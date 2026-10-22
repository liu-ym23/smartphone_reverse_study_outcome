package rk8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final int l() {
        int r0 = j.a;
        return j.r0;
    }

    public final boolean e(jc8.a r7) {
        if ((r7 instanceof a) == true) goto L5;
        return false;
    L5:
        a r8 = (a) r7;
        if (((jc8.a) this).a.hashCode() == ((jc8.a) r8).a.hashCode()) goto L8;
        return false;
    L8:
        List r0 = i();
        List r9 = r8.i();
        if (r0.size() != r9.size()) goto L32;
        Collection r2 = CollectionsKt.getIndices(r0);
        if ((r2 instanceof Collection) == true) goto L13;
    L15:
        IntIterator r3 = r2.iterator();
    L17:
        if (r3.hasNext() == false) goto L14;
        int r4 = r3.nextInt();
        if (((jc8.a) ListProtector.get(r0, r4)).a.hashCode() != ((jc8.a) ListProtector.get(r9, r4)).a.hashCode()) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L17;
        boolean r10 = false;
    L24:
        if (r10 == false) goto L33;
        return true;
    L33:
        return false;
    L21:
        r5 = false;
    L14:
        r10 = true;
        goto L24
    L13:
        if (r2.isEmpty() == false) goto L15;
    L32:
        return false;
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
