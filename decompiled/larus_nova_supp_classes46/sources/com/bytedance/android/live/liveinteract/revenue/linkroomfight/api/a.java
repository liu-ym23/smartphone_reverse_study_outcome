package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/a;", "", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "setTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/multiscene/a;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("teamfight_info")
    protected com.bytedance.android.live.liveinteract.multiscene.a teamFightInfo;

    public a() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.liveinteract.multiscene.a, java.lang.Object] */
    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.teamFightInfo = f.a(r5, com.bytedance.android.live.liveinteract.multiscene.a.class);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
