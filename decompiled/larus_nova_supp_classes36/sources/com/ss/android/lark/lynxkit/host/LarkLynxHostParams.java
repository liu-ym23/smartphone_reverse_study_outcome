package com.ss.android.lark.lynxkit.host;

import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b(\u0010)J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0017\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\t\u0010X\u001a\u00020\fHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010g\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010h\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010HJ\t\u0010i\u001a\u00020\fHÆ\u0003J\t\u0010j\u001a\u00020\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jø\u0002\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\f2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020\nHÖ\u0001J\t\u0010t\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bB\u00105R\u0011\u0010\u001a\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0011\u0010 \u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010+R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010+¨\u0006u"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "", "templateUrl", "", "templatePath", "initDataJson", "initDataMap", "", "lynxViewShareData", "containerBackgroundColor", "", "showLoading", "", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "tagForJsContext", "tagForCustomComponent", "tagForGlobalData", "tagForBridgeMethodDispatcher", "tagForBridgeMethodGroup", "tagForJSModule", "tagForTemplateLoader", "devToolSocketUrl", "enableDevToolsDebug", "enableUserCodeCache", "codeCacheSourceUrl", "widthMeasureSpec", "heightMeasureSpec", "fontScale", "", "enableAsyncRender", "enableAsyncRenderForList", "tagForBridgeProtocol", "bridgeRuntimeFactory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "bridgeProtocol", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "bridgeProtocolContainerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZLandroid/view/ViewGroup$LayoutParams;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;ZZLjava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;Ljava/lang/String;)V", "getTemplateUrl", "()Ljava/lang/String;", "getTemplatePath", "getInitDataJson", "getInitDataMap", "()Ljava/util/Map;", "getLynxViewShareData", "getContainerBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowLoading", "()Z", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "getTagForJsContext", "getTagForCustomComponent", "getTagForGlobalData", "getTagForBridgeMethodDispatcher", "getTagForBridgeMethodGroup", "getTagForJSModule", "getTagForTemplateLoader", "getDevToolSocketUrl", "getEnableDevToolsDebug", "getEnableUserCodeCache", "getCodeCacheSourceUrl", "getWidthMeasureSpec", "getHeightMeasureSpec", "getFontScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEnableAsyncRender", "getEnableAsyncRenderForList", "getTagForBridgeProtocol", "getBridgeRuntimeFactory", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "getBridgeProtocol", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "getBridgeProtocolContainerId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZLandroid/view/ViewGroup$LayoutParams;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;ZZLjava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;Ljava/lang/String;)Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxHostParams {
    private final ILarkLynxBridgeProtocol bridgeProtocol;
    private final String bridgeProtocolContainerId;
    private final ILarkLynxBridgeRuntimeFactory bridgeRuntimeFactory;
    private final String codeCacheSourceUrl;
    private final Integer containerBackgroundColor;
    private final ILynxContainerContext containerContext;
    private final String devToolSocketUrl;
    private final boolean enableAsyncRender;
    private final boolean enableAsyncRenderForList;
    private final boolean enableDevToolsDebug;
    private final boolean enableUserCodeCache;
    private final Float fontScale;
    private final Integer heightMeasureSpec;
    private final String initDataJson;
    private final Map<String, Object> initDataMap;
    private final ViewGroup.LayoutParams layoutParams;
    private final Map<String, Object> lynxViewShareData;
    private final boolean showLoading;
    private final String tagForBridgeMethodDispatcher;
    private final String tagForBridgeMethodGroup;
    private final String tagForBridgeProtocol;
    private final String tagForCustomComponent;
    private final String tagForGlobalData;
    private final String tagForJSModule;
    private final String tagForJsContext;
    private final String tagForTemplateLoader;
    private final String templatePath;
    private final String templateUrl;
    private final Integer widthMeasureSpec;

    public LarkLynxHostParams() {
        this(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, false, false, null, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkLynxHostParams copy$default(LarkLynxHostParams r17, String r18, String r19, String r20, Map r21, Map r22, Integer r23, boolean r24, ViewGroup.LayoutParams r25, ILynxContainerContext r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, boolean r35, boolean r36, String r37, Integer r38, Integer r39, Float r40, boolean r41, boolean r42, String r43, ILarkLynxBridgeRuntimeFactory r44, ILarkLynxBridgeProtocol r45, String r46, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        String r2 = r17.templateUrl;
    L7:
        if ((r47 & 2) == 0) goto L9;
        String r3 = r17.templatePath;
    L11:
        if ((r47 & 4) == 0) goto L13;
        String r4 = r17.initDataJson;
    L15:
        if ((r47 & 8) == 0) goto L17;
        Map r5 = r17.initDataMap;
    L19:
        if ((r47 & 16) == 0) goto L21;
        Map r6 = r17.lynxViewShareData;
    L23:
        if ((r47 & 32) == 0) goto L25;
        Integer r7 = r17.containerBackgroundColor;
    L27:
        if ((r47 & 64) == 0) goto L29;
        boolean r8 = r17.showLoading;
    L31:
        if ((r47 & 128) == 0) goto L33;
        ViewGroup.LayoutParams r9 = r17.layoutParams;
    L35:
        if ((r47 & 256) == 0) goto L37;
        ILynxContainerContext r10 = r17.containerContext;
    L39:
        if ((r47 & 512) == 0) goto L41;
        String r11 = r17.tagForJsContext;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        String r12 = r17.tagForCustomComponent;
    L47:
        if ((r47 & 2048) == 0) goto L49;
        String r13 = r17.tagForGlobalData;
    L51:
        if ((r47 & 4096) == 0) goto L53;
        String r14 = r17.tagForBridgeMethodDispatcher;
    L55:
        if ((r47 & 8192) == 0) goto L57;
        String r15 = r17.tagForBridgeMethodGroup;
    L58:
        String r310 = r15;
        if ((r47 & 16384) == 0) goto L61;
        String r16 = r17.tagForJSModule;
    L62:
        String r311 = r16;
        if ((r47 & 32768) == 0) goto L65;
        String r110 = r17.tagForTemplateLoader;
    L66:
        String r312 = r110;
        if ((r47 & 65536) == 0) goto L69;
        String r111 = r17.devToolSocketUrl;
    L70:
        String r313 = r111;
        if ((r47 & 131072) == 0) goto L73;
        boolean r112 = r17.enableDevToolsDebug;
    L74:
        boolean r314 = r112;
        if ((r47 & 262144) == 0) goto L77;
        boolean r113 = r17.enableUserCodeCache;
    L78:
        boolean r315 = r113;
        if ((r47 & 524288) == 0) goto L81;
        String r114 = r17.codeCacheSourceUrl;
    L82:
        String r316 = r114;
        if ((r47 & 1048576) == 0) goto L85;
        Integer r115 = r17.widthMeasureSpec;
    L86:
        Integer r317 = r115;
        if ((r47 & 2097152) == 0) goto L89;
        Integer r116 = r17.heightMeasureSpec;
    L90:
        Integer r318 = r116;
        if ((r47 & 4194304) == 0) goto L93;
        Float r117 = r17.fontScale;
    L94:
        Float r49 = r117;
        if ((r47 & 8388608) == 0) goto L97;
        boolean r118 = r17.enableAsyncRender;
    L98:
        boolean r410 = r118;
        if ((r47 & 16777216) == 0) goto L101;
        boolean r119 = r17.enableAsyncRenderForList;
    L102:
        boolean r411 = r119;
        if ((r47 & 33554432) == 0) goto L105;
        String r120 = r17.tagForBridgeProtocol;
    L106:
        String r412 = r120;
        if ((r47 & 67108864) == 0) goto L109;
        ILarkLynxBridgeRuntimeFactory r121 = r17.bridgeRuntimeFactory;
    L110:
        ILarkLynxBridgeRuntimeFactory r413 = r121;
        if ((r47 & 134217728) == 0) goto L113;
        ILarkLynxBridgeProtocol r122 = r17.bridgeProtocol;
    L115:
        if ((r47 & 268435456) == 0) goto L117;
        String r1 = r17.bridgeProtocolContainerId;
    L119:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r49, r410, r411, r412, r413, r122, r1);
    L117:
        r1 = r46;
        goto L119
    L113:
        r122 = r45;
        goto L115
    L109:
        r121 = r44;
        goto L110
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
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
        return this.templateUrl;
    }

    public final String component10() {
        return this.tagForJsContext;
    }

    public final String component11() {
        return this.tagForCustomComponent;
    }

    public final String component12() {
        return this.tagForGlobalData;
    }

    public final String component13() {
        return this.tagForBridgeMethodDispatcher;
    }

    public final String component14() {
        return this.tagForBridgeMethodGroup;
    }

    public final String component15() {
        return this.tagForJSModule;
    }

    public final String component16() {
        return this.tagForTemplateLoader;
    }

    public final String component17() {
        return this.devToolSocketUrl;
    }

    public final boolean component18() {
        return this.enableDevToolsDebug;
    }

    public final boolean component19() {
        return this.enableUserCodeCache;
    }

    public final String component2() {
        return this.templatePath;
    }

    public final String component20() {
        return this.codeCacheSourceUrl;
    }

    public final Integer component21() {
        return this.widthMeasureSpec;
    }

    public final Integer component22() {
        return this.heightMeasureSpec;
    }

    public final Float component23() {
        return this.fontScale;
    }

    public final boolean component24() {
        return this.enableAsyncRender;
    }

    public final boolean component25() {
        return this.enableAsyncRenderForList;
    }

    public final String component26() {
        return this.tagForBridgeProtocol;
    }

    public final ILarkLynxBridgeRuntimeFactory component27() {
        return this.bridgeRuntimeFactory;
    }

    public final ILarkLynxBridgeProtocol component28() {
        return this.bridgeProtocol;
    }

    public final String component29() {
        return this.bridgeProtocolContainerId;
    }

    public final String component3() {
        return this.initDataJson;
    }

    public final Map<String, Object> component4() {
        return this.initDataMap;
    }

    public final Map<String, Object> component5() {
        return this.lynxViewShareData;
    }

    public final Integer component6() {
        return this.containerBackgroundColor;
    }

    public final boolean component7() {
        return this.showLoading;
    }

    public final ViewGroup.LayoutParams component8() {
        return this.layoutParams;
    }

    public final ILynxContainerContext component9() {
        return this.containerContext;
    }

    public final LarkLynxHostParams copy(String r32, String r33, String r34, Map<String, ? extends Object> r35, Map<String, ? extends Object> r36, Integer r37, boolean r38, ViewGroup.LayoutParams r39, ILynxContainerContext r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, boolean r49, boolean r50, String r51, Integer r52, Integer r53, Float r54, boolean r55, boolean r56, String r57, ILarkLynxBridgeRuntimeFactory r58, ILarkLynxBridgeProtocol r59, String r60) {
        return new LarkLynxHostParams(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkLynxHostParams) == true) goto L8;
        return false;
    L8:
        LarkLynxHostParams r6 = (LarkLynxHostParams) r5;
        if (Intrinsics.areEqual(this.templateUrl, r6.templateUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templatePath, r6.templatePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.initDataJson, r6.initDataJson) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.initDataMap, r6.initDataMap) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxViewShareData, r6.lynxViewShareData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.containerBackgroundColor, r6.containerBackgroundColor) == true) goto L27;
        return false;
    L27:
        if (this.showLoading == r6.showLoading) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.layoutParams, r6.layoutParams) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.containerContext, r6.containerContext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagForJsContext, r6.tagForJsContext) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.tagForCustomComponent, r6.tagForCustomComponent) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tagForGlobalData, r6.tagForGlobalData) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tagForBridgeMethodDispatcher, r6.tagForBridgeMethodDispatcher) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tagForBridgeMethodGroup, r6.tagForBridgeMethodGroup) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tagForJSModule, r6.tagForJSModule) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tagForTemplateLoader, r6.tagForTemplateLoader) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.devToolSocketUrl, r6.devToolSocketUrl) == true) goto L60;
        return false;
    L60:
        if (this.enableDevToolsDebug == r6.enableDevToolsDebug) goto L63;
        return false;
    L63:
        if (this.enableUserCodeCache == r6.enableUserCodeCache) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.codeCacheSourceUrl, r6.codeCacheSourceUrl) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.widthMeasureSpec, r6.widthMeasureSpec) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.heightMeasureSpec, r6.heightMeasureSpec) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.fontScale, r6.fontScale) == true) goto L78;
        return false;
    L78:
        if (this.enableAsyncRender == r6.enableAsyncRender) goto L81;
        return false;
    L81:
        if (this.enableAsyncRenderForList == r6.enableAsyncRenderForList) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.tagForBridgeProtocol, r6.tagForBridgeProtocol) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bridgeRuntimeFactory, r6.bridgeRuntimeFactory) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.bridgeProtocol, r6.bridgeProtocol) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.bridgeProtocolContainerId, r6.bridgeProtocolContainerId) == true) goto L95;
        return false;
    L95:
        return true;
    }

    public int hashCode() {
        String r0 = this.templateUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.templatePath;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.initDataJson;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.initDataMap;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, Object> r13 = this.lynxViewShareData;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.containerBackgroundColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        int r19 = 1231;
        if (this.showLoading == false) goto L29;
        int r20 = 1231;
    L30:
        int r21 = (r18 + r20) * 31;
        ViewGroup.LayoutParams r22 = this.layoutParams;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ILynxContainerContext r25 = this.containerContext;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.tagForJsContext;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.tagForCustomComponent;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.tagForGlobalData;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.tagForBridgeMethodDispatcher;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.tagForBridgeMethodGroup;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.tagForJSModule;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.tagForTemplateLoader;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.devToolSocketUrl;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        if (this.enableDevToolsDebug == false) goto L73;
        int r52 = 1231;
    L74:
        int r53 = (r51 + r52) * 31;
        if (this.enableUserCodeCache == false) goto L77;
        int r54 = 1231;
    L78:
        int r55 = (r53 + r54) * 31;
        String r56 = this.codeCacheSourceUrl;
        if (r56 != null) goto L81;
        int r57 = 0;
    L82:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.widthMeasureSpec;
        if (r59 != null) goto L85;
        int r60 = 0;
    L86:
        int r61 = (r58 + r60) * 31;
        Integer r62 = this.heightMeasureSpec;
        if (r62 != null) goto L89;
        int r63 = 0;
    L90:
        int r64 = (r61 + r63) * 31;
        Float r65 = this.fontScale;
        if (r65 != null) goto L93;
        int r66 = 0;
    L94:
        int r67 = (r64 + r66) * 31;
        if (this.enableAsyncRender == false) goto L97;
        int r68 = 1231;
    L98:
        int r69 = (r67 + r68) * 31;
        if (this.enableAsyncRenderForList == true) goto L102;
        r19 = 1237;
    L102:
        int r70 = (r69 + r19) * 31;
        String r71 = this.tagForBridgeProtocol;
        if (r71 != null) goto L105;
        int r72 = 0;
    L106:
        int r73 = (r70 + r72) * 31;
        ILarkLynxBridgeRuntimeFactory r74 = this.bridgeRuntimeFactory;
        if (r74 != null) goto L109;
        int r75 = 0;
    L110:
        int r76 = (r73 + r75) * 31;
        ILarkLynxBridgeProtocol r77 = this.bridgeProtocol;
        if (r77 != null) goto L113;
        int r78 = 0;
    L114:
        int r79 = (r76 + r78) * 31;
        String r80 = this.bridgeProtocolContainerId;
        if (r80 == null) goto L119;
        r1 = r80.hashCode();
    L119:
        return r79 + r1;
    L113:
        r78 = r77.hashCode();
        goto L114
    L109:
        r75 = r74.hashCode();
        goto L110
    L105:
        r72 = r71.hashCode();
        goto L106
    L97:
        r68 = 1237;
        goto L98
    L93:
        r66 = r65.hashCode();
        goto L94
    L89:
        r63 = r62.hashCode();
        goto L90
    L85:
        r60 = r59.hashCode();
        goto L86
    L81:
        r57 = r56.hashCode();
        goto L82
    L77:
        r54 = 1237;
        goto L78
    L73:
        r52 = 1237;
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
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
        r20 = 1237;
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
        return "LarkLynxHostParams(templateUrl=" + this.templateUrl + ", templatePath=" + this.templatePath + ", initDataJson=" + this.initDataJson + ", initDataMap=" + this.initDataMap + ", lynxViewShareData=" + this.lynxViewShareData + ", containerBackgroundColor=" + this.containerBackgroundColor + ", showLoading=" + this.showLoading + ", layoutParams=" + this.layoutParams + ", containerContext=" + this.containerContext + ", tagForJsContext=" + this.tagForJsContext + ", tagForCustomComponent=" + this.tagForCustomComponent + ", tagForGlobalData=" + this.tagForGlobalData + ", tagForBridgeMethodDispatcher=" + this.tagForBridgeMethodDispatcher + ", tagForBridgeMethodGroup=" + this.tagForBridgeMethodGroup + ", tagForJSModule=" + this.tagForJSModule + ", tagForTemplateLoader=" + this.tagForTemplateLoader + ", devToolSocketUrl=" + this.devToolSocketUrl + ", enableDevToolsDebug=" + this.enableDevToolsDebug + ", enableUserCodeCache=" + this.enableUserCodeCache + ", codeCacheSourceUrl=" + this.codeCacheSourceUrl + ", widthMeasureSpec=" + this.widthMeasureSpec + ", heightMeasureSpec=" + this.heightMeasureSpec + ", fontScale=" + this.fontScale + ", enableAsyncRender=" + this.enableAsyncRender + ", enableAsyncRenderForList=" + this.enableAsyncRenderForList + ", tagForBridgeProtocol=" + this.tagForBridgeProtocol + ", bridgeRuntimeFactory=" + this.bridgeRuntimeFactory + ", bridgeProtocol=" + this.bridgeProtocol + ", bridgeProtocolContainerId=" + this.bridgeProtocolContainerId + ')';
    }

    public final ILarkLynxBridgeProtocol getBridgeProtocol() {
        return this.bridgeProtocol;
    }

    public final String getBridgeProtocolContainerId() {
        return this.bridgeProtocolContainerId;
    }

    public final ILarkLynxBridgeRuntimeFactory getBridgeRuntimeFactory() {
        return this.bridgeRuntimeFactory;
    }

    public final String getCodeCacheSourceUrl() {
        return this.codeCacheSourceUrl;
    }

    public final Integer getContainerBackgroundColor() {
        return this.containerBackgroundColor;
    }

    public final ILynxContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final String getDevToolSocketUrl() {
        return this.devToolSocketUrl;
    }

    public final boolean getEnableAsyncRender() {
        return this.enableAsyncRender;
    }

    public final boolean getEnableAsyncRenderForList() {
        return this.enableAsyncRenderForList;
    }

    public final boolean getEnableDevToolsDebug() {
        return this.enableDevToolsDebug;
    }

    public final boolean getEnableUserCodeCache() {
        return this.enableUserCodeCache;
    }

    public final Float getFontScale() {
        return this.fontScale;
    }

    public final Integer getHeightMeasureSpec() {
        return this.heightMeasureSpec;
    }

    public final String getInitDataJson() {
        return this.initDataJson;
    }

    public final Map<String, Object> getInitDataMap() {
        return this.initDataMap;
    }

    public final ViewGroup.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public final Map<String, Object> getLynxViewShareData() {
        return this.lynxViewShareData;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final String getTagForBridgeMethodDispatcher() {
        return this.tagForBridgeMethodDispatcher;
    }

    public final String getTagForBridgeMethodGroup() {
        return this.tagForBridgeMethodGroup;
    }

    public final String getTagForBridgeProtocol() {
        return this.tagForBridgeProtocol;
    }

    public final String getTagForCustomComponent() {
        return this.tagForCustomComponent;
    }

    public final String getTagForGlobalData() {
        return this.tagForGlobalData;
    }

    public final String getTagForJSModule() {
        return this.tagForJSModule;
    }

    public final String getTagForJsContext() {
        return this.tagForJsContext;
    }

    public final String getTagForTemplateLoader() {
        return this.tagForTemplateLoader;
    }

    public final String getTemplatePath() {
        return this.templatePath;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final Integer getWidthMeasureSpec() {
        return this.widthMeasureSpec;
    }

    public LarkLynxHostParams(String r3, String r4, String r5, Map<String, ? extends Object> r6, Map<String, ? extends Object> r7, Integer r8, boolean r9, ViewGroup.LayoutParams r10, ILynxContainerContext r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, boolean r20, boolean r21, String r22, Integer r23, Integer r24, Float r25, boolean r26, boolean r27, String r28, ILarkLynxBridgeRuntimeFactory r29, ILarkLynxBridgeProtocol r30, String r31) {
        this.templateUrl = r3;
        this.templatePath = r4;
        this.initDataJson = r5;
        this.initDataMap = r6;
        this.lynxViewShareData = r7;
        this.containerBackgroundColor = r8;
        this.showLoading = r9;
        this.layoutParams = r10;
        this.containerContext = r11;
        this.tagForJsContext = r12;
        this.tagForCustomComponent = r13;
        this.tagForGlobalData = r14;
        this.tagForBridgeMethodDispatcher = r15;
        this.tagForBridgeMethodGroup = r16;
        this.tagForJSModule = r17;
        this.tagForTemplateLoader = r18;
        this.devToolSocketUrl = r19;
        this.enableDevToolsDebug = r20;
        this.enableUserCodeCache = r21;
        this.codeCacheSourceUrl = r22;
        this.widthMeasureSpec = r23;
        this.heightMeasureSpec = r24;
        this.fontScale = r25;
        this.enableAsyncRender = r26;
        this.enableAsyncRenderForList = r27;
        this.tagForBridgeProtocol = r28;
        this.bridgeRuntimeFactory = r29;
        this.bridgeProtocol = r30;
        this.bridgeProtocolContainerId = r31;
    }

    public /* synthetic */ LarkLynxHostParams(String r31, String r32, String r33, Map r34, Map r35, Integer r36, boolean r37, ViewGroup.LayoutParams r38, ILynxContainerContext r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, boolean r48, boolean r49, String r50, Integer r51, Integer r52, Float r53, boolean r54, boolean r55, String r56, ILarkLynxBridgeRuntimeFactory r57, ILarkLynxBridgeProtocol r58, String r59, int r60, DefaultConstructorMarker r61) {
        if ((r60 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r60 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r60 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r60 & 8) == 0) goto L17;
        Map r5 = null;
    L19:
        if ((r60 & 16) == 0) goto L21;
        Map r6 = null;
    L23:
        if ((r60 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r60 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r60 & 128) == 0) goto L33;
        ViewGroup.LayoutParams r10 = null;
    L35:
        if ((r60 & 256) == 0) goto L37;
        ILynxContainerContext r11 = null;
    L39:
        if ((r60 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r60 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r60 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r60 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r60 & 8192) == 0) goto L57;
        String r2 = null;
    L59:
        if ((r60 & 16384) == 0) goto L61;
        String r9 = null;
    L63:
        if ((r60 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r60 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r60 & 131072) == 0) goto L73;
        boolean r18 = false;
    L75:
        if ((r60 & 262144) == 0) goto L77;
        boolean r19 = false;
    L79:
        if ((r60 & 524288) == 0) goto L81;
        String r20 = null;
    L83:
        if ((r60 & 1048576) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r60 & 2097152) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r60 & 4194304) == 0) goto L93;
        Float r23 = null;
    L95:
        if ((r60 & 8388608) == 0) goto L97;
        boolean r24 = false;
    L99:
        if ((r60 & 16777216) == 0) goto L101;
        boolean r25 = false;
    L103:
        if ((r60 & 33554432) == 0) goto L105;
        String r26 = null;
    L107:
        if ((r60 & 67108864) == 0) goto L109;
        ILarkLynxBridgeRuntimeFactory r27 = null;
    L111:
        if ((r60 & 134217728) == 0) goto L113;
        ILarkLynxBridgeProtocol r28 = null;
    L115:
        if ((r60 & 268435456) == 0) goto L117;
        String r0 = null;
    L118:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r2, r9, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r0);
        return;
    L117:
        r0 = r59;
        goto L118
    L113:
        r28 = r58;
        goto L115
    L109:
        r27 = r57;
        goto L111
    L105:
        r26 = r56;
        goto L107
    L101:
        r25 = r55;
        goto L103
    L97:
        r24 = r54;
        goto L99
    L93:
        r23 = r53;
        goto L95
    L89:
        r22 = r52;
        goto L91
    L85:
        r21 = r51;
        goto L87
    L81:
        r20 = r50;
        goto L83
    L77:
        r19 = r49;
        goto L79
    L73:
        r18 = r48;
        goto L75
    L69:
        r17 = r47;
        goto L71
    L65:
        r16 = r46;
        goto L67
    L61:
        r9 = r45;
        goto L63
    L57:
        r2 = r44;
        goto L59
    L53:
        r15 = r43;
        goto L55
    L49:
        r14 = r42;
        goto L51
    L45:
        r13 = r41;
        goto L47
    L41:
        r12 = r40;
        goto L43
    L37:
        r11 = r39;
        goto L39
    L33:
        r10 = r38;
        goto L35
    L29:
        r8 = r37;
        goto L31
    L25:
        r7 = r36;
        goto L27
    L21:
        r6 = r35;
        goto L23
    L17:
        r5 = r34;
        goto L19
    L13:
        r4 = r33;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r31;
        goto L7
    }
}
