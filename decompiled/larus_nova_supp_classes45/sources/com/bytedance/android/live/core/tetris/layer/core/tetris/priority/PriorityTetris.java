package com.bytedance.android.live.core.tetris.layer.core.tetris.priority;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.bytedance.android.live.core.setting.d2;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import j70.f;
import j70.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k70.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import t70.k;
import u70.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityTetris;", "Lh70/b;", "T", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "<init>", "()V", "a", "OrientationMode", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PriorityTetris<T extends h70.b> extends Tetris<T> {
    public PriorityLinearLayout o;
    public HorizontalScrollView p;
    public JatoOptFrameLayout q;
    public final b r;
    public final Map<View, u70.b> s;
    public final Map<View, String> t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityTetris$OrientationMode;", "", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OrientationMode {
    }

    public static final class a {
    }

    public static final class b implements PriorityLinearLayout.b {
        public final /* synthetic */ PriorityTetris a;

        public b(PriorityTetris r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.priority.PriorityLinearLayout.b
        public final void a(List<? extends View> r4, List<? extends View> r5, List<? extends View> r6) {
            Intrinsics.checkNotNullParameter(r4, "allVisibleChildren");
            Intrinsics.checkNotNullParameter(r5, "canToCannotList");
            Intrinsics.checkNotNullParameter(r6, "cannotToCanList");
            Iterator<T> r7 = r4.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            View r0 = (View) r7.next();
            LocalTestManager.a(new Class[]{wy.a.class});
            goto L4
        L6:
            Iterator<T> r8 = r5.iterator();
        L8:
            if (r8.hasNext() == false) goto L12;
            u70.b r9 = (u70.b) ((LinkedHashMap) this.a.s).get((View) r8.next());
            if (r9 == null) goto L8;
            r9.J6(false);
            goto L8
        L12:
            Iterator<T> r11 = r6.iterator();
        L14:
            if (r11.hasNext() == false) goto L18;
            u70.b r12 = (u70.b) ((LinkedHashMap) this.a.s).get((View) r11.next());
            if (r12 == null) goto L14;
            r12.J6(true);
            goto L14
        }
    }

    static {
    }

    public abstract boolean Q();

    public abstract boolean R();

    public abstract boolean S();

    public abstract boolean T();

    public abstract int V();

    public abstract void W();

    public abstract int Z();

    public PriorityTetris() {
        this.r = new b(this);
        this.s = new LinkedHashMap();
        this.t = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r9) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        PriorityLinearLayout r0 = new PriorityLinearLayout(r9.getContext(), null, 6, 0);
        this.o = r0;
        r0.setChangeListener(this.r);
        PriorityLinearLayout r1 = this.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L5:
        W();
        r1.setOrientation(0);
        PriorityLinearLayout r2 = this.o;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L8:
        r2.setSpaceMargin(V());
        PriorityLinearLayout r3 = this.o;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L11:
        r3.setMaxVisibleCount(Z());
        PriorityLinearLayout r4 = this.o;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L14:
        r4.setAutoDismissChildViewWhenWidthLimit(S());
        JatoOptFrameLayout r5 = this.o;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L18:
        if (Q() == false) goto L37;
        PriorityLinearLayout r6 = this.o;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L22:
        r6.setAutoDismissChildViewWhenWidthLimit(false);
        if (R() == false) goto L28;
        HorizontalScrollView r7 = new HorizontalScrollView(r9.getContext(), null, 0);
        r7.setClipChildren(true);
        r7.setHorizontalFadingEdgeEnabled(true);
        r7.setHorizontalScrollBarEnabled(false);
        r7.setPadding(0, 0, 1, 0);
        PriorityLinearLayout r8 = this.o;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L27:
        r7.addView(r8, new ViewGroup.LayoutParams(-2, -2));
        Unit r11 = Unit.INSTANCE;
        this.p = r7;
    L33:
        if (((Boolean) d2.a.getValue()).booleanValue() == false) goto L35;
        r5 = new JatoOptFrameLayoutVisibilityProxy(r9.getContext(), null, 6, 0);
        r5.setClipChildren(true);
        r5.addView(this.p, new ViewGroup.LayoutParams(-1, -1));
    L36:
        this.q = r5;
        goto L37
    L35:
        r5 = new JatoOptFrameLayout(r9.getContext());
        r5.setClipChildren(true);
        r5.addView(this.p, new ViewGroup.LayoutParams(-1, -1));
        goto L36
    L28:
        HorizontalScrollView r12 = new HorizontalScrollView(r9.getContext());
        r12.setClipChildren(true);
        r12.setHorizontalFadingEdgeEnabled(true);
        r12.setHorizontalScrollBarEnabled(false);
        r12.setPadding(0, 0, 1, 0);
        PriorityLinearLayout r13 = this.o;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L31:
        r12.addView(r13, new ViewGroup.LayoutParams(-2, -2));
        Unit r14 = Unit.INSTANCE;
        this.p = r12;
    L37:
        return r5;
    }

    public final Element P(o r5, c r6) {
        Intrinsics.checkNotNullParameter(r5, "elementAttribute");
        Intrinsics.checkNotNullParameter(r6, "priorityItemInfo");
        k70.c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r7 = r0.a(f.c, r5);
        ((ArrayList) this.a).add(r7);
        View r1 = r7.c(K().getContext(), null);
        if (r1 == null) goto L32;
        r7.b = r1;
        getLifecycle().addObserver(r7);
        d r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L10:
        r2.b(r7);
        PriorityLinearLayout r3 = this.o;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L13:
        r3.getPriorityMap().put(r1, Integer.valueOf(r6.a));
        PriorityLinearLayout r4 = this.o;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L16:
        r4.getViewToIdentifyMap().put(r1, r6.b);
        PriorityLinearLayout r8 = this.o;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L19:
        r8.getIdentifyToViewMap().put(r6.b, r1);
        PriorityLinearLayout r9 = this.o;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L22:
        r9.addView(r1);
        u70.b r11 = (u70.b) r7.f(u70.b.class);
        if (r11 == null) goto L25;
        this.s.put(r1, r11);
    L25:
        this.t.put(r1, r6.b);
        if (T() == false) goto L30;
        JatoOptFrameLayout r12 = this.q;
        if (r12 == null) goto L30;
        r12.setHasFixSize(true);
    L30:
        return r7;
    L32:
        throw new IllegalStateException("buildView 不能为空");
    }
}
