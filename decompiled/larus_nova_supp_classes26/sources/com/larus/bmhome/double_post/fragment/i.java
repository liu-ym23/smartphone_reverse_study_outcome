package com.larus.bmhome.double_post.fragment;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ i(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final AwemeDoublePostFragment r0 = this.a;
        int r1 = AwemeDoublePostFragment.A;
        Intrinsics.checkNotNullParameter((TextView) r3, "it");
        r0.o = false;
        u r4 = r0.w;
        if (r4 == null) goto L5;
        r4.t5();
    L5:
        r0.V90();
        LarusFragmentAwemeDoublePostBinding r5 = r0.e;
        if (r5 == null) goto L8;
        RecyclerView r6 = r5.b;
    L9:
        if (r6 == null) goto L11;
        r6.post(new c(r0));
    L11:
        r0.da0("click");
        return Unit.INSTANCE;
    L8:
        r6 = null;
        goto L9
    }
}
