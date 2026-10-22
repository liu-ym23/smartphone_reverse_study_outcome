package com.cronutils.model;

import com.cronutils.model.definition.CronConstraint;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vr7.b;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SingleCron implements Cron {
    private static final long serialVersionUID = 7487370826825439098L;
    private String asString;
    private final CronDefinition cronDefinition;
    private final Map<CronFieldName, CronField> fields;

    @Override // com.cronutils.model.Cron
    public String asString() {
        if (this.asString != null) goto L10;
        ArrayList r0 = new ArrayList(this.fields.values());
        r0.sort(CronField.createFieldComparator());
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.append(String.format("%s ", new Object[]{((CronField) r2.next()).getExpression().asString()}));
        goto L6
    L8:
        this.asString = r1.toString().trim();
    L10:
        return this.asString;
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
        Map.Entry<CronFieldName, CronField> r1 = r0.next();
        r1.getValue().getExpression().accept(new b(getCronDefinition().getFieldDefinition(r1.getKey()).getConstraints()));
        goto L4
    L6:
        Iterator<CronConstraint> r2 = getCronDefinition().getCronConstraints().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        CronConstraint r3 = r2.next();
        if (r3.validate(this) == true) goto L8;
        throw new IllegalArgumentException(String.format("Invalid cron expression: %s. %s", new Object[]{asString(), r3.getDescription()}));
    L14:
        return this;
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.cronDefinition;
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r2) {
        return asString().equals(r2.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r3) {
        Map<CronFieldName, CronField> r0 = this.fields;
        a.b(r3, "CronFieldName must not be null");
        return r0.get(r3);
    }

    public SingleCron(CronDefinition r3, List<CronField> r4) {
        a.b(r3, "CronDefinition must not be null");
        this.cronDefinition = r3;
        a.b(r4, "CronFields cannot be null");
        this.fields = new EnumMap(CronFieldName.class);
        Iterator<CronField> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CronField r6 = r5.next();
        this.fields.put(r6.getField(), r6);
        goto L4
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(qr7.b r1, Cron r2) {
        asString();
        throw null;
    }
}
