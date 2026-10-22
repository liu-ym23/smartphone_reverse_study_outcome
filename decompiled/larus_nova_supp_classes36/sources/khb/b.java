package khb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements h, ihb.a {
    public com.ss.android.lark.feed.cardcomponent.avatar.a a;
    public ehb.a b;
    public com.ss.android.lark.flow.feed.component.badge.a c;
    public UIFeedCard d;
    public d e;
    public boolean f;

    public static final class a {
    }

    /* JADX INFO: renamed from: khb.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0287b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AtInfo.AtType.values().length];
            r0[AtInfo.AtType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AtInfo.AtType.ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final void onViewAttachedToWindow() {
    }

    public final void onViewDetachedFromWindow() {
    }

    public final void onViewRecycled() {
    }

    public final void c() {
        UIFeedCard r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        d r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        fhb.a.f(r0, fhb.a.b(r1));
    }

    public b() {
        this.f = true;
    }

    public final com.ss.android.lark.feed.export.feedcard.a a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        this.a = new com.ss.android.lark.feed.cardcomponent.avatar.a(r11.getContext(), 28);
        this.b = new ehb.a(r11.getContext());
        this.c = new com.ss.android.lark.flow.feed.component.badge.a(r11.getContext());
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
        com.ss.android.lark.flow.feed.component.badge.a r3 = this.c;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L13:
        r6[0] = r1;
        return new com.ss.android.lark.feed.export.feedcard.a(r2, null, r4, r6, null, null, null, 485);
    L12:
        r1 = r3;
        goto L13
    L5:
        r2 = r0;
        goto L6
    }

    @Override // ihb.a
    public final void d(boolean r1) {
        this.f = r1;
    }

    public final void b(View r19, UIFeedCard r20, com.ss.android.lark.feed.export.feedcard.c r21, d r22) {
        Intrinsics.checkNotNullParameter(r19, "itemView");
        Intrinsics.checkNotNullParameter(r20, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r21, "paramsFactory");
        Intrinsics.checkNotNullParameter(r22, "feedCardContext");
        this.d = r20;
        this.e = r22;
        com.ss.android.lark.flow.feed.component.badge.a r3 = null;
        if ((r20 instanceof ThreadFeedPreview) == false) goto L5;
        ThreadFeedPreview r2 = (ThreadFeedPreview) r20;
    L6:
        if (r2 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowSidebarThreadCell", "onBindView: unsupported id=" + r20.getId() + ", card=" + r20.getClass().getSimpleName());
        return;
    L9:
        Context r1 = r19.getContext();
        if (r2.isMsgThread() == false) goto L12;
        Drawable r4 = UIUtils.getDrawable(r1, 2131237931);
    L14:
        if (r2.getFeedType() != FeedCard.FeedType.DONE) goto L16;
        boolean r5 = true;
    L17:
        tdb.a r11 = afb.a.a(r2, r5);
        AvatarModel.a r6 = new AvatarModel.a();
        r6.e(r4);
        r6.f(r2.getId());
        r6.h(AvatarModel.Size.MIDDLE);
        Biz r7 = Biz.Messenger;
        r6.c(r7);
        Scene r8 = Scene.Feed;
        r6.g(r8);
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r9 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(new AvatarModel(r6), false, 6), r11, null, null, 28);
        UIFeedCard.AtInfo r10 = r2.getAtInfo();
        if (r10 == null) goto L30;
        qdb.a r12 = new qdb.a();
        r12.b(r10.getAvatarKey());
        r12.f(r10.getId());
        r12.h(AvatarModel.Size.MINI);
        r12.a(false);
        r12.c(r7);
        r12.g(r8);
        AvatarModel r13 = new AvatarModel(r12);
        AtInfo.AtType r14 = r10.getAtType();
        if (r14 != null) goto L22;
        int r15 = -1;
    L23:
        if (r15 != 1) goto L25;
        Drawable r16 = UIHelper.getDrawable(2131235353);
    L29:
        com.ss.android.lark.flow.feed.component.badge.a.b r17 = new com.ss.android.lark.flow.feed.component.badge.a.b(r13, r16);
    L31:
        com.ss.android.lark.feed.cardcomponent.avatar.a r18 = this.a;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r18 = null;
    L34:
        r18.d(r9);
        ehb.a r23 = this.b;
        if (r23 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r23 = null;
    L37:
        Context r24 = r19.getContext();
        ArrayList r110 = new ArrayList();
        if (this.f == false) goto L43;
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L43;
        r110.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r24, 2131237933)));
    L43:
        if (r2.isRemind() == true) goto L45;
        r110.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r24, 2131237908)));
    L45:
        r23.d(new ehb.b(r2.getName(), r110, false, 17, 4));
        com.ss.android.lark.flow.feed.component.badge.a r25 = this.c;
        if (r25 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L49:
        r3.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r2.isRemind(), r9.b, r17, true, r2.getBadgeCount(), 4));
        return;
    L48:
        r3 = r25;
        goto L49
    L25:
        if (r15 == 2) goto L27;
        r16 = null;
        goto L29
    L27:
        r16 = UIHelper.getDrawable(2131235352);
        goto L29
    L22:
        r15 = C0287b.a[r14.ordinal()];
        goto L23
    L30:
        r17 = null;
        goto L31
    L16:
        r5 = false;
        goto L17
    L12:
        r4 = UIUtils.getDrawable(r1, 2131237932);
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
