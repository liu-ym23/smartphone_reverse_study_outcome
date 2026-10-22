package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences r10, boolean r11, Function1<? super SharedPreferences.Editor, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        SharedPreferences.Editor r13 = r10.edit();
        Intrinsics.checkNotNullExpressionValue(r13, "editor");
        r12.invoke(r13);
        if (r11 == false) goto L5;
        r13.commit();
        return;
    L5:
        r13.apply();
    }

    public static /* synthetic */ void edit$default(SharedPreferences r10, boolean r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = false;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        SharedPreferences.Editor r15 = r10.edit();
        Intrinsics.checkNotNullExpressionValue(r15, "editor");
        r12.invoke(r15);
        if (r11 == false) goto L8;
        r15.commit();
        return;
    L8:
        r15.apply();
    }
}
