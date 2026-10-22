package com.larus.bmhome.chat.bubble.floating.reach;

import com.larus.bmhome.chat.bubble.floating.report.BubbleBannerShowReporter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneLifecycleListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ns9.e;
import ns9.t;
import sc8.b;
import sc8.g;
import sc8.i;
import tc8.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/reach/GeneralBannerReachLifecycleListener;", "Lcom/larus/reach/api/ReachSceneLifecycleListener;", "<init>", "()V", "pushScene", "", "getPushScene", "()Ljava/lang/String;", "onShow", "", "request", "Lcom/larus/reach/api/ReachRequest;", "onClick", "click", "Lcom/larus/reach/api/ReachClickEvent;", "onClickResult", "success", "", "failReason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GeneralBannerReachLifecycleListener implements ReachSceneLifecycleListener {
    public final String a;

    public static final class a {
    }

    static {
    }

    public GeneralBannerReachLifecycleListener() {
        this.a = "*";
    }

    public final String a() {
        return this.a;
    }

    public final void b(t r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
    }

    public final void g(t r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (tc8.t.a(r5) == false) goto L9;
        int r1 = s.a;
        Intrinsics.checkNotNullParameter(r5, "request");
        b r0 = tc8.t.b(r5);
        long r2 = System.currentTimeMillis();
        if (tc8.t.a(r5) == false) goto L7;
        CoroutineScope r6 = BubbleBannerShowReporter.a;
        Intrinsics.checkNotNullParameter(r0, "event");
        BubbleBannerShowReporter.a(r0, r2);
    L7:
        i.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "event");
        i.c(new g(i.b(r0.a), r0));
        return;
    }

    public final void d(t r2, ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    public final void f(t r2, ReachRejectReason r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    public final void h(t r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "click");
        if (tc8.t.a(r3) == false) goto L6;
        int r5 = s.a;
        Intrinsics.checkNotNullParameter(r3, "request");
        i r6 = i.a;
        b r7 = tc8.t.b(r3);
        r6.getClass();
        i.a(r7);
        return;
    }

    public final void c(t r4, e r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "click");
        if (tc8.t.a(r4) == false) goto L20;
        int r8 = s.a;
        Map r9 = MapsKt.createMapBuilder();
        if (r6 == false) goto L7;
        String r1 = "success";
    L8:
        r9.put("banner_action_result", r1);
        if (r6 == true) goto L18;
        if (r7 != null) goto L12;
    L16:
        r7 = "system_error";
    L17:
        r9.put("banner_action_fail_reason", r7);
        goto L18
    L12:
        if ((!StringsKt.isBlank(r7)) == true) goto L15;
        r7 = null;
    L15:
        if (r7 != null) goto L17;
    L18:
        Unit r10 = Unit.INSTANCE;
        sc8.a r11 = new sc8.a(MapsKt.build(r9));
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r11, "result");
        i r12 = i.a;
        b r13 = tc8.t.b(r4);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r11, "result");
        i.c(new sc8.e(i.b(r13.a), r13, r11));
        return;
    L7:
        r1 = "fail";
        goto L8
    }
}
