package com.obric.cae.userAware.ui;

import android.view.View;
import android.widget.BaseAdapter;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAdapter f6008b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6009m;

    public /* synthetic */ o(BaseAdapter r8, Object r10, int r11) {
        this.f6007a = r11;
        this.f6008b = r8;
        this.f6009m = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f6007a;
        Object r11 = this.f6009m;
        BaseAdapter r12 = this.f6008b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HARRecordAdapter.b((HARRecordAdapter) r12, (HARFeedbackInfo) r11, r8);
        return;
    L7:
        SubwayRecordAdapter.c((SubwayRecordAdapter) r12, (SubwayFeedbackInfo) r11, r8);
    }
}
