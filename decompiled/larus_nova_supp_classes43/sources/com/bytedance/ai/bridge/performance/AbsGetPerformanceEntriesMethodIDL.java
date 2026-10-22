package com.bytedance.ai.bridge.performance;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesParamModel;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "GetPerformanceEntriesParamModel", "GetPerformanceEntriesResultModel", "PerformanceEntry", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetPerformanceEntriesMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010,JÔ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0014\u0010,¨\u0006F"}, d2 = {"Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$PerformanceEntry;", "", "entryType", "", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "startTime", "", com.bytedance.android.ec.core.event.a.KEY_DURATION, "path", "navigationStart", "navigationType", "moduleName", "viewLayerRenderStartTime", "viewLayerRenderEndTime", "pageId", "referrerPath", "referrerPageId", "viewLayerReadyTime", "widgetId", "widgetInstanceId", "isAppColdLaunch", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEntryType", "()Ljava/lang/String;", "getName", "getStartTime", "()J", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPath", "getNavigationStart", "getNavigationType", "getModuleName", "getViewLayerRenderStartTime", "getViewLayerRenderEndTime", "getPageId", "getReferrerPath", "getReferrerPageId", "getViewLayerReadyTime", "getWidgetId", "getWidgetInstanceId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$PerformanceEntry;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PerformanceEntry {

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DURATION)
        private final Long duration;

        @SerializedName("entryType")
        private final String entryType;

        @SerializedName("isAppColdLaunch")
        private final Boolean isAppColdLaunch;

        @SerializedName("moduleName")
        private final String moduleName;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME)
        private final String name;

        @SerializedName("navigationStart")
        private final Long navigationStart;

        @SerializedName("navigationType")
        private final String navigationType;

        @SerializedName("pageId")
        private final Long pageId;

        @SerializedName("path")
        private final String path;

        @SerializedName("referrerPageId")
        private final Long referrerPageId;

        @SerializedName("referrerPath")
        private final String referrerPath;

        @SerializedName("startTime")
        private final long startTime;

        @SerializedName("viewLayerReadyTime")
        private final Long viewLayerReadyTime;

        @SerializedName("viewLayerRenderEndTime")
        private final Long viewLayerRenderEndTime;

        @SerializedName("viewLayerRenderStartTime")
        private final Long viewLayerRenderStartTime;

        @SerializedName("widgetId")
        private final String widgetId;

        @SerializedName("widgetInstanceId")
        private final String widgetInstanceId;

        public static /* synthetic */ PerformanceEntry copy$default(PerformanceEntry r17, String r18, String r19, long r20, Long r22, String r23, Long r24, String r25, String r26, Long r27, Long r28, Long r29, String r30, Long r31, Long r32, String r33, String r34, Boolean r35, int r36, Object r37) {
            if ((r36 & 1) == 0) goto L5;
            String r10 = r17.entryType;
        L7:
            if ((r36 & 2) == 0) goto L9;
            String r11 = r17.name;
        L11:
            if ((r36 & 4) == 0) goto L13;
            long r12 = r17.startTime;
        L15:
            if ((r36 & 8) == 0) goto L17;
            Long r13 = r17.duration;
        L19:
            if ((r36 & 16) == 0) goto L21;
            String r14 = r17.path;
        L23:
            if ((r36 & 32) == 0) goto L25;
            Long r15 = r17.navigationStart;
        L27:
            if ((r36 & 64) == 0) goto L29;
            String r16 = r17.navigationType;
        L31:
            if ((r36 & 128) == 0) goto L33;
            String r110 = r17.moduleName;
        L35:
            if ((r36 & 256) == 0) goto L37;
            Long r111 = r17.viewLayerRenderStartTime;
        L39:
            if ((r36 & 512) == 0) goto L41;
            Long r112 = r17.viewLayerRenderEndTime;
        L43:
            if ((r36 & 1024) == 0) goto L45;
            Long r113 = r17.pageId;
        L47:
            if ((r36 & 2048) == 0) goto L49;
            String r114 = r17.referrerPath;
        L51:
            if ((r36 & 4096) == 0) goto L53;
            Long r115 = r17.referrerPageId;
        L54:
            Long r38 = r115;
            if ((r36 & 8192) == 0) goto L57;
            Long r116 = r17.viewLayerReadyTime;
        L58:
            Long r39 = r116;
            if ((r36 & 16384) == 0) goto L61;
            String r117 = r17.widgetId;
        L62:
            String r310 = r117;
            if ((r36 & 32768) == 0) goto L65;
            String r118 = r17.widgetInstanceId;
        L67:
            if ((r36 & 65536) == 0) goto L69;
            Boolean r1 = r17.isAppColdLaunch;
        L71:
            return r17.copy(r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, r114, r38, r39, r310, r118, r1);
        L69:
            r1 = r35;
            goto L71
        L65:
            r118 = r34;
            goto L67
        L61:
            r117 = r33;
            goto L62
        L57:
            r116 = r32;
            goto L58
        L53:
            r115 = r31;
            goto L54
        L49:
            r114 = r30;
            goto L51
        L45:
            r113 = r29;
            goto L47
        L41:
            r112 = r28;
            goto L43
        L37:
            r111 = r27;
            goto L39
        L33:
            r110 = r26;
            goto L35
        L29:
            r16 = r25;
            goto L31
        L25:
            r15 = r24;
            goto L27
        L21:
            r14 = r23;
            goto L23
        L17:
            r13 = r22;
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
            return this.entryType;
        }

        public final Long component10() {
            return this.viewLayerRenderEndTime;
        }

        public final Long component11() {
            return this.pageId;
        }

        public final String component12() {
            return this.referrerPath;
        }

        public final Long component13() {
            return this.referrerPageId;
        }

        public final Long component14() {
            return this.viewLayerReadyTime;
        }

        public final String component15() {
            return this.widgetId;
        }

        public final String component16() {
            return this.widgetInstanceId;
        }

        public final Boolean component17() {
            return this.isAppColdLaunch;
        }

        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.startTime;
        }

        public final Long component4() {
            return this.duration;
        }

        public final String component5() {
            return this.path;
        }

        public final Long component6() {
            return this.navigationStart;
        }

        public final String component7() {
            return this.navigationType;
        }

        public final String component8() {
            return this.moduleName;
        }

        public final Long component9() {
            return this.viewLayerRenderStartTime;
        }

        public final PerformanceEntry copy(String r22, String r23, long r24, Long r26, String r27, Long r28, String r29, String r30, Long r31, Long r32, Long r33, String r34, Long r35, Long r36, String r37, String r38, Boolean r39) {
            Intrinsics.checkNotNullParameter(r22, "entryType");
            Intrinsics.checkNotNullParameter(r23, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            return new PerformanceEntry(r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof PerformanceEntry) == true) goto L8;
            return false;
        L8:
            PerformanceEntry r11 = (PerformanceEntry) r10;
            if (Intrinsics.areEqual(this.entryType, r11.entryType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L15;
            return false;
        L15:
            if (this.startTime == r11.startTime) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.duration, r11.duration) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.path, r11.path) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.navigationStart, r11.navigationStart) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.navigationType, r11.navigationType) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.moduleName, r11.moduleName) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.viewLayerRenderStartTime, r11.viewLayerRenderStartTime) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.viewLayerRenderEndTime, r11.viewLayerRenderEndTime) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.pageId, r11.pageId) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.referrerPath, r11.referrerPath) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.referrerPageId, r11.referrerPageId) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.viewLayerReadyTime, r11.viewLayerReadyTime) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.widgetInstanceId, r11.widgetInstanceId) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.isAppColdLaunch, r11.isAppColdLaunch) == true) goto L59;
            return false;
        L59:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.entryType.hashCode() * 31) + this.name.hashCode()) * 31;
            long r1 = this.startTime;
            int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            Long r11 = this.duration;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.path;
            if (r15 != null) goto L9;
            int r16 = 0;
        L10:
            int r17 = (r14 + r16) * 31;
            Long r18 = this.navigationStart;
            if (r18 != null) goto L13;
            int r19 = 0;
        L14:
            int r20 = (r17 + r19) * 31;
            String r21 = this.navigationType;
            if (r21 != null) goto L17;
            int r22 = 0;
        L18:
            int r23 = (r20 + r22) * 31;
            String r24 = this.moduleName;
            if (r24 != null) goto L21;
            int r25 = 0;
        L22:
            int r26 = (r23 + r25) * 31;
            Long r27 = this.viewLayerRenderStartTime;
            if (r27 != null) goto L25;
            int r28 = 0;
        L26:
            int r29 = (r26 + r28) * 31;
            Long r30 = this.viewLayerRenderEndTime;
            if (r30 != null) goto L29;
            int r31 = 0;
        L30:
            int r32 = (r29 + r31) * 31;
            Long r33 = this.pageId;
            if (r33 != null) goto L33;
            int r34 = 0;
        L34:
            int r35 = (r32 + r34) * 31;
            String r36 = this.referrerPath;
            if (r36 != null) goto L37;
            int r37 = 0;
        L38:
            int r38 = (r35 + r37) * 31;
            Long r39 = this.referrerPageId;
            if (r39 != null) goto L41;
            int r40 = 0;
        L42:
            int r41 = (r38 + r40) * 31;
            Long r42 = this.viewLayerReadyTime;
            if (r42 != null) goto L45;
            int r43 = 0;
        L46:
            int r44 = (r41 + r43) * 31;
            String r45 = this.widgetId;
            if (r45 != null) goto L49;
            int r46 = 0;
        L50:
            int r47 = (r44 + r46) * 31;
            String r48 = this.widgetInstanceId;
            if (r48 != null) goto L53;
            int r49 = 0;
        L54:
            int r50 = (r47 + r49) * 31;
            Boolean r51 = this.isAppColdLaunch;
            if (r51 == null) goto L59;
            r12 = r51.hashCode();
        L59:
            return r50 + r12;
        L53:
            r49 = r48.hashCode();
            goto L54
        L49:
            r46 = r45.hashCode();
            goto L50
        L45:
            r43 = r42.hashCode();
            goto L46
        L41:
            r40 = r39.hashCode();
            goto L42
        L37:
            r37 = r36.hashCode();
            goto L38
        L33:
            r34 = r33.hashCode();
            goto L34
        L29:
            r31 = r30.hashCode();
            goto L30
        L25:
            r28 = r27.hashCode();
            goto L26
        L21:
            r25 = r24.hashCode();
            goto L22
        L17:
            r22 = r21.hashCode();
            goto L18
        L13:
            r19 = r18.hashCode();
            goto L14
        L9:
            r16 = r15.hashCode();
            goto L10
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "PerformanceEntry(entryType=" + this.entryType + ", name=" + this.name + ", startTime=" + this.startTime + ", duration=" + this.duration + ", path=" + this.path + ", navigationStart=" + this.navigationStart + ", navigationType=" + this.navigationType + ", moduleName=" + this.moduleName + ", viewLayerRenderStartTime=" + this.viewLayerRenderStartTime + ", viewLayerRenderEndTime=" + this.viewLayerRenderEndTime + ", pageId=" + this.pageId + ", referrerPath=" + this.referrerPath + ", referrerPageId=" + this.referrerPageId + ", viewLayerReadyTime=" + this.viewLayerReadyTime + ", widgetId=" + this.widgetId + ", widgetInstanceId=" + this.widgetInstanceId + ", isAppColdLaunch=" + this.isAppColdLaunch + ')';
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getEntryType() {
            return this.entryType;
        }

        public final String getModuleName() {
            return this.moduleName;
        }

        public final String getName() {
            return this.name;
        }

        public final Long getNavigationStart() {
            return this.navigationStart;
        }

        public final String getNavigationType() {
            return this.navigationType;
        }

        public final Long getPageId() {
            return this.pageId;
        }

        public final String getPath() {
            return this.path;
        }

        public final Long getReferrerPageId() {
            return this.referrerPageId;
        }

        public final String getReferrerPath() {
            return this.referrerPath;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final Long getViewLayerReadyTime() {
            return this.viewLayerReadyTime;
        }

        public final Long getViewLayerRenderEndTime() {
            return this.viewLayerRenderEndTime;
        }

        public final Long getViewLayerRenderStartTime() {
            return this.viewLayerRenderStartTime;
        }

        public final String getWidgetId() {
            return this.widgetId;
        }

        public final String getWidgetInstanceId() {
            return this.widgetInstanceId;
        }

        public final Boolean isAppColdLaunch() {
            return this.isAppColdLaunch;
        }

        public PerformanceEntry(String r10, String r11, long r12, Long r13, String r14, Long r15, String r16, String r17, Long r18, Long r19, Long r110, String r111, Long r112, Long r113, String r20, String r21, Boolean r22) {
            Intrinsics.checkNotNullParameter(r10, "entryType");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            this.entryType = r10;
            this.name = r11;
            this.startTime = r12;
            this.duration = r13;
            this.path = r14;
            this.navigationStart = r15;
            this.navigationType = r16;
            this.moduleName = r17;
            this.viewLayerRenderStartTime = r18;
            this.viewLayerRenderEndTime = r19;
            this.pageId = r110;
            this.referrerPath = r111;
            this.referrerPageId = r112;
            this.viewLayerReadyTime = r113;
            this.widgetId = r20;
            this.widgetInstanceId = r21;
            this.isAppColdLaunch = r22;
        }

        public /* synthetic */ PerformanceEntry(String r23, String r24, long r25, Long r27, String r28, Long r29, String r30, String r31, Long r32, Long r33, Long r34, String r35, Long r36, Long r37, String r38, String r39, Boolean r40, int r41, DefaultConstructorMarker r42) {
            if ((r41 & 8) == 0) goto L5;
            Long r10 = null;
        L7:
            if ((r41 & 16) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r41 & 32) == 0) goto L13;
            Long r12 = null;
        L15:
            if ((r41 & 64) == 0) goto L17;
            String r13 = null;
        L19:
            if ((r41 & 128) == 0) goto L21;
            String r14 = null;
        L23:
            if ((r41 & 256) == 0) goto L25;
            Long r15 = null;
        L27:
            if ((r41 & 512) == 0) goto L29;
            Long r16 = null;
        L31:
            if ((r41 & 1024) == 0) goto L33;
            Long r17 = null;
        L35:
            if ((r41 & 2048) == 0) goto L37;
            String r18 = null;
        L39:
            if ((r41 & 4096) == 0) goto L41;
            Long r19 = null;
        L43:
            if ((r41 & 8192) == 0) goto L45;
            Long r110 = null;
        L47:
            if ((r41 & 16384) == 0) goto L49;
            String r111 = null;
        L51:
            if ((32768 & r41) == 0) goto L53;
            String r20 = null;
        L55:
            if ((r41 & 65536) == 0) goto L57;
            Boolean r21 = null;
        L58:
            this(r23, r24, r25, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21);
            return;
        L57:
            r21 = r40;
            goto L58
        L53:
            r20 = r39;
            goto L55
        L49:
            r111 = r38;
            goto L51
        L45:
            r110 = r37;
            goto L47
        L41:
            r19 = r36;
            goto L43
        L37:
            r18 = r35;
            goto L39
        L33:
            r17 = r34;
            goto L35
        L29:
            r16 = r33;
            goto L31
        L25:
            r15 = r32;
            goto L27
        L21:
            r14 = r31;
            goto L23
        L17:
            r13 = r30;
            goto L19
        L13:
            r12 = r29;
            goto L15
        L9:
            r11 = r28;
            goto L11
        L5:
            r10 = r27;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "entryType", required = false)
        String getEntryType();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, required = false)
        String getName();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "entries", required = true)
        void setEntries(List<PerformanceEntry> r1);
    }

    public AbsGetPerformanceEntriesMethodIDL() {
        this.a = "doubao.getPerformanceEntries";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
