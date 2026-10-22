package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.HighLightLabel")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/t;", "", "", "text", "Ljava/lang/String;", "", "status", "I", "labelType", "labelNameFontStyle", "labelNameFontColor", "labelBottomImageUrl", "labelPartnerBottomImageUrl", "labelDescBottomImageUrl", "labelDescImageUrl", "labelPartnerDescImageUrl", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t implements vh7.h {

    @SerializedName("label_bottom_image_url")
    public String labelBottomImageUrl;

    @SerializedName("label_desc_bottom_image_url")
    public String labelDescBottomImageUrl;

    @SerializedName("label_desc_image_url")
    public String labelDescImageUrl;

    @SerializedName("label_name_font_color")
    public String labelNameFontColor;

    @SerializedName("label_name_font_style")
    public String labelNameFontStyle;

    @SerializedName("label_partner_bottom_image_url")
    public String labelPartnerBottomImageUrl;

    @SerializedName("label_partner_desc_image_url")
    public String labelPartnerDescImageUrl;

    @SerializedName("label_type")
    public int labelType;

    @SerializedName("status")
    public int status;

    @SerializedName("text")
    public String text;

    public t() {
        this.text = "";
        this.status = 0;
        this.labelType = 0;
        this.labelNameFontStyle = "";
        this.labelNameFontColor = "";
        this.labelBottomImageUrl = "";
        this.labelPartnerBottomImageUrl = "";
        this.labelDescBottomImageUrl = "";
        this.labelDescImageUrl = "";
        this.labelPartnerDescImageUrl = "";
    }

    public t(am3.g r7) {
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L17;
        switch(r4) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.labelPartnerDescImageUrl = am3.h.c(r7);
        goto L3
    L8:
        this.labelDescImageUrl = am3.h.c(r7);
        goto L3
    L9:
        this.labelDescBottomImageUrl = am3.h.c(r7);
        goto L3
    L10:
        this.labelPartnerBottomImageUrl = am3.h.c(r7);
        goto L3
    L11:
        this.labelBottomImageUrl = am3.h.c(r7);
        goto L3
    L12:
        this.labelNameFontColor = am3.h.c(r7);
        goto L3
    L13:
        this.labelNameFontStyle = am3.h.c(r7);
        goto L3
    L14:
        this.labelType = r7.i();
        r3 = r3 | 2;
        goto L3
    L15:
        this.status = (int) r7.j();
        r3 = r3 | 1;
        goto L3
    L16:
        this.text = am3.h.c(r7);
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L17:
        r7.d(r0);
        if (this.text != null) goto L21;
        this.text = "";
    L21:
        if ((r3 & 1) != 0) goto L24;
        this.status = 0;
    L24:
        if ((r3 & 2) != 0) goto L27;
        this.labelType = 0;
    L27:
        if (this.labelNameFontStyle != null) goto L30;
        this.labelNameFontStyle = "";
    L30:
        if (this.labelNameFontColor != null) goto L33;
        this.labelNameFontColor = "";
    L33:
        if (this.labelBottomImageUrl != null) goto L36;
        this.labelBottomImageUrl = "";
    L36:
        if (this.labelPartnerBottomImageUrl != null) goto L39;
        this.labelPartnerBottomImageUrl = "";
    L39:
        if (this.labelDescBottomImageUrl != null) goto L42;
        this.labelDescBottomImageUrl = "";
    L42:
        if (this.labelDescImageUrl != null) goto L45;
        this.labelDescImageUrl = "";
    L45:
        if (this.labelPartnerDescImageUrl != null) goto L72;
        this.labelPartnerDescImageUrl = "";
        return;
    }
}
