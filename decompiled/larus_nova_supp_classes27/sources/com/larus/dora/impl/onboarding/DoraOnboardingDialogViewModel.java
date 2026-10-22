package com.larus.dora.impl.onboarding;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.h.HSKU;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.ReplaceBindAndConnectResult;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J$\u0010\u001d\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010&\u001a\u00020\u001cJ\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010(H\u0002J&\u0010/\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0083@¢\u0006\u0002\u00101J,\u0010/\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f022\u0006\u00100\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0083@¢\u0006\u0002\u00103J\u0012\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\"\u00107\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(2\u0006\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010:\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(J\u001d\u0010:\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010<¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(J\u001d\u0010>\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010<¢\u0006\u0002\u0010=J \u0010?\u001a\u00020,2\u0006\u0010.\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010<H\u0082@¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(J\u000e\u0010B\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(J\u000e\u0010C\u001a\u00020<H\u0082@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020(J\u001e\u0010F\u001a\u00020G2\u0006\u0010.\u001a\u00020(2\u0006\u0010H\u001a\u00020!H\u0082@¢\u0006\u0002\u0010IR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001a\u0010'\u001a\u00020!*\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006L"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "uiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_actionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "actionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "scanTimeoutJob", "Lkotlinx/coroutines/Job;", "doraScanCallback", "Landroid/bluetooth/le/ScanCallback;", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "doraLinkCallback", "com/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel$doraLinkCallback$1;", "onCleared", "", "startScan", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "sku", "", "scanForALongTime", "", "productTypes", "", "stopScan", "log", "Lcom/bytedance/dora/device/DoraDevice;", "getLog", "(Lcom/bytedance/dora/device/DoraDevice;)Ljava/lang/String;", "shouldIgnoreUnsupportedHDevice", "", "isOtherSmartDevice", "device", "scanForDora", "skuParam", "(Lcom/bytedance/dora/annotation/ProductNameType;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/List;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDoraG2ScanResult", "result", "Landroid/bluetooth/le/ScanResult;", "onDeviceFound", "where", "scanCallback", "bindAndConnect", "bluetoothOffToastResId", "", "(Lcom/bytedance/dora/device/DoraDevice;Ljava/lang/Integer;)V", "replaceBindAndConnect", "showBluetoothOffFailureIfNeeded", "(Lcom/bytedance/dora/device/DoraDevice;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelUnbind", "jumpUnbind", "getDeviceAuthAbilityFlag", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authDevice", "verifyToken", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel$VerifyTokenResult;", "token", "(Lcom/bytedance/dora/device/DoraDevice;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VerifyTokenResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingDialogViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long SCAN_FOR_A_LONG_TIME = 12000;
    private static final long SCAN_NO_LIMIT_TIME = 3000;
    private static final String TAG = "DoraOnboardingDialogViewModel";
    private static final String URL_DEVICE_AUTH = "/alice/w/device/verify_token";
    private static final long VERIFY_TOKEN_SUCCESS_CODE = 0;
    private static final long VERIFY_TOKEN_THROWABLE_ERROR_CODE = -2;
    private static final long VERIFY_TOKEN_UNKNOWN_ERROR_CODE = -1;
    private final MutableSharedFlow<o0> _actionSharedFlow;
    private final z0<q0> _uiStateFlow;
    private final d1<o0> actionSharedFlow;
    private final ExecutorCoroutineDispatcher dispatcher;
    private final DoraOnboardingDialogViewModel$doraLinkCallback$1 doraLinkCallback;
    private ScanCallback doraScanCallback;
    private Job scanTimeoutJob;
    private final i1<q0> uiStateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$authDevice$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$authDevice$1", f = "DoraOnboardingDialogViewModel.kt", i = {0, 4, 4, 4, 6, 6, 6}, l = {760, 764, 773, 787, 797, 800, 811}, m = "invokeSuspend", n = {"startTime", "startTime", "getSecurityAuthTokenStartTime", "verifyTokenStartTime", "startTime", "getSecurityAuthTokenStartTime", "verifyTokenStartTime"}, s = {"J$0", "J$0", "J$1", "J$2", "J$0", "J$1", "J$2"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        long J$0;
        long J$1;
        long J$2;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public AnonymousClass1(DoraOnboardingDialogViewModel r1, DoraDevice r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public static final /* synthetic */ Object access$invokeSuspend$authFailed(DoraDevice r0, DoraOnboardingDialogViewModel r1, com.larus.dora.impl.onboarding.a r2, long r3, long r5, long r7, Continuation r9) {
            return a(r0, r1, r2, r3, r5, r7, r9);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r210) {
            Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L13;
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            long r0 = this.J$2;
            long r2 = this.J$1;
            long r4 = this.J$0;
            ResultKt.throwOnFailure(r210);
        L66:
            int r6 = m0.a;
            m0.d(true, com.larus.dora.impl.onboarding.a.c.b, r2 - r4, r0 - r2, SystemClock.elapsedRealtime() - r0);
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r210);
        L61:
            return Unit.INSTANCE;
        L8:
            long r3 = this.J$2;
            long r5 = this.J$1;
            long r7 = this.J$0;
            ResultKt.throwOnFailure(r210);
            Object r1 = r210;
            long r8 = r3;
        L55:
            b r9 = (b) r1;
            if ((r9 instanceof b.a) == false) goto L62;
            DoraDevice r10 = this.$device;
            DoraOnboardingDialogViewModel r11 = this.this$0;
            com.larus.dora.impl.onboarding.a.d r12 = new com.larus.dora.impl.onboarding.a.d(((b.a) r9).a);
            long r13 = r5 - r7;
            long r15 = r8 - r5;
            long r16 = SystemClock.elapsedRealtime() - r8;
            this.label = 6;
            if (a(r10, r11, r12, r13, r15, r16, this) != r14) goto L61;
            return r14;
        L62:
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "authDevice: " + this.$device.sn + " success");
            MutableSharedFlow r17 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.b r18 = new o0.b(this.$device);
            this.J$0 = r7;
            this.J$1 = r5;
            this.J$2 = r8;
            this.label = 7;
            if (r17.emit(r18, this) != r14) goto L65;
            return r14;
        L65:
            r0 = r8;
            r2 = r5;
            r4 = r7;
            goto L66
        L9:
            ResultKt.throwOnFailure(r210);
        L72:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r210);
        L29:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r210);
        L22:
            return Unit.INSTANCE;
        L12:
            long r20 = this.J$0;
            ResultKt.throwOnFailure(r210);
            Object r21 = r210;
        L16:
            int r22 = ((Number) r21).intValue();
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "authDevice: " + this.$device.sn + " deviceAuthAbilityFlag=" + r22);
            if (r22 != 2) goto L24;
            DoraDevice r23 = this.$device;
            DoraOnboardingDialogViewModel r24 = this.this$0;
            com.larus.dora.impl.onboarding.a.b r25 = com.larus.dora.impl.onboarding.a.b.b;
            long r26 = SystemClock.elapsedRealtime() - r20;
            this.label = 2;
            if (invokeSuspend$authFailed$default(r23, r24, r25, r26, DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE, DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE, this, 48, null) != r14) goto L22;
            return r14;
        L24:
            if (r22 != 0) goto L30;
            MutableSharedFlow r27 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.b r28 = new o0.b(this.$device);
            this.label = 3;
            if (r27.emit(r28, this) != r14) goto L29;
            return r14;
        L30:
            long r30 = SystemClock.elapsedRealtime();
            String r110 = ILoginService.a.getAccountInfo().c;
            String r111 = com.larus.platform.service.o.a.getDeviceId();
            if (o59.a.m(Boxing.boxInt(this.$device.productId)) == false) goto L33;
            int r31 = 2;
        L34:
            mj4.f r112 = kj4.a.g().c;
            r112.getClass();
            byte[] r32 = {1, 1, (byte) r31};
            r32 = pk4.n.u(r32, pk4.n.u(new byte[]{2, 8}, pk4.n.m(CastLongProtector.parseLong(r110))));     // Catch: NumberFormatException -> L37
        L73:
            r32 = pk4.n.u(r32, pk4.n.u(new byte[]{3, 8}, pk4.n.m(CastLongProtector.parseLong(r111))));     // Catch: NumberFormatException -> L41
        L43:
            r112.d.j(1, 32, pk4.n.u(new byte[]{-127, (byte) r32.length}, r32), 7000);
            byte[] r33 = r112.t;
            if (r33 != null) goto L46;
        L68:
            long r34 = SystemClock.elapsedRealtime() - r30;
            this.label = 4;
            if (invokeSuspend$authFailed$default(this.$device, this.this$0, com.larus.dora.impl.onboarding.a.C0087a.b, r30 - r20, r34, DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE, this, 32, null) != r14) goto L72;
            return r14;
        L46:
            if (r33.length != 0) goto L48;
            boolean r35 = true;
        L49:
            if (r35 == true) goto L68;
            r8 = SystemClock.elapsedRealtime();
            DoraOnboardingDialogViewModel r36 = this.this$0;
            DoraDevice r37 = this.$device;
            String r38 = Base64.encodeToString(r33, 2);
            this.J$0 = r20;
            this.J$1 = r30;
            this.J$2 = r8;
            this.label = 5;
            r1 = DoraOnboardingDialogViewModel.access$verifyToken(r36, r37, r38, this);
            if (r1 != r14) goto L54;
            return r14;
        L54:
            r5 = r30;
            r7 = r20;
            goto L55
        L48:
            r35 = false;
        L41:
            e = move-exception;
            pk4.j.c("DoraBuds", "getSecurityAuthToken deviceId=" + r111 + " NumberFormatException", e);
        L37:
            e = move-exception;
            pk4.j.c("DoraBuds", "getSecurityAuthToken userId=" + r110 + " NumberFormatException", e);
            goto L73
        L33:
            r31 = 1;
            goto L34
        L13:
            ResultKt.throwOnFailure(r210);
            r20 = SystemClock.elapsedRealtime();
            DoraOnboardingDialogViewModel r40 = this.this$0;
            this.J$0 = r20;
            this.label = 1;
            r21 = DoraOnboardingDialogViewModel.access$getDeviceAuthAbilityFlag(r40, this);
            if (r21 != r14) goto L16;
            return r14;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static final Object a(DoraDevice r18, DoraOnboardingDialogViewModel r110, com.larus.dora.impl.onboarding.a r20, long r21, long r23, long r25, Continuation<? super Unit> r27) {
            com.larus.dora.impl.onboarding.a r1 = r20;
            if ((r27 instanceof DoraOnboardingDialogViewModel$authDevice$1$authFailed$1) == false) goto L7;
            DoraOnboardingDialogViewModel$authDevice$1$authFailed$1 r3 = (DoraOnboardingDialogViewModel$authDevice$1$authFailed$1) r27;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            if (r6 == 0) goto L18;
            if (r6 == 1) goto L17;
            if (r6 == 2) goto L16;
            if (r6 != 3) goto L15;
            long r0 = r3.J$2;
            long r7 = r3.J$1;
            long r8 = r3.J$0;
            com.larus.dora.impl.onboarding.a r9 = (com.larus.dora.impl.onboarding.a) r3.L$0;
            ResultKt.throwOnFailure(r2);
            com.larus.dora.impl.onboarding.a r11 = r9;
        L30:
            int r10 = m0.a;
            m0.d(false, r11, r8, r7, r0);
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r0 = r3.J$2;
            long r12 = r3.J$1;
            long r13 = r3.J$0;
            r11 = (com.larus.dora.impl.onboarding.a) r3.L$1;
            DoraOnboardingDialogViewModel r14 = (DoraOnboardingDialogViewModel) r3.L$0;
            ResultKt.throwOnFailure(r2);
            long r15 = r12;
        L26:
            MutableSharedFlow r16 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(r14);
            o0.a r17 = o0.a.a;
            r3.L$0 = r11;
            r3.L$1 = null;
            r3.J$0 = r13;
            r3.J$1 = r15;
            r3.J$2 = r0;
            r3.label = 3;
            if (r16.emit(r17, r3) != r5) goto L29;
            return r5;
        L29:
            r7 = r15;
            r8 = r13;
            goto L30
        L17:
            long r22 = r3.J$2;
            long r24 = r3.J$1;
            long r111 = r3.J$0;
            com.larus.dora.impl.onboarding.a r26 = (com.larus.dora.impl.onboarding.a) r3.L$2;
            DoraOnboardingDialogViewModel r112 = (DoraOnboardingDialogViewModel) r3.L$1;
            DoraDevice r113 = (DoraDevice) r3.L$0;
            ResultKt.throwOnFailure(r2);
            long r114 = r22;
            r1 = r26;
            r15 = r24;
            long r115 = r111;
        L22:
            kj4.a r28 = kj4.a.g();
            r3.L$0 = r112;
            r3.L$1 = r1;
            r3.L$2 = null;
            r3.J$0 = r115;
            r3.J$1 = r15;
            com.larus.dora.impl.onboarding.a r30 = r1;
            r0 = r114;
            r3.J$2 = r0;
            r3.label = 2;
            if (DoraAdapterExtKt.f(r28, r113) != r5) goto L25;
            return r5;
        L25:
            r13 = r115;
            r14 = r112;
            r11 = r30;
            goto L26
        L18:
            ResultKt.throwOnFailure(r2);
            g49.d.b(DoraOnboardingDialogViewModel.TAG, "authDevice: " + r18.sn + " failed due to " + r1);
            kj4.a r31 = kj4.a.g();
            r3.L$0 = r18;
            r3.L$1 = r110;
            r3.L$2 = r1;
            r115 = r21;
            r3.J$0 = r115;
            r3.J$1 = r23;
            r3.J$2 = r25;
            r3.label = 1;
            if (DoraAdapterExtKt.R(r31, false) != r5) goto L21;
            return r5;
        L21:
            r15 = r23;
            r114 = r25;
            r113 = r18;
            r112 = r110;
        L7:
            r3 = new DoraOnboardingDialogViewModel$authDevice$1$authFailed$1(r27);
            goto L8
        }

        public static /* synthetic */ Object invokeSuspend$authFailed$default(DoraDevice r13, DoraOnboardingDialogViewModel r14, com.larus.dora.impl.onboarding.a r15, long r16, long r18, long r20, Continuation r22, int r23, Object r24) {
            if ((r23 & 16) == 0) goto L5;
            long r8 = 0;
        L7:
            if ((r23 & 32) == 0) goto L9;
            long r10 = 0;
        L11:
            return a(r13, r14, r15, r16, r8, r10, r22);
        L9:
            r10 = r20;
            goto L11
        L5:
            r8 = r18;
            goto L7
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final long a;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((a) r8).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (int) (r0 ^ (r0 >>> 32));
            }

            public final String toString() {
                return "Failure(code=" + this.a + ')';
            }

            public a(long r1) {
                this.a = r1;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$b$b, reason: collision with other inner class name */
        public static final class C0086b extends b {
            public static final C0086b a = null;

            static {
                a = new C0086b();
            }

            public C0086b() {
            }
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$bindAndConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$bindAndConnect$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {546, 558, 569, 574, 583, 596, 599, 611}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $bluetoothOffToastResId;
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$bindAndConnect$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BindAndConnectResult.values().length];
                r0[BindAndConnectResult.SERVER_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[BindAndConnectResult.SERVER_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[BindAndConnectResult.SERVER_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[BindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[BindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[BindAndConnectResult.SUCCESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                a = r0;
            }
        }

        public C03671(DoraOnboardingDialogViewModel r1, DoraDevice r2, Integer r3, Continuation<? super C03671> r4) {
            this.this$0 = r1;
            this.$device = r2;
            this.$bluetoothOffToastResId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03671(this.this$0, this.$device, this.$bluetoothOffToastResId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L14;
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r8);
        L73:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r8);
        L63:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.a(this.$device));
            goto L73
        L8:
            ResultKt.throwOnFailure(r8);
        L57:
            if (((Boolean) r8).booleanValue() == true) goto L59;
            MutableSharedFlow r9 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r1 = new o0.d(AppHost.a.getApplication().getString(2131903935, new Object[]{o59.a.g(this.$device)}));
            this.label = 7;
            if (r9.emit(r1, this) != r0) goto L63;
            return r0;
        L59:
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r8);
        L67:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.a(this.$device));
            goto L73
        L10:
            ResultKt.throwOnFailure(r8);
        L71:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.d(this.$device));
            goto L73
        L11:
            ResultKt.throwOnFailure(r8);
        L45:
            BindAndConnectResult r10 = (BindAndConnectResult) r8;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "bindAndConnect: " + DoraOnboardingDialogViewModel.access$getLog(this.this$0, this.$device) + " result=" + r10);
            switch(a.a[r10.ordinal()]) {
                case 1: goto L68;
                case 2: goto L68;
                case 3: goto L64;
                case 4: goto L53;
                case 5: goto L53;
                case 6: goto L50;
                case 7: goto L49;
                default: goto L48;
            };
        L49:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.b(this.$device));
            goto L73
        L50:
            MutableSharedFlow r11 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.c r2 = new o0.c(this.$device);
            this.label = 8;
            if (r11.emit(r2, this) != r0) goto L73;
            return r0;
        L53:
            DoraOnboardingDialogViewModel r12 = this.this$0;
            DoraDevice r3 = this.$device;
            Integer r4 = this.$bluetoothOffToastResId;
            this.label = 6;
            r8 = DoraOnboardingDialogViewModel.access$showBluetoothOffFailureIfNeeded(r12, r3, r4, this);
            if (r8 != r0) goto L57;
            return r0;
        L64:
            MutableSharedFlow r13 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r5 = new o0.d(AppHost.a.getApplication().getString(2131903938, new Object[]{o59.a.g(this.$device)}));
            this.label = 5;
            if (r13.emit(r5, this) != r0) goto L67;
            return r0;
        L68:
            MutableSharedFlow r14 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r6 = new o0.d(AppHost.a.getApplication().getString(2131908080));
            this.label = 4;
            if (r14.emit(r6, this) != r0) goto L71;
            return r0;
        L48:
            throw new NoWhenBranchMatchedException();
        L12:
            ResultKt.throwOnFailure(r8);
        L40:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r8);
        L18:
            if (((Boolean) r8).booleanValue() == false) goto L22;
            return Unit.INSTANCE;
        L22:
            if (o59.a.r(this.$device) == false) goto L41;
            DoraDevice r15 = this.$device;
            if (r15._device == null) goto L41;
            String r16 = r15.name;
            if (r16 != null) goto L28;
        L30:
            boolean r17 = false;
        L31:
            if (r17 == false) goto L41;
            AppHost.Companion r18 = AppHost.a;
            if (com.larus.dora.impl.core.j.a(r18.getApplication()).contains(this.$device.mac) == false) goto L42;
            Lazy r7 = com.larus.dora.impl.core.t.a;
            if (com.larus.dora.impl.core.t.c(this.$device._device, UUID.fromString("00101020-4C42-0065-636E-614465747942")) == true) goto L42;
            DoraBuryPointManager.a.L("dora_h_connect_fail_lowedition", MapsKt.mapOf(TuplesKt.to("name", this.$device.name)));
            MutableSharedFlow r20 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r21 = new o0.d(r18.getApplication().getString(2131903101), TOAST_TYPE.TOAST_TYPE_WARNING);
            this.label = 2;
            if (r20.emit(r21, this) != r0) goto L40;
            return r0;
        L42:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.c(this.$device));
            kj4.a r22 = kj4.a.g();
            DoraDevice r23 = this.$device;
            this.label = 3;
            r8 = DoraAdapterExtKt.a(r22, r23, this);
            if (r8 != r0) goto L45;
            return r0;
        L28:
            if (StringsKt.contains(r16, "clip", true) != true) goto L30;
            r17 = true;
        L41:
            g49.d.a(DoraOnboardingDialogViewModel.TAG, "bindAndConnect: not H device or device name is not match, skip spp check");
            goto L42
        L14:
            ResultKt.throwOnFailure(r8);
            DoraOnboardingDialogViewModel r24 = this.this$0;
            DoraDevice r25 = this.$device;
            Integer r26 = this.$bluetoothOffToastResId;
            this.label = 1;
            r8 = DoraOnboardingDialogViewModel.access$showBluetoothOffFailureIfNeeded(r24, r25, r26, this);
            if (r8 != r0) goto L18;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class c extends ScanCallback {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ProductNameType b;
        public final /* synthetic */ DoraOnboardingDialogViewModel c;
        public final /* synthetic */ List<ProductNameType> d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Ref.BooleanRef f;
        public final /* synthetic */ Set<Integer> g;
        public final /* synthetic */ Set<Integer> h;
        public final /* synthetic */ Set<Integer> i;
        public final /* synthetic */ Ref.LongRef j;
        public final /* synthetic */ Set<String> k;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> l;

        public final String toString() {
            return "ScanCallback@" + Integer.toHexString(hashCode());
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.b(DoraOnboardingDialogViewModel.TAG, "onScanFailed# " + r3);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r7, ScanResult r8) {
            if (this.a == false) goto L6;
            DoraDevice r9 = pk4.a.j(r8, this.b.vendorID);
        L23:
            StringBuilder r10 = new StringBuilder("onScanResult# ");
            String r1 = null;
            if (r9 == null) goto L26;
            String r2 = DoraOnboardingDialogViewModel.access$getLog(this.c, r9);
        L27:
            r10.append(r2);
            r10.append(", hasInputMac=");
            r10.append(this.e);
            r10.append(", scanNoLimit=");
            r10.append(this.f.element);
            r10.append(", isOtherSmartDevice=");
            r10.append(this.a);
            r10.append("，device name=");
            if (r9 == null) goto L30;
            r1 = r9.name;
        L30:
            r10.append(r1);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, r10.toString());
            if (DoraOnboardingDialogViewModel.access$shouldIgnoreUnsupportedHDevice(this.c, this.a, r9) == false) goto L33;
            return;
        L33:
            if (r9 == null) goto L83;
            String r11 = r9.mac;
            if (r11 == null) goto L90;
            boolean r3 = this.a;
            if (r3 == false) goto L40;
            r9.mode = 1;
        L40:
            if (r3 == true) goto L48;
            if (this.g.contains(Integer.valueOf(r9.type)) == false) goto L48;
            if (this.h.contains(Integer.valueOf(r9.productId)) == true) goto L48;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "ignore scan result because productId=" + r9.productId + " is not in targetProductIds=" + this.h);
            return;
        L48:
            if (this.a == true) goto L54;
            if (this.i.contains(Integer.valueOf(r9.type)) == true) goto L54;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "ignore scan result because deviceType=" + r9.type + " is not in targetDeviceTypes=" + this.i);
            return;
        L54:
            if (kj4.a.g().getDoraLinkState(r9) != 2) goto L57;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "-----ignore because this is connected");
            return;
        L57:
            Ref.LongRef r0 = this.j;
            if (r0.element <= DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE) goto L61;
            r0.element = DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE;
        L61:
            if (this.e == false) goto L73;
            if (this.f.element == true) goto L73;
            if (this.k.contains(r11) == false) goto L68;
            DoraOnboardingDialogViewModel.access$onDeviceFound(this.c, r9, "onScanResult#1", this);
            return;
        L68:
            if (o59.a.t(r9) == false) goto L85;
            Ref.ObjectRef<DoraDevice> r12 = this.l;
            if (r12.element != null) goto L86;
            r12.element = r9;
            return;
        L86:
            return;
        L85:
            return;
        L73:
            if (o59.a.t(r9) == false) goto L75;
        L78:
            DoraOnboardingDialogViewModel.access$onDeviceFound(this.c, r9, "onScanResult#2", this);
            return;
        L75:
            if (this.f.element == true) goto L77;
            return;
        L77:
            if (this.k.contains(r11) == true) goto L78;
            return;
        L90:
            return;
        L83:
            return;
        L26:
            r2 = null;
            goto L27
        L6:
            if (DoraOnboardingDialogViewModel.access$isDoraG2ScanResult(this.c, r8) == true) goto L22;
            List<ProductNameType> r13 = this.d;
            if ((r13 instanceof Collection) == true) goto L10;
        L12:
            Iterator<T> r14 = r13.iterator();
        L14:
            if (r14.hasNext() == false) goto L18;
            if (o59.a.m(Integer.valueOf(((ProductNameType) r14.next()).id)) == true) goto L14;
            boolean r15 = false;
        L19:
            if (r15 == true) goto L22;
            r9 = kj4.a.g().convertScanResultToDoraDevice(r8);
        L18:
            r15 = true;
            goto L19
        L10:
            if (r13.isEmpty() == false) goto L12;
        L22:
            r9 = kj4.a.g().convertScanResultToDoraDeviceV2(r8);
            goto L23
        }

        public c(boolean r1, ProductNameType r2, DoraOnboardingDialogViewModel r3, List<? extends ProductNameType> r4, boolean r5, Ref.BooleanRef r6, Set<Integer> r7, Set<Integer> r8, Set<Integer> r9, Ref.LongRef r10, Set<String> r11, Ref.ObjectRef<DoraDevice> r12) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$cancelUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$cancelUnbind$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {701}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03681(DoraOnboardingDialogViewModel r1, DoraDevice r2, Continuation<? super C03681> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03681(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.d(this.$device));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "cancelUnbind: " + DoraOnboardingDialogViewModel.access$getLog(this.this$0, this.$device));
            MutableSharedFlow r9 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r2 = new o0.d(AppHost.a.getApplication().getString(2131903935, new Object[]{o59.a.g(this.$device)}));
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$getDeviceAuthAbilityFlag$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel", f = "DoraOnboardingDialogViewModel.kt", i = {0}, l = {736}, m = "getDeviceAuthAbilityFlag", n = {"i"}, s = {"I$0"})
    public static final class C03691 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03691(DoraOnboardingDialogViewModel r1, Continuation<? super C03691> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraOnboardingDialogViewModel.access$getDeviceAuthAbilityFlag(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$jumpUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$jumpUnbind$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03701(DoraOnboardingDialogViewModel r1, DoraDevice r2, Continuation<? super C03701> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03701(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "jump factory Page: " + DoraOnboardingDialogViewModel.access$getLog(this.this$0, this.$device));
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.d(this.$device));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$replaceBindAndConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$replaceBindAndConnect$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {627, 631, 636, 645, 658, 661}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $bluetoothOffToastResId;
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$replaceBindAndConnect$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReplaceBindAndConnectResult.values().length];
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ReplaceBindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ReplaceBindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ReplaceBindAndConnectResult.SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public C03711(DoraOnboardingDialogViewModel r1, DoraDevice r2, Integer r3, Continuation<? super C03711> r4) {
            this.this$0 = r1;
            this.$device = r2;
            this.$bluetoothOffToastResId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03711(this.this$0, this.$device, this.$bluetoothOffToastResId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r7);
        L37:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.a(this.$device));
        L47:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r7);
        L31:
            if (((Boolean) r7).booleanValue() == true) goto L33;
            MutableSharedFlow r8 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r1 = new o0.d(AppHost.a.getApplication().getString(2131903935, new Object[]{o59.a.g(this.$device)}));
            this.label = 6;
            if (r8.emit(r1, this) != r0) goto L37;
            return r0;
        L33:
            return Unit.INSTANCE;
        L8:
            ResultKt.throwOnFailure(r7);
        L41:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.a(this.$device));
            goto L47
        L9:
            ResultKt.throwOnFailure(r7);
        L45:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.d(this.$device));
            goto L47
        L10:
            ResultKt.throwOnFailure(r7);
        L22:
            ReplaceBindAndConnectResult r9 = (ReplaceBindAndConnectResult) r7;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "replaceBindAndConnect: " + DoraOnboardingDialogViewModel.access$getLog(this.this$0, this.$device) + " result=" + r9);
            switch(a.a[r9.ordinal()]) {
                case 1: goto L42;
                case 2: goto L42;
                case 3: goto L38;
                case 4: goto L27;
                case 5: goto L27;
                case 6: goto L26;
                default: goto L25;
            };
        L26:
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.b(this.$device));
            goto L47
        L27:
            DoraOnboardingDialogViewModel r10 = this.this$0;
            DoraDevice r2 = this.$device;
            Integer r4 = this.$bluetoothOffToastResId;
            this.label = 5;
            r7 = DoraOnboardingDialogViewModel.access$showBluetoothOffFailureIfNeeded(r10, r2, r4, this);
            if (r7 != r0) goto L31;
            return r0;
        L38:
            MutableSharedFlow r11 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r3 = new o0.d(AppHost.a.getApplication().getString(2131903938, new Object[]{o59.a.g(this.$device)}));
            this.label = 4;
            if (r11.emit(r3, this) != r0) goto L41;
            return r0;
        L42:
            MutableSharedFlow r12 = DoraOnboardingDialogViewModel.access$get_actionSharedFlow$p(this.this$0);
            o0.d r5 = new o0.d(AppHost.a.getApplication().getString(2131908080));
            this.label = 3;
            if (r12.emit(r5, this) != r0) goto L45;
            return r0;
        L25:
            throw new NoWhenBranchMatchedException();
        L11:
            ResultKt.throwOnFailure(r7);
        L16:
            if (((Boolean) r7).booleanValue() == true) goto L18;
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.c(this.$device));
            kj4.a r13 = kj4.a.g();
            DoraDevice r6 = this.$device;
            this.label = 2;
            r7 = DoraAdapterExtKt.G(r13, r6, this);
            if (r7 != r0) goto L22;
            return r0;
        L18:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r7);
            DoraOnboardingDialogViewModel r14 = this.this$0;
            DoraDevice r15 = this.$device;
            Integer r16 = this.$bluetoothOffToastResId;
            this.label = 1;
            r7 = DoraOnboardingDialogViewModel.access$showBluetoothOffFailureIfNeeded(r14, r15, r16, this);
            if (r7 != r0) goto L16;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$scanForDora$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel", f = "DoraOnboardingDialogViewModel.kt", i = {0}, l = {517}, m = "scanForDora", n = {"targetProductIds"}, s = {"L$0"})
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public AnonymousClass2(DoraOnboardingDialogViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return DoraOnboardingDialogViewModel.access$scanForDora(this.this$0, null, null, DoraOnboardingDialogViewModel.VERIFY_TOKEN_SUCCESS_CODE, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$scanForDora$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$scanForDora$4", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {380, 396}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DoraDevice> $firstScannedDoraDevice;
        final /* synthetic */ long $scanForALongTime;
        final /* synthetic */ Ref.BooleanRef $scanNoLimit;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public AnonymousClass4(Ref.ObjectRef<DoraDevice> r1, DoraOnboardingDialogViewModel r2, Ref.BooleanRef r3, long r4, Continuation<? super AnonymousClass4> r6) {
            this.$firstScannedDoraDevice = r1;
            this.this$0 = r2;
            this.$scanNoLimit = r3;
            this.$scanForALongTime = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass4(this.$firstScannedDoraDevice, this.this$0, this.$scanNoLimit, this.$scanForALongTime, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L27:
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "scanTimeoutJob: scanning " + this.$scanForALongTime + 's');
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(q0.f.a);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L13:
            StringBuilder r9 = new StringBuilder("scanTimeoutJob: scanning 3000s, has ");
            DoraDevice r2 = (DoraDevice) this.$firstScannedDoraDevice.element;
            if (r2 == null) goto L16;
            String r3 = DoraOnboardingDialogViewModel.access$getLog(this.this$0, r2);
        L17:
            r9.append(r3);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, r9.toString());
            DoraDevice r10 = (DoraDevice) this.$firstScannedDoraDevice.element;
            if (r10 == null) goto L24;
            DoraOnboardingDialogViewModel r4 = this.this$0;
            if (DoraOnboardingDialogViewModel.access$getDoraScanCallback$p(r4) == null) goto L22;
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "scanTimeoutJob: stopScan#" + DoraOnboardingDialogViewModel.access$getDoraScanCallback$p(r4));
            kj4.a.g().stopScan(DoraOnboardingDialogViewModel.access$getDoraScanCallback$p(r4));
            DoraOnboardingDialogViewModel.access$setDoraScanCallback$p(r4, null);
        L22:
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "scanTimeoutJob: launchOnboarding " + DoraOnboardingDialogViewModel.access$getLog(r4, r10));
            DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(r4).setValue(new q0.d(r10));
            return Unit.INSTANCE;
        L24:
            this.$scanNoLimit.element = true;
            long r5 = this.$scanForALongTime;
            this.label = 2;
            if (DelayKt.delay(r5, this) != r0) goto L27;
            return r0;
        L16:
            r3 = null;
            goto L17
        L10:
            ResultKt.throwOnFailure(r8);
            this.label = 1;
            if (DelayKt.delay(DoraOnboardingDialogViewModel.SCAN_NO_LIMIT_TIME, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$showBluetoothOffFailureIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel", f = "DoraOnboardingDialogViewModel.kt", i = {0}, l = {689}, m = "showBluetoothOffFailureIfNeeded", n = {"device"}, s = {"L$0"})
    public static final class C03721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03721(DoraOnboardingDialogViewModel r1, Continuation<? super C03721> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraOnboardingDialogViewModel.access$showBluetoothOffFailureIfNeeded(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$startScan$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$startScan$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {119, 120}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProductNameType $productType;
        final /* synthetic */ long $scanForALongTime;
        final /* synthetic */ String $sku;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03731(DoraOnboardingDialogViewModel r1, ProductNameType r2, String r3, long r4, Continuation<? super C03731> r6) {
            this.this$0 = r1;
            this.$productType = r2;
            this.$sku = r3;
            this.$scanForALongTime = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C03731(this.this$0, this.$productType, this.$sku, this.$scanForALongTime, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L13:
            DoraOnboardingDialogViewModel r3 = this.this$0;
            ProductNameType r4 = this.$productType;
            String r5 = this.$sku;
            long r6 = this.$scanForALongTime;
            this.label = 2;
            if (DoraOnboardingDialogViewModel.access$scanForDora(r3, r4, r5, r6, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, "startScan");
            z0 r11 = DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0);
            q0.e r2 = q0.e.a;
            this.label = 1;
            if (r11.emit(r2, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$startScan$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$startScan$2", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {146, 147}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $scanForALongTime;
        final /* synthetic */ String $sku;
        final /* synthetic */ List<ProductNameType> $targetProducts;
        int label;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03742(List<? extends ProductNameType> r1, DoraOnboardingDialogViewModel r2, String r3, long r4, Continuation<? super C03742> r6) {
            this.$targetProducts = r1;
            this.this$0 = r2;
            this.$sku = r3;
            this.$scanForALongTime = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C03742(this.$targetProducts, this.this$0, this.$sku, this.$scanForALongTime, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L17:
            DoraOnboardingDialogViewModel r3 = this.this$0;
            List<ProductNameType> r4 = this.$targetProducts;
            String r5 = this.$sku;
            long r6 = this.$scanForALongTime;
            this.label = 2;
            if (DoraOnboardingDialogViewModel.access$scanForDora(r3, r4, r5, r6, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            StringBuilder r11 = new StringBuilder("startScan: productIds=");
            List<ProductNameType> r2 = this.$targetProducts;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r8 = r2.iterator();
        L12:
            if (r8.hasNext() == false) goto L14;
            r7.add(Boxing.boxInt(((ProductNameType) r8.next()).id));
            goto L12
        L14:
            r11.append(r7);
            g49.d.d(DoraOnboardingDialogViewModel.TAG, r11.toString());
            z0 r12 = DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0);
            q0.e r9 = q0.e.a;
            this.label = 1;
            if (r12.emit(r9, this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$verifyToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {838}, m = "verifyToken", n = {}, s = {})
    public static final class C03751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraOnboardingDialogViewModel this$0;

        public C03751(DoraOnboardingDialogViewModel r1, Continuation<? super C03751> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraOnboardingDialogViewModel.access$verifyToken(this.this$0, null, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Thread yo(Runnable r0) {
        return dispatcher$lambda$0(r0);
    }

    public final void stopScan() {
        Job r0 = this.scanTimeoutJob;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L6:
        if (this.doraScanCallback == null) goto L9;
        g49.d.d(TAG, "stopScan: stopScan#" + this.doraScanCallback);
        kj4.a.g().stopScan(this.doraScanCallback);
        this.doraScanCallback = null;
        return;
    }

    public DoraOnboardingDialogViewModel() {
        StateFlowImpl r0 = j1.a(q0.e.a);
        this._uiStateFlow = r0;
        this.uiStateFlow = r0;
        MutableSharedFlow<o0> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionSharedFlow = r1;
        this.actionSharedFlow = r1;
        this.dispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new h0()));
        IDoraLinkCallback r2 = new DoraOnboardingDialogViewModel$doraLinkCallback$1(this);
        this.doraLinkCallback = r2;
        g49.d.d(TAG, this + " init, registerDoraLinkCallback at 0 index.");
        kj4.a.g().registerDoraLinkCallback(r2, true);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, this + " onCleared");
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        stopScan();
    }

    public final d1<o0> getActionSharedFlow() {
        return this.actionSharedFlow;
    }

    public final i1<q0> getUiStateFlow() {
        return this.uiStateFlow;
    }

    public static final /* synthetic */ ScanCallback access$getDoraScanCallback$p(DoraOnboardingDialogViewModel r0) {
        return r0.doraScanCallback;
    }

    public static final /* synthetic */ Job access$getScanTimeoutJob$p(DoraOnboardingDialogViewModel r0) {
        return r0.scanTimeoutJob;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionSharedFlow$p(DoraOnboardingDialogViewModel r0) {
        return r0._actionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_uiStateFlow$p(DoraOnboardingDialogViewModel r0) {
        return r0._uiStateFlow;
    }

    private static final Thread dispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "dora#smart_onboarding_dialog");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0090 -> B:36:0x0093). Please report as a decompilation issue!!! */
    private final Object getDeviceAuthAbilityFlag(Continuation<? super Integer> r10) {
        if ((r10 instanceof C03691) == false) goto L7;
        C03691 r0 = (C03691) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r4 = r0.I$0;
        ResultKt.throwOnFailure(r11);
    L36:
        r4 = r4 + 1;
    L16:
        if (r4 >= 11) goto L38;
        sk4.e r12 = kj4.a.g().requestProtocolInfo();
        if (r12 == null) goto L22;
        byte[] r13 = r12.b;
        if (r13 == null) goto L22;
        String r14 = pk4.n.g(r13);
    L23:
        g49.d.d(TAG, "getDeviceAuthAbilityFlag: featureAbility=" + r14 + ", retry=" + r4);
        if (r14 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == false) goto L32;
        r0.I$0 = r4;
        r0.label = 1;
        if (DelayKt.delay(300, r0) != r2) goto L36;
        return r2;
    L32:
        return Boxing.boxInt(StringsKt.contains$default(r14, "deviceCert", false, 2, null) ? 1 : 0);
    L26:
        if (r14.length() == 0) goto L29;
        r7 = false;
    L22:
        r14 = null;
        goto L23
    L38:
        return Boxing.boxInt(2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r4 = 0;
    L7:
        r0 = new C03691(this, r10);
        goto L8
    }

    private final String getLog(DoraDevice r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        return "{name=" + r3.name + ", sn=" + r3.sn + ", mode=" + r3.mode + ", productId=" + r3.productId + "}, type=" + r3.type + ", sku=" + r3.sku;
    }

    private final boolean isDoraG2ScanResult(ScanResult r3) {
        ParcelUuid r0 = ParcelUuid.fromString("00002010-0000-1000-8000-00805F9B34FB");
        if (r3 == null) goto L12;
        ScanRecord r4 = r3.getScanRecord();
        if (r4 == null) goto L13;
        List<ParcelUuid> r5 = r4.getServiceUuids();
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.contains(r0) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final void authDevice(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final void bindAndConnect(DoraDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "device");
        bindAndConnect(r2, null);
    }

    public final void cancelUnbind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03681(this, r8, null), 2, null);
    }

    public final void jumpUnbind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03701(this, r8, null), 2, null);
    }

    public final void replaceBindAndConnect(DoraDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "device");
        replaceBindAndConnect(r2, null);
    }

    public static final /* synthetic */ Object access$getDeviceAuthAbilityFlag(DoraOnboardingDialogViewModel r0, Continuation r1) {
        return r0.getDeviceAuthAbilityFlag(r1);
    }

    public static final /* synthetic */ String access$getLog(DoraOnboardingDialogViewModel r0, DoraDevice r1) {
        return r0.getLog(r1);
    }

    public static final /* synthetic */ boolean access$isDoraG2ScanResult(DoraOnboardingDialogViewModel r0, ScanResult r1) {
        return r0.isDoraG2ScanResult(r1);
    }

    public static final /* synthetic */ void access$setDoraScanCallback$p(DoraOnboardingDialogViewModel r0, ScanCallback r1) {
        r0.doraScanCallback = r1;
    }

    private final boolean shouldIgnoreUnsupportedHDevice(boolean r2, DoraDevice r3) {
        if (r2 == false) goto L11;
        if (r3 == null) goto L11;
        if (ProductNameType.getProduct(r3.productId) == null) goto L9;
        return false;
    L9:
        g49.d.d(TAG, "ignore unsupported h device, productId=" + r3.productId + ", name=" + r3.name);
        return true;
    L11:
        return false;
    }

    public final void bindAndConnect(DoraDevice r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03671(this, r8, r9, null), 2, null);
    }

    public final void replaceBindAndConnect(DoraDevice r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03711(this, r8, r9, null), 2, null);
    }

    public static final /* synthetic */ boolean access$shouldIgnoreUnsupportedHDevice(DoraOnboardingDialogViewModel r0, boolean r1, DoraDevice r2) {
        return r0.shouldIgnoreUnsupportedHDevice(r1, r2);
    }

    private final void onDeviceFound(DoraDevice r4, String r5, ScanCallback r6) {
        g49.d.d(TAG, r5 + "#onDeviceFound: " + getLog(r4) + ", stopScan#" + this);
        Job r7 = this.scanTimeoutJob;
        if (r7 == null) goto L5;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L5:
        kj4.a.g().stopScan(r6);
        if (Intrinsics.areEqual(this._uiStateFlow.getValue(), q0.e.a) == false) goto L8;
    L9:
        g49.d.d(TAG, "onDeviceFound: OnboardingUiState.DeviceFound");
        this._uiStateFlow.setValue(new q0.d(r4));
        return;
    L8:
        if (Intrinsics.areEqual(this._uiStateFlow.getValue(), q0.f.a) == true) goto L9;
    }

    private final Object showBluetoothOffFailureIfNeeded(DoraDevice r6, Integer r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof C03721) == false) goto L7;
        C03721 r0 = (C03721) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
        this._uiStateFlow.setValue(new q0.d(r6));
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r7 == null) goto L25;
        if (kj4.a.g().isReady() != 2) goto L25;
        MutableSharedFlow<o0> r10 = this._actionSharedFlow;
        o0.d r4 = new o0.d(AppHost.a.getApplication().getString(r7.intValue()));
        r0.L$0 = r6;
        r0.label = 1;
        if (r10.emit(r4, r0) != r2) goto L22;
        return r2;
    L25:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C03721(this, r8);
        goto L8
    }

    private final Object verifyToken(DoraDevice r17, String r18, Continuation<? super b> r110) {
        if ((r110 instanceof C03751) == false) goto L7;
        C03751 r6 = (C03751) r110;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        C03751 r13 = r6;
        Object r1 = r13.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r13.label;
        if (r9 == 0) goto L15;
        if (r9 != 1) goto L14;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L36
    L19:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;     // Catch: Throwable -> L36
        g49.d.d(TAG, "verifyToken: call=" + r2);     // Catch: Throwable -> L36
        boolean r0 = r2 instanceof com.larus.network.http.y;     // Catch: Throwable -> L36
        long r3 = VERIFY_TOKEN_UNKNOWN_ERROR_CODE;
        if (r0 == false) goto L32;
        Long r4 = r2.g;     // Catch: Throwable -> L36
        if (r4 != null) goto L25;
    L27:
        Long r5 = r2.g;     // Catch: Throwable -> L36
        if (r5 == null) goto L41;
        r3 = r5.longValue();     // Catch: Throwable -> L36
    L41:
        return new b.a(r3);
    L25:
        if (r4.longValue() != VERIFY_TOKEN_SUCCESS_CODE) goto L27;
        return b.C0086b.a;
    L32:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L35;
        return new b.a(((com.larus.network.http.f) r2).d.getCode());
    L35:
        return new b.a(VERIFY_TOKEN_UNKNOWN_ERROR_CODE);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L36
        r11.put("token", r18);     // Catch: Throwable -> L36
        r11.put("hardware_device_type", r17.type);     // Catch: Throwable -> L36
        r11.put("version", 1);     // Catch: Throwable -> L36
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L36
        r10.put("token_len", r18.length());     // Catch: Throwable -> L36
        r10.put("hardware_device_type", r17.type);     // Catch: Throwable -> L36
        r10.put("version", 1);     // Catch: Throwable -> L36
        g49.d.d(TAG, "verifyToken: callBody=" + r10);     // Catch: Throwable -> L36
        com.larus.dora.api.network.a r12 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L36
        r13.label = 1;     // Catch: Throwable -> L36
        r1 = com.larus.dora.api.network.a.c(r12, Object.class, URL_DEVICE_AUTH, r11, null, r13, 248);     // Catch: Throwable -> L36
        if (r1 != r8) goto L19;
        return r8;
    L36:
        th = move-exception;
        g49.d.c(TAG, "verifyToken: throwable=" + th.getMessage(), th);
        return new b.a(VERIFY_TOKEN_THROWABLE_ERROR_CODE);
    L7:
        r6 = new C03751(this, r110);
        goto L8
    }

    public final void startScan(Collection<? extends ProductNameType> r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "productTypes");
        Intrinsics.checkNotNullParameter(r12, "sku");
        HashSet r0 = new HashSet();
        ArrayList r2 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r1 = r14.next();
        if (r0.add(Integer.valueOf(((ProductNameType) r1).id)) == false) goto L4;
        r2.add(r1);
        goto L4
    L9:
        if (r2.isEmpty() == false) goto L13;
        g49.d.b(TAG, "startScan ignored because target products are empty");
        return;
    L13:
        if (r2.size() != 1) goto L16;
        startScan((ProductNameType) CollectionsKt.first(r2), r12, r13);
        return;
    L16:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C03742(r2, this, r12, r13, null), 2, null);
    }

    public final void startScan(ProductNameType r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, "productType");
        Intrinsics.checkNotNullParameter(r13, "sku");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C03731(this, r12, r13, r14, null), 2, null);
    }

    public static final /* synthetic */ void access$onDeviceFound(DoraOnboardingDialogViewModel r0, DoraDevice r1, String r2, ScanCallback r3) {
        r0.onDeviceFound(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$showBluetoothOffFailureIfNeeded(DoraOnboardingDialogViewModel r0, DoraDevice r1, Integer r2, Continuation r3) {
        return r0.showBluetoothOffFailureIfNeeded(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$verifyToken(DoraOnboardingDialogViewModel r0, DoraDevice r1, String r2, Continuation r3) {
        return r0.verifyToken(r1, r2, r3);
    }

    private final Object scanForDora(List<? extends ProductNameType> r35, String r36, long r37, Continuation<? super Unit> r310) {
        if ((r310 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r1 = (AnonymousClass2) r310;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        AnonymousClass2 r15 = r1;
        Object r0 = r15.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Set r4 = (Set) r15.L$0;
        ResultKt.throwOnFailure(r0);
        String r17 = "scanForDora: productIds=";
        String r11 = TAG;
    L190:
        Unit r5 = Unit.INSTANCE;
        Set r6 = r4;
    L192:
        g49.d.d(r11, r17 + r6 + " method end");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        List<? extends ProductNameType> r8 = r35;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r7.add(Boxing.boxInt(((ProductNameType) r9.next()).vendorID));
        goto L16
    L18:
        List r10 = CollectionsKt.distinct(r7);
        if (r10.size() == 1) goto L22;
        g49.d.b(TAG, "scanForDora ignored because vendors are mixed: " + r10);
        return Unit.INSTANCE;
    L22:
        ProductNameType r13 = (ProductNameType) CollectionsKt.first(r35);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r16 = r8.iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        r14.add(Boxing.boxInt(((ProductNameType) r16.next()).id));
        goto L24
    L26:
        Set r18 = CollectionsKt.toSet(r14);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r21 = r8.iterator();
    L28:
        if (r21.hasNext() == false) goto L30;
        r20.add(Boxing.boxInt(((ProductNameType) r21.next()).deviceType));
        goto L28
    L30:
        Set r22 = CollectionsKt.toSet(r20);
        ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r8.iterator();
    L32:
        if (r24.hasNext() == false) goto L36;
        Object r25 = r24.next();
        if (o59.a.m(Boxing.boxInt(((ProductNameType) r25).id)) == false) goto L32;
        r23.add(r25);
        goto L32
    L36:
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r27 = r23.iterator();
    L38:
        if (r27.hasNext() == false) goto L40;
        r26.add(Boxing.boxInt(((ProductNameType) r27.next()).deviceType));
        goto L38
    L40:
        Set r110 = CollectionsKt.toSet(r26);
        g49.d.d(TAG, "scanForDora: productIds=" + r18 + ", deviceTypes=" + r22 + ", scanForALongTime=" + r37);
        if (l69.a.c(TAG) == true) goto L44;
        g49.d.e(TAG, "scanForDora: bluetooth scan permission not granted, skip scanning");
        return Unit.INSTANCE;
    L44:
        Set<String> r111 = com.larus.dora.impl.core.j.a(AppHost.a.getApplication());
        boolean r112 = !r111.isEmpty();
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        Ref.BooleanRef r28 = new Ref.BooleanRef();
        Ref.LongRef r30 = new Ref.LongRef();
        r30.element = SystemClock.elapsedRealtime();
        Job r31 = this.scanTimeoutJob;
        if (r31 == null) goto L48;
        Job.DefaultImpls.cancel$default(r31, null, 1, null);
        Unit r32 = Unit.INSTANCE;
    L48:
        if (this.doraScanCallback == null) goto L51;
        g49.d.d(TAG, "scanForDora: productIds=" + r18 + " stopScan#" + this.doraScanCallback);
        kj4.a.g().stopScan(this.doraScanCallback);
        this.doraScanCallback = null;
    L51:
        if (r13.vendorID == 1) goto L53;
        boolean r210 = true;
    L54:
        ProductNameType r211 = r13;
        String r114 = TAG;
        String r115 = "scanForDora: productIds=";
        this.doraScanCallback = new c(r210, r13, this, r35, r112, r28, r110, r18, r22, r30, r111, r113);
        g49.d.d(r114, r115 + r18 + " startScan#" + this.doraScanCallback);
        int r33 = 2;
        if (r210 == false) goto L63;
        ArrayList r34 = new ArrayList();
        ScanFilter r38 = new ScanFilter.Builder().setServiceData(new ParcelUuid(UUID.fromString("0000FDEE-0000-1000-8000-00805F9B34FB")), new byte[]{0, 16, 0}).build();
        Intrinsics.checkNotNull(r38);
        r34.add(r38);
        ScanSettings.Builder r40 = new ScanSettings.Builder();
        r40.setScanMode(2);
        if (Build.VERSION.SDK_INT < 23) goto L60;
        r40.setCallbackType(1);
        r40.setMatchMode(2);
    L60:
        if (BluetoothAdapter.getDefaultAdapter().isOffloadedScanBatchingSupported() == false) goto L62;
        r40.setReportDelay(VERIFY_TOKEN_SUCCESS_CODE);
    L62:
        kj4.a.g().startScan(r34, r40.build(), this.doraScanCallback);
    L89:
        this.scanTimeoutJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new AnonymousClass4(r113, this, r28, r37, null), 2, null);
        if (r210 == false) goto L184;
        BluetoothAdapter r41 = BluetoothAdapter.getDefaultAdapter();
        if (r41 == null) goto L95;
        Set<BluetoothDevice> r42 = l69.a.d(r41);
        if (r42 == null) goto L95;
    L97:
        if ((!r42.isEmpty()) == false) goto L184;
        List r43 = DoraAdapterExtKt.k(kj4.a.g());
        Iterator r44 = r42.iterator();
    L100:
        if (r44.hasNext() == false) goto L184;
        BluetoothDevice r45 = (BluetoothDevice) r44.next();
        ArrayList r46 = new ArrayList();
        Iterator r47 = r43.iterator();
    L103:
        if (r47.hasNext() == false) goto L108;
        Object r48 = r47.next();
        if (Intrinsics.areEqual(((DoraDevice) r48).mac, r45.getAddress()) == false) goto L103;
        r46.add(r48);
        goto L103
    L108:
        if (r46.isEmpty() == true) goto L110;
    L182:
        Iterator r311 = r44;
        r43 = r43;
        String r116 = r114;
        r115 = r115;
        r211 = r211;
    L183:
        r44 = r311;
        r43 = r43;
        r211 = r211;
        r114 = r116;
        r115 = r115;
        r33 = 2;
        goto L100
    L110:
        if (com.larus.utils.o0.d(r45.getName()) == false) goto L182;
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeClip 2 HE", false, r33, null) == true) goto L172;
        r311 = r44;
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeClip 2 " + AppHost.a.getApplication().getString(2131903143), false, 2, null) == false) goto L117;
        r116 = r114;
    L173:
        DoraDevice r50 = DoraDevice.from(r45);
        r50.vendorId = r211.vendorID;
        r50.productId = ProductNameType.H_FREE_CLIP_2_HE.id;
        r50.sku = 0;
        if (com.larus.utils.o0.d(r36) == true) goto L195;
    L179:
        r50.type = ProductNameType.H_FREE_CLIP_2_HE.deviceType;
        boolean r51 = pk4.a.f(r45);
        g49.d.d(r116, "onFilterResult# " + getLog(r50) + ", isConnected=" + r51 + "，device name=" + r50.name);
        if (r51 == false) goto L183;
        onDeviceFound(r50, "filterSystemBodedDevices", this.doraScanCallback);
        goto L183
    L195:
        r50.sku = CastIntegerProtector.parseInt(r36, CharsKt.checkRadix(16));     // Catch: Exception -> L178
    L178:
        g49.d.b(r116, "sku format error. skuParam=" + r36);
        goto L179
    L117:
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeClip 2", false, 2, null) == false) goto L119;
    L162:
        r43 = r43;
        r115 = r115;
        r211 = r211;
        r116 = r114;
        DoraDevice r52 = DoraDevice.from(r45);
        r52.vendorId = r211.vendorID;
        r52.productId = ProductNameType.H_FREE_CLIP_2.id;
        r52.sku = 1;
        if (com.larus.utils.o0.d(r36) == true) goto L197;
    L168:
        r52.type = ProductNameType.H_FREE_CLIP_2.deviceType;
        boolean r53 = pk4.a.f(r45);
        g49.d.d(r116, "onFilterResult# " + getLog(r52) + ", isConnected=" + r53 + "，device name=" + r52.name);
        if (r53 == false) goto L183;
        onDeviceFound(r52, "filterSystemBodedDevices", this.doraScanCallback);
        goto L183
    L197:
        r52.sku = CastIntegerProtector.parseInt(r36, CharsKt.checkRadix(16));     // Catch: Exception -> L167
    L167:
        g49.d.b(r116, "sku format error. skuParam=" + r36);
        goto L168
    L119:
        if (StringsKt.startsWith$default(r45.getName(), "Robin", false, 2, null) == true) goto L162;
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeBuds Pro 5", false, 2, null) == false) goto L138;
        DoraDevice r54 = DoraDevice.from(r45);
        r211 = r211;
        r54.vendorId = r211.vendorID;
        r54.productId = ProductNameType.H_FREE_BUDS_PRO_5.id;
        r54.sku = HSKU.GOLD.getSku();
        if (com.larus.utils.o0.d(r36) == true) goto L201;
        r116 = r114;
    L133:
        r54.type = ProductNameType.H_FREE_BUDS_PRO_5.deviceType;
        boolean r55 = pk4.a.f(r45);
        g49.d.d(r116, "onFilterResult# " + getLog(r54) + ", isConnected=" + r55 + "，device name=" + r54.name);
        if (r55 == false) goto L136;
        onDeviceFound(r54, "filterSystemBodedDevices", this.doraScanCallback);
    L136:
        r43 = r43;
        r115 = r115;
        goto L183
    L201:
        String r56 = r36;
        r116 = r114;
        r54.sku = CastIntegerProtector.parseInt(r56, CharsKt.checkRadix(16));     // Catch: Exception -> L194
    L131:
        g49.d.b(r116, "sku format error. skuParam=" + r56);
    L130:
        r56 = r36;
        r116 = r114;
        goto L131
    L138:
        r116 = r114;
        r211 = r211;
        r43 = r43;
        r115 = r115;
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeBuds 7", false, 2, null) == false) goto L150;
        DoraDevice r57 = DoraDevice.from(r45);
        r57.vendorId = r211.vendorID;
        r57.productId = ProductNameType.H_GUITAR.id;
        r57.sku = 0;
        if (com.larus.utils.o0.d(r36) == true) goto L205;
    L146:
        r57.type = ProductNameType.H_GUITAR.deviceType;
        boolean r58 = pk4.a.f(r45);
        g49.d.d(r116, "onFilterResult# " + getLog(r57) + ", isConnected=" + r58 + "，device name=" + r57.name);
        if (r58 == false) goto L183;
        onDeviceFound(r57, "filterSystemBodedDevices", this.doraScanCallback);
        goto L183
    L205:
        r57.sku = CastIntegerProtector.parseInt(r36, CharsKt.checkRadix(16));     // Catch: Exception -> L145
    L145:
        g49.d.b(r116, "sku format error. skuParam=" + r36);
        goto L146
    L150:
        if (StringsKt.startsWith$default(r45.getName(), "Dolphin", false, 2, null) == false) goto L152;
    L153:
        DoraDevice r60 = DoraDevice.from(r45);
        r60.vendorId = r211.vendorID;
        r60.productId = ProductNameType.H_DOLPHIN.id;
        r60.sku = 1;
        if (com.larus.utils.o0.d(r36) == true) goto L203;
    L159:
        r60.type = ProductNameType.H_DOLPHIN.deviceType;
        boolean r61 = pk4.a.f(r45);
        g49.d.d(r116, "onFilterResult# " + getLog(r60) + ", isConnected=" + r61 + "，device name=" + r60.name);
        if (r61 == false) goto L183;
        onDeviceFound(r60, "filterSystemBodedDevices", this.doraScanCallback);
        goto L183
    L203:
        r60.sku = CastIntegerProtector.parseInt(r36, CharsKt.checkRadix(16));     // Catch: Exception -> L158
    L158:
        g49.d.b(r116, "sku format error. skuParam=" + r36);
        goto L159
    L152:
        if (StringsKt.startsWith$default(r45.getName(), "HUAWEI FreeBuds Neo", false, 2, null) == false) goto L183;
    L172:
        r311 = r44;
        r116 = r114;
    L95:
        r42 = SetsKt.emptySet();
    L184:
        r11 = r114;
        r17 = r115;
        Job r62 = this.scanTimeoutJob;
        if (r62 == null) goto L191;
        r15.L$0 = r18;
        r15.label = 1;
        if (r62.join(r15) != r12) goto L189;
        return r12;
    L189:
        r4 = r18;
        goto L190
    L191:
        r6 = r18;
        goto L192
    L63:
        List r63 = CollectionsKt.createListBuilder();
        boolean r64 = r8 instanceof Collection;
        if (r64 == true) goto L66;
    L68:
        Iterator<T> r65 = r8.iterator();
    L70:
        if (r65.hasNext() == false) goto L67;
        if ((!o59.a.m(Boxing.boxInt(((ProductNameType) r65.next()).id))) == false) goto L70;
        boolean r117 = true;
    L74:
        if (r117 == false) goto L76;
        r63.add("0000FD7B-0000-1000-8000-00805F9B34FB");
    L76:
        if (r64 == true) goto L78;
    L80:
        Iterator<T> r66 = r8.iterator();
    L82:
        if (r66.hasNext() == false) goto L79;
        if (o59.a.m(Boxing.boxInt(((ProductNameType) r66.next()).id)) == false) goto L82;
        boolean r118 = true;
    L86:
        if (r118 == false) goto L88;
        r63.add("00002010-0000-1000-8000-00805F9B34FB");
    L88:
        kj4.a.g().scan(CollectionsKt.build(r63), this.doraScanCallback);
    L79:
        r118 = false;
        goto L86
    L78:
        if (r8.isEmpty() == false) goto L80;
    L67:
        r117 = false;
        goto L74
    L66:
        if (r8.isEmpty() == false) goto L68;
    L53:
        r210 = false;
    L7:
        r1 = new AnonymousClass2(this, r310);
        goto L8
    }

    private final Object scanForDora(ProductNameType r7, String r8, long r9, Continuation<? super Unit> r11) {
        Object r10 = scanForDora(CollectionsKt.listOf(r7), r8, r9, r11);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$scanForDora(DoraOnboardingDialogViewModel r0, ProductNameType r1, String r2, long r3, Continuation r5) {
        return r0.scanForDora(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object access$scanForDora(DoraOnboardingDialogViewModel r0, List r1, String r2, long r3, Continuation r5) {
        return r0.scanForDora(r1, r2, r3, r5);
    }
}
