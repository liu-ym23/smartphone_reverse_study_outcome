package em8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.standarduikit.markdowncontainer.view.MarkdownContainerView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import fb8.h;
import fb8.m;
import fh8.f;
import fh8.g;
import fh8.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.v0;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lw8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements a {
    public final m a;
    public final boolean b;
    public final y c;
    public final v0 d;
    public final kc8.b e;
    public final Lazy f;

    @Override // em8.a
    public final boolean H1() {
        y r0 = this.c;
        if (r0 == null) goto L7;
        Boolean r1 = r0.h;
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // em8.a
    public final Integer getBoxType() {
        y r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    @Override // em8.a
    public final boolean p() {
        y r0 = this.c;
        if (r0 == null) goto L5;
        Integer r1 = r0.k;
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    @Override // em8.a
    public final f q() {
        g r1 = new g();
        y r2 = this.c;
        jh8.a r3 = null;
        if (r2 == null) goto L9;
        Function0 r4 = r2.l;
        if (r4 == null) goto L9;
        BotModel r5 = (BotModel) r4.invoke();
        if (r5 == null) goto L9;
        String r6 = r5.getBotId();
    L10:
        r1.d = r6;
        y r7 = this.c;
        if (r7 == null) goto L15;
        Function0 r8 = r7.f;
        if (r8 == null) goto L15;
        String r9 = (String) r8.invoke();
    L16:
        r1.c = r9;
        Object r10 = this.a.i.b;
        if ((r10 instanceof Message) == false) goto L19;
        Message r11 = (Message) r10;
    L20:
        if (r11 != null) goto L22;
        r11 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L22:
        r1.b = r11;
        y r12 = this.c;
        if (r12 == null) goto L25;
        LruSet r13 = r12.y;
    L26:
        r1.g = r13;
        if (r12 == null) goto L29;
        q0 r14 = r12.x;
    L30:
        r1.q = r14;
        List r15 = this.a.i();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L32:
        if (r17.hasNext() == false) goto L36;
        Object r18 = r17.next();
        if ((r18 instanceof h) == false) goto L32;
        r16.add(r18);
        goto L32
    L36:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r20 = r16.iterator();
    L38:
        if (r20.hasNext() == false) goto L41;
        h r21 = (h) r20.next();
        r19.add(new mh8.a(((jc8.a) r21).g, r21.i(), this.e));
        goto L38
    L41:
        if (r19.isEmpty() == false) goto L43;
        j r22 = null;
    L44:
        r1.r = r22;
        y r23 = this.c;
        if (r23 == null) goto L51;
        Function0 r24 = r23.m;
        if (r24 == null) goto L51;
        ChatParam r25 = (ChatParam) r24.invoke();
        if (r25 == null) goto L51;
        String r26 = r25.e;
    L52:
        r1.a = r26;
        y r27 = this.c;
        if (r27 == null) goto L59;
        Function0 r28 = r27.m;
        if (r28 == null) goto L59;
        ChatParam r29 = (ChatParam) r28.invoke();
        if (r29 == null) goto L59;
        String r30 = r29.d;
    L60:
        r1.e = r30;
        y r31 = this.c;
        if (r31 == null) goto L67;
        Function0 r32 = r31.m;
        if (r32 == null) goto L67;
        ChatParam r33 = (ChatParam) r32.invoke();
        if (r33 == null) goto L67;
        String r34 = r33.c;
    L68:
        r1.f = r34;
        y r35 = this.c;
        if (r35 == null) goto L73;
        Boolean r36 = r35.g;
        if (r36 == null) goto L73;
        boolean r37 = r36.booleanValue();
    L74:
        r1.h = Boolean.valueOf(r37);
        r1.l = new c(this);
        y r38 = this.c;
        if (r38 == null) goto L77;
        q0.a r39 = r38.u;
    L78:
        r1.m = r39;
        if (r38 == null) goto L81;
        AttachReceiver r40 = r38.v;
    L82:
        r1.n = r40;
        if (r38 == null) goto L85;
        RecyclerView.Adapter r41 = r38.w;
    L86:
        r1.o = r41;
        if (r38 == null) goto L89;
        LruSet r42 = r38.y;
    L90:
        r1.g = r42;
        if (r38 == null) goto L93;
        Integer r43 = r38.t;
    L94:
        r1.k = r43;
        if (r38 == null) goto L97;
        Function0 r44 = r38.s;
    L98:
        r1.s = r44;
        v0 r45 = this.d;
        if (r45 == null) goto L101;
        bc8.b r46 = r45.i;
    L102:
        r1.t = r46;
        if (r45 == null) goto L105;
        Boolean r47 = r45.f;
    L106:
        r1.u = r47;
        if (r45 == null) goto L109;
        jh8.b r48 = r45.l;
    L110:
        r1.v = r48;
        if (r38 == null) goto L113;
        Function0 r49 = r38.F;
    L114:
        r1.x = r49;
        if (r38 == null) goto L117;
        Function1 r50 = r38.I;
    L118:
        r1.y = r50;
        if (r38 == null) goto L123;
        kc8.j r51 = r38.r;
        if (r51 == null) goto L123;
        Function1 r52 = r51.m;
    L124:
        r1.z = r52;
        if (r45 == null) goto L127;
        r3 = r45.o;
    L127:
        r1.A = r3;
        return r1.a();
    L123:
        r52 = null;
        goto L124
    L117:
        r50 = null;
        goto L118
    L113:
        r49 = null;
        goto L114
    L109:
        r48 = null;
        goto L110
    L105:
        r47 = null;
        goto L106
    L101:
        r46 = null;
        goto L102
    L97:
        r44 = null;
        goto L98
    L93:
        r43 = null;
        goto L94
    L89:
        r42 = null;
        goto L90
    L85:
        r41 = null;
        goto L86
    L81:
        r40 = null;
        goto L82
    L77:
        r39 = null;
    L73:
        r37 = false;
    L67:
        r34 = null;
    L59:
        r30 = null;
    L51:
        r26 = null;
        goto L52
    L43:
        r22 = new j(r19);
        goto L44
    L29:
        r14 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L19:
        r11 = null;
    L15:
        r9 = null;
    L9:
        r6 = null;
        goto L10
    }

    @Override // em8.a
    public final boolean r() {
        y r0 = this.c;
        if (r0 == null) goto L7;
        Boolean r1 = r0.i;
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public final if8.c s() {
        return (if8.c) this.f.getValue();
    }

    @Override // em8.a
    public final void a() {
        if8.c r0 = s();
        Message r1 = r0.a.a;
        o.a.reportEvent("footnote_link_show", r0.a(r1));
    }

    @Override // em8.a
    public final void f() {
        if8.c r0 = s();
        Message r1 = r0.a.a;
        o.a.reportEvent("footnote_link_click", r0.a(r1));
    }

    @Override // em8.a
    public final void h(lw8.g r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
        s().d(r2);
    }

    @Override // em8.a
    public final void l(lw8.g r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
        s().j(r2);
    }

    @Override // em8.a
    public final void b(Context r2, gw8.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "span");
        s().b(r2, r3);
    }

    @Override // em8.a
    public final void d(lw8.f r2, by7.e r3) {
        Intrinsics.checkNotNullParameter(r2, "span");
        s().h(r2, r3);
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.TextView, com.larus.bmhome.view.textview.impl.CustomMarkdownTextView] */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // em8.a
    public final void e(MarkdownContainerView r2, ow8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "markdownView");
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L5;
        final ?? r4 = (CustomMarkdownTextView) r3;
    L6:
        if (r4 != 0) goto L8;
        return;
    L8:
        r4.post(new d(this, r4));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // em8.a
    public final void g(Context r2, gw8.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "span");
        s().c(r2, r3);
    }

    @Override // em8.a
    public final void i(MarkdownContainerView r2, ow8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "markdownView");
        v0 r4 = this.d;
        if (r4 == null) goto L12;
        Function1 r5 = r4.j;
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L9;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r3;
    L10:
        r5.invoke(r6);
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // em8.a
    public final void j(MarkdownContainerView r2, ow8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "markdownView");
        v0 r4 = this.d;
        if (r4 == null) goto L12;
        Function1 r5 = r4.h;
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L9;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r3;
    L10:
        r5.invoke(r6);
        return;
    L9:
        r6 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // em8.a
    public final void k(View r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if8.c r0 = s();
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r5 = (CustomMarkdownTextView) r4;
    L6:
        r0.g(r3, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // em8.a
    public final void m(gw8.b r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "span");
        Intrinsics.checkNotNullParameter(r3, "view");
        s().i(r2, r3);
    }

    @Override // em8.a
    public final void n(View r2, lw8.f r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "span");
        s().f(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // em8.a
    public final void c(int r3, k r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "markDownLinkInfo");
        if8.c r0 = s();
        if ((r5 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r5;
    L6:
        r0.k(r3, r4, r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // em8.a
    public final void o(Context r9, View r10, lw8.f r11, View r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "span");
        Intrinsics.checkNotNullParameter(r12, "customMarkdownTextView");
        com.larus.bmhome.chat.cotdetail.list.processor.f r1 = null;
        if ((r12 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r12;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        Object r13 = this.a.i.b;
        if ((r13 instanceof Message) == false) goto L11;
        Message r14 = (Message) r13;
    L12:
        if (r14 == null) goto L18;
        int r0 = com.larus.bmhome.chat.cotdetail.list.processor.f.f;
        y r2 = this.c;
        if (r2 == null) goto L16;
        Fragment r3 = r2.a;
    L17:
        r1 = com.larus.bmhome.chat.cotdetail.list.processor.f.a.a(r3, r14, null);
        goto L18
    L16:
        r3 = null;
    L18:
        s().e(r9, r10, r11, r6, r1);
        return;
    L11:
        r14 = null;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    public e(m r2, boolean r3, y r4, v0 r5, kc8.b r6) {
        Intrinsics.checkNotNullParameter(r2, "textBlockBizModelV2");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(new b(this));
    }
}
