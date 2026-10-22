package com.larus.bmhome.block.holder.deepthink;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockControlInfo;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends jc8.b<gb8.b> {
    public boolean d;
    public final Lazy e;
    public kc8.b f;
    public ib8.f g;
    public Boolean h;
    public Job i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b extends ib8.k {
        public final /* synthetic */ l i;

        public b(l r2, kc8.b r3, lb8.b r4) {
            this.i = r2;
            super(r3, null, r4, 2);
        }

        @Override // ib8.g
        public final void b(Message r1, st8.a r2, ow8.a r3, LongClickSource r4) {
            Intrinsics.checkNotNullParameter(r2, "anchorView");
            Intrinsics.checkNotNullParameter(r4, "longClickSource");
            kc8.b r5 = this.i.f;
            if (r5 == null) goto L10;
            kc8.y r6 = r5.a;
            if (r6 == null) goto L11;
            kc8.z r7 = r6.A;
            if (r7 == null) goto L12;
            r7.b(null, r2, r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "DeepThinkBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        Job r0 = this.i;
        if (r0 != null) goto L5;
    L10:
        ib8.f r1 = this.g;
        if (r1 == null) goto L13;
        r1.f();
    L13:
        ib8.f r2 = this.g;
        if (r2 == null) goto L18;
        st8.a r3 = r2.b();
        if (r3 == null) goto L18;
        ExposeXTrackerExtKt.e(r3);
    L18:
        this.d = true;
        this.h = null;
        this.f = null;
        return;
    L5:
        if (r0.isActive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        goto L10
    }

    public l() {
        this.d = true;
        this.e = LazyKt.lazy(new c(this));
        this.j = LazyKt.lazy(new d(this));
        this.k = LazyKt.lazy(new e(this));
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r3) {
        gb8.b r4 = (gb8.b) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        ib8.f r0 = this.g;
        if (r0 == null) goto L5;
        DeepThinkFoldStatus r1 = ((com.larus.bmhome.block.newheader.foldcontainer.a) r0.c.getValue()).p.a();
    L7:
        if (ic8.q.a(r1) == true) goto L9;
    L11:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L15;
        int r6 = c7.b(6);
    L17:
        return new jc8.d(0, 0, 0, r6);
    L15:
        r6 = 0;
        goto L17
    L9:
        if (r4.n() == true) goto L11;
        r5 = true;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    @Override // jc8.b
    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        k((gb8.b) r1);
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ib8.f r0 = new ib8.f(r2.getContext());
        this.g = r0;
        return r0.b();
    }

    public final void k(final gb8.b r10) {
        Intrinsics.checkNotNullParameter(r10, "blockModel");
        this.f = (kc8.b) jc8.c.a(this, kc8.b.class);
        ib8.f r0 = this.g;
        if (r0 == null) goto L7;
        st8.a r1 = r0.b();
        if (r1 == null) goto L7;
        ExposeXTrackerExtKt.e(r1);
    L7:
        ib8.f r2 = this.g;
        if (r2 == null) goto L12;
        st8.a r3 = r2.b();
        if (r3 == null) goto L12;
        ExposeXTrackerExtKt.b(r3, new i(r10, this));
    L12:
        j(r10, false, null);
        ((b) this.k.getValue()).h = new f(this, r10);
        ((lb8.b) this.j.getValue()).b = new g(this, r10);
        Job r4 = this.i;
        if (r4 != null) goto L15;
    L20:
        Message r5 = r10.j();
        ComplexTaskDelegate r6 = ComplexTaskDelegate.b;
        if (r6.f(r5) == true) goto L23;
        return;
    L23:
        if (r6.a(r5, r10.a) == false) goto L27;
        FLogger.a.i("DeepThinkBlockHolder", "checkDelayUpdate, delay update, message: " + r5);
        this.i = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DeepThinkBlockHolder$checkDelayUpdate$2(r5, this, r10, null), 3, null);
        return;
    L27:
        return;
    L15:
        if (r4.isActive() == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L20;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        goto L20
    }

    public final void j(gb8.b r22, boolean r23, ib8.d0 r24) {
        kc8.b r1 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r1 == null) goto L7;
        kc8.r r3 = r1.f;
        if (r3 == null) goto L7;
        boolean r4 = r3.f;
    L8:
        boolean r5 = r22.b(r4);
        List<jc8.a> r6 = r22.i();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L9:
        boolean r11 = true;
        String r12 = null;
        if (r8.hasNext() == false) goto L34;
        Object r9 = r8.next();
        Block r10 = ((jc8.a) r9).a;
        if (r10.getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.e) goto L31;
        BlockContent r13 = r10.getContent();
        if (r13 == null) goto L18;
        TextBlock r14 = r13.getTextBlock();
        if (r14 == null) goto L18;
        r12 = r14.text;
    L18:
        if (r12 != null) goto L20;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L32;
        BlockControlInfo r16 = r10.getControlInfo();
        if (r16 == null) goto L28;
        boolean r17 = Intrinsics.areEqual(r16.isVisible(), Boolean.FALSE);
    L29:
        if (r17 == false) goto L31;
    L28:
        r17 = false;
    L32:
        if (r11 == true) goto L9;
        r7.add(r9);
        goto L9
    L20:
        if (r12.length() == 0) goto L23;
        r15 = false;
    L31:
        r11 = false;
        goto L32
    L34:
        mb8.a r18 = new mb8.a(r7, r23, r22.j(), this.f, r5, null);
        kc8.b r19 = this.f;
        if (r19 == null) goto L37;
        kc8.o r110 = r19.b;
    L38:
        com.larus.bmhome.utils.z r20 = com.larus.bmhome.utils.z.a;
        Boolean r21 = this.h;
        if (r19 == null) goto L43;
        kc8.y r25 = r19.a;
        if (r25 == null) goto L43;
        boolean r26 = Intrinsics.areEqual(r25.h, Boolean.TRUE);
    L44:
        kc8.b r2 = this.f;
        if (r2 == null) goto L53;
        kc8.y r27 = r2.a;
        if (r27 == null) goto L53;
        kc8.j r28 = r27.r;
        if (r28 == null) goto L53;
        Function0<Long> r29 = r28.d;
        if (r29 == null) goto L53;
        Long r111 = (Long) r29.invoke();
    L54:
        if (r1 == null) goto L58;
        kc8.r r30 = r1.f;
        if (r30 == null) goto L58;
        DeepThinkFoldStatus r31 = r30.a;
    L59:
        if (r1 == null) goto L63;
        kc8.r r32 = r1.f;
        if (r32 == null) goto L63;
        boolean r112 = r32.b;
    L64:
        if (r1 == null) goto L68;
        kc8.r r33 = r1.f;
        if (r33 == null) goto L68;
        Integer r113 = r33.c;
    L69:
        if (r1 == null) goto L73;
        kc8.r r34 = r1.f;
        if (r34 == null) goto L73;
        Integer r114 = r34.d;
    L74:
        if (r1 == null) goto L78;
        kc8.r r35 = r1.f;
        if (r35 == null) goto L78;
        Integer r36 = r35.e;
    L79:
        r20.getClass();
        ib8.b r37 = new ib8.b(com.larus.bmhome.utils.z.a(r24, r5, r22, r21, r19, r26, r111, r31, r112, r113, r114, r36, false), null, r18, null, null, r110, 26);
        ib8.f r38 = this.g;
        if (r38 == null) goto L82;
        r38.a(r37, (b) this.k.getValue());
    L82:
        this.h = Boolean.valueOf(com.larus.im.bean.message.a.f0(r22.j()));
        return;
    L78:
        r36 = null;
    L73:
        r114 = null;
    L68:
        r113 = null;
    L63:
        r112 = true;
    L58:
        r31 = null;
    L53:
        r111 = null;
    L43:
        r26 = false;
        goto L44
    L37:
        r110 = null;
    L7:
        r4 = false;
        goto L8
    }
}
