package com.obric.oui.indicator;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends DataSetObserver implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBaseIndicator f13497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPager f13498b;

    public n(OBaseIndicator r5, ViewPager r10) {
        this.f13497a = r5;
        this.f13498b = r10;
    }

    @Override // com.obric.oui.indicator.m
    public final Function1 a() {
        final ViewPager r5 = this.f13498b;
        return new OBaseIndicator$setViewPager$2$releaseAction$1(r5);
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        super.onChanged();
        this.f13497a.h();
    }
}
