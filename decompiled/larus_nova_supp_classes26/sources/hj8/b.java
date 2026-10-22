package hj8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.clarification.u;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import com.larus.im.bean.message.block.InteractionAskQuestionCapability;
import ij8.i;
import ij8.p;
import java.util.Iterator;
import java.util.List;
import jj8.f;
import jj8.g;
import jj8.h;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<hj8.a> {
    public gj8.c d;
    public final a e;

    public static final class a implements g {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // jj8.g
        public final void a(f r2) {
            Intrinsics.checkNotNullParameter(r2, "vmData");
            u r3 = (u) jc8.c.a(this.a, u.class);
            if (r3 == null) goto L8;
            Function0<Unit> r4 = r3.h;
            if (r4 == null) goto L9;
            r4.invoke();
            return;
        L9:
            return;
        }

        @Override // jj8.g
        public final BaseResourceViewHolder.a c(f r2) {
            Intrinsics.checkNotNullParameter(r2, "vmData");
            u r3 = (u) jc8.c.a(this.a, u.class);
            if (r3 != null) goto L7;
            return null;
        L7:
            return r3.j;
        }

        @Override // jj8.g
        public final void b(f r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "vmData");
            Intrinsics.checkNotNullParameter(r5, "optionId");
            u r0 = (u) jc8.c.a(this.a, u.class);
            if (r0 != null) goto L5;
            return;
        L5:
            InteractionAskBlock r1 = r4.b;
            if (r1 == null) goto L27;
            List r2 = r1.getQuestions();
            if (r2 == null) goto L28;
            InteractionAskQuestion r6 = (InteractionAskQuestion) CollectionsKt.getOrNull(r2, r4.c);
            if (r6 == null) goto L29;
            List r7 = r6.getOptions();
            if (r7 == null) goto L30;
            Iterator r8 = r7.iterator();
        L15:
            if (r8.hasNext() == false) goto L19;
            Object r3 = r8.next();
            if (Intrinsics.areEqual(((InteractionAskOption) r3).getOptionId(), r5) == false) goto L15;
        L20:
            InteractionAskOption r9 = (InteractionAskOption) r3;
            if (r9 == null) goto L31;
            r0.i.invoke(Integer.valueOf(r0.a), r9);
            return;
        L31:
            return;
        L19:
            r3 = null;
            goto L20
        L30:
            return;
        L29:
            return;
        L28:
            return;
        }
    }

    public final String c() {
        return "InteractionAskBlockHolder";
    }

    public b() {
        this.e = new a(this);
    }

    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((hj8.a) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    public final void g(jc8.a r21) {
        hj8.a r1 = (hj8.a) r21;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        u r2 = (u) jc8.c.a(this, u.class);
        if (r2 == null) goto L5;
        int r3 = r2.a;
    L6:
        List r4 = r1.i.getQuestions();
        if (r4 != null) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        int r9 = RangesKt.coerceIn(r3, 0, RangesKt.coerceAtLeast(r4.size() - 1, 0));
        List r5 = r1.i.getQuestions();
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        InteractionAskQuestion r6 = (InteractionAskQuestion) CollectionsKt.getOrNull(r5, r9);
        gj8.c r7 = this.d;
        if (r7 == null) goto L83;
        Message r8 = r1.j();
        InteractionAskBlock r10 = r1.i;
        if (r2 == null) goto L18;
        List<String> r11 = r2.b;
        if (r11 == null) goto L18;
    L19:
        List<String> r12 = r11;
        if (r2 == null) goto L23;
        String r13 = r2.c;
        if (r13 == null) goto L23;
    L24:
        String r14 = r13;
        if (r6 == null) goto L29;
        InteractionAskQuestionCapability r15 = r6.getQuestionCapability();
        if (r15 == null) goto L29;
        boolean r16 = Intrinsics.areEqual(r15.getAllowText(), Boolean.TRUE);
    L30:
        List r18 = null;
        if (r6 == null) goto L35;
        InteractionAskQuestionCapability r17 = r6.getQuestionCapability();
        if (r17 == null) goto L35;
        String r19 = r17.getTextPlaceholder();
    L37:
        if (r19 != null) goto L39;
        String r110 = "";
    L40:
        if (r2 == null) goto L42;
        boolean r20 = r2.d;
    L43:
        boolean r111 = r20;
        if (r2 == null) goto L46;
        int r22 = r2.e;
    L47:
        if (r2 == null) goto L50;
        List<ResourceItemBean> r23 = r2.f;
        if (r23 == null) goto L50;
    L51:
        List<ResourceItemBean> r112 = r23;
        if (r2 == null) goto L54;
        boolean r24 = r2.g;
    L55:
        f r113 = new f(r8, r10, r9, r12, r14, r16, r110, r111, r22, r112, r24);
        a r25 = this.e;
        Intrinsics.checkNotNullParameter(r113, "vmData");
        h r26 = (h) r7.b.getValue();
        r26.getClass();
        Intrinsics.checkNotNullParameter(r113, "vmData");
        r26.a = r113;
        r26.b = r25;
        f r27 = ((h) r7.b.getValue()).a;
        if (r27 != null) goto L58;
        r27 = new f(0);
    L58:
        InteractionAskBlock r28 = r27.b;
        if (r28 == null) goto L61;
        List r29 = r28.getQuestions();
    L62:
        if (r29 != null) goto L64;
        r29 = CollectionsKt.emptyList();
    L64:
        InteractionAskQuestion r30 = (InteractionAskQuestion) CollectionsKt.getOrNull(r29, RangesKt.coerceIn(r27.c, 0, RangesKt.coerceAtLeast(r29.size() - 1, 0)));
        if (r30 == null) goto L67;
        String r31 = r30.getTitle();
    L68:
        if (r31 != null) goto L70;
        String r32 = "";
    L71:
        if (r30 == null) goto L75;
        Integer r33 = r30.getType();
        if (r33 == null) goto L75;
        int r34 = r33.intValue();
    L76:
        if (r30 == null) goto L78;
        r18 = r30.getOptions();
    L78:
        if (r18 != null) goto L80;
        List r35 = CollectionsKt.emptyList();
    L81:
        ((i) r7.a.getValue()).f(new p(r32, r34, r35, r27.d, r27.f, r27.g, r27.h, r27.i, r27.j, r27.k), ((h) r7.b.getValue()).c);
        return;
    L80:
        r35 = r18;
    L75:
        r34 = 0;
        goto L76
    L70:
        r32 = r31;
        goto L71
    L67:
        r31 = null;
        goto L68
    L61:
        r29 = null;
        goto L62
    L54:
        r24 = r1.p;
    L50:
        r23 = r1.o;
        goto L51
    L46:
        r22 = r1.n;
        goto L47
    L42:
        r20 = r1.m;
        goto L43
    L39:
        r110 = r19;
    L35:
        r19 = null;
    L29:
        r16 = false;
    L23:
        r13 = r1.l;
    L18:
        r11 = r1.k;
        goto L19
    L83:
        return;
    L5:
        r3 = r1.o();
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        gj8.c r0 = new gj8.c(r2.getContext());
        this.d = r0;
        return (i) r0.a.getValue();
    }
}
