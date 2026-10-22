package com.larus.dora.impl.guide.strategy;

import android.bluetooth.BluetoothDevice;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FineDoraDeviceStrategy {
    public final BluetoothDevice a;
    public final int b;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/guide/strategy/FineDoraDeviceStrategy$CheckBindStatusResponse;", "", "bindingStatus", "", "<init>", "(Ljava/lang/Boolean;)V", "getBindingStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/dora/impl/guide/strategy/FineDoraDeviceStrategy$CheckBindStatusResponse;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("binding_status")
        private final Boolean bindingStatus;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.bindingStatus, ((a) r4).bindingStatus) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r0 = this.bindingStatus;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "CheckBindStatusResponse(bindingStatus=" + this.bindingStatus + ')';
        }

        public a() {
            this.bindingStatus = null;
        }

        public final Boolean a() {
            return this.bindingStatus;
        }
    }

    public static final class b {
    }

    static {
    }

    public final Object a(Continuation<? super Boolean> r8) {
        if ((r8 instanceof FineDoraDeviceStrategy$isConditionMet$1) == false) goto L7;
        FineDoraDeviceStrategy$isConditionMet$1 r0 = (FineDoraDeviceStrategy$isConditionMet$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L13
    L22:
        Object r10 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r9).booleanValue()));     // Catch: Throwable -> L13
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r10);
        if (r4 == null) goto L29;
        g49.d.c("FineDoraDeviceStrategy", "isConditionMet() SPP check failed: " + r4.getMessage(), r4);
        r10 = Boxing.boxBoolean(false);
    L29:
        boolean r11 = ((Boolean) r10).booleanValue();
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() SPP available=" + r11);
        return Boxing.boxBoolean(r11);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r9);
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() start vendor=" + this.b + " device=" + this.a);
        if (this.b != 4096) goto L31;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Throwable -> L13
        FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1 r5 = new FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1(this, null);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r9 = BuildersKt.withContext(r13, r5, r0);     // Catch: Throwable -> L13
        if (r9 != r2) goto L22;
        return r2;
    L31:
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() unsupported vendor: " + this.b);
        return Boxing.boxBoolean(false);
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new FineDoraDeviceStrategy$isConditionMet$1(this, r8);
        goto L8
    }

    public FineDoraDeviceStrategy(BluetoothDevice r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "device");
        this.a = r2;
        this.b = r3;
    }
}
