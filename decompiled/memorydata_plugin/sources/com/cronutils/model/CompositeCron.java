package com.cronutils.model;

import com.cronutils.mapper.b;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeCron implements Cron {
    private List<Cron> crons;
    private CronDefinition definition;
    private Pattern split;

    public CompositeCron(List<Cron> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.split = Pattern.compile("\\|");
        this.crons = Collections.unmodifiableList(r6);
        a.a(r6, "List of Cron cannot be null or empty");
        boolean r0 = false;
        this.definition = ((Cron) ZeusTransformUtils.preCheckCast(r6.get(0), Cron.class, "com.obric.memorydata.plugin")).getCronDefinition();
        if (r6.size() != r6.stream().filter(new $$Lambda$CompositeCron$Jty2xcqSnSNChBlchwX7Iz74OsE(this)).count()) goto L5;
        r0 = true;
    L5:
        a.a(r0, "All Cron objects must have same definition for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public String asString() {
        StringBuilder r0 = new StringBuilder();
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.crons.stream().map($$Lambda$diaE8MMX7IQhlzoJdkhY4cXWkk.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        int r4 = ((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin")).split(" ").length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L13;
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = r1.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r7.append(String.format("%s ", new Object[]{((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")).split(" ")[r6]}));
        goto L6
    L8:
        String r9 = r7.toString().trim().replaceAll(" ", "|");
        if (this.split.splitAsStream(r9).distinct().limit(2).count() > 1) goto L11;
        r9 = this.split.split(r9)[0];
    L11:
        r0.append(String.format("%s ", new Object[]{r9}));
        r6 = r6 + 1;
        goto L3
    L13:
        return r0.toString().trim();
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(b r1, Cron r2) {
        Cron r0 = (Cron) ZeusTransformUtils.wrapperContextForParams(r2, Cron.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r3) {
        Cron r4 = (Cron) ZeusTransformUtils.wrapperContextForParams(r3, Cron.class, "com.obric.memorydata.plugin");
        return asString().equals(r4.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.definition;
    }

    public List<Cron> getCrons() {
        return this.crons;
    }

    public /* synthetic */ boolean lambda$new$0$CompositeCron(Cron r3) {
        return ((Cron) ZeusTransformUtils.wrapperContextForParams(r3, Cron.class, "com.obric.memorydata.plugin")).getCronDefinition().equals(this.definition);
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r1) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
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
        ((Cron) ZeusTransformUtils.preCheckCast(r0.next(), Cron.class, "com.obric.memorydata.plugin")).validate();
        goto L4
    L6:
        return this;
    }
}
