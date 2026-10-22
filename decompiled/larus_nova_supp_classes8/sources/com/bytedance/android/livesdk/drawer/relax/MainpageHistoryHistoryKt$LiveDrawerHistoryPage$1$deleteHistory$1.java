package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.d3;
import com.bytedance.salamander.anniex.m2;
import com.bytedance.salamander.anniex.r3;
import com.bytedance.salamander.anniex.s3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "deleteList", "Ljava/util/ArrayList;", "", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$deleteHistory$1 extends Lambda implements Function1<ArrayList<Long>, Unit> {
    final /* synthetic */ Function3 $fetchFeed;
    final /* synthetic */ e $globalData;
    final /* synthetic */ Function1 $setAllSelected;
    final /* synthetic */ Function1 $setDeleteList;
    final /* synthetic */ Function1 $setManageStatus;
    final /* synthetic */ Function1 $setMaxTime;

    public MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$deleteHistory$1(e r1, Function1 r2, Function3 r3, Function1 r4, Function1 r5, Function1 r6) {
        this.$globalData = r1;
        this.$setMaxTime = r2;
        this.$fetchFeed = r3;
        this.$setManageStatus = r4;
        this.$setDeleteList = r5;
        this.$setAllSelected = r6;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ArrayList) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "deleteList");
        if (com.bytedance.rts.foundation.j.d(r10) != 0) goto L5;
        return;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();
        e r0 = this.$globalData;
        if (r0 == null) goto L17;
        Function0<? extends r3> r1 = r0.d;
        if (r1 == null) goto L17;
        r3 r2 = (r3) r1.invoke();
        if (r2 == null) goto L17;
        s3 r3 = r2.b;
        if (r3 == null) goto L17;
        d3 r4 = r3.b;
        if (r4 == null) goto L17;
        String r6 = r4.a;
        if (r6 == null) goto L17;
    L18:
        com.bytedance.rts.foundation.m.e(r5, "user_id", r6);
        com.bytedance.rts.foundation.m.e(r5, "anchor_ids", com.bytedance.rts.foundation.j.g(r10, ","));
        int r11 = m2.a;
        m2.a.a(new a4("https://webcast.amemv.com/webcast/distribution/delete_story/", "POST", null, r5, null, null, 8176), new AnonymousClass1(this));
        return;
    L17:
        r6 = "";
        goto L18
    }
}
