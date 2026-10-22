package com.larus.bmhome.double_post.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ AwemeDoublePostFragment a;
    public final /* synthetic */ List b;

    public /* synthetic */ m(AwemeDoublePostFragment r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final AwemeDoublePostFragment r0 = this.a;
        List r1 = this.b;
        r0.i.E2(r1);
        LarusFragmentAwemeDoublePostBinding r2 = r0.e;
        if (r2 == null) goto L5;
        RecyclerView r3 = r2.b;
    L6:
        if (r3 == null) goto L9;
        r3.post(new d(r0));
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
