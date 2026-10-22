package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ServiceBotCardHelper implements cf8.a {
    public static final ServiceBotCardHelper a = null;
    public static WeakReference<Balloon> b;

    static {
        a = new ServiceBotCardHelper();
    }

    public ServiceBotCardHelper() {
    }

    @Override // cf8.a
    public final void a(final Context r41, View r42, final cf8.b r43) {
        Intrinsics.checkNotNullParameter(r43, "data");
        ChatFragment r0 = com.larus.utils.e1.k(r42);
        Integer r7 = null;
        if ((r0 instanceof ChatFragment) == false) goto L5;
        ChatFragment r1 = r0;
    L6:
        if (r1 == null) goto L8;
    L18:
        ChatFragment r11 = r1;
    L19:
        if (r11 == null) goto L21;
        t1a.b r2 = r11.WF();
    L22:
        if (r2 == null) goto L24;
        com.larus.bmhome.chat.component.cvs.y r8 = (com.larus.bmhome.chat.component.cvs.y) r2.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L25:
        if (r2 == null) goto L29;
        u7 r3 = r2.getAbility(u7.class);
        if (r3 == null) goto L29;
        final MessageAdapter r5 = r3.MF();
    L30:
        if (r5 == null) goto L39;
        Iterator<T> r4 = r5.getCurrentList().iterator();
    L33:
        if (r4.hasNext() == false) goto L37;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((Message) r6).getMessageId(), r43.a) == false) goto L33;
    L38:
        Message r9 = (Message) r6;
    L40:
        FLogger r10 = FLogger.a;
        StringBuilder r12 = new StringBuilder("onLongPress data=");
        r12.append(r43);
        r12.append(" message=");
        if (r9 == null) goto L43;
        String r13 = r9.getMessageId();
    L44:
        r12.append(r13);
        r12.append(" fragment=");
        r12.append(r11);
        r10.i("ServiceBotCardHelper", r12.toString());
        if (r11 == null) goto L132;
        if (r9 == null) goto L133;
        LarusPageChatBinding r14 = r11.u;
        if (r14 == null) goto L51;
        ChatMessageList r15 = r14.n;
    L53:
        if (r15 == null) goto L65;
        Iterator r16 = SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r15.getChildCount())), new ServiceBotCardHelper$onLongPress$messageAnchor$1$1(r15)).iterator();
    L56:
        if (r16.hasNext() == false) goto L60;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((View) r17).getTag(2131365552), r9.getMessageId()) == false) goto L56;
    L61:
        View r18 = (View) r17;
        if (r18 == null) goto L65;
        View r22 = r18;
    L66:
        ArrayList r19 = new ArrayList();
        r19.add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(null));
        r19.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r41, null, true, 4));
        v1.a(r19);
        boolean r20 = com.larus.platform.service.z2.a.enableMessageMenuTimestamp();
        if (r20 == false) goto L69;
        Calendar r21 = oo8.b.a;
        String r23 = oo8.b.a(r9.getCreateTime() * 1000, true);
    L70:
        List r110 = com.larus.bmhome.view.screenmenu.u0.b(r19, r20, r23);
        CommonMenu r111 = new CommonMenu(r41);
        if (r20 == false) goto L73;
        com.larus.bmhome.view.screenmenu.g.a(r111);
    L73:
        com.larus.bmhome.view.screenmenu.u0.a(r111, r20);
        final Message r24 = r9;
        final ChatFragment r25 = r11;
        r111.g(r110, new v2(r43, r41, r24, r25, r5));
        View r26 = r111.i();
        Balloon r27 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r22, r26, false, null, null, null, new w2(), 60);
        Integer r28 = r43.c;
        if (r28 == null) goto L76;
        float r112 = c7.c(r28);
    L77:
        Integer r29 = r43.d;
        if (r29 == null) goto L80;
        float r113 = c7.c(r29);
    L81:
        com.larus.bmhome.view.screenmenu.d.g(r27, r22, r26, r112, r113, 0, 0, 0, true, DoraCallStateCode.DOUBAO_CMD_12);
        FLogger.a.i("ServiceBotCardHelper", "onLongPress show menu");
        new WeakReference(r111);
        b = new WeakReference(r27);
        LruCache r30 = ko8.a.a;
        JSONObject r31 = ko8.a.i(r9, null);
        if (r31 != null) goto L84;
        r31 = new JSONObject();
    L84:
        JSONObject r210 = r31;
        if (r8 == null) goto L87;
        String r211 = r8.getBotId();
    L88:
        if (r8 == null) goto L92;
        BotModel r32 = r8.j0();
        if (r32 == null) goto L92;
        Integer r33 = r32.getBotType();
    L93:
        if (r8 == null) goto L99;
        wc9.e r34 = r8.h();
        if (r34 == null) goto L99;
        String r35 = r34.a;
        if (r35 == null) goto L99;
        Long r212 = StringsKt.toLongOrNull(r35);
    L100:
        String r213 = r9.getMessageId();
        IAIChatControlTraceService.Companion r36 = IAIChatControlTraceService.a;
        if (r8 == null) goto L105;
        wc9.e r37 = r8.h();
        if (r37 == null) goto L105;
        Integer r38 = r37.v;
    L106:
        if (r8 == null) goto L110;
        BotModel r39 = r8.j0();
        if (r39 == null) goto L110;
        Integer r40 = r39.getBotType();
    L111:
        tx9.t1.a(r211, r212, "chat", "assistant", r213, null, r210, null, null, r36.g(r38, r40, false), r33, null, null, null, null, com.larus.bmhome.chat.bean.d.l(r9), 62304);
        if (r8 == null) goto L114;
        BotModel r114 = r8.j0();
    L115:
        if (r8 == null) goto L119;
        wc9.e r44 = r8.h();
        if (r44 == null) goto L119;
        Integer r45 = r44.v;
    L120:
        if (r8 == null) goto L124;
        BotModel r46 = r8.j0();
        if (r46 == null) goto L124;
        r7 = r46.getBotType();
    L124:
        ko8.a.l(r19, r9, r114, r11, r36.g(r45, r7, false), "long_press_message", new JSONObject());
        return;
    L119:
        r45 = null;
        goto L120
    L114:
        r114 = null;
    L110:
        r40 = null;
    L105:
        r38 = null;
    L99:
        r212 = null;
    L92:
        r33 = null;
        goto L93
    L87:
        r211 = null;
        goto L88
    L80:
        r113 = 0.0f;
        goto L81
    L76:
        r112 = 0.0f;
        goto L77
    L69:
        r23 = null;
        goto L70
    L60:
        r17 = null;
    L65:
        r22 = r42;
        goto L66
    L51:
        r15 = null;
        goto L53
    L133:
        return;
    L132:
        return;
    L43:
        r13 = null;
        goto L44
    L37:
        r6 = null;
        goto L38
    L39:
        r9 = null;
    L29:
        r5 = null;
        goto L30
    L24:
        r8 = null;
        goto L25
    L21:
        r2 = null;
        goto L22
    L8:
        if ((r41 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r47 = (FragmentActivity) r41;
    L11:
        if (r47 == null) goto L13;
        Fragment r48 = com.larus.utils.v.c(r47, ChatFragment.class);
    L15:
        if ((r48 instanceof ChatFragment) == false) goto L17;
        r1 = (ChatFragment) r48;
        goto L18
    L17:
        r11 = null;
        goto L19
    L13:
        r48 = null;
        goto L15
    L10:
        r47 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
