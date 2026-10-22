package com.bytedance.android.live.emoji.online.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bRB\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006("}, d2 = {"Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmoji;", "Ljava/io/Serializable;", "", "showInPanel", "", "toString", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "displayName", "getDisplayName", "setDisplayName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "displayNameLang", "Ljava/util/HashMap;", "getDisplayNameLang", "()Ljava/util/HashMap;", "setDisplayNameLang", "(Ljava/util/HashMap;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "hide", "getHide", "setHide", "<init>", "()V", "Companion", "a", "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public final class OnlineSmallEmoji implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("display_name_lang")
    private HashMap<String, String> displayNameLang;

    @SerializedName("height")
    private int height;

    @SerializedName("hide")
    private int hide;

    @SerializedName("uri")
    private String uri;

    @SerializedName("width")
    private int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean showInPanel() {
        if (this.hide != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "OnlineSmallEmoji={uri=" + this.uri + ", displayName=" + this.displayName + ", displayNameLang=" + this.displayName + ", hide=" + this.hide + '}';
    }

    public OnlineSmallEmoji() {
        this.uri = "";
        this.displayName = "";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final HashMap<String, String> getDisplayNameLang() {
        return this.displayNameLang;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHide() {
        return this.hide;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setDisplayName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.displayName = r2;
    }

    public final void setDisplayNameLang(HashMap<String, String> r1) {
        this.displayNameLang = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setHide(int r1) {
        this.hide = r1;
    }

    public final void setUri(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uri = r2;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
