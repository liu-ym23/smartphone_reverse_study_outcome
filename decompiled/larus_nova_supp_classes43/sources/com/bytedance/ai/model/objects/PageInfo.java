package com.bytedance.ai.model.objects;

import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.utils.f;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import f2.b;
import h2.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010?\u001a\u00020\u0003H\u0016J\u0006\u0010@\u001a\u00020\u0003J\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030BJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010T\u001a\u00020\u00112\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020WHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001eR\u001a\u0010<\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u0010>¨\u0006X"}, d2 = {"Lcom/bytedance/ai/model/objects/PageInfo;", "", "pageName", "", "pageData", "context", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "pageUrl", "pageType", "Lcom/bytedance/ai/model/objects/PageType;", "botId", "pageId", "pageSettings", "messageId", "pos", "", "alignLeft", "", "replyFor", "traceInfo", "", "packageName", "mcpName", "fullScreenRefresh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageType;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;DZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "getPageData", "setPageData", "(Ljava/lang/String;)V", "getContext", "()Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "getPageUrl", "setPageUrl", "getPageType", "()Lcom/bytedance/ai/model/objects/PageType;", "getBotId", "getPageId", "setPageId", "getPageSettings", "setPageSettings", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "getMessageId", "setMessageId", "getPos", "()D", "getAlignLeft", "()Z", "getReplyFor", "getTraceInfo", "()Ljava/util/Map;", "setTraceInfo", "(Ljava/util/Map;)V", "getPackageName", "setPackageName", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "isWidget", "setWidget", "(Z)V", "toString", "toViewContext", "buildMonitorEvent", "Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageInfo {
    private final boolean alignLeft;
    private final String botId;
    private final ReadableMap context;
    private String fullScreenRefresh;
    private boolean isWidget;
    private String mcpName;
    private String messageId;
    private String packageName;
    private String pageData;
    private String pageId;
    private final String pageName;
    private ReadableMap pageSettings;
    private final PageType pageType;
    private String pageUrl;
    private final double pos;
    private final String replyFor;
    private Map<String, Object> traceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageInfo copy$default(PageInfo r17, String r18, String r19, ReadableMap r20, String r21, PageType r22, String r23, String r24, ReadableMap r25, String r26, double r27, boolean r29, String r30, Map r31, String r32, String r33, String r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r10 = r17.pageName;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r11 = r17.pageData;
    L11:
        if ((r35 & 4) == 0) goto L13;
        ReadableMap r12 = r17.context;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r13 = r17.pageUrl;
    L19:
        if ((r35 & 16) == 0) goto L21;
        PageType r14 = r17.pageType;
    L23:
        if ((r35 & 32) == 0) goto L25;
        String r15 = r17.botId;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r16 = r17.pageId;
    L31:
        if ((r35 & 128) == 0) goto L33;
        ReadableMap r28 = r17.pageSettings;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r110 = r17.messageId;
    L39:
        if ((r35 & 512) == 0) goto L41;
        double r111 = r17.pos;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        boolean r112 = r17.alignLeft;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r113 = r17.replyFor;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        Map r114 = r17.traceInfo;
    L54:
        Map r37 = r114;
        if ((r35 & 8192) == 0) goto L57;
        String r115 = r17.packageName;
    L58:
        String r38 = r115;
        if ((r35 & 16384) == 0) goto L61;
        String r116 = r17.mcpName;
    L63:
        if ((r35 & 32768) == 0) goto L65;
        String r1 = r17.fullScreenRefresh;
    L67:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r28, r110, r111, r112, r113, r37, r38, r116, r1);
    L65:
        r1 = r34;
        goto L67
    L61:
        r116 = r33;
        goto L63
    L57:
        r115 = r32;
        goto L58
    L53:
        r114 = r31;
        goto L54
    L49:
        r113 = r30;
        goto L51
    L45:
        r112 = r29;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L37:
        r110 = r26;
        goto L39
    L33:
        r28 = r25;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final String component1() {
        return this.pageName;
    }

    public final double component10() {
        return this.pos;
    }

    public final boolean component11() {
        return this.alignLeft;
    }

    public final String component12() {
        return this.replyFor;
    }

    public final Map<String, Object> component13() {
        return this.traceInfo;
    }

    public final String component14() {
        return this.packageName;
    }

    public final String component15() {
        return this.mcpName;
    }

    public final String component16() {
        return this.fullScreenRefresh;
    }

    public final String component2() {
        return this.pageData;
    }

    public final ReadableMap component3() {
        return this.context;
    }

    public final String component4() {
        return this.pageUrl;
    }

    public final PageType component5() {
        return this.pageType;
    }

    public final String component6() {
        return this.botId;
    }

    public final String component7() {
        return this.pageId;
    }

    public final ReadableMap component8() {
        return this.pageSettings;
    }

    public final String component9() {
        return this.messageId;
    }

    public final PageInfo copy(String r20, String r21, ReadableMap r22, String r23, PageType r24, String r25, String r26, ReadableMap r27, String r28, double r29, boolean r31, String r32, Map<String, Object> r33, String r34, String r35, String r36) {
        Intrinsics.checkNotNullParameter(r24, "pageType");
        Intrinsics.checkNotNullParameter(r25, "botId");
        Intrinsics.checkNotNullParameter(r26, "pageId");
        Intrinsics.checkNotNullParameter(r34, "packageName");
        return new PageInfo(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PageInfo) == true) goto L8;
        return false;
    L8:
        PageInfo r11 = (PageInfo) r10;
        if (Intrinsics.areEqual(this.pageName, r11.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageData, r11.pageData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.context, r11.context) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageUrl, r11.pageUrl) == true) goto L21;
        return false;
    L21:
        if (this.pageType == r11.pageType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r11.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pageId, r11.pageId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageSettings, r11.pageSettings) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L36;
        return false;
    L36:
        if (Double.compare(this.pos, r11.pos) == 0) goto L39;
        return false;
    L39:
        if (this.alignLeft == r11.alignLeft) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.replyFor, r11.replyFor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.traceInfo, r11.traceInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.mcpName, r11.mcpName) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.fullScreenRefresh, r11.fullScreenRefresh) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.pageName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.pageData;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        ReadableMap r15 = this.context;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.pageUrl;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (((((((r17 + r19) * 31) + this.pageType.hashCode()) * 31) + this.botId.hashCode()) * 31) + this.pageId.hashCode()) * 31;
        ReadableMap r21 = this.pageSettings;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.messageId;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        long r27 = Double.doubleToLongBits(this.pos);
        int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
        if (this.alignLeft == false) goto L29;
        int r29 = 1231;
    L30:
        int r30 = (r28 + r29) * 31;
        String r31 = this.replyFor;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = (r30 + r32) * 31;
        Map<String, Object> r34 = this.traceInfo;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (((r33 + r35) * 31) + this.packageName.hashCode()) * 31;
        String r37 = this.mcpName;
        if (r37 != null) goto L41;
        int r38 = 0;
    L42:
        int r39 = (r36 + r38) * 31;
        String r40 = this.fullScreenRefresh;
        if (r40 == null) goto L47;
        r1 = r40.hashCode();
    L47:
        return r39 + r1;
    L41:
        r38 = r37.hashCode();
        goto L42
    L37:
        r35 = r34.hashCode();
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = 1237;
        goto L30
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toViewContext() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ReadableMap r10 = this.context;     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        HashMap r11 = r10.toHashMap();     // Catch: Throwable -> L9
    L7:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r12) == false) goto L14;
        r12 = null;
    L14:
        HashMap r13 = (HashMap) r12;
        if (r13 != null) goto L18;
        r13 = new HashMap();
    L18:
        if (this.pageId.length() <= 0) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L24;
        r13.put("viewId", this.pageId);
    L24:
        if (f.g(this.pageName) == false) goto L27;
        r13.put("pageName", this.pageName);
    L27:
        if (f.g(this.botId) == false) goto L30;
        r13.put("botId", this.botId);
    L30:
        if (f.g(this.messageId) == false) goto L33;
        r13.put("msgId", this.messageId);
    L33:
        if (f.g(this.replyFor) == false) goto L36;
        r13.put("replyFor", this.replyFor);
    L36:
        if (f.g(this.pageUrl) == false) goto L39;
        r13.put("pageUrl", this.pageUrl);
    L39:
        if (f.g(this.mcpName) == false) goto L41;
        r13.put("mcpName", this.mcpName);
    L41:
        ReadableMap r15 = this.pageSettings;
        if (r15 == null) goto L48;
        HashMap r16 = r15.toHashMap();
        if (r16 == null) goto L48;
        if ((true ^ r16.isEmpty()) == false) goto L48;
        r13.putAll(r16);
    L48:
        a r17 = b.c;
        if (r17 == null) goto L52;
        String r18 = r17.r;
        if (r18 == null) goto L52;
    L53:
        r13.put("lang", r18);
        Object r19 = Result.constructor-impl(e.c(r13));     // Catch: Throwable -> L56
    L59:
        if (Result.isFailure-impl(r19) == true) goto L62;
        r0 = r19;
    L62:
        String r20 = (String) r0;
        if (r20 != null) goto L70;
        return "";
    L70:
        return r20;
    L56:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L52:
        r18 = "zh";
        goto L53
    L20:
        r14 = false;
        goto L21
    L6:
        r11 = null;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final HashMap<String, String> buildMonitorEvent() {
        HashMap<String, String> r0 = new HashMap();
        String r1 = this.messageId;
        if (r1 != null) goto L5;
    L10:
        r0.put("botId", this.botId);
        r0.put("viewType", this.pageType.toString());
        String r10 = this.pageName;
        if (r10 == null) goto L13;
        String r11 = r0.put("pagePath", r10);
    L13:
        return r0;
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        r0.put("message_id", r1);
        goto L10
    L7:
        r12 = false;
        goto L8
    }

    public String toString() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(e.c(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r10 = (String) r1;
        if (r10 != null) goto L15;
        return "";
    L15:
        return r10;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean getAlignLeft() {
        return this.alignLeft;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final ReadableMap getContext() {
        return this.context;
    }

    public final String getFullScreenRefresh() {
        return this.fullScreenRefresh;
    }

    public final String getMcpName() {
        return this.mcpName;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPageData() {
        return this.pageData;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final ReadableMap getPageSettings() {
        return this.pageSettings;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final double getPos() {
        return this.pos;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public final boolean isWidget() {
        return this.isWidget;
    }

    public final void setFullScreenRefresh(String r1) {
        this.fullScreenRefresh = r1;
    }

    public final void setMcpName(String r1) {
        this.mcpName = r1;
    }

    public final void setMessageId(String r1) {
        this.messageId = r1;
    }

    public final void setPackageName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.packageName = r10;
    }

    public final void setPageData(String r1) {
        this.pageData = r1;
    }

    public final void setPageId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageId = r10;
    }

    public final void setPageSettings(ReadableMap r1) {
        this.pageSettings = r1;
    }

    public final void setPageUrl(String r1) {
        this.pageUrl = r1;
    }

    public final void setTraceInfo(Map<String, Object> r1) {
        this.traceInfo = r1;
    }

    public final void setWidget(boolean r1) {
        this.isWidget = r1;
    }

    public PageInfo(String r10, String r11, ReadableMap r12, String r13, PageType r14, String r15, String r16, ReadableMap r17, String r18, double r19, boolean r110, String r111, Map<String, Object> r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r14, "pageType");
        Intrinsics.checkNotNullParameter(r15, "botId");
        Intrinsics.checkNotNullParameter(r16, "pageId");
        Intrinsics.checkNotNullParameter(r21, "packageName");
        this.pageName = r10;
        this.pageData = r11;
        this.context = r12;
        this.pageUrl = r13;
        this.pageType = r14;
        this.botId = r15;
        this.pageId = r16;
        this.pageSettings = r17;
        this.messageId = r18;
        this.pos = r19;
        this.alignLeft = r110;
        this.replyFor = r111;
        this.traceInfo = r20;
        this.packageName = r21;
        this.mcpName = r22;
        this.fullScreenRefresh = r23;
    }

    public /* synthetic */ PageInfo(String r22, String r23, ReadableMap r24, String r25, PageType r26, String r27, String r28, ReadableMap r29, String r30, double r31, boolean r33, String r34, Map r35, String r36, String r37, String r38, int r39, DefaultConstructorMarker r40) {
        if ((r39 & 64) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r39 & 128) == 0) goto L9;
        ReadableMap r11 = null;
    L11:
        if ((r39 & 256) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r39 & 512) == 0) goto L17;
        double r13 = 0.5d;
    L19:
        if ((r39 & 1024) == 0) goto L21;
        boolean r15 = false;
    L23:
        if ((r39 & 2048) == 0) goto L25;
        String r16 = null;
    L27:
        if ((r39 & 4096) == 0) goto L29;
        Map r17 = null;
    L31:
        if ((r39 & 8192) == 0) goto L33;
        String r18 = "";
    L35:
        if ((r39 & 16384) == 0) goto L37;
        String r19 = null;
    L39:
        if ((r39 & 32768) == 0) goto L41;
        String r20 = null;
    L42:
        this(r22, r23, r24, r25, r26, r27, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20);
        return;
    L41:
        r20 = r38;
        goto L42
    L37:
        r19 = r37;
        goto L39
    L33:
        r18 = r36;
        goto L35
    L29:
        r17 = r35;
        goto L31
    L25:
        r16 = r34;
        goto L27
    L21:
        r15 = r33;
        goto L23
    L17:
        r13 = r31;
        goto L19
    L13:
        r12 = r30;
        goto L15
    L9:
        r11 = r29;
        goto L11
    L5:
        r10 = r28;
        goto L7
    }
}
