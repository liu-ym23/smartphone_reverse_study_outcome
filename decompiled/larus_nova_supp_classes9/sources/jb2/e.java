package jb2;

import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends fk6.a implements a {
    public final int d;
    public final String e;
    public final int f;
    public final b g;

    @Override // jb2.a
    public final b b() {
        return this.g;
    }

    public final int getType() {
        return this.d;
    }

    public e(int r2, String r3, int r4, ek6.b r5, ImageStyle r6, ib2.a r7, b r8) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r5, "payload");
        super(r5, r6, r7);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r8;
    }
}
