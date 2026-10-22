package com.cronutils.model.definition;

import com.cronutils.model.Cron;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.QuestionMark;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class CronConstraintsFactory$1 extends CronConstraint {
    private static final long serialVersionUID = 520379111876897579L;

    CronConstraintsFactory$1(String r1) {
        super(r1);
    }

    @Override // com.cronutils.model.definition.CronConstraint
    public boolean validate(Cron r3) {
        Cron r2 = (Cron) ZeusTransformUtils.wrapperContextForParams(r3, Cron.class, "com.obric.memorydata.plugin");
        CronField r4 = r2.retrieve(CronFieldName.DAY_OF_YEAR);
        if (r4 != null) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r4.getExpression(), QuestionMark.class) == false) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r2.retrieve(CronFieldName.DAY_OF_WEEK).getExpression(), QuestionMark.class) == true) goto L9;
    L11:
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r2.retrieve(CronFieldName.DAY_OF_MONTH).getExpression(), QuestionMark.class) == false) goto L11;
        return true;
    }
}
