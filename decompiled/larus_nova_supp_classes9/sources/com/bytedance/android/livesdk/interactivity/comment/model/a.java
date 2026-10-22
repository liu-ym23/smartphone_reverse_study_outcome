package com.bytedance.android.livesdk.interactivity.comment.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.interaction.GetInterestKpListResponse.InterestKpMeta")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/model/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "J", "a", "()J", BuildConfig.FLAVOR, "kp", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setKp", "(Ljava/lang/String;)V", "getKp$annotations", "()V", "<init>", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("id")
    protected long id;

    @SerializedName("interest_kp")
    protected String kp;

    public a() {
    }

    public final int hashCode() {
        long r0 = this.id;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final long a() {
        return this.id;
    }

    public final String b() {
        return this.kp;
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.id = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.kp = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r3)) == false) goto L12;
        return false;
    L12:
        long r4 = this.id;
        if ((r7 instanceof a) == true) goto L15;
        r7 = null;
    L15:
        a r8 = (a) r7;
        if (r8 != null) goto L18;
    L20:
        return false;
    L18:
        if (r4 != r8.id) goto L20;
        return true;
    L8:
        r3 = null;
        goto L10
    }
}
