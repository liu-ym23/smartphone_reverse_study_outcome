package com.bytedance.android.live.openplatform.impl.miniappanchor.api.request;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.GetMicroAppOpenInfoRequest")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/request/a;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "", "scenes", "Ljava/util/List;", "getScenes", "()Ljava/util/List;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("scenes")
    protected List<String> scenes;

    public a(String r1, List<String> r2) {
        this.appId = r1;
        this.scenes = r2;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scenes, r4.scenes) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.appId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.scenes;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GetMicroAppOpenInfoRequest(appId=" + this.appId + ", scenes=" + this.scenes + ")";
    }

    public a() {
        this.appId = null;
        this.scenes = null;
    }

    public a(g r5) {
        this.scenes = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.appId = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.scenes.add(am3.h.c(r5));
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.appId != null) goto L16;
        this.appId = null;
    L16:
        if (this.scenes.isEmpty() == false) goto L28;
        this.scenes = null;
        return;
    }
}
