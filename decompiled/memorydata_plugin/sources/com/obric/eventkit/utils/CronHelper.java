package com.obric.eventkit.utils;

import android.os.Build;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.b;
import com.obric.eventkit.logger.Logger;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/eventkit/utils/CronHelper;", "", "()V", "TAG", "", "cronParser", "Lcom/cronutils/parser/CronParser;", "getCronParser", "()Lcom/cronutils/parser/CronParser;", "cronParser$delegate", "Lkotlin/Lazy;", "getNextScheduleTime", "", CronJobRunnerTask.KEY_CRON, "fromTimestamp", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "isTimeRecurring", "", "isValidCron", "isValidCronException", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CronHelper {
    public static final CronHelper INSTANCE = null;
    private static final String TAG = "CronHelper";
    private static final Lazy cronParser$delegate = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/cronutils/parser/CronParser;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<com.cronutils.b.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8035a = null;

        static {
            f8035a = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.cronutils.b.a invoke() {
            return new com.cronutils.b.a(b.a(CronType.QUARTZ));
        }
    }

    static {
        INSTANCE = new CronHelper();
        cronParser$delegate = LazyKt.lazy(a.f8035a);
    }

    private CronHelper() {
    }

    private final com.cronutils.b.a getCronParser() {
        return (com.cronutils.b.a) ZeusTransformUtils.preCheckCast(cronParser$delegate.getValue(), com.cronutils.b.a.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Long getNextScheduleTime$default(CronHelper r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getNextScheduleTime(r1, r2);
    }

    public final Long getNextScheduleTime(String r5, Long r6) {
        Intrinsics.checkNotNullParameter(r5, CronJobRunnerTask.KEY_CRON);
        com.cronutils.model.time.b r0 = com.cronutils.model.time.b.a(INSTANCE.getCronParser().a(r5));     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r6 == null) goto L7;
        ZonedDateTime r1 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(r6.longValue()), ZoneId.systemDefault());     // Catch: Throwable -> L14
    L8:
        ZonedDateTime r2 = (ZonedDateTime) ZeusTransformUtils.preCheckCast(r0.a(r1).orElse(null), ZonedDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullExpressionValue(r2, "orElse(null)");     // Catch: Throwable -> L14
        return Long.valueOf(r2.toInstant().toEpochMilli());
    L7:
        r1 = ZonedDateTime.now();     // Catch: Throwable -> L14
    L12:
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L19;
        Logger.INSTANCE.i(TAG, "getNextScheduleTime fail cron = " + r5 + ", fromTimestamp = " + r6 + ' ' + r4);
    L19:
        return null;
    L14:
        th = move-exception;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean isTimeRecurring(String r7) {
        Intrinsics.checkNotNullParameter(r7, CronJobRunnerTask.KEY_CRON);
        List r6 = StringsKt.split$default(r7, new String[]{" "}, false, 0, 6, null);
        if (r6.size() == 6) goto L8;
        if (r6.size() == 7) goto L8;
        return false;
    L8:
        if (StringsKt.contains$default(r7, "*", false, 2, null) == false) goto L10;
    L15:
        return true;
    L10:
        if (StringsKt.contains$default(r7, "-", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r7, "/", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r7, ",", false, 2, null) == true) goto L15;
        return false;
    }

    public final boolean isValidCron(String r4) {
        Intrinsics.checkNotNullParameter(r4, CronJobRunnerTask.KEY_CRON);
        INSTANCE.isValidCronException(r4);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Throwable r3 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r3 == null) goto L14;
        Logger.INSTANCE.i(TAG, "isValidCron fail cron = " + r4 + ", " + r3);
        return false;
    L14:
        return false;
    }

    public final void isValidCronException(String r2) {
        Intrinsics.checkNotNullParameter(r2, CronJobRunnerTask.KEY_CRON);
        getCronParser().a(r2).validate();
    }
}
