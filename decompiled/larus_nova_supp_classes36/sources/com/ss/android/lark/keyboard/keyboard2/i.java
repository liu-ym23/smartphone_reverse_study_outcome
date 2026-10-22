package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public final View a;
    public final b b;

    public interface a {
        void performClick();
    }

    public interface b extends a {
        KeyboardMenu.f a();
    }

    public i(AppCompatImageView r2, KeyboardMenu.f r3) {
        Intrinsics.checkNotNullParameter(r2, "iconView");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
    }
}
