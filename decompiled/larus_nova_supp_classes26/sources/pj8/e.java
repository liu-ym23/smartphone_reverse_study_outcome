package pj8;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.im.bean.message.block.SearchQueryResultExtend;
import kc8.l;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<a> {
    public oj8.c d;
    public final Lazy e;

    public final String c() {
        return "ContentCodeBlockHolder";
    }

    public final void i() {
        oj8.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public e() {
        this.e = LazyKt.lazy(new d());
    }

    public final jc8.d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r41) {
        a r1 = (a) r41;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        oj8.c r2 = this.d;
        if (r2 == null) goto L79;
        Block r3 = ((jc8.a) r1).a;
        BlockContent r4 = r3.getContent();
        if (r4 == null) goto L7;
        CodeBlock r5 = r4.getCodeBlock();
    L8:
        int r6 = oe8.a.a;
        if (r5 == null) goto L11;
        String r7 = r5.code;
    L13:
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        oe8.b r8 = oe8.a.a(r7, true);
        boolean r9 = h.a;
        if (h.a(null) == false) goto L19;
        if (r5 == null) goto L21;
        String r10 = r5.iconUrlDark;
    L23:
        if (((Boolean) this.e.getValue()).booleanValue() == true) goto L25;
    L27:
        String r24 = null;
    L28:
        kc8.b r11 = jc8.c.a(this, kc8.b.class);
        if (r11 == null) goto L31;
        final y r12 = r11.a;
    L32:
        String r13 = r1.j().getSenderId();
        if (r13 != null) goto L35;
        String r14 = "";
    L36:
        Message r15 = r1.j();
        int r16 = 0;
        if (r12 == null) goto L39;
        boolean r17 = r12.a();
    L40:
        if (r12 == null) goto L42;
        Long r18 = r12.b;
    L43:
        if (r5 == null) goto L49;
        SearchQueryResultExtend r19 = r5.extendFields;
        if (r19 == null) goto L49;
        Integer r20 = r19.thinkingIndex;
        if (r20 == null) goto L49;
        r16 = r20.intValue();
    L49:
        if (r12 == null) goto L51;
        by7.e r110 = r12.c;
    L52:
        if (r12 == null) goto L54;
        RecyclerView r111 = r12.d;
    L55:
        Function0 r21 = new b(r12);
        Function0 r112 = new c(r12);
        String r22 = r8.b;
        String r23 = r8.a;
        if (r23 != null) goto L58;
        String r25 = "";
    L59:
        boolean r26 = r3.isFinish();
        if (r12 == null) goto L62;
        q0 r30 = r12.x;
    L64:
        if (r12 == null) goto L66;
        RecyclerView.Adapter r27 = r12.w;
    L68:
        if ((r27 instanceof ry8.d) == false) goto L70;
        ry8.d r32 = (ry8.d) r27;
    L72:
        if (r11 == null) goto L76;
        l r28 = r11.x;
        if (r28 == null) goto L76;
        Function2 r38 = r28.a;
    L77:
        r2.a(new rj8.a(r14, r15, r17, r18, r16, r110, r111, r21, r112, null, null, null, r22, r24, r25, r26, false, null, null, r30, null, r32, null, false, false, null, null, r38, 131468800), null);
        return;
    L76:
        r38 = null;
        goto L77
    L70:
        r32 = null;
        goto L72
    L66:
        r27 = null;
        goto L68
    L62:
        r30 = null;
        goto L64
    L58:
        r25 = r23;
        goto L59
    L54:
        r111 = null;
        goto L55
    L51:
        r110 = null;
        goto L52
    L42:
        r18 = null;
        goto L43
    L39:
        r17 = false;
        goto L40
    L35:
        r14 = r13;
        goto L36
    L31:
        r12 = null;
        goto L32
    L25:
        if (r3.isFinish() == true) goto L27;
        r24 = r10;
    L21:
        r10 = null;
        goto L23
    L19:
        if (r5 == null) goto L21;
        r10 = r5.iconUrl;
        goto L23
    L11:
        r7 = null;
        goto L13
    L7:
        r5 = null;
        goto L8
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        oj8.c r0 = new oj8.c(r2.getContext());
        this.d = r0;
        return r0.b();
    }
}
