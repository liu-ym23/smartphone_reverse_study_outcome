package en8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaLayoutAdapter;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaLayoutView;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.b0;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.e0;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.g0;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.h0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import com.larus.im.bean.message.block.RichMediaLayoutStyleConfig;
import dn8.c;
import fn8.x;
import java.util.LinkedHashMap;
import java.util.List;
import jc8.d;
import jc8.e;
import kc8.y;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public c d;

    public final void i() {
        c r0 = this.d;
        if (r0 == null) goto L12;
        h0 r1 = r0.b;
        r1.k = null;
        r1.j++;
        Job r3 = r1.i;
        if (r3 == null) goto L7;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L7:
        r1.i = null;
        r1.f();
        ((LinkedHashMap) r1.o).clear();
        r1.a = null;
        r1.b = null;
        r1.c = CollectionsKt.emptyList();
        r1.d = CollectionsKt.emptyList();
        r1.e = CollectionsKt.emptyList();
        r1.f = null;
        r1.g = null;
        b0 r4 = r1.h;
        if (r4 == null) goto L10;
        r4.a();
    L10:
        r1.h = null;
        RichMediaLayoutView r2 = (RichMediaLayoutView) r0.a.getValue();
        r2.a = null;
        r2.setOnLongClickListener(null);
        RichMediaLayoutAdapter r5 = r2.c;
        List<x> r6 = CollectionsKt.emptyList();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "newItems");
        r5.a = r6;
        r5.b = null;
        r5.notifyDataSetChanged();
        return;
    }

    public b() {
    }

    public final d f(jc8.a r5) {
        a r6 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        d r7 = e.d(r6);
        mh8.c r0 = jc8.c.a(this, mh8.c.class);
        if (r0 != null) goto L5;
        return r7;
    L5:
        return d.a(r7, -RangesKt.coerceAtLeast(r0.a, 0), -RangesKt.coerceAtLeast(r0.b, 0), 0, 10);
    }

    public final void g(jc8.a r15) {
        a r16 = (a) r15;
        Intrinsics.checkNotNullParameter(r16, "blockModel");
        kc8.b r0 = jc8.c.a(this, kc8.b.class);
        mh8.c r1 = jc8.c.a(this, mh8.c.class);
        BlockContent r2 = ((jc8.a) r16).a.getContent();
        Integer r3 = null;
        if (r2 == null) goto L5;
        RichMediaLayoutBlock r4 = r2.getRichMediaLayoutBlock();
    L6:
        if (r4 == null) goto L8;
        List r5 = r4.richMediaItem;
    L9:
        if (r5 != null) goto L11;
        r5 = CollectionsKt.emptyList();
    L11:
        List r9 = r5;
        final c r6 = this.d;
        if (r6 == null) goto L51;
        Message r7 = r16.j();
        String r8 = ((jc8.a) r16).a.getBlockId();
        int r10 = r16.j;
        if (r4 == null) goto L18;
        RichMediaLayoutStyleConfig r17 = r4.styleConfig;
        if (r17 == null) goto L18;
        String r18 = r17.enableCreationLayoutFallback;
    L19:
        boolean r11 = Intrinsics.areEqual(r18, "1");
        if (r1 == null) goto L31;
        Integer r12 = r1.c;
        if (r12 == null) goto L31;
        if (r12.intValue() <= 0) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == false) goto L29;
        r3 = r12;
    L29:
        if (r3 == null) goto L31;
        int r14 = r3.intValue();
    L37:
        int r19 = r14;
    L39:
        if (r1 == null) goto L41;
        int r110 = r1.a;
    L42:
        if (r1 == null) goto L44;
        int r111 = r1.b;
    L45:
        e0 r112 = new e0(r7, r8, r10, r9, r11, r19, r110, r111);
        g0 r20 = new g0(r0);
        Intrinsics.checkNotNullParameter(r112, "vmData");
        h0 r21 = r6.b;
        r21.k = new dn8.b(r6);
        r21.c(r112, r20);
        RichMediaLayoutView r113 = (RichMediaLayoutView) r6.a.getValue();
        h0 r22 = r6.b;
        e0 r23 = r22.a;
        if (r23 != null) goto L48;
        fn8.b0 r24 = h0.q;
    L49:
        r113.a(r24, r6.b.p);
        return;
    L48:
        r24 = new fn8.b0(r22.e, r23.g, r23.h);
        goto L49
    L44:
        r111 = 0;
        goto L45
    L41:
        r110 = 0;
        goto L42
    L26:
        r13 = false;
    L31:
        if (r0 == null) goto L38;
        y r25 = r0.a;
        if (r25 == null) goto L38;
        Function0 r26 = r25.F;
        if (r26 == null) goto L38;
        r14 = ((Number) r26.invoke()).intValue();
    L38:
        r19 = 0;
    L18:
        r18 = null;
        goto L19
    L51:
        return;
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        c r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new c(r2.getContext());
    L5:
        this.d = r0;
        return (RichMediaLayoutView) r0.a.getValue();
    }
}
