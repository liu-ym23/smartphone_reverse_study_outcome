package com.larus.suggest.impl.popup;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u extends BaseDataSubscriber<Void> {
    public final /* synthetic */ String a;

    public u(String r1) {
        this.a = r1;
    }

    public final void onFailureImpl(DataSource<Void> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        FLogger.a.i("NexPulseDialogManager", "preload video cover failed " + this.a);
    }

    public final void onNewResultImpl(DataSource<Void> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        FLogger.a.i("NexPulseDialogManager", "preload video cover success " + this.a);
        q.d = true;
    }
}
