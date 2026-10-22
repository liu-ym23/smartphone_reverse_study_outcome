package com.ss.android.lark.flow.feed.cell.contact;

import android.view.View;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.preview.e;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements h {
    public com.ss.android.lark.feed.cardcomponent.avatar.a a;
    public ehb.a b;
    public xdb.a c;
    public com.ss.android.lark.flow.feed.component.preview.a d;
    public e e;
    public com.ss.android.lark.flow.feed.component.badge.a f;
    public UIFeedCard g;
    public d h;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.cell.contact.a$a, reason: collision with other inner class name */
    public static final class C0042a {
    }

    static {
    }

    public a() {
    }

    public final void onViewAttachedToWindow() {
    }

    public final void onViewDetachedFromWindow() {
    }

    public final void onViewRecycled() {
    }

    public final void c() {
        UIFeedCard r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        d r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        fhb.a.f(r0, fhb.a.b(r1));
    }

    public final com.ss.android.lark.feed.export.feedcard.a a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        this.a = new com.ss.android.lark.feed.cardcomponent.avatar.a(r11.getContext(), 60);
        this.b = new ehb.a(r11.getContext());
        this.c = new xdb.a(r11.getContext());
        this.d = new com.ss.android.lark.flow.feed.component.preview.a(r11.getContext());
        this.f = new com.ss.android.lark.flow.feed.component.badge.a(r11.getContext());
        this.e = new e(r11.getContext());
        com.ss.android.lark.feed.cardcomponent.avatar.a r0 = this.a;
        com.ss.android.lark.flow.feed.component.badge.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        com.ss.android.lark.feed.cardcomponent.avatar.a r2 = null;
    L6:
        FeedCardComponent[] r4 = new FeedCardComponent[1];
        ehb.a r5 = this.b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r5 = null;
    L9:
        r4[0] = r5;
        FeedCardComponent[] r6 = new FeedCardComponent[1];
        xdb.a r7 = this.c;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r7 = null;
    L12:
        r6[0] = r7;
        FeedCardComponent[] r8 = new FeedCardComponent[2];
        com.ss.android.lark.flow.feed.component.preview.a r9 = this.d;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r9 = null;
    L15:
        r8[0] = r9;
        com.ss.android.lark.flow.feed.component.badge.a r10 = this.f;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L19:
        r8[1] = r1;
        return new com.ss.android.lark.feed.export.feedcard.a(r2, null, r4, r6, r8, null, null, 421);
    L18:
        r1 = r10;
        goto L19
    L5:
        r2 = r0;
        goto L6
    }

    public final void b(View r11, UIFeedCard r12, com.ss.android.lark.feed.export.feedcard.c r13, d r14) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        Intrinsics.checkNotNullParameter(r12, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r13, "paramsFactory");
        Intrinsics.checkNotNullParameter(r14, "feedCardContext");
        this.g = r12;
        this.h = r14;
        qdb.a r15 = new qdb.a();
        r15.d(2131237903);
        r15.f(r12.getAvatarId());
        r15.h(AvatarModel.Size.MIDDLE);
        int r0 = 0;
        r15.a(false);
        r15.c(Biz.Messenger);
        r15.g(Scene.Feed);
        AvatarModel r1 = new AvatarModel(r15);
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r16 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(r1, false, 6), afb.a.a(r12, false), null, null, 28);
        com.ss.android.lark.feed.cardcomponent.avatar.a r2 = this.a;
        com.ss.android.lark.flow.feed.component.badge.a r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r2 = null;
    L5:
        r2.d(r16);
        ehb.a r4 = this.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r4 = null;
    L8:
        r4.d(new ehb.b(r12.getName(), null, true, 16, 2));
        xdb.a r5 = this.c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r5 = null;
    L11:
        r5.d(r13.a(r12));
        com.ss.android.lark.flow.feed.component.preview.a r6 = this.d;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r6 = null;
    L14:
        com.ss.android.lark.feed.cardcomponent.preview.a.b r17 = r13.d(r11.getContext(), r12);
        r17.d = 2131101973;
        UIFeedCard.AtInfo r7 = r12.getAtInfo();
        if (r7 == null) goto L17;
        AtInfo.AtType r8 = r7.getAtType();
    L19:
        if (r8 == AtInfo.AtType.USER) goto L28;
        UIFeedCard.AtInfo r9 = r12.getAtInfo();
        if (r9 == null) goto L23;
        AtInfo.AtType r10 = r9.getAtType();
    L25:
        if (r10 == AtInfo.AtType.ALL) goto L28;
        boolean r18 = false;
    L30:
        if (r12.isRemind() == true) goto L32;
        r0 = r12.getBadgeCount();
    L32:
        r6.d(new com.ss.android.lark.flow.feed.component.preview.a.C0045a(r17, new com.ss.android.lark.flow.feed.component.text_layer.a.C0046a(r18, r0)));
        e r19 = this.e;
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("muteComponent");
        r19 = null;
    L35:
        r19.d(r13.e(r12));
        com.ss.android.lark.flow.feed.component.badge.a r110 = this.f;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L39:
        boolean r20 = r12.isRemind();
        tdb.a r21 = r16.b;
        r12.getAtInfo();
        r3.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r20, r21, null, false, r12.getBadgeCount(), 8));
        return;
    L38:
        r3 = r110;
        goto L39
    L23:
        r10 = null;
    L28:
        r18 = true;
        goto L30
    L17:
        r8 = null;
        goto L19
    }
}
