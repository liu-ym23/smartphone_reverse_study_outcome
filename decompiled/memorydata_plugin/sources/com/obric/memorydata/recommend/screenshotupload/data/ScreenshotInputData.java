package com.obric.memorydata.recommend.screenshotupload.data;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.recommend.useraction.recommend.a;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b9\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010P\u001a\u00020\u001aHÆ\u0003J\u0015\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cHÆ\u0003JÃ\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cHÆ\u0001J\u0013\u0010S\u001a\u00020\u001a2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020VHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010,R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010>\"\u0004\b?\u0010@R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006X"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotInputData;", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "timestamp", "", "triggerUploadType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "screenshot", "Landroid/graphics/Bitmap;", "heifScreenshotPath", "viewTreePath", "viewTree", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "touchAction", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "actionPosition", "Lcom/obric/memorydata/recommend/useraction/recommend/ActionPosition;", "actionEndPosition", "scrollDirection", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "isVertical", "", "extraMeta", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/hardware/HardwareBuffer;Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;Lcom/obric/memorydata/recommend/useraction/recommend/ActionPosition;Lcom/obric/memorydata/recommend/useraction/recommend/ActionPosition;Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;ZLjava/util/Map;)V", "getAppName", "()Ljava/lang/String;", "getPackageName", "getTimestamp", "()J", "getTriggerUploadType", "()Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getHeifScreenshotPath", "setHeifScreenshotPath", "(Ljava/lang/String;)V", "getViewTreePath", "setViewTreePath", "getViewTree", "()Ljava/util/List;", "setViewTree", "(Ljava/util/List;)V", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "setHardwareBuffer", "(Landroid/hardware/HardwareBuffer;)V", "getTouchAction", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "getActionPosition", "()Lcom/obric/memorydata/recommend/useraction/recommend/ActionPosition;", "getActionEndPosition", "getScrollDirection", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "()Z", "setVertical", "(Z)V", "getExtraMeta", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotInputData {
    private final a actionEndPosition;
    private final a actionPosition;
    private final String appName;
    private final Map<String, String> extraMeta;
    private transient HardwareBuffer hardwareBuffer;
    private String heifScreenshotPath;
    private boolean isVertical;
    private final String packageName;
    private transient Bitmap screenshot;
    private final ScreenTouchEvent.ScrollDirection scrollDirection;
    private final long timestamp;
    private final ScreenTouchEvent.TouchAction touchAction;
    private final TriggerUploadType triggerUploadType;
    private transient List<ViewTreeNode> viewTree;
    private String viewTreePath;

    public ScreenshotInputData(String r9, String r10, long r11, TriggerUploadType r13, Bitmap r14, String r15, String r16, List<ViewTreeNode> r17, HardwareBuffer r18, ScreenTouchEvent.TouchAction r19, a r20, a r21, ScreenTouchEvent.ScrollDirection r22, boolean r23, Map<String, String> r24) {
        List<ViewTreeNode> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "appName");
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r13, "triggerUploadType");
        Intrinsics.checkNotNullParameter(r5, "extraMeta");
        this.appName = r9;
        this.packageName = r10;
        this.timestamp = r11;
        this.triggerUploadType = r13;
        this.screenshot = r14;
        this.heifScreenshotPath = r15;
        this.viewTreePath = r16;
        this.viewTree = r4;
        this.hardwareBuffer = r18;
        this.touchAction = r19;
        this.actionPosition = r20;
        this.actionEndPosition = r21;
        this.scrollDirection = r22;
        this.isVertical = r23;
        this.extraMeta = r5;
    }

    public /* synthetic */ ScreenshotInputData(String r23, String r24, long r25, TriggerUploadType r27, Bitmap r28, String r29, String r30, List r31, HardwareBuffer r32, ScreenTouchEvent.TouchAction r33, a r34, a r35, ScreenTouchEvent.ScrollDirection r36, boolean r37, Map r38, int r39, DefaultConstructorMarker r40) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r38, Map.class, "com.obric.memorydata.plugin");
        if ((r39 & 16) == 0) goto L5;
        Bitmap r11 = null;
    L7:
        if ((r39 & 32) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r39 & 64) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r39 & 128) == 0) goto L17;
        List r14 = null;
    L19:
        if ((r39 & 256) == 0) goto L21;
        HardwareBuffer r15 = null;
    L23:
        if ((r39 & 512) == 0) goto L25;
        ScreenTouchEvent.TouchAction r16 = null;
    L27:
        if ((r39 & 1024) == 0) goto L29;
        a r17 = null;
    L31:
        if ((r39 & 2048) == 0) goto L33;
        a r18 = null;
    L35:
        if ((r39 & 4096) == 0) goto L37;
        ScreenTouchEvent.ScrollDirection r19 = null;
    L39:
        if ((r39 & 8192) == 0) goto L41;
        boolean r20 = false;
    L43:
        if ((r39 & 16384) == 0) goto L45;
        r2 = MapsKt.emptyMap();
    L45:
        this(r23, r24, r25, r27, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r2);
        return;
    L41:
        r20 = r37;
        goto L43
    L37:
        r19 = r36;
        goto L39
    L33:
        r18 = r35;
        goto L35
    L29:
        r17 = r34;
        goto L31
    L25:
        r16 = r33;
        goto L27
    L21:
        r15 = r32;
        goto L23
    L17:
        r14 = r1;
        goto L19
    L13:
        r13 = r30;
        goto L15
    L9:
        r12 = r29;
        goto L11
    L5:
        r11 = r28;
        goto L7
    }

    public static /* synthetic */ ScreenshotInputData copy$default(ScreenshotInputData r16, String r17, String r18, long r19, TriggerUploadType r21, Bitmap r22, String r23, String r24, List r25, HardwareBuffer r26, ScreenTouchEvent.TouchAction r27, a r28, a r29, ScreenTouchEvent.ScrollDirection r30, boolean r31, Map r32, int r33, Object r34) {
        List<ViewTreeNode> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.memorydata.plugin");
        if ((r33 & 1) == 0) goto L5;
        String r4 = r16.appName;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r5 = r16.packageName;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = r16.timestamp;
    L15:
        if ((r33 & 8) == 0) goto L17;
        TriggerUploadType r8 = r16.triggerUploadType;
    L19:
        if ((r33 & 16) == 0) goto L21;
        Bitmap r9 = r16.screenshot;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r10 = r16.heifScreenshotPath;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r11 = r16.viewTreePath;
    L31:
        if ((r33 & 128) == 0) goto L34;
        r2 = r16.viewTree;
    L34:
        if ((r33 & 256) == 0) goto L36;
        HardwareBuffer r12 = r16.hardwareBuffer;
    L38:
        if ((r33 & 512) == 0) goto L40;
        ScreenTouchEvent.TouchAction r13 = r16.touchAction;
    L42:
        if ((r33 & 1024) == 0) goto L44;
        a r14 = r16.actionPosition;
    L46:
        if ((r33 & 2048) == 0) goto L48;
        a r15 = r16.actionEndPosition;
    L50:
        if ((r33 & 4096) == 0) goto L52;
        ScreenTouchEvent.ScrollDirection r7 = r16.scrollDirection;
    L53:
        ScreenTouchEvent.ScrollDirection r35 = r7;
        if ((r33 & 8192) == 0) goto L56;
        boolean r20 = r16.isVertical;
    L58:
        if ((r33 & 16384) == 0) goto L60;
        Map<String, String> r1 = r16.extraMeta;
    L62:
        return r16.copy(r4, r5, r6, r8, r9, r10, r11, r2, r12, r13, r14, r15, r35, r20, r1);
    L60:
        r1 = r3;
        goto L62
    L56:
        r20 = r31;
        goto L58
    L52:
        r7 = r30;
        goto L53
    L48:
        r15 = r29;
        goto L50
    L44:
        r14 = r28;
        goto L46
    L40:
        r13 = r27;
        goto L42
    L36:
        r12 = r26;
        goto L38
    L29:
        r11 = r24;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public final String component1() {
        return this.appName;
    }

    public final ScreenTouchEvent.TouchAction component10() {
        return this.touchAction;
    }

    public final a component11() {
        return this.actionPosition;
    }

    public final a component12() {
        return this.actionEndPosition;
    }

    public final ScreenTouchEvent.ScrollDirection component13() {
        return this.scrollDirection;
    }

    public final boolean component14() {
        return this.isVertical;
    }

    public final Map<String, String> component15() {
        return this.extraMeta;
    }

    public final String component2() {
        return this.packageName;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final TriggerUploadType component4() {
        return this.triggerUploadType;
    }

    public final Bitmap component5() {
        return this.screenshot;
    }

    public final String component6() {
        return this.heifScreenshotPath;
    }

    public final String component7() {
        return this.viewTreePath;
    }

    public final List<ViewTreeNode> component8() {
        return this.viewTree;
    }

    public final HardwareBuffer component9() {
        return this.hardwareBuffer;
    }

    public final ScreenshotInputData copy(String r20, String r21, long r22, TriggerUploadType r24, Bitmap r25, String r26, String r27, List<ViewTreeNode> r28, HardwareBuffer r29, ScreenTouchEvent.TouchAction r30, a r31, a r32, ScreenTouchEvent.ScrollDirection r33, boolean r34, Map<String, String> r35) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "appName");
        Intrinsics.checkNotNullParameter(r21, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r24, "triggerUploadType");
        Intrinsics.checkNotNullParameter(r1, "extraMeta");
        return new ScreenshotInputData(r20, r21, r22, r24, r25, r26, r27, r0, r29, r30, r31, r32, r33, r34, r1);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ScreenshotInputData.class) == true) goto L8;
        return false;
    L8:
        ScreenshotInputData r10 = (ScreenshotInputData) ZeusTransformUtils.preCheckCast(r9, ScreenshotInputData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appName, r10.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r10.timestamp) goto L18;
        return false;
    L18:
        if (this.triggerUploadType == r10.triggerUploadType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.screenshot, r10.screenshot) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.heifScreenshotPath, r10.heifScreenshotPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.viewTreePath, r10.viewTreePath) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.viewTree, r10.viewTree) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.hardwareBuffer, r10.hardwareBuffer) == true) goto L36;
        return false;
    L36:
        if (this.touchAction == r10.touchAction) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.actionPosition, r10.actionPosition) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.actionEndPosition, r10.actionEndPosition) == true) goto L45;
        return false;
    L45:
        if (this.scrollDirection == r10.scrollDirection) goto L48;
        return false;
    L48:
        if (this.isVertical == r10.isVertical) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.extraMeta, r10.extraMeta) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final a getActionEndPosition() {
        return this.actionEndPosition;
    }

    public final a getActionPosition() {
        return this.actionPosition;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Map<String, String> getExtraMeta() {
        return this.extraMeta;
    }

    public final HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public final String getHeifScreenshotPath() {
        return this.heifScreenshotPath;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final ScreenTouchEvent.ScrollDirection getScrollDirection() {
        return this.scrollDirection;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ScreenTouchEvent.TouchAction getTouchAction() {
        return this.touchAction;
    }

    public final TriggerUploadType getTriggerUploadType() {
        return this.triggerUploadType;
    }

    public final List<ViewTreeNode> getViewTree() {
        return this.viewTree;
    }

    public final String getViewTreePath() {
        return this.viewTreePath;
    }

    public int hashCode() {
        int r0 = ((((((this.appName.hashCode() * 31) + this.packageName.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.triggerUploadType.hashCode()) * 31;
        Bitmap r1 = this.screenshot;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.heifScreenshotPath;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.viewTreePath;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<ViewTreeNode> r11 = this.viewTree;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        HardwareBuffer r14 = this.hardwareBuffer;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        ScreenTouchEvent.TouchAction r17 = this.touchAction;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        a r20 = this.actionPosition;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        a r23 = this.actionEndPosition;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        ScreenTouchEvent.ScrollDirection r26 = this.scrollDirection;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return ((((r25 + r2) * 31) + Boolean.hashCode(this.isVertical)) * 31) + this.extraMeta.hashCode();
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setHardwareBuffer(HardwareBuffer r1) {
        this.hardwareBuffer = r1;
    }

    public final void setHeifScreenshotPath(String r1) {
        this.heifScreenshotPath = r1;
    }

    public final void setScreenshot(Bitmap r1) {
        this.screenshot = r1;
    }

    public final void setVertical(boolean r1) {
        this.isVertical = r1;
    }

    public final void setViewTree(List<ViewTreeNode> r3) {
        this.viewTree = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setViewTreePath(String r1) {
        this.viewTreePath = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ScreenshotInputData(appName=").append(this.appName).append(", packageName=").append(this.packageName).append(", timestamp=").append(this.timestamp).append(", triggerUploadType=").append(this.triggerUploadType).append(", screenshot=").append(this.screenshot).append(", heifScreenshotPath=").append(this.heifScreenshotPath).append(", viewTreePath=").append(this.viewTreePath).append(", viewTree=").append(this.viewTree).append(", hardwareBuffer=").append(this.hardwareBuffer).append(", touchAction=").append(this.touchAction).append(", actionPosition=").append(this.actionPosition).append(", actionEndPosition=");
        r0.append(this.actionEndPosition).append(", scrollDirection=").append(this.scrollDirection).append(", isVertical=").append(this.isVertical).append(", extraMeta=").append(this.extraMeta).append(')');
        return r0.toString();
    }
}
