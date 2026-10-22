package com.larus.dora.impl.ota.g;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.google.gson.reflect.TypeToken;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.ota.DoraOTACheckFrom;
import com.larus.dora.impl.ota.DoraOTAManager;
import com.larus.dora.impl.ota.DoraOTAManager$a;
import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.dora.impl.ota.g2.Trigger;
import com.larus.dora.impl.ota.g2.UserChoice;
import com.larus.dora.impl.ota.g2.b5;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.ota.g2.o5;
import com.larus.dora.impl.ota.g2.s$a0;
import com.larus.dora.impl.ota.g2.s$z;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiList;
import com.larus.dora.impl.wlan.wifi.DoraWifiResponse;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u000216\u0018\u0000 g2\u00020\u0001:\u0002fgB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010#2\u0006\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\n\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0006\u0010@\u001a\u000209J\u0016\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020&J\b\u0010D\u001a\u000209H\u0014J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u00020&H\u0002J\u001e\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020#J\u0016\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020&J\u001e\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020&2\u0006\u0010J\u001a\u00020&J&\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020#J\b\u0010P\u001a\u000209H\u0002J\b\u0010Q\u001a\u000209H\u0002J\b\u0010R\u001a\u000209H\u0002J\u000e\u0010S\u001a\u0002092\u0006\u0010M\u001a\u00020NJ\u0016\u0010S\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010J\u001a\u00020&J\u001e\u0010S\u001a\u0002092\u0006\u0010M\u001a\u00020N2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020#J\u0016\u0010T\u001a\u0002092\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020#J\u0006\u0010U\u001a\u000209J\u000e\u0010V\u001a\u0002092\u0006\u0010K\u001a\u00020#J\u001a\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020?2\b\b\u0002\u0010Y\u001a\u00020&H\u0002J\u0018\u0010Z\u001a\u0002092\u0006\u0010K\u001a\u00020#2\u0006\u0010[\u001a\u00020&H\u0002J4\u0010\\\u001a\u0002092\u0006\u0010K\u001a\u00020#2\u0006\u0010X\u001a\u00020?2\u0006\u0010[\u001a\u00020&2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u0002090^H\u0002J\u001a\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010K\u001a\u00020#2\u0006\u0010X\u001a\u00020?H\u0002J\u0018\u0010a\u001a\u00020&2\u0006\u0010K\u001a\u00020#2\u0006\u0010b\u001a\u00020_H\u0002J\u0012\u0010c\u001a\u0004\u0018\u00010_2\u0006\u0010X\u001a\u00020?H\u0002J\u0010\u0010d\u001a\u00020&2\u0006\u0010X\u001a\u00020?H\u0002J\u0010\u0010e\u001a\u0002092\u0006\u0010X\u001a\u00020?H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\nR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006h"}, d2 = {"Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_otaUiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/ota/g/DoraGOTAUiState;", "otaUiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOtaUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_otaIntentSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/ota/g/DoraGOTAIntent;", "otaIntentSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getOtaIntentSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_otaCommonIntentSharedFlow", "Lcom/larus/dora/impl/ota/DoraOTACommonIntent;", "otaCommonIntentSharedFlow", "getOtaCommonIntentSharedFlow", "_otaConnectorIntentSharedFlow", "Lcom/larus/dora/impl/ota/connector/DoraOTAConnectorIntent;", "otaConnectorIntentSharedFlow", "getOtaConnectorIntentSharedFlow", "_otaSwitchStateFlow", "Lcom/larus/dora/impl/ota/g/SilentOTASwitchState;", "otaSwitchStateFlow", "getOtaSwitchStateFlow", "_otaUiIntentSharedFlow", "Lcom/larus/dora/impl/ota/g/DoraGOTAUiIntent;", "otaUiIntentSharedFlow", "getOtaUiIntentSharedFlow", "sn", "", "targetDeviceMac", "isOtaNetworkCallbackRegistered", "", "manualPageDevices", "", "Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel$ManualPageBinding;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "otaNetworkCallback", "com/larus/dora/impl/ota/g/DoraGOTAViewModel$otaNetworkCallback$1", "Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel$otaNetworkCallback$1;", "doraLinkCallback", "Lcom/bytedance/dora/link/IDoraLinkCallback;", "doraBudsCallback", "com/larus/dora/impl/ota/g/DoraGOTAViewModel$doraBudsCallback$1", "Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel$doraBudsCallback$1;", "setTargetDeviceMac", "", "mac", "productId", "", "setTargetDeviceMac$impl_mainlandRelease", "targetDevice", "Lcom/bytedance/dora/device/DoraDevice;", "loadSilentSwitchState", "updateSilenceSwitch", "isOn", "pendingOpen", "onCleared", "collectFlow", "usesG2Engine", "checkUpdate", "from", "Lcom/larus/dora/impl/ota/DoraOTACheckFrom;", "isDebug", "sessionId", "download", "responseWrapper", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "onlyWifi", "registerOTAResumeNetworkCallback", "unregisterOTAResumeNetworkCallback", "postInterruptSilentOTA", "startDataTransfer", "onManualPageResumed", "onManualPagePaused", "onManualPageDestroyed", "bindConnectedTarget", "device", "g2Only", "rememberManualPageSession", "debug", "bindManualPageDevice", "enter", "Lkotlin/Function1;", "Lcom/larus/dora/impl/ota/g2/DeviceKey;", "manualPageActionKey", "ownsManualPageAction", "key", "g2Key", "hasCompleteG2Version", "publishG2SwitchState", "ManualPageBinding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOTAViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraGOTAViewModel";
    private final MutableSharedFlow<com.larus.dora.impl.ota.a> _otaCommonIntentSharedFlow;
    private final MutableSharedFlow<com.larus.dora.impl.ota.connector.a> _otaConnectorIntentSharedFlow;
    private final MutableSharedFlow<u> _otaIntentSharedFlow;
    private final z0<SilentOTASwitchState> _otaSwitchStateFlow;
    private final MutableSharedFlow<w> _otaUiIntentSharedFlow;
    private final z0<x> _otaUiStateFlow;
    private final Lazy connectivityManager$delegate;
    private final c doraBudsCallback;
    private final IDoraLinkCallback doraLinkCallback;
    private boolean isOtaNetworkCallbackRegistered;
    private final Map<String, b> manualPageDevices;
    private final d1<com.larus.dora.impl.ota.a> otaCommonIntentSharedFlow;
    private final d1<com.larus.dora.impl.ota.connector.a> otaConnectorIntentSharedFlow;
    private final d1<u> otaIntentSharedFlow;
    private final DoraGOTAViewModel$otaNetworkCallback$1 otaNetworkCallback;
    private final i1<SilentOTASwitchState> otaSwitchStateFlow;
    private final d1<w> otaUiIntentSharedFlow;
    private final i1<x> otaUiStateFlow;
    private String sn;
    private String targetDeviceMac;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final com.larus.dora.impl.ota.g2.e a;
        public final boolean b;
        public final String c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            com.larus.dora.impl.ota.g2.e r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            if (this.b == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            String r6 = this.c;
            if (r6 == null) goto L15;
            r1 = r6.hashCode();
        L15:
            return r5 + r1;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ManualPageBinding(key=" + this.a + ", debug=" + this.b + ", targetMac=" + this.c + ')';
        }

        public b(com.larus.dora.impl.ota.g2.e r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements mj4.h {
        public final /* synthetic */ DoraGOTAViewModel a;

        public final /* synthetic */ void D(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void J(byte[] r1) {
        }

        public final /* synthetic */ void N(int r1, int r2) {
        }

        public final /* synthetic */ void N0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void P0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void Y(int r1, int r2, int r3) {
        }

        public final /* synthetic */ void a0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void a1(DoraDevice r1, mj4.b r2) {
        }

        public final /* synthetic */ void b0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void d1(DoraDevice r1, int r2) {
        }

        public final /* synthetic */ void e1(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void f1(int r1, byte r2) {
        }

        public final /* synthetic */ void p(int r1) {
        }

        public final /* synthetic */ void u(DoraDevice r1, int r2) {
        }

        public final /* synthetic */ void y(DoraDevice r1, int r2, byte[] r3) {
        }

        public final /* synthetic */ void y0(DoraDevice r1, int[] r2) {
        }

        public c(DoraGOTAViewModel r1) {
            this.a = r1;
        }

        public final void l1(DoraDevice r3) {
            if (kj4.a.g().getDoraLinkState(r3) == 2) goto L5;
            return;
        L5:
            if (DoraGOTAViewModel.access$bindConnectedTarget(this.a, r3, true) == false) goto L9;
            g49.d.d(DoraGOTAViewModel.TAG, "onDeviceInfoChange: target accepted");
            this.a.loadSilentSwitchState();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$checkUpdate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$checkUpdate$2", f = "DoraGOTAViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraOTACheckFrom $from;
        final /* synthetic */ boolean $isDebug;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public AnonymousClass2(DoraGOTAViewModel r1, DoraOTACheckFrom r2, boolean r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$from = r2;
            this.$isDebug = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$from, this.$isDebug, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            DoraDevice r5 = DoraGOTAViewModel.access$targetDevice(this.this$0);
            if (r5 == null) goto L13;
            if (o59.a.m(Boxing.boxInt(r5.productId)) == false) goto L10;
            r5 = null;
        L10:
            if (r5 == null) goto L13;
            DoraOTACheckFrom r0 = this.$from;
            boolean r1 = this.$isDebug;
            DoraOTAManager.a.d(r5).c(r5, r0, r1);
        L13:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$1", f = "DoraGOTAViewModel.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraGOTAViewModel a;

            public a(DoraGOTAViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                b5 r3 = (b5) r1;
                DoraDevice r4 = DoraGOTAViewModel.access$targetDevice(this.a);
                if (r4 == null) goto L11;
                if (o59.a.m(Boxing.boxInt(r4.productId)) == true) goto L8;
                r4 = null;
            L8:
                if (r4 == null) goto L11;
                DoraGOTAViewModel.access$publishG2SwitchState(this.a, r4);
            L11:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(DoraGOTAViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            G2OtaFacade.INSTANCE.getClass();
            i1 r6 = G2OtaFacade.A();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$2", f = "DoraGOTAViewModel.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            public final /* synthetic */ DoraGOTAViewModel a;
            public final /* synthetic */ Map<String, d49.a> b;

            public AnonymousClass1(DoraGOTAViewModel r1, Map<String, d49.a> r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object a(Map<String, ? extends d49.a> r21, Continuation<? super Unit> r22) {
                if ((r22 instanceof DoraGOTAViewModel$collectFlow$2$1$emit$1) == false) goto L7;
                DoraGOTAViewModel$collectFlow$2$1$emit$1 r2 = (DoraGOTAViewModel$collectFlow$2$1$emit$1) r22;
                int r3 = r2.label;
                if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
                r2.label = r3 - Integer.MIN_VALUE;
            L8:
                Object r0 = r2.result;
                Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean r5 = true;
                switch(r2.label) {
                    case 0: goto L31;
                    case 1: goto L30;
                    case 2: goto L29;
                    case 3: goto L28;
                    case 4: goto L27;
                    case 5: goto L26;
                    case 6: goto L25;
                    case 7: goto L24;
                    case 8: goto L23;
                    case 9: goto L22;
                    case 10: goto L21;
                    case 11: goto L20;
                    case 12: goto L19;
                    case 13: goto L18;
                    case 14: goto L17;
                    case 15: goto L16;
                    case 16: goto L15;
                    case 17: goto L14;
                    case 18: goto L13;
                    case 19: goto L12;
                    default: goto L11;
                };
            L12:
                ResultKt.throwOnFailure(r0);
            L220:
                return Unit.INSTANCE;
            L13:
                d49.a r6 = (d49.a) r2.L$1;
                d49.a r8 = (d49.a) r2.L$0;
                ResultKt.throwOnFailure(r0);
            L205:
                boolean r1 = DoraGOTAViewModel.access$usesG2Engine(this.a);
                Intrinsics.checkNotNullParameter(r8, "current");
                if (r1 == true) goto L208;
            L214:
                r5 = false;
            L215:
                if (r5 == false) goto L224;
                MutableSharedFlow r7 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.a);
                com.larus.dora.impl.ota.a.e r9 = com.larus.dora.impl.ota.a.e.a;
                r2.L$0 = null;
                r2.L$1 = null;
                r2.label = 19;
                if (r7.emit(r9, r2) != r4) goto L220;
                return r4;
            L224:
                return Unit.INSTANCE;
            L208:
                if ((r6 instanceof d49.a.m) == true) goto L214;
                if ((r8 instanceof d49.a.m) == false) goto L214;
                if (f0.b(r1, r6, r8) != null) goto L214;
            L14:
                r6 = (d49.a) r2.L$1;
                r8 = (d49.a) r2.L$0;
                ResultKt.throwOnFailure(r0);
            L200:
                u.c r10 = f0.b(DoraGOTAViewModel.access$usesG2Engine(this.a), r6, r8);
                if (r10 == null) goto L205;
                MutableSharedFlow r11 = DoraGOTAViewModel.access$get_otaIntentSharedFlow$p(this.a);
                r2.L$0 = r8;
                r2.L$1 = r6;
                r2.label = 18;
                if (r11.emit(r10, r2) != r4) goto L205;
                return r4;
            L15:
                ResultKt.throwOnFailure(r0);
            L194:
                return Unit.INSTANCE;
            L16:
                ResultKt.throwOnFailure(r0);
            L187:
                return Unit.INSTANCE;
            L17:
                ResultKt.throwOnFailure(r0);
            L180:
                return Unit.INSTANCE;
            L18:
                ResultKt.throwOnFailure(r0);
            L175:
                return Unit.INSTANCE;
            L19:
                ResultKt.throwOnFailure(r0);
            L166:
                return Unit.INSTANCE;
            L20:
                ResultKt.throwOnFailure(r0);
            L159:
                return Unit.INSTANCE;
            L21:
                ResultKt.throwOnFailure(r0);
            L152:
                return Unit.INSTANCE;
            L22:
                ResultKt.throwOnFailure(r0);
                goto L224
            L23:
                r6 = (d49.a) r2.L$1;
                r8 = (d49.a) r2.L$0;
                ResultKt.throwOnFailure(r0);
            L129:
                boolean r12 = DoraGOTAViewModel.access$usesG2Engine(this.a);
                Intrinsics.checkNotNullParameter(r8, "current");
                com.larus.dora.impl.ota.a.f r13 = com.larus.dora.impl.ota.a.f.a;
                if (r12 == true) goto L132;
            L138:
                r5 = false;
            L139:
                if (r5 == true) goto L142;
                r13 = null;
            L142:
                if (r13 == null) goto L224;
                MutableSharedFlow r14 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.a);
                r2.L$0 = null;
                r2.L$1 = null;
                r2.label = 9;
                if (r14.emit(r13, r2) != r4) goto L224;
                return r4;
            L132:
                if ((r6 instanceof d49.a.i) == true) goto L138;
                if ((r8 instanceof d49.a.i) == false) goto L138;
                if (Intrinsics.areEqual(((d49.a.i) r8).d, "STORAGE_INSUFFICIENT".toLowerCase(Locale.ROOT)) == false) goto L138;
            L24:
                ResultKt.throwOnFailure(r0);
            L123:
                return Unit.INSTANCE;
            L25:
                ResultKt.throwOnFailure(r0);
            L113:
                return Unit.INSTANCE;
            L26:
                ResultKt.throwOnFailure(r0);
            L77:
                return Unit.INSTANCE;
            L27:
                ResultKt.throwOnFailure(r0);
            L70:
                return Unit.INSTANCE;
            L28:
                ResultKt.throwOnFailure(r0);
            L63:
                return Unit.INSTANCE;
            L29:
                ResultKt.throwOnFailure(r0);
            L56:
                return Unit.INSTANCE;
            L30:
                ResultKt.throwOnFailure(r0);
            L49:
                return Unit.INSTANCE;
            L31:
                ResultKt.throwOnFailure(r0);
                if (DoraGOTAViewModel.access$getSn$p(this.a).length() != 0) goto L34;
                boolean r15 = true;
            L35:
                if (r15 == false) goto L38;
                g49.d.b(DoraGOTAViewModel.TAG, "collectStateFlow: collect sn is empty");
                return Unit.INSTANCE;
            L38:
                d49.a r16 = r21.get(DoraGOTAViewModel.access$getSn$p(this.a));
                if (r16 != null) goto L41;
                r16 = d49.a.l.c;
            L41:
                r8 = r16;
                r6 = this.b.put(DoraGOTAViewModel.access$getSn$p(this.a), r8);
                g49.d.d(DoraGOTAViewModel.TAG, "collectStateFlow: collect " + r8);
                if (Intrinsics.areEqual(r8, d49.a.l.c) == true) goto L224;
                if (Intrinsics.areEqual(r8, d49.a.d.c) == false) goto L51;
                z0 r17 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.d r18 = x.d.a;
                r2.label = 1;
                if (r17.emit(r18, r2) != r4) goto L49;
                return r4;
            L51:
                if (Intrinsics.areEqual(r8, d49.a.C0124a.c) == false) goto L58;
                z0 r20 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.a r23 = x.a.a;
                r2.label = 2;
                if (r20.emit(r23, r2) != r4) goto L56;
                return r4;
            L58:
                if ((r8 instanceof d49.a.c) == false) goto L65;
                z0 r24 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.c r25 = new x.c(((d49.a.c) r8).c);
                r2.label = 3;
                if (r24.emit(r25, r2) != r4) goto L63;
                return r4;
            L65:
                if ((r8 instanceof d49.a.b) == false) goto L72;
                z0 r26 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.b r27 = new x.b(((d49.a.b) r8).c);
                r2.label = 4;
                if (r26.emit(r27, r2) != r4) goto L70;
                return r4;
            L72:
                if ((r8 instanceof d49.a.f) == false) goto L79;
                z0 r28 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.e r30 = new x.e(((d49.a.f) r8).c);
                r2.label = 5;
                if (r28.emit(r30, r2) != r4) goto L77;
                return r4;
            L79:
                if ((r8 instanceof d49.a.k) == false) goto L115;
                if (DoraGOTAViewModel.access$usesG2Engine(this.a) == true) goto L109;
                DoraOTAManager r31 = DoraOTAManager.a;
                String r32 = DoraGOTAViewModel.access$getSn$p(this.a);
                d49.a.k r33 = (d49.a.k) r8;
                e49.a r110 = r33.c;
                int r111 = r33.d;
                r31.getClass();
                Intrinsics.checkNotNullParameter(r32, "sn");
                Intrinsics.checkNotNullParameter(r110, "responseWrapper");
                if (r32.length() == 0) goto L86;
                r5 = false;
            L86:
                if (r5 == false) goto L88;
                g49.d.e("DoraOTAManager", "recordDownloadProgress: sn is empty");
                goto L109
            L88:
                Object r34 = DoraOTAManager.h;
                monitor-enter(r34);
                DoraOTAManager$a r35 = DoraOTAManager.i;     // Catch: Throwable -> L106
                if (r35 != null) goto L93;
            L103:
                DoraOTAManager.i = new DoraOTAManager$a(r32, r110, false, r111, System.currentTimeMillis(), false, 0);     // Catch: Throwable -> L106
                DoraOTAManager.g(r32, r110);     // Catch: Throwable -> L106
                monitor-exit(r34);
                goto L109
            L93:
                if (Intrinsics.areEqual(r35.a, r32) == false) goto L103;
                if (Intrinsics.areEqual(r35.b, r110) == false) goto L103;
                if (r111 <= r35.d) goto L100;
                r35.d = r111;     // Catch: Throwable -> L106
                r35.e = System.currentTimeMillis();     // Catch: Throwable -> L106
                r35.f = false;     // Catch: Throwable -> L106
                DoraOTAManager.g(r32, r110);     // Catch: Throwable -> L106
            L100:
                Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L106
                monitor-exit(r34);
            L106:
                th = move-exception;
                throw th;
            L109:
                z0 r37 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                d49.a.k r38 = (d49.a.k) r8;
                x.k r40 = new x.k(r38.c, r38.d);
                r2.label = 6;
                if (r37.emit(r40, r2) != r4) goto L113;
                return r4;
            L115:
                if ((r8 instanceof d49.a.j) == false) goto L125;
                if (DoraGOTAViewModel.access$usesG2Engine(this.a) == true) goto L119;
                DoraOTAManager r41 = DoraOTAManager.a;
                String r42 = DoraGOTAViewModel.access$getSn$p(this.a);
                e49.a r43 = ((d49.a.j) r8).c;
                r41.getClass();
                DoraOTAManager.a(r42, r43);
            L119:
                z0 r44 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.j r45 = new x.j(((d49.a.j) r8).c);
                r2.label = 7;
                if (r44.emit(r45, r2) != r4) goto L123;
                return r4;
            L125:
                if ((r8 instanceof d49.a.i) == false) goto L147;
                z0 r46 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.i r47 = new x.i(((d49.a.i) r8).c);
                r2.L$0 = r8;
                r2.L$1 = r6;
                r2.label = 8;
                if (r46.emit(r47, r2) != r4) goto L129;
                return r4;
            L147:
                if ((r8 instanceof d49.a.e) == false) goto L154;
                z0 r48 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.e r50 = new x.e(((d49.a.e) r8).c);
                r2.label = 10;
                if (r48.emit(r50, r2) != r4) goto L152;
                return r4;
            L154:
                if ((r8 instanceof d49.a.h) == false) goto L161;
                z0 r51 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                d49.a.h r52 = (d49.a.h) r8;
                x.g r53 = new x.g(r52.c, (int) (((double) r52.e) * 0.5d));
                r2.label = 11;
                if (r51.emit(r53, r2) != r4) goto L159;
                return r4;
            L161:
                if ((r8 instanceof d49.a.g) == false) goto L168;
                z0 r54 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.g r55 = new x.g(((d49.a.g) r8).c, 50);
                r2.label = 12;
                if (r54.emit(r55, r2) != r4) goto L166;
                return r4;
            L168:
                if ((r8 instanceof d49.a.o) == false) goto L182;
                d49.a.o r56 = (d49.a.o) r8;
                if (r56.c.c == false) goto L176;
                z0 r57 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.g r58 = new x.g(r56.c, r56.d);
                r2.label = 13;
                if (r57.emit(r58, r2) != r4) goto L175;
                return r4;
            L176:
                z0 r60 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.g r61 = new x.g(r56.c, ((int) (((double) r56.d) * 0.5d)) + 50);
                r2.label = 14;
                if (r60.emit(r61, r2) != r4) goto L180;
                return r4;
            L182:
                if ((r8 instanceof d49.a.p) == false) goto L189;
                z0 r62 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.h r63 = new x.h(((d49.a.p) r8).c);
                r2.label = 15;
                if (r62.emit(r63, r2) != r4) goto L187;
                return r4;
            L189:
                if ((r8 instanceof d49.a.n) == false) goto L196;
                z0 r64 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.m r65 = new x.m(((d49.a.n) r8).c);
                r2.label = 16;
                if (r64.emit(r65, r2) != r4) goto L194;
                return r4;
            L196:
                if ((r8 instanceof d49.a.m) == false) goto L222;
                z0 r66 = DoraGOTAViewModel.access$get_otaUiStateFlow$p(this.a);
                x.f r67 = new x.f(((d49.a.m) r8).c);
                r2.L$0 = r8;
                r2.L$1 = r6;
                r2.label = 17;
                if (r66.emit(r67, r2) != r4) goto L200;
                return r4;
            L222:
                throw new NoWhenBranchMatchedException();
            L34:
                r15 = false;
                goto L35
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L7:
                r2 = new DoraGOTAViewModel$collectFlow$2$1$emit$1(this, r22);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((Map) r1, r2);
            }
        }

        public C04322(DoraGOTAViewModel r1, Continuation<? super C04322> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04322(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L24:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (DoraGOTAViewModel.access$getSn$p(this.this$0).length() != 0) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L20;
            DoraGOTAViewModel r8 = this.this$0;
            DoraDevice r2 = DoraGOTAViewModel.access$targetDevice(r8);
            if (r2 == null) goto L16;
            String r3 = r2.sn;
        L17:
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            DoraGOTAViewModel.access$setSn$p(r8, r3);
            goto L20
        L16:
            r3 = null;
        L20:
            DoraOTAManager.a.getClass();
            StateFlowImpl r9 = DoraOTAManager.d;
            Map r4 = MapsKt.toMutableMap((Map) r9.getValue());
            g49.d.d(DoraGOTAViewModel.TAG, "collectFlow: sn=" + DoraGOTAViewModel.access$getSn$p(this.this$0));
            AnonymousClass1 r5 = new AnonymousClass1(this.this$0, r4);
            this.label = 1;
            if (r9.collect(r5, this) != r0) goto L24;
            return r0;
        L11:
            r7 = false;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$3", f = "DoraGOTAViewModel.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraGOTAViewModel a;

            public a(DoraGOTAViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r18, Continuation r110) {
                Map r2 = (Map) r18;
                boolean r4 = false;
                if (DoraGOTAViewModel.access$getSn$p(this.a).length() != 0) goto L5;
                boolean r3 = true;
            L6:
                if (r3 == false) goto L8;
                g49.d.b(DoraGOTAViewModel.TAG, "collectIntentSharedFlow: collect sn is empty");
                return Unit.INSTANCE;
            L8:
                com.larus.dora.impl.ota.c r5 = (com.larus.dora.impl.ota.c) r2.get(DoraGOTAViewModel.access$getSn$p(this.a));
                g49.d.d(DoraGOTAViewModel.TAG, "collectIntentSharedFlow: collect " + r5);
                if ((r5 instanceof u) == false) goto L15;
                Object r0 = DoraGOTAViewModel.access$get_otaIntentSharedFlow$p(this.a).emit(r5, r110);
                if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
                return r0;
            L57:
                return Unit.INSTANCE;
            L15:
                if ((r5 instanceof com.larus.dora.impl.ota.a) == false) goto L47;
                if ((r5 instanceof com.larus.dora.impl.ota.a.d) == true) goto L19;
            L42:
                Object r1 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.a).emit(r5, r110);
                if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
                return r1;
            L58:
                return Unit.INSTANCE;
            L19:
                if (DoraGOTAViewModel.access$usesG2Engine(this.a) == true) goto L42;
                DoraOTAManager r6 = DoraOTAManager.a;
                String r7 = DoraGOTAViewModel.access$getSn$p(this.a);
                e49.a r9 = ((com.larus.dora.impl.ota.a.d) r5).a;
                r6.getClass();
                Intrinsics.checkNotNullParameter(r7, "sn");
                Intrinsics.checkNotNullParameter(r9, "responseWrapper");
                if (r7.length() != 0) goto L23;
                r4 = true;
            L23:
                if (r4 == false) goto L25;
                g49.d.e("DoraOTAManager", "markDownloadOnlyWifiFailed: sn is empty");
                goto L42
            L25:
                Object r8 = DoraOTAManager.h;
                monitor-enter(r8);
                DoraOTAManager$a r10 = DoraOTAManager.i;     // Catch: Throwable -> L39
                if (r10 != null) goto L30;
            L35:
                DoraOTAManager.i = new DoraOTAManager$a(r7, r9, true, 0, System.currentTimeMillis(), true, 0);     // Catch: Throwable -> L39
            L36:
                Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L39
                monitor-exit(r8);
                g49.d.d("DoraOTAManager", "markDownloadOnlyWifiFailed: sn=".concat(r7));
                goto L42
            L30:
                if (Intrinsics.areEqual(r10.a, r7) == false) goto L35;
                if (Intrinsics.areEqual(r10.b, r9) == false) goto L35;
                r10.f = true;     // Catch: Throwable -> L39
            L39:
                th = move-exception;
                throw th;
            L47:
                if ((r5 instanceof com.larus.dora.impl.ota.connector.a) == false) goto L53;
                Object r12 = DoraGOTAViewModel.access$get_otaConnectorIntentSharedFlow$p(this.a).emit(r5, r110);
                if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
                return r12;
            L59:
                return Unit.INSTANCE;
            L53:
                return Unit.INSTANCE;
            L5:
                r3 = false;
                goto L6
            }
        }

        public AnonymousClass3(DoraGOTAViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L24:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if (DoraGOTAViewModel.access$getSn$p(this.this$0).length() != 0) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L20;
            DoraGOTAViewModel r7 = this.this$0;
            DoraDevice r2 = DoraGOTAViewModel.access$targetDevice(r7);
            if (r2 == null) goto L16;
            String r3 = r2.sn;
        L17:
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            DoraGOTAViewModel.access$setSn$p(r7, r3);
            goto L20
        L16:
            r3 = null;
        L20:
            g49.d.d(DoraGOTAViewModel.TAG, "collectFlow: ## sn=" + DoraGOTAViewModel.access$getSn$p(this.this$0));
            DoraOTAManager.a.getClass();
            MutableSharedFlow r8 = DoraOTAManager.f;
            a r4 = new a(this.this$0);
            this.label = 1;
            if (r8.collect(r4, this) != r0) goto L24;
            return r0;
        L11:
            r6 = false;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$download$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$download$1", f = "DoraGOTAViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isDebug;
        final /* synthetic */ com.larus.dora.impl.ota.g2.e $key;
        final /* synthetic */ DoraDevice $manualTarget;
        final /* synthetic */ boolean $onlyWifi;
        final /* synthetic */ String $sessionId;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public C04331(DoraGOTAViewModel r1, String r2, com.larus.dora.impl.ota.g2.e r3, DoraDevice r4, boolean r5, boolean r6, Continuation<? super C04331> r7) {
            this.this$0 = r1;
            this.$sessionId = r2;
            this.$key = r3;
            this.$manualTarget = r4;
            this.$isDebug = r5;
            this.$onlyWifi = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C04331(this.this$0, this.$sessionId, this.$key, this.$manualTarget, this.$isDebug, this.$onlyWifi, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r110);
            if (DoraGOTAViewModel.access$ownsManualPageAction(this.this$0, this.$sessionId, this.$key) == false) goto L8;
            G2OtaFacade r2 = G2OtaFacade.INSTANCE;
            DoraDevice r3 = this.$manualTarget;
            com.larus.dora.impl.ota.g2.e r1 = this.$key;
            boolean r15 = this.$isDebug;
            boolean r14 = this.$onlyWifi;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "device");
            Intrinsics.checkNotNullParameter(r1, "key");
            G2OtaFacade.O(r2, r3, Trigger.MANUAL_ACTION, false, null, null, null, null, null, null, r1, null, 1528);
            G2OtaFacade.Y(new s$z(r1, r15, System.currentTimeMillis(), r14));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$download$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$download$2", f = "DoraGOTAViewModel.kt", i = {}, l = {542, 548, 554}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $onlyWifi;
        final /* synthetic */ e49.a $responseWrapper;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public C04342(DoraGOTAViewModel r1, e49.a r2, boolean r3, Continuation<? super C04342> r4) {
            this.this$0 = r1;
            this.$responseWrapper = r2;
            this.$onlyWifi = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04342(this.this$0, this.$responseWrapper, this.$onlyWifi, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r23);
        L57:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r23);
            Object r3 = r0;
            Object r1 = r23;
        L45:
            if (((Boolean) r1).booleanValue() == true) goto L57;
            MutableSharedFlow r4 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.b r5 = com.larus.dora.impl.ota.a.b.a;
            this.label = 2;
            if (r4.emit(r5, this) != r3) goto L57;
            return r3;
        L12:
            ResultKt.throwOnFailure(r23);
            DoraDevice r6 = DoraGOTAViewModel.access$targetDevice(this.this$0);
            if (r6 != null) goto L15;
        L18:
            DoraGOTAViewModel.access$postInterruptSilentOTA(this.this$0);
            g49.d.d(DoraGOTAViewModel.TAG, "download: " + r6);
            if (r6 != null) goto L21;
        L53:
            MutableSharedFlow r7 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.b r8 = com.larus.dora.impl.ota.a.b.a;
            this.label = 3;
            if (r7.emit(r8, this) != r0) goto L57;
            return r0;
        L21:
            if (o59.a.k(r6) == false) goto L53;
            DoraGOTAViewModel r9 = this.this$0;
            String r10 = r6.sn;
            if (r10 != null) goto L25;
            r10 = "";
        L25:
            DoraGOTAViewModel.access$setSn$p(r9, r10);
            DoraOTAManager r11 = DoraOTAManager.a;
            e49.a r14 = this.$responseWrapper;
            boolean r15 = this.$onlyWifi;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r6, "device");
            Intrinsics.checkNotNullParameter(r14, "responseWrapper");
            String r12 = r6.sn;
            if (r12 != null) goto L28;
            r12 = "";
        L28:
            String r13 = r12;
            if (r13.length() != 0) goto L31;
            boolean r16 = true;
        L32:
            if (r16 == false) goto L34;
            g49.d.e("DoraOTAManager", "recordDownloadStart: sn is empty");
        L40:
            if (r6.productId != ProductNameType.DORA_G.id) goto L49;
            e49.a r17 = this.$responseWrapper;
            boolean r18 = this.$onlyWifi;
            this.label = 1;
            r1 = r11.b(r6, r17, r18, this);
            r3 = r0;
            if (r1 != r3) goto L45;
            return r3;
        L49:
            r11.d(r6).e(this.$responseWrapper, this.$onlyWifi);
            goto L57
        L34:
            Object r110 = DoraOTAManager.h;
            monitor-enter(r110);
            DoraOTAManager.i = new DoraOTAManager$a(r13, r14, r15, 0, System.currentTimeMillis(), false, 0);     // Catch: Throwable -> L50
            DoraOTAManager.g(r13, r14);     // Catch: Throwable -> L50
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L50
            monitor-exit(r110);
            g49.d.d("DoraOTAManager", "recordDownloadStart: sn=" + r13 + ", onlyWifi=" + r15);
        L50:
            th = move-exception;
            throw th;
        L31:
            r16 = false;
            goto L32
        L15:
            if (o59.a.m(Boxing.boxInt(r6.productId)) == false) goto L18;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$loadSilentSwitchState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$loadSilentSwitchState$1", f = "DoraGOTAViewModel.kt", i = {1}, l = {196, 964, 219}, m = "invokeSuspend", n = {"convertor$iv"}, s = {"L$0"})
    public static final class C04351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$loadSilentSwitchState$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<DoraWifiList>> {
            public a() {
            }
        }

        public C04351(DoraGOTAViewModel r1, Continuation<? super C04351> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04351(this.this$0, r3);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L46:
            DoraGOTAViewModel.access$get_otaSwitchStateFlow$p(this.this$0).setValue(SilentOTASwitchState.Off);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            w39.a r2 = (w39.a) this.L$0;
            ResultKt.throwOnFailure(r10);
        L21:
            com.larus.dora.impl.core.request.v2.a r11 = (com.larus.dora.impl.core.request.v2.a) r10;
            if ((r11 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L62;
            g49.d.b("DoraRequestXV2", "request<T>: failed, " + r11);
            Result.Companion r3 = Result.Companion;
            Object r12 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r11)));
        L31:
            Throwable r4 = Result.exceptionOrNull-impl(r12);
            if (r4 != null) goto L39;
            DoraWifiList r13 = (DoraWifiList) ((DoraWifiResponse) r12).getData();
            if (r13 == null) goto L37;
            List<DoraWifiEntity> r14 = r13.getWifiList();
            if (r14 == null) goto L37;
        L38:
            g49.d.d(DoraGOTAViewModel.TAG, "loadSavedWifi: " + r14);
            Pair r15 = TuplesKt.to(r14, Boxing.boxBoolean(true));
        L40:
            List r5 = (List) r15.component1();
            boolean r16 = ((Boolean) r15.component2()).booleanValue();
            l0.d.set(!r5.isEmpty());
            if (r5.isEmpty() == false) goto L48;
            if (r16 == false) goto L48;
            g49.d.e(DoraGOTAViewModel.TAG, "loadSilentSwitchState: load savedWifiList success but it's empty");
            kj4.a r17 = kj4.a.g();
            this.L$0 = null;
            this.label = 3;
            if (DoraAdapterExtKt.F(r17, false) != r0) goto L46;
            return r0;
        L48:
            z0 r18 = DoraGOTAViewModel.access$get_otaSwitchStateFlow$p(this.this$0);
            SilentOTASwitchState r6 = SilentOTASwitchState.Off;
            r18.setValue(r6);
            mj4.f r110 = kj4.a.g().c;
            int r7 = r110.d.i(3, 17, new byte[]{1, 0});
            if (r7 != 0) goto L52;
            r7 = r110.r;
        L52:
            g49.d.d(DoraGOTAViewModel.TAG, "loadSilentSwitchState: " + r7);
            z0 r111 = DoraGOTAViewModel.access$get_otaSwitchStateFlow$p(this.this$0);
            if (r7 == 0) goto L57;
            if (r7 != 1) goto L57;
            r6 = SilentOTASwitchState.On;
        L57:
            r111.setValue(r6);
        L60:
            return Unit.INSTANCE;
        L37:
            r14 = CollectionsKt.emptyList();
            goto L38
        L39:
            g49.d.c(DoraGOTAViewModel.TAG, "loadSavedWifi: failed", r4);
            r15 = TuplesKt.to(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
            goto L40
        L62:
            Type r8 = new a().getType();     // Catch: Throwable -> L28
            byte[] r112 = ((com.larus.dora.impl.core.request.v2.a.b) r11).a;     // Catch: Throwable -> L28
            Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L28
            Object r113 = r2.a(r112, r8);     // Catch: Throwable -> L28
            if (r113 != null) goto L26;
            g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L28
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L28
            r12 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L28
        L61:
            goto L31
        L26:
            r12 = Result.constructor-impl(r113);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
            Result.Companion r9 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L31
        L11:
            ResultKt.throwOnFailure(r10);
        L16:
            if (((Boolean) r10).booleanValue() == false) goto L58;
            DoraRequestXV2 r115 = DoraRequestXV2.a;
            bl4.c r20 = new bl4.c();
            Lazy<w39.d> r21 = w39.d.b;
            w39.d r22 = w39.d.a.a();
            this.L$0 = r22;
            this.label = 2;
            r10 = r115.a(r20, 5000, this);
            if (r10 != r0) goto L20;
            return r0;
        L20:
            r2 = r22;
            goto L21
        L58:
            DoraGOTAViewModel.access$get_otaSwitchStateFlow$p(this.this$0).setValue(SilentOTASwitchState.Unsupported);
            goto L60
        L12:
            ResultKt.throwOnFailure(r10);
            sk4.e r116 = o0.a;
            this.label = 1;
            r10 = o0.f();
            if (r10 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$postInterruptSilentOTA$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$postInterruptSilentOTA$1", f = "DoraGOTAViewModel.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C04361(Continuation<? super C04361> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C04361(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            kj4.a r5 = kj4.a.g();
            this.label = 1;
            if (DoraAdapterExtKt.E(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$startDataTransfer$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$startDataTransfer$1", f = "DoraGOTAViewModel.kt", i = {}, l = {619, 622, 623}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isDebug;
        final /* synthetic */ com.larus.dora.impl.ota.g2.e $key;
        final /* synthetic */ DoraDevice $manualTarget;
        final /* synthetic */ String $sessionId;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public C04371(DoraGOTAViewModel r1, String r2, com.larus.dora.impl.ota.g2.e r3, DoraDevice r4, boolean r5, Continuation<? super C04371> r6) {
            this.this$0 = r1;
            this.$sessionId = r2;
            this.$key = r3;
            this.$manualTarget = r4;
            this.$isDebug = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04371(this.this$0, this.$sessionId, this.$key, this.$manualTarget, this.$isDebug, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r7);
        L35:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L30:
            if (((Boolean) r7).booleanValue() == true) goto L35;
            MutableSharedFlow r8 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.e r2 = com.larus.dora.impl.ota.a.e.a;
            this.label = 3;
            if (r8.emit(r2, this) != r0) goto L35;
            return r0;
        L11:
            ResultKt.throwOnFailure(r7);
        L25:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r7);
            if (DoraGOTAViewModel.access$ownsManualPageAction(this.this$0, this.$sessionId, this.$key) == false) goto L35;
            if (o59.a.k(this.$manualTarget) == false) goto L35;
            DoraWifiLinkWrapper.a.getClass();
            x39.a r9 = DoraWifiLinkWrapper.o();
            Intrinsics.checkNotNullParameter(r9, "precheck");
            com.larus.dora.impl.ota.connector.a.f r3 = com.larus.dora.impl.ota.connector.a.f.a;
            if ((r9 instanceof x39.a.e) == true) goto L20;
            r3 = null;
        L20:
            if (r3 == null) goto L26;
            MutableSharedFlow r10 = DoraGOTAViewModel.access$get_otaConnectorIntentSharedFlow$p(this.this$0);
            this.label = 1;
            if (r10.emit(r3, this) != r0) goto L25;
            return r0;
        L26:
            G2OtaFacade r11 = G2OtaFacade.INSTANCE;
            DoraDevice r4 = this.$manualTarget;
            com.larus.dora.impl.ota.g2.e r5 = this.$key;
            boolean r6 = this.$isDebug;
            this.label = 2;
            r7 = r11.C(r4, r5, r6);
            if (r7 != r0) goto L30;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$startDataTransfer$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$startDataTransfer$2", f = "DoraGOTAViewModel.kt", i = {0}, l = {634, 642, 657, 660}, m = "invokeSuspend", n = {"current"}, s = {"L$0"})
    public static final class C04382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e49.a $responseWrapper;
        Object L$0;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public C04382(DoraGOTAViewModel r1, e49.a r2, Continuation<? super C04382> r3) {
            this.this$0 = r1;
            this.$responseWrapper = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04382(this.this$0, this.$responseWrapper, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r6v6, types: [com.larus.dora.impl.ota.g.d0] */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r9);
        L52:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r9);
        L47:
            return Unit.INSTANCE;
        L13:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r9);
        L25:
            final String r10 = (String) r9;
            if (r10 == null) goto L28;
            final DoraDevice r3 = kj4.a.g().c();
            if (r3 != null) goto L32;
        L43:
            G2OtaFacade.INSTANCE.getClass();
            G2OtaFacade.T(r2, r10);
            MutableSharedFlow r11 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.b r4 = com.larus.dora.impl.ota.a.b.a;
            this.L$0 = null;
            this.label = 2;
            if (r11.emit(r4, this) != r0) goto L47;
            return r0;
        L32:
            if (o59.a.k(r3) == false) goto L43;
            if (Intrinsics.areEqual(r3.sn, r2.sn) == false) goto L43;
            if (r3.productId != r2.productId) goto L43;
            G2OtaFacade r5 = G2OtaFacade.INSTANCE;
            final e49.a r6 = this.$responseWrapper;
            ?? r7 = new d0(r3, r6, r10);
            r5.getClass();
            if (G2OtaFacade.Z(r3, r10, r7) == true) goto L52;
            G2OtaFacade.T(r3, r10);
            MutableSharedFlow r12 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.b r8 = com.larus.dora.impl.ota.a.b.a;
            this.L$0 = null;
            this.label = 3;
            if (r12.emit(r8, this) != r0) goto L52;
            return r0;
        L28:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r9);
            r2 = DoraGOTAViewModel.access$targetDevice(this.this$0);
            g49.d.d(DoraGOTAViewModel.TAG, "startDataTransfer: " + r2);
            if (r2 != null) goto L17;
        L48:
            MutableSharedFlow r13 = DoraGOTAViewModel.access$get_otaCommonIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.ota.a.b r14 = com.larus.dora.impl.ota.a.b.a;
            this.label = 4;
            if (r13.emit(r14, this) != r0) goto L52;
            return r0;
        L17:
            if (o59.a.k(r2) == false) goto L48;
            if (o59.a.m(Boxing.boxInt(r2.productId)) == true) goto L21;
            G2OtaFacade r15 = G2OtaFacade.INSTANCE;
            this.L$0 = r2;
            this.label = 1;
            r9 = r15.o(r2, this);
            if (r9 != r0) goto L25;
            return r0;
        L21:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g.DoraGOTAViewModel$updateSilenceSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$updateSilenceSwitch$1", f = "DoraGOTAViewModel.kt", i = {}, l = {250, 262}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isOn;
        final /* synthetic */ boolean $pendingOpen;
        int label;
        final /* synthetic */ DoraGOTAViewModel this$0;

        public C04391(boolean r1, boolean r2, DoraGOTAViewModel r3, Continuation<? super C04391> r4) {
            this.$isOn = r1;
            this.$pendingOpen = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04391(this.$isOn, this.$pendingOpen, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L36:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L20:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r6);
            if (this.$isOn == true) goto L13;
        L21:
            int r7 = kj4.a.g().s(this.$isOn);
            g49.d.d(DoraGOTAViewModel.TAG, "updateSilenceSwitch: " + this.$isOn + ", ret=" + r7);
            if (r7 != 0) goto L32;
            int r8 = j69.a.a;
            if (this.$isOn == false) goto L26;
            String r9 = "on";
        L27:
            j69.a.b("silent_ota_switch", MapsKt.mapOf(TuplesKt.to("status", r9)));
            z0 r10 = DoraGOTAViewModel.access$get_otaSwitchStateFlow$p(this.this$0);
            if (this.$isOn == false) goto L30;
            SilentOTASwitchState r2 = SilentOTASwitchState.On;
        L31:
            r10.setValue(r2);
            goto L36
        L30:
            r2 = SilentOTASwitchState.Off;
            goto L31
        L26:
            r9 = "off";
            goto L27
        L32:
            MutableSharedFlow r11 = DoraGOTAViewModel.access$get_otaUiIntentSharedFlow$p(this.this$0);
            w.b r3 = w.b.a;
            this.label = 2;
            if (r11.emit(r3, this) != r0) goto L36;
            return r0;
        L13:
            if (l0.d.get() == true) goto L21;
            g49.d.d(DoraGOTAViewModel.TAG, "updateSilenceSwitch: true, no saved wifi, pendingOpen=" + this.$pendingOpen);
            if (this.$pendingOpen == true) goto L20;
            MutableSharedFlow r12 = DoraGOTAViewModel.access$get_otaUiIntentSharedFlow$p(this.this$0);
            w.a r4 = w.a.a;
            this.label = 1;
            if (r12.emit(r4, this) != r0) goto L20;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(DoraDevice r0, b r1, String r2, com.larus.dora.impl.ota.g2.e r3) {
        return bindConnectedTarget$lambda$16$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit No(DoraDevice r0, boolean r1, String r2, com.larus.dora.impl.ota.g2.e r3) {
        return checkUpdate$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ ConnectivityManager Oo() {
        return connectivityManager_delegate$lambda$0();
    }

    public static /* synthetic */ Unit Po(DoraDevice r0, boolean r1, String r2, com.larus.dora.impl.ota.g2.e r3) {
        return onManualPageResumed$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ void yo(DoraGOTAViewModel r0, DoraDevice r1, int r2, int r3) {
        doraLinkCallback$lambda$1(r0, r1, r2, r3);
    }

    public final void onManualPagePaused() {
    }

    private static final ConnectivityManager connectivityManager_delegate$lambda$0() {
        Object r0 = AppHost.a.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) r0;
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    private final void registerOTAResumeNetworkCallback() {
        if (this.isOtaNetworkCallbackRegistered == false) goto L10;
        return;
    L10:
        NetworkRequest r1 = new NetworkRequest.Builder().addTransportType(1).build();     // Catch: Exception -> L7
        getConnectivityManager().registerNetworkCallback(r1, this.otaNetworkCallback);     // Catch: Exception -> L7
        this.isOtaNetworkCallbackRegistered = true;     // Catch: Exception -> L7
        g49.d.d(TAG, "registerOTAResumeNetworkCallback");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        g49.d.c(TAG, "registerOTAResumeNetworkCallback: failed", e);
    }

    private final void unregisterOTAResumeNetworkCallback() {
        if (this.isOtaNetworkCallbackRegistered == true) goto L10;
        return;
    L10:
        getConnectivityManager().unregisterNetworkCallback(this.otaNetworkCallback);     // Catch: Exception -> L7
        this.isOtaNetworkCallbackRegistered = false;     // Catch: Exception -> L7
        g49.d.d(TAG, "unregisterOTAResumeNetworkCallback");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        g49.d.c(TAG, "unregisterOTAResumeNetworkCallback: failed", e);
    }

    private final boolean usesG2Engine() {
        G2OtaFacade.INSTANCE.getClass();
        Set r0 = ((b5) G2OtaFacade.A().getValue()).c().keySet();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((com.larus.dora.impl.ota.g2.e) r1.next()).b(), this.sn) == false) goto L9;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L27;
        DoraDevice r3 = targetDevice();
        if (r3 != null) goto L18;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == true) goto L27;
        return false;
    L18:
        if (Intrinsics.areEqual(r3.sn, this.sn) == true) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 != true) goto L25;
        r4 = true;
        goto L26
    L20:
        if (o59.a.m(Integer.valueOf(r3.productId)) == false) goto L22;
        r5 = true;
    L27:
        return true;
    L13:
        r2 = false;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final void loadSilentSwitchState() {
        DoraDevice r14 = targetDevice();
        if (r14 != null) goto L5;
    L8:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04351(this, null), 2, null);
        return;
    L5:
        if (o59.a.m(Integer.valueOf(r14.productId)) == false) goto L8;
        G2OtaFacade r1 = G2OtaFacade.INSTANCE;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "device");
        G2OtaFacade.O(r1, r14, Trigger.CONDITION_CHANGED, false, null, null, null, null, null, null, null, null, 2040);
        publishG2SwitchState(r14);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.ota.g.DoraGOTAViewModel$otaNetworkCallback$1] */
    public DoraGOTAViewModel() {
        StateFlowImpl r0 = j1.a(x.l.a);
        this._otaUiStateFlow = r0;
        this.otaUiStateFlow = r0;
        MutableSharedFlow<u> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._otaIntentSharedFlow = r3;
        this.otaIntentSharedFlow = r3;
        MutableSharedFlow<com.larus.dora.impl.ota.a> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._otaCommonIntentSharedFlow = r4;
        this.otaCommonIntentSharedFlow = r4;
        MutableSharedFlow<com.larus.dora.impl.ota.connector.a> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._otaConnectorIntentSharedFlow = r5;
        this.otaConnectorIntentSharedFlow = r5;
        StateFlowImpl r6 = j1.a(SilentOTASwitchState.Unsupported);
        this._otaSwitchStateFlow = r6;
        this.otaSwitchStateFlow = r6;
        MutableSharedFlow<w> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._otaUiIntentSharedFlow = r1;
        this.otaUiIntentSharedFlow = r1;
        this.sn = "";
        this.manualPageDevices = new LinkedHashMap();
        this.connectivityManager$delegate = LazyKt.lazy(new a0());
        this.otaNetworkCallback = new DoraGOTAViewModel$otaNetworkCallback$1(this);
        IDoraLinkCallback r2 = new b0(this);
        this.doraLinkCallback = r2;
        c r7 = new c(this);
        this.doraBudsCallback = r7;
        g49.d.d(TAG, "init " + hashCode());
        kj4.a.g().registerDoraLinkCallback(r2);
        kj4.a.g().k(r7);
        registerOTAResumeNetworkCallback();
        collectFlow();
    }

    private final void collectFlow() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04322(this, null), 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass3(this, null), 2, null);
    }

    private final void postInterruptSilentOTA() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04361(null), 2, null);
    }

    private final DoraDevice targetDevice() {
        kj4.a r0 = kj4.a.g();
        DoraDevice r1 = r0.c();
        String r2 = this.targetDeviceMac;
        Object r4 = null;
        if (r2 != null) goto L13;
        if (r1 == null) goto L10;
        String r5 = r1.mac;
        if (r5 == null) goto L10;
        if ((!StringsKt.isBlank(r5)) == false) goto L10;
    L11:
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r2 == null) goto L69;
        Intrinsics.checkNotNull(r0);
        List r3 = DoraAdapterExtKt.k(r0);
        Intrinsics.checkNotNullParameter(r5, "routedMac");
        Intrinsics.checkNotNullParameter(r3, "boundDevices");
        if (r1 != null) goto L19;
    L29:
        List r6 = r3;
        Iterator r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L40;
        Object r8 = r7.next();
        DoraDevice r9 = (DoraDevice) r8;
        if (Intrinsics.areEqual(r9.mac, r5) == true) goto L35;
    L37:
        boolean r10 = false;
    L38:
        if (r10 == false) goto L31;
    L41:
        DoraDevice r11 = (DoraDevice) r8;
        if (r11 != null) goto L57;
        if (r1 != null) goto L45;
    L47:
        r1 = null;
    L48:
        if (r1 != null) goto L67;
        Iterator r12 = r6.iterator();
    L51:
        if (r12.hasNext() == false) goto L68;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((DoraDevice) r13).mac, r5) == false) goto L51;
        r4 = r13;
    L68:
        return (DoraDevice) r4;
    L67:
        return r1;
    L45:
        if (Intrinsics.areEqual(r1.mac, r5) == false) goto L47;
    L57:
        return r11;
    L35:
        if (j0.c(r9.sn) == false) goto L37;
        r10 = true;
        goto L38
    L40:
        r8 = null;
        goto L41
    L19:
        if (Intrinsics.areEqual(r1.mac, r5) == true) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == false) goto L26;
        DoraDevice r15 = r1;
    L27:
        if (r15 == null) goto L29;
        return r15;
    L26:
        r15 = null;
        goto L27
    L21:
        if (j0.c(r1.sn) == false) goto L23;
        r14 = true;
        goto L24
    L69:
        return r1;
    L10:
        r5 = null;
        goto L11
    L13:
        r5 = r2;
        goto L14
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, "onCleared " + hashCode());
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        kj4.a.g().E(this.doraBudsCallback);
        unregisterOTAResumeNetworkCallback();
    }

    public final d1<com.larus.dora.impl.ota.a> getOtaCommonIntentSharedFlow() {
        return this.otaCommonIntentSharedFlow;
    }

    public final d1<com.larus.dora.impl.ota.connector.a> getOtaConnectorIntentSharedFlow() {
        return this.otaConnectorIntentSharedFlow;
    }

    public final d1<u> getOtaIntentSharedFlow() {
        return this.otaIntentSharedFlow;
    }

    public final i1<SilentOTASwitchState> getOtaSwitchStateFlow() {
        return this.otaSwitchStateFlow;
    }

    public final d1<w> getOtaUiIntentSharedFlow() {
        return this.otaUiIntentSharedFlow;
    }

    public final i1<x> getOtaUiStateFlow() {
        return this.otaUiStateFlow;
    }

    public static final /* synthetic */ ConnectivityManager access$getConnectivityManager(DoraGOTAViewModel r0) {
        return r0.getConnectivityManager();
    }

    public static final /* synthetic */ String access$getSn$p(DoraGOTAViewModel r0) {
        return r0.sn;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_otaCommonIntentSharedFlow$p(DoraGOTAViewModel r0) {
        return r0._otaCommonIntentSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_otaConnectorIntentSharedFlow$p(DoraGOTAViewModel r0) {
        return r0._otaConnectorIntentSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_otaIntentSharedFlow$p(DoraGOTAViewModel r0) {
        return r0._otaIntentSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_otaSwitchStateFlow$p(DoraGOTAViewModel r0) {
        return r0._otaSwitchStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_otaUiIntentSharedFlow$p(DoraGOTAViewModel r0) {
        return r0._otaUiIntentSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_otaUiStateFlow$p(DoraGOTAViewModel r0) {
        return r0._otaUiStateFlow;
    }

    public static final /* synthetic */ void access$postInterruptSilentOTA(DoraGOTAViewModel r0) {
        r0.postInterruptSilentOTA();
    }

    public static final /* synthetic */ DoraDevice access$targetDevice(DoraGOTAViewModel r0) {
        return r0.targetDevice();
    }

    public static final /* synthetic */ boolean access$usesG2Engine(DoraGOTAViewModel r0) {
        return r0.usesG2Engine();
    }

    private final com.larus.dora.impl.ota.g2.e g2Key(DoraDevice r3) {
        String r1 = r3.sn;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        com.larus.dora.impl.ota.g2.e r0 = new com.larus.dora.impl.ota.g2.e(r1, r3.productId);
        if (o59.a.m(Integer.valueOf(r0.a())) == true) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L15;
        return null;
    L15:
        return r0;
    L8:
        if (j0.c(r0.b()) == false) goto L10;
        r4 = true;
        goto L11
    }

    private final boolean hasCompleteG2Version(DoraDevice r4) {
        String r0 = r4.androidOSVersion;
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if ((!StringsKt.isBlank(r0)) == false) goto L19;
        String r2 = r4.androidRomVersion;
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if ((!StringsKt.isBlank(r2)) == false) goto L19;
        String r5 = r4.androidBuildTime;
        if (r5 == null) goto L17;
        r1 = r5;
    L17:
        if ((!StringsKt.isBlank(r1)) == false) goto L19;
        return true;
    L19:
        return false;
    }

    private final void publishG2SwitchState(DoraDevice r3) {
        G2OtaFacade.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r3, "device");
        com.larus.dora.impl.ota.g2.e r4 = G2OtaFacade.F(r3);
        if (r4 == null) goto L9;
        com.larus.dora.impl.ota.g2.f r5 = (com.larus.dora.impl.ota.g2.f) ((b5) G2OtaFacade.A().getValue()).c().get(r4);
        if (r5 == null) goto L7;
        o5 r6 = r5.o();
    L8:
        if (r6 == null) goto L9;
    L10:
        z0<SilentOTASwitchState> r0 = this._otaSwitchStateFlow;
        if (r6.g() == true) goto L14;
        SilentOTASwitchState r7 = SilentOTASwitchState.Unsupported;
    L17:
        r0.setValue(r7);
        return;
    L14:
        if (r6.e() == false) goto L16;
        r7 = SilentOTASwitchState.On;
        goto L17
    L16:
        r7 = SilentOTASwitchState.Off;
        goto L17
    L7:
        r6 = null;
    L9:
        DoraSetting.a.getClass();
        r6 = new o5(DoraSetting.i().a, 14);
        goto L10
    }

    public final void onManualPageDestroyed(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Map<String, b> r0 = this.manualPageDevices;
        monitor-enter(r0);
        b r1 = this.manualPageDevices.remove(r4);     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        com.larus.dora.impl.ota.g2.e r2 = r1.a;     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        G2OtaFacade.INSTANCE.getClass();     // Catch: Throwable -> L11
        G2OtaFacade.H(r2, r4);     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void startDataTransfer(e49.a r3) {
        Intrinsics.checkNotNullParameter(r3, "responseWrapper");
        startDataTransfer(r3, false, "");
    }

    public static final /* synthetic */ void access$publishG2SwitchState(DoraGOTAViewModel r0, DoraDevice r1) {
        r0.publishG2SwitchState(r1);
    }

    public static final /* synthetic */ void access$setSn$p(DoraGOTAViewModel r0, String r1) {
        r0.sn = r1;
    }

    private final boolean bindConnectedTarget(final DoraDevice r12, boolean r13) {
        Map<String, b> r0 = this.manualPageDevices;
        monitor-enter(r0);
        DoraDevice r1 = kj4.a.g().c();     // Catch: Throwable -> L63
        if (r1 == null) goto L7;
        String r2 = r1.mac;     // Catch: Throwable -> L63
    L8:
        boolean r3 = false;
        if (r13 == false) goto L16;
        int r14 = r12.productId;     // Catch: Throwable -> L63
        String r5 = r12.mac;     // Catch: Throwable -> L63
        String r6 = this.targetDeviceMac;     // Catch: Throwable -> L63
        if (o59.a.m(Integer.valueOf(r14)) == true) goto L13;
    L15:
        boolean r15 = false;
    L17:
        if (r15 == false) goto L61;
        com.larus.dora.impl.ota.g2.e r16 = g2Key(r12);     // Catch: Throwable -> L63
        if (r16 == null) goto L22;
    L23:
        String r4 = r12.sn;     // Catch: Throwable -> L63
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        this.sn = r4;     // Catch: Throwable -> L63
    L27:
        Iterator r7 = MapsKt.toMap(this.manualPageDevices).entrySet().iterator();     // Catch: Throwable -> L63
    L28:
        if (r7.hasNext() == false) goto L60;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L63
        final String r9 = (String) r8.getKey();     // Catch: Throwable -> L63
        final b r10 = (b) r8.getValue();     // Catch: Throwable -> L63
        com.larus.dora.impl.ota.g2.e r11 = r10.a;     // Catch: Throwable -> L63
        int r17 = r12.productId;     // Catch: Throwable -> L63
        boolean r18 = Intrinsics.areEqual(r10.c, r12.mac);     // Catch: Throwable -> L63
        if (r16 != null) goto L41;
        if (r11 != null) goto L34;
    L40:
        com.larus.dora.impl.ota.g2.e r20 = null;
    L42:
        boolean r21 = !Intrinsics.areEqual(r20, r11);     // Catch: Throwable -> L63
        com.larus.dora.impl.ota.g2.e r22 = r10.a;     // Catch: Throwable -> L63
        if (r22 == null) goto L47;
        G2OtaFacade.INSTANCE.getClass();     // Catch: Throwable -> L63
        if (((b5) G2OtaFacade.A().getValue()).b(r22).s().l() != true) goto L47;
        boolean r23 = true;
    L48:
        boolean r110 = hasCompleteG2Version(r12);     // Catch: Throwable -> L63
        if (r22 != null) goto L51;
    L55:
        boolean r24 = false;
    L56:
        if (r21 == true) goto L58;
        if (r24 == false) goto L28;
    L58:
        bindManualPageDevice(r9, r12, r10.b, new c0(r12, r10, r9));     // Catch: Throwable -> L63
        goto L28
    L51:
        if (Intrinsics.areEqual(r22, r16) == false) goto L55;
        if (r23 == true) goto L55;
        if (r110 == false) goto L55;
        r24 = true;
    L47:
        r23 = false;
        goto L48
    L34:
        if (o59.a.m(Integer.valueOf(r17)) == false) goto L37;
        if (r18 == false) goto L37;
        boolean r25 = true;
    L38:
        if (r25 == false) goto L40;
        r20 = r11;
    L37:
        r25 = false;
        goto L38
    L41:
        r20 = r16;
        goto L42
    L60:
        r3 = true;
        goto L61
    L22:
        if (o59.a.m(Integer.valueOf(r12.productId)) == true) goto L27;
    L61:
        monitor-exit(r0);
        return r3;
    L13:
        if (f0.a(r5, r6, r2) == false) goto L15;
        r15 = true;
        goto L17
    L16:
        r15 = f0.a(r12.mac, this.targetDeviceMac, r2);     // Catch: Throwable -> L63
        goto L17
    L7:
        r2 = null;
    L63:
        th = move-exception;
        throw th;
    }

    private final com.larus.dora.impl.ota.g2.e manualPageActionKey(String r4, DoraDevice r5) {
        com.larus.dora.impl.ota.g2.e r6 = g2Key(r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank(r4) == false) goto L8;
        return r6;
    L8:
        Map<String, b> r1 = this.manualPageDevices;
        monitor-enter(r1);
        b r7 = this.manualPageDevices.get(r4);     // Catch: Throwable -> L25
        if (r7 == null) goto L14;
        com.larus.dora.impl.ota.g2.e r8 = r7.a;     // Catch: Throwable -> L25
    L15:
        monitor-exit(r1);
        if (r8 != null) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L24;
        return r6;
    L24:
        return null;
    L18:
        if (Intrinsics.areEqual(r8, r6) == false) goto L20;
        r9 = true;
        goto L21
    L14:
        r8 = null;
    L25:
        th = move-exception;
        throw th;
    }

    private final boolean ownsManualPageAction(String r4, com.larus.dora.impl.ota.g2.e r5) {
        boolean r1 = true;
        if (StringsKt.isBlank(r4) == false) goto L5;
        return true;
    L5:
        Map<String, b> r0 = this.manualPageDevices;
        monitor-enter(r0);
        b r6 = this.manualPageDevices.get(r4);     // Catch: Throwable -> L18
        if (r6 == null) goto L10;
        com.larus.dora.impl.ota.g2.e r7 = r6.a;     // Catch: Throwable -> L18
    L11:
        if (r7 == null) goto L15;
        if (Intrinsics.areEqual(r7, r5) == false) goto L15;
    L16:
        monitor-exit(r0);
        return r1;
    L15:
        r1 = false;
        goto L16
    L10:
        r7 = null;
    L18:
        th = move-exception;
        throw th;
    }

    private final void rememberManualPageSession(String r6, boolean r7) {
        if (StringsKt.isBlank(r6) == false) goto L5;
        return;
    L5:
        Map<String, b> r0 = this.manualPageDevices;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (this.manualPageDevices.containsKey(r6) == true) goto L16;
        Map<String, b> r1 = this.manualPageDevices;     // Catch: Throwable -> L19
        String r3 = this.targetDeviceMac;     // Catch: Throwable -> L19
        if (r3 != null) goto L15;
        DoraDevice r4 = kj4.a.g().c();     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
        r3 = r4.mac;     // Catch: Throwable -> L19
        goto L15
    L14:
        r3 = null;
    L15:
        r1.put(r6, new b(null, r7, r3));     // Catch: Throwable -> L19
    L16:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
    }

    public final void download(e49.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "responseWrapper");
        download(r3, r4, false, "");
    }

    public final void onManualPageResumed(final boolean r18, final String r110) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        final DoraDevice r5 = targetDevice();
        if (r5 != null) goto L6;
        rememberManualPageSession(r110, r18);
        return;
    L6:
        bindManualPageDevice(r110, r5, r18, new z(r5, r18, r110));
        if (o59.a.m(Integer.valueOf(r5.productId)) == false) goto L10;
        G2OtaFacade r4 = G2OtaFacade.INSTANCE;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "device");
        G2OtaFacade.O(r4, r5, Trigger.CONDITION_CHANGED, false, null, null, null, null, null, null, null, null, 2040);
        return;
    }

    public final void setTargetDeviceMac$impl_mainlandRelease(String r4, int r5) {
        Map<String, b> r0 = this.manualPageDevices;
        monitor-enter(r0);
        String r1 = null;
        boolean r2 = true;
        if (o59.a.m(Integer.valueOf(r5)) == false) goto L12;
        if (r4 == null) goto L12;
        if ((!StringsKt.isBlank(r4)) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L12;
    L13:
        this.targetDeviceMac = r4;     // Catch: Throwable -> L30
        DoraDevice r6 = targetDevice();     // Catch: Throwable -> L30
        if (r6 == null) goto L16;
        r1 = r6.sn;     // Catch: Throwable -> L30
    L16:
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        this.sn = r1;     // Catch: Throwable -> L30
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r0);
        StringBuilder r8 = new StringBuilder("setTargetDeviceMac routed=");
        if (this.targetDeviceMac == null) goto L23;
        boolean r3 = true;
    L24:
        r8.append(r3);
        r8.append(" resolved=");
        if (this.sn.length() > 0) goto L28;
        r2 = false;
    L28:
        r8.append(r2);
        g49.d.d(TAG, r8.toString());
        return;
    L23:
        r3 = false;
    L12:
        r4 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public final void startDataTransfer(e49.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "responseWrapper");
        startDataTransfer(r2, r3, "");
    }

    public final void updateSilenceSwitch(boolean r10, boolean r11) {
        DoraDevice r0 = targetDevice();
        if (r0 != null) goto L5;
    L15:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04391(r10, r11, this, null), 2, null);
        return;
    L5:
        if (o59.a.m(Integer.valueOf(r0.productId)) == false) goto L15;
        G2OtaFacade.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r0, "device");
        com.larus.dora.impl.ota.g2.e r12 = G2OtaFacade.F(r0);
        if (r12 != null) goto L10;
        return;
    L10:
        if (r10 == false) goto L12;
        UserChoice r13 = UserChoice.ON;
    L13:
        G2OtaFacade.Y(new com.larus.dora.impl.ota.g2.s.f0(r12, r13, System.currentTimeMillis()));
        return;
    L12:
        r13 = UserChoice.OFF;
        goto L13
    }

    public static final /* synthetic */ boolean access$bindConnectedTarget(DoraGOTAViewModel r0, DoraDevice r1, boolean r2) {
        return r0.bindConnectedTarget(r1, r2);
    }

    public static final /* synthetic */ boolean access$ownsManualPageAction(DoraGOTAViewModel r0, String r1, com.larus.dora.impl.ota.g2.e r2) {
        return r0.ownsManualPageAction(r1, r2);
    }

    public final void checkUpdate(DoraOTACheckFrom r7, final boolean r8, final String r9) {
        Intrinsics.checkNotNullParameter(r7, "from");
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        final DoraDevice r0 = targetDevice();
        StringBuilder r1 = new StringBuilder("checkUpdate: target=");
        if (r0 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(", isDebug=");
        r1.append(r8);
        g49.d.d(TAG, r1.toString());
        if (r0 == null) goto L11;
        bindManualPageDevice(r9, r0, r8, new y(r0, r8, r9));
        if (o59.a.m(Integer.valueOf(r0.productId)) == false) goto L12;
        return;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(this, r7, r8, null), 2, null);
        return;
    L11:
        rememberManualPageSession(r9, r8);
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void download(e49.a r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "responseWrapper");
        download(r2, r3, r4, "");
    }

    public final void startDataTransfer(e49.a r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "responseWrapper");
        Intrinsics.checkNotNullParameter(r15, "sessionId");
        DoraDevice r0 = targetDevice();
        if (r0 != null) goto L5;
    L7:
        DoraDevice r7 = null;
    L8:
        if (r7 == null) goto L14;
        com.larus.dora.impl.ota.g2.e r6 = manualPageActionKey(r15, r7);
        if (r6 != null) goto L12;
        return;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04371(this, r15, r6, r7, r14, null), 2, null);
        return;
    L14:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04382(this, r13, null), 2, null);
        return;
    L5:
        if (o59.a.m(Integer.valueOf(r0.productId)) == false) goto L7;
        r7 = r0;
        goto L8
    }

    private static final Unit bindConnectedTarget$lambda$16$lambda$15$lambda$14(DoraDevice r1, b r2, String r3, com.larus.dora.impl.ota.g2.e r4) {
        Intrinsics.checkNotNullParameter(r4, "stableKey");
        G2OtaFacade.INSTANCE.q(r1, r4, r2.b, r3);
        return Unit.INSTANCE;
    }

    private final void bindManualPageDevice(String r10, DoraDevice r11, boolean r12, Function1<? super com.larus.dora.impl.ota.g2.e, Unit> r13) {
        if (StringsKt.isBlank(r10) == false) goto L5;
        return;
    L5:
        com.larus.dora.impl.ota.g2.e r0 = g2Key(r11);
        Map<String, b> r1 = this.manualPageDevices;
        monitor-enter(r1);
        b r2 = this.manualPageDevices.get(r10);     // Catch: Throwable -> L57
        if (r2 == null) goto L10;
        com.larus.dora.impl.ota.g2.e r4 = r2.a;     // Catch: Throwable -> L57
    L11:
        int r5 = r11.productId;     // Catch: Throwable -> L57
        if (r2 == null) goto L14;
        String r6 = r2.c;     // Catch: Throwable -> L57
    L15:
        boolean r7 = Intrinsics.areEqual(r6, r11.mac);     // Catch: Throwable -> L57
        boolean r8 = false;
        if (r0 != null) goto L26;
        if (r4 != null) goto L19;
    L25:
        r4 = null;
    L27:
        if (r2 == null) goto L29;
        String r9 = r2.c;     // Catch: Throwable -> L57
    L30:
        if (r0 != null) goto L37;
        if (r2 == null) goto L33;
        com.larus.dora.impl.ota.g2.e r3 = r2.a;     // Catch: Throwable -> L57
    L35:
        if (Intrinsics.areEqual(r4, r3) == false) goto L37;
        r8 = true;
        goto L37
    L33:
        r3 = null;
    L37:
        if (r8 == true) goto L40;
        r9 = null;
    L40:
        if (r9 != null) goto L42;
        r9 = r11.mac;     // Catch: Throwable -> L57
    L42:
        this.manualPageDevices.put(r10, new b(r4, r12, r9));     // Catch: Throwable -> L57
        if (r2 != null) goto L45;
    L52:
        if (r4 == null) goto L54;
        r13.invoke(r4);     // Catch: Throwable -> L57
    L54:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L57
        monitor-exit(r1);
        return;
    L45:
        if ((!Intrinsics.areEqual(r2.a, r4)) == true) goto L48;
        r2 = null;
    L48:
        if (r2 == null) goto L52;
        com.larus.dora.impl.ota.g2.e r15 = r2.a;     // Catch: Throwable -> L57
        if (r15 == null) goto L52;
        G2OtaFacade.INSTANCE.getClass();     // Catch: Throwable -> L57
        G2OtaFacade.H(r15, r10);     // Catch: Throwable -> L57
        goto L52
    L29:
        r9 = null;
        goto L30
    L19:
        if (o59.a.m(Integer.valueOf(r5)) == false) goto L22;
        if (r7 == false) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
    L22:
        r16 = false;
        goto L23
    L26:
        r4 = r0;
        goto L27
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
    L57:
        th = move-exception;
        throw th;
    }

    private static final Unit checkUpdate$lambda$6(DoraDevice r1, boolean r2, String r3, com.larus.dora.impl.ota.g2.e r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        G2OtaFacade.INSTANCE.q(r1, r4, r2, r3);
        return Unit.INSTANCE;
    }

    private static final void doraLinkCallback$lambda$1(DoraGOTAViewModel r1, DoraDevice r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r4 == 2) goto L6;
        return;
    L6:
        if (bindConnectedTarget$default(r1, r2, false, 2, null) == false) goto L11;
        g49.d.d(TAG, "onDoraLinkStateChanged: target accepted");
        r1.loadSilentSwitchState();
        return;
    }

    private static final Unit onManualPageResumed$lambda$9(DoraDevice r15, boolean r16, String r17, com.larus.dora.impl.ota.g2.e r18) {
        Intrinsics.checkNotNullParameter(r18, "key");
        G2OtaFacade r8 = G2OtaFacade.INSTANCE;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "device");
        Intrinsics.checkNotNullParameter(r18, "key");
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        DoraSetting.a.getClass();
        long r6 = DoraSetting.i().d;
        G2OtaFacade.Y(new s$a0(r18, System.currentTimeMillis(), r16, r17, r6));
        G2OtaFacade.O(r8, r15, Trigger.MANUAL_PAGE, false, null, null, null, null, null, null, r18, null, 1528);
        return Unit.INSTANCE;
    }

    public final void download(e49.a r16, boolean r17, boolean r18, String r110) {
        Intrinsics.checkNotNullParameter(r16, "responseWrapper");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        DoraDevice r1 = targetDevice();
        if (r1 != null) goto L5;
    L7:
        DoraDevice r4 = null;
    L8:
        if (r4 == null) goto L14;
        com.larus.dora.impl.ota.g2.e r3 = manualPageActionKey(r110, r4);
        if (r3 != null) goto L12;
        return;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04331(this, r110, r3, r4, r18, r17, null), 2, null);
        return;
    L14:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04342(this, r16, r17, null), 2, null);
        return;
    L5:
        if (o59.a.m(Integer.valueOf(r1.productId)) == false) goto L7;
        r4 = r1;
        goto L8
    }

    public static /* synthetic */ boolean bindConnectedTarget$default(DoraGOTAViewModel r0, DoraDevice r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.bindConnectedTarget(r1, r2);
    }
}
