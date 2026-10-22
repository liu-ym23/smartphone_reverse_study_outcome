package ib8;

import android.content.Context;
import androidx.collection.LruCache;
import com.larus.bmhome.block.newheader.foldcontainer.FolderContainerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements hb8.a {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public final FolderContainerView b() {
        return (FolderContainerView) this.b.getValue();
    }

    @Override // hb8.a
    public final void f() {
        ((com.larus.bmhome.block.newheader.foldcontainer.a) this.c.getValue()).f();
        b().f();
    }

    public final Context getContext() {
        return this.a;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new d(this));
        this.c = LazyKt.lazy(new e());
    }

    public final void a(b r58, g r59) {
        Intrinsics.checkNotNullParameter(r58, "vmData");
        com.larus.bmhome.block.newheader.foldcontainer.a r3 = (com.larus.bmhome.block.newheader.foldcontainer.a) this.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r58, "vmData");
        Message r4 = r3.g;
        if (r4 == null) goto L5;
        String r5 = r4.getMessageId();
    L7:
        if (Intrinsics.areEqual(r5, r58.a.d.getMessageId()) == false) goto L41;
        Message r6 = r3.g;
        if (r6 == null) goto L11;
        String r7 = r6.getConversationId();
    L13:
        if (Intrinsics.areEqual(r7, r58.a.d.getConversationId()) == false) goto L41;
        Message r8 = r58.a.d;
        if (com.larus.bmhome.chat.bean.d.i0(r8) == false) goto L20;
        if (com.larus.bmhome.chat.bean.d.w(r8) == true) goto L20;
    L39:
        boolean r9 = false;
    L40:
        if (r9 == false) goto L41;
    L42:
        r3.a = r58;
        c0 r1 = r58.a;
        r3.g = r1.d;
        r3.b = r59;
        DeepThinkFoldStatus r2 = r1.f;
        if (r2 == null) goto L45;
        r3.p.c(r2);
    L45:
        DeepThinkFoldStatus r10 = r3.p.a();
        DeepThinkFoldStatus r11 = r3.r;
        if (r10 == r11) goto L49;
        if (r11 == null) goto L49;
        boolean r12 = true;
    L50:
        String r13 = r3.c;
        Message r14 = r3.g;
        if (r14 == null) goto L53;
        String r15 = r14.getMessageId();
    L54:
        boolean r16 = !Intrinsics.areEqual(r13, r15);
        b r17 = r3.a;
        if (r17 == null) goto L59;
        c0 r18 = r17.a;
        if (r18 == null) goto L59;
        Boolean r19 = Boolean.valueOf(r18.j);
    L61:
        if (Intrinsics.areEqual(r19, r3.s) == false) goto L63;
    L65:
        boolean r20 = false;
    L66:
        if (r16 == true) goto L71;
        if (r12 == true) goto L71;
        if (r20 == true) goto L71;
        boolean r21 = false;
    L72:
        b r22 = r3.a;
        if (r22 == null) goto L81;
        c0 r110 = r22.a;
        if (r110 == null) goto L81;
        d0 r111 = r110.b;
        if (r111 == null) goto L81;
        if (r111.a != true) goto L81;
        boolean r112 = true;
    L82:
        if (r112 == true) goto L85;
        if (r21 == false) goto L85;
        boolean r113 = true;
    L86:
        if (r113 == true) goto L229;
        if (r16 == true) goto L229;
        if (r22 == null) goto L97;
        c0 r23 = r22.a;
        if (r23 == null) goto L97;
        d0 r24 = r23.b;
        if (r24 == null) goto L97;
        if (r24.a != true) goto L97;
        boolean r25 = true;
    L98:
        if (r25 == false) goto L173;
        if (r22 == null) goto L105;
        c0 r26 = r22.a;
        if (r26 == null) goto L105;
        d0 r27 = r26.b;
        if (r27 == null) goto L105;
        String r28 = r27.b;
    L106:
        if (r28 != null) goto L108;
        r28 = "";
    L108:
        if (r22 == null) goto L114;
        c0 r29 = r22.a;
        if (r29 == null) goto L114;
        Message r30 = r29.d;
        if (r30 == null) goto L114;
        boolean r31 = com.larus.im.bean.message.a.f0(r30);
    L115:
        b r32 = r3.a;
        if (r32 == null) goto L122;
        c0 r33 = r32.a;
        if (r33 == null) goto L122;
        if (r33.e != true) goto L122;
        boolean r34 = true;
    L123:
        boolean r35 = !r34;
        po8.e r114 = r3.p;
        if (r31 == true) goto L131;
        DeepThinkFoldStatus r36 = r114.b;
        if (r36 == DeepThinkFoldStatus.HalfFold) goto L129;
        DeepThinkFoldStatus r115 = DeepThinkFoldStatus.CompleteExpand;
        if (r36 == r115) goto L129;
    L149:
        b r37 = r3.a;
        if (r37 == null) goto L159;
        mb8.a r38 = r37.c;
        if (r38 == null) goto L159;
        List<jc8.a> r39 = r38.a;
        if (r39 == null) goto L159;
        jc8.a r40 = (jc8.a) CollectionsKt.firstOrNull(r39);
        if (r40 == null) goto L159;
        Block r41 = r40.a;
        if (r41 == null) goto L159;
    L160:
        b r116 = r3.a;
        if (r116 == null) goto L166;
        c0 r117 = r116.a;
        if (r117 == null) goto L166;
        Message r118 = r117.d;
        if (r118 == null) goto L166;
    L167:
        ComplexTaskDelegate r119 = ComplexTaskDelegate.b;
        if (r119.f(r118) == true) goto L170;
    L172:
        e0 r42 = new e0(new c(true, r35, r10, r115), r28);
    L230:
        c r43 = r42.a;
        DeepThinkFoldStatus r44 = r43.c;
        DeepThinkFoldStatus r45 = r43.d;
        if (r44 == r45) goto L255;
        r3.p.c(r45);
        String r46 = r42.b;
        if (r46 == null) goto L255;
        Message r47 = r3.g;
        if (r47 == null) goto L239;
        String r48 = r47.getMessageId();
        if (r48 == null) goto L239;
        LruCache r49 = ko8.a.a;
        IAIChatControlTraceService.a.Nb().put(r48, r3.p.a().toString());
    L239:
        g r50 = r3.b;
        if (r50 == null) goto L245;
        Message r51 = r3.g;
        if (r51 != null) goto L244;
        r51 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L244:
        r50.h(r46, r51, r3.p.a());
    L245:
        g r52 = r3.b;
        if (r52 == null) goto L255;
        boolean r53 = ic8.q.b(r3.p.a());
        b r54 = r3.a;
        if (r54 == null) goto L253;
        c0 r55 = r54.a;
        if (r55 == null) goto L253;
        Message r56 = r55.d;
        if (r56 == null) goto L253;
    L254:
        r52.q(r53, r56);
    L253:
        r56 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L255:
        r3.q = r42.a;
        r3.r = r3.p.a();
        b r57 = r3.a;
        if (r57 == null) goto L260;
        c0 r60 = r57.a;
        if (r60 == null) goto L260;
        Boolean r61 = Boolean.valueOf(r60.j);
    L261:
        r3.s = r61;
        b r62 = r3.a;
        if (r62 == null) goto L281;
        mb8.a r63 = r62.c;
        if (r63 == null) goto L281;
        c0 r64 = r62.a;
        if (r64 == null) goto L268;
        boolean r120 = r64.e;
    L269:
        po8.e r121 = r3.p;
        if (r3.k == false) goto L272;
    L275:
        boolean r122 = true;
    L276:
        List<jc8.a> r123 = r63.a;
        Message r124 = r63.c;
        kc8.b r125 = r63.d;
        Intrinsics.checkNotNullParameter(r123, "blockList");
        Intrinsics.checkNotNullParameter(r124, "message");
        mb8.a r65 = new mb8.a(r123, r122, r124, r125, r120, r121);
        mb8.c r66 = (mb8.c) r3.m.getValue();
        g r67 = r3.b;
        if (r67 == null) goto L279;
        lb8.a r68 = r67.e();
    L280:
        r66.getClass();
        Intrinsics.checkNotNullParameter(r65, "vmData");
        r66.a = r65;
        r66.b = r68;
        goto L281
    L279:
        r68 = null;
        goto L280
    L272:
        if (r63.b == true) goto L275;
        r122 = false;
        goto L276
    L268:
        r120 = false;
    L281:
        b r69 = r3.a;
        if (r69 == null) goto L300;
        kb8.a r70 = r69.b;
        if (r70 == null) goto L300;
        DeepThinkFoldStatus r71 = r3.p.a();
        Intrinsics.checkNotNullParameter(r71, "<set-?>");
        r70.h = r71;
        r70.e.f = r3.p.b();
        r70.g = r3.l;
        kb8.m r72 = (kb8.m) r3.n.getValue();
        g r73 = r3.b;
        if (r73 == null) goto L288;
        kb8.t r74 = r73.c();
    L289:
        r72.getClass();
        Intrinsics.checkNotNullParameter(r70, "vmData");
        r72.a = r70;
        r72.b = r74;
        String r75 = r70.b;
        List<Reference> r76 = r70.d;
        ArrayList r126 = new ArrayList();
        Iterator<T> r77 = r76.iterator();
    L291:
        if (r77.hasNext() == false) goto L299;
        Reference r127 = (Reference) r77.next();
        TextCard r128 = r127.getTextCard();
        if (r128 == null) goto L295;
        r126.add(new kb8.u(r128, r128.getId() + '&' + r75, String.valueOf(r128.getId()), r128.getDocId()));
    L295:
        VideoCard r78 = r127.getVideoCard();
        if (r78 == null) goto L291;
        r126.add(new kb8.u(r78, r78.getId() + '&' + r75, String.valueOf(r78.getId()), r78.getItemId()));
        goto L291
    L299:
        r72.d = !Intrinsics.areEqual(CollectionsKt.joinToString$default(r72.c, null, null, null, 0, null, new kb8.k(), 31, null), CollectionsKt.joinToString$default(r126, null, null, null, 0, null, new kb8.l(), 31, null));
        r72.c = r126;
        goto L300
    L288:
        r74 = null;
    L300:
        b r79 = r3.a;
        if (r79 == null) goto L316;
        nb8.m r80 = r79.d;
        if (r80 == null) goto L316;
        if (r80.f == false) goto L307;
    L310:
        boolean r129 = true;
    L311:
        boolean r130 = r3.k;
        po8.e r131 = r3.p;
        fh8.f r81 = r80.a;
        Message r82 = r80.b;
        String r132 = r80.c;
        fh8.t.a r133 = r80.d;
        boolean r134 = r80.e;
        Intrinsics.checkNotNullParameter(r81, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r82, "message");
        Intrinsics.checkNotNullParameter(r132, "thinkingContent");
        Intrinsics.checkNotNullParameter(r133, "renderViewConfig");
        nb8.m r83 = new nb8.m(r81, r82, r132, r133, r134, r129, r130, r131);
        nb8.k r84 = (nb8.k) r3.o.getValue();
        g r85 = r3.b;
        if (r85 == null) goto L314;
        nb8.a r86 = r85.f();
    L315:
        r84.getClass();
        Intrinsics.checkNotNullParameter(r83, "vmData");
        r84.a = r83;
        r84.d = r86;
        goto L316
    L314:
        r86 = null;
        goto L315
    L307:
        if (r3.k == true) goto L310;
        r129 = false;
    L316:
        b r87 = r3.a;
        if (r87 == null) goto L325;
        do8.k r88 = r87.e;
        if (r88 == null) goto L325;
        do8.w r89 = (do8.w) r3.u.getValue();
        g r90 = r3.b;
        if (r90 == null) goto L323;
        do8.h r91 = r90.d();
    L324:
        r89.a(r88, r91);
        goto L325
    L323:
        r91 = null;
    L325:
        r3.k = false;
        r3.b();
        po8.e r92 = r3.p;
        w r93 = r3.v;
        r92.getClass();
        Intrinsics.checkNotNullParameter(r93, "callback");
        if (((ArrayList) r92.c).contains(r93) == true) goto L329;
        ((ArrayList) r92.c).add(r93);
    L329:
        so8.r r94 = (so8.r) r3.t.getValue();
        so8.s r95 = (so8.s) r3.x.getValue();
        r94.getClass();
        Intrinsics.checkNotNullParameter(r95, "output");
        r94.f = r95;
        b().o6(((com.larus.bmhome.block.newheader.foldcontainer.a) this.c.getValue()).a(), ((com.larus.bmhome.block.newheader.foldcontainer.a) this.c.getValue()).w);
        return;
    L260:
        r61 = null;
        goto L261
    L170:
        if (r119.d(r118, r41) == false) goto L172;
        r115 = com.larus.bmhome.block.holder.deepthink.m.b(r119.h(com.larus.bmhome.block.holder.deepthink.m.a(r10), r118, r41, com.larus.bmhome.block.holder.deepthink.m.a(r115)));
    L166:
        r118 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L159:
        r41 = new Block(0, null, null, null, false, null, null, null, 255, null);
    L129:
        r115 = DeepThinkFoldStatus.CompleteFold;
        goto L149
    L131:
        if (((com.larus.platform.model.chat.p) r114.a.getValue()).a() == false) goto L135;
        DeepThinkFoldStatus r96 = r114.b;
        r115 = DeepThinkFoldStatus.HalfFold;
        if (r96 != r115) goto L149;
        r115 = DeepThinkFoldStatus.CompleteExpand;
        goto L149
    L135:
        DeepThinkFoldStatus r97 = r114.b;
        if (r97 != null) goto L138;
        int r99 = -1;
    L139:
        if (r99 != 1) goto L141;
        DeepThinkFoldStatus r100 = DeepThinkFoldStatus.CompleteExpand;
    L148:
        r115 = r100;
        goto L149
    L141:
        if (r99 != 2) goto L143;
        r100 = DeepThinkFoldStatus.CompleteExpand;
        goto L148
    L143:
        if (r99 == 3) goto L145;
        r100 = DeepThinkFoldStatus.CompleteExpand;
        goto L148
    L145:
        r100 = DeepThinkFoldStatus.CompleteFold;
        goto L148
    L138:
        r99 = po8.e.a.a[r97.ordinal()];
    L122:
        r34 = false;
    L114:
        r31 = false;
    L105:
        r28 = null;
        goto L106
    L173:
        boolean r101 = r3.p.b();
        b r102 = r3.a;
        if (r102 == null) goto L178;
        c0 r135 = r102.a;
        if (r135 == null) goto L178;
        boolean r136 = r135.e;
    L179:
        boolean r137 = !r136;
        if (r102 == null) goto L185;
        c0 r103 = r102.a;
        if (r103 == null) goto L185;
        Message r104 = r103.d;
        if (r104 == null) goto L185;
    L186:
        Boolean r138 = com.larus.im.bean.message.a.T(r104);
        if (r138 == null) goto L189;
        boolean r139 = r138.booleanValue();
    L190:
        if (r139 == true) goto L197;
        Boolean r140 = com.larus.im.bean.message.a.q(r104);
        if (r140 == null) goto L194;
        boolean r141 = r140.booleanValue();
    L195:
        if (r141 == true) goto L197;
    L210:
        boolean r105 = false;
    L212:
        if (((com.larus.platform.model.chat.p) r3.p.a.getValue()).a() == false) goto L214;
        DeepThinkFoldStatus r142 = DeepThinkFoldStatus.HalfFold;
    L215:
        if (r101 == false) goto L221;
        if (r137 == false) goto L221;
        if (r105 == false) goto L221;
        if (r142 == r3.p.a()) goto L221;
        boolean r106 = true;
    L222:
        if (r106 == true) goto L224;
        r42 = new e0(new c(r21, false, r10, r10), null);
        goto L230
    L224:
        if (((com.larus.platform.model.chat.p) r3.p.a.getValue()).a() == false) goto L226;
        DeepThinkFoldStatus r107 = DeepThinkFoldStatus.HalfFold;
    L227:
        r42 = new e0(new c(true, true, r10, r107), "auto_fold");
        goto L230
    L226:
        r107 = DeepThinkFoldStatus.CompleteFold;
    L221:
        r106 = false;
        goto L222
    L214:
        r142 = DeepThinkFoldStatus.CompleteFold;
        goto L215
    L194:
        r141 = false;
    L197:
        if (com.larus.bmhome.chat.bean.d.b0(r104) == true) goto L210;
        b r143 = r3.a;
        if (r143 == null) goto L205;
        c0 r144 = r143.a;
        if (r144 == null) goto L205;
        if (r144.u != true) goto L205;
        boolean r145 = true;
    L206:
        if (r145 == true) goto L210;
        if (com.larus.im.bean.message.a.m0(r104) == false) goto L210;
        r105 = true;
    L205:
        r145 = false;
        goto L206
    L189:
        r139 = false;
    L185:
        r104 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L178:
        r136 = false;
    L97:
        r25 = false;
    L229:
        r42 = new e0(new c(true, false, r10, r10), null);
    L85:
        r113 = false;
    L81:
        r112 = false;
    L71:
        r21 = true;
        goto L72
    L63:
        if (r3.s == null) goto L65;
        r20 = true;
    L59:
        r19 = null;
        goto L61
    L53:
        r15 = null;
    L49:
        r12 = false;
    L20:
        if (com.larus.bmhome.chat.bean.d.T(r8) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.p0(r8) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.C0(r8) == true) goto L27;
    L29:
        MessageStatus r108 = r8.getMessageStatus();
        if (r108 != null) goto L32;
    L34:
        boolean r109 = false;
    L35:
        if (r109 == false) goto L37;
    L38:
        r9 = true;
        goto L40
    L37:
        if (com.larus.bmhome.social.userchat.model.b0.f(r8) == false) goto L39;
    L32:
        if (r108.isVisible() != true) goto L34;
        r109 = true;
        goto L35
    L27:
        if (r8.getRegenVisible() == true) goto L29;
    L11:
        r7 = null;
    L41:
        r3.h++;
        r3.i = false;
        r3.j = null;
        goto L42
    L5:
        r5 = null;
        goto L7
    }
}
