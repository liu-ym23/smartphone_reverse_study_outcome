package com.cronutils.model;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import rr7.b;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CompositeCron implements Cron {
    private List<Cron> crons;
    private CronDefinition definition;
    private Pattern split;

    @Override // com.cronutils.model.Cron
    public String asString() {
        StringBuilder r0 = new StringBuilder();
        List r1 = (List) this.crons.stream().map(new b()).collect(Collectors.toList());
        int r3 = ((String) ListProtector.get(r1, 0)).split(" ").length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L13;
        StringBuilder r6 = new StringBuilder();
        Iterator r7 = r1.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.append(String.format("%s ", new Object[]{((String) r7.next()).split(" ")[r5]}));
        goto L6
    L8:
        String r8 = r6.toString().trim().replaceAll(" ", "|");
        if (this.split.splitAsStream(r8).distinct().limit(2).count() > 1) goto L11;
        r8 = this.split.split(r8)[0];
    L11:
        r0.append(String.format("%s ", new Object[]{r8}));
        r5 = r5 + 1;
        goto L3
    L13:
        return r0.toString().trim();
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public Cron validate() {
        Iterator<Cron> r0 = this.crons.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().validate();
        goto L4
    L6:
        return this;
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.definition;
    }

    public List<Cron> getCrons() {
        return this.crons;
    }

    public CompositeCron(List<Cron> r6) {
        this.split = PatternProtector.compile("\\|");
        this.crons = Collections.unmodifiableList(r6);
        a.c(r6, "List of Cron cannot be null or empty");
        boolean r0 = false;
        this.definition = ((Cron) ListProtector.get(r6, 0)).getCronDefinition();
        if (r6.size() != r6.stream().filter(new rr7.a(this)).count()) goto L5;
        r0 = true;
    L5:
        a.a(r0, "All Cron objects must have same definition for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r2) {
        return asString().equals(r2.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r2) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    public static /* synthetic */ boolean a(CompositeCron r0, Cron r1) {
        r0.getClass();
        return r1.getCronDefinition().equals(r0.definition);
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(qr7.b r1, Cron r2) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }
}
