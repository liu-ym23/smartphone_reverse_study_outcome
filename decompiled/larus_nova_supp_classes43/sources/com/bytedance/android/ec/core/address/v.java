package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/core/address/v;", "", "Lcom/bytedance/android/ec/core/address/y;", "_addressUpdateConfig", "Lcom/bytedance/android/ec/core/address/y;", "Lcom/bytedance/android/ec/core/address/h0;", "_notifyDialogConfig", "Lcom/bytedance/android/ec/core/address/h0;", "Lcom/bytedance/android/ec/core/address/x;", "_addressStrategy", "Lcom/bytedance/android/ec/core/address/x;", "", "Lcom/bytedance/android/ec/core/address/j0;", "_schemaList", "Ljava/util/List;", "Lcom/bytedance/android/ec/core/address/g0;", "_locateConfig", "Lcom/bytedance/android/ec/core/address/g0;", "", "", "_pageBtmCode", "Ljava/util/Map;", "", "_useDefaultLocation", "Ljava/lang/Boolean;", "Lcom/bytedance/android/ec/core/address/k0;", "_sdkRuntimeConfig", "Lcom/bytedance/android/ec/core/address/k0;", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {
    public static final /* synthetic */ int c = 0;

    @SerializedName("address_strategy")
    private x _addressStrategy;

    @SerializedName("address_update_config")
    private y _addressUpdateConfig;

    @SerializedName("locate_config")
    private g0 _locateConfig;

    @SerializedName("notify_dialog_config")
    private h0 _notifyDialogConfig;

    @SerializedName("page_btm_code")
    private Map<String, String> _pageBtmCode;

    @SerializedName("hook_schema_list")
    private List<j0> _schemaList;

    @SerializedName("sdk_runtime_config")
    private k0 _sdkRuntimeConfig;

    @SerializedName("use_default_location")
    private Boolean _useDefaultLocation;
    public Map<String, j0> a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public v() {
        this(false);
    }

    public final x a() {
        x r0 = this._addressStrategy;
        if (r0 != null) goto L6;
        x r1 = new x(null);
        this._addressStrategy = r1;
        return r1;
    L6:
        return r0;
    }

    public final y b() {
        y r0 = this._addressUpdateConfig;
        if (r0 != null) goto L6;
        y r1 = new y(0);
        this._addressUpdateConfig = r1;
        return r1;
    L6:
        return r0;
    }

    public final Map<String, j0> c() {
        if (this.a != null) goto L16;
        List<j0> r0 = this._schemaList;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r0 == null) goto L14;
        Iterator<T> r10 = r0.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        j0 r11 = (j0) r10.next();
        if (r11.b() == null) goto L8;
        if (r11.a() == null) goto L8;
        r1.put(r11.b(), r11);
    L14:
        this.a = r1;
    L16:
        return this.a;
    }

    public final g0 d() {
        g0 r0 = this._locateConfig;
        if (r0 != null) goto L6;
        g0 r1 = new g0(null);
        this._locateConfig = r1;
        return r1;
    L6:
        return r0;
    }

    public final h0 e() {
        h0 r0 = this._notifyDialogConfig;
        if (r0 != null) goto L6;
        h0 r1 = new h0(null);
        this._notifyDialogConfig = r1;
        return r1;
    L6:
        return r0;
    }

    public final boolean h() {
        return Intrinsics.areEqual(this._useDefaultLocation, Boolean.TRUE);
    }

    public final Map<String, String> f() {
        return this._pageBtmCode;
    }

    public final k0 g() {
        return this._sdkRuntimeConfig;
    }

    public v(boolean r1) {
        this.b = r1;
    }
}
