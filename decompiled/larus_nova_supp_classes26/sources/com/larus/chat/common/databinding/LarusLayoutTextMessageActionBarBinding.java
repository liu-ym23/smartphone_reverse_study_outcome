package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutTextMessageActionBarBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final LinearLayout c;
    public final LinearLayout d;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LarusLayoutTextMessageActionBarBinding(NonPriorityMessageActionBar r1, View r2, LinearLayout r3, LinearLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
