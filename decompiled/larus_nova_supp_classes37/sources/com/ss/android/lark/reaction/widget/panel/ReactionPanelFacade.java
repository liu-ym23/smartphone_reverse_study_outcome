package com.ss.android.lark.reaction.widget.panel;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.layout.WindowMetricsCalculator;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s2c.f;
import s2c.h;
import z5c.o;
import z5c.z0;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionPanelFacade {
    public final Context a;
    public final b b;
    public final List<e> c;
    public final View d;
    public final boolean e;
    public final boolean f;
    public int g;
    public boolean h;
    public final List<String> i;
    public BasePopupWindow j;
    public View k;
    public RecyclerView l;
    public EmojiListView m;
    public View n;
    public RecentUsedEmojiView o;
    public ImageView p;
    public final boolean q;
    public PopupWindow.OnDismissListener r;
    public boolean s;
    public final int t;
    public final int u;
    public final int v;
    public final boolean w;
    public final ReactionScene x;
    public final String y;
    public final DefaultEmojiPanelData z;

    public static final enum ReactionScene extends Enum<ReactionScene> {
        public static final ReactionScene CCM = null;
        public static final ReactionScene IM = null;
        public static final ReactionScene MOMENTS = null;
        public static final ReactionScene TODO = null;
        public static final /* synthetic */ ReactionScene[] a = null;
        public s5c.d value;

        static {
            ReactionScene r0 = new ReactionScene("IM", 0, z2.c);
            IM = r0;
            ReactionScene r1 = new ReactionScene("CCM", 1, z2.d);
            CCM = r1;
            ReactionScene r2 = new ReactionScene("MOMENTS", 2, z2.e);
            MOMENTS = r2;
            ReactionScene r4 = new ReactionScene("TODO", 3, z2.f);
            TODO = r4;
            a = new ReactionScene[]{r0, r1, r2, r4};
        }

        public static ReactionScene[] values() {
            return (ReactionScene[]) a.clone();
        }

        public static ReactionScene valueOf(String r1) {
            return (ReactionScene) r27.a.a(ReactionScene.class, r1);
        }

        public ReactionScene(String r1, int r2, s5c.a r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReactionSource {
        public static final int REACTION_DETAIL = 2;
        public static final int REACTION_LKP_HOVER = 3;
        public static final int REACTION_QUICK_APPEND = 5;
        public static final int REACTION_RECENT_USED = 0;
        public static final int REACTION_THREAD_LIKE = 4;
        public static final int REACTION_UNKNOWN = -1;
        public static final int REACTION_WHOLE = 1;
    }

    public static class a {
        public final Context a;
        public final View b;
        public boolean c;
        public final List<e> d;
        public b e;
        public boolean f;
        public boolean g;
        public int h;
        public final int i;
        public int j;
        public boolean k;
        public ReactionScene l;
        public final String m;

        public final ReactionPanelFacade a() {
            return new ReactionPanelFacade(this.a, this.b, this.d, this.c, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }

        public a(View r3) {
            this.c = true;
            this.d = new ArrayList();
            this.g = true;
            this.h = 2131953375;
            this.i = -1;
            this.j = -1;
            this.k = false;
            this.l = ReactionScene.IM;
            this.m = "";
            this.a = r3.getContext();
            this.b = r3;
        }
    }

    public interface b {
        void a(String r1, int r2);

        void b();
    }

    public final void c() {
        BasePopupWindow r0 = this.j;
        if (r0 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
        return;
    }

    public final int d() {
        Activity r0 = UIUtils.getActivityFromContext(this.d.getContext());
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r0 == null) goto L8;
        int r1 = WindowMetricsCalculator.-CC.getOrCreate().computeCurrentWindowMetrics(r0).getBounds().height();
        if (r1 <= 0) goto L8;
    L9:
        if (r1 <= 0) goto L12;
        return r1;
    L12:
        return v2c.a.d(this.a);
    L8:
        r1 = -1;
        goto L9
    }

    public final void e() {
        if (this.h == false) goto L5;
        this.k = LayoutInflater.from(this.a).inflate(2131563394, null);
    L6:
        this.k.setOnHoverListener(new s2c.b(this));
        this.n = this.k.findViewById(2131372601);
        this.o = this.k.findViewById(2131383862);
        this.p = (ImageView) this.k.findViewById(2131380305);
        this.m = this.k.findViewById(2131371538);
        this.l = this.k.findViewById(2131381562);
        this.k.setOnClickListener(new s2c.c(this));
        View r0 = this.k.findViewById(2131372074);
        if (r0 == null) goto L9;
        float r1 = v2c.a.getResources(this.a).getDimensionPixelSize(2131168103);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = (int) r1;
        r0.setLayoutParams(r2);
    L9:
        ViewGroup.LayoutParams r3 = this.m.getLayoutParams();
        r3.height = v2c.a.getResources(this.a).getDimensionPixelSize(2131168102);
        this.m.setLayoutParams(r3);
        int r4 = 6;
        if (this.s == true) goto L12;
        Log.i("ReactionPanelFacade", "Not init PopupWindow");
    L19:
        if (this.v == (-1)) goto L22;
        this.k.findViewById(2131384813).setBackgroundResource(this.v);
    L22:
        if (this.e == true) goto L24;
        this.n.setVisibility(8);
    L32:
        boolean r5 = this.f;
        if (r5 == false) goto L41;
        if (r5 == true) goto L36;
        this.l.setVisibility(8);
        goto L41
    L36:
        this.l.setVisibility(0);
        ReactionOperationMenuAdapter r6 = new ReactionOperationMenuAdapter(this.a, this.c);
        r6.a = new s2c.d(this);
        r6.b = new s2c.e(this);
        this.l.setAdapter(r6);
        Context r7 = this.a;
        if (this.e == true) goto L40;
        r4 = Math.min(6, this.c.size());
    L40:
        this.l.setLayoutManager(new GridLayoutManager(r7, r4));
        this.l.setOverScrollMode(2);
        this.l.setHasFixedSize(true);
    L41:
        int r8 = com.ss.android.lark.reaction.widget.panel.a.a;
        ReactionScene r9 = this.x;
        Intrinsics.checkNotNullParameter(r9, "scene");
        Statistics.sendEvent("public_reaction_panel_popup_view", r9.value.toJson());
        return;
    L24:
        this.n.setVisibility(0);
        ImageView r10 = this.p;
        if (this.f == false) goto L27;
        int r11 = 0;
    L28:
        r10.setVisibility(r11);
        Context r12 = this.a;
        int r13 = this.u;
        if (r13 != (-1)) goto L31;
        r13 = 2131102418;
    L31:
        this.p.setImageDrawable(UDIconUtils.getIconDrawable(this.a, 2131255142, v2c.a.b(r12, r13), new UDDimension.Dp(22)));
        this.p.setOnClickListener(new c(this));
        this.n.getViewTreeObserver().addOnGlobalLayoutListener(new h(this, new d(this)));
        goto L32
    L27:
        r11 = 8;
        goto L28
    L12:
        this.g = Math.min((int) (((double) d()) * 0.92d), v2c.a.a(this.a, 338.0f));
        if (this.c.size() < 6) goto L15;
    L17:
        BasePopupWindow r14 = new BasePopupWindow(this.k, this.g, -2, true);
        this.j = r14;
        r14.setBackgroundDrawable(new ColorDrawable(0));
        this.j.setOutsideTouchable(true);
        this.j.setTouchable(true);
        this.j.setFocusable(this.q);
        this.j.setAnimationStyle(this.t);
        this.j.setOnDismissListener(new f(this));
        goto L19
    L15:
        if (this.e == true) goto L17;
        this.g = (((this.g - v2c.a.a(this.a, 20.0f)) / 6) * this.c.size()) + v2c.a.a(this.a, 20.0f);
        goto L17
    L5:
        this.k = LayoutInflater.from(this.a).inflate(2131563395, null);
        goto L6
    }

    public final void f(View r7) {
        int[] r0 = new int[2];
        r7.getLocationOnScreen(r0);
        int r1 = d();
        if (r0[1] <= (r1 >> 1)) goto L5;
        boolean r3 = true;
    L6:
        this.h = r3;
        e();
        if (this.h == false) goto L9;
        int r2 = r1 - r0[1];
        a(this.j, r7, 81, 0, r2);
        return;
    L9:
        a(this.j, r7, 49, 0, r0[1]);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static void b(ReactionPanelFacade r2, s5c.d r3) {
        if (TextUtils.isEmpty(r2.y) == true) goto L5;
        r3 = r3.plus(o.c.a(r2.y));
    L5:
        s5c.d r4 = r3.plus(r2.x.value);
        int r0 = com.ss.android.lark.reaction.widget.panel.a.a;
        DefaultEmojiPanelData r5 = r2.z;
        if (r5 != null) goto L8;
    L10:
        s5c.a r6 = z0.d;
    L11:
        s5c.d r7 = r4.plus(r6);
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        Statistics.sendEvent("public_reaction_panel_select_click", r7.toJson());
        return;
    L8:
        if (r5.c() == false) goto L10;
        r6 = z0.c;
        goto L11
    }

    public final BasePopupWindow g(boolean r2, int r3, int r4, int r5) {
        this.h = r2;
        e();
        a(this.j, this.d, r3, r4, r5);
        return this.j;
    }

    public static void a(BasePopupWindow r7, View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r8, r0, r9, r10, r11) == false) goto L14;
        return;
    L14:
        r7.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(r7, r0, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r8, r9, r10, r11);
    }

    public ReactionPanelFacade(Context r3, View r4, List r5, boolean r6, b r7, boolean r8, boolean r9, int r10, int r11, int r12, boolean r13, ReactionScene r14, String r15) {
        boolean r0 = false;
        this.h = false;
        this.s = true;
        this.a = r3;
        this.d = r4;
        this.c = r5;
        if (r5 != null) goto L5;
    L8:
        this.f = r0;
        this.e = r6;
        this.i = new ArrayList(k2c.a.a().h());
        this.z = k2c.a.a().a();
        this.b = r7;
        this.q = r8;
        this.t = r10;
        this.u = r11;
        this.v = r12;
        this.w = r13;
        this.x = r14;
        this.y = r15;
        return;
    L5:
        if (((ArrayList) r5).size() == 0) goto L8;
        if (r9 == false) goto L8;
        r0 = true;
        goto L8
    }
}
