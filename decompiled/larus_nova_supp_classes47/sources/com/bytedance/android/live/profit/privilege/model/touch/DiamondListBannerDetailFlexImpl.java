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
@ProtoMessage("webcast.data.DiamondListBannerDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R;\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR/\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R;\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000b¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/DiamondListBannerDetailFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "<set-?>", "mainText$delegate", "Ljava/lang/Object;", "getMainText", "()Ljava/util/List;", "setMainText", "(Ljava/util/List;)V", "mainText", "Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "mainTextButton$delegate", "getMainTextButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "setMainTextButton", "(Lcom/bytedance/android/live/profit/privilege/model/touch/o;)V", "mainTextButton", "deputyText$delegate", "getDeputyText", "setDeputyText", "deputyText", "Lpy/k;", "bgImg$delegate", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "bgImg", "Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "progressBar$delegate", "getProgressBar", "()Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "setProgressBar", "(Lcom/bytedance/android/live/profit/privilege/model/touch/k;)V", "progressBar", "upperRightText$delegate", "getUpperRightText", "setUpperRightText", "upperRightText", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondListBannerDetailFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("bg_img")
    protected py.k _$$bgImg;

    @SerializedName("deputy_text")
    protected List<? extends n> _$$deputyText;

    @SerializedName("main_text")
    protected List<? extends n> _$$mainText;

    @SerializedName("main_text_button")
    protected o _$$mainTextButton;

    @SerializedName("progress_bar")
    protected k _$$progressBar;

    @SerializedName("upper_right_text")
    protected List<? extends n> _$$upperRightText;

    public DiamondListBannerDetailFlexImpl() {
        super(a.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.profit.privilege.model.touch.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.profit.privilege.model.touch.k, java.lang.Object] */
    public DiamondListBannerDetailFlexImpl(am3.g r5) {
        super(a.class);
        this._$$mainText = new ArrayList();
        this._$$deputyText = new ArrayList();
        this._$$upperRightText = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
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
        List<? extends n> r4 = this._$$upperRightText;
    L14:
        r4.add(vh7.f.a(r5, n.class));
        goto L3
    L9:
        this._$$progressBar = vh7.f.a(r5, k.class);
        goto L3
    L10:
        this._$$bgImg = vh7.f.a(r5, py.k.class);
        goto L3
    L11:
        r4 = this._$$deputyText;
        goto L14
    L12:
        this._$$mainTextButton = vh7.f.a(r5, o.class);
        goto L3
    L13:
        r4 = this._$$mainText;
        goto L14
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final py.k getBgImg() {
        return this._$$bgImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final List<n> getDeputyText() {
        return this._$$deputyText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final List<n> getMainText() {
        return this._$$mainText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final o getMainTextButton() {
        return this._$$mainTextButton;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final k getProgressBar() {
        return this._$$progressBar;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final List<n> getUpperRightText() {
        return this._$$upperRightText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setBgImg(py.k r1) {
        this._$$bgImg = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setDeputyText(List<? extends n> r1) {
        this._$$deputyText = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setMainText(List<? extends n> r1) {
        this._$$mainText = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setMainTextButton(o r1) {
        this._$$mainTextButton = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setProgressBar(k r1) {
        this._$$progressBar = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.a
    public final void setUpperRightText(List<? extends n> r1) {
        this._$$upperRightText = r1;
    }
}
