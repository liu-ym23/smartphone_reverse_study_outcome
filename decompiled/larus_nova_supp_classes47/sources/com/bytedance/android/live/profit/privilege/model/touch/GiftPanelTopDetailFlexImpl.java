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
@ProtoMessage("webcast.data.GiftPanelTopDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b1\u00102R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R;\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R/\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR/\u00100\u001a\u0004\u0018\u00010*2\b\u0010\u0004\u001a\u0004\u0018\u00010*8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTopDetailFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "Lpy/k;", "<set-?>", "icon$delegate", "Ljava/lang/Object;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "icon", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "mainText$delegate", "getMainText", "()Ljava/util/List;", "setMainText", "(Ljava/util/List;)V", "mainText", "deputyText$delegate", "getDeputyText", "setDeputyText", "deputyText", "Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "progressBar$delegate", "getProgressBar", "()Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "setProgressBar", "(Lcom/bytedance/android/live/profit/privilege/model/touch/k;)V", "progressBar", "Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "button$delegate", "getButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "setButton", "(Lcom/bytedance/android/live/profit/privilege/model/touch/o;)V", "button", "bgImg$delegate", "getBgImg", "setBgImg", "bgImg", "", "mainTextBgAttr$delegate", "getMainTextBgAttr", "()Ljava/lang/String;", "setMainTextBgAttr", "(Ljava/lang/String;)V", "mainTextBgAttr", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelTopDetailFlexImpl extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("bg_img")
    protected py.k _$$bgImg;

    @SerializedName("button")
    protected o _$$button;

    @SerializedName("deputy_text")
    protected List<? extends n> _$$deputyText;

    @SerializedName("icon")
    protected py.k _$$icon;

    @SerializedName("main_text")
    protected List<? extends n> _$$mainText;

    @SerializedName("main_text_bg_attr")
    protected String _$$mainTextBgAttr;

    @SerializedName("progress_bar")
    protected k _$$progressBar;

    public GiftPanelTopDetailFlexImpl() {
        super(f.class);
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.profit.privilege.model.touch.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.profit.privilege.model.touch.o, java.lang.Object] */
    public GiftPanelTopDetailFlexImpl(am3.g r5) {
        super(f.class);
        this._$$mainText = new ArrayList();
        this._$$deputyText = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$mainTextBgAttr = am3.h.c(r5);
        goto L3
    L9:
        this._$$bgImg = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this._$$button = vh7.f.a(r5, o.class);
        goto L3
    L11:
        this._$$progressBar = vh7.f.a(r5, k.class);
        goto L3
    L12:
        List<? extends n> r4 = this._$$deputyText;
    L14:
        r4.add(vh7.f.a(r5, n.class));
        goto L3
    L13:
        r4 = this._$$mainText;
        goto L14
    L15:
        this._$$icon = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final py.k getBgImg() {
        return this._$$bgImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final o getButton() {
        return this._$$button;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final List<n> getDeputyText() {
        return this._$$deputyText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final py.k getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final List<n> getMainText() {
        return this._$$mainText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final String getMainTextBgAttr() {
        return this._$$mainTextBgAttr;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final k getProgressBar() {
        return this._$$progressBar;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setBgImg(py.k r1) {
        this._$$bgImg = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setButton(o r1) {
        this._$$button = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setDeputyText(List<? extends n> r1) {
        this._$$deputyText = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setIcon(py.k r1) {
        this._$$icon = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setMainText(List<? extends n> r1) {
        this._$$mainText = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setMainTextBgAttr(String r1) {
        this._$$mainTextBgAttr = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.f
    public final void setProgressBar(k r1) {
        this._$$progressBar = r1;
    }
}
