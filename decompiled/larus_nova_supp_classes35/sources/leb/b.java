package leb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.core.storage.CoreStorage;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.utils.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.suite.lark.platform.component.storage.file.dirs.h;
import iec.g;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b<T> {
    public final com.ss.android.lark.feed.shared.data.utils.a a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SystemMessageType.values().length];
            b = r0;
            r0[SystemMessageType.VC_MEETING_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            b[SystemMessageType.VC_MEETING_ENDED_OVER_ONE_HOUR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L30:
            b[SystemMessageType.VC_MEETING_ENDED_LESS_ONE_HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L44:
            b[SystemMessageType.VC_MEETING_ENDED_LESS_ONE_MINUTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L28:
            b[SystemMessageType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L32:
            b[SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L36:
            b[SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L38:
            b[SystemMessageType.VIDEO_MEETING_CHAT_ROOM_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r2 = new int[FeedPreviewInfo.VideoChatContentType.values().length];
            a = r2;
            r2[FeedPreviewInfo.VideoChatContentType.CHAT_ROOM_CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L34:
            a[FeedPreviewInfo.VideoChatContentType.MEETING_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    /* JADX INFO: renamed from: leb.b$b, reason: collision with other inner class name */
    public static class C0252b {
        public static final C0252b a = null;

        static {
            a = new C0252b();
        }

        public C0252b() {
            peb.b r0 = heb.a.a;
            r0.getAccountDependency().a();
            r0.getPushDependency().a();
        }
    }

    public abstract void d(FeedPreview r1, FeedPreviewInfo r2);

    public abstract T e(FeedPreviewInfo r1);

    public b() {
        this.a = new com.ss.android.lark.feed.shared.data.utils.a();
    }

    public static void b(FeedPreview r2) {
        if (TextUtils.isEmpty(r2.getDraftMessage()) == true) goto L6;
        TextProperty r0 = new TextProperty(r2.getDraftMessage());
        ArrayList<DigestElement> r1 = new ArrayList();
        r1.add(r0);
        r2.setDraftDigestMessage(r1);
        return;
    }

    public static String g(String r6) {
        LinkedList r1 = new LinkedList(EmojiHandler.b(r6));
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= 80) goto L12;
        Pair r4 = (Pair) r1.peekFirst();
        if (r4 == null) goto L10;
        if (r3 != ((Integer) r4.getFirst()).intValue()) goto L10;
        r3 = ((Integer) r4.getSecond()).intValue();
        r1.pollFirst();
    L10:
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L4
    L12:
        return r6.substring(0, Math.min(r3, r6.length()));
    }

    public static String h(String r2) {
        if (TextUtils.isEmpty(null) == true) goto L5;
        throw null;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return r2;
    L8:
        return r2.substring(r2.length() - 1);
    }

    public static RichText c(String r7, CloudDraftContent r8) {
        boolean r0 = false;
        if (r7 == null) goto L13;
        int r2 = r7.length();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        int r4 = r7.codePointAt(r3);
        if (Character.isWhitespace(r4) == false) goto L8;
        r3 = r3 + Character.charCount(r4);
        goto L5
    L8:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L13;
    L15:
        return heb.a.a.getResourceDependency().b(r7);
    L10:
        r5 = true;
    L13:
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.chat.reset.sync") == false) goto L15;
        if (r8 != null) goto L19;
        return null;
    L19:
        String r6 = r8.title;
        if (r6 == null) goto L30;
        int r9 = r6.length();
        int r10 = 0;
    L22:
        if (r10 >= r9) goto L27;
        int r11 = r6.codePointAt(r10);
        if (Character.isWhitespace(r11) == false) goto L28;
        r10 = r10 + Character.charCount(r11);
    L28:
        if (r0 == true) goto L30;
        return com.ss.android.lark.widget.richtext.c.c(r8.title);
    L27:
        r0 = true;
    L30:
        com.bytedance.lark.pb.basic.v1.RichText r12 = r8.rich_text;
        if (r12 != null) goto L33;
        return null;
    L33:
        return g0.e(r12, null);
    }

    public final void a(FeedPreview r7, FeedPreviewInfo r8) {
        Digest r0 = r8.p0;
        if (r0 != null) goto L5;
    L6:
        Log.i("FeedSharedModule_BasePacker", "buildDigestMessage, digestMessage is invalid. feedId = " + r7.getId());
    L7:
        r7.setOriginDigest(r8.p0);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "feedPreview");
        ArrayList<DigestElement> r1 = null;
        if (r8.p0 == null) goto L53;
        ArrayList<DigestElement> r2 = new ArrayList();
        Digest r9 = r8.p0;
        if (r9 == null) goto L46;
        List r10 = r9.elements;
        if (r10 == null) goto L46;
        ArrayList r3 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L47;
        Digest.Element r4 = (Digest.Element) r11.next();
        Digest.Element.Tag r5 = r4.tag;
        if (r5 != null) goto L20;
        int r6 = -1;
    L22:
        if (r6 != 1) goto L24;
        Digest.Element.TextProperty r12 = r4.text;
        if (r12 == null) goto L43;
        String r13 = r12.content;
        if (r13 == null) goto L43;
        y28.b r14 = new TextProperty(r13);
    L44:
        if (r14 == null) goto L16;
        r3.add(r14);
    L43:
        r14 = null;
        goto L44
    L24:
        if (r6 != 2) goto L26;
        Digest.Element.EmojiProperty r15 = r4.emoji;
        if (r15 == null) goto L43;
        String r16 = r15.emoji_key;
        if (r16 == null) goto L43;
        r14 = new EmojiProperty(r16, r15.default_content);
        goto L44
    L26:
        if (r6 != 3) goto L43;
        Digest.Element.TextProperty r17 = r4.text;
        if (r17 == null) goto L43;
        String r18 = r17.content;
        if (r18 == null) goto L43;
        r14 = new TextWithEmojiProperty(r18);
        goto L44
    L20:
        r6 = k.a[r5.ordinal()];
    L47:
        if (r3 == null) goto L53;
        Iterator<T> r19 = r3.iterator();
    L50:
        if (r19.hasNext() == false) goto L52;
        r2.add((DigestElement) r19.next());
        goto L50
    L52:
        r1 = r2;
    L46:
        r3 = null;
    L53:
        r7.setDigestMessage(r1);
        return;
    L5:
        if (CollectionUtils.isEmpty(r0.elements) == false) goto L7;
        goto L6
    }

    public final void f(FeedPreview r18, FeedPreviewInfo r19) {
        FeedPreview r1 = r18;
        r1.setId(r19.a);
        r1.setFeedType(r19.e);
        r1.setType(r19.d);
        r1.setUid(r19.b);
        r1.setCheckUser(r19.c);
        r1.setDisplayTime(r19.k * 1000);
        if ((r1 instanceof ChatFeedPreview) == false) goto L5;
        ChatFeedPreview r0 = (ChatFeedPreview) r1;
        r0.setChatType(r19.G);
        r0.setLastMessageType(r19.v);
    L5:
        r1.setUpdateTime(r19.m);
        r1.setRankTime(r19.l);
        r1.setName(r19.g);
        if (TextUtils.isEmpty(r19.f) == true) goto L8;
    L63:
        String r2 = r19.f;
    L64:
        r1 = r18;
    L65:
        r1.setAvatarKey(r2);
        r1.setAvatarId(r19.a());
        r1.setUnreadCount(r19.i);
        r1.setRemind(r19.j);
        r1.setLastMessageId(r19.T1);
        r1.setShortCut(r19.o);
        FeedPreviewInfo.EntityStatus r3 = r19.t;
        if (r3 != FeedPreviewInfo.EntityStatus.UNREAD) goto L71;
        if (r19.G != Chat.Type.P2P) goto L71;
        MutexMarkType r4 = MutexMarkType.UNREAD;
    L172:
        r1.setMutexMarkType(r4);
        if (com.ss.android.lark.feed.shared.fg.b.a == true) goto L184;
        Object r5 = com.ss.android.lark.feed.shared.fg.b.c;
        monitor-enter(r5);
    L313:
        th = move-exception;
        throw th;
    L178:
        if (com.ss.android.lark.feed.shared.fg.b.a == false) goto L181;
        monitor-exit(r5);     // Catch: Throwable -> L313
    L321:
        goto L184
    L181:
        peb.b.InterfaceC0277b r6 = heb.a.a.getAppConfigDependency();     // Catch: Throwable -> L313
        r6.c();     // Catch: Throwable -> L313
        r6.a();     // Catch: Throwable -> L313
        r6.a();     // Catch: Throwable -> L313
        com.ss.android.lark.feed.shared.fg.b.b = false;     // Catch: Throwable -> L313
        r6.a();     // Catch: Throwable -> L313
        r6.a();     // Catch: Throwable -> L313
        com.ss.android.lark.feed.shared.fg.b.a = true;     // Catch: Throwable -> L313
        monitor-exit(r5);     // Catch: Throwable -> L313
    L184:
        if (com.ss.android.lark.feed.shared.fg.b.b == false) goto L262;
        oeb.d r7 = (oeb.d) e0c.k.a(LarkContext.getApplication(), oeb.d.class);
        int r8 = f.a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        peb.b.f r9 = com.ss.android.lark.feed.shared.fg.c.a;
        if (r9.isEnable("im.message.stranger") == false) goto L188;
        boolean r10 = false;
    L189:
        if (r10 == true) goto L202;
        if (r9.isEnable("im.message.stranger") == true) goto L202;
        List r11 = r19.O;
        if (r11 != null) goto L195;
    L198:
        boolean r12 = true;
    L199:
        if (r12 == false) goto L258;
    L259:
        boolean r13 = false;
    L260:
        if (r13 == false) goto L262;
        int r14 = UIFeedCard.MarkType.URGENT.getNumber() | 0;
    L263:
        FeedPreviewInfo.AtInfo r15 = r19.p;
        if (r15 == null) goto L273;
        FeedPreviewInfo.AtInfo.AtType r16 = r15.b;
        if (r16 != FeedPreviewInfo.AtInfo.AtType.ALL) goto L269;
        int r17 = UIFeedCard.MarkType.AT_ALL.getNumber();
    L271:
        r14 = r14 | r17;
    L272:
        UIFeedCard.AtInfo r20 = new UIFeedCard.AtInfo(r15.a, r15.e, r15.c);
        r20.setAtDisplayTime(r15.g);
        r20.setAtRankTime(r15.f);
        r20.setAtContent(r15.h);
        r20.setAtType(AtInfo.AtType.fromValue(r15.b.getValue()));
        r1.setAtInfo(r20);
        goto L273
    L269:
        if (r16 != FeedPreviewInfo.AtInfo.AtType.USER) goto L272;
        r17 = UIFeedCard.MarkType.AT_USER.getNumber();
    L273:
        r1.setMuteUrgentInfo(r19.r);
        r1.setAtInfoCount(r19.q);
        r1.setMarkType(r14);
        r1.setUrgentInfos(new ArrayList(r19.O));
        r1.setStranger(r19.E2);
        r1.setBlocked(r19.F2);
        r1.setCanSetStranger(r19.G2);
        r1.setDelayed(r19.z);
        r1.setFlag(r19.A);
        r1.setParentCardId(r19.P1);
        r1.setOfflineOncall(r19.U);
        r1.setLastMessagePosition(r19.u);
        r1.setTranslateEmojiCode(false);
        FeedPreviewInfo.a r21 = r19.s;
        if (r21 != null) goto L276;
    L275:
        String r22 = null;
    L292:
        r1.setDraftMessage(r22);
        r1.setCrossTenant(r19.L0);
        C0252b.a.getClass();
        r1.setSimpleTenant(false);
        r1.setCustomer(false);
        if (CollectionUtils.isEmpty(r19.P0) == true) goto L304;
        Iterator r23 = r19.P0.iterator();
        int r24 = 0;
    L297:
        if (r23.hasNext() == false) goto L299;
        r24 = r24 + ((Reaction) r23.next()).getCount();
        goto L297
    L299:
        r1.setReactions(r19.P0);
        r1.setReactionCount(r24);
        if (r19.G != Chat.Type.P2P) goto L302;
        int r25 = -1;
    L303:
        r1.setReactionDisplayCount(r25);
        goto L304
    L302:
        r25 = 3;
    L304:
        d(r18, r19);
        r1.setCustomStatusIconKey(r19.h2);
        r1.setTagData(r19.X);
        if (r19.L2 == true) goto L308;
        long r26 = r19.K2;
    L311:
        r1.setOnTopRankTime(r26);
        r1.setIsPriorityProcessing(r19.L2);
        r1.setFeedCardButtons(beb.b.b(r19.P2));
        r1.setIsFake(r19.M2);
        r1.setMuteNoticeType(AutoMuteSettingNoticeType.valueOf(Integer.valueOf(r19.S2.getNumber())));
        r1.setRedBadge(r19.T2);
        return;
    L308:
        if (com.ss.android.lark.feed.shared.fg.c.a() == false) goto L310;
        r26 = r19.K2;
        goto L311
    L310:
        r26 = 0;
        goto L311
    L276:
        String r27 = r21.a;
        CloudDraftContent r28 = r21.b;
        DraftAttachmentSnapshot r29 = r21.c;
        if (r29 == null) goto L283;
        List r30 = r29.attachments;
        if (r30 == null) goto L283;
        if (r30.isEmpty() == true) goto L283;
        boolean r31 = true;
    L285:
        if (r19.K == false) goto L318;
        r22 = r27;
        goto L292
    L318:
        RichText r32 = c(r27, r28);     // Catch: Exception -> L290
        g.a r33 = new g.a();     // Catch: Exception -> L290
        iec.a r34 = r33.e;     // Catch: Exception -> L290
        r34.b = true;     // Catch: Exception -> L290
        r34.a = true;     // Catch: Exception -> L290
        r33.d.a = false;     // Catch: Exception -> L290
        r33.c = r31;     // Catch: Exception -> L290
        r22 = g(i.d(r32, r33.a()).toString());     // Catch: Exception -> L290
        if (TextUtils.isEmpty(r22) == false) goto L292;
    L290:
        e = move-exception;
        Log.e("FeedSharedModule_BasePacker", "buildDraftMessage" + e.getMessage());
    L283:
        r31 = false;
    L258:
        r13 = true;
        goto L260
    L195:
        if (r11.isEmpty() == true) goto L198;
        r12 = false;
    L202:
        if (r9.isEnable("im.message.stranger") == false) goto L204;
        boolean r35 = false;
    L206:
        if (r35 == false) goto L231;
        Log.i("UrgentMarkTypeJudge", "feedId =" + r19.a + " chatReadable = " + r19.y2 + ", urgentInfos = " + r19.O);
        if (r19.y2 != 2) goto L222;
        List r36 = r19.O;
        if (r36 == null) goto L259;
        List r37 = r36;
        if ((r37 instanceof Collection) == true) goto L214;
    L216:
        Iterator<T> r38 = r37.iterator();
    L218:
        if (r38.hasNext() == false) goto L259;
        if ((!((UrgentInfo) r38.next()).isClosed()) == false) goto L218;
    L214:
        if (r37.isEmpty() == false) goto L216;
    L222:
        List r39 = r19.O;
        if (r39 != null) goto L225;
    L228:
        boolean r40 = true;
    L229:
        if (r40 == true) goto L259;
    L225:
        if (r39.isEmpty() == true) goto L228;
        r40 = false;
        goto L229
    L231:
        if (r7 == null) goto L233;
        boolean r41 = r7.get();
    L234:
        Log.i("UrgentMarkTypeJudge", "feedId =" + r19.a + " isStranger = " + r19.E2 + ", urgentInfos = " + r19.O + ", setting_on = " + r41);
        if (r19.E2 == false) goto L250;
        if (r41 == false) goto L250;
        List r42 = r19.O;
        if (r42 == null) goto L259;
        List r43 = r42;
        if ((r43 instanceof Collection) == true) goto L242;
    L244:
        Iterator<T> r44 = r43.iterator();
    L246:
        if (r44.hasNext() == false) goto L259;
        if ((!((UrgentInfo) r44.next()).isClosed()) == false) goto L246;
    L242:
        if (r43.isEmpty() == false) goto L244;
    L250:
        List r45 = r19.O;
        if (r45 != null) goto L253;
    L256:
        boolean r46 = true;
    L257:
        if (r46 == true) goto L259;
    L253:
        if (r45.isEmpty() == true) goto L256;
        r46 = false;
        goto L257
    L233:
        r41 = false;
        goto L234
    L204:
        r35 = r9.isEnable("im.message.strangerchat");
        goto L206
    L188:
        r10 = r9.isEnable("im.message.strangerchat");
    L262:
        r14 = 0;
    L71:
        if (r3 != FeedPreviewInfo.EntityStatus.PENDING) goto L74;
        r4 = MutexMarkType.SENDING;
        goto L172
    L74:
        if (r3 != FeedPreviewInfo.EntityStatus.FAILED) goto L76;
        r4 = MutexMarkType.FAILED;
        goto L172
    L76:
        Message.Type r47 = r19.v;
        Message.Type r48 = Message.Type.VIDEO_CHAT;
        if (r47 != r48) goto L84;
        FeedPreviewInfo.VideoChatContentType r49 = r19.y;
        if (r49 != FeedPreviewInfo.VideoChatContentType.MEETING_CARD) goto L81;
    L127:
        boolean r50 = true;
    L128:
        if (r50 == false) goto L151;
        if (r19.S1 == false) goto L132;
        r4 = MutexMarkType.VOICE_CALL;
        goto L172
    L132:
        if (r47 != r48) goto L140;
        int r51 = a.a[r19.y.ordinal()];
        if (r51 == 1) goto L138;
        if (r51 != 2) goto L151;
        r4 = MutexMarkType.VIDEO_MEETING;
        goto L172
    L138:
        r4 = MutexMarkType.CHAT_ROOM_CARD;
        goto L172
    L140:
        switch(a.b[r19.w.ordinal()]) {
            case 1: goto L149;
            case 2: goto L148;
            case 3: goto L147;
            case 4: goto L146;
            case 5: goto L145;
            case 6: goto L144;
            case 7: goto L143;
            case 8: goto L142;
            default: goto L141;
        };
    L141:
        r4 = MutexMarkType.VIDEO_MEETING;
        goto L172
    L142:
        r4 = MutexMarkType.CHAT_ROOM_START_MESSAGE;
        goto L172
    L143:
        r4 = MutexMarkType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN;
        goto L172
    L144:
        r4 = MutexMarkType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR;
        goto L172
    L145:
        r4 = MutexMarkType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR;
        goto L172
    L146:
        r4 = MutexMarkType.VC_MEETING_ENDED_LESS_ONE_MINUTE;
        goto L172
    L147:
        r4 = MutexMarkType.VC_MEETING_ENDED_LESS_ONE_HOUR;
        goto L172
    L148:
        r4 = MutexMarkType.VC_MEETING_ENDED_OVER_ONE_HOUR;
        goto L172
    L149:
        r4 = MutexMarkType.VC_MEETING_STARTED;
    L151:
        if (r19.v != Message.Type.SYSTEM) goto L164;
        SystemMessageType r52 = r19.w;
        if (r52 != SystemMessageType.USER_CALL_E2EE_VOICE_DURATION) goto L156;
    L165:
        boolean r53 = true;
    L166:
        if (r53 == false) goto L169;
        r4 = MutexMarkType.ENCRYPTED_CALL;
        goto L172
    L169:
        if (r19.t != FeedPreviewInfo.EntityStatus.READ) goto L171;
        r4 = MutexMarkType.READ;
        goto L172
    L171:
        r4 = MutexMarkType.UNKNOWN;
        goto L172
    L156:
        if (r52 == SystemMessageType.USER_CALL_E2EE_VOICE_WHEN_REFUSED) goto L165;
        if (r52 == SystemMessageType.USER_CALL_E2EE_VOICE_ON_CANCELL) goto L165;
        if (r52 == SystemMessageType.USER_CALL_E2EE_VOICE_ON_MISSING) goto L165;
        if (r52 == SystemMessageType.USER_CALL_E2EE_VOICE_WHEN_OCCUPY) goto L165;
    L164:
        r53 = false;
        goto L166
    L81:
        if (r49 == FeedPreviewInfo.VideoChatContentType.CHAT_ROOM_CARD) goto L127;
    L84:
        if (r47 != Message.Type.SYSTEM) goto L86;
    L88:
        SystemMessageType r54 = r19.w;
        if (r54 == SystemMessageType.VC_CALL_HOST_CANCEL) goto L127;
        if (r54 == SystemMessageType.VC_CALL_PARTI_NO_ANSWER) goto L127;
        if (r54 == SystemMessageType.VC_CALL_PARTI_CANCEL) goto L127;
        if (r54 == SystemMessageType.VC_CALL_HOST_BUSY) goto L127;
        if (r54 == SystemMessageType.VC_CALL_PARTI_BUSY) goto L127;
        if (r54 == SystemMessageType.VC_CALL_FINISH_NOTICE) goto L127;
        if (r54 == SystemMessageType.VC_CALL_DURATION) goto L127;
        if (r54 == SystemMessageType.VC_CALL_CONNECT_FAIL) goto L127;
        if (r54 == SystemMessageType.VC_CALL_DISCONNECT) goto L127;
        if (r54 == SystemMessageType.VC_MEETING_STARTED) goto L127;
        if (r54 == SystemMessageType.VC_MEETING_ENDED_OVER_ONE_HOUR) goto L127;
        if (r54 == SystemMessageType.VC_MEETING_ENDED_LESS_ONE_HOUR) goto L127;
        if (r54 == SystemMessageType.VC_MEETING_ENDED_LESS_ONE_MINUTE) goto L127;
        if (r54 == SystemMessageType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR) goto L127;
        if (r54 == SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR) goto L127;
        if (r54 == SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN) goto L127;
        if (r54 == SystemMessageType.VIDEO_MEETING_CHAT_ROOM_START) goto L127;
        if (r19.x == FeedPreviewInfo.CardContentType.VCHAT) goto L127;
    L126:
        r50 = false;
        goto L128
    L86:
        if (r47 == Message.Type.CARD) goto L88;
    L8:
        if (r19.d != FeedCard.Type.CHAT) goto L63;
        long r55 = System.currentTimeMillis();
        peb.b r56 = heb.a.a;
        Context r110 = r56.getApplictaionContext();
        if (r19.G != Chat.Type.GROUP) goto L14;
        r2 = UIHelper.getString(2131891797);
    L40:
        if (TextUtils.isEmpty(r2) == true) goto L65;
        int r111 = h.c;
        h r112 = h.a.a(r110);
        r112.c(CoreStorage.a());
        leb.a r113 = new leb.a();
        Intrinsics.checkNotNullParameter(r113, "pathProvider");
        h.b r114 = r112.a(r113);
        r114.b(r2 + ".jpg");
        VFSPath r115 = r114.a();
        if (CoreStorage.a().exists(r115) == true) goto L62;
        int r116 = UIUtils.dp2px(r110, 100.0f);
        int r117 = UIUtils.dp2px(r110, 100.0f);
        int r57 = gkc.b.a[new Random().nextInt(10)].intValue();
        Bitmap r118 = Bitmap.createBitmap(r116, r116, Bitmap.Config.ARGB_8888);
        Canvas r119 = new Canvas(r118);
        RectF r58 = new RectF(0.0f, 0.0f, r119.getWidth(), r119.getHeight());
        Paint r59 = new Paint(257);
        r59.setColor(-1);
        r119.drawOval(r58, r59);
        r59.setColor(r57);
        float r60 = r117;
        r119.drawRect(new RectF(r60, r60, r58.width() - r60, r58.height() - r60), r59);
        r59.setColor(-1);
        r59.setStrokeWidth(3.0f);
        r59.setTextSize(r116 * 0.5f);
        r59.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r61 = r59.getFontMetricsInt();
        r119.drawText(r2, r58.centerX(), (((r58.bottom + r58.top) - r61.bottom) - r61.top) / 2.0f, r59);
        VFSFile r62 = new VFSFile(r115);
        if (r62.exists() == true) goto L62;
        r62.createNewFile();     // Catch: Throwable -> L51 Exception -> L53
        OutputStream r63 = CoreStorage.a().E(r62);     // Catch: Throwable -> L51 Exception -> L53
        r118.compress(Bitmap.CompressFormat.JPEG, 80, r63);     // Catch: Exception -> L49 Throwable -> L57
        r63.flush();     // Catch: Exception -> L49 Throwable -> L57
        r63.close();     // Catch: Exception -> L49 Throwable -> L57
        com.larksuite.framework.utils.d.b(new Closeable[]{r63});
    L49:
        e = e;
    L55:
        Log.e("FeedSharedModule_BasePacker", "buildAvatarKey avatarKey failed" + e.getCause() + "   " + e.getMessage());     // Catch: Throwable -> L57
        com.larksuite.framework.utils.d.b(new Closeable[]{r63});
    L57:
        th = th;
        OutputStream r64 = r63;
        int r65 = 1;
    L59:
        Closeable[] r66 = new Closeable[r65];
        r66[0] = r64;
        com.larksuite.framework.utils.d.b(r66);
        throw th;
    L53:
        e = e;
        r63 = null;
    L51:
        th = th;
        r65 = 1;
        r64 = null;
    L62:
        Log.w("FeedSharedModule_BasePacker", "buildAvatarKey avatarKey is empty; id= " + r19.a + "filePath = " + r115.getRealPath() + " build cost = " + (System.currentTimeMillis() - r55));
        r2 = r115.getRealPath();
        goto L64
    L14:
        if (r19.I != Chatter.ChatterType.USER) goto L38;
        String r120 = r19.g;
        Locale r67 = r56.getSettingDependency().getCacheLanguageSetting();
        if (r67 != null) goto L18;
    L21:
        String r68 = Locale.CHINESE.getLanguage();
    L23:
        if (r68.equals(Locale.CHINESE.getLanguage()) == false) goto L29;
        if (TextUtils.isEmpty(r120) == true) goto L35;
        r2 = r120.substring(r120.length() - 1);
    L35:
        r2 = r120;
        goto L40
    L29:
        if (r68.equals(Locale.ENGLISH.getLanguage()) == false) goto L32;
        r2 = h(r120);
        goto L40
    L32:
        if (r68.equals(Locale.JAPANESE.getLanguage()) == true) goto L34;
        r2 = h(r120);
        goto L40
    L34:
        if (TextUtils.isEmpty(r120) == true) goto L35;
        r2 = r120.substring(r120.length() - 1);
        goto L40
    L18:
        if (TextUtils.isEmpty(r67.getLanguage()) == true) goto L21;
        r68 = r67.getLanguage();
        goto L23
    L38:
        r2 = r19.g;
        goto L40
    }
}
