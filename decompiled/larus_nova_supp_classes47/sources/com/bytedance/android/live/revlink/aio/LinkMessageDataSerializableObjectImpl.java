package com.bytedance.android.live.revlink.aio;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import k11.j;
import k11.o;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/LinkMessageDataSerializableObjectImpl;", "Lk11/j;", "Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "message", "Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "getMessage", "()Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "B3", "(Lcom/bytedance/android/livesdk/link/model/bridge/h1;)V", "Lk11/o;", "sideEffect", "Lk11/o;", "getSideEffect", "()Lk11/o;", "a", "(Lk11/o;)V", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMessageDataSerializableObjectImpl implements j {

    @SerializedName("message")
    private h1 message;

    @SerializedName("state_transition")
    private o sideEffect;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/LinkMessageDataSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkMessageDataSerializableObjectImpl.class);
        }
    }

    public LinkMessageDataSerializableObjectImpl() {
    }

    @Override // k11.j
    public final void B3(i6 r1) {
        this.message = r1;
    }

    @Override // k11.j
    public final void a(o r1) {
        this.sideEffect = r1;
    }
}
