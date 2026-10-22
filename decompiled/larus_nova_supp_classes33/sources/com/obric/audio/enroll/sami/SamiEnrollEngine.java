package com.obric.audio.enroll.sami;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.o;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreHttpPayloadType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreHttpCommonContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintResult;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.utils.j;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.sdk.entity.search.SearchError;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SamiEnrollEngine {
    public static final SamiEnrollEngine a = null;
    public static volatile a b;
    public static String c;
    public static volatile SpeechFingerPrintEnrollService d;
    public static final ReentrantLock e = null;
    public static final Object f = null;
    public static final Object g = null;
    public static volatile SpeechFingerPrintEnrollService h;
    public static volatile b i;
    public static volatile boolean j;
    public static final Semaphore k = null;
    public static volatile boolean l;
    public static volatile boolean m;
    public static final CoroutineScope n = null;
    public static final Gson o = null;
    public static final Set<String> p = null;
    public static final ConcurrentHashMap<String, Function2<String, String, Unit>> q = null;
    public static final ConcurrentHashMap<String, AtomicBoolean> r = null;
    public static final AtomicBoolean s = null;
    public static final c t = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/audio/enroll/sami/SamiEnrollEngine$ModelPaths;", "", "firstKwsModelPath", "", "sidEnrollModelPath", "silentFilePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstKwsModelPath", "()Ljava/lang/String;", "getSidEnrollModelPath", "getSilentFilePath", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("firstKwsModelPath")
        private final String firstKwsModelPath;

        @SerializedName("sidEnrollModelPath")
        private final String sidEnrollModelPath;

        @SerializedName("silentFilePath")
        private final String silentFilePath;

        public a() {
            this(null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.firstKwsModelPath, r6.firstKwsModelPath) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sidEnrollModelPath, r6.sidEnrollModelPath) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.silentFilePath, r6.silentFilePath) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.firstKwsModelPath;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.sidEnrollModelPath;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.silentFilePath;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ModelPaths(firstKwsModelPath=" + this.firstKwsModelPath + ", sidEnrollModelPath=" + this.sidEnrollModelPath + ", silentFilePath=" + this.silentFilePath + ')';
        }

        public final String a() {
            return this.firstKwsModelPath;
        }

        public final String b() {
            return this.sidEnrollModelPath;
        }

        public final String c() {
            return this.silentFilePath;
        }

        public a(String r1, String r2, String r3) {
            this.firstKwsModelPath = r1;
            this.sidEnrollModelPath = r2;
            this.silentFilePath = r3;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "PhoneEnrollQueryHandleKey(uid=" + this.a + ", sn=" + this.b + ", doubaoDid=" + this.c + ", dbPath=" + this.d + ", appId=" + this.e + ')';
        }

        public b(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            Intrinsics.checkNotNullParameter(r3, "sn");
            Intrinsics.checkNotNullParameter(r4, "doubaoDid");
            Intrinsics.checkNotNullParameter(r5, "dbPath");
            Intrinsics.checkNotNullParameter(r6, "appId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class c implements SAMICoreCallBackListener {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SAMICoreCallBackEventType.values().length];
                r0[SAMICoreCallBackEventType.ASRResponse.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[SAMICoreCallBackEventType.ASREnded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public c() {
        }

        public final void onMessageReceived(SAMICoreCallBackEventType r22, SAMICoreBlock r23) {
            if (r22 != null) goto L5;
            return;
        L5:
            if (r23 != null) goto L7;
            return;
        L7:
            int r2 = a.a[r22.ordinal()];
            boolean r3 = false;
            String r5 = "";
            String r8 = null;
            if (r2 != 1) goto L10;
            Object[] r0 = r23.audioData;
            if (r0 == null) goto L53;
            Object r1 = ArraysKt.firstOrNull(r0);
        L55:
            if ((r1 instanceof SAMICoreServerEvent) == false) goto L57;
            SAMICoreServerEvent r4 = (SAMICoreServerEvent) r1;
        L58:
            if (r4 != null) goto L60;
            return;
        L60:
            String r6 = r4.taskId;
            if (r6 != null) goto L63;
            return;
        L63:
            String r7 = r4.textMsg;
            if (r7 != null) goto L66;
            return;
        L66:
            Function2<String, String, Unit> r9 = SamiEnrollEngine.q.get(r6);
            if (r9 != null) goto L70;
            FLogger.a.i("SamiEnrollEngine", "ASRResponse ignored: no callback taskId=" + r6 + " respLen=" + r7.length());
            return;
        L70:
            ConcurrentHashMap<String, AtomicBoolean> r10 = SamiEnrollEngine.r;
            AtomicBoolean r11 = r10.get(r6);
            if (r11 != null) goto L77;
            r11 = new AtomicBoolean(false);
            AtomicBoolean r12 = r10.putIfAbsent(r6, r11);
            if (r12 == null) goto L77;
            r11 = r12;
        L77:
            if (r11.compareAndSet(false, true) == false) goto L122;
            FLogger.a.i("SamiEnrollEngine", "ASRResponse first taskId=" + r6 + " respLen=" + r7.length());
        L122:
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L81
            Object r14 = Result.constructor-impl((lia.a) SamiEnrollEngine.o.fromJson(r7, lia.a.class));     // Catch: Throwable -> L81
        L83:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L87;
            FLogger.a.e("SamiEnrollEngine", "ASRResponse parse failed taskId=" + r6 + ' ' + r15.getMessage());
        L87:
            if (Result.isFailure-impl(r14) == false) goto L89;
            r14 = null;
        L89:
            lia.a r16 = (lia.a) r14;
            if (r16 != null) goto L92;
            return;
        L92:
            List<lia.a.C0062a> r17 = r16.a();
            if (r17 == null) goto L95;
            lia.a.C0062a r18 = (lia.a.C0062a) CollectionsKt.firstOrNull(r17);
        L96:
            if (r18 == null) goto L98;
            r8 = r18.c();
        L98:
            if (r8 == null) goto L101;
            r5 = r8;
        L101:
            if (r18 == null) goto L103;
            boolean r19 = r18.d();
        L104:
            boolean r20 = !r19;
            if (StringsKt.isBlank(r5) == false) goto L109;
            if (r20 == true) goto L109;
            return;
        L109:
            if (r18 == null) goto L111;
            float r110 = r18.a();
        L113:
            if (r18 == null) goto L115;
            float r111 = r18.b();
        L116:
            String r21 = GsonProtectorUtils.toJson(SamiEnrollEngine.o, new kia.a("1", r20, null, r110, 0, null, r111, r5, 52), kia.a.class);
            Intrinsics.checkNotNull(r21);
            r9.invoke(r6, r21);
            FLogger r24 = FLogger.a;
            StringBuilder r25 = new StringBuilder("on realtime asrText=");
            SamiEnrollEngine.a.getClass();
            if (StringsKt.isBlank(r5) == false) goto L119;
            String r26 = "blank(len=" + r5.length() + ')';
        L120:
            r25.append(r26);
            r25.append(" vadEnd=");
            r25.append(r20);
            r25.append(" taskId=");
            r25.append(r6);
            r24.i("SamiEnrollEngine", r25.toString());
            return;
        L119:
            r26 = "redacted(len=" + r5.length() + ')';
            goto L120
        L115:
            r111 = 0.0f;
            goto L116
        L111:
            r110 = 0.0f;
            goto L113
        L103:
            r19 = true;
            goto L104
        L95:
            r18 = null;
        L81:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L83
        L57:
            r4 = null;
            goto L58
        L53:
            r1 = null;
            goto L55
        L10:
            if (r2 != 2) goto L12;
        L16:
            Object[] r28 = r23.audioData;
            if (r28 == null) goto L19;
            Object r29 = ArraysKt.firstOrNull(r28);
        L21:
            if ((r29 instanceof SAMICoreServerEvent) == false) goto L23;
            SAMICoreServerEvent r30 = (SAMICoreServerEvent) r29;
        L24:
            if (r30 == null) goto L26;
            r8 = r30.taskId;
        L26:
            if (r8 != null) goto L28;
        L31:
            boolean r31 = true;
        L33:
            if (r31 == true) goto L49;
            ConcurrentHashMap<String, Function2<String, String, Unit>> r32 = SamiEnrollEngine.q;
            Function2<String, String, Unit> r33 = r32.get(r8);
            if (r33 != null) goto L37;
        L45:
            SamiEnrollEngine.p.remove(r8);
            Function2<String, String, Unit> r34 = r32.remove(r8);
            SamiEnrollEngine.r.remove(r8);
            FLogger r35 = FLogger.a;
            StringBuilder r36 = new StringBuilder("session event=");
            r36.append(r22);
            r36.append(" taskId=");
            r36.append(r8);
            r36.append(" removedCallback=");
            if (r34 == null) goto L48;
            r3 = true;
        L48:
            r36.append(r3);
            r35.i("SamiEnrollEngine", r36.toString());
            return;
        L37:
            if (r22 != SAMICoreCallBackEventType.SessionFailed) goto L39;
            int r112 = 504;
        L41:
            if (r112 == 0) goto L44;
            r5 = r22.name();
        L44:
            r33.invoke(r8, GsonProtectorUtils.toJson(SamiEnrollEngine.o, new kia.a("0", true, "true", 0.0f, r112, r5, 0.0f, "", 72), kia.a.class));
            goto L45
        L39:
            r112 = 0;
            goto L41
        L49:
            FLogger.a.i("SamiEnrollEngine", "session event=" + r22 + " without taskId");
            return;
        L28:
            if (StringsKt.isBlank(r8) == true) goto L31;
            r31 = false;
            goto L33
        L23:
            r30 = null;
            goto L24
        L19:
            r29 = null;
            goto L21
        L12:
            if (r2 == 3) goto L16;
            if (r2 == 4) goto L16;
        }
    }

    public SamiEnrollEngine() {
    }

    static {
        a = new SamiEnrollEngine();
        e = new ReentrantLock();
        f = new Object();
        g = new Object();
        k = new Semaphore(1, true);
        n = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        o = new Gson();
        p = Collections.newSetFromMap(new ConcurrentHashMap());
        q = new ConcurrentHashMap();
        r = new ConcurrentHashMap();
        s = new AtomicBoolean(false);
        t = new c();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.mammon.audiosdk.structures.SAMICoreVoiceprintTrainableRequest");
    }

    public static boolean s() {
        boolean r1 = false;
        String r3 = null;
        if (b == null) goto L64;
    L46:
        a r0 = b;
        if (r0 == null) goto L49;
        String r5 = r0.a();
    L51:
        if (t(r5) == false) goto L62;
        if (r0 == null) goto L54;
        String r6 = r0.b();
    L56:
        if (t(r6) == false) goto L62;
        if (r0 == null) goto L60;
        r3 = r0.c();
    L60:
        if (t(r3) == false) goto L62;
        r1 = true;
        goto L62
    L54:
        r6 = null;
    L62:
        FLogger.a.i("SamiEnrollEngine", "hasDownloadedModelPaths ready=" + r1);
        return r1;
    L49:
        r5 = null;
        goto L51
    L64:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L41
        pia.b r4 = pia.b.a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter("bt_enroll_model_paths", "key");     // Catch: Throwable -> L41
        String r7 = pia.b.a().getString("bt_enroll_model_paths", null);     // Catch: Throwable -> L41
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        if (r7.length() <= 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L39;
        a r9 = (a) o.fromJson(r7, a.class);     // Catch: Throwable -> L41
        if (r9 == null) goto L39;
        String r10 = r9.a();     // Catch: Throwable -> L41
        if (r10 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == true) goto L39;
        String r12 = r9.b();     // Catch: Throwable -> L41
        if (r12 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == true) goto L39;
        String r14 = r9.c();     // Catch: Throwable -> L41
        if (r14 != null) goto L33;
    L36:
        boolean r15 = true;
    L37:
        if (r15 == true) goto L39;
        b = r9;     // Catch: Throwable -> L41
        FLogger.a.i("SamiEnrollEngine", "hasDownloadedModelPaths restore from keva");     // Catch: Throwable -> L41
        goto L39
    L33:
        if (r14.length() == 0) goto L36;
        r15 = false;
        goto L37
    L25:
        if (r12.length() == 0) goto L28;
        r13 = false;
        goto L29
    L17:
        if (r10.length() == 0) goto L20;
        r11 = false;
    L39:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L46;
        FLogger.a.e("SamiEnrollEngine", "hasDownloadedModelPaths restore failed: " + r17.getMessage());
        goto L46
    L10:
        r8 = false;
    L41:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    }

    public static void u() {
        BuildersKt.launch$default(n, null, null, new SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1(null), 3, null);
    }

    public static void x() {
        FLogger r2 = FLogger.a;
        r2.i("SamiEnrollEngine", "release begin");
        p.clear();
        q.clear();
        r.clear();
        e.lock();
        SpeechFingerPrintEnrollService r4 = d;     // Catch: Throwable -> L23
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.releaseHandle());     // Catch: Throwable -> L15
    L9:
        StringBuilder r7 = new StringBuilder("releaseHandle ret=");     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        int r1 = r5.intValue();     // Catch: Throwable -> L15
    L13:
        r7.append(r1);     // Catch: Throwable -> L15
        r2.i("SamiEnrollEngine", r7.toString());     // Catch: Throwable -> L15
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r8 = Result.exceptionOrNull-impl(r3);     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        FLogger.a.e("SamiEnrollEngine", "releaseHandle failed: " + r8.getMessage());     // Catch: Throwable -> L23
    L20:
        d = null;     // Catch: Throwable -> L23
        l = false;     // Catch: Throwable -> L23
        y("release enroll session");     // Catch: Throwable -> L23
        e.unlock();
        FLogger.a.i("SamiEnrollEngine", "release end");
        return;
    L12:
        r1 = Integer.MIN_VALUE;
        goto L13
    L8:
        r5 = null;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        e.unlock();
        throw th;
    }

    public final boolean w() {
        nia.a.a.getClass();
        return query(nia.a.d(), true);
    }

    public static String E() {
        String r0 = pia.d.i().getString("voice_print_owner_did", "");
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if ((!StringsKt.isBlank(r0)) == false) goto L20;
        return r0;
    L20:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        nia.a.a.getClass();     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl(nia.a.d());     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r2) == false) goto L15;
        r2 = null;
    L15:
        String r3 = (String) r2;
        if (r3 != null) goto L19;
        return "";
    L19:
        return r3;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static void A(String r5) {
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.REASON);
        FLogger.a.i("SamiEnrollEngine", "releaseQueryHandleForAccountChange reason=" + r5);
        Object r1 = f;
        monitor-enter(r1);
        a.getClass();     // Catch: Throwable -> L7
        z("account_change: " + r5);     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void D(String r7) {
        Intrinsics.checkNotNullParameter(r7, WindowEvent.Params.REASON);
        if (s.compareAndSet(false, true) == true) goto L21;
        FLogger.a.i("SamiEnrollEngine", "requestDownloadedModel ignored: requesting reason=".concat(r7));
        return;
    L21:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        r2.s0();     // Catch: Throwable -> L11
    L9:
        FLogger.a.i("SamiEnrollEngine", "requestDownloadedModel success reason=".concat(r7));     // Catch: Throwable -> L11
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L17;
        FLogger.a.e("SamiEnrollEngine", "requestDownloadedModel failed reason=" + r7 + ' ' + r3.getMessage());
        s.set(false);
    L17:
        if (Result.isSuccess-impl(r0) == true) goto L19;
        return;
    L19:
        BuildersKt.launch$default(n, null, null, new SamiEnrollEngine$requestDownloadedModel$1(r7, null), 3, null);
        return;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static int K(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L6;
        FLogger.a.e("SamiEnrollEngine", "uploadStoredPhoneEnrollForUid failed: uid is blank");
        return Integer.MIN_VALUE;
    L6:
        final String r0 = UUID.randomUUID().toString();
        FLogger.a.i("SamiEnrollEngine", "uploadStoredPhoneEnrollForUid taskId=" + r0 + " uid=" + j.d(r5));
        return F("upload_stored_uid", r5, null, new com.obric.audio.enroll.sami.c(r0, r5));
    }

    public static SAMICoreVoiceAssistantContextCreateParameter c(Context r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        nia.a.a.i(r3.getApplicationContext());     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L20:
        nia.a.a.getClass();     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = null;
    L13:
        String r5 = (String) r4;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        SAMICoreVoiceAssistantContextCreateParameter r1 = new SAMICoreVoiceAssistantContextCreateParameter();
        r1.url = "wss://audio.oceancloudapi.com/ocean/api/v1/ws";
        r1.header = r5;
        r1.protoVersion = "v2";
        r1.appKey = "KBSUHtkhOQ";
        r1.tokenType = SAMICoreTokenType.TOKEN_TO_C_D;
        r1.token = r5;
        r1.connectTimeout = 10000;
        r1.enableTransferRetry = false;
        r1.retryTimeArray = new int[]{500, SearchError.ERR_UNKNOWN, 2000, 4000};
        r1.enableConnectPool = false;
        r1.enableFrontier = false;
        r1.enableFallback = false;
        r1.retryPingPongTimeout = 0;
        r1.pingPongInterval = 0;
        r1.sendBufferSize = 0;
        r1.enableHostTransport = false;
        r1.encodeFrameSize = 0;
        FLogger.a.i("SamiEnrollEngine", "buildCreateAsrParam param=" + n(r1));
        return r1;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static int l(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L6;
        FLogger.a.e("SamiEnrollEngine", "deletePhoneEnrollLocalForUid failed: uid is blank");
        return Integer.MIN_VALUE;
    L6:
        final String r0 = E();
        Integer r5 = (Integer) L("delete phone enroll local uid=" + j.d(r4), new com.obric.audio.enroll.sami.b(r4, r0));
        if (r5 != null) goto L9;
        return Integer.MIN_VALUE;
    L9:
        return r5.intValue();
    }

    public static int m(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (StringsKt.isBlank(r3) == false) goto L6;
        FLogger.a.e("SamiEnrollEngine", "deletePhoneEnrollOnlineForUid failed: uid is blank");
        return Integer.MIN_VALUE;
    L6:
        final String r0 = E();
        return F("delete_online_uid", r3, r0, new f(r3, r0));
    }

    public static String n(Object r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L18
        r1.append(r7.getClass().getSimpleName());     // Catch: Throwable -> L18
        r1.append("(");     // Catch: Throwable -> L18
        Field[] r2 = r7.getClass().getFields();     // Catch: Throwable -> L18
        int r3 = r2.length;     // Catch: Throwable -> L18
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L16;
        Field r5 = r2[r4];     // Catch: Throwable -> L18
        String r6 = r5.getName();     // Catch: Throwable -> L18
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L7
        Object r9 = Result.constructor-impl(r5.get(r7));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r9) == false) goto L12;
        r9 = null;
    L12:
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L18
        String r10 = p(r6, r9);     // Catch: Throwable -> L18
        r1.append(r6);     // Catch: Throwable -> L18
        r1.append("=");     // Catch: Throwable -> L18
        r1.append(r10);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L18
        if (r4 == ArraysKt.getLastIndex(r2)) goto L15;
        r1.append(", ");     // Catch: Throwable -> L18
    L15:
        r4 = r4 + 1;     // Catch: Throwable -> L18
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L10
    L16:
        r1.append(")");     // Catch: Throwable -> L18
        Object r12 = Result.constructor-impl(r1.toString());     // Catch: Throwable -> L18
    L20:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L25;
        r12 = r7.getClass().getSimpleName() + "(dump_failed=" + r13.getMessage() + ')';
    L25:
        return (String) r12;
    L18:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static void o(SpeechFingerprintEnrollParameter r5) {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isOversea() == false) goto L5;
        AppLocaleUtils.a.getClass();
        Locale r1 = AppLocaleUtils.c();
    L6:
        JSONObject r2 = new JSONObject();
        r2.put("app_channel", r0.getBuildChannel());
        String r3 = b0.a;
        Intrinsics.checkNotNull(r1);
        r2.put("app_language", b0.c(r1));
        r2.put("app_version", r0.getVersionName());
        r2.put("app_version_code", String.valueOf(r0.getVersionCode()));
        r2.put("update_version_code", String.valueOf(r0.getUpdateVersionCode()));
        r2.put("version_code", String.valueOf(r0.getVersionCode()));
        r2.put("o_rom_version", t9a.b.b().b().b());
        r2.put("device_model", Build.MODEL);
        String r4 = r2.toString();
        boolean r6 = I(r5, "extra", r4);
        FLogger.a.i("SamiEnrollEngine", "fillUploadExtra applied=" + r6 + " extra=" + r4);
        return;
    L5:
        r1 = Locale.CHINA;
        goto L6
    }

    public static SpeechFingerPrintEnrollService q(Context r13) {
        Context r14 = r13.getApplicationContext();
        Intrinsics.checkNotNull(r14);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        nia.a.a.i(r14.getApplicationContext());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L91:
        nia.a.a.getClass();     // Catch: Throwable -> L9
        Object r5 = Result.constructor-impl(nia.a.d());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = null;
    L14:
        String r6 = (String) r5;
        if (r6 != null) goto L17;
        String r9 = "";
    L87:
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L21
        nia.a.a.getClass();     // Catch: Throwable -> L21
        r7.append(nia.a.g());     // Catch: Throwable -> L21
        r7.append('-');     // Catch: Throwable -> L21
        r7.append(r9);     // Catch: Throwable -> L21
        Object r8 = Result.constructor-impl(r7.toString());     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r8) == false) goto L26;
        r8 = null;
    L26:
        String r10 = (String) r8;
        if (r10 != null) goto L29;
        String r11 = "";
    L93:
        nia.a.a.getClass();     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(o.a.getDeviceId());     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r12) == false) goto L37;
        r12 = null;
    L37:
        String r15 = (String) r12;
        if (r15 != null) goto L40;
        String r16 = "";
    L85:
        nia.a.a.getClass();     // Catch: Throwable -> L43
        Object r17 = Result.constructor-impl(nia.a.g);     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r17) == false) goto L48;
        r17 = null;
    L48:
        String r18 = (String) r17;
        if (r18 != null) goto L51;
        String r19 = "";
    L52:
        b r20 = new b(r11, r9, r16, r19, String.valueOf(AppHost.a.getAppId()));
        if (StringsKt.isBlank(r20.b) == false) goto L56;
        FLogger.a.e("SamiEnrollEngine", "getOrCreatePhoneEnrollQueryService failed: sn is blank");
        return null;
    L56:
        Object r21 = f;
        monitor-enter(r21);
        SpeechFingerPrintEnrollService r22 = h;     // Catch: Throwable -> L79
        if (r22 != null) goto L61;
    L65:
        a.getClass();     // Catch: Throwable -> L79
        z("recreate query");     // Catch: Throwable -> L79
        SpeechFingerPrintEnrollService r3 = new SpeechFingerPrintEnrollService();     // Catch: Throwable -> L79
        String r23 = r20.b;     // Catch: Throwable -> L79
        String r24 = r20.a;     // Catch: Throwable -> L79
        SpeechFingerprintEnrollParameter r110 = f(r14, r23, StringsKt.substringBefore(r24, '-', r24), r20.c);     // Catch: Throwable -> L79
        int r25 = r3.createHandle(r110);     // Catch: Throwable -> L79
        FLogger r26 = FLogger.a;     // Catch: Throwable -> L79
        r26.i("SamiEnrollEngine", "phone enroll query createHandle ret=" + r25 + " sn=" + r20.b + " param=" + n(r110));     // Catch: Throwable -> L79
        if (r25 != 0) goto L89;
        h = r3;     // Catch: Throwable -> L79
        i = r20;     // Catch: Throwable -> L79
        monitor-exit(r21);
        return r3;
    L89:
        r26.i("SamiEnrollEngine", "phone enroll query createHandle failed release ret=" + r3.releaseHandle() + " sn=" + r20.b);     // Catch: Throwable -> L69
        Object r111 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        Throwable r112 = Result.exceptionOrNull-impl(r111);     // Catch: Throwable -> L79
        if (r112 == null) goto L74;
        FLogger.a.e("SamiEnrollEngine", "phone enroll query createHandle failed release failed sn=" + r20.b + ' ' + r112.getMessage());     // Catch: Throwable -> L79
    L74:
        monitor-exit(r21);
        return null;
    L69:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L79
        r111 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
        goto L71
    L61:
        if (Intrinsics.areEqual(i, r20) == false) goto L65;
        FLogger.a.i("SamiEnrollEngine", "reuse phone enroll query handle sn=" + r20.b);     // Catch: Throwable -> L79
        monitor-exit(r21);
        return r22;
    L79:
        th = move-exception;
        throw th;
    L51:
        r19 = r18;
    L43:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L40:
        r16 = r15;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r11 = r10;
    L21:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L17:
        r9 = r6;
    L9:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    }

    public static boolean t(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L13:
        return false;
    L11:
        if (new PolarisFileWrapper(r3).exists() == false) goto L13;
        return true;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void y(String r2) {
        if (j == true) goto L5;
        return;
    L5:
        j = false;
        k.release();
        FLogger.a.i("SamiEnrollEngine", "phone enroll local write released reason=".concat(r2));
    }

    public static void z(String r5) {
        SpeechFingerPrintEnrollService r2 = h;
        if (r2 != null) goto L14;
        return;
    L14:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        int r4 = r2.releaseHandle();     // Catch: Throwable -> L7
        FLogger.a.i("SamiEnrollEngine", "release phone enroll query handle reason=" + r5 + " ret=" + r4);     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r6 = Result.exceptionOrNull-impl(r1);
        if (r6 == null) goto L12;
        FLogger.a.e("SamiEnrollEngine", "release phone enroll query handle failed reason=" + r5 + ' ' + r6.getMessage());
    L12:
        h = null;
        i = null;
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final int delete(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sn");
        return delete(r3, false, true);
    }

    public final boolean k(String r9) {
        Intrinsics.checkNotNullParameter(r9, "sn");
        FLogger r0 = FLogger.a;
        r0.i("SamiEnrollEngine", "deleteBtAndDora sn=" + r9);
        boolean r4 = false;
        if (StringsKt.isBlank(r9) == false) goto L5;
        return false;
    L5:
        int r1 = delete(r9, false, false);
        int r6 = delete(r9, true, false);
        if (r1 != Integer.MIN_VALUE) goto L8;
        if (r6 != Integer.MIN_VALUE) goto L8;
    L9:
        r0.i("SamiEnrollEngine", "deleteBtAndDora sn=" + r9 + " thirdPartyRet=" + r1 + " doraRet=" + r6 + " createHandleOk=" + r4);
        return r4;
    L8:
        r4 = true;
        goto L9
    }

    public final boolean query(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        return query(r2, false);
    }

    public final int v(boolean r12) {
        if (m == false) goto L5;
        return 0;
    L5:
        if (r12 == false) goto L8;
        FLogger.a.i("SamiEnrollEngine", "migrateLegacyPhoneEnrollIfNeeded skipped: enterprise account");
        return 0;
    L8:
        Context r13 = AppHost.a.getApplication().getApplicationContext();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        nia.a r1 = nia.a.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L11
        r1.i(r13);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        nia.a.a.getClass();
        final String r14 = nia.a.f;
        if (StringsKt.isBlank(r14) == false) goto L17;
        m = true;
        FLogger.a.i("SamiEnrollEngine", "migrateLegacyPhoneEnrollIfNeeded skipped: legacyDir blank");
        return 0;
    L17:
        final PolarisFileWrapper r2 = new PolarisFileWrapper(r14);
        if (r2.isDirectory() == false) goto L38;
        File[] r3 = r2.listFiles();
        if (r3 == null) goto L35;
        int r4 = r3.length;
        int r5 = 0;
    L22:
        if (r5 >= r4) goto L32;
        File r6 = r3[r5];
        if (r6.isFile() == true) goto L26;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == true) goto L30;
        r5 = r5 + 1;
        goto L22
    L30:
        boolean r8 = true;
    L33:
        if (r8 != true) goto L35;
        boolean r9 = true;
    L36:
        if (r9 == false) goto L38;
        boolean r10 = true;
    L39:
        if (r10 == true) goto L43;
        m = true;
        FLogger.a.i("SamiEnrollEngine", "migrateLegacyPhoneEnrollIfNeeded skipped: legacy dir empty path=" + r14);
        return 0;
    L43:
        if (w() == false) goto L46;
        m = true;
        FLogger.a.i("SamiEnrollEngine", "migrateLegacyPhoneEnrollIfNeeded skipped: default voiceprint db exists path=" + r14);
        return 0;
    L46:
        Object r11 = f;
        monitor-enter(r11);
        a.getClass();     // Catch: Throwable -> L54
        z("before migrate legacy");     // Catch: Throwable -> L54
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r11);
        int r16 = G("migrate_legacy", new d(r14, r2));
        if (r16 != 0) goto L53;
        m = true;
    L53:
        return r16;
    L54:
        th = move-exception;
        throw th;
    L26:
        if (r6.length() <= 0) goto L28;
        r7 = true;
        goto L29
    L32:
        r8 = false;
    L35:
        r9 = false;
    L38:
        r10 = false;
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static int G(final String r2, final Function1 r3) {
        Integer r4 = (Integer) L("phone enroll model ".concat(r2), new h(r2, r3));
        if (r4 != null) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r4.intValue();
    }

    public static int H(String r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r16, "uid");
        Object r8 = Integer.MIN_VALUE;
        if (StringsKt.isBlank(r16) == false) goto L6;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid failed: uid is blank");
        return Integer.MIN_VALUE;
    L6:
        Context r0 = AppHost.a.getApplication().getApplicationContext();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        nia.a r11 = nia.a.a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r11.i(r0);     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        String r12 = g(r16, E());
        if (StringsKt.isBlank(r12) == false) goto L142;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid failed: sn is blank uid=" + j.d(r16));
        return Integer.MIN_VALUE;
    L142:
        nia.a.a.getClass();     // Catch: Throwable -> L17
        Object r1 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r1) == false) goto L22;
        r1 = null;
    L22:
        String r2 = (String) r1;
        if (r2 != null) goto L25;
        r2 = "";
    L25:
        String r13 = r2;
        if (StringsKt.isBlank(r13) == false) goto L150;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid failed: token is blank uid=" + j.d(r16));
        return Integer.MIN_VALUE;
    L150:
        Object r3 = a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L32
        r3.getClass().getField("uid").set(r3, r12);     // Catch: Throwable -> L32
        r3.getClass().getField("isTrainable").set(r3, Boolean.valueOf(r17));     // Catch: Throwable -> L32
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L32
    L35:
        if (Result.exceptionOrNull-impl(r4) == null) goto L38;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid unsupported audiosdk uid=" + j.d(r16));
    L38:
        if (Result.isFailure-impl(r4) == false) goto L40;
        Object r6 = null;
    L42:
        if (r6 != null) goto L134;
        return 100002;
    L134:
        Object r5 = Result.constructor-impl(SAMICorePropertyId.valueOf("SAMICorePropertyId_Http_Common_Request_Set_Voiceprint_Trainable"));     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r5) == false) goto L52;
        r5 = null;
    L52:
        SAMICorePropertyId r14 = (Enum) r5;
        Object r7 = Result.constructor-impl(SAMICoreDataType.valueOf("SAMICoreDataType_Http_Common_Request_Set_Voiceprint_Trainable"));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r7) == false) goto L60;
        r7 = null;
    L60:
        SAMICoreDataType r15 = (Enum) r7;
        if (r14 == null) goto L130;
        if (r15 == null) goto L130;
        SAMICore r18 = new SAMICore();
        SAMICoreHttpCommonContextCreateParameter r9 = new SAMICoreHttpCommonContextCreateParameter();
        r9.url = "https://audio.doubao.com/internal/api/v1/invoke";
        r9.appKey = "NTIQXNbrFj";
        r9.tokenType = SAMICoreTokenType.TOKEN_TO_C_D;
        r9.token = r13;
        r9.header = r13;
        r9.apiNamespace = "AudioDataManager";
        r9.responsePayloadType = SAMICoreHttpPayloadType.JsonString;
        Object r19 = Result.constructor-impl(Integer.valueOf(r18.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_HTTP_COMMON, r9)));     // Catch: Throwable -> L67
    L69:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L73;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid create handle failed uid=" + j.d(r16) + ' ' + r110.getMessage());
    L73:
        if (Result.isFailure-impl(r19) == false) goto L75;
        r19 = r8;
    L75:
        int r20 = ((Number) r19).intValue();
        if (r20 == 0) goto L136;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid create handle ret=" + r20 + " uid=" + j.d(r16));
        return r20;
    L136:
        SAMICoreProperty r21 = new SAMICoreProperty();     // Catch: Throwable -> L113
        r21.id = r14;     // Catch: Throwable -> L113
        r21.type = r15;     // Catch: Throwable -> L113
        r21.dataObjectArray = new Object[]{r6};     // Catch: Throwable -> L113
        r21.dataArrayLen = 1;     // Catch: Throwable -> L113
        Object r22 = Result.constructor-impl(Integer.valueOf(r18.SAMICoreSetProperty(r14, r21)));     // Catch: Throwable -> L82
    L84:
        Throwable r111 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L113
        if (r111 == null) goto L88;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid failed uid=" + j.d(r16) + ' ' + r111.getMessage());     // Catch: Throwable -> L113
    L88:
        if (Result.isFailure-impl(r22) == false) goto L90;
        r22 = r8;
    L90:
        int r23 = ((Number) r22).intValue();     // Catch: Throwable -> L113
        Object r24 = r(r6, "response");     // Catch: Throwable -> L113
        FLogger r25 = FLogger.a;     // Catch: Throwable -> L113
        StringBuilder r112 = new StringBuilder("setDefaultVoicePrintTrainableForUid ret=");     // Catch: Throwable -> L113
        r112.append(r23);     // Catch: Throwable -> L113
        r112.append(" uid=");     // Catch: Throwable -> L113
        r112.append(j.d(r16));     // Catch: Throwable -> L113
        r112.append(" isTrainable=");     // Catch: Throwable -> L113
        r112.append(r17);     // Catch: Throwable -> L113
        r112.append(" statusCode=");     // Catch: Throwable -> L113
        r112.append(r(r24, "statusCode"));     // Catch: Throwable -> L113
        r112.append(" statusText=");     // Catch: Throwable -> L113
        r112.append(r(r24, "statusText"));     // Catch: Throwable -> L113
        r112.append(" payloadLen=");     // Catch: Throwable -> L113
        Object r26 = r(r24, "payload");     // Catch: Throwable -> L113
        if ((r26 instanceof String) == false) goto L93;
        String r113 = (String) r26;     // Catch: Throwable -> L113
    L94:
        if (r113 == null) goto L96;
        int r27 = r113.length();     // Catch: Throwable -> L113
    L97:
        r112.append(r27);     // Catch: Throwable -> L113
        r25.i("SamiEnrollEngine", r112.toString());     // Catch: Throwable -> L113
        Object r28 = Result.constructor-impl(Integer.valueOf(r18.SAMICoreDestroyHandle()));     // Catch: Throwable -> L100
    L102:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L106;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid destroy handle failed " + r29.getMessage());
    L106:
        if (Result.isFailure-impl(r28) == true) goto L109;
        r8 = r28;
    L109:
        int r30 = ((Number) r8).intValue();
        if (r30 == 0) goto L112;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid destroy handle ret=" + r30);
    L112:
        return r23;
    L100:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L102
    L96:
        r27 = 0;
        goto L97
    L93:
        r113 = null;
        goto L94
    L82:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L113
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L117
        Object r33 = Result.constructor-impl(Integer.valueOf(r18.SAMICoreDestroyHandle()));     // Catch: Throwable -> L117
    L119:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L123;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid destroy handle failed " + r34.getMessage());
    L123:
        if (Result.isFailure-impl(r33) == true) goto L126;
        r8 = r33;
    L126:
        int r35 = ((Number) r8).intValue();
        if (r35 == 0) goto L152;
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid destroy handle ret=" + r35);
        throw th;
    L152:
        throw th;
    L117:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L67:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L130:
        FLogger.a.e("SamiEnrollEngine", "setDefaultVoicePrintTrainableForUid unsupported audiosdk uid=" + j.d(r16));
        return 100002;
    L55:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L47:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L40:
        r6 = r4;
    L32:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static Object L(String r6, Function0 r7) {
        FLogger r1 = FLogger.a;
        r1.i("SamiEnrollEngine", "phone enroll local write acquire begin reason=" + r6);
        Semaphore r2 = k;
        r2.acquire();
        r1.i("SamiEnrollEngine", "phone enroll local write acquired reason=" + r6);
        Object r8 = r7.invoke();     // Catch: Throwable -> L6
        r2.release();
        r1.i("SamiEnrollEngine", "phone enroll local write released reason=" + r6);
        return r8;
    L6:
        th = move-exception;
        k.release();
        FLogger.a.i("SamiEnrollEngine", "phone enroll local write released reason=" + r6);
        throw th;
    }

    public static SAMICoreAsrContextCreateParameter b(Context r6, boolean r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        nia.a.a.i(r6.getApplicationContext());     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L20:
        nia.a.a.getClass();     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = null;
    L13:
        String r9 = (String) r8;
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        JSONObject r1 = new JSONObject();
        r1.put("engine_version", "1.0.1.1");
        StringBuilder r2 = new StringBuilder();
        nia.a.a.getClass();
        r2.append(nia.a.g());
        r2.append('-');
        r2.append(c);
        r1.put("voice_print_id", r2.toString());
        String r3 = r1.toString();
        JSONObject r4 = new JSONObject();
        r4.put("enable_vad_timeout_break", false);
        r4.put("enable_pvad_audio_interrupt", false);
        r4.put("dora_engine_version", r3);
        String r5 = r4.toString();
        SAMICoreAsrContextCreateParameter r10 = new SAMICoreAsrContextCreateParameter();
        r10.url = "wss://audio.oceancloudapi.com/ocean/api/v1/ws";
        r10.appKey = "KBSUHtkhOQ";
        r10.header = "{\"proto-version\":\"v2\"}";
        r10.tokenType = SAMICoreTokenType.TOKEN_TO_C_D;
        r10.token = r9;
        r10.format = "speech_opus";
        r10.sampleRate = 16000;
        r10.channel = 1;
        r10.connect_timeout = 0;
        r10.language = "zh";
        r10.extra = r5;
        r10.enable_punctuation = 1;
        r10.enable_speaker_diarization = 0;
        r10.sos_silence_timeout = 0;
        r10.eos_silence_timeout = 0;
        r10.sentence_max_time = 0;
        r10.timestamp = 0;
        r10.enable_audio_cache = 1;
        r10.audio_cache_size = 1920000;
        r10.enable_remove_first_audio_data = 0;
        r10.enable_net_transport_compress = !r7 ? 1 : 0;
        r10.enable_speech_rejection = false;
        r10.audio_src = 1;
        r10.retry_mode = 0;
        r10.retry_count = 0;
        r10.max_buffer_count = 0;
        r10.finish_wait_timeout = 0;
        FLogger.a.i("SamiEnrollEngine", "buildAsrParam isDoraEnroll=" + r7 + " param=" + n(r10));
        return r10;
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static String g(String r1, String r2) {
        if (StringsKt.isBlank(r1) == false) goto L5;
        return "";
    L5:
        if (StringsKt.isBlank(r2) == false) goto L8;
        return "";
    L8:
        return r1 + '-' + r2;
    }

    public static SAMICoreVoiceAssistantPropertyParameter h(String r9, String r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        nia.a.a.getClass();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(nia.a.g());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        String r3 = c;
        JSONObject r4 = new JSONObject();
        r4.put("conversation_id", "203059595437826");
        r4.put("local_message_id", r9);
        r4.put("new_conversation", false);
        r4.put("uid", r2);
        String r5 = r4.toString();
        JSONObject r6 = new JSONObject();
        r6.put("app_version", "3.1.0");
        r6.put("app_version_code", 0);
        r6.put("did", r3);
        r6.put("uid", r2);
        r6.put("enable_text_complete", false);
        r6.put("query_length_limit", 50);
        r6.put("enable_comfort", false);
        r6.put("enable_aec_interrupt_cancellation", false);
        r6.put("enable_chat_comfort", true);
        r6.put("comfort_wait_first_recv_ms", "1500");
        r6.put("enable_llm_reject", false);
        r6.put("first_word_filter_confidence_threshold", 0.65d);
        r6.put("para_language_enable", true);
        r6.put("chat_server_cluster", "assistant-im");
        String r7 = r6.toString();
        SAMICoreVoiceAssistantPropertyParameter r8 = new SAMICoreVoiceAssistantPropertyParameter();
        r8.taskId = r9;
        if (r10 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        r8.wakeupId = r10;
    L21:
        r8.conversationId = "203059595437826";
        r8.enableAudioInput = true;
        r8.enableUploadAudio = false;
        r8.enableTextReading = false;
        r8.enableRealtimeVoiceCall = false;
        r8.interruptType = 0;
        r8.business = 2;
        r8.requestType = 0;
        r8.triggerType = 0;
        r8.playerStatus = 0;
        r8.volume = 0.0f;
        r8.enablePlayer = false;
        r8.enableTouch = false;
        r8.enableBurst = false;
        r8.enableOneShot = false;
        r8.enableAudioRecorder = false;
        r8.audioRecordChannels = 0;
        r8.highQuality = 0;
        r8.imageStatus = 0;
        r8.imageType = 0;
        r8.intentMode = 0;
        r8.multimodalStatus = 0;
        r8.vuiQueryMode = 0;
        r8.wakeupAudioDurationMs = 0;
        r8.chat = r5;
        r8.extra = r7;
        FLogger.a.i("SamiEnrollEngine", "buildStartParam taskId=" + r9 + " param=" + n(r8));
        return r8;
    L15:
        if (StringsKt.isBlank(r10) == true) goto L18;
        r11 = false;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String p(String r17, Object r18) {
        if (r18 != null) goto L6;
        return "null";
    L6:
        String r1 = r17.toLowerCase(Locale.ROOT);
        if (StringsKt.contains$default(r1, "token", false, 2, null) == false) goto L9;
    L14:
        boolean r2 = true;
    L16:
        if ((r18 instanceof String) == false) goto L31;
        if (Intrinsics.areEqual(r1, "uid") == false) goto L20;
    L27:
        String r0 = j.d((String) r18);
        if (r0 != null) goto L43;
        return "";
    L43:
        return r0;
    L20:
        if (Intrinsics.areEqual(r1, "doubao_uid") == true) goto L27;
        if (StringsKt.endsWith$default(r1, "did", false, 2, null) == true) goto L27;
        if (r2 == false) goto L42;
        return "REDACTED(len=" + ((String) r18).length() + ')';
    L42:
        return (String) r18;
    L31:
        if ((r18 instanceof int[]) == false) goto L34;
        return ArraysKt.joinToString$default((int[]) r18, null, "[", "]", 0, null, null, 57, null);
    L34:
        if ((r18 instanceof float[]) == false) goto L37;
        return "FloatArray(size=" + ((float[]) r18).length + ')';
    L37:
        if ((r18 instanceof byte[]) == false) goto L40;
        return "ByteArray(size=" + ((byte[]) r18).length + ')';
    L40:
        return r18.toString();
    L9:
        if (StringsKt.contains$default(r1, "header", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r1, "enckeyinfo", false, 2, null) == true) goto L14;
        r2 = false;
        goto L16
    }

    private final boolean query(String r17, boolean r18) {
        FLogger r8 = FLogger.a;
        r8.i("SamiEnrollEngine", "query sn=" + r17 + " isPhoneEnroll=" + r18);
        boolean r10 = false;
        if (StringsKt.isBlank(r17) == false) goto L6;
        return false;
    L6:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L8;
        r8.e("SamiEnrollEngine", "query called on main thread sn=" + r17);
    L8:
        Object r12 = null;
        if (r18 == false) goto L110;
        SpeechFingerPrintEnrollService r3 = q(AppHost.a.getApplication());
        if (r3 == null) goto L191;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Object r1 = Result.constructor-impl(r3.getAudioFeatureOnline());     // Catch: Throwable -> L15
    L17:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L21;
        FLogger.a.e("SamiEnrollEngine", "query phone getAudioFeatureOnline failed sn=" + r17 + ' ' + r4.getMessage());
    L21:
        if (Result.isFailure-impl(r1) == false) goto L23;
        r1 = null;
    L23:
        SpeechFingerprintResult r2 = (SpeechFingerprintResult) r1;
        if (r2 != null) goto L58;
        Object r5 = f;
        monitor-enter(r5);
    L55:
        th = move-exception;
        throw th;
    L28:
        if (h == r3) goto L31;
        monitor-exit(r5);
    L40:
        SpeechFingerPrintEnrollService r6 = q(AppHost.a.getApplication());
        if (r6 == null) goto L192;
        FLogger.a.i("SamiEnrollEngine", "query phone retry with recreated query handle sn=" + r17);
        Object r7 = Result.constructor-impl(r6.getAudioFeatureOnline());     // Catch: Throwable -> L46
    L48:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L52;
        FLogger.a.e("SamiEnrollEngine", "query phone retry getAudioFeatureOnline failed sn=" + r17 + ' ' + r9.getMessage());
    L52:
        if (Result.isFailure-impl(r7) == false) goto L54;
        r7 = null;
    L54:
        r2 = (SpeechFingerprintResult) r7;
    L46:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L192:
        return false;
    L31:
        FLogger r13 = FLogger.a;     // Catch: Throwable -> L55
        r13.e("SamiEnrollEngine", "invalidate phone enroll query handle reason=query failed");     // Catch: Throwable -> L55
        h = null;     // Catch: Throwable -> L55
        i = null;     // Catch: Throwable -> L55
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r5);
        r13.i("SamiEnrollEngine", "invalidate phone enroll query handle release ret=" + r3.releaseHandle() + " reason=query failed");     // Catch: Throwable -> L35
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L40;
        FLogger.a.e("SamiEnrollEngine", "invalidate phone enroll query handle release failed reason=query failed " + r16.getMessage());
    L35:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L58:
        if (r2 == null) goto L193;
        int r20 = r2.exist_primacy_data;
        byte[] r21 = r2.sid_feature;
        if (r21 == null) goto L63;
        int r22 = r21.length;
    L64:
        if (r20 == 0) goto L66;
        boolean r23 = true;
    L67:
        FLogger.a.i("SamiEnrollEngine", "query phone sn=" + r17 + " existed=" + r23 + " existPrimacyData=" + r20 + " sidFeatureSize=" + r22);
        if (r23 == false) goto L84;
        nia.a.a.getClass();     // Catch: Throwable -> L71
        Object r24 = Result.constructor-impl(nia.a.g());     // Catch: Throwable -> L71
    L74:
        if (Result.isFailure-impl(r24) == true) goto L77;
        r12 = r24;
    L77:
        String r110 = (String) r12;
        if (r110 != null) goto L81;
        r110 = "";
    L81:
        if ((!StringsKt.isBlank(r110)) == false) goto L84;
        pia.d.a(r110);
        pia.d.q(r17);
    L71:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L84:
        if (pia.d.i().getBoolean("voice_print_legacy_global_keys_cleared", false) == true) goto L109;
        pia.b r26 = pia.b.a;     // Catch: Throwable -> L88
        pia.b.d("default_voice_print_cloud_desired_op");     // Catch: Throwable -> L88
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L88
    L90:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L167;
        FLogger.a.e("SamiEnrollEngine", "cleanupLegacyGlobalCloudKeys remove desired failed: " + r28.getMessage());
    L167:
        pia.b r29 = pia.b.a;     // Catch: Throwable -> L95
        pia.b.d("default_voice_print_cloud_actual_op");     // Catch: Throwable -> L95
        Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L163;
        FLogger.a.e("SamiEnrollEngine", "cleanupLegacyGlobalCloudKeys remove actual failed: " + r31.getMessage());
    L163:
        pia.b r32 = pia.b.a;     // Catch: Throwable -> L102
        pia.b.d("default_voice_print_mic0_recorded");     // Catch: Throwable -> L102
        Object r33 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L102
    L104:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L107;
        FLogger.a.e("SamiEnrollEngine", "cleanupLegacyGlobalCloudKeys remove mic0 failed: " + r34.getMessage());
    L107:
        pia.d.i().storeBoolean("voice_print_legacy_global_keys_cleared", true);
        FLogger.a.i("SamiEnrollEngine", "cleanupLegacyGlobalCloudKeys done");
    L102:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L95:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
    L109:
        return r23;
    L66:
        r23 = false;
        goto L67
    L63:
        r22 = 0;
        goto L64
    L193:
        return false;
    L15:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L191:
        return false;
    L110:
        SpeechFingerPrintEnrollService r111 = new SpeechFingerPrintEnrollService();
        r8.i("SamiEnrollEngine", "query createHandle ret=" + r111.createHandle(e(this, AppHost.a.getApplication(), r17, false, false)) + " sn=" + r17);     // Catch: Throwable -> L150
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L116
        Object r40 = Result.constructor-impl(r111.getAudioFeatureOnline());     // Catch: Throwable -> L116
    L118:
        Throwable r41 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L150
        if (r41 == null) goto L122;
        FLogger.a.e("SamiEnrollEngine", "query getAudioFeatureOnline failed sn=" + r17 + ' ' + r41.getMessage());     // Catch: Throwable -> L150
    L122:
        if (Result.isFailure-impl(r40) == true) goto L125;
        r12 = r40;
    L125:
        SpeechFingerprintResult r112 = (SpeechFingerprintResult) r12;     // Catch: Throwable -> L150
        if (r112 == null) goto L177;
        int r42 = r112.exist_primacy_data;     // Catch: Throwable -> L150
        byte[] r43 = r112.sid_feature;     // Catch: Throwable -> L150
        if (r43 == null) goto L138;
        int r44 = r43.length;     // Catch: Throwable -> L150
    L139:
        if (r42 == 0) goto L141;
        r10 = true;
    L141:
        FLogger r45 = FLogger.a;     // Catch: Throwable -> L150
        r45.i("SamiEnrollEngine", "query sn=" + r17 + " existed=" + r10 + " existPrimacyData=" + r42 + " sidFeatureSize=" + r44);     // Catch: Throwable -> L150
        r45.i("SamiEnrollEngine", "query releaseHandle ret=" + r111.releaseHandle() + " sn=" + r17);     // Catch: Throwable -> L144
        Object r46 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L144
    L146:
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L149;
        FLogger.a.e("SamiEnrollEngine", "query releaseHandle failed sn=" + r17 + ' ' + r47.getMessage());
    L149:
        return r10;
    L144:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L146
    L138:
        r44 = 0;
        goto L139
    L177:
        int r49 = r111.releaseHandle();     // Catch: Throwable -> L129
        FLogger.a.i("SamiEnrollEngine", "query releaseHandle ret=" + r49 + " sn=" + r17);     // Catch: Throwable -> L129
        Object r50 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L129
    L131:
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L134;
        FLogger.a.e("SamiEnrollEngine", "query releaseHandle failed sn=" + r17 + ' ' + r51.getMessage());
    L134:
        return false;
    L129:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L131
    L116:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L150
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L150:
        th = th;
    L154:
        Throwable r54 = th;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L157
        int r56 = r111.releaseHandle();     // Catch: Throwable -> L157
        FLogger.a.i("SamiEnrollEngine", "query releaseHandle ret=" + r56 + " sn=" + r17);     // Catch: Throwable -> L157
        Object r57 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L157
    L159:
        Throwable r58 = Result.exceptionOrNull-impl(r57);
        if (r58 == null) goto L194;
        FLogger.a.e("SamiEnrollEngine", "query releaseHandle failed sn=" + r17 + ' ' + r58.getMessage());
        throw r54;
    L194:
        throw r54;
    L157:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
    L152:
        th = th;
        goto L154
    }

    public static Object r(Object r2, String r3) {
        if (r2 != null) goto L14;
        return null;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(r2.getClass().getField(r3).get(r2));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r4) == false) goto L13;
        return null;
    L13:
        return r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static boolean I(Object r1, String r2, Object r3) {
        if (r3 != null) goto L11;
        return false;
    L11:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        r1.getClass().getField(r2).set(r1, r3);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static void J(String r6, String r7, String r8) {
        b = new a(r6, r7, r8);
        int r1 = 0;
        s.set(false);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        String r2 = o.toJson(new a(r6, r7, r8));     // Catch: Throwable -> L5
        pia.b r3 = pia.b.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        pia.b.c("bt_enroll_model_paths", r2);     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L10;
        FLogger.a.e("SamiEnrollEngine", "updateModelPaths persist failed: " + r5.getMessage());
    L10:
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("updateModelPaths firstLen=");
        if (r6 == null) goto L13;
        int r11 = r6.length();
    L14:
        r10.append(r11);
        r10.append(" sidLen=");
        if (r7 == null) goto L17;
        int r12 = r7.length();
    L18:
        r10.append(r12);
        r10.append(" silentLen=");
        if (r8 == null) goto L21;
        r1 = r8.length();
    L21:
        r10.append(r1);
        r9.i("SamiEnrollEngine", r10.toString());
        return;
    L17:
        r12 = 0;
        goto L18
    L13:
        r11 = 0;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final int delete(String r19, boolean r20, boolean r21) {
        FLogger r9 = FLogger.a;
        r9.i("SamiEnrollEngine", "delete sn=" + r19 + " isDoraEnroll=" + r20 + " resetLocalStatusAfterDelete=" + r21);
        if (StringsKt.isBlank(r19) == false) goto L6;
        return Integer.MIN_VALUE;
    L6:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L8;
        r9.e("SamiEnrollEngine", "delete called on main thread sn=" + r19);
    L8:
        SpeechFingerPrintEnrollService r10 = new SpeechFingerPrintEnrollService();
        int r14 = r10.createHandle(e(this, AppHost.a.getApplication(), r19, r20, false));     // Catch: Throwable -> L53
        r9.i("SamiEnrollEngine", "delete createHandle ret=" + r14 + " sn=" + r19 + " isDoraEnroll=" + r20);     // Catch: Throwable -> L53
        if (r14 == 0) goto L74;
        r9.e("SamiEnrollEngine", "delete createHandle failed sn=" + r19 + " isDoraEnroll=" + r20 + " ret=" + r14);     // Catch: Throwable -> L53
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        r9.i("SamiEnrollEngine", "delete releaseHandle ret=" + r10.releaseHandle() + " sn=" + r19 + " isDoraEnroll=" + r20);     // Catch: Throwable -> L20
        if (r21 == false) goto L18;
        a.getClass();     // Catch: Throwable -> L20
        u();     // Catch: Throwable -> L20
    L18:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L81;
        FLogger.a.e("SamiEnrollEngine", "delete releaseHandle failed sn=" + r19 + " isDoraEnroll=" + r20 + ' ' + r2.getMessage());
        return Integer.MIN_VALUE;
    L81:
        return Integer.MIN_VALUE;
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L74:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        Object r5 = Result.constructor-impl(Integer.valueOf(r10.removeAudioFeatureOnline(r19)));     // Catch: Throwable -> L29
    L31:
        Throwable r11 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L53
        if (r11 == null) goto L35;
        FLogger.a.e("SamiEnrollEngine", "delete failed sn=" + r19 + " isDoraEnroll=" + r20 + ' ' + r11.getMessage());     // Catch: Throwable -> L53
    L35:
        if (Result.isFailure-impl(r5) == false) goto L37;
        r5 = null;
    L37:
        Integer r6 = (Integer) r5;     // Catch: Throwable -> L53
        if (r6 == null) goto L40;
        int r15 = r6.intValue();     // Catch: Throwable -> L53
    L41:
        FLogger r7 = FLogger.a;     // Catch: Throwable -> L53
        r7.i("SamiEnrollEngine", "delete sn=" + r19 + " isDoraEnroll=" + r20 + " ret=" + r15);     // Catch: Throwable -> L53
        r7.i("SamiEnrollEngine", "delete releaseHandle ret=" + r10.releaseHandle() + " sn=" + r19 + " isDoraEnroll=" + r20);     // Catch: Throwable -> L47
        if (r21 == false) goto L45;
        a.getClass();     // Catch: Throwable -> L47
        u();     // Catch: Throwable -> L47
    L45:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r12 = Result.exceptionOrNull-impl(r8);
        if (r12 == null) goto L52;
        FLogger.a.e("SamiEnrollEngine", "delete releaseHandle failed sn=" + r19 + " isDoraEnroll=" + r20 + ' ' + r12.getMessage());
    L52:
        return r15;
    L47:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L40:
        r15 = 0;
        goto L41
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L53
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
    L53:
        th = th;
    L57:
        Throwable r17 = th;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L63
        int r22 = r10.releaseHandle();     // Catch: Throwable -> L63
        FLogger.a.i("SamiEnrollEngine", "delete releaseHandle ret=" + r22 + " sn=" + r19 + " isDoraEnroll=" + r20);     // Catch: Throwable -> L63
        if (r21 == false) goto L61;
        a.getClass();     // Catch: Throwable -> L63
        u();     // Catch: Throwable -> L63
    L61:
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L65:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L80;
        FLogger.a.e("SamiEnrollEngine", "delete releaseHandle failed sn=" + r19 + " isDoraEnroll=" + r20 + ' ' + r24.getMessage());
        throw r17;
    L80:
        throw r17;
    L63:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        th = th;
        goto L57
    }

    public static SpeechFingerPrintEnrollService i(Context r17, String r18, boolean r19) {
        Context r2 = r17.getApplicationContext();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        nia.a r1 = nia.a.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        r1.i(r2);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        FLogger.a.e("SamiEnrollEngine", "EnrollGlobal.init failed before phone enroll model purpose=" + r18 + ": " + r4.getMessage());
    L10:
        nia.a r5 = nia.a.a;
        r5.getClass();
        if (nia.a.c(r18) == true) goto L14;
        FLogger.a.e("SamiEnrollEngine", "createPhoneEnrollModelService failed: wakeup sid snapshot not ready purpose=".concat(r18));
        return null;
    L14:
        Intrinsics.checkNotNull(r2);
        r5.i(r2.getApplicationContext());     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L217:
        nia.a.a.getClass();     // Catch: Throwable -> L21
        Object r6 = Result.constructor-impl(nia.a.e(nia.a.m().b));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r6) == false) goto L26;
        r6 = null;
    L26:
        String r7 = (String) r6;
        if (r19 == true) goto L233;
        boolean r8 = false;
    L37:
        if (r8 == true) goto L209;
    L46:
        FLogger.a.i("SamiEnrollEngine", "buildPhoneEnrollHandleKey includeSidAuth=" + r19 + " authReady=" + r8 + " (includeSidAuth=false only skips sid_auth model fields; phone SID enroll still requires QNN runtime)");
        nia.a.a.getClass();     // Catch: Throwable -> L49
        Object r9 = Result.constructor-impl(nia.a.g());     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r9) == false) goto L54;
        r9 = null;
    L54:
        String r10 = (String) r9;
        String r11 = "";
        if (r10 != null) goto L57;
        String r12 = "";
    L231:
        nia.a.a.getClass();     // Catch: Throwable -> L60
        Object r13 = Result.constructor-impl(nia.a.d());     // Catch: Throwable -> L60
    L63:
        if (Result.isFailure-impl(r13) == false) goto L65;
        r13 = null;
    L65:
        String r14 = (String) r13;
        if (r14 != null) goto L68;
        String r15 = "";
    L203:
        nia.a.a.getClass();     // Catch: Throwable -> L71
        Object r16 = Result.constructor-impl(o.a.getDeviceId());     // Catch: Throwable -> L71
    L74:
        if (Result.isFailure-impl(r16) == false) goto L76;
        r16 = null;
    L76:
        String r20 = (String) r16;
        if (r20 != null) goto L79;
        String r110 = "";
    L207:
        nia.a.a.getClass();     // Catch: Throwable -> L82
        Object r21 = Result.constructor-impl(nia.a.h);     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r21) == false) goto L87;
        r21 = null;
    L87:
        String r22 = (String) r21;
        if (r22 != null) goto L90;
        String r111 = "";
    L213:
        nia.a.a.getClass();     // Catch: Throwable -> L93
        Object r23 = Result.constructor-impl(nia.a.m().a);     // Catch: Throwable -> L93
    L96:
        if (Result.isFailure-impl(r23) == false) goto L98;
        r23 = null;
    L98:
        String r24 = (String) r23;
        if (r24 != null) goto L101;
        String r112 = "";
    L229:
        nia.a.a.getClass();     // Catch: Throwable -> L104
        Object r25 = Result.constructor-impl(nia.a.m().c);     // Catch: Throwable -> L104
    L107:
        if (Result.isFailure-impl(r25) == false) goto L109;
        r25 = null;
    L109:
        String r26 = (String) r25;
        if (r26 != null) goto L112;
        String r113 = "";
    L113:
        if (r8 == true) goto L205;
    L125:
        String r114 = "";
    L126:
        if (r8 == true) goto L211;
    L138:
        String r27 = "";
    L225:
        nia.a.a.getClass();     // Catch: Throwable -> L141
        Object r28 = Result.constructor-impl(nia.a.g);     // Catch: Throwable -> L141
    L144:
        if (Result.isFailure-impl(r28) == false) goto L146;
        r28 = null;
    L146:
        String r29 = (String) r28;
        if (r29 != null) goto L149;
        String r115 = "";
    L235:
        nia.a.a.getClass();     // Catch: Throwable -> L152
        Object r30 = Result.constructor-impl(nia.a.i);     // Catch: Throwable -> L152
    L155:
        if (Result.isFailure-impl(r30) == false) goto L157;
        r30 = null;
    L157:
        String r31 = (String) r30;
        if (r31 == null) goto L161;
        r11 = r31;
    L161:
        Intrinsics.checkNotNullParameter(r12, "uid");
        Intrinsics.checkNotNullParameter(r15, "sn");
        Intrinsics.checkNotNullParameter(r110, "doubaoDid");
        Intrinsics.checkNotNullParameter(r111, "firstKwsModelPath");
        Intrinsics.checkNotNullParameter(r112, "sidEnrollModelPath");
        Intrinsics.checkNotNullParameter(r113, "sidEnrollModelMd5");
        Intrinsics.checkNotNullParameter(r114, "sidAuthModelPath");
        Intrinsics.checkNotNullParameter(r27, "sidAuthModelMd5");
        Intrinsics.checkNotNullParameter(r115, "dbPath");
        Intrinsics.checkNotNullParameter(r11, "silenceFilePath");
        if (StringsKt.isBlank(r15) == false) goto L221;
        FLogger.a.e("SamiEnrollEngine", "createPhoneEnrollModelService failed: sn is blank purpose=".concat(r18));
        return null;
    L221:
        nia.a.a.getClass();     // Catch: Throwable -> L167
        Object r32 = Result.constructor-impl(Boolean.valueOf(nia.a.b()));     // Catch: Throwable -> L167
    L169:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L172;
        FLogger.a.e("SamiEnrollEngine", "phone sid qnn runtime prepare failed purpose=" + r18 + ": " + r33.getMessage(), r33);
    L172:
        Boolean r34 = Boolean.FALSE;
        if (Result.isFailure-impl(r32) == false) goto L175;
        r32 = r34;
    L175:
        boolean r35 = ((Boolean) r32).booleanValue();
        if (r35 == true) goto L178;
        FLogger r36 = FLogger.a;
        StringBuilder r37 = new StringBuilder("phone sid qnn runtime not ready purpose=");
        r37.append(r18);
        r37.append(" qnnDir=");
        nia.a.a.getClass();
        r37.append(nia.a.l().e);
        r36.e("SamiEnrollEngine", r37.toString());
    L178:
        if (r35 == true) goto L181;
        return null;
    L181:
        SpeechFingerPrintEnrollService r116 = new SpeechFingerPrintEnrollService();
        r116.setListener(t);
        SpeechFingerprintEnrollParameter r38 = d(r2, r15, false, true, r19, r12, r110);
        Object r39 = Result.constructor-impl(Integer.valueOf(r116.createHandle(r38)));     // Catch: Throwable -> L184
    L186:
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L190;
        FLogger.a.e("SamiEnrollEngine", "phone enroll model createHandle failed purpose=" + r18 + ' ' + r40.getMessage());
    L190:
        if (Result.isFailure-impl(r39) == false) goto L192;
        r39 = Integer.MIN_VALUE;
    L192:
        int r41 = ((Number) r39).intValue();
        FLogger.a.i("SamiEnrollEngine", "phone enroll model createHandle purpose=" + r18 + " ret=" + r41 + " param=" + n(r38));
        if (r41 != 0) goto L223;
        return r116;
    L223:
        Result.constructor-impl(Integer.valueOf(r116.releaseHandle()));     // Catch: Throwable -> L196
        return null;
    L196:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L184:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
    L167:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
    L152:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L155
    L149:
        r115 = r29;
    L141:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L144
    L211:
        nia.a.a.getClass();     // Catch: Throwable -> L129
        Object r45 = Result.constructor-impl(nia.a.l().c);     // Catch: Throwable -> L129
    L132:
        if (Result.isFailure-impl(r45) == false) goto L134;
        r45 = null;
    L134:
        String r46 = (String) r45;
        if (r46 == null) goto L138;
        r27 = r46;
    L129:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L132
    L205:
        nia.a.a.getClass();     // Catch: Throwable -> L116
        Object r48 = Result.constructor-impl(nia.a.l().a);     // Catch: Throwable -> L116
    L119:
        if (Result.isFailure-impl(r48) == false) goto L121;
        r48 = null;
    L121:
        String r49 = (String) r48;
        if (r49 == null) goto L125;
        r114 = r49;
    L116:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L119
    L112:
        r113 = r26;
    L104:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L107
    L101:
        r112 = r24;
    L93:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L96
    L90:
        r111 = r22;
    L82:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L79:
        r110 = r20;
    L71:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L74
    L68:
        r15 = r14;
    L60:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L57:
        r12 = r10;
    L49:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L209:
        nia.a.a.getClass();     // Catch: Throwable -> L40
        Object r52 = Result.constructor-impl(nia.a.e(nia.a.l().b));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r52) == false) goto L45;
        r52 = null;
    L45:
        String r53 = (String) r52;
    L40:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L233:
        nia.a.a.getClass();     // Catch: Throwable -> L30
        Object r55 = Result.constructor-impl(Boolean.valueOf(nia.a.l().f));     // Catch: Throwable -> L30
    L32:
        Boolean r56 = Boolean.FALSE;
        if (Result.isFailure-impl(r55) == false) goto L35;
        r55 = r56;
    L35:
        r8 = ((Boolean) r55).booleanValue();
    L30:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void C(String r4, boolean r5, Integer r6, String r7) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L14
        r3.put("stage", r4);     // Catch: Throwable -> L14
        if (r5 == false) goto L6;
        String r8 = WindowEvent.WindowOpenPerfResult.SUCCESS;
    L7:
        r3.put("status", r8);     // Catch: Throwable -> L14
        if (r6 == null) goto L10;
        r3.put("ret_code", r6.intValue());     // Catch: Throwable -> L14
    L10:
        if (r7 == null) goto L12;
        r3.put("fail_stage", r7);     // Catch: Throwable -> L14
    L12:
        by7.a r9 = new by7.a("obric_legacy_phone_enroll_migrate");     // Catch: Throwable -> L14
        r9.a.merge(new TrackParams().merge(r3));     // Catch: Throwable -> L14
        r9.b();     // Catch: Throwable -> L14
        FLogger.a.i("SamiEnrollEngine", "reportLegacyPhoneEnrollMigrate payload=" + r3);     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L22;
        FLogger.a.e("SamiEnrollEngine", "reportLegacyPhoneEnrollMigrate failed: " + r11.getMessage(), r11);
        return;
    L22:
        return;
    L6:
        r8 = "failure";
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static int F(String r10, String r11, String r12, Function1 r13) {
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        if (r12 != null) goto L5;
    L59:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        nia.a r15 = nia.a.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L11
        r15.i(r2);     // Catch: Throwable -> L11
        Object r16 = Result.constructor-impl(nia.a.d());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r16) == false) goto L16;
        r16 = null;
    L16:
        r12 = (String) r16;
        if (r12 != null) goto L20;
        r12 = "";
    L20:
        if (StringsKt.isBlank(r12) == false) goto L23;
        FLogger.a.e("SamiEnrollEngine", "runPhoneEnrollDataOperationWithUid failed: sn is blank purpose=".concat(r10));
        return Integer.MIN_VALUE;
    L23:
        SpeechFingerPrintEnrollService r4 = new SpeechFingerPrintEnrollService();
        Intrinsics.checkNotNull(r2);
        SpeechFingerprintEnrollParameter r17 = f(r2, r12, r11, null);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L26
        Object r19 = Result.constructor-impl(Integer.valueOf(r4.createHandle(r17)));     // Catch: Throwable -> L26
    L28:
        Throwable r3 = Result.exceptionOrNull-impl(r19);
        if (r3 == null) goto L32;
        FLogger.a.e("SamiEnrollEngine", "phone enroll data createHandle failed purpose=" + r10 + ' ' + r3.getMessage());
    L32:
        if (Result.isFailure-impl(r19) == false) goto L34;
        r19 = Integer.MIN_VALUE;
    L34:
        int r110 = ((Number) r19).intValue();
        FLogger r5 = FLogger.a;
        r5.i("SamiEnrollEngine", "phone enroll data createHandle purpose=" + r10 + " ret=" + r110 + " param=" + n(r17));
        if (r110 == 0) goto L63;
        Result.constructor-impl(Integer.valueOf(r4.releaseHandle()));     // Catch: Throwable -> L38
    L40:
        return Integer.MIN_VALUE;
    L38:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L63:
        int r112 = ((Number) r13.invoke(r4)).intValue();     // Catch: Throwable -> L50
        r5.i("SamiEnrollEngine", "phone enroll data release purpose=" + r10 + " ret=" + r4.releaseHandle());     // Catch: Throwable -> L44
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L49;
        FLogger.a.e("SamiEnrollEngine", "phone enroll data release failed purpose=" + r10 + ' ' + r114.getMessage());
    L49:
        return r112;
    L44:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L53
        int r117 = r4.releaseHandle();     // Catch: Throwable -> L53
        FLogger.a.i("SamiEnrollEngine", "phone enroll data release purpose=" + r10 + " ret=" + r117);     // Catch: Throwable -> L53
        Object r118 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r119 = Result.exceptionOrNull-impl(r118);
        if (r119 == null) goto L71;
        FLogger.a.e("SamiEnrollEngine", "phone enroll data release failed purpose=" + r10 + ' ' + r119.getMessage());
        throw th;
    L71:
        throw th;
    L53:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        if ((!StringsKt.isBlank(r12)) == true) goto L8;
        r12 = null;
    L8:
        if (r12 != null) goto L20;
        goto L59
    }

    public static SpeechFingerprintEnrollParameter f(Context r5, String r6, String r7, String r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        nia.a.a.i(r5.getApplicationContext());     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L65:
        nia.a.a.getClass();     // Catch: Throwable -> L8
        Object r9 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L8
    L10:
        Object r1 = null;
        if (Result.isFailure-impl(r9) == false) goto L13;
        r9 = null;
    L13:
        String r10 = (String) r9;
        String r2 = "";
        if (r10 != null) goto L63;
        r10 = "";
    L63:
        String r3 = new JSONObject(r10).toString();     // Catch: Exception -> L18
    L19:
        Intrinsics.checkNotNull(r3);
        if (r7 != null) goto L22;
    L59:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
        nia.a.a.getClass();     // Catch: Throwable -> L28
        Object r12 = Result.constructor-impl(nia.a.g());     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r12) == false) goto L33;
        r12 = null;
    L33:
        r7 = (String) r12;
        if (r7 != null) goto L36;
        r7 = "";
    L36:
        String r4 = g(r7, r6);
        if (r8 != null) goto L39;
    L67:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L47
        nia.a.a.getClass();     // Catch: Throwable -> L47
        Object r14 = Result.constructor-impl(o.a.getDeviceId());     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r14) == true) goto L53;
        r1 = r14;
    L53:
        String r15 = (String) r1;
        if (r15 == null) goto L57;
        r2 = r15;
    L57:
        SpeechFingerprintEnrollParameter r16 = new SpeechFingerprintEnrollParameter();
        a.getClass();
        I(r16, MemorySourceLinkType.URL, "https://audio.doubao.com/internal");
        I(r16, "app_id", String.valueOf(AppHost.a.getAppId()));
        I(r16, "token", r10);
        I(r16, "tokenType", SAMICoreTokenType.TOKEN_TO_C_D);
        I(r16, "header", r3);
        I(r16, "appkey", "NTIQXNbrFj");
        I(r16, "business", "Pacifical");
        I(r16, "uid", r4);
        I(r16, "doubao_uid", r7);
        I(r16, "doubao_did", r2);
        I(r16, "device_did", r6);
        o(r16);
        r16.sn = r6;
        I(r16, "fw_engine_version", "1.0.0.100");
        nia.a.a.getClass();
        I(r16, "db_path", nia.a.g);
        I(r16, "sid_enroll_engine_backend", "flute");
        return r16;
    L47:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L39:
        if ((!StringsKt.isBlank(r8)) == true) goto L42;
        r8 = null;
    L42:
        if (r8 == null) goto L67;
        r2 = r8;
    L28:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L22:
        if ((!StringsKt.isBlank(r7)) == true) goto L25;
        r7 = null;
    L25:
        if (r7 != null) goto L36;
    L18:
        r3 = r10;
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    }

    public final void j(Context r6, String r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("createSamiCoreHandle begin isDoraEnroll=");
        r1.append(r8);
        r1.append(" isPhoneEnroll=");
        r1.append(r9);
        r1.append(" snLen=");
        boolean r2 = false;
        if (r7 == null) goto L5;
        int r3 = r7.length();
    L6:
        r1.append(r3);
        r0.i("SamiEnrollEngine", r1.toString());
        if (r9 == false) goto L20;
        x();
        r0.i("SamiEnrollEngine", "phone enroll local write acquire begin reason=create phone enroll handle");
        k.acquire();
        j = true;
        r0.i("SamiEnrollEngine", "phone enroll local write acquired reason=create phone enroll handle");
        c = r7;
        l = true;
        SpeechFingerPrintEnrollService r10 = i(r6.getApplicationContext(), "phone_enroll_session", true);
        if (r10 != null) goto L12;
        y("create phone enroll handle failed");
        l = false;
        r0.e("SamiEnrollEngine", "createSamiCoreHandle end phone failed");
        return;
    L12:
        Context r11 = r6.getApplicationContext();
        int r12 = r10.createASR(c(r11));
        r0.i("SamiEnrollEngine", "phone enroll createASR ret=" + r12);
        int r13 = r10.setAsrParam(b(r11, false));
        r0.i("SamiEnrollEngine", "phone enroll setAsrParam ret=" + r13);
        if (r12 != 0) goto L16;
        if (r13 != 0) goto L16;
        r2 = true;
    L16:
        if (r2 == true) goto L18;
        r0.e("SamiEnrollEngine", "phone enroll asr init failed createAsrRet=" + r12 + " setAsrRet=" + r13);
    L18:
        d = r10;
        r0.i("SamiEnrollEngine", "createSamiCoreHandle end phone sessionHandle=true");
        return;
    L20:
        x();
        if (r7 != null) goto L23;
    L24:
        r2 = true;
    L25:
        if (r2 == false) goto L27;
    L30:
        c = r7;
        l = r9;
        SpeechFingerPrintEnrollService r4 = new SpeechFingerPrintEnrollService();
        r4.setListener(t);
        r0.i("SamiEnrollEngine", "createHandle ret=" + r4.createHandle(e(this, r6, r7, r8, r9)));
        r0.i("SamiEnrollEngine", "createASR ret=" + r4.createASR(c(r6)));
        r0.i("SamiEnrollEngine", "setAsrParam ret=" + r4.setAsrParam(b(r6, r8)));
        d = r4;
        r0.i("SamiEnrollEngine", "createSamiCoreHandle end");
        return;
    L27:
        if (s() == true) goto L30;
        r0.e("SamiEnrollEngine", "createSamiCoreHandle aborted: downloaded model not ready snLen=" + r7.length());
        D("create_handle_model_not_ready");
        return;
    L23:
        if (StringsKt.isBlank(r7) == false) goto L25;
    L5:
        r3 = 0;
        goto L6
    }

    public static void B(String r4, boolean r5, String r6, Integer r7, String r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L14
        r3.put("stage", r4);     // Catch: Throwable -> L14
        if (r5 == false) goto L6;
        String r9 = WindowEvent.WindowOpenPerfResult.SUCCESS;
    L7:
        r3.put("status", r9);     // Catch: Throwable -> L14
        r3.put(WindowEvent.Params.REASON, r6);     // Catch: Throwable -> L14
        if (r7 == null) goto L10;
        r3.put("ret_code", r7.intValue());     // Catch: Throwable -> L14
    L10:
        if (r8 == null) goto L12;
        r3.put("fail_stage", r8);     // Catch: Throwable -> L14
    L12:
        by7.a r10 = new by7.a("obric_force_reenroll_wakeup_sid");     // Catch: Throwable -> L14
        r10.a.merge(new TrackParams().merge(r3));     // Catch: Throwable -> L14
        r10.b();     // Catch: Throwable -> L14
        FLogger.a.i("SamiEnrollEngine", "reportForceReEnrollWakeupSid payload=" + r3);     // Catch: Throwable -> L14
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L22;
        FLogger.a.e("SamiEnrollEngine", "reportForceReEnrollWakeupSid failed: " + r12.getMessage(), r12);
        return;
    L22:
        return;
    L6:
        r9 = "failure";
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static /* synthetic */ SpeechFingerprintEnrollParameter e(SamiEnrollEngine r7, Context r8, String r9, boolean r10, boolean r11) {
        r7.getClass();
        return d(r8, r9, r10, r11, true, null, null);
    }

    public static SpeechFingerprintEnrollParameter d(Context r16, String r17, boolean r18, boolean r19, boolean r20, String r21, String r22) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        nia.a.a.i(r16.getApplicationContext());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L173:
        nia.a.a.getClass();     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r1) == false) goto L14;
        r1 = null;
    L14:
        String r2 = (String) r1;
        String r3 = "";
        if (r2 != null) goto L17;
        String r5 = "";
    L171:
        String r6 = new JSONObject(r5).toString();     // Catch: Exception -> L20
    L21:
        Intrinsics.checkNotNull(r6);
        if (r18 == false) goto L25;
        String r4 = "Dora";
    L24:
        String r8 = r4;
        if (r19 == false) goto L30;
        nia.a.a.getClass();
        String r9 = nia.a.d();
    L33:
        boolean r10 = true;
        if (r21 != null) goto L36;
    L40:
        nia.a.a.getClass();
        String r7 = nia.a.g();
    L41:
        String r11 = r7;
        if (r22 != null) goto L44;
    L167:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L52
        nia.a.a.getClass();     // Catch: Throwable -> L52
        Object r13 = Result.constructor-impl(o.a.getDeviceId());     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r13) == false) goto L57;
        r13 = null;
    L57:
        String r14 = (String) r13;
        if (r14 == null) goto L59;
    L49:
        r3 = r14;
    L59:
        String r15 = r11 + '-' + r9;
        if (r19 == true) goto L69;
        if (r17 != null) goto L63;
    L66:
        boolean r110 = true;
    L67:
        if (r110 == true) goto L69;
    L70:
        if (r19 == false) goto L72;
        nia.a.a.getClass();
        String r111 = nia.a.h;
    L91:
        if (r19 == false) goto L93;
        nia.a.a.getClass();
        String r112 = nia.a.m().a;
    L112:
        if (r19 == false) goto L114;
        nia.a.a.getClass();
        String r113 = nia.a.i;
    L134:
        if (r10 == false) goto L151;
        if (r111 == null) goto L138;
        if (r112 == null) goto L138;
        if (r113 != null) goto L151;
    L138:
        FLogger r114 = FLogger.a;
        StringBuilder r23 = new StringBuilder("buildHandleParam require downloaded model but not ready first=");
        a r24 = b;
        if (r24 == null) goto L141;
        String r25 = r24.a();
    L142:
        r23.append(r25);
        r23.append(" sid=");
        a r26 = b;
        if (r26 == null) goto L145;
        String r27 = r26.b();
    L146:
        r23.append(r27);
        r23.append(" silent=");
        a r28 = b;
        if (r28 == null) goto L149;
        String r29 = r28.c();
    L150:
        r23.append(r29);
        r114.e("SamiEnrollEngine", r23.toString());
        goto L151
    L149:
        r29 = null;
        goto L150
    L145:
        r27 = null;
        goto L146
    L141:
        r25 = null;
    L151:
        SpeechFingerprintEnrollParameter r30 = new SpeechFingerprintEnrollParameter();
        a.getClass();
        I(r30, MemorySourceLinkType.URL, "https://audio.doubao.com/internal");
        I(r30, "app_id", String.valueOf(AppHost.a.getAppId()));
        I(r30, "token", r5);
        I(r30, "tokenType", SAMICoreTokenType.TOKEN_TO_C_D);
        I(r30, "header", r6);
        I(r30, "appkey", "NTIQXNbrFj");
        I(r30, "business", r8);
        I(r30, "uid", r15);
        I(r30, "doubao_uid", r11);
        I(r30, "doubao_did", r3);
        I(r30, "device_did", r9);
        o(r30);
        r30.sn = r9;
        I(r30, "fw_engine_version", "1.0.0.100");
        I(r30, "first_kws_model_path", r111);
        I(r30, "sid_enroll_model_path", r112);
        I(r30, "silence_file_path", r113);
        nia.a.a.getClass();
        I(r30, "sid_enroll_model_md5", nia.a.m().c);
        if (r19 == false) goto L161;
        I(r30, "sid_enroll_engine_backend", "flute");
        if (r20 == true) goto L156;
    L160:
        I(r30, "db_path", nia.a.g);
        I(r30, "encKeyInfo", nia.a.e(nia.a.m().b));
        goto L161
    L156:
        if (nia.a.l().f == false) goto L160;
        if (nia.a.b() == false) goto L160;
        I(r30, "sid_auth_model_path", nia.a.l().a);
        I(r30, "sid_auth_model_md5", nia.a.l().c);
        I(r30, "sid_auth_enc_key_info", nia.a.e(nia.a.l().b));
    L161:
        FLogger r31 = FLogger.a;
        StringBuilder r32 = new StringBuilder("buildHandleParam isDoraEnroll=");
        r32.append(r18);
        r32.append(" isPhoneEnroll=");
        r32.append(r19);
        r32.append(" snLen=");
        if (r17 == null) goto L164;
        int r33 = r17.length();
    L165:
        r32.append(r33);
        r32.append(" param=");
        r32.append(n(r30));
        r31.i("SamiEnrollEngine", r32.toString());
        return r30;
    L164:
        r33 = 0;
        goto L165
    L114:
        if (r10 == false) goto L123;
        a r115 = b;
        if (r115 == null) goto L122;
        r113 = r115.c();
        if (r113 == null) goto L122;
        a.getClass();
        if (t(r113) == true) goto L134;
    L122:
        r113 = null;
        goto L134
    L123:
        a r116 = b;
        if (r116 == null) goto L132;
        r113 = r116.c();
        if (r113 == null) goto L132;
        a.getClass();
        if (t(r113) == true) goto L131;
        r113 = null;
    L131:
        if (r113 != null) goto L134;
    L132:
        nia.a.a.getClass();
        r113 = nia.a.i;
        goto L134
    L93:
        if (r10 == false) goto L102;
        a r117 = b;
        if (r117 == null) goto L101;
        r112 = r117.b();
        if (r112 == null) goto L101;
        a.getClass();
        if (t(r112) == true) goto L112;
    L101:
        r112 = null;
        goto L112
    L102:
        a r118 = b;
        if (r118 == null) goto L111;
        r112 = r118.b();
        if (r112 == null) goto L111;
        a.getClass();
        if (t(r112) == true) goto L110;
        r112 = null;
    L110:
        if (r112 != null) goto L112;
    L111:
        nia.a.a.getClass();
        r112 = nia.a.m().a;
        goto L112
    L72:
        if (r10 == false) goto L81;
        a r119 = b;
        if (r119 == null) goto L80;
        r111 = r119.a();
        if (r111 == null) goto L80;
        a.getClass();
        if (t(r111) == true) goto L91;
    L80:
        r111 = null;
        goto L91
    L81:
        a r120 = b;
        if (r120 == null) goto L90;
        r111 = r120.a();
        if (r111 == null) goto L90;
        a.getClass();
        if (t(r111) == true) goto L89;
        r111 = null;
    L89:
        if (r111 != null) goto L91;
    L90:
        nia.a.a.getClass();
        r111 = nia.a.h;
        goto L91
    L63:
        if (StringsKt.isBlank(r17) == true) goto L66;
        r110 = false;
    L69:
        r10 = false;
    L52:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L44:
        if ((!StringsKt.isBlank(r22)) == false) goto L46;
        r14 = r22;
    L47:
        if (r14 != null) goto L49;
    L46:
        r14 = null;
        goto L47
    L36:
        if ((!StringsKt.isBlank(r21)) == false) goto L38;
        r7 = r21;
    L39:
        if (r7 != null) goto L41;
    L38:
        r7 = null;
        goto L39
    L30:
        if (r17 != null) goto L32;
        r9 = "";
        goto L33
    L32:
        r9 = r17;
        goto L33
    L25:
        if (r19 == false) goto L27;
        r4 = "Pacifical";
        goto L24
    L27:
        r4 = "Obric-" + Build.MODEL + '-' + AppHost.a.getBuildChannel();
    L20:
        r6 = r5;
        goto L21
    L17:
        r5 = r2;
    L9:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L173
    }
}
