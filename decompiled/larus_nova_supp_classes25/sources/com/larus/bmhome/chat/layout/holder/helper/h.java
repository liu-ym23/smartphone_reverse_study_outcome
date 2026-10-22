package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.GroupInfo;
import com.larus.im.bean.bot.GroupKey;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements t0 {
    public static final Set<String> a = null;

    public static final class a {
    }

    public h() {
    }

    static {
        a = SetsKt.setOf(new String[]{"copy", "tts", "quote-reply", "select-text"});
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    public static List c(GroupKey r16, List r17, Message r18, Function0 r19, com.larus.bmhome.chat.api.q0.a r20, com.larus.bmhome.chat.api.q0 r21) {
        List r1 = r17;
        ArrayList r0 = new ArrayList();
        Iterator r2 = r1.iterator();
    L3:
        String r4 = null;
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        GroupInfo r5 = ((AnswerAction) r3).getGroup();
        if (r5 == null) goto L9;
        r4 = r5.getKey();
    L9:
        if (Intrinsics.areEqual(r4, r16.getValue()) == false) goto L3;
        r0.add(r3);
        goto L3
    L12:
        if (r0.isEmpty() == false) goto L15;
        List r6 = CollectionsKt.emptyList();
    L29:
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L31:
        if (r9.hasNext() == false) goto L122;
        List r10 = (List) r9.next();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L34:
        if (r13.hasNext() == false) goto L38;
        String r14 = ((AnswerAction) r13.next()).getKey();
        if (r14 == null) goto L34;
        r12.add(r14);
        goto L34
    L38:
        Iterator r15 = r12.iterator();
    L40:
        if (r15.hasNext() == false) goto L121;
        String r22 = (String) r15.next();
        Iterator r23 = r1.iterator();
    L43:
        if (r23.hasNext() == false) goto L47;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((AnswerAction) r24).getKey(), r22) == false) goto L43;
    L48:
        AnswerAction r25 = (AnswerAction) r24;
        switch(r22.hashCode()) {
            case -576006635: goto L78;
            case -330459047: goto L74;
            case 115187: goto L64;
            case 3059573: goto L60;
            case 169275230: goto L56;
            case 1996259211: goto L52;
            default: goto L120;
        };
    L120:
        FLogger.a.d("AppletDebugMenuGroupCreator", "unknown action key: ".concat(r22));
        goto L40
    L56:
        if (r22.equals("select-text") == false) goto L120;
        r11.add(com.larus.bmhome.chat.layout.holder.menu.item.u0.a());
        goto L40
    L60:
        if (r22.equals("copy") == false) goto L120;
        r11.add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(r25));
        goto L40
    L64:
        if (r22.equals("tts") == false) goto L120;
        if (r19 == null) goto L69;
        Message r26 = (Message) r19.invoke();
        if (r26 == null) goto L69;
    L70:
        com.larus.bmhome.view.screenmenu.l0 r27 = com.larus.bmhome.chat.layout.holder.menu.item.d1.a(r26, r20);
        if (r27 == null) goto L40;
        r11.add(r27);
    L69:
        r26 = r18;
        goto L70
    L74:
        if (r22.equals("quote-reply") == false) goto L120;
        r11.add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(r25));
        goto L40
    L52:
        if (r22.equals("agent_trace") == false) goto L120;
    L80:
        if (r21 == null) goto L117;
        Function0<Fragment> r28 = r21.getHostFragment();
        if (r28 == null) goto L117;
        Fragment r29 = (Fragment) r28.invoke();
        if (r29 == null) goto L117;
        if (r29.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L117;
        if (r18.getUserType() != 2) goto L117;
        if (com.larus.bmhome.chat.bean.d.j0(r18) == false) goto L117;
        if (com.larus.bmhome.chat.bean.d.Q0(r18) == true) goto L117;
        if (com.larus.bmhome.chat.bean.d.r0(r18) == true) goto L117;
        com.larus.platform.api.e r30 = new com.larus.platform.api.e(r22, r18.getConversationId(), r18.getMessageId(), r18.getLocalMessageId(), com.larus.im.bean.message.a.x(r18), r18.getSectionId());
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L110
        IFlowSdkDepend r32 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L110
        if (r32 == null) goto L103;
        FlowAppletServiceImpl r33 = r32.g0();     // Catch: Throwable -> L110
        if (r33 == null) goto L103;
        zp9.j r34 = r33.d(r30);     // Catch: Throwable -> L110
    L105:
        if ((r34 instanceof ot8.a) == false) goto L107;
        ot8.a r35 = (ot8.a) r34;     // Catch: Throwable -> L110
    L108:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L110
    L112:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L116;
        FLogger.a.e("AppletDebugMenuGroupCreator", "create debugger message menu failed", r37);
        r36 = null;
    L116:
        ot8.a r38 = (ot8.a) r36;
    L118:
        if (r38 == null) goto L40;
        r11.add(r38);
        goto L40
    L107:
        r35 = null;
    L103:
        r34 = null;
    L110:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L117:
        r38 = null;
        goto L118
    L78:
        if (r22.equals("copy_logid") == true) goto L80;
    L47:
        r24 = null;
        goto L48
    L121:
        r8.add(r11);
        goto L31
    L122:
        return r8;
    L15:
        if (r16 != GroupKey.First) goto L28;
        LinkedHashMap r40 = new LinkedHashMap();
        Iterator r41 = r0.iterator();
    L18:
        if (r41.hasNext() == false) goto L27;
        Object r42 = r41.next();
        GroupInfo r43 = ((AnswerAction) r42).getGroup();
        if (r43 == null) goto L22;
        int r44 = r43.getPosition();
    L23:
        Integer r45 = Integer.valueOf(r44);
        Object r46 = r40.get(r45);
        if (r46 != null) goto L26;
        r46 = new ArrayList();
        r40.put(r45, r46);
    L26:
        ((List) r46).add(r42);
        goto L18
    L22:
        r44 = 0;
        goto L23
    L27:
        r6 = CollectionsKt.toList(MapsKt.toSortedMap(r40).values());
        goto L29
    L28:
        r6 = CollectionsKt.listOf(r0);
        goto L29
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r48, Message r49, Function0<Message> r50, com.larus.bmhome.chat.api.q0 r51, BotModel r52, wc9.e r53, com.larus.bmhome.chat.api.q0.a r54, JSONObject r55) {
        Intrinsics.checkNotNullParameter(r48, "context");
        Intrinsics.checkNotNullParameter(r49, "data");
        Intrinsics.checkNotNullParameter(r52, "chatBot");
        ArrayList r2 = new ArrayList();
        List r3 = r52.getMenuActions();
        boolean r13 = true;
        if (r3 != null) goto L5;
        FLogger.a.w("AppletDebugMenuGroupCreator", "BotModel menuActions is null, use default actions");
        r3 = CollectionsKt.listOf(new AnswerAction[]{new AnswerAction(null, "copy", null, null, null, null, null, 125, null), new AnswerAction(null, "tts", null, null, null, null, null, 125, null), new AnswerAction(null, "quote-reply", null, null, null, null, null, 125, null), new AnswerAction(null, "select-text", null, null, null, null, null, 125, null)});
    L5:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (CollectionsKt.contains(a, ((AnswerAction) r6).getKey()) == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        Iterator r7 = r4.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((AnswerAction) r8).getKey(), "select-text") == false) goto L13;
    L18:
        AnswerAction r15 = (AnswerAction) r8;
        GroupInfo r9 = new GroupInfo(GroupKey.First.getValue(), 0);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r4.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((AnswerAction) r12).getKey(), "select-text") == true) goto L20;
        r10.add(r12);
        goto L20
    L24:
        List r14 = CollectionsKt.toMutableList(r10);
        r14.add(new AnswerAction(null, "agent_trace", null, null, null, null, r9, 61, null));
        r14.add(new AnswerAction(null, "copy_logid", null, null, null, null, r9, 61, null));
        if (r15 == null) goto L33;
        GroupInfo r16 = r15.getGroup();
        if (r16 == null) goto L29;
        GroupInfo r22 = GroupInfo.copy$default(r16, null, 1, 1, null);
    L30:
        AnswerAction r17 = AnswerAction.copy$default(r15, null, null, null, null, null, null, r22, 63, null);
        if (r17 == null) goto L33;
        r14.add(r17);
        goto L33
    L29:
        r22 = null;
    L33:
        List r18 = CollectionsKt.flatten(c(GroupKey.Top, r14, r49, r50, r54, r51));
        List r19 = r18;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L35:
        if (r21.hasNext() == false) goto L37;
        r20.add(Integer.valueOf(((ot8.a) r21.next()).getId()));
        goto L35
    L37:
        int r23 = r18.size();
        if (r23 == 2) goto L42;
        if (r23 == 3) goto L41;
        r2.addAll(r18);
    L44:
        if ((!r18.isEmpty()) == false) goto L46;
        Intrinsics.checkNotNullParameter(r48, "context");
        r2.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r48, v19.c.b(2130972086, null, 2131103159))));
    L46:
        ArrayList r46 = r20;
        ArrayList r24 = (ArrayList) c(GroupKey.First, r14, r49, r50, r54, r51);
        Iterator r25 = r24.iterator();
        int r26 = 0;
    L48:
        if (r25.hasNext() == false) goto L56;
        Object r27 = r25.next();
        int r28 = r26 + 1;
        if (r26 >= 0) goto L52;
        CollectionsKt.throwIndexOverflow();
    L52:
        r2.addAll((List) r27);
        if (r26 >= (r24.size() - 1)) goto L55;
        Intrinsics.checkNotNullParameter(r48, "context");
        r2.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r48, v19.c.b(2130972086, null, 2131103159))));
    L55:
        r26 = r28;
        goto L48
    L56:
        List r29 = CollectionsKt.toMutableList(CollectionsKt.flatten(c(GroupKey.Second, r14, r49, r50, r54, r51)));
        if (Build.VERSION.SDK_INT >= 26) goto L59;
    L81:
        r13 = false;
    L82:
        if (r13 == false) goto L84;
        Intrinsics.checkNotNullParameter(r48, "context");
        r2.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r48, v19.c.b(2130972086, null, 2131103159))));
        r2.add(com.larus.bmhome.chat.layout.holder.menu.item.c0.a(r29));
    L88:
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r30 = r2.iterator();
    L90:
        if (r30.hasNext() == false) goto L98;
        Object r31 = r30.next();
        ot8.a r32 = (ot8.a) r31;
        if ((r32 instanceof com.larus.bmhome.view.screenmenu.i0) == false) goto L94;
        String r33 = UUID.randomUUID().toString();
    L96:
        if (r0.add(r33) == false) goto L90;
        r1.add(r31);
        goto L90
    L94:
        r33 = String.valueOf(r32.getId());
        goto L96
    L98:
        return r1;
    L84:
        CollectionsKt.removeAll(r29, new g());
        com.larus.bmhome.view.screenmenu.l0 r34 = com.larus.bmhome.chat.layout.holder.menu.item.l.a();
        if (r34 == null) goto L87;
        r29.add(r34);
    L87:
        r2.addAll(r29);
        goto L88
    L59:
        if (r29.size() <= 1) goto L81;
        if (r2.isEmpty() == false) goto L63;
        int r35 = 3;
        int r36 = 0;
    L79:
        if (r36 < r35) goto L81;
    L63:
        Iterator r37 = r2.iterator();
        r36 = 0;
    L65:
        if (r37.hasNext() == false) goto L78;
        ot8.a r38 = (ot8.a) r37.next();
        if (r38.getId() <= 0) goto L71;
        ArrayList r39 = r46;
        if (r39.contains(Integer.valueOf(r38.getId())) == true) goto L72;
        boolean r40 = true;
    L73:
        if (r40 == false) goto L77;
        r36 = r36 + 1;
        if (r36 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
    L77:
        r46 = r39;
    L72:
        r40 = false;
        goto L73
    L71:
        r39 = r46;
        goto L72
    L78:
        r35 = 3;
        goto L79
    L41:
        r2.add(new com.larus.bmhome.view.screenmenu.o1((ot8.a) ListProtector.get(r18, 0), (ot8.a) ListProtector.get(r18, 1), (ot8.a) ListProtector.get(r18, 2)));
        goto L44
    L42:
        r2.add(new com.larus.bmhome.view.screenmenu.y((ot8.a) ListProtector.get(r18, 0), (ot8.a) ListProtector.get(r18, 1)));
        goto L44
    L17:
        r8 = null;
        goto L18
    }
}
