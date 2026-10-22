package a41;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public String a;
    public String b;
    public String c;
    public String d;
    public final HSImageView e;
    public final HSImageView f;

    public b(HSImageView r1, HSImageView r2) {
        this.e = r1;
        this.f = r2;
    }

    public final void a(String r2, String r3) {
        if (t41.a.m.a() == true) goto L5;
    L9:
        ImageLoader.bindImage(this.e, r2);
        ImageLoader.bindImage(this.f, r3);
        this.c = r2;
        this.d = r3;
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.c) == false) goto L9;
        if (Intrinsics.areEqual(r3, this.d) == false) goto L9;
    }
}
