package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TextUtils.isDigitsOnly(r10);
    }

    public static final int trimmedLength(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TextUtils.getTrimmedLength(r10);
    }
}
