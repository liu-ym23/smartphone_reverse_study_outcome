package com.bytedance.apm.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f1111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f1112b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;

    static {
        ArrayList r0 = new ArrayList();
        f1111a = r0;
        r0.add("https://mon.zijieapi.com/monitor/appmonitor/v5/batch_settings");
        r0.add("https://monsetting.toutiao.com/monitor/appmonitor/v5/batch_settings");
        ArrayList r1 = new ArrayList();
        f1112b = r1;
        r1.add("https://mon.zijieapi.com/monitor/collect/batch/");
        r1.add("https://mon.toutiao.com/monitor/collect/batch/");
        ArrayList r2 = new ArrayList();
        c = r2;
        r2.add("https://mon.zijieapi.com/monitor/collect/c/trace_collect");
        ArrayList r3 = new ArrayList();
        d = r3;
        r3.add("https://mon.zijieapi.com/monitor/collect/c/exception");
        r3.add("https://mon.zijieapi.com/monitor/collect/c/exception");
    }
}
