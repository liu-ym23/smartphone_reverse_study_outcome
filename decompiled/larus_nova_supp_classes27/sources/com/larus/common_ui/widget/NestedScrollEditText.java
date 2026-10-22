package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/common_ui/widget/NestedScrollEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "canVerticalScroll", "editText", "Landroid/widget/EditText;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedScrollEditText extends AppCompatEditText {
    public NestedScrollEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NestedScrollEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static boolean c(EditText r4) {
        int r0 = r4.getScrollY();
        int r1 = r4.getLayout().getHeight() - ((r4.getHeight() - r4.getCompoundPaddingTop()) - r4.getCompoundPaddingBottom());
        if (r1 != 0) goto L6;
    L10:
        return false;
    L6:
        if (r0 <= 0) goto L8;
        return true;
    L8:
        if (r0 >= (r1 - 1)) goto L10;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
    L16:
        getParent().requestDisallowInterceptTouchEvent(false);
    L22:
        return super/*android.widget.EditText*/.onTouchEvent(r5);
    L6:
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L16;
        if (r0 != 8) goto L22;
    L13:
        if (c(this) == false) goto L15;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L22
    L15:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L22
    L18:
        if (c(this) == false) goto L20;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L22
    L20:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L22
    }

    public NestedScrollEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ NestedScrollEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = 2130969939;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }
}
