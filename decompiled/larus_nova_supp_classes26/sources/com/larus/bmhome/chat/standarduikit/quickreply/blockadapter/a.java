package com.larus.bmhome.chat.standarduikit.quickreply.blockadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyDecisionContext;
import com.larus.im.bean.message.block.QuickReplyEnvironment;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc8.b;
import jc8.d;
import jc8.e;
import kc8.l0;
import kc8.y;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mi8.f;
import mi8.g;
import qm8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends b<c> {
    public static final /* synthetic */ int j = 0;
    public mi8.a d;
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b e;
    public List<Pair<Integer, QuickReplyItem>> f;
    public String g;
    public Integer h;
    public final QuickReplyVMDependencyImpl i;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    static {
    }

    public final String c() {
        return "MoaGrantingQuickReplyBlockHolder";
    }

    public final void i() {
        mi8.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.e = null;
        this.f = CollectionsKt.emptyList();
        this.g = null;
        this.h = null;
    }

    public a() {
        this.f = CollectionsKt.emptyList();
        this.i = new QuickReplyVMDependencyImpl();
    }

    public final d f(jc8.a r2) {
        c r3 = (c) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r38) {
        c r0 = (c) r38;
        Intrinsics.checkNotNullParameter(r0, "blockModel");
        mi8.a r1 = this.d;
        if (r1 == null) goto L5;
        r1.recycle();
    L5:
        mi8.a r2 = this.d;
        if (r2 == null) goto L8;
        r2.hide();
    L8:
        String r3 = null;
        this.e = null;
        this.f = CollectionsKt.emptyList();
        if (Intrinsics.areEqual(this.g, ((jc8.a) r0).g) == true) goto L11;
        this.g = ((jc8.a) r0).g;
        this.h = null;
    L11:
        BlockContent r4 = ((jc8.a) r0).a.getContent();
        if (r4 == null) goto L179;
        QuickReplyBlock r5 = r4.getQuickReplyBlock();
        if (r5 == null) goto L184;
        QuickReplyDecisionContext r6 = r5.getDecisionContext();
        if (r6 == null) goto L185;
        Integer r7 = r5.getStatus();
        int r8 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        boolean r9 = false;
        if (r7 != null) goto L23;
    L25:
        List r10 = r5.getItems();
        if (r10 != null) goto L28;
        r10 = CollectionsKt.emptyList();
    L28:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L30:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        String r14 = ((QuickReplyItem) r13).getText();
        if (r14 != null) goto L34;
    L37:
        boolean r15 = true;
    L39:
        if ((!r15) == false) goto L30;
        r11.add(r13);
        goto L30
    L34:
        if (StringsKt.isBlank(r14) == true) goto L37;
        r15 = false;
        goto L39
    L41:
        List r16 = r11;
    L42:
        Iterator r17 = r16.iterator();
        int r18 = 0;
    L43:
        int r19 = -1;
        if (r17.hasNext() == false) goto L55;
        Integer r20 = ((QuickReplyItem) r17.next()).getActionType();
        int r110 = ActionType.MOA_AUTH_ALLOW.getValue();
        if (r20 != null) goto L49;
    L51:
        boolean r21 = false;
    L52:
        if (r21 == true) goto L56;
        r18 = r18 + 1;
    L56:
        Integer r22 = Integer.valueOf(r18);
        if (r22.intValue() < 0) goto L59;
        boolean r23 = true;
    L60:
        if (r23 == true) goto L63;
        r22 = null;
    L63:
        if (r22 == null) goto L180;
        int r24 = r22.intValue();
        Iterator r25 = r16.iterator();
        int r26 = 0;
    L66:
        if (r25.hasNext() == false) goto L77;
        Integer r111 = ((QuickReplyItem) r25.next()).getActionType();
        int r112 = ActionType.MOA_AUTH_REFUSE.getValue();
        if (r111 != null) goto L71;
    L73:
        boolean r113 = false;
    L74:
        if (r113 == true) goto L75;
        r26 = r26 + 1;
        goto L66
    L75:
        r19 = r26;
        goto L77
    L71:
        if (r111.intValue() != r112) goto L73;
        r113 = true;
    L77:
        Integer r27 = Integer.valueOf(r19);
        if (r27.intValue() < 0) goto L80;
        boolean r28 = true;
    L81:
        if (r28 == true) goto L84;
        r27 = null;
    L84:
        if (r27 == null) goto L181;
        int r29 = r27.intValue();
        QuickReplyItem r30 = (QuickReplyItem) ListProtector.get(r16, r24);
        QuickReplyItem r114 = (QuickReplyItem) ListProtector.get(r16, r29);
        kc8.b r31 = jc8.c.a(this, kc8.b.class);
        BlockContent r115 = ((jc8.a) r0).a.getContent();
        if (r115 == null) goto L138;
        QuickReplyBlock r210 = r115.getQuickReplyBlock();
        if (r210 == null) goto L138;
        if (r31 == null) goto L92;
        y r116 = r31.a;
    L93:
        Message r211 = r0.j();
        jc8.a r117 = r0.k();
        if (r117 == null) goto L96;
        long r118 = r117.c;
    L97:
        long r119 = r118;
        String r120 = ((jc8.a) r0).g;
        if (r116 == null) goto L103;
        Function0 r121 = r116.f;
        if (r121 == null) goto L103;
        String r122 = (String) r121.invoke();
        if (r122 == null) goto L103;
    L104:
        String r123 = r122;
        String r124 = r211.getMessageId();
        if (r116 == null) goto L112;
        Function0 r125 = r116.l;
        if (r125 == null) goto L112;
        BotModel r126 = (BotModel) r125.invoke();
        if (r126 == null) goto L112;
        String r127 = r126.getBotId();
        if (r127 == null) goto L112;
    L113:
        String r128 = r127;
        if (r116 == null) goto L120;
        Function0 r129 = r116.m;
        if (r129 == null) goto L120;
        ChatParam r130 = (ChatParam) r129.invoke();
        if (r130 == null) goto L120;
        String r131 = r130.d;
    L121:
        Map r212 = r211.getExt();
        if (r31 == null) goto L126;
        l0 r132 = r31.s;
        if (r132 == null) goto L126;
        Function6 r213 = r132.a;
    L127:
        if (r31 == null) goto L131;
        l0 r32 = r31.s;
        if (r32 == null) goto L131;
        Integer r33 = r32.b;
    L132:
        if (r116 == null) goto L136;
        Function0 r133 = r116.n;
        if (r133 == null) goto L136;
        ChatPageContext r214 = (ChatPageContext) r133.invoke();
    L137:
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r34 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(r123, r124, r128, r131, r119, r212, r213, r33, r210, r214, r120, r211);
    L139:
        this.e = r34;
        this.f = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(r29), r114), TuplesKt.to(Integer.valueOf(r24), r30)});
        mi8.a r134 = this.d;
        if (r134 == null) goto L157;
        String r135 = ((jc8.a) r0).g;
        QuickReplyEnvironment r35 = r6.getEnvironment();
        if (r35 == null) goto L146;
        QuickReplyIcon r36 = r35.getIcon();
        if (r36 == null) goto L146;
        String r136 = r36.getUrlLight();
    L147:
        QuickReplyEnvironment r37 = r6.getEnvironment();
        if (r37 == null) goto L152;
        QuickReplyIcon r39 = r37.getIcon();
        if (r39 == null) goto L152;
        String r40 = r39.getUrlDark();
    L153:
        QuickReplyEnvironment r137 = r6.getEnvironment();
        if (r137 == null) goto L156;
        r3 = r137.getTitle();
    L156:
        r134.P5(new mi8.d(r135, r136, r40, r3, r6.getTitle(), r6.getContent(), r114.getText(), r30.getText()), new qm8.b(this, r34, r114, r29, r30, r24));
    L152:
        r40 = null;
    L146:
        r136 = null;
    L157:
        Integer r41 = this.h;
        if (r41 == null) goto L182;
        mi8.a r42 = this.d;
        if (r42 != null) goto L162;
        return;
    L162:
        if (r41.intValue() != ActionType.MOA_AUTH_ALLOW.getValue()) goto L164;
        boolean r43 = true;
    L166:
        if (r41.intValue() != ActionType.MOA_AUTH_REFUSE.getValue()) goto L168;
        r9 = true;
    L168:
        r42.P2(r43, r9);
        return;
    L164:
        r43 = false;
        goto L166
    L182:
        return;
    L136:
        r214 = null;
    L131:
        r33 = null;
    L126:
        r213 = null;
    L120:
        r131 = null;
    L112:
        r127 = r211.getSenderId();
    L103:
        r122 = r211.getConversationId();
        goto L104
    L96:
        r118 = 0;
        goto L97
    L92:
        r116 = null;
    L138:
        r34 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(null, null, null, null, 0, null, null, null, 4095);
        goto L139
    L181:
        return;
    L80:
        r28 = false;
        goto L81
    L180:
        return;
    L59:
        r23 = false;
        goto L60
    L49:
        if (r20.intValue() != r110) goto L51;
        r21 = true;
        goto L52
    L55:
        r18 = -1;
        goto L56
    L23:
        if (r7.intValue() != r8) goto L25;
        r16 = CollectionsKt.emptyList();
        goto L42
    L185:
        return;
    L184:
        return;
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        int r0 = mi8.c.a;
        Context r1 = r3.getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        IMoaGrantingAppletService r2 = mi8.c.a();
        if (r2 == null) goto L5;
        PermissionApplyCardView r4 = r2.b(r1);
    L6:
        this.d = r4;
        if (r4 == null) goto L11;
        View r5 = r4.getView();
        if (r5 == null) goto L11;
        return r5;
    L11:
        return new View(r3.getContext());
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [qm8.a] */
    public static final void j(a r9, QuickReplyItem r10, int r11) {
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r0 = r9.e;
        if (r0 == null) goto L76;
        List<Pair<Integer, QuickReplyItem>> r1 = r9.f;
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        Pair r4 = (Pair) r2.next();
        if (((Number) r4.getFirst()).intValue() == r11) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L12;
        boolean r12 = false;
    L22:
        if (r12 == false) goto L24;
        return;
    L24:
        if (r9.h != null) goto L77;
        Integer r13 = r10.getActionType();
        if (r13 == null) goto L73;
        final int r14 = r13.intValue();
        final String r6 = r0.k;
        if (r6 == null) goto L78;
        r9.h = Integer.valueOf(r14);
        mi8.a r7 = r9.d;
        if (r7 != null) goto L34;
    L41:
        final WeakReference r8 = new WeakReference(r9);
        ?? r15 = new qm8.a(r8, r6, r14);
        int r16 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.a;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.c(r0, r10, r10.getTrackIndex());
        String r17 = r10.getSchemaPayload();
        if (r17 != null) goto L45;
        r15.invoke();
        return;
    L45:
        if (r14 != ActionType.MOA_AUTH_ALLOW.getValue()) goto L49;
        MoaGrantingDecision r18 = MoaGrantingDecision.ALLOW;
    L47:
        MoaGrantingDecision r19 = r18;
        int r110 = mi8.c.a;
        String r111 = r0.b;
        if (r111 != null) goto L55;
        r111 = "";
    L55:
        f r20 = new f(r111);
        mi8.a r21 = r9.d;
        if (r21 == null) goto L62;
        View r22 = r21.getView();
        if (r22 == null) goto L62;
        Context r23 = r22.getContext();
        if (r23 == null) goto L62;
        WeakReference r24 = new WeakReference(r23);
    L63:
        g r25 = new g(r17, r19, r20, r24, r15);
        Intrinsics.checkNotNullParameter(r25, "request");
        IMoaGrantingAppletService r112 = mi8.c.a();
        if (r112 == null) goto L75;
        r112.a(r25);
        return;
    L75:
        return;
    L62:
        r24 = null;
        goto L63
    L49:
        if (r14 != ActionType.MOA_AUTH_REFUSE.getValue()) goto L51;
        r18 = MoaGrantingDecision.REFUSE;
        goto L47
    L51:
        r18 = MoaGrantingDecision.UNSUPPORTED;
        goto L47
    L34:
        if (r14 != ActionType.MOA_AUTH_ALLOW.getValue()) goto L36;
        boolean r26 = true;
    L38:
        if (r14 != ActionType.MOA_AUTH_REFUSE.getValue()) goto L40;
        r3 = true;
    L40:
        r7.P2(r26, r3);
        goto L41
    L36:
        r26 = false;
        goto L38
    L78:
        return;
    L73:
        return;
    L77:
        return;
    L16:
        if (r4.getSecond() != r10) goto L18;
        r5 = true;
    L21:
        r12 = true;
        goto L22
    L8:
        if (r1.isEmpty() == false) goto L10;
    }
}
