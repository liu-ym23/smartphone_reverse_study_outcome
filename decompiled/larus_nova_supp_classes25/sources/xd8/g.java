package xd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel$b;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.c0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import xc8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements td8.c {
    public final td8.d a;
    public final Lazy b;
    public final Lazy c;
    public Set<Integer> d;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r2).getFirst(), (Integer) ((Pair) r1).getFirst());
        }
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public g(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new e());
        this.c = LazyKt.lazy(new f());
        this.d = SetsKt.emptySet();
    }

    @Override // td8.c
    public final List<xc8.b> b(int r28, xc8.b r29, xc8.b r30, List<xc8.b> r31) {
        Intrinsics.checkNotNullParameter(r30, "current");
        Intrinsics.checkNotNullParameter(r31, "input");
        int r12 = 2;
        xc8.b r15 = null;
        boolean r7 = true;
        if (r28 >= 0) goto L144;
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r31.iterator();
    L5:
        int r9 = 1002;
        if (r0.hasNext() == false) goto L19;
        Object r2 = r0.next();
        xc8.b r3 = (xc8.b) r2;
        if (r3.getMessage().getContentType() != 1002) goto L16;
        Map r4 = r3.getMessage().getExt();
        if (r4 == null) goto L12;
        String r5 = (String) r4.get("visible_message_timestamp");
    L14:
        if (Intrinsics.areEqual(r5, "1") == false) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L5;
        r1.add(r2);
        goto L5
    L12:
        r5 = null;
    L16:
        r6 = false;
        goto L17
    L19:
        List<xc8.b> r10 = CollectionsKt.toMutableList(r1);
        wc9.e r16 = this.a.g();
        int r8 = ra9.a.a;
        int r11 = ga9.a.d("insert_visible_message_timestamp_interval", DoraCallStateCode.DOUBAO_MOCK_STOP);
        if (r11 > 0) goto L26;
        c0 r13 = this.a.l();
        if (r13 == null) goto L24;
        r13.a();
    L24:
        return r10;
    L26:
        if (com.larus.bmhome.utils.i.f(r16) == true) goto L28;
    L142:
        return r10;
    L28:
        if (this.a.E8() == true) goto L142;
        c0 r14 = this.a.l();
        if (r14 != null) goto L33;
    L35:
        boolean r17 = false;
    L36:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r10.iterator();
        int r20 = -1;
        int r21 = -1;
        boolean r22 = false;
        int r23 = 0;
    L38:
        if (r19.hasNext() == false) goto L120;
        Object r24 = r19.next();
        int r25 = r23 + 1;
        if (r23 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        xc8.b r26 = (xc8.b) r24;
        Message r27 = r26.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r27) == false) goto L48;
        if (com.larus.bmhome.chat.bean.d.w(r27) == true) goto L48;
    L67:
        boolean r32 = false;
    L68:
        if (r32 == true) goto L70;
    L94:
        boolean r33 = false;
    L95:
        if (r33 == true) goto L109;
        if (r15 != null) goto L98;
    L108:
        ArrayList r34 = r18;
        r11 = r11;
        r26 = r15;
    L119:
        r18 = r34;
        r11 = r11;
        r23 = r25;
        r15 = r26;
        r7 = true;
        r9 = 1002;
        r12 = 2;
        goto L38
    L98:
        if (r26.getMessage().getContentType() != r9) goto L101;
        r22 = true;
        goto L108
    L101:
        if (com.larus.bmhome.chat.bean.d.Y(r26.getMessage()) == true) goto L107;
        Integer r35 = b0.c(r26.getMessage());
        if (r35 == null) goto L108;
        if (r35.intValue() != 3) goto L108;
    L107:
        r21 = r25;
        goto L108
    L109:
        if (r15 != null) goto L111;
    L117:
        r34 = r18;
    L118:
        r20 = r23;
        r21 = -1;
        r22 = false;
        goto L119
    L111:
        if ((r15.getMessage().getCreateTime() - r26.getMessage().getCreateTime()) < r11) goto L117;
        if (r22 == true) goto L117;
        if (r21 >= 0) goto L116;
        r21 = r20 + 1;
    L116:
        r34 = r18;
        r34.add(TuplesKt.to(Integer.valueOf(r21), c(this, r15.getMessage(), r26.getMessage(), false, false, false, true, 28)));
        goto L118
    L70:
        if (r27.getCreateTime() <= 0) goto L94;
        if (b0.f(r27) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.z0(r27) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.O0(r27) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.I0(r27) == true) goto L94;
        CopyOnWriteArraySet r36 = xc8.f.a;
        xc8.g r37 = (xc8.g) xc8.f.d.getValue();
        if (r37 != null) goto L82;
    L84:
        boolean r38 = false;
    L85:
        if (r38 == true) goto L94;
        int r39 = r27.getContentType();
        if (r39 == 0) goto L91;
        if (r39 == r12) goto L91;
        switch(r39) {
            case 1001: goto L91;
            case 1002: goto L91;
            case 1003: goto L91;
            default: goto L90;
        };
    L90:
        boolean r40 = true;
    L92:
        if (r40 == false) goto L94;
        r33 = true;
    L91:
        r40 = false;
        goto L92
    L82:
        if (r37.a(r27) != r7) goto L84;
        r38 = true;
    L48:
        if (com.larus.bmhome.chat.bean.d.T(r27) == true) goto L67;
        if (com.larus.bmhome.chat.bean.d.p0(r27) == true) goto L67;
        if (com.larus.bmhome.chat.bean.d.C0(r27) == true) goto L55;
    L57:
        MessageStatus r41 = r27.getMessageStatus();
        if (r41 != null) goto L60;
    L62:
        boolean r42 = false;
    L63:
        if (r42 == false) goto L65;
    L66:
        r32 = true;
        goto L68
    L65:
        if (b0.f(r27) == false) goto L67;
    L60:
        if (r41.isVisible() != r7) goto L62;
        r42 = true;
        goto L63
    L55:
        if (r27.getRegenVisible() == true) goto L57;
    L120:
        ArrayList r43 = r18;
        int r110 = r11;
        if (this.a.e() == true) goto L125;
        if (r17 == true) goto L125;
        boolean r111 = false;
    L127:
        if (n.D(r16) == true) goto L129;
    L135:
        Iterator r44 = CollectionsKt.sortedWith(r43, new b()).iterator();
    L137:
        if (r44.hasNext() == false) goto L140;
        Pair r45 = (Pair) r44.next();
        ListProtector.add(r10, ((Number) r45.component1()).intValue(), (l) r45.component2());
        goto L137
    L140:
        if ((!r43.isEmpty()) == false) goto L142;
        FLogger.a.i("Pipeline_List_TimeStampDividerTask", "insert visible message timestamps, count=" + r43.size() + ", interval=" + r110 + ", hasReachedVisibleHistoryTop=" + r111);
        goto L142
    L129:
        if (Intrinsics.areEqual(this.a.extraInfo().get("visible_timestamp_search_mode"), Boolean.TRUE) == true) goto L135;
        if (r111 == false) goto L135;
        if (r15 == null) goto L135;
        if (CollectionsKt.lastOrNull(r10) != r15) goto L135;
        r43.add(TuplesKt.to(Integer.valueOf(r10.size()), c(this, r15.getMessage(), r15.getMessage(), false, false, false, true, 28)));
    L125:
        r111 = true;
        goto L127
    L33:
        if (r14.a() != true) goto L35;
        r17 = true;
        goto L36
    L144:
        if (this.a.E8() == false) goto L162;
        if (r29 == null) goto L147;
        Message r46 = r29.getMessage();
    L148:
        Message r112 = r30.getMessage();
        xc8.b r47 = this.a.n();
        if (r47 == null) goto L151;
        Message r48 = r47.getMessage();
    L152:
        boolean r113 = Intrinsics.areEqual(r112, r48);
        if (r46 != null) goto L155;
    L157:
        l r114 = null;
    L158:
        if (r113 == false) goto L160;
        r15 = c(this, r112, r112, false, false, true, false, 36);
    L160:
        FLogger.a.i("Pipeline_List_TimeStampDividerTask", "create service bot timestamp, index=" + r28 + " current=" + r112.getMessageId() + " isOldestCell=" + r113);
        return CollectionsKt.toMutableList(CollectionsKt.listOfNotNull(new xc8.b[]{r114, r30, r15}));
    L155:
        if (this.d.contains(Integer.valueOf(r28 - 1)) == false) goto L157;
        r114 = c(this, r46, r112, false, false, true, false, 36);
        goto L158
    L151:
        r48 = null;
        goto L152
    L147:
        r46 = null;
        goto L148
    L162:
        xc8.b r49 = (xc8.b) CollectionsKt.lastOrNull(r31);
        wc9.e r50 = this.a.g();
        if (r49 == null) goto L165;
        Message r51 = r49.getMessage();
    L166:
        Message r52 = r30.getMessage();
        if (r51 == null) goto L169;
        String r53 = r51.getSectionId();
    L170:
        String r54 = r52.getSectionId();
        if (r28 > 0) goto L173;
    L191:
        boolean r55 = false;
    L192:
        if (r51 == null) goto L201;
        CopyOnWriteArraySet r56 = xc8.f.a;
        xc8.g r57 = (xc8.g) xc8.f.d.getValue();
        if (r57 != null) goto L196;
    L198:
        boolean r58 = false;
    L199:
        if (r58 == false) goto L201;
        boolean r59 = true;
    L202:
        if (r55 == false) goto L230;
        if (r51 == null) goto L230;
        Regex r60 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r51, "<this>");
        String r61 = r51.getMessageId();
        if (r61 != null) goto L207;
    L209:
        boolean r62 = false;
    L210:
        if (r62 == true) goto L230;
        if (r59 == true) goto L230;
        if (com.larus.bmhome.chat.bean.d.O0(r51) == false) goto L216;
    L250:
        if (r15 == null) goto L254;
        return CollectionsKt.mutableListOf(new xc8.b[]{r15, r30});
    L254:
        return CollectionsKt.mutableListOf(new xc8.b[]{r30});
    L216:
        if (com.larus.bmhome.chat.bean.d.x(r51).isClickClearContext() == true) goto L218;
    L222:
        FLogger.a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by section changed, preSectionId = " + r53 + ", currentSectionId = " + r54);
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L225;
    L227:
        boolean r63 = false;
    L228:
        r15 = c(this, r51, r52, false, r63, false, false, 52);
        goto L250
    L225:
        if (com.larus.bmhome.utils.i.f(r50) == true) goto L227;
        r63 = true;
        goto L228
    L218:
        if (com.larus.bmhome.chat.bean.d.G0(r51) == false) goto L222;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r51).getSource(), "onboarding_welcome_back_sug") == true) goto L222;
    L207:
        if (StringsKt.contains$default(r61, "-welcome-back", false, 2, null) != true) goto L209;
        r62 = true;
    L230:
        if (r51 == null) goto L239;
        ChatListComponentViewModel.Companion.getClass();
        if (ChatListComponentViewModel$b.a(r51) == false) goto L239;
        if (ChatListComponentViewModel$b.a(r52) == true) goto L236;
    L237:
        FLogger.a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by positive message, preMessage.createTime = " + r51.getCreateTime() + ", currentMessage.createTime = " + r52.getCreateTime() + ", interval = " + z2.a.positiveMsgSplitTimeInterval());
        r15 = c(this, r51, r52, true, false, false, false, 56);
        goto L250
    L236:
        if ((r51.getCreateTime() - r52.getCreateTime()) > z2.a.positiveMsgSplitTimeInterval()) goto L237;
    L239:
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L241;
    L243:
        boolean r64 = false;
    L244:
        if (r64 == false) goto L250;
        if (r51 == null) goto L250;
        if ((r51.getCreateTime() - r52.getCreateTime()) <= ((Number) this.c.getValue()).intValue()) goto L250;
        if (r59 == true) goto L250;
        FLogger.a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by show ugc timestamp, preMessage.createTime = " + r51.getCreateTime() + ", currentMessage.createTime = " + r52.getCreateTime() + ", interval = " + ((Number) this.c.getValue()).intValue());
        r15 = c(this, r51, r52, false, false, false, false, 60);
        goto L250
    L241:
        if (com.larus.bmhome.utils.i.f(r50) == true) goto L243;
        r64 = true;
        goto L244
    L196:
        if (r57.a(r51) != true) goto L198;
        r58 = true;
    L201:
        r59 = false;
        goto L202
    L173:
        if (Intrinsics.areEqual(r54, r53) == true) goto L191;
        if (r54 != null) goto L176;
    L179:
        boolean r65 = true;
    L180:
        if (r65 == true) goto L191;
        if (r53 != null) goto L183;
    L186:
        boolean r66 = true;
    L187:
        if (r66 == true) goto L191;
        if (b0.f(r51) == true) goto L191;
        r55 = true;
        goto L192
    L183:
        if (r53.length() == 0) goto L186;
        r66 = false;
        goto L187
    L176:
        if (r54.length() == 0) goto L179;
        r65 = false;
        goto L180
    L169:
        r53 = null;
        goto L170
    L165:
        r51 = null;
        goto L166
    }

    public static l c(g r56, Message r57, Message r58, boolean r59, boolean r60, boolean r61, boolean r62, int r63) {
        if ((r63 & 4) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r63 & 8) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r63 & 16) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r63 & 32) == 0) goto L17;
        boolean r4 = false;
    L18:
        r56.getClass();
        String r5 = r57.getLocalMessageId();
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L26:
        if (r6 == true) goto L28;
        String r7 = "local:" + r57.getLocalMessageId();
    L38:
        String r9 = r58.getLocalMessageId();
        String r10 = null;
        if (r9 != null) goto L41;
    L45:
        r9 = r58.getMessageId();
        if (r9 != null) goto L48;
    L50:
        r9 = null;
    L51:
        if (r9 != null) goto L54;
        r9 = "index:" + r58.getLocalIndex() + ':' + r58.getCreateTime();
    L54:
        if (r4 == false) goto L57;
        String r8 = "visible_timestamp:" + r57.getConversationId() + ':' + r7;
    L56:
        String r27 = r8;
        if (r4 == false) goto L63;
        String r26 = r27;
    L64:
        Pair[] r11 = new Pair[1];
        if (r0 == false) goto L67;
        String r1 = "1";
    L68:
        r11[0] = TuplesKt.to("show_time_line", r1);
        Map r12 = MapsKt.mutableMapOf(r11);
        if (r4 == false) goto L71;
        r12.put("visible_message_timestamp", "1");
    L71:
        String r13 = r58.getConversationId();
        if (r2 == false) goto L74;
        String r21 = AppHost.a.getApplication().getString(2131907414);
    L75:
        long r48 = r57.getCreateTime();
        if (r4 == false) goto L78;
        long r14 = r57.getLocalIndex();
    L79:
        long r28 = r14;
        String r33 = r57.getSectionId();
        if (r3 == true) goto L85;
        if (r4 == true) goto L85;
        r10 = r57.getSectionName();
    L85:
        return new l(b0.j(new Message(r13, null, null, 0, 21, null, 1002, false, null, r21, null, null, null, r12, r26, r27, r28, 0, false, r33, r10, null, null, null, null, 0, false, 0, null, null, false, null, null, r48, null, null, null, -1696338, 29, null), 3));
    L78:
        r14 = r58.getLocalIndex() + 1;
        goto L79
    L74:
        r21 = null;
        goto L75
    L67:
        r1 = "0";
        goto L68
    L63:
        r26 = r9 + "-time-stamp";
        goto L64
    L57:
        String r15 = r58.getMessageId();
        if (r15 != null) goto L60;
        r15 = "";
    L60:
        r8 = r15.concat("-time-stamp");
        goto L56
    L48:
        if ((!StringsKt.isBlank(r9)) == false) goto L50;
    L41:
        if ((!StringsKt.isBlank(r9)) == true) goto L44;
        r9 = null;
    L44:
        if (r9 != null) goto L54;
    L28:
        String r16 = r57.getMessageId();
        if (r16 != null) goto L31;
    L34:
        boolean r17 = true;
    L35:
        if (r17 == true) goto L37;
        r7 = "message:" + r57.getMessageId();
        goto L38
    L37:
        r7 = "index:" + r57.getLocalIndex() + ':' + r57.getCreateTime();
        goto L38
    L31:
        if (StringsKt.isBlank(r16) == true) goto L34;
        r17 = false;
        goto L35
    L21:
        if (StringsKt.isBlank(r5) == true) goto L24;
        r6 = false;
        goto L26
    L17:
        r4 = r62;
        goto L18
    L13:
        r3 = r61;
        goto L15
    L9:
        r2 = r60;
        goto L11
    L5:
        r0 = r59;
        goto L7
    }
}
