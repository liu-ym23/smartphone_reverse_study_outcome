package f6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f16879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f16880b = null;

    static {
        ArrayList r5 = new ArrayList();
        f16879a = r5;
        r5.add("https://mon.zijieapi.com/monitor/appmonitor/v5/batch_settings");
        r5.add("https://monsetting.toutiao.com/monitor/appmonitor/v5/batch_settings");
        ArrayList r10 = new ArrayList();
        f16880b = r10;
        r10.add("https://mon.zijieapi.com/monitor/collect/batch/");
        r10.add("https://mon.toutiao.com/monitor/collect/batch/");
        new ArrayList().add("https://mon.zijieapi.com/monitor/collect/c/trace_collect");
        ArrayList r11 = new ArrayList();
        r11.add("https://mon.zijieapi.com/monitor/collect/c/exception");
        r11.add("https://mon.zijieapi.com/monitor/collect/c/exception");
    }
}
