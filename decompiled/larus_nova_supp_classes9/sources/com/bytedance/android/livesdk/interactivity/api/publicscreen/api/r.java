package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lpy/k;", "iconList", "Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/s;", "iconMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements vh7.h {

    @SerializedName("icons")
    public List<py.k> iconList;

    @SerializedName("component_related_icons")
    protected Map<Long, s> iconMap;

    public r() {
    }

    public final Map<Long, s> a() {
        return this.iconMap;
    }

    public r(am3.g r13) {
        this.iconList = new ArrayList();
        this.iconMap = new HashMap();
        long r0 = r13.c();
    L3:
        int r2 = r13.f();
        if (r2 == (-1)) goto L27;
        if (r2 != 1) goto L8;
        this.iconList.add((py.k) vh7.f.a(r13, py.k.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r6 = r13.c();
        Long r3 = null;
        s r8 = null;
    L11:
        int r9 = r13.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r13.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r8 = new s(r13);
        goto L11
    L15:
        am3.h.e(r13);
        goto L11
    L18:
        r13.d(r6);
        Map<Long, s> r4 = this.iconMap;
        if (r3 == null) goto L25;
        if (r8 == null) goto L23;
        r4.put(r3, r8);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r13);
        goto L3
    L27:
        r13.d(r0);
    }
}
