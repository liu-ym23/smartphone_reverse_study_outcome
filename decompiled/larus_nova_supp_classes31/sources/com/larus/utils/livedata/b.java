package com.larus.utils.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ b(MediatorLiveData r1, MutableLiveData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        this.a.setValue(TuplesKt.to(r3, this.b.getValue()));
        return Unit.INSTANCE;
    }
}
