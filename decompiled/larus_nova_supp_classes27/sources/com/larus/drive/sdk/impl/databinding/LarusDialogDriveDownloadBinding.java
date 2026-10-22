package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogDriveDownloadBinding implements ViewBinding {
    public final CardView a;
    public final ImageView b;
    public final CircleProgressBar c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogDriveDownloadBinding(CardView r1, ImageView r2, CircleProgressBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
