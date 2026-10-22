package com.ss.android.lark.flow.feed.component.badge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FeedCardComponent<c, FlowBadgeView> {
    public final Context c;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.badge.a$a, reason: collision with other inner class name */
    public static final class C0044a {
    }

    public static final class b {
        public final AvatarModel a;
        public final Drawable b;

        public b(AvatarModel r1, Drawable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final boolean a;
        public final tdb.a b;
        public final b c;
        public final boolean d;
        public final int e;

        public c(boolean r4, tdb.a r5, b r6, boolean r7, int r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r4 = false;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r5 = null;
        L9:
            if ((r9 & 8) == 0) goto L12;
            r6 = null;
        L12:
            if ((r9 & 16) == 0) goto L15;
            r7 = false;
        L15:
            if ((r9 & 32) == 0) goto L17;
            r8 = 0;
        L17:
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
        }
    }

    static {
    }

    public final View a() {
        return new FlowBadgeView(getContext());
    }

    public Context getContext() {
        return this.c;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.ss.android.lark.flow.feed.component.badge.FlowBadgeView, java.lang.Object] */
    public final void d(c r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        ?? r0 = (FlowBadgeView) c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "param");
        boolean r4 = true;
        int r5 = 0;
        if (r12.d == true) goto L5;
    L28:
        AdvanceAvatarView r1 = r0.c;
        if (r1 == null) goto L31;
        r1.setVisibility(8);
    L31:
        float r7 = 10.0f;
        if (r12.a == false) goto L67;
        ImageView r2 = r0.b;
        if (r2 == null) goto L36;
        r2.setVisibility(8);
    L36:
        tdb.a r3 = r12.b;
        if (r3 != null) goto L39;
    L63:
        AppCompatTextView r6 = r0.a;
        if (r6 == null) goto L90;
        r6.setVisibility(8);
    L90:
        AppCompatTextView r8 = r0.a;
        if (r8 != null) goto L93;
    L95:
        boolean r9 = false;
    L96:
        if (r9 == true) goto L113;
        ImageView r10 = r0.b;
        if (r10 != null) goto L100;
    L102:
        boolean r11 = false;
    L103:
        if (r11 == true) goto L113;
        AdvanceAvatarView r13 = r0.c;
        if (r13 != null) goto L107;
    L109:
        boolean r14 = false;
    L110:
        if (r14 == true) goto L113;
        r4 = false;
        goto L113
    L107:
        if (r13.getVisibility() != 0) goto L109;
        r14 = true;
        goto L110
    L100:
        if (r10.getVisibility() != 0) goto L102;
        r11 = true;
    L113:
        if (r4 == true) goto L116;
        r5 = 8;
    L116:
        r0.setVisibility(r5);
        if (r12.d == false) goto L119;
        int r15 = UIUtils.dp2px(getContext(), 18.0f);
    L120:
        ConstraintLayout r16 = (FlowBadgeView) c();
        ViewGroup.LayoutParams r17 = ((FlowBadgeView) c()).getLayoutParams();
        r17.width = r15;
        r17.height = r15;
        r16.setLayoutParams(r17);
        return;
    L119:
        r15 = UIUtils.dp2px(getContext(), 22.0f);
        goto L120
    L93:
        if (r8.getVisibility() != 0) goto L95;
        r9 = true;
        goto L96
    L39:
        if (r3.c != 0) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == true) goto L45;
        r3 = null;
    L45:
        if (r3 == null) goto L63;
        if (r0.a != null) goto L49;
        r0.a = new FlowRedDotTextView(r0.getContext());
        ConstraintLayout.LayoutParams r19 = new ConstraintLayout.LayoutParams(-2, -2);
        r19.startToStart = 0;
        r19.endToEnd = 0;
        r19.topToTop = 0;
        r19.bottomToBottom = 0;
        r0.addView(r0.a, r19);
    L49:
        FlowRedDotTextView r20 = r0.a;
        if (r20 == null) goto L60;
        r20.setBadgeSize(22.0f);
        if (r12.d == true) goto L55;
        r7 = 12.0f;
    L55:
        r20.setBadgeTextSize(r7);
        int r21 = r12.e;
        if (r21 <= 99) goto L58;
        String r22 = "99";
    L59:
        r20.setRedDotText(r22);
        goto L60
    L58:
        r22 = String.valueOf(r21);
    L60:
        AppCompatTextView r23 = r0.a;
        if (r23 == null) goto L90;
        r23.setVisibility(0);
        goto L90
    L41:
        r18 = false;
        goto L42
    L67:
        if (r12.e <= 0) goto L81;
        AppCompatTextView r24 = r0.a;
        if (r24 == null) goto L72;
        r24.setVisibility(8);
    L72:
        if (r0.b != null) goto L78;
        Context r25 = r0.getContext();
        boolean r26 = r12.d;
        ImageView r27 = new ImageView(r25);
        r0.b = r27;
        r27.setImageDrawable(UIHelper.getDrawable(2131237930));
        if (r26 == false) goto L76;
        int r28 = UIUtils.dp2px(r25, 8.0f);
    L77:
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(r28, r28);
        r29.startToStart = 0;
        r29.endToEnd = 0;
        r29.topToTop = 0;
        r29.bottomToBottom = 0;
        r0.addView(r0.b, r29);
        goto L78
    L76:
        r28 = UIUtils.dp2px(r25, 10.0f);
    L78:
        ImageView r30 = r0.b;
        if (r30 == null) goto L90;
        r30.setVisibility(0);
        goto L90
    L81:
        AppCompatTextView r31 = r0.a;
        if (r31 == null) goto L84;
        r31.setVisibility(8);
    L84:
        ImageView r32 = r0.b;
        if (r32 == null) goto L87;
        r32.setVisibility(8);
    L87:
        AdvanceAvatarView r33 = r0.c;
        if (r33 == null) goto L90;
        r33.setVisibility(8);
        goto L90
    L5:
        if (r12.c == null) goto L28;
        AppCompatTextView r34 = r0.a;
        if (r34 == null) goto L9;
        r34.setVisibility(8);
    L9:
        ImageView r35 = r0.b;
        if (r35 == null) goto L13;
        r35.setVisibility(8);
    L13:
        if (r0.c != null) goto L15;
        Context r36 = r0.getContext();
        AdvanceAvatarView r37 = new AdvanceAvatarView(r36);
        r37.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r37.setOval(true);
        r0.c = r37;
        int r38 = UIUtils.dp2px(r36, 18.0f);
        ConstraintLayout.LayoutParams r39 = new ConstraintLayout.LayoutParams(r38, r38);
        r39.startToStart = 0;
        r39.endToEnd = 0;
        r39.topToTop = 0;
        r39.bottomToBottom = 0;
        r0.addView(r0.c, r39);
    L15:
        AvatarModel r40 = r12.c.a;
        if (r40 == null) goto L20;
        AdvanceAvatarView r41 = r0.c;
        if (r41 == null) goto L20;
        r41.j(r40);
    L20:
        Drawable r42 = r12.c.b;
        if (r42 == null) goto L25;
        AdvanceAvatarView r43 = r0.c;
        if (r43 == null) goto L25;
        r43.setBorderDrawable(r42);
    L25:
        AdvanceAvatarView r44 = r0.c;
        if (r44 == null) goto L90;
        r44.setVisibility(0);
        goto L90
    }
}
