package seb;

import aeb.f;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.shared.fg.FeedFgSyncUtil;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public final aeb.b a;
    public final d b;
    public final List<aeb.c> c;

    public static final class a {
    }

    static {
    }

    public b(aeb.b r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "dependency");
        Intrinsics.checkNotNullParameter(r4, "feedCardContext");
        this.a = r3;
        this.b = r4;
        Map r5 = com.ss.android.lark.im.base.d.a;
        List r6 = com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_SWIPE_ACTION_PROVIDER, c.class);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = ((ArrayList) r6).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r7.add(((c) r8.next()).a(this.b));
        goto L4
    L6:
        this.c = r7;
    }

    public final LinkedHashMap<FeedActionType, aeb.c> a(List<? extends FeedActionType> r7, List<? extends aeb.c> r8) {
        Intrinsics.checkNotNullParameter(r7, "actionTypeList");
        if (r7.isEmpty() == false) goto L6;
        Log.i("FeedActionManager", "actionTypeList is empty, action without result");
        return new LinkedHashMap();
    L6:
        List<aeb.c> r0 = this.c;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        r4.put(((aeb.c) r2).d(), r2);
        goto L8
    L10:
        Map r3 = MapsKt.toMutableMap(r4);
        List<? extends aeb.c> r5 = r8;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L23;
        List<? extends aeb.c> r9 = r8;
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator<T> r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        Object r12 = r11.next();
        r10.put(((aeb.c) r12).d(), r12);
        goto L20
    L22:
        r3.putAll(r10);
    L23:
        LinkedHashMap<FeedActionType, aeb.c> r13 = new LinkedHashMap();
        Iterator<T> r14 = r7.iterator();
    L25:
        if (r14.hasNext() == false) goto L29;
        FeedActionType r15 = (FeedActionType) r14.next();
        aeb.c r16 = (aeb.c) r3.get(r15);
        if (r16 == null) goto L25;
        r13.put(r15, r16);
        goto L25
    L29:
        return r13;
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
        goto L17
    }

    public static void b(List r2, ueb.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "actionTypeList");
        Intrinsics.checkNotNullParameter(r3, "itemContainer");
        List<FeedActionType> r1 = r3.D1();
        if (r1 == null) goto L5;
        r2.removeAll(r1);
    L5:
        int r5 = seb.a.a;
        FeedListAdapter.f r6 = r3.c1();
        if (r6 == null) goto L8;
        r6.a();
    L8:
        Intrinsics.checkNotNullParameter(r2, "actionTypeList");
        com.ss.android.lark.feed.shared.fg.a.a();
        if (com.ss.android.lark.feed.shared.fg.a.b == true) goto L12;
        r2.remove(FeedActionType.TOPPING);
    L12:
        if (((Boolean) FeedFgSyncUtil.a.getValue()).booleanValue() == true) goto L15;
        r2.remove(FeedActionType.ADD_FEED_TAG);
        r2.remove(FeedActionType.REMOVE_FROM_TAG);
    L15:
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("messager.bot.p2p_chat_mute") == true) goto L17;
        r2.remove(FeedActionType.BOT_MUTE);
    L17:
        if (r4 == false) goto L22;
        List<FeedActionType> r7 = r3.w0();
        if (r7 == null) goto L23;
        r2.addAll(r7);
        return;
    L23:
        return;
    }

    public final List<FeedActionType> c(UIFeedCard r3, f r4, ueb.a r5) {
        Intrinsics.checkNotNullParameter(r3, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r4, "feedAction");
        Intrinsics.checkNotNullParameter(r5, "itemContainer");
        boolean r0 = true;
        List<FeedActionType> r6 = CollectionsKt.toMutableList(e(r3, r4, true));
        b(r6, r5, false);
        if (r6.size() > 3) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L8;
        List<FeedActionType> r7 = r6;
    L9:
        if (r7 == null) goto L15;
        List<FeedActionType> r8 = r6.subList(0, 3);
        if (r8 != null) goto L14;
        return r6;
    L14:
        return r8;
    L15:
        return r6;
    L8:
        r7 = null;
        goto L9
    }

    public final List<FeedActionType> d(UIFeedCard r2, f r3, ueb.a r4) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r3, "feedAction");
        Intrinsics.checkNotNullParameter(r4, "itemContainer");
        List<FeedActionType> r5 = CollectionsKt.toMutableList(e(r2, r3, false));
        b(r5, r4, false);
        if (r5.size() <= 1) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        List<FeedActionType> r7 = r5;
    L9:
        if (r7 == null) goto L15;
        List<FeedActionType> r8 = r5.subList(0, 1);
        if (r8 != null) goto L14;
        return r5;
    L14:
        return r8;
    L15:
        return r5;
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = false;
        goto L6
    }

    public final List<FeedActionType> e(UIFeedCard r5, f r6, boolean r7) {
        boolean r0 = false;
        if (r7 == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r7 == false) goto L12;
    L16:
        if (r2 == true) goto L38;
        if (r0 == true) goto L38;
        FeedFolder r1 = this.b.f();
        int r3 = dfb.a.a;
        if ((!FeedFolderCompat.INSTANCE.getFLAG().isSameFolderWith(r1)) == false) goto L35;
        if (r7 == false) goto L23;
        heb.a.a.getFeedDependency().getClass();
        List<FeedActionType> r4 = new com.ss.android.lark.feed.shared.data.swipe.a().c;
    L24:
        List<FeedActionType> r8 = CollectionsKt.toList(CollectionsKt.intersect(CollectionsKt.toList(CollectionsKt.union(r6.k(r5), CollectionsKt.union(r6.n(r5), r6.e(r5)))), CollectionsKt.toSet(r4)));
        if (r7 == true) goto L27;
        return r8;
    L27:
        if ((!r8.isEmpty()) == false) goto L48;
        List<FeedActionType> r9 = com.ss.android.lark.feed.shared.data.swipe.a.h;
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((ArrayList) r9).iterator();
    L30:
        if (r11.hasNext() == false) goto L49;
        Object r12 = r11.next();
        if (r8.contains((FeedActionType) r12) == false) goto L30;
        r10.add(r12);
        goto L30
    L49:
        return r10;
    L48:
        return r8;
    L23:
        heb.a.a.getFeedDependency().getClass();
        r4 = new com.ss.android.lark.feed.shared.data.swipe.a().d;
        goto L24
    L35:
        if (r7 == false) goto L51;
        return r6.e(r5);
    L51:
        return r6.k(r5);
    L38:
        if (r7 == false) goto L41;
        return r6.h(r5);
    L41:
        return r6.f(r5);
    L12:
        if ((!r6.f(r5).isEmpty()) == false) goto L16;
        if ((!r6.k(r5).isEmpty()) == false) goto L16;
        r0 = true;
        goto L16
    L5:
        if ((!r6.h(r5).isEmpty()) == false) goto L9;
        if ((!r6.e(r5).isEmpty()) == false) goto L9;
        r2 = true;
        goto L10
    }
}
