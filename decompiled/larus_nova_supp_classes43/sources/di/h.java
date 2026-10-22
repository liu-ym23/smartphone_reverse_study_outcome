package di;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Ldi/h;", "", "", "createStreamFinish", "Ljava/lang/Double;", "a", "()Ljava/lang/Double;", "setCreateStreamFinish", "(Ljava/lang/Double;)V", "createStreamStart", "b", "setCreateStreamStart", "", "httpTransactionStart", "Ljava/lang/Float;", "getHttpTransactionStart", "()Ljava/lang/Float;", "setHttpTransactionStart", "(Ljava/lang/Float;)V", "requestSentTime", "d", "setRequestSentTime", "responseRecvTime", "e", "setResponseRecvTime", "startTime", "f", "setStartTime", "waitCtx", "getWaitCtx", "setWaitCtx", "", com.bytedance.android.ec.core.event.a.KEY_DURATION, "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("create_stream_finish")
    private Double createStreamFinish;

    @SerializedName("create_stream_start")
    private Double createStreamStart;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DURATION)
    private Long duration;

    @SerializedName("http_transaction_start")
    private Float httpTransactionStart;

    @SerializedName("request_sent_time")
    private Double requestSentTime;

    @SerializedName("response_recv_time")
    private Double responseRecvTime;

    @SerializedName("start_time")
    private Double startTime;

    @SerializedName("wait_ctx")
    private Float waitCtx;

    public h() {
    }

    public final Double a() {
        return this.createStreamFinish;
    }

    public final Double b() {
        return this.createStreamStart;
    }

    public final Long c() {
        return this.duration;
    }

    public final Double d() {
        return this.requestSentTime;
    }

    public final Double e() {
        return this.responseRecvTime;
    }

    public final Double f() {
        return this.startTime;
    }
}
