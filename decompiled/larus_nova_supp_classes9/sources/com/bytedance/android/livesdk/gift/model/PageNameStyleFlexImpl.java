package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.PageNameStyle")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR;\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR;\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR/\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00168V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PageNameStyleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/a3;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/x;", "<set-?>", "fontStyle$delegate", "Ljava/lang/Object;", "getFontStyle", "()Ljava/util/List;", "setFontStyle", "(Ljava/util/List;)V", "fontStyle", BuildConfig.FLAVOR, "direction$delegate", "getDirection", "setDirection", "direction", "position$delegate", "getPosition", "setPosition", "position", "Lpy/k;", "image$delegate", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PageNameStyleFlexImpl extends FlexModelBase<a3> implements a3, vh7.h {

    @SerializedName("direction")
    protected List<Double> _$$direction;

    @SerializedName("font_style")
    protected List<? extends x> _$$fontStyle;

    @SerializedName("image")
    protected py.k _$$image;

    @SerializedName("position")
    protected List<Double> _$$position;

    public PageNameStyleFlexImpl() {
        super(a3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final List<Double> getDirection() {
        return this._$$direction;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final List<x> getFontStyle() {
        return this._$$fontStyle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final py.k getImage() {
        return this._$$image;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final List<Double> getPosition() {
        return this._$$position;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public PageNameStyleFlexImpl(am3.g r6) {
        super(a3.class);
        this._$$fontStyle = new ArrayList();
        this._$$direction = new ArrayList();
        this._$$position = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L20;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L12;
        List<? extends x> r4 = this._$$position;
    L17:
        Object r5 = Double.valueOf(Double.longBitsToDouble(r6.h()));
    L19:
        r4.add(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$image = vh7.f.a(r6, py.k.class);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L16:
        r4 = this._$$direction;
        goto L17
    L18:
        r4 = this._$$fontStyle;
        r5 = vh7.f.a(r6, x.class);
        goto L19
    L20:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final void setDirection(List<Double> r1) {
        this._$$direction = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final void setFontStyle(List<? extends x> r1) {
        this._$$fontStyle = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final void setImage(py.k r1) {
        this._$$image = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a3
    public final void setPosition(List<Double> r1) {
        this._$$position = r1;
    }
}
