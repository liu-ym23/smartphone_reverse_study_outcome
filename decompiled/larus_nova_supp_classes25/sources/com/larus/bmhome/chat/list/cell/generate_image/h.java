package com.larus.bmhome.chat.list.cell.generate_image;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ GenerateImageCell a;

    public /* synthetic */ h(GenerateImageCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        GenerateImageCell r0 = this.a;
        ConcurrentHashMap.KeySetView r1 = GenerateImageCell.A;
        Fragment r2 = a.d(r0);
        if (r2 == null) goto L9;
        LiveData r3 = r2.getViewLifecycleOwnerLiveData();
        if (r3 == null) goto L9;
        LifecycleOwner r4 = (LifecycleOwner) r3.getValue();
        if (r4 == null) goto L9;
        return LifecycleOwnerKt.getLifecycleScope(r4);
    L9:
        return null;
    }
}
