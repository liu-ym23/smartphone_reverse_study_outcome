package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BlurHelper {

    public static final class a {
    }

    static {
    }

    public BlurHelper() {
    }

    public final void a(Context r11, Bitmap r12, com.larksuite.component.ignition.widget.blur.a r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        Intrinsics.checkNotNullParameter(r13, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new BlurHelper$blur$3(this, r11, r12, r13, null), 2, null);
    }
}
