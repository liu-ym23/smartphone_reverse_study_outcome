package com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.mainbot.impl.databinding.LarusDeepSearchReferenceBinding;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w extends bd8.b implements hg8.z {
    public AtMostHeightRecyclerView l;
    public LarusDeepSearchReferenceBinding m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public ArrayList<Object> s;
    public Message t;

    public w() {
        super(false, -1);
        this.n = LazyKt.lazy(new m(this));
        this.o = LazyKt.lazy(new n(this));
        this.p = LazyKt.lazy(new o(this));
        this.q = LazyKt.lazy(new p(this));
        this.r = LazyKt.lazy(new q(this));
    }

    @Override // hg8.z
    public final void j() {
    }

    @Override // bd8.b
    public final void C() {
        com.larus.bmhome.chat.layout.item.i r0 = this.d;
        if (r0 == null) goto L5;
        Object r1 = r0.getParent();
    L7:
        if ((r1 instanceof View) == false) goto L9;
        View r2 = (View) r1;
    L10:
        if (r2 == null) goto L12;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = -2;
        r2.setLayoutParams(r3);
    L12:
        com.larus.bmhome.chat.layout.item.i r4 = this.d;
        if (r4 == null) goto L15;
        Object r5 = r4.getParent();
    L17:
        if ((r5 instanceof View) == false) goto L19;
        View r6 = (View) r5;
    L20:
        if (r6 == null) goto L22;
        e1.o(r6);
    L22:
        RecyclerView r7 = this.l;
        if (r7 == null) goto L25;
        e1.o(r7);
    L25:
        this.s = null;
        return;
    L19:
        r6 = null;
        goto L20
    L15:
        r5 = null;
        goto L17
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // bd8.b
    public final boolean H(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        r3.getMessage();
        Lazy r0 = qg8.b.a;
        if (qg8.b.c == true) goto L13;
        RecyclerView r1 = this.l;
        if (r1 == null) goto L7;
        boolean r2 = e1.r(r1);
    L9:
        if ((!r2) == false) goto L11;
        r3.getMessage();
        return true;
    L11:
        return false;
    L7:
        r2 = true;
        goto L9
    L13:
        return true;
    }

    public final oi8.n.a J(int r5) {
        ArrayList<Object> r0 = this.s;
        oi8.n.a r1 = null;
        if (r0 == null) goto L5;
        Object r2 = CollectionsKt.getOrNull(r0, r5);
    L7:
        if ((r2 instanceof TextCard) == false) goto L9;
        TextCard r3 = (TextCard) r2;
    L10:
        if (r3 == null) goto L16;
        Long r4 = r3.getId();
        if (r4 == null) goto L14;
        String r6 = r4.toString();
    L28:
        return new oi8.n.a(r6, r3.getUrl(), r3.getDocId(), null);
    L14:
        r6 = null;
        goto L28
    L16:
        ArrayList<Object> r7 = this.s;
        if (r7 == null) goto L19;
        Object r8 = CollectionsKt.getOrNull(r7, r5);
    L21:
        if ((r8 instanceof VideoCard) == false) goto L23;
        VideoCard r9 = (VideoCard) r8;
    L24:
        if (r9 == null) goto L27;
        r1 = new oi8.n.a(r9.getId(), r9.getMainSiteUrl(), r9.getItemId(), null);
    L27:
        return r1;
    L23:
        r9 = null;
        goto L24
    L19:
        r8 = null;
        goto L21
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // hg8.z
    public final void i(int r4) {
        com.larus.bmhome.chat.layout.item.i r0 = this.d;
        View r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof View) == false) goto L10;
        r1 = (View) r2;
    L10:
        if (r1 == null) goto L12;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.height = -2;
        r1.setLayoutParams(r3);
        r1.setVisibility(r4);
    L12:
        RecyclerView r5 = this.l;
        if (r5 == null) goto L16;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.height = -2;
        r5.setLayoutParams(r6);
        r5.setVisibility(r4);
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // bd8.b
    public final void w(final Message r78, int r79, ec8.b r80) {
        Intrinsics.checkNotNullParameter(r78, "message");
        Intrinsics.checkNotNullParameter(r78, "message");
        if (com.larus.im.bean.message.a.f0(r78) == false) goto L9;
        LarusDeepSearchReferenceBinding r2 = this.m;
        if (r2 == null) goto L14;
        View r3 = r2.b;
        if (r3 == null) goto L14;
        e1.x(r3);
    L14:
        Message r4 = this.t;
        View r5 = null;
        if (r4 == null) goto L17;
        String r6 = r4.getMessageId();
    L18:
        this.t = r78;
        Context r8 = getContext();
        if (r8 != null) goto L21;
        return;
    L21:
        ArrayList<Object> r7 = new ArrayList();
        this.s = r7;
        List r9 = com.larus.im.bean.message.a.G(r78);
        com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r10 == null) goto L25;
        final BotModel r11 = r10.j0();
        if (r11 == null) goto L25;
    L26:
        Iterator r12 = r9.iterator();
    L28:
        if (r12.hasNext() == false) goto L36;
        Reference r13 = (Reference) r12.next();
        TextCard r14 = r13.getTextCard();
        if (r14 == null) goto L32;
        r7.add(r14);
    L32:
        VideoCard r15 = r13.getVideoCard();
        if (r15 == null) goto L28;
        r7.add(r15);
        goto L28
    L36:
        if (Intrinsics.areEqual(r78.getMessageId(), r6) == true) goto L46;
        AtMostHeightRecyclerView r16 = this.l;
        if (r16 == null) goto L46;
        Function1 r17 = new u(this);
        boolean r18 = com.larus.im.bean.message.a.f0(r78);
        com.larus.bmhome.chat.component.cvs.y r19 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r19 == null) goto L44;
        wc9.e r20 = r19.h();
        if (r20 == null) goto L44;
        String r110 = ic8.n.f(r20);
    L45:
        r16.setAdapter(new MessageReferenceAdapter(false, r7, r17, r8, r18, r110, false, false, new v(r78, r11)));
    L44:
        r110 = null;
    L46:
        com.larus.bmhome.chat.layout.item.i r1 = this.d;
        if (r1 == null) goto L49;
        ViewParent r21 = r1.getParent();
    L51:
        if ((r21 instanceof View) == false) goto L53;
        r5 = (View) r21;
    L53:
        if (r5 == null) goto L55;
        e1.o(r5);
    L55:
        RecyclerView r22 = this.l;
        if (r22 == null) goto L64;
        e1.o(r22);
        return;
    L64:
        return;
    L49:
        r21 = null;
    L25:
        r11 = new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L26
    L17:
        r6 = null;
        goto L18
    L9:
        LarusDeepSearchReferenceBinding r23 = this.m;
        if (r23 == null) goto L14;
        View r24 = r23.b;
        if (r24 == null) goto L14;
        e1.o(r24);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.view.View, com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView] */
    @Override // bd8.b
    public final List<View> x(int r7, Context r8, BaseMessageListCell<?> r9, com.larus.bmhome.chat.layout.item.i r10, q0 r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (this.l != null) goto L5;
        View r13 = LayoutInflater.from(r8).inflate(2131562023, r10, false);
        int r14 = 2131388570;
        if (((AtMostHeightRecyclerView) ViewBindings.findChildViewById(r13, 2131388570)) == null) goto L29;
        r14 = 2131392215;
        View r0 = ViewBindings.findChildViewById(r13, 2131392215);
        if (r0 == null) goto L29;
        this.m = new LarusDeepSearchReferenceBinding((LinearLayout) r13, r0);
        ?? r15 = new AtMostHeightRecyclerView(r8);
        this.l = r15;
        if (r10 == 0) goto L13;
        r10.addView(r15, r7, new LinearLayout.LayoutParams(-1, 0));
    L13:
        AtMostHeightRecyclerView r16 = this.l;
        if (r16 == null) goto L16;
        r16.setLayoutManager(new LinearLayoutManager(getContext()));
    L16:
        AtMostHeightRecyclerView r17 = this.l;
        if (r17 == null) goto L19;
        r17.addItemDecoration(new ReferenceListComponent$initRecyclerConfig$1(this));
    L19:
        AtMostHeightRecyclerView r1 = this.l;
        if (r1 == null) goto L22;
        y6.d(r1, new r(this), new s(this), null, new t(this), 9);
    L22:
        LarusDeepSearchReferenceBinding r18 = this.m;
        if (r18 == null) goto L25;
        LinearLayout r19 = r18.a;
    L27:
        return CollectionsKt.listOf(r19);
    L25:
        r19 = null;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    L5:
        return CollectionsKt.emptyList();
    }
}
