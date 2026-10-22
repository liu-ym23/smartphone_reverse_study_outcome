package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.ShowStatusLabel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ShowStatusLabelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/p3;", BuildConfig.FLAVOR, "<set-?>", "showStatusLabelText$delegate", "Ljava/lang/Object;", "getShowStatusLabelText", "()Ljava/lang/String;", "setShowStatusLabelText", "(Ljava/lang/String;)V", "showStatusLabelText", BuildConfig.FLAVOR, "showStatusLabelTextAlpha$delegate", "getShowStatusLabelTextAlpha", "()F", "setShowStatusLabelTextAlpha", "(F)V", "showStatusLabelTextAlpha", "showStatusLabelBgColor$delegate", "getShowStatusLabelBgColor", "setShowStatusLabelBgColor", "showStatusLabelBgColor", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ShowStatusLabelFlexImpl extends FlexModelBase<p3> implements p3, vh7.h {

    @SerializedName("show_status_label_bg_color")
    protected String _$$showStatusLabelBgColor;

    @SerializedName("show_status_label_text")
    protected String _$$showStatusLabelText;

    @SerializedName("show_status_label_text_transparency")
    protected float _$$showStatusLabelTextAlpha;

    public ShowStatusLabelFlexImpl() {
        super(p3.class);
        this._$$showStatusLabelText = BuildConfig.FLAVOR;
        this._$$showStatusLabelBgColor = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final String getShowStatusLabelBgColor() {
        return this._$$showStatusLabelBgColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final String getShowStatusLabelText() {
        return this._$$showStatusLabelText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final float getShowStatusLabelTextAlpha() {
        return this._$$showStatusLabelTextAlpha;
    }

    public ShowStatusLabelFlexImpl(am3.g r6) {
        super(p3.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$showStatusLabelText = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$showStatusLabelTextAlpha = Float.intBitsToFloat(r6.g());
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$showStatusLabelBgColor = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$showStatusLabelText != null) goto L19;
        this._$$showStatusLabelText = BuildConfig.FLAVOR;
    L19:
        if (this._$$showStatusLabelBgColor != null) goto L34;
        this._$$showStatusLabelBgColor = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final void setShowStatusLabelBgColor(String r1) {
        this._$$showStatusLabelBgColor = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final void setShowStatusLabelText(String r1) {
        this._$$showStatusLabelText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p3
    public final void setShowStatusLabelTextAlpha(float r1) {
        this._$$showStatusLabelTextAlpha = r1;
    }
}
