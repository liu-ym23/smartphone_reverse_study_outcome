package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogAiFilePreviewShareBinding implements ViewBinding {
    public final RoundLinearLayout a;
    public final AppCompatImageView b;
    public final FrameLayout c;
    public final ProgressBar d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogAiFilePreviewShareBinding(RoundLinearLayout r1, AppCompatImageView r2, FrameLayout r3, ProgressBar r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
