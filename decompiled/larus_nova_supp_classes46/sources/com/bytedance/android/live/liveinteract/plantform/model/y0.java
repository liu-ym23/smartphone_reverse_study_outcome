package com.bytedance.android.live.liveinteract.plantform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/y0;", "", "", "needShow", "Ljava/lang/Boolean;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i1;", "explainCardInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i1;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y0 implements vh7.h {

    @SerializedName("explain_card_info")
    public com.bytedance.android.livesdk.chatroom.model.interact.i1 explainCardInfo;

    @SerializedName("need_show")
    public Boolean needShow;

    public y0() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.interact.i1, java.lang.Object] */
    public y0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.needShow = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.explainCardInfo = vh7.f.a(r5, com.bytedance.android.livesdk.chatroom.model.interact.i1.class);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
