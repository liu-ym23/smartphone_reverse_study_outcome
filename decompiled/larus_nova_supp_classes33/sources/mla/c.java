package mla;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements e {
    public final DateTimeFormatter b;

    public c() {
        Locale r0 = Locale.getDefault();
        DateTimeFormatter r1 = DateTimeFormatter.h;
        DateTimeFormatterBuilder r2 = new DateTimeFormatterBuilder();
        r2.g("d");
        this.b = r2.q(r0);
    }
}
