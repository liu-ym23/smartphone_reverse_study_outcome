package com.obric.sva.sdk.session.legacy;

import android.content.Context;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$ModulePropertiesWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$StatusListenerWrapper;
import com.obric.sva.sdk.config.Stage1Config;
import com.obric.sva.sdk.controller.ExtendedSmMgr;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.IKeyphraseModel;
import com.obric.sva.sdk.data.IUserModel;
import com.obric.sva.sdk.data.SettingsModel;
import com.obric.sva.sdk.session.IWakeupSession;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import rna.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class LegacyWakeupSession implements IWakeupSession {
    protected String TAG;
    private final Object mAttachLock;
    protected Context mContext;
    protected ExtendedSmMgr mExtendedSmMgr;
    protected boolean mIsSupportConcurrency;
    protected String mKeyphraseFromXml;
    protected String mLastStage1UserConfig;
    protected byte[] mOpaqueDataFromXml;
    protected SoundTriggerModuleWrapper mSTModule;
    protected UUID mVendorUuid;
    protected UUID mVendorUuidFromHal;
    protected List<IWakeupListener> mWakeupListeners;
    protected SoundTriggerWrapper$StatusListenerWrapper statusListenerWrapper;

    public static /* synthetic */ void a(LegacyWakeupSession r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void b(LegacyWakeupSession r0, SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r1) {
        r0.lambda$startRecognition$1(r1);
    }

    public abstract int getModelIndex();

    public abstract String getModelUuid();

    private boolean attachModule() {
        Object r3 = this.mAttachLock;
        monitor-enter(r3);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.mSTModule == null) goto L9;
        LogUtils.d(this.TAG, "attachModule: already attached", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return true;
    L9:
        String r4 = Build.MODEL;     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: build model name = " + r4, new Object[0]);     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule start ### with packageName:" + this.mContext.getPackageName(), new Object[0]);     // Catch: Throwable -> L40
        ArrayList<SoundTriggerWrapper$ModulePropertiesWrapper> r1 = new ArrayList();     // Catch: Throwable -> L40
        IdentityWrapper r2 = new IdentityWrapper();     // Catch: Throwable -> L40
        r2.setPackageName(this.mContext.getPackageName());     // Catch: Throwable -> L40
        ISvaFrameworkKt.getSvaFrameworkDelegate().listModulesAsOriginator(r1, r2);     // Catch: Throwable -> L40
        if (r1.isEmpty() == false) goto L14;
        LogUtils.e(this.TAG, "attachModule: no available modules", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return false;
    L14:
        LogUtils.d(this.TAG, "attachModule all module properties size is :  " + r1.size(), new Object[0]);     // Catch: Throwable -> L40
        Iterator<SoundTriggerWrapper$ModulePropertiesWrapper> r0 = r1.iterator();     // Catch: Throwable -> L40
    L16:
        if (r0.hasNext() == false) goto L19;
        SoundTriggerWrapper$ModulePropertiesWrapper r5 = r0.next();     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: each moduleProperty = " + r5 + "\n", new Object[0]);     // Catch: Throwable -> L40
        goto L16
    L19:
        if (getModelIndex() < r1.size()) goto L23;
        LogUtils.e(this.TAG, "attachModule: out of bound of model size " + r1.size(), new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return false;
    L23:
        SoundTriggerWrapper$ModulePropertiesWrapper r6 = r1.get(getModelIndex());     // Catch: Throwable -> L40
        String r7 = getModelUuid();     // Catch: Throwable -> L40
        if (r7 != null) goto L43;
        LogUtils.e(this.TAG, "attachModule: modelUuid is null", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return false;
    L43:
        this.mVendorUuidFromHal = UUID.fromString(r7);     // Catch: IllegalArgumentException -> L37 Throwable -> L40
        this.mIsSupportConcurrency = r6.isConcurrentCaptureSupported();     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: moduleProperties:" + r6 + ", mIsSupportConcurrency = " + this.mIsSupportConcurrency, new Object[0]);     // Catch: Throwable -> L40
        SoundTriggerModuleWrapper r8 = ISvaFrameworkKt.getSvaFrameworkDelegate().attachModuleAsOriginator(r6.getId(), this.statusListenerWrapper, null, r2);     // Catch: Throwable -> L40
        this.mSTModule = r8;     // Catch: Throwable -> L40
        if (r8 != null) goto L34;
        LogUtils.e(this.TAG, "attachModule: low layer error", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return false;
    L34:
        LogUtils.e(this.TAG, "attachModule attached: successful", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return true;
    L37:
        LogUtils.e(this.TAG, "attachModule: invalid UUID format: " + maskTailForLog(r7), new Object[0]);     // Catch: Throwable -> L40
        return false;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public boolean isSupportConcurrency() {
        if (this.mSTModule != null) goto L8;
        if (attachModule() == true) goto L8;
        this.mIsSupportConcurrency = false;
    L8:
        return this.mIsSupportConcurrency;
    }

    public void onResourcesAvailableWrapper() {
        LogUtils.d(this.TAG, "onResourcesAvailable", new Object[0]);
        Iterator<IWakeupListener> r0 = this.mWakeupListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onResourcesAvailable(getSessionType());
        goto L4
    }

    public void onServiceDiedWrapper() {
        LogUtils.d(this.TAG, "onServiceDied: ST Service died", new Object[0]);
        Iterator<IWakeupListener> r0 = this.mWakeupListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onServiceDied(getSessionType());
        goto L4
    L6:
        releaseAllSvaSessions();
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void releaseAllSvaSessions() {
        LogUtils.d(this.TAG, "@@ releaseAllSvaSessions @@", new Object[0]);
        Iterator<IExtendedSmModel> r0 = this.mExtendedSmMgr.getAllSoundModelList().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        IExtendedSmModel r2 = r0.next();
        String r3 = r2.getSoundModelFullFileName();
        LogUtils.d(this.TAG, "releaseAllSvaSessions: smName = " + r3, new Object[0]);
        int r4 = 2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r2.getSessionStatus().ordinal()];
        if (r4 != 1) goto L8;
        LogUtils.d(this.TAG, "releaseAllSvaSessions: unloaded status, do nothing", new Object[0]);
    L18:
        r2.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        goto L4
    L8:
        if (r4 != 2) goto L10;
        int r5 = terminateSvaSession(r3);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: started status returnCode = " + r5, new Object[0]);
        goto L18
    L10:
        if (r4 != 3) goto L12;
        int r6 = unloadSM(r3);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: loaded status returnCode = " + r6, new Object[0]);
        goto L18
    L12:
        if (r4 == 4) goto L14;
        LogUtils.d(this.TAG, "releaseAllSvaSessions: invalid status value", new Object[0]);
        goto L18
    L14:
        int r7 = unloadSM(r3);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: stopped status returnCode = " + r7, new Object[0]);
        goto L18
    L19:
        LogUtils.d(this.TAG, "releaseAllSvaSessions: detachModule is called", new Object[0]);
        detachModule(null);
    }

    private /* synthetic */ void lambda$new$0() {
        if (attachModule() == true) goto L6;
        LogUtils.e(this.TAG, "LegacyWakeupSession: attachModule failed", new Object[0]);
        return;
    }

    public LegacyWakeupSession(Context r3) {
        this.TAG = "LegacyWakeupSession[" + getSessionType() + "]";
        this.mAttachLock = new Object();
        this.mSTModule = null;
        this.mWakeupListeners = new CopyOnWriteArrayList();
        this.mVendorUuid = null;
        this.mVendorUuidFromHal = null;
        this.mKeyphraseFromXml = null;
        this.mOpaqueDataFromXml = null;
        this.mIsSupportConcurrency = false;
        this.mLastStage1UserConfig = "";
        this.mContext = r3;
        this.statusListenerWrapper = new AnonymousClass1(this);
        this.mExtendedSmMgr = Global.getInstance().getExtendedSmMgr();
        ThreadMethodProxy.start(new PthreadThreadV2(new b(this), "LegacyWakeupSession"));
    }

    private SoundTriggerWrapper.KeyphraseSoundModelWrapper createSTKeyphraseSoundModel(String r22) {
        if (r22 != null) goto L6;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: invalid input param", new Object[0]);
        return null;
    L6:
        SettingsModel r0 = new SettingsModel(this.mContext, r22);
        int r5 = 3;
        ByteBuffer r12 = c.e(this.mExtendedSmMgr.getSoundModelFullPath(r22));     // Catch: IOException -> L65
        IExtendedSmModel r13 = this.mExtendedSmMgr.getSoundModel(r22);
        if (r13 != null) goto L13;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: read getSoundModel data fail", new Object[0]);
        return null;
    L13:
        if (Global.getInstance().getIsToggleXmlParam() == false) goto L19;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: A", new Object[0]);
        createStkSmInfoFromXml(r22);
        if (this.mKeyphraseFromXml != null) goto L18;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: mKeyphraseFromXml is null", new Object[0]);
        return null;
    L18:
        SoundTriggerWrapper.KeyphraseWrapper[] r6 = {new SoundTriggerWrapper.KeyphraseWrapper(0, 3, Locale.forLanguageTag("en_US"), this.mKeyphraseFromXml, new int[0])};
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r1 = {new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper(0, 1, 69, new SoundTriggerWrapper.ConfidenceLevelWrapper[0])};
    L56:
        r13.setKeyphraseRecognitionExtra(r1);
        r12.rewind();
        byte[] r2 = new byte[r12.remaining()];
        r12.get(r2);
        String r3 = getModelUuid();
        if (r3 != null) goto L68;
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: modelUuid is null", new Object[0]);
        return null;
    L68:
        this.mVendorUuid = UUID.fromString(r3);     // Catch: IllegalArgumentException -> L63
        return new SoundTriggerWrapper.KeyphraseSoundModelWrapper(r13.getSoundModelUUID(), this.mVendorUuid, r2, r6);
    L63:
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: invalid UUID format: " + maskTailForLog(r3), new Object[0]);
        return null;
    L19:
        this.mVendorUuid = this.mVendorUuidFromHal;
        int r4 = r13.getSoundModelKeyphraseList().size();
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: B size =" + r4, new Object[0]);
        SoundTriggerWrapper.KeyphraseWrapper[] r15 = new SoundTriggerWrapper.KeyphraseWrapper[r4];
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r11 = new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[r4];
        int r10 = 0;
    L20:
        if (r10 >= r4) goto L55;
        IKeyphraseModel r16 = (IKeyphraseModel) ListProtector.get(r13.getSoundModelKeyphraseList(), r10);
        int r9 = r16.getUserList().size();
        int[] r8 = new int[r9];
        Iterator<IUserModel> r7 = r16.getUserList().iterator();
        int r14 = 0;
    L23:
        if (r7.hasNext() == false) goto L25;
        r8[r14] = r7.next().getUserId();
        r14 = r14 + 1;
        goto L23
    L25:
        int r18 = r10;
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r19 = r11;
        SoundTriggerWrapper.KeyphraseWrapper r17 = new SoundTriggerWrapper.KeyphraseWrapper(r16.getKeyphraseId(), r5, Locale.forLanguageTag("en_US"), r16.getKeyphraseFullName(), r8);
        r15[r18] = r17;
        SoundTriggerWrapper.ConfidenceLevelWrapper[] r20 = new SoundTriggerWrapper.ConfidenceLevelWrapper[r9];
        boolean r21 = r0.getOpaqueDataTransferEnabled();
        int r23 = 0;
    L26:
        int r24 = 100;
        if (r23 >= r9) goto L42;
        if (r13.isSupportExtendedOpaqueData() == false) goto L36;
        int r110 = r0.get2ndUserConfidenceLevel();
        if (r21 == false) goto L37;
        if (r110 >= 0) goto L34;
        r110 = 0;
        goto L37
    L34:
        if (r110 <= 100) goto L37;
        r110 = 100;
    L37:
        if (r110 < 0) goto L40;
        r24 = r110;
    L40:
        SoundTriggerWrapper.ConfidenceLevelWrapper r111 = new SoundTriggerWrapper.ConfidenceLevelWrapper(r17.getUsers()[r23], r24);
        r20[r23] = r111;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: level  " + r111, new Object[0]);
        r23 = r23 + 1;
        goto L26
    L36:
        r110 = r0.get1stUserConfidenceLevel();
        goto L37
    L42:
        if (r13.isSupportExtendedOpaqueData() == false) goto L49;
        int r25 = r0.get2ndKeyphraseConfidenceLevel();
        if (r21 == false) goto L50;
        if (r25 >= 0) goto L47;
        r25 = 0;
        goto L50
    L47:
        if (r25 <= 100) goto L50;
        r25 = 100;
    L50:
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: keyphraseConfidenceLevel  " + r25, new Object[0]);
        if (r25 < 0) goto L54;
        r24 = r25;
    L54:
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r26 = new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper(r16.getKeyphraseId(), 3, r24, r20);
        LogUtils.d(this.TAG, "==== recognition extra " + r26, new Object[0]);
        r19[r18] = r26;
        r10 = r18 + 1;
        r11 = r19;
        r5 = 3;
        goto L20
    L49:
        r25 = r0.get1stKeyphraseConfidenceLevel();
        goto L50
    L55:
        r6 = r15;
        r1 = r11;
    L65:
        e = move-exception;
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: read sound model failed, smName=" + r22 + ", err=" + e, new Object[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v50 */
    private void createStkSmInfoFromXml(String r9) {
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: enter", new Object[0]);
        String r0 = Global.getInstance().PATH_ROOT + "/" + r9 + ".xml";
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: smName= " + r9 + ", xmlFilePath= " + r0, new Object[0]);
        ?? r3 = 0;
        FileInputStream r4 = null;
        FileInputStream r5 = null;
        FileInputStream r6 = null;
        FileInputStream r7 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r0));     // Catch: Throwable -> L50 IOException -> L52 XmlPullParserException -> L57 FileNotFoundException -> L61
    L82:
        XmlPullParser r1 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r1.setInput(r7, null);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        int r8 = r1.getEventType();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L6:
        if (r8 == 1) goto L37;
        if (r8 != 0) goto L9;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: start_document parser.getName() = " + r1.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L36:
        int r10 = r1.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: parser.next() = " + r1.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r8 = r10;
        goto L6
    L9:
        if (r8 != 2) goto L11;
        String r11 = r1.getName();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: start_tag = " + r11, new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        if (r11.equals("KeyphraseSoundModel") == true) goto L36;
        if (r11.equals("Uuid") == false) goto L21;
        r1.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Uuid = " + maskTailForLog(r1.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L21:
        if (r11.equals("VendorUuid") == false) goto L27;
        r1.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: VendorUuid = " + maskTailForLog(r1.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mVendorUuid = UUID.fromString(r1.getText());     // Catch: IllegalArgumentException -> L25 Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L25:
        LogUtils.e(this.TAG, "createStkSmInfoFromXml: invalid VendorUuid format: " + maskTailForLog(r1.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L27:
        if (r11.equals("Data") == false) goto L32;
        r1.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Data= " + r1.getText(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        if (r1.getText().equals("true") == false) goto L36;
        String r12 = Global.getInstance().PATH_ROOT + "/" + r9 + Global.SUFFIX_DATA_FILE;     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: opaqueData  filepath = " + r12, new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mOpaqueDataFromXml = c.d(r12);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L32:
        if (r11.equals("Text") == false) goto L34;
        r1.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Text = " + r1.getText(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mKeyphraseFromXml = r1.getText();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L34:
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: startTag = " + r11 + " not recognized.", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L11:
        if (r8 != 3) goto L36;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: end_tag = " + r1.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L37:
        if (r8 != 1) goto L39;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: END_DOCUMENT", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: END_DOCUMENT parser.getName()= " + r1.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        ?? r13 = "createStkSmInfoFromXml: END_DOCUMENT parser.getName()= ";
    L40:
        r7.close();     // Catch: IOException -> L69
        r3 = r13;
    L71:
        return;
    L39:
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Could not reach end of document.", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r13 = r8;
    L48:
        e = e;
        r4 = r7;
    L62:
        e.printStackTrace();     // Catch: Throwable -> L50
        r3 = r4;
        FileInputStream r14 = r4;
        if (r4 == null) goto L71;
    L55:
        r14.close();     // Catch: IOException -> L69
        r3 = r14;
    L44:
        e = e;
        r5 = r7;
    L53:
        e.printStackTrace();     // Catch: Throwable -> L50
        r3 = r5;
        r14 = r5;
        if (r5 == null) goto L71;
    L46:
        e = e;
        r6 = r7;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L50
        r3 = r6;
        if (r6 == null) goto L71;
        r14 = r6;
    L42:
        th = th;
        r3 = r7;
    L66:
        if (r3 != 0) goto L76;
    L68:
        throw th;
    L76:
        r3.close();     // Catch: IOException -> L70
    L50:
        th = th;
    L61:
        e = e;
    L52:
        e = e;
    L57:
        e = e;
    }

    private void detachModule(String r6) {
        LogUtils.d(this.TAG, "detachModule: enter :" + r6, new Object[0]);
        Object r0 = this.mAttachLock;
        monitor-enter(r0);
        SoundTriggerModuleWrapper r1 = this.mSTModule;     // Catch: Throwable -> L17
        this.mSTModule = null;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L12;
        LogUtils.d(this.TAG, "detachModule: mSTModule.detach() is called", new Object[0]);
        r1.detach();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        LogUtils.d(this.TAG, "detachModule: detach failed, possibly due to audio server death: " + e.getMessage(), new Object[0]);
    L12:
        if (r6 != null) goto L14;
        this.mExtendedSmMgr.resetAllSessionStatus();
    L15:
        LogUtils.d(this.TAG, "detachModule: exit " + r6, new Object[0]);
        return;
    L14:
        this.mExtendedSmMgr.resetSessionStatus(r6);
    L17:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startRecognition$1(SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r4) {
        LogUtils.d(this.TAG, "startRecognition: item = " + r4, new Object[0]);
    }

    private String maskTailForLog(String r4) {
        if (r4 != null) goto L4;
        return "";
    L4:
        if (r4.isEmpty() == false) goto L7;
        return "";
    L7:
        return "****" + r4.substring(Math.max(0, r4.length() - 4));
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void addWakeupListener(IWakeupListener r5) {
        if (this.mWakeupListeners.contains(r5) == false) goto L5;
        LogUtils.d(this.TAG, "addWakeupListener: listener already exists", new Object[0]);
        return;
    L5:
        LogUtils.d(this.TAG, "addWakeupListener: add listener " + r5, new Object[0]);
        this.mWakeupListeners.add(r5);
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int establishSvaSession(String r6) {
        LogUtils.d(this.TAG, "establishSvaSession: smName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "establishSvaSession: invalid input param", new Object[0]);
        return -1000;
    L6:
        int r0 = loadSM(r6);
        if (r0 == 0) goto L10;
        LogUtils.d(this.TAG, "establishSvaSession: loadSM returnCode = " + r0, new Object[0]);
        return r0;
    L10:
        int r1 = startRecognition(r6);
        if (r1 == 0) goto L13;
        LogUtils.d(this.TAG, "establishSvaSession: startRecognition returnCode = " + r1, new Object[0]);
        unloadSM(r6);
    L13:
        return r1;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public boolean isRecognitionActive(String r4) {
        LogUtils.d(this.TAG, "isRecognitionActive: not support for legacy STModule API", new Object[0]);
        return false;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int loadSM(String r9) {
        String r0 = Build.MODEL;
        LogUtils.d(this.TAG, "loadSM: build model name = " + r0, new Object[0]);
        LogUtils.d(this.TAG, "loadSM: ## smName = " + r9, new Object[0]);
        if (r9 != null) goto L6;
        LogUtils.d(this.TAG, "loadSM: invalid input param", new Object[0]);
        return -1000;
    L6:
        String r1 = this.mExtendedSmMgr.getSoundModelFullPath(r9);
        IExtendedSmModel r2 = this.mExtendedSmMgr.getSoundModel(r9);
        if (r2 != null) goto L9;
    L37:
        LogUtils.d(this.TAG, "loadSM: sm file not exist", new Object[0]);
        return IWakeupSessionConstant.RC_FILE_NOT_EXIST;
    L9:
        if (c.c(r1) == false) goto L37;
        if (this.mSTModule != null) goto L17;
        LogUtils.d(this.TAG, "loadSM: mSTModule is null, need retry attachModule", new Object[0]);
        if (attachModule() == true) goto L17;
        LogUtils.e(this.TAG, "loadSM: retry attachModule fail", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L17:
        IExtendedSmModel.SessionStatus r3 = IExtendedSmModel.SessionStatus.LOADED;
        if (r3 != r2.getSessionStatus()) goto L20;
    L35:
        LogUtils.d(this.TAG, "loadSM: already loaded, return success", new Object[0]);
        return 0;
    L20:
        if (IExtendedSmModel.SessionStatus.STOPPED == r2.getSessionStatus()) goto L35;
        SoundTriggerWrapper.KeyphraseSoundModelWrapper r10 = createSTKeyphraseSoundModel(r9);
        if (r10 != null) goto L26;
        LogUtils.d(this.TAG, "loadSM: create KeyphraseSoundModel fail", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L26:
        int[] r4 = new int[20];
        SoundTriggerModuleWrapper r5 = this.mSTModule;
        if (r5 != null) goto L30;
        LogUtils.d(this.TAG, "loadSM: mSTModule is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L30:
        LogUtils.d(this.TAG, "loadSM: start to loadSoundModel with " + r10, new Object[0]);
        int r11 = r5.loadSoundModel(r10, r4);
        if (r11 != 0) goto L33;
        LogUtils.d(this.TAG, "loadSM: STM loadSoundModel success", new Object[0]);
        r2.setSessionStatus(r3);
        r2.setSoundModelHandle(r4[0]);
    L34:
        return r11;
    L33:
        LogUtils.d(this.TAG, "loadSM: STM loadSoundModel failed !", new Object[0]);
        goto L34
    }

    public void onModelUnloadedWrapper(int r4) {
        LogUtils.d(this.TAG, "onModelUnloaded is recalled, do nothing. handle = " + r4, new Object[0]);
    }

    public void onRecognitionWrapper(SoundTriggerWrapper.RecognitionEventWrapper r4) {
        LogUtils.d(this.TAG, "onRecognition: recognitionEvent = " + r4, new Object[0]);
        Iterator<IWakeupListener> r0 = this.mWakeupListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onRecognition(getSessionType(), r4);
        goto L4
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void releaseSvaSession(String r7) {
        LogUtils.d(this.TAG, "@@ releaseSvaSession @@ :" + r7, new Object[0]);
        Iterator<IExtendedSmModel> r0 = this.mExtendedSmMgr.getAllSoundModelList().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IExtendedSmModel r1 = r0.next();
        if (r1.getSoundModelFullFileName().equalsIgnoreCase(r7) == false) goto L4;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        LogUtils.d(this.TAG, "releaseSvaSession: smName = " + r7, new Object[0]);
        int r2 = 2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r1.getSessionStatus().ordinal()];
        if (r2 != 1) goto L14;
        LogUtils.d(this.TAG, "releaseSvaSession: unloaded status, do nothing", new Object[0]);
    L24:
        r1.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        LogUtils.d(this.TAG, "releaseSvaSession: detachModule is called", new Object[0]);
        detachModule(r7);
        return;
    L14:
        if (r2 != 2) goto L16;
        int r3 = terminateSvaSession(r7);
        LogUtils.d(this.TAG, "releaseSvaSession: started status returnCode = " + r3, new Object[0]);
        goto L24
    L16:
        if (r2 != 3) goto L18;
        int r4 = unloadSM(r7);
        LogUtils.d(this.TAG, "releaseSvaSession: loaded status returnCode = " + r4, new Object[0]);
        goto L24
    L18:
        if (r2 == 4) goto L20;
        LogUtils.d(this.TAG, "releaseSvaSession: invalid status value", new Object[0]);
        goto L24
    L20:
        int r5 = unloadSM(r7);
        LogUtils.d(this.TAG, "releaseSvaSession: stopped status returnCode = " + r5, new Object[0]);
        goto L24
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void removeWakeupListener(IWakeupListener r5) {
        if (this.mWakeupListeners.contains(r5) == false) goto L5;
        LogUtils.d(this.TAG, "removeWakeupListener: remove listener " + r5, new Object[0]);
        this.mWakeupListeners.remove(r5);
        return;
    L5:
        LogUtils.d(this.TAG, "removeWakeupListener: listener not exist, do nothing", new Object[0]);
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int restartRecognition(String r8) {
        LogUtils.d(this.TAG, "restartRecognition: smName = " + r8, new Object[0]);
        if (r8 != null) goto L6;
        LogUtils.d(this.TAG, "restartRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r0 = this.mExtendedSmMgr.getSoundModel(r8);
        if (r0 != null) goto L10;
        LogUtils.d(this.TAG, "restartRecognition: extendedSmModel is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L10:
        IExtendedSmModel.SessionStatus r3 = IExtendedSmModel.SessionStatus.STARTED;
        if (r3 == r0.getSessionStatus()) goto L14;
        LogUtils.d(this.TAG, "restartRecognition: failure for wrong status", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L14:
        SoundTriggerModuleWrapper r4 = this.mSTModule;
        if (r4 != null) goto L19;
        LogUtils.d(this.TAG, "restartRecognition: failure for mSTModule is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L19:
        if (getSessionType() != SessionType.VOICE) goto L24;
        String r1 = rna.b.h(this.mContext);
        if (r1.hashCode() == this.mLastStage1UserConfig.hashCode()) goto L24;
        LogUtils.d(this.TAG, "restartRecognition: config has changed , so stop then start", new Object[0]);
        this.mLastStage1UserConfig = r1;
        stopRecognition(r8);
        int r9 = startRecognition(r8);
        LogUtils.d(this.TAG, "restartRecognition: config has changed , start with code :" + r9, new Object[0]);
        return r9;
    L24:
        int r10 = r4.startRecognition(r0.getSoundModelHandle(), r0.getRecognitionConfig());
        if (r10 != 0) goto L27;
        LogUtils.d(this.TAG, "restartRecognition: STM restartRecognition success", new Object[0]);
        r0.setSessionStatus(r3);
    L27:
        return r10;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int startRecognition(String r25) {
        LogUtils.d(this.TAG, "startRecognition: smName = " + r25, new Object[0]);
        if (r25 != null) goto L6;
        LogUtils.d(this.TAG, "startRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        ExtendedSmMgr r1 = this.mExtendedSmMgr;
        if (r1 != null) goto L10;
        LogUtils.d(this.TAG, "startRecognition: invalid extended Sm Mgr", new Object[0]);
        return IWakeupSessionConstant.RC_INVALID_SM_MANAGER;
    L10:
        IExtendedSmModel r8 = r1.getSoundModel(r25);
        if (r8 != null) goto L14;
        LogUtils.d(this.TAG, "startRecognition: extendedSmModel is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L14:
        IExtendedSmModel.SessionStatus r10 = IExtendedSmModel.SessionStatus.STARTED;
        if (r10 != r8.getSessionStatus()) goto L19;
        LogUtils.d(this.TAG, "startRecognition: already started, return success directly", new Object[0]);
        return 0;
    L19:
        if (isStateTransitional(r8.getSessionStatus(), r10) == true) goto L22;
        LogUtils.d(this.TAG, "startRecognition: failure for wrong status", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L22:
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r11 = r8.getKeyphraseRecognitionExtra();
        if (r11 != null) goto L27;
        LogUtils.d(this.TAG, "startRecognition: failure for stKpRecognitionExtraArray", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L27:
        if (Build.VERSION.SDK_INT < 24) goto L29;
        Arrays.stream(r11).forEach(new a(this));
    L29:
        SettingsModel r12 = new SettingsModel(this.mContext, r25);
        boolean r13 = r12.getVoiceRequestEnabled();
        boolean r3 = r12.getOpaqueDataTransferEnabled();
        int r15 = r12.getHistBufferTime();
        int r14 = r12.getPreRollDuration();
        if (r3 == true) goto L32;
        byte[] r2 = null;
    L47:
        SoundTriggerWrapper.RecognitionConfigWrapper r4 = new SoundTriggerWrapper.RecognitionConfigWrapper(r13, true, r11, r2);
        r8.setRecognitionConfig(r4);
        LogUtils.d(this.TAG, "startRecognition: STM startRecognition now !! with mSTModule : " + this.mSTModule, new Object[0]);
        SoundTriggerModuleWrapper r5 = this.mSTModule;
        if (r5 != null) goto L51;
        LogUtils.d(this.TAG, "startRecognition: failure for mStModule is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L51:
        int r6 = r5.startRecognition(r8.getSoundModelHandle(), r4);
        if (r6 != 0) goto L54;
        LogUtils.d(this.TAG, "startRecognition: STM startRecognition success", new Object[0]);
        r8.setSessionStatus(r10);
    L54:
        return r6;
    L32:
        if (r8.isSupportExtendedOpaqueData() == false) goto L42;
        SessionType r7 = getSessionType();
        SessionType r9 = SessionType.VOICE;
        if (r7 != r9) goto L36;
        boolean r16 = true;
    L37:
        OpaqueDataHelper r17 = new OpaqueDataHelper(r25, r3, false, false, r16);
        int r18 = r12.get2ndKeyphraseConfidenceLevel();
        int r19 = r12.get2ndUserConfidenceLevel();
        int r20 = r12.get1stKeyphraseConfidenceLevel();
        int r110 = r12.get1stUserConfidenceLevel();
        Stage1Config r21 = new Stage1Config();
        if (getSessionType() != r9) goto L40;
        this.mLastStage1UserConfig = r21.acquireUserConfig(this.mContext);
        OpaqueDataHelper r22 = r17;
        r22.mNumberOfStage1Config = Math.max(r21.size(), 0);
        LogUtils.d(this.TAG, "startRecognition A: stage1Config " + r21 + " stage1Size: " + r22.mNumberOfStage1Config, new Object[0]);
    L41:
        r2 = r22.fillOpaqueDataByteBuffer(r20, r110, r18, r19, r15, r14, 0, 0, r21);
    L44:
        if (Global.getInstance().getIsToggleXmlParam() == false) goto L47;
        r2 = this.mOpaqueDataFromXml;
        goto L47
    L40:
        r22 = r17;
        r22.mNumberOfStage1Config = 0;
        LogUtils.d(this.TAG, "startRecognition B: 0 Stage1Config", new Object[0]);
        goto L41
    L36:
        r16 = false;
        goto L37
    L42:
        r2 = new OpaqueDataHelper(r25, false, false, false, false).fillOpaqueDataByteBuffer(r15, r14);
        goto L44
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int stopRecognition(String r6) {
        LogUtils.d(this.TAG, "stopRecognition: smName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "stopRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r7 = this.mExtendedSmMgr.getSoundModel(r6);
        if (r7 != null) goto L10;
        LogUtils.d(this.TAG, "stopRecognition: extendedSmModel is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L10:
        IExtendedSmModel.SessionStatus r1 = IExtendedSmModel.SessionStatus.STOPPED;
        if (r1 != r7.getSessionStatus()) goto L13;
    L27:
        LogUtils.d(this.TAG, "stopRecognition: already stopped, return success directly", new Object[0]);
        return 0;
    L13:
        if (IExtendedSmModel.SessionStatus.LOADED == r7.getSessionStatus()) goto L27;
        if (isStateTransitional(r7.getSessionStatus(), r1) == true) goto L19;
        LogUtils.d(this.TAG, "stopRecognition: failure for wrong status", new Object[0]);
        return IWakeupSessionConstant.RC_WRONG_STATUS;
    L19:
        SoundTriggerModuleWrapper r3 = this.mSTModule;
        if (r3 != null) goto L23;
        LogUtils.d(this.TAG, "stopRecognition: mSTModule is null !", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L23:
        int r0 = r3.stopRecognition(r7.getSoundModelHandle());
        if (r0 != 0) goto L26;
        LogUtils.d(this.TAG, "stopRecognition: STM stopRecognition success", new Object[0]);
        r7.setSessionStatus(r1);
    L26:
        return r0;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int terminateSvaSession(String r6) {
        LogUtils.d(this.TAG, "terminateSvaSession: smName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "terminateSvaSession: invalid input param", new Object[0]);
        return -1000;
    L6:
        int r0 = stopRecognition(r6);
        IExtendedSmModel r1 = this.mExtendedSmMgr.getSoundModel(r6);
        if (r1 == null) goto L9;
        r1.setSessionStatus(IExtendedSmModel.SessionStatus.STOPPED);
    L9:
        if (r0 == 0) goto L11;
        LogUtils.d(this.TAG, "terminateSvaSession: stopRecognition returnCode = " + r0, new Object[0]);
    L11:
        int r7 = unloadSM(r6);
        if (r7 == 0) goto L14;
        LogUtils.d(this.TAG, "terminateSvaSession: unloadSM returnCode = " + r7, new Object[0]);
    L14:
        return r7;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int unloadSM(String r6) {
        LogUtils.d(this.TAG, "unloadSM: smName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "unloadSM: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r7 = this.mExtendedSmMgr.getSoundModel(r6);
        if (r7 != null) goto L10;
        LogUtils.d(this.TAG, "unloadSM: extendedSmModel is null", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L10:
        IExtendedSmModel.SessionStatus r1 = IExtendedSmModel.SessionStatus.UNLOADED;
        if (r1 != r7.getSessionStatus()) goto L15;
        LogUtils.d(this.TAG, "unloadSM: already unloaded, return success directly", new Object[0]);
        return 0;
    L15:
        if (isStateTransitional(r7.getSessionStatus(), r1) == true) goto L18;
        LogUtils.d(this.TAG, "unloadSM: failure for wrong status", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L18:
        SoundTriggerModuleWrapper r3 = this.mSTModule;
        if (r3 != null) goto L22;
        LogUtils.d(this.TAG, "unloadSM: failure for null=mSTModule", new Object[0]);
        return IWakeupSessionConstant.RC_FAILURE;
    L22:
        int r0 = r3.unloadSoundModel(r7.getSoundModelHandle());
        if (r0 != 0) goto L25;
        LogUtils.d(this.TAG, "unloadSM: STM unloadSoundModel success", new Object[0]);
        r7.setSessionStatus(r1);
    L25:
        return r0;
    }

    private boolean isStateTransitional(IExtendedSmModel.SessionStatus r5, IExtendedSmModel.SessionStatus r6) {
        int r0 = 2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r6.ordinal()];
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L12;
        LogUtils.e("isStateTransitional: unrecognized state" + r6, new Object[0]);
    L22:
        return false;
    L12:
        if (IExtendedSmModel.SessionStatus.STARTED != r5) goto L22;
        return true;
    L15:
        if (IExtendedSmModel.SessionStatus.UNLOADED != r5) goto L22;
        return true;
    L18:
        if (IExtendedSmModel.SessionStatus.LOADED != r5) goto L20;
    L23:
        return true;
    L20:
        if (IExtendedSmModel.SessionStatus.STOPPED != r5) goto L22;
        goto L22
    }
}
