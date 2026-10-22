package com.obric.aikernel.service.res;

import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f5524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f5525b;

    public j(Map<String, ? extends Object> r10, Map<String, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r11, "metrics");
        this.f5524a = r10;
        this.f5525b = r11;
    }

    public final Map<String, Object> a() {
        return this.f5524a;
    }

    public final Map<String, Long> b() {
        return this.f5525b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (Intrinsics.areEqual(this.f5524a, r11.f5524a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5525b, r11.f5525b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f5524a.hashCode() * 31) + this.f5525b.hashCode();
    }

    public String toString() {
        return "ModelDownloadEventFields(category=" + this.f5524a + ", metrics=" + this.f5525b + ')';
    }
}
