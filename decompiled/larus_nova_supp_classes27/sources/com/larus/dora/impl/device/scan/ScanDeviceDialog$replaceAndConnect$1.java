package com.larus.dora.impl.device.scan;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.ReplaceBindAndConnectResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog$replaceAndConnect$1", f = "ScanDeviceDialog.kt", i = {}, l = {247, 249}, m = "invokeSuspend", n = {}, s = {})
final class ScanDeviceDialog$replaceAndConnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ ScanDeviceDialog this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.scan.ScanDeviceDialog$replaceAndConnect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog$replaceAndConnect$1$1", f = "ScanDeviceDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        final /* synthetic */ ReplaceBindAndConnectResult $replace;
        int label;
        final /* synthetic */ ScanDeviceDialog this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.scan.ScanDeviceDialog$replaceAndConnect$1$1$a */
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

        public AnonymousClass1(ScanDeviceDialog r1, ReplaceBindAndConnectResult r2, DoraDevice r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$replace = r2;
            this.$device = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$replace, this.$device, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r3);
            if (this.this$0.getContext() == null) goto L23;
            ReplaceBindAndConnectResult r4 = this.$replace;
            switch(a.a[r4.ordinal()]) {
                case 1: goto L19;
                case 2: goto L19;
                case 3: goto L16;
                case 4: goto L13;
                case 5: goto L13;
                case 6: goto L10;
                default: goto L9;
            };
        L10:
            ScanDeviceListAdapter r5 = this.this$0.i;
            if (r5 == null) goto L23;
            r5.y2(k.a(this.$device, 2));
            goto L23
        L13:
            s r6 = s.a;
            Application r1 = AppHost.a.getApplication();
            r6.getClass();
            s.b(r1, 2131903672, false);
            ScanDeviceListAdapter r7 = this.this$0.i;
            if (r7 == null) goto L23;
            r7.y2(k.a(this.$device, 0));
            goto L23
        L16:
            s r8 = s.a;
            Application r2 = AppHost.a.getApplication();
            r8.getClass();
            s.b(r2, 2131904024, false);
            ScanDeviceListAdapter r9 = this.this$0.i;
            if (r9 == null) goto L23;
            r9.y2(k.a(this.$device, 0));
            goto L23
        L19:
            s r10 = s.a;
            Application r11 = AppHost.a.getApplication();
            r10.getClass();
            s.b(r11, 2131908080, false);
            ScanDeviceListAdapter r12 = this.this$0.i;
            if (r12 == null) goto L23;
            r12.y2(k.a(this.$device, 0));
            goto L23
        L9:
            throw new NoWhenBranchMatchedException();
        L23:
            return Unit.INSTANCE;
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ScanDeviceDialog$replaceAndConnect$1(ScanDeviceDialog r1, DoraDevice r2, Continuation<? super ScanDeviceDialog$replaceAndConnect$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ScanDeviceDialog$replaceAndConnect$1(this.this$0, this.$device, r4);
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
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        this.this$0.j.set(false);
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        ScanDeviceDialog r4 = this.this$0;
        AnonymousClass1 r3 = new AnonymousClass1(r4, (ReplaceBindAndConnectResult) r8, this.$device, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        this.this$0.j.set(true);
        kj4.a r9 = kj4.a.g();
        DoraDevice r5 = this.$device;
        this.label = 1;
        r8 = DoraAdapterExtKt.G(r9, r5, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
