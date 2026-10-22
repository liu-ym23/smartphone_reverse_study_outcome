package nh0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lnh0/g;", "", "", "", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel;", "configMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("config_map")
    private final Map<String, LayoutConfigModel> configMap;

    public g() {
        this.configMap = new LinkedHashMap();
    }

    public final Map<String, LayoutConfigModel> a() {
        return this.configMap;
    }
}
