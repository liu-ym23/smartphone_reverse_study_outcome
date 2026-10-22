package com.cronutils.b;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CronFieldName f3402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldConstraints f3403b;
    private final c c;
    private final boolean d;

    public b(CronFieldName r2, FieldConstraints r3) {
        this(r2, r3, false);
    }

    public b(CronFieldName r3, FieldConstraints r4, boolean r5) {
        this.f3402a = (CronFieldName) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r3, "CronFieldName must not be null"), CronFieldName.class, "com.obric.memorydata.plugin");
        this.f3403b = (FieldConstraints) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r4, "FieldConstraints must not be null"), FieldConstraints.class, "com.obric.memorydata.plugin");
        this.c = new c(r4);
        this.d = r5;
    }

    private static /* synthetic */ int a(b r0) {
        return r0.a().getOrder();
    }

    public static Comparator<b> c() {
        return Comparator.comparingInt($$Lambda$b$RkOc8xJsu5oaqokvQKaT4X6Ob44.INSTANCE);
    }

    public static /* synthetic */ int lambda$RkOc8xJsu5oaqokvQKaT4X6Ob44(b r0) {
        return a(r0);
    }

    public CronField a(String r5) {
        if (a().equals(CronFieldName.DAY_OF_WEEK) == false) goto L10;
        if (r5.endsWith(i.u) == false) goto L10;
        Integer r1 = this.f3403b.getStringMappingValue(r5.substring(0, r5.length() - 1));
        if (r1 == null) goto L10;
        r5 = r1 + i.u;
    L10:
        return new CronField(this.f3402a, this.c.a(r5), this.f3403b);
    }

    public CronFieldName a() {
        return this.f3402a;
    }

    public final boolean b() {
        return this.d;
    }

    public String toString() {
        return "CronParserField{field=" + this.f3402a + '}';
    }
}
