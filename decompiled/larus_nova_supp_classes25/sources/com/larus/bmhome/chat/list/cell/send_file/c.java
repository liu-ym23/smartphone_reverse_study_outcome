package com.larus.bmhome.chat.list.cell.send_file;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ SendFileCell a;

    public /* synthetic */ c(SendFileCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SendFileCell r0 = this.a;
        int r1 = SendFileCell.i;
        Fragment r2 = lf8.a.d(r0);
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
