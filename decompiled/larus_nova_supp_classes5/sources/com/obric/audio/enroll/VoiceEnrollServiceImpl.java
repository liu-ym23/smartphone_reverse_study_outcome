package com.obric.audio.enroll;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.voiceprint.v;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.assistant.spi.dora.VendorPrivateLinkDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.utils.j;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import com.obric.audio.enroll.sami.e;
import com.obric.audio.enroll.sidauth.SidAuthSessionService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import pia.d;
import sia.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002\u000e\u0017\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u001e\u0010\u001f\u001a\u00020\u001c2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0016J&\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0016J.\u0010%\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J(\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010$2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u000205H\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0014H\u0016J\u0010\u00107\u001a\u0002052\u0006\u0010+\u001a\u00020$H\u0016J\u0018\u00108\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002J \u00109\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002J \u0010;\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002J\u001d\u0010=\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0000¢\u0006\u0002\b>J\u0018\u0010?\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020$H\u0002J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020$H\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\u0010\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020$H\u0016J\u001a\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0H0GH\u0016J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020J0GH\u0016J\u0018\u0010K\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020$2\u0006\u0010L\u001a\u00020$H\u0016J\u0010\u0010M\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020$H\u0016J&\u0010M\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020$2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0016J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010E\u001a\u00020$H\u0016J\u0018\u0010O\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020$2\u0006\u0010P\u001a\u00020$H\u0016J\b\u0010Q\u001a\u00020\u001cH\u0016J\b\u0010R\u001a\u00020\u001cH\u0016J&\u0010S\u001a\u00020\u001c2\b\u0010T\u001a\u0004\u0018\u00010$2\b\u0010U\u001a\u0004\u0018\u00010$2\b\u0010V\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006Y"}, d2 = {"Lcom/obric/audio/enroll/VoiceEnrollServiceImpl;", "Lcom/obric/audio/enroll/IVoiceEnrollService;", "<init>", "()V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "phoneEnrollDataOperationLock", "", "voicePrintTrainableOperationLock", "bluetoothDeviceStore", "Lcom/obric/audio/enroll/VoiceEnrollServiceImpl$BluetoothDeviceStore;", "deleteBtAndDoraVoicePrintStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "btReceiver", "com/obric/audio/enroll/VoiceEnrollServiceImpl$btReceiver$2$1", "getBtReceiver", "()Lcom/obric/audio/enroll/VoiceEnrollServiceImpl$btReceiver$2$1;", "btReceiver$delegate", "Lkotlin/Lazy;", "btReceiverRegistered", "", "networkCallbackRegistered", "defaultVoicePrintNetworkCallback", "com/obric/audio/enroll/VoiceEnrollServiceImpl$defaultVoicePrintNetworkCallback$2$1", "getDefaultVoicePrintNetworkCallback", "()Lcom/obric/audio/enroll/VoiceEnrollServiceImpl$defaultVoicePrintNetworkCallback$2$1;", "defaultVoicePrintNetworkCallback$delegate", "registerDefaultVoicePrintNetworkCallback", "", "triggerModelDownloadIfBtConnected", "ensureInitialized", "clearVoicePrint", "callback", "Lkotlin/Function1;", "clearVoicePrintForUid", "uid", "", "clearVoicePrintForUidInternal", "clearLegacyDefaultVoicePrint", "disableContinueSpeakIfCurrentUid", "clearAllVoicePrintByUid", "fallbackUid", "releaseVoiceEnrollStateForAccountChange", "reason", "getDefaultVoicePrintEnrollStatus", "uploadDefaultVoicePrintToCloud", "deleteDefaultVoicePrintFromCloud", "setDefaultVoicePrintTrainable", "isTrainable", "isDefaultVoicePrintUploadedToCloud", "isDefaultVoicePrintRecordedWithMic0Flow", "currentLoggedInUidOrEmpty", "migrateLegacyPhoneEnrollIfNeeded", "", "skipForEnterprise", "forceReEnrollWakeupSid", "clearWakeupTruthUploadRegisterDataId", "setCloudDesiredOpForUid", "desired", "setCloudActualOpForUid", "actual", "syncDefaultVoicePrintCloudForUidExternally", "syncDefaultVoicePrintCloudForUidExternally$impl_mainlandRelease", "syncVoicePrintTrainableForUidIfNeeded", "syncAllPendingVoicePrintTrainableIfNeeded", "syncDefaultVoicePrintCloudForUidIfNeeded", "syncAllPendingUidCloudOpsIfNeeded", "bootstrapPendingCloudOpUidsIfNeeded", "getDeviceEnrollStatus", "sn", "getEnrolledDevices", "", "Lkotlin/Pair;", "getEnrolledDeviceInfos", "Lcom/obric/audio/enroll/EnrolledDeviceInfo;", "updateEnrolledDeviceName", "newName", "deleteEnrolledDevice", "isBtHeadsetVoicePrintRecorded", "addEnrolledDevice", "deviceName", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "tryDeleteBtAndDoraVoicePrintOnce", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "Companion", "BluetoothDeviceStore", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollServiceImpl implements IVoiceEnrollService {
    public static final b k = null;
    public final CoroutineScope b;
    public final Object c;
    public final Object d;
    public final a e;
    public final AtomicBoolean f;
    public final Lazy g;
    public final boolean h;
    public boolean i;
    public final Lazy j;

    /* JADX INFO: renamed from: com.obric.audio.enroll.VoiceEnrollServiceImpl$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$5", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VoiceEnrollServiceImpl this$0;

        public AnonymousClass5(VoiceEnrollServiceImpl r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r8);
            VoiceEnrollServiceImpl r9 = this.this$0;
            b r0 = VoiceEnrollServiceImpl.k;
            r9.getClass();
            Set r10 = d.f();
            Set r1 = d.e();
            LinkedHashSet r2 = new LinkedHashSet();
            r2.addAll(r10);
            r2.addAll(r1);
            Iterator r3 = r2.iterator();
            int r4 = 0;
        L6:
            if (r3.hasNext() == false) goto L22;
            String r5 = (String) r3.next();
            if (StringsKt.isBlank(r5) == true) goto L6;
            String r6 = d.d(r5);
            String r7 = d.c(r5);
            if (Intrinsics.areEqual(r6, "upload") == false) goto L12;
        L15:
            boolean r11 = true;
        L16:
            if (r11 == false) goto L6;
            if (Intrinsics.areEqual(r6, r7) == true) goto L6;
            if (r10.contains(r5) == true) goto L6;
            d.b(r5);
            r4 = r4 + 1;
            goto L6
        L12:
            if (Intrinsics.areEqual(r6, "delete") == true) goto L15;
            r11 = false;
            goto L16
        L22:
            if (r4 <= 0) goto L24;
            FLogger.a.i("VoiceEnrollServiceImpl", "bootstrapPendingCloudOpUidsIfNeeded patched=" + r4);
        L24:
            VoiceEnrollServiceImpl.x(this.this$0, "service_init");
            VoiceEnrollServiceImpl.y(this.this$0, "service_init");
            return Unit.INSTANCE;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a {
        public final Object a;
        public final pia.b b;

        /* JADX INFO: renamed from: com.obric.audio.enroll.VoiceEnrollServiceImpl$a$a, reason: collision with other inner class name */
        public static final class C0003a {
        }

        static {
        }

        public static JSONObject d() {
            JSONObject r0 = new JSONObject();
            r0.put(EffectConfiguration.KEY_VERSION, 1);
            r0.put("devices", new JSONObject());
            return r0;
        }

        public final void a() {
            Object r0 = this.a;
            monitor-enter(r0);
            g(d());     // Catch: Throwable -> L7
            FLogger.a.i("BluetoothDeviceStore", "clearAllDevices");     // Catch: Throwable -> L7
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final JSONObject e() {
            this.b.getClass();
            String r0 = pia.b.b("sva_bt_headset_voiceprint_devices_v1");
            if (StringsKt.isBlank(r0) == false) goto L19;
            FLogger.a.i("BluetoothDeviceStore", "readRoot empty, create new");
            return d();
        L19:
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
            Object r2 = Result.constructor-impl(new JSONObject(r0));     // Catch: Throwable -> L8
        L10:
            Throwable r3 = Result.exceptionOrNull-impl(r2);
            if (r3 == null) goto L14;
            FLogger.a.e("BluetoothDeviceStore", "readRoot parse failed: " + r3.getMessage());
        L14:
            if (Result.exceptionOrNull-impl(r2) == null) goto L18;
            r2 = d();
        L18:
            return (JSONObject) r2;
        L8:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public a() {
            this.a = new Object();
            this.b = pia.b.a;
        }

        public final boolean c(String r7) {
            Intrinsics.checkNotNullParameter(r7, "sn");
            boolean r2 = false;
            if (StringsKt.isBlank(r7) == false) goto L6;
            FLogger.a.i("BluetoothDeviceStore", "getEnrollStatus ignore blank sn");
            return false;
        L6:
            Object r1 = this.a;
            monitor-enter(r1);
            JSONObject r3 = e().optJSONObject("devices");     // Catch: Throwable -> L17
            if (r3 != null) goto L11;
            JSONObject r4 = null;
        L12:
            if (r4 == null) goto L14;
            r2 = r4.optBoolean("enrolled", false);     // Catch: Throwable -> L17
        L14:
            FLogger.a.i("BluetoothDeviceStore", "getEnrollStatus sn=" + r7 + " enrolled=" + r2);     // Catch: Throwable -> L17
            monitor-exit(r1);
            return r2;
        L11:
            r4 = r3.optJSONObject(r7);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        public final void g(JSONObject r3) {
            pia.b r0 = this.b;
            String r4 = r3.toString();
            r0.getClass();
            pia.b.c("sva_bt_headset_voiceprint_devices_v1", r4);
            FLogger.a.i("BluetoothDeviceStore", "writeRoot");
        }

        public static JSONObject b(JSONObject r3, String r4) {
            JSONObject r1 = r3.optJSONObject("devices");
            if (r1 != null) goto L5;
            r1 = new JSONObject();
            r3.put("devices", r1);
        L5:
            JSONObject r5 = r1.optJSONObject(r4);
            if (r5 == null) goto L8;
            return r5;
        L8:
            FLogger.a.i("BluetoothDeviceStore", "ensureDevice create new sn=" + r4);
            JSONObject r6 = new JSONObject();
            r6.put(DBDefinition.NAME, "");
            r6.put("enrolled", false);
            r6.put("blue_device_type", 0);
            r6.put("blue_product_id", 0);
            r1.put(r4, r6);
            return r6;
        }

        public final void f(String r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "sn");
            if (StringsKt.isBlank(r7) == false) goto L6;
            FLogger.a.i("BluetoothDeviceStore", "setEnrollStatus ignore blank sn");
            return;
        L6:
            Object r1 = this.a;
            monitor-enter(r1);
            JSONObject r2 = e();     // Catch: Throwable -> L11
            b(r2, r7).put("enrolled", r8);     // Catch: Throwable -> L11
            FLogger.a.i("BluetoothDeviceStore", "setEnrollStatus sn=" + r7 + " enrolled=" + r8);     // Catch: Throwable -> L11
            g(r2);     // Catch: Throwable -> L11
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r1);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static void c() {
            Intrinsics.checkNotNullParameter("default enroll success", "reason");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            Object r3 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r3) == false) goto L10;
            r3 = null;
        L10:
            String r4 = (String) r3;
            if (r4 != null) goto L14;
            r4 = "";
        L14:
            if (StringsKt.isBlank(r4) == false) goto L17;
            FLogger.a.i("VoiceEnrollServiceImpl", "onDefaultVoicePrintFreshlyEnrolled skip: uid blank reason=default enroll success");
            return;
        L17:
            Lazy r5 = d.a;
            Intrinsics.checkNotNullParameter(r4, "uid");
            if (StringsKt.isBlank(r4) == true) goto L21;
            d.i().storeBoolean("default_voice_print_mic0_recorded_".concat(r4), true);
            FLogger.a.i("VoiceEnrollUidStore", "setDefaultVoicePrintMic0Recorded uid=" + d.j(r4) + " recorded=true");
        L21:
            FLogger.a.i("VoiceEnrollServiceImpl", "onDefaultVoicePrintFreshlyEnrolled mark mic0=true uid=" + j.d(r4) + " reason=default enroll success");
            a("default enroll success");
            Object r6 = Result.constructor-impl(Boolean.valueOf(ObricEnrollInteropDelegate.b.m(r4)));     // Catch: Throwable -> L24
        L26:
            Boolean r7 = Boolean.FALSE;
            if (Result.isFailure-impl(r6) == false) goto L30;
            r6 = r7;
        L30:
            if (((Boolean) r6).booleanValue() == true) goto L33;
            FLogger.a.i("VoiceEnrollServiceImpl", "onDefaultVoicePrintFreshlyEnrolled skip upload uid=" + j.d(r4) + " reason=default enroll success");
            return;
        L33:
            String r8 = d.c(r4);
            if (Intrinsics.areEqual(r8, "none") == true) goto L36;
            d.o(r4, "none");
            FLogger.a.i("VoiceEnrollServiceImpl", "onDefaultVoicePrintFreshlyEnrolled reset actual uid=" + j.d(r4) + ' ' + r8 + " -> none reason=default enroll success");
        L36:
            d.p(r4, "upload");
            FLogger.a.i("VoiceEnrollServiceImpl", "onDefaultVoicePrintFreshlyEnrolled trigger upload uid=" + j.d(r4) + " reason=default enroll success");
            IVoiceEnrollService.a.getClass();
            IVoiceEnrollService r9 = IVoiceEnrollService.a.a();
            if (r9 != null) goto L39;
            return;
        L39:
            if ((r9 instanceof VoiceEnrollServiceImpl) == false) goto L47;
            VoiceEnrollServiceImpl r10 = (VoiceEnrollServiceImpl) r9;
            Intrinsics.checkNotNullParameter(r4, "uid");
            Intrinsics.checkNotNullParameter("default enroll success", "reason");
            BuildersKt.launch$default(r10.b, null, null, new syncDefaultVoicePrintCloudForUidExternally.1(r10, r4, "default enroll success", null), 3, null);
            return;
        L47:
            return;
        L24:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
        L5:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }

        @JvmStatic
        public static void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "reason");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r1) == false) goto L10;
            r1 = null;
        L10:
            String r2 = (String) r1;
            if (r2 != null) goto L14;
            r2 = "";
        L14:
            if (StringsKt.isBlank(r2) == false) goto L17;
            FLogger.a.i("VoiceEnrollServiceImpl", "cancelPendingDefaultVoicePrintCleanupOperation skip: uid blank reason=".concat(r7));
            return;
        L17:
            String r3 = d.d(r2);
            if (Intrinsics.areEqual(r3, "delete") == true) goto L21;
            FLogger.a.i("VoiceEnrollServiceImpl", "cancelPendingDefaultVoicePrintCleanupOperation ignored uid=" + j.d(r2) + " reason=" + r7 + " desired=" + r3);
            return;
        L21:
            d.p(r2, "none");
            FLogger.a.i("VoiceEnrollServiceImpl", "cancelPendingDefaultVoicePrintCleanupOperation done uid=" + j.d(r2) + " reason=" + r7 + " previousDesired=" + r3);
            return;
        L5:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }

        public static void b(String r7) {
            Intrinsics.checkNotNullParameter(r7, "reason");
            nia.a.a.getClass();
            String r1 = nia.a.f;
            if (StringsKt.isBlank(r1) == false) goto L21;
            FLogger.a.i("VoiceEnrollServiceImpl", "clearLegacyDefaultVoicePrintDir ignored: reason=" + r7 + " legacyDir blank");
            return;
        L21:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
            int r3 = c.a;     // Catch: Throwable -> L15
            if (r1 != null) goto L9;
            FLogger.a.e("EnrollFileUtils", "isExist: invalid input param");     // Catch: Throwable -> L15
            boolean r4 = false;
        L10:
            if (r4 == false) goto L12;
            FLogger.a.i("VoiceEnrollServiceImpl", "clearLegacyDefaultVoicePrintDir delete reason=" + r7 + " legacyDir=" + r1);     // Catch: Throwable -> L15
            c.b(r1);     // Catch: Throwable -> L15
        L13:
            Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r5 = Result.exceptionOrNull-impl(r0);
            if (r5 == null) goto L23;
            FLogger.a.e("VoiceEnrollServiceImpl", "clearLegacyDefaultVoicePrintDir failed: reason=" + r7 + ' ' + r5.getMessage());
            return;
        L23:
            return;
        L12:
            FLogger.a.i("VoiceEnrollServiceImpl", "clearLegacyDefaultVoicePrintDir ignored: reason=" + r7 + " not exists legacyDir=" + r1);     // Catch: Throwable -> L15
            goto L13
        L9:
            r4 = new PolarisFileWrapper(r1).exists();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r0 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    static {
        k = new b();
    }

    public VoiceEnrollServiceImpl() {
        CoroutineScope r4 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = r4;
        this.c = new Object();
        this.d = new Object();
        this.e = new a();
        this.f = new AtomicBoolean(false);
        Lazy r3 = LazyKt.lazy(new g(this));
        this.g = r3;
        this.j = LazyKt.lazy(new h(this));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        if (this.h == true) goto L6;
        IntentFilter r6 = new IntentFilter();     // Catch: Throwable -> L8
        r6.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L8
        r6.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L8
        u(AppHost.a.getApplication(), (VoiceEnrollServiceImpl$btReceiver$2$1) r3.getValue(), r6);     // Catch: Throwable -> L8
        this.h = true;     // Catch: Throwable -> L8
        FLogger.a.i("VoiceEnrollServiceImpl", "registerBtReceiver done");     // Catch: Throwable -> L8
        BuildersKt.launch$default(r4, null, null, new VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1(null), 3, null);     // Catch: Throwable -> L8
    L6:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L40;
        FLogger.a.e("VoiceEnrollServiceImpl", "registerBtReceiver failed: " + r8.getMessage());
    L40:
        r68.b r9 = r68.b.a;     // Catch: Throwable -> L15
        r68.b.b = SidAuthSessionService.a;     // Catch: Throwable -> L15
        FLogger.a.i("VoiceEnrollServiceImpl", "register SidAuthSessionService done");     // Catch: Throwable -> L15
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L21;
        FLogger.a.e("VoiceEnrollServiceImpl", "register SidAuthSessionService failed: " + r11.getMessage());
    L21:
        if (this.i == false) goto L38;
    L36:
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass5(this, null), 3, null);
        return;
    L38:
        Object r12 = AppHost.a.getApplication().getSystemService("connectivity");     // Catch: Throwable -> L31
        if ((r12 instanceof ConnectivityManager) == false) goto L26;
        ConnectivityManager r13 = (ConnectivityManager) r12;     // Catch: Throwable -> L31
    L27:
        if (r13 == null) goto L36;
        r13.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (VoiceEnrollServiceImpl$defaultVoicePrintNetworkCallback$2$1) this.j.getValue());     // Catch: Throwable -> L31
        this.i = true;     // Catch: Throwable -> L31
        FLogger.a.i("VoiceEnrollServiceImpl", "registerDefaultVoicePrintNetworkCallback done");     // Catch: Throwable -> L31
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r14 = Result.exceptionOrNull-impl(r2);
        if (r14 == null) goto L36;
        FLogger.a.e("VoiceEnrollServiceImpl", "registerDefaultVoicePrintNetworkCallback failed: " + r14.getMessage());
        goto L36
    L26:
        r13 = null;
    L31:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static String B() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void C() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        nia.a.a.i(AppHost.a.getApplication());     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        FLogger.a.e("VoiceEnrollServiceImpl", "EnrollGlobal.init failed: " + r2.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final List<d> m() {
        a r0 = this.e;
        Object r1 = r0.a;
        monitor-enter(r1);
        JSONObject r2 = r0.e().optJSONObject("devices");     // Catch: Throwable -> L24
        if (r2 != null) goto L7;
        r2 = new JSONObject();     // Catch: Throwable -> L24
    L7:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L24
        Iterator<String> r4 = r2.keys();     // Catch: Throwable -> L24
    L9:
        if (r4.hasNext() == false) goto L16;
        String r5 = r4.next();     // Catch: Throwable -> L24
        JSONObject r6 = r2.optJSONObject(r5);     // Catch: Throwable -> L24
        if (r6 == null) goto L9;
        if (r6.optBoolean("enrolled", false) == false) goto L9;
        r3.put(r5, new c(r6.optString(DBDefinition.NAME, ""), r6.optInt("blue_device_type", 0), r6.optInt("blue_product_id", 0)));     // Catch: Throwable -> L24
        goto L9
    L16:
        LinkedHashMap r7 = (LinkedHashMap) MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(r3), new i()), new LinkedHashMap());     // Catch: Throwable -> L24
        FLogger.a.i("BluetoothDeviceStore", "getEnrolledDeviceBluetoothInfos size=" + r7.size());     // Catch: Throwable -> L24
        monitor-exit(r1);
        ArrayList r8 = new ArrayList(r7.size());
        Iterator r9 = r7.entrySet().iterator();
    L20:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r10 = (Map.Entry) r9.next();
        String r11 = (String) r10.getKey();
        c r12 = (c) r10.getValue();
        r8.add(new d(r11, r12.a, r12.b, r12.c));
        goto L20
    L22:
        FLogger.a.i("VoiceEnrollServiceImpl", "getEnrolledDeviceInfos size=" + r8.size());
        return r8;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void n() {
        pia.b r0 = pia.b.a;
        Intrinsics.checkNotNullParameter("sva_bt_dora_voiceprint_delete_once_v1", "key");
        if (pia.b.a().getBoolean("sva_bt_dora_voiceprint_delete_once_v1", false) == false) goto L7;
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce ignored: already executed");
        return;
    L7:
        if (this.f.compareAndSet(false, true) == true) goto L10;
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce ignored: running");
        return;
    L10:
        BuildersKt.launch$default(this.b, null, null, new tryDeleteBtAndDoraVoicePrintOnce.1(this, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int o() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(AccountService.a.isEnterpriseAccount()));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return l(((Boolean) r1).booleanValue());
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void p() {
        SamiEnrollEngine.a.getClass();
        SamiEnrollEngine.u();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean c() {
        String r0 = B();
        boolean r3 = false;
        if (StringsKt.isBlank(r0) == false) goto L6;
        FLogger.a.i("VoiceEnrollServiceImpl", "isDefaultVoicePrintRecordedWithMic0Flow skip: uid blank");
        return false;
    L6:
        Lazy r1 = d.a;
        Intrinsics.checkNotNullParameter(r0, "uid");
        if (StringsKt.isBlank(r0) == true) goto L10;
        r3 = d.i().getBoolean("default_voice_print_mic0_recorded_".concat(r0), false);
    L10:
        FLogger.a.i("VoiceEnrollServiceImpl", "isDefaultVoicePrintRecordedWithMic0Flow uid=" + j.d(r0) + " recorded=" + r3);
        return r3;
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean d() {
        String r0 = B();
        if (StringsKt.isBlank(r0) == false) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(d.c(r0), "upload");
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean f() {
        C();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Boolean.valueOf(SamiEnrollEngine.a.w()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("VoiceEnrollServiceImpl", "getDefaultVoicePrintEnrollStatus failed: " + r2.getMessage());
    L10:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = r3;
    L13:
        boolean r4 = ((Boolean) r1).booleanValue();
        FLogger.a.i("VoiceEnrollServiceImpl", "getDefaultVoicePrintEnrollStatus enrolled=" + r4);
        return r4;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void k() {
        String r0 = B();
        if (StringsKt.isBlank(r0) == false) goto L6;
        FLogger.a.w("VoiceEnrollServiceImpl", "uploadDefaultVoicePrintToCloud skip: uid blank");
        return;
    L6:
        D(r0, "upload", "api_upload");
        BuildersKt.launch$default(this.b, null, null, new uploadDefaultVoicePrintToCloud.1(this, r0, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sn");
        boolean r0 = this.e.c(r5);
        FLogger.a.i("VoiceEnrollServiceImpl", "getDeviceEnrollStatus sn=" + r5 + " status=" + r0);
        return r0;
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void e(v r4) {
        String r0 = B();
        if (StringsKt.isBlank(r0) == false) goto L6;
        FLogger.a.w("VoiceEnrollServiceImpl", "clearVoicePrint skip: uid blank");
        r4.invoke(Boolean.FALSE);
        return;
    L6:
        z(r0, true, r4);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void h(boolean r10) {
        String r0 = B();
        if (StringsKt.isBlank(r0) == false) goto L6;
        FLogger.a.w("VoiceEnrollServiceImpl", "setDefaultVoicePrintTrainable skip: uid blank");
        return;
    L6:
        Lazy r1 = d.a;
        Intrinsics.checkNotNullParameter(r0, "uid");
        if (StringsKt.isBlank(r0) == true) goto L17;
        d.i().storeBoolean("default_voice_print_trainable_pending_".concat(r0), r10);
        if (StringsKt.isBlank(r0) == true) goto L16;
        Set r2 = d.h();
        if (r2.contains(r0) == true) goto L16;
        LinkedHashSet r3 = new LinkedHashSet(r2);
        r3.add(r0);
        d.i().storeStringSet("voice_print_pending_trainable_uids", r3);
        FLogger.a.i("VoiceEnrollUidStore", "addPendingVoicePrintTrainableUid uid=" + d.j(r0) + " size=" + r3.size());
    L16:
        FLogger.a.i("VoiceEnrollUidStore", "setPendingVoicePrintTrainable uid=" + d.j(r0) + " isTrainable=" + r10);
    L17:
        BuildersKt.launch$default(this.b, null, null, new setDefaultVoicePrintTrainable.1(this, r0, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void i(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        FLogger.a.i("VoiceEnrollServiceImpl", "releaseVoiceEnrollStateForAccountChange reason=" + r6);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L5
        SamiEnrollEngine.A(r6);     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L18;
        FLogger.a.e("VoiceEnrollServiceImpl", "release enroll query handle failed: " + r2.getMessage());
    L18:
        SidAuthSessionService.a.getClass();     // Catch: Throwable -> L12
        SidAuthSessionService.k(r6);     // Catch: Throwable -> L12
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L22;
        FLogger.a.e("VoiceEnrollServiceImpl", "SidAuthSessionService destroy failed: " + r8.getMessage());
        return;
    L22:
        return;
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int l(boolean r7) {
        C();
        Object r1 = this.c;
        monitor-enter(r1);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        Object r8 = Result.constructor-impl(Integer.valueOf(SamiEnrollEngine.a.v(r7)));     // Catch: Throwable -> L6
    L8:
        Throwable r3 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L17
        if (r3 == null) goto L11;
        FLogger.a.e("VoiceEnrollServiceImpl", "migrateLegacyPhoneEnrollIfNeeded failed: " + r3.getMessage());     // Catch: Throwable -> L17
    L11:
        Integer r0 = Integer.valueOf(IntCompanionObject.MIN_VALUE);     // Catch: Throwable -> L17
        if (Result.isFailure-impl(r8) == false) goto L14;
        r8 = r0;
    L14:
        int r9 = ((Number) r8).intValue();     // Catch: Throwable -> L17
        monitor-exit(r1);
        return r9;
    L17:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L8
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void q(String r7) {
        BuildersKt.launch$default(this.b, null, null, new clearAllVoicePrintByUid.1(this, null, r7, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean r(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sn");
        boolean r0 = this.e.c(r7);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Boolean.valueOf(VendorPrivateLinkDelegate.b.a()));     // Catch: Throwable -> L5
    L7:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = r3;
    L10:
        boolean r4 = ((Boolean) r2).booleanValue();
        if (r4 == false) goto L13;
        boolean r5 = false;
    L14:
        FLogger.a.i("VoiceEnrollServiceImpl", "isBtHeadsetVoicePrintRecorded sn=" + r7 + " local=" + r0 + " needActivePrivateLink=" + r4 + " -> " + r5);
        return r5;
    L13:
        r5 = r0;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int s(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        C();
        Object r1 = this.c;
        monitor-enter(r1);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r8, "reason");     // Catch: Throwable -> L6
        Object r3 = Result.constructor-impl(Integer.valueOf(SamiEnrollEngine.G("force_re_enroll", new e(r8))));     // Catch: Throwable -> L6
    L8:
        Throwable r4 = Result.exceptionOrNull-impl(r3);     // Catch: Throwable -> L19
        if (r4 == null) goto L11;
        FLogger.a.e("VoiceEnrollServiceImpl", "forceReEnrollWakeupSid failed reason=" + r8 + ": " + r4.getMessage());     // Catch: Throwable -> L19
    L11:
        Integer r0 = Integer.valueOf(IntCompanionObject.MIN_VALUE);     // Catch: Throwable -> L19
        if (Result.isFailure-impl(r3) == false) goto L14;
        r3 = r0;
    L14:
        int r5 = ((Number) r3).intValue();     // Catch: Throwable -> L19
        monitor-exit(r1);
        if (r5 != 0) goto L18;
        nia.a.a.getClass();
        A(nia.a.g(), "force re-enroll wakeup sid: ".concat(r8));
    L18:
        return r5;
    L19:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
        goto L8
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void t(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        z(r3, false, null);
    }

    public static void A(String r3, String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ObricWakeupTruthUploadDelegate.b.f(r3, r4);     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearWakeupTruthUploadRegisterDataId failed reason=" + r4 + ": " + r6.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static final void v(VoiceEnrollServiceImpl r4, String r5) {
        r4.getClass();
        String r6 = B();
        if (StringsKt.isBlank(r6) == false) goto L5;
    L8:
        FLogger.a.i("VoiceEnrollServiceImpl", "disableContinueSpeak skip uid=" + j.d(r5) + " currentUid=" + j.d(r6));
        return;
    L5:
        if (Intrinsics.areEqual(r6, r5) == false) goto L8;
        t1.a.y(false);
        FLogger.a.i("VoiceEnrollServiceImpl", "disableContinueSpeak done uid=" + j.d(r5));
    }

    public static final void x(VoiceEnrollServiceImpl r5, String r6) {
        r5.getClass();
        Set r0 = d.f();
        if (r0.isEmpty() == false) goto L5;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncAllPendingUidCloudOpsIfNeeded skip: empty pending reason=".concat(r6));
        return;
    L5:
        FLogger.a.i("VoiceEnrollServiceImpl", "syncAllPendingUidCloudOpsIfNeeded size=" + r0.size() + " reason=" + r6);
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r5.E((String) r1.next(), "pending_sync.".concat(r6));
        goto L7
    }

    public static final void y(VoiceEnrollServiceImpl r5, String r6) {
        r5.getClass();
        Set r0 = d.h();
        if (r0.isEmpty() == false) goto L5;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncAllPendingVoicePrintTrainableIfNeeded skip: empty pending reason=".concat(r6));
        return;
    L5:
        FLogger.a.i("VoiceEnrollServiceImpl", "syncAllPendingVoicePrintTrainableIfNeeded size=" + r0.size() + " reason=" + r6);
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r5.F((String) r1.next(), "pending_trainable.".concat(r6));
        goto L7
    }

    public final void E(String r11, String r12) {
        if (StringsKt.isBlank(r11) == false) goto L5;
        return;
    L5:
        String r4 = d.d(r11);
        String r0 = d.c(r11);
        if (Intrinsics.areEqual(r4, "none") == false) goto L8;
    L30:
        FLogger.a.i("VoiceEnrollServiceImpl", "syncDefaultVoicePrintCloudForUidIfNeeded skip uid=" + j.d(r11) + " desired=" + r4 + " actual=" + r0 + " reason=" + r12);
        return;
    L8:
        if (Intrinsics.areEqual(r4, r0) == true) goto L30;
        if (sia.e.a(AppHost.a.getApplication()) == true) goto L32;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncDefaultVoicePrintCloudForUidIfNeeded skip: network unavailable uid=" + j.d(r11));
        return;
    L32:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        nia.a.a.getClass();     // Catch: Throwable -> L16
        Object r2 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r2) == false) goto L21;
        r2 = null;
    L21:
        String r3 = (String) r2;
        if (r3 != null) goto L25;
        r3 = "";
    L25:
        if (StringsKt.isBlank(r3) == false) goto L28;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncDefaultVoicePrintCloudForUidIfNeeded skip: sami token not ready uid=" + j.d(r11));
        return;
    L28:
        BuildersKt.launch$default(this.b, null, null, new syncDefaultVoicePrintCloudForUidIfNeeded.1(this, r11, r4, r12, null), 3, null);
        return;
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void F(String r8, String r9) {
        if (StringsKt.isBlank(r8) == false) goto L6;
        return;
    L6:
        if (d.g(r8) != null) goto L9;
        d.m(r8);
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded skip: no pending uid=" + j.d(r8) + " reason=" + r9);
        return;
    L9:
        String r2 = B();
        if (Intrinsics.areEqual(r2, r8) == true) goto L14;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded skip: uid mismatch pendingUid=" + j.d(r8) + " currentUid=" + j.d(r2) + " reason=" + r9);
        return;
    L14:
        if (sia.e.a(AppHost.a.getApplication()) == true) goto L48;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded skip: network unavailable uid=" + j.d(r8));
        return;
    L48:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        nia.a.a.getClass();     // Catch: Throwable -> L19
        Object r4 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r4) == false) goto L24;
        r4 = null;
    L24:
        String r5 = (String) r4;
        if (r5 != null) goto L28;
        r5 = "";
    L28:
        if (StringsKt.isBlank(r5) == false) goto L31;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded skip: sami token not ready uid=" + j.d(r8));
        return;
    L31:
        Object r6 = this.d;
        monitor-enter(r6);
        Boolean r7 = d.g(r8);     // Catch: Throwable -> L45
        if (r7 != null) goto L36;
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded skip in lock: no pending uid=" + j.d(r8) + " reason=" + r9);     // Catch: Throwable -> L45
    L42:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r6);
        return;
    L36:
        SamiEnrollEngine r1 = SamiEnrollEngine.a;     // Catch: Throwable -> L45
        boolean r11 = r7.booleanValue();     // Catch: Throwable -> L45
        r1.getClass();     // Catch: Throwable -> L45
        int r12 = SamiEnrollEngine.H(r8, r11);     // Catch: Throwable -> L45
        if (r12 == 0) goto L39;
    L41:
        FLogger.a.i("VoiceEnrollServiceImpl", "syncVoicePrintTrainableForUidIfNeeded uid=" + j.d(r8) + " isTrainable=" + r7 + " ret=" + r12 + " reason=" + r9);     // Catch: Throwable -> L45
        goto L42
    L39:
        if (Intrinsics.areEqual(d.g(r8), r7) == false) goto L41;
        d.m(r8);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void g(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "sn");
        Intrinsics.checkNotNullParameter(r10, "deviceName");
        FLogger r0 = FLogger.a;
        r0.i("VoiceEnrollServiceImpl", "addEnrolledDevice sn=" + r9 + " nameLen=" + StringsKt.trim(r10).toString().length());
        a r1 = this.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "sn");
        Intrinsics.checkNotNullParameter(r10, "newName");
        if (StringsKt.isBlank(r9) == false) goto L5;
        r0.i("BluetoothDeviceStore", "updateDeviceName ignore blank sn");
    L15:
        this.e.f(r9, true);
        return;
    L5:
        String r11 = StringsKt.trim(r10).toString();
        if (r11.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r0.i("BluetoothDeviceStore", "updateDeviceName ignore empty name sn=" + r9);
        goto L15
    L11:
        Object r4 = r1.a;
        monitor-enter(r4);
        JSONObject r5 = r1.e();     // Catch: Throwable -> L17
        a.b(r5, r9).put(DBDefinition.NAME, r11);     // Catch: Throwable -> L17
        r0.i("BluetoothDeviceStore", "updateDeviceName sn=" + r9 + " nameLen=" + r11.length());     // Catch: Throwable -> L17
        r1.g(r5);     // Catch: Throwable -> L17
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r4);
    L17:
        th = move-exception;
        throw th;
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void j(String r8, com.obric.assistant.settings.voiceprint.g r9) {
        Intrinsics.checkNotNullParameter(r8, "sn");
        FLogger.a.i("VoiceEnrollServiceImpl", "deleteEnrolledDevice sn=" + r8);
        this.e.f(r8, false);
        r9.invoke(Boolean.TRUE);
        BuildersKt.launch$default(this.b, null, null, new deleteEnrolledDevice.1(r8, null), 3, null);
    }

    public static void D(String r6, String r7, String r8) {
        if (StringsKt.isBlank(r6) == false) goto L5;
        return;
    L5:
        String r0 = d.d(r6);
        if (Intrinsics.areEqual(r0, r7) == false) goto L9;
        FLogger.a.i("VoiceEnrollServiceImpl", "setCloudDesiredOpForUid noop uid=" + j.d(r6) + " desired=" + r7 + " reason=" + r8);
        return;
    L9:
        d.p(r6, r7);
        FLogger.a.i("VoiceEnrollServiceImpl", "setCloudDesiredOpForUid uid=" + j.d(r6) + ' ' + r0 + " -> " + r7 + " reason=" + r8);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void u(Application r8, VoiceEnrollServiceImpl$btReceiver$2$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void b(String r2, String r3, String r4) {
        SamiEnrollEngine.a.getClass();
        SamiEnrollEngine.J(r2, r3, r4);
    }

    public final void z(String r11, boolean r12, v r13) {
        if (StringsKt.isBlank(r11) == false) goto L8;
        FLogger.a.i("VoiceEnrollServiceImpl", "clearVoicePrintForUid skip: blank uid");
        if (r13 == null) goto L10;
        r13.invoke(Boolean.FALSE);
        return;
    L10:
        return;
    L8:
        BuildersKt.launch$default(this.b, null, null, new clearVoicePrintForUidInternal.1(this, r11, r13, r12, null), 3, null);
    }

    public static final void w(VoiceEnrollServiceImpl r3, String r4, String r5, String r6) {
        r3.getClass();
        if (StringsKt.isBlank(r4) == true) goto L10;
        String r7 = d.c(r4);
        if (Intrinsics.areEqual(r7, r5) == true) goto L11;
        d.o(r4, r5);
        FLogger.a.i("VoiceEnrollServiceImpl", "setCloudActualOpForUid uid=" + j.d(r4) + ' ' + r7 + " -> " + r5 + " reason=" + r6);
        return;
    L11:
        return;
    }
}
