package com.ss.android.common.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6715a;

    public RecycleListView(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f6715a = true;
    }

    public final boolean recycleOnMeasure() {
        return this.f6715a;
    }
}
