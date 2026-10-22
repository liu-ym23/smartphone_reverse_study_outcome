package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(r10);
    }
}
