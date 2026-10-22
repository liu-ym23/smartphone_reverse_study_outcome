package com.cronutils.mapper;

import com.cronutils.model.Cron;
import com.cronutils.model.RebootCron;
import com.cronutils.model.SingleCron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronNicknames;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<CronFieldName, com.cronutils.a<CronField, CronField>> f3410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.cronutils.a<Cron, Cron> f3411b;
    private final CronDefinition c;

    public Cron a(Cron r9) {
        Cron r10 = (Cron) ZeusTransformUtils.wrapperContextForParams(r9, Cron.class, "com.obric.memorydata.plugin");
        com.cronutils.utils.a.a(r10, "Cron must not be null");
        if (ZeusTransformUtils.instanceOf(r10, RebootCron.class) == true) goto L5;
        ArrayList r0 = new ArrayList();
        CronFieldName[] r2 = CronFieldName.values();
        int r3 = r2.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L19;
        CronFieldName r5 = r2[r4];
        if (this.f3410a.containsKey(r5) == false) goto L17;
        CronField r6 = (CronField) ZeusTransformUtils.preCheckCast(((com.cronutils.a) ZeusTransformUtils.preCheckCast(this.f3410a.get(r5), com.cronutils.a.class, "com.obric.memorydata.plugin")).apply(r10.retrieve(r5)), CronField.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        r0.add(r6);
    L17:
        r4 = r4 + 1;
        goto L11
    L19:
        return ((Cron) ZeusTransformUtils.preCheckCast(this.f3411b.apply(new SingleCron(this.c, r0)), Cron.class, "com.obric.memorydata.plugin")).validate();
    L5:
        if (this.c.getCronNicknames().contains(CronNicknames.REBOOT) == false) goto L9;
        return new RebootCron(this.c);
    L9:
        throw new IllegalArgumentException("The target cron definition does not support @reboot nickname");
    }
}
