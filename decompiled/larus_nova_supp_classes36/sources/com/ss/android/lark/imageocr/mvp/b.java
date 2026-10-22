package com.ss.android.lark.imageocr.mvp;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.imageocr_export.OCRParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends BaseModel {
    public final OCRParams a;
    public final Handler b;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        super.destroy();
        this.b.removeCallbacksAndMessages(null);
    }

    public b(OCRParams r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r2;
        this.b = new Handler(Looper.getMainLooper());
    }
}
