package com.larus.doc.sdk.impl.v2.plugins.header;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData;", "Ljava/io/Serializable;", "<init>", "()V", "themeColor", "", "getThemeColor", "()Ljava/lang/String;", "setThemeColor", "(Ljava/lang/String;)V", "shouldShowDivider", "", "getShouldShowDivider", "()Z", "setShouldShowDivider", "(Z)V", "titleConfig", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "getTitleConfig", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "setTitleConfig", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;)V", "items", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "getItems", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "setItems", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;)V", "isEmpty", "toString", "TitleConfig", "Items", "Item", "EIconRes", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetCustomHeaderData implements Serializable {

    @SerializedName("items")
    private Items items;

    @SerializedName("shouldShowDivider")
    private boolean shouldShowDivider;

    @SerializedName("themeColor")
    private String themeColor;

    @SerializedName("titleConfig")
    private TitleConfig titleConfig;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$EIconRes;", "", "imgResId", "", "imgResTint", "<init>", "(Ljava/lang/String;III)V", "getImgResId", "()I", "getImgResTint", "doc_embedded_mindnote_exit", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EIconRes extends Enum<EIconRes> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ EIconRes[] $VALUES = null;
        public static final EIconRes doc_embedded_mindnote_exit = null;
        private final int imgResId;
        private final int imgResTint;

        private static final /* synthetic */ EIconRes[] $values() {
            return new EIconRes[]{doc_embedded_mindnote_exit};
        }

        public static EnumEntries<EIconRes> getEntries() {
            return $ENTRIES;
        }

        static {
            doc_embedded_mindnote_exit = new EIconRes("doc_embedded_mindnote_exit", 0, 2131232590, 2131101926);
            EIconRes[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static EIconRes[] values() {
            return (EIconRes[]) $VALUES.clone();
        }

        public final int getImgResId() {
            return this.imgResId;
        }

        public final int getImgResTint() {
            return this.imgResTint;
        }

        public static EIconRes valueOf(String r1) {
            return (EIconRes) r27.a.a(EIconRes.class, r1);
        }

        private EIconRes(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.imgResId = r3;
            this.imgResTint = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Item;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "extraId", "getExtraId", "setExtraId", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "style", "getStyle", "setStyle", "text", "getText", "setText", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Item {

        @SerializedName("enable")
        private Boolean enable;

        @SerializedName("extraId")
        private String extraId;

        @SerializedName("id")
        private String id;

        @SerializedName("style")
        private String style;

        @SerializedName("text")
        private String text;

        public Item() {
        }

        public String toString() {
            return "Item@" + hashCode() + "{id: " + this.id + ", extraId: " + this.extraId + ", enable: " + this.enable + ", style: " + this.style + ", text: " + this.text + '}';
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public final String getExtraId() {
            return this.extraId;
        }

        public final String getId() {
            return this.id;
        }

        public final String getStyle() {
            return this.style;
        }

        public final String getText() {
            return this.text;
        }

        public final void setEnable(Boolean r1) {
            this.enable = r1;
        }

        public final void setExtraId(String r1) {
            this.extraId = r1;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final void setStyle(String r1) {
            this.style = r1;
        }

        public final void setText(String r1) {
            this.text = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "", "<init>", "()V", "left", "", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Item;", "getLeft", "()Ljava/util/List;", "setLeft", "(Ljava/util/List;)V", "right", "getRight", "setRight", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Items {

        @SerializedName("left")
        private List<Item> left;

        @SerializedName("right")
        private List<Item> right;

        public Items() {
        }

        public String toString() {
            return "Items@" + hashCode() + "{left: " + this.left + ", right: right}";
        }

        public final List<Item> getLeft() {
            return this.left;
        }

        public final List<Item> getRight() {
            return this.right;
        }

        public final void setLeft(List<Item> r1) {
            this.left = r1;
        }

        public final void setRight(List<Item> r1) {
            this.right = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "position", "getPosition", "setPosition", "isLoading", "", "()Z", "setLoading", "(Z)V", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleConfig {

        @SerializedName("isLoading")
        private boolean isLoading;

        @SerializedName("position")
        private String position;

        @SerializedName("title")
        private String title;

        public TitleConfig() {
        }

        public String toString() {
            return "TitleConfig@" + hashCode() + "{title: " + this.title + ", position: " + this.position + ", isLoading: " + this.isLoading + '}';
        }

        public final String getPosition() {
            return this.position;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final void setLoading(boolean r1) {
            this.isLoading = r1;
        }

        public final void setPosition(String r1) {
            this.position = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    public SetCustomHeaderData() {
    }

    public final boolean isEmpty() {
        if (this.titleConfig != null) goto L22;
        Items r0 = this.items;
        if (r0 != null) goto L7;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (this.shouldShowDivider == true) goto L24;
        return true;
    L24:
        return false;
    L7:
        if (r0.getLeft() == null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        r1 = false;
        goto L17
    L9:
        if (r0.getRight() != null) goto L12;
        r2 = false;
        goto L13
    L22:
        return false;
    }

    public String toString() {
        return "SetCustomHeaderData@" + hashCode() + "{themeColor: " + this.themeColor + ", shouldShowDivider: " + this.shouldShowDivider + ", titleConfig: " + this.titleConfig + ", items: " + this.items + '}';
    }

    public final Items getItems() {
        return this.items;
    }

    public final boolean getShouldShowDivider() {
        return this.shouldShowDivider;
    }

    public final String getThemeColor() {
        return this.themeColor;
    }

    public final TitleConfig getTitleConfig() {
        return this.titleConfig;
    }

    public final void setItems(Items r1) {
        this.items = r1;
    }

    public final void setShouldShowDivider(boolean r1) {
        this.shouldShowDivider = r1;
    }

    public final void setThemeColor(String r1) {
        this.themeColor = r1;
    }

    public final void setTitleConfig(TitleConfig r1) {
        this.titleConfig = r1;
    }
}
