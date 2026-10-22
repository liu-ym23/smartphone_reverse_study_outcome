package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.livesdk.gift.model.h0;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Comparator {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ((h0) r1).getGroupCount() - ((h0) r2).getGroupCount();
    }
}
