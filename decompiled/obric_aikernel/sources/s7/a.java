package s7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("bizName")
    private final String f12726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("key")
    private final String f12727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("bizId")
    private final int f12728c;

    public a(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        this.f12726a = r10;
        this.f12727b = r11;
        this.f12728c = r12;
    }

    public final int a() {
        return this.f12728c;
    }

    public final String b() {
        return this.f12726a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aikernel.middleware.api.settings.BizMappingConfig");
        a r12 = (a) r10;
        if (Intrinsics.areEqual(this.f12726a, r12.f12726a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f12727b, r12.f12727b) == true) goto L19;
        return false;
    L19:
        if (this.f12728c == r12.f12728c) goto L21;
        return false;
    L21:
        return true;
    L8:
        r11 = null;
        goto L10
    }

    public int hashCode() {
        return (((this.f12726a.hashCode() * 31) + this.f12727b.hashCode()) * 31) + this.f12728c;
    }

    public String toString() {
        return "BizMappingConfig(bizName=" + this.f12726a + ", bizKey=" + this.f12727b + ", bizId=" + this.f12728c + ')';
    }
}
