package com.cronutils.model.definition;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronDefinition implements Serializable {
    private static final long serialVersionUID = 7067112327461432170L;
    private final Set<CronConstraint> cronConstraints;
    private final Set<CronNicknames> cronNicknames;
    private final Map<CronFieldName, FieldDefinition> fieldDefinitions;
    private final boolean matchDayOfWeekAndDayOfMonth;

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldDefinitions, this.cronConstraints, this.cronNicknames, Boolean.valueOf(this.matchDayOfWeekAndDayOfMonth)});
    }

    public Set<FieldDefinition> getFieldDefinitions() {
        return new HashSet(this.fieldDefinitions.values());
    }

    public Map<CronFieldName, FieldDefinition> retrieveFieldDefinitionsAsMap() {
        return Collections.unmodifiableMap(this.fieldDefinitions);
    }

    public Set<CronConstraint> getCronConstraints() {
        return this.cronConstraints;
    }

    public Set<CronNicknames> getCronNicknames() {
        return this.cronNicknames;
    }

    public boolean isMatchDayOfWeekAndDayOfMonth() {
        return this.matchDayOfWeekAndDayOfMonth;
    }

    public boolean containsFieldDefinition(CronFieldName r2) {
        return this.fieldDefinitions.containsKey(r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        CronDefinition r6 = (CronDefinition) r5;
        if (this.matchDayOfWeekAndDayOfMonth == r6.matchDayOfWeekAndDayOfMonth) goto L13;
    L19:
        return false;
    L13:
        if (this.fieldDefinitions.equals(r6.fieldDefinitions) == false) goto L19;
        if (this.cronConstraints.equals(r6.cronConstraints) == false) goto L19;
        if (this.cronNicknames.equals(r6.cronNicknames) == false) goto L19;
        return true;
    }

    public FieldDefinition getFieldDefinition(CronFieldName r2) {
        return this.fieldDefinitions.get(r2);
    }

    public CronDefinition(List<FieldDefinition> r4, Set<CronConstraint> r5, Set<CronNicknames> r6, boolean r7) {
        zr7.a.b(r6, "Cron nicknames must not be null");
        if (r6.contains(CronNicknames.REBOOT) == true) goto L5;
        zr7.a.b(r4, "Field definitions must not be null");
        zr7.a.b(r5, "Cron validations must not be null");
        zr7.a.c(r4, "Field definitions must not be empty");
        zr7.a.a(!((FieldDefinition) ListProtector.get(r4, 0)).isOptional(), "The first field must not be optional");
    L5:
        this.fieldDefinitions = new EnumMap(CronFieldName.class);
        Iterator<FieldDefinition> r8 = r4.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        FieldDefinition r0 = r8.next();
        this.fieldDefinitions.put(r0.getFieldName(), r0);
        goto L7
    L9:
        this.cronConstraints = Collections.unmodifiableSet(r5);
        this.cronNicknames = Collections.unmodifiableSet(r6);
        this.matchDayOfWeekAndDayOfMonth = r7;
    }
}
