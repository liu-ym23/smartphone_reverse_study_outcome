package si8;

import com.larus.bmhome.chat.search.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements pi8.a {
    public e() {
    }

    @Override // pi8.a
    public final o a(k r35, oi8.c r36) {
        Intrinsics.checkNotNullParameter(r35, "originData");
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.chat.search.b r1 = r35.e();
        if (r1 == null) goto L7;
        com.larus.bmhome.chat.search.b.d r2 = r1.f();
        if (r2 == null) goto L7;
        List<VideoInfo> r3 = r2.a();
    L8:
        List<VideoInfo> r4 = r3;
        int r5 = 0;
        if (r4 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        Iterator<T> r7 = r3.iterator();
    L20:
        if (r7.hasNext() == false) goto L26;
        Object r8 = r7.next();
        int r9 = r5 + 1;
        if (r5 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        VideoInfo r10 = VideoInfo.copy$default((VideoInfo) r8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
        r10.setVideoInfoList(new ArrayList(r4));
        r10.setVideoIndex(r5);
        r0.add(r10);
        r5 = r9;
        goto L20
    L26:
        return new o(r0, true);
    L17:
        return new o(r0, true);
    L11:
        if (r4.isEmpty() == true) goto L14;
        r6 = false;
    L7:
        r3 = null;
        goto L8
    }
}
