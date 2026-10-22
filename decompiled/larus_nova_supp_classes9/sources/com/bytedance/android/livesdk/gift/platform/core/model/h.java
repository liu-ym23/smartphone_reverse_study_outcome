package com.bytedance.android.livesdk.gift.platform.core.model;

import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/h;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "groupCount", "I", "getGroupCount", "()I", "setGroupCount", "(I)V", BuildConfig.FLAVOR, "groupText", "Ljava/lang/String;", "getGroupText", "()Ljava/lang/String;", "setGroupText", "(Ljava/lang/String;)V", "<init>", "()V", "a", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements Comparable<h>, vh7.h {

    @SerializedName("group_count")
    protected int groupCount;

    @SerializedName("group_text")
    protected String groupText;

    public static final class a {
    }

    static {
    }

    public h() {
    }

    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.groupCount = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.groupText = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    @Override // java.lang.Comparable
    public final int compareTo(h r2) {
        h r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "o");
        return this.groupCount - r3.groupCount;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof h) == false) goto L10;
        h r5 = (h) r4;
        if (r5.groupCount == this.groupCount) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r5.groupText, this.groupText) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
