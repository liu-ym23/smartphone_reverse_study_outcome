package m0;

import com.bytedance.apm6.util.constant.ReportConsts;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10956a;

    public static void a(String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(ReportConsts.HTTPS);
        r11.append(r10);
        r11.append("/monitor/collect/c/code_coverage");
    }

    public static void b(String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(ReportConsts.HTTPS);
        r11.append(r10);
        r11.append("/monitor/collect/c/logcollect");
        f10956a = r10;
    }
}
