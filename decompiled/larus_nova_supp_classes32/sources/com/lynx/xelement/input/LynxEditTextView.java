package com.lynx.xelement.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/lynx/xelement/input/LynxEditTextView;", "Lcom/lynx/xelement/input/LynxEditText;", "Lcom/lynx/xelement/input/LynxEditTextView$a;", "h", "Lcom/lynx/xelement/input/LynxEditTextView$a;", "getOnSelectionChangeListener", "()Lcom/lynx/xelement/input/LynxEditTextView$a;", "setOnSelectionChangeListener", "(Lcom/lynx/xelement/input/LynxEditTextView$a;)V", "onSelectionChangeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", NameKeys.UnloadStrategy_No_Strategy, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "Input_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEditTextView extends LynxEditText {
    public a h;
    public float i;
    public int j;

    public interface a {
        void a(int r1, int r2);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final a getOnSelectionChangeListener() {
        return this.h;
    }

    public LynxEditTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r6) {
        if (isFocusable() == true) goto L5;
        return false;
    L5:
        if (r6 == null) goto L7;
        int r0 = r6.getAction();
        if (r0 != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
        r6.getX();
        this.i = r6.getY();
        this.j = getScrollY();
    L30:
        return super/*android.widget.EditText*/.onTouchEvent(r6);
    L11:
        if (r0 != 1) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.i = 0.0f;
        Math.abs(getScrollY() - this.j);
        goto L30
    L13:
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L30;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.i = 0.0f;
        Math.abs(getScrollY() - this.j);
        goto L30
    L19:
        if (canScrollVertically(1) == true) goto L23;
        if (r6.getY() >= this.i) goto L23;
    L26:
        getParent().requestDisallowInterceptTouchEvent(false);
    L23:
        if (canScrollVertically(-1) == true) goto L30;
        if (r6.getY() <= this.i) goto L30;
    L7:
        return super/*android.widget.EditText*/.onTouchEvent(null);
    }

    public final void setOnSelectionChangeListener(a r1) {
        this.h = r1;
    }

    public LynxEditTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSelectionChanged(int r2, int r3) {
        super/*android.widget.EditText*/.onSelectionChanged(r2, r3);
        a r0 = this.h;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    public LynxEditTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3, r4);
    }
}
