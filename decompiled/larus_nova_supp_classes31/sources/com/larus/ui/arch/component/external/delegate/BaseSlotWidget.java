package com.larus.ui.arch.component.external.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H'R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseSlotWidget;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget;", "Lcom/larus/ui/arch/context/external/EmptyVWidgetData;", "<init>", "()V", "slotViewId", "", "getSlotViewId", "()I", "setSlotViewId", "(I)V", "onCreateView", "", "injectViewFactory", "Lcom/larus/ui/arch/component/external/SlotViewFactory;", "contentLayoutId", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class BaseSlotWidget extends BaseComponentWidget<Object> {
    public int k;

    public static final class a implements l1a.a {
        public final /* synthetic */ BaseSlotWidget a;

        public a(BaseSlotWidget r1) {
            this.a = r1;
        }

        @Override // l1a.a
        public final View a(ViewGroup r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "containerView");
            Intrinsics.checkNotNullParameter(r4, "context");
            return LayoutInflater.from(r4).inflate(this.a.P2(), r3, false);
        }
    }

    public abstract int P2();

    public final void S1() {
        ComponentStateController r0 = ((BaseComponentFeatureInternal) this).e;
        FragmentActivity r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateController");
        r0 = null;
    L6:
        Object r2 = r0.e;
        if ((r2 instanceof View) == false) goto L9;
        View r3 = (View) r2;
    L10:
        if (r3 == null) goto L12;
        ViewGroup r4 = (ViewGroup) r3.findViewById(this.k);
    L13:
        if (r4 == null) goto L22;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ((BaseComponentWidget) this).j = r4;
        View r5 = U2().a(r4, getContext());
        Context r6 = getContext();
        if ((r6 instanceof FragmentActivity) == false) goto L17;
        r1 = (FragmentActivity) r6;
    L17:
        r4.addView(r5);
        if (r1 == null) goto L23;
        Attachable.Companion.getClass();
        N2(r5, Attachable.a.a(r1));
        return;
    L23:
        return;
    L22:
        throw new IllegalStateException("container view in stateController is null".toString());
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    }

    public l1a.a U2() {
        return new a(this);
    }

    public BaseSlotWidget() {
    }
}
