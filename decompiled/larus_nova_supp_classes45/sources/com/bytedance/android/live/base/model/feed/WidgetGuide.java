package com.bytedance.android.live.base.model.feed;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.WidgetGuide")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/WidgetGuide;", "Ljava/io/Serializable;", "()V", "buttonSchemaUrl", "", "getButtonSchemaUrl", "()Ljava/lang/String;", "setButtonSchemaUrl", "(Ljava/lang/String;)V", "buttonText", "getButtonText", "setButtonText", "buttonType", "getButtonType", "setButtonType", "guideText", "getGuideText", "setGuideText", "guideTextTag", "getGuideTextTag", "setGuideTextTag", "isAnchor", "", "()Ljava/lang/Boolean;", "setAnchor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WidgetGuide implements Serializable, h {

    @SerializedName("button_schema_url")
    protected String buttonSchemaUrl;

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("button_type")
    protected String buttonType;

    @SerializedName("guide_text")
    protected String guideText;

    @SerializedName("guide_text_tag")
    protected String guideTextTag;

    @SerializedName("is_anchor")
    protected Boolean isAnchor;

    public WidgetGuide() {
    }

    public WidgetGuide(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.buttonType = am3.h.c(r5);
        goto L3
    L8:
        this.guideTextTag = am3.h.c(r5);
        goto L3
    L9:
        this.buttonSchemaUrl = am3.h.c(r5);
        goto L3
    L10:
        this.buttonText = am3.h.c(r5);
        goto L3
    L11:
        this.guideText = am3.h.c(r5);
        goto L3
    L12:
        this.isAnchor = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }

    public final String getButtonSchemaUrl() {
        return this.buttonSchemaUrl;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final String getGuideTextTag() {
        return this.guideTextTag;
    }

    public final Boolean isAnchor() {
        return this.isAnchor;
    }

    public final void setAnchor(Boolean r1) {
        this.isAnchor = r1;
    }

    public final void setButtonSchemaUrl(String r1) {
        this.buttonSchemaUrl = r1;
    }

    public final void setButtonText(String r1) {
        this.buttonText = r1;
    }

    public final void setButtonType(String r1) {
        this.buttonType = r1;
    }

    public final void setGuideText(String r1) {
        this.guideText = r1;
    }

    public final void setGuideTextTag(String r1) {
        this.guideTextTag = r1;
    }
}
