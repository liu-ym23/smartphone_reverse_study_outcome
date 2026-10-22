package com.obric.aiproactive.ui.entry;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.list.SensingEventDotTone;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0000\u001a \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0000\u001aD\u0010 \u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010$2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0000\u001a/\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u0010-\u001a=\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u00103\u001a\u001e\u00104\u001a\u0004\u0018\u0001002\b\u00105\u001a\u0004\u0018\u0001002\b\u00106\u001a\u0004\u0018\u000100H\u0000\u001a\f\u00107\u001a\u000208*\u000200H\u0002\u001a\f\u00109\u001a\u00020\u0013*\u000200H\u0002\u001a\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0004H\u0002\u001a\u001e\u0010=\u001a\u00020\u00132\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)2\u0006\u0010+\u001a\u00020\u0004H\u0000\u001a$\u0010@\u001a\u0002082\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010A\u001a\u000208H\u0000\u001a\u001a\u0010B\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010A\u001a\u000208H\u0000\u001a0\u0010C\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010A\u001a\u0002082\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0000\u001a\u0012\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020*H\u0002\u001a\"\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\tH\u0000\u001a$\u0010L\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\tH\u0000\u001a\u001a\u0010O\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\tH\u0000\u001a(\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u0013H\u0000\u001a\u0018\u0010U\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010V\u001a\u000208H\u0000\u001a\u0010\u0010W\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a(\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u0002082\u0006\u0010Z\u001a\u0002082\u0006\u0010[\u001a\u0002082\u0006\u0010\\\u001a\u00020\tH\u0000\u001a(\u0010]\u001a\u0002082\u0006\u0010Y\u001a\u0002082\u0006\u0010Z\u001a\u0002082\u0006\u0010[\u001a\u0002082\u0006\u0010^\u001a\u000208H\u0000\u001a \u0010_\u001a\u00020`2\u0006\u0010a\u001a\u0002082\u0006\u0010b\u001a\u0002082\u0006\u0010c\u001a\u000208H\u0000\u001a2\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u00132\u0006\u0010i\u001a\u0002082\b\b\u0002\u0010j\u001a\u000208H\u0000\u001a \u0010k\u001a\u0002082\u0006\u0010l\u001a\u00020\u00132\u0006\u0010m\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u0013H\u0000\u001a\u001e\u0010o\u001a\u0002082\u0006\u0010p\u001a\u0002082\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)H\u0000\u001aB\u0010q\u001a\u0002082\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0)2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020?0)2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020?0)2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u0013H\u0000\u001a\u0018\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u0002082\u0006\u0010|\u001a\u000208H\u0000\u001a\u0010\u0010}\u001a\u0002082\u0006\u0010~\u001a\u000208H\u0000\u001a\u0011\u0010\u007f\u001a\u0002082\u0007\u0010\u0080\u0001\u001a\u00020\u0013H\u0000\u001a:\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0084\u0001\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\t2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\tH\u0000\u001a\u0012\u0010\u0087\u0001\u001a\u0002082\u0007\u0010\u0088\u0001\u001a\u00020\u0019H\u0000\u001a\u0012\u0010\u0089\u0001\u001a\u0002082\u0007\u0010\u0088\u0001\u001a\u00020\u0019H\u0000\u001aA\u0010\u008a\u0001\u001a\u0002082\u0007\u0010\u008b\u0001\u001a\u0002082\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020?0)2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020?0)2\u0007\u0010\u008e\u0001\u001a\u0002082\u0006\u0010A\u001a\u000208H\u0000\u001a \u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020?0)2\u0007\u0010\u0090\u0001\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0004H\u0000\u001a\u0013\u0010\u0091\u0001\u001a\u0002082\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0000\u001a\u001f\u0010\u0094\u0001\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0000\u001a\u001e\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0006\u0010+\u001a\u00020\u00042\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0000\u001a5\u0010\u0099\u0001\u001a\u00030\u0098\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0007\u0010\u009a\u0001\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00042\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0000\u001a5\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0007\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\tH\u0000\u001a#\u0010 \u0001\u001a\u0002082\u0006\u0010G\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002\u001a\u0019\u0010¡\u0001\u001a\u00020\u00042\u0006\u0010G\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004H\u0002\u001a\u001c\u0010¢\u0001\u001a\u00020\u00012\u0007\u0010£\u0001\u001a\u00020\u00042\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002\u001a\u001c\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010¦\u0001\u001a\u00020\u00012\u0007\u0010§\u0001\u001a\u000208H\u0000\u001a$\u0010¨\u0001\u001a\u0002082\u0007\u0010©\u0001\u001a\u0002082\u0007\u0010ª\u0001\u001a\u00020\u00132\u0007\u0010«\u0001\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¬\u0001"}, d2 = {"DEBUG_RECOMMENDATION_PREFIX", "", "DEBUG_INSPIRATION_PREFIX", "NOW_TEMPORARY_STATUS_DURATION_MS", "", "NOW_AGENT_RUNNING_STALE_DURATION_MS", "NOW_CELEBRATION_EXIT_ANIMATION_DURATION_MS", "NOW_CELEBRATION_HOLD_DURATION_MS", "COLLAPSED_AVATAR_FINAL_LEFT_DP", "", "COLLAPSED_AVATAR_FINAL_TOP_DP", "COLLAPSED_AVATAR_FINAL_SIZE_DP", "FIRST_WAKE_FALLBACK_TEXT", "HISTORY_EMPTY_TODAY_FALLBACK_TEXT", "AGENT_LIFECYCLE_EVENT_ECA", "AGENT_LIFECYCLE_EVENT_USER_REQUIREMENT", "SENSING_EVENT_TIME_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "trailingEmojiStart", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "(Ljava/lang/String;)Ljava/lang/Integer;", "resolveNowTitleStyle", "Lcom/obric/aiproactive/ui/entry/NowTitleStyle;", "visualState", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$NowVisualState;", "primaryColor", "secondaryColor", "tertiaryColor", "resolveNowAgentStatusTitleStyle", "status", "Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "resolveNowAgentStatusTitle", "sensingText", "runningText", "completedWithSuggestions", "Lkotlin/Function1;", "completedWithoutSuggestions", "failedText", "resolveNowAgentStatusBarState", "todayRows", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "nowMillis", "activeSuggestionCount", "(Ljava/util/List;JLjava/lang/Integer;)Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "overlayNowAgentRunStatus", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "fallback", "runningStaleDurationMillis", "(Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;JJLjava/lang/Integer;)Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "mergeLatestAgentRun", "current", "candidate", "isTerminalAgentRun", "", "agentRunStateRank", "completedNowAgentStatus", "suggestionCount", "sourceRecordId", "countActiveNowSuggestions", "recommendations", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "shouldShowAgentRunEntry", "celebrationActive", "shouldShowPassiveSensingHint", "resolveNowAgentRunEntryText", "completedText", "parseNowAgentLifecycle", "Lcom/obric/aiproactive/ui/entry/ParsedNowAgentLifecycle;", "row", "calculateStickyListOverlapPx", "progress", "density", "maxOverlapDp", "calculateStickyChromeProgress", "startProgress", "fullProgress", "calculateStickyAvatarProgress", "calculateStickyBlurRevealProgress", "defaultRecyclerTopPx", "scrollY", "blurBottomPx", "revealDistancePx", "shouldSupportNowCollapsibleList", "hasGuidedPreferenceEntry", "shouldRestoreNowPageFromAvatarTap", "shouldInterceptNowListVerticalDrag", "listScrollEnabled", "appBarCollapseEnabled", "appBarFullyCollapsed", "dragDeltaY", "shouldClampNowListAtCollapsedBoundary", "listScrolledFromTop", "resolveNowCelebrationViewportAction", "Lcom/obric/aiproactive/ui/entry/NowCelebrationViewportAction;", "recyclerAtTop", "appBarExpanded", "appBarExpansionRequested", "resolveNowListScrollBehavior", "Lcom/obric/aiproactive/ui/entry/NowListScrollBehavior;", "totalContentHeightPx", "maxItemHeightPx", "availableHeightPx", "allItemsRendered", "forceAppBarCollapse", "shouldEnableNowListCollapse", "lastItemBottomPx", "firstScreenListBottomPx", "bottomSafeSpacePx", "resolveNowProactiveEnabled", "cachedEnabled", "shouldEnableNowHistoryAction", "nowItems", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "celebrationRecommendations", "debugRecommendations", "allPageState", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "sensingRecordCount", "resolveHistoryButtonUiState", "Lcom/obric/aiproactive/ui/entry/HistoryButtonUiState;", "visible", "historyEnabled", "shouldResetNowViewportOnWakeUp", "hasActiveSuggestions", "shouldResetSensingEventsInitialAnchor", "eventCount", "calculateNowMoreMenuLocation", "Lcom/obric/aiproactive/ui/entry/NowMoreMenuLocation;", "anchorWidth", "popupWidth", "horizontalInsetDp", "verticalOverlapDp", "shouldShowVoiceEntry", "state", "shouldShowGradientBackground", "shouldStartNowSensingExitAnimation", "previousHadPendingRecommendations", "previousRecommendations", "currentRecommendations", "celebrationPending", "buildTemporaryMockRecommendations", CommonConsts.COUNT_TYPE, "isTemporaryDebugRecommendation", "dto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "resolveTodaySensingDayAnchorMillis", "zoneId", "Ljava/time/ZoneId;", "buildInitialSensingUiState", "Lcom/obric/aiproactive/ui/entry/NowSensingUiState;", "buildNowSensingUiState", "totalCount", "calculateCollapsedAvatarState", "Lcom/obric/aiproactive/ui/entry/CollapsedAvatarState;", "screenWidthPx", "startCenterYOffsetDp", "startAvatarSizeDp", "isSensingEventInToday", "resolveSensingEventMillis", "formatSensingEventTime", "millis", "resolveWakeUpGate", "Lcom/obric/aiproactive/ui/entry/WakeUpGate;", "userId", "aiProactiveDbReady", "shouldRunAvatarFallbackEndAction", "isBindingAvailable", "resId", "currentPlayingResId", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f6624a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6625a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6626b = null;

        static {
            int[] r0 = new int[NowFeedPageFragment.NowVisualState.values().length];
            r0[NowFeedPageFragment.NowVisualState.SLEEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[NowFeedPageFragment.NowVisualState.SENSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[NowFeedPageFragment.NowVisualState.SUGGESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[NowFeedPageFragment.NowVisualState.CELEBRATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f6625a = r0;
            int[] r1 = new int[NowAgentStatusType.values().length];
            r1[NowAgentStatusType.SENSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[NowAgentStatusType.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[NowAgentStatusType.COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[NowAgentStatusType.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f6626b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6627a;

        public c(Comparator r3) {
            this.f6627a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f6627a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("HH:mm");
        Intrinsics.checkNotNullExpressionValue(r0, "ofPattern(...)");
        f6624a = r0;
    }

    public static final float a(float r3, float r4) {
        if (r4 > 0.0f) goto L9;
        if (r3 > 0.0f) goto L7;
        return 0.0f;
    L7:
        return 1.0f;
    L9:
        return RangesKt.coerceIn(r3 / r4, 0.0f, 1.0f);
    }

    public static /* synthetic */ float a(float r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = 0.06f;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = 0.34f;
    L9:
        return b(r0, r1, r2);
    }

    public static /* synthetic */ float a(float r0, float r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 0.28f;
    L6:
        return a(r0, r1);
    }

    public static final float a(int r1, int r2, int r3, int r4) {
        if (r1 <= 0) goto L9;
        if (r3 <= 0) goto L9;
        if (r4 <= 0) goto L9;
        return RangesKt.coerceIn((r3 - RangesKt.coerceAtLeast(r1 - r2, 0)) / r4, 0.0f, 1.0f);
    L9:
        return 0.0f;
    }

    public static final int a(float r2, float r3, float r4) {
        return (int) ((RangesKt.coerceIn(r2, 0.0f, 1.0f) * r4) * r3);
    }

    public static final int a(List<com.obric.aiproactive.ui.model.j.f> r7, long r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "recommendations");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L5;
    L7:
        Iterator r11 = r10.iterator();
        int r0 = 0;
    L9:
        if (r11.hasNext() == false) goto L29;
        com.obric.aiproactive.ui.model.j.f r3 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (r3.b().getRecommendStatus() == 2) goto L23;
        Long r4 = r3.b().getExpireAtMs();
        if (r4 != null) goto L15;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L23;
    L24:
        if (r6 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L15:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= r8) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == true) goto L20;
        r5 = true;
        goto L21
    L17:
        r12 = false;
    L23:
        r6 = false;
        goto L24
    L29:
        return r0;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return 0;
    }

    public static final long a(long r1, ZoneId r3) {
        Intrinsics.checkNotNullParameter(r3, "zoneId");
        return Instant.ofEpochMilli(r1).atZone(r3).toLocalDate().atStartOfDay(r3).toInstant().toEpochMilli();
    }

    public static /* synthetic */ long a(long r0, ZoneId r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = System.currentTimeMillis();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = ZoneId.systemDefault();
    L9:
        return a(r0, r2);
    }

    private static final long a(com.obric.aiproactive.api.p r4, long r5) {
        if (r4.e() <= 0) goto L6;
        return r4.e();
    L6:
        if (r4.f() <= 0) goto L9;
        return r4.f();
    L9:
        if (r4.b() > 0) goto L11;
        return r5;
    L11:
        return r4.b();
    }

    public static final com.obric.aiproactive.api.g a(com.obric.aiproactive.api.g r4, com.obric.aiproactive.api.g r5) {
        if (r4 != null) goto L4;
        return r5;
    L4:
        if (r5 != null) goto L7;
        return r4;
    L7:
        if (Intrinsics.areEqual(r5.a(), r4.a()) == true) goto L13;
        if (r5.d() >= r4.d()) goto L11;
        return r4;
    L11:
        return r5;
    L13:
        if (a(r4) == false) goto L18;
        if (a(r5) == true) goto L18;
        return r4;
    L18:
        if (a(r5) == false) goto L23;
        if (a(r4) == true) goto L23;
        return r5;
    L23:
        if (r5.e() == r4.e()) goto L29;
        if (r5.e() > r4.e()) goto L27;
        return r4;
    L27:
        return r5;
    L29:
        if (b(r5) >= b(r4)) goto L31;
        return r4;
    L31:
        return r5;
    }

    public static final NowCelebrationViewportAction a(boolean r0, boolean r1, boolean r2) {
        if (r0 == false) goto L10;
        if (r1 == true) goto L11;
        if (r2 == true) goto L9;
        return NowCelebrationViewportAction.REQUEST_APP_BAR_EXPANSION;
    L9:
        return NowCelebrationViewportAction.WAIT_FOR_APP_BAR_EXPANSION;
    L11:
        return NowCelebrationViewportAction.START_CELEBRATION;
    L10:
        return NowCelebrationViewportAction.WAIT_FOR_LIST_TOP;
    }

    public static final WakeUpGate a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        if (r4 == true) goto L18;
        return WakeUpGate.BLOCK;
    L18:
        return WakeUpGate.ALLOW;
    L13:
        return WakeUpGate.BLOCK;
    L8:
        if (Intrinsics.areEqual(r5, "0") == true) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    public static final e a(float r9, float r10, float r11, float r12, float r13) {
        float r14 = RangesKt.coerceIn(r9, 0.0f, 1.0f);
        float r15 = (r12 * r10) + ((r13 / 2.0f) * r10);
        float r2 = 40.0f * r10;
        float r4 = (((r2 / (r13 * r10)) - 1.0f) * r14) + 1.0f;
        float r3 = r2 / 2.0f;
        float r7 = (12.0f * r10) + r3;
        float r8 = (r10 * 56.0f) + r3;
        return new e(r4, (r7 - (r11 / 2.0f)) * r14, (r8 - r15) * r14, r7, r8);
    }

    public static final g a(boolean r2, boolean r3) {
        if (r2 == true) goto L6;
        return new g(false, false, 0.0f);
    L6:
        return new g(true, r3, 1.0f);
    }

    public static final j a(com.obric.aiproactive.api.g r9, j r10, long r11, long r13, Integer r15) {
        Intrinsics.checkNotNullParameter(r10, "fallback");
        if (r9 != null) goto L5;
        return r10;
    L5:
        String r0 = r9.c();
        switch(r0.hashCode()) {
            case -1281977283: goto L25;
            case 945734241: goto L19;
            case 1116313165: goto L12;
            case 1550783935: goto L9;
            default: goto L29;
        };
    L25:
        r0.equals("failed");
        return r10;
    L29:
        return r10;
    L9:
        if (r0.equals("running") == true) goto L15;
        return r10;
    L15:
        if ((r11 - r9.e()) < r13) goto L27;
        return r10;
    L27:
        return new j(NowAgentStatusType.RUNNING, 0, r9.e(), 0, 10, null);
    L12:
        if (r0.equals("waiting") == true) goto L15;
        return r10;
    L19:
        if (r0.equals("succeeded") == false) goto L33;
        if (r15 == null) goto L23;
        int r12 = r15.intValue();
    L28:
        return b(r12, r9.e());
    L23:
        r12 = r9.f();
        goto L28
    L33:
        return r10;
    }

    public static /* synthetic */ j a(com.obric.aiproactive.api.g r7, j r8, long r9, long r11, Integer r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = 1800000;
    L5:
        long r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r13 = null;
    L9:
        return a(r7, r8, r9, r4, r13);
    }

    public static final j a(List<com.obric.aiproactive.api.p> r9, long r10, Integer r12) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "todayRows");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        u r0 = a((com.obric.aiproactive.api.p) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.aiproactive.api.p.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L4;
        r14.add(r0);
        goto L4
    L8:
        u r16 = (u) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), u.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L11;
        String r17 = r16.getType();
        if (Intrinsics.areEqual(r17, CommonConsts.APM_INNER_EVENT_COST_START) == false) goto L16;
        return new j(NowAgentStatusType.RUNNING, 0, r16.a(), 0, 10, null);
    L16:
        if (Intrinsics.areEqual(r17, "finish") == false) goto L22;
        if (r12 == null) goto L19;
        int r18 = r12.intValue();
    L29:
        return b(r18, r16.a());
    L19:
        r18 = r16.b();
        goto L29
    L22:
        return j.f6620a.a();
    L11:
        return j.f6620a.a();
    }

    public static final p a(int r2, int r3, int r4, boolean r5, boolean r6) {
        boolean r0 = false;
        if (r4 > 0) goto L7;
        return new p(false, false, false);
    L7:
        if (r6 == true) goto L9;
        if (r3 > r4) goto L12;
        if (r5 == false) goto L15;
        if (r2 > r4) goto L15;
    L17:
        return new p(r0, r0, r0);
    L15:
        r0 = true;
        goto L17
    L12:
        return new p(true, true, false);
    L9:
        return new p(false, true, true);
    }

    public static final q a(List<com.obric.aiproactive.api.p> r10, int r11, long r12, ZoneId r14) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "todayRows");
        Intrinsics.checkNotNullParameter(r14, "zoneId");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L3:
        int r3 = 0;
        if (r16.hasNext() == false) goto L12;
        Object r2 = r16.next();
        com.obric.aiproactive.api.p r5 = (com.obric.aiproactive.api.p) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.p.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L10:
        if (r3 == 0) goto L3;
        r0.add(r2);
        goto L3
    L8:
        if (a(r5, r12, r14) == false) goto L10;
        r3 = 1;
        goto L10
    L12:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L26;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r18.iterator();
    L16:
        if (r110.hasNext() == false) goto L25;
        Object r1 = r110.next();
        int r4 = r3 + 1;
        if (r3 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        com.obric.aiproactive.api.p r6 = (com.obric.aiproactive.api.p) ZeusTransformUtils.preCheckCast(r1, com.obric.aiproactive.api.p.class, "com.obric.memorydata.plugin");
        String r7 = c(a(r6, r12), r14);
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 != 0) goto L23;
        SensingEventDotTone r9 = SensingEventDotTone.HIGHLIGHT;
    L24:
        r19.add(new com.obric.aiproactive.ui.list.h(r7, r8, r9, "record:" + r6.a()));
        r3 = r4;
        goto L16
    L23:
        r9 = SensingEventDotTone.NORMAL;
        goto L24
    L25:
        List r111 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
    L31:
        com.obric.aiproactive.ui.list.h r112 = (com.obric.aiproactive.ui.list.h) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r111), com.obric.aiproactive.ui.list.h.class, "com.obric.memorydata.plugin");
        return new q(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r112.a() + ' ' + r112.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r111);
    L26:
        String r113 = c(r12, r14);
        if (r11 > 0) goto L29;
        String r114 = "用户唤醒我了！有什么值得重点关注？💬";
    L30:
        r111 = CollectionsKt.listOf(new com.obric.aiproactive.ui.list.h(r113, r114, SensingEventDotTone.HIGHLIGHT, "fallback:" + r11));
        goto L31
    L29:
        r114 = "用户又来监督我了！打起精神来！💪";
        goto L30
    }

    public static /* synthetic */ q a(List r1, int r2, long r3, ZoneId r5, int r6, Object r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = ZoneId.systemDefault();
    L6:
        return a(r4, r2, r3, r5);
    }

    public static final r a(NowFeedPageFragment.NowVisualState r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "visualState");
        int r6 = a.f6625a[r2.ordinal()];
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L12;
        return new r(r3, r3, false);
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return new r(r5, r3, true);
    L15:
        return new r(r4, r3, false);
    }

    public static final r a(j r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        NowAgentStatusType r5 = r2.getType();
        int r6 = a.f6626b[r5.ordinal()];
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L16;
        if (r6 == 4) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return new r(r3, r3, false);
    L15:
        return new r(r4, r3, true);
    }

    private static final u a(com.obric.aiproactive.api.p r11) {
        String r0 = r11.c();
        if (r0 != null) goto L5;
    L33:
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L33;
        JSONObject r2 = new JSONObject(r0);     // Catch: JSONException -> L34
        String r1 = r2.optString("lifecycle_event");
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r3, "ai_proactive_debug_trigger_agent_loop") == false) goto L14;
    L16:
        String r4 = r2.optString("type");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        if (Intrinsics.areEqual(r7, CommonConsts.APM_INNER_EVENT_COST_START) == true) goto L22;
        if (Intrinsics.areEqual(r7, "finish") == true) goto L22;
        return null;
    L22:
        if (r11.f() <= 0) goto L26;
        long r5 = r11.f();
    L32:
        return new u(r11.a(), r7, RangesKt.coerceAtLeast(r2.optInt("suggestion_count", 0), 0), r5);
    L26:
        if (r11.e() <= 0) goto L29;
        r5 = r11.e();
        goto L32
    L29:
        if (r11.b() <= 0) goto L33;
        r5 = r11.b();
        goto L32
    L14:
        if (Intrinsics.areEqual(r3, "ai_proactive_user_requirement_agent_loop") == true) goto L16;
        return null;
    }

    public static final Integer a(String r11) {
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        int r0 = r11.length();
        boolean r2 = false;
    L3:
        if (r0 <= 0) goto L36;
        int r3 = r11.codePointBefore(r0);
        int r4 = r0 - Character.charCount(r3);
        if (126976 > r3) goto L8;
        if (r3 >= 129792) goto L8;
        boolean r8 = true;
    L10:
        if (r8 == true) goto L22;
        if (9728 > r3) goto L14;
        if (r3 >= 10176) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L22;
        if (r3 == 65039) goto L22;
        if (r3 == 8205) goto L22;
        boolean r10 = false;
    L23:
        if (r10 == false) goto L36;
        if (126976 > r3) goto L27;
        if (r3 >= 129792) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == true) goto L34;
        if (9728 > r3) goto L32;
        if (r3 >= 10176) goto L32;
        boolean r5 = true;
    L33:
        if (r5 == true) goto L34;
    L35:
        r0 = r4;
    L32:
        r5 = false;
    L34:
        r2 = true;
    L27:
        r1 = false;
    L14:
        r9 = false;
    L22:
        r10 = true;
    L8:
        r8 = false;
    L36:
        Integer r12 = Integer.valueOf(r0);
        ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 == true) goto L45;
        return null;
    L45:
        return r12;
    }

    public static final String a(j r3, String r4, String r5, Function1<? super Integer, String> r6, String r7, String r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "status");
        Intrinsics.checkNotNullParameter(r4, "sensingText");
        Intrinsics.checkNotNullParameter(r5, "runningText");
        Intrinsics.checkNotNullParameter(r9, "completedWithSuggestions");
        Intrinsics.checkNotNullParameter(r7, "completedWithoutSuggestions");
        Intrinsics.checkNotNullParameter(r8, "failedText");
        NowAgentStatusType r0 = r3.getType();
        int r1 = a.f6626b[r0.ordinal()];
        if (r1 != 1) goto L5;
        return r4;
    L5:
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L14;
        if (r1 != 4) goto L12;
        return r8;
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (r3.a() <= 0) goto L22;
        return (String) ZeusTransformUtils.preCheckCast(r9.invoke(Integer.valueOf(r3.a())), String.class, "com.obric.memorydata.plugin");
    L22:
        return r7;
    L18:
        return r5;
    }

    public static final String a(j r1, boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r3, "sensingText");
        Intrinsics.checkNotNullParameter(r4, "runningText");
        Intrinsics.checkNotNullParameter(r5, "completedText");
        if (r2 == false) goto L5;
        return r5;
    L5:
        NowAgentStatusType r6 = r1.getType();
        int r7 = a.f6626b[r6.ordinal()];
        if (r7 != 1) goto L8;
        return r3;
    L8:
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L20;
        if (r7 != 4) goto L15;
        return r3;
    L15:
        throw new NoWhenBranchMatchedException();
    L20:
        return r5;
    L18:
        return r4;
    }

    public static final List<com.obric.aiproactive.ui.model.j.f> a(int r48, long r49) {
        char r2 = 0;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r48), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L38;
        int r7 = ((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        int r8 = r7 + 1;
        String r12 = "debug-recommend-" + r49 + '_' + r8;
        String r31 = "debug-inspiration-" + r49 + '_' + r8;
        if (r7 != 0) goto L8;
        com.obric.aiproactive.api.b[] r10 = new com.obric.aiproactive.api.b[3];
        r10[r2] = new com.obric.aiproactive.api.b("回复老板", "这里是第一个行动推荐，超出一行就打点...", 0, null, null, false, false, 124, null);
        r10[1] = new com.obric.aiproactive.api.b("同步客户", "这是第二个推荐", 0, null, null, false, false, 124, null);
        r10[2] = new com.obric.aiproactive.api.b("设置提醒", "这是第三个推荐，最多三个", 0, null, null, false, false, 124, null);
        List r11 = CollectionsKt.listOf(r10);
    L9:
        if (r7 == 0) goto L13;
        if (r7 == 1) goto L12;
        String r13 = "已过常规下班时间，若在加班建议不要熬太晚，尽早回家休息补觉，避免持续疲劳损伤身体健康。";
    L14:
        String r45 = r13;
        if (r7 == 0) goto L19;
        if (r7 == 1) goto L18;
        String r14 = "加班时段提醒尽早休息避免持续疲劳";
    L20:
        String r46 = r14;
        String r15 = "debug-task-" + r8;
        String r16 = "debug-subscription-" + r8;
        if (r7 != 0) goto L23;
        String r9 = "👨\u200d💼";
    L24:
        String r17 = r9;
        String r18 = com.obric.aiproactive.api.c.a(com.obric.aiproactive.api.c.c(r11));
        Iterator r410 = r5;
        long r21 = r49 - (((long) r7) * 60000);
        double r23 = 99.0d - ((double) r7);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        String r6 = AutoMemoryViewModel.SOURCE_AI_PROACTIVE;
    L28:
        ProactiveRecommendationDto r47 = new ProactiveRecommendationDto(r12, r15, r16, r45, r17, r18, null, null, null, r21, r23, r46, null, 1, "RUNNING", r6, null, r31, null, null, null, null, null, 0, 0, null, null, 134025472, null);
        String r19 = "09:" + RangesKt.coerceAtLeast(23 - r7, 10);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L31;
        String r20 = "去处理";
    L32:
        String r110 = r20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L35;
        Integer r22 = Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.union, "drawable", "union"));
    L36:
        r4.add(new com.obric.aiproactive.ui.model.j.f(r47, null, r19, r45, r46, r110, r22, 2, null));
        r5 = r410;
        r2 = 0;
        goto L4
    L35:
        r22 = null;
        goto L36
    L31:
        r20 = "知道了";
        goto L32
    L27:
        r6 = "immediate";
        goto L28
    L23:
        r9 = "";
        goto L24
    L18:
        r14 = "天气提醒尽量保持简短，作为卡片中间的内容槽位。";
        goto L20
    L19:
        r14 = "09:23 这是最新一条事件，超长打点时最多展示四行。";
        goto L20
    L12:
        r13 = "今天下午深圳发布了红色暴雨警告，你记得带伞出门，不出门最好。";
        goto L14
    L13:
        r13 = "手机业务群中，陈老板问你什么时候才能回答客户的问题，你已经半小时没有回复老板了。";
        goto L14
    L8:
        r11 = CollectionsKt.emptyList();
        goto L9
    L38:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }

    public static final boolean a(int r0) {
        if (r0 <= 0) goto L4;
        return true;
    L4:
        return false;
    }

    public static final boolean a(ProactiveRecommendationDto r5) {
        Intrinsics.checkNotNullParameter(r5, "dto");
        if (StringsKt.startsWith$default(r5.getRecommendId(), "debug-recommend-", false, 2, null) == true) goto L12;
        String r6 = r5.getInspirationId();
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == true) goto L12;
        return false;
    L7:
        if (StringsKt.startsWith$default(r6, "debug-inspiration-", false, 2, null) != true) goto L9;
        r7 = true;
    L12:
        return true;
    }

    private static final boolean a(com.obric.aiproactive.api.g r2) {
        if (Intrinsics.areEqual(r2.c(), "succeeded") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.c(), "failed") == true) goto L12;
        if (Intrinsics.areEqual(r2.c(), "cancelled") == true) goto L12;
        if (Intrinsics.areEqual(r2.c(), "timed_out") == true) goto L12;
        return false;
    }

    public static final boolean a(com.obric.aiproactive.api.g r3, j r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "status");
        String r1 = null;
        if (r5 == false) goto L8;
        if (r3 == null) goto L7;
        r1 = r3.c();
    L7:
        return Intrinsics.areEqual(r1, "succeeded");
    L8:
        int r6 = a.f6626b[r4.getType().ordinal()];
        if (r6 != 2) goto L11;
        if (r3 == null) goto L18;
        String r7 = r3.c();
    L20:
        if (Intrinsics.areEqual(r7, "running") == true) goto L25;
        if (r3 == null) goto L24;
        r1 = r3.c();
    L24:
        if (Intrinsics.areEqual(r1, "waiting") == true) goto L25;
        return false;
    L25:
        return true;
    L18:
        r7 = null;
        goto L20
    L11:
        if (r6 != 3) goto L29;
        if (r3 == null) goto L27;
        r1 = r3.c();
    L27:
        return Intrinsics.areEqual(r1, "succeeded");
    L29:
        return false;
    }

    private static final boolean a(com.obric.aiproactive.api.p r2, long r3, ZoneId r5) {
        long r0 = a(r2, r3);
        LocalDate r4 = Instant.ofEpochMilli(r3).atZone(r5).toLocalDate();
        return Intrinsics.areEqual(Instant.ofEpochMilli(r0).atZone(r5).toLocalDate(), r4);
    }

    public static final boolean a(NowFeedPageFragment.NowVisualState r1) {
        Intrinsics.checkNotNullParameter(r1, "visualState");
        if (r1 != NowFeedPageFragment.NowVisualState.SUGGESTION) goto L5;
    L8:
        return true;
    L5:
        if (r1 == NowFeedPageFragment.NowVisualState.CELEBRATION) goto L8;
        return false;
    }

    public static final boolean a(NowFeedPageFragment.NowVisualState r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "visualState");
        if (r1 != NowFeedPageFragment.NowVisualState.SUGGESTION) goto L5;
    L11:
        return true;
    L5:
        if (r1 == NowFeedPageFragment.NowVisualState.CELEBRATION) goto L11;
        if (r1 != NowFeedPageFragment.NowVisualState.SENSING) goto L10;
        if (r2 == true) goto L11;
    L10:
        return false;
    }

    public static final boolean a(j r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "status");
        if (r2 == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.getType() != NowAgentStatusType.SENSING) goto L7;
        return true;
    }

    public static final boolean a(List<? extends com.obric.aiproactive.ui.model.j> r3, List<com.obric.aiproactive.ui.model.j.f> r4, List<com.obric.aiproactive.ui.model.j.f> r5, com.obric.aiproactive.ui.model.f r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "nowItems");
        Intrinsics.checkNotNullParameter(r9, "celebrationRecommendations");
        Intrinsics.checkNotNullParameter(r10, "debugRecommendations");
        Intrinsics.checkNotNullParameter(r6, "allPageState");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        return true;
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        return true;
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Object r14 = r13.next();
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiproactive.ui.model.j.f.class) == false) goto L10;
        r12.add(r14);
        goto L10
    L14:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L17;
    L19:
        Iterator r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L18;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L21;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L27;
        return true;
    L27:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r6.g().values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L30;
    L32:
        Iterator r19 = r18.iterator();
    L34:
        if (r19.hasNext() == false) goto L31;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r20, Collection.class) == true) goto L38;
    L40:
        Iterator r21 = r20.iterator();
    L42:
        if (r21.hasNext() == false) goto L39;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r21.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L42;
        boolean r22 = true;
    L46:
        if (r22 == false) goto L34;
        boolean r23 = true;
    L48:
        if (r23 == false) goto L51;
        return true;
    L51:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.e(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L53;
        return false;
    L53:
        return r6.g().isEmpty();
    L39:
        r22 = false;
        goto L46
    L38:
        if (((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L40;
    L31:
        r23 = false;
        goto L48
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
    L18:
        r17 = false;
        goto L25
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
        goto L18
    }

    public static final boolean a(boolean r0) {
        return r0;
    }

    public static final boolean a(boolean r2, List<com.obric.aiproactive.ui.model.j.f> r3, List<com.obric.aiproactive.ui.model.j.f> r4, boolean r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "previousRecommendations");
        Intrinsics.checkNotNullParameter(r8, "currentRecommendations");
        if (r2 == true) goto L5;
        return false;
    L5:
        if (r5 == true) goto L33;
        if (r6 == false) goto L9;
        return false;
    L9:
        if (r7.isEmpty() == false) goto L11;
        return false;
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L36;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L16;
    L18:
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L38;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L20;
        return true;
    L24:
        r11 = false;
        goto L25
    L38:
        return false;
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
        return false;
    L36:
        return false;
    L33:
        return false;
    }

    public static final boolean a(boolean r1, boolean r2, boolean r3, float r4) {
        if (r1 == false) goto L6;
        return false;
    L6:
        if (r2 == true) goto L8;
        return true;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        if (r4 < 0.0f) goto L12;
        return false;
    L12:
        return true;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2, boolean r3) {
        if (r0 == true) goto L7;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final float b(float r3, float r4, float r5) {
        if (r5 > r4) goto L10;
        if (r3 <= r4) goto L8;
        return 1.0f;
    L8:
        return 0.0f;
    L10:
        return RangesKt.coerceIn((r3 - r4) / (r5 - r4), 0.0f, 1.0f);
    }

    private static final int b(com.obric.aiproactive.api.g r1) {
        String r2 = r1.c();
        switch(r2.hashCode()) {
            case -1281977283: goto L23;
            case 40661574: goto L20;
            case 476588369: goto L17;
            case 945734241: goto L14;
            case 1116313165: goto L10;
            case 1550783935: goto L6;
            default: goto L26;
        };
    L26:
        return 0;
    L6:
        if (r2.equals("running") == false) goto L26;
        return 1;
    L10:
        if (r2.equals("waiting") == false) goto L26;
        return 2;
    L14:
        if (r2.equals("succeeded") == false) goto L26;
    L25:
        return 3;
    L17:
        if (r2.equals("cancelled") == true) goto L25;
    L20:
        if (r2.equals("timed_out") == true) goto L25;
    L23:
        if (r2.equals("failed") == true) goto L25;
        goto L25
    }

    private static final j b(int r8, long r9) {
        return new j(NowAgentStatusType.COMPLETED, RangesKt.coerceAtLeast(r8, 0), r9, 0);
    }

    public static final q b(long r2, ZoneId r4) {
        Intrinsics.checkNotNullParameter(r4, "zoneId");
        return a(CollectionsKt.emptyList(), 0, r2, r4);
    }

    public static /* synthetic */ q b(long r0, ZoneId r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ZoneId.systemDefault();
    L6:
        return b(r0, r2);
    }

    private static final String c(long r0, ZoneId r2) {
        String r1 = Instant.ofEpochMilli(r0).atZone(r2).format(f6624a);
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        return r1;
    }
}
