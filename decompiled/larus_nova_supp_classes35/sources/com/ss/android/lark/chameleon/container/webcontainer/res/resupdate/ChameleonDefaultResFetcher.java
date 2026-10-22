package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.FileUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonDefaultResFetcher;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/IResourceFetcher;", "()V", "localResourceMap", "Ljava/util/concurrent/ConcurrentHashMap;", BuildConfig.FLAVOR, "asyncGetResource", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "context", "Landroid/content/Context;", "session", "clearOldResource", BuildConfig.FLAVOR, "channelRootDir", "Ljava/io/File;", "getResourceInternal", "getTemplateDir", "ChameleonConfig", "syncGetResource", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonDefaultResFetcher implements IResourceFetcher {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_DefaultResFetcher";
    private final ConcurrentHashMap<String, String> localResourceMap;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonDefaultResFetcher$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher$asyncGetResource$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher$asyncGetResource$1", f = "ChameleonDefaultResFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChameleonConfig $chameleonConfig;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $session;
        int label;
        final /* synthetic */ ChameleonDefaultResFetcher this$0;

        public AnonymousClass1(ChameleonDefaultResFetcher r1, ChameleonConfig r2, Context r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$chameleonConfig = r2;
            this.$context = r3;
            this.$session = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$chameleonConfig, this.$context, this.$session, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            ChameleonDefaultResFetcher.access$getResourceInternal(this.this$0, this.$chameleonConfig, this.$context, this.$session);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.IResourceFetcher
    public String getTemplateDir(ChameleonConfig r1) {
        return BuildConfig.FLAVOR;
    }

    public ChameleonDefaultResFetcher() {
        this.localResourceMap = new ConcurrentHashMap();
    }

    private final void clearOldResource(File r4) throws IOException {
        if (r4.isDirectory() == false) goto L7;
        File[] r5 = r4.listFiles();
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        FileUtils.deleteFile(r5[r1]);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private final String getResourceInternal(ChameleonConfig r23, Context r24, String r25) {
        StringBuilder r7 = new StringBuilder("getResourceInternal ChameleonId is ");
        if (r23 == null) goto L5;
        String r9 = r23.getBizName();
    L6:
        r7.append(r9);
        Log.i(TAG, r7.toString());
        if (r24 != null) goto L9;
        return null;
    L9:
        if (r23 == null) goto L12;
        String r6 = r23.getBizName();
        if (r6 == null) goto L12;
    L14:
        monitor-enter(ChameleonDefaultResFetcher.class);
        if (r23 != null) goto L82;
    L20:
        String r10 = BuildConfig.FLAVOR;
    L21:
        ChameleonResUtils r11 = ChameleonResUtils.INSTANCE;     // Catch: Throwable -> L73
        File r8 = r11.getResourceRootDir(r23, r6);     // Catch: Throwable -> L73
        File r12 = new PolarisFileWrapper(r8, r10);     // Catch: Throwable -> L73
        boolean r13 = false;
        if (r23 == null) goto L31;
        ResConfig r14 = r23.getResConfig();     // Catch: Throwable -> L73
        if (r14 == null) goto L31;
        String r15 = r14.getOfflineZipName();     // Catch: Throwable -> L73
        if (r15 == null) goto L31;
        List r16 = StringsKt.split$default(r15, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L73
        if (r16 == null) goto L31;
        String r17 = (String) r16.get(0);     // Catch: Throwable -> L73
        if (r17 == null) goto L31;
    L32:
        PolarisFileWrapper r18 = new PolarisFileWrapper(r12, r17);     // Catch: Throwable -> L73
        String r19 = r11.getOfflineFileVersion(r18.getPath());     // Catch: Throwable -> L73
        Log.i(TAG, "getResource(): path " + r18.getAbsolutePath() + "  localVersion: " + r19 + "  assetVersion: " + r10);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r10) == false) goto L35;
    L39:
        clearOldResource(r8);     // Catch: Throwable -> L73
        ChameleonAssertResManager r5 = ChameleonAssertResManager.INSTANCE;     // Catch: Throwable -> L73
        ChameleonResInfo r110 = r5.getResInfo(r23, r24);     // Catch: Throwable -> L73
        if (r110 != null) goto L42;
    L44:
        if (r13 == false) goto L49;
        Log.i(TAG, "getResourceInternal resInfo is null, return");     // Catch: Throwable -> L73
        monitor-exit(ChameleonDefaultResFetcher.class);
        return null;
    L49:
        if (r12.exists() == true) goto L65;
        ChameleonOpenTracker r111 = ChameleonOpenTracker.INSTANCE;     // Catch: Throwable -> L73
        ChameleonOpenTracker.SessionTracker r112 = r111.getSessionTracker(r25);     // Catch: Throwable -> L73
        if (r112 == null) goto L53;
        ChameleonOpenTracker.SessionTracker.stageStart$default(r112, ChameleonOpenTracker.Stage.UNZIP, 0, 2, null);     // Catch: Throwable -> L73
    L53:
        Log.i(TAG, "getResourceInternal clearOldResource");     // Catch: Throwable -> L73
        PolarisFileWrapper r113 = new PolarisFileWrapper(r8, r10 + '_' + System.currentTimeMillis() + "__temp");     // Catch: Throwable -> L73
        r113.mkdir();     // Catch: Throwable -> L73
        if (r5.extractSimAssetToLocal(r23, r24, r113) == true) goto L59;
        monitor-exit(ChameleonDefaultResFetcher.class);
        return null;
    L59:
        if (r12.exists() == false) goto L61;
        Log.i(TAG, "getResource(): destParentFile exists() after unzip delete temp file");     // Catch: Throwable -> L73
        FileUtils.deleteFile(r113);     // Catch: Throwable -> L73
    L62:
        ChameleonOpenTracker.SessionTracker r114 = r111.getSessionTracker(r25);     // Catch: Throwable -> L73
        if (r114 == null) goto L66;
        ChameleonOpenTracker.SessionTracker.stageEnd$default(r114, ChameleonOpenTracker.Stage.UNZIP, 0, 2, null);     // Catch: Throwable -> L73
    L66:
        if (r23 == null) goto L70;
        String r0 = r23.getBizName();     // Catch: Throwable -> L73
        if (r0 == null) goto L70;
        String r1 = this.localResourceMap.put(r0, r18.getPath());     // Catch: Throwable -> L73
    L70:
        String r2 = r18.getPath();     // Catch: Throwable -> L73
        monitor-exit(ChameleonDefaultResFetcher.class);
        return r2;
    L61:
        Log.i(TAG, "getResource(): rename result = " + r113.renameTo(r12));     // Catch: Throwable -> L73
        goto L62
    L65:
        Log.i(TAG, "getResource(): destParentFile exists()");     // Catch: Throwable -> L73
        goto L66
    L42:
        if (r110.isEmpty() != true) goto L44;
        r13 = true;
        goto L44
    L35:
        if (TextUtils.isEmpty(r19) == true) goto L39;
        if (TextUtils.equals(r10, r19) == false) goto L39;
        Log.i(TAG, "getResource(): assetVersion == localVersion");     // Catch: Throwable -> L73
    L31:
        r17 = BuildConfig.FLAVOR;
        goto L32
    L82:
        ResConfig r20 = r23.getResConfig();     // Catch: Throwable -> L73
        if (r20 == null) goto L20;
        r10 = r20.getResVersion();     // Catch: Throwable -> L73
        if (r10 != null) goto L21;
    L73:
        th = move-exception;
        Log.e(TAG, "Chameleon getResourceInternal(): failed ", th);     // Catch: Throwable -> L77
        return null;
    L77:
        th = move-exception;
        throw th;
    L12:
        r6 = ChameleonChannel.DEFAULT_CHANNEL.getValue();
        goto L14
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.IResourceFetcher
    public String asyncGetResource(ChameleonConfig r13, Context r14, String r15) {
        StringBuilder r0 = new StringBuilder("asyncGetResource ");
        String r1 = null;
        if (r13 == null) goto L5;
        String r2 = r13.getBizName();
    L6:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        if (r13 == null) goto L9;
        String r3 = r13.getBizName();
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        ConcurrentHashMap<String, String> r4 = this.localResourceMap;
        if (r13 == null) goto L15;
        String r5 = r13.getBizName();
    L16:
        String r6 = r4.get(r5);
        if (r6 == null) goto L22;
        StringBuilder r16 = new StringBuilder("getResource from memory cache, ChameleonId is ");
        if (r13 == null) goto L21;
        r1 = r13.getBizName();
    L21:
        r16.append(r1);
        Log.i(TAG, r16.toString());
        return r6;
    L22:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r13, r14, r15, null), 2, null);
        return null;
    L15:
        r5 = null;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.IResourceFetcher
    public String syncGetResource(ChameleonConfig r1, Context r2, String r3) {
        return getResourceInternal(r1, r2, r3);
    }

    public static final /* synthetic */ String access$getResourceInternal(ChameleonDefaultResFetcher r0, ChameleonConfig r1, Context r2, String r3) {
        return r0.getResourceInternal(r1, r2, r3);
    }
}
