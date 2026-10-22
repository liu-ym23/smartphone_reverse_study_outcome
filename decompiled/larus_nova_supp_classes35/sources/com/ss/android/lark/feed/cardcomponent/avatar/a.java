package com.ss.android.lark.feed.cardcomponent.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import wz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<b, FeedCardAvatarView> {
    public final Context c;
    public final int d;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.cardcomponent.avatar.a$a, reason: collision with other inner class name */
    public static final class C0199a {
    }

    public static final class b {
        public final com.ss.android.lark.feed.export.feedcard.b a;
        public final tdb.a b;
        public final d c;
        public final Drawable d;
        public final AvatarModel e;

        public b(com.ss.android.lark.feed.export.feedcard.b r3, tdb.a r4, d r5, Drawable r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = null;
        L11:
            Intrinsics.checkNotNullParameter(r3, "avatar");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = null;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        Context r1 = getContext();
        int r2 = this.d;
        Intrinsics.checkNotNullParameter(r1, "context");
        return new FeedCardAvatarView(r1, null, r2);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.ss.android.lark.feed.cardcomponent.avatar.FeedCardAvatarView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup, com.ss.android.lark.feed.cardcomponent.avatar.FeedCardAvatarView] */
    public final void d(b r15) {
        Intrinsics.checkNotNullParameter(r15, Keys.API_RETURN_KEY_DATA);
        FeedCardAvatarView r0 = c();
        com.ss.android.lark.feed.export.feedcard.b r1 = r15.a;
        AvatarModel r2 = r1.a;
        d r3 = r15.c;
        String r4 = r1.b;
        boolean r5 = r1.c;
        tdb.a r6 = r15.b;
        boolean r7 = r1.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "avatarModel");
        AdvanceAvatarView r8 = r0.b;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r8 = null;
    L5:
        r8.j(r2);
        AdvanceAvatarView r9 = r0.b;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r9 = null;
    L8:
        r9.l(r3);
        if (r4 != null) goto L11;
        DecoratedAvatar r10 = r0.c;
        if (r10 == null) goto L32;
        r10.setVisibility(8);
    L32:
        if (r5 == false) goto L36;
        View r11 = r0.a;
        if (r11 == null) goto L40;
        r11.setVisibility(0);
    L40:
        if (r7 == false) goto L83;
        if (r6 != null) goto L43;
    L80:
        LKUIBadgeView r12 = r0.d;
        if (r12 == null) goto L83;
        r12.setVisibility(8);
        goto L83
    L43:
        if (r6.c != 0) goto L45;
        boolean r13 = true;
    L46:
        if (r13 == true) goto L49;
        r6 = null;
    L49:
        if (r6 == null) goto L80;
        if (r0.d != null) goto L56;
        Context r14 = r0.getContext();
        LKUIBadgeView r16 = new LKUIBadgeView(r14);
        float r17 = zz7.b.j(12);
        com.larksuite.component.ui.imageview.a r18 = r16.a;
        Context r19 = r16.getContext();
        r18.getClass();
        float r110 = j08.b.a(r19, r17);
        if (r18.b == r110) goto L55;
        r18.b = r110;
        r18.g.setTextSize(r110);
        r18.h = true;
    L55:
        r0.d = r16;
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(-2, UIHelper.dp2px(16.0f));
        r20.circleRadius = zz7.b.g(r14, r0.h) / 2;
        r20.circleConstraint = 2131381508;
        r20.circleAngle = 45.0f;
        r0.addView(r0.d, r20);
    L56:
        LKUIBadgeView r21 = r0.d;
        if (r21 == null) goto L77;
        int r22 = r6.b;
        if (r22 == 0) goto L64;
        com.larksuite.component.ui.imageview.a r23 = r21.a;
        if (r23.d == r22) goto L63;
        r23.d = r22;
        r23.g.setColor(r22);
    L63:
        r23.i = true;
    L64:
        String r24 = r6.d;
        com.larksuite.component.ui.imageview.a r25 = r21.a;
        if (r24 == null) goto L67;
    L68:
        if (r24 != null) goto L70;
        r25.getClass();
    L73:
        r21.b(r6.a);
        com.larksuite.component.ui.imageview.a r26 = r21.a;
        if (r26.e == null) goto L76;
        r26.e = null;
        r26.h = true;
    L76:
        r21.a();
        goto L77
    L70:
        if (r24.equals(r25.a) == true) goto L73;
    L71:
        r25.a = r24;
        r25.h = true;
        goto L73
    L67:
        if (r25.a != null) goto L71;
    L77:
        LKUIBadgeView r27 = r0.d;
        if (r27 == null) goto L83;
        r27.setVisibility(0);
        goto L83
    L45:
        r13 = false;
    L83:
        FeedCardAvatarView r28 = c();
        Drawable r29 = r15.d;
        AvatarModel r111 = r15.e;
        if (r29 != null) goto L86;
        LKUIRoundedImageView2 r30 = r28.e;
        if (r30 == null) goto L97;
        r30.setVisibility(8);
    L97:
        if (r111 != null) goto L99;
        LarkAvatarView r112 = r28.f;
        if (r112 == null) goto L115;
        r112.setVisibility(8);
        return;
    L115:
        return;
    L99:
        if (r28.f != null) goto L101;
        Context r31 = r28.getContext();
        LKUIRoundedImageView2 r32 = new AdvanceAvatarView(r31);
        r32.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r32.setOval(true);
        r28.f = r32;
        ConstraintLayout.LayoutParams r33 = new ConstraintLayout.LayoutParams(zz7.b.g(r31, 22), zz7.b.g(r31, 22));
        r33.endToEnd = 2131381508;
        r33.bottomToBottom = 2131381508;
        r28.addView(r28.f, r33);
    L101:
        LarkAvatarView r34 = r28.f;
        if (r34 == null) goto L104;
        r34.setVisibility(0);
    L104:
        AdvanceAvatarView r35 = r28.f;
        if (r35 == null) goto L113;
        r35.j(r111);
        return;
    L113:
        return;
    L86:
        if (r28.e != null) goto L88;
        Context r113 = r28.getContext();
        LKUIRoundedImageView2 r36 = new LKUIRoundedImageView2(r113, null, 0, 6, null);
        r36.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r36.setOval(true);
        r28.e = r36;
        ConstraintLayout.LayoutParams r37 = new ConstraintLayout.LayoutParams(zz7.b.g(r113, 20), zz7.b.g(r113, 20));
        r37.endToEnd = 2131381508;
        r37.bottomToBottom = 2131381508;
        r28.addView(r28.e, r37);
    L88:
        LKUIRoundedImageView2 r114 = r28.e;
        if (r114 == null) goto L91;
        r114.setVisibility(0);
    L91:
        LKUIRoundedImageView2 r115 = r28.e;
        if (r115 == null) goto L111;
        r115.setBackground(r29);
        return;
    L111:
        return;
    L36:
        View r38 = r0.a;
        if (r38 == null) goto L40;
        r38.setVisibility(8);
        goto L40
    L11:
        if (r0.c != null) goto L20;
        Context r39 = r0.getContext();
        DecoratedAvatar r116 = new DecoratedAvatar(r39, null, 6, 0);
        r0.c = r116;
        ImageView r117 = r116.getDecorationView();
        if (r117 == null) goto L20;
        r117.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (((Boolean) FeedCardAvatarView.i.getValue()).booleanValue() == false) goto L18;
        int r118 = UIHelper.dp2px(8);
    L19:
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(zz7.b.g(r39, 48), zz7.b.g(r39, 48));
        r119.topToTop = 0;
        r119.bottomToBottom = 0;
        r119.leftToLeft = 0;
        r119.setMargins(UIHelper.dp2px(16.0f), r118, 0, r118);
        r0.addView(r0.c, r0.g, r119);
        goto L20
    L18:
        r118 = 0;
    L20:
        DecoratedAvatar r40 = r0.c;
        if (r40 == null) goto L26;
        ImageView r120 = r40.a;
        if (r120 == null) goto L25;
        r120.setImageDrawable(null);
    L25:
        r40.b(r4);
    L26:
        DecoratedAvatar r41 = r0.c;
        if (r41 == null) goto L32;
        r41.setVisibility(0);
        goto L32
    }

    public a(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
        this.d = r3;
    }
}
