package com.larus.suggest.impl.popup;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r extends BaseDataSubscriber<Void> {
    public final /* synthetic */ String a;

    public r(String r1) {
        this.a = r1;
    }

    public final void onFailureImpl(DataSource<Void> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        FLogger.a.i("NexPulseDialogManager", "preload image failed " + this.a);
    }

    public final void onNewResultImpl(DataSource<Void> r6) {
        Intrinsics.checkNotNullParameter(r6, "dataSource");
        FLogger.a.i("NexPulseDialogManager", "preload image success " + this.a);
        StateFlowImpl r7 = q.b;
        b1 r1 = q.c;
        e r2 = (e) r1.getValue();
        String r3 = null;
        if (r2 == null) goto L5;
        NexPulseCandidate r4 = r2.a;
    L6:
        e r5 = (e) r1.getValue();
        if (r5 == null) goto L9;
        r3 = r5.c;
    L9:
        e r8 = (e) r1.getValue();
        if (r8 == null) goto L13;
        String r9 = r8.d;
        if (r9 == null) goto L13;
    L14:
        r7.setValue(new e(r4, true, r3, r9));
        return;
    L13:
        r9 = "user_package";
        goto L14
    L5:
        r4 = null;
        goto L6
    }
}
