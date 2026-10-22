package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.BottomLabel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftBottomLabelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/k1;", "Lpy/k;", "<set-?>", "label$delegate", "Ljava/lang/Object;", "getLabel", "()Lpy/k;", "setLabel", "(Lpy/k;)V", "label", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftBottomLabelFlexImpl extends FlexModelBase<k1> implements k1, vh7.h {

    @SerializedName("label")
    protected py.k _$$label;

    public IGiftBottomLabelFlexImpl() {
        super(k1.class);
        this._$$label = $defaultValue_label$();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IGiftBottomLabelFlexImpl(am3.g r6) {
        super(k1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$label = vh7.f.a(r6, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$label != null) goto L19;
        this._$$label = $defaultValue_label$();
        return;
    }

    public final py.k $defaultValue_label$() {
        return (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.k1
    public final py.k getLabel() {
        return this._$$label;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k1
    public final void setLabel(py.k r1) {
        this._$$label = r1;
    }
}
