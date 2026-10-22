package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.PageInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R'\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"R\u001d\u0010(\u001a\u0004\u0018\u00010$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PageInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/x2;", "Lpy/k;", "titleImg", "Lpy/k;", "getTitleImg", "()Lpy/k;", "setTitleImg", "(Lpy/k;)V", "backgroundImg", "getBackgroundImg", "setBackgroundImg", "iconImage", "getIconImage", "setIconImage", BuildConfig.FLAVOR, "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "text$delegate", "getText", "text", "buttonText$delegate", "getButtonText", "buttonText", "schemeUrl$delegate", "getSchemeUrl", "schemeUrl", BuildConfig.FLAVOR, "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "Lcom/bytedance/android/livesdk/gift/model/PageInfoBarFlexImpl;", "pageProgressBar$delegate", "getPageProgressBar", "()Lcom/bytedance/android/livesdk/gift/model/PageInfoBarFlexImpl;", "pageProgressBar", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PageInfoFlexImpl extends FlexModelBase<x2> implements x2, vh7.h {

    @SerializedName("button_text")
    protected String _$$buttonText;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("bar")
    protected PageInfoBarFlexImpl _$$pageProgressBar;

    @SerializedName("scheme_url")
    protected String _$$schemeUrl;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("background_img")
    protected py.k backgroundImg;

    @SerializedName("icon_img")
    protected py.k iconImage;

    @SerializedName("title_img")
    protected py.k titleImg;

    public PageInfoFlexImpl() {
        super(x2.class);
        this._$$text = BuildConfig.FLAVOR;
        this._$$extra = $defaultValue_extra$();
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public PageInfoFlexImpl(am3.g r11) {
        super(x2.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L34;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 100) goto L7;
        long r6 = r11.c();
        String r3 = null;
        String r7 = null;
    L18:
        int r8 = r11.f();
        if (r8 == (-1)) goto L26;
        if (r8 != 1) goto L22;
        r3 = am3.h.c(r11);
        goto L18
    L22:
        if (r8 != 2) goto L23;
        r7 = am3.h.c(r11);
        goto L18
    L23:
        am3.h.e(r11);
        goto L18
    L26:
        r11.d(r6);
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L33;
        if (r7 == null) goto L31;
        r4.put(r3, r7);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this._$$pageProgressBar = new PageInfoBarFlexImpl(r11);
        goto L3
    L10:
        this.iconImage = vh7.f.a(r11, py.k.class);
        goto L3
    L11:
        this.backgroundImg = vh7.f.a(r11, py.k.class);
        goto L3
    L12:
        this.titleImg = vh7.f.a(r11, py.k.class);
        goto L3
    L13:
        this._$$schemeUrl = am3.h.c(r11);
        goto L3
    L14:
        this._$$buttonText = am3.h.c(r11);
        goto L3
    L15:
        this._$$text = am3.h.c(r11);
        goto L3
    L16:
        this._$$title = am3.h.c(r11);
        goto L3
    L8:
        am3.h.d(r5, r11);
        goto L3
    L34:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L38;
        this._$$text = BuildConfig.FLAVOR;
    L38:
        if (this._$$extra != null) goto L75;
        this._$$extra = $defaultValue_extra$();
        return;
    }

    public final Map<String, String> $defaultValue_extra$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public /* bridge */ /* synthetic */ y2 getPageProgressBar() {
        return getPageProgressBar();
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public py.k getBackgroundImg() {
        return this.backgroundImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final String getButtonText() {
        return this._$$buttonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public py.k getIconImage() {
        return this.iconImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final String getSchemeUrl() {
        return this._$$schemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public py.k getTitleImg() {
        return this.titleImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x2
    public final PageInfoBarFlexImpl getPageProgressBar() {
        return this._$$pageProgressBar;
    }

    public void setBackgroundImg(py.k r1) {
        this.backgroundImg = r1;
    }

    public void setIconImage(py.k r1) {
        this.iconImage = r1;
    }

    public void setTitleImg(py.k r1) {
        this.titleImg = r1;
    }
}
