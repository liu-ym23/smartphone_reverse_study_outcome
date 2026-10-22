package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandIconHelper;", "", "<init>", "()V", "TAG", "", "createBitmapIcon", "Landroid/graphics/drawable/Icon;", "context", "Landroid/content/Context;", "resId", "", "bitmap", "Landroid/graphics/Bitmap;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10208a = null;

    static {
        f10208a = new c();
    }

    private c() {
    }

    public final Icon a(Context r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Drawable r13 = r12.getDrawable(r11);     // Catch: Exception -> L15
        if (r13 != null) goto L8;
        c r9 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandIconHelper", "createBitmapIcon: getDrawable returned null for resId=" + r11, null, 4, null);     // Catch: Exception -> L15
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r13, BitmapDrawable.class) == true) goto L10;
    L12:
        int r14 = RangesKt.coerceAtLeast(r13.getIntrinsicWidth(), 1);     // Catch: Exception -> L15
        int r3 = RangesKt.coerceAtLeast(r13.getIntrinsicHeight(), 1);     // Catch: Exception -> L15
        Bitmap r4 = Bitmap.createBitmap(r14, r3, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L15
        Intrinsics.checkNotNullExpressionValue(r4, "createBitmap(...)");     // Catch: Exception -> L15
        Canvas r5 = new Canvas(r4);     // Catch: Exception -> L15
        r13.setBounds(0, 0, r14, r3);     // Catch: Exception -> L15
        r13.draw(r5);     // Catch: Exception -> L15
        RunLog.INSTANCE.debug("IslandIconHelper", "createBitmapIcon: converted drawable to bitmap " + r14 + 'x' + r3);     // Catch: Exception -> L15
        Bitmap r15 = r4;
    L19:
        return Icon.createWithBitmap(r15);
    L10:
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r13, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap() == null) goto L12;
        RunLog.INSTANCE.debug("IslandIconHelper", "createBitmapIcon: drawable is BitmapDrawable, using directly");     // Catch: Exception -> L15
        r15 = ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r13, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        RunLog.INSTANCE.error("IslandIconHelper", "createBitmapIcon: EXCEPTION for resId=" + r11 + ": " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }
}
