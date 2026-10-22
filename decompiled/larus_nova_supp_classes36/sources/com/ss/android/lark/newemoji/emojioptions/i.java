package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface i {

    public static final class a {
        public static float a(i r1, int r2) {
            Resources r3 = r1.a().getResources();
            return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        }
    }

    Context a();
}
