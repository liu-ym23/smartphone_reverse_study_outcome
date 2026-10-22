package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u00020\r\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00028\u0004\"\b\b\u0001\u0010\u0001*\u00028\u0003\"\f\b\u0002\u0010\u0003*\u0006\u0012\u0002\b\u00030\u0002\"\b\b\u0003\u0010\u0005*\u00020\u0004\"\b\b\u0004\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\n\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0004H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"A", "S", "Lcom/bytedance/android/anya/MVIState;", "VIEW_STATE", "Lcom/bytedance/android/anya/r;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Lcom/bytedance/android/anya/l0;", "readWriteStateContext", "state", "businessState", "action", "", "invoke", "(Lcom/bytedance/android/anya/l0;Lcom/bytedance/android/anya/MVIState;Lcom/bytedance/android/anya/r;Lcom/bytedance/android/anya/p;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class StateModifyBuilder$ActionModifyBuilder$on$1 extends Lambda implements Function4<l0<MVIState<?>>, MVIState<?>, r, p, Unit> {
    final /* synthetic */ Function4 $modifierFun;

    public StateModifyBuilder$ActionModifyBuilder$on$1(Function4 r1) {
        this.$modifierFun = r1;
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11, Object r12) {
        invoke((l0) r1, (MVIState) r10, (r) r11, (p) r12);
        return Unit.INSTANCE;
    }

    public final void invoke(l0<MVIState<?>> r10, MVIState<?> r11, r r12, p r13) {
        Function4 r0 = this.$modifierFun;
        Intrinsics.reifiedOperationMarker(1, "A");
        r0.invoke(r10, r13, r11, r12);
    }
}
