package com.obric.sva.sdk.controller;

import android.content.Context;
import android.content.Intent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.data.ExtendedSmModel;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.IKeyphraseModel;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.data.SettingsDAO;
import com.obric.sva.sdk.data.SettingsModel;
import com.obric.sva.sdk.listen.ObricListenTypes$KeywordInfo;
import com.obric.sva.sdk.listen.ObricListenTypes$SVASoundModelInfo;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rna.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ExtendedSmMgr {
    private static final int SVA_APP_KEYPHRASE_ID_BASE = 500;
    private static volatile ArrayList<String> mUIMKeyphraseList;
    private final String TAG;
    private int mKeyphraseIdCounter;
    private volatile List<IExtendedSmModel> mSoundModelList;

    public static /* synthetic */ boolean a(File r0) {
        return lambda$initSoundModels$1(r0);
    }

    public static /* synthetic */ boolean b(File r0, String r1) {
        return lambda$initSoundModels$0(r0, r1);
    }

    public static /* synthetic */ int c(File r0, File r1) {
        return lambda$initSoundModels$3(r0, r1);
    }

    public static /* synthetic */ File[] d(int r0) {
        return lambda$initSoundModels$2(r0);
    }

    static {
        mUIMKeyphraseList = new ArrayList();
    }

    public ArrayList<IExtendedSmModel> getAllLoadedSoundModelList() {
        ArrayList<IExtendedSmModel> r0 = new ArrayList();
        Iterator<IExtendedSmModel> r1 = this.mSoundModelList.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        IExtendedSmModel r2 = r1.next();
        if (IExtendedSmModel.SessionStatus.STARTED == r2.getSessionStatus()) goto L9;
        if (IExtendedSmModel.SessionStatus.LOADED != r2.getSessionStatus()) goto L4;
    L9:
        r0.add(r2);
        goto L4
    L10:
        return r0;
    }

    public ArrayList<IExtendedSmModel> getCanDeleteSoundModelList() {
        ArrayList<IExtendedSmModel> r0 = new ArrayList();
        Iterator<IExtendedSmModel> r1 = this.mSoundModelList.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        IExtendedSmModel r2 = r1.next();
        if (r2.isUserTrainedSoundModel() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public ArrayList<IExtendedSmModel> getCanMergeSoundModelList() {
        ArrayList<IExtendedSmModel> r0 = new ArrayList();
        Iterator<IExtendedSmModel> r1 = this.mSoundModelList.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        IExtendedSmModel r2 = r1.next();
        if (r2.getSoundModelVersion() != ISmModel.ModelVersion.VERSION_2_0) goto L4;
        if (r2.isUdkSm() == true) goto L4;
        r0.add(r2);
        goto L4
    L10:
        return r0;
    }

    public ArrayList<IExtendedSmModel> getSingleKeyphraseSoundModelList() {
        ArrayList<IExtendedSmModel> r0 = new ArrayList();
        Iterator<IExtendedSmModel> r1 = this.mSoundModelList.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        IExtendedSmModel r2 = r1.next();
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public ArrayList<IExtendedSmModel> getTrainableSoundModelList() {
        ArrayList<IExtendedSmModel> r0 = new ArrayList();
        Iterator<IExtendedSmModel> r1 = this.mSoundModelList.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        IExtendedSmModel r2 = r1.next();
        if (ISmModel.SUFFIX_DEFAULT_SOUND_MODEL.equalsIgnoreCase(r2.getSoundModelSuffix()) == false) goto L4;
        if (r2.getSoundModelKeyphraseList().size() != 1) goto L4;
        r0.add(r2);
        goto L4
    L10:
        return r0;
    }

    public boolean hasActiveSessions() {
        Iterator<IExtendedSmModel> r0 = this.mSoundModelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IExtendedSmModel r1 = r0.next();
        if (IExtendedSmModel.SessionStatus.STARTED != r1.getSessionStatus()) goto L4;
        return true;
    L8:
        return false;
    }

    public boolean hasLoadedOrActiveSessions() {
        Iterator<IExtendedSmModel> r0 = this.mSoundModelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IExtendedSmModel r1 = r0.next();
        if (IExtendedSmModel.SessionStatus.UNLOADED == r1.getSessionStatus()) goto L4;
        return true;
    L8:
        return false;
    }

    public void resetAllSessionStatus() {
        LogUtils.d(this.TAG, "resetAllSessionStatus: enter", new Object[0]);
        Iterator<IExtendedSmModel> r0 = this.mSoundModelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        goto L4
    }

    public ExtendedSmMgr() {
        this.TAG = "ExtendedSmMgr";
        this.mSoundModelList = Collections.synchronizedList(new ArrayList());
        this.mKeyphraseIdCounter = 0;
    }

    public static ArrayList<String> getPDKkeyphraseList() {
        return mUIMKeyphraseList;
    }

    public List<IExtendedSmModel> getAllSoundModelList() {
        return this.mSoundModelList;
    }

    public ArrayList<String> getUIMKeyphraseList() {
        return mUIMKeyphraseList;
    }

    private ISmModel.ModelVersion convertVersion(int r5) {
        if (r5 != 256) goto L5;
        ISmModel.ModelVersion r0 = ISmModel.ModelVersion.VERSION_1_0;
    L24:
        LogUtils.d(this.TAG, "convertVersion: version = " + r5 + " convertedVersion = " + r0, new Object[0]);
        return r0;
    L5:
        if (r5 != 512) goto L7;
        r0 = ISmModel.ModelVersion.VERSION_2_0;
        goto L24
    L7:
        if (r5 != 768) goto L9;
        r0 = ISmModel.ModelVersion.VERSION_3_0;
        goto L24
    L9:
        if (r5 != 1024) goto L11;
        r0 = ISmModel.ModelVersion.VERSION_4_0;
        goto L24
    L11:
        if (r5 != 1280) goto L13;
        r0 = ISmModel.ModelVersion.VERSION_5_0;
        goto L24
    L13:
        if (r5 != 1536) goto L15;
        r0 = ISmModel.ModelVersion.VERSION_6_0;
        goto L24
    L15:
        if (r5 == 1792) goto L17;
        r0 = ISmModel.ModelVersion.VERSION_UNKNOWN;
        goto L24
    L17:
        r0 = ISmModel.ModelVersion.VERSION_7_0;
        goto L24
    }

    private ArrayList<String> generateKeyphraseUserIndicesArray(ObricListenTypes$SVASoundModelInfo r21) {
        ObricListenTypes$SVASoundModelInfo r1 = r21;
        ArrayList<String> r2 = new ArrayList();
        if (r1 != null) goto L6;
        LogUtils.e(this.TAG, "generateKeyphraseUserIndicesArray: invalid input param", new Object[0]);
        return r2;
    L6:
        ObricListenTypes$KeywordInfo[] r4 = r1.keywordInfo;
        int r5 = r4.length;
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L10;
        ObricListenTypes$KeywordInfo r8 = r4[r6];
        r2.add(r8.keywordPhrase);
        String r9 = this.TAG;
        StringBuilder r10 = new StringBuilder("generateKeyphraseUserIndicesArray: ");
        r10.append(r8.keywordPhrase);
        r10.append(" index = ");
        r10.append(r2.size() - 1);
        LogUtils.d(r9, r10.toString(), new Object[0]);
        r6 = r6 + 1;
        goto L8
    L10:
        String[] r7 = r1.userNames;
        int r11 = r7.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L34;
        String r13 = r7[r12];
        ObricListenTypes$KeywordInfo[] r14 = r1.keywordInfo;
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L33;
        ObricListenTypes$KeywordInfo r17 = r14[r16];
        if (768 != r1.version) goto L25;
        String[] r18 = r1.userNames;
        int r19 = r18.length;
        int r3 = 0;
    L17:
        String[] r110 = r7;
        if (r3 >= r19) goto L24;
        if (r13.equals(r18[r3]) == false) goto L23;
        r2.add(r13 + "|" + r17.keywordPhrase);
        String r20 = this.TAG;
        StringBuilder r22 = new StringBuilder("generateKeyphraseUserIndicesArray: 3.0 model ");
        r22.append(r17.keywordPhrase);
        r22.append(" & ");
        r22.append(r13);
        r22.append(" index = ");
        r22.append(r2.size() - 1);
        LogUtils.d(r20, r22.toString(), new Object[0]);
    L23:
        r3 = r3 + 1;
        r7 = r110;
        r11 = r11;
        r14 = r14;
        r15 = r15;
        goto L17
    L24:
        int r111 = r11;
        ObricListenTypes$KeywordInfo[] r112 = r14;
        int r113 = r15;
    L32:
        r16 = r16 + 1;
        r1 = r21;
        r7 = r110;
        r11 = r111;
        r14 = r112;
        r15 = r113;
        goto L13
    L25:
        r110 = r7;
        r111 = r11;
        r112 = r14;
        r113 = r15;
        String[] r23 = r17.activeUsers;
        int r24 = r23.length;
        int r25 = 0;
    L26:
        if (r25 >= r24) goto L32;
        if (r13.equals(r23[r25]) == false) goto L31;
        r2.add(r13 + "|" + r17.keywordPhrase);
        String r26 = this.TAG;
        StringBuilder r114 = new StringBuilder("generateKeyphraseUserIndicesArray: 2.0 model ");
        r114.append(r17.keywordPhrase);
        r114.append(" & ");
        r114.append(r13);
        r114.append(" index = ");
        r114.append(r2.size() - 1);
        LogUtils.d(r26, r114.toString(), new Object[0]);
    L31:
        r25 = r25 + 1;
        goto L26
    L33:
        r12 = r12 + 1;
        r1 = r21;
        goto L11
    L34:
        return r2;
    }

    private static /* synthetic */ boolean lambda$initSoundModels$1(File r2) {
        if (r2.getName().equals(SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.getName().equals(SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL) == true) goto L8;
        return false;
    }

    private static /* synthetic */ File[] lambda$initSoundModels$2(int r0) {
        return new File[r0];
    }

    private ObricListenTypes$SVASoundModelInfo query(String r7) {
        LogUtils.d(this.TAG, "query: smFullName = " + r7, new Object[0]);
        if (r7 != null) goto L7;
        LogUtils.e(this.TAG, "query: invalid input param", new Object[0]);
        return null;
    L7:
        if (c.c(Global.getInstance().PATH_ROOT + "/" + r7) == true) goto L15;
        LogUtils.e(this.TAG, "query: error file not exists", new Object[0]);
        return null;
    L15:
        ObricListenTypes$SVASoundModelInfo r8 = new ObricListenTypes$SVASoundModelInfo();     // Catch: Exception -> L10
        r8.version = 0;     // Catch: Exception -> L10
        r8.type = 0;     // Catch: Exception -> L10
        r8.keywordInfo = new ObricListenTypes$KeywordInfo[1];     // Catch: Exception -> L10
        ObricListenTypes$KeywordInfo r4 = new ObricListenTypes$KeywordInfo();     // Catch: Exception -> L10
        r4.keywordPhrase = "obric";     // Catch: Exception -> L10
        r4.activeUsers = new String[]{"obric"};     // Catch: Exception -> L10
        r8.keywordInfo[0] = r4;     // Catch: Exception -> L10
        r8.userNames = new String[]{"obric"};     // Catch: Exception -> L10
        return r8;
    L10:
        e = move-exception;
        LogUtils.e(this.TAG, "query: error " + e, new Object[0]);
        return null;
    }

    public void deleteSoundModel(String r5) {
        LogUtils.d(this.TAG, "deleteSoundModel: smFullName = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.d(this.TAG, "deleteSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r6 = getSoundModel(r5);
        if (r6 == null) goto L10;
        this.mSoundModelList.remove(r6);
        return;
    }

    public ByteBuffer getLanguageModel(ISmModel.ModelVersion r7) {
        LogUtils.d(this.TAG, "getLanguageModel: enter with version:" + r7, new Object[0]);
        if (r7 != ISmModel.ModelVersion.VERSION_5_0) goto L5;
    L16:
        LogUtils.e(this.TAG, "getLanguageModel: no corresponding language model", new Object[0]);
        String r8 = null;
    L18:
        if (c.c(r8) == true) goto L26;
        LogUtils.d(this.TAG, "getLanguageModel: language model file not exist", new Object[0]);
        return null;
    L26:
        return c.e(r8);
    L21:
        e = move-exception;
        LogUtils.e(this.TAG, "getLanguageModel: read language model failed, filePath=" + r8 + ", err=" + e, new Object[0]);
        return null;
    L5:
        if (r7 == ISmModel.ModelVersion.VERSION_6_0) goto L16;
        if (r7 != ISmModel.ModelVersion.VERSION_4_0) goto L11;
        r8 = Global.getInstance().PATH_ROOT + "/merged_language_model_1225.lat";
        LogUtils.d(this.TAG, "getLanguageModel: merged model", new Object[0]);
        goto L18
    L11:
        if (r7 != ISmModel.ModelVersion.VERSION_7_0) goto L14;
        LogUtils.d(this.TAG, "getLanguageModel: sm7 merged model", new Object[0]);
        throw new RuntimeException("has removed the model  , if need , please contact the developer");
    L14:
        LogUtils.d(this.TAG, "getLanguageModel: default model", new Object[0]);
        throw new RuntimeException("has removed the model , if need , please contact the developer");
    }

    public String getSmNameByHandle(int r5) {
        Iterator<IExtendedSmModel> r0 = this.mSoundModelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IExtendedSmModel r1 = r0.next();
        if (r1.getSoundModelHandle() != r5) goto L4;
        String r2 = r1.getSoundModelFullFileName();
    L9:
        LogUtils.d(this.TAG, "getSmNameByHandle: smHandle = " + r5 + " smName = " + r2, new Object[0]);
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    public String getSmNameByKeyphraseId(int r7) {
        String r1 = null;
        if (r7 >= 0) goto L6;
        LogUtils.e(this.TAG, "getSmNameByKeyphraseId: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IExtendedSmModel> r2 = this.mSoundModelList.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        IExtendedSmModel r3 = r2.next();
        Iterator<IKeyphraseModel> r4 = r3.getSoundModelKeyphraseList().iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (r7 != r4.next().getKeyphraseId()) goto L11;
        r1 = r3.getSoundModelFullFileName();
        goto L8
    L15:
        LogUtils.e(this.TAG, "getSmNameByKeyphraseId: keyphraseId = " + r7 + " smName = " + r1, new Object[0]);
        return r1;
    }

    public IExtendedSmModel getSoundModel(String r2) {
        return getSoundModel(r2, this.mSoundModelList);
    }

    public String getSoundModelFullPath(String r5) {
        LogUtils.d(this.TAG, "getSoundModelFullPath: smFullName = " + r5, new Object[0]);
        if (r5 != null) goto L7;
        LogUtils.e(this.TAG, "getSoundModelFullPath: invalid input param", new Object[0]);
        return null;
    L7:
        return Global.getInstance().PATH_ROOT + "/" + r5;
    }

    public boolean initSoundModels(Context r10) {
        ArrayList r0 = new ArrayList();
        ArrayList<String> r1 = new ArrayList();
        PolarisFileWrapper r2 = new PolarisFileWrapper(Global.getInstance().PATH_ROOT);
        if (r2.exists() == false) goto L21;
        File[] r3 = r2.listFiles(new d());
        LogUtils.d(this.TAG, "initSoundModels: check endfix files = " + r3.length, new Object[0]);
        File[] r4 = (File[]) Arrays.stream(r3).filter(new e()).toArray(new f());
        LogUtils.d(this.TAG, "initSoundModels: check name files = " + r4.length, new Object[0]);
        if (r4.length != 0) goto L8;
        LogUtils.e(this.TAG, "initSoundModels: no sound model file found", new Object[0]);
        publishSoundModels(r0, r1);
        return false;
    L8:
        LogUtils.e(this.TAG, "initSoundModels:  sound model file found with size :" + r4.length, new Object[0]);
        ArrayList r5 = new ArrayList();
        int r6 = r4.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L11;
        r5.add(r4[r7]);
        r7 = r7 + 1;
        goto L9
    L11:
        Collections.sort(r5, new g());
        Iterator r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        File r9 = (File) r8.next();
        LogUtils.d(this.TAG, "after sort file is :" + r9.getName(), new Object[0]);
        goto L13
    L15:
        Iterator r11 = r5.iterator();
        boolean r12 = false;
    L17:
        if (r11.hasNext() == false) goto L19;
        String r13 = ((File) r11.next()).getName();
        LogUtils.d(this.TAG, "initSoundModels: add sound model " + r13, new Object[0]);
        addSoundModel(r10, r13, r0, r1);
        r12 = true;
        goto L17
    L19:
        publishSoundModels(r0, r1);
        return r12;
    L21:
        publishSoundModels(r0, r1);
        return false;
    }

    public void resetSessionStatus(String r4) {
        LogUtils.d(this.TAG, "resetSessionStatus: enter : " + r4, new Object[0]);
        Iterator<IExtendedSmModel> r0 = this.mSoundModelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IExtendedSmModel r1 = r0.next();
        if (r1.getSoundModelFullFileName().equalsIgnoreCase(r4) == false) goto L4;
    L9:
        if (r1 == null) goto L15;
        r1.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    private IExtendedSmModel getSoundModel(String r6, List<IExtendedSmModel> r7) {
        LogUtils.d(this.TAG, "getSoundModel: smFullName = " + r6, new Object[0]);
        IExtendedSmModel r0 = null;
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "getSoundModel: invalid input param", new Object[0]);
        return null;
    L6:
        monitor-enter(r7);
        Iterator<IExtendedSmModel> r1 = r7.iterator();     // Catch: Throwable -> L16
    L9:
        if (r1.hasNext() == false) goto L13;
        IExtendedSmModel r3 = r1.next();     // Catch: Throwable -> L16
        if (r3.getSoundModelFullFileName().equalsIgnoreCase(r6) == false) goto L9;
        r0 = r3;
    L13:
        monitor-exit(r7);     // Catch: Throwable -> L16
        LogUtils.d(this.TAG, "getSoundModel: return model is  " + r0, new Object[0]);
        return r0;
    L16:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$initSoundModels$0(File r0, String r1) {
        if (r1.endsWith(ISmModel.SUFFIX_DEFAULT_SOUND_MODEL) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static /* synthetic */ int lambda$initSoundModels$3(File r1, File r2) {
        boolean r3 = r1.getName().contains("voice");
        boolean r4 = r2.getName().contains("voice");
        if (r3 == false) goto L7;
        if (r4 == true) goto L7;
        return -1;
    L7:
        if (r3 == true) goto L11;
        if (r4 == false) goto L13;
        return 1;
    L13:
        return 0;
    L11:
        return 0;
    }

    private void publishSoundModels(List<IExtendedSmModel> r2, ArrayList<String> r3) {
        this.mSoundModelList = Collections.synchronizedList(new ArrayList(r2));
        mUIMKeyphraseList = new ArrayList(r3);
    }

    public void addSoundModel(Context r3, String r4) {
        addSoundModel(r3, r4, this.mSoundModelList, mUIMKeyphraseList);
    }

    public void updateSoundModel(Context r2, IExtendedSmModel r3) {
        updateSoundModel(r2, r3, mUIMKeyphraseList);
    }

    private int generateKeyphraseId(Context r1, ArrayList<String> r2, String r3) {
        if (r2 != null) goto L4;
    L9:
        LogUtils.e(this.TAG, "generateKeyphraseId: invalid input param", new Object[0]);
        return -1;
    L4:
        if (r2.isEmpty() == true) goto L9;
        if (r3 == null) goto L9;
        return r2.indexOf(r3);
    }

    private int generateUserId(ArrayList<String> r2, String r3, String r4) {
        if (r2 != null) goto L4;
    L10:
        LogUtils.e(this.TAG, "generateUserId: invalid input param", new Object[0]);
        return -1;
    L4:
        if (r2.isEmpty() == true) goto L10;
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        return r2.indexOf(r4 + "|" + r3);
    }

    private void updateSoundModel(Context r7, IExtendedSmModel r8, ArrayList<String> r9) {
        LogUtils.d(this.TAG, "updateSoundModel: soundModel = " + r8, new Object[0]);
        if (r8 != null) goto L6;
        LogUtils.e(this.TAG, "updateSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        String r0 = r8.getSoundModelFullFileName();
        ObricListenTypes$SVASoundModelInfo r1 = query(r0);
        if (r1 == null) goto L13;
        LogUtils.i(this.TAG, "updateSoundModel: query model Info " + r1, new Object[0]);
        r8.setSoundModelType(r1.type);
        r8.setSoundModelVersion(convertVersion(r1.version));
        ObricListenTypes$KeywordInfo[] r3 = r1.keywordInfo;
        if (r3 == null) goto L13;
        if (r3.length <= 0) goto L13;
        r8.setSoundModelPrettyKeyphrase(r3[0].keywordPhrase);
        addKeyphraseAndUsers(r7, r1, r8, r9);
    L13:
        SettingsModel r10 = new SettingsModel(r7, r0);
        r8.setSoundModelActionName(r10.getActionName());
        r8.setSoundModelActionIntent(r10.getActionIntent());
    }

    public void setSoundModelAction(String r5, String r6, Intent r7) {
        LogUtils.d(this.TAG, "setSoundModelAction: smFullName = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.e(this.TAG, "setSoundModelAction: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r8 = getSoundModel(r5);
        if (r8 == null) goto L10;
        r8.setSoundModelActionName(r6);
        r8.setSoundModelActionIntent(r7);
        return;
    }

    private void addKeyphraseAndUsers(Context r19, ObricListenTypes$SVASoundModelInfo r20, IExtendedSmModel r21, ArrayList<String> r22) {
        ObricListenTypes$SVASoundModelInfo r1 = r20;
        int r4 = 0;
        if (r1 == null) goto L26;
        if (r21 == null) goto L26;
        ArrayList<String> r5 = generateKeyphraseUserIndicesArray(r1);
        if (r5.isEmpty() == true) goto L25;
        ObricListenTypes$KeywordInfo[] r6 = r1.keywordInfo;
        int r7 = r6.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L32;
        ObricListenTypes$KeywordInfo r9 = r6[r8];
        int r10 = generateKeyphraseId(r19, r5, r9.keywordPhrase);
        r21.addKeyphrase(r9.keywordPhrase, r10);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: keyphrase " + r9 + " 's keyphraseId = " + r10, new Object[r4]);
        if (r21.isUserTrainedSoundModel() == true) goto L16;
        if (r22.contains(r9.keywordPhrase) == true) goto L16;
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: add " + r9.keywordPhrase + " to mUIMKeyphraseList", new Object[r4]);
        r22.add(r9.keywordPhrase);
    L16:
        if (768 != r1.version) goto L21;
        String[] r12 = r1.userNames;
        int r13 = r12.length;
        int r15 = 0;
    L18:
        if (r15 >= r13) goto L20;
        String r11 = r12[r15];
        int r2 = generateUserId(r5, r9.keywordPhrase, r11);
        r21.addKeyphraseAndUser(r9.keywordPhrase, r10, r11, r2);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: 3.0 model user " + r11 + " 's userId = " + r2, new Object[0]);
        r15 = r15 + 1;
        r6 = r6;
        r7 = r7;
        goto L18
    L20:
        ObricListenTypes$KeywordInfo[] r16 = r6;
        int r17 = r7;
    L24:
        r8 = r8 + 1;
        r1 = r20;
        r6 = r16;
        r7 = r17;
        r4 = 0;
        goto L9
    L21:
        r16 = r6;
        r17 = r7;
        String[] r3 = r9.activeUsers;
        int r14 = r3.length;
        int r18 = 0;
    L22:
        if (r18 >= r14) goto L24;
        String r23 = r3[r18];
        int r24 = generateUserId(r5, r9.keywordPhrase, r23);
        r21.addKeyphraseAndUser(r9.keywordPhrase, r10, r23, r24);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: user " + r23 + " 's userId = " + r24, new Object[0]);
        r18 = r18 + 1;
        goto L22
    L32:
        return;
    L25:
        return;
    L26:
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: invalid input param", new Object[0]);
    }

    private void addSoundModel(Context r5, String r6, List<IExtendedSmModel> r7, ArrayList<String> r8) {
        LogUtils.d(this.TAG, "addSoundModel: smFullName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(this.TAG, "addSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r0 = getSoundModel(r6, r7);
        if (r0 != null) goto L9;
        LogUtils.d(this.TAG, "addSoundModel: new one sound model" + r6, new Object[0]);
        r0 = new ExtendedSmModel(r6);
        r7.add(r0);
    L10:
        updateSoundModel(r5, r0, r8);
        SettingsModel r9 = new SettingsModel(r5, r6);
        if (r0.isSupportExtendedOpaqueData() == false) goto L14;
        LogUtils.d(this.TAG, "addSoundModel: set opaque data transfer enabled.", new Object[0]);
        r9.setOpaqueDataTransferEnabled(true);
        return;
    L14:
        return;
    L9:
        LogUtils.d(this.TAG, "addSoundModel: sound model already exists", new Object[0]);
        goto L10
    }
}
