package com.bytedance.android.livesdk.feedback.light.help;

import com.bytedance.android.live.base.model.feedback.ClientImpression;
import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedbackIntervalHelper {
    public static final Keva a = null;
    public static final String b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\n\u0010\u000bR6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/help/FeedbackIntervalHelper$a;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/feedback/light/help/FeedbackIntervalHelper$a$a;", "Lkotlin/collections/HashMap;", "map", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("ignore_map")
        private final HashMap<Long, C0317a> map;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.light.help.FeedbackIntervalHelper$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/help/FeedbackIntervalHelper$a$a;", "", "", "ignoreCounts", "J", "a", "()J", "setIgnoreCounts", "(J)V", "ignoreTime", "b", "setIgnoreTime", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0317a {

            @SerializedName("ignore_counts")
            private long ignoreCounts;

            @SerializedName("ignore_time")
            private long ignoreTime;

            public final long a() {
                return this.ignoreCounts;
            }

            public final long b() {
                return this.ignoreTime;
            }

            public C0317a(long r1, long r3) {
                this.ignoreCounts = r1;
                this.ignoreTime = r3;
            }
        }

        public a() {
            this.map = new HashMap();
        }

        public final HashMap<Long, C0317a> a() {
            return this.map;
        }
    }

    public static a a() {
        return (a) d.getValue();
    }

    static {
        a = Keva.getRepo("live_feedback_ignore_times");
        b = "live_feedback_ignore_times_record";
        c = LazyKt.lazy(FeedbackIntervalHelper$hasSubmittedFeedbacks$2.INSTANCE);
        d = LazyKt.lazy(FeedbackIntervalHelper$ignoreModel$2.INSTANCE);
    }

    public static boolean b(FeedbackCard r14) {
        Intrinsics.checkNotNullParameter(r14, "feedbackCard");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackIntervalHelper", "page");
        r1.a = "FeedbackIntervalHelper";
        a.C0317a r2 = null;
        if (r14.shouldRecordIgnoreAction() == false) goto L5;
        FeedbackCard r3 = r14;
    L7:
        if (r3 == null) goto L32;
        Condition r4 = r3.condition;
        if (r4 == null) goto L32;
        ClientImpression r5 = r4.clientImpression;
        if (r5 == null) goto L32;
        Long r6 = r5.ignoreCounts;
        if (r6 == null) goto L15;
        long r7 = r6.longValue();
    L16:
        Long r8 = r5.ignoreInterval;
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L20:
        long r10 = r9 * 86400000;
        a.C0317a r11 = a().a().get(r14.feedbackId);
        if (r11 == null) goto L32;
        long r12 = System.currentTimeMillis() - r11.b();
        r1.b(new Pair[]{TuplesKt.to("ignoreCountsConfig", Long.valueOf(r7)), TuplesKt.to("ignoreIntervalConfig", Long.valueOf(r10)), TuplesKt.to("已经忽略的次数", Long.valueOf(r11.a())), TuplesKt.to("上次忽略的时间戳", Long.valueOf(r11.b())), TuplesKt.to("时长间隔", Long.valueOf(r12))});
        if (r11.a() >= r7) goto L25;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L30;
        r2 = r11;
    L30:
        if (r2 == null) goto L32;
        boolean r15 = true;
    L33:
        r1.c("检查问卷展示是否受忽略频控限制:" + r15);
        r1.b(new Pair[]{TuplesKt.to("feedbackId", r14.feedbackId)});
        r1.d();
        return r15;
    L25:
        if (r12 > r10) goto L27;
        r13 = true;
        goto L28
    L19:
        r9 = 30;
        goto L20
    L15:
        r7 = 3;
    L32:
        r15 = false;
        goto L33
    L5:
        r3 = null;
        goto L7
    }

    public static void c(FeedbackCard r4) {
        if (r4 != null) goto L4;
    L9:
        if (r4 == null) goto L14;
        Long r5 = r4.roomId;
        if (r5 == null) goto L15;
        ((HashSet) c.getValue()).add(Long.valueOf(r5.longValue()));
        return;
    L15:
        return;
    L14:
        return;
    L4:
        if (r4.shouldRecordIgnoreAction() == false) goto L6;
        FeedbackCard r0 = r4;
    L7:
        if (r0 == null) goto L9;
        int r1 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r2 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackIntervalHelper", "page");
        r2.a = "FeedbackIntervalHelper";
        r2.c("问卷填答了，重置忽略次数");
        r2.b(new Pair[]{TuplesKt.to("feedbackId", r4.feedbackId)});
        r2.d();
        e(r4);
        goto L9
    L6:
        r0 = null;
        goto L7
    }

    public static void d(FeedbackCard r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.shouldRecordIgnoreAction() == true) goto L7;
        r7 = null;
    L7:
        if (r7 == null) goto L18;
        Long r8 = r7.feedbackId;
        a.C0317a r0 = a().a().get(r8);
        long r1 = 0;
        if (r0 == null) goto L11;
        long r3 = r0.a();
    L12:
        long r4 = r3 + 1;
        long r5 = System.currentTimeMillis();
        HashMap<Long, a.C0317a> r2 = a().a();
        if (r8 == null) goto L15;
        r1 = r8.longValue();
    L15:
        r2.put(Long.valueOf(r1), new a.C0317a(r4, r5));
        f(a());
        int r6 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r9 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackIntervalHelper", "page");
        r9.a = "FeedbackIntervalHelper";
        r9.c("记录问卷忽略的信息");
        r9.b(new Pair[]{TuplesKt.to("已经忽略的次数", Long.valueOf(r4)), TuplesKt.to("忽略的时间戳", Long.valueOf(r5)), TuplesKt.to("feedbackId", r8)});
        r9.d();
        return;
    L11:
        r3 = 0;
        goto L12
    }

    public static void e(FeedbackCard r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.shouldRecordIgnoreAction() == false) goto L6;
        FeedbackCard r0 = r7;
    L7:
        if (r0 == null) goto L15;
        HashMap<Long, a.C0317a> r1 = a().a();
        Long r2 = r7.feedbackId;
        if (r2 == null) goto L11;
        long r4 = r2.longValue();
    L12:
        r1.put(Long.valueOf(r4), new a.C0317a(0, System.currentTimeMillis()));
        f(a());
        int r3 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r5 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackIntervalHelper", "page");
        r5.a = "FeedbackIntervalHelper";
        r5.c("重置问卷的忽略次数");
        r5.b(new Pair[]{TuplesKt.to("feedbackId", r7.feedbackId)});
        r5.d();
        return;
    L11:
        r4 = 0;
        goto L12
    L15:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void f(a r3) {
        String r4 = JsonUtil.toJSONString(r3);     // Catch: Exception -> L5
        int r1 = FeedbackMonitor.a;     // Catch: Exception -> L5
        FeedbackMonitor.Monitor r2 = new FeedbackMonitor.Monitor();     // Catch: Exception -> L5
        r2.c("保存问卷记录:" + r4);     // Catch: Exception -> L5
        r2.d();     // Catch: Exception -> L5
        a.storeString(b, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, "FeedbackIntervalHelper");
    }
}
