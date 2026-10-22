package com.bytedance.android.livesdk.interactivity.comment.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.interaction.GetInterestKpListResponse.ResponseData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/model/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "title", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitle$annotations", "()V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/model/a;", "kpList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setKpList", "(Ljava/util/List;)V", "getKpList$annotations", "<init>", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("interest_kp_list")
    protected List<a> kpList;

    @SerializedName("title_txt")
    protected String title;

    public b() {
        this.title = BuildConfig.FLAVOR;
    }

    public final List<a> a() {
        return this.kpList;
    }

    public final String b() {
        return this.title;
    }

    public b(g r5) {
        this.kpList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.kpList.add(new a(r5));
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.title != null) goto L25;
        this.title = BuildConfig.FLAVOR;
        return;
    }
}
