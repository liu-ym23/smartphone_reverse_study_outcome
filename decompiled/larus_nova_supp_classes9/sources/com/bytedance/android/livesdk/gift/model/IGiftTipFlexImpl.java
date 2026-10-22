package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftTip")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftTipFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/c2;", "Lcom/bytedance/android/live/base/model/message/a5;", "<set-?>", "displayText$delegate", "Ljava/lang/Object;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "displayText", BuildConfig.FLAVOR, "backgroundColor$delegate", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundColor", "Lpy/k;", "prefixImage$delegate", "getPrefixImage", "()Lpy/k;", "setPrefixImage", "(Lpy/k;)V", "prefixImage", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftTipFlexImpl extends FlexModelBase<c2> implements c2, vh7.h {

    @SerializedName("background_color")
    protected String _$$backgroundColor;

    @SerializedName("display_text")
    protected a5 _$$displayText;

    @SerializedName("prefix_image")
    protected py.k _$$prefixImage;

    public IGiftTipFlexImpl() {
        super(c2.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IGiftTipFlexImpl(am3.g r6) {
        super(c2.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$displayText = vh7.f.a(r6, a5.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$backgroundColor = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$prefixImage = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final String getBackgroundColor() {
        return this._$$backgroundColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final a5 getDisplayText() {
        return this._$$displayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final py.k getPrefixImage() {
        return this._$$prefixImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final void setBackgroundColor(String r1) {
        this._$$backgroundColor = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final void setDisplayText(a5 r1) {
        this._$$displayText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.c2
    public final void setPrefixImage(py.k r1) {
        this._$$prefixImage = r1;
    }
}
