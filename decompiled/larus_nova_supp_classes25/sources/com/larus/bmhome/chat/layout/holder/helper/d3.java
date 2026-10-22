package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility$ActionType;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.widget.MenuStyle;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d3 implements cf8.c {
    public static final d3 a = null;
    public static WeakReference<CommonMenu> b;
    public static String c;
    public static WeakReference<Balloon> d;

    public d3() {
    }

    static {
        a = new d3();
        c = "";
    }

    @Override // cf8.c
    public final Unit c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L8;
        r0.getCollectService();
        com.larus.platform.api.y0 r1 = com.larus.home.impl.sdk.j1.a.f();
        if (r1 == null) goto L9;
        r1.Of(null);
        return Unit.INSTANCE;
    L9:
        return null;
    L8:
        return null;
    }

    @Override // cf8.c
    public final String f() {
        return c;
    }

    @Override // cf8.c
    public final boolean e(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L19:
        return false;
    L11:
        if (Intrinsics.areEqual(c, r4) == false) goto L19;
        WeakReference<Balloon> r5 = d;
        if (r5 == null) goto L18;
        Balloon r6 = r5.get();
        if (r6 == null) goto L18;
        r6.h();
    L18:
        return true;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // cf8.c
    public final boolean b(String r4, List<? extends ot8.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "menuItems");
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L22:
        return false;
    L11:
        if (Intrinsics.areEqual(r4, c) == false) goto L22;
        Iterator<T> r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L21;
        ot8.a r7 = (ot8.a) r6.next();
        WeakReference<CommonMenu> r0 = b;
        if (r0 == null) goto L15;
        CommonMenu r1 = r0.get();
        if (r1 == null) goto L15;
        r1.update(r7);
        goto L15
    L21:
        return true;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // cf8.c
    public final void a(View r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "traceInfo");
        ChatFragment r8 = com.larus.utils.e1.k(r5);
        Object r0 = null;
        if ((r8 instanceof ChatFragment) == false) goto L5;
        ChatFragment r9 = r8;
    L6:
        if (r9 == null) goto L44;
        t1a.b r10 = r9.WF();
        if (r10 == null) goto L47;
        u7 r11 = r10.getAbility(u7.class);
        if (r11 == null) goto L13;
        MessageAdapter r12 = r11.MF();
    L15:
        if ((r12 instanceof MessageAdapter) == true) goto L18;
        r12 = null;
    L18:
        if (r12 == null) goto L25;
        List<xc8.b> r13 = r12.z2();
        if (r13 == null) goto L25;
        List<xc8.b> r14 = r13;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L26;
        r1.add(((xc8.b) r15.next()).getMessage());
    L26:
        if (r1 == null) goto L45;
        Iterator r16 = r1.iterator();
    L29:
        if (r16.hasNext() == false) goto L33;
        Object r2 = r16.next();
        if (Intrinsics.areEqual(((Message) r2).getMessageId(), r6) == false) goto L29;
        r0 = r2;
    L33:
        Message r3 = (Message) r0;
        if (r3 == null) goto L48;
        IChatMessageShareAbility r17 = r10.getAbility(IChatMessageShareAbility.class);
        if (r17 == null) goto L46;
        r17.yt(IChatMessageShareAbility$ActionType.DELETE, r3, r1, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "long_press_answer"), TuplesKt.to("EXT_KEY_SCENE", ChatMsgDeleteScene.bridgeMenu)}));
        return;
    L46:
        return;
    L48:
        return;
    L45:
        return;
    L25:
        r1 = null;
        goto L26
    L13:
        r12 = null;
        goto L15
    L47:
        return;
    L44:
        return;
    L5:
        r9 = null;
        goto L6
    }

    @Override // cf8.c
    public final Pair<String, String> d(Context r16, final View r17, String r18, Long r19, float r20, float r21, List<? extends List<? extends ot8.a>> r22, @MenuStyle String r23) {
        Intrinsics.checkNotNullParameter(r22, "menuItems");
        Intrinsics.checkNotNullParameter(r23, "menuStyle");
        boolean r4 = false;
        int r5 = 0;
        if (r17 == null) goto L53;
        if (r16 == null) goto L53;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r22.iterator();
    L8:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        int r11 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r6.addAll((List) r8);
        if (r5 == (r22.size() - 1)) goto L15;
        r6.add(new com.larus.bmhome.view.screenmenu.i0(-1, ContextCompat.getColor(r16, v19.c.b(2130972086, r17.getContext(), 2131103159))));
    L15:
        r5 = r11;
        goto L8
    L16:
        boolean r2 = com.larus.platform.service.z2.a.enableMessageMenuTimestamp();
        if (r2 == false) goto L41;
        if (r19 != null) goto L40;
        ChatFragment r9 = com.larus.utils.e1.k(r17);
        if ((r9 instanceof ChatFragment) == false) goto L22;
        ChatFragment r10 = r9;
    L23:
        if (r10 == null) goto L41;
        t1a.b r12 = r10.WF();
        if (r12 == null) goto L41;
        u7 r13 = r12.getAbility(u7.class);
        if (r13 == null) goto L41;
        MessageAdapter r14 = r13.MF();
        if (r14 == null) goto L41;
        Iterator<T> r15 = r14.getCurrentList().iterator();
    L32:
        if (r15.hasNext() == false) goto L36;
        Object r24 = r15.next();
        if (Intrinsics.areEqual(((Message) r24).getMessageId(), r18) == false) goto L32;
    L37:
        Message r25 = (Message) r24;
        if (r25 == null) goto L41;
        Long r1 = Long.valueOf(r25.getCreateTime());
    L42:
        if (r1 == null) goto L44;
        String r3 = oo8.b.a(r1.longValue() * 1000, true);
    L45:
        List r26 = com.larus.bmhome.view.screenmenu.u0.b(r6, r2, r3);
        CommonMenu r110 = new CommonMenu(r16);
        if (r2 == false) goto L48;
        com.larus.bmhome.view.screenmenu.g.a(r110);
    L48:
        r110.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.i0.class), new com.larus.bmhome.view.screenmenu.j0());
        r110.h(Reflection.getOrCreateKotlinClass(pt8.b.class), new pt8.f());
        r110.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.f1.class), new com.larus.bmhome.view.screenmenu.i1());
        r110.h(Reflection.getOrCreateKotlinClass(pt8.g.class), new pt8.m());
        com.larus.bmhome.view.screenmenu.u0.a(r110, r2);
        r110.g(r26, new b3(r17));
        if (Intrinsics.areEqual(r23, "wrap") == false) goto L51;
        r110.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -2));
        r110.setMinimumWidth(i5.B());
        r110.setMaxWidth(i5.y0(v19.c.b(2130971356, null, 2131167081)));
    L51:
        View r111 = r110.i();
        Balloon r112 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r17, r111, false, null, null, null, new c3(), 60);
        com.larus.bmhome.view.screenmenu.d.g(r112, r17, r111, r20, r21, 0, 0, 0, true, DoraCallStateCode.DOUBAO_CMD_12);
        b = new WeakReference(r110);
        c = "menu_" + System.currentTimeMillis();
        d = new WeakReference(r112);
        return new Pair(c, null);
    L44:
        r3 = null;
        goto L45
    L36:
        r24 = null;
        goto L37
    L22:
        r10 = null;
        goto L23
    L40:
        r1 = r19;
    L41:
        r1 = null;
    L53:
        StringBuilder r27 = new StringBuilder("messageId：");
        r27.append(r18);
        r27.append("----anchor is null:");
        if (r17 != null) goto L56;
        boolean r28 = true;
    L57:
        r27.append(r28);
        r27.append("---context is null:");
        if (r16 != null) goto L60;
        r4 = true;
    L60:
        r27.append(r4);
        return new Pair(null, r27.toString());
    L56:
        r28 = false;
        goto L57
    }
}
