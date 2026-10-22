package com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough;

import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x21.d;
import xy0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiBreakThroughBarState {
    public d a;
    public String b;
    public String c;
    public Long d;
    public final b e;

    public FeedMultiBreakThroughBarState(b r2) {
        Intrinsics.checkNotNullParameter(r2, "sender");
        this.e = r2;
    }

    public final void a(Function1<? super Map<String, Object>, Unit> r4) {
        HashMap r0 = new HashMap();
        r4.invoke(r0);
        JSONObject r5 = new JSONObject();
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r5.put((String) r2.getKey(), r2.getValue());
        goto L4
    L6:
        b r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        if (r3.b == false) goto L13;
        zy0.b r6 = r3.c;
        if (r6 == null) goto L16;
        a<?> r7 = r6.g();
        if (r7 == null) goto L17;
        r7.sendJsEvent("H5_webcastNotification", r5);
        return;
    L17:
        return;
    L16:
        return;
    L13:
        r3.a.offer(r5);
    }

    public final void b(final String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, this.b) == true) goto L9;
        this.b = r2;
        a(new FeedMultiBreakThroughBarState$btFinishEvent$1(r2));
        return;
    }

    public final void c(final String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a(new FeedMultiBreakThroughBarState$btRefreshEvent$1(r2));
    }

    public final void d(final String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, this.c) == true) goto L9;
        this.c = r2;
        a(new FeedMultiBreakThroughBarState$btUpdateScoreEvent$1(r2));
        return;
    }

    public final void e(final Long r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, this.d) == true) goto L9;
        this.d = r2;
        a(new FeedMultiBreakThroughBarState$pkLeftTime$1(r2));
        return;
    }
}
