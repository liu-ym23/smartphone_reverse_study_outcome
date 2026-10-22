package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.LiveSenarioMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/q;", "", "", "enableLiveAudio", "Z", "getEnableLiveAudio", "()Z", "setEnableLiveAudio", "(Z)V", "enableLiveThirdParty", "getEnableLiveThirdParty", "setEnableLiveThirdParty", "enableLiveScreenshot", "getEnableLiveScreenshot", "setEnableLiveScreenshot", "Lcom/bytedance/android/live/broadcast/api/model/q$a;", "mToast", "Lcom/bytedance/android/live/broadcast/api/model/q$a;", "getMToast", "()Lcom/bytedance/android/live/broadcast/api/model/q$a;", "setMToast", "(Lcom/bytedance/android/live/broadcast/api/model/q$a;)V", "<init>", "()V", "a", "b", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q implements vh7.h {

    @SerializedName("enable_live_audio")
    protected boolean enableLiveAudio;

    @SerializedName("enable_live_screenshot")
    protected boolean enableLiveScreenshot;

    @SerializedName("enable_live_third_party")
    protected boolean enableLiveThirdParty;

    @SerializedName("toast")
    protected a mToast;

    @ProtoMessage("webcast.api.room.LiveSenarioMessage.LiveToastMessage")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/q$a;", "", "", "mNewAnchor", "Z", "getMNewAnchor", "()Z", "setMNewAnchor", "(Z)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("new_anchor")
        protected boolean mNewAnchor;

        public a() {
        }

        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.mNewAnchor = am3.h.a(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }
    }

    public static final class b {
    }

    static {
    }

    public q() {
    }

    public q(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.enableLiveAudio = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.enableLiveThirdParty = am3.h.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.enableLiveScreenshot = am3.h.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.mToast = new a(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof q) == false) goto L12;
        q r5 = (q) r4;
        if (this.enableLiveAudio == r5.enableLiveAudio) goto L7;
        return false;
    L7:
        if (this.enableLiveThirdParty == r5.enableLiveThirdParty) goto L9;
        return false;
    L9:
        if (this.enableLiveScreenshot != r5.enableLiveScreenshot) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }
}
