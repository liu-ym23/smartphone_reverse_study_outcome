package com.bytedance.android.live.room.api.record.guide;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PublishDialogInfo {
    public boolean a;
    public final Lazy b;
    public DataCenter c;
    public final Lazy d;
    public final Context e;
    public final String f;
    public final String g;

    public final Context getContext() {
        return this.e;
    }

    public PublishDialogInfo(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "originFilePath");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = LazyKt.lazy(new PublishDialogInfo$finalFilePath$2(this));
        this.d = LazyKt.lazy(PublishDialogInfo$highlightId$2.INSTANCE);
    }
}
