package im8;

import android.view.View;
import android.view.ViewGroup;
import cb8.x1;
import com.larus.bmhome.chat.standarduikit.memory.view.MemoryView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MemoryAction;
import com.larus.im.bean.message.block.MemoryTagBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.d;
import jc8.e;
import km8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ph8.f;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.b<a> {
    public hm8.c d;
    public kc8.b e;
    public final Lazy f;

    public final String c() {
        return "MemoryBlockHolder";
    }

    public c() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r18) {
        a r1 = (a) r18;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.e = jc8.c.a(this, kc8.b.class);
        cd8.a r2 = jc8.c.a(this, cd8.a.class);
        if (r2 == null) goto L5;
        int r7 = r2.a;
    L6:
        Pair r6 = new Pair(0, 0);
        Message r8 = r1.j();
        int r3 = x1.b(((jc8.b) this).a, r1, a.class);
        BlockContent r4 = ((jc8.a) r1).a.getContent();
        ViewGroup.MarginLayoutParams r5 = null;
        if (r4 == null) goto L9;
        MemoryTagBlock r9 = r4.getMemoryBlock();
    L10:
        if (r9 == null) goto L20;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r10 = r9.getActionTitle();
        String r11 = r9.getActionTag();
        String r12 = r9.getIconUrl();
        String r13 = r9.getIconUrlDark();
        List r14 = r9.getActions();
        if (r14 == null) goto L18;
        List r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        MemoryAction r19 = (MemoryAction) r17.next();
        r16.add(new f(r19.getMemoryTipTitle(), r19.getMemoryTipSubTitle()));
        goto L15
    L17:
        ArrayList r110 = r16;
    L19:
        ph8.e r20 = new ph8.e(r10, r11, r12, r13, r110, r9.getLoading(), r9.getLoadingHide());
    L21:
        km8.a r21 = new km8.a(r6, r7, r8, r20, Integer.valueOf(r3));
        hm8.c r22 = this.d;
        if (r22 == null) goto L24;
        r22.a(r21, (g) this.f.getValue());
    L24:
        hm8.c r23 = this.d;
        if (r23 == null) goto L29;
        MemoryView r24 = r23.b();
        if (r24 == null) goto L29;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
    L31:
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r5 = (ViewGroup.MarginLayoutParams) r25;
    L33:
        if (r5 == null) goto L37;
        r5.setMarginStart(i5.q());
        r5.setMarginEnd(i5.q());
        return;
    L37:
        return;
    L29:
        r25 = null;
        goto L31
    L18:
        r110 = null;
        goto L19
    L20:
        r20 = null;
        goto L21
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        hm8.c r0 = new hm8.c(r2.getContext());
        this.d = r0;
        return r0.b();
    }
}
