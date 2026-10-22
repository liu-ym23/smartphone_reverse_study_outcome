package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusLayoutRecordMinutesSyncHeaderBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ProgressBar b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutRecordMinutesSyncHeaderBinding(ConstraintLayout r1, ProgressBar r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
