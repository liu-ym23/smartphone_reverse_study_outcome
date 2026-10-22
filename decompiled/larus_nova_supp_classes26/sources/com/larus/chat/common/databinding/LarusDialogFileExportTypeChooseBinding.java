package com.larus.chat.common.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogFileExportTypeChooseBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final FileExportTypeItemView c;
    public final RoundTextView d;
    public final FileExportTypeItemView e;
    public final FileExportTypeItemView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogFileExportTypeChooseBinding(ConstraintLayout r1, AppCompatImageView r2, FileExportTypeItemView r3, RoundTextView r4, FileExportTypeItemView r5, FileExportTypeItemView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
