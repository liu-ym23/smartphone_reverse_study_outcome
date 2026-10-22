package wg0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final DataCenter a;
    public final ViewGroup b;
    public final ViewGroup c;
    public final l d;
    public final hg0.d e;
    public final o.a f;
    public final BaseMultiLinkWindowManager g;

    public e(Context r1, DataCenter r2, ViewGroup r3, ViewGroup r4, l r5, fg0.a r6, hg0.d r7, o.a r8, BaseMultiLinkWindowManager r9) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "playModeViewContainer");
        Intrinsics.checkNotNullParameter(r4, "playModeViewAlignContainer");
        Intrinsics.checkNotNullParameter(r7, "mLayerManager");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "windowManager");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
