package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lw20/hf;", "", "", "source", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "", "is_task", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "set_task", "(Ljava/lang/Boolean;)V", "activity_name", "a", "setActivity_name", "", "apply_type", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setApply_type", "(Ljava/lang/Integer;)V", "apply_source", "b", "setApply_source", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hf {

    @SerializedName("activity_name")
    private String activity_name;

    @SerializedName("apply_source")
    private String apply_source;

    @SerializedName("apply_type")
    private Integer apply_type;

    @SerializedName("is_task")
    private Boolean is_task;

    @SerializedName("source")
    private String source;

    public hf() {
    }

    public final String a() {
        return this.activity_name;
    }

    public final String b() {
        return this.apply_source;
    }

    public final Integer c() {
        return this.apply_type;
    }

    public final String d() {
        return this.source;
    }
}
