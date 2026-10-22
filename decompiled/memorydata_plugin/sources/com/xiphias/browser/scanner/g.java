package com.xiphias.browser.scanner;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.util.AutoFitSurfaceView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerUiBinding;", "", "root", "Landroid/view/View;", "scannerPage", "inactivePage", "surfaceView", "Lcom/xiphias/browser/scanner/util/AutoFitSurfaceView;", "scannerMaskView", "Lcom/xiphias/browser/scanner/ScannerMaskView;", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/xiphias/browser/scanner/util/AutoFitSurfaceView;Lcom/xiphias/browser/scanner/ScannerMaskView;)V", "getRoot", "()Landroid/view/View;", "getScannerPage", "getInactivePage", "getSurfaceView", "()Lcom/xiphias/browser/scanner/util/AutoFitSurfaceView;", "getScannerMaskView", "()Lcom/xiphias/browser/scanner/ScannerMaskView;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f16346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f16347b;
    private final View c;
    private final AutoFitSurfaceView d;
    private final ScannerMaskView e;

    public g(View r2, View r3, View r4, AutoFitSurfaceView r5, ScannerMaskView r6) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "scannerPage");
        Intrinsics.checkNotNullParameter(r4, "inactivePage");
        Intrinsics.checkNotNullParameter(r5, "surfaceView");
        Intrinsics.checkNotNullParameter(r6, "scannerMaskView");
        this.f16346a = r2;
        this.f16347b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final View a() {
        return this.f16346a;
    }

    public final View b() {
        return this.f16347b;
    }

    public final View c() {
        return this.c;
    }

    public final AutoFitSurfaceView d() {
        return this.d;
    }

    public final ScannerMaskView e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f16346a, r6.f16346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16347b, r6.f16347b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f16346a.hashCode() * 31) + this.f16347b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ScannerUiBinding(root=" + this.f16346a + ", scannerPage=" + this.f16347b + ", inactivePage=" + this.c + ", surfaceView=" + this.d + ", scannerMaskView=" + this.e + ')';
    }
}
