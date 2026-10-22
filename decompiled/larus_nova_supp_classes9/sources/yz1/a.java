package yz1;

import ay1.b;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.model.i;
import com.bytedance.android.livesdk.revenue.perf.wto.IRevWTORepeatableTask;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOPriorityType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOSceneType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOThreadType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOThreadWorkType;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IRevWTORepeatableTask {
    public final i a;
    public final int b;
    public final HashSet<Integer> c;

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final String taskBusinessInfo() {
        return "WTO-GiftListCacheTask";
    }

    public final int taskID() {
        return 2001;
    }

    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    public final void run() {
        Gson r0 = GsonHelper.get();
        ArrayList r1 = new ArrayList();
        w1 r2 = (w1) f.c(w1.class);
        List<? extends w1> r3 = this.a.giftPages;
        boolean r4 = false;
        if (r3 == null) goto L13;
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        w1 r6 = (w1) r5.next();
        if (r6.getPageType() != 1) goto L6;
        if (r6.getDisplay() == false) goto L6;
        r1.addAll(r6.getGifts());
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r1);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r1, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r1);
        r2.setPageType(r6.getPageType());
        r2.setPageName(r6.getPageName());
        r2.setEventName(r6.getEventName());
        r2.setDisplay(r6.getDisplay());
        r2.setTopicList(r6.getTopicList());
    L13:
        if (r1.size() <= 12) goto L22;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
        int r9 = 0;
    L16:
        if (r8.hasNext() == false) goto L20;
        h1 r10 = (h1) r8.next();
        if (r9 > 11) goto L16;
        r7.add(r10);
        r9 = r9 + 1;
        goto L16
    L20:
        if (r2 == null) goto L24;
        r2.setGifts(r7);
    L24:
        if (r2 != null) goto L26;
        return;
    L26:
        new i().giftPages = CollectionsKt.listOf(r2);
        String r11 = GsonProtectorUtils.toJson(r0, r2);
        if (r11 != null) goto L29;
    L30:
        r4 = true;
    L31:
        if (r4 == false) goto L33;
        return;
    L33:
        com.bytedance.android.livesdk.sharedpref.f.d(new e("gift_list_response_v2_" + this.b, BuildConfig.FLAVOR), r11);
        HashSet<String> r13 = b.k();
        r13.add(String.valueOf(this.b));
        b.y(r13);
        this.c.add(Integer.valueOf(this.b));
        return;
    L29:
        if (r11.length() != 0) goto L31;
    L22:
        if (r2 == null) goto L24;
        r2.setGifts(r1);
        goto L24
    }

    public final mq2.a taskExecutePeriod() {
        return mq2.a.a.b;
    }

    public final WTOPriorityType taskPriorityType() {
        return WTOPriorityType.SCHEDULE;
    }

    public final WTOSceneType taskSceneType() {
        return WTOSceneType.COMMON;
    }

    public final WTOThreadType taskThreadType() {
        return WTOThreadType.WorkerThread;
    }

    public final WTOThreadWorkType taskThreadWorkType() {
        return WTOThreadWorkType.IO;
    }

    public a(i r2, int r3, HashSet<Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r4, "cacheRoomTypeSet");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
