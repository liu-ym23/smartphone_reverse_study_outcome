package com.cronutils.model;

import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.io.Serializable;
import java.util.Map;
import qr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface Cron extends Serializable {
    String asString();

    boolean equivalent(Cron r1);

    boolean equivalent(b r1, Cron r2);

    CronDefinition getCronDefinition();

    CronField retrieve(CronFieldName r1);

    Map<CronFieldName, CronField> retrieveFieldsAsMap();

    Cron validate();
}
