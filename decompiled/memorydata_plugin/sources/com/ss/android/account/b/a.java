package com.ss.android.account.b;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f14988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14989b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public long j;
    public long k;
    public long l;

    static {
        f14988a = new String[]{"flyme", "sina_weibo", "telecom", "qq_weibo", "renren_sns", "kaixin_sns", "qzone_sns", "mobile", "live_stream", "aweme", "aweme_v2", NotificationCompat.CATEGORY_EMAIL, "google", "facebook", "twitter", "instagram", "line", "kakaotalk", "vk", "toutiao", "toutiao_v2", "flipchat", "gogokid", "tiktok"};
    }

    public a(String r2) {
        this.f14989b = r2;
        this.c = false;
        this.d = "";
        this.e = null;
        this.f = "";
    }

    public static a a(String r1) {
        return new a(r1);
    }

    public void a() {
        this.c = false;
        this.d = "";
        this.e = null;
        this.f = "";
        this.g = "";
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.i = 0;
    }
}
