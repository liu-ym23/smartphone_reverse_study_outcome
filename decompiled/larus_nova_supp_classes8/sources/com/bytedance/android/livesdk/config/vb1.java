package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/vb1;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "fixDynamicEqual", "getFixDynamicEqual", "setFixDynamicEqual", "", "", "", "uiTransitionMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setUiTransitionMap", "(Ljava/util/Map;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class vb1 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fix_dynamic_equal")
    private boolean fixDynamicEqual;

    @SerializedName("ui_transition_map")
    private Map<String, Integer> uiTransitionMap;

    public static final class a {
        public static vb1 a() {
            return new vb1();
        }
    }

    static {
    }

    public vb1() {
        this.enable = true;
        this.fixDynamicEqual = true;
        this.uiTransitionMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("32", 32), TuplesKt.to("10000", 0)});
    }

    public final boolean a() {
        return this.enable;
    }

    public final Map<String, Integer> b() {
        return this.uiTransitionMap;
    }
}
