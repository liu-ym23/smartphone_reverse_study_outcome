package db2;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Ldb2/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "a1", "F", "a", "()F", "setA1", "(F)V", "a2", "b", "setA2", "b1", "c", "setB1", "b2", "d", "setB2", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("a1")
    private float a1;

    @SerializedName("a2")
    private float a2;

    @SerializedName("b1")
    private float b1;

    @SerializedName("b2")
    private float b2;

    public b() {
        this.a1 = 1.0f;
        this.a2 = 1.0f;
        this.b1 = 1.0f;
        this.b2 = 1.0f;
    }

    public final float a() {
        return this.a1;
    }

    public final float b() {
        return this.a2;
    }

    public final float c() {
        return this.b1;
    }

    public final float d() {
        return this.b2;
    }
}
