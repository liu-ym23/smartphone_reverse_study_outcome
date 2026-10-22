package com.bytedance.android.livesdk.interactivity.publicscreen.panel.model;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/model/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/data/b;", "dataList", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setDataList", "(Ljava/util/Map;)V", "version", "Ljava/lang/Long;", "getVersion", "()Ljava/lang/Long;", "setVersion", "(Ljava/lang/Long;)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("data")
    protected Map<Long, com.bytedance.android.live.base.model.data.b> dataList;

    @SerializedName("version")
    protected Long version;

    public b() {
        this.version = 0L;
    }

    public final Map<Long, com.bytedance.android.live.base.model.data.b> a() {
        return this.dataList;
    }

    public b(g r13) {
        this.dataList = new HashMap();
        long r0 = r13.c();
    L3:
        int r2 = r13.f();
        if (r2 == (-1)) goto L26;
        if (r2 != 1) goto L7;
        long r6 = r13.c();
        Long r3 = null;
        com.bytedance.android.live.base.model.data.b r8 = null;
    L11:
        int r9 = r13.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r13.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r8 = new com.bytedance.android.live.base.model.data.b(r13);
        goto L11
    L15:
        am3.h.e(r13);
        goto L11
    L18:
        r13.d(r6);
        Map<Long, com.bytedance.android.live.base.model.data.b> r4 = this.dataList;
        if (r3 == null) goto L25;
        if (r8 == null) goto L23;
        r4.put(r3, r8);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r2 != 2) goto L8;
        this.version = Long.valueOf(r13.j());
        goto L3
    L8:
        am3.h.e(r13);
        goto L3
    L26:
        r13.d(r0);
        if (this.version != null) goto L50;
        this.version = 0L;
        return;
    }
}
