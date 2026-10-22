package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ PkRandomMatchDialogV2 a;

    public m(PkRandomMatchDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        y31.k r4 = (y31.k) r3;
        if (r4 != null) goto L22;
        PkAutoMatchDataContext r5 = this.a.o;
        if (r5 == null) goto L7;
        List<Object> r6 = r5.getMUserListWhenInvite();
    L8:
        if (r6 == null) goto L18;
        PkRandomMatchDialogV2 r0 = this.a;
        r0.k = r6;
        MultiTypeAdapter r1 = r0.j;
        if (r1 == null) goto L12;
        r1.a = r6;
    L12:
        View r7 = r0.m;
        if (r7 == null) goto L15;
        r7.post(new l(this));
    L15:
        MultiTypeAdapter r8 = this.a.j;
        if (r8 == null) goto L18;
        r8.notifyDataSetChanged();
    L18:
        PkItemExposeRecyclerView r9 = this.a.i;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L21:
        r9.setLayoutManager(new FixedForAppBarLayoutManager(this.a.getContext()));
        return;
    L7:
        r6 = null;
        goto L8
    L22:
        PkRandomMatchDialogV2 r2 = this.a;
        String r10 = PkRandomMatchDialogV2.r;
        r2.Z90(r4, false);
    }
}
