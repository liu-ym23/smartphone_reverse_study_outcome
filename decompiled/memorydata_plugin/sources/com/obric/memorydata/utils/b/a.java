package com.obric.memorydata.utils.b;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J)\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bR\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/utils/cron/QuartzCronHelper;", "", "<init>", "()V", "definition", "Lcom/cronutils/model/definition/CronDefinition;", "kotlin.jvm.PlatformType", "Lcom/cronutils/model/definition/CronDefinition;", "parser", "Lcom/cronutils/parser/CronParser;", "parse", "Lcom/cronutils/model/Cron;", "expression", "", "isValid", "", "describe", "locale", "Ljava/util/Locale;", "nextExecution", "Ljava/time/ZonedDateTime;", "now", "nextExecutionMillis", "", "baseMillis", "zoneId", "Ljava/time/ZoneId;", "(Ljava/lang/String;JLjava/time/ZoneId;)Ljava/lang/Long;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CronDefinition f13192b = null;
    private static final com.cronutils.b.a c = null;

    static {
        f13191a = new a();
        CronDefinition r0 = b.a(CronType.QUARTZ);
        f13192b = r0;
        c = new com.cronutils.b.a(r0);
    }

    private a() {
    }

    public static /* synthetic */ Long a(a r0, String r1, long r2, ZoneId r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = System.currentTimeMillis();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = ZoneId.systemDefault();
    L9:
        return r0.a(r1, r2, r4);
    }

    public final Cron a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "expression");
        Cron r0 = c.a(r1);
        r0.validate();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final Long a(String r2, long r3, ZoneId r5) {
        Intrinsics.checkNotNullParameter(r2, "expression");
        Intrinsics.checkNotNullParameter(r5, "zoneId");
        ZonedDateTime r4 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(r3), r5);
        Intrinsics.checkNotNull(r4);
        ZonedDateTime r1 = a(r2, r4);
        if (r1 == null) goto L7;
        Instant r6 = r1.toInstant();
        if (r6 == null) goto L7;
        return Long.valueOf(r6.toEpochMilli());
    L7:
        return null;
    }

    public final ZonedDateTime a(String r2, ZonedDateTime r3) {
        Intrinsics.checkNotNullParameter(r2, "expression");
        Intrinsics.checkNotNullParameter(r3, "now");
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(com.cronutils.model.time.b.a(a(r2)).a(r3).orElse(null), ZonedDateTime.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "expression");
        a(r2);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }
}
