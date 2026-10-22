package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.tangram.base.style.Value;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010!HÆ\u0003JÎ\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006_"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/PreviewData;", "Ljava/io/Serializable;", "string", BuildConfig.FLAVOR, "int", BuildConfig.FLAVOR, "long", BuildConfig.FLAVOR, "boolean", BuildConfig.FLAVOR, "float", BuildConfig.FLAVOR, "items", "Lcom/ss/android/lark/export/entity/preview/Items;", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "padding", "Lcom/ss/android/lark/export/entity/preview/Padding;", "imageSet", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "themeColors", "Lcom/ss/android/lark/export/entity/preview/ThemeColors;", "layoutValue", "Lcom/ss/android/lark/tangram/base/style/Value;", "chatterInfos", "Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "stringList", "Lcom/ss/android/lark/export/entity/preview/StringList;", "chatterInfo", "Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "tagList", "Lcom/ss/android/lark/export/entity/preview/TagList;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/Items;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/preview/ImageSet;Lcom/ss/android/lark/export/entity/preview/ThemeColors;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/export/entity/preview/ChatterInfos;Lcom/ss/android/lark/export/entity/preview/StringList;Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/TagList;)V", "getString", "()Ljava/lang/String;", "getInt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLong", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBoolean", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFloat", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getItems", "()Lcom/ss/android/lark/export/entity/preview/Items;", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getPadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "getImageSet", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "getThemeColors", "()Lcom/ss/android/lark/export/entity/preview/ThemeColors;", "getLayoutValue", "()Lcom/ss/android/lark/tangram/base/style/Value;", "getChatterInfos", "()Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "getStringList", "()Lcom/ss/android/lark/export/entity/preview/StringList;", "getChatterInfo", "()Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "getFontLevel", "()Lcom/ss/android/lark/export/entity/preview/FontLevel;", "getTagList", "()Lcom/ss/android/lark/export/entity/preview/TagList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/Items;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/preview/ImageSet;Lcom/ss/android/lark/export/entity/preview/ThemeColors;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/export/entity/preview/ChatterInfos;Lcom/ss/android/lark/export/entity/preview/StringList;Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/TagList;)Lcom/ss/android/lark/export/entity/preview/PreviewData;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewData implements Serializable {

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    private final Boolean f3boolean;
    private final AvatarChatterInfo chatterInfo;
    private final ChatterInfos chatterInfos;

    /* JADX INFO: renamed from: float, reason: not valid java name */
    private final Float f4float;
    private final FontLevel fontLevel;
    private final ImageSet imageSet;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private final Integer f5int;
    private final Items items;
    private final Value layoutValue;

    /* JADX INFO: renamed from: long, reason: not valid java name */
    private final Long f6long;
    private final Padding padding;
    private final String string;
    private final StringList stringList;
    private final TagList tagList;
    private final ThemeColor themeColor;
    private final ThemeColors themeColors;

    public static /* synthetic */ PreviewData copy$default(PreviewData r17, String r18, Integer r19, Long r20, Boolean r21, Float r22, Items r23, ThemeColor r24, Padding r25, ImageSet r26, ThemeColors r27, Value r28, ChatterInfos r29, StringList r30, AvatarChatterInfo r31, FontLevel r32, TagList r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.string;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Integer r3 = r17.f5int;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Long r4 = r17.f6long;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Boolean r5 = r17.f3boolean;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Float r6 = r17.f4float;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Items r7 = r17.items;
    L27:
        if ((r34 & 64) == 0) goto L29;
        ThemeColor r8 = r17.themeColor;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Padding r9 = r17.padding;
    L35:
        if ((r34 & 256) == 0) goto L37;
        ImageSet r10 = r17.imageSet;
    L39:
        if ((r34 & 512) == 0) goto L41;
        ThemeColors r11 = r17.themeColors;
    L43:
        if ((r34 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        Value r12 = r17.layoutValue;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        ChatterInfos r13 = r17.chatterInfos;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        StringList r14 = r17.stringList;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        AvatarChatterInfo r15 = r17.chatterInfo;
    L58:
        AvatarChatterInfo r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        FontLevel r16 = r17.fontLevel;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        TagList r1 = r17.tagList;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.string;
    }

    public final ThemeColors component10() {
        return this.themeColors;
    }

    public final Value component11() {
        return this.layoutValue;
    }

    public final ChatterInfos component12() {
        return this.chatterInfos;
    }

    public final StringList component13() {
        return this.stringList;
    }

    public final AvatarChatterInfo component14() {
        return this.chatterInfo;
    }

    public final FontLevel component15() {
        return this.fontLevel;
    }

    public final TagList component16() {
        return this.tagList;
    }

    public final Integer component2() {
        return this.f5int;
    }

    public final Long component3() {
        return this.f6long;
    }

    public final Boolean component4() {
        return this.f3boolean;
    }

    public final Float component5() {
        return this.f4float;
    }

    public final Items component6() {
        return this.items;
    }

    public final ThemeColor component7() {
        return this.themeColor;
    }

    public final Padding component8() {
        return this.padding;
    }

    public final ImageSet component9() {
        return this.imageSet;
    }

    public final PreviewData copy(String r19, Integer r20, Long r21, Boolean r22, Float r23, Items r24, ThemeColor r25, Padding r26, ImageSet r27, ThemeColors r28, Value r29, ChatterInfos r30, StringList r31, AvatarChatterInfo r32, FontLevel r33, TagList r34) {
        return new PreviewData(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PreviewData) == true) goto L8;
        return false;
    L8:
        PreviewData r6 = (PreviewData) r5;
        if (Intrinsics.areEqual(this.string, r6.string) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5int, r6.f5int) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f6long, r6.f6long) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3boolean, r6.f3boolean) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f4float, r6.f4float) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.themeColor, r6.themeColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.padding, r6.padding) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageSet, r6.imageSet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.themeColors, r6.themeColors) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.layoutValue, r6.layoutValue) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.chatterInfos, r6.chatterInfos) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.stringList, r6.stringList) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.chatterInfo, r6.chatterInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.fontLevel, r6.fontLevel) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.string;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f5int;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.f6long;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.f3boolean;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.f4float;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Items r16 = this.items;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        ThemeColor r19 = this.themeColor;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Padding r22 = this.padding;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ImageSet r25 = this.imageSet;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        ThemeColors r28 = this.themeColors;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Value r31 = this.layoutValue;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        ChatterInfos r34 = this.chatterInfos;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        StringList r37 = this.stringList;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        AvatarChatterInfo r40 = this.chatterInfo;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        FontLevel r43 = this.fontLevel;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        TagList r46 = this.tagList;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PreviewData(string=" + this.string + ", int=" + this.f5int + ", long=" + this.f6long + ", boolean=" + this.f3boolean + ", float=" + this.f4float + ", items=" + this.items + ", themeColor=" + this.themeColor + ", padding=" + this.padding + ", imageSet=" + this.imageSet + ", themeColors=" + this.themeColors + ", layoutValue=" + this.layoutValue + ", chatterInfos=" + this.chatterInfos + ", stringList=" + this.stringList + ", chatterInfo=" + this.chatterInfo + ", fontLevel=" + this.fontLevel + ", tagList=" + this.tagList + ')';
    }

    public final Boolean getBoolean() {
        return this.f3boolean;
    }

    public final AvatarChatterInfo getChatterInfo() {
        return this.chatterInfo;
    }

    public final ChatterInfos getChatterInfos() {
        return this.chatterInfos;
    }

    public final Float getFloat() {
        return this.f4float;
    }

    public final FontLevel getFontLevel() {
        return this.fontLevel;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final Integer getInt() {
        return this.f5int;
    }

    public final Items getItems() {
        return this.items;
    }

    public final Value getLayoutValue() {
        return this.layoutValue;
    }

    public final Long getLong() {
        return this.f6long;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final String getString() {
        return this.string;
    }

    public final StringList getStringList() {
        return this.stringList;
    }

    public final TagList getTagList() {
        return this.tagList;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final ThemeColors getThemeColors() {
        return this.themeColors;
    }

    public PreviewData(String r3, Integer r4, Long r5, Boolean r6, Float r7, Items r8, ThemeColor r9, Padding r10, ImageSet r11, ThemeColors r12, Value r13, ChatterInfos r14, StringList r15, AvatarChatterInfo r16, FontLevel r17, TagList r18) {
        this.string = r3;
        this.f5int = r4;
        this.f6long = r5;
        this.f3boolean = r6;
        this.f4float = r7;
        this.items = r8;
        this.themeColor = r9;
        this.padding = r10;
        this.imageSet = r11;
        this.themeColors = r12;
        this.layoutValue = r13;
        this.chatterInfos = r14;
        this.stringList = r15;
        this.chatterInfo = r16;
        this.fontLevel = r17;
        this.tagList = r18;
    }
}
