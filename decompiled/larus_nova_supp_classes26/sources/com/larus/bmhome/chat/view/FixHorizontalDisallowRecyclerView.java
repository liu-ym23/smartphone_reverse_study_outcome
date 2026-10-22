package com.larus.bmhome.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/view/FixHorizontalDisallowRecyclerView;", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startActionDownX", "", "startActionDownY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FixHorizontalDisallowRecyclerView extends HorizontalOverScrollRV {
    public float i;
    public float j;

    public FixHorizontalDisallowRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FixHorizontalDisallowRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L4;
        Integer r0 = Integer.valueOf(r5.getActionMasked());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L20:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r5);
    L14:
        if (r0.intValue() != 2) goto L20;
        if (Math.abs(r5.getX() - this.i) <= Math.abs(r5.getY() - this.j)) goto L18;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L18:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L20
    L9:
        if (r0.intValue() != 0) goto L11;
        this.i = r5.getX();
        this.j = r5.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L4:
        r0 = null;
        goto L6
    }

    public FixHorizontalDisallowRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ FixHorizontalDisallowRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
