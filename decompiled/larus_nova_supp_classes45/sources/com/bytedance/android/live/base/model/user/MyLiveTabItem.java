package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/base/model/user/MyLiveTabItem;", "", "()V", "dslItem", "Lcom/bytedance/android/live/base/model/user/LiveDSLContainer;", "getDslItem", "()Lcom/bytedance/android/live/base/model/user/LiveDSLContainer;", "setDslItem", "(Lcom/bytedance/android/live/base/model/user/LiveDSLContainer;)V", "localId", "", "getLocalId", "()Ljava/lang/Integer;", "setLocalId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "radius", "", "", "getRadius", "()Ljava/util/Map;", "setRadius", "(Ljava/util/Map;)V", "uiConfig", "Lcom/bytedance/android/live/base/model/user/MyLiveUIConfig;", "getUiConfig", "()Lcom/bytedance/android/live/base/model/user/MyLiveUIConfig;", "setUiConfig", "(Lcom/bytedance/android/live/base/model/user/MyLiveUIConfig;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyLiveTabItem implements vh7.h {

    @SerializedName("dsl_item")
    protected LiveDSLContainer dslItem;
    private Integer localId;
    private Map<String, String> radius;

    @SerializedName("ui_config")
    protected MyLiveUIConfig uiConfig;

    public MyLiveTabItem() {
    }

    public final LiveDSLContainer getDslItem() {
        return this.dslItem;
    }

    public final Integer getLocalId() {
        return this.localId;
    }

    public final Map<String, String> getRadius() {
        return this.radius;
    }

    public final MyLiveUIConfig getUiConfig() {
        return this.uiConfig;
    }

    public MyLiveTabItem(am3.g r9) {
        long r0 = r9.c();
    L3:
        int r2 = r9.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        MyLiveUIConfig r3 = new MyLiveUIConfig();
        long r5 = r9.c();
    L12:
        int r7 = r9.f();
        if (r7 == (-1)) goto L17;
        if (r7 != 1) goto L15;
        r3.group = am3.h.c(r9);
        goto L12
    L15:
        am3.h.e(r9);
        goto L12
    L17:
        r9.d(r5);
        this.uiConfig = r3;
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.dslItem = new LiveDSLContainer(r9);
        goto L3
    L9:
        am3.h.e(r9);
        goto L3
    L18:
        r9.d(r0);
    }

    public final void setDslItem(LiveDSLContainer r1) {
        this.dslItem = r1;
    }

    public final void setLocalId(Integer r1) {
        this.localId = r1;
    }

    public final void setRadius(Map<String, String> r1) {
        this.radius = r1;
    }

    public final void setUiConfig(MyLiveUIConfig r1) {
        this.uiConfig = r1;
    }
}
