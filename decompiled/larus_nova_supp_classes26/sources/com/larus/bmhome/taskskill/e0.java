package com.larus.bmhome.taskskill;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.flowskill.impl.databinding.LarusLayoutPcLocalCvsHintBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ e0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        SkillComponent r0 = this.a;
        ViewGroup r6 = (ViewGroup) r5;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r6, "parentView");
        LarusLayoutPcLocalCvsHintBinding r2 = r0.t;
        if (r2 != null) goto L9;
        ConstraintLayout r7 = LayoutInflater.from(r6.getContext()).inflate(2131562859, r6, false);
        TextView r3 = (TextView) ViewBindings.findChildViewById(r7, 2131391098);
        if (r3 == null) goto L11;
        r2 = new LarusLayoutPcLocalCvsHintBinding(r7, r3);
        r0.t = r2;
        goto L9
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(2131391098)));
    L9:
        return r2.a;
    }
}
