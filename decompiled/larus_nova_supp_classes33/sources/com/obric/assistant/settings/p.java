package com.obric.assistant.settings;

import android.content.DialogInterface;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class p implements Function2 {
    public final /* synthetic */ MutableLiveData a;
    public final /* synthetic */ List b;

    public /* synthetic */ p(MutableLiveData r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5, Object r6) {
        MutableLiveData r0 = this.a;
        List r1 = this.b;
        DialogInterface r7 = (DialogInterface) r5;
        ((Integer) r6).intValue();
        Intrinsics.checkNotNullParameter(r7, "dialog");
        r7.dismiss();
        Boolean r8 = Boolean.TRUE;
        ArrayList r9 = new ArrayList();
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((SelectableToggleItem) r3).d == false) goto L4;
        r9.add(r3);
        goto L4
    L8:
        r0.setValue(new Pair(r8, r9));
        return Unit.INSTANCE;
    }
}
