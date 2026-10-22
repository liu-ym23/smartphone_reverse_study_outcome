package com.cronutils.model.definition;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CronDefinition implements Serializable {
    private static final long serialVersionUID = 7067112327461432170L;
    private final Set<CronConstraint> cronConstraints;
    private final Set<CronNicknames> cronNicknames;
    private final Map<CronFieldName, FieldDefinition> fieldDefinitions;
    private final boolean matchDayOfWeekAndDayOfMonth;

    public CronDefinition(List<FieldDefinition> r5, Set<CronConstraint> r6, Set<CronNicknames> r7, boolean r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        com.cronutils.utils.a.a(r11, "Cron nicknames must not be null");
        if (r11.contains(CronNicknames.REBOOT) == true) goto L5;
        com.cronutils.utils.a.a(r9, "Field definitions must not be null");
        com.cronutils.utils.a.a(r10, "Cron validations must not be null");
        com.cronutils.utils.a.a(r9, "Field definitions must not be empty");
        com.cronutils.utils.a.a(!((FieldDefinition) ZeusTransformUtils.preCheckCast(r9.get(0), FieldDefinition.class, "com.obric.memorydata.plugin")).isOptional(), "The first field must not be optional");
    L5:
        this.fieldDefinitions = new EnumMap(CronFieldName.class);
        Iterator r12 = r9.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        FieldDefinition r0 = (FieldDefinition) ZeusTransformUtils.preCheckCast(r12.next(), FieldDefinition.class, "com.obric.memorydata.plugin");
        this.fieldDefinitions.put(r0.getFieldName(), r0);
        goto L7
    L9:
        this.cronConstraints = Collections.unmodifiableSet(r10);
        this.cronNicknames = Collections.unmodifiableSet(r11);
        this.matchDayOfWeekAndDayOfMonth = r8;
    }

    public boolean containsFieldDefinition(CronFieldName r1) {
        return this.fieldDefinitions.containsKey(r1);
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
        CronDefinition r6 = (CronDefinition) ZeusTransformUtils.preCheckCast(r5, CronDefinition.class, "com.obric.memorydata.plugin");
        if (this.matchDayOfWeekAndDayOfMonth != r6.matchDayOfWeekAndDayOfMonth) goto L20;
        if (this.fieldDefinitions.equals(r6.fieldDefinitions) == false) goto L20;
        if (this.cronConstraints.equals(r6.cronConstraints) == false) goto L20;
        if (this.cronNicknames.equals(r6.cronNicknames) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public Set<CronConstraint> getCronConstraints() {
        return this.cronConstraints;
    }

    public Set<CronNicknames> getCronNicknames() {
        return this.cronNicknames;
    }

    public FieldDefinition getFieldDefinition(CronFieldName r2) {
        return (FieldDefinition) ZeusTransformUtils.preCheckCast(this.fieldDefinitions.get(r2), FieldDefinition.class, "com.obric.memorydata.plugin");
    }

    public Set<FieldDefinition> getFieldDefinitions() {
        return new HashSet(this.fieldDefinitions.values());
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldDefinitions, this.cronConstraints, this.cronNicknames, Boolean.valueOf(this.matchDayOfWeekAndDayOfMonth)});
    }

    public boolean isMatchDayOfWeekAndDayOfMonth() {
        return this.matchDayOfWeekAndDayOfMonth;
    }

    public Map<CronFieldName, FieldDefinition> retrieveFieldDefinitionsAsMap() {
        return Collections.unmodifiableMap(this.fieldDefinitions);
    }
}
