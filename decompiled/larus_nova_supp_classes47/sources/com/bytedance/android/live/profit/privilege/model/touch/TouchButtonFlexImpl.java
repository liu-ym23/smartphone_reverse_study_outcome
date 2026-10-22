package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.TouchButton")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchButtonFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "<set-?>", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "text", "Lpy/k;", "bgImg$delegate", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "bgImg", "", "jumpUrl$delegate", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "jumpUrl", "", "buttonType$delegate", "getButtonType", "()Ljava/lang/Long;", "setButtonType", "(Ljava/lang/Long;)V", "buttonType", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchButtonFlexImpl extends FlexModelBase<o> implements o, vh7.h {

    @SerializedName("bg_img")
    protected py.k _$$bgImg;

    @SerializedName("button_type")
    protected Long _$$buttonType;

    @SerializedName("jump_url")
    protected String _$$jumpUrl;

    @SerializedName("text")
    protected List<? extends n> _$$text;

    public TouchButtonFlexImpl() {
        super(o.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final py.k getBgImg() {
        return this._$$bgImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final Long getButtonType() {
        return this._$$buttonType;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final String getJumpUrl() {
        return this._$$jumpUrl;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final List<n> getText() {
        return this._$$text;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public TouchButtonFlexImpl(am3.g r6) {
        super(o.class);
        this._$$text = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$text.add(vh7.f.a(r6, n.class));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$bgImg = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$jumpUrl = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$buttonType = Long.valueOf(r6.j());
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final void setBgImg(py.k r1) {
        this._$$bgImg = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final void setButtonType(Long r1) {
        this._$$buttonType = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final void setJumpUrl(String r1) {
        this._$$jumpUrl = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.o
    public final void setText(List<? extends n> r1) {
        this._$$text = r1;
    }
}
