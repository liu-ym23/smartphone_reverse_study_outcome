package com.bytedance.android.live.revlink.aio;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import d11.i;
import java.util.Map;
import k11.b;
import k11.o;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/CancelParamsAndResultDataSerializableObjectImpl;", "Lk11/b;", "Ld11/i;", "serverParams", "Ld11/i;", "getServerParams", "()Ld11/i;", "N3", "(Ld11/i;)V", "", "", "clientParams", "Ljava/util/Map;", "getClientParams", "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "Lk11/o;", "sideEffect", "Lk11/o;", "getSideEffect", "()Lk11/o;", "a", "(Lk11/o;)V", "", "startTs", "J", "getStartTs", "()J", "d", "(J)V", Constants.OperatorKey.CODE, "getCode", "b", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CancelParamsAndResultDataSerializableObjectImpl implements b {

    @SerializedName("client_params")
    private Map<String, String> clientParams;

    @SerializedName("error_code")
    private long code;

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("request_params")
    private i serverParams;

    @SerializedName("state_transition")
    private o sideEffect;

    @SerializedName("start_ts")
    private long startTs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/CancelParamsAndResultDataSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CancelParamsAndResultDataSerializableObjectImpl.class);
        }
    }

    public CancelParamsAndResultDataSerializableObjectImpl() {
    }

    @Override // k11.b
    public final void N3(i r1) {
        this.serverParams = r1;
    }

    @Override // k11.b
    public final void a(o r1) {
        this.sideEffect = r1;
    }

    @Override // k11.b
    public final void b(long r1) {
        this.code = r1;
    }

    @Override // k11.b
    public final void d(long r1) {
        this.startTs = r1;
    }

    @Override // k11.b
    public final void e(Map<String, String> r1) {
        this.clientParams = r1;
    }

    @Override // k11.b
    public final void setErrorMessage(String r1) {
        this.errorMessage = r1;
    }
}
