package com.larus.dora.impl.guide;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraGuideBindDeviceDialogBinding;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBindGuide$onConfirm$1", f = "DoraBindGuide.kt", i = {}, l = {410, 418}, m = "invokeSuspend", n = {}, s = {})
final class DoraBindGuide$onConfirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraBindGuide this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.DoraBindGuide$onConfirm$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.guide.DoraBindGuide$onConfirm$1$1", f = "DoraBindGuide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraBindGuide this$0;

        public AnonymousClass1(DoraBindGuide r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r3);
            DoraBindGuide.BindBottomSheetDialogFragment r4 = this.this$0.k;
            if (r4 == null) goto L12;
            r4.e = DoraBindGuide.BindBottomSheetDialogFragment.Phase.BindFail;
            LarusDoraGuideBindDeviceDialogBinding r0 = r4.f;
            if (r0 == null) goto L16;
            FrameLayout r1 = r0.a;
            if (r1 == null) goto L16;
            r1.post(new o(r4));
        L16:
            return Unit.INSTANCE;
        L12:
            return null;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements by7.e {
        public final /* synthetic */ DoraBindGuide a;

        public final by7.e parentTrackNode() {
            return by7.i.c(this);
        }

        public final by7.e referrerTrackNode() {
            return by7.e.a.a(this);
        }

        public a(DoraBindGuide r1) {
            this.a = r1;
        }

        public final void fillTrackParams(TrackParams r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            r3.put("current_page", this.a.a);
        }
    }

    public DoraBindGuide$onConfirm$1(DoraBindGuide r1, Continuation<? super DoraBindGuide$onConfirm$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraBindGuide$onConfirm$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L17
    L15:
        Boolean r10 = (Boolean) r9;     // Catch: Exception -> L17
    L20:
        if (Intrinsics.areEqual(r10, Boxing.boxBoolean(true)) == true) goto L26;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: fine dora device strategy not met, go to bind fail phase");
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L25;
        return r0;
    L26:
        DoraBindGuide r3 = this.this$0;
        a r12 = new a(r3);
        int r4 = DoraBindGuide.p;
        BluetoothDevice r5 = r3.j().c;
        if (r5 == null) goto L29;
        g49.d.d("DoraBindGuide", "onConfirm(), jump to device bind page");
        com.bytedance.router.i r6 = SmartRouter.buildRoute(AppHost.a.getApplication(), "//flow/dora/bind_device");
        Bundle r7 = com.larus.utils.f.c(new Pair[0]);
        DoraBindGuide r8 = this.this$0;
        by7.h.k(r7, r12);
        r7.putString("extra_mac", r5.getAddress());
        r7.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");
        r7.putString("product_id", "-1");
        r7.putString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, String.valueOf(r8.j().b));
        r6.c.putExtras(r7);
        r6.d();
        DoraBindGuide.g(this.this$0);
        this.this$0.i(3);
    L31:
        return Unit.INSTANCE;
    L29:
        g49.d.b("DoraBindGuide", "onConfirm(), target device or url is null");
        goto L31
    L11:
        ResultKt.throwOnFailure(r9);
        DoraBindGuide r13 = this.this$0;     // Catch: Exception -> L17
        DoraBindGuide r14 = this.this$0;     // Catch: Exception -> L17
        int r15 = DoraBindGuide.p;     // Catch: Exception -> L17
        BluetoothDevice r16 = r14.j().c;     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L17
        Integer r17 = this.this$0.j().b;     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L17
        r13.j = new FineDoraDeviceStrategy(r16, r17.intValue());     // Catch: Exception -> L17
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Exception -> L17
        DoraBindGuide$onConfirm$1$isMet$1 r20 = new DoraBindGuide$onConfirm$1$isMet$1(this.this$0, null);     // Catch: Exception -> L17
        this.label = 1;     // Catch: Exception -> L17
        r9 = BuildersKt.withContext(r18, r20, this);     // Catch: Exception -> L17
        if (r9 != r0) goto L15;
        return r0;
    L17:
        e = move-exception;
        g49.d.c("DoraBindGuide", "FineDoraDeviceStrategy check failed: " + e.getMessage(), e);
        r10 = null;
        goto L20
    }
}
