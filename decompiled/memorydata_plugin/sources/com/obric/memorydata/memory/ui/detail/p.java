package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerTransitionSnapshot;", "", "<init>", "()V", "TAG", "", "pendingBitmap", "Landroid/graphics/Bitmap;", "capture", "", "activity", "Landroid/app/Activity;", "take", "clear", "", "replace", "bitmap", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f10869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Bitmap f10870b;

    static {
        f10869a = new p();
    }

    private p() {
    }

    private final void a(Bitmap r2) {
        Bitmap r1 = f10870b;
        f10870b = r2;
        if (r1 == r2) goto L12;
        boolean r3 = false;
        if (r1 != null) goto L7;
    L9:
        if (r3 == false) goto L13;
        r1.recycle();
        return;
    L13:
        return;
    L7:
        if (r1.isRecycled() == true) goto L9;
        r3 = true;
        goto L9
    }

    public final synchronized Bitmap a() {
        monitor-enter(this);
        Bitmap r0 = f10870b;     // Catch: Throwable -> L6
        f10870b = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(Activity r10) {
        monitor-enter(this);
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r11, "activity");     // Catch: Throwable -> L28
        View r12 = ZeusTransformUtils.getWindow(r11, "com.obric.memorydata.plugin").getDecorView();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r12, "getDecorView(...)");     // Catch: Throwable -> L28
        if (r12.getWidth() > 0) goto L6;
    L26:
        monitor-exit(this);
        return false;
    L6:
        if (r12.getHeight() <= 0) goto L26;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        p r1 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Bitmap r2 = Bitmap.createBitmap(r12.getWidth(), r12.getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L10
        r12.draw(new Canvas(r2));     // Catch: Throwable -> L10
        Object r13 = Result.m1421constructorimpl(r2);     // Catch: Throwable -> L10
    L12:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);     // Catch: Throwable -> L28
        if (r3 == null) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageViewerSnapshot", "capture previous screen failed: " + r3.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L28
    L16:
        if (Result.m1427isFailureimpl(r13) == false) goto L18;
        r13 = null;
    L18:
        Bitmap r14 = (Bitmap) ZeusTransformUtils.preCheckCast(r13, Bitmap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r14 != null) goto L22;
        monitor-exit(this);
        return false;
    L22:
        a(r14);     // Catch: Throwable -> L28
        monitor-exit(this);
        return true;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L28
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        a(null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
