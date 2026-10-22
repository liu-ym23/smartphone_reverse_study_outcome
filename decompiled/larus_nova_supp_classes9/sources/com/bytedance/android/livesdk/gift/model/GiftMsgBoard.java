package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", BuildConfig.FLAVOR, "()V", "forMsgBoard", BuildConfig.FLAVOR, "promptText", BuildConfig.FLAVOR, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class GiftMsgBoard implements vh7.h {

    @SerializedName("for_msg_board")
    public boolean forMsgBoard;

    @SerializedName("prompt_text")
    public String promptText;

    public GiftMsgBoard() {
        this.promptText = BuildConfig.FLAVOR;
    }

    public GiftMsgBoard(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.forMsgBoard = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.promptText = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.promptText != null) goto L25;
        this.promptText = BuildConfig.FLAVOR;
        return;
    }
}
