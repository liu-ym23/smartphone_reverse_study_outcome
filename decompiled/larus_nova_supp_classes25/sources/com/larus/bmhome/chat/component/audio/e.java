package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements y.a<wc9.e> {
    public final /* synthetic */ MutableLiveData<wc9.e> a;

    public e(MutableLiveData<wc9.e> r1) {
        this.a = r1;
    }

    public final void c(Object r2) {
        wc9.e r3 = (wc9.e) r2;
        Intrinsics.checkNotNullParameter(r3, "new");
        this.a.postValue(r3);
    }
}
