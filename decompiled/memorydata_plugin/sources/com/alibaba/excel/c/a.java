package com.alibaba.excel.c;

import com.alibaba.excel.i.g;
import com.alibaba.excel.i.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.commons.collections4.CollectionUtils;
import org.ehcache.config.a.e;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f139a = null;
    private static final org.ehcache.b d = null;
    private static final org.ehcache.config.b<Integer, ArrayList> e = null;
    private static final org.ehcache.b f = null;
    private static final File g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140b;
    private ArrayList<String> c;
    private final org.ehcache.config.b<Integer, ArrayList> h;
    private org.ehcache.a<Integer, ArrayList> i;
    private org.ehcache.a<Integer, ArrayList> j;
    private String k;
    private int l;

    static {
        f139a = org.slf4j.d.a(a.class);
        File r0 = g.a();
        g = r0;
        d = org.ehcache.config.a.b.c().a(org.ehcache.config.a.b.a(r0)).a(true);
        f = org.ehcache.config.a.b.c().a(true);
        e = org.ehcache.config.a.a.a(Integer.class, ArrayList.class, e.b().a(20, MemoryUnit.GB)).b();
    }

    public a(Integer r5, Integer r6) {
        this.f140b = 0;
        this.c = i.a(100);
        this.l = 0;
        if (r5 == null) goto L5;
        org.ehcache.config.a.a r7 = org.ehcache.config.a.a.a(Integer.class, ArrayList.class, e.b().a(r5.intValue(), MemoryUnit.MB));
    L6:
        this.h = r7.b();
        return;
    L5:
        r7 = org.ehcache.config.a.a.a(Integer.class, ArrayList.class, e.b().a(r6.intValue(), EntryUnit.ENTRIES));
        goto L6
    }

    @Override // com.alibaba.excel.c.c
    public String a(Integer r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.intValue() < 0) goto L17;
        int r0 = r6.intValue() / 100;
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.j.a(Integer.valueOf(r0)), ArrayList.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L14;
        r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.i.a(Integer.valueOf(r0)), ArrayList.class, "com.obric.memorydata.plugin");
        this.j.a(Integer.valueOf(r0), r1);
        org.slf4j.c r2 = f139a;
        if (r2.isDebugEnabled() == false) goto L14;
        int r3 = this.l;
        int r4 = r3 + 1;
        this.l = r4;
        if ((r3 % 1000) != 0) goto L14;
        r2.debug("Cache misses count:{}", Integer.valueOf(r4));
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r1.get(r6.intValue() % 100), String.class, "com.obric.memorydata.plugin");
    L17:
        return null;
    }

    @Override // com.alibaba.excel.c.c
    public void a() {
        if (CollectionUtils.isEmpty(this.c) == false) goto L5;
        return;
    L5:
        this.i.a(Integer.valueOf(this.f140b), this.c);
    }

    @Override // com.alibaba.excel.c.c
    public void a(com.alibaba.excel.e.a r4) {
        com.alibaba.excel.e.a r5 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        String r6 = UUID.randomUUID().toString();
        this.k = r6;
        this.i = d.a(r6, e);     // Catch: IllegalStateException -> L5
    L18:
        this.j = f.a(this.k, this.h);
        return;
    L5:
        e = move-exception;
        File r0 = g;
        if (r0.exists() == false) goto L9;
        throw e;
    L9:
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (r0.exists() == true) goto L16;
        org.slf4j.c r7 = f139a;     // Catch: Throwable -> L20
        if (r7.isDebugEnabled() == false) goto L15;
        r7.debug("cache file dir is not exist retry create");     // Catch: Throwable -> L20
    L15:
        g.a(r0);     // Catch: Throwable -> L20
    L16:
        this.i = d.a(this.k, e);
        goto L18
    }

    @Override // com.alibaba.excel.c.c
    public void a(String r4) {
        this.c.add(r4);
        if (this.c.size() < 100) goto L5;
        this.i.a(Integer.valueOf(this.f140b), this.c);
        this.f140b++;
        this.c = i.a(100);
    L5:
        org.slf4j.c r5 = f139a;
        if (r5.isDebugEnabled() == false) goto L11;
        int r1 = (this.f140b * 100) + this.c.size();
        if ((r1 % 1000000) != 0) goto L12;
        r5.debug("Already put :{}", Integer.valueOf(r1));
        return;
    L12:
        return;
    }

    @Override // com.alibaba.excel.c.c
    public void b() {
        d.a(this.k);
        f.a(this.k);
    }
}
