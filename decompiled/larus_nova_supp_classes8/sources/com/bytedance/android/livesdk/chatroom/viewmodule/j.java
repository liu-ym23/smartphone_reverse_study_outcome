package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends i<BottomRightBannerWidget> {
    public static boolean q;
    public final ViewGroup m;
    public final HSImageView n;
    public final TextView o;
    public final TransitionDrawable p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r1 = new Pair[2];
            if (this.a.f == false) goto L5;
            String r2 = "open";
        L6:
            r1[0] = TuplesKt.to("click_type", r2);
            r1[1] = TuplesKt.to("user_id", jc1.k.n(IUserService.class).user().n());
            r7.sendLog("live_activity_banner_button_click", MapsKt.mapOf(r1), new Object[]{am2.x.class, Room.class});
            j r8 = this.a;
            if (r8.f == false) goto L9;
            r8.b();
            return;
        L9:
            r8.a();
            return;
        L5:
            r2 = "retract";
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    public final void d(int r3) {
        Drawable r0 = this.n.getBackground();
        if ((r0 instanceof ShapeDrawable) == false) goto L10;
        Drawable r1 = this.n.getBackground();
        if (r1 == null) goto L8;
        ((ShapeDrawable) r1).getPaint().setColor(r3);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
    L10:
        if ((r0 instanceof GradientDrawable) == false) goto L17;
        Drawable r2 = this.n.getBackground();
        if (r2 == null) goto L15;
        ((GradientDrawable) r2).setColor(r3);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L17:
        if ((r0 instanceof ColorDrawable) == false) goto L25;
        Drawable r4 = this.n.getBackground();
        if (r4 == null) goto L22;
        ((ColorDrawable) r4).setColor(r3);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }

    public final void e(BannerInRoomCollection.BannerInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "info");
        Intrinsics.checkNotNullParameter(r6, "info");
        int r0 = r6.height;
        if (r0 <= 0) goto L5;
        int r1 = com.bytedance.android.live.core.utils.s1.f(Math.min(r0, 130));
        View r2 = this.c;
        r2.getLayoutParams().height = r1;
        r2.requestLayout();
    L5:
        com.bytedance.android.livesdk.chatroom.model.m r3 = r6.collapseInfo;
        boolean r4 = false;
        if (r3 != null) goto L8;
    L11:
        com.bytedance.android.livesdk.chatroom.model.m r5 = r6.collapseInfo;
        if (r5 == null) goto L19;
        a5 r7 = r5.title;
        if (r7 == null) goto L19;
        TextView r8 = this.o;
        Spannable r9 = sb2.a.a;
        String r10 = "";
        if (TextUtils.isEmpty("") == false) goto L18;
        r10 = r7.getDefaultPattern();
    L18:
        r8.setText(sb2.a.g(r10, r7, sb2.a.c()).a);
    L19:
        com.bytedance.android.livesdk.chatroom.model.m r11 = r6.collapseInfo;
        if (r11 == null) goto L24;
        py.k r12 = r11.image;
        if (r12 == null) goto L24;
        ImageLoader.bindImage(this.n, r12);
        d(0);
        return;
    L24:
        Integer r13 = null;
        if (r11 == null) goto L27;
        String r14 = r11.backgroundColor;
    L29:
        if (r14 != null) goto L31;
    L32:
        r4 = true;
    L34:
        if ((!r4) == true) goto L45;
        r14 = null;
    L45:
        r13 = Integer.valueOf(Color.parseColor(r14));     // Catch: Throwable -> L39
    L40:
        if (r13 == null) goto L42;
        d(r13.intValue());
    L43:
        Unit r15 = Unit.INSTANCE;
        return;
    L42:
        this.n.setBackgroundResource(2131249832);
        goto L43
    L31:
        if (r14.length() != 0) goto L34;
    L27:
        r14 = null;
        goto L29
    L8:
        if (Boolean.valueOf(r3.enabled).booleanValue() == false) goto L10;
        this.m.setVisibility(0);
        goto L11
    L10:
        this.m.setVisibility(8);
        b();
        goto L11
    }

    public j(ViewGroup r5, i.b r6) {
        Intrinsics.checkNotNullParameter(r5, "parentView");
        Intrinsics.checkNotNullParameter(r6, "stateChangeListener");
        super(r5, r6);
        ViewGroup r7 = (ViewGroup) c().findViewById(2131363964);
        r7.setOnClickListener(new a(this));
        Unit r8 = Unit.INSTANCE;
        this.m = r7;
        this.n = r7.findViewById(2131363806);
        this.o = (TextView) r7.findViewById(2131388772);
        TransitionDrawable r9 = new TransitionDrawable(new Drawable[]{com.bytedance.android.live.core.utils.s1.m(2131250872), com.bytedance.android.live.core.utils.s1.m(2131250873)});
        r9.setCrossFadeEnabled(true);
        ((ImageView) r7.findViewById(2131371895)).setImageDrawable(r9);
        r9.startTransition(0);
        this.p = r9;
    }
}
