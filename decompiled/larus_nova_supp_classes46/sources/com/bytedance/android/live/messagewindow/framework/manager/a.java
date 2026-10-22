package com.bytedance.android.live.messagewindow.framework.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements IFloatingBannerManager {
    public static final /* synthetic */ int d = 0;
    public final HashMap<View, d> a;
    public final FrameLayout b;
    public final DataCenter c;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.manager.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0128a {
        public AbstractC0128a() {
        }

        public abstract void a();
    }

    public static final class b {
    }

    public final class c extends e {
        public c(a r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            super(r2, r3);
        }

        @Override // com.bytedance.android.live.messagewindow.framework.manager.a.e
        public final boolean b(ConstraintLayout.LayoutParams r2, ViewGroup r3, ViewGroup r4, Rect r5) {
            Intrinsics.checkNotNullParameter(r2, "lp");
            Intrinsics.checkNotNullParameter(r3, "fullscreen");
            Intrinsics.checkNotNullParameter(r4, "layerLayout");
            Intrinsics.checkNotNullParameter(r5, "publicScreenRectInLayer");
            int r6 = r4.getHeight() - r5.top;
            int r7 = (int) fm3.e.a(this.b.getContext(), 22.0f);
            if (((ViewGroup.MarginLayoutParams) r2).bottomMargin == r6) goto L5;
        L8:
            boolean r8 = true;
        L9:
            if (r8 == false) goto L11;
            ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r6;
            ((ViewGroup.MarginLayoutParams) r2).height = r7;
        L11:
            return r8;
        L5:
            if (((ViewGroup.MarginLayoutParams) r2).height != r7) goto L8;
            r8 = false;
            goto L9
        }
    }

    public final class d {
        public final List<AbstractC0128a> a;
        public final View b;

        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "layerView");
            this.b = r2;
            this.a = new ArrayList();
        }
    }

    public class e extends AbstractC0128a {
        public final Disposable a;
        public final View b;
        public final /* synthetic */ a c;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.manager.a$e$a, reason: collision with other inner class name */
        public static final class C0129a<T1, T2, R> implements BiFunction {
            public static final C0129a a = null;

            static {
                a = new C0129a();
            }

            public C0129a() {
            }

            public final Object apply(Object r2, Object r3) {
                i32.a r4 = (i32.a) r3;
                Intrinsics.checkNotNullParameter((Unit) r2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(r4, "data");
                return r4;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ e a;

            public b(e r1) {
                this.a = r1;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final void accept(Object r9) {
                i32.a r10 = (i32.a) r9;
                e r0 = this.a;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r10, "data");
                ViewParent r1 = r0.c.b.getParent();
                ViewParent r2 = null;
                if (r1 == null) goto L5;
                ViewParent r3 = r1.getParent();
            L7:
                if ((r3 instanceof ViewGroup) == false) goto L10;
                r2 = r3;
            L10:
                ViewGroup r4 = (ViewGroup) r2;
                if (r4 != null) goto L13;
                r0.c.getClass();
                a.a("fullscreenParent is null");
                return;
            L13:
                ViewParent r5 = r0.b.getParent();
                if (r5 == null) goto L25;
                ViewGroup r6 = (ViewGroup) r5;
                ConstraintLayout.LayoutParams r7 = r0.b.getLayoutParams();
                if (r7 == null) goto L23;
                ConstraintLayout.LayoutParams r8 = r7;
                int r11 = r4.getHeight() - r10.b;
                Rect r12 = new Rect(0, r11 - r10.a, r4.getRight(), r11);
                String r13 = r12.toString();
                r4.offsetRectIntoDescendantCoords(r6, r12);
                boolean r14 = r0.b(r8, r4, r6, r12);
                if (r14 == false) goto L20;
                r0.b.setLayoutParams(r8);
            L20:
                a r15 = r0.c;
                String r16 = "onPublicScreenSpecUpdated fullScreenSize=(" + r4.getWidth() + ", " + r4.getHeight() + ") pubRectInFullscreen=" + r13 + " pubRectInLayer=" + r12 + " layoutChanged=" + r14;
                r15.getClass();
                a.a(r16);
                return;
            L23:
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            L25:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            L5:
                r3 = null;
                goto L7
            }
        }

        @Override // com.bytedance.android.live.messagewindow.framework.manager.a.AbstractC0128a
        public final void a() {
            this.a.dispose();
        }

        public e(a r6, View r7) {
            Intrinsics.checkNotNullParameter(r7, "target");
            this.c = r6;
            this.b = r7;
            ConstraintSet r0 = new ConstraintSet();
            r0.connect(r7.getId(), 1, 0, 1);
            r0.connect(r7.getId(), 2, 0, 2);
            r0.connect(r7.getId(), 4, 0, 4);
            ConstraintLayout r1 = r7.getParent();
            if (r1 == null) goto L11;
            r0.applyTo(r1);
            Observable r2 = RxUtilKt.g(r7, false);
            if (ViewCompat.isLaidOut(r7) == false) goto L7;
            r2 = r2.startWith(Unit.INSTANCE);
        L8:
            this.a = Observable.combineLatest(r2.doOnNext(new com.bytedance.android.live.messagewindow.framework.manager.d(this)), RxUtilKt.b(r6.c, "cmd_data_interact_public_screen_height_change", true).distinctUntilChanged(com.bytedance.android.live.messagewindow.framework.manager.b.a).doOnNext(new com.bytedance.android.live.messagewindow.framework.manager.c(this)), C0129a.a).subscribe(new b(this));
            return;
        L7:
            r7.getLeft();
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }

        public boolean b(ConstraintLayout.LayoutParams r2, ViewGroup r3, ViewGroup r4, Rect r5) {
            Intrinsics.checkNotNullParameter(r2, "lp");
            Intrinsics.checkNotNullParameter(r3, "fullscreen");
            Intrinsics.checkNotNullParameter(r4, "layerLayout");
            Intrinsics.checkNotNullParameter(r5, "publicScreenRectInLayer");
            int r6 = r4.getHeight() - r5.bottom;
            int r7 = r5.height();
            if (((ViewGroup.MarginLayoutParams) r2).bottomMargin == r6) goto L5;
        L8:
            boolean r8 = true;
        L9:
            if (r8 == false) goto L11;
            ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r6;
            ((ViewGroup.MarginLayoutParams) r2).height = r7;
        L11:
            return r8;
        L5:
            if (((ViewGroup.MarginLayoutParams) r2).height != r7) goto L8;
            r8 = false;
            goto L9
        }
    }

    static {
    }

    public final ViewGroup getRootContainer() {
        return this.b;
    }

    public static void a(String r1) {
        ALogger.i("FloatingBannerManager", r1);
    }

    public final void H1(View r4) {
        Intrinsics.checkNotNullParameter(r4, "layerView");
        d r0 = this.a.get(r4);
        if (r0 == null) goto L11;
        a("unloadLayer " + r4);
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((AbstractC0128a) r1.next()).a();
        goto L6
    L8:
        ((ArrayList) r0.a).clear();
        this.b.removeView(r4);
        return;
    }

    public final void n0(View r3) {
        Intrinsics.checkNotNullParameter(r3, "layerView");
        if (this.a.containsKey(r3) == true) goto L6;
        a("loadLayer " + r3);
        this.b.addView(r3, -1, -1);
        this.a.put(r3, new d(r3));
        return;
    }

    public a(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r3;
        this.a = new HashMap();
        this.b = new FrameLayout(r2);
    }

    public final void I1(View r3, View r4, IFloatingBannerManager.Element r5) {
        Intrinsics.checkNotNullParameter(r3, "layerView");
        Intrinsics.checkNotNullParameter(r4, "placeholderView");
        Intrinsics.checkNotNullParameter(r5, "reference");
        d r0 = this.a.get(r3);
        if (r0 == null) goto L15;
        int r6 = com.bytedance.android.live.messagewindow.framework.manager.e.a[r5.ordinal()];
        if (r6 != 1) goto L7;
        Object r7 = new e(this, r4);
    L12:
        a("setPlaceholder " + r3 + ' ' + r7);
        Intrinsics.checkNotNullParameter(r7, "placeholder");
        ((ArrayList) r0.a).add(r7);
        return;
    L7:
        if (r6 != 2) goto L10;
        r7 = new c(this, r4);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("layer is not loaded");
    }
}
