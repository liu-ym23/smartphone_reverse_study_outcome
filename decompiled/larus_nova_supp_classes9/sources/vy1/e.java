package vy1;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Unit r6 = (Unit) r5;
        DraggableContainerView.b r7 = this.a.j.getDragCallback();
        ViewGroup.LayoutParams r1 = null;
        if ((r7 instanceof ry1.a) == true) goto L5;
        r7 = null;
    L5:
        ry1.a r8 = (ry1.a) r7;
        if (r8 == null) goto L12;
        PropertyOwner r9 = r8.e;
        if (r9 == null) goto L12;
        if (((Boolean) r9.a).booleanValue() != true) goto L12;
        return;
    L12:
        a r10 = this.a;
        if (r10.r == r10.h.getHeight()) goto L28;
        FrameLayout r0 = r10.k;
        if (r0 == null) goto L29;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        r1 = r2;
    L20:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        if (r3 != null) goto L24;
        return;
    L24:
        if ((r0.getHeight() + ((ViewGroup.MarginLayoutParams) r3).topMargin) <= r10.h.getHeight()) goto L26;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r10.h.getHeight() - r0.getHeight();
        r0.setLayoutParams(r3);
    L26:
        r10.r = r10.h.getHeight();
        return;
    L29:
        return;
    }
}
