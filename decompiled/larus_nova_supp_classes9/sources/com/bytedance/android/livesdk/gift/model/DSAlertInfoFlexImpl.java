package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.DSAlertInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0014\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001a\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\u001d\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010 \u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010%\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/DSAlertInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/r;", BuildConfig.FLAVOR, "icon$delegate", "Ljava/lang/Object;", "getIcon", "()Ljava/lang/String;", "icon", "slogan$delegate", "getSlogan", "slogan", "background$delegate", "getBackground", "background", "title$delegate", "getTitle", "title", "leftButtonText$delegate", "getLeftButtonText", "leftButtonText", "rightButtonText$delegate", "getRightButtonText", "rightButtonText", "schemaUrl$delegate", "getSchemaUrl", "schemaUrl", "limitScene$delegate", "getLimitScene", "limitScene", "text$delegate", "getText", "text", BuildConfig.FLAVOR, "errorCode$delegate", "getErrorCode", "()I", "errorCode", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DSAlertInfoFlexImpl extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName("background")
    protected String _$$background;

    @SerializedName("err_code")
    protected int _$$errorCode;

    @SerializedName("icon")
    protected String _$$icon;

    @SerializedName("left_button_text")
    protected String _$$leftButtonText;

    @SerializedName("limit_scene")
    protected String _$$limitScene;

    @SerializedName("right_button_text")
    protected String _$$rightButtonText;

    @SerializedName("schema_url")
    protected String _$$schemaUrl;

    @SerializedName("slogan")
    protected String _$$slogan;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("title")
    protected String _$$title;

    public DSAlertInfoFlexImpl() {
        super(r.class);
        this._$$icon = BuildConfig.FLAVOR;
        this._$$slogan = BuildConfig.FLAVOR;
        this._$$background = BuildConfig.FLAVOR;
        this._$$title = BuildConfig.FLAVOR;
        this._$$leftButtonText = BuildConfig.FLAVOR;
        this._$$rightButtonText = BuildConfig.FLAVOR;
        this._$$schemaUrl = BuildConfig.FLAVOR;
        this._$$limitScene = BuildConfig.FLAVOR;
        this._$$text = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getBackground() {
        return this._$$background;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final int getErrorCode() {
        return this._$$errorCode;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getLeftButtonText() {
        return this._$$leftButtonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getLimitScene() {
        return this._$$limitScene;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getRightButtonText() {
        return this._$$rightButtonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getSchemaUrl() {
        return this._$$schemaUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getSlogan() {
        return this._$$slogan;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.r
    public final String getTitle() {
        return this._$$title;
    }

    public DSAlertInfoFlexImpl(am3.g r5) {
        super(r.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$errorCode = r5.i();
        goto L3
    L9:
        this._$$limitScene = am3.h.c(r5);
        goto L3
    L10:
        this._$$schemaUrl = am3.h.c(r5);
        goto L3
    L11:
        this._$$rightButtonText = am3.h.c(r5);
        goto L3
    L12:
        this._$$leftButtonText = am3.h.c(r5);
        goto L3
    L13:
        this._$$text = am3.h.c(r5);
        goto L3
    L14:
        this._$$title = am3.h.c(r5);
        goto L3
    L15:
        this._$$background = am3.h.c(r5);
        goto L3
    L16:
        this._$$slogan = am3.h.c(r5);
        goto L3
    L17:
        this._$$icon = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L18:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$icon != null) goto L22;
        this._$$icon = BuildConfig.FLAVOR;
    L22:
        if (this._$$slogan != null) goto L25;
        this._$$slogan = BuildConfig.FLAVOR;
    L25:
        if (this._$$background != null) goto L28;
        this._$$background = BuildConfig.FLAVOR;
    L28:
        if (this._$$title != null) goto L31;
        this._$$title = BuildConfig.FLAVOR;
    L31:
        if (this._$$leftButtonText != null) goto L34;
        this._$$leftButtonText = BuildConfig.FLAVOR;
    L34:
        if (this._$$rightButtonText != null) goto L37;
        this._$$rightButtonText = BuildConfig.FLAVOR;
    L37:
        if (this._$$schemaUrl != null) goto L40;
        this._$$schemaUrl = BuildConfig.FLAVOR;
    L40:
        if (this._$$limitScene != null) goto L43;
        this._$$limitScene = BuildConfig.FLAVOR;
    L43:
        if (this._$$text != null) goto L70;
        this._$$text = BuildConfig.FLAVOR;
        return;
    }
}
