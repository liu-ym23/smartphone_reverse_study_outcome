package com.larus.bmhome.chat.trace.container;

import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.api.t;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.appreciable.z;
import com.larus.bmhome.chat.trace.r;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements t {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void j() {
        c.a r0 = c.a;
        if (r0 != null) goto L5;
    L7:
        d.a r1 = d.a;
        if (r1 != null) goto L10;
    L12:
        RenderExceptionTrace r2 = RenderExceptionTrace.a;
        RenderExceptionTrace.e = SystemClock.elapsedRealtime();
        return;
    L10:
        if (r1.b <= 0) goto L12;
        SystemClock.elapsedRealtime();
        goto L12
    L5:
        if (r0.e <= 0) goto L7;
        r0.f = SystemClock.elapsedRealtime();
        FLogger.a.d("EndToEndRenderTrace", "onEndCreateCell()");
        goto L7
    }

    public static void k() {
        d.a r0 = d.a;
        if (r0 == null) goto L12;
        FLogger.a.d("FirstScreenRenderTrace", "onFirstScreenOver()");
        if (r0.a <= 0) goto L13;
        r0.f = SystemClock.elapsedRealtime();
        if (r0.j() > 0) goto L9;
    L10:
        r0.y();
        d.a = null;
        return;
    L9:
        if ((((long) r0.j()) - r0.h) <= 0) goto L10;
        return;
    L13:
        return;
    }

    public static void q() {
        c.a r0 = c.a;
        if (r0 != null) goto L5;
    L9:
        d.a r1 = d.a;
        if (r1 != null) goto L12;
    L16:
        RenderExceptionTrace r2 = RenderExceptionTrace.a;
        RenderExceptionTrace.d = SystemClock.elapsedRealtime();
        return;
    L12:
        if (r1.a <= 0) goto L16;
        r1.b = SystemClock.elapsedRealtime();
        if (r1.g() != null) goto L16;
        r1.n(Long.valueOf(r1.b - r1.a));
        goto L16
    L5:
        if (r0.h() == null) goto L9;
        if (r0.c <= 0) goto L9;
        r0.e = SystemClock.elapsedRealtime();
        FLogger.a.d("EndToEndRenderTrace", "onStartCreateCell()");
        goto L9
    }

    public static void l(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        d.a r1 = d.a;
        Intrinsics.checkNotNullParameter(r3, "msgId");
        if (d.a == null) goto L6;
        FLogger.a.d("FirstScreenRenderTrace", "onMessageGetOffScreen(), messageId: " + r3);
        d.a = null;
        return;
    }

    public static void m(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        c.a r1 = c.a;
        Intrinsics.checkNotNullParameter(r6, "msg");
        c.a r0 = c.a;
        if (r0 == null) goto L49;
        String r2 = r0.h();
        String r3 = r6.getReplyId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        if (Intrinsics.areEqual(r2, r3) == false) goto L50;
        r0.d = SystemClock.elapsedRealtime();
        r0.p(r6.getMessageId());
        r0.i(Integer.valueOf(r6.getContentType()));
        Integer r4 = r0.e();
        boolean r5 = false;
        if (r4 != null) goto L13;
    L15:
        if (r4 != null) goto L18;
    L19:
        if (r4 != null) goto L22;
    L24:
        r0.o(0);
    L35:
        Map r7 = r6.getExt();
        if (r7 == null) goto L38;
        String r8 = (String) r7.get("tea_tags_time_cost");
    L39:
        if (r8 != null) goto L41;
    L42:
        r5 = true;
    L44:
        if (r5 == false) goto L46;
        Map<String, String> r9 = new LinkedHashMap();
    L47:
        r0.k = r9;
        FLogger.a.d("EndToEndRenderTrace", "onReceiveFirstToken(), sendMsgId: " + r0.h() + ", contentType: " + r0.e() + ", lynxCardType = " + r0.f());
        return;
    L46:
        r9 = z.a(r8, "EndToEndRenderTrace");
        goto L47
    L41:
        if (r8.length() != 0) goto L44;
    L38:
        r8 = null;
        goto L39
    L22:
        if (r4.intValue() != 9999) goto L24;
    L25:
        List r10 = com.larus.bmhome.chat.bean.d.K(r6);
        if (r10 != null) goto L28;
    L31:
        boolean r11 = true;
    L32:
        if (r11 == true) goto L34;
        r0.o(2);
        r0.m(r10.toString());
        goto L35
    L34:
        r0.o(0);
        goto L35
    L28:
        if (((ArrayList) r10).isEmpty() == true) goto L31;
        r11 = false;
        goto L32
    L18:
        if (r4.intValue() == 1) goto L25;
    L13:
        if (r4.intValue() != 100) goto L15;
        r0.o(1);
        goto L35
    L50:
        return;
    }

    public final long c(MessageMonitorItemType r3) {
        Intrinsics.checkNotNullParameter(r3, "monitorItem");
        RenderExceptionTrace r0 = RenderExceptionTrace.a;
        return RenderExceptionTrace.f(r3);
    }

    public final boolean d(MessageMonitorItemType r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorItem");
        RenderExceptionTrace r0 = RenderExceptionTrace.a;
        return RenderExceptionTrace.g(r2);
    }

    public static void i(xc8.b r11, Message r12) {
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r12, "msg");
        c.a r2 = c.a;
        Intrinsics.checkNotNullParameter(r12, "msg");
        c.a r3 = c.a;
        Long r4 = null;
        if (r3 != null) goto L5;
    L22:
        d.a r5 = d.a;
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r12, "msg");
        d.a r0 = d.a;
        if (r0 != null) goto L25;
    L67:
        RenderExceptionTrace r13 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r12, "msg");
        RenderExceptionTrace.a r14 = RenderExceptionTrace.b.get(r12.getMessageId());
        if (r14 != null) goto L70;
        return;
    L70:
        if (r14.d > 0) goto L72;
        return;
    L72:
        if (r14.e > 0) goto L82;
        r14.e = SystemClock.elapsedRealtime();
        return;
    L82:
        return;
    L25:
        if ((r11 instanceof com.larus.bmhome.chat.list.cell.text.cells.base.a) == false) goto L27;
        com.larus.bmhome.chat.list.cell.text.cells.base.a r15 = (com.larus.bmhome.chat.list.cell.text.cells.base.a) r11;
    L28:
        if (r15 == null) goto L32;
        com.larus.bmhome.chat.list.cell.text.cells.base.c r16 = r15.i();
        if (r16 == null) goto L32;
        CellComponentType r17 = r16.a;
    L34:
        if (r0.f > 0) goto L67;
        List<Pair<String, CellComponentType>> r6 = r0.i;
        boolean r8 = false;
        if ((r6 instanceof Collection) == true) goto L38;
    L40:
        Iterator<T> r7 = r6.iterator();
    L42:
        if (r7.hasNext() == false) goto L51;
        Pair r9 = (Pair) r7.next();
        if (Intrinsics.areEqual(r9.getFirst(), r12.getMessageId()) == true) goto L46;
    L48:
        boolean r10 = false;
    L49:
        if (r10 == false) goto L42;
        r8 = true;
        goto L51
    L46:
        if (r9.getSecond() != r17) goto L48;
        r10 = true;
    L51:
        if (r8 == true) goto L67;
        long r18 = SystemClock.elapsedRealtime();
        r0.d = r18;
        long r19 = r18 - r0.b;
        Long r20 = r0.i();
        if (r20 == null) goto L56;
        long r21 = r20.longValue();
    L58:
        if (r19 <= r21) goto L63;
        r0.u(Long.valueOf(r0.d - r0.b));
        r0.v(Long.valueOf(r0.d - r0.c));
        r0.j = r12;
        if (r17 == null) goto L62;
        r4 = Long.valueOf(r17.ordinal());
    L62:
        r0.w(r4);
    L63:
        List<Pair<String, CellComponentType>> r1 = r0.i;
        String r22 = r12.getMessageId();
        if (r22 != null) goto L66;
        r22 = "";
    L66:
        r1.add(TuplesKt.to(r22, r17));
        FLogger.a.d("FirstScreenRenderTrace", "onEndBindCell(), messageId: " + r12.getMessageId());
        goto L67
    L56:
        r21 = 0;
        goto L58
    L38:
        if (r6.isEmpty() == false) goto L40;
    L32:
        r17 = null;
        goto L34
    L27:
        r15 = null;
        goto L28
    L5:
        if (Intrinsics.areEqual(r3.g(), r12.getMessageId()) == false) goto L22;
        if (r3.g <= 0) goto L22;
        r3.h = SystemClock.elapsedRealtime();
        Map r23 = r12.getExt();
        if (r23 == null) goto L11;
        String r24 = (String) r23.get("is_deep_thinking");
    L12:
        r3.j(r24);
        Map r25 = r12.getExt();
        if (r25 == null) goto L15;
        String r26 = (String) r25.get("is_deep_thinking_show");
    L16:
        r3.k(r26);
        FLogger.a.d("EndToEndRenderTrace", "onEndBindCell(), messageId: " + r3.g());
        Integer r27 = r3.f();
        if (r27 == null) goto L22;
        if (r27.intValue() != 0) goto L22;
        r3.r();
        c.a = null;
        goto L22
    L15:
        r26 = null;
        goto L16
    L11:
        r24 = null;
        goto L12
    }

    public static void n(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "localMsgId");
        Intrinsics.checkNotNullParameter(r4, "msgId");
        c.a r2 = c.a;
        Intrinsics.checkNotNullParameter(r3, "localMsgId");
        Intrinsics.checkNotNullParameter(r4, "msgId");
        c.a r0 = c.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.a, r3) == false) goto L9;
        r0.c = SystemClock.elapsedRealtime();
        r0.q(r4);
        FLogger.a.d("EndToEndRenderTrace", "onSendAck(), localMsgId = " + r3 + ", msgId = " + r4);
        return;
    }

    public static void o(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "localMsgId");
        Intrinsics.checkNotNullParameter(r4, "convType");
        c.a r2 = c.a;
        Intrinsics.checkNotNullParameter(r3, "localMsgId");
        Intrinsics.checkNotNullParameter(r4, "convType");
        FLogger.a.d("EndToEndRenderTrace", "onSendMessage(), localMsgId: " + r3);
        c.a r0 = new c.a(null);
        r0.c("first_token_render_duration");
        r0.b(r4);
        r0.b = SystemClock.elapsedRealtime();
        r0.a = r3;
        c.a = r0;
    }

    public static void p(xc8.b r14, Message r15) {
        Intrinsics.checkNotNullParameter(r14, "state");
        Intrinsics.checkNotNullParameter(r15, "msg");
        c.a r2 = c.a;
        Intrinsics.checkNotNullParameter(r15, "msg");
        c.a r3 = c.a;
        if (r3 != null) goto L5;
    L9:
        d.a r4 = d.a;
        Intrinsics.checkNotNullParameter(r14, "state");
        Intrinsics.checkNotNullParameter(r15, "msg");
        d.a r0 = d.a;
        Map<String, RenderExceptionTrace.b> r5 = null;
        if (r0 != null) goto L12;
    L103:
        RenderExceptionTrace r16 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r15, "msg");
        ConcurrentHashMap<String, RenderExceptionTrace.a> r17 = RenderExceptionTrace.b;
        RenderExceptionTrace.a r1 = r17.get(r15.getMessageId());
        if (r.a(r15) == true) goto L131;
        if (r1 != null) goto L107;
    L108:
        RenderExceptionTrace.a r6 = new RenderExceptionTrace.a();
        r6.d = SystemClock.elapsedRealtime();
        r6.b = RenderExceptionTrace.d;
        r6.c = RenderExceptionTrace.e;
        r15.getMessageId();
        if (r1 == null) goto L111;
        String r7 = r1.g;
    L112:
        r6.g = r7;
        if (r1 == null) goto L115;
        String r8 = r1.h;
    L116:
        r6.h = r8;
        if (r1 == null) goto L119;
        String r9 = r1.i;
    L120:
        r6.i = r9;
        if (r1 == null) goto L123;
        JSONObject r10 = r1.j;
    L124:
        r6.j = r10;
        if (r1 == null) goto L127;
        r5 = r1.f;
    L127:
        r6.f = r5;
        String r18 = r15.getMessageId();
        if (r18 != null) goto L130;
        r18 = "";
    L130:
        r17.put(r18, r6);
        goto L131
    L123:
        r10 = null;
        goto L124
    L119:
        r9 = null;
        goto L120
    L115:
        r8 = null;
        goto L116
    L111:
        r7 = null;
        goto L112
    L107:
        if (r1.a == true) goto L108;
    L131:
        RenderExceptionTrace.d = 0;
        RenderExceptionTrace.e = 0;
        return;
    L12:
        if ((r14 instanceof com.larus.bmhome.chat.list.cell.text.cells.base.a) == false) goto L14;
        com.larus.bmhome.chat.list.cell.text.cells.base.a r19 = (com.larus.bmhome.chat.list.cell.text.cells.base.a) r14;
    L15:
        if (r19 == null) goto L19;
        com.larus.bmhome.chat.list.cell.text.cells.base.c r110 = r19.i();
        if (r110 == null) goto L19;
        CellComponentType r111 = r110.a;
    L21:
        if (r0.f > 0) goto L103;
        List<Pair<String, CellComponentType>> r11 = r0.i;
        if ((r11 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L38;
        Pair r13 = (Pair) r12.next();
        if (Intrinsics.areEqual(r13.getFirst(), r15.getMessageId()) == true) goto L33;
    L35:
        boolean r20 = false;
    L36:
        if (r20 == false) goto L29;
        boolean r21 = true;
    L39:
        if (r21 == true) goto L103;
        r0.c = SystemClock.elapsedRealtime();
        if (r0.f() == null) goto L44;
    L46:
        r0.k(r0.e() + 1);
        if (r15.getContentType() != 100) goto L50;
        r0.x(r0.j() + 1);
    L102:
        FLogger.a.d("FirstScreenRenderTrace", "onStartBindCell(), messageId: " + r15.getMessageId() + ", lynxCardCount: " + r0.j());
        goto L103
    L50:
        if (r15.getContentType() != 1) goto L52;
    L53:
        if (r111 == null) goto L57;
        if (r111 != CellComponentType.MIDDLE_CELL_COMPONENT) goto L102;
    L57:
        if (com.larus.im.bean.message.a.b0(r15) == false) goto L76;
        Iterator r112 = ((ArrayList) com.larus.im.bean.message.a.A(r15)).iterator();
    L60:
        if (r112.hasNext() == false) goto L102;
        List r22 = ((Block) r112.next()).getMetaInfo();
        if (r22 == null) goto L60;
        Iterator r23 = r22.iterator();
    L65:
        if (r23.hasNext() == false) goto L60;
        BlockMetaInfo r24 = (BlockMetaInfo) r23.next();
        if (r24.type != TagEnum.TagEnum_InsertText_BLOCK.value) goto L65;
        int r113 = p0.a;
        JSONObject r25 = p0.b(r24.getRealInfo());
        if (r25.optInt("scene_type") != RichMediaType.RUYI.getValue()) goto L71;
    L74:
        int r26 = 1;
    L75:
        r0.x(r0.j() + r26);
        goto L65
    L71:
        if (r25.optInt("scene_type") == RichMediaType.APPLET.getValue()) goto L74;
        r26 = 0;
        goto L75
    L76:
        int r114 = p0.a;
        JSONArray r115 = p0.b(r15.getContent()).optJSONArray("text_tags");
        if (r115 == null) goto L102;
        int r27 = r115.length();
        int r28 = 0;
    L79:
        if (r28 >= r27) goto L102;
        JSONObject r116 = r115.optJSONObject(r28);
        if (r116 == null) goto L83;
        Integer r117 = Integer.valueOf(r116.optInt("type"));
    L84:
        if (r117 != null) goto L87;
    L89:
        if (r117 == null) goto L101;
        if (r117.intValue() != 102) goto L101;
        int r118 = p0.a;
        String r119 = p0.b(r116.optString("tag_info")).optString("card_type");
        if (Intrinsics.areEqual(r119, "applet") == false) goto L96;
    L99:
        int r120 = 1;
    L100:
        r0.x(r0.j() + r120);
        goto L101
    L96:
        if (Intrinsics.areEqual(r119, "lynx_ruyi") == true) goto L99;
        r120 = 0;
    L101:
        r28 = r28 + 1;
        goto L79
    L87:
        if (r117.intValue() != 101) goto L89;
        r0.x(r0.j() + 1);
        goto L101
    L83:
        r117 = null;
        goto L84
    L52:
        if (r15.getContentType() != 9999) goto L102;
    L44:
        if (r0.g() == null) goto L46;
        r0.m(Long.valueOf(r0.c - r0.a));
        goto L46
    L33:
        if (r13.getSecond() != r111) goto L35;
        r20 = true;
    L38:
        r21 = false;
        goto L39
    L25:
        if (r11.isEmpty() == false) goto L27;
    L19:
        r111 = null;
        goto L21
    L14:
        r19 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r3.g(), r15.getMessageId()) == false) goto L9;
        if (r3.d <= 0) goto L9;
        r3.g = SystemClock.elapsedRealtime();
        FLogger.a.d("EndToEndRenderTrace", "onStartBindCell(), messageId: " + r3.g());
        goto L9
    }

    public static void r(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "channel");
        d.a r1 = d.a;
        Intrinsics.checkNotNullParameter(r6, "channel");
        FLogger.a.d("FirstScreenRenderTrace", "openChatPage(), cvsId = " + r5 + ", channel = " + r6);
        Integer r2 = null;
        d.a r0 = new d.a(null);
        r0.c("first_screen_render_duration");
        if (r5 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        ChatControlTrace r4 = ChatControlTrace.b;
        r4.getClass();
        wc9.e r7 = (wc9.e) ChatControlTrace.o.get(r5);
        if (r7 == null) goto L17;
        r2 = r7.v;
    L17:
        BotInfoCache r8 = BotInfoCache.INSTANCE;
        String r9 = r4.g(r2, r8.getBotType(r5), r8.isOwnBot(r5));
    L18:
        r0.b(r9);
        r0.l(r6);
        r0.a = SystemClock.elapsedRealtime();
        d.a = r0;
        return;
    L11:
        if (Intrinsics.areEqual(r6, ChatLandingChannel.COLD_PURE_CHAT.getChannel()) == false) goto L13;
        r9 = "default";
        goto L18
    L13:
        r9 = "unKnow";
        goto L18
    L5:
        if (r5.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void b(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "view");
        String r3 = null;
        if ((r6 instanceof rt8.a) == false) goto L5;
        rt8.a r7 = (rt8.a) r6;
    L6:
        if (r7 != null) goto L8;
        return;
    L8:
        RenderExceptionTrace r2 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r7, "view");
        RenderExceptionTrace.c r8 = RenderExceptionTrace.c.get(r5);
        if (r8 == null) goto L31;
        Iterator<T> r9 = r8.a.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        Object r0 = r9.next();
        if (Intrinsics.areEqual(((WeakReference) r0).get(), r7) == false) goto L13;
    L19:
        if (((WeakReference) r0) == null) goto L30;
        l r10 = r7.getMarkdownContent();
        if (r10 == null) goto L25;
        SpannableStringBuilder r11 = r10.e();
        if (r11 == null) goto L25;
        r3 = r11.toString();
    L25:
        r7.setMarkdownTextMonitorCache(r3);
        return;
    L30:
        return;
    L17:
        r0 = null;
        goto L19
    L31:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void e(String r2, MessageMonitorItemType r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "monitorItem");
        RenderExceptionTrace r0 = RenderExceptionTrace.a;
        RenderExceptionTrace.i(r2, r3);
    }

    public final void f(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "view");
        if ((r6 instanceof rt8.a) == false) goto L5;
        rt8.a r7 = (rt8.a) r6;
    L6:
        if (r7 != null) goto L8;
        return;
    L8:
        RenderExceptionTrace r0 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r7, "view");
        RenderExceptionTrace.c r1 = RenderExceptionTrace.c.get(r5);
        boolean r2 = false;
        if (r1 != null) goto L11;
        r1 = new RenderExceptionTrace.c(0);
    L11:
        CopyOnWriteArrayList<WeakReference<rt8.a>> r3 = r1.a;
        if ((r3 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((WeakReference) r4.next()).get(), r7) == false) goto L18;
        r2 = true;
    L22:
        if (r2 == true) goto L37;
        FLogger.a.d("RenderExceptionTrace", "onMarkdownViewAttached, messageId: ".concat(r5));
        r1.a.add(new WeakReference(r7));
        ConcurrentHashMap<String, RenderExceptionTrace.c> r8 = RenderExceptionTrace.c;
        r8.put(r5, r1);
        Iterator<Map.Entry<String, RenderExceptionTrace.c>> r9 = r8.entrySet().iterator();
    L26:
        if (r9.hasNext() == false) goto L48;
        CopyOnWriteArrayList<WeakReference<rt8.a>> r10 = r9.next().getValue().a;
        monitor-enter(r10);
        CollectionsKt.removeAll(r10, new f());     // Catch: Throwable -> L34
        monitor-exit(r10);
        if (r10.isEmpty() == false) goto L26;
        r9.remove();
    L34:
        th = move-exception;
        throw th;
    L48:
        return;
    L37:
        return;
    L14:
        if (r3.isEmpty() == false) goto L16;
    L5:
        r7 = null;
        goto L6
    }

    public final void g(String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        Intrinsics.checkNotNullParameter(r15, "cardId");
        c.a r4 = c.a;
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        Intrinsics.checkNotNullParameter(r15, "cardId");
        c.a r5 = c.a;
        if (r5 != null) goto L5;
    L9:
        d.a r6 = d.a;
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        Intrinsics.checkNotNullParameter(r15, "cardId");
        d.a r7 = d.a;
        if (r7 != null) goto L12;
    L20:
        RenderExceptionTrace r8 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        Intrinsics.checkNotNullParameter(r15, "cardId");
        MessageMonitorItemType r0 = MessageMonitorItemType.LYNX;
        if (RenderExceptionTrace.g(r0) == true) goto L37;
        RenderExceptionTrace.i(r12, r0);
        RenderExceptionTrace.a r16 = RenderExceptionTrace.b.get(r12);
        if (r16 != null) goto L26;
        return;
    L26:
        if (r16.d > 0) goto L28;
        return;
    L28:
        if (r16.f != null) goto L30;
        r16.f = new LinkedHashMap();
    L30:
        Map<String, RenderExceptionTrace.b> r17 = r16.f;
        if (r17 == null) goto L36;
        RenderExceptionTrace.b r1 = new RenderExceptionTrace.b();
        r1.a = SystemClock.elapsedRealtime();
        r1.c = r13;
        r1.d = r14;
        r1.e = r15;
        Unit r18 = Unit.INSTANCE;
        RenderExceptionTrace.b r19 = r17.put(r15, r1);
        return;
    L36:
        return;
    L37:
        return;
    L12:
        if (r7.f > 0) goto L20;
        if (r7.j() <= r7.e.size()) goto L20;
        long r9 = SystemClock.elapsedRealtime();
        r7.e.put(r15, Long.valueOf(r9));
        if (r7.h() != null) goto L19;
        r7.o(Long.valueOf(r9 - r7.a));
    L19:
        FLogger.a.d("FirstScreenRenderTrace", "onStartRenderLynxCard(), msgId: " + r12 + ", cardId: " + r15);
        goto L20
    L5:
        if (Intrinsics.areEqual(r5.g(), r12) == false) goto L9;
        if (r5.g <= 0) goto L9;
        r5.i = SystemClock.elapsedRealtime();
        FLogger.a.d("EndToEndRenderTrace", "onStartRenderLynxCard(), messageId: " + r5.g());
        goto L9
    }

    public final void h(String r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r20, "msgId");
        Intrinsics.checkNotNullParameter(r21, "appletId");
        Intrinsics.checkNotNullParameter(r22, "widgetId");
        Intrinsics.checkNotNullParameter(r23, "cardId");
        c.a r8 = c.a;
        Intrinsics.checkNotNullParameter(r20, "msgId");
        Intrinsics.checkNotNullParameter(r21, "appletId");
        Intrinsics.checkNotNullParameter(r22, "widgetId");
        Intrinsics.checkNotNullParameter(r23, "cardId");
        c.a r9 = c.a;
        if (r9 != null) goto L5;
    L9:
        d.a r10 = d.a;
        Intrinsics.checkNotNullParameter(r20, "msgId");
        Intrinsics.checkNotNullParameter(r21, "appletId");
        Intrinsics.checkNotNullParameter(r22, "widgetId");
        Intrinsics.checkNotNullParameter(r23, "cardId");
        d.a r11 = d.a;
        if (r11 == null) goto L18;
        Long r12 = r11.e.get(r23);
        if (r12 == null) goto L18;
        long r13 = r12.longValue();
        long r14 = SystemClock.elapsedRealtime();
        r11.g = r14;
        long r15 = r14 - r13;
        FLogger r16 = FLogger.a;
        r16.d("FirstScreenRenderTrace", "onEndRenderLynxCard(), msgId: " + r20 + ", cardId: " + r23);
        if (r11.h() == null) goto L18;
        long r17 = r11.h + 1;
        r11.h = r17;
        String r18 = "widgetId";
        String r19 = "cardId";
        if (r17 < r11.j()) goto L19;
        r16.d("FirstScreenRenderTrace", "onEndRenderLynxCard(), last card id: " + r23 + ", widget id: " + r22);
        r11.t(r20);
        r11.q(r23);
        r11.r(r21);
        r11.s(r22);
        r11.p(Long.valueOf(r15));
        r11.y();
        d.a = null;
    L19:
        RenderExceptionTrace r6 = RenderExceptionTrace.a;
        Intrinsics.checkNotNullParameter(r20, "msgId");
        Intrinsics.checkNotNullParameter(r21, "appletId");
        Intrinsics.checkNotNullParameter(r22, r18);
        Intrinsics.checkNotNullParameter(r23, r19);
        if (RenderExceptionTrace.g(MessageMonitorItemType.LYNX) == true) goto L33;
        RenderExceptionTrace.a r0 = RenderExceptionTrace.b.get(r20);
        if (r0 == null) goto L30;
        Map<String, RenderExceptionTrace.b> r1 = r0.f;
        if (r1 == null) goto L31;
        RenderExceptionTrace.b r2 = r1.get(r23);
        if (r2 == null) goto L32;
        r2.b = SystemClock.elapsedRealtime();
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L33:
        return;
    L18:
        r18 = "widgetId";
        r19 = "cardId";
        goto L19
    L5:
        if (Intrinsics.areEqual(r9.g(), r20) == false) goto L9;
        if (r9.i <= 0) goto L9;
        r9.j = SystemClock.elapsedRealtime();
        r9.l(r23);
        r9.m(r21);
        r9.n(r22);
        FLogger.a.d("EndToEndRenderTrace", "onEndRenderLynxCard(), messageId: " + r9.g());
        r9.r();
        c.a = null;
        goto L9
    }

    public final void a(String r8, ContainerExceptionType r9, String r10, JSONObject r11, Long r12) {
        Intrinsics.checkNotNullParameter(r8, "msgId");
        Intrinsics.checkNotNullParameter(r9, "exceptionType");
        Intrinsics.checkNotNullParameter(r11, "exceptionParams");
        RenderExceptionTrace r1 = RenderExceptionTrace.a;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r1.h(r8, r9, r10, r11, r12);
    }
}
