package com.ss.android.lark.flow.feed.cell.doc;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.preview.e;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import java.util.List;
import kotlin.collections.CollectionsKt;
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

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.cell.doc.a$a, reason: collision with other inner class name */
    public static final class C0043a {
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

    public final void b(View r12, UIFeedCard r13, com.ss.android.lark.feed.export.feedcard.c r14, d r15) {
        Intrinsics.checkNotNullParameter(r12, "itemView");
        Intrinsics.checkNotNullParameter(r13, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r14, "paramsFactory");
        Intrinsics.checkNotNullParameter(r15, "feedCardContext");
        this.g = r13;
        this.h = r15;
        com.ss.android.lark.flow.feed.component.badge.a r0 = null;
        if ((r13 instanceof DocFeedPreview) == false) goto L5;
        DocFeedPreview r16 = (DocFeedPreview) r13;
    L6:
        if (r16 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowDocCell", "onBindView: unsupported id=" + r13.getId() + ", card=" + r13.getClass().getSimpleName());
        return;
    L9:
        tz7.a.a r17 = new tz7.a.a();
        r17.f("");
        String r1 = r16.getDocUrl();
        Intrinsics.checkNotNullParameter(r1, "url");
        r17.k = r1;
        r17.c(Biz.Messenger);
        r17.g(Scene.Feed);
        String r2 = r16.getIconInfo();
        Intrinsics.checkNotNullParameter(r2, "meta");
        r17.l = r2;
        boolean r3 = true;
        int r4 = 0;
        if (r16.getDocType() != DocType.BITABLE) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        IconShape r6 = IconShape.SQUARE;
    L16:
        r17.m = r6;
        tz7.a r7 = new tz7.a(r17);
        boolean r18 = r16.isContainMarkType(UIFeedCard.MarkType.URGENT);
        wz7.a r8 = new wz7.a(r16.getDocType().getNumber());
        if (r16.getFeedType() != FeedCard.FeedType.DONE) goto L19;
        boolean r9 = true;
    L20:
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r19 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(r7, r18, 2), afb.a.a(r16, r9), r8, null, 24);
        com.ss.android.lark.feed.cardcomponent.avatar.a r10 = this.a;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r10 = null;
    L23:
        r10.d(r19);
        ehb.a r11 = this.b;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r11 = null;
    L26:
        Context r20 = r12.getContext();
        if (r16.isRemind() == true) goto L29;
        List r21 = CollectionsKt.listOf(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r20, 2131237908)));
    L30:
        r11.d(new ehb.b(r16.getName(), r21, true, 16));
        xdb.a r22 = this.c;
        if (r22 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r22 = null;
    L33:
        r22.d(r14.a(r16));
        com.ss.android.lark.flow.feed.component.preview.a r23 = this.d;
        if (r23 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r23 = null;
    L36:
        Context r110 = r12.getContext();
        com.ss.android.lark.feed.cardcomponent.preview.c r24 = r14.c(r16);
        r24.d = false;
        r24.e = false;
        r24.f = 20;
        com.ss.android.lark.feed.cardcomponent.preview.a.b r111 = r14.d(r110, r16);
        r111.e = 20;
        r111.d = 2131101973;
        UIFeedCard.AtInfo r25 = r16.getAtInfo();
        if (r25 == null) goto L39;
        AtInfo.AtType r26 = r25.getAtType();
    L41:
        if (r26 == AtInfo.AtType.USER) goto L51;
        UIFeedCard.AtInfo r27 = r16.getAtInfo();
        if (r27 == null) goto L45;
        AtInfo.AtType r28 = r27.getAtType();
    L47:
        if (r28 == AtInfo.AtType.ALL) goto L51;
        r3 = false;
        goto L51
    L45:
        r28 = null;
    L51:
        if (r16.isRemind() == true) goto L53;
        r4 = r16.getBadgeCount();
    L53:
        r23.d(new com.ss.android.lark.flow.feed.component.preview.a.C0045a(r24, r111, new com.ss.android.lark.flow.feed.component.text_layer.a.C0046a(r3, r4)));
        e r112 = this.e;
        if (r112 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("muteComponent");
        r112 = null;
    L56:
        r112.d(r14.e(r16));
        com.ss.android.lark.flow.feed.component.badge.a r113 = this.f;
        if (r113 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L60:
        boolean r29 = r16.isRemind();
        tdb.a r30 = r19.b;
        r16.getAtInfo();
        r0.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r29, r30, null, false, r16.getBadgeCount(), 8));
        return;
    L59:
        r0 = r113;
        goto L60
    L39:
        r26 = null;
        goto L41
    L29:
        r21 = CollectionsKt.emptyList();
        goto L30
    L19:
        r9 = false;
        goto L20
    L15:
        r6 = IconShape.CIRCLE;
        goto L16
    L12:
        r5 = false;
        goto L13
    L5:
        r16 = null;
        goto L6
    }
}
