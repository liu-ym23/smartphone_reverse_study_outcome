package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R<\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR<\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/g;", "", "<init>", "()V", "", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "setMethods", "(Ljava/util/Map;)V", "methods", "b", "setSettings", "settings", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("methods")
    private Map<String, ? extends Map<String, ? extends Object>> f5205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("settings")
    private Map<String, ? extends Map<String, ? extends Object>> f5206b;

    public g() {
        this.f5205a = MapsKt.emptyMap();
        this.f5206b = MapsKt.emptyMap();
    }

    public final Map a() {
        return this.f5205a;
    }

    public final Map b() {
        return this.f5206b;
    }
}
