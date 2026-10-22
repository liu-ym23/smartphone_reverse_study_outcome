package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ObservedScrollView extends ScrollView {

    public interface a {
    }

    public void setOnScrollListener(a r1) {
    }

    public ObservedScrollView(Context r1) {
        super(r1);
    }

    public ObservedScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ObservedScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
    }
}
