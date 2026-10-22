package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001b\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IndustryCertificationProfile;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/y;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "contentColor", "getContentColor", "setContentColor", "bgColor", "getBgColor", "setBgColor", "", "certType", "I", "getCertType", "()I", "setCertType", "(I)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndustryCertificationProfile extends FlexModelBase<y> implements y, vh7.h {

    @SerializedName("bg_color")
    protected String bgColor;

    @SerializedName("cert_type")
    protected int certType;

    @SerializedName("content")
    protected String content;

    @SerializedName("content_color")
    protected String contentColor;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("schema")
    protected String schema;

    public IndustryCertificationProfile() {
        super(y.class);
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public int getCertType() {
        return this.certType;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public String getContentColor() {
        return this.contentColor;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public String getSchema() {
        return this.schema;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IndustryCertificationProfile(am3.g r5) {
        super(y.class);
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
        this.certType = (int) r5.j();
        goto L3
    L9:
        this.bgColor = am3.h.c(r5);
        goto L3
    L10:
        this.contentColor = am3.h.c(r5);
        goto L3
    L11:
        this.schema = am3.h.c(r5);
        goto L3
    L12:
        this.content = am3.h.c(r5);
        goto L3
    L13:
        this.icon = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setBgColor(String r1) {
        this.bgColor = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setCertType(int r1) {
        this.certType = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setContent(String r1) {
        this.content = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setContentColor(String r1) {
        this.contentColor = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.y
    public void setSchema(String r1) {
        this.schema = r1;
    }
}
