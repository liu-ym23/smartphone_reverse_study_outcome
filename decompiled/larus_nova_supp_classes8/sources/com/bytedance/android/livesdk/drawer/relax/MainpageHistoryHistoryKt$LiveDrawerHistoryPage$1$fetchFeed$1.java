package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.m2;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", "first", "", "loadmore", "action", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$fetchFeed$1 extends Lambda implements Function3<Boolean, Boolean, Function0<? extends Unit>, Unit> {
    final /* synthetic */ Function0 $dataList;
    final /* synthetic */ Function2 $formatFeedItem;
    final /* synthetic */ e $globalData;
    final /* synthetic */ Function0 $hasMore;
    final /* synthetic */ Ref.BooleanRef $isFetching;
    final /* synthetic */ Function0 $maxTime;
    final /* synthetic */ Function1 $setDataList;
    final /* synthetic */ Function1 $setExtra;
    final /* synthetic */ Function1 $setFirstLoading;
    final /* synthetic */ Function1 $setHasMore;
    final /* synthetic */ Function1 $setMaxTime;
    final /* synthetic */ Function1 $setPageName;

    public MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$fetchFeed$1(Ref.BooleanRef r1, Function0 r2, Function0 r3, e r4, Function2 r5, Function1 r6, Function1 r7, Function1 r8, Function1 r9, Function1 r10, Function0 r11, Function1 r12) {
        this.$isFetching = r1;
        this.$hasMore = r2;
        this.$maxTime = r3;
        this.$globalData = r4;
        this.$formatFeedItem = r5;
        this.$setDataList = r6;
        this.$setHasMore = r7;
        this.$setMaxTime = r8;
        this.$setFirstLoading = r9;
        this.$setPageName = r10;
        this.$dataList = r11;
        this.$setExtra = r12;
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), ((Boolean) r2).booleanValue(), (Function0) r3);
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean r11, final boolean r12, final Function0<Unit> r13) {
        if (this.$isFetching.element == false) goto L5;
        return;
    L5:
        if (r12 == true) goto L7;
    L9:
        this.$isFetching.element = true;
        LinkedHashMap r6 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r6, "source_key", "drawer_hot_live_history");
        com.bytedance.rts.foundation.m.e(r6, "max_time", this.$maxTime.invoke());
        com.bytedance.rts.foundation.m.e(r6, "need_map", 1);
        int r0 = m2.a;
        m2.a.a(new a4("https://webcast.amemv.com/webcast/feed/", "GET", null, r6, null, null, 8176), new AnonymousClass1(this, r12, r11, r13));
        return;
    L7:
        if (((Boolean) this.$hasMore.invoke()).booleanValue() == true) goto L9;
    }
}
