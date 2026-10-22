package com.cronutils.model;

import com.cronutils.mapper.b;
import com.cronutils.model.definition.CronConstraint;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SingleCron implements Cron {
    private static final long serialVersionUID = 7487370826825439098L;
    private String asString;
    private final CronDefinition cronDefinition;
    private final Map<CronFieldName, CronField> fields;

    public SingleCron(CronDefinition r4, List<CronField> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.cronDefinition = (CronDefinition) ZeusTransformUtils.preCheckCast(a.a(r4, "CronDefinition must not be null"), CronDefinition.class, "com.obric.memorydata.plugin");
        a.a(r6, "CronFields cannot be null");
        this.fields = new EnumMap(CronFieldName.class);
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        CronField r8 = (CronField) ZeusTransformUtils.preCheckCast(r7.next(), CronField.class, "com.obric.memorydata.plugin");
        this.fields.put(r8.getField(), r8);
        goto L4
    }

    @Override // com.cronutils.model.Cron
    public String asString() {
        if (this.asString != null) goto L10;
        ArrayList r0 = new ArrayList(this.fields.values());
        r0.sort(CronField.createFieldComparator());
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.append(String.format("%s ", new Object[]{((CronField) ZeusTransformUtils.preCheckCast(r2.next(), CronField.class, "com.obric.memorydata.plugin")).getExpression().asString()}));
        goto L6
    L8:
        this.asString = r1.toString().trim();
    L10:
        return this.asString;
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
    public CronField retrieve(CronFieldName r2) {
        return (CronField) ZeusTransformUtils.preCheckCast(this.fields.get(a.a(r2, "CronFieldName must not be null")), CronField.class, "com.obric.memorydata.plugin");
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        return Collections.unmodifiableMap(this.fields);
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
