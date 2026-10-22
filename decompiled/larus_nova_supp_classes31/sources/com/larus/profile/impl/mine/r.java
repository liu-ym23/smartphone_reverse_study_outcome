package com.larus.profile.impl.mine;

import androidx.lifecycle.MutableLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class r implements Function0 {
    public final /* synthetic */ MineTabViewModel a;

    public /* synthetic */ r(MineTabViewModel r1) {
        this.a = r1;
    }

    public final Object invoke() {
        MutableLiveData r0 = MineTabViewModel.access$get_showBindPhoneEvent$p(this.a);
        Unit r1 = Unit.INSTANCE;
        r0.postValue(r1);
        return r1;
    }
}
