package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.LightInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/LightInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/h;", "", "<set-?>", "isOn$delegate", "Ljava/lang/Object;", "isOn", "()Z", "setOn", "(Z)V", "Lpy/k;", "image$delegate", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LightInfoFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("image")
    protected py.k _$$image;

    @SerializedName("is_on")
    protected boolean _$$isOn;

    public LightInfoFlexImpl() {
        super(h.class);
        this._$$isOn = false;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, py.k] */
    public LightInfoFlexImpl(am3.g r8) {
        super(h.class);
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L12;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$isOn = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L8:
        if (r4 != 2) goto L9;
        this._$$image = vh7.f.a(r8, py.k.class);
        goto L3
    L9:
        am3.h.d(r5, r8);
        goto L3
    L12:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L25;
        this._$$isOn = false;
        return;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.h
    public final py.k getImage() {
        return this._$$image;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.h
    public final boolean isOn() {
        return this._$$isOn;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.h
    public final void setImage(py.k r1) {
        this._$$image = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.h
    public final void setOn(boolean r1) {
        this._$$isOn = r1;
    }
}
