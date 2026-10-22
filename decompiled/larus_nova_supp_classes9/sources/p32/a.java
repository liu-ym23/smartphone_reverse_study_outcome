package p32;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements d {
    public c a;
    public final String b;
    public final int c;

    public final c p() {
        c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("highlightContainer");
    L5:
        return r0;
    }

    @Override // p32.d
    public String getId() {
        return this.b;
    }

    @Override // p32.d
    public final int getPriority() {
        return this.c;
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.b = r2;
        this.c = r3;
    }
}
