package com.obric.cae.userAware.ui;

import android.view.View;
import android.widget.BaseAdapter;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAdapter f6016b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6017m;

    public /* synthetic */ p(BaseAdapter r8, Object r10, int r11) {
        this.f6015a = r11;
        this.f6016b = r8;
        this.f6017m = r10;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r8) {
        int r10 = this.f6015a;
        Object r11 = this.f6017m;
        BaseAdapter r12 = this.f6016b;
        switch(r10) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return HARRecordAdapter.c((HARRecordAdapter) r12, (HARFeedbackInfo) r11, r8);
    L8:
        return SubwayRecordAdapter.b((SubwayRecordAdapter) r12, (SubwayFeedbackInfo) r11, r8);
    }
}
