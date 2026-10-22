package com.ss.android.lark.export.entity.preview;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012*\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000f\u0012*\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R1\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR5\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR5\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u0006&"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewState;", "Ljava/io/Serializable;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/UrlPreviewState$Type;", "templateId", BuildConfig.FLAVOR, "cardUrl", "Lcom/ss/android/lark/export/entity/preview/Url;", "actions", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction;", "Lkotlin/collections/LinkedHashMap;", "styles", "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewStyleData;", "Lkotlin/collections/HashMap;", "properties", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlPreviewState$Type;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/Url;Ljava/util/LinkedHashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewState$Type;", "getTemplateId", "()Ljava/lang/String;", "getCardUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "getActions", "()Ljava/util/LinkedHashMap;", "getStyles", "()Ljava/util/HashMap;", "getProperties", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "Type", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewState implements Serializable {
    private final LinkedHashMap<String, UrlPreviewAction> actions;
    private final Url cardUrl;
    private final HashMap<String, UrlPreviewPropertyData> properties;
    private final HashMap<String, UrlPreviewStyleData> styles;
    private final String templateId;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewState$Type;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CARD", "ALERT", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type ALERT = null;
        public static final Type CARD = null;
        public static final a Companion = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("CARD", 0, 0);
            CARD = r0;
            Type r1 = new Type("ALERT", 1, 1);
            ALERT = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public int hashCode() {
        int r0 = ((this.type.hashCode() * 31) + this.templateId.hashCode()) * 31;
        Url r1 = this.cardUrl;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        LinkedHashMap<String, UrlPreviewAction> r5 = this.actions;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        HashMap<String, UrlPreviewStyleData> r8 = this.styles;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        HashMap<String, UrlPreviewPropertyData> r11 = this.properties;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final LinkedHashMap<String, UrlPreviewAction> getActions() {
        return this.actions;
    }

    public final Url getCardUrl() {
        return this.cardUrl;
    }

    public final HashMap<String, UrlPreviewPropertyData> getProperties() {
        return this.properties;
    }

    public final HashMap<String, UrlPreviewStyleData> getStyles() {
        return this.styles;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Type getType() {
        return this.type;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreviewState) == true) goto L8;
        return false;
    L8:
        UrlPreviewState r6 = (UrlPreviewState) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardUrl, r6.cardUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.styles, r6.styles) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.properties, r6.properties) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public UrlPreviewState(Type r2, String r3, Url r4, LinkedHashMap<String, UrlPreviewAction> r5, HashMap<String, UrlPreviewStyleData> r6, HashMap<String, UrlPreviewPropertyData> r7) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "templateId");
        this.type = r2;
        this.templateId = r3;
        this.cardUrl = r4;
        this.actions = r5;
        this.styles = r6;
        this.properties = r7;
    }
}
