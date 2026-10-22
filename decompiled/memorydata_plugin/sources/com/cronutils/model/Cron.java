package com.cronutils.model;

import com.cronutils.mapper.b;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface Cron extends Serializable {
    String asString();

    boolean equivalent(b r1, Cron r2);

    boolean equivalent(Cron r1);

    CronDefinition getCronDefinition();

    CronField retrieve(CronFieldName r1);

    Map<CronFieldName, CronField> retrieveFieldsAsMap();

    Cron validate();
}
