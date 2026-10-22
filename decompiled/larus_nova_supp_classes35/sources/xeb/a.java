package xeb;

import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Triple<HashSet<String>, HashSet<String>, HashSet<String>> a = null;

    /* JADX INFO: renamed from: xeb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0320a {
        UIFeedCard getItem(int r1);

        int getSize();
    }

    static {
        a = new Triple(new HashSet(), new HashSet(), new HashSet());
    }

    @JvmStatic
    public static final Set<String> c(List<? extends UIFeedCard> r2) {
        HashSet r0 = new HashSet();
        if (r2 == null) goto L8;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.add(((UIFeedCard) r3.next()).getId());
    L8:
        return r0;
    }

    @JvmStatic
    public static final void e(Set r5) {
        Log.i("FeedItemListUtils", "start measure preloadIds = null, loadedIds = null, shownIds = " + Integer.valueOf(((HashSet) r5).size()));
        Triple<HashSet<String>, HashSet<String>, HashSet<String>> r0 = a;
        ((HashSet) r0.getThird()).addAll(r5);
        Log.i("FeedItemListUtils", "Local Total Preload Rate = " + a((HashSet) r0.getFirst(), (HashSet) r0.getThird()) + ", Total Success Rate = " + a((HashSet) r0.getSecond(), (HashSet) r0.getThird()));
        Log.i("FeedItemListUtils", "Local Current Preload Rate = " + a((HashSet) r0.getFirst(), new HashSet(r5)) + ", Current Success Rate = " + a((HashSet) r0.getSecond(), new HashSet(r5)));
    }

    public static double a(HashSet r5, HashSet r6) {
        Intrinsics.checkNotNullParameter(r5, "preloadIds");
        Intrinsics.checkNotNullParameter(r6, "shownIds");
        Object r0 = r6.clone();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.HashSet<*>");
        HashSet r1 = (HashSet) r0;
        TypeIntrinsics.asMutableCollection(r1).retainAll(r5);
        double r2 = (((double) r1.size()) * 1.0d) / ((double) r6.size());
        Log.i("FeedItemListUtils", "rate = " + r2 + '(' + r1.size() + '/' + r6.size() + ')');
        return r2;
    }

    @JvmStatic
    public static final List b(AtomicInteger r3, AtomicInteger r4, StableLinearLayoutManager r5, LarkFeedInBoxListAdapter r6) {
        Intrinsics.checkNotNullParameter(r3, "lastFirstVisiblePosition");
        Intrinsics.checkNotNullParameter(r4, "lastEndVisiblePosition");
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        int r2 = r5.findFirstVisibleItemPosition();
        int r7 = r5.findLastVisibleItemPosition();
        Intrinsics.checkNotNullParameter(r3, "lastFirstVisiblePosition");
        Intrinsics.checkNotNullParameter(r4, "lastEndVisiblePosition");
        return d(r2, r7, r3, r4, new b(r6));
    }

    @JvmStatic
    public static final List<UIFeedCard> d(int r2, int r3, AtomicInteger r4, AtomicInteger r5, InterfaceC0320a r6) {
        Intrinsics.checkNotNullParameter(r4, "lastFirstVisiblePosition");
        Intrinsics.checkNotNullParameter(r5, "lastEndVisiblePosition");
        Intrinsics.checkNotNullParameter(r6, "feedProvider");
        if (r2 == (-1)) goto L24;
        if (r3 == (-1)) goto L31;
        if (r2 < r3) goto L7;
        return null;
    L7:
        if (r2 == r4.get()) goto L9;
    L13:
        Log.d("FeedItemListUtils", "getSpecificPageItems:" + r2 + '/' + r3 + '/' + r4 + '/' + r5);
        r4.set(r2);
        r5.set(r3);
        ArrayList r7 = new ArrayList();
        int r8 = r6.getSize();
    L14:
        if (r2 >= r3) goto L23;
        if (r2 < 0) goto L22;
        if (r2 >= r8) goto L22;
        UIFeedCard r0 = r6.getItem(r2);
        if (r0 == null) goto L22;
        r7.add(r0);
    L22:
        r2 = r2 + 1;
        goto L14
    L23:
        return r7;
    L9:
        if (r3 != r5.get()) goto L13;
        if ((r4.get() + r5.get()) <= 0) goto L13;
        return null;
    L31:
        return null;
    L24:
        return null;
    }
}
