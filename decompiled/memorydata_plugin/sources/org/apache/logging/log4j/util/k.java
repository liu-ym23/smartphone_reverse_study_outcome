package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes6.dex */
public class k implements PropertySource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Properties f17929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17930b;

    public k(Properties r2) {
        this(r2, 200);
    }

    public k(Properties r1, int r2) {
        this.f17929a = r1;
        this.f17930b = r2;
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public int a() {
        return this.f17930b;
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public CharSequence a(Iterable<? extends CharSequence> r2) {
        return "log4j2." + PropertySource.a.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public String a(String r1) {
        return this.f17929a.getProperty(r1);
    }

    public void a(a<String, String> r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        Iterator r4 = this.f17929a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r6.accept((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public Collection<String> b() {
        return this.f17929a.stringPropertyNames();
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public boolean b(String r1) {
        if (a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
