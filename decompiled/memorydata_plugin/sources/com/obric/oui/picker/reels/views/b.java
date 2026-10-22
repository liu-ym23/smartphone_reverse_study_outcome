package com.obric.oui.picker.reels.views;

import android.view.View;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;", "", "percent", "", "(F)V", "getPercent", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", "resolveReferenceView", "Landroid/view/View;", "owner", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14302a;

    public b(float r1) {
        this.f14302a = r1;
    }

    public final float a() {
        return this.f14302a;
    }

    public final View a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        ViewParent r1 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r1, View.class) == true) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Float.valueOf(this.f14302a), Float.valueOf(r6.f14302a)) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Float.hashCode(this.f14302a);
    }

    public String toString() {
        return "PercentDimensionSpec(percent=" + this.f14302a + ')';
    }
}
