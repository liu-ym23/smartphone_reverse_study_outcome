package eb8;

import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.block.RichMediaType;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new c0());
    }

    public static final boolean a(final jc8.a r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List r0 = r6.a.getMetaInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        Lazy r7 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new d0(r6));
        Iterator r1 = SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r0), new e0()), new f0()).iterator();
    L7:
        if (r1.hasNext() == false) goto L33;
        RichMediaMeta r2 = (RichMediaMeta) r1.next();
        Integer r3 = r2.getSceneType();
        int r4 = RichMediaType.APPLET.getValue();
        if (r3 != null) goto L12;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L7;
        return true;
    L12:
        if (r3.intValue() != r4) goto L24;
        Integer r8 = r2.getPos();
        if (r8 != null) goto L17;
    L18:
        Integer r9 = r2.getPos();
        int r10 = ((Number) r7.getValue()).intValue();
        if (r9 == null) goto L24;
        if (r9.intValue() != r10) goto L24;
    L23:
        r5 = true;
        goto L25
    L17:
        if (r8.intValue() == (-1)) goto L23;
    L33:
        return false;
    }
}
