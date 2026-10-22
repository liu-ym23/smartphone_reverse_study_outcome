package com.larus.avlink.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.record.ui.RecordMinutesBottomView;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.avlink.record.ui.RecordMinutesOnboardingView;
import com.larus.avlink.record.ui.RecordMinutesSyncHeaderView;
import com.larus.avlink.record.ui.RecordMinutesTitleView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutFragmentRecordMinutesBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecordMinutesBottomView b;
    public final RecordMinutesLoadingOrRetryView c;
    public final LayoutRecordMinutesNetworkBannerBinding d;
    public final RecordMinutesOnboardingView e;
    public final RecyclerView f;
    public final SwipeRefreshLayout g;
    public final RecordMinutesSyncHeaderView h;
    public final RecordMinutesTitleView i;

    public final View getRoot() {
        return this.a;
    }

    public LayoutFragmentRecordMinutesBinding(ConstraintLayout r1, RecordMinutesBottomView r2, RecordMinutesLoadingOrRetryView r3, LayoutRecordMinutesNetworkBannerBinding r4, RecordMinutesOnboardingView r5, RecyclerView r6, SwipeRefreshLayout r7, RecordMinutesSyncHeaderView r8, RecordMinutesTitleView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
