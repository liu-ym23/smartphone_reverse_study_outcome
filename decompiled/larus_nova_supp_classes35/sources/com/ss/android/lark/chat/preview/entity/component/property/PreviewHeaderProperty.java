package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.preview.entity.component.Tag;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 o2\u00020\u0001:\u0002opBÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010V\u001a\u00020\u0000H\u0016J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010]\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010`\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010h\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0011HÖ\u0001J\t\u0010n\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\t\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\u000b\u0010,\"\u0004\b0\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\bN\u0010:\"\u0004\bO\u0010<R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!¨\u0006q"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "iconKey", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "title", BuildConfig.FLAVOR, "larkTag", "Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "childComponentId", "isNeedCopyLink", BuildConfig.FLAVOR, "isNeedClose", "theme", "Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "headerType", "Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "numberOfLines", BuildConfig.FLAVOR, "tagColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "tagTextColor", "headerTag", "faviconUrl", "iconColor", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "iconSize", "dmIcon", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Tag;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/ss/android/lark/chat/preview/entity/component/Theme;Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getIconKey", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIconKey", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getLarkTag", "()Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "setLarkTag", "(Lcom/ss/android/lark/chat/preview/entity/component/Tag;)V", "getChildComponentId", "setChildComponentId", "()Ljava/lang/Boolean;", "setNeedCopyLink", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setNeedClose", "getTheme", "()Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "setTheme", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;)V", "getHeaderType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "setHeaderType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;)V", "getNumberOfLines", "()Ljava/lang/Integer;", "setNumberOfLines", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTagColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setTagColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getTagTextColor", "setTagTextColor", "getHeaderTag", "setHeaderTag", "getFaviconUrl", "setFaviconUrl", "getIconColor", "setIconColor", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getIconSize", "setIconSize", "getDmIcon", "setDmIcon", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Tag;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/ss/android/lark/chat/preview/entity/component/Theme;Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ImageSet;)Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Companion", "HeaderType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewHeaderProperty extends BaseProperty {
    public static final a Companion = null;
    public static final int DEFAULT_ICON_SIZE_DP = 16;
    private String childComponentId;
    private ImageSet dmIcon;
    private String faviconUrl;
    private String headerTag;
    private HeaderType headerType;
    private ThemeColor iconColor;
    private ImageSet iconKey;
    private Integer iconSize;
    private Boolean isNeedClose;
    private Boolean isNeedCopyLink;
    private Tag larkTag;
    private Integer numberOfLines;
    private ThemeColor tagColor;
    private ThemeColor tagTextColor;
    private Theme theme;
    private String title;
    private UDIcon udIcon;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "NORMAL", "HEADLINES", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HeaderType extends Enum<HeaderType> implements Serializable {
        public static final a Companion = null;
        public static final HeaderType HEADLINES = null;
        public static final HeaderType NORMAL = null;
        public static final /* synthetic */ HeaderType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<HeaderType> getEntries() {
            return b;
        }

        static {
            HeaderType r0 = new HeaderType("NORMAL", 0, 0);
            NORMAL = r0;
            HeaderType r1 = new HeaderType("HEADLINES", 1, 1);
            HEADLINES = r1;
            HeaderType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static HeaderType[] values() {
            return (HeaderType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static HeaderType valueOf(String r1) {
            return (HeaderType) r27.a.a(HeaderType.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public HeaderType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ PreviewHeaderProperty copy$default(PreviewHeaderProperty r17, ImageSet r18, String r19, Tag r20, String r21, Boolean r22, Boolean r23, Theme r24, HeaderType r25, Integer r26, ThemeColor r27, ThemeColor r28, String r29, String r30, ThemeColor r31, UDIcon r32, Integer r33, ImageSet r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        ImageSet r2 = r17.iconKey;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.title;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Tag r4 = r17.larkTag;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r5 = r17.childComponentId;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Boolean r6 = r17.isNeedCopyLink;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Boolean r7 = r17.isNeedClose;
    L27:
        if ((r35 & 64) == 0) goto L29;
        Theme r8 = r17.theme;
    L31:
        if ((r35 & 128) == 0) goto L33;
        HeaderType r9 = r17.headerType;
    L35:
        if ((r35 & 256) == 0) goto L37;
        Integer r10 = r17.numberOfLines;
    L39:
        if ((r35 & 512) == 0) goto L41;
        ThemeColor r11 = r17.tagColor;
    L43:
        if ((r35 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        ThemeColor r12 = r17.tagTextColor;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r13 = r17.headerTag;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        String r14 = r17.faviconUrl;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        ThemeColor r15 = r17.iconColor;
    L58:
        ThemeColor r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        UDIcon r16 = r17.udIcon;
    L62:
        UDIcon r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        Integer r110 = r17.iconSize;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        ImageSet r1 = r17.dmIcon;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
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

    public final ImageSet component1() {
        return this.iconKey;
    }

    public final ThemeColor component10() {
        return this.tagColor;
    }

    public final ThemeColor component11() {
        return this.tagTextColor;
    }

    public final String component12() {
        return this.headerTag;
    }

    public final String component13() {
        return this.faviconUrl;
    }

    public final ThemeColor component14() {
        return this.iconColor;
    }

    public final UDIcon component15() {
        return this.udIcon;
    }

    public final Integer component16() {
        return this.iconSize;
    }

    public final ImageSet component17() {
        return this.dmIcon;
    }

    public final String component2() {
        return this.title;
    }

    public final Tag component3() {
        return this.larkTag;
    }

    public final String component4() {
        return this.childComponentId;
    }

    public final Boolean component5() {
        return this.isNeedCopyLink;
    }

    public final Boolean component6() {
        return this.isNeedClose;
    }

    public final Theme component7() {
        return this.theme;
    }

    public final HeaderType component8() {
        return this.headerType;
    }

    public final Integer component9() {
        return this.numberOfLines;
    }

    public final PreviewHeaderProperty copy(ImageSet r20, String r21, Tag r22, String r23, Boolean r24, Boolean r25, Theme r26, HeaderType r27, Integer r28, ThemeColor r29, ThemeColor r30, String r31, String r32, ThemeColor r33, UDIcon r34, Integer r35, ImageSet r36) {
        return new PreviewHeaderProperty(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PreviewHeaderProperty) == true) goto L8;
        return false;
    L8:
        PreviewHeaderProperty r6 = (PreviewHeaderProperty) r5;
        if (Intrinsics.areEqual(this.iconKey, r6.iconKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (this.larkTag == r6.larkTag) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.childComponentId, r6.childComponentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isNeedCopyLink, r6.isNeedCopyLink) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isNeedClose, r6.isNeedClose) == true) goto L27;
        return false;
    L27:
        if (this.theme == r6.theme) goto L30;
        return false;
    L30:
        if (this.headerType == r6.headerType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.numberOfLines, r6.numberOfLines) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagColor, r6.tagColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.tagTextColor, r6.tagTextColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.headerTag, r6.headerTag) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.faviconUrl, r6.faviconUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.iconColor, r6.iconColor) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.udIcon, r6.udIcon) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.iconSize, r6.iconSize) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.dmIcon, r6.dmIcon) == true) goto L59;
        return false;
    L59:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        ImageSet r0 = this.iconKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Tag r7 = this.larkTag;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.childComponentId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isNeedCopyLink;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isNeedClose;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Theme r19 = this.theme;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        HeaderType r22 = this.headerType;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.numberOfLines;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        ThemeColor r28 = this.tagColor;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        ThemeColor r31 = this.tagTextColor;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.headerTag;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.faviconUrl;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        ThemeColor r40 = this.iconColor;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        UDIcon r43 = this.udIcon;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.iconSize;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        ImageSet r49 = this.dmIcon;
        if (r49 == null) goto L71;
        r1 = r49.hashCode();
    L71:
        return r48 + r1;
    L65:
        r47 = r46.hashCode();
        goto L66
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
        return "PreviewHeaderProperty(iconKey=" + this.iconKey + ", title=" + this.title + ", larkTag=" + this.larkTag + ", childComponentId=" + this.childComponentId + ", isNeedCopyLink=" + this.isNeedCopyLink + ", isNeedClose=" + this.isNeedClose + ", theme=" + this.theme + ", headerType=" + this.headerType + ", numberOfLines=" + this.numberOfLines + ", tagColor=" + this.tagColor + ", tagTextColor=" + this.tagTextColor + ", headerTag=" + this.headerTag + ", faviconUrl=" + this.faviconUrl + ", iconColor=" + this.iconColor + ", udIcon=" + this.udIcon + ", iconSize=" + this.iconSize + ", dmIcon=" + this.dmIcon + ')';
    }

    public PreviewHeaderProperty clone() {
        PreviewHeaderProperty r15 = new PreviewHeaderProperty(this.iconKey, this.title, this.larkTag, this.childComponentId, this.isNeedCopyLink, this.isNeedClose, this.theme, this.headerType, this.numberOfLines, this.tagColor, this.tagTextColor, this.headerTag, this.faviconUrl, this.iconColor, this.udIcon, this.iconSize, this.dmIcon);
        r15.setMarginLeft(getMarginLeft());
        r15.setMarginRight(getMarginRight());
        r15.setMarginTop(getMarginTop());
        r15.setMarginBottom(getMarginBottom());
        return r15;
    }

    public final String getChildComponentId() {
        return this.childComponentId;
    }

    public final ImageSet getDmIcon() {
        return this.dmIcon;
    }

    public final String getFaviconUrl() {
        return this.faviconUrl;
    }

    public final String getHeaderTag() {
        return this.headerTag;
    }

    public final HeaderType getHeaderType() {
        return this.headerType;
    }

    public final ThemeColor getIconColor() {
        return this.iconColor;
    }

    public final ImageSet getIconKey() {
        return this.iconKey;
    }

    public final Integer getIconSize() {
        return this.iconSize;
    }

    public final Tag getLarkTag() {
        return this.larkTag;
    }

    public final Integer getNumberOfLines() {
        return this.numberOfLines;
    }

    public final ThemeColor getTagColor() {
        return this.tagColor;
    }

    public final ThemeColor getTagTextColor() {
        return this.tagTextColor;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public final Boolean isNeedClose() {
        return this.isNeedClose;
    }

    public final Boolean isNeedCopyLink() {
        return this.isNeedCopyLink;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m665clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r7 = r6.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L116;
        Map.Entry<Integer, PreviewData> r0 = r7.next();
        int r1 = r0.getKey().intValue();
        ImageSet r3 = null;
        UDIcon r4 = null;
        ThemeColor r5 = null;
        String r8 = null;
        String r9 = null;
        ThemeColor r10 = null;
        ThemeColor r11 = null;
        Boolean r12 = null;
        Boolean r13 = null;
        String r14 = null;
        String r15 = null;
        if (r1 == ComponentAttribute.icon.getValue()) goto L9;
        if (r1 == ComponentAttribute.title.getValue()) goto L15;
        int r16 = 0;
        if (r1 == ComponentAttribute.lark_tag.getValue()) goto L21;
        if (r1 == ComponentAttribute.child_component_id.getValue()) goto L29;
        if (r1 == ComponentAttribute.show_close_Btn.getValue()) goto L35;
        if (r1 == ComponentAttribute.show_copy_Link_Btn.getValue()) goto L41;
        if (r1 == ComponentAttribute.theme.getValue()) goto L47;
        if (r1 == ComponentAttribute.type.getValue()) goto L55;
        if (r1 == ComponentAttribute.number_of_lines.getValue()) goto L70;
        if (r1 == ComponentAttribute.tagColor.getValue()) goto L78;
        if (r1 == ComponentAttribute.tagTextColor.getValue()) goto L84;
        if (r1 == ComponentAttribute.header_tag.getValue()) goto L90;
        if (r1 == ComponentAttribute.favicon_url.getValue()) goto L96;
        if (r1 == ComponentAttribute.icon_color.getValue()) goto L102;
        if (r1 == ComponentAttribute.ud_icon_key.getValue()) goto L112;
        if (r1 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L112;
        if (r1 != ComponentAttribute.unicode.getValue()) goto L6;
    L112:
        UDIcon r2 = this.udIcon;
        if (r2 == null) goto L115;
        r4 = r2.patchData(r0.getKey().intValue(), r0.getValue(), this.udIcon);
    L115:
        this.udIcon = r4;
        goto L6
    L102:
        PreviewData r17 = r0.getValue();
        if (r17 == null) goto L105;
        r5 = r17.getThemeColor();
    L105:
        this.iconColor = r5;
        goto L6
    L96:
        PreviewData r18 = r0.getValue();
        if (r18 == null) goto L99;
        r8 = r18.getString();
    L99:
        this.faviconUrl = r8;
        goto L6
    L90:
        PreviewData r19 = r0.getValue();
        if (r19 == null) goto L93;
        r9 = r19.getString();
    L93:
        this.headerTag = r9;
        goto L6
    L84:
        PreviewData r20 = r0.getValue();
        if (r20 == null) goto L87;
        r10 = r20.getThemeColor();
    L87:
        this.tagTextColor = r10;
        goto L6
    L78:
        PreviewData r21 = r0.getValue();
        if (r21 == null) goto L81;
        r11 = r21.getThemeColor();
    L81:
        this.tagColor = r11;
        goto L6
    L70:
        PreviewData r22 = r0.getValue();
        if (r22 == null) goto L74;
        int r23 = r22.getInt();
        if (r23 == null) goto L74;
    L75:
        this.numberOfLines = r23;
    L74:
        r23 = 3;
        goto L75
    L55:
        HeaderType.a r24 = HeaderType.Companion;
        PreviewData r25 = r0.getValue();
        if (r25 == null) goto L60;
        Integer r26 = r25.getInt();
        if (r26 == null) goto L60;
        r16 = r26.intValue();
    L60:
        r24.getClass();
        if (r16 != 0) goto L63;
        HeaderType r27 = HeaderType.NORMAL;
    L67:
        this.headerType = r27;
        goto L6
    L63:
        if (r16 == 1) goto L65;
        r27 = HeaderType.NORMAL;
        goto L67
    L65:
        r27 = HeaderType.HEADLINES;
        goto L67
    L47:
        Theme.a r28 = Theme.Companion;
        PreviewData r29 = r0.getValue();
        if (r29 == null) goto L52;
        Integer r30 = r29.getInt();
        if (r30 == null) goto L52;
        r16 = r30.intValue();
    L52:
        r28.getClass();
        this.theme = Theme.a.a(r16);
        goto L6
    L41:
        PreviewData r31 = r0.getValue();
        if (r31 == null) goto L44;
        r12 = r31.getBoolean();
    L44:
        this.isNeedCopyLink = r12;
        goto L6
    L35:
        PreviewData r32 = r0.getValue();
        if (r32 == null) goto L38;
        r13 = r32.getBoolean();
    L38:
        this.isNeedClose = r13;
        goto L6
    L29:
        PreviewData r33 = r0.getValue();
        if (r33 == null) goto L32;
        r14 = r33.getString();
    L32:
        this.childComponentId = r14;
        goto L6
    L21:
        Tag.a r34 = Tag.Companion;
        PreviewData r35 = r0.getValue();
        if (r35 == null) goto L26;
        Integer r36 = r35.getInt();
        if (r36 == null) goto L26;
        r16 = r36.intValue();
    L26:
        r34.getClass();
        this.larkTag = Tag.a.a(r16);
        goto L6
    L15:
        PreviewData r37 = r0.getValue();
        if (r37 == null) goto L18;
        r15 = r37.getString();
    L18:
        this.title = r15;
        goto L6
    L9:
        PreviewData r38 = r0.getValue();
        if (r38 == null) goto L12;
        r3 = r38.getImageSet();
    L12:
        this.iconKey = r3;
        goto L6
    }

    public final void setChildComponentId(String r1) {
        this.childComponentId = r1;
    }

    public final void setDmIcon(ImageSet r1) {
        this.dmIcon = r1;
    }

    public final void setFaviconUrl(String r1) {
        this.faviconUrl = r1;
    }

    public final void setHeaderTag(String r1) {
        this.headerTag = r1;
    }

    public final void setHeaderType(HeaderType r1) {
        this.headerType = r1;
    }

    public final void setIconColor(ThemeColor r1) {
        this.iconColor = r1;
    }

    public final void setIconKey(ImageSet r1) {
        this.iconKey = r1;
    }

    public final void setIconSize(Integer r1) {
        this.iconSize = r1;
    }

    public final void setLarkTag(Tag r1) {
        this.larkTag = r1;
    }

    public final void setNeedClose(Boolean r1) {
        this.isNeedClose = r1;
    }

    public final void setNeedCopyLink(Boolean r1) {
        this.isNeedCopyLink = r1;
    }

    public final void setNumberOfLines(Integer r1) {
        this.numberOfLines = r1;
    }

    public final void setTagColor(ThemeColor r1) {
        this.tagColor = r1;
    }

    public final void setTagTextColor(ThemeColor r1) {
        this.tagTextColor = r1;
    }

    public final void setTheme(Theme r1) {
        this.theme = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setUdIcon(UDIcon r1) {
        this.udIcon = r1;
    }

    public PreviewHeaderProperty(ImageSet r3, String r4, Tag r5, String r6, Boolean r7, Boolean r8, Theme r9, HeaderType r10, Integer r11, ThemeColor r12, ThemeColor r13, String r14, String r15, ThemeColor r16, UDIcon r17, Integer r18, ImageSet r19) {
        super(Type.HEADER);
        this.iconKey = r3;
        this.title = r4;
        this.larkTag = r5;
        this.childComponentId = r6;
        this.isNeedCopyLink = r7;
        this.isNeedClose = r8;
        this.theme = r9;
        this.headerType = r10;
        this.numberOfLines = r11;
        this.tagColor = r12;
        this.tagTextColor = r13;
        this.headerTag = r14;
        this.faviconUrl = r15;
        this.iconColor = r16;
        this.udIcon = r17;
        this.iconSize = r18;
        this.dmIcon = r19;
    }

    public /* synthetic */ PreviewHeaderProperty(ImageSet r22, String r23, Tag r24, String r25, Boolean r26, Boolean r27, Theme r28, HeaderType r29, Integer r30, ThemeColor r31, ThemeColor r32, String r33, String r34, ThemeColor r35, UDIcon r36, Integer r37, ImageSet r38, int r39, DefaultConstructorMarker r40) {
        if ((r39 & 1) == 0) goto L5;
        ImageSet r4 = null;
    L7:
        if ((r39 & 4) == 0) goto L9;
        Tag r6 = null;
    L11:
        if ((r39 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r39 & 16) == 0) goto L17;
        Boolean r8 = null;
    L19:
        if ((r39 & 32) == 0) goto L21;
        Boolean r9 = null;
    L23:
        if ((r39 & 64) == 0) goto L25;
        Theme r10 = Theme.LIGHT;
    L27:
        if ((r39 & 128) == 0) goto L29;
        HeaderType r11 = HeaderType.NORMAL;
    L31:
        if ((r39 & 256) == 0) goto L33;
        Integer r12 = 3;
    L35:
        if ((r39 & 512) == 0) goto L37;
        ThemeColor r13 = null;
    L39:
        if ((r39 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L41;
        ThemeColor r14 = null;
    L43:
        if ((r39 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r39 & 4096) == 0) goto L49;
        String r16 = null;
    L51:
        if ((r39 & 8192) == 0) goto L53;
        ThemeColor r17 = null;
    L55:
        if ((r39 & 16384) == 0) goto L57;
        UDIcon r18 = null;
    L59:
        if ((32768 & r39) == 0) goto L61;
        Integer r19 = 16;
    L63:
        if ((r39 & 65536) == 0) goto L65;
        ImageSet r20 = null;
    L66:
        this(r4, r23, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L65:
        r20 = r38;
        goto L66
    L61:
        r19 = r37;
        goto L63
    L57:
        r18 = r36;
        goto L59
    L53:
        r17 = r35;
        goto L55
    L49:
        r16 = r34;
        goto L51
    L45:
        r15 = r33;
        goto L47
    L41:
        r14 = r32;
        goto L43
    L37:
        r13 = r31;
        goto L39
    L33:
        r12 = r30;
        goto L35
    L29:
        r11 = r29;
        goto L31
    L25:
        r10 = r28;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r7 = r25;
        goto L15
    L9:
        r6 = r24;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }
}
