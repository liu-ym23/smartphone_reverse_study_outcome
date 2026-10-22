package com.larus.bmhome.instruction;

import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o1 implements Function0<ViewModelStoreOwner> {
    public final /* synthetic */ ComponentFeature a;

    public o1(ComponentFeature r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return s1a.a.getActivity(this.a);
    }
}
