package m;

import java.time.LocalTime;
import java.time.MonthDay;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f19906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f19907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f19908c = null;

    static {
        f19906a = Pattern.compile("[0-9]+");
        f19907b = Pattern.compile("^[A-Za-z].*");
        f19908c = Pattern.compile("[一-鿿]");
        LocalTime.of(1, 0, 0);
        LocalTime.of(23, 0, 0);
        MonthDay.parse("--01-01");
        MonthDay.parse("--12-31");
        MonthDay.parse("--12-22");
        MonthDay.parse("--01-19");
    }
}
