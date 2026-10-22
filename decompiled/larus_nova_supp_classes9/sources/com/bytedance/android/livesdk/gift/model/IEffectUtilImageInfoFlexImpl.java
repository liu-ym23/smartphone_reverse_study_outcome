package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.EffectUtilImageInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IEffectUtilImageInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/f1;", "Lpy/k;", "mixImage", "Lpy/k;", "getMixImage", "()Lpy/k;", "setMixImage", "(Lpy/k;)V", BuildConfig.FLAVOR, "placeholderKey$delegate", "Ljava/lang/Object;", "getPlaceholderKey", "()Ljava/lang/String;", "placeholderKey", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEffectUtilImageInfoFlexImpl extends FlexModelBase<f1> implements f1, vh7.h {

    @SerializedName("placeholder_key")
    protected String _$$placeholderKey;

    @SerializedName("mix_image")
    protected py.k mixImage;

    public IEffectUtilImageInfoFlexImpl() {
        super(f1.class);
        this._$$placeholderKey = BuildConfig.FLAVOR;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IEffectUtilImageInfoFlexImpl(am3.g r6) {
        super(f1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$placeholderKey = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.mixImage = vh7.f.a(r6, py.k.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$placeholderKey != null) goto L25;
        this._$$placeholderKey = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.f1
    public py.k getMixImage() {
        return this.mixImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.f1
    public final String getPlaceholderKey() {
        return this._$$placeholderKey;
    }

    public void setMixImage(py.k r1) {
        this.mixImage = r1;
    }
}
