package y6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public String a;
    public String b;
    public String c;
    public String d;

    public e() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    public e(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "desc");
        Intrinsics.checkNotNullParameter(r12, "image");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.c = r11;
        this.d = r12;
        this.b = r13;
    }
}
