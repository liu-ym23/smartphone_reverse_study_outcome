package com.larus.dora.impl.device.settings.unbind;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.UnbindAndResetResult;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\u0000H&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "", "<init>", "(Ljava/lang/String;I)V", "API", "RESET", "CLEAR", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum DoraUnbindStep extends Enum<DoraUnbindStep> {
    public static final DoraUnbindStep API = null;
    public static final DoraUnbindStep CLEAR = null;
    public static final DoraUnbindStep RESET = null;
    public static final /* synthetic */ DoraUnbindStep[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/device/settings/unbind/DoraUnbindStep.API", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class API extends DoraUnbindStep {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UnbindAndResetResult.values().length];
                r0[UnbindAndResetResult.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[UnbindAndResetResult.SERVER_UNBIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[UnbindAndResetResult.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[UnbindAndResetResult.SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[UnbindAndResetResult.SPP_DISCONNECT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public DoraUnbindStep next() {
            return DoraUnbindStep.RESET;
        }

        public API(String r2, int r3) {
            super(r2, r3, null);
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public Object step(DoraDevice r5, Continuation<? super DoraUnbindState> r6) {
            if ((r6 instanceof DoraUnbindStep$API$step$1) == false) goto L7;
            DoraUnbindStep$API$step$1 r0 = (DoraUnbindStep$API$step$1) r6;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L17:
            int r8 = a.a[((UnbindAndResetResult) r7).ordinal()];
            if (r8 == 1) goto L33;
            if (r8 == 2) goto L36;
            if (r8 == 3) goto L36;
            if (r8 == 4) goto L35;
            if (r8 != 5) goto L29;
            return DoraUnbindState.SPP_DISCONNECT_FAILED;
        L29:
            throw new NoWhenBranchMatchedException();
        L35:
            return DoraUnbindState.UNBIND_SUCCESS;
        L36:
            return DoraUnbindState.SERVER_UNBIND_FAILED;
        L33:
            return DoraUnbindState.SERVER_UNBIND_NETWORK_ERROR;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            kj4.a.g();
            r0.label = 1;
            r7 = DoraAdapterExtKt.D(r5, r0);
            if (r7 != r2) goto L17;
            return r2;
        L7:
            r0 = new DoraUnbindStep$API$step$1(this, r6);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/device/settings/unbind/DoraUnbindStep.CLEAR", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CLEAR extends DoraUnbindStep {
        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public DoraUnbindStep next() {
            return null;
        }

        public CLEAR(String r2, int r3) {
            super(r2, r3, null);
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public Object step(DoraDevice r6, Continuation<? super DoraUnbindState> r7) {
            if ((r7 instanceof DoraUnbindStep$CLEAR$step$1) == false) goto L7;
            DoraUnbindStep$CLEAR$step$1 r0 = (DoraUnbindStep$CLEAR$step$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r8);
        L23:
            return DoraUnbindState.UNBIND_SUCCESS;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r6 = (DoraDevice) r0.L$0;
            ResultKt.throwOnFailure(r8);
        L19:
            kj4.a r9 = kj4.a.g();
            r0.L$0 = null;
            r0.label = 2;
            if (DoraAdapterExtKt.f(r9, r6) != r2) goto L23;
            return r2;
        L16:
            ResultKt.throwOnFailure(r8);
            DoraGGestureSettingsRepository.a.b(r6.mac);
            kj4.a r10 = kj4.a.g();
            r0.L$0 = r6;
            r0.label = 1;
            if (DoraAdapterExtKt.R(r10, true) != r2) goto L19;
            return r2;
        L7:
            r0 = new DoraUnbindStep$CLEAR$step$1(this, r7);
            goto L8
        }
    }

    public DoraUnbindStep() {
        throw null;
    }

    public static EnumEntries<DoraUnbindStep> getEntries() {
        return b;
    }

    public abstract DoraUnbindStep next();

    public abstract Object step(DoraDevice r1, Continuation<? super DoraUnbindState> r2);

    static {
        API r0 = new API("API", 0);
        API = r0;
        final String r3 = "RESET";
        final int r4 = 1;
        DoraUnbindStep r1 = new RESET(r3, r4);
        RESET = r1;
        CLEAR r5 = new CLEAR("CLEAR", 2);
        CLEAR = r5;
        DoraUnbindStep[] r6 = {r0, r1, r5};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DoraUnbindStep[] values() {
        return (DoraUnbindStep[]) a.clone();
    }

    public static DoraUnbindStep valueOf(String r1) {
        return (DoraUnbindStep) r27.a.a(DoraUnbindStep.class, r1);
    }

    public DoraUnbindStep(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
