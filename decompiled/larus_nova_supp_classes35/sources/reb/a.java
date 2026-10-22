package reb;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> {
    public final List<e> a;
    public final b<T> b;
    public final Map<FeedCard.Type, T> c;
    public final Map<AppFeedCardType, T> d;

    /* JADX INFO: renamed from: reb.a$a, reason: collision with other inner class name */
    public static final class C0295a {
    }

    public interface b<T> {
        T a(e r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedCard.Type.values().length];
            r0[FeedCard.Type.APP_FEED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends e> r4, b<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "injectFactories");
        Intrinsics.checkNotNullParameter(r5, "creator");
        this.a = r4;
        this.b = r5;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        e r7 = (e) r6.next();
        T r0 = this.b.a(r7);
        if (r0 == null) goto L4;
        this.c.put(r7.type(), r0);
        if (r7.bizType() == AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE) goto L4;
        this.d.put(r7.bizType(), r0);
        goto L4
    }

    public final T a(FeedCard.Type r5, AppFeedCardType r6) {
        if (r5 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != (-1)) goto L9;
        Log.e("OpenFeedCardWrapper", "feedType is empty");
        return null;
    L9:
        if (r1 != 1) goto L19;
        if (r6 == null) goto L16;
        T r7 = (T) ((LinkedHashMap) this.d).get(r6);
        if (r7 == null) goto L16;
        return r7;
    L16:
        Log.e("OpenFeedCardWrapper", "bizType is empty");
        return null;
    L19:
        return (T) ((LinkedHashMap) this.c).get(r5);
    L5:
        r1 = c.a[r5.ordinal()];
        goto L7
    }
}
