package com.bytedance.android.live.revlink.impl.pk.dialog.adapter;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder a;

    public c(PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r5 = this.a;
        j r0 = r5.f.f;
        String r6 = r5.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "queryWord");
        r0.j.remove(r6);
        Map r7 = j.f();
        r7.put(String.valueOf(r0.z), r0.j);
        l51.a.N(r7);
        r0.d.postValue(r0.j);
    }
}
