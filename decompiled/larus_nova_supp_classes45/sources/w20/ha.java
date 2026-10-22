package w20;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lw20/ha;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "durationLimit", "Ljava/lang/Integer;", "getDurationLimit", "()Ljava/lang/Integer;", "setDurationLimit", "(Ljava/lang/Integer;)V", "Lw20/ha$a;", "params", "Lw20/ha$a;", "c", "()Lw20/ha$a;", "setParams", "(Lw20/ha$a;)V", "commonRecordTips", "a", "setCommonRecordTips", "recordType", "d", "setRecordType", "customRecordTips", "b", "setCustomRecordTips", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ha {

    @SerializedName("commonRecordTips")
    private String commonRecordTips;

    @SerializedName("customRecordTips")
    private String customRecordTips;

    @SerializedName("durationLimit")
    private Integer durationLimit;

    @SerializedName("params")
    private a params;

    @SerializedName("recordType")
    private String recordType;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String url;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lw20/ha$a;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "encrypt", "Ljava/lang/Integer;", "getEncrypt", "()Ljava/lang/Integer;", "setEncrypt", "(Ljava/lang/Integer;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("encrypt")
        private Integer encrypt;

        @SerializedName("scene")
        private String scene;

        public a() {
        }
    }

    public ha() {
    }

    public final String a() {
        return this.commonRecordTips;
    }

    public final String b() {
        return this.customRecordTips;
    }

    public final a c() {
        return this.params;
    }

    public final String d() {
        return this.recordType;
    }

    public final String e() {
        return this.url;
    }
}
