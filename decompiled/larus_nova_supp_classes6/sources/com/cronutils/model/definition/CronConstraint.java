package com.cronutils.model.definition;

import com.cronutils.model.Cron;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class CronConstraint implements Serializable {
    private static final long serialVersionUID = 6866660085991775528L;
    private final String description;

    public int hashCode() {
        return Objects.hash(new Object[]{this.description});
    }

    public abstract boolean validate(Cron r1);

    public String getDescription() {
        return this.description;
    }

    public CronConstraint(String r1) {
        this.description = r1;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.description, ((CronConstraint) r3).description);
    }
}
