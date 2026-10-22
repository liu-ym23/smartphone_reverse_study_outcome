package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.MemoryAbilityGetStatusResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/h;", "", "", "rememberStatus", "I", "b", "()I", "setRememberStatus", "(I)V", "rememberCardStatus", "a", "setRememberCardStatus", "showLiveData", "d", "setShowLiveData", "showImportantCard", "c", "setShowImportantCard", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("remember_card_status")
    protected int rememberCardStatus;

    @SerializedName("remember_status")
    protected int rememberStatus;

    @SerializedName("show_important_card")
    protected int showImportantCard;

    @SerializedName("show_live_data")
    protected int showLiveData;

    public h() {
    }

    public final String toString() {
        return "MemoryAbilityGetStatusResponse{rememberStatus=" + this.rememberStatus + ", rememberCardStatus=" + this.rememberCardStatus + ", showLiveData=" + this.showLiveData + '}';
    }

    public final int a() {
        return this.rememberCardStatus;
    }

    public final int b() {
        return this.rememberStatus;
    }

    public final int c() {
        return this.showImportantCard;
    }

    public final int d() {
        return this.showLiveData;
    }

    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.rememberStatus = (int) r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rememberCardStatus = (int) r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.showLiveData = (int) r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.showImportantCard = (int) r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
