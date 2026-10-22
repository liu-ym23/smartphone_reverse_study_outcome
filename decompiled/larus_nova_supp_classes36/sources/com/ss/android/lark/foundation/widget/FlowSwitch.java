package com.ss.android.lark.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchStyle;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0013J\u001c\u0010\u001e\u001a\u00020\u00172\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/foundation/widget/FlowSwitch;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "style", "Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;)V", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "state", "Landroidx/compose/runtime/MutableState;", "Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchState;", "enabledState", "", "styleState", "listener", "Lkotlin/Function1;", "", "isChecked", "toggle", "setChecked", "checked", "setLoading", "loading", "setOnCheckedChangeListener", "l", "setStyle", "setEnabled", "enabled", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowSwitch extends FrameLayout implements Checkable {
    public final MutableState<a> a;
    public final MutableState<Boolean> b;
    public final MutableState<FlowSwitchStyle> c;
    public Function1<? super Boolean, Unit> d;

    public FlowSwitch(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public FlowSwitch(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public FlowSwitch(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return ((a) this.a.getValue()).a;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!((a) this.a.getValue()).a);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (((a) this.a.getValue()).a == r5) goto L6;
        MutableState<a> r0 = this.a;
        r0.setValue(a.a((a) r0.getValue(), r5, false, 2));
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (((Boolean) this.b.getValue()).booleanValue() == r2) goto L6;
        this.b.setValue(Boolean.valueOf(r2));
        return;
    }

    public final void setLoading(boolean r5) {
        if (((a) this.a.getValue()).b == r5) goto L6;
        MutableState<a> r0 = this.a;
        r0.setValue(a.a((a) r0.getValue(), false, r5, 1));
        return;
    }

    public final void setOnCheckedChangeListener(Function1<? super Boolean, Unit> r1) {
        this.d = r1;
    }

    public final void setStyle(FlowSwitchStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.c.getValue() == r2) goto L6;
        this.c.setValue(r2);
        return;
    }

    public FlowSwitch(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r13 & 8) == 0) goto L11;
        FlowSwitchStyle r14 = FlowSwitchStyle.NORMAL;
    L12:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "style");
        super(r10, r11, r12);
        ComposeView r15 = new ComposeView(r10, null, 0, 6, null);
        this.a = SnapshotStateKt.mutableStateOf$default(new a(false, false), null, 2, null);
        this.b = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isEnabled()), null, 2, null);
        this.c = SnapshotStateKt.mutableStateOf$default(r14, null, 2, null);
        r15.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
        r15.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r15.setContent(ComposableLambdaKt.composableLambdaInstance(-279263023, true, new AnonymousClass1(this)));
        addView(r15);
        return;
    L11:
        r14 = null;
        goto L12
    }
}
