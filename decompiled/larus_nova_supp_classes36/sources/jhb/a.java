package jhb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.c;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements h, ihb.a {
    public com.ss.android.lark.feed.cardcomponent.avatar.a a;
    public ehb.a b;
    public com.ss.android.lark.flow.feed.component.badge.a c;
    public UIFeedCard d;
    public d e;
    public boolean f;

    /* JADX INFO: renamed from: jhb.a$a, reason: collision with other inner class name */
    public static final class C0281a {
    }

    public /* synthetic */ class b {
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

    public a() {
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

    public final void b(View r22, UIFeedCard r23, c r24, d r25) {
        Intrinsics.checkNotNullParameter(r22, "itemView");
        Intrinsics.checkNotNullParameter(r23, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r24, "paramsFactory");
        Intrinsics.checkNotNullParameter(r25, "feedCardContext");
        this.d = r23;
        this.e = r25;
        com.ss.android.lark.flow.feed.component.badge.a r3 = null;
        if ((r23 instanceof DocFeedPreview) == false) goto L5;
        DocFeedPreview r2 = (DocFeedPreview) r23;
    L6:
        if (r2 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowSidebarDocCell", "onBindView: unsupported id=" + r23.getId() + ", card=" + r23.getClass().getSimpleName());
        return;
    L9:
        r22.getContext();
        tz7.a.a r1 = new tz7.a.a();
        r1.f("");
        String r5 = r2.getDocUrl();
        Intrinsics.checkNotNullParameter(r5, "url");
        r1.k = r5;
        Biz r6 = Biz.Messenger;
        r1.c(r6);
        Scene r7 = Scene.Feed;
        r1.g(r7);
        String r8 = r2.getIconInfo();
        Intrinsics.checkNotNullParameter(r8, "meta");
        r1.l = r8;
        boolean r9 = true;
        if (r2.getDocType() != DocType.BITABLE) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        IconShape r11 = IconShape.SQUARE;
    L16:
        r1.m = r11;
        tz7.a r12 = new tz7.a(r1);
        wz7.a r14 = new wz7.a(r2.getDocType().getNumber());
        boolean r4 = r2.isContainMarkType(UIFeedCard.MarkType.URGENT);
        if (r2.getFeedType() != FeedCard.FeedType.DONE) goto L19;
        boolean r13 = true;
    L20:
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r15 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(r12, r4, 2), afb.a.a(r2, r13), r14, null, 24);
        UIFeedCard.AtInfo r16 = r2.getAtInfo();
        if (r16 == null) goto L32;
        qdb.a r17 = new qdb.a();
        r17.b(r16.getAvatarKey());
        r17.f(r16.getId());
        r17.h(AvatarModel.Size.MINI);
        r17.a(false);
        r17.c(r6);
        r17.g(r7);
        AvatarModel r18 = new AvatarModel(r17);
        AtInfo.AtType r19 = r16.getAtType();
        if (r19 != null) goto L25;
        int r20 = -1;
    L26:
        if (r20 == 1) goto L30;
        if (r20 == 2) goto L29;
        Drawable r21 = null;
    L31:
        com.ss.android.lark.flow.feed.component.badge.a.b r110 = new com.ss.android.lark.flow.feed.component.badge.a.b(r18, r21);
    L33:
        com.ss.android.lark.feed.cardcomponent.avatar.a r26 = this.a;
        if (r26 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r26 = null;
    L36:
        r26.d(r15);
        ehb.a r27 = this.b;
        if (r27 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r27 = null;
    L39:
        Context r28 = r22.getContext();
        ArrayList r29 = new ArrayList();
        if (r28 == null) goto L60;
        FlowTagBuilder r30 = new FlowTagBuilder(r28);
        TagData r31 = a0.a(r2.getTagData());
        if (r31 == null) goto L55;
        TagData.Companion.getClass();
        Iterator r32 = ((ArrayList) TagData.a.b(r31)).iterator();
    L45:
        if (r32.hasNext() == false) goto L49;
        Object r111 = r32.next();
        if (g08.b.a(((g08.a) r111).b) == false) goto L45;
    L50:
        g08.a r112 = (g08.a) r111;
        if (r112 == null) goto L55;
        if (r112.b != 1) goto L55;
    L56:
        r30.i = r9;
        FlowTagView r33 = r30.b();
        if (r33 == null) goto L60;
        r29.add(new com.ss.android.lark.flow.feed.component.title.a.b(r33));
        goto L60
    L49:
        r111 = null;
    L55:
        r9 = false;
    L60:
        if (this.f == false) goto L65;
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L65;
        r29.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r28, 2131237933)));
    L65:
        if (r2.isRemind() == true) goto L67;
        r29.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r28, 2131237908)));
    L67:
        r27.d(new ehb.b(r2.getName(), r29, false, 17, 4));
        com.ss.android.lark.flow.feed.component.badge.a r34 = this.c;
        if (r34 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L71:
        r3.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r2.isRemind(), r15.b, r110, true, r2.getBadgeCount(), 4));
        return;
    L70:
        r3 = r34;
        goto L71
    L29:
        r21 = UIHelper.getDrawable(2131235352);
        goto L31
    L30:
        r21 = UIHelper.getDrawable(2131235353);
        goto L31
    L25:
        r20 = b.a[r19.ordinal()];
        goto L26
    L32:
        r110 = null;
        goto L33
    L19:
        r13 = false;
        goto L20
    L15:
        r11 = IconShape.CIRCLE;
        goto L16
    L12:
        r10 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
