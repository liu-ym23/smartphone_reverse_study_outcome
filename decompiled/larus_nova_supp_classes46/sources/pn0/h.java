package pn0;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR:\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bRb\u0010\t\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lpn0/h;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "featureMap", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "filenameMap", "b", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h {

    @SerializedName("feature_map")
    private final HashMap<String, String> featureMap;

    @SerializedName("filename_map")
    private final HashMap<String, HashMap<String, String>> filenameMap;

    public h() {
    }

    public final HashMap<String, String> a() {
        return this.featureMap;
    }

    public final HashMap<String, HashMap<String, String>> b() {
        return this.filenameMap;
    }
}
