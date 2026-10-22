package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.HighlightConfig")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/h;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "pinHighlightSwitch", "I", "a", "()I", "setPinHighlightSwitch", "(I)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("pin_highlight_switch")
    protected int pinHighlightSwitch;

    public h() {
    }

    public final int a() {
        return this.pinHighlightSwitch;
    }

    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.pinHighlightSwitch = r5.i();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
