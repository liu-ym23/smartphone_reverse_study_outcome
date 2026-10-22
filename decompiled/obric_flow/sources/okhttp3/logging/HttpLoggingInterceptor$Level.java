package okhttp3.logging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"okhttp3/logging/HttpLoggingInterceptor$Level", "", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
public final enum HttpLoggingInterceptor$Level extends Enum<HttpLoggingInterceptor$Level> {
    public static final HttpLoggingInterceptor$Level BASIC = null;
    public static final HttpLoggingInterceptor$Level BODY = null;
    public static final HttpLoggingInterceptor$Level HEADERS = null;
    public static final HttpLoggingInterceptor$Level NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpLoggingInterceptor$Level[] f20697a = null;

    static {
        HttpLoggingInterceptor$Level r5 = new HttpLoggingInterceptor$Level("NONE", 0);
        NONE = r5;
        HttpLoggingInterceptor$Level r10 = new HttpLoggingInterceptor$Level("BASIC", 1);
        BASIC = r10;
        HttpLoggingInterceptor$Level r11 = new HttpLoggingInterceptor$Level("HEADERS", 2);
        HEADERS = r11;
        HttpLoggingInterceptor$Level r12 = new HttpLoggingInterceptor$Level("BODY", 3);
        BODY = r12;
        f20697a = new HttpLoggingInterceptor$Level[]{r5, r10, r11, r12};
    }

    public static HttpLoggingInterceptor$Level valueOf(String r5) {
        return (HttpLoggingInterceptor$Level) Enum.valueOf(HttpLoggingInterceptor$Level.class, r5);
    }

    public static HttpLoggingInterceptor$Level[] values() {
        return (HttpLoggingInterceptor$Level[]) f20697a.clone();
    }
}
