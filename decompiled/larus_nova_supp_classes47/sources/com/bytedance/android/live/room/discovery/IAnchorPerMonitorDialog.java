package com.bytedance.android.live.room.discovery;

import android.content.Context;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/IAnchorPerMonitorDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IAnchorPerMonitorDialog extends CommonBottomDialog {
    public abstract void M0(int r1, boolean r2);

    public abstract void N0(int r1);

    public void O0(int r1) {
    }

    public abstract void P0(int r1);

    public abstract void Q0();

    public IAnchorPerMonitorDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
