package p000j;

import com.bytedance.apm6.util.constant.ReportConsts;

/* JADX INFO: loaded from: classes.dex */
public class a {
    static {
    }

    public static void a(String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(ReportConsts.HTTPS);
        r11.append(r10);
        r11.append("/monitor/collect/c/logcollect");
    }
}
