package com.obric.aikernel.res;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.Keep;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.downloader.DownloadController;
import com.obric.aikernel.res.downloader.obric.ObricDownloadManager;
import com.obric.aikernel.res.installer.AssetsScanner;
import com.obric.aikernel.res.installer.DeviceStorageScanner;
import com.obric.aikernel.res.installer.FusionInstaller;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.PackagesListener;
import com.obric.aikernel.res.metadata.config.e;
import com.obric.aikernel.res.metadata.controller.MetadataController;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.metadata.data.b;
import com.obric.aikernel.res.update.PackageUpdater;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.res.update.h;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class PackageResourceManager {
    public static final a Companion = null;
    public static final String DEBUG_CALLER = ":debug";
    public static final String TAG = "PResM";
    private final PrmContext context;
    private final FusionInstaller fusionInstaller;
    private final DownloadController globalDownloadController;
    private final MetadataController metadataController;
    private final PackagesListener packagesListener;
    private Function0<? extends Set<String>> runningDepsGetter;
    private final r0<PackageUpdater> updater;

    @Keep
    public static final class PresmConfig {
        private final AppConfig appConfig;
        private final String assertRootDir;
        private final Context context;
        private com.obric.aikernel.res.installer.a customInstaller;
        private b decryptFeature;
        private final String deviceRootDir;
        private c8.c dynamicResProxy;
        private Function0<Boolean> isInferProcess;
        private final com.obric.aikernel.runtime.utils.c logger;
        private final Lazy memSize$delegate;
        private c nativeLibLifeCycle;
        private final d packageActionInjector;
        private final int parallelDownloadNum;
        private final String preInitPackageName;
        private final Map<String, Set<String>> presetLibraries;
        private final String pyVmVersion;
        private final String resRootDir;
        private final String rootDir;
        private e updateListener;
        private boolean useAIKernelModel;
        private final boolean useObricDownloader;

        @Keep
        public static final class AppConfig {
            private final String aid;
            private final g1<Pair<Boolean, String>> allowBackgroundUpdate;
            private final Function0<Boolean> allowNetworkRequest;
            private final String appVersion;
            private final Function0<Long> autoCleanResourceInterval;
            private final Function0<Integer> autoCleanResourceTotalGB;
            private final Function0<Boolean> autoDeleteDebugPackage;
            private final g1<String> autoUpdateTrigger;
            private final String channel;
            private final Function0<Boolean> checkPackageResource;
            private final Function1<Continuation<? super String>, Object> did;
            private final boolean enableDownloadForegroundService;
            private boolean isDebug;
            private final Function2<y, Continuation<? super String>, Object> networkRequestDelegate;
            private final String projectId;
            private final String region;
            private final String semAppVersion;
            private final String soc;
            private final Function0<Unit> startDownloadForegroundService;
            private final Function0<Unit> stopDownloadForegroundService;
            private final String url;
            private final String userId;

            /* JADX WARN: Multi-variable type inference failed */
            public AppConfig(String r17, String r18, String r19, Function1<? super Continuation<? super String>, ? extends Object> r20, String r21, String r22, String r23, String r24, boolean r25, g1<Pair<Boolean, String>> r26, g1<String> r27, Function0<Long> r28, Function0<Integer> r29, Function2<? super y, ? super Continuation<? super String>, ? extends Object> r30, Function0<Boolean> r31, Function0<Boolean> r32, Function0<Boolean> r33, String r34, boolean r35, Function0<Unit> r36, Function0<Unit> r37, String r38) {
                Intrinsics.checkNotNullParameter(r17, "aid");
                Intrinsics.checkNotNullParameter(r18, "appVersion");
                Intrinsics.checkNotNullParameter(r19, "channel");
                Intrinsics.checkNotNullParameter(r20, "did");
                Intrinsics.checkNotNullParameter(r21, "userId");
                Intrinsics.checkNotNullParameter(r22, "url");
                Intrinsics.checkNotNullParameter(r23, "projectId");
                Intrinsics.checkNotNullParameter(r24, "semAppVersion");
                Intrinsics.checkNotNullParameter(r26, "allowBackgroundUpdate");
                Intrinsics.checkNotNullParameter(r28, "autoCleanResourceInterval");
                Intrinsics.checkNotNullParameter(r29, "autoCleanResourceTotalGB");
                Intrinsics.checkNotNullParameter(r31, "autoDeleteDebugPackage");
                Intrinsics.checkNotNullParameter(r32, "checkPackageResource");
                Intrinsics.checkNotNullParameter(r33, "allowNetworkRequest");
                Intrinsics.checkNotNullParameter(r36, "startDownloadForegroundService");
                Intrinsics.checkNotNullParameter(r37, "stopDownloadForegroundService");
                this.aid = r17;
                this.appVersion = r18;
                this.channel = r19;
                this.did = r20;
                this.userId = r21;
                this.url = r22;
                this.projectId = r23;
                this.semAppVersion = r24;
                this.isDebug = r25;
                this.allowBackgroundUpdate = r26;
                this.autoUpdateTrigger = r27;
                this.autoCleanResourceInterval = r28;
                this.autoCleanResourceTotalGB = r29;
                this.networkRequestDelegate = r30;
                this.autoDeleteDebugPackage = r31;
                this.checkPackageResource = r32;
                this.allowNetworkRequest = r33;
                this.soc = r34;
                this.enableDownloadForegroundService = r35;
                this.startDownloadForegroundService = r36;
                this.stopDownloadForegroundService = r37;
                this.region = r38;
            }

            public /* synthetic */ AppConfig(String r27, String r28, String r29, Function1 r30, String r31, String r32, String r33, String r34, boolean r35, g1 r36, g1 r37, Function0 r38, Function0 r39, Function2 r40, Function0 r41, Function0 r42, Function0 r43, String r44, boolean r45, Function0 r46, Function0 r47, String r48, int r49, DefaultConstructorMarker r50) {
                if ((r49 & 256) == 0) goto L5;
                boolean r12 = false;
            L7:
                if ((r49 & 512) == 0) goto L9;
                g1 r13 = q1.a(new Pair(Boolean.FALSE, "default disable background update."));
            L11:
                if ((r49 & 1024) == 0) goto L13;
                g1 r14 = null;
            L15:
                if ((r49 & 2048) == 0) goto L17;
                Function0 r15 = AnonymousClass1.INSTANCE;
            L19:
                if ((r49 & 4096) == 0) goto L21;
                Function0 r16 = AnonymousClass2.INSTANCE;
            L23:
                if ((r49 & 8192) == 0) goto L25;
                Function2 r17 = null;
            L27:
                if ((r49 & 16384) == 0) goto L29;
                Function0 r18 = AnonymousClass3.INSTANCE;
            L31:
                if ((32768 & r49) == 0) goto L33;
                Function0 r19 = AnonymousClass4.INSTANCE;
            L35:
                if ((65536 & r49) == 0) goto L37;
                Function0 r20 = AnonymousClass5.INSTANCE;
            L39:
                if ((131072 & r49) == 0) goto L41;
                String r21 = null;
            L43:
                if ((262144 & r49) == 0) goto L45;
                boolean r22 = false;
            L47:
                if ((524288 & r49) == 0) goto L49;
                Function0 r23 = AnonymousClass6.INSTANCE;
            L51:
                if ((1048576 & r49) == 0) goto L53;
                Function0 r24 = AnonymousClass7.INSTANCE;
            L55:
                if ((r49 & 2097152) == 0) goto L57;
                String r25 = null;
            L58:
                this(r27, r28, r29, r30, r31, r32, r33, r34, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
                return;
            L57:
                r25 = r48;
                goto L58
            L53:
                r24 = r47;
                goto L55
            L49:
                r23 = r46;
                goto L51
            L45:
                r22 = r45;
                goto L47
            L41:
                r21 = r44;
                goto L43
            L37:
                r20 = r43;
                goto L39
            L33:
                r19 = r42;
                goto L35
            L29:
                r18 = r41;
                goto L31
            L25:
                r17 = r40;
                goto L27
            L21:
                r16 = r39;
                goto L23
            L17:
                r15 = r38;
                goto L19
            L13:
                r14 = r37;
                goto L15
            L9:
                r13 = r36;
                goto L11
            L5:
                r12 = r35;
                goto L7
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AppConfig copy$default(AppConfig r17, String r18, String r19, String r20, Function1 r21, String r22, String r23, String r24, String r25, boolean r26, g1 r27, g1 r28, Function0 r29, Function0 r30, Function2 r31, Function0 r32, Function0 r33, Function0 r34, String r35, boolean r36, Function0 r37, Function0 r38, String r39, int r40, Object r41) {
                if ((r40 & 1) == 0) goto L5;
                String r10 = r17.aid;
            L7:
                if ((r40 & 2) == 0) goto L9;
                String r11 = r17.appVersion;
            L11:
                if ((r40 & 4) == 0) goto L13;
                String r12 = r17.channel;
            L15:
                if ((r40 & 8) == 0) goto L17;
                Function1 r13 = r17.did;
            L19:
                if ((r40 & 16) == 0) goto L21;
                String r14 = r17.userId;
            L23:
                if ((r40 & 32) == 0) goto L25;
                String r15 = r17.url;
            L27:
                if ((r40 & 64) == 0) goto L29;
                String r16 = r17.projectId;
            L31:
                if ((r40 & 128) == 0) goto L33;
                String r42 = r17.semAppVersion;
            L35:
                if ((r40 & 256) == 0) goto L37;
                boolean r110 = r17.isDebug;
            L39:
                if ((r40 & 512) == 0) goto L41;
                g1 r111 = r17.allowBackgroundUpdate;
            L43:
                if ((r40 & 1024) == 0) goto L45;
                g1 r112 = r17.autoUpdateTrigger;
            L47:
                if ((r40 & 2048) == 0) goto L49;
                Function0 r113 = r17.autoCleanResourceInterval;
            L51:
                if ((r40 & 4096) == 0) goto L53;
                Function0 r114 = r17.autoCleanResourceTotalGB;
            L55:
                if ((r40 & 8192) == 0) goto L57;
                Function2 r115 = r17.networkRequestDelegate;
            L58:
                Function2 r310 = r115;
                if ((r40 & 16384) == 0) goto L61;
                Function0 r116 = r17.autoDeleteDebugPackage;
            L62:
                Function0 r311 = r116;
                if ((r40 & 32768) == 0) goto L65;
                Function0 r117 = r17.checkPackageResource;
            L66:
                Function0 r312 = r117;
                if ((r40 & 65536) == 0) goto L69;
                Function0 r118 = r17.allowNetworkRequest;
            L70:
                Function0 r313 = r118;
                if ((r40 & 131072) == 0) goto L73;
                String r119 = r17.soc;
            L74:
                String r314 = r119;
                if ((r40 & 262144) == 0) goto L77;
                boolean r120 = r17.enableDownloadForegroundService;
            L78:
                boolean r315 = r120;
                if ((r40 & 524288) == 0) goto L81;
                Function0 r121 = r17.startDownloadForegroundService;
            L82:
                Function0 r316 = r121;
                if ((r40 & 1048576) == 0) goto L85;
                Function0 r122 = r17.stopDownloadForegroundService;
            L87:
                if ((r40 & 2097152) == 0) goto L89;
                String r43 = r17.region;
            L91:
                return r17.copy(r10, r11, r12, r13, r14, r15, r16, r42, r110, r111, r112, r113, r114, r310, r311, r312, r313, r314, r315, r316, r122, r43);
            L89:
                r43 = r39;
                goto L91
            L85:
                r122 = r38;
                goto L87
            L81:
                r121 = r37;
                goto L82
            L77:
                r120 = r36;
                goto L78
            L73:
                r119 = r35;
                goto L74
            L69:
                r118 = r34;
                goto L70
            L65:
                r117 = r33;
                goto L66
            L61:
                r116 = r32;
                goto L62
            L57:
                r115 = r31;
                goto L58
            L53:
                r114 = r30;
                goto L55
            L49:
                r113 = r29;
                goto L51
            L45:
                r112 = r28;
                goto L47
            L41:
                r111 = r27;
                goto L43
            L37:
                r110 = r26;
                goto L39
            L33:
                r42 = r25;
                goto L35
            L29:
                r16 = r24;
                goto L31
            L25:
                r15 = r23;
                goto L27
            L21:
                r14 = r22;
                goto L23
            L17:
                r13 = r21;
                goto L19
            L13:
                r12 = r20;
                goto L15
            L9:
                r11 = r19;
                goto L11
            L5:
                r10 = r18;
                goto L7
            }

            public final String component1() {
                return this.aid;
            }

            public final g1<Pair<Boolean, String>> component10() {
                return this.allowBackgroundUpdate;
            }

            public final g1<String> component11() {
                return this.autoUpdateTrigger;
            }

            public final Function0<Long> component12() {
                return this.autoCleanResourceInterval;
            }

            public final Function0<Integer> component13() {
                return this.autoCleanResourceTotalGB;
            }

            public final Function2<y, Continuation<? super String>, Object> component14() {
                return this.networkRequestDelegate;
            }

            public final Function0<Boolean> component15() {
                return this.autoDeleteDebugPackage;
            }

            public final Function0<Boolean> component16() {
                return this.checkPackageResource;
            }

            public final Function0<Boolean> component17() {
                return this.allowNetworkRequest;
            }

            public final String component18() {
                return this.soc;
            }

            public final boolean component19() {
                return this.enableDownloadForegroundService;
            }

            public final String component2() {
                return this.appVersion;
            }

            public final Function0<Unit> component20() {
                return this.startDownloadForegroundService;
            }

            public final Function0<Unit> component21() {
                return this.stopDownloadForegroundService;
            }

            public final String component22() {
                return this.region;
            }

            public final String component3() {
                return this.channel;
            }

            public final Function1<Continuation<? super String>, Object> component4() {
                return this.did;
            }

            public final String component5() {
                return this.userId;
            }

            public final String component6() {
                return this.url;
            }

            public final String component7() {
                return this.projectId;
            }

            public final String component8() {
                return this.semAppVersion;
            }

            public final boolean component9() {
                return this.isDebug;
            }

            public final AppConfig copy(String r25, String r26, String r27, Function1<? super Continuation<? super String>, ? extends Object> r28, String r29, String r30, String r31, String r32, boolean r33, g1<Pair<Boolean, String>> r34, g1<String> r35, Function0<Long> r36, Function0<Integer> r37, Function2<? super y, ? super Continuation<? super String>, ? extends Object> r38, Function0<Boolean> r39, Function0<Boolean> r40, Function0<Boolean> r41, String r42, boolean r43, Function0<Unit> r44, Function0<Unit> r45, String r46) {
                Intrinsics.checkNotNullParameter(r25, "aid");
                Intrinsics.checkNotNullParameter(r26, "appVersion");
                Intrinsics.checkNotNullParameter(r27, "channel");
                Intrinsics.checkNotNullParameter(r28, "did");
                Intrinsics.checkNotNullParameter(r29, "userId");
                Intrinsics.checkNotNullParameter(r30, "url");
                Intrinsics.checkNotNullParameter(r31, "projectId");
                Intrinsics.checkNotNullParameter(r32, "semAppVersion");
                Intrinsics.checkNotNullParameter(r34, "allowBackgroundUpdate");
                Intrinsics.checkNotNullParameter(r36, "autoCleanResourceInterval");
                Intrinsics.checkNotNullParameter(r37, "autoCleanResourceTotalGB");
                Intrinsics.checkNotNullParameter(r39, "autoDeleteDebugPackage");
                Intrinsics.checkNotNullParameter(r40, "checkPackageResource");
                Intrinsics.checkNotNullParameter(r41, "allowNetworkRequest");
                Intrinsics.checkNotNullParameter(r44, "startDownloadForegroundService");
                Intrinsics.checkNotNullParameter(r45, "stopDownloadForegroundService");
                return new AppConfig(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof AppConfig) == true) goto L8;
                return false;
            L8:
                AppConfig r11 = (AppConfig) r10;
                if (Intrinsics.areEqual(this.aid, r11.aid) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.appVersion, r11.appVersion) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.channel, r11.channel) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.did, r11.did) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.userId, r11.userId) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.url, r11.url) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.projectId, r11.projectId) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.semAppVersion, r11.semAppVersion) == true) goto L33;
                return false;
            L33:
                if (this.isDebug == r11.isDebug) goto L36;
                return false;
            L36:
                if (Intrinsics.areEqual(this.allowBackgroundUpdate, r11.allowBackgroundUpdate) == true) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.autoUpdateTrigger, r11.autoUpdateTrigger) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.autoCleanResourceInterval, r11.autoCleanResourceInterval) == true) goto L45;
                return false;
            L45:
                if (Intrinsics.areEqual(this.autoCleanResourceTotalGB, r11.autoCleanResourceTotalGB) == true) goto L48;
                return false;
            L48:
                if (Intrinsics.areEqual(this.networkRequestDelegate, r11.networkRequestDelegate) == true) goto L51;
                return false;
            L51:
                if (Intrinsics.areEqual(this.autoDeleteDebugPackage, r11.autoDeleteDebugPackage) == true) goto L54;
                return false;
            L54:
                if (Intrinsics.areEqual(this.checkPackageResource, r11.checkPackageResource) == true) goto L57;
                return false;
            L57:
                if (Intrinsics.areEqual(this.allowNetworkRequest, r11.allowNetworkRequest) == true) goto L60;
                return false;
            L60:
                if (Intrinsics.areEqual(this.soc, r11.soc) == true) goto L63;
                return false;
            L63:
                if (this.enableDownloadForegroundService == r11.enableDownloadForegroundService) goto L66;
                return false;
            L66:
                if (Intrinsics.areEqual(this.startDownloadForegroundService, r11.startDownloadForegroundService) == true) goto L69;
                return false;
            L69:
                if (Intrinsics.areEqual(this.stopDownloadForegroundService, r11.stopDownloadForegroundService) == true) goto L72;
                return false;
            L72:
                if (Intrinsics.areEqual(this.region, r11.region) == true) goto L74;
                return false;
            L74:
                return true;
            }

            public final String getAid() {
                return this.aid;
            }

            public final g1<Pair<Boolean, String>> getAllowBackgroundUpdate() {
                return this.allowBackgroundUpdate;
            }

            public final Function0<Boolean> getAllowNetworkRequest() {
                return this.allowNetworkRequest;
            }

            public final String getAppVersion() {
                return this.appVersion;
            }

            public final Function0<Long> getAutoCleanResourceInterval() {
                return this.autoCleanResourceInterval;
            }

            public final Function0<Integer> getAutoCleanResourceTotalGB() {
                return this.autoCleanResourceTotalGB;
            }

            public final Function0<Boolean> getAutoDeleteDebugPackage() {
                return this.autoDeleteDebugPackage;
            }

            public final g1<String> getAutoUpdateTrigger() {
                return this.autoUpdateTrigger;
            }

            public final String getChannel() {
                return this.channel;
            }

            public final Function0<Boolean> getCheckPackageResource() {
                return this.checkPackageResource;
            }

            public final Function1<Continuation<? super String>, Object> getDid() {
                return this.did;
            }

            public final boolean getEnableDownloadForegroundService() {
                return this.enableDownloadForegroundService;
            }

            public final Function2<y, Continuation<? super String>, Object> getNetworkRequestDelegate() {
                return this.networkRequestDelegate;
            }

            public final String getProjectId() {
                return this.projectId;
            }

            public final String getRegion() {
                return this.region;
            }

            public final String getSemAppVersion() {
                return this.semAppVersion;
            }

            public final String getSoc() {
                return this.soc;
            }

            public final Function0<Unit> getStartDownloadForegroundService() {
                return this.startDownloadForegroundService;
            }

            public final Function0<Unit> getStopDownloadForegroundService() {
                return this.stopDownloadForegroundService;
            }

            public final String getUrl() {
                return this.url;
            }

            public final String getUserId() {
                return this.userId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v17, types: [int] */
            /* JADX WARN: Type inference failed for: r0v37, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15, types: [int] */
            /* JADX WARN: Type inference failed for: r1v45 */
            /* JADX WARN: Type inference failed for: r1v46 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int r10 = ((((((((((((((this.aid.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.did.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.url.hashCode()) * 31) + this.projectId.hashCode()) * 31) + this.semAppVersion.hashCode()) * 31;
                boolean r11 = this.isDebug;
                ?? r12 = 1;
                ?? r13 = r11;
                if (r11 == false) goto L5;
                r13 = 1;
            L5:
                int r14 = (((r10 + r13) * 31) + this.allowBackgroundUpdate.hashCode()) * 31;
                g1<String> r15 = this.autoUpdateTrigger;
                int r16 = 0;
                if (r15 != null) goto L8;
                int r17 = 0;
            L9:
                int r18 = (((((r14 + r17) * 31) + this.autoCleanResourceInterval.hashCode()) * 31) + this.autoCleanResourceTotalGB.hashCode()) * 31;
                Function2<y, Continuation<? super String>, Object> r19 = this.networkRequestDelegate;
                if (r19 != null) goto L12;
                int r20 = 0;
            L13:
                int r21 = (((((((r18 + r20) * 31) + this.autoDeleteDebugPackage.hashCode()) * 31) + this.checkPackageResource.hashCode()) * 31) + this.allowNetworkRequest.hashCode()) * 31;
                String r22 = this.soc;
                if (r22 != null) goto L16;
                int r23 = 0;
            L17:
                int r24 = (r21 + r23) * 31;
                boolean r25 = this.enableDownloadForegroundService;
                if (r25 == true) goto L21;
                r12 = r25;
            L21:
                int r26 = (((((r24 + r12) * 31) + this.startDownloadForegroundService.hashCode()) * 31) + this.stopDownloadForegroundService.hashCode()) * 31;
                String r27 = this.region;
                if (r27 == null) goto L26;
                r16 = r27.hashCode();
            L26:
                return r26 + r16;
            L16:
                r23 = r22.hashCode();
                goto L17
            L12:
                r20 = r19.hashCode();
                goto L13
            L8:
                r17 = r15.hashCode();
                goto L9
            }

            public final boolean isDebug() {
                return this.isDebug;
            }

            public final void setDebug(boolean r10) {
                this.isDebug = r10;
            }

            public String toString() {
                return "AppConfig(aid=" + this.aid + ", appVersion=" + this.appVersion + ", channel=" + this.channel + ", did=" + this.did + ", userId=" + this.userId + ", url=" + this.url + ", projectId=" + this.projectId + ", semAppVersion=" + this.semAppVersion + ", isDebug=" + this.isDebug + ", allowBackgroundUpdate=" + this.allowBackgroundUpdate + ", autoUpdateTrigger=" + this.autoUpdateTrigger + ", autoCleanResourceInterval=" + this.autoCleanResourceInterval + ", autoCleanResourceTotalGB=" + this.autoCleanResourceTotalGB + ", networkRequestDelegate=" + this.networkRequestDelegate + ", autoDeleteDebugPackage=" + this.autoDeleteDebugPackage + ", checkPackageResource=" + this.checkPackageResource + ", allowNetworkRequest=" + this.allowNetworkRequest + ", soc=" + this.soc + ", enableDownloadForegroundService=" + this.enableDownloadForegroundService + ", startDownloadForegroundService=" + this.startDownloadForegroundService + ", stopDownloadForegroundService=" + this.stopDownloadForegroundService + ", region=" + this.region + ')';
            }
        }

        public static final class a implements d {
            a() {
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.d
            public boolean a(int r10, String r11, String r12) {
                return d.a.a(this, r10, r11, r12);
            }
        }

        public interface b {

            public static final class a {
                public static Object a(b r10, String r11, String r12, String r13, String r14, String r15, Continuation<? super Pair<Boolean, String>> r16) {
                    return new Pair(Boxing.boxBoolean(true), "");
                }

                public static boolean b(b r10) {
                    return false;
                }

                public static String c(b r10, String r11, String r12) {
                    Intrinsics.checkNotNullParameter(r11, "model");
                    Intrinsics.checkNotNullParameter(r12, "version");
                    return "";
                }

                public static boolean d(b r10, String r11, String r12) {
                    Intrinsics.checkNotNullParameter(r11, "model");
                    Intrinsics.checkNotNullParameter(r12, "version");
                    return false;
                }

                public static boolean e(b r10, String r11, String r12) {
                    Intrinsics.checkNotNullParameter(r11, "model");
                    Intrinsics.checkNotNullParameter(r12, "version");
                    return false;
                }

                public static Object f(b r10, Map<String, ? extends List<Pair<String, k>>> r11, Continuation<? super Unit> r12) {
                    return Unit.INSTANCE;
                }

                public static Object g(b r10, Collection<String> r11, Continuation<? super Unit> r12) {
                    return Unit.INSTANCE;
                }
            }

            Object a(String r10, String r11, String r12, String r13, String r14, Continuation<? super Pair<Boolean, String>> r15);

            boolean b();

            boolean c(String r10, String r11);

            Object d(Map<String, ? extends List<Pair<String, k>>> r10, Continuation<? super Unit> r11);

            String e(String r10, String r11);

            boolean isPresetDecrypted(String r10, String r11);

            Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11);
        }

        public interface c {
            Object a(String r10, Continuation<? super Unit> r11);

            void b(List<String> r10);

            r0<Unit> c();
        }

        public interface d {

            public static final class a {
                public static boolean a(d r10, int r11, String r12, String r13) {
                    Intrinsics.checkNotNullParameter(r12, "pkg");
                    Intrinsics.checkNotNullParameter(r13, "caller");
                    return true;
                }
            }

            boolean a(int r10, String r11, String r12);
        }

        public interface e {
            void a(com.obric.aikernel.res.update.a r10);

            void b(UpdateResult r10);

            void c(PackageUpdater.b r10, String r11, String r12);

            void d(h r10);
        }

        public static final class f implements b {
            f() {
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public Object a(String r10, String r11, String r12, String r13, String r14, Continuation<? super Pair<Boolean, String>> r15) {
                return b.a.a(this, r10, r11, r12, r13, r14, r15);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public boolean b() {
                return b.a.b(this);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public boolean c(String r10, String r11) {
                return b.a.d(this, r10, r11);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public Object d(Map<String, ? extends List<Pair<String, k>>> r10, Continuation<? super Unit> r11) {
                return b.a.f(this, r10, r11);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public String e(String r10, String r11) {
                return b.a.c(this, r10, r11);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public boolean isPresetDecrypted(String r10, String r11) {
                return b.a.e(this, r10, r11);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
            public Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11) {
                return b.a.g(this, r10, r11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PresmConfig(Context r10, String r11, String r12, AppConfig r13, String r14, String r15, String r16, com.obric.aikernel.runtime.utils.c r17, d r18, String r19, Map<String, ? extends Set<String>> r110, boolean r111, int r112) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "rootDir");
            Intrinsics.checkNotNullParameter(r12, "resRootDir");
            Intrinsics.checkNotNullParameter(r13, "appConfig");
            Intrinsics.checkNotNullParameter(r14, "pyVmVersion");
            Intrinsics.checkNotNullParameter(r18, "packageActionInjector");
            this.context = r10;
            this.rootDir = r11;
            this.resRootDir = r12;
            this.appConfig = r13;
            this.pyVmVersion = r14;
            this.assertRootDir = r15;
            this.deviceRootDir = r16;
            this.logger = r17;
            this.packageActionInjector = r18;
            this.preInitPackageName = r19;
            this.presetLibraries = r110;
            this.useObricDownloader = r111;
            this.parallelDownloadNum = r112;
            this.memSize$delegate = LazyKt.lazy(PackageResourceManager$PresmConfig$memSize$2.INSTANCE);
            this.decryptFeature = new f();
            this.isInferProcess = PackageResourceManager$PresmConfig$isInferProcess$1.INSTANCE;
            if (r17 == null) goto L5;
            com.obric.aikernel.runtime.utils.d.f5417a.j(r17);
        L5:
            if (r111 == false) goto L8;
            ObricDownloadManager.f4976a.d(this);
            return;
        }

        public /* synthetic */ PresmConfig(Context r18, String r19, String r20, AppConfig r21, String r22, String r23, String r24, com.obric.aikernel.runtime.utils.c r25, d r26, String r27, Map r28, boolean r29, int r30, int r31, DefaultConstructorMarker r32) {
            if ((r31 & 32) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r31 & 64) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r31 & 128) == 0) goto L13;
            com.obric.aikernel.runtime.utils.c r12 = null;
        L15:
            if ((r31 & 256) == 0) goto L17;
            d r13 = new a();
        L19:
            if ((r31 & 512) == 0) goto L21;
            String r14 = null;
        L23:
            if ((r31 & 1024) == 0) goto L25;
            Map r15 = null;
        L27:
            if ((r31 & 2048) == 0) goto L29;
            boolean r16 = false;
        L31:
            if ((r31 & 4096) == 0) goto L33;
            int r17 = 4;
        L34:
            this(r18, r19, r20, r21, r22, r10, r11, r12, r13, r14, r15, r16, r17);
            return;
        L33:
            r17 = r30;
            goto L34
        L29:
            r16 = r29;
            goto L31
        L25:
            r15 = r28;
            goto L27
        L21:
            r14 = r27;
            goto L23
        L17:
            r13 = r26;
            goto L19
        L13:
            r12 = r25;
            goto L15
        L9:
            r11 = r24;
            goto L11
        L5:
            r10 = r23;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PresmConfig copy$default(PresmConfig r14, Context r15, String r16, String r17, AppConfig r18, String r19, String r20, String r21, com.obric.aikernel.runtime.utils.c r22, d r23, String r24, Map r25, boolean r26, int r27, int r28, Object r29) {
            if ((r28 & 1) == 0) goto L5;
            Context r10 = r14.context;
        L7:
            if ((r28 & 2) == 0) goto L9;
            String r11 = r14.rootDir;
        L11:
            if ((r28 & 4) == 0) goto L13;
            String r12 = r14.resRootDir;
        L15:
            if ((r28 & 8) == 0) goto L17;
            AppConfig r13 = r14.appConfig;
        L19:
            if ((r28 & 16) == 0) goto L21;
            String r30 = r14.pyVmVersion;
        L23:
            if ((r28 & 32) == 0) goto L25;
            String r31 = r14.assertRootDir;
        L27:
            if ((r28 & 64) == 0) goto L29;
            String r32 = r14.deviceRootDir;
        L31:
            if ((r28 & 128) == 0) goto L33;
            com.obric.aikernel.runtime.utils.c r33 = r14.logger;
        L35:
            if ((r28 & 256) == 0) goto L37;
            d r110 = r14.packageActionInjector;
        L39:
            if ((r28 & 512) == 0) goto L41;
            String r111 = r14.preInitPackageName;
        L43:
            if ((r28 & 1024) == 0) goto L45;
            Map r112 = r14.presetLibraries;
        L47:
            if ((r28 & 2048) == 0) goto L49;
            boolean r113 = r14.useObricDownloader;
        L51:
            if ((r28 & 4096) == 0) goto L53;
            int r34 = r14.parallelDownloadNum;
        L55:
            return r14.copy(r10, r11, r12, r13, r30, r31, r32, r33, r110, r111, r112, r113, r34);
        L53:
            r34 = r27;
            goto L55
        L49:
            r113 = r26;
            goto L51
        L45:
            r112 = r25;
            goto L47
        L41:
            r111 = r24;
            goto L43
        L37:
            r110 = r23;
            goto L39
        L33:
            r33 = r22;
            goto L35
        L29:
            r32 = r21;
            goto L31
        L25:
            r31 = r20;
            goto L27
        L21:
            r30 = r19;
            goto L23
        L17:
            r13 = r18;
            goto L19
        L13:
            r12 = r17;
            goto L15
        L9:
            r11 = r16;
            goto L11
        L5:
            r10 = r15;
            goto L7
        }

        public final Context component1() {
            return this.context;
        }

        public final String component10() {
            return this.preInitPackageName;
        }

        public final Map<String, Set<String>> component11() {
            return this.presetLibraries;
        }

        public final boolean component12() {
            return this.useObricDownloader;
        }

        public final int component13() {
            return this.parallelDownloadNum;
        }

        public final String component2() {
            return this.rootDir;
        }

        public final String component3() {
            return this.resRootDir;
        }

        public final AppConfig component4() {
            return this.appConfig;
        }

        public final String component5() {
            return this.pyVmVersion;
        }

        public final String component6() {
            return this.assertRootDir;
        }

        public final String component7() {
            return this.deviceRootDir;
        }

        public final com.obric.aikernel.runtime.utils.c component8() {
            return this.logger;
        }

        public final d component9() {
            return this.packageActionInjector;
        }

        public final PresmConfig copy(Context r16, String r17, String r18, AppConfig r19, String r20, String r21, String r22, com.obric.aikernel.runtime.utils.c r23, d r24, String r25, Map<String, ? extends Set<String>> r26, boolean r27, int r28) {
            Intrinsics.checkNotNullParameter(r16, "context");
            Intrinsics.checkNotNullParameter(r17, "rootDir");
            Intrinsics.checkNotNullParameter(r18, "resRootDir");
            Intrinsics.checkNotNullParameter(r19, "appConfig");
            Intrinsics.checkNotNullParameter(r20, "pyVmVersion");
            Intrinsics.checkNotNullParameter(r24, "packageActionInjector");
            return new PresmConfig(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof PresmConfig) == true) goto L8;
            return false;
        L8:
            PresmConfig r11 = (PresmConfig) r10;
            if (Intrinsics.areEqual(this.context, r11.context) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rootDir, r11.rootDir) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.resRootDir, r11.resRootDir) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.appConfig, r11.appConfig) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.pyVmVersion, r11.pyVmVersion) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.assertRootDir, r11.assertRootDir) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.deviceRootDir, r11.deviceRootDir) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.logger, r11.logger) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.packageActionInjector, r11.packageActionInjector) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.preInitPackageName, r11.preInitPackageName) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.presetLibraries, r11.presetLibraries) == true) goto L42;
            return false;
        L42:
            if (this.useObricDownloader == r11.useObricDownloader) goto L45;
            return false;
        L45:
            if (this.parallelDownloadNum == r11.parallelDownloadNum) goto L47;
            return false;
        L47:
            return true;
        }

        public final AppConfig getAppConfig() {
            return this.appConfig;
        }

        public final String getAssertRootDir() {
            return this.assertRootDir;
        }

        public final Context getContext() {
            return this.context;
        }

        public final com.obric.aikernel.res.installer.a getCustomInstaller() {
            return this.customInstaller;
        }

        public final b getDecryptFeature() {
            return this.decryptFeature;
        }

        public final String getDeviceRootDir() {
            return this.deviceRootDir;
        }

        public final c8.c getDynamicResProxy() {
            return this.dynamicResProxy;
        }

        public final com.obric.aikernel.runtime.utils.c getLogger() {
            return this.logger;
        }

        public final int getMemSize() {
            return ((Number) this.memSize$delegate.getValue()).intValue();
        }

        public final c getNativeLibLifeCycle() {
            return this.nativeLibLifeCycle;
        }

        public final d getPackageActionInjector() {
            return this.packageActionInjector;
        }

        public final int getParallelDownloadNum() {
            return this.parallelDownloadNum;
        }

        public final String getPreInitPackageName() {
            return this.preInitPackageName;
        }

        public final Map<String, Set<String>> getPresetLibraries() {
            return this.presetLibraries;
        }

        public final String getPyVmVersion() {
            return this.pyVmVersion;
        }

        public final String getResRootDir() {
            return this.resRootDir;
        }

        public final String getRootDir() {
            return this.rootDir;
        }

        public final e getUpdateListener() {
            return this.updateListener;
        }

        public final boolean getUseAIKernelModel() {
            return this.useAIKernelModel;
        }

        public final boolean getUseObricDownloader() {
            return this.useObricDownloader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24, types: [int] */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v30 */
        public int hashCode() {
            int r10 = ((((((((this.context.hashCode() * 31) + this.rootDir.hashCode()) * 31) + this.resRootDir.hashCode()) * 31) + this.appConfig.hashCode()) * 31) + this.pyVmVersion.hashCode()) * 31;
            String r11 = this.assertRootDir;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.deviceRootDir;
            if (r15 != null) goto L9;
            int r16 = 0;
        L10:
            int r17 = (r14 + r16) * 31;
            com.obric.aikernel.runtime.utils.c r18 = this.logger;
            if (r18 != null) goto L13;
            int r19 = 0;
        L14:
            int r20 = (((r17 + r19) * 31) + this.packageActionInjector.hashCode()) * 31;
            String r21 = this.preInitPackageName;
            if (r21 != null) goto L17;
            int r22 = 0;
        L18:
            int r23 = (r20 + r22) * 31;
            Map<String, Set<String>> r24 = this.presetLibraries;
            if (r24 == null) goto L22;
            r12 = r24.hashCode();
        L22:
            int r25 = (r23 + r12) * 31;
            boolean r26 = this.useObricDownloader;
            ?? r27 = r26;
            if (r26 == false) goto L26;
            r27 = 1;
        L26:
            return ((r25 + r27) * 31) + Integer.hashCode(this.parallelDownloadNum);
        L17:
            r22 = r21.hashCode();
            goto L18
        L13:
            r19 = r18.hashCode();
            goto L14
        L9:
            r16 = r15.hashCode();
            goto L10
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public final Function0<Boolean> isInferProcess() {
            return this.isInferProcess;
        }

        public final void setCustomInstaller(com.obric.aikernel.res.installer.a r10) {
            this.customInstaller = r10;
        }

        public final void setDecryptFeature(b r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.decryptFeature = r10;
        }

        public final void setDynamicResProxy(c8.c r10) {
            this.dynamicResProxy = r10;
        }

        public final void setInferProcess(Function0<Boolean> r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.isInferProcess = r10;
        }

        public final void setNativeLibLifeCycle(c r10) {
            this.nativeLibLifeCycle = r10;
        }

        public final void setUpdateListener(e r10) {
            this.updateListener = r10;
        }

        public final void setUseAIKernelModel(boolean r10) {
            this.useAIKernelModel = r10;
        }

        public String toString() {
            return "PresmConfig(context=" + this.context + ", rootDir=" + this.rootDir + ", resRootDir=" + this.resRootDir + ", appConfig=" + this.appConfig + ", pyVmVersion=" + this.pyVmVersion + ", assertRootDir=" + this.assertRootDir + ", deviceRootDir=" + this.deviceRootDir + ", logger=" + this.logger + ", packageActionInjector=" + this.packageActionInjector + ", preInitPackageName=" + this.preInitPackageName + ", presetLibraries=" + this.presetLibraries + ", useObricDownloader=" + this.useObricDownloader + ", parallelDownloadNum=" + this.parallelDownloadNum + ')';
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$clean$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {307}, m = "clean", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        AnonymousClass1(PackageResourceManager r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clean(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$cleanCache$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {}, l = {312}, m = "cleanCache", n = {}, s = {})
    static final class C03791 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03791(PackageResourceManager r10, Continuation<? super C03791> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.cleanCache(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getAllPackageConfigs$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {}, l = {121}, m = "getAllPackageConfigs", n = {}, s = {})
    static final class C03801 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03801(PackageResourceManager r10, Continuation<? super C03801> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAllPackageConfigs(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getDownloadingSummary$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0}, l = {326}, m = "getDownloadingSummary", n = {CommonConsts.COUNT_TYPE, "totalSpeed"}, s = {"L$0", "L$1"})
    static final class C03811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03811(PackageResourceManager r10, Continuation<? super C03811> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getDownloadingSummary(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageConfig$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {123}, m = "getPackageConfig", n = {ActivityLifecycle.NAME}, s = {"L$0"})
    static final class C03821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03821(PackageResourceManager r10, Continuation<? super C03821> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageConfig(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageUpdateInfo$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {118}, m = "getPackageUpdateInfo", n = {"biz"}, s = {"L$0"})
    static final class C03831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03831(PackageResourceManager r10, Continuation<? super C03831> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageUpdateInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageUpdateProgress$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {125}, m = "getPackageUpdateProgress", n = {"biz"}, s = {"L$0"})
    static final class C03841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03841(PackageResourceManager r10, Continuation<? super C03841> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageUpdateProgress(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$pushDebugDistributeInfo$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 2}, l = {299, 299, 301, 301}, m = "pushDebugDistributeInfo", n = {"biz", "info"}, s = {"L$0", "L$0"})
    static final class C03851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03851(PackageResourceManager r10, Continuation<? super C03851> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.pushDebugDistributeInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$resumeBlockedUpdateTasksIfNeed$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {339}, m = "resumeBlockedUpdateTasksIfNeed", n = {"trigger"}, s = {"L$0"})
    static final class C03861 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03861(PackageResourceManager r10, Continuation<? super C03861> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.resumeBlockedUpdateTasksIfNeed(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updateAll$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {265, 267}, m = "updateAll", n = {"caller", "packageNames", "$this$updateAll_u24lambda_u2414", "background", "caller", "$this$updateAll_u24lambda_u2414", "background"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "Z$0"})
    static final class C03871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03871(PackageResourceManager r10, Continuation<? super C03871> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateAll(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updateByForeground$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {132, 132}, m = "updateByForeground", n = {"this", ActivityLifecycle.NAME, "caller", "loraType", "force", "this", ActivityLifecycle.NAME}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
    static final class C03881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03881(PackageResourceManager r10, Continuation<? super C03881> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateByForeground(null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updatePackage$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {151, 151}, m = "updatePackage", n = {"this", ActivityLifecycle.NAME, "caller", "loraType", "background", "force", "this", ActivityLifecycle.NAME}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1"})
    static final class C03891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C03891(PackageResourceManager r10, Continuation<? super C03891> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updatePackage(null, null, false, false, null, this);
        }
    }

    static {
        Companion = new a(null);
    }

    public PackageResourceManager(PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r12, "presmConfig");
        PrmContext r10 = new PrmContext(r12, this);
        this.context = r10;
        this.runningDepsGetter = PackageResourceManager$runningDepsGetter$1.INSTANCE;
        PackagesListener r11 = new PackagesListener(r10.getScope$resource_manager_release());
        this.packagesListener = r11;
        MetadataController r13 = new MetadataController(r10, r11);
        this.metadataController = r13;
        DownloadController r14 = new DownloadController(r10);
        this.globalDownloadController = r14;
        NativeLibVersionPolicy.INSTANCE.init(r10);
        r10.setMetadataCtrl$resource_manager_release(r13);
        r10.setDownloadCtrl$resource_manager_release(r14);
        File r15 = new File(r12.getRootDir());
        if (r15.exists() == true) goto L5;
        r15.mkdirs();
    L5:
        r13.t();
        d.f5417a.d(TAG, "init config: " + r12);
        ArrayList r16 = new ArrayList();
        com.obric.aikernel.res.installer.a r17 = r10.getConfig().getCustomInstaller();
        if (r17 == null) goto L8;
        r16.add(r17);
    L8:
        String r18 = r10.getConfig().getAssertRootDir();
        boolean r19 = true;
        if (r18 != null) goto L11;
    L19:
        String r20 = r10.getConfig().getDeviceRootDir();
        if (r20 != null) goto L22;
    L30:
        this.fusionInstaller = new FusionInstaller(r16);
        this.updater = kotlinx.coroutines.h.b(m0.a(z0.a()), null, null, new PackageResourceManager$updater$1(this, null), 3, null);
        return;
    L22:
        if (r20.length() > 0) goto L25;
        r19 = false;
    L25:
        if (r19 == true) goto L28;
        r20 = null;
    L28:
        if (r20 == null) goto L30;
        r16.add(new DeviceStorageScanner(r20));
        goto L30
    L11:
        if (r18.length() <= 0) goto L13;
        boolean r21 = true;
    L14:
        if (r21 == true) goto L17;
        r18 = null;
    L17:
        if (r18 == null) goto L19;
        AssetManager r22 = r10.getConfig().getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(r22, "context.config.context.assets");
        r16.add(new AssetsScanner(r22, r18));
        goto L19
    L13:
        r21 = false;
        goto L14
    }

    public static final /* synthetic */ MetadataController access$getMetadataController$p(PackageResourceManager r10) {
        return r10.metadataController;
    }

    public static /* synthetic */ void disable$default(PackageResourceManager r10, String r11, String r12, String r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L5;
        r14 = false;
    L5:
        r10.disable(r11, r12, r13, r14);
    }

    private final String summarizeUpdateResults(Map<String, UpdateResult> r12) {
        Collection<UpdateResult> r11 = r12.values();
        int r10 = 0;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        if (((UpdateResult) r13.next()).getSuccess() == false) goto L9;
        r10 = r10 + 1;
        if (r10 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Collection<UpdateResult> r14 = r12.values();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Object r17 = r16.next();
        if (((UpdateResult) r17).getSuccess() == true) goto L17;
        r15.add(r17);
        goto L17
    L22:
        return "resultCount=" + r12.size() + " success=" + r10 + " failed=" + (r12.size() - r10) + " failureSummary=[" + CollectionsKt.joinToString$default(r15, null, null, null, 5, null, PackageResourceManager$summarizeUpdateResults$failureSummary$2.INSTANCE, 23, null) + ']';
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    public static /* synthetic */ void uninstall$default(PackageResourceManager r10, String r11, String r12, String r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L5;
        r14 = false;
    L5:
        r10.uninstall(r11, r12, r13, r14);
    }

    public static /* synthetic */ Object updateAll$default(PackageResourceManager r10, String r11, boolean r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = DEBUG_CALLER;
    L6:
        return r10.updateAll(r11, r12, r13);
    }

    public static /* synthetic */ Object updateByForeground$default(PackageResourceManager r10, String r11, String r12, boolean r13, String r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        r13 = false;
    L5:
        boolean r18 = r13;
        if ((r16 & 8) == 0) goto L9;
        r14 = "";
    L9:
        return r10.updateByForeground(r11, r12, r18, r14, r15);
    }

    public static /* synthetic */ Object updatePackage$default(PackageResourceManager r10, String r11, String r12, boolean r13, boolean r14, String r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = false;
    L5:
        boolean r19 = r14;
        if ((r17 & 16) == 0) goto L9;
        r15 = "";
    L9:
        return r10.updatePackage(r11, r12, r13, r19, r15, r16);
    }

    public final Object clean(Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r11 = (AnonymousClass1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        PackageResourceManager this = (PackageResourceManager) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        PackageUpdater.j((PackageUpdater) r13, false, 1, null);
        this.metadataController.h();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0<PackageUpdater> r16 = this.updater;
        r11.L$0 = this;
        r11.label = 1;
        r13 = r16.r(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final Object cleanCache(Continuation<? super Unit> r10) {
        if ((r10 instanceof C03791) == false) goto L7;
        C03791 r11 = (C03791) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        ((PackageUpdater) r13).i(false);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0<PackageUpdater> r16 = this.updater;
        r11.label = 1;
        r13 = r16.r(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new C03791(this, r10);
        goto L8
    }

    public final Object cleanDebug(Continuation<? super Unit> r10) {
        this.metadataController.c();
        return Unit.INSTANCE;
    }

    public final void disable(String r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Map<String, b> r13 = this.metadataController.p().b(r10, r11);
        Function1<b, Unit> r14 = new PackageResourceManager$disable$packageAction$1(this, r11, r12);
        if (r11.length() != 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L20;
        MetadataController.c r16 = this.metadataController.p().a().get("package");
        if (r16 == null) goto L26;
        Map<String, Map<String, b>> r17 = r16.a();
        if (r17 == null) goto L27;
        Collection<Map<String, b>> r18 = r17.values();
        if (r18 == null) goto L28;
        Iterator<T> r19 = r18.iterator();
    L15:
        if (r19.hasNext() == false) goto L30;
        Iterator r20 = ((Map) r19.next()).values().iterator();
    L18:
        if (r20.hasNext() == false) goto L15;
        b r21 = (b) r20.next();
        r21.l();
        r14.invoke(r21);
        goto L18
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L20:
        b r22 = r13.get(r12);
        if (r22 == null) goto L29;
        r22.l();
        r14.invoke(r22);
        return;
    L29:
        return;
    L5:
        r15 = false;
        goto L6
    }

    public final void disable(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        if (Intrinsics.areEqual(r10, "package") == false) goto L6;
        this.metadataController.j(r11, r12, r13);
        return;
    }

    public final void enable(String r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Map<String, b> r13 = this.metadataController.p().b(r10, r11);
        Function1<b, Unit> r14 = new PackageResourceManager$enable$packageAction$1(this, r11, r12);
        if (r11.length() != 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L20;
        MetadataController.c r16 = this.metadataController.p().a().get("package");
        if (r16 == null) goto L26;
        Map<String, Map<String, b>> r17 = r16.a();
        if (r17 == null) goto L27;
        Collection<Map<String, b>> r18 = r17.values();
        if (r18 == null) goto L28;
        Iterator<T> r19 = r18.iterator();
    L15:
        if (r19.hasNext() == false) goto L30;
        Iterator r20 = ((Map) r19.next()).values().iterator();
    L18:
        if (r20.hasNext() == false) goto L15;
        r14.invoke((b) r20.next());
        goto L18
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L20:
        b r21 = r13.get(r12);
        if (r21 == null) goto L29;
        r14.invoke(r21);
        return;
    L29:
        return;
    L5:
        r15 = false;
        goto L6
    }

    public final void flushPackageUsage() {
        this.metadataController.n();
    }

    public final Object getAllPackageConfigs(Continuation<? super List<e>> r10) {
        if ((r10 instanceof C03801) == false) goto L7;
        C03801 r11 = (C03801) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((PackageUpdater) r13).m();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0<PackageUpdater> r16 = this.updater;
        r11.label = 1;
        r13 = r16.r(r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new C03801(this, r10);
        goto L8
    }

    public final AIPackage getAvailPackage(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        AIPackage r11 = this.metadataController.q(r10);
        if (r11 == null) goto L8;
        if (r11.H() == false) goto L8;
        return r11;
    L8:
        return null;
    }

    public final PrmContext getContext() {
        return this.context;
    }

    public final Object getDownloadInfos(Continuation<? super List<k>> r10) {
        return this.context.getDownloadCtrl$resource_manager_release().o(r10);
    }

    public final Object getDownloadingSummary(Continuation<? super k> r10) {
        if ((r10 instanceof C03811) == false) goto L7;
        C03811 r11 = (C03811) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Ref.DoubleRef r16 = (Ref.DoubleRef) r11.L$1;
        Ref.IntRef r17 = (Ref.IntRef) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        ArrayList r18 = new ArrayList();
        Iterator r19 = ((Iterable) r13).iterator();
    L20:
        if (r19.hasNext() == false) goto L24;
        Object r20 = r19.next();
        if (((k) r20).s("downloading").a() == false) goto L20;
        r18.add(r20);
        goto L20
    L24:
        Iterator r21 = r18.iterator();
    L26:
        if (r21.hasNext() == false) goto L28;
        k r22 = (k) r21.next();
        r17.element++;
        r16.element += r22.s("speed").b();
        goto L26
    L28:
        k r23 = new k();
        r23.o(CommonConsts.COUNT_TYPE, Boxing.boxInt(r17.element));
        r23.o("speed", Boxing.boxDouble(r16.element));
        return r23;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Ref.IntRef r24 = new Ref.IntRef();
        Ref.DoubleRef r25 = new Ref.DoubleRef();
        r11.L$0 = r24;
        r11.L$1 = r25;
        r11.label = 1;
        Object r26 = getDownloadInfos(r11);
        if (r26 != r14) goto L17;
        return r14;
    L17:
        r17 = r24;
        r13 = r26;
        r16 = r25;
    L7:
        r11 = new C03811(this, r10);
        goto L8
    }

    public final FusionInstaller getFusionInstaller() {
        return this.fusionInstaller;
    }

    public final AIPackage getPackage(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.metadataController.q(r10);
    }

    public final Object getPackageConfig(String r10, Continuation<? super e> r11) {
        if ((r11 instanceof C03821) == false) goto L7;
        C03821 r12 = (C03821) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        return ((PackageUpdater) r14).o(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0<PackageUpdater> r17 = this.updater;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new C03821(this, r11);
        goto L8
    }

    public final Collection<AIPackage> getPackageMap() {
        return this.metadataController.r().values();
    }

    public final Object getPackageUpdateInfo(String r10, Continuation<? super UpdateResult> r11) {
        if ((r11 instanceof C03831) == false) goto L7;
        C03831 r12 = (C03831) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        return ((PackageUpdater) r14).q(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0<PackageUpdater> r17 = this.updater;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new C03831(this, r11);
        goto L8
    }

    public final Object getPackageUpdateProgress(String r10, Continuation<? super Float> r11) {
        if ((r11 instanceof C03841) == false) goto L7;
        C03841 r12 = (C03841) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        return Boxing.boxFloat(((PackageUpdater) r14).r(r10));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0<PackageUpdater> r17 = this.updater;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new C03841(this, r11);
        goto L8
    }

    public final Function0<Set<String>> getRunningDepsGetter() {
        return this.runningDepsGetter;
    }

    public final void installFromPath(String r10) {
        Intrinsics.checkNotNullParameter(r10, "prsPath");
        this.context.runInstaller(new DeviceStorageScanner(r10));
    }

    public final void markPackageCorrupt(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        this.metadataController.z(r10, r11);
    }

    public final Object pushDebugDistributeInfo(k r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof C03851) == false) goto L7;
        C03851 r10 = (C03851) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        C03851 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 != 4) goto L16;
        ResultKt.throwOnFailure(r13);
    L36:
        Unit r16 = Unit.INSTANCE;
    L38:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        k r17 = (k) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L33:
        r12.L$0 = null;
        r12.label = 4;
        if (((PackageUpdater) r13).v(r17, r12) != r14) goto L36;
        return r14;
    L18:
        ResultKt.throwOnFailure(r13);
        goto L38
    L19:
        String r18 = (String) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        List r19 = CollectionsKt.listOf(r18);
        String r110 = "push_debug";
        PackageUpdater.b r20 = new PackageUpdater.b(r110, 200, false, false, false, false, false, 60, null);
        r12.L$0 = null;
        r12.label = 2;
        if (PackageUpdater.z((PackageUpdater) r13, r19, r20, null, r12, 4, null) != r14) goto L38;
        return r14;
    L20:
        ResultKt.throwOnFailure(r13);
        k r23 = r21.u("businesses");
        Set<String> r24 = r23.x();
        Intrinsics.checkNotNullExpressionValue(r24, "it.keySet()");
        String r25 = (String) CollectionsKt.first(r24);
        boolean r26 = Intrinsics.areEqual(r23.u(r25).u("add").u("dependency").s("py_vm").h(), this.context.getConfig().getPyVmVersion());
        r0<PackageUpdater> r27 = this.updater;
        if (r26 == true) goto L29;
        r12.L$0 = r25;
        r12.label = 1;
        r13 = r27.r(r12);
        if (r13 != r14) goto L25;
        return r14;
    L25:
        r18 = r25;
        goto L26
    L29:
        r12.L$0 = r21;
        r12.label = 3;
        r13 = r27.r(r12);
        if (r13 != r14) goto L32;
        return r14;
    L32:
        r17 = r21;
    L7:
        r10 = new C03851(this, r22);
        goto L8
    }

    public final r0<Unit> refreshAllPackageState() {
        return this.metadataController.B();
    }

    public final void refreshPackageState(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.metadataController.C(r10);
    }

    public final void registerPackageObserver(com.obric.aikernel.res.metadata.a r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.packagesListener.d(r10);
    }

    public final Object resumeBlockedUpdateTasksIfNeed(String r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C03861) == false) goto L7;
        C03861 r12 = (C03861) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        ((PackageUpdater) r14).w(r10);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0<PackageUpdater> r17 = this.updater;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new C03861(this, r11);
        goto L8
    }

    public final void setRunningDepsGetter(Function0<? extends Set<String>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.runningDepsGetter = r10;
    }

    public final void uninstall(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        if (Intrinsics.areEqual(r10, "package") == false) goto L6;
        this.metadataController.F(r11, r12, r13);
        return;
    }

    public final void unregisterPackageObserver(com.obric.aikernel.res.metadata.a r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.packagesListener.e(r10);
    }

    public final Object updateAll(String r28, boolean r29, Continuation<? super Map<String, UpdateResult>> r30) {
        PackageResourceManager r10 = this;
        String r11 = r28;
        boolean r12 = r29;
        if ((r30 instanceof C03871) == false) goto L7;
        C03871 r13 = (C03871) r30;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        C03871 r15 = r13;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        boolean r19 = false;
        if (r18 == 0) goto L24;
        if (r18 == 1) goto L19;
        if (r18 != 2) goto L18;
        boolean r20 = r15.Z$0;
        r10 = (PackageResourceManager) r15.L$1;
        String r21 = (String) r15.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
        Object r22 = r16;
        boolean r23 = true;
        r12 = r20;
        r11 = r21;
    L44:
        Map<String, UpdateResult> r24 = (Map) r22;     // Catch: Throwable -> L49
        d r25 = d.f5417a;     // Catch: Throwable -> L49
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L49
        r26.append("updateAll end caller=");     // Catch: Throwable -> L49
        r26.append(r11);     // Catch: Throwable -> L49
        r26.append(" background=");     // Catch: Throwable -> L49
        if (r12 == false) goto L47;
        r19 = r23;
    L47:
        r26.append(r19);     // Catch: Throwable -> L49
        r26.append(' ');     // Catch: Throwable -> L49
        r26.append(r10.summarizeUpdateResults(r24));     // Catch: Throwable -> L49
        r25.i(TAG, r26.toString());     // Catch: Throwable -> L49
        Object r27 = Result.m32constructorimpl((Map) r22);     // Catch: Throwable -> L49
    L51:
        Throwable r31 = Result.m35exceptionOrNullimpl(r27);
        if (r31 == null) goto L54;
        d.f5417a.f(TAG, "updateAll failed caller=" + r11 + " background=" + r12 + ' ' + ExceptionsKt.stackTraceToString(r31));
    L54:
        ResultKt.throwOnFailure(r27);
        return r27;
    L49:
        Throwable th = th;
    L50:
        Result.Companion r32 = Result.Companion;
        r27 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L15:
        th = th;
        r12 = r20;
        r11 = r21;
        goto L50
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r33 = r15.Z$0;
        r10 = (PackageResourceManager) r15.L$2;
        List<String> r34 = (List) r15.L$1;
        String r35 = (String) r15.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L22
        List<String> r36 = r34;
        r12 = r33;
        r11 = r35;
    L33:
        PackageUpdater r37 = (PackageUpdater) r16;     // Catch: Throwable -> L49
        d r38 = d.f5417a;     // Catch: Throwable -> L49
        StringBuilder r39 = new StringBuilder();     // Catch: Throwable -> L49
        r39.append("updateAll enter updater.update caller=");     // Catch: Throwable -> L49
        r39.append(r11);     // Catch: Throwable -> L49
        r39.append(" background=");     // Catch: Throwable -> L49
        if (r12 == false) goto L36;
        boolean r110 = true;
    L37:
        r39.append(r110);     // Catch: Throwable -> L49
        r38.i(TAG, r39.toString());     // Catch: Throwable -> L49
        int r111 = 0;
        boolean r112 = true;
        boolean r210 = true;
        boolean r211 = false;
        boolean r212 = false;
        if (r12 == false) goto L40;
        boolean r213 = true;
    L41:
        PackageUpdater.b r40 = new PackageUpdater.b(r11, r111, r112, r210, r211, r212, r213, 50, null);     // Catch: Throwable -> L49
        r15.L$0 = r11;     // Catch: Throwable -> L49
        r15.L$1 = r10;     // Catch: Throwable -> L49
        r15.L$2 = null;     // Catch: Throwable -> L49
        r15.Z$0 = r12;     // Catch: Throwable -> L49
        r15.label = 2;     // Catch: Throwable -> L49
        r23 = true;
        r22 = PackageUpdater.z(r37, r36, r40, null, r15, 4, null);     // Catch: Throwable -> L49
        if (r22 != r17) goto L44;
        return r17;
    L40:
        r213 = false;
        goto L41
    L36:
        r110 = false;
    L22:
        th = th;
        r12 = r33;
        r11 = r35;
        goto L50
    L24:
        ResultKt.throwOnFailure(r16);
        List<String> r41 = r10.metadataController.o();
        d r42 = d.f5417a;
        r42.i(TAG, "updateAll start caller=" + r11 + " background=" + r12 + " packageCount=" + r41.size() + " packages=" + CollectionsKt.joinToString$default(r41, null, null, null, 10, null, null, 55, null));
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L49
        StringBuilder r44 = new StringBuilder();     // Catch: Throwable -> L49
        r44.append("updateAll awaiting updater caller=");     // Catch: Throwable -> L49
        r44.append(r11);     // Catch: Throwable -> L49
        r44.append(" background=");     // Catch: Throwable -> L49
        if (r12 == false) goto L28;
        boolean r45 = true;
    L29:
        r44.append(r45);     // Catch: Throwable -> L49
        r42.i(TAG, r44.toString());     // Catch: Throwable -> L49
        r0<PackageUpdater> r46 = r10.updater;     // Catch: Throwable -> L49
        r15.L$0 = r11;     // Catch: Throwable -> L49
        r15.L$1 = r41;     // Catch: Throwable -> L49
        r15.L$2 = r10;     // Catch: Throwable -> L49
        r15.Z$0 = r12;     // Catch: Throwable -> L49
        r15.label = 1;     // Catch: Throwable -> L49
        Object r47 = r46.r(r15);     // Catch: Throwable -> L49
        if (r47 != r17) goto L32;
        return r17;
    L32:
        r36 = r41;
        r16 = r47;
        goto L33
    L28:
        r45 = false;
    L7:
        r13 = new C03871(r10, r30);
        goto L8
    }

    public final Object updateByForeground(String r24, String r25, boolean r26, String r27, Continuation<? super AIPackage> r28) {
        PackageResourceManager r10 = this;
        if ((r28 instanceof C03881) == false) goto L7;
        C03881 r11 = (C03881) r28;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        String r16 = (String) r11.L$1;
        PackageResourceManager r17 = (PackageResourceManager) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L25:
        return r17.getPackage(r16);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r18 = r11.Z$0;
        String r19 = (String) r11.L$3;
        String r20 = (String) r11.L$2;
        String r21 = (String) r11.L$1;
        PackageResourceManager r22 = (PackageResourceManager) r11.L$0;
        ResultKt.throwOnFailure(r13);
        boolean r110 = r18;
        r10 = r22;
        Object r23 = r13;
        String r29 = r19;
        String r30 = r21;
        String r31 = r20;
    L20:
        List<String> r111 = CollectionsKt.listOf(r30);
        PackageUpdater.b r112 = new PackageUpdater.b(r31, 100, false, r110, false, false, false, 52, null);
        r11.L$0 = r10;
        r11.L$1 = r30;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.label = 2;
        if (((PackageUpdater) r23).y(r111, r112, r29, r11) != r14) goto L23;
        return r14;
    L23:
        r17 = r10;
        r16 = r30;
        goto L25
    L16:
        ResultKt.throwOnFailure(r13);
        r0<PackageUpdater> r32 = r10.updater;
        r11.L$0 = r10;
        r30 = r24;
        r11.L$1 = r30;
        r31 = r25;
        r11.L$2 = r31;
        r11.L$3 = r27;
        r11.Z$0 = r26;
        r11.label = 1;
        Object r33 = r32.r(r11);
        if (r33 != r14) goto L19;
        return r14;
    L19:
        r23 = r33;
        r29 = r27;
        r110 = r26;
    L7:
        r11 = new C03881(r10, r28);
        goto L8
    }

    public final Object updatePackage(String r21, String r22, boolean r23, boolean r24, String r25, Continuation<? super AIPackage> r26) {
        if ((r26 instanceof C03891) == false) goto L7;
        C03891 r10 = (C03891) r26;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        String r15 = (String) r10.L$1;
        PackageResourceManager r16 = (PackageResourceManager) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        return r16.getPackage(r15);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r17 = r10.Z$1;
        boolean r18 = r10.Z$0;
        String r19 = (String) r10.L$3;
        String r20 = (String) r10.L$2;
        String r27 = (String) r10.L$1;
        PackageResourceManager r28 = (PackageResourceManager) r10.L$0;
        ResultKt.throwOnFailure(r12);
        boolean r110 = r17;
        boolean r111 = r18;
        String r112 = r20;
        String r29 = r27;
    L20:
        List<String> r30 = CollectionsKt.listOf(r29);
        PackageUpdater.b r31 = new PackageUpdater.b(r112, 100, false, r110, false, false, r111, 52, null);
        r10.L$0 = r28;
        r10.L$1 = r29;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.label = 2;
        if (((PackageUpdater) r12).y(r30, r31, r19, r10) != r13) goto L23;
        return r13;
    L23:
        r15 = r29;
        r16 = r28;
        goto L25
    L16:
        ResultKt.throwOnFailure(r12);
        r0<PackageUpdater> r32 = this.updater;
        r10.L$0 = this;
        r29 = r21;
        r10.L$1 = r29;
        r10.L$2 = r22;
        r10.L$3 = r25;
        r10.Z$0 = r23;
        r10.Z$1 = r24;
        r10.label = 1;
        r12 = r32.r(r10);
        if (r12 != r13) goto L19;
        return r13;
    L19:
        r112 = r22;
        r19 = r25;
        r111 = r23;
        r110 = r24;
        r28 = this;
    L7:
        r10 = new C03891(this, r26);
        goto L8
    }

    public final Object waitLocalPackageInit(Continuation<? super Unit> r10) {
        Object r11 = this.updater.r(r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
