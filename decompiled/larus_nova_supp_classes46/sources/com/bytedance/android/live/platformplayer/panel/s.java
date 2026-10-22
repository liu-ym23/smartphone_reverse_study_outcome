package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public WeakReference<DataCenter> a;
    public WeakReference<LivePlayerView> b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public volatile String g;
    public JSONObject h;
    public final Lazy i;
    public final StreamAutoAdapterStatusController$linkStateObserver$1 j;
    public final r k;
    public final StreamAutoAdapterService l;

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterStatusController$linkStateObserver$1] */
    public s() {
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        Intrinsics.checkNotNullParameter(r0, "adapterService");
        this.l = r0;
        this.a = new WeakReference(null);
        this.b = new WeakReference(null);
        this.c = "link";
        this.d = "banned";
        this.e = "pause";
        this.f = "";
        this.g = "";
        this.i = LazyKt.lazy(StreamAutoAdapterStatusController$streamAutoAdapterStatusOpt$2.INSTANCE);
        this.j = new StreamAutoAdapterStatusController$linkStateObserver$1(this);
        this.k = new r(this);
    }

    public final boolean a(JSONObject r3) {
        int r0 = 0;
        if (r3 != null) goto L5;
        return false;
    L5:
        JSONObject r4 = r3.optJSONObject("heart_beat");
        if (r4 == null) goto L8;
        JSONObject r1 = r4.optJSONObject("content");
    L9:
        if (r4 == null) goto L27;
        if (r1 == null) goto L27;
        JSONObject r5 = r1.optJSONObject("anchor_stream_status");
        if (r5 == null) goto L16;
        r0 = r5.optInt("status", 0);
    L16:
        if (Intrinsics.areEqual(this.g, this.c) == false) goto L19;
        if (r0 != 0) goto L19;
        return true;
    L19:
        if (r0 != 1) goto L21;
        String r6 = this.e;
    L25:
        this.g = r6;
        return true;
    L21:
        if (r0 == 2) goto L23;
        r6 = "";
        goto L25
    L23:
        r6 = this.d;
    L27:
        return false;
    L8:
        r1 = null;
        goto L9
    }
}
