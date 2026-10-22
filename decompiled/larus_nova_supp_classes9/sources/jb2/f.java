package jb2;

import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends fk6.a implements a {
    public final String d;
    public final int e;
    public final float f;
    public final b g;

    @Override // jb2.a
    public final b b() {
        return this.g;
    }

    public f(String r2, int r3, float r4, ob2.f r5, ImageStyle r6, ib2.a r7, b r8) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r5, "payload");
        super(r5, r6, r7);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r8;
    }
}
