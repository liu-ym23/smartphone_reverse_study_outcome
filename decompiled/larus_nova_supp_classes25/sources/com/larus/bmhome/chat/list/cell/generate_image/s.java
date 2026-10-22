package com.larus.bmhome.chat.list.cell.generate_image;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import kotlin.jvm.functions.Function0;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ GenerateImageScrollCell a;

    public /* synthetic */ s(GenerateImageScrollCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Fragment r0 = a.d(this.a);
        if (r0 == null) goto L9;
        LiveData r1 = r0.getViewLifecycleOwnerLiveData();
        if (r1 == null) goto L9;
        LifecycleOwner r2 = (LifecycleOwner) r1.getValue();
        if (r2 == null) goto L9;
        return LifecycleOwnerKt.getLifecycleScope(r2);
    L9:
        return null;
    }
}
