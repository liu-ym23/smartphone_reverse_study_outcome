package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.bottomaction.FeedCardButtonsComponent;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.openfeed.FeedCardButtonsParamsFactory;
import com.ss.android.lark.feed.shared.openfeed.FeedCardButtonsParamsFactory$createFeedCardButtonsParams$clickListener$1;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.feed.export.feedcard.c {
    public final com.samskivert.mustache.h a;

    public a() {
        this.a = com.samskivert.mustache.e.a().b().a(UIUtils.getString(LarkContext.getApplication(), 2131892293));
    }

    @Override // com.ss.android.lark.feed.export.feedcard.c
    public final xdb.a.b a(UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        if (r4.isFlag() == false) goto L7;
        Drawable r0 = UIHelper.getDrawable(2131254770);
        if (r0 == null) goto L7;
        r0.mutate();
        r0.setTint(UIHelper.getColor(2131101119));
    L8:
        Map<String, String> r1 = com.ss.android.lark.feed.shared.data.utils.f.a;
        if (r4.getId() == null) goto L13;
        Map<String, String> r2 = com.ss.android.lark.feed.shared.data.utils.f.a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        String r5 = (String) r3.get(r4.getId());
        if (r5 == null) goto L13;
    L17:
        return new xdb.a.b(r5, r0, 4);
    L13:
        r5 = com.ss.android.lark.feed.shared.data.utils.f.a(r4.getDisplayTime());
        if (r4.getId() == null) goto L17;
        Map<String, String> r6 = com.ss.android.lark.feed.shared.data.utils.f.a;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        r7.put(r4.getId(), r5);
    L7:
        r0 = null;
        goto L8
    }

    @Override // com.ss.android.lark.feed.export.feedcard.c
    public final com.ss.android.lark.feed.cardcomponent.preview.c c(FeedPreview r6) {
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        List<Reaction> r0 = r6.getReactions();
        if (r0 == null) goto L10;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (qsb.b.a().i7(((Reaction) r3).getType()) == true) goto L6;
        r1.add(r3);
    L11:
        List r4 = r1;
        if (r1 != null) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        return new com.ss.android.lark.feed.cardcomponent.preview.c(r4, r6.getReactionDisplayCount());
    L10:
        r1 = null;
        goto L11
    }

    @Override // com.ss.android.lark.feed.export.feedcard.c
    public final com.ss.android.lark.feed.cardcomponent.preview.e.b e(UIFeedCard r7) {
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_DATA);
        boolean r0 = com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.im.group_auto_mute_gray_config");
        boolean r3 = true;
        if (r7.getType() != FeedCard.Type.CHAT) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r7.getMuteNoticeType() == AutoMuteSettingNoticeType.UNKNOWN) goto L12;
        boolean r2 = true;
    L14:
        if (r7.isRemind() == false) goto L21;
        if (r0 == false) goto L19;
        if (r2 == false) goto L19;
        if (r1 == true) goto L21;
    L19:
        r3 = false;
    L21:
        return new com.ss.android.lark.feed.cardcomponent.preview.e.b(r3);
    L12:
        r2 = false;
        goto L14
    L5:
        if (r7.getType() == FeedCard.Type.OPEN_APP_CHAT) goto L8;
        r1 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.lark.feed.shared.openfeed.FeedCardButtonsParamsFactory$createFeedCardButtonsParams$clickListener$1] */
    @Override // com.ss.android.lark.feed.export.feedcard.c
    public final FeedCardButtonsComponent.c b(final ChatFeedPreview r27, final com.ss.android.lark.feed.export.feedcard.d r28) {
        Intrinsics.checkNotNullParameter(r27, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r28, "feedCardContext");
        int r1 = FeedCardButtonsParamsFactory.a;
        Intrinsics.checkNotNullParameter(r27, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r28, "feedCardContext");
        ArrayList<FeedCardButton> r0 = r27.getFeedCardButtons();
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        FeedCardButtonsComponent.c r3 = new FeedCardButtonsComponent.c(CollectionsKt.emptyList());
    L37:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type T of com.ss.android.lark.feed.shared.page.ComponentParamsFactory.createFeedCardButtonsParams");
        return r3;
    L11:
        final Context r17 = r28.getHost().getContext();
        FeedCardButtonsParamsFactory.FeedCardButtonsViewModel.a r4 = FeedCardButtonsParamsFactory.FeedCardButtonsViewModel.Companion;
        Fragment r5 = r28.getHost();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "lifeCycleOwner");
        FeedCardButtonsParamsFactory.FeedCardButtonsViewModel r12 = (FeedCardButtonsParamsFactory.FeedCardButtonsViewModel) new ViewModelProvider(r5).get(FeedCardButtonsParamsFactory.FeedCardButtonsViewModel.class);
        final com.ss.android.lark.feed.export.feedcard.g r18 = r28.a();
        final String r19 = r27.getId();
        final String r20 = FeedCardButtonsParamsFactory.a(r27);
        String r11 = r12.getWebHookingBtnID(r27);
        ArrayList r10 = new ArrayList();
        Iterator<FeedCardButton> r21 = r0.iterator();
    L13:
        if (r21.hasNext() == false) goto L36;
        FeedCardButton r6 = r21.next();
        final String r9 = r6.getId();
        final String r7 = y.a(r9);
        final String r8 = r6.getText();
        final String r13 = r6.getUrl();
        final AppFeedCardButton.ActionType r14 = r6.getActionType();
        if (com.ss.android.lark.feed.shared.page.utils.d.a(r27) == false) goto L17;
        FeedCardButtonsComponent.ButtonStyle r15 = FeedCardButtonsComponent.ButtonStyle.TOPPING;
    L18:
        FeedCardButtonsComponent.ButtonStyle r16 = r15;
        if (r11 != null) goto L21;
    L24:
        boolean r22 = true;
    L25:
        if (r22 == false) goto L29;
        FeedCardButtonsComponent.ButtonState r23 = FeedCardButtonsComponent.ButtonState.DEFAULT;
    L27:
        FeedCardButtonsComponent.ButtonState r24 = r23;
        final FeedCardButtonsParamsFactory.FeedCardButtonsViewModel r25 = r12;
        ArrayList r26 = r10;
        r26.add(new FeedCardButtonsComponent.a(r8, r16, r24, new FeedCardButtonsParamsFactory$createFeedCardButtonsParams$clickListener$1(r14, r7, r27, r8, r13, r17, r28, r25, r9, r18, r19, r20)));
        r10 = r26;
        r11 = r11;
        r12 = r12;
        goto L13
    L29:
        if (Intrinsics.areEqual(r11, r9) == false) goto L32;
        r23 = FeedCardButtonsComponent.ButtonState.LOADING;
        goto L27
    L32:
        if (r14 != AppFeedCardButton.ActionType.WEBHOOK) goto L34;
        r23 = FeedCardButtonsComponent.ButtonState.DISABLED;
        goto L27
    L34:
        r23 = FeedCardButtonsComponent.ButtonState.DEFAULT;
        goto L27
    L21:
        if (r11.length() == 0) goto L24;
        r22 = false;
        goto L25
    L17:
        r15 = FeedCardButtonsComponent.ButtonStyle.DEFAULT;
        goto L18
    L36:
        r3 = new FeedCardButtonsComponent.c(r10);
        goto L37
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.ss.android.lark.feed.export.feedcard.c
    public final com.ss.android.lark.feed.cardcomponent.preview.a.b d(Context r11, UIFeedCard r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        MutexMarkType r1 = r12.getMutexMarkType();
        boolean r3 = true;
        if (r12.isRemind() == false) goto L9;
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.im.group_auto_mute_gray_config") == true) goto L7;
    L16:
        String r2 = BuildConfig.FLAVOR;
    L18:
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.feed.forseti_selected_feed_draft_disable") == false) goto L20;
    L26:
        boolean r13 = false;
    L27:
        if (r13 == false) goto L39;
        if (r2.length() == 0) goto L32;
        r3 = false;
    L32:
        if (r3 == false) goto L34;
        List r14 = r12.getDigestMessage();
    L43:
        int r4 = com.ss.android.lark.feed.shared.page.utils.d.a;
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        if (com.ss.android.lark.feed.shared.page.utils.d.a(r12) == false) goto L46;
        int r15 = 2131106607;
    L48:
        return new com.ss.android.lark.feed.cardcomponent.preview.a.b(r14, r15);
    L46:
        r15 = 2131106620;
        goto L48
    L34:
        ArrayList r16 = new ArrayList();
        List<DigestElement> r5 = r12.getDigestMessage();
        if (r5 == null) goto L37;
        r16.addAll(r5);
    L37:
        ListProtector.add(r16, 0, new TextProperty(r2));
        r14 = r16;
        goto L43
    L39:
        if (r1 == MutexMarkType.DRAFT) goto L42;
        r3 = false;
    L42:
        r14 = r12.getDigestMessage(r3, r2);
        goto L43
    L20:
        if (ForsetiConfig.a(r11) == false) goto L26;
        if (r12.getMutexMarkType() != MutexMarkType.DRAFT) goto L26;
        if (Intrinsics.areEqual(r12.getId(), jeb.b.a().q3()) == false) goto L26;
        r13 = true;
        goto L27
    L7:
        if (r12.isRedBadge() == true) goto L16;
    L9:
        if (afb.b.a == false) goto L16;
        if (r12.getUnreadCount() != 1) goto L14;
        HashMap r6 = new HashMap(1);
        r6.put("unread_count", String.valueOf(r12.getUnreadCount()));
        r2 = this.a.b(r6) + ' ';
        goto L18
    L14:
        if (r12.getUnreadCount() <= 1) goto L16;
        HashMap r7 = new HashMap(1);
        r7.put("unread_count", String.valueOf(r12.getUnreadCount()));
        r2 = this.a.b(r7) + ' ';
        goto L18
    }
}
