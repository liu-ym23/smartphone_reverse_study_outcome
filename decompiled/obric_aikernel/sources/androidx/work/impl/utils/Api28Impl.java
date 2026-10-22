package androidx.work.impl.utils;

import android.app.Application;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class Api28Impl {
    public static final Api28Impl INSTANCE = null;

    static {
        INSTANCE = new Api28Impl();
    }

    private Api28Impl() {
    }

    @DoNotInline
    public final String getProcessName() {
        String r10 = Application.getProcessName();
        Intrinsics.checkNotNullExpressionValue(r10, "getProcessName()");
        return r10;
    }
}
