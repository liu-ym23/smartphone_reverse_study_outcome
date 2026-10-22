package qeb;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.g;
import z5c.j;
import z5c.p0;
import z5c.q0;
import z5c.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[FeedCard.Type.values().length];
            r0[FeedCard.Type.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L45:
            r0[FeedCard.Type.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L61:
            r0[FeedCard.Type.APP_FEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L47:
            r0[FeedCard.Type.OPEN_APP_CHAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L49:
            r0[FeedCard.Type.THREAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L37:
            r0[FeedCard.Type.MSG_THREAD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L51:
            r0[FeedCard.Type.TOPIC.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L15:
            a = r0;
            int[] r1 = new int[AppFeedCardType.values().length];
            r1[AppFeedCardType.CALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L43:
            r1[AppFeedCardType.MAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L55:
            r1[AppFeedCardType.DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L41:
            r1[AppFeedCardType.OPEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L53:
            r1[AppFeedCardType.AI_UNREAD_SUMMARY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L39:
            r1[AppFeedCardType.MINUTES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L22:
            b = r1;
        }
    }

    public static final Map<String, Object> a(UIFeedCard r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (UIFeedCardExtraKt.isOnTop(r8) == false) goto L5;
        s5c.a r1 = x1.c;
    L6:
        FeedCard.Type r2 = r8.getType();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = a.a[r2.ordinal()];
        String r4 = BuildConfig.FLAVOR;
        switch(r3) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L16;
        };
    L9:
        s5c.a r5 = q0.d;
    L17:
        s5c.a r6 = j.c.a(r8.getBizId());
        s5c.a r7 = p0.c.a(r8.getId());
        AppFeedCardType r9 = r8.getBizType();
        if (r9 == null) goto L28;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        switch(a.b[r9.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            default: goto L28;
        };
    L22:
        String r0 = "hardware_connection";
    L29:
        g r10 = g.c;
        String r11 = r8.getAppId();
        if (r11 == null) goto L33;
        r4 = r11;
    L33:
        s5c.a r12 = r10.a(r4);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(r1.a, r1.b), TuplesKt.to(r5.a, r5.b), TuplesKt.to(r6.a, r6.b), TuplesKt.to(r7.a, r7.b), TuplesKt.to(r12.a, r12.b), TuplesKt.to("biz_type", r0), TuplesKt.to("app_feed_card_id", r8.getId())});
    L23:
        r0 = "ai_unread_summary";
        goto L29
    L24:
        r0 = "open";
        goto L29
    L25:
        r0 = "doubao";
        goto L29
    L26:
        r0 = "mail";
        goto L29
    L27:
        r0 = "cal";
    L28:
        r0 = BuildConfig.FLAVOR;
        goto L29
    L10:
        r5 = q0.d;
        goto L17
    L11:
        r5 = q0.d;
        goto L17
    L12:
        r5 = q0.f;
        goto L17
    L13:
        r5 = q0.g;
        goto L17
    L14:
        r5 = q0.e;
        goto L17
    L15:
        r5 = q0.c;
        goto L17
    L16:
        r5 = q0.h.a(BuildConfig.FLAVOR);
        goto L17
    L5:
        r1 = x1.d;
        goto L6
    }
}
