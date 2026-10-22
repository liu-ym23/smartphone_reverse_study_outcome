package com.obric.memorydata.memory.tracker;

import com.bytedance.crash.entity.Header;
import com.obric.memorydata.database.dao.SpeakerProfileDailyStats;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.q;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007Jg\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012H\u0000¢\u0006\u0002\b\u0014J'\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/tracker/SpeakerProfileDailyEventTracker;", "", "<init>", "()V", "EVENT_NAME", "", "reportDaily", "", "reportIfCurrentAccount", "", "userId", "currentUserId", "Lkotlin/Function0;", "isLoggedIn", "isPersonalDbReady", "statsProvider", "Lcom/obric/memorydata/database/dao/SpeakerProfileDailyStats;", "report", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "reportIfCurrentAccount$memory_obricRelease", "buildParamsIfCurrentAccount", "stats", "buildParamsIfCurrentAccount$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10551a = null;

    static {
        f10551a = new i();
    }

    private i() {
    }

    private static final Unit a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        Tracker.INSTANCE.reportEvent("speaker_profile_daily_event", r2);
        return Unit.INSTANCE;
    }

    private static final boolean a(PersonalMemoryFrameDb r2) {
        String r3 = r2.getOpenHelper().getDatabaseName();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        return Intrinsics.areEqual(r3, com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME));
    }

    private static final SpeakerProfileDailyStats b(PersonalMemoryFrameDb r9) {
        return r9.getPersonProfileDao().querySpeakerProfileDailyStats();
    L4:
        o.a((o) ZeusTransformUtils.preCheckCast(q.f11632a, o.class, "com.obric.memorydata.plugin"), "声纹画像日上报统计查询失败", "daily_report_failed", "speaker_profile_stats_query_failed", null, null, null, 56, null);
        return null;
    }

    /* JADX INFO: renamed from: lambda$CVVVJiwQXEG6ziiagVRV-6XDcfs, reason: not valid java name */
    public static /* synthetic */ SpeakerProfileDailyStats m762lambda$CVVVJiwQXEG6ziiagVRV6XDcfs(PersonalMemoryFrameDb r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$MwGNY08_00izaumsm7MT9N1BYZ0(JSONObject r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$Xq83u-g-40jUQIK__kwD9nMif7A, reason: not valid java name */
    public static /* synthetic */ boolean m763lambda$Xq83ug40jUQIK__kwD9nMif7A(PersonalMemoryFrameDb r0) {
        return a(r0);
    }

    public final JSONObject a(String r2, String r3, SpeakerProfileDailyStats r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "currentUserId");
        Intrinsics.checkNotNullParameter(r4, "stats");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r3, r2) == false) goto L14;
        JSONObject r1 = new JSONObject();
        r1.put(Header.KEY_USER_ID, r2);
        r1.put("profile_count", r4.getProfileCount());
        Object r5 = r4.getProfileAvgEmbeddingCount();
        if (r5 != null) goto L10;
        r5 = JSONObject.NULL;
    L10:
        r1.put("profile_avg_embedding_count", r5);
        return r1;
    L14:
        return null;
    }

    public final void a() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L5;
        return;
    L5:
        String r2 = UserSettings.INSTANCE.getUserId();
        final PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        Function0<Boolean> r5 = new $$Lambda$i$Xq83ug40jUQIK__kwD9nMif7A(r0);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L8;
        return;
    L8:
        a(r2, (Function0) ZeusTransformUtils.preCheckCast(new SpeakerProfileDailyEventTracker$reportDaily$1(UserSettings.INSTANCE), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new SpeakerProfileDailyEventTracker$reportDaily$2(UserSettings.INSTANCE), Function0.class, "com.obric.memorydata.plugin"), r5, new $$Lambda$i$CVVVJiwQXEG6ziiagVRV6XDcfs(r0), $$Lambda$i$MwGNY08_00izaumsm7MT9N1BYZ0.INSTANCE);
    }

    public final boolean a(String r5, Function0<String> r6, Function0<Boolean> r7, Function0<Boolean> r8, Function0<SpeakerProfileDailyStats> r9, Function1<? super JSONObject, Unit> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r11, "currentUserId");
        Intrinsics.checkNotNullParameter(r12, "isLoggedIn");
        Intrinsics.checkNotNullParameter(r13, "isPersonalDbReady");
        Intrinsics.checkNotNullParameter(r14, "statsProvider");
        Intrinsics.checkNotNullParameter(r15, "report");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L24:
        return false;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L24;
        if (Intrinsics.areEqual(r11.invoke(), r5) == false) goto L24;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        SpeakerProfileDailyStats r16 = (SpeakerProfileDailyStats) ZeusTransformUtils.preCheckCast(r14.invoke(), SpeakerProfileDailyStats.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L15;
        return false;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        JSONObject r4 = a(r5, (String) ZeusTransformUtils.preCheckCast(r11.invoke(), String.class, "com.obric.memorydata.plugin"), r16);
        if (r4 != null) goto L22;
        return false;
    L22:
        r15.invoke(r4);
        return true;
    }
}
