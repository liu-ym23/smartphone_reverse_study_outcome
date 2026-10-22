package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001a\u0010#\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001a\u0010'\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/config/h31;", "", "", "styleType", "I", "h", "()I", "showMillMs", "getShowMillMs", "", "", "followingEntrances", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "jumpFactor", "F", "f", "()F", "", "adaptMultiTab", "Z", "getAdaptMultiTab", "()Z", "useNewConfig", "i", "", "Lcom/bytedance/android/livesdk/config/r4;", "entranceItemConfig", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "feedBackBugFix", "d", "livetabUseNewConfig", "g", "refactorEmpty", "getRefactorEmpty", "enterSourceFix", "b", "enterEntrancesComponent", "a", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h31 {

    @SerializedName("adapt_multi_tab")
    private final boolean adaptMultiTab;

    @SerializedName("enter_entrances_component")
    private final List<String> enterEntrancesComponent;

    @SerializedName("enter_source_fix")
    private final boolean enterSourceFix;

    @SerializedName("entrance_item_config")
    private final Map<String, r4> entranceItemConfig;

    @SerializedName("feedback_bug_fix")
    private final boolean feedBackBugFix;

    @SerializedName("follow_entrances")
    private final List<String> followingEntrances;

    @SerializedName("jump_factor")
    private final float jumpFactor;

    @SerializedName("livetab_use_new_config")
    private final boolean livetabUseNewConfig;

    @SerializedName("refactor_empty")
    private final boolean refactorEmpty;

    @SerializedName("show_mill_ms")
    private final int showMillMs;

    @SerializedName("style_type")
    private final int styleType;

    @SerializedName("use_new_config")
    private final boolean useNewConfig;

    public static final class a {
    }

    static {
    }

    public h31() {
        this.styleType = -1;
        this.showMillMs = 10000;
        this.followingEntrances = CollectionsKt.emptyList();
        this.jumpFactor = 0.24f;
        this.entranceItemConfig = MapsKt.emptyMap();
        this.feedBackBugFix = true;
        this.enterSourceFix = true;
    }

    public final List<String> a() {
        return this.enterEntrancesComponent;
    }

    public final boolean b() {
        return this.enterSourceFix;
    }

    public final Map<String, r4> c() {
        return this.entranceItemConfig;
    }

    public final boolean d() {
        return this.feedBackBugFix;
    }

    public final List<String> e() {
        return this.followingEntrances;
    }

    public final float f() {
        return this.jumpFactor;
    }

    public final boolean g() {
        return this.livetabUseNewConfig;
    }

    public final int h() {
        return this.styleType;
    }

    public final boolean i() {
        return this.useNewConfig;
    }
}
