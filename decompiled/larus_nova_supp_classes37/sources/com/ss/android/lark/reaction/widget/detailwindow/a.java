package com.ss.android.lark.reaction.widget.detailwindow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.reaction.widget.detailwindow.scroller.ScrollableLayout;
import java.util.List;
import n2c.m;
import n2c.n;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements n2c.b {
    public static final Double v = null;
    public ScrollableLayout a;
    public View b;
    public ViewGroup c;
    public ViewGroup d;
    public View e;
    public ViewGroup f;
    public MagicIndicator g;
    public ViewPager h;
    public View i;
    public ViewGroup j;
    public View k;
    public final g l;
    public final Context m;
    public final Fragment n;
    public List<o2c.a> o;
    public String p;
    public int q;
    public RecyclerView r;
    public final C0123a s;
    public final b t;
    public final c u;

    /* JADX INFO: renamed from: com.ss.android.lark.reaction.widget.detailwindow.a$a, reason: collision with other inner class name */
    public class C0123a extends xuc.a {
        public final /* synthetic */ a b;

        public final xuc.c b(Context r1) {
            return null;
        }

        public final int a() {
            return this.b.o.size();
        }

        public C0123a(a r1) {
            this.b = r1;
        }

        public final xuc.d c(Context r9, final int r10) {
            avc.b r11 = new avc.b(this.b.m);
            r11.setContentView(2131563390);
            final a r0 = this.b;
            r0.getClass();
            ImageView r1 = (ImageView) r11.findViewById(2131383753);
            TextView r2 = (TextView) r11.findViewById(2131383742);
            ViewGroup r3 = (ViewGroup) r11.findViewById(2131383756);
            ReactionLoaderManager.b.a.c(r1, ((o2c.a) ListProtector.get(r0.o, r10)).b);
            String r4 = ((o2c.a) ListProtector.get(r0.o, r10)).b;
            int r5 = v2c.a.a(r0.m, 20);
            int r6 = k2c.b.b(r4);
            int r7 = k2c.b.a(r4);
            if (r6 <= 44) goto L6;
            if (r7 == 0) goto L6;
            r5 = (r5 * r6) / r7;
        L6:
            r1.getLayoutParams().width = r5;
            r2.setText(String.valueOf(((o2c.a) ListProtector.get(r0.o, r10)).c));
            r11.setOnPagerTitleChangeListener(new e(r0, r3));
            View r8 = r11.getChildAt(0);
            if (r10 != 0) goto L10;
            r8.setPadding(v2c.a.a(r0.m, 16.0f), 0, 0, 0);
        L12:
            r3.setOnClickListener(new n2c.g(r0, r10));
            return r11;
        L10:
            if (r10 != (r0.o.size() - 1)) goto L12;
            r8.setPadding(0, 0, v2c.a.a(r0.m, 4.0f), 0);
            goto L12
        }
    }

    public class b implements ReactionPopupFacade.c {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade.c
        public final void a(String r2) {
            g r0 = this.a.l;
            if (r0 == null) goto L6;
            ((ReactionPopupFacade.a) r0).b(r2);
            return;
        }
    }

    public class c implements ReactionPopupFacade.b {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }
    }

    public interface d {
        void a(int r1);
    }

    public class e implements avc.b.b {
        public final ViewGroup a;
        public final TextView b;
        public final /* synthetic */ a c;

        public final void onEnter() {
        }

        public final void onLeave() {
        }

        public final void b() {
            this.a.setBackgroundResource(2131247436);
            this.b.setTextColor(v2c.a.b(this.c.m, 2131106607));
        }

        public final void a(int r4) {
            this.a.setBackgroundResource(2131247435);
            this.b.setTextColor(v2c.a.b(this.c.m, 2131106521));
            this.c.h.setCurrentItem(r4);
        }

        public e(a r1, ViewGroup r2) {
            this.c = r1;
            this.a = r2;
            this.b = (TextView) r2.findViewById(2131383742);
        }
    }

    public static class f extends com.ss.android.lark.reaction.widget.detailwindow.scroller.e {
        public f() {
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.e, com.ss.android.lark.reaction.widget.detailwindow.scroller.b
        public final int b(int r3, int r4) {
            int r0 = r4 / 4;
            if (r3 <= (r4 - r0)) goto L5;
            return r4;
        L5:
            if (r3 >= r0) goto L9;
            return 0;
        L9:
            return Double.valueOf(((double) r4) * a.v.doubleValue()).intValue();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.e, com.ss.android.lark.reaction.widget.detailwindow.scroller.b
        public final int a(boolean r5, int r6, int r7) {
            int r0 = Double.valueOf(((double) r7) * a.v.doubleValue()).intValue();
            if (r5 == false) goto L7;
            if (r6 >= r0) goto L8;
            return 0;
        L8:
            return r0;
        L7:
            return r7;
        }
    }

    public interface g {
    }

    public final void a() {
        FragmentActivity r0 = this.n.getActivity();
        if (r0 != null) goto L5;
    L13:
        b(this.a.getScrollY(), 0, new m(this));
        return;
    L5:
        if (com.ss.android.lark.base.embedded.b.b(r0) == false) goto L13;
        ((ReactionPopupFacade.a) this.l).a.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    static {
        v = Double.valueOf(0.67d);
    }

    public a(ReactionPopupFacade.a r2, Context r3, Fragment r4) {
        this.s = new C0123a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }

    public static void b(int r2, int r3, final d r4) {
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r2, r3});
        r5.setInterpolator(new DecelerateInterpolator());
        r5.addUpdateListener(new n(r4));
        r5.start();
    }
}
