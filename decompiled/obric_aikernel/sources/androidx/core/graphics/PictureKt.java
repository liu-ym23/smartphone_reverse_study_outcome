package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture r10, int r11, int r12, Function1<? super Canvas, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "block");
        Canvas r14 = r10.beginRecording(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r14, "beginRecording(width, height)");
        r13.invoke(r14);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.endRecording();
        InlineMarker.finallyEnd(1);
        return r10;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.endRecording();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
