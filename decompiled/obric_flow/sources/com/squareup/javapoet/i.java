package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f14970c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14972b;

    static {
        Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");
        Pattern.compile("[a-z]+[\\w_]*");
    }

    public i(g r5) {
        this.f14971a = com.bytedance.android.anniex.base.service.f.x(r5.f14965a);
        this.f14972b = com.bytedance.android.anniex.base.service.f.x(r5.f14966b);
    }

    public static g a() {
        return new g();
    }

    public static i c(String r5, ArrayList r10) {
        return (i) StreamSupport.stream(r10.spliterator(), false).collect(Collector.of(new f(r5, 0), new com.google.common.hash.e(3), new com.google.common.hash.f(2), new com.google.android.material.color.utilities.h(4), new Collector.Characteristics[0]));
    }

    public static i d(String r5, Object... r10) {
        g r11 = new g();
        r11.b(r5, r10);
        return new i(r11);
    }

    public final boolean b() {
        return this.f14971a.isEmpty();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (i.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        new k(r5).c(this, false);     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }
}
