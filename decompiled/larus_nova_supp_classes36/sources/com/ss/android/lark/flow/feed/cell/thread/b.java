package com.ss.android.lark.flow.feed.cell.thread;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.cardcomponent.preview.e;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sz7.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements h {
    public com.ss.android.lark.feed.cardcomponent.avatar.a a;
    public ehb.a b;
    public xdb.a c;
    public com.ss.android.lark.flow.feed.component.preview.a d;
    public e e;
    public com.ss.android.lark.flow.feed.component.badge.a f;
    public UIFeedCard g;
    public com.ss.android.lark.feed.export.feedcard.d h;

    public static final class a {
    }

    static {
    }

    public b() {
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
        com.ss.android.lark.feed.export.feedcard.d r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        fhb.a.f(r0, fhb.a.b(r1));
    }

    public static AvatarModel d(ThreadFeedPreview r2) {
        AvatarModel.a r0 = new AvatarModel.a();
        r0.b(r2.getAvatarKey());
        r0.f(r2.getAvatarId());
        r0.h(AvatarModel.Size.MIDDLE);
        r0.a(false);
        r0.c(Biz.Messenger);
        r0.g(Scene.Feed);
        return new AvatarModel(r0);
    }

    public final com.ss.android.lark.feed.export.feedcard.a a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        this.a = new com.ss.android.lark.feed.cardcomponent.avatar.a(r11.getContext(), 60);
        this.b = new ehb.a(r11.getContext());
        this.c = new xdb.a(r11.getContext());
        this.d = new com.ss.android.lark.flow.feed.component.preview.a(r11.getContext());
        this.e = new e(r11.getContext());
        this.f = new com.ss.android.lark.flow.feed.component.badge.a(r11.getContext());
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

    public final void b(View r12, UIFeedCard r13, com.ss.android.lark.feed.export.feedcard.c r14, com.ss.android.lark.feed.export.feedcard.d r15) {
        Intrinsics.checkNotNullParameter(r12, "itemView");
        Intrinsics.checkNotNullParameter(r13, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r14, "paramsFactory");
        Intrinsics.checkNotNullParameter(r15, "feedCardContext");
        this.g = r13;
        this.h = r15;
        com.ss.android.lark.flow.feed.component.badge.a r0 = null;
        if ((r13 instanceof ThreadFeedPreview) == false) goto L5;
        ThreadFeedPreview r16 = (ThreadFeedPreview) r13;
    L6:
        if (r16 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowThreadCell", "onBindView: unsupported id=" + r13.getId() + ", card=" + r13.getClass().getSimpleName());
        return;
    L9:
        Context r17 = r12.getContext();
        boolean r3 = true;
        int r4 = 0;
        if (r16.getFeedType() != FeedCard.FeedType.DONE) goto L12;
        boolean r1 = true;
    L13:
        tdb.a r7 = afb.a.a(r16, r1);
        wz7.d r8 = new wz7.d(AvatarType.TOPIC, 2);
        if (v.b == null) goto L16;
        boolean r2 = FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
    L17:
        if (r2 == false) goto L19;
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r18 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(d(r16), false, 2), r7, r8, null, 24);
    L30:
        com.ss.android.lark.feed.cardcomponent.avatar.a r5 = this.a;
        if (r5 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r5 = null;
    L33:
        r5.d(r18);
        ehb.a r6 = this.b;
        if (r6 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r6 = null;
    L36:
        Context r9 = r12.getContext();
        if (r16.isRemind() == true) goto L39;
        List r10 = CollectionsKt.listOf(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r9, 2131237908)));
    L40:
        r6.d(new ehb.b(r16.getName(), r10, true, 16));
        xdb.a r11 = this.c;
        if (r11 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r11 = null;
    L43:
        r11.d(r14.a(r16));
        com.ss.android.lark.flow.feed.component.preview.a r19 = this.d;
        if (r19 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r19 = null;
    L46:
        Context r110 = r12.getContext();
        com.ss.android.lark.feed.cardcomponent.preview.c r20 = r14.c(r16);
        r20.d = false;
        r20.e = false;
        r20.f = 20;
        com.ss.android.lark.feed.cardcomponent.preview.a.b r111 = r14.d(r110, r16);
        r111.e = 20;
        r111.d = 2131101973;
        UIFeedCard.AtInfo r21 = r16.getAtInfo();
        if (r21 == null) goto L49;
        AtInfo.AtType r22 = r21.getAtType();
    L51:
        if (r22 == AtInfo.AtType.USER) goto L61;
        UIFeedCard.AtInfo r23 = r16.getAtInfo();
        if (r23 == null) goto L55;
        AtInfo.AtType r24 = r23.getAtType();
    L57:
        if (r24 == AtInfo.AtType.ALL) goto L61;
        r3 = false;
        goto L61
    L55:
        r24 = null;
    L61:
        if (r16.isRemind() == true) goto L63;
        r4 = r16.getBadgeCount();
    L63:
        r19.d(new com.ss.android.lark.flow.feed.component.preview.a.C0045a(r20, r111, new com.ss.android.lark.flow.feed.component.text_layer.a.C0046a(r3, r4)));
        e r112 = this.e;
        if (r112 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("muteComponent");
        r112 = null;
    L66:
        r112.d(r14.e(r16));
        com.ss.android.lark.flow.feed.component.badge.a r113 = this.f;
        if (r113 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L70:
        boolean r25 = r16.isRemind();
        tdb.a r26 = r18.b;
        r16.getAtInfo();
        r0.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r25, r26, null, false, r16.getBadgeCount(), 8));
        return;
    L69:
        r0 = r113;
        goto L70
    L49:
        r22 = null;
        goto L51
    L39:
        r10 = CollectionsKt.emptyList();
        goto L40
    L19:
        com.ss.android.lark.feed.export.feedcard.b r27 = new com.ss.android.lark.feed.export.feedcard.b(d(r16), false, 2);
        if (r16.isMsgThread() == false) goto L26;
        if (UIFeedCardExtraKt.isOnTop(r16) == false) goto L24;
        int r28 = 2131237927;
    L29:
        r18 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(r27, r7, r8, UIUtils.getDrawable(r17, r28), 16);
        goto L30
    L24:
        r28 = 2131237925;
        goto L29
    L26:
        if (UIFeedCardExtraKt.isOnTop(r16) == false) goto L28;
        r28 = 2131237937;
        goto L29
    L28:
        r28 = 2131237935;
        goto L29
    L16:
        r2 = false;
        goto L17
    L12:
        r1 = false;
        goto L13
    L5:
        r16 = null;
        goto L6
    }
}
