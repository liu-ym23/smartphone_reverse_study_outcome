package com.cronutils.model.field.definition;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;

/* JADX INFO: loaded from: classes2.dex */
public class DayOfWeekFieldDefinition extends FieldDefinition {
    private static final long serialVersionUID = 8684844402711204711L;
    private final WeekDay mondayDoWValue;

    public DayOfWeekFieldDefinition(CronFieldName r1, FieldConstraints r2, boolean r3, WeekDay r4) {
        super(r1, r2, r3);
        this.mondayDoWValue = r4;
    }

    public WeekDay getMondayDoWValue() {
        return this.mondayDoWValue;
    }
}
