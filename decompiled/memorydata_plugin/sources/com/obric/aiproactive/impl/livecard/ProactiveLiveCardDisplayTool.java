package com.obric.aiproactive.impl.livecard;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.tracker.fragment.BuildConfig;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.ColorHex;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.ISceneEntity;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.RuntimeState;
import com.obric.livecard.api.entity.SceneType;
import com.obric.livecard.api.entity.SuggestionSceneEntity;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.utils.ResourceUtils;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001:\u001c~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\r\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b J\u0015\u0010!\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\"J%\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0000¢\u0006\u0002\b*J'\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\b0J'\u00101\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\b3J'\u00104\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\b5J\u001d\u00106\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u00020/H\u0000¢\u0006\u0002\b9J\u0011\u0010:\u001a\u0004\u0018\u00010;H\u0000¢\u0006\u0004\b<\u0010=J+\u0010>\u001a\u0004\u0018\u00010\u00012\u0006\u0010?\u001a\u00020\u00012\n\u0010@\u001a\u0006\u0012\u0002\b\u00030A2\u0006\u0010B\u001a\u00020\u0005H\u0000¢\u0006\u0002\bCJ\u001d\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020;H\u0000¢\u0006\u0002\bHJ]\u0010I\u001a\u00020J2\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00052\u0006\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020;2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010;2\u0006\u0010R\u001a\u00020SH\u0002¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020;2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010V\u001a\u00020W2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J2\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020;2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010^\u001a\u00020_2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020;2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0002J:\u0010`\u001a\u00020a2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020;2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020/H\u0002J)\u0010b\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\beJ\u0014\u0010f\u001a\u00020J*\u00020J2\u0006\u0010R\u001a\u00020SH\u0002J5\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020\u001b2\b\u0010c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\biJ\u0010\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020\u001bH\u0002J\u0010\u0010l\u001a\u00020_2\u0006\u0010m\u001a\u00020YH\u0002J\u0010\u0010n\u001a\u00020a2\u0006\u0010m\u001a\u00020YH\u0002J\u0010\u0010o\u001a\u00020J2\u0006\u0010m\u001a\u00020YH\u0002J\u0010\u0010p\u001a\u00020_2\u0006\u0010m\u001a\u00020aH\u0002J\u0010\u0010q\u001a\u00020a2\u0006\u0010m\u001a\u00020_H\u0002J\u0018\u0010r\u001a\u00020_2\u0006\u0010m\u001a\u00020_2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010s\u001a\u00020a2\u0006\u0010m\u001a\u00020a2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010t\u001a\u00020Y2\u0006\u0010m\u001a\u00020aH\u0002J\u0010\u0010u\u001a\u00020Y2\u0006\u0010m\u001a\u00020_H\u0002J\u0016\u0010v\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010w\u001a\u00020\u0013J\u000e\u0010x\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\u0013J\u000e\u0010y\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\u0013J\u0012\u0010z\u001a\u0004\u0018\u00010{2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010|\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\u00132\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool;", "", "<init>", "()V", "TAG", "", "COLLAPSED_DISPLAY_TEXT", "LOCKED_CONTENT_TEXT", "COLLAPSE_TEMPLATE_ID", "HOST_PRIMARY_TEXT_COLOR", "HOST_DESCRIPTION_TEXT_COLOR", "HOST_BUTTON_FOREGROUND_BLEND_COLOR", "HOST_BUTTON_FOREGROUND_FLUID_COLOR", "HOST_BUTTON_BACKGROUND_BLEND_COLOR", "HOST_BUTTON_BACKGROUND_FLUID_COLOR", "LEGACY_BUTTON_BACKGROUND_COLOR", "DEFAULT_AUTO_DISMISS_DURATION_MS", "", "buildSession", "Lcom/obric/livecard/api/entity/IslandSession;", "context", "Landroid/content/Context;", "config", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CardConfig;", "buildInteractiveAiNotifyWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "templateData", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTemplateData;", "openDetailFromCard", "Lkotlin/Function1;", "", "resolveCollapsedDisplayText", "resolveCollapsedDisplayText$ai_proactive_impl_obricRelease", "resolveSceneContent", "resolveSceneContent$ai_proactive_impl_obricRelease", "resolveExpandedContent", Params.CONTENT, "title", "hasIndependentTitle", "", "resolveExpandedContent$ai_proactive_impl_obricRelease", "removeLeadingDuplicateTitle", "removeLeadingDuplicateTitle$ai_proactive_impl_obricRelease", "buildCollapseWidget", "icon", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "hostColors", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColors;", "buildCollapseWidget$ai_proactive_impl_obricRelease", "buildExpandedIslandTemplateData", "leftIcon", "buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease", "buildAiNotifyTemplateData", "buildAiNotifyTemplateData$ai_proactive_impl_obricRelease", "combineExpandedTitleAndContent", "combineExpandedTitleAndContent$ai_proactive_impl_obricRelease", "resolveHostColors", "resolveHostColors$ai_proactive_impl_obricRelease", "resolveHostUiNightMode", "", "resolveHostUiNightMode$ai_proactive_impl_obricRelease", "()Ljava/lang/Integer;", "invokePublicApiNoArg", "receiver", "declaringClass", "Ljava/lang/Class;", "methodName", "invokePublicApiNoArg$ai_proactive_impl_obricRelease", "hostColorHex", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColorHex;", "lightColor", "nightColor", "hostColorHex$ai_proactive_impl_obricRelease", "compatibleText", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "maskedText", "textSize", "textColor", "textLightColor", "fontWeight", "lineHeight", "maxLines", "hostColor", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;)Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "getLiveCardVersion", "buildCompatibleAiNotifyButtons", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CompatibleButtonLists;", "createButton", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyButton;", OaidModel.KEY_ID, "width", "dismissKeyguard", "styleType", "createButtonV2", "Lcom/obric/livecard/api/entity/ButtonV2;", "createModernTextButton", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyModernTextButton;", "refreshTemplateColors", "current", "fallback", "refreshTemplateColors$ai_proactive_impl_obricRelease", "withHostColor", "preserveCompatibleButtonLists", "refreshed", "preserveCompatibleButtonLists$ai_proactive_impl_obricRelease", "hasCompatibleButtonList", "template", "legacyButtonToV2", "button", "legacyButtonToIntermediate", "legacyButtonTextToIntermediate", "intermediateButtonToV2", "buttonV2ToIntermediate", "normalizeButtonV2Colors", "normalizeIntermediateButtonColors", "intermediateButtonToLegacy", "buttonV2ToLegacy", "showSession", "session", "destroySession", "refreshSession", "ensureIslandService", "Lcom/obric/livecard/api/island/IslandApi;", "markSessionAsProcessed", "feedbackAction", "CardConfig", "CardActionButton", "AiNotifyTemplateData", "AiNotifyIcon", "AiNotifyText", "AiNotifyDescription", "AiNotifyButton", "AiNotifyTextIconStyle", "AiNotifyModernTextButton", "CompatibleCommonCollapseTemplate", "HostColor", "HostColors", "HostColorHex", "CompatibleButtonLists", "HostThemeResourceBridge", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveLiveCardDisplayTool {
    private static final String COLLAPSED_DISPLAY_TEXT = "AI 建议";
    private static final String COLLAPSE_TEMPLATE_ID = "com.obric.island_applet:common_collapse_template";
    public static final long DEFAULT_AUTO_DISMISS_DURATION_MS = 3600000;
    private static final String HOST_BUTTON_BACKGROUND_BLEND_COLOR = "oui_basic_fill_element_2";
    private static final String HOST_BUTTON_BACKGROUND_FLUID_COLOR = "oui_on_accent_fill_element_2";
    private static final String HOST_BUTTON_FOREGROUND_BLEND_COLOR = "oui_basic_text_1";
    private static final String HOST_BUTTON_FOREGROUND_FLUID_COLOR = "oui_on_accent_text_1";
    private static final String HOST_DESCRIPTION_TEXT_COLOR = "oui_on_accent_text_3";
    private static final String HOST_PRIMARY_TEXT_COLOR = "oui_on_accent_text_1";
    public static final ProactiveLiveCardDisplayTool INSTANCE = null;
    private static final String LEGACY_BUTTON_BACKGROUND_COLOR = "rgba(150, 150, 150, 0.20)";
    private static final String LOCKED_CONTENT_TEXT = "解锁查看完整内容";
    private static final String TAG = "ProactiveLiveCardDisplayTool";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyButton;", "", OaidModel.KEY_ID, "", "width", "", "height", "icon", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "dismissKeyguard", "", "textIconStyle", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTextIconStyle;", "styleType", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTextIconStyle;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "getIcon", "getText", "getDismissKeyguard", "()Z", "getTextIconStyle", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTextIconStyle;", "getStyleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyButton {
        private final boolean dismissKeyguard;
        private final int height;
        private final String icon;
        private final String id;
        private final String styleType;
        private final String text;
        private final AiNotifyTextIconStyle textIconStyle;
        private final int width;

        public AiNotifyButton(String r2, int r3, int r4, String r5, String r6, boolean r7, AiNotifyTextIconStyle r8, String r9) {
            Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r5, "icon");
            Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r8, "textIconStyle");
            this.id = r2;
            this.width = r3;
            this.height = r4;
            this.icon = r5;
            this.text = r6;
            this.dismissKeyguard = r7;
            this.textIconStyle = r8;
            this.styleType = r9;
        }

        public /* synthetic */ AiNotifyButton(String r11, int r12, int r13, String r14, String r15, boolean r16, AiNotifyTextIconStyle r17, String r18, int r19, DefaultConstructorMarker r20) {
            if ((r19 & 128) == 0) goto L5;
            String r9 = null;
        L6:
            this(r11, r12, r13, r14, r15, r16, r17, r9);
            return;
        L5:
            r9 = r18;
            goto L6
        }

        public static /* synthetic */ AiNotifyButton copy$default(AiNotifyButton r9, String r10, int r11, int r12, String r13, String r14, boolean r15, AiNotifyTextIconStyle r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            String r2 = r9.id;
        L7:
            if ((r18 & 2) == 0) goto L9;
            int r3 = r9.width;
        L11:
            if ((r18 & 4) == 0) goto L13;
            int r4 = r9.height;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r5 = r9.icon;
        L19:
            if ((r18 & 16) == 0) goto L21;
            String r6 = r9.text;
        L23:
            if ((r18 & 32) == 0) goto L25;
            boolean r7 = r9.dismissKeyguard;
        L27:
            if ((r18 & 64) == 0) goto L29;
            AiNotifyTextIconStyle r8 = r9.textIconStyle;
        L31:
            if ((r18 & 128) == 0) goto L33;
            String r1 = r9.styleType;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final String component1() {
            return this.id;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final String component4() {
            return this.icon;
        }

        public final String component5() {
            return this.text;
        }

        public final boolean component6() {
            return this.dismissKeyguard;
        }

        public final AiNotifyTextIconStyle component7() {
            return this.textIconStyle;
        }

        public final String component8() {
            return this.styleType;
        }

        public final AiNotifyButton copy(String r11, int r12, int r13, String r14, String r15, boolean r16, AiNotifyTextIconStyle r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r14, "icon");
            Intrinsics.checkNotNullParameter(r15, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r17, "textIconStyle");
            return new AiNotifyButton(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyButton.class) == true) goto L8;
            return false;
        L8:
            AiNotifyButton r6 = (AiNotifyButton) ZeusTransformUtils.preCheckCast(r5, AiNotifyButton.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
            return false;
        L12:
            if (this.width == r6.width) goto L15;
            return false;
        L15:
            if (this.height == r6.height) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L24;
            return false;
        L24:
            if (this.dismissKeyguard == r6.dismissKeyguard) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.textIconStyle, r6.textIconStyle) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.styleType, r6.styleType) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final boolean getDismissKeyguard() {
            return this.dismissKeyguard;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getId() {
            return this.id;
        }

        public final String getStyleType() {
            return this.styleType;
        }

        public final String getText() {
            return this.text;
        }

        public final AiNotifyTextIconStyle getTextIconStyle() {
            return this.textIconStyle;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            int r0 = ((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.dismissKeyguard)) * 31) + this.textIconStyle.hashCode()) * 31;
            String r2 = this.styleType;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "AiNotifyButton(id=" + this.id + ", width=" + this.width + ", height=" + this.height + ", icon=" + this.icon + ", text=" + this.text + ", dismissKeyguard=" + this.dismissKeyguard + ", textIconStyle=" + this.textIconStyle + ", styleType=" + this.styleType + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyDescription;", "", "icon", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "<init>", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;)V", "getIcon", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;", "getText", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyDescription {
        private final AiNotifyIcon icon;
        private final AiNotifyText text;

        public AiNotifyDescription(AiNotifyIcon r2, AiNotifyText r3) {
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.icon = r2;
            this.text = r3;
        }

        public /* synthetic */ AiNotifyDescription(AiNotifyIcon r1, AiNotifyText r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1, r2);
        }

        public static /* synthetic */ AiNotifyDescription copy$default(AiNotifyDescription r0, AiNotifyIcon r1, AiNotifyText r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.icon;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.text;
        L9:
            return r0.copy(r1, r2);
        }

        public final AiNotifyIcon component1() {
            return this.icon;
        }

        public final AiNotifyText component2() {
            return this.text;
        }

        public final AiNotifyDescription copy(AiNotifyIcon r1, AiNotifyText r2) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            return new AiNotifyDescription(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyDescription.class) == true) goto L8;
            return false;
        L8:
            AiNotifyDescription r6 = (AiNotifyDescription) ZeusTransformUtils.preCheckCast(r5, AiNotifyDescription.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final AiNotifyIcon getIcon() {
            return this.icon;
        }

        public final AiNotifyText getText() {
            return this.text;
        }

        public int hashCode() {
            AiNotifyIcon r0 = this.icon;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.text.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "AiNotifyDescription(icon=" + this.icon + ", text=" + this.text + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;", "", "icon", "", "width", "", "height", "<init>", "(Ljava/lang/String;II)V", "getIcon", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyIcon {
        private final int height;
        private final String icon;
        private final int width;

        public AiNotifyIcon(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "icon");
            this.icon = r2;
            this.width = r3;
            this.height = r4;
        }

        public static /* synthetic */ AiNotifyIcon copy$default(AiNotifyIcon r0, String r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.icon;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.width;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.height;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.icon;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final AiNotifyIcon copy(String r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "icon");
            return new AiNotifyIcon(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyIcon.class) == true) goto L8;
            return false;
        L8:
            AiNotifyIcon r6 = (AiNotifyIcon) ZeusTransformUtils.preCheckCast(r5, AiNotifyIcon.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L12;
            return false;
        L12:
            if (this.width == r6.width) goto L15;
            return false;
        L15:
            if (this.height == r6.height) goto L17;
            return false;
        L17:
            return true;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((this.icon.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
        }

        public String toString() {
            return "AiNotifyIcon(icon=" + this.icon + ", width=" + this.width + ", height=" + this.height + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003Jl\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u0006."}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyModernTextButton;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "height", "", "width", OaidModel.KEY_ID, "", "dismissKeyguard", "", "backgroundIcon", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "styleType", "<init>", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/String;)V", "getText", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getId", "()Ljava/lang/String;", "getDismissKeyguard", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBackgroundIcon", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "getStyleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/String;)Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyModernTextButton;", "equals", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyModernTextButton {
        private final String backgroundIcon;
        private final ColorToken color;
        private final Boolean dismissKeyguard;
        private final Integer height;
        private final String id;
        private final String styleType;
        private final AiNotifyText text;
        private final Integer width;

        public AiNotifyModernTextButton(AiNotifyText r2, Integer r3, Integer r4, String r5, Boolean r6, String r7, ColorToken r8, String r9) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.text = r2;
            this.height = r3;
            this.width = r4;
            this.id = r5;
            this.dismissKeyguard = r6;
            this.backgroundIcon = r7;
            this.color = r8;
            this.styleType = r9;
        }

        public /* synthetic */ AiNotifyModernTextButton(AiNotifyText r9, Integer r10, Integer r11, String r12, Boolean r13, String r14, ColorToken r15, String r16, int r17, DefaultConstructorMarker r18) {
            String r2 = null;
            if ((r17 & 2) == 0) goto L5;
            Integer r1 = null;
        L7:
            if ((r17 & 4) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r17 & 8) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r17 & 16) == 0) goto L17;
            Boolean r5 = null;
        L19:
            if ((r17 & 32) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r17 & 64) == 0) goto L25;
            ColorToken r7 = null;
        L27:
            if ((r17 & 128) != 0) goto L30;
            r2 = r16;
        L30:
            this(r9, r1, r3, r4, r5, r6, r7, r2);
            return;
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r1 = r10;
            goto L7
        }

        public static /* synthetic */ AiNotifyModernTextButton copy$default(AiNotifyModernTextButton r9, AiNotifyText r10, Integer r11, Integer r12, String r13, Boolean r14, String r15, ColorToken r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            AiNotifyText r2 = r9.text;
        L7:
            if ((r18 & 2) == 0) goto L9;
            Integer r3 = r9.height;
        L11:
            if ((r18 & 4) == 0) goto L13;
            Integer r4 = r9.width;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r5 = r9.id;
        L19:
            if ((r18 & 16) == 0) goto L21;
            Boolean r6 = r9.dismissKeyguard;
        L23:
            if ((r18 & 32) == 0) goto L25;
            String r7 = r9.backgroundIcon;
        L27:
            if ((r18 & 64) == 0) goto L29;
            ColorToken r8 = r9.color;
        L31:
            if ((r18 & 128) == 0) goto L33;
            String r1 = r9.styleType;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final AiNotifyText component1() {
            return this.text;
        }

        public final Integer component2() {
            return this.height;
        }

        public final Integer component3() {
            return this.width;
        }

        public final String component4() {
            return this.id;
        }

        public final Boolean component5() {
            return this.dismissKeyguard;
        }

        public final String component6() {
            return this.backgroundIcon;
        }

        public final ColorToken component7() {
            return this.color;
        }

        public final String component8() {
            return this.styleType;
        }

        public final AiNotifyModernTextButton copy(AiNotifyText r11, Integer r12, Integer r13, String r14, Boolean r15, String r16, ColorToken r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            return new AiNotifyModernTextButton(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyModernTextButton.class) == true) goto L8;
            return false;
        L8:
            AiNotifyModernTextButton r6 = (AiNotifyModernTextButton) ZeusTransformUtils.preCheckCast(r5, AiNotifyModernTextButton.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.height, r6.height) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.width, r6.width) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.color, r6.color) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.styleType, r6.styleType) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final String getBackgroundIcon() {
            return this.backgroundIcon;
        }

        public final ColorToken getColor() {
            return this.color;
        }

        public final Boolean getDismissKeyguard() {
            return this.dismissKeyguard;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getId() {
            return this.id;
        }

        public final String getStyleType() {
            return this.styleType;
        }

        public final AiNotifyText getText() {
            return this.text;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public int hashCode() {
            int r0 = this.text.hashCode() * 31;
            Integer r1 = this.height;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.width;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.id;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Boolean r11 = this.dismissKeyguard;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.backgroundIcon;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            ColorToken r17 = this.color;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.styleType;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return r19 + r2;
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

        public String toString() {
            return "AiNotifyModernTextButton(text=" + this.text + ", height=" + this.height + ", width=" + this.width + ", id=" + this.id + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundIcon=" + this.backgroundIcon + ", color=" + this.color + ", styleType=" + this.styleType + ')';
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003Jc\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTemplateData;", "", "leftIcon", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;", "title", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "description", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyDescription;", "buttonList", "", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyButton;", "textButtonList", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyModernTextButton;", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyDescription;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLeftIcon", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyIcon;", "getTitle", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "getDescription", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyDescription;", "getButtonList", "()Ljava/util/List;", "getTextButtonList", "getButtonV2List", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyTemplateData {
        private final List<AiNotifyButton> buttonList;
        private final List<ButtonV2> buttonV2List;
        private final AiNotifyDescription description;
        private final AiNotifyIcon leftIcon;
        private final List<AiNotifyModernTextButton> textButtonList;
        private final AiNotifyText title;

        public AiNotifyTemplateData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public AiNotifyTemplateData(AiNotifyIcon r3, AiNotifyText r4, AiNotifyDescription r5, List<AiNotifyButton> r6, List<AiNotifyModernTextButton> r7, List<ButtonV2> r8) {
            List<AiNotifyButton> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List<AiNotifyModernTextButton> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            List<ButtonV2> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            this.leftIcon = r3;
            this.title = r4;
            this.description = r5;
            this.buttonList = r9;
            this.textButtonList = r10;
            this.buttonV2List = r11;
        }

        public /* synthetic */ AiNotifyTemplateData(AiNotifyIcon r9, AiNotifyText r10, AiNotifyDescription r11, List r12, List r13, List r14, int r15, DefaultConstructorMarker r16) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            if ((r15 & 1) == 0) goto L5;
            AiNotifyIcon r3 = null;
        L7:
            if ((r15 & 2) == 0) goto L9;
            AiNotifyText r5 = null;
        L11:
            if ((r15 & 4) == 0) goto L13;
            AiNotifyDescription r6 = null;
        L15:
            if ((r15 & 8) == 0) goto L18;
            r0 = null;
        L18:
            if ((r15 & 16) == 0) goto L21;
            r2 = null;
        L21:
            if ((r15 & 32) == 0) goto L23;
            r1 = null;
        L23:
            this(r3, r5, r6, r0, r2, r1);
            return;
        L13:
            r6 = r11;
            goto L15
        L9:
            r5 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public static /* synthetic */ AiNotifyTemplateData copy$default(AiNotifyTemplateData r7, AiNotifyIcon r8, AiNotifyText r9, AiNotifyDescription r10, List r11, List r12, List r13, int r14, Object r15) {
            List<AiNotifyButton> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            List<AiNotifyModernTextButton> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            List<ButtonV2> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            if ((r14 & 1) == 0) goto L5;
            r8 = r7.leftIcon;
        L5:
            AiNotifyIcon r1 = r8;
            if ((r14 & 2) == 0) goto L8;
            r9 = r7.title;
        L8:
            AiNotifyText r2 = r9;
            if ((r14 & 4) == 0) goto L11;
            r10 = r7.description;
        L11:
            AiNotifyDescription r3 = r10;
            if ((r14 & 8) == 0) goto L14;
            r16 = r7.buttonList;
        L14:
            List<AiNotifyButton> r4 = r16;
            if ((r14 & 16) == 0) goto L17;
            r17 = r7.textButtonList;
        L17:
            List<AiNotifyModernTextButton> r5 = r17;
            if ((r14 & 32) == 0) goto L21;
            r18 = r7.buttonV2List;
        L21:
            return r7.copy(r1, r2, r3, r4, r5, r18);
        }

        public final AiNotifyIcon component1() {
            return this.leftIcon;
        }

        public final AiNotifyText component2() {
            return this.title;
        }

        public final AiNotifyDescription component3() {
            return this.description;
        }

        public final List<AiNotifyButton> component4() {
            return this.buttonList;
        }

        public final List<AiNotifyModernTextButton> component5() {
            return this.textButtonList;
        }

        public final List<ButtonV2> component6() {
            return this.buttonV2List;
        }

        public final AiNotifyTemplateData copy(AiNotifyIcon r9, AiNotifyText r10, AiNotifyDescription r11, List<AiNotifyButton> r12, List<AiNotifyModernTextButton> r13, List<ButtonV2> r14) {
            return new AiNotifyTemplateData(r9, r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"));
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyTemplateData.class) == true) goto L8;
            return false;
        L8:
            AiNotifyTemplateData r6 = (AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r5, AiNotifyTemplateData.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.leftIcon, r6.leftIcon) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.textButtonList, r6.textButtonList) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final List<AiNotifyButton> getButtonList() {
            return this.buttonList;
        }

        public final List<ButtonV2> getButtonV2List() {
            return this.buttonV2List;
        }

        public final AiNotifyDescription getDescription() {
            return this.description;
        }

        public final AiNotifyIcon getLeftIcon() {
            return this.leftIcon;
        }

        public final List<AiNotifyModernTextButton> getTextButtonList() {
            return this.textButtonList;
        }

        public final AiNotifyText getTitle() {
            return this.title;
        }

        public int hashCode() {
            AiNotifyIcon r0 = this.leftIcon;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            AiNotifyText r4 = this.title;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            AiNotifyDescription r7 = this.description;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            List<AiNotifyButton> r10 = this.buttonList;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            List<AiNotifyModernTextButton> r13 = this.textButtonList;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            List<ButtonV2> r16 = this.buttonV2List;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
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
            return "AiNotifyTemplateData(leftIcon=" + this.leftIcon + ", title=" + this.title + ", description=" + this.description + ", buttonList=" + this.buttonList + ", textButtonList=" + this.textButtonList + ", buttonV2List=" + this.buttonV2List + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "maskedText", "textSize", "", "textColor", "textLightColor", "fontWeight", "lineHeight", "maxLines", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getText", "()Ljava/lang/String;", "getMaskedText", "getTextSize", "()I", "getTextColor", "getTextLightColor", "getFontWeight", "getLineHeight", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "equals", "", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyText {
        private final ColorToken color;
        private final String fontWeight;
        private final int lineHeight;
        private final String maskedText;
        private final Integer maxLines;
        private final String text;
        private final String textColor;
        private final String textLightColor;
        private final int textSize;

        public AiNotifyText(String r2, String r3, int r4, String r5, String r6, String r7, int r8, Integer r9, ColorToken r10) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r5, "textColor");
            Intrinsics.checkNotNullParameter(r6, "textLightColor");
            Intrinsics.checkNotNullParameter(r7, "fontWeight");
            this.text = r2;
            this.maskedText = r3;
            this.textSize = r4;
            this.textColor = r5;
            this.textLightColor = r6;
            this.fontWeight = r7;
            this.lineHeight = r8;
            this.maxLines = r9;
            this.color = r10;
        }

        public /* synthetic */ AiNotifyText(String r14, String r15, int r16, String r17, String r18, String r19, int r20, Integer r21, ColorToken r22, int r23, DefaultConstructorMarker r24) {
            if ((r23 & 2) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r23 & 128) == 0) goto L9;
            Integer r11 = null;
        L11:
            if ((r23 & 256) == 0) goto L13;
            ColorToken r12 = null;
        L14:
            this(r14, r5, r16, r17, r18, r19, r20, r11, r12);
            return;
        L13:
            r12 = r22;
            goto L14
        L9:
            r11 = r21;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }

        public static /* synthetic */ AiNotifyText copy$default(AiNotifyText r10, String r11, String r12, int r13, String r14, String r15, String r16, int r17, Integer r18, ColorToken r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            String r2 = r10.text;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.maskedText;
        L11:
            if ((r20 & 4) == 0) goto L13;
            int r4 = r10.textSize;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.textColor;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = r10.textLightColor;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = r10.fontWeight;
        L27:
            if ((r20 & 64) == 0) goto L29;
            int r8 = r10.lineHeight;
        L31:
            if ((r20 & 128) == 0) goto L33;
            Integer r9 = r10.maxLines;
        L35:
            if ((r20 & 256) == 0) goto L37;
            ColorToken r1 = r10.color;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.maskedText;
        }

        public final int component3() {
            return this.textSize;
        }

        public final String component4() {
            return this.textColor;
        }

        public final String component5() {
            return this.textLightColor;
        }

        public final String component6() {
            return this.fontWeight;
        }

        public final int component7() {
            return this.lineHeight;
        }

        public final Integer component8() {
            return this.maxLines;
        }

        public final ColorToken component9() {
            return this.color;
        }

        public final AiNotifyText copy(String r12, String r13, int r14, String r15, String r16, String r17, int r18, Integer r19, ColorToken r20) {
            Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r15, "textColor");
            Intrinsics.checkNotNullParameter(r16, "textLightColor");
            Intrinsics.checkNotNullParameter(r17, "fontWeight");
            return new AiNotifyText(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyText.class) == true) goto L8;
            return false;
        L8:
            AiNotifyText r6 = (AiNotifyText) ZeusTransformUtils.preCheckCast(r5, AiNotifyText.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.maskedText, r6.maskedText) == true) goto L15;
            return false;
        L15:
            if (this.textSize == r6.textSize) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L27;
            return false;
        L27:
            if (this.lineHeight == r6.lineHeight) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.maxLines, r6.maxLines) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.color, r6.color) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final ColorToken getColor() {
            return this.color;
        }

        public final String getFontWeight() {
            return this.fontWeight;
        }

        public final int getLineHeight() {
            return this.lineHeight;
        }

        public final String getMaskedText() {
            return this.maskedText;
        }

        public final Integer getMaxLines() {
            return this.maxLines;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final String getTextLightColor() {
            return this.textLightColor;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            int r0 = this.text.hashCode() * 31;
            String r1 = this.maskedText;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((((((r0 + r3) * 31) + Integer.hashCode(this.textSize)) * 31) + this.textColor.hashCode()) * 31) + this.textLightColor.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.lineHeight)) * 31;
            Integer r5 = this.maxLines;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            ColorToken r8 = this.color;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AiNotifyText(text=" + this.text + ", maskedText=" + this.maskedText + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", maxLines=" + this.maxLines + ", color=" + this.color + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyTextIconStyle;", "", "textSize", "", "textColor", "", "textLightColor", "backgroundColor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTextSize", "()I", "getTextColor", "()Ljava/lang/String;", "getTextLightColor", "getBackgroundColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AiNotifyTextIconStyle {
        private final String backgroundColor;
        private final String textColor;
        private final String textLightColor;
        private final int textSize;

        public AiNotifyTextIconStyle(int r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "textColor");
            Intrinsics.checkNotNullParameter(r4, "textLightColor");
            Intrinsics.checkNotNullParameter(r5, "backgroundColor");
            this.textSize = r2;
            this.textColor = r3;
            this.textLightColor = r4;
            this.backgroundColor = r5;
        }

        public static /* synthetic */ AiNotifyTextIconStyle copy$default(AiNotifyTextIconStyle r0, int r1, String r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.textSize;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.textColor;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.textLightColor;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.backgroundColor;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.textSize;
        }

        public final String component2() {
            return this.textColor;
        }

        public final String component3() {
            return this.textLightColor;
        }

        public final String component4() {
            return this.backgroundColor;
        }

        public final AiNotifyTextIconStyle copy(int r1, String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "textColor");
            Intrinsics.checkNotNullParameter(r3, "textLightColor");
            Intrinsics.checkNotNullParameter(r4, "backgroundColor");
            return new AiNotifyTextIconStyle(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AiNotifyTextIconStyle.class) == true) goto L8;
            return false;
        L8:
            AiNotifyTextIconStyle r6 = (AiNotifyTextIconStyle) ZeusTransformUtils.preCheckCast(r5, AiNotifyTextIconStyle.class, "com.obric.memorydata.plugin");
            if (this.textSize == r6.textSize) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final String getTextLightColor() {
            return this.textLightColor;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.textSize) * 31) + this.textColor.hashCode()) * 31) + this.textLightColor.hashCode()) * 31) + this.backgroundColor.hashCode();
        }

        public String toString() {
            return "AiNotifyTextIconStyle(textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", backgroundColor=" + this.backgroundColor + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CardActionButton;", "", OaidModel.KEY_ID, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "dismissKeyguard", "", "styleType", "onClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getId", "()Ljava/lang/String;", "getText", "getDismissKeyguard", "()Z", "getStyleType", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CardActionButton {
        private final boolean dismissKeyguard;
        private final String id;
        private final Function0<Unit> onClick;
        private final String styleType;
        private final String text;

        public CardActionButton(String r3, String r4, boolean r5, String r6, Function0<Unit> r7) {
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r6, "styleType");
            Intrinsics.checkNotNullParameter(r8, "onClick");
            this.id = r3;
            this.text = r4;
            this.dismissKeyguard = r5;
            this.styleType = r6;
            this.onClick = r8;
        }

        public /* synthetic */ CardActionButton(String r7, String r8, boolean r9, String r10, Function0 r11, int r12, DefaultConstructorMarker r13) {
            Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = "left";
        L5:
            this(r7, r8, r9, r10, r5);
        }

        public static /* synthetic */ CardActionButton copy$default(CardActionButton r6, String r7, String r8, boolean r9, String r10, Function0 r11, int r12, Object r13) {
            Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.id;
        L5:
            String r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.text;
        L8:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.dismissKeyguard;
        L11:
            boolean r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r10 = r6.styleType;
        L14:
            String r4 = r10;
            if ((r12 & 16) == 0) goto L18;
            r14 = r6.onClick;
        L18:
            return r6.copy(r1, r2, r3, r4, r14);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.text;
        }

        public final boolean component3() {
            return this.dismissKeyguard;
        }

        public final String component4() {
            return this.styleType;
        }

        public final Function0<Unit> component5() {
            return this.onClick;
        }

        public final CardActionButton copy(String r7, String r8, boolean r9, String r10, Function0<Unit> r11) {
            Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r10, "styleType");
            Intrinsics.checkNotNullParameter(r5, "onClick");
            return new CardActionButton(r7, r8, r9, r10, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CardActionButton.class) == true) goto L8;
            return false;
        L8:
            CardActionButton r6 = (CardActionButton) ZeusTransformUtils.preCheckCast(r5, CardActionButton.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
            return false;
        L15:
            if (this.dismissKeyguard == r6.dismissKeyguard) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.styleType, r6.styleType) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.onClick, r6.onClick) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final boolean getDismissKeyguard() {
            return this.dismissKeyguard;
        }

        public final String getId() {
            return this.id;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getStyleType() {
            return this.styleType;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.dismissKeyguard)) * 31) + this.styleType.hashCode()) * 31) + this.onClick.hashCode();
        }

        public String toString() {
            return "CardActionButton(id=" + this.id + ", text=" + this.text + ", dismissKeyguard=" + this.dismissKeyguard + ", styleType=" + this.styleType + ", onClick=" + this.onClick + ')';
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001BÞ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012'\b\u0002\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J(\u0010>\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003Jä\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2'\b\u0002\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u00142\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0001J\u0013\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0015HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R0\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006E"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CardConfig;", "", "recommendId", "", "title", "titleMasked", Params.CONTENT, "onIgnoreClick", "Lkotlin/Function0;", "", "onExecuteClick", "executeButtonText", "executeButtonDismissKeyguard", "", "onCardClick", MemorySourceLinkType.INTENT, "Landroid/app/PendingIntent;", "onCardClose", "onCardShow", "onSessionDestroy", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, InfoRequestQPSOptTraceLogger.REASON, "actionButtons", "", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CardActionButton;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroid/app/PendingIntent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "getRecommendId", "()Ljava/lang/String;", "getTitle", "getTitleMasked", "getContent", "getOnIgnoreClick", "()Lkotlin/jvm/functions/Function0;", "getOnExecuteClick", "getExecuteButtonText", "getExecuteButtonDismissKeyguard", "()Z", "getOnCardClick", "getIntent", "()Landroid/app/PendingIntent;", "getOnCardClose", "getOnCardShow", "getOnSessionDestroy", "()Lkotlin/jvm/functions/Function1;", "getActionButtons", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CardConfig {
        private final List<CardActionButton> actionButtons;
        private final String content;
        private final boolean executeButtonDismissKeyguard;
        private final String executeButtonText;
        private final PendingIntent intent;
        private final Function0<Unit> onCardClick;
        private final Function0<Unit> onCardClose;
        private final Function0<Unit> onCardShow;
        private final Function0<Unit> onExecuteClick;
        private final Function0<Unit> onIgnoreClick;
        private final Function1<Integer, Unit> onSessionDestroy;
        private final String recommendId;
        private final String title;
        private final String titleMasked;

        public CardConfig(String r16, String r17, String r18, String r19, Function0<Unit> r20, Function0<Unit> r21, String r22, boolean r23, Function0<Unit> r24, PendingIntent r25, Function0<Unit> r26, Function0<Unit> r27, Function1<? super Integer, Unit> r28, List<CardActionButton> r29) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r24, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
            Function1<Integer, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
            List<CardActionButton> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "recommendId");
            Intrinsics.checkNotNullParameter(r17, "title");
            Intrinsics.checkNotNullParameter(r18, "titleMasked");
            Intrinsics.checkNotNullParameter(r19, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r22, "executeButtonText");
            Intrinsics.checkNotNullParameter(r7, "actionButtons");
            this.recommendId = r16;
            this.title = r17;
            this.titleMasked = r18;
            this.content = r19;
            this.onIgnoreClick = r6;
            this.onExecuteClick = r8;
            this.executeButtonText = r22;
            this.executeButtonDismissKeyguard = r23;
            this.onCardClick = r9;
            this.intent = r25;
            this.onCardClose = r10;
            this.onCardShow = r11;
            this.onSessionDestroy = r12;
            this.actionButtons = r7;
        }

        public /* synthetic */ CardConfig(String r26, String r27, String r28, String r29, Function0 r30, Function0 r31, String r32, boolean r33, Function0 r34, PendingIntent r35, Function0 r36, Function0 r37, Function1 r38, List r39, int r40, DefaultConstructorMarker r41) {
            Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r30, Function0.class, "com.obric.memorydata.plugin");
            Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r31, Function0.class, "com.obric.memorydata.plugin");
            Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
            Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r36, Function0.class, "com.obric.memorydata.plugin");
            Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r37, Function0.class, "com.obric.memorydata.plugin");
            Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r38, Function1.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
            if ((r40 & 2) == 0) goto L5;
            String r12 = ProactiveLiveCardDisplayTool.COLLAPSED_DISPLAY_TEXT;
        L7:
            if ((r40 & 4) == 0) goto L9;
            String r13 = ProactiveLiveCardDisplayTool.COLLAPSED_DISPLAY_TEXT;
        L11:
            if ((r40 & 16) == 0) goto L13;
            Function0 r15 = null;
        L15:
            if ((r40 & 32) == 0) goto L17;
            Function0 r16 = null;
        L19:
            if ((r40 & 64) == 0) goto L21;
            String r17 = "立即执行";
        L23:
            if ((r40 & 128) == 0) goto L25;
            boolean r18 = true;
        L27:
            if ((r40 & 256) == 0) goto L29;
            Function0 r19 = null;
        L31:
            if ((r40 & 512) == 0) goto L33;
            PendingIntent r20 = null;
        L35:
            if ((r40 & 1024) == 0) goto L37;
            Function0 r21 = null;
        L39:
            if ((r40 & 2048) == 0) goto L41;
            Function0 r22 = null;
        L43:
            if ((r40 & 4096) == 0) goto L45;
            Function1 r23 = null;
        L47:
            if ((r40 & 8192) == 0) goto L49;
            r2 = CollectionsKt.emptyList();
        L49:
            this(r26, r12, r13, r29, r15, r16, r17, r18, r19, r20, r21, r22, r23, r2);
            return;
        L45:
            r23 = r7;
            goto L47
        L41:
            r22 = r6;
            goto L43
        L37:
            r21 = r5;
            goto L39
        L33:
            r20 = r35;
            goto L35
        L29:
            r19 = r4;
            goto L31
        L25:
            r18 = r33;
            goto L27
        L21:
            r17 = r32;
            goto L23
        L17:
            r16 = r3;
            goto L19
        L13:
            r15 = r1;
            goto L15
        L9:
            r13 = r28;
            goto L11
        L5:
            r12 = r27;
            goto L7
        }

        public static /* synthetic */ CardConfig copy$default(CardConfig r16, String r17, String r18, String r19, String r20, Function0 r21, Function0 r22, String r23, boolean r24, Function0 r25, PendingIntent r26, Function0 r27, Function0 r28, Function1 r29, List r30, int r31, Object r32) {
            Function0<Unit> r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r25, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r28, Function0.class, "com.obric.memorydata.plugin");
            Function1<Integer, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
            List<CardActionButton> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
            if ((r31 & 1) == 0) goto L5;
            String r9 = r16.recommendId;
        L7:
            if ((r31 & 2) == 0) goto L9;
            String r10 = r16.title;
        L11:
            if ((r31 & 4) == 0) goto L13;
            String r11 = r16.titleMasked;
        L15:
            if ((r31 & 8) == 0) goto L17;
            String r12 = r16.content;
        L19:
            if ((r31 & 16) == 0) goto L22;
            r2 = r16.onIgnoreClick;
        L22:
            if ((r31 & 32) == 0) goto L25;
            r4 = r16.onExecuteClick;
        L25:
            if ((r31 & 64) == 0) goto L27;
            String r13 = r16.executeButtonText;
        L29:
            if ((r31 & 128) == 0) goto L31;
            boolean r14 = r16.executeButtonDismissKeyguard;
        L33:
            if ((r31 & 256) == 0) goto L36;
            r5 = r16.onCardClick;
        L36:
            if ((r31 & 512) == 0) goto L38;
            PendingIntent r15 = r16.intent;
        L40:
            if ((r31 & 1024) == 0) goto L42;
            Function0<Unit> r33 = r16.onCardClose;
        L44:
            if ((r31 & 2048) == 0) goto L46;
            Function0<Unit> r34 = r16.onCardShow;
        L48:
            if ((r31 & 4096) == 0) goto L50;
            Function1<Integer, Unit> r35 = r16.onSessionDestroy;
        L52:
            if ((r31 & 8192) == 0) goto L54;
            List<CardActionButton> r1 = r16.actionButtons;
        L56:
            return r16.copy(r9, r10, r11, r12, r2, r4, r13, r14, r5, r15, r33, r34, r35, r1);
        L54:
            r1 = r3;
            goto L56
        L50:
            r35 = r8;
            goto L52
        L46:
            r34 = r7;
            goto L48
        L42:
            r33 = r6;
            goto L44
        L38:
            r15 = r26;
            goto L40
        L31:
            r14 = r24;
            goto L33
        L27:
            r13 = r23;
            goto L29
        L17:
            r12 = r20;
            goto L19
        L13:
            r11 = r19;
            goto L15
        L9:
            r10 = r18;
            goto L11
        L5:
            r9 = r17;
            goto L7
        }

        public final String component1() {
            return this.recommendId;
        }

        public final PendingIntent component10() {
            return this.intent;
        }

        public final Function0<Unit> component11() {
            return this.onCardClose;
        }

        public final Function0<Unit> component12() {
            return this.onCardShow;
        }

        public final Function1<Integer, Unit> component13() {
            return this.onSessionDestroy;
        }

        public final List<CardActionButton> component14() {
            return this.actionButtons;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.titleMasked;
        }

        public final String component4() {
            return this.content;
        }

        public final Function0<Unit> component5() {
            return this.onIgnoreClick;
        }

        public final Function0<Unit> component6() {
            return this.onExecuteClick;
        }

        public final String component7() {
            return this.executeButtonText;
        }

        public final boolean component8() {
            return this.executeButtonDismissKeyguard;
        }

        public final Function0<Unit> component9() {
            return this.onCardClick;
        }

        public final CardConfig copy(String r18, String r19, String r20, String r21, Function0<Unit> r22, Function0<Unit> r23, String r24, boolean r25, Function0<Unit> r26, PendingIntent r27, Function0<Unit> r28, Function0<Unit> r29, Function1<? super Integer, Unit> r30, List<CardActionButton> r31) {
            Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
            Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
            Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
            Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r28, Function0.class, "com.obric.memorydata.plugin");
            Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r29, Function0.class, "com.obric.memorydata.plugin");
            Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r18, "recommendId");
            Intrinsics.checkNotNullParameter(r19, "title");
            Intrinsics.checkNotNullParameter(r20, "titleMasked");
            Intrinsics.checkNotNullParameter(r21, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r24, "executeButtonText");
            Intrinsics.checkNotNullParameter(r0, "actionButtons");
            return new CardConfig(r18, r19, r20, r21, r7, r8, r24, r25, r11, r27, r13, r14, r15, r0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CardConfig.class) == true) goto L8;
            return false;
        L8:
            CardConfig r6 = (CardConfig) ZeusTransformUtils.preCheckCast(r5, CardConfig.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.recommendId, r6.recommendId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.titleMasked, r6.titleMasked) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.onIgnoreClick, r6.onIgnoreClick) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.onExecuteClick, r6.onExecuteClick) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.executeButtonText, r6.executeButtonText) == true) goto L30;
            return false;
        L30:
            if (this.executeButtonDismissKeyguard == r6.executeButtonDismissKeyguard) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.onCardClick, r6.onCardClick) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.onCardClose, r6.onCardClose) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.onCardShow, r6.onCardShow) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.onSessionDestroy, r6.onSessionDestroy) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.actionButtons, r6.actionButtons) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final List<CardActionButton> getActionButtons() {
            return this.actionButtons;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean getExecuteButtonDismissKeyguard() {
            return this.executeButtonDismissKeyguard;
        }

        public final String getExecuteButtonText() {
            return this.executeButtonText;
        }

        public final PendingIntent getIntent() {
            return this.intent;
        }

        public final Function0<Unit> getOnCardClick() {
            return this.onCardClick;
        }

        public final Function0<Unit> getOnCardClose() {
            return this.onCardClose;
        }

        public final Function0<Unit> getOnCardShow() {
            return this.onCardShow;
        }

        public final Function0<Unit> getOnExecuteClick() {
            return this.onExecuteClick;
        }

        public final Function0<Unit> getOnIgnoreClick() {
            return this.onIgnoreClick;
        }

        public final Function1<Integer, Unit> getOnSessionDestroy() {
            return this.onSessionDestroy;
        }

        public final String getRecommendId() {
            return this.recommendId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTitleMasked() {
            return this.titleMasked;
        }

        public int hashCode() {
            int r0 = ((((((this.recommendId.hashCode() * 31) + this.title.hashCode()) * 31) + this.titleMasked.hashCode()) * 31) + this.content.hashCode()) * 31;
            Function0<Unit> r1 = this.onIgnoreClick;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Function0<Unit> r5 = this.onExecuteClick;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((((r4 + r6) * 31) + this.executeButtonText.hashCode()) * 31) + Boolean.hashCode(this.executeButtonDismissKeyguard)) * 31;
            Function0<Unit> r8 = this.onCardClick;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            PendingIntent r11 = this.intent;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Function0<Unit> r14 = this.onCardClose;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Function0<Unit> r17 = this.onCardShow;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Function1<Integer, Unit> r20 = this.onSessionDestroy;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return ((r19 + r2) * 31) + this.actionButtons.hashCode();
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

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("CardConfig(recommendId=").append(this.recommendId).append(", title=").append(this.title).append(", titleMasked=").append(this.titleMasked).append(", content=").append(this.content).append(", onIgnoreClick=").append(this.onIgnoreClick).append(", onExecuteClick=").append(this.onExecuteClick).append(", executeButtonText=").append(this.executeButtonText).append(", executeButtonDismissKeyguard=").append(this.executeButtonDismissKeyguard).append(", onCardClick=").append(this.onCardClick).append(", intent=").append(this.intent).append(", onCardClose=").append(this.onCardClose).append(", onCardShow=");
            r0.append(this.onCardShow).append(", onSessionDestroy=").append(this.onSessionDestroy).append(", actionButtons=").append(this.actionButtons).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CompatibleCommonCollapseTemplate;", "", "startIcon", "Lcom/obric/livecard/api/entity/Icon;", "endText", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;)V", "getStartIcon", "()Lcom/obric/livecard/api/entity/Icon;", "getEndText", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyText;", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompatibleCommonCollapseTemplate {
        private final AiNotifyText endText;
        private final Icon startIcon;

        /* JADX WARN: Multi-variable type inference failed */
        public CompatibleCommonCollapseTemplate() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public CompatibleCommonCollapseTemplate(Icon r1, AiNotifyText r2) {
            this.startIcon = r1;
            this.endText = r2;
        }

        public /* synthetic */ CompatibleCommonCollapseTemplate(Icon r2, AiNotifyText r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public static /* synthetic */ CompatibleCommonCollapseTemplate copy$default(CompatibleCommonCollapseTemplate r0, Icon r1, AiNotifyText r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.startIcon;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.endText;
        L9:
            return r0.copy(r1, r2);
        }

        public final Icon component1() {
            return this.startIcon;
        }

        public final AiNotifyText component2() {
            return this.endText;
        }

        public final CompatibleCommonCollapseTemplate copy(Icon r1, AiNotifyText r2) {
            return new CompatibleCommonCollapseTemplate(r1, r2);
        }

        public final IslandWidget create() {
            return new IslandWidget(ProactiveLiveCardDisplayTool.COLLAPSE_TEMPLATE_ID, this, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CompatibleCommonCollapseTemplate.class) == true) goto L8;
            return false;
        L8:
            CompatibleCommonCollapseTemplate r6 = (CompatibleCommonCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, CompatibleCommonCollapseTemplate.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.startIcon, r6.startIcon) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.endText, r6.endText) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final AiNotifyText getEndText() {
            return this.endText;
        }

        public final Icon getStartIcon() {
            return this.startIcon;
        }

        public int hashCode() {
            Icon r0 = this.startIcon;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            AiNotifyText r4 = this.endText;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "CompatibleCommonCollapseTemplate(startIcon=" + this.startIcon + ", endText=" + this.endText + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CompatibleButtonLists;", "", "legacy", "", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyButton;", "intermediate", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$AiNotifyModernTextButton;", "latest", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLegacy", "()Ljava/util/List;", "getIntermediate", "getLatest", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<AiNotifyButton> f6445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<AiNotifyModernTextButton> f6446b;
        private final List<ButtonV2> c;

        public a(List<AiNotifyButton> r3, List<AiNotifyModernTextButton> r4, List<ButtonV2> r5) {
            List<AiNotifyButton> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<AiNotifyModernTextButton> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<ButtonV2> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "legacy");
            Intrinsics.checkNotNullParameter(r7, "intermediate");
            Intrinsics.checkNotNullParameter(r8, "latest");
            this.f6445a = r6;
            this.f6446b = r7;
            this.c = r8;
        }

        public final List<AiNotifyButton> a() {
            return this.f6445a;
        }

        public final List<AiNotifyModernTextButton> b() {
            return this.f6446b;
        }

        public final List<ButtonV2> c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6445a, r6.f6445a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6446b, r6.f6446b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f6445a.hashCode() * 31) + this.f6446b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "CompatibleButtonLists(legacy=" + this.f6445a + ", intermediate=" + this.f6446b + ", latest=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "", "resourceId", "", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f6447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ColorToken f6448b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public b(Integer r1, ColorToken r2) {
            this.f6447a = r1;
            this.f6448b = r2;
        }

        public /* synthetic */ b(Integer r2, ColorToken r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final ColorToken a() {
            return this.f6448b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6447a, r6.f6447a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6448b, r6.f6448b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f6447a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ColorToken r4 = this.f6448b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "HostColor(resourceId=" + this.f6447a + ", color=" + this.f6448b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColorHex;", "", "light", "", "night", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLight", "()Ljava/lang/String;", "getNight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6450b;

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "light");
            Intrinsics.checkNotNullParameter(r3, "night");
            this.f6449a = r2;
            this.f6450b = r3;
        }

        public final String a() {
            return this.f6449a;
        }

        public final String b() {
            return this.f6450b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6449a, r6.f6449a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6450b, r6.f6450b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6449a.hashCode() * 31) + this.f6450b.hashCode();
        }

        public String toString() {
            return "HostColorHex(light=" + this.f6449a + ", night=" + this.f6450b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColors;", "", "primaryText", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "descriptionText", "buttonForeground", "buttonBackground", "<init>", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;)V", "getPrimaryText", "()Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "getDescriptionText", "getButtonForeground", "getButtonBackground", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f6451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f6452b;
        private final b c;
        private final b d;

        public d() {
            this(null, null, null, null, 15, null);
        }

        public d(b r2, b r3, b r4, b r5) {
            Intrinsics.checkNotNullParameter(r2, "primaryText");
            Intrinsics.checkNotNullParameter(r3, "descriptionText");
            Intrinsics.checkNotNullParameter(r4, "buttonForeground");
            Intrinsics.checkNotNullParameter(r5, "buttonBackground");
            this.f6451a = r2;
            this.f6452b = r3;
            this.c = r4;
            this.d = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ d(b r3, b r4, b r5, b r6, int r7, DefaultConstructorMarker r8) {
            int r0 = 3;
            Integer r1 = null;
            Object[] r2 = 0;
            Object[] r9 = 0;
            Object[] r10 = 0;
            Object[] r11 = 0;
            Object[] r12 = 0;
            Object[] r13 = 0;
            Object[] r14 = 0;
            Object[] r15 = 0;
            Object[] r16 = 0;
            Object[] r17 = 0;
            Object[] r18 = 0;
            if ((r7 & 1) == 0) goto L6;
            r3 = new b(r1, r18 == true ? 1 : 0, r0, r17 == true ? 1 : 0);
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = new b(r16 == true ? 1 : 0, r15 == true ? 1 : 0, r0, r14 == true ? 1 : 0);
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = new b(r13 == true ? 1 : 0, r12 == true ? 1 : 0, r0, r11 == true ? 1 : 0);
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = new b(r10 == true ? 1 : 0, r9 == true ? 1 : 0, r0, r2 == true ? 1 : 0);
        L14:
            this(r3, r4, r5, r6);
        }

        public final b a() {
            return this.f6451a;
        }

        public final b b() {
            return this.f6452b;
        }

        public final b c() {
            return this.c;
        }

        public final b d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6451a, r6.f6451a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6452b, r6.f6452b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f6451a.hashCode() * 31) + this.f6452b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "HostColors(primaryText=" + this.f6451a + ", descriptionText=" + this.f6452b + ", buttonForeground=" + this.c + ", buttonBackground=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\r\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\fH\u0002J'\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J.\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0 H\u0082\b¢\u0006\u0002\u0010!J\f\u0010\"\u001a\u00020#*\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostThemeResourceBridge;", "", "<init>", "()V", "ZEUS_CLASS_NAME", "", "GET_APP_APPLICATION_METHOD", "log", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "resolveColors", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColors;", "resolveUiNightMode", "", "()Ljava/lang/Integer;", "resolveColor", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColor;", "hostApplication", "resourceName", "blendResourceName", "fluidResourceName", "resolveHex", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$HostColorHex;", "resourceId", "resolveColorForMode", "nightMode", "(Ljava/lang/Object;II)Ljava/lang/Integer;", "resolveResourceId", "rawHostApplication", "reflectOrNull", ExifInterface.GPS_DIRECTION_TRUE, "code", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toSdkColorHex", "Lcom/obric/livecard/api/entity/ColorHex;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6453a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.obric.memorydata.middleware.api.logging.o f6454b = null;

        static {
            f6453a = new e();
            f6454b = com.obric.memorydata.middleware.api.logging.r.f11633a.a("LiveCardTheme");
        }

        private e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final b a(Object r4, String r5) {
            int r6 = b(r4, r5);
            int r0 = 3;
            Integer r1 = null;
            Object[] r2 = 0;
            Object[] r3 = 0;
            Object[] r7 = 0;
            Object[] r8 = 0;
            Object[] r9 = 0;
            if (r6 == 0) goto L5;
            c r10 = a(r4, r6);
            if (r10 != null) goto L11;
            return new b(r7 == true ? 1 : 0, r3 == true ? 1 : 0, r0, r2 == true ? 1 : 0);
        L11:
            return new b(Integer.valueOf(r6), new ColorToken(a(r10), a(r10)));
        L5:
            return new b(r1, r9 == true ? 1 : 0, r0, r8 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final b a(Object r4, String r5, String r6) {
            int r7 = b(r4, r5);
            int r8 = b(r4, r6);
            int r0 = 3;
            Integer r1 = null;
            Object[] r2 = 0;
            Object[] r3 = 0;
            Object[] r9 = 0;
            Object[] r10 = 0;
            Object[] r11 = 0;
            Object[] r12 = 0;
            Object[] r13 = 0;
            Object[] r14 = 0;
            if (r7 == 0) goto L17;
            if (r8 == 0) goto L17;
            c r15 = a(r4, r7);
            if (r15 == null) goto L9;
            c r16 = a(r4, r8);
            if (r16 != null) goto L15;
            return new b(r12 == true ? 1 : 0, r11 == true ? 1 : 0, r0, r10 == true ? 1 : 0);
        L15:
            return new b(Integer.valueOf(r7), new ColorToken(a(r15), a(r16)));
        L9:
            return new b(r1, r14 == true ? 1 : 0, r0, r13 == true ? 1 : 0);
        L17:
            return new b(r9 == true ? 1 : 0, r3 == true ? 1 : 0, r0, r2 == true ? 1 : 0);
        }

        private final c a(Object r4, int r5) {
            Integer r0 = a(r4, r5, 16);
            if (r0 == null) goto L8;
            int r1 = r0.intValue();
            Integer r3 = a(r4, r5, 32);
            if (r3 == null) goto L8;
            int r6 = r3.intValue();
            return ProactiveLiveCardDisplayTool.INSTANCE.hostColorHex$ai_proactive_impl_obricRelease(r1, r6);
        L8:
            return null;
        }

        private final ColorHex a(c r2) {
            return new ColorHex(r2.a(), r2.b());
        }

        private final Integer a(Object r8, int r9, int r10) {
            Object r7 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r8, Context.class, "getResources");
            if (r7 != null) goto L5;
            return null;
        L5:
            Object r11 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r7, Resources.class, "getConfiguration");
            if (ZeusTransformUtils.instanceOf(r11, Configuration.class) == false) goto L8;
            Configuration r12 = (Configuration) ZeusTransformUtils.preCheckCast(r11, Configuration.class, "com.obric.memorydata.plugin");
        L9:
            if (r12 != null) goto L11;
            return null;
        L11:
            Configuration r2 = new Configuration(r12);
            r2.uiMode = (r2.uiMode & (-49)) | r10;
            Object r13 = Context.class.getMethod("createConfigurationContext", new Class[]{Configuration.class}).invoke(r8, new Object[]{r2});
            if (r13 != null) goto L14;
            return null;
        L14:
            Object r14 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r13, Context.class, "getResources");
            if (r14 != null) goto L17;
            return null;
        L17:
            Object r15 = Resources.class.getMethod("getColor", new Class[]{Integer.TYPE, Resources.Theme.class}).invoke(r14, new Object[]{Integer.valueOf(r9), ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r13, Context.class, "getTheme")});
            if (ZeusTransformUtils.instanceOf(r15, Integer.class) == true) goto L20;
            return null;
        L20:
            return (Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.memorydata.plugin");
        L8:
            r12 = null;
            goto L9
        }

        private final int b(Object r10, String r11) {
            Object r9 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r10, Context.class, "getResources");
            if (r9 != null) goto L5;
            return 0;
        L5:
            Object r12 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r10, Context.class, "getPackageName");
            Integer r3 = null;
            if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L8;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        L9:
            if (r13 != null) goto L11;
            return 0;
        L11:
            Object r14 = Resources.class.getMethod("getIdentifier", new Class[]{String.class, String.class, String.class}).invoke(r9, new Object[]{r11, TypedValues.Custom.S_COLOR, r13});
            if (ZeusTransformUtils.instanceOf(r14, Integer.class) == false) goto L14;
            r3 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin");
        L14:
            if (r3 != null) goto L16;
            return 0;
        L16:
            return r3.intValue();
        L8:
            r13 = null;
            goto L9
        }

        private final Object c() {
            return ZeusTransformUtils.forName("com.volcengine.zeus.Zeus", "com.obric.memorydata.plugin").getMethod("getAppApplication", new Class[0]).invoke(null, new Object[0]);
        }

        public final d a() {
            d r1 = null;
            e r2 = f6453a;     // Catch: SecurityException -> L8 ReflectiveOperationException -> L9
            Object r3 = r2.c();     // Catch: SecurityException -> L8 ReflectiveOperationException -> L9
            if (r3 == null) goto L11;
            r1 = new d(r2.a(r3, "oui_on_accent_text_1"), r2.a(r3, ProactiveLiveCardDisplayTool.HOST_DESCRIPTION_TEXT_COLOR), r2.a(r3, ProactiveLiveCardDisplayTool.HOST_BUTTON_FOREGROUND_BLEND_COLOR, "oui_on_accent_text_1"), r2.a(r3, ProactiveLiveCardDisplayTool.HOST_BUTTON_BACKGROUND_BLEND_COLOR, ProactiveLiveCardDisplayTool.HOST_BUTTON_BACKGROUND_FLUID_COLOR));     // Catch: SecurityException -> L8 ReflectiveOperationException -> L9
            goto L11
        L11:
            if (r1 == null) goto L13;
            return r1;
        L13:
            return new d(null, null, null, null, 15, null);
        L9:
            com.obric.memorydata.middleware.api.logging.o r9 = f6454b;
            com.obric.memorydata.middleware.api.logging.e r8 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            com.obric.memorydata.middleware.api.logging.f r4 = new com.obric.memorydata.middleware.api.logging.g().a();
            String r5 = "宿主主题反射边界不可用";
        L10:
            r9.a("livecard_host_theme_colors_unavailable", r5, r8, r4);
        L8:
            r9 = f6454b;
            r8 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            r4 = new com.obric.memorydata.middleware.api.logging.g().a();
            r5 = "宿主主题反射边界访问受限";
            goto L10
        }

        public final Integer b() {
            Object r1 = f6453a.c();     // Catch: SecurityException -> L17 ReflectiveOperationException -> L18
            if (r1 == null) goto L23;
            Object r2 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r1, Context.class, "getResources");     // Catch: SecurityException -> L17 ReflectiveOperationException -> L18
            if (r2 == null) goto L24;
            Object r3 = ProactiveLiveCardDisplayTool.INSTANCE.invokePublicApiNoArg$ai_proactive_impl_obricRelease(r2, Resources.class, "getConfiguration");     // Catch: SecurityException -> L17 ReflectiveOperationException -> L18
            if (ZeusTransformUtils.instanceOf(r3, Configuration.class) == false) goto L12;
            Configuration r4 = (Configuration) ZeusTransformUtils.preCheckCast(r3, Configuration.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L17 ReflectiveOperationException -> L18
        L13:
            if (r4 == null) goto L25;
        L26:
            return Integer.valueOf(r4.uiMode & 48);
        L25:
            return null;
        L12:
            r4 = null;
            goto L13
        L24:
            return null;
        L23:
            return null;
        L18:
            com.obric.memorydata.middleware.api.logging.o r5 = f6454b;
            com.obric.memorydata.middleware.api.logging.e r8 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            com.obric.memorydata.middleware.api.logging.f r6 = new com.obric.memorydata.middleware.api.logging.g().a();
            String r7 = "宿主主题反射边界不可用";
        L19:
            r5.a("livecard_host_night_mode_unavailable", r7, r8, r6);
            return null;
        L17:
            r5 = f6454b;
            r8 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            r6 = new com.obric.memorydata.middleware.api.logging.g().a();
            r7 = "宿主主题反射边界访问受限";
            goto L19
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$buildSession$session$2", "Lcom/obric/livecard/api/IslandCardCallback;", "onSessionActive", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "onSessionCreate", "onSessionDestroy", InfoRequestQPSOptTraceLogger.REASON, "", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Integer;)V", "onSessionInactive", "onSessionStatusChanged", "status", "onSessionDisplayStatusChanged", "onWidgetShow", "Landroid/os/Bundle;", "widget", "Lcom/obric/livecard/api/entity/IslandWidget;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements IslandCardCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CardConfig f6455a;

        f(CardConfig r1) {
            this.f6455a = r1;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionActive(IslandSession r7) {
            Intrinsics.checkNotNullParameter(r7, "session");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveLiveCardDisplayTool.TAG, "Session active for recommendId: " + this.f6455a.getRecommendId(), false, 4, null);
            Function0<Unit> r6 = this.f6455a.getOnCardShow();
            if (r6 == null) goto L6;
            r6.invoke();
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionCreate(IslandSession r1) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDestroy(IslandSession r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r7, "session");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveLiveCardDisplayTool.TAG, "Session destroyed for recommendId: " + this.f6455a.getRecommendId(), false, 4, null);
            Function1<Integer, Unit> r6 = this.f6455a.getOnSessionDestroy();
            if (r6 == null) goto L6;
            r6.invoke(r8);
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDisplayStatusChanged(IslandSession r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "session");
            if (r8 != 2) goto L8;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveLiveCardDisplayTool.TAG, "Session display status changed to NOTIFICATION_HIDE for recommendId: " + this.f6455a.getRecommendId(), false, 4, null);
            Function0<Unit> r6 = this.f6455a.getOnCardClose();
            if (r6 == null) goto L9;
            r6.invoke();
            return;
        L9:
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionInactive(IslandSession r1) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionStatusChanged(IslandSession r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public Bundle onWidgetShow(IslandWidget r1) {
            Intrinsics.checkNotNullParameter(r1, "widget");
            return null;
        }
    }

    static {
        INSTANCE = new ProactiveLiveCardDisplayTool();
    }

    private ProactiveLiveCardDisplayTool() {
    }

    public static /* synthetic */ AiNotifyTemplateData buildAiNotifyTemplateData$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool r7, CardConfig r8, String r9, d r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L6;
        r10 = new d(null, null, null, null, 15, null);
    L6:
        return r7.buildAiNotifyTemplateData$ai_proactive_impl_obricRelease(r8, r9, r10);
    }

    public static /* synthetic */ IslandWidget buildCollapseWidget$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool r7, String r8, String r9, d r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L6;
        r10 = new d(null, null, null, null, 15, null);
    L6:
        return r7.buildCollapseWidget$ai_proactive_impl_obricRelease(r8, r9, r10);
    }

    private final a buildCompatibleAiNotifyButtons(CardConfig r17, d r18) {
        List<CardActionButton> r0 = r17.getActionButtons();
        if (r0.isEmpty() == true) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        CardActionButton r5 = (CardActionButton) ZeusTransformUtils.preCheckCast(r3.next(), CardActionButton.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.getStyleType(), "fullCenter") == false) goto L12;
        int r6 = 300;
    L13:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
        ProactiveLiveCardDisplayTool r14 = INSTANCE;
        int r9 = r6;
        r13.add(r14.createButton(r5.getId(), r9, r5.getText(), r5.getDismissKeyguard(), r5.getStyleType()));
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(r14.createModernTextButton(r5.getId(), r9, r5.getText(), r5.getDismissKeyguard(), r5.getStyleType(), r18));
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(r14.createButtonV2(r5.getId(), r9, r5.getText(), r5.getDismissKeyguard(), r18));
        goto L8
    L12:
        r6 = 146;
        goto L13
    L15:
        return new a(r1, r2, r4);
    L5:
        return new a(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public static /* synthetic */ AiNotifyTemplateData buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool r7, CardConfig r8, String r9, d r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L6;
        r10 = new d(null, null, null, null, 15, null);
    L6:
        return r7.buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease(r8, r9, r10);
    }

    private final IslandWidget buildInteractiveAiNotifyWidget(final CardConfig r17, AiNotifyTemplateData r18, Function1<? super String, Unit> r19) {
        final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        IslandWidget r15 = new IslandWidget("com.obric.island_assistant:ai_notification_template", r18, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        r15.addOnViewClickCallback("ignore", new $$Lambda$ProactiveLiveCardDisplayTool$PtasydepoGptHz9K8rUJq6F5ys(r17));
        r15.addOnViewClickCallback("execute", new $$Lambda$ProactiveLiveCardDisplayTool$rMrfs5xMoCgMb9iXjrwBNmVvY(r17));
        r15.addOnViewClickCallback("title", new $$Lambda$ProactiveLiveCardDisplayTool$MZieLuEZnExkVbAbvT2WtLPJQ0c(r1));
        r15.addOnViewClickCallback("description", new $$Lambda$ProactiveLiveCardDisplayTool$HD804k2JY5VwI8rnniV3pREgeG0(r1));
        r15.addOnViewClickCallback("leftIcon", new $$Lambda$ProactiveLiveCardDisplayTool$uHNhsxvkxWCG_1CpfUNnAN3ldo(r1));
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r17.getActionButtons(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        final CardActionButton r4 = (CardActionButton) ZeusTransformUtils.preCheckCast(r3.next(), CardActionButton.class, "com.obric.memorydata.plugin");
        r15.addOnViewClickCallback(r4.getId(), new $$Lambda$ProactiveLiveCardDisplayTool$WQCqtKMbNykd3biPyKMDvTcVb4(r4, r17));
        goto L4
    L6:
        r15.setOnCardClickCallback(new $$Lambda$ProactiveLiveCardDisplayTool$_lueiIlpYa9eG6js4A2A402IiBI(r1));
        return r15;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$10(Function1 r2) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke("expanded card");
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$3(CardConfig r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Clicked ignore button on lock screen recommendation: " + r7.getRecommendId(), false, 4, null);
        Function0<Unit> r8 = r7.getOnIgnoreClick();
        if (r8 == null) goto L6;
        r8.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$4(CardConfig r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Clicked execute button on lock screen recommendation: " + r7.getRecommendId(), false, 4, null);
        Function0<Unit> r8 = r7.getOnExecuteClick();
        if (r8 == null) goto L6;
        r8.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$5(Function1 r2) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke("title area");
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$6(Function1 r2) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke("description area");
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$7(Function1 r2) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke("icon area");
        return Unit.INSTANCE;
    }

    private static final Unit buildInteractiveAiNotifyWidget$lambda$11$lambda$9$lambda$8(CardActionButton r7, CardConfig r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Clicked action button=" + r7.getId() + " on lock screen recommendation: " + r8.getRecommendId(), false, 4, null);
        r7.getOnClick().invoke();
        return Unit.INSTANCE;
    }

    private static final Unit buildSession$lambda$0(CardConfig r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, AILabCheckPermissionTask.KEY_SOURCE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Clicked " + r8 + " on lock screen recommendation: " + r7.getRecommendId(), false, 4, null);
        Function0<Unit> r9 = r7.getOnCardClick();
        if (r9 == null) goto L6;
        r9.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit buildSession$lambda$2$lambda$1(Function1 r2) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke("collapse card");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AiNotifyModernTextButton buttonV2ToIntermediate(ButtonV2 r23) {
        Text r0 = r23.getText();
        Integer r1 = null;
        Object[] r2 = 0;
        if (r0 == null) goto L5;
        String r3 = r0.getText();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        AiNotifyText r4 = compatibleText$default(this, r3, null, 14, "rgba(255, 255, 255, 0.90)", "rgba(0, 0, 0, 0.90)", "400", 20, null, new b(r1, r23.getForegroundColor(), 1, r2 == true ? 1 : 0), 130, null);
        Integer r5 = r23.getHeight();
        Integer r6 = r23.getWidth();
        String r7 = r23.getId();
        Boolean r8 = r23.getDismissKeyguard();
        String r9 = r23.getBackgroundIcon();
        ColorToken r10 = r23.getBackgroundColor();
        Integer r11 = r23.getWidth();
        if (r11 != null) goto L12;
    L14:
        String r12 = "left";
    L16:
        return new AiNotifyModernTextButton(r4, r5, r6, r7, r8, r9, r10, r12);
    L12:
        if (r11.intValue() != 300) goto L14;
        r12 = "fullCenter";
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    private final AiNotifyButton buttonV2ToLegacy(ButtonV2 r12) {
        String r0 = r12.getId();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        Integer r1 = r12.getWidth();
        if (r1 == null) goto L9;
        int r3 = r1.intValue();
    L10:
        int r4 = r3;
        Integer r5 = r12.getHeight();
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L14:
        int r7 = r6;
        String r8 = r12.getIcon();
        if (r8 != null) goto L17;
        String r9 = "";
    L18:
        Text r10 = r12.getText();
        if (r10 == null) goto L21;
        String r11 = r10.getText();
    L22:
        if (r11 != null) goto L24;
        String r13 = "";
    L25:
        Boolean r14 = r12.getDismissKeyguard();
        if (r14 == null) goto L28;
        boolean r15 = r14.booleanValue();
    L29:
        boolean r16 = r15;
        AiNotifyTextIconStyle r17 = new AiNotifyTextIconStyle(14, "rgba(255, 255, 255, 0.90)", "rgba(0, 0, 0, 0.90)", LEGACY_BUTTON_BACKGROUND_COLOR);
        Integer r18 = r12.getWidth();
        if (r18 != null) goto L33;
    L35:
        String r19 = "left";
    L37:
        return new AiNotifyButton(r2, r4, r7, r9, r13, r16, r17, r19);
    L33:
        if (r18.intValue() != 300) goto L35;
        r19 = "fullCenter";
        goto L37
    L28:
        r15 = false;
        goto L29
    L24:
        r13 = r11;
        goto L25
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = r8;
        goto L18
    L13:
        r6 = 40;
        goto L14
    L9:
        r3 = 146;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    private final AiNotifyText compatibleText(String r12, String r13, int r14, String r15, String r16, String r17, int r18, Integer r19, b r20) {
        return new AiNotifyText(r12, r13, r14, r15, r16, r17, r18, r19, r20.a());
    }

    static /* synthetic */ AiNotifyText compatibleText$default(ProactiveLiveCardDisplayTool r13, String r14, String r15, int r16, String r17, String r18, String r19, int r20, Integer r21, b r22, int r23, Object r24) {
        if ((r23 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r23 & 128) == 0) goto L9;
        Integer r11 = null;
    L11:
        return r13.compatibleText(r14, r5, r16, r17, r18, r19, r20, r11, r22);
    L9:
        r11 = r21;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    private final AiNotifyButton createButton(String r10, int r11, String r12, boolean r13, String r14) {
        return new AiNotifyButton(r10, r11, 40, "", r12, r13, new AiNotifyTextIconStyle(14, "rgba(255, 255, 255, 0.90)", "rgba(0, 0, 0, 0.90)", LEGACY_BUTTON_BACKGROUND_COLOR), r14);
    }

    private final ButtonV2 createButtonV2(String r17, int r18, String r19, boolean r20, d r21) {
        return new ButtonV2(null, new Text(r19, 0, null, null, null, null, null, null, 254, null), 40, Integer.valueOf(r18), r17, Boolean.valueOf(r20), null, null, r21.c().a(), r21.d().a(), null, 1217, null);
    }

    private final AiNotifyModernTextButton createModernTextButton(String r25, int r26, String r27, boolean r28, String r29, d r30) {
        String r6 = null;
        return new AiNotifyModernTextButton(compatibleText$default(this, r27, null, 14, "rgba(255, 255, 255, 0.90)", "rgba(0, 0, 0, 0.90)", "400", 20, null, r30.c(), 130, null), 40, Integer.valueOf(r26), r25, Boolean.valueOf(r28), r6, r30.d().a(), r29, 32, null);
    }

    private final IslandApi ensureIslandService(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 != null) goto L31;
        ProactiveLiveCardDisplayTool r9 = (ProactiveLiveCardDisplayTool) ZeusTransformUtils.preCheckCast(this, ProactiveLiveCardDisplayTool.class, "com.obric.memorydata.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Object r2 = null;
        if (ZeusTransformUtils.instanceOf(r12, Application.class) == false) goto L7;
        Application r13 = (Application) ZeusTransformUtils.preCheckCast(r12, Application.class, "com.obric.memorydata.plugin");
    L8:
        if (r13 != null) goto L29;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("Cannot init ILiveCard because applicationContext is ");
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L14;
        Class<?> r16 = r15.getClass();
        if (r16 == null) goto L14;
        String r17 = r16.getName();
    L15:
        IRunLog.a.a(r3, TAG, r14.append(r17).toString(), null, 4, null);
        return null;
    L14:
        r17 = null;
        goto L15
    L29:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L18
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Island service is null, initializing ILiveCard with application=" + r13.getPackageName(), false, 4, null);     // Catch: Throwable -> L18
        ILiveCard.Companion.getInst().init(r13);     // Catch: Throwable -> L18
        Object r19 = Result.m1421constructorimpl(ILiveCard.Companion.getInst().getIslandService());     // Catch: Throwable -> L18
    L20:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L24;
        RunLog.INSTANCE.error(TAG, "Failed to init ILiveCard before createSession", r110);
    L24:
        if (Result.m1427isFailureimpl(r19) == true) goto L28;
        r2 = r19;
    L28:
        return (IslandApi) ZeusTransformUtils.preCheckCast(r2, IslandApi.class, "com.obric.memorydata.plugin");
    L18:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L7:
        r13 = null;
        goto L8
    L31:
        return r0;
    }

    private final boolean hasCompatibleButtonList(AiNotifyTemplateData r1) {
        if (r1.getButtonList() == null) goto L5;
    L10:
        return true;
    L5:
        if (r1.getTextButtonList() != null) goto L10;
        if (r1.getButtonV2List() != null) goto L10;
        return false;
    }

    private final AiNotifyButton intermediateButtonToLegacy(AiNotifyModernTextButton r11) {
        String r0 = r11.getId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = r0;
        Integer r2 = r11.getWidth();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        int r4 = r3;
        Integer r5 = r11.getHeight();
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
    L13:
        int r7 = r6;
        String r8 = r11.getText().getText();
        Boolean r9 = r11.getDismissKeyguard();
        if (r9 == null) goto L16;
        boolean r10 = r9.booleanValue();
    L18:
        return new AiNotifyButton(r1, r4, r7, "", r8, r10, new AiNotifyTextIconStyle(r11.getText().getTextSize(), r11.getText().getTextColor(), r11.getText().getTextLightColor(), LEGACY_BUTTON_BACKGROUND_COLOR), r11.getStyleType());
    L16:
        r10 = false;
        goto L18
    L12:
        r6 = 40;
        goto L13
    L8:
        r3 = 146;
        goto L9
    }

    private final ButtonV2 intermediateButtonToV2(AiNotifyModernTextButton r15) {
        return new ButtonV2(null, new Text(r15.getText().getText(), 0, null, null, null, null, null, null, 254, null), r15.getHeight(), r15.getWidth(), r15.getId(), r15.getDismissKeyguard(), r15.getBackgroundIcon(), null, r15.getText().getColor(), r15.getColor(), null, 1153, null);
    }

    /* JADX INFO: renamed from: lambda$-uHNhsxvkxWCG_1CpfUNnAN3ldo, reason: not valid java name */
    public static /* synthetic */ Unit m224lambda$uHNhsxvkxWCG_1CpfUNnAN3ldo(Function1 r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$8Ds-nP2E_C6h2sWKmeRtA5DBgow, reason: not valid java name */
    public static /* synthetic */ Unit m225lambda$8DsnP2E_C6h2sWKmeRtA5DBgow(Function1 r0) {
        return buildSession$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Unit lambda$HD804k2JY5VwI8rnniV3pREgeG0(Function1 r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$6(r0);
    }

    public static /* synthetic */ Unit lambda$MZieLuEZnExkVbAbvT2WtLPJQ0c(Function1 r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$Mhk6CkgQYQGGARac-opke9n1XsY, reason: not valid java name */
    public static /* synthetic */ Unit m226lambda$Mhk6CkgQYQGGARacopke9n1XsY(CardConfig r0, String r1) {
        return buildSession$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$PtasydepoGptHz9K8rU-Jq6F5ys, reason: not valid java name */
    public static /* synthetic */ Unit m227lambda$PtasydepoGptHz9K8rUJq6F5ys(CardConfig r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$WQCqtKMbNykd3b-iPyKMDvTcVb4, reason: not valid java name */
    public static /* synthetic */ Unit m228lambda$WQCqtKMbNykd3biPyKMDvTcVb4(CardActionButton r0, CardConfig r1) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit lambda$_lueiIlpYa9eG6js4A2A402IiBI(Function1 r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$10(r0);
    }

    /* JADX INFO: renamed from: lambda$rMrfs5xMoCg-Mb9-iXjrwBNmVvY, reason: not valid java name */
    public static /* synthetic */ Unit m229lambda$rMrfs5xMoCgMb9iXjrwBNmVvY(CardConfig r0) {
        return buildInteractiveAiNotifyWidget$lambda$11$lambda$4(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AiNotifyText legacyButtonTextToIntermediate(AiNotifyButton r13) {
        String r1 = r13.getText();
        int r3 = r13.getTextIconStyle().getTextSize();
        String r4 = r13.getTextIconStyle().getTextColor();
        String r5 = r13.getTextIconStyle().getTextLightColor();
        Object[] r14 = 0 == true ? 1 : 0;
        return compatibleText$default(this, r1, null, r3, r4, r5, "400", 20, null, new b(null, r14, 3, 0 == true ? 1 : 0), 130, null);
    }

    private final AiNotifyModernTextButton legacyButtonToIntermediate(AiNotifyButton r13) {
        String r6 = null;
        ColorToken r7 = null;
        return new AiNotifyModernTextButton(legacyButtonTextToIntermediate(r13), Integer.valueOf(r13.getHeight()), Integer.valueOf(r13.getWidth()), r13.getId(), Boolean.valueOf(r13.getDismissKeyguard()), r6, r7, r13.getStyleType(), 96, null);
    }

    private final ButtonV2 legacyButtonToV2(AiNotifyButton r15) {
        return new ButtonV2(r15.getIcon(), new Text(r15.getText(), 0, null, null, null, null, null, null, 254, null), Integer.valueOf(r15.getHeight()), Integer.valueOf(r15.getWidth()), r15.getId(), Boolean.valueOf(r15.getDismissKeyguard()), null, null, null, null, null, 1984, null);
    }

    public static /* synthetic */ void markSessionAsProcessed$default(ProactiveLiveCardDisplayTool r0, IslandSession r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.markSessionAsProcessed(r1, r2);
    }

    private final ButtonV2 normalizeButtonV2Colors(ButtonV2 r16, d r17) {
        ColorToken r0 = r17.c().a();
        if (r0 != null) goto L5;
        r0 = r16.getForegroundColor();
    L5:
        ColorToken r10 = r0;
        ColorToken r1 = r17.d().a();
        if (r1 != null) goto L9;
        r1 = r16.getBackgroundColor();
    L9:
        return ButtonV2.copy$default(r16, null, null, null, null, null, null, null, null, r10, r1, null, 1279, null);
    }

    private final AiNotifyModernTextButton normalizeIntermediateButtonColors(AiNotifyModernTextButton r24, d r25) {
        AiNotifyText r0 = r24.getText();
        ColorToken r1 = r25.c().a();
        if (r1 != null) goto L5;
        r1 = r24.getText().getColor();
    L5:
        AiNotifyText r13 = AiNotifyText.copy$default(r0, null, null, 0, null, null, null, 0, null, r1, 255, null);
        ColorToken r2 = r25.d().a();
        if (r2 != null) goto L9;
        r2 = r24.getColor();
    L9:
        return AiNotifyModernTextButton.copy$default(r24, r13, null, null, null, null, null, r2, null, BuildConfig.VERSION_CODE, null);
    }

    public static /* synthetic */ AiNotifyTemplateData preserveCompatibleButtonLists$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool r7, AiNotifyTemplateData r8, AiNotifyTemplateData r9, AiNotifyTemplateData r10, d r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r11 = new d(null, null, null, null, 15, null);
    L9:
        return r7.preserveCompatibleButtonLists$ai_proactive_impl_obricRelease(r8, r9, r10, r11);
    }

    public static /* synthetic */ AiNotifyTemplateData refreshTemplateColors$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool r0, AiNotifyTemplateData r1, d r2, AiNotifyTemplateData r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.refreshTemplateColors$ai_proactive_impl_obricRelease(r1, r2, r3);
    }

    private final AiNotifyText withHostColor(AiNotifyText r13, b r14) {
        ColorToken r12 = r14.a();
        if (r12 != null) goto L6;
        r12 = r13.getColor();
    L6:
        return AiNotifyText.copy$default(r13, null, null, 0, null, null, null, 0, null, r12, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AiNotifyTemplateData buildAiNotifyTemplateData$ai_proactive_impl_obricRelease(CardConfig r21, String r22, d r23) {
        Intrinsics.checkNotNullParameter(r21, "config");
        Intrinsics.checkNotNullParameter(r22, "leftIcon");
        Intrinsics.checkNotNullParameter(r23, "hostColors");
        a r16 = buildCompatibleAiNotifyButtons(r21, r23);
        AiNotifyIcon r2 = null;
        return new AiNotifyTemplateData(new AiNotifyIcon(r22, 36, 36), compatibleText$default(this, r21.getTitle(), r21.getTitleMasked(), 14, "#FFFFFF", "#000000", "500", 21, null, r23.a(), 128, null), new AiNotifyDescription(r2, compatibleText$default(this, r21.getContent(), LOCKED_CONTENT_TEXT, 14, "rgba(255, 255, 255, 0.60)", "rgba(0, 0, 0, 0.60)", "400", 18, null, r23.b(), 128, null), 1, 0 == true ? 1 : 0), r16.a(), r16.b(), r16.c());
    }

    public final IslandWidget buildCollapseWidget$ai_proactive_impl_obricRelease(String r20, String r21, d r22) {
        Intrinsics.checkNotNullParameter(r20, "icon");
        Intrinsics.checkNotNullParameter(r21, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "hostColors");
        return new CompatibleCommonCollapseTemplate(new Icon(20, 20, r20, null, null, null, null, false, null, null, null, 1912, null), compatibleText$default(this, r21, null, 13, "#FFFFFF", "#FFFFFF", "400", 18, null, r22.a(), 130, null)).create();
    }

    public final AiNotifyTemplateData buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease(CardConfig r15, String r16, d r17) {
        Intrinsics.checkNotNullParameter(r15, "config");
        Intrinsics.checkNotNullParameter(r16, "leftIcon");
        Intrinsics.checkNotNullParameter(r17, "hostColors");
        a r10 = buildCompatibleAiNotifyButtons(r15, r17);
        return new AiNotifyTemplateData(new AiNotifyIcon(r16, 36, 36), compatibleText(combineExpandedTitleAndContent$ai_proactive_impl_obricRelease(r15.getTitle(), r15.getContent()), combineExpandedTitleAndContent$ai_proactive_impl_obricRelease(r15.getTitleMasked(), LOCKED_CONTENT_TEXT), 14, "#FFFFFF", "#000000", "500", 21, 2, r17.a()), null, r10.a(), r10.b(), r10.c());
    }

    public final IslandSession buildSession(Context r36, final CardConfig r37) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r37, "config");
        String r4 = ResourceUtils.INSTANCE.getDrawable(r2, ZeusTransformUtils.mapRes(R.drawable.ic_livecard_ai_notify_expanded, "drawable", "ic_livecard_ai_notify_expanded"));
        String r5 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r3 = ResourceUtils.INSTANCE.getDrawable(r2, ZeusTransformUtils.mapRes(R.drawable.ic_livecard_ai_notify_collapsed, "drawable", "ic_livecard_ai_notify_collapsed"));
        if (r3 == null) goto L9;
        r5 = r3;
    L9:
        String r6 = resolveCollapsedDisplayText$ai_proactive_impl_obricRelease();
        String r9 = resolveSceneContent$ai_proactive_impl_obricRelease(r37);
        d r7 = resolveHostColors$ai_proactive_impl_obricRelease();
        final Function1<? super String, Unit> r8 = new $$Lambda$ProactiveLiveCardDisplayTool$Mhk6CkgQYQGGARacopke9n1XsY(r37);
        IslandWidget r15 = buildInteractiveAiNotifyWidget(r37, buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease(r37, r4, r7), r8);
        IslandWidget r17 = buildInteractiveAiNotifyWidget(r37, buildAiNotifyTemplateData$ai_proactive_impl_obricRelease(r37, r4, r7), r8);
        IslandWidget r0 = buildCollapseWidget$ai_proactive_impl_obricRelease(r5, r6, r7);
        r0.setOnCardClickCallback(new $$Lambda$ProactiveLiveCardDisplayTool$8DsnP2E_C6h2sWKmeRtA5DBgow(r8));
        PendingIntent r18 = r37.getIntent();
        SuggestionSceneEntity r1 = new SuggestionSceneEntity(SceneType.AI_SUGGESTION, RuntimeState.PROCESSING, r9, null, 8, null);
        LiveCardType r23 = LiveCardType.MEMORY_DATA;
        return new IslandSession(r0, r15, null, r17, r18, (IslandCardCallback) ZeusTransformUtils.preCheckCast(new f(r37), IslandCardCallback.class, "com.obric.memorydata.plugin"), null, 0, r23, null, null, null, 0, null, (ISceneEntity) ZeusTransformUtils.preCheckCast(r1, ISceneEntity.class, "com.obric.memorydata.plugin"), null, 0, 114372, null);
    }

    public final String combineExpandedTitleAndContent$ai_proactive_impl_obricRelease(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r11, r12}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r1 = r14.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r13.add(r1);
        goto L4
    L9:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public final void destroySession(IslandSession r7) {
        Intrinsics.checkNotNullParameter(r7, "session");
        IslandApi r6 = ILiveCard.Companion.getInst().getIslandService();
        if (r6 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Skip destroySession because island service is null", null, 4, null);
        return;
    L6:
        r6.destroySession(r7);
    }

    public final int getLiveCardVersion(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ProactiveLiveCardDisplayTool r4 = (ProactiveLiveCardDisplayTool) ZeusTransformUtils.preCheckCast(this, ProactiveLiveCardDisplayTool.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ILiveCard r7 = ILiveCard.Companion.getInst();     // Catch: Throwable -> L5
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r8, "getApplicationContext(...)");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(Integer.valueOf(r7.getVersion(r8)));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L11;
        RunLog.INSTANCE.warn(TAG, "Failed to get LiveCard version, fallback to no buttons", r10);
    L11:
        if (Result.m1427isFailureimpl(r9) == false) goto L14;
        r9 = 0;
    L14:
        return ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final c hostColorHex$ai_proactive_impl_obricRelease(int r7, int r8) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r9 = String.format(Locale.ROOT, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r7)}, 1));
        Intrinsics.checkNotNullExpressionValue(r9, "format(...)");
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r10 = String.format(Locale.ROOT, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r8)}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(...)");
        return new c(r9, r10);
    }

    public final Object invokePublicApiNoArg$ai_proactive_impl_obricRelease(Object r2, Class<?> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        Intrinsics.checkNotNullParameter(r3, "declaringClass");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        return r3.getMethod(r4, new Class[0]).invoke(r2, new Object[0]);
    }

    @Deprecated(message = "Lock-screen cards now destroy the session instead of showing processed state.")
    public final void markSessionAsProcessed(IslandSession r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "session");
        IslandWidget r3 = r19.getExpandWidget();
        AiNotifyTemplateData r4 = null;
        if (r3 == null) goto L5;
        Object r5 = r3.getTemplateData();
    L7:
        if (ZeusTransformUtils.instanceOf(r5, AiNotifyTemplateData.class) == false) goto L9;
        r4 = (AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r5, AiNotifyTemplateData.class, "com.obric.memorydata.plugin");
    L9:
        AiNotifyTemplateData r8 = r4;
        if (r3 == null) goto L27;
        if (r8 != null) goto L13;
        return;
    L13:
        if (StringsKt.equals(r20, "ignore", true) == false) goto L15;
        String r6 = "已忽略";
    L16:
        AiNotifyButton r7 = new AiNotifyButton("processed", 300, 40, "", r6, false, new AiNotifyTextIconStyle(14, "rgba(255, 255, 255, 0.40)", "rgba(0, 0, 0, 0.40)", "rgba(150, 150, 150, 0.10)"), "fullCenter");
        r3.setTemplateData(AiNotifyTemplateData.copy$default(r8, null, null, null, CollectionsKt.listOf(r7), CollectionsKt.listOf(legacyButtonToIntermediate(r7)), CollectionsKt.listOf(legacyButtonToV2(r7)), 7, null));
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L19
        ProactiveLiveCardDisplayTool r0 = (ProactiveLiveCardDisplayTool) ZeusTransformUtils.preCheckCast(this, ProactiveLiveCardDisplayTool.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r19.update(r3);     // Catch: Throwable -> L19
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L29;
        RunLog.INSTANCE.warn(TAG, "Failed to call session.update for marking processed action=" + r20, r2);
        return;
    L29:
        return;
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    L15:
        r6 = "已处理";
        goto L16
    L27:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final AiNotifyTemplateData preserveCompatibleButtonLists$ai_proactive_impl_obricRelease(AiNotifyTemplateData r12, AiNotifyTemplateData r13, AiNotifyTemplateData r14, d r15) {
        Intrinsics.checkNotNullParameter(r12, "refreshed");
        Intrinsics.checkNotNullParameter(r15, "hostColors");
        AiNotifyTemplateData r0 = null;
        if (r13 != null) goto L5;
    L9:
        if (r14 != null) goto L11;
    L15:
        if (r0 != null) goto L17;
        r13 = r12;
    L18:
        List<ButtonV2> r16 = r13.getButtonV2List();
        if (r16 == null) goto L34;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        r18.add(INSTANCE.normalizeButtonV2Colors((ButtonV2) ZeusTransformUtils.preCheckCast(r19.next(), ButtonV2.class, "com.obric.memorydata.plugin"), r15));
        goto L22
    L24:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r110.iterator();
    L26:
        if (r112.hasNext() == false) goto L28;
        r111.add(buttonV2ToLegacy((ButtonV2) ZeusTransformUtils.preCheckCast(r112.next(), ButtonV2.class, "com.obric.memorydata.plugin")));
        goto L26
    L28:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r115 = r113.iterator();
    L30:
        if (r115.hasNext() == false) goto L33;
        r114.add(buttonV2ToIntermediate((ButtonV2) ZeusTransformUtils.preCheckCast(r115.next(), ButtonV2.class, "com.obric.memorydata.plugin")));
        goto L30
    L33:
        return AiNotifyTemplateData.copy$default(r12, null, null, null, r6, (List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin"), r8, 7, null);
    L34:
        List<AiNotifyModernTextButton> r116 = r13.getTextButtonList();
        if (r116 == null) goto L50;
        Iterable r117 = (Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin");
        Collection r118 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r119 = r117.iterator();
    L38:
        if (r119.hasNext() == false) goto L40;
        r118.add(INSTANCE.normalizeIntermediateButtonColors((AiNotifyModernTextButton) ZeusTransformUtils.preCheckCast(r119.next(), AiNotifyModernTextButton.class, "com.obric.memorydata.plugin"), r15));
        goto L38
    L40:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r118, List.class, "com.obric.memorydata.plugin");
        Iterable r120 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r121 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r122 = r120.iterator();
    L42:
        if (r122.hasNext() == false) goto L44;
        r121.add(intermediateButtonToV2((AiNotifyModernTextButton) ZeusTransformUtils.preCheckCast(r122.next(), AiNotifyModernTextButton.class, "com.obric.memorydata.plugin")));
        goto L42
    L44:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r121, List.class, "com.obric.memorydata.plugin");
        Iterable r123 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r124 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r125 = r123.iterator();
    L46:
        if (r125.hasNext() == false) goto L49;
        r124.add(intermediateButtonToLegacy((AiNotifyModernTextButton) ZeusTransformUtils.preCheckCast(r125.next(), AiNotifyModernTextButton.class, "com.obric.memorydata.plugin")));
        goto L46
    L49:
        return AiNotifyTemplateData.copy$default(r12, null, null, null, (List) ZeusTransformUtils.preCheckCast(r124, List.class, "com.obric.memorydata.plugin"), r7, r9, 7, null);
    L50:
        List<AiNotifyButton> r4 = r13.getButtonList();
        if (r4 == null) goto L67;
        Iterable r126 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r127 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r128 = r126.iterator();
    L54:
        if (r128.hasNext() == false) goto L56;
        r127.add(legacyButtonToV2((AiNotifyButton) ZeusTransformUtils.preCheckCast(r128.next(), AiNotifyButton.class, "com.obric.memorydata.plugin")));
        goto L54
    L56:
        Iterable r129 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r127, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r130 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r131 = r129.iterator();
    L58:
        if (r131.hasNext() == false) goto L60;
        r130.add(INSTANCE.normalizeButtonV2Colors((ButtonV2) ZeusTransformUtils.preCheckCast(r131.next(), ButtonV2.class, "com.obric.memorydata.plugin"), r15));
        goto L58
    L60:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r130, List.class, "com.obric.memorydata.plugin");
        Iterable r132 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r133 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r134 = r132.iterator();
    L62:
        if (r134.hasNext() == false) goto L65;
        r133.add(buttonV2ToIntermediate((ButtonV2) ZeusTransformUtils.preCheckCast(r134.next(), ButtonV2.class, "com.obric.memorydata.plugin")));
        goto L62
    L65:
        return AiNotifyTemplateData.copy$default(r12, null, null, null, r4, (List) ZeusTransformUtils.preCheckCast(r133, List.class, "com.obric.memorydata.plugin"), r10, 7, null);
    L67:
        return AiNotifyTemplateData.copy$default(r12, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 7, null);
    L17:
        r13 = r0;
        goto L18
    L11:
        if (hasCompatibleButtonList(r14) == true) goto L14;
        r14 = null;
    L14:
        r0 = r14;
        goto L15
    L5:
        if (hasCompatibleButtonList(r13) == true) goto L8;
        r13 = null;
    L8:
        if (r13 != null) goto L18;
        goto L9
    }

    public final void refreshSession(IslandSession r7) {
        Intrinsics.checkNotNullParameter(r7, "session");
        IslandApi r6 = ILiveCard.Companion.getInst().getIslandService();
        if (r6 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Skip refreshSession because island service is null", null, 4, null);
        return;
    L6:
        r6.refreshScene(r7);
    }

    public final AiNotifyTemplateData refreshTemplateColors$ai_proactive_impl_obricRelease(AiNotifyTemplateData r12, d r13, AiNotifyTemplateData r14) {
        Intrinsics.checkNotNullParameter(r12, "current");
        Intrinsics.checkNotNullParameter(r13, "hostColors");
        AiNotifyText r0 = r12.getTitle();
        AiNotifyDescription r1 = null;
        if (r0 == null) goto L5;
        AiNotifyText r4 = withHostColor(r0, r13.a());
    L6:
        AiNotifyDescription r2 = r12.getDescription();
        if (r2 == null) goto L9;
        r1 = AiNotifyDescription.copy$default(r2, null, withHostColor(r12.getDescription().getText(), r13.b()), 1, null);
    L9:
        AiNotifyTemplateData r15 = AiNotifyTemplateData.copy$default(r12, null, r4, r1, null, null, null, 57, null);
        return preserveCompatibleButtonLists$ai_proactive_impl_obricRelease(r15, r15, r14, r13);
    L5:
        r4 = null;
        goto L6
    }

    public final String removeLeadingDuplicateTitle$ai_proactive_impl_obricRelease(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r11, "title");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return r10;
    L5:
        String r12 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"**" + r9 + "**", r9}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        Object r5 = null;
        if (r13.hasNext() == false) goto L19;
        Object r2 = r13.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r12, r6) == false) goto L11;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L6;
        r5 = r2;
        goto L19
    L11:
        if (StringsKt.startsWith$default(r12, r6 + '\n', false, 2, null) == true) goto L16;
        if (StringsKt.startsWith$default(r12, r6 + "\r\n", false, 2, null) == true) goto L16;
        r7 = false;
    L19:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L23;
        return r10;
    L23:
        return StringsKt.trimStart(StringsKt.removePrefix(r12, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")), new char[]{'\n', '\r', ' '});
    }

    public final String resolveCollapsedDisplayText$ai_proactive_impl_obricRelease() {
        return COLLAPSED_DISPLAY_TEXT;
    }

    public final String resolveExpandedContent$ai_proactive_impl_obricRelease(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r3, "title");
        if (r4 == true) goto L6;
        return r2;
    L6:
        return removeLeadingDuplicateTitle$ai_proactive_impl_obricRelease(r2, r3);
    }

    public final d resolveHostColors$ai_proactive_impl_obricRelease() {
        return e.f6453a.a();
    }

    public final Integer resolveHostUiNightMode$ai_proactive_impl_obricRelease() {
        return e.f6453a.b();
    }

    public final String resolveSceneContent$ai_proactive_impl_obricRelease(CardConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "config");
        return r1.getTitle();
    }

    public final boolean showSession(Context r7, IslandSession r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r8, "session");
        IslandApi r0 = ensureIslandService(r9);
        if (r0 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Failed to create session because island service is null", null, 4, null);
        return false;
    L18:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        ProactiveLiveCardDisplayTool r6 = (ProactiveLiveCardDisplayTool) ZeusTransformUtils.preCheckCast(this, ProactiveLiveCardDisplayTool.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(r0.createSession(r8, r9)));     // Catch: Throwable -> L8
    L11:
        if (Result.m1428isSuccessimpl(r10) == false) goto L13;
        ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Successfully requested createSession", false, 4, null);
    L13:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L17;
        RunLog.INSTANCE.error(TAG, "Failed to create session", r11);
    L17:
        return Result.m1428isSuccessimpl(r10);
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
