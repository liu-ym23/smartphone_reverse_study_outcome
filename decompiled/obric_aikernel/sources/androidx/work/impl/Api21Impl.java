package androidx.work.impl;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class Api21Impl {
    public static final Api21Impl INSTANCE = null;

    static {
        INSTANCE = new Api21Impl();
    }

    private Api21Impl() {
    }

    @DoNotInline
    public final File getNoBackupFilesDir(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        File r11 = r10.getNoBackupFilesDir();
        Intrinsics.checkNotNullExpressionValue(r11, "context.noBackupFilesDir");
        return r11;
    }
}
