package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/HideKeyboardLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scrollThreshold", "", "startClickTime", "", "startX", "startY", "hasHiddenInThisTouch", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "hideKeyboard", "", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class HideKeyboardLinearLayout extends LinearLayout {
    public final float a;
    public long b;
    public float c;
    public float d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public HideKeyboardLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HideKeyboardLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        int r3 = bwb.b.a;     // Catch: Exception -> L16
        MmUiLogScene r4 = MmUiLogScene.FOUNDATION;     // Catch: Exception -> L16
        bwb.b.b(r4, "hideKeyboard", "hide keyboard", null, 8);     // Catch: Exception -> L16
        View r5 = getRootView().findFocus();     // Catch: Exception -> L16
        if (r5 == null) goto L9;
        bwb.b.b(r4, "hideKeyboard", "clear focus, view=".concat(r5.getClass().getSimpleName()), null, 8);     // Catch: Exception -> L16
        r5.clearFocus();     // Catch: Exception -> L16
    L9:
        Object r1 = getContext().getSystemService("input_method");     // Catch: Exception -> L16
        if ((r1 instanceof InputMethodManager) == false) goto L12;
        InputMethodManager r2 = (InputMethodManager) r1;     // Catch: Exception -> L16
    L13:
        if (r2 == null) goto L21;
        r2.hideSoftInputFromWindow(getWindowToken(), 0);     // Catch: Exception -> L16
        return;
    L21:
        return;
    L12:
        r2 = null;
    L16:
        e = move-exception;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "hideKeyboard", "error=" + e.getMessage(), null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        int r0 = r7.getAction();
        if (r0 != 0) goto L5;
        this.b = System.currentTimeMillis();
        this.c = r7.getX();
        this.d = r7.getY();
        this.e = false;
    L30:
        return super.dispatchTouchEvent(r7);
    L27:
        e = move-exception;
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "dispatchTouchEvent", String.valueOf(e), null);
        return false;
    L5:
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L30;
        this.e = false;
        goto L30
    L13:
        if (this.e == true) goto L30;
        float r2 = Math.abs(r7.getX() - this.c);
        float r3 = Math.abs(r7.getY() - this.d);
        float r4 = this.a;
        if (r2 <= r4) goto L17;
    L18:
        a();
        goto L30
    L17:
        if (r3 <= r4) goto L30;
    L20:
        if (this.e == true) goto L30;
        if ((System.currentTimeMillis() - this.b) >= 200) goto L30;
        a();
        goto L30
    }

    public HideKeyboardLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = UIUtils.dp2px(r2, 5.0f);
    }

    public /* synthetic */ HideKeyboardLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
