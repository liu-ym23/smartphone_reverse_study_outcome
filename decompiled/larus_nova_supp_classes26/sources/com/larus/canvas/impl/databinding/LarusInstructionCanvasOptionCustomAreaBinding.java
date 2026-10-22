package com.larus.canvas.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusInstructionCanvasOptionCustomAreaBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;

    public final View getRoot() {
        return this.a;
    }

    public static LarusInstructionCanvasOptionCustomAreaBinding a(LayoutInflater r3) {
        ConstraintLayout r4 = r3.inflate(2131562460, null, false);
        RecyclerView r1 = ViewBindings.findChildViewById(r4, 2131384978);
        if (r1 == null) goto L7;
        return new LarusInstructionCanvasOptionCustomAreaBinding(r4, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131384978)));
    }

    public LarusInstructionCanvasOptionCustomAreaBinding(ConstraintLayout r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
