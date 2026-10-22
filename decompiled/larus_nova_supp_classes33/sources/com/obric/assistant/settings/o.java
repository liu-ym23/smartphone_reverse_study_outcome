package com.obric.assistant.settings;

import android.content.DialogInterface;
import androidx.lifecycle.MutableLiveData;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class o implements Function2 {
    public final /* synthetic */ MutableLiveData a;

    public /* synthetic */ o(MutableLiveData r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        MutableLiveData r0 = this.a;
        DialogInterface r5 = (DialogInterface) r3;
        ((Integer) r4).intValue();
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r5.dismiss();
        r0.setValue(new Pair(Boolean.TRUE, CollectionsKt.emptyList()));
        return Unit.INSTANCE;
    }
}
