package com.alibaba.excel.metadata;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Field f292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f293b;
    private String[] c;

    public i() {
    }

    public Field a() {
        return this.f292a;
    }

    public void a(String r1) {
        this.f293b = r1;
    }

    public void a(Field r1) {
        this.f292a = r1;
    }

    public void a(String[] r1) {
        this.c = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, i.class);
    }

    public String b() {
        return this.f293b;
    }

    public String[] c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Field r0 = a();
        Field r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        String r1 = b();
        String r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 == null) goto L26;
    L24:
        return false;
    L26:
        if (Arrays.deepEquals(c(), r6.c()) == true) goto L28;
        return false;
    L28:
        return true;
    L23:
        if (r1.equals(r3) == true) goto L26;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public int hashCode() {
        Field r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        String r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return ((r4 + r1) * 59) + Arrays.deepHashCode(c());
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
