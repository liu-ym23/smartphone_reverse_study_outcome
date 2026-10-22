package beb;

import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.bytedance.lark.pb.basic.v1.FeedButtonData;
import com.bytedance.lark.pb.feed.v1.AIKnowledgeQueryStatus;
import com.bytedance.lark.pb.feed.v1.AppFeedCard;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Digest.Element.Tag.values().length];
            r0[Digest.Element.Tag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Digest.Element.Tag.EMOJI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Digest.Element.Tag.TEXT_WITH_EMOJIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final Digest a(AppFeedCard.PreviewData r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        String r1 = r4.preview;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L10:
        if (r2 == false) goto L13;
        Digest.Element r5 = new Digest.Element.Builder().tag(Digest.Element.Tag.TEXT).text(new Digest.Element.TextProperty.Builder().content(r4.preview).build()).build();
        Intrinsics.checkNotNull(r5);
        r0.add(r5);
    L13:
        return new Digest.Builder().elements(r0).build();
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 != true) goto L10;
        r2 = true;
        goto L10
    L7:
        r3 = false;
        goto L8
    }

    public static final ArrayList<FeedCardButton> b(List<AppFeedCardButton> r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        ArrayList<FeedCardButton> r1 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L41;
        AppFeedCardButton r2 = (AppFeedCardButton) r12.next();
        AppFeedCardButton.URL r3 = r2.multi_url;
        if (r3 == null) goto L20;
        String r4 = r3.android_url;
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        String r6 = r3.url;
    L21:
        String r7 = r2.id;
        if (r7 != null) goto L24;
        String r8 = BuildConfig.FLAVOR;
    L25:
        if (r6 != null) goto L27;
        r6 = BuildConfig.FLAVOR;
    L27:
        AppFeedCardButton.ActionType r9 = r2.action_type;
        if (r9 != null) goto L30;
        r9 = AppFeedCardButton.ActionType.UNKNOWN;
    L30:
        AppFeedCardButton.ActionType r10 = r9;
        AppFeedCardButton.Text r13 = r2.text;
        if (r13 == null) goto L36;
        String r14 = r13.content;
        if (r14 == null) goto L36;
        String r15 = r14;
    L37:
        AppFeedCardButton.ButtonType r16 = r2.button_type;
        if (r16 != null) goto L40;
        r16 = AppFeedCardButton.ButtonType.DEFAULT;
    L40:
        r1.add(new FeedCardButton(r8, r6, r10, r15, r16));
    L36:
        r15 = BuildConfig.FLAVOR;
        goto L37
    L24:
        r8 = r7;
        goto L25
    L19:
        r6 = r3.android_url;
        goto L21
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
        goto L17
    L20:
        r6 = null;
        goto L21
    L41:
        return r1;
    }

    public static final FeedPreviewInfo c(FeedEntityPreview r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FeedPreviewInfo r0 = new FeedPreviewInfo();
        r0.a = r5.feed_id;
        r0.e = FeedCard.FeedType.forNumber(r5.feed_type.getValue());
        r0.z = r5.is_delayed.booleanValue();
        Boolean r1 = r5.is_flag;
        Boolean r2 = Boolean.TRUE;
        r0.A = Intrinsics.areEqual(r1, r2);
        r0.m = r5.update_time.longValue();
        r0.P1 = r5.parent_card_id;
        Long r3 = r5.user_id;
        AIKnowledgeQueryStatus r4 = null;
        if (r3 == null) goto L5;
        String r6 = r3.toString();
    L6:
        r0.b = r6;
        r0.c = Intrinsics.areEqual(r5.check_user, r2);
        r0.K2 = r5.on_top_rank_time.longValue();
        r0.L2 = r5.is_priority_processing.booleanValue();
        r0.M2 = r5.is_fake.booleanValue();
        int r7 = beb.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.im.feed.feed_button") == false) goto L13;
        FeedButtonData r8 = r5.button_data;
        if (r8 == null) goto L11;
        List r9 = r8.buttons;
    L12:
        r0.P2 = r9;
        goto L13
    L11:
        r9 = null;
    L13:
        ChatData r10 = r5.chat_data;
        if (r10 == null) goto L16;
        r4 = r10.query_status;
    L16:
        r0.Q2 = r4;
        if (r10 == null) goto L21;
        Boolean r11 = r10.digest_is_query;
        if (r11 == null) goto L21;
        boolean r12 = r11.booleanValue();
    L22:
        r0.R2 = r12;
        return r0;
    L21:
        r12 = false;
        goto L22
    L5:
        r6 = null;
        goto L6
    }
}
