package com.cronutils.model.time;

import com.cronutils.model.CompositeCron;
import com.cronutils.model.Cron;
import com.cronutils.model.SingleCron;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: renamed from: com.cronutils.model.time.b$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3424a = null;

        static {
            int[] r0 = new int[CronFieldName.values().length];
            f3424a = r0;
            r0[CronFieldName.SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f3424a[CronFieldName.MINUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f3424a[CronFieldName.HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f3424a[CronFieldName.DAY_OF_WEEK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f3424a[CronFieldName.DAY_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f3424a[CronFieldName.MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f3424a[CronFieldName.YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f3424a[CronFieldName.DAY_OF_YEAR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static b a(Cron r8) {
        Cron r9 = (Cron) ZeusTransformUtils.wrapperContextForParams(r8, Cron.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, SingleCron.class) == false) goto L23;
        Map<CronFieldName, CronField> r0 = r9.retrieveFieldsAsMap();
        c r2 = new c(r9);
        CronFieldName[] r10 = CronFieldName.values();
        int r3 = r10.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L21;
        CronFieldName r5 = r10[r4];
        if (r0.get(r5) == null) goto L19;
        switch(AnonymousClass2.f3424a[r5.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L19;
        };
    L11:
        r2.h((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L12:
        r2.e((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L13:
        r2.d((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L14:
        r2.g((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L15:
        r2.f((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L16:
        r2.c((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L17:
        r2.b((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
        goto L19
    L18:
        r2.a((CronField) ZeusTransformUtils.preCheckCast(r0.get(r5), CronField.class, "com.obric.memorydata.plugin"));
    L19:
        r4 = r4 + 1;
        goto L5
    L21:
        return r2.a();
    L23:
        if (ZeusTransformUtils.instanceOf(r9, CompositeCron.class) == false) goto L27;
        return new a((List) ZeusTransformUtils.preCheckCast(((CompositeCron) ZeusTransformUtils.preCheckCast(r9, CompositeCron.class, "com.obric.memorydata.plugin")).getCrons().parallelStream().map($$Lambda$29hhPjdbz4SiMXJRXMTZXMHeR1A.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    L27:
        return new AnonymousClass1();
    }

    Optional<ZonedDateTime> a(ZonedDateTime r1);
}
