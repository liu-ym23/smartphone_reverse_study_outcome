package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FragmentDoraEnvObserveEventListBinding implements ViewBinding {
    public final LinearLayoutCompat a;
    public final RecyclerView b;
    public final SuperSwipeRefreshLayout c;
    public final TextView d;
    public final RecordMinutesLoadingOrRetryView e;
    public final NovaTitleBarEx f;

    public final View getRoot() {
        return this.a;
    }

    public FragmentDoraEnvObserveEventListBinding(LinearLayoutCompat r1, RecyclerView r2, SuperSwipeRefreshLayout r3, TextView r4, RecordMinutesLoadingOrRetryView r5, NovaTitleBarEx r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
