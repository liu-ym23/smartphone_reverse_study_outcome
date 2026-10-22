package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$gameMixStreamType$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$gameMixStreamType$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseGameMixStreamType", "parseGameMixStreamType()I", 0);
    }

    public final int invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        JSONObject r2 = r0.d();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.optInt("mix_stream_type");
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m377invoke() {
        return Integer.valueOf(invoke());
    }
}
