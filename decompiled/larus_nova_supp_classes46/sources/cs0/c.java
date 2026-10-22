package cs0;

import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final IQuality d;
    public final String e;
    public boolean f;
    public String g;
    public boolean h;

    public c(String r2, String r3, String r4, IQuality r5) {
        this.e = "unknown";
        this.f = false;
        this.g = "";
        this.h = true;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public c(String r2, String r3, String r4, LiveCoreSDKData.Quality r5, String r6) {
        this.e = "unknown";
        this.f = false;
        this.g = "";
        this.h = true;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
