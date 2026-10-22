package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/t;", BuildConfig.FLAVOR, "Lpy/k;", "mainGroupIcon", "Lpy/k;", "mainGroupBg", "guestGroupIcon", "guestGroupBg", BuildConfig.FLAVOR, "aggregateIcon", "Ljava/util/List;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t implements vh7.h {

    @SerializedName("aggregate_icon")
    public List<? extends py.k> aggregateIcon;

    @SerializedName("guest_group_background")
    public py.k guestGroupBg;

    @SerializedName("guest_group_icon")
    public py.k guestGroupIcon;

    @SerializedName("main_group_background")
    public py.k mainGroupBg;

    @SerializedName("main_group_icon")
    public py.k mainGroupIcon;

    public t() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public t(am3.g r5) {
        this.aggregateIcon = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.mainGroupIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.mainGroupBg = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.guestGroupIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.guestGroupBg = vh7.f.a(r5, py.k.class);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.aggregateIcon.add(vh7.f.a(r5, py.k.class));
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
