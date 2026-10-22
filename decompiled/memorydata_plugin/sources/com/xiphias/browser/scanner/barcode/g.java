package com.xiphias.browser.scanner.barcode;

import android.content.Context;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BarcodeScanEngine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/xiphias/browser/scanner/barcode/ScannerManager;", "", "resultCallback", "Lcom/xiphias/browser/scanner/barcode/BarcodeResultCallback;", "<init>", "(Lcom/xiphias/browser/scanner/barcode/BarcodeResultCallback;)V", "decoder", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoder;", "configure", "", "context", "Landroid/content/Context;", "engine", "Lcom/xiphias/browser/scanner/BarcodeScanEngine;", "addSource", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/xiphias/browser/scanner/barcode/SourceData;", "startScan", "stopScan", "release", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f16335b;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16336a = null;

        static {
            int[] r0 = new int[BarcodeScanEngine.values().length];
            r0[BarcodeScanEngine.BACH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BarcodeScanEngine.ZXING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f16336a = r0;
        }
    }

    public g(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "resultCallback");
        this.f16334a = r4;
    }

    public final void a() {
        b r0 = this.f16335b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void a(Context r4, BarcodeScanEngine r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "engine");
        b r0 = this.f16335b;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        int r7 = a.f16336a[r5.ordinal()];
        if (r7 != 1) goto L8;
        b r8 = f.f16333a.b(r6, (Function1) ZeusTransformUtils.preCheckCast(new ScannerManager$configure$1(this.f16334a), Function1.class, "com.obric.memorydata.plugin"));
    L13:
        this.f16335b = r8;
        return;
    L8:
        if (r7 != 2) goto L11;
        r8 = f.f16333a.a(r6, (Function1) ZeusTransformUtils.preCheckCast(new ScannerManager$configure$2(this.f16334a), Function1.class, "com.obric.memorydata.plugin"));
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(SourceData r2) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        b r1 = this.f16335b;
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    public final void b() {
        b r0 = this.f16335b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void c() {
        b r0 = this.f16335b;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.f16335b = null;
    }
}
