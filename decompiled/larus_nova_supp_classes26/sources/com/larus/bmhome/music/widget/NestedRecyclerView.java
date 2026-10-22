package com.larus.bmhome.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/music/widget/NestedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeModel", "Lcom/larus/bmhome/view/utils/SwipingControlVm;", "getSwipeModel", "()Lcom/larus/bmhome/view/utils/SwipingControlVm;", "setSwipeModel", "(Lcom/larus/bmhome/view/utils/SwipingControlVm;)V", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedRecyclerView extends RecyclerView {
    public SwipingControlVm a;

    public static final class a {
    }

    static {
    }

    public NestedRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NestedRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final SwipingControlVm getSwipeModel() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("on touch dispatch ");
        if (r5 == null) goto L5;
        Integer r2 = Integer.valueOf(r5.getAction());
    L6:
        r1.append(r2);
        r0.i("NestedRecyclerView", r1.toString());
        boolean r3 = true;
        if (r5 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L19;
        if (r5 != null) goto L15;
    L17:
        r3 = false;
    L18:
        if (r3 == true) goto L19;
    L25:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r5);
    L15:
        if (r5.getAction() != 3) goto L17;
    L19:
        SwipingControlVm r6 = this.a;
        if (r6 == null) goto L25;
        MutableSharedFlow<Boolean> r7 = r6.getSwipingControlFlow();
        if (r7 == null) goto L25;
        r7.tryEmit(Boolean.TRUE);
        goto L25
    L9:
        if (r5.getAction() != 1) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("on touch interception ");
        Integer r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = Integer.valueOf(r5.getAction());
    L6:
        r1.append(r3);
        r0.i("NestedRecyclerView", r1.toString());
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getAction());
    L9:
        if (r2 != null) goto L12;
    L18:
        if (r2 == null) goto L22;
        r2.intValue();
    L22:
        return super.onInterceptTouchEvent(r5);
    L12:
        if (r2.intValue() != 0) goto L18;
        SwipingControlVm r4 = this.a;
        if (r4 == null) goto L22;
        MutableSharedFlow<Boolean> r6 = r4.getSwipingControlFlow();
        if (r6 == null) goto L22;
        r6.tryEmit(Boolean.FALSE);
        goto L22
    L5:
        r3 = null;
        goto L6
    }

    public final void setSwipeModel(SwipingControlVm r1) {
        this.a = r1;
    }

    public NestedRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = CircleProgressBarView.k;
        addItemDecoration(new SpacesItemDecoration((int) CircleProgressBarView.a.a(r2, 5.0f)));
    }

    public /* synthetic */ NestedRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
