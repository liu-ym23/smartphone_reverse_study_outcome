package com.bytedance.android.live.base.model;

import android.text.TextUtils;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.PanelWidget")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010,\u001a\u00020\u0004H\u0016J\u0006\u0010-\u001a\u00020*J\b\u0010.\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR \u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR \u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR \u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/base/model/PanelWidget;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "imageFallbackUrl", "", "getImageFallbackUrl", "()Ljava/lang/String;", "setImageFallbackUrl", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "isGray", "setGray", "name", "getName", "setName", "payload", "getPayload", "setPayload", "scheme", "getScheme", "setScheme", "showType", "getShowType", "setShowType", "title", "getTitle", "setTitle", "toast", "getToast", "setToast", "type", "getType", "setType", "equals", "", "o", "hashCode", "needGray", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelWidget implements vh7.h {

    @SerializedName("id")
    protected int id;

    @SerializedName("image_fallback_url")
    protected String imageFallbackUrl;

    @SerializedName("image_url")
    protected String imageUrl;

    @SerializedName("is_gray")
    protected int isGray;

    @SerializedName("name")
    protected String name;

    @SerializedName("payload")
    protected String payload;

    @SerializedName("scheme_url")
    protected String scheme;

    @SerializedName(FeedApi.SHOW_TYPE)
    protected int showType;

    @SerializedName("display_text")
    protected String title;

    @SerializedName("toast")
    protected String toast;

    @SerializedName("type")
    protected int type;

    public PanelWidget() {
    }

    public int hashCode() {
        int r0 = this.id * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 == null) goto L6;
        if (r1 == null) goto L6;
        int r3 = r1.hashCode();
    L7:
        int r4 = (r0 + r3) * 31;
        String r5 = this.title;
        if (r5 == null) goto L11;
        if (r5 == null) goto L11;
        int r6 = r5.hashCode();
    L12:
        int r7 = (((r4 + r6) * 31) + this.type) * 31;
        String r8 = this.scheme;
        if (r8 == null) goto L16;
        if (r8 == null) goto L16;
        int r9 = r8.hashCode();
    L17:
        int r11 = (r7 + r9) * 31;
        String r12 = this.imageUrl;
        if (r12 == null) goto L21;
        if (r12 == null) goto L21;
        int r13 = r12.hashCode();
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.imageFallbackUrl;
        if (r15 == null) goto L26;
        if (r15 == null) goto L26;
        int r16 = r15.hashCode();
    L27:
        int r17 = (((r14 + r16) * 31) + this.isGray) * 31;
        String r18 = this.toast;
        if (r18 == null) goto L31;
        if (r18 == null) goto L31;
        int r19 = r18.hashCode();
    L32:
        int r21 = (((r17 + r19) * 31) + this.showType) * 31;
        String r22 = this.payload;
        if (r22 == null) goto L37;
        if (r22 == null) goto L37;
        r2 = r22.hashCode();
    L37:
        return r21 + r2;
    L31:
        r19 = 0;
    L26:
        r16 = 0;
    L21:
        r13 = 0;
    L16:
        r9 = 0;
    L11:
        r6 = 0;
    L6:
        r3 = 0;
        goto L7
    }

    public final boolean needGray() {
        if (this.isGray == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        if (TextUtils.isEmpty(this.title) == false) goto L8;
        String r0 = this.name;
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    L8:
        return this.title;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImageFallbackUrl() {
        return this.imageFallbackUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToast() {
        return this.toast;
    }

    public final int getType() {
        return this.type;
    }

    public final int isGray() {
        return this.isGray;
    }

    public PanelWidget(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L28;
        if (r2 != 1) goto L8;
        this.id = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.name = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.title = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.type = r5.i();
        goto L3
    L14:
        if (r2 != 100) goto L15;
        this.payload = am3.h.c(r5);
        goto L3
    L15:
        switch(r2) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            default: goto L16;
        };
    L17:
        this.scheme = am3.h.c(r5);
        goto L3
    L18:
        this.showType = r5.i();
        goto L3
    L19:
        this.toast = am3.h.c(r5);
        goto L3
    L20:
        this.isGray = r5.i();
        goto L3
    L21:
        this.imageFallbackUrl = am3.h.c(r5);
        goto L3
    L22:
        this.imageUrl = am3.h.c(r5);
        goto L3
    L16:
        am3.h.e(r5);
        goto L3
    L28:
        r5.d(r0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L83:
        return false;
    L8:
        if ((!Intrinsics.areEqual(PanelWidget.class, r5.getClass())) == true) goto L83;
        PanelWidget r6 = (PanelWidget) r5;
        if (this.id == r6.id) goto L14;
        return false;
    L14:
        if (this.type == r6.type) goto L17;
        return false;
    L17:
        if (this.isGray == r6.isGray) goto L20;
        return false;
    L20:
        if (this.showType == r6.showType) goto L22;
        return false;
    L22:
        String r2 = this.name;
        if (r2 == null) goto L26;
        boolean r3 = !Intrinsics.areEqual(r2, r6.name);
    L29:
        if (r3 == false) goto L31;
        return false;
    L31:
        String r4 = this.title;
        if (r4 == null) goto L35;
        boolean r7 = !Intrinsics.areEqual(r4, r6.title);
    L38:
        if (r7 == false) goto L40;
        return false;
    L40:
        String r8 = this.scheme;
        if (r8 == null) goto L44;
        boolean r9 = !Intrinsics.areEqual(r8, r6.scheme);
    L47:
        if (r9 == false) goto L49;
        return false;
    L49:
        String r11 = this.imageUrl;
        if (r11 == null) goto L53;
        boolean r12 = !Intrinsics.areEqual(r11, r6.imageUrl);
    L56:
        if (r12 == false) goto L58;
        return false;
    L58:
        String r13 = this.imageFallbackUrl;
        if (r13 == null) goto L62;
        boolean r14 = !Intrinsics.areEqual(r13, r6.imageFallbackUrl);
    L65:
        if (r14 == false) goto L67;
        return false;
    L67:
        String r15 = this.toast;
        if (r15 == null) goto L71;
        boolean r16 = !Intrinsics.areEqual(r15, r6.toast);
    L74:
        if (r16 == false) goto L76;
        return false;
    L76:
        String r17 = this.payload;
        String r18 = r6.payload;
        if (r17 != null) goto L84;
        if (r18 == null) goto L85;
        return false;
    L85:
        return true;
    L84:
        return Intrinsics.areEqual(r17, r18);
    L71:
        if (r6.toast == null) goto L73;
        r16 = true;
        goto L74
    L73:
        r16 = false;
        goto L74
    L62:
        if (r6.imageFallbackUrl == null) goto L64;
        r14 = true;
        goto L65
    L64:
        r14 = false;
        goto L65
    L53:
        if (r6.imageUrl == null) goto L55;
        r12 = true;
        goto L56
    L55:
        r12 = false;
        goto L56
    L44:
        if (r6.scheme == null) goto L46;
        r9 = true;
        goto L47
    L46:
        r9 = false;
        goto L47
    L35:
        if (r6.title == null) goto L37;
        r7 = true;
        goto L38
    L37:
        r7 = false;
        goto L38
    L26:
        if (r6.name == null) goto L28;
        r3 = true;
        goto L29
    L28:
        r3 = false;
        goto L29
    }

    public final void setGray(int r1) {
        this.isGray = r1;
    }

    public final void setId(int r1) {
        this.id = r1;
    }

    public final void setImageFallbackUrl(String r1) {
        this.imageFallbackUrl = r1;
    }

    public final void setImageUrl(String r1) {
        this.imageUrl = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setPayload(String r1) {
        this.payload = r1;
    }

    public final void setScheme(String r1) {
        this.scheme = r1;
    }

    public final void setShowType(int r1) {
        this.showType = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setToast(String r1) {
        this.toast = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
