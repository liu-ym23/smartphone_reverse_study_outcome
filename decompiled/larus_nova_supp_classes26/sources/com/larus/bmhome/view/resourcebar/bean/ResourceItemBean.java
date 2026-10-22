package com.larus.bmhome.view.resourcebar.bean;

import com.larus.im.bean.message.Image;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mt8.b;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012$\b\u0002\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001f¢\u0006\u0004\b \u0010!J\u000e\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u0000J\u0013\u0010P\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010Q\u001a\u00020\u0003H\u0016J\b\u0010R\u001a\u00020\fH\u0016J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010Y\u001a\u00020\fHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u0010HÆ\u0003J\t\u0010\\\u001a\u00020\u0012HÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0010HÆ\u0003J\t\u0010d\u001a\u00020\u0010HÆ\u0003J\t\u0010e\u001a\u00020\fHÆ\u0003J%\u0010f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fHÆ\u0003Jñ\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\f2$\b\u0002\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00103\"\u0004\b4\u00105R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u001a\u0010\u0017\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00103\"\u0004\bC\u00105R\u001a\u0010\u0019\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00103\"\u0004\bE\u00105R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u00105R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e`\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006h"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Ljava/io/Serializable;", "key", "", "title", "fileSuffixes", "mimeType", "image", "Lcom/larus/im/bean/message/Image;", "video", "Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;", "upLinkProgress", "", "status", "Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "isExpire", "", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "itemWidth", "itemHeight", "paddingTop", "paddingBottom", "showEditImageBtn", "showEditVideoBtn", "showSubscriptView", "immersiveStyle", "subscriptIndex", "ext", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;ILcom/larus/bmhome/view/resourcebar/bean/ItemStatus;ZLcom/larus/bmhome/view/resourcebar/bean/ResourceType;IIIIZZZZILjava/util/HashMap;)V", "getKey", "()Ljava/lang/String;", "getTitle", "getFileSuffixes", "getMimeType", "getImage", "()Lcom/larus/im/bean/message/Image;", "getVideo", "()Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;", "getUpLinkProgress", "()I", "setUpLinkProgress", "(I)V", "getStatus", "()Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "setStatus", "(Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;)V", "()Z", "setExpire", "(Z)V", "getResourceType", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "setResourceType", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;)V", "getItemWidth", "setItemWidth", "getItemHeight", "setItemHeight", "getPaddingTop", "getPaddingBottom", "getShowEditImageBtn", "setShowEditImageBtn", "getShowEditVideoBtn", "setShowEditVideoBtn", "getShowSubscriptView", "setShowSubscriptView", "getImmersiveStyle", "setImmersiveStyle", "getSubscriptIndex", "setSubscriptIndex", "getExt", "()Ljava/util/HashMap;", "setExt", "(Ljava/util/HashMap;)V", "equalsExcludeProgress", "other", "equals", "toString", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceItemBean implements Serializable {
    private HashMap<String, Object> ext;
    private final String fileSuffixes;
    private final Image image;
    private boolean immersiveStyle;
    private boolean isExpire;
    private int itemHeight;
    private int itemWidth;
    private final String key;
    private final String mimeType;
    private final int paddingBottom;
    private final int paddingTop;
    private ResourceType resourceType;
    private boolean showEditImageBtn;
    private boolean showEditVideoBtn;
    private boolean showSubscriptView;
    private ItemStatus status;
    private int subscriptIndex;
    private final String title;
    private int upLinkProgress;
    private final b video;

    public ResourceItemBean() {
        this(null, null, null, null, null, null, 0, null, false, null, 0, 0, 0, 0, false, false, false, false, 0, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceItemBean copy$default(ResourceItemBean r17, String r18, String r19, String r20, String r21, Image r22, b r23, int r24, ItemStatus r25, boolean r26, ResourceType r27, int r28, int r29, int r30, int r31, boolean r32, boolean r33, boolean r34, boolean r35, int r36, HashMap r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        String r2 = r17.key;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = r17.title;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = r17.fileSuffixes;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = r17.mimeType;
    L19:
        if ((r38 & 16) == 0) goto L21;
        Image r6 = r17.image;
    L23:
        if ((r38 & 32) == 0) goto L25;
        b r7 = r17.video;
    L27:
        if ((r38 & 64) == 0) goto L29;
        int r8 = r17.upLinkProgress;
    L31:
        if ((r38 & 128) == 0) goto L33;
        ItemStatus r9 = r17.status;
    L35:
        if ((r38 & 256) == 0) goto L37;
        boolean r10 = r17.isExpire;
    L39:
        if ((r38 & 512) == 0) goto L41;
        ResourceType r11 = r17.resourceType;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        int r12 = r17.itemWidth;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        int r13 = r17.itemHeight;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        int r14 = r17.paddingTop;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        int r15 = r17.paddingBottom;
    L58:
        int r310 = r15;
        if ((r38 & 16384) == 0) goto L61;
        boolean r16 = r17.showEditImageBtn;
    L62:
        boolean r311 = r16;
        if ((r38 & 32768) == 0) goto L65;
        boolean r110 = r17.showEditVideoBtn;
    L66:
        boolean r312 = r110;
        if ((r38 & 65536) == 0) goto L69;
        boolean r111 = r17.showSubscriptView;
    L70:
        boolean r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        boolean r112 = r17.immersiveStyle;
    L74:
        boolean r314 = r112;
        if ((r38 & 262144) == 0) goto L77;
        int r113 = r17.subscriptIndex;
    L79:
        if ((r38 & 524288) == 0) goto L81;
        HashMap r1 = r17.ext;
    L83:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r113, r1);
    L81:
        r1 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L79
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
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

    public final String component1() {
        return this.key;
    }

    public final ResourceType component10() {
        return this.resourceType;
    }

    public final int component11() {
        return this.itemWidth;
    }

    public final int component12() {
        return this.itemHeight;
    }

    public final int component13() {
        return this.paddingTop;
    }

    public final int component14() {
        return this.paddingBottom;
    }

    public final boolean component15() {
        return this.showEditImageBtn;
    }

    public final boolean component16() {
        return this.showEditVideoBtn;
    }

    public final boolean component17() {
        return this.showSubscriptView;
    }

    public final boolean component18() {
        return this.immersiveStyle;
    }

    public final int component19() {
        return this.subscriptIndex;
    }

    public final String component2() {
        return this.title;
    }

    public final HashMap<String, Object> component20() {
        return this.ext;
    }

    public final String component3() {
        return this.fileSuffixes;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final Image component5() {
        return this.image;
    }

    public final b component6() {
        return this.video;
    }

    public final int component7() {
        return this.upLinkProgress;
    }

    public final ItemStatus component8() {
        return this.status;
    }

    public final boolean component9() {
        return this.isExpire;
    }

    public final ResourceItemBean copy(String r24, String r25, String r26, String r27, Image r28, b r29, int r30, ItemStatus r31, boolean r32, ResourceType r33, int r34, int r35, int r36, int r37, boolean r38, boolean r39, boolean r40, boolean r41, int r42, HashMap<String, Object> r43) {
        Intrinsics.checkNotNullParameter(r24, "key");
        Intrinsics.checkNotNullParameter(r25, "title");
        Intrinsics.checkNotNullParameter(r26, "fileSuffixes");
        Intrinsics.checkNotNullParameter(r27, "mimeType");
        Intrinsics.checkNotNullParameter(r31, "status");
        Intrinsics.checkNotNullParameter(r33, "resourceType");
        Intrinsics.checkNotNullParameter(r43, "ext");
        return new ResourceItemBean(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    }

    public String toString() {
        return "key:" + this.key + ",title:" + this.title + ",mimeType:" + this.mimeType + ",upLinkProgress:" + this.upLinkProgress + ",status:" + this.status + ",resourceType:" + this.resourceType + ",image:" + this.image;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final HashMap<String, Object> getExt() {
        return this.ext;
    }

    public final String getFileSuffixes() {
        return this.fileSuffixes;
    }

    public final Image getImage() {
        return this.image;
    }

    public final boolean getImmersiveStyle() {
        return this.immersiveStyle;
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final ResourceType getResourceType() {
        return this.resourceType;
    }

    public final boolean getShowEditImageBtn() {
        return this.showEditImageBtn;
    }

    public final boolean getShowEditVideoBtn() {
        return this.showEditVideoBtn;
    }

    public final boolean getShowSubscriptView() {
        return this.showSubscriptView;
    }

    public final ItemStatus getStatus() {
        return this.status;
    }

    public final int getSubscriptIndex() {
        return this.subscriptIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUpLinkProgress() {
        return this.upLinkProgress;
    }

    public final b getVideo() {
        return this.video;
    }

    public final boolean isExpire() {
        return this.isExpire;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ResourceItemBean) == true) goto L5;
        return false;
    L5:
        ResourceItemBean r4 = (ResourceItemBean) r3;
        if (equalsExcludeProgress(r4) == true) goto L8;
        return false;
    L8:
        if (this.upLinkProgress != r4.upLinkProgress) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean equalsExcludeProgress(ResourceItemBean r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        if (Intrinsics.areEqual(this.key, r3.key) == true) goto L5;
    L21:
        return false;
    L5:
        if (Intrinsics.areEqual(this.title, r3.title) == false) goto L21;
        if (Intrinsics.areEqual(this.mimeType, r3.mimeType) == false) goto L21;
        if (this.status != r3.status) goto L21;
        if (this.resourceType != r3.resourceType) goto L21;
        if (Intrinsics.areEqual(this.image, r3.image) == false) goto L21;
        if (Intrinsics.areEqual(this.video, r3.video) == false) goto L21;
        if (this.subscriptIndex != r3.subscriptIndex) goto L21;
        if (this.showSubscriptView != r3.showSubscriptView) goto L21;
        return true;
    }

    public final void setExpire(boolean r1) {
        this.isExpire = r1;
    }

    public final void setExt(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ext = r2;
    }

    public final void setImmersiveStyle(boolean r1) {
        this.immersiveStyle = r1;
    }

    public final void setItemHeight(int r1) {
        this.itemHeight = r1;
    }

    public final void setItemWidth(int r1) {
        this.itemWidth = r1;
    }

    public final void setResourceType(ResourceType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resourceType = r2;
    }

    public final void setShowEditImageBtn(boolean r1) {
        this.showEditImageBtn = r1;
    }

    public final void setShowEditVideoBtn(boolean r1) {
        this.showEditVideoBtn = r1;
    }

    public final void setShowSubscriptView(boolean r1) {
        this.showSubscriptView = r1;
    }

    public final void setStatus(ItemStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.status = r2;
    }

    public final void setSubscriptIndex(int r1) {
        this.subscriptIndex = r1;
    }

    public final void setUpLinkProgress(int r1) {
        this.upLinkProgress = r1;
    }

    public ResourceItemBean(String r10, String r11, String r12, String r13, Image r14, b r15, int r16, ItemStatus r17, boolean r18, ResourceType r19, int r20, int r21, int r22, int r23, boolean r24, boolean r25, boolean r26, boolean r27, int r28, HashMap<String, Object> r29) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "fileSuffixes");
        Intrinsics.checkNotNullParameter(r13, "mimeType");
        Intrinsics.checkNotNullParameter(r17, "status");
        Intrinsics.checkNotNullParameter(r19, "resourceType");
        Intrinsics.checkNotNullParameter(r29, "ext");
        this.key = r10;
        this.title = r11;
        this.fileSuffixes = r12;
        this.mimeType = r13;
        this.image = r14;
        this.video = r15;
        this.upLinkProgress = r16;
        this.status = r17;
        this.isExpire = r18;
        this.resourceType = r19;
        this.itemWidth = r20;
        this.itemHeight = r21;
        this.paddingTop = r22;
        this.paddingBottom = r23;
        this.showEditImageBtn = r24;
        this.showEditVideoBtn = r25;
        this.showSubscriptView = r26;
        this.immersiveStyle = r27;
        this.subscriptIndex = r28;
        this.ext = r29;
    }

    public /* synthetic */ ResourceItemBean(String r22, String r23, String r24, String r25, Image r26, b r27, int r28, ItemStatus r29, boolean r30, ResourceType r31, int r32, int r33, int r34, int r35, boolean r36, boolean r37, boolean r38, boolean r39, int r40, HashMap r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        String r1 = UUID.randomUUID().toString();
    L6:
        String r3 = "";
        if ((r42 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r42 & 8) != 0) goto L18;
        r3 = r25;
    L18:
        b r6 = null;
        if ((r42 & 16) == 0) goto L21;
        Image r5 = null;
    L23:
        if ((r42 & 32) != 0) goto L27;
        r6 = r27;
    L27:
        if ((r42 & 64) == 0) goto L29;
        int r7 = 0;
    L31:
        if ((r42 & 128) == 0) goto L33;
        ItemStatus r9 = ItemStatus.SUCCESS;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r10 = false;
    L39:
        if ((r42 & 512) == 0) goto L41;
        ResourceType r11 = ResourceType.FILE;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        int r12 = i5.y();
    L47:
        if ((r42 & 2048) == 0) goto L49;
        int r13 = i5.f();
    L51:
        if ((r42 & 4096) == 0) goto L53;
        int r14 = i5.h();
    L55:
        if ((r42 & 8192) == 0) goto L57;
        int r15 = i5.h();
    L59:
        if ((r42 & 16384) == 0) goto L61;
        boolean r8 = false;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        boolean r17 = false;
    L71:
        if ((r42 & 131072) == 0) goto L73;
        boolean r18 = false;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        int r19 = 0;
    L79:
        if ((r42 & 524288) == 0) goto L81;
        HashMap r0 = new HashMap();
    L82:
        this(r1, r2, r4, r3, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r8, r16, r17, r18, r19, r0);
        return;
    L81:
        r0 = r41;
        goto L82
    L77:
        r19 = r40;
        goto L79
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r8 = r36;
        goto L63
    L57:
        r15 = r35;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L45:
        r12 = r32;
        goto L47
    L41:
        r11 = r31;
        goto L43
    L37:
        r10 = r30;
        goto L39
    L33:
        r9 = r29;
        goto L35
    L29:
        r7 = r28;
        goto L31
    L21:
        r5 = r26;
        goto L23
    L13:
        r4 = r24;
        goto L15
    L9:
        r2 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L6
    }
}
