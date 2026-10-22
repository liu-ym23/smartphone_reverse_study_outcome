package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements t0 {
    public static final List<Integer> b = null;
    public final boolean a;

    public static final class a {
    }

    static {
        b = CollectionsKt.listOf(new Integer[]{1, 9999});
    }

    public k(boolean r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r96, Message r97, Function0<Message> r99, com.larus.bmhome.chat.api.q0 r910, BotModel r100, wc9.e r101, com.larus.bmhome.chat.api.q0.a r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r96, "context");
        Intrinsics.checkNotNullParameter(r97, "data");
        Intrinsics.checkNotNullParameter(r100, "chatBot");
        ArrayList r3 = new ArrayList();
        List r4 = r100.getMenuActions();
        if (r4 == null) goto L16;
        List r7 = r4;
        if ((r7 instanceof Collection) == true) goto L7;
    L9:
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((AnswerAction) r8.next()).getKey(), "like") == false) goto L11;
    L15:
        boolean r9 = false;
    L17:
        if (r4 == null) goto L30;
        List r10 = r4;
        if ((r10 instanceof Collection) == true) goto L21;
    L23:
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((AnswerAction) r11.next()).getKey(), "dislike") == false) goto L25;
    L29:
        boolean r12 = false;
    L31:
        if (r4 == null) goto L44;
        List r13 = r4;
        if ((r13 instanceof Collection) == true) goto L35;
    L37:
        Iterator r14 = r13.iterator();
    L39:
        if (r14.hasNext() == false) goto L43;
        if (Intrinsics.areEqual(((AnswerAction) r14.next()).getKey(), "share") == false) goto L39;
    L43:
        boolean r15 = false;
    L45:
        if (r4 == null) goto L66;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L49;
    L51:
        Iterator r6 = r5.iterator();
    L53:
        if (r6.hasNext() == false) goto L65;
        AnswerAction r16 = (AnswerAction) r6.next();
        if (Intrinsics.areEqual(r16.getKey(), "collection") == false) goto L57;
    L62:
        boolean r17 = true;
    L63:
        if (r17 == false) goto L53;
    L57:
        if (Intrinsics.areEqual(r16.getKey(), "single-collection") == true) goto L62;
        if (Intrinsics.areEqual(r16.getKey(), "cancel_collection") == true) goto L62;
        r17 = false;
    L65:
        boolean r18 = false;
    L68:
        if (r97.getMessageStatusLocal() == 21) goto L74;
        if (r97.getMessageStatusLocal() == 23) goto L74;
        if (com.larus.bmhome.chat.bean.d.d(r97) == true) goto L74;
    L76:
        boolean r19 = false;
    L77:
        String r110 = null;
        if (r19 == false) goto L90;
        if (r9 == false) goto L82;
        if (r12 == false) goto L82;
        r3.add(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r97));
        r3.add(com.larus.bmhome.chat.layout.holder.menu.item.p.a(r97));
    L87:
        if ((!r3.isEmpty()) == false) goto L90;
        Intrinsics.checkNotNullParameter(r96, "context");
        r3.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r96, v19.c.b(2130972086, null, 2131103159))));
    L82:
        if (r9 == false) goto L84;
        r3.add(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r97));
        goto L87
    L84:
        if (r12 == false) goto L87;
        r3.add(com.larus.bmhome.chat.layout.holder.menu.item.p.a(r97));
    L90:
        if (this.a == false) goto L92;
        r3.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SAVE_CODE_IMAGE.getType(), 0, r96.getString(2131899911), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971735, null, 2131241420)), null, false, false, null, null, "save_code_image", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528390, 127));
    L93:
        if (r15 == false) goto L97;
        com.larus.bmhome.view.screenmenu.l0 r0 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r97, r102);
        if (r0 == null) goto L97;
        r3.add(r0);
    L97:
        if (r18 == false) goto L121;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L103;
        r1.getCollectService();
        if (com.larus.home.impl.sdk.j1.a.e() != true) goto L103;
        boolean r20 = true;
    L104:
        if (r20 == false) goto L121;
        if (b.contains(Integer.valueOf(r97.getContentType())) == false) goto L108;
    L109:
        Map r2 = r97.getExt();
        if (r2 == null) goto L113;
        r110 = (String) r2.get("need_auth_identity");
    L113:
        if (Intrinsics.areEqual(r110, "1") == true) goto L121;
        if (com.larus.bmhome.utils.i.f(r101) == false) goto L121;
        if (com.larus.bmhome.chat.bean.d.B0(r97) == false) goto L119;
        com.larus.bmhome.view.screenmenu.l0 r21 = com.larus.bmhome.chat.layout.holder.menu.item.f.a();
    L120:
        r3.add(r21);
        goto L121
    L119:
        r21 = com.larus.bmhome.chat.layout.holder.menu.item.i.a();
        goto L120
    L108:
        if (com.larus.bmhome.chat.bean.d.a0(r97) == false) goto L121;
    L103:
        r20 = false;
    L121:
        return r3;
    L92:
        r3.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.FULLSCREEN_CODE.getType(), 0, r96.getString(2131899912), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971818, null, 2131241943)), null, false, false, null, null, "fullscreen_code", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528390, 127));
        r3.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.COPY_CODE.getType(), 0, r96.getString(2131899910), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971813, null, 2131241927)), null, false, false, null, null, "copy_code", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528390, 127));
        r3.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SAVE_CODE_IMAGE.getType(), 0, r96.getString(2131899911), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971735, null, 2131241420)), null, false, false, null, null, "save_code_image", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528390, 127));
    L74:
        if (com.larus.bmhome.chat.bean.d.z0(r97) == true) goto L76;
        r19 = true;
        goto L77
    L49:
        if (r5.isEmpty() == false) goto L51;
    L66:
        r18 = true;
        goto L68
    L35:
        if (r13.isEmpty() == false) goto L37;
    L44:
        r15 = true;
        goto L45
    L21:
        if (r10.isEmpty() == false) goto L23;
    L30:
        r12 = true;
        goto L31
    L7:
        if (r7.isEmpty() == false) goto L9;
    L16:
        r9 = true;
        goto L17
    }
}
