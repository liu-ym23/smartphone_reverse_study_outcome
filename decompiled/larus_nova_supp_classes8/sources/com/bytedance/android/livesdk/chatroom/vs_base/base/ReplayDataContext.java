package com.bytedance.android.livesdk.chatroom.vs_base.base;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.danmaku.VSDanmakuContext;
import com.bytedance.android.livesdk.chatroom.widget.k0;
import com.bytedance.android.livesdk.config.gc0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¯\u00012\u00020\u00012\u00020\u0002:\u0002°\u0001B\t¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#R!\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\bR!\u0010*\u001a\b\u0012\u0004\u0012\u00020%0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\bR!\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010#R!\u00101\u001a\b\u0012\u0004\u0012\u00020+0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\u0019R!\u00104\u001a\b\u0012\u0004\u0012\u00020%0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0006\u001a\u0004\b3\u0010\bR!\u00108\u001a\b\u0012\u0004\u0012\u0002050\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0006\u001a\u0004\b7\u0010\u0019R!\u0010<\u001a\b\u0012\u0004\u0012\u0002090\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\u0019R!\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0006\u001a\u0004\b?\u0010\u0019R!\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0006\u001a\u0004\bC\u0010#R!\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0006\u001a\u0004\bF\u0010\bR!\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0006\u001a\u0004\bI\u0010\bR!\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0006\u001a\u0004\bM\u0010#R!\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0006\u001a\u0004\bP\u0010\bR!\u0010U\u001a\b\u0012\u0004\u0012\u00020R0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0006\u001a\u0004\bT\u0010#R!\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0006\u001a\u0004\bX\u0010\u0019R!\u0010]\u001a\b\u0012\u0004\u0012\u00020Z0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0006\u001a\u0004\b\\\u0010\u0019R!\u0010`\u001a\b\u0012\u0004\u0012\u00020 0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0006\u001a\u0004\b_\u0010#R!\u0010c\u001a\b\u0012\u0004\u0012\u00020%0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0006\u001a\u0004\bb\u0010\bR!\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0006\u001a\u0004\be\u0010\bR!\u0010j\u001a\b\u0012\u0004\u0012\u00020g0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0006\u001a\u0004\bi\u0010\bR!\u0010p\u001a\b\u0012\u0004\u0012\u00020l0k8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0006\u001a\u0004\bn\u0010oR!\u0010s\u001a\b\u0012\u0004\u0012\u00020%0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0006\u001a\u0004\br\u0010\bR!\u0010v\u001a\b\u0012\u0004\u0012\u00020%0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0006\u001a\u0004\bu\u0010\bR5\u0010}\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020y\u0012\u0006\u0012\u0004\u0018\u00010z0x0w0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0006\u001a\u0004\b|\u0010#R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0006\u001a\u0004\b\u007f\u0010\bR$\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0006\u001a\u0005\b\u0082\u0001\u0010\bR$\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u0006\u001a\u0005\b\u0085\u0001\u0010\bR$\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0006\u001a\u0005\b\u0087\u0001\u0010\bR$\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0006\u001a\u0005\b\u008a\u0001\u0010\bR%\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0006\u001a\u0005\b\u008d\u0001\u0010#R$\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010\u0006\u001a\u0005\b\u0090\u0001\u0010\bR%\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u00168FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\u0006\u001a\u0005\b\u0094\u0001\u0010\u0019R%\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u00168FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u0006\u001a\u0005\b\u0098\u0001\u0010\u0019R$\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u0006\u001a\u0005\b\u009b\u0001\u0010\bR$\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u001f8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010\u0006\u001a\u0005\b\u009e\u0001\u0010#R$\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0001\u0010\u0006\u001a\u0005\b¡\u0001\u0010\bR$\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0001\u0010\u0006\u001a\u0005\b¤\u0001\u0010\bR$\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0006\u001a\u0005\b§\u0001\u0010#R%\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030©\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bª\u0001\u0010\u0006\u001a\u0005\b«\u0001\u0010#¨\u0006±\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/ReplayDataContext;", "Llm1/b;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "isPortrait$delegate", "Lcom/bytedance/live/datacontext/p;", "isPortrait", "()Lcom/bytedance/live/datacontext/m;", "isFromCache$delegate", "isFromCache", "Lcom/bytedance/live/datacontext/i;", "playDuringUpdateView$delegate", "getPlayDuringUpdateView", "()Lcom/bytedance/live/datacontext/i;", "playDuringUpdateView", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "portraitInteractiveMargin", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getPortraitInteractiveMargin", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/live/datacontext/j;", "playerControllerBottomMargin$delegate", "getPlayerControllerBottomMargin", "()Lcom/bytedance/live/datacontext/j;", "playerControllerBottomMargin", "", "totalStopTime$delegate", "getTotalStopTime", "totalStopTime", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode$delegate", "getEpisode", "()Lcom/bytedance/live/datacontext/n;", "episode", "", "isLongPressSpeed$delegate", "isLongPressSpeed", "seekType$delegate", "getSeekType", "seekType", "Lvlc/d;", "seekMessageManager$delegate", "getSeekMessageManager", "seekMessageManager", "messageManager$delegate", "getMessageManager", "messageManager", "openPanelInReplay$delegate", "getOpenPanelInReplay", "openPanelInReplay", "Lylc/e;", "wrdsManager$delegate", "getWrdsManager", "wrdsManager", "", "vsMsgBoardDataContext$delegate", "getVsMsgBoardDataContext", "vsMsgBoardDataContext", "Lcom/bytedance/android/livesdk/chatroom/widget/k0;", "replayUISizeGetter$delegate", "getReplayUISizeGetter", "replayUISizeGetter", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VideoResolutionItem;", "videoCurrentResolution$delegate", "getVideoCurrentResolution", "videoCurrentResolution", "playerTipsReady$delegate", "getPlayerTipsReady", "playerTipsReady", "videoSpeed$delegate", "getVideoSpeed", "videoSpeed", "Landroid/graphics/Bitmap;", "videoBackgroundBitmap$delegate", "getVideoBackgroundBitmap", "videoBackgroundBitmap", "videoBackgroundReady$delegate", "getVideoBackgroundReady", "videoBackgroundReady", "Landroid/view/ViewGroup$LayoutParams;", "videoContainerPositionInfo$delegate", "getVideoContainerPositionInfo", "videoContainerPositionInfo", "Liq1/a;", "loggerHelper$delegate", "getLoggerHelper", "loggerHelper", "Lcom/bytedance/android/livesdk/chatroom/danmaku/VSDanmakuContext;", "vsDanmakuContext$delegate", "getVsDanmakuContext", "vsDanmakuContext", "vsInteractionDataPrepared$delegate", "getVsInteractionDataPrepared", "vsInteractionDataPrepared", "orientationAfterChanged$delegate", "getOrientationAfterChanged", "orientationAfterChanged", "syncWidgetLoaded$delegate", "getSyncWidgetLoaded", "syncWidgetLoaded", "", "preSeasonId$delegate", "getPreSeasonId", "preSeasonId", "Lcom/bytedance/live/datacontext/k;", "", "videoGiftBehaviorStartLoad$delegate", "getVideoGiftBehaviorStartLoad", "()Lcom/bytedance/live/datacontext/k;", "videoGiftBehaviorStartLoad", "replayOffset$delegate", "getReplayOffset", "replayOffset", "replayDuration$delegate", "getReplayDuration", "replayDuration", "Lh80/d;", "Lkotlin/Pair;", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", "interactionFragmentInfoGetter$delegate", "getInteractionFragmentInfoGetter", "interactionFragmentInfoGetter", "roomFirstFrame$delegate", "getRoomFirstFrame", "roomFirstFrame", "hasSwitched$delegate", "getHasSwitched", "hasSwitched", "isEnterReturned$delegate", "isEnterReturned", "enterErrorCode$delegate", "getEnterErrorCode", "enterErrorCode", "isHDRGuideVideoShow$delegate", "isHDRGuideVideoShow", "Lcom/bytedance/android/livesdk/chatroom/m;", "renderStartMessageOpt$delegate", "getRenderStartMessageOpt", "renderStartMessageOpt", "extensionLoaded$delegate", "getExtensionLoaded", "extensionLoaded", "Lkq1/a;", "paidManager$delegate", "getPaidManager", "paidManager", "Lkq1/c;", "privilegeClarityManager$delegate", "getPrivilegeClarityManager", "privilegeClarityManager", "playFragmentSizeChange$delegate", "getPlayFragmentSizeChange", "playFragmentSizeChange", "castScreenEpisode$delegate", "getCastScreenEpisode", "castScreenEpisode", "interactionRefreshEnd$delegate", "getInteractionRefreshEnd", "interactionRefreshEnd", "shadowPlayerSizeChanged$delegate", "getShadowPlayerSizeChanged", "shadowPlayerSizeChanged", "curTabId$delegate", "getCurTabId", "curTabId", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "widgetManager$delegate", "getWidgetManager", "widgetManager", "<init>", "()V", "Companion", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayDataContext extends DataContext implements lm1.b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "replay_context";
    private final p castScreenEpisode$delegate;
    private final p curTabId$delegate;
    private final p enterErrorCode$delegate;
    private final p episode$delegate;
    private final p extensionLoaded$delegate;
    private final p hasSwitched$delegate;
    private final p interactionFragmentInfoGetter$delegate;
    private final p interactionRefreshEnd$delegate;
    private final p isEnterReturned$delegate;
    private final p isFromCache$delegate;
    private final p isHDRGuideVideoShow$delegate;
    private final p isLongPressSpeed$delegate;
    private final p isPortrait$delegate;
    private final p loggerHelper$delegate;
    private final p messageManager$delegate;
    private final p openPanelInReplay$delegate;
    private final p orientationAfterChanged$delegate;
    private final p paidManager$delegate;
    private final p playDuringUpdateView$delegate;
    private final p playFragmentSizeChange$delegate;
    private final p playerControllerBottomMargin$delegate;
    private final p playerTipsReady$delegate;
    private final NextLiveData<Float> portraitInteractiveMargin;
    private final p preSeasonId$delegate;
    private final p privilegeClarityManager$delegate;
    private final p renderStartMessageOpt$delegate;
    private final p replayDuration$delegate;
    private final p replayOffset$delegate;
    private final p replayUISizeGetter$delegate;
    private final p roomFirstFrame$delegate;
    private final p seekMessageManager$delegate;
    private final p seekType$delegate;
    private final p shadowPlayerSizeChanged$delegate;
    private final p syncWidgetLoaded$delegate;
    private final p totalStopTime$delegate;
    private final p videoBackgroundBitmap$delegate;
    private final p videoBackgroundReady$delegate;
    private final p videoContainerPositionInfo$delegate;
    private final p videoCurrentResolution$delegate;
    private final p videoGiftBehaviorStartLoad$delegate;
    private final p videoSpeed$delegate;
    private final p vsDanmakuContext$delegate;
    private final p vsInteractionDataPrepared$delegate;
    private final p vsMsgBoardDataContext$delegate;
    private final p widgetManager$delegate;
    private final p wrdsManager$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ReplayDataContext a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(ReplayDataContext.class);
            if ((r0 instanceof ReplayDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (ReplayDataContext) r0;
        }

        @JvmStatic
        public static ReplayDataContext b(DataCenter r2) {
            DataContext r0 = null;
            if (r2 == null) goto L5;
            DataContext r3 = com.bytedance.live.datacontext.d.d(r2);
            if ((r3 instanceof ReplayDataContext) == false) goto L14;
            r0 = r3;
        L14:
            return (ReplayDataContext) r0;
        L5:
            if (gc0.a.getValue().booleanValue() == true) goto L7;
            return null;
        L7:
            return a();
        }
    }

    @JvmStatic
    public static final ReplayDataContext getInteractionContext() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final ReplayDataContext getInteractionContext(DataCenter r1) {
        Companion.getClass();
        return a.b(r1);
    }

    public final n<Episode> getCastScreenEpisode() {
        return (n) this.castScreenEpisode$delegate.a(this, $$delegatedProperties[40]);
    }

    public final n<Long> getCurTabId() {
        return (n) this.curTabId$delegate.a(this, $$delegatedProperties[43]);
    }

    public final m<Integer> getEnterErrorCode() {
        return (m) this.enterErrorCode$delegate.a(this, $$delegatedProperties[33]);
    }

    public n<Episode> getEpisode() {
        return (n) this.episode$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> getExtensionLoaded() {
        return (m) this.extensionLoaded$delegate.a(this, $$delegatedProperties[36]);
    }

    public final m<Boolean> getHasSwitched() {
        return (m) this.hasSwitched$delegate.a(this, $$delegatedProperties[31]);
    }

    public final n<h80.d<Pair<Fragment, FragmentManager>>> getInteractionFragmentInfoGetter() {
        return (n) this.interactionFragmentInfoGetter$delegate.a(this, $$delegatedProperties[29]);
    }

    public final m<Boolean> getInteractionRefreshEnd() {
        return (m) this.interactionRefreshEnd$delegate.a(this, $$delegatedProperties[41]);
    }

    public final j<iq1.a> getLoggerHelper() {
        return (j) this.loggerHelper$delegate.a(this, $$delegatedProperties[20]);
    }

    public final j<vlc.d> getMessageManager() {
        return (j) this.messageManager$delegate.a(this, $$delegatedProperties[9]);
    }

    public m<Integer> getOpenPanelInReplay() {
        return (m) this.openPanelInReplay$delegate.a(this, $$delegatedProperties[10]);
    }

    public m<Integer> getOrientationAfterChanged() {
        return (m) this.orientationAfterChanged$delegate.a(this, $$delegatedProperties[23]);
    }

    public final j<kq1.a> getPaidManager() {
        return (j) this.paidManager$delegate.a(this, $$delegatedProperties[37]);
    }

    public final i<Boolean> getPlayDuringUpdateView() {
        return (i) this.playDuringUpdateView$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getPlayFragmentSizeChange() {
        return (m) this.playFragmentSizeChange$delegate.a(this, $$delegatedProperties[39]);
    }

    public final j<Float> getPlayerControllerBottomMargin() {
        return (j) this.playerControllerBottomMargin$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getPlayerTipsReady() {
        return (m) this.playerTipsReady$delegate.a(this, $$delegatedProperties[15]);
    }

    public final m<String> getPreSeasonId() {
        return (m) this.preSeasonId$delegate.a(this, $$delegatedProperties[25]);
    }

    public final j<kq1.c> getPrivilegeClarityManager() {
        return (j) this.privilegeClarityManager$delegate.a(this, $$delegatedProperties[38]);
    }

    public final n<com.bytedance.android.livesdk.chatroom.m> getRenderStartMessageOpt() {
        return (n) this.renderStartMessageOpt$delegate.a(this, $$delegatedProperties[35]);
    }

    public final m<Integer> getReplayDuration() {
        return (m) this.replayDuration$delegate.a(this, $$delegatedProperties[28]);
    }

    public final m<Integer> getReplayOffset() {
        return (m) this.replayOffset$delegate.a(this, $$delegatedProperties[27]);
    }

    public j<k0> getReplayUISizeGetter() {
        return (j) this.replayUISizeGetter$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Boolean> getRoomFirstFrame() {
        return (m) this.roomFirstFrame$delegate.a(this, $$delegatedProperties[30]);
    }

    public n<vlc.d> getSeekMessageManager() {
        return (n) this.seekMessageManager$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<Integer> getSeekType() {
        return (m) this.seekType$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getShadowPlayerSizeChanged() {
        return (m) this.shadowPlayerSizeChanged$delegate.a(this, $$delegatedProperties[42]);
    }

    public final m<Boolean> getSyncWidgetLoaded() {
        return (m) this.syncWidgetLoaded$delegate.a(this, $$delegatedProperties[24]);
    }

    public final m<Long> getTotalStopTime() {
        return (m) this.totalStopTime$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<Bitmap> getVideoBackgroundBitmap() {
        return (n) this.videoBackgroundBitmap$delegate.a(this, $$delegatedProperties[17]);
    }

    public final m<Boolean> getVideoBackgroundReady() {
        return (m) this.videoBackgroundReady$delegate.a(this, $$delegatedProperties[18]);
    }

    public n<ViewGroup.LayoutParams> getVideoContainerPositionInfo() {
        return (n) this.videoContainerPositionInfo$delegate.a(this, $$delegatedProperties[19]);
    }

    public final n<VideoResolutionItem> getVideoCurrentResolution() {
        return (n) this.videoCurrentResolution$delegate.a(this, $$delegatedProperties[14]);
    }

    public k<Unit> getVideoGiftBehaviorStartLoad() {
        return (k) this.videoGiftBehaviorStartLoad$delegate.a(this, $$delegatedProperties[26]);
    }

    public final m<Float> getVideoSpeed() {
        return (m) this.videoSpeed$delegate.a(this, $$delegatedProperties[16]);
    }

    public final j<VSDanmakuContext> getVsDanmakuContext() {
        return (j) this.vsDanmakuContext$delegate.a(this, $$delegatedProperties[21]);
    }

    public final n<Episode> getVsInteractionDataPrepared() {
        return (n) this.vsInteractionDataPrepared$delegate.a(this, $$delegatedProperties[22]);
    }

    public j<Object> getVsMsgBoardDataContext() {
        return (j) this.vsMsgBoardDataContext$delegate.a(this, $$delegatedProperties[12]);
    }

    public final n<RecyclableWidgetManager> getWidgetManager() {
        return (n) this.widgetManager$delegate.a(this, $$delegatedProperties[44]);
    }

    public j<ylc.e> getWrdsManager() {
        return (j) this.wrdsManager$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<Boolean> isEnterReturned() {
        return (m) this.isEnterReturned$delegate.a(this, $$delegatedProperties[32]);
    }

    public final m<Boolean> isFromCache() {
        return (m) this.isFromCache$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isHDRGuideVideoShow() {
        return (m) this.isHDRGuideVideoShow$delegate.a(this, $$delegatedProperties[34]);
    }

    public final m<Integer> isLongPressSpeed() {
        return (m) this.isLongPressSpeed$delegate.a(this, $$delegatedProperties[6]);
    }

    public m<Boolean> isPortrait() {
        return (m) this.isPortrait$delegate.a(this, $$delegatedProperties[0]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "isPortrait", "isPortrait()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "isFromCache", "isFromCache()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "playDuringUpdateView", "getPlayDuringUpdateView()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "playerControllerBottomMargin", "getPlayerControllerBottomMargin()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "totalStopTime", "getTotalStopTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "episode", "getEpisode()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "isLongPressSpeed", "isLongPressSpeed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "seekType", "getSeekType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "seekMessageManager", "getSeekMessageManager()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "messageManager", "getMessageManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "openPanelInReplay", "getOpenPanelInReplay()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "wrdsManager", "getWrdsManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "vsMsgBoardDataContext", "getVsMsgBoardDataContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "replayUISizeGetter", "getReplayUISizeGetter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoCurrentResolution", "getVideoCurrentResolution()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "playerTipsReady", "getPlayerTipsReady()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoSpeed", "getVideoSpeed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoBackgroundBitmap", "getVideoBackgroundBitmap()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoBackgroundReady", "getVideoBackgroundReady()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoContainerPositionInfo", "getVideoContainerPositionInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "loggerHelper", "getLoggerHelper()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "vsDanmakuContext", "getVsDanmakuContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "vsInteractionDataPrepared", "getVsInteractionDataPrepared()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "orientationAfterChanged", "getOrientationAfterChanged()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "syncWidgetLoaded", "getSyncWidgetLoaded()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "preSeasonId", "getPreSeasonId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "videoGiftBehaviorStartLoad", "getVideoGiftBehaviorStartLoad()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "replayOffset", "getReplayOffset()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "replayDuration", "getReplayDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "interactionFragmentInfoGetter", "getInteractionFragmentInfoGetter()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "roomFirstFrame", "getRoomFirstFrame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "hasSwitched", "getHasSwitched()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "isEnterReturned", "isEnterReturned()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "enterErrorCode", "getEnterErrorCode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "isHDRGuideVideoShow", "isHDRGuideVideoShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "renderStartMessageOpt", "getRenderStartMessageOpt()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "extensionLoaded", "getExtensionLoaded()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "paidManager", "getPaidManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "privilegeClarityManager", "getPrivilegeClarityManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "playFragmentSizeChange", "getPlayFragmentSizeChange()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "castScreenEpisode", "getCastScreenEpisode()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "interactionRefreshEnd", "getInteractionRefreshEnd()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "shadowPlayerSizeChanged", "getShadowPlayerSizeChanged()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "curTabId", "getCurTabId()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayDataContext.class, "widgetManager", "getWidgetManager()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public ReplayDataContext() {
        this.isPortrait$delegate = q.d(this, Boolean.TRUE);
        Boolean r0 = Boolean.FALSE;
        this.isFromCache$delegate = q.d(this, r0);
        this.playDuringUpdateView$delegate = ConstantKt.d(this, r0);
        this.portraitInteractiveMargin = new NextLiveData();
        this.playerControllerBottomMargin$delegate = ConstantKt.c(this);
        this.totalStopTime$delegate = q.d(this, 0L);
        this.episode$delegate = q.c(this);
        this.isLongPressSpeed$delegate = q.d(this, 0);
        this.seekType$delegate = q.d(this, -1);
        this.seekMessageManager$delegate = q.b(this, ReplayDataContext$seekMessageManager$2.INSTANCE);
        this.messageManager$delegate = ConstantKt.c(this);
        this.openPanelInReplay$delegate = q.d(this, 0);
        this.wrdsManager$delegate = ConstantKt.b(this, ReplayDataContext$wrdsManager$2.INSTANCE);
        this.vsMsgBoardDataContext$delegate = ConstantKt.c(this);
        this.replayUISizeGetter$delegate = ConstantKt.c(this);
        this.videoCurrentResolution$delegate = q.c(this);
        this.playerTipsReady$delegate = q.d(this, r0);
        this.videoSpeed$delegate = q.d(this, Float.valueOf(1.0f));
        this.videoBackgroundBitmap$delegate = q.c(this);
        this.videoBackgroundReady$delegate = q.d(this, r0);
        this.videoContainerPositionInfo$delegate = q.c(this);
        this.loggerHelper$delegate = ConstantKt.b(this, ReplayDataContext$loggerHelper$2.INSTANCE);
        this.vsDanmakuContext$delegate = ConstantKt.c(this);
        this.vsInteractionDataPrepared$delegate = q.c(this);
        this.orientationAfterChanged$delegate = q.d(this, 1);
        this.syncWidgetLoaded$delegate = q.d(this, r0);
        this.preSeasonId$delegate = q.d(this, "");
        this.videoGiftBehaviorStartLoad$delegate = com.bytedance.live.datacontext.e.b(this);
        this.replayOffset$delegate = q.d(this, 0);
        this.replayDuration$delegate = q.d(this, 0);
        this.interactionFragmentInfoGetter$delegate = q.c(this);
        this.roomFirstFrame$delegate = q.d(this, r0);
        this.hasSwitched$delegate = q.d(this, r0);
        this.isEnterReturned$delegate = q.d(this, r0);
        this.enterErrorCode$delegate = q.d(this, 0);
        this.isHDRGuideVideoShow$delegate = q.d(this, r0);
        this.renderStartMessageOpt$delegate = q.c(this);
        this.extensionLoaded$delegate = q.d(this, r0);
        this.paidManager$delegate = ConstantKt.c(this);
        this.privilegeClarityManager$delegate = ConstantKt.c(this);
        this.playFragmentSizeChange$delegate = q.d(this, r0);
        this.castScreenEpisode$delegate = q.c(this);
        this.interactionRefreshEnd$delegate = q.d(this, r0);
        this.shadowPlayerSizeChanged$delegate = q.d(this, r0);
        this.curTabId$delegate = q.c(this);
        this.widgetManager$delegate = q.c(this);
    }

    public final NextLiveData<Float> getPortraitInteractiveMargin() {
        return this.portraitInteractiveMargin;
    }

    @JvmStatic
    public static final void share(ReplayDataContext r1, DataCenter r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "ctx");
        com.bytedance.live.datacontext.b.a(r1, ReplayDataContext.class);
        if (r2 == null) goto L6;
        com.bytedance.live.datacontext.b.a(r1, r2);
        return;
    }
}
