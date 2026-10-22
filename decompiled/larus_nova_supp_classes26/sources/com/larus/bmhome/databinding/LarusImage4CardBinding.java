package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusImage4CardBinding implements ViewBinding {
    public final LinearLayout a;
    public final GridLayout b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusImage4CardBinding(LinearLayout r1, GridLayout r2, ImageViewWithLastMotion r3, ViewStub r4, ImageViewWithLastMotion r5, ViewStub r6, ImageViewWithLastMotion r7, ViewStub r8, ImageViewWithLastMotion r9, ViewStub r10, TextView r11) {
        this.a = r1;
        this.b = r2;
        this.c = r11;
    }
}
