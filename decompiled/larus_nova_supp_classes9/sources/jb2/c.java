package jb2;

import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends fk6.a implements a {
    public final ek6.b d;
    public final ImageStyle e;
    public final ek6.c f;
    public final b g;

    @Override // jb2.a
    public final b b() {
        return this.g;
    }

    public final ek6.c c() {
        return this.f;
    }

    public final ek6.b d() {
        return this.d;
    }

    public final ImageStyle e() {
        return this.e;
    }

    public c(ek6.b r2, ImageStyle r3, ek6.c r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        super(r2, r3, r4);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
