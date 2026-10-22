package com.bytedance.android.livesdk.interactivity.like.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.LikeResponse.LikeResponseData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/api/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "doubleFlag", "Z", "a", "()Z", "setDoubleFlag", "(Z)V", "doubleFlagV2", "b", "setDoubleFlagV2", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("double_flag")
    protected boolean doubleFlag;

    @SerializedName("double_flag_v2")
    protected boolean doubleFlagV2;

    public c() {
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.doubleFlag = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.doubleFlagV2 = am3.h.a(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final boolean a() {
        return this.doubleFlag;
    }

    public final boolean b() {
        return this.doubleFlagV2;
    }
}
