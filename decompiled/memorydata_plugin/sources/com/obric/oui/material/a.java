package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ(\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/material/BlurShadowConfig;", "", "blurRadius", "", "shadow", "", "Lcom/obric/oui/shadow/ShadowConfig;", "(F[Lcom/obric/oui/shadow/ShadowConfig;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getShadow", "()[Lcom/obric/oui/shadow/ShadowConfig;", "setShadow", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "[Lcom/obric/oui/shadow/ShadowConfig;", "component1", "component2", "copy", "(F[Lcom/obric/oui/shadow/ShadowConfig;)Lcom/obric/oui/material/BlurShadowConfig;", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.shadow.a[] f14014b;

    public a(float r2, com.obric.oui.shadow.a[] r3) {
        Intrinsics.checkNotNullParameter(r3, "shadow");
        this.f14013a = r2;
        this.f14014b = r3;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
        if (this.f14013a != ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")).f14013a) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f14014b, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")).f14014b) == true) goto L21;
        return false;
    L21:
        return true;
    L15:
        r5 = false;
        goto L16
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        return (int) ((31 * this.f14013a) + Arrays.hashCode(this.f14014b));
    }

    public String toString() {
        return "BlurShadowConfig(blurRadius=" + this.f14013a + ", shadow=" + Arrays.toString(this.f14014b) + ')';
    }
}
