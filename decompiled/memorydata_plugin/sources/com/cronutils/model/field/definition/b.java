package com.cronutils.model.field.definition;

import com.cronutils.model.field.CronFieldName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.cronutils.model.definition.b f3418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final CronFieldName f3419b;
    protected com.cronutils.model.field.constraint.a c;
    protected boolean d;

    public b(com.cronutils.model.definition.b r3, CronFieldName r4) {
        this.f3418a = (com.cronutils.model.definition.b) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r3, "ParserBuilder must not be null"), com.cronutils.model.definition.b.class, "com.obric.memorydata.plugin");
        this.f3419b = (CronFieldName) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r4, "CronFieldName must not be null"), CronFieldName.class, "com.obric.memorydata.plugin");
        this.c = com.cronutils.model.field.constraint.a.h().a(r4);
    }

    public com.cronutils.model.definition.b a() {
        this.f3418a.a(new FieldDefinition(this.f3419b, this.c.g(), this.d));
        return this.f3418a;
    }

    public b b() {
        this.c.f();
        return this;
    }

    public b c() {
        this.d = true;
        return this;
    }

    public b e(int r2, int r3) {
        this.c.b(r2, r3);
        return this;
    }

    public b f(int r2, int r3) {
        this.c.a(r2, r3);
        return this;
    }
}
