package rjb;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ViewUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends c {
    public FrameLayout j;
    public WeakReference<FrameLayout> k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a.isShowing() == false) goto L6;
            this.a.close();
            return;
        }
    }

    static {
    }

    @Override // rjb.c, rjb.g
    public final void close() {
        WeakReference<FrameLayout> r0 = this.k;
        if (r0 == null) goto L8;
        FrameLayout r1 = r0.get();
        if (r1 == null) goto L9;
        r1.removeView(this.j);
        return;
    L9:
        return;
    }

    @Override // rjb.c, rjb.g
    public final boolean isShowing() {
        FrameLayout r0 = this.j;
        if (r0 == null) goto L14;
        WeakReference<FrameLayout> r2 = this.k;
        if (r2 == null) goto L17;
        FrameLayout r3 = r2.get();
        if (r3 == null) goto L18;
        int r4 = r3.getChildCount();
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L20;
        if (Intrinsics.areEqual(r3.getChildAt(r5), r0) == true) goto L19;
        r5 = r5 + 1;
        goto L9
    L19:
        return true;
    L20:
        return false;
    L18:
        return false;
    L17:
        return false;
    L14:
        return false;
    }

    @Override // rjb.c, rjb.g
    public final boolean show() {
        View r1 = this.a.b;
        if (r1 != null) goto L7;
        Log.i("ViewGuidePopup", "params.anchorView is null");
        return false;
    L7:
        if (r1.getWindowToken() != null) goto L10;
        Log.i("ViewGuidePopup", "anchorView.windowToken is null, anchorView.isAttachedToWindow=" + r1.isAttachedToWindow());
        return false;
    L10:
        rjb.b r4 = this.a.a;
        if (r4 != null) goto L14;
        Log.i("ViewGuidePopup", "params.component is null");
        return false;
    L14:
        int r5 = h.b;
        Intrinsics.checkNotNullParameter(r4, "component");
        h r6 = new h(r4);
        Context r7 = r1.getContext();
        if ((r7 instanceof Activity) == false) goto L18;
        Activity r8 = (Activity) r7;
    L24:
        Intrinsics.checkNotNull(r7);
        e(r7);
        this.g = d(r7, r6);
        Rect r2 = c.b(r1);
        LinearLayout r9 = this.g;
        Intrinsics.checkNotNull(r9);
        Point r3 = c(r6.a(r9, this.h, r2), r6);
        int r10 = this.h.getWidth();     // Catch: Exception -> L38
        int r11 = this.h.getHeight();     // Catch: Exception -> L38
        if (r10 <= 0) goto L36;
        if (r11 <= 0) goto L36;
        FrameLayout r0 = (FrameLayout) r8.findViewById(R.id.content);     // Catch: Exception -> L38
        this.k = new WeakReference(r0);     // Catch: Exception -> L38
        FrameLayout r12 = new FrameLayout(r7);     // Catch: Exception -> L38
        LinearLayout r13 = this.g;     // Catch: Exception -> L38
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);     // Catch: Exception -> L38
        r14.topMargin = r3.y;     // Catch: Exception -> L38
        r14.leftMargin = r3.x;     // Catch: Exception -> L38
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L38
        r12.addView(r13, r14);     // Catch: Exception -> L38
        Boolean r16 = this.a.c;     // Catch: Exception -> L38
        if (r16 == null) goto L32;
        boolean r17 = r16.booleanValue();     // Catch: Exception -> L38
    L33:
        if (r17 == false) goto L35;
        r12.setOnClickListener(new b(this));     // Catch: Exception -> L38
    L35:
        this.j = r12;     // Catch: Exception -> L38
        r0.addView(r12, new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L38
    L40:
        return false;
    L32:
        r17 = false;
    L36:
        Log.w("ViewGuidePopup", "show error, width=" + r10 + ", height=" + r11);     // Catch: Exception -> L38
        return false;
    L38:
        e = move-exception;
        Log.e("ViewGuidePopup", "show error", e);
        goto L40
    L18:
        if (this.a.getActivity() == null) goto L20;
        r8 = this.a.getActivity();
        goto L24
    L20:
        r8 = ViewUtils.getActivityByContext(r7);
        if (r8 != null) goto L24;
        Log.i("ViewGuidePopup", "not found activity");
        return false;
    }

    public i(rjb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(r2);
    }
}
