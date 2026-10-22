package ju1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lju1/a;", "Lju1/h;", "", LiveEndPageData.TAG_NAME, "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "defaultValue", "I", "g", "()I", "setDefaultValue", "(I)V", "", "relativeFactors", "Ljava/util/List;", "i", "()Ljava/util/List;", "setRelativeFactors", "(Ljava/util/List;)V", "relativeScenes", "getRelativeScenes", "setRelativeScenes", "", "singleUse", "Z", "getSingleUse", "()Z", "setSingleUse", "(Z)V", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class a implements h {

    @SerializedName("default_value")
    private int defaultValue;

    @SerializedName(LiveEndPageData.TAG_NAME)
    private String name;

    @SerializedName("relative_factors")
    private List<String> relativeFactors;

    @SerializedName("relative_scenes")
    private List<String> relativeScenes;

    @SerializedName("single_use")
    private boolean singleUse;

    @Override // ju1.h
    public final Object a() {
        return Integer.valueOf(this.defaultValue);
    }

    @Override // ju1.h
    public final boolean f() {
        return !this.singleUse;
    }

    public a() {
        this.name = "";
        this.relativeFactors = new ArrayList();
        this.relativeScenes = new ArrayList();
    }

    @Override // ju1.h
    public final String b() {
        return this.name;
    }

    @Override // ju1.h
    public final List<String> c() {
        return this.relativeScenes;
    }

    @Override // ju1.h
    public final List<String> e() {
        return this.relativeFactors;
    }

    public final int g() {
        return this.defaultValue;
    }

    public final String h() {
        return this.name;
    }

    public final List<String> i() {
        return this.relativeFactors;
    }
}
