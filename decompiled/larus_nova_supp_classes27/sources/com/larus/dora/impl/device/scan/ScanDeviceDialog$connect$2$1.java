package com.larus.dora.impl.device.scan;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.BindAndConnectResult;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog$connect$2$1", f = "ScanDeviceDialog.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
final class ScanDeviceDialog$connect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BindAndConnectResult $connectResult;
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ ScanDeviceDialog this$0;

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

    public ScanDeviceDialog$connect$2$1(BindAndConnectResult r1, ScanDeviceDialog r2, DoraDevice r3, Continuation<? super ScanDeviceDialog$connect$2$1> r4) {
        this.$connectResult = r1;
        this.this$0 = r2;
        this.$device = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ScanDeviceDialog$connect$2$1(this.$connectResult, this.this$0, this.$device, r5);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L34:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        BindAndConnectResult r7 = this.$connectResult;
        switch(a.a[r7.ordinal()]) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L15;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        ScanDeviceListAdapter r8 = this.this$0.i;
        if (r8 == null) goto L32;
        r8.y2(k.a(this.$device, 2));
        return Unit.INSTANCE;
    L32:
        return null;
    L15:
        ScanDeviceDialog r9 = this.this$0;
        DoraDevice r3 = this.$device;
        this.label = 1;
        int r2 = ScanDeviceDialog.l;
        r9.getClass();
        Object r10 = BuildersKt.withContext(Dispatchers.getMain(), new ScanDeviceDialog$showNeedUnbindDialog$2(r9, r3, null), this);
        if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r10 = Unit.INSTANCE;
    L19:
        if (r10 != r0) goto L34;
        return r0;
    L22:
        s r11 = s.a;
        Application r4 = AppHost.a.getApplication();
        r11.getClass();
        s.b(r4, 2131903672, false);
        ScanDeviceListAdapter r12 = this.this$0.i;
        if (r12 == null) goto L35;
        r12.y2(k.a(this.$device, 0));
        return Unit.INSTANCE;
    L35:
        return null;
    L25:
        s r13 = s.a;
        Application r5 = AppHost.a.getApplication();
        r13.getClass();
        s.b(r5, 2131904024, false);
        ScanDeviceListAdapter r14 = this.this$0.i;
        if (r14 == null) goto L37;
        r14.y2(k.a(this.$device, 0));
        return Unit.INSTANCE;
    L37:
        return null;
    L28:
        s r15 = s.a;
        Application r16 = AppHost.a.getApplication();
        r15.getClass();
        s.b(r16, 2131908080, false);
        ScanDeviceListAdapter r17 = this.this$0.i;
        if (r17 == null) goto L39;
        r17.y2(k.a(this.$device, 0));
        return Unit.INSTANCE;
    L39:
        return null;
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
