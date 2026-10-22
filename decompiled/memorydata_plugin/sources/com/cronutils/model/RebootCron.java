package com.cronutils.model;

import com.cronutils.mapper.b;
import com.cronutils.model.definition.CronConstraint;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RebootCron implements Cron {
    private static final long serialVersionUID = 7487370826825439099L;
    private final CronDefinition cronDefinition;

    public RebootCron(CronDefinition r3) {
        this.cronDefinition = (CronDefinition) ZeusTransformUtils.preCheckCast(a.a(r3, "CronDefinition must not be null"), CronDefinition.class, "com.obric.memorydata.plugin");
    }

    @Override // com.cronutils.model.Cron
    public String asString() {
        return "@reboot";
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(b r3, Cron r4) {
        Cron r5 = (Cron) ZeusTransformUtils.wrapperContextForParams(r4, Cron.class, "com.obric.memorydata.plugin");
        return asString().equals(r3.a(r5).asString());
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r3) {
        Cron r4 = (Cron) ZeusTransformUtils.wrapperContextForParams(r3, Cron.class, "com.obric.memorydata.plugin");
        return asString().equals(r4.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.cronDefinition;
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r1) {
        a.a(r1, "CronFieldName must not be null");
        return null;
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        return Collections.unmodifiableMap(new HashMap());
    }

    @Override // com.cronutils.model.Cron
    public Cron validate() {
        Iterator<Map.Entry<CronFieldName, CronField>> r0 = retrieveFieldsAsMap().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((CronField) ZeusTransformUtils.preCheckCast(r1.getValue(), CronField.class, "com.obric.memorydata.plugin")).getExpression().accept(new com.cronutils.model.field.expression.a.b(getCronDefinition().getFieldDefinition((CronFieldName) ZeusTransformUtils.preCheckCast(r1.getKey(), CronFieldName.class, "com.obric.memorydata.plugin")).getConstraints()));
        goto L4
    L6:
        Iterator<CronConstraint> r2 = getCronDefinition().getCronConstraints().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        CronConstraint r3 = (CronConstraint) ZeusTransformUtils.preCheckCast(r2.next(), CronConstraint.class, "com.obric.memorydata.plugin");
        if (r3.validate(this) == true) goto L8;
        throw new IllegalArgumentException(String.format("Invalid cron expression: %s. %s", new Object[]{asString(), r3.getDescription()}));
    L14:
        return this;
    }
}
