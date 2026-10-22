package tvb;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kub.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final c a;
    public final Function0<d> b;

    /* JADX INFO: renamed from: tvb.a$a, reason: collision with other inner class name */
    public static final class C0193a {
    }

    static {
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r0 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r0.e("feishu_record_id", r4);
        r0.e("end_method", "feishu_recording_detail_page");
        a(r4, "click_feishu_recording_end", r0.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(c r2, Function0<? extends d> r3) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        Intrinsics.checkNotNullParameter(r3, "hostTrackerProvider");
        this.a = r2;
        this.b = r3;
    }

    public final void a(String r7, String r8, JSONObject r9) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r0 = this.a.c(r7);
        if (r0 != null) goto L6;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: context missing, eventName=" + r8 + ", sessionId=" + r7);
        return;
    L6:
        DoubaoStatisticInfo r3 = r0.c;
        if (r3 != null) goto L10;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: doubaoStatisticInfo missing, eventName=" + r8 + ", sessionId=" + r7);
        return;
    L10:
        d r4 = (d) this.b.invoke();
        if (r4 != null) goto L14;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: host tracker missing, eventName=" + r8 + ", sessionId=" + r7);
        return;
    L14:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r5 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r5.f(r3.toJSONObject());
        r5.f(r9);
        r5.f(r0.b.asTrackerParams().a());
        JSONObject r10 = r5.a();
        lvb.a.a("MmDoubaoBusinessTracker", "[sendDoubaoEvent] eventName=" + r8 + ", sessionId=" + r7 + ", params=" + r10);
        r4.sendEvent(r8, r10);
    }
}
