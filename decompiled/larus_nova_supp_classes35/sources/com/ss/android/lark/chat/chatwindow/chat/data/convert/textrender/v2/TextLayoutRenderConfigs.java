package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.t;
import com.ss.android.lark.biz.im.api.message.params.y;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.chatmessage.ChatMessageContextResolver;
import com.ss.android.lark.coremd.facade.listeners.IMRegexParseListener;
import com.ss.android.lark.coremd.facade.plugins.a0;
import com.ss.android.lark.coremd.facade.plugins.z;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import g3b.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextLayoutRenderConfigs {
    public static final List<String> a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final ConcurrentHashMap<Integer, com.ss.android.lark.coremd.facade.listeners.d> d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public TextLayoutRenderConfigs() {
    }

    static {
        a = CollectionsKt.listOf(new String[]{"KEY_IM_REGEX_PARSE", "KEY_EDIT_MESSAGE_TAG", "KEY_MY_AI_CURSOR_LOADING"});
        b = LazyKt.lazy(TextLayoutRenderConfigs$imRegexParseListener$2.INSTANCE);
        c = LazyKt.lazy(TextLayoutRenderConfigs$editMessageTagListener$2.INSTANCE);
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(TextLayoutRenderConfigs$myAICursorLoadingListener$2.INSTANCE);
        f = LazyKt.lazy(TextLayoutRenderConfigs$devTagListener$2.INSTANCE);
    }

    public static float h(m2b.a r1) {
        y r0 = r1.d0(y.class);
        if (r0 == null) goto L8;
        Integer r2 = r0.g;
        if (r2 == null) goto L8;
        return r2.intValue();
    L8:
        return zz7.b.h(r1.getContext(), 17);
    }

    public static boolean i(f5b.b r4) {
        if (r4.getMessage().getThreadMessageType() == Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r4.getMessage().getThreadPosition() >= 0) goto L11;
        boolean r1 = true;
    L13:
        if (r4.isPreMessage() == true) goto L18;
        if (r0 == true) goto L16;
        if (r1 == true) goto L16;
        return false;
    L16:
        return true;
    L18:
        return false;
    L11:
        r1 = false;
        goto L13
    L5:
        if (Intrinsics.areEqual(r4.getMessage().getThreadId(), r4.getId()) == false) goto L7;
        r0 = true;
        goto L9
    }

    public static n c(m2b.a r6, f5b.b r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "chatContext");
        Intrinsics.checkNotNullParameter(r7, "chatMessage");
        return a(r6, r7, r8, null, null, null);
    }

    public static int g(m2b.a r3, Message.Status r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "chatContext");
        FragmentActivity r0 = r3.getContext();
        y r6 = r3.d0(y.class);
        com.ss.android.lark.biz.im.api.message.params.o r2 = null;
        if (r4 != Message.Status.DELETED) goto L12;
        if (r6 == null) goto L6;
        r2 = r6.b;
    L6:
        if (r2 == null) goto L23;
        if (r5 == false) goto L10;
        return UIUtils.getColor(r0, r2.a);
    L10:
        return UIUtils.getColor(r0, r2.b);
    L23:
        return UIUtils.getColor(r0, 2131106620);
    L12:
        if (r6 == null) goto L14;
        r2 = r6.a;
    L14:
        if (r2 == null) goto L20;
        if (r5 == false) goto L18;
        return UIUtils.getColor(r0, r2.a);
    L18:
        return UIUtils.getColor(r0, r2.b);
    L20:
        return UIUtils.getColor(r0, 2131106622);
    }

    public static int e(m2b.a r7, boolean r8, boolean r9, boolean r10) {
        Integer r0 = f3b.b.a(r7);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        FragmentActivity r2 = r7.getContext();
        return r7.H8().b(r2, Integer.valueOf(r1), r8, r10, r9);
    L5:
        r1 = Integer.MAX_VALUE;
        goto L6
    }

    @JvmStatic
    public static final n b(final m2b.a r22, final y6b.a<?> r23, final boolean r24, v4b.d r25, List<String> r26) {
        Intrinsics.checkNotNullParameter(r22, "chatContext");
        Intrinsics.checkNotNullParameter(r23, "messageVO");
        Intrinsics.checkNotNullParameter(r22, "chatContext");
        Intrinsics.checkNotNullParameter(r23, "messageVO");
        t r0 = r22.d0(t.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.a;
    L7:
        if (r25 == null) goto L10;
        int r2 = r25.d;
    L9:
        final int r12 = r2;
        final FragmentActivity r16 = r22.getContext();
        final float r14 = h(r22);
        String r17 = r23.getId();
        com.ss.android.lark.richtextmd.parse.a r3 = com.ss.android.lark.richtextmd.parse.a.a;
        List<Float> r4 = com.ss.android.lark.coremd.facade.b.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.ss.android.lark.coremd.facade.a r18 = com.ss.android.lark.coremd.facade.a.b;
        Intrinsics.checkNotNullParameter(t9b.d.a, "<this>");
        List r19 = CollectionsKt.listOf(new com.ss.android.lark.coremd.base.parse.g[]{a0.b, z.a});
        boolean r5 = MessageStyleHelper.b(r23);
        t9b.e r6 = t9b.e.a;
        com.ss.android.lark.coremd.base.parse.j r20 = com.ss.android.lark.coremd.facade.b.a(new TextLayoutRenderConfigs$obtainParseTheme$1(r22, r5));
        t9b.c r11 = t9b.c.a;
        Chat r13 = r22.getChat();
        Function2<IMContextExtend, com.ss.android.lark.coremd.base.parse.b, Unit> r7 = new TextLayoutRenderConfigs$resolveMessageImpl$1(r12, r22, r16, r23, r14, r24);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r7, Keys.API_PARAM_KEY_ACTION);
        com.ss.android.lark.coremd.base.parse.b r8 = ChatMessageContextResolver.b(r13, r23);
        com.ss.android.lark.coremd.ext.g.a(r8, IMContextExtend.A, r7);
        n r15 = new n(r16, r17, r18, r19, r20, r8, f(r22, null, r23, r26, null, 2), new com.ss.android.lark.widget.light.layout.h(r16, r12, g(r22, r23.K(), MessageStyleHelper.b(r23)), r14, 8092));
        com.ss.android.lark.coremd.ext.g.a(r15.e, IMThemeExtend.s, new TextLayoutRenderConfigs$applyCellConfig$1((u) r22.d0(u.class), r25));
        return r15;
    L10:
        boolean r9 = r23 instanceof y6b.c;
        if (r9 == false) goto L17;
        y6b.c r10 = (y6b.c) r23;
        if (r10.Y() == false) goto L15;
    L16:
        boolean r21 = true;
    L18:
        y6b.c r27 = null;
        if (r9 == false) goto L21;
        y6b.c r28 = (y6b.c) r23;
    L23:
        if (q7b.c.a(r28, r22) == false) goto L26;
        if (r1 == false) goto L26;
        boolean r29 = true;
    L27:
        if (r9 == false) goto L29;
        r27 = (y6b.c) r23;
    L29:
        if (r27 == null) goto L31;
        boolean r30 = r27.V1;
    L32:
        r2 = e(r22, r21, r29, r30);
        goto L9
    L31:
        r30 = false;
    L26:
        r29 = false;
        goto L27
    L21:
        r28 = null;
        goto L23
    L15:
        if (r10.Z() == true) goto L16;
    L17:
        r21 = false;
        goto L18
    L5:
        r1 = true;
        goto L7
    }

    public static /* synthetic */ n d(m2b.a r6, f5b.b r7, boolean r8, List r9, Integer r10) {
        return a(r6, r7, r8, null, r9, r10);
    }

    @JvmStatic
    public static final n a(final m2b.a r22, final f5b.b r23, final boolean r24, v4b.d r25, List<String> r26, Integer r27) {
        Intrinsics.checkNotNullParameter(r22, "chatContext");
        Intrinsics.checkNotNullParameter(r23, "chatMessage");
        if (r25 == null) goto L6;
        int r2 = r25.d;
    L5:
        final int r12 = r2;
        final FragmentActivity r16 = r22.getContext();
        final float r14 = h(r22);
        String r17 = r23.getId();
        com.ss.android.lark.richtextmd.parse.a r3 = com.ss.android.lark.richtextmd.parse.a.a;
        List<Float> r4 = com.ss.android.lark.coremd.facade.b.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.ss.android.lark.coremd.facade.a r18 = com.ss.android.lark.coremd.facade.a.b;
        Intrinsics.checkNotNullParameter(t9b.d.a, "<this>");
        List r19 = CollectionsKt.listOf(new com.ss.android.lark.coremd.base.parse.g[]{a0.b, z.a});
        Lazy r0 = MessageStyleHelper.a;
        boolean r1 = MessageStyleHelper.a(r23.getMessage());
        t9b.e r5 = t9b.e.a;
        com.ss.android.lark.coremd.base.parse.j r20 = com.ss.android.lark.coremd.facade.b.a(new TextLayoutRenderConfigs$obtainParseTheme$1(r22, r1));
        t9b.c r11 = t9b.c.a;
        Chat r13 = r22.getChat();
        Function2<IMContextExtend, com.ss.android.lark.coremd.base.parse.b, Unit> r6 = new TextLayoutRenderConfigs$resolveMessageImpl$2(r12, r22, r16, r23, r14, r24);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r23, "info");
        Intrinsics.checkNotNullParameter(r6, Keys.API_PARAM_KEY_ACTION);
        Message r7 = r23.getMessage();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r6, Keys.API_PARAM_KEY_ACTION);
        com.ss.android.lark.coremd.base.parse.b r8 = ChatMessageContextResolver.a(r13, r7);
        com.ss.android.lark.coremd.ext.g.a(r8, IMContextExtend.A, r6);
        n r15 = new n(r16, r17, r18, r19, r20, r8, f(r22, r23, null, r26, r27, 4), new com.ss.android.lark.widget.light.layout.h(r16, r12, g(r22, r23.getMessage().getStatus(), MessageStyleHelper.a(r23.getMessage())), r14, 8092));
        com.ss.android.lark.coremd.ext.g.a(r15.e, IMThemeExtend.s, new TextLayoutRenderConfigs$applyCellConfig$1((u) r22.d0(u.class), r25));
        return r15;
    L6:
        boolean r9 = i(r23);
        int r10 = q7b.c.a;
        Intrinsics.checkNotNullParameter(r22, "chatContent");
        if (r23.getMessage().isFromMe() == true) goto L9;
    L27:
        boolean r21 = false;
    L28:
        r2 = e(r22, r9, r21, r23.getMessage().isFlag());
        goto L5
    L9:
        if (r22.X() == true) goto L27;
        if (r22.h() == true) goto L27;
        if (r22.o() == true) goto L27;
        if (MessageDLPState.BLOCK == r23.getMessage().getDlpState()) goto L27;
        if (r22.B8() == true) goto L27;
        if (r23.getMessage().isCleaned() == true) goto L27;
        if (r22.isAIChat() == true) goto L27;
        if (r23.getMessage().getType() == Message.Type.TEXT) goto L25;
    L26:
        r21 = true;
        goto L28
    L25:
        if (r23.getMessage().isIncludeDocUrl() == false) goto L27;
        goto L26
    }

    public static List f(m2b.a r20, f5b.b r21, y6b.a r22, List r23, Integer r24, int r25) {
        ChatDisplayModeSetting r2 = null;
        if ((r25 & 2) == 0) goto L5;
        f5b.b r1 = null;
    L7:
        if ((r25 & 4) == 0) goto L9;
        y6b.a r3 = null;
    L11:
        if ((r25 & 8) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r25 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if (r1 == null) goto L23;
        Message r7 = r1.getMessage();
        if (r7 == null) goto L23;
        boolean r8 = r7.isFromMe();
    L26:
        if (r5 != null) goto L36;
        com.ss.android.lark.biz.im.api.message.params.e r6 = r20.d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r6 == null) goto L35;
        com.ss.android.lark.biz.im.api.message.params.o r9 = r6.b;
        if (r9 == null) goto L35;
        if (r8 == false) goto L33;
        int r10 = r9.a;
    L34:
        r5 = Integer.valueOf(r10);
        goto L36
    L33:
        r10 = r9.b;
    L35:
        r5 = null;
    L36:
        List r11 = r4;
        if (r11 != null) goto L39;
    L42:
        boolean r12 = true;
    L43:
        if (r12 == false) goto L45;
        r4 = a;
    L45:
        ArrayList r13 = new ArrayList();
        if (r4 == null) goto L77;
        Iterator r14 = r4.iterator();
    L49:
        if (r14.hasNext() == false) goto L77;
        String r15 = (String) r14.next();
        switch(r15.hashCode()) {
            case -1766065184: goto L75;
            case 238411373: goto L62;
            case 385126960: goto L58;
            case 1088552023: goto L54;
            default: goto L49;
        };
    L54:
        if (r15.equals("KEY_MY_AI_CURSOR_LOADING") == false) goto L49;
        r13.add((com.ss.android.lark.coremd.facade.listeners.g) e.getValue());
        goto L49
    L58:
        if (r15.equals("KEY_DEV_TAG") == false) goto L49;
        r13.add((com.ss.android.lark.coremd.facade.listeners.b) f.getValue());
        goto L49
    L62:
        if (r15.equals("KEY_EDIT_MESSAGE_TAG") == false) goto L49;
        if (r5 == null) goto L72;
        int r16 = r5.intValue();
        ConcurrentHashMap<Integer, com.ss.android.lark.coremd.facade.listeners.d> r17 = d;
        Integer r18 = Integer.valueOf(r16);
        Object r19 = r17.get(r18);
        if (r19 != null) goto L73;
        r19 = new com.ss.android.lark.coremd.facade.listeners.d(12, Integer.valueOf(r16));
        com.ss.android.lark.coremd.facade.listeners.d r26 = r17.putIfAbsent(r18, (com.ss.android.lark.coremd.facade.listeners.d) r19);
        if (r26 == null) goto L73;
        r19 = r26;
    L73:
        r13.add((com.ss.android.lark.coremd.facade.listeners.d) r19);
        goto L49
    L72:
        r19 = c.getValue();
        goto L73
    L75:
        if (r15.equals("KEY_IM_REGEX_PARSE") == false) goto L49;
        r13.add((IMRegexParseListener) b.getValue());
    L77:
        if (r1 != null) goto L80;
        if (r3 != null) goto L80;
        Log.e("TextLayoutRenderConfigs", "chatMessage and messageVO is all null,at least one is not null");
        return r13;
    L80:
        if (r1 != null) goto L83;
        if (r3 != null) goto L83;
    L129:
        boolean r27 = false;
    L130:
        if (r27 == true) goto L132;
        return r13;
    L132:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L177;
        String r110 = r20.getChatId();
        boolean r111 = r20.d();
        boolean r112 = r20.isGroup();
        boolean r113 = r20.m();
        boolean r114 = r20.Y();
        boolean r115 = r20.r();
        boolean r116 = r20.isSecretChat();
        Chat r28 = r20.getChat();
        if (r28 == null) goto L136;
        r2 = r28.getChatDisplayModeSetting();
    L136:
        ChatDisplayModeSetting r117 = r2;
        jdb.g r118 = w.a(r20).C();
        if (r1 == null) goto L139;
        boolean r29 = i(r1);
    L140:
        if (r29 == true) goto L153;
        if (r3 != null) goto L143;
    L149:
        boolean r30 = false;
    L150:
        if (r30 == true) goto L153;
        boolean r119 = false;
    L155:
        return CollectionsKt.plus(r13, new com.ss.android.lark.coremd.facade.listeners.h(r20, new com.ss.android.lark.coremd.facade.listeners.h.c(r110, r111, r112, r113, r114, r115, r116, r117, r118, r119)));
    L143:
        if ((r3 instanceof y6b.c) == false) goto L149;
        y6b.c r31 = (y6b.c) r3;
        if (r31.Y() == false) goto L147;
    L148:
        r30 = true;
        goto L150
    L147:
        if (r31.Z() == false) goto L149;
    L153:
        r119 = true;
        goto L155
    L139:
        r29 = false;
        goto L140
    L177:
        return r13;
    L83:
        if (r20.Y() == true) goto L87;
        if (r20.m() == false) goto L129;
    L87:
        if (r20.B8() == true) goto L129;
        if (r20.X() == true) goto L129;
        if (r20.h() == true) goto L129;
        if (r20.o() == true) goto L129;
        if (r20.isAIChat() == true) goto L129;
        if (r1 != null) goto L98;
    L100:
        boolean r32 = false;
    L101:
        if (r32 == true) goto L129;
        if (r3 != null) goto L104;
    L106:
        boolean r33 = false;
    L107:
        if (r33 == true) goto L129;
        if (r20.getChatId() == null) goto L129;
        MessageDLPState r34 = MessageDLPState.BLOCK;
        if (r1 == null) goto L115;
        Message r35 = r1.getMessage();
        if (r35 == null) goto L115;
        MessageDLPState r36 = r35.getDlpState();
    L116:
        if (r34 == r36) goto L129;
        if (r3 == null) goto L119;
        MessageDLPState r37 = r3.t();
    L120:
        if (r34 == r37) goto L129;
        t r38 = r20.d0(t.class);
        if (r38 != null) goto L124;
    L126:
        boolean r39 = false;
    L127:
        if (r39 == true) goto L129;
        r27 = true;
        goto L130
    L124:
        if (r38.a == true) goto L126;
        r39 = true;
        goto L127
    L119:
        r37 = null;
    L115:
        r36 = null;
        goto L116
    L104:
        if (r3.isPreMessage() != true) goto L106;
        r33 = true;
        goto L107
    L98:
        if (r1.isPreMessage() != true) goto L100;
        r32 = true;
        goto L101
    L39:
        if (r11.isEmpty() == true) goto L42;
        r12 = false;
    L23:
        if (r3 == null) goto L25;
        r8 = r3.h();
        goto L26
    L25:
        r8 = false;
        goto L26
    L17:
        r5 = r24;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }
}
