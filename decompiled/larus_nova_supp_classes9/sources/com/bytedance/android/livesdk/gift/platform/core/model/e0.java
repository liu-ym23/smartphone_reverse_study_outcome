package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", BuildConfig.FLAVOR, "Lpy/k;", "toolbarIconDynamic", "Lpy/k;", "c", "()Lpy/k;", "setToolbarIconDynamic", "(Lpy/k;)V", "toolbarIconStatic", "e", "setToolbarIconStatic", BuildConfig.FLAVOR, "toolbarIconSchemaUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setToolbarIconSchemaUrl", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/core/model/z;", "popupInfos", "Ljava/util/List;", "b", "()Ljava/util/List;", "setPopupInfos", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "extra", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e0 implements vh7.h {
    public long a;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("pop_up_info")
    protected List<z> popupInfos;

    @SerializedName("toolbar_icon_dynamic")
    protected py.k toolbarIconDynamic;

    @SerializedName("toolbar_icon_scheme_url")
    protected String toolbarIconSchemaUrl;

    @SerializedName("toolbar_icon_static")
    protected py.k toolbarIconStatic;

    public e0() {
        this.popupInfos = new ArrayList();
    }

    public final Map<String, String> a() {
        return this.extra;
    }

    public final List<z> b() {
        return this.popupInfos;
    }

    public final py.k c() {
        return this.toolbarIconDynamic;
    }

    public final String d() {
        return this.toolbarIconSchemaUrl;
    }

    public final py.k e() {
        return this.toolbarIconStatic;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public e0(am3.g r11) {
        this.popupInfos = new ArrayList();
        this.extra = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L36;
        if (r2 != 1) goto L8;
        this.toolbarIconDynamic = vh7.f.a(r11, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.toolbarIconStatic = vh7.f.a(r11, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.toolbarIconSchemaUrl = am3.h.c(r11);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.popupInfos.add(new z(r11));
        goto L3
    L14:
        if (r2 != 5) goto L15;
        long r6 = r11.c();
        String r3 = null;
        String r8 = null;
    L17:
        int r9 = r11.f();
        if (r9 == (-1)) goto L24;
        if (r9 != 1) goto L20;
        r3 = am3.h.c(r11);
        goto L17
    L20:
        if (r9 != 2) goto L21;
        r8 = am3.h.c(r11);
        goto L17
    L21:
        am3.h.e(r11);
        goto L17
    L24:
        r11.d(r6);
        Map<String, String> r4 = this.extra;
        if (r3 == null) goto L31;
        if (r8 == null) goto L29;
        r4.put(r3, r8);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.e(r11);
        goto L3
    L36:
        r11.d(r0);
        if (this.popupInfos.isEmpty() == false) goto L69;
        this.popupInfos = new ArrayList();
        return;
    }
}
