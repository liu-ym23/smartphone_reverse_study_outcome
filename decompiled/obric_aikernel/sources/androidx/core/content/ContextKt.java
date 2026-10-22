package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) ContextCompat.getSystemService(r10, Object.class);
    }

    public static final void withStyledAttributes(Context r10, @StyleRes int r11, int[] r12, Function1<? super TypedArray, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        Intrinsics.checkNotNullParameter(r13, "block");
        TypedArray r14 = r10.obtainStyledAttributes(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r14, "obtainStyledAttributes(resourceId, attrs)");
        r13.invoke(r14);
        r14.recycle();
    }

    public static final void withStyledAttributes(Context r10, AttributeSet r11, int[] r12, @AttrRes int r13, @StyleRes int r14, Function1<? super TypedArray, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        Intrinsics.checkNotNullParameter(r15, "block");
        TypedArray r16 = r10.obtainStyledAttributes(r11, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r16, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        r15.invoke(r16);
        r16.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context r10, AttributeSet r11, int[] r12, int r13, int r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r16 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r16 & 8) == 0) goto L11;
        r14 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        Intrinsics.checkNotNullParameter(r15, "block");
        TypedArray r18 = r10.obtainStyledAttributes(r11, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r18, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        r15.invoke(r18);
        r18.recycle();
    }
}
