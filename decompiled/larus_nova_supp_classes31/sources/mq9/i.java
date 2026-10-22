package mq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/avatar/RecordInfoConfigV2;", "", "werCheckTitle", "", "numReadTitle", "wordReadTitle", "werCheckTimeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getWerCheckTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "werCheckTitleKey", "numReadTitleKey", "wordReadTitleKey", "getWerCheckTitle", "()Ljava/lang/String;", "getNumReadTitle", "getWordReadTitle", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class i {

    @SerializedName("num_read_title")
    private final String numReadTitleKey;

    @SerializedName("wer_check_timeout")
    private final Integer werCheckTimeout;

    @SerializedName("wer_check_title")
    private final String werCheckTitleKey;

    @SerializedName("word_read_title")
    private final String wordReadTitleKey;

    public i() {
        this(null, null, null, 5);
    }

    public final String a() {
        return e.a(this.numReadTitleKey);
    }

    public final String c() {
        return e.a(this.werCheckTitleKey);
    }

    public final String d() {
        return e.a(this.wordReadTitleKey);
    }

    public final Integer b() {
        return this.werCheckTimeout;
    }

    public i(String r1, String r2, String r3, Integer r4) {
        this.werCheckTimeout = r4;
        this.werCheckTitleKey = r1;
        this.numReadTitleKey = r2;
        this.wordReadTitleKey = r3;
    }
}
