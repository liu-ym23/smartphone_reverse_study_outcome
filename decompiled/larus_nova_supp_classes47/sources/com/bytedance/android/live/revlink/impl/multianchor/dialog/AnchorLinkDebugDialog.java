package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.revenuelink.rtc.f;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.livesdk.LiveDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/AnchorLinkDebugDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkDebugDialog extends LiveDialogFragment {
    public Map<Integer, View> d;

    public AnchorLinkDebugDialog() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.d).get(2131368597);
        if (r4 != null) goto L13;
        View r5 = getView();
        if (r5 == null) goto L12;
        r4 = r5.findViewById(2131368597);
        if (r4 == null) goto L12;
        this.d.put(2131368597, r4);
    L12:
        r4 = null;
    L13:
        TextView r6 = (TextView) r4;
        f r7 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r7 == null) goto L20;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L20;
        String r9 = r8.U0();
        if (r9 == null) goto L20;
    L21:
        r6.setText(r9);
        return;
    L20:
        r9 = "";
        goto L21
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565382, r3, false);
    }
}
