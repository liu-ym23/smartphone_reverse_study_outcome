package oe;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f9787b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f9788m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c[] f9789n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f9790a;

    static {
        c r8 = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f9787b = r8;
        c r10 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c r11 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f9788m = r11;
        f9789n = new c[]{r8, r10, r11, new c("SECONDS", 3, TimeUnit.SECONDS), new c("MINUTES", 4, TimeUnit.MINUTES), new c("HOURS", 5, TimeUnit.HOURS), new c("DAYS", 6, TimeUnit.DAYS)};
    }

    public c(String r8, int r10, TimeUnit r11) {
        super(r8, r10);
        this.f9790a = r11;
    }

    public static c valueOf(String r8) {
        return (c) Enum.valueOf(c.class, r8);
    }

    public static c[] values() {
        return (c[]) f9789n.clone();
    }
}
