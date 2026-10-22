package km0;

import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s71.b;
import s71.d;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements g<v61.a> {
    public static final List<CardTypeAndPriority> a = null;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = CollectionsKt.listOf(new CardTypeAndPriority[]{CardTypeAndPriority.DrawAndGuess, CardTypeAndPriority.WatchVideo, CardTypeAndPriority.AudienceLink, CardTypeAndPriority.VideoTalk});
    }

    public static boolean c(v61.a r3) {
        List<CardTypeAndPriority> r0 = a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(((CardTypeAndPriority) r2.next()).getType());
        goto L4
    L7:
        return CollectionsKt.contains(r1, r3.j);
    }

    public final d a(v61.a r2, c r3) {
        v61.a r4 = (v61.a) r3;
        Intrinsics.checkNotNullParameter(r2, "us");
        Intrinsics.checkNotNullParameter(r4, "others");
        if (r2.k < r4.k) goto L6;
        return d.c.a;
    L6:
        if (c(r2) == false) goto L9;
        return d.d.a;
    L9:
        return d.a.a;
    }

    public final e b(c r2, v61.a r3) {
        v61.a r4 = (v61.a) r2;
        Intrinsics.checkNotNullParameter(r4, "us");
        Intrinsics.checkNotNullParameter(r3, "winner");
        if (r4.k > r3.k) goto L8;
        if (c(r4) == false) goto L8;
        return b.a;
    L8:
        return s71.a.a;
    }
}
