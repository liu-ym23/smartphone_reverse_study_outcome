package com.bytedance.ai.model.objects;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.utils.c;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kk.a;
import kn.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010?\u001a\u00020\u0003H\u0016J\u0006\u0010@\u001a\u00020\u0003J\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030BJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010T\u001a\u00020\u00112\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020WHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001eR\u001a\u0010<\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u0010>¨\u0006X"}, d2 = {"Lcom/bytedance/ai/model/objects/PageInfo;", "", "pageName", "", "pageData", "context", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "pageUrl", "pageType", "Lcom/bytedance/ai/model/objects/PageType;", "botId", "pageId", "pageSettings", "messageId", OpenPageMethod.KEY_POS, "", "alignLeft", "", "replyFor", "traceInfo", "", "packageName", "mcpName", "fullScreenRefresh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageType;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;DZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "getPageData", "setPageData", "(Ljava/lang/String;)V", "getContext", "()Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "getPageUrl", "setPageUrl", "getPageType", "()Lcom/bytedance/ai/model/objects/PageType;", "getBotId", "getPageId", "setPageId", "getPageSettings", "setPageSettings", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "getMessageId", "setMessageId", "getPos", "()D", "getAlignLeft", "()Z", "getReplyFor", "getTraceInfo", "()Ljava/util/Map;", "setTraceInfo", "(Ljava/util/Map;)V", "getPackageName", "setPackageName", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "isWidget", "setWidget", "(Z)V", "toString", "toViewContext", "buildMonitorEvent", "Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPageInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageInfo.kt\ncom/bytedance/ai/model/objects/PageInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageInfo copy$default(PageInfo r17, String r18, String r19, ReadableMap r20, String r21, PageType r22, String r23, String r24, ReadableMap r25, String r26, double r27, boolean r29, String r30, Map r31, String r32, String r33, String r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r5 = r17.pageName;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r10 = r17.pageData;
    L11:
        if ((r35 & 4) == 0) goto L13;
        ReadableMap r11 = r17.context;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r12 = r17.pageUrl;
    L19:
        if ((r35 & 16) == 0) goto L21;
        PageType r13 = r17.pageType;
    L23:
        if ((r35 & 32) == 0) goto L25;
        String r14 = r17.botId;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r15 = r17.pageId;
    L31:
        if ((r35 & 128) == 0) goto L33;
        ReadableMap r16 = r17.pageSettings;
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
        String r28 = r17.fullScreenRefresh;
    L67:
        return r17.copy(r5, r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, r37, r38, r116, r28);
    L65:
        r28 = r34;
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
        r16 = r25;
        goto L35
    L29:
        r15 = r24;
        goto L31
    L25:
        r14 = r23;
        goto L27
    L21:
        r13 = r22;
        goto L23
    L17:
        r12 = r21;
        goto L19
    L13:
        r11 = r20;
        goto L15
    L9:
        r10 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }

    public final HashMap<String, String> buildMonitorEvent() {
        HashMap<String, String> r5 = new HashMap();
        String r10 = this.messageId;
        if (r10 != null) goto L5;
    L7:
        r5.put("botId", this.botId);
        r5.put("viewType", this.pageType.toString());
        String r11 = this.pageName;
        if (r11 == null) goto L10;
        String r12 = r5.put("pagePath", r11);
    L10:
        return r5;
    L5:
        if (r10.length() <= 0) goto L7;
        r5.put("message_id", r10);
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

    public int hashCode() {
        String r5 = this.pageName;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.pageData;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        ReadableMap r16 = this.context;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.pageUrl;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = a.b(this.pageId, a.b(this.botId, (this.pageType.hashCode() + ((r18 + r20) * 31)) * 31, 31), 31);
        ReadableMap r22 = this.pageSettings;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.messageId;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = e.a((Double.hashCode(this.pos) + ((r24 + r26) * 31)) * 31, 31, this.alignLeft);
        String r28 = this.replyFor;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        Map<String, Object> r31 = this.traceInfo;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = a.b(this.packageName, (r30 + r32) * 31, 31);
        String r34 = this.mcpName;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.fullScreenRefresh;
        if (r37 == null) goto L43;
        r10 = r37.hashCode();
    L43:
        return r36 + r10;
    L37:
        r35 = r34.hashCode();
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final boolean isWidget() {
        return this.isWidget;
    }

    public final void setFullScreenRefresh(String r5) {
        this.fullScreenRefresh = r5;
    }

    public final void setMcpName(String r5) {
        this.mcpName = r5;
    }

    public final void setMessageId(String r5) {
        this.messageId = r5;
    }

    public final void setPackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.packageName = r5;
    }

    public final void setPageData(String r5) {
        this.pageData = r5;
    }

    public final void setPageId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.pageId = r5;
    }

    public final void setPageSettings(ReadableMap r5) {
        this.pageSettings = r5;
    }

    public final void setPageUrl(String r5) {
        this.pageUrl = r5;
    }

    public final void setTraceInfo(Map<String, Object> r5) {
        this.traceInfo = r5;
    }

    public final void setWidget(boolean r5) {
        this.isWidget = r5;
    }

    public String toString() {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "value");     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(z0.a.a().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        String r11 = (String) r10;
        if (r11 != null) goto L15;
        return "";
    L15:
        return r11;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String toViewContext() {
        Object r5 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        ReadableMap r11 = this.context;     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        HashMap<String, Object> r12 = r11.toHashMap();     // Catch: Throwable -> L6
    L9:
        Object r13 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r13) == false) goto L15;
        r13 = null;
    L15:
        HashMap r14 = (HashMap) r13;
        if (r14 != null) goto L19;
        r14 = new HashMap();
    L19:
        if (this.pageId.length() <= 0) goto L22;
        r14.put("viewId", this.pageId);
    L22:
        if (c.l(this.pageName) == false) goto L25;
        r14.put("pageName", this.pageName);
    L25:
        if (c.l(this.botId) == false) goto L28;
        r14.put("botId", this.botId);
    L28:
        if (c.l(this.messageId) == false) goto L31;
        r14.put("msgId", this.messageId);
    L31:
        if (c.l(this.replyFor) == false) goto L34;
        r14.put("replyFor", this.replyFor);
    L34:
        if (c.l(this.pageUrl) == false) goto L37;
        r14.put("pageUrl", this.pageUrl);
    L37:
        if (c.l(this.mcpName) == false) goto L39;
        r14.put("mcpName", this.mcpName);
    L39:
        ReadableMap r15 = this.pageSettings;
        if (r15 == null) goto L46;
        HashMap<String, Object> r16 = r15.toHashMap();
        if (r16 == null) goto L46;
        if (r16.isEmpty() == true) goto L46;
        r14.putAll(r16);
    L46:
        AtomicBoolean r17 = s0.a.f21798a;
        r14.put("lang", "zh");
        Intrinsics.checkNotNullParameter(r14, "value");     // Catch: Throwable -> L49
        Object r18 = Result.m124constructorimpl(z0.a.a().toJson(r14));     // Catch: Throwable -> L49
    L52:
        if (Result.m130isFailureimpl(r18) == true) goto L55;
        r5 = r18;
    L55:
        String r19 = (String) r5;
        if (r19 != null) goto L63;
        return "";
    L63:
        return r19;
    L49:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L52
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
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
