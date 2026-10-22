package eb8;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView;
import com.larus.bmhome.chat.deepresearch.view.f1;
import com.larus.bmhome.chat.deepresearch.view.p0;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class h<T extends jc8.a> extends jc8.b<T> {
    public MarkdownTextBlockView d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public kc8.b h;

    public abstract MarkdownTextBlockView j(ViewGroup r1);

    public abstract RectF k(jc8.a r1);

    @Override // jc8.b
    public final void i() {
        MarkdownTextBlockView r0 = this.d;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public h() {
        this.e = LazyKt.lazy(new b(this));
        this.f = LazyKt.lazy(new c(this));
        this.g = LazyKt.lazy(new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
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
    @Override // jc8.b
    public final void g(T r91) {
        Intrinsics.checkNotNullParameter(r91, "blockModel");
        this.h = (kc8.b) jc8.c.a(this, kc8.b.class);
        Intrinsics.checkNotNullParameter(r91, "blockModel");
        MarkdownTextBlockView r4 = this.d;
        if (r4 == null) goto L137;
        Block r7 = r91.a;
        boolean r2 = r91 instanceof fb8.l;
        RecyclerView.Adapter<?> r3 = null;
        if (r2 == false) goto L9;
        Message r5 = r91.j();
    L12:
        if (r5 != null) goto L14;
        r5 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L14:
        Message r6 = r5;
        if (r2 == false) goto L17;
        fb8.l r8 = (fb8.l) r91;
    L18:
        if (r8 == null) goto L27;
        List<jc8.a> r9 = r8.i();
        if (r9 == null) goto L27;
        ?? r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L28;
        Object r12 = r11.next();
        if ((r12 instanceof fb8.h) == false) goto L23;
        r10.add(r12);
    L28:
        if (r10 != 0) goto L30;
        r10 = CollectionsKt.emptyList();
    L30:
        Iterable r13 = (Iterable) r10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L32:
        if (r15.hasNext() == false) goto L35;
        fb8.h r16 = (fb8.h) r15.next();
        r14.add(new mh8.a(r16.g, r16.i(), this.h));
        goto L32
    L35:
        if ((!r14.isEmpty()) == true) goto L38;
        r14 = null;
    L38:
        if (r14 == null) goto L40;
        fh8.j r17 = new fh8.j(r14);
    L41:
        kc8.b r18 = this.h;
        if (r18 == null) goto L48;
        kc8.y r19 = r18.a;
        if (r19 == null) goto L48;
        Integer r20 = r19.t;
        if (r20 == null) goto L48;
        int r21 = r20.intValue();
    L49:
        kc8.b r22 = this.h;
        if (r22 == null) goto L57;
        kc8.y r23 = r22.a;
        if (r23 == null) goto L57;
        Function0<BotModel> r24 = r23.l;
        if (r24 == null) goto L57;
        BotModel r25 = (BotModel) r24.invoke();
        if (r25 == null) goto L57;
    L58:
        BotModel r110 = r25;
        de8.c r26 = (de8.c) this.f.getValue();
        if (r26 == null) goto L62;
        Integer r27 = r26.m();
        if (r27 == null) goto L62;
    L67:
        Integer r111 = r27;
    L69:
        kc8.b r112 = this.h;
        if (r112 == null) goto L74;
        kc8.y r113 = r112.a;
        if (r113 == null) goto L74;
        Integer r114 = r113.j;
    L75:
        ChatParam r115 = (ChatParam) this.e.getValue();
        if (r115 != null) goto L85;
        LruCache r116 = ko8.a.a;
        String r117 = r6.getConversationId();
        if (r117 != null) goto L80;
        r117 = "";
    L80:
        wc9.e r118 = (wc9.e) r116.get(r117);
        if (r118 == null) goto L83;
        String r28 = ic8.n.f(r118);
    L84:
        r115 = new ChatParam(null, null, null, null, r28, 239);
        goto L85
    L83:
        r28 = null;
    L85:
        ChatParam r119 = r115;
        LruCache r120 = ko8.a.a;
        de8.c r121 = (de8.c) this.f.getValue();
        if (r121 == null) goto L88;
        long r122 = r121.n;
    L89:
        String r123 = ko8.a.e(r122);
        de8.c r124 = (de8.c) this.f.getValue();
        if (r124 != null) goto L92;
        r124 = new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    L92:
        de8.c r125 = r124;
        e5 r126 = (e5) this.g.getValue();
        if (r111 == null) goto L95;
        boolean r127 = true;
    L96:
        Boolean r128 = Boolean.valueOf(r127);
        kc8.b r129 = this.h;
        if (r129 == null) goto L101;
        kc8.y r130 = r129.a;
        if (r130 == null) goto L101;
        q0 r29 = r130.x;
    L102:
        if (r129 == null) goto L106;
        kc8.y r131 = r129.a;
        if (r131 == null) goto L106;
        r3 = r131.w;
    L106:
        RecyclerView.Adapter<?> r210 = r3;
        if (r129 == null) goto L111;
        kc8.y r30 = r129.a;
        if (r30 == null) goto L111;
        boolean r211 = Intrinsics.areEqual(r30.h, Boolean.TRUE);
    L112:
        p0 r31 = new p0(r114, r110, r119, r123, r125, r126, r128, r111, r29, r21, r210, r211, new e(this), new f(this), new g(this));
        kc8.b r32 = this.h;
        if (r32 == null) goto L115;
        fh8.g r33 = z3.a(r32, r91.j());
    L116:
        r33.r = r17;
        fh8.f r132 = r33.a();
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r35 = r13.iterator();
    L118:
        if (r35.hasNext() == false) goto L120;
        r34.add(((fb8.h) r35.next()).a);
        goto L118
    L120:
        r4.setEmbeddedMetaInfoBlocks$impl_mainlandRelease(r34);
        RectF r36 = k(r91);
        boolean r37 = r91.n();
        kc8.b r1 = this.h;
        if (r1 == null) goto L127;
        kc8.y r38 = r1.a;
        if (r38 == null) goto L127;
        Boolean r39 = r38.i;
        if (r39 == null) goto L127;
        boolean r40 = r39.booleanValue();
    L128:
        r4.e(r36, r6, r7, r37, r31, new f1(r40), r132);
        return;
    L127:
        r40 = false;
        goto L128
    L115:
        r33 = new fh8.g();
    L111:
        r211 = false;
    L101:
        r29 = null;
        goto L102
    L95:
        r127 = false;
        goto L96
    L88:
        r122 = 0;
    L74:
        r114 = null;
    L62:
        kc8.b r41 = this.h;
        if (r41 == null) goto L68;
        kc8.y r42 = r41.a;
        if (r42 == null) goto L68;
        r27 = r42.k;
    L68:
        r111 = null;
    L57:
        r25 = new BotModel(r6.getSenderId(), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L48:
        r21 = -1;
        goto L49
    L40:
        r17 = null;
    L27:
        r10 = 0;
        goto L28
    L17:
        r8 = null;
        goto L18
    L9:
        if ((r91 instanceof fb8.d) == false) goto L11;
        r5 = r91.j();
        goto L12
    L11:
        r5 = null;
        goto L12
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        MarkdownTextBlockView r3 = j(r2);
        this.d = r3;
        return r3;
    }
}
