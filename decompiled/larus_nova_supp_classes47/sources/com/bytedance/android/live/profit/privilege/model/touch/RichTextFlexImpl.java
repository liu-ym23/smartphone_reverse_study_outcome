package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.RichText")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R/\u0010(\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001f¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/RichTextFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "", "<set-?>", "richTextType$delegate", "Ljava/lang/Object;", "getRichTextType", "()I", "setRichTextType", "(I)V", "richTextType", "", "text$delegate", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "Lpy/k;", "img$delegate", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "img", "", "fontSize$delegate", "getFontSize", "()Ljava/lang/Long;", "setFontSize", "(Ljava/lang/Long;)V", "fontSize", "fontColor$delegate", "getFontColor", "setFontColor", "fontColor", "weight$delegate", "getWeight", "setWeight", "weight", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RichTextFlexImpl extends FlexModelBase<n> implements n, vh7.h {

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("font_size")
    protected Long _$$fontSize;

    @SerializedName("img")
    protected py.k _$$img;

    @SerializedName("type")
    protected int _$$richTextType;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("weight")
    protected Long _$$weight;

    public RichTextFlexImpl() {
        super(n.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final Long getFontSize() {
        return this._$$fontSize;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final py.k getImg() {
        return this._$$img;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final int getRichTextType() {
        return this._$$richTextType;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final Long getWeight() {
        return this._$$weight;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public RichTextFlexImpl(am3.g r5) {
        super(n.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$weight = Long.valueOf(r5.j());
        goto L3
    L9:
        this._$$fontColor = am3.h.c(r5);
        goto L3
    L10:
        this._$$fontSize = Long.valueOf(r5.j());
        goto L3
    L11:
        this._$$img = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this._$$text = am3.h.c(r5);
        goto L3
    L13:
        this._$$richTextType = r5.i();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setFontColor(String r1) {
        this._$$fontColor = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setFontSize(Long r1) {
        this._$$fontSize = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setImg(py.k r1) {
        this._$$img = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setRichTextType(int r1) {
        this._$$richTextType = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setText(String r1) {
        this._$$text = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.n
    public final void setWeight(Long r1) {
        this._$$weight = r1;
    }
}
