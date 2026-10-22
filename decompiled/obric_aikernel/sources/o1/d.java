package o1;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static SimpleDateFormat a() {
        return c("yyyy-MM-dd");
    }

    public static SimpleDateFormat b() {
        return c("yyyy-MM-dd HH:mm:ss");
    }

    public static SimpleDateFormat c(String r10) {
        SimpleDateFormat r11 = new SimpleDateFormat(r10, Locale.US);
        r11.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return r11;
    }
}
