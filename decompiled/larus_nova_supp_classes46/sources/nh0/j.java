package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lnh0/j;", "", "", "bg", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBg", "(Ljava/lang/String;)V", "textColor", "e", "setTextColor", "strokeColor", "d", "setStrokeColor", "shadowColor", "getShadowColor", "setShadowColor", "", "shadowRadius", "I", "getShadowRadius", "()I", "setShadowRadius", "(I)V", "fontSize", "c", "setFontSize", "font", "getFont", "setFont", "animationType", "a", "setAnimationType", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j {

    @SerializedName("animation_type")
    private String animationType;

    @SerializedName("bg")
    private String bg;

    @SerializedName("font")
    private String font;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("shadow_color")
    private String shadowColor;

    @SerializedName("shadow_radius")
    private int shadowRadius;

    @SerializedName("stroke_color")
    private String strokeColor;

    @SerializedName("text_color")
    private String textColor;

    public j() {
        this.shadowColor = "#8B98ED";
        this.shadowRadius = 1;
        this.fontSize = 12;
    }

    public final String a() {
        return this.animationType;
    }

    public final String b() {
        return this.bg;
    }

    public final int c() {
        return this.fontSize;
    }

    public final String d() {
        return this.strokeColor;
    }

    public final String e() {
        return this.textColor;
    }

    public final boolean f(j r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L29:
        return false;
    L8:
        if ((!Intrinsics.areEqual(j.class, j.class)) == true) goto L29;
        if (Intrinsics.areEqual(this.bg, r5.bg) == true) goto L13;
    L27:
        return false;
    L13:
        if (Intrinsics.areEqual(this.textColor, r5.textColor) == false) goto L27;
        if (Intrinsics.areEqual(this.strokeColor, r5.strokeColor) == false) goto L27;
        if (Intrinsics.areEqual(this.shadowColor, r5.shadowColor) == false) goto L27;
        if (this.shadowRadius != r5.shadowRadius) goto L27;
        if (this.fontSize != r5.fontSize) goto L27;
        if (Intrinsics.areEqual(this.font, r5.font) == false) goto L27;
        if (Intrinsics.areEqual(this.animationType, r5.animationType) == false) goto L27;
        return true;
    }
}
