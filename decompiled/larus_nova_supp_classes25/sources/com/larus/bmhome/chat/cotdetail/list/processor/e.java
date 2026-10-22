package com.larus.bmhome.chat.cotdetail.list.processor;

import android.content.Context;
import android.view.animation.Interpolator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.o1;
import com.larus.bmhome.view.screenmenu.u0;
import com.larus.bmhome.view.screenmenu.y;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskDisplayType;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final List<String> a = null;

    public static final class a {
    }

    public static final class b implements b0 {
        public final RecyclerView a;
        public boolean b;

        public final void c(boolean r1, int r2, Function0<Unit> r3, Interpolator r4, int r5) {
        }

        public final void e(int r1) {
        }

        public final Long getChatUniqueKey() {
            return null;
        }

        public final void l(boolean r1, int r2, boolean r3, Function0<Unit> r4) {
        }

        public final boolean i() {
            return this.b;
        }

        public final RecyclerView m() {
            return this.a;
        }

        public b(RecyclerView r2) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            this.a = r2;
        }

        public final void setBottomReached(boolean r1) {
            this.b = r1;
        }
    }

    public e() {
    }

    static {
        a = CollectionsKt.listOf(new String[]{"delete", "share", "quote-reply", "regenerate", "create-conversation", "collection", "cancel_collection", "export-file"});
    }

    public static List a(List r7) {
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L26;
        y r1 = (ot8.a) r8.next();
        if ((r1 instanceof y) == false) goto L9;
        y r2 = r1;
        List r3 = a(CollectionsKt.listOf(new ot8.a[]{r2.c, r2.d}));
    L25:
        CollectionsKt.addAll(r0, r3);
        goto L4
    L9:
        if ((r1 instanceof o1) == false) goto L11;
        o1 r4 = (o1) r1;
        r3 = a(CollectionsKt.listOf(new ot8.a[]{r4.c, r4.d, r4.e}));
        goto L25
    L11:
        boolean r5 = r1 instanceof l0;
        if (r5 == false) goto L22;
        Object r6 = ((l0) r1).l;
        if ((r6 instanceof List) == false) goto L22;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList r9 = new ArrayList();
        Iterator r10 = ((List) r6).iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if ((r11 instanceof ot8.a) == false) goto L17;
        r9.add(r11);
        goto L17
    L21:
        r3 = a(r9);
    L22:
        if (r5 == false) goto L24;
        r3 = CollectionsKt.listOf(r1);
        goto L25
    L24:
        r3 = CollectionsKt.emptyList();
        goto L25
    L26:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static List c(List r9, Set r10) {
        ArrayList r0 = new ArrayList();
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L42;
        y r1 = (ot8.a) r11.next();
        if ((r1 instanceof y) == false) goto L24;
        y r4 = r1;
        List r3 = CollectionsKt.listOf(new ot8.a[]{r4.c, r4.d});
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        if ((r7 instanceof l0) == false) goto L9;
        r5.add(r7);
        goto L9
    L13:
        ?? r8 = new ArrayList();
        Iterator r12 = r5.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        Object r13 = r12.next();
        if (CollectionsKt.contains(r10, ((l0) r13).t) == false) goto L15;
        r8.add(r13);
        goto L15
    L19:
        int r14 = r8.size();
        if (r14 == 1) goto L40;
        if (r14 == 2) goto L23;
        r8 = CollectionsKt.emptyList();
        goto L40
    L23:
        r8 = CollectionsKt.listOf(r1);
    L40:
        CollectionsKt.addAll(r0, (Iterable) r8);
        goto L4
    L24:
        boolean r2 = r1 instanceof l0;
        if (r2 == true) goto L27;
    L29:
        if (r2 == false) goto L39;
        Object r15 = ((l0) r1).l;
        if ((r15 instanceof List) == false) goto L39;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList r16 = new ArrayList();
        Iterator r17 = ((List) r15).iterator();
    L34:
        if (r17.hasNext() == false) goto L38;
        Object r18 = r17.next();
        if ((r18 instanceof ot8.a) == false) goto L34;
        r16.add(r18);
        goto L34
    L38:
        r8 = c(r16, r10);
    L39:
        r8 = CollectionsKt.emptyList();
        goto L40
    L27:
        if (CollectionsKt.contains(r10, ((l0) r1).t) == false) goto L29;
        r8 = CollectionsKt.listOf(r1);
        goto L40
    L42:
        return CollectionsKt.toMutableList(r0);
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [com.larus.bmhome.chat.cotdetail.list.processor.a] */
    public static void b(final Fragment r17, RecyclerView r18, final st8.a r19, final Message r20, final BotModel r21, CustomMarkdownTextView r22, LongClickSource r23, String r24, final Function0 r25) {
        Intrinsics.checkNotNullParameter(r17, "fragment");
        Intrinsics.checkNotNullParameter(r18, "recyclerView");
        Intrinsics.checkNotNullParameter(r19, "anchorView");
        Intrinsics.checkNotNullParameter(r20, "message");
        Intrinsics.checkNotNullParameter(r21, "botModel");
        Intrinsics.checkNotNullParameter(r23, "longClickSource");
        Intrinsics.checkNotNullParameter(r25, "isCurrentMessage");
        hc8.c r0 = hc8.c.a;
        if (r0.j(r20) == false) goto L11;
        String r1 = r21.getBotId();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        if (r0.e(r20, r1) == true) goto L11;
        return;
    L11:
        if ((r17 instanceof fe8.a) == false) goto L13;
        fe8.a r2 = (fe8.a) r17;
    L14:
        if (r2 == null) goto L18;
        w r3 = r2.vF();
        if (r3 == null) goto L18;
        String r4 = r3.a;
    L20:
        if (z2.a.enableMessageMenuTimestamp() == true) goto L22;
    L28:
        boolean r6 = false;
    L29:
        boolean r26 = r6;
        final k r5 = new k(r17, r18, r20, r21, r22, r23, r24, r26, new com.larus.bmhome.chat.cotdetail.list.processor.a(r19, r25, r17, r20, r21));
        IAIChatService.Companion r9 = IAIChatService.a;
        t0 r7 = r9.O7(r20, null);
        r7.b(a);
        List r8 = CollectionsKt.toMutableList(t0.a.a(r7, r18.getContext(), r20, new com.larus.bmhome.chat.cotdetail.list.processor.b(r20), null, r21, null, null, null, 128));
        if (com.larus.bmhome.chat.bean.d.Q0(r20) == true) goto L57;
        if (r9.P7(r20, r17, r23) == false) goto L57;
        ot8.a r10 = r9.f8(r20);
        if (r10 == null) goto L57;
        List r11 = r8;
        if ((r11 instanceof Collection) == true) goto L38;
    L40:
        Iterator r12 = r11.iterator();
    L42:
        if (r12.hasNext() == false) goto L53;
        l0 r13 = (ot8.a) r12.next();
        if ((r13 instanceof l0) == false) goto L46;
        l0 r14 = r13;
    L47:
        if (r14 == null) goto L49;
        String r15 = r14.t;
    L51:
        if (Intrinsics.areEqual(r15, "play") == false) goto L42;
        boolean r16 = false;
    L54:
        if (r16 == false) goto L57;
        r8.add(r10);
        goto L57
    L49:
        r15 = null;
        goto L51
    L46:
        r14 = null;
    L53:
        r16 = true;
        goto L54
    L38:
        if (r11.isEmpty() == false) goto L40;
    L57:
        if (r26 == false) goto L71;
        List r27 = a(r8);
        ArrayList r28 = new ArrayList();
        Iterator r29 = ((ArrayList) r27).iterator();
    L60:
        if (r29.hasNext() == false) goto L64;
        Object r30 = r29.next();
        if (CollectionsKt.contains(r5.c(), ((l0) r30).t) == false) goto L60;
        r28.add(r30);
        goto L60
    L64:
        HashSet r31 = new HashSet();
        ArrayList r32 = new ArrayList();
        Iterator r33 = r28.iterator();
    L66:
        if (r33.hasNext() == false) goto L70;
        Object r34 = r33.next();
        if (r31.add(((l0) r34).t) == false) goto L66;
        r32.add(r34);
        goto L66
    L70:
        final List r35 = CollectionsKt.toMutableList(r32);
    L72:
        ObricMessagePopupServiceDelegate.b.filterMessageMenuItemsIfNeeded(r18.getContext(), r35);
        if (r35.isEmpty() == false) goto L75;
        return;
    L75:
        if (r26 == false) goto L130;
        ArrayList r36 = new ArrayList();
        Iterator r37 = r35.iterator();
    L78:
        if (r37.hasNext() == false) goto L82;
        Object r38 = r37.next();
        if ((r38 instanceof l0) == false) goto L78;
        r36.add(r38);
        goto L78
    L82:
        List r39 = CollectionsKt.listOf(new List[]{CollectionsKt.listOf(new String[]{"copy", "play"}), CollectionsKt.listOf(new String[]{"like", "dislike"}), CollectionsKt.listOf(new String[]{"choose_text", "report"})});
        ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator r41 = r39.iterator();
    L84:
        if (r41.hasNext() == false) goto L99;
        List r42 = (List) r41.next();
        ArrayList r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L87:
        if (r44.hasNext() == false) goto L98;
        String r45 = (String) r44.next();
        Iterator r46 = r36.iterator();
    L90:
        if (r46.hasNext() == false) goto L94;
        Object r110 = r46.next();
        if (Intrinsics.areEqual(((l0) r110).t, r45) == false) goto L90;
        Object r47 = r110;
    L95:
        l0 r48 = (l0) r47;
        if (r48 == null) goto L87;
        r43.add(r48);
        goto L87
    L94:
        r47 = null;
        goto L95
    L98:
        r40.add(r43);
        goto L84
    L99:
        ArrayList r49 = new ArrayList();
        Iterator r50 = r40.iterator();
        int r51 = 0;
    L101:
        if (r50.hasNext() == false) goto L119;
        Object r52 = r50.next();
        int r53 = r51 + 1;
        if (r51 >= 0) goto L105;
        CollectionsKt.throwIndexOverflow();
    L105:
        List r54 = (List) r52;
        List r55 = r54;
        if ((!r55.isEmpty()) == true) goto L108;
        r50 = r50;
    L118:
        r50 = r50;
        r51 = r53;
        goto L101
    L108:
        if ((!r49.isEmpty()) == false) goto L110;
        Context r56 = r18.getContext();
        Intrinsics.checkNotNullParameter(r56, "context");
        int r57 = ContextCompat.getColor(r56, v19.c.b(2130972086, null, 2131103159));
        int r58 = 0;
        r49.add(new i0(0, r57));
    L111:
        if (r51 != 0) goto L116;
        if (r54.size() != 2) goto L116;
        r49.add(new y((ot8.a) ListProtector.get(r54, r58), (ot8.a) ListProtector.get(r54, 1)));
    L116:
        r49.addAll(r55);
        goto L118
    L110:
        r58 = 0;
        goto L111
    L119:
        String r59 = null;
        Long r60 = Long.valueOf(r20.getCreateTime());
        if (r60.longValue() <= 0) goto L122;
        boolean r61 = true;
    L123:
        if (r61 == true) goto L126;
        r60 = null;
    L126:
        if (r60 == null) goto L128;
        boolean r62 = true;
        r59 = oo8.b.a(r60.longValue() * 1000, true);
    L129:
        List r63 = u0.b(r49, r62, r59);
    L131:
        CommonMenu r64 = new CommonMenu(r18.getContext());
        com.larus.bmhome.view.screenmenu.g.a(r64);
        u0.a(r64, r26);
        r64.i = i5.q();
        r64.g(r63, new c(r35, r5));
        IAIChatService.a.I7(r17, new b(r18), r19, r20, r64);
        if (r26 == false) goto L193;
        int r65 = f.f;
        f r66 = f.a.a(r17, r20, r21);
        if (r66 == null) goto L194;
        ArrayList r67 = new ArrayList();
        Iterator r68 = r63.iterator();
    L137:
        if (r68.hasNext() == false) goto L155;
        Object r69 = r68.next();
        l0 r70 = (ot8.a) r69;
        if ((r70 instanceof y) == false) goto L141;
    L152:
        boolean r71 = true;
    L153:
        if (r71 == false) goto L137;
        r67.add(r69);
        goto L137
    L141:
        if ((r70 instanceof l0) == false) goto L151;
        String r72 = r70.t;
        if (r72 != null) goto L145;
    L148:
        boolean r73 = true;
    L149:
        if (r73 == true) goto L151;
    L145:
        if (r72.length() == 0) goto L148;
        r73 = false;
    L151:
        r71 = false;
        goto L153
    L155:
        r66.b(r67);
        return;
    L194:
        return;
    L193:
        return;
    L128:
        r62 = true;
        goto L129
    L122:
        r61 = false;
        goto L123
    L130:
        r63 = r35;
        goto L131
    L71:
        r35 = c(r8, r5.c());
        goto L72
    L22:
        if (Intrinsics.areEqual(r4, ComplexTaskDisplayType.THREAD.getValue()) == false) goto L24;
    L27:
        r6 = true;
        goto L29
    L24:
        if (Intrinsics.areEqual(r4, "organizer") == true) goto L27;
        if (Intrinsics.areEqual(r4, ComplexTaskDisplayType.SUB_AGENT.getValue()) == false) goto L28;
    L18:
        r4 = null;
        goto L20
    L13:
        r2 = null;
        goto L14
    }
}
