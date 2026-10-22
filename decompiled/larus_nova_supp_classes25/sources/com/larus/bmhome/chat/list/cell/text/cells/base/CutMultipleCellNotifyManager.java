package com.larus.bmhome.chat.list.cell.text.cells.base;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.richtext.n;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageContentType;
import com.larus.platform.service.z2;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import dg8.l;
import hg8.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CutMultipleCellNotifyManager implements gk9.a {
    public static final /* synthetic */ int i = 0;
    public final q0 a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Map<String, wq8.a> e;
    public final Set<String> f;
    public final ExecutorCoroutineDispatcher g;
    public long h;

    public static final class a {
    }

    static {
    }

    public CutMultipleCellNotifyManager(MessageAdapter r3) {
        Intrinsics.checkNotNullParameter(r3, "messageAdapter");
        this.a = r3;
        this.b = LazyKt.lazy(new f());
        this.c = LazyKt.lazy(new g());
        this.d = LazyKt.lazy(new h());
        this.e = Collections.synchronizedMap(new LinkedHashMap());
        this.f = Collections.synchronizedSet(new LinkedHashSet());
        this.g = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new i()));
        this.h = -1;
    }

    public final void b(List<? extends wq8.a> r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "state");
        ChatMessageList r0 = this.a.B7();
        if (r0 == null) goto L14;
        Context r1 = r0.getContext();
        if (r1 == null) goto L18;
        Iterator<T> r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L19;
        wq8.a r3 = (wq8.a) r10.next();
        this.f.add(r3.getMessage().getMessageId());
        this.e.put(r3.getMessage().getMessageId(), r3);
        String r2 = r3.getMessage().getMessageId();
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        d(r2, r3, r1, r3.getMessage().getContentType(), r9);
        goto L9
    L19:
        return;
    L18:
        return;
    }

    public final boolean a(xc8.b r19, final String r20, @MessageContentType int r21) {
        Intrinsics.checkNotNullParameter(r19, "state");
        Intrinsics.checkNotNullParameter(r20, "messageId");
        if ((r19 instanceof l) == false) goto L6;
        this.a.l3(r20, Integer.valueOf(r21));
        return true;
    L6:
        ChatMessageList r0 = this.a.B7();
        if (r0 == null) goto L64;
        Context r4 = r0.getContext();
        if (r4 == null) goto L64;
        if (com.larus.bmhome.chat.bean.d.f0(r19.getMessage()) == true) goto L60;
        boolean r11 = this.f.contains(r20);
        this.f.remove(r20);
        if (r11 == false) goto L16;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.g), null, null, new CutMultipleCellNotifyManager$notifyDeepThinkContentFirstTypingEnd$1(this, r20, r21, r4, r19, null), 3, null);
    L16:
        List<wq8.a> r1 = this.a.D7();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        if (Intrinsics.areEqual(((wq8.a) r5).getMessage().getMessageId(), r20) == false) goto L18;
        r2.add(r5);
        goto L18
    L22:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r2.iterator();
    L24:
        if (r7.hasNext() == false) goto L45;
        Object r8 = r7.next();
        wq8.a r9 = (wq8.a) r8;
        if (Intrinsics.areEqual(r9.getMessage().getMessageId(), r20) == false) goto L42;
        if (r9.getMessage().getContentType() != r21) goto L42;
        if ((r9 instanceof eg8.g) == false) goto L34;
        if (eg8.h.a((eg8.g) r9) == false) goto L34;
    L40:
        boolean r10 = true;
    L43:
        if (r10 == false) goto L24;
        r6.add(r8);
    L34:
        if ((r9 instanceof fg8.f) == false) goto L38;
        if (fg8.g.a((fg8.f) r9) == true) goto L40;
    L38:
        if ((r9 instanceof p) == false) goto L42;
        if (r11 == true) goto L40;
    L42:
        r10 = false;
        goto L43
    L45:
        final ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r13 = r6.iterator();
    L47:
        if (r13.hasNext() == false) goto L49;
        r12.add(Integer.valueOf(this.a.D7().indexOf((wq8.a) r13.next())));
        goto L47
    L49:
        ChatMessageList r14 = this.a.B7();
        final LinearLayoutManager r15 = null;
        if (r14 == null) goto L52;
        RecyclerView.LayoutManager r16 = r14.getLayoutManager();
    L54:
        if ((r16 instanceof LinearLayoutManager) == false) goto L57;
        r15 = (LinearLayoutManager) r16;
    L57:
        if (r6.isEmpty() == true) goto L63;
        t0.e(new j(r15, r12, this, r20));
    L63:
        return true;
    L52:
        r16 = null;
        goto L54
    L60:
        this.f.add(r20);
        this.e.put(r20, r19);
        if ((System.currentTimeMillis() - this.h) <= 16) goto L63;
        d(r20, r19, r4, r21, null);
        this.h = System.currentTimeMillis();
    L64:
        return false;
    }

    public final void d(String r14, wq8.a r15, Context r16, @MessageContentType int r17, Object r18) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.g), null, null, new CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1(this, r14, r17, r16, r15, r18, null), 3, null);
    }

    public final Unit c(boolean r24, String r25, @MessageContentType int r26, Context r27, wq8.a r28, Map r29, Object r30) {
        MessageAdapter r0 = this.a.F7();
        List r2 = null;
        if ((r0 instanceof dc8.c) == false) goto L5;
        MessageAdapter r3 = r0;
    L6:
        String r1 = "";
        if (r3 == null) goto L12;
        String r4 = r28.getMessage().getMessageId();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        ec8.b r5 = r3.X0(r4);
    L13:
        if (r5 == null) goto L16;
        ec8.b.a r6 = r5.c;
        if (r6 == null) goto L16;
    L17:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r29.entrySet().iterator();
    L19:
        if (r8.hasNext() == false) goto L94;
        Map.Entry r9 = (Map.Entry) r8.next();
        if (com.larus.bmhome.chat.bean.d.f0(((wq8.a) r9.getValue()).getMessage()) == true) goto L25;
        if (r24 == true) goto L25;
        String r22 = r1;
    L93:
        r1 = r22;
        r2 = null;
    L25:
        int r10 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r11 = com.larus.im.internal.stream.b.a;
        String r12 = (String) r9.getKey();
        List r13 = com.larus.im.bean.message.a.S(((wq8.a) r9.getValue()).getMessage());
        if (r13 == null) goto L32;
        com.larus.im.bean.message.c r14 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L32;
        Integer r15 = r14.c;
        if (r15 == null) goto L32;
        int r16 = r15.intValue();
    L33:
        Integer r17 = r11.d(r12, r16);
        long r18 = System.currentTimeMillis();
        boolean r19 = com.larus.bmhome.chat.bean.d.f0(r28.getMessage());
        final Message r110 = r28.getMessage();
        gw8.c r111 = (gw8.c) this.d.getValue();
        int r112 = 0;
        if (r111 != null) goto L37;
        r22 = r1;
    L36:
        List r20 = r2;
    L55:
        ec8.b.a r21 = new ec8.b.a(r17, r20);
        ArrayList r23 = new ArrayList();
        List<uvc.b> r113 = r6.b;
        if (r113 == null) goto L58;
        int r114 = r113.size();
    L59:
        if (r20 == null) goto L61;
        int r115 = r20.size();
    L62:
        if (r114 > r115) goto L86;
        List<uvc.b> r116 = r6.b;
        if (r116 == null) goto L79;
        Iterator<T> r117 = r116.iterator();
    L67:
        if (r117.hasNext() == false) goto L79;
        Object r118 = r117.next();
        int r119 = r112 + 1;
        if (r112 >= 0) goto L71;
        CollectionsKt.throwIndexOverflow();
    L71:
        uvc.b r120 = (uvc.b) r118;
        List<uvc.b> r31 = r21.b;
        if (r31 == null) goto L74;
        uvc.b r32 = (uvc.b) CollectionsKt.getOrNull(r31, r112);
    L76:
        if (com.larus.business.markdown.impl.widget.f.b(r120, r32) == true) goto L78;
        r23.add(Integer.valueOf(r112));
    L78:
        r112 = r119;
        goto L67
    L74:
        r32 = null;
    L79:
        if (r115 <= r114) goto L88;
        if (r114 <= 0) goto L84;
        int r33 = r114 - 1;
        if (r23.contains(Integer.valueOf(r33)) == true) goto L84;
        r23.add(Integer.valueOf(r33));
    L84:
        if (r114 >= r115) goto L88;
        r23.add(Integer.valueOf(r114));
        r114 = r114 + 1;
    L88:
        r7.add(new k(r25, r23, r21));
        FLogger r34 = FLogger.a;
        StringBuilder r35 = new StringBuilder("testParseStreamContentInSubThread:  newCutNode:");
        if (r20 == null) goto L91;
        Integer r36 = Boxing.boxInt(r20.size());
    L92:
        r35.append(r36);
        r35.append("======");
        r35.append(System.currentTimeMillis() - r18);
        r34.d("CutMultipleCellNotifyManager", r35.toString());
        goto L93
    L91:
        r36 = null;
    L86:
        if (r112 >= r114) goto L88;
        r23.add(Integer.valueOf(r112));
        r112 = r112 + 1;
        goto L86
    L61:
        r115 = 0;
        goto L62
    L58:
        r114 = 0;
        goto L59
    L37:
        String r121 = (String) l0.a(r1, new e(r110));
        if (com.larus.bmhome.chat.bean.d.f0(r110) == false) goto L42;
        r22 = r1;
        if (StringsKt.endsWith$default(r121, "\n\n", false, 2, r2) == false) goto L44;
        r121 = r121 + 160;
    L44:
        if (z2.a.enableMessageMention() == true) goto L46;
        String r122 = r121;
    L47:
        boolean r123 = !r19;
        if (com.larus.bmhome.chat.bean.d.f0(r110) == false) goto L50;
        MarkwonStruct r37 = (MarkwonStruct) this.b.getValue();
    L51:
        uvc.b r38 = gw8.c.b.c(r111, r27, r122, r123, null, r37, null, null, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY);
        if (r38 == null) goto L36;
        r20 = MarkdownMultiWidgetHelper.a(r38);
        goto L55
    L50:
        r37 = (MarkwonStruct) this.c.getValue();
        goto L51
    L46:
        Regex r39 = n.a;
        r122 = n.k(r121);
        goto L47
    L42:
        r22 = r1;
    L32:
        r16 = -1;
        goto L33
    L94:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CutMultipleCellNotifyManager$deepThinkContentNotify$3(r7, r3, r25, this, r26, r30, null), 3, null);
        return Unit.INSTANCE;
    L16:
        r6 = new ec8.b.a(null, null);
        goto L17
    L12:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }
}
