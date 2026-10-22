package com.obric.memorydata.screencapture.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.accessibility.AccessibilityCondition;
import com.obric.memorydata.sdk.accessibility.KeywordMatchRule;
import com.obric.memorydata.sdk.accessibility.VisibleNodeCountCondition;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.obric.memorydata.sdk.screencapture.rule.CacheStrategy;
import com.obric.memorydata.sdk.screencapture.rule.ConditionMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.KeywordsMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.RectMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+J*\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010.\u001a\u00020!H\u0002J\u0018\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020#H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;", "", "rule", "Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;)V", "getRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "TAG", "", "status", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus$MatchStatus;", "step", "", "exitTime", "", "conditionCheckTimeMap", "", "Lcom/obric/memorydata/sdk/accessibility/AccessibilityCondition;", "lastNodeTexts", "getLastNodeTexts", "()Ljava/util/Map;", "setLastNodeTexts", "(Ljava/util/Map;)V", "screenshotRef", "Ljava/lang/ref/SoftReference;", "getScreenshotRef", "()Ljava/lang/ref/SoftReference;", "setScreenshotRef", "(Ljava/lang/ref/SoftReference;)V", "currentActivityName", "lastCheckVersionComparableTs", "lastCheckVersionComparableState", "", "onAccessibilityEvent", "", "service", "Landroid/accessibilityservice/AccessibilityService;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "listener", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleMatchListener;", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "isMatch", "condition", "checkVersionCompatibility", "compareVersion", "current", TypedValues.AttributesType.S_TARGET, "inValidPage", "reset", "MatchStatus", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AccessibilityRuleStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppAccessibilityEventRule f12769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12770b;
    private MatchStatus c;
    private int d;
    private long e;
    private Map<AccessibilityCondition, Long> f;
    private Map<String, String> g;
    private SoftReference<Object> h;
    private String i;
    private long j;
    private boolean k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus$MatchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "MATCHING", "MATCHED", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MatchStatus extends Enum<MatchStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MatchStatus[] $VALUES = null;
        public static final MatchStatus INIT = null;
        public static final MatchStatus MATCHED = null;
        public static final MatchStatus MATCHING = null;

        private static final /* synthetic */ MatchStatus[] $values() {
            return new MatchStatus[]{INIT, MATCHING, MATCHED};
        }

        static {
            INIT = new MatchStatus("INIT", 0);
            MATCHING = new MatchStatus("MATCHING", 1);
            MATCHED = new MatchStatus("MATCHED", 2);
            MatchStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private MatchStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<MatchStatus> getEntries() {
            return $ENTRIES;
        }

        public static MatchStatus valueOf(String r2) {
            return (MatchStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(MatchStatus.class, r2), MatchStatus.class, "com.obric.memorydata.plugin");
        }

        public static MatchStatus[] values() {
            return (MatchStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MatchStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    public AccessibilityRuleStatus(AppAccessibilityEventRule r3) {
        Intrinsics.checkNotNullParameter(r3, "rule");
        this.f12769a = r3;
        this.f12770b = "AccessibilityRuleStatus-" + r3.getId();
        this.c = MatchStatus.INIT;
        this.d = -1;
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final int a(String r9, String r10) {
        List<Integer> r8 = a(r9);
        List<Integer> r11 = a(r10);
        int r12 = Math.max(r8.size(), r11.size());
        int r2 = 0;
    L3:
        if (r2 >= r12) goto L29;
        if (r2 >= 0) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        Integer r5 = r8.get(r2);
    L13:
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 >= 0) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L21;
        Integer r13 = r11.get(r2);
    L22:
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6 > r14) goto L24;
        if (r6 < r14) goto L26;
        r2 = r2 + 1;
        goto L3
    L26:
        return -1;
    L24:
        return 1;
    L21:
        r13 = 0;
        goto L22
    L16:
        if (r2 >= r11.size()) goto L18;
        r7 = true;
        goto L19
    L12:
        r5 = 0;
        goto L13
    L7:
        if (r2 >= r8.size()) goto L9;
        r4 = true;
        goto L10
    L29:
        return 0;
    }

    private static final List<Integer> a(String r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r3 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.memorydata.plugin");
        int r4 = r2.length();
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L11;
        char r7 = r2.charAt(r6);
        if (Character.isDigit(r7) == false) goto L10;
        r3.append(r7);
    L10:
        r6 = r6 + 1;
        goto L6
    L11:
        String r8 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r3, StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        r5 = Integer.parseInt(r8);
    L15:
        r0.add(Integer.valueOf(r5));
        goto L4
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void a(AccessibilityRuleStatus r1, AccessibilityService r2, AccessibilityEvent r3, b r4, TouchInfo r5, int r6, Object r7) {
        AccessibilityService r8 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r2, AccessibilityService.class, "com.obric.memorydata.plugin");
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = null;
    L5:
        r1.a(r8, r3, r9, r5);
    }

    private final boolean a(AccessibilityCondition r19, AccessibilityService r20, AccessibilityEvent r21, TouchInfo r22) {
        AccessibilityService r9 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r20, AccessibilityService.class, "com.obric.memorydata.plugin");
        boolean r10 = false;
        if ((r19.getEventType() & r21.getEventType()) != 0) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r21.getPackageName(), this.f12769a.getPackageName()) == true) goto L8;
        return false;
    L8:
        long r2 = 0;
        if (r19.getTimeThreshold() <= 0) goto L16;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f.get(r19), Long.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        r2 = r0.longValue();
    L14:
        if (Math.abs(System.currentTimeMillis() - r2) >= r19.getTimeThreshold()) goto L16;
        return false;
    L16:
        String r3 = null;
        if (r21.getEventType() != 32) goto L26;
        CharSequence r1 = r21.getClassName();
        if (r1 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L26;
        String r5 = String.valueOf(r21.getClassName());
    L31:
        if (at.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), r19.getActivityName()) == false) goto L33;
    L32:
        boolean r6 = true;
    L52:
        if (r6 == true) goto L54;
        return false;
    L54:
        this.f.put(r19, Long.valueOf(System.currentTimeMillis()));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19.getKeywordMatchRules(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L57;
    L101:
        boolean r7 = true;
    L102:
        if (r7 == true) goto L104;
        return false;
    L104:
        VisibleNodeCountCondition r8 = r19.getVisibleNodeCountCondition();
        if (r8 == null) goto L117;
        int r11 = f.f12787a.a(r9.getRootInActiveWindow(), r19.getTimeThreshold(), true).size();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "visible node count = " + r11, false, 4, null);
        if (r8.getMin() == null) goto L112;
        Integer r12 = r8.getMin();
        Intrinsics.checkNotNull(r12);
        if (r11 >= r12.intValue()) goto L112;
        return false;
    L112:
        if (r8.getMax() == null) goto L117;
        Integer r13 = r8.getMax();
        Intrinsics.checkNotNull(r13);
        if (r11 <= r13.intValue()) goto L117;
        return false;
    L117:
        if (com.obric.memorydata.sdk.accessibility.a.f12814a.a(r21.getEventType()) == false) goto L171;
        if (r22 == null) goto L172;
        List<Rect> r14 = r19.getTouchRects();
        if (r14 != null) goto L122;
    L124:
        boolean r15 = false;
    L125:
        if (r15 == true) goto L127;
        return r7;
    L127:
        if (r19.getTouchRectMatchRule() != RectMatchRuleEnum.CONTAINS) goto L140;
        List<Rect> r16 = r19.getTouchRects();
        Intrinsics.checkNotNull(r16);
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L131;
    L133:
        Iterator r18 = r17.iterator();
    L135:
        if (r18.hasNext() == false) goto L153;
        if (((Rect) ZeusTransformUtils.preCheckCast(r18.next(), Rect.class, "com.obric.memorydata.plugin")).contains((int) r22.getX(), (int) r22.getY()) == false) goto L135;
    L138:
        r10 = true;
    L153:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "click position matched " + r10 + " in range " + r19.getTouchRects(), false, 4, null);
        return r10;
    L131:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L133;
    L140:
        if (r19.getTouchRectMatchRule() != RectMatchRuleEnum.NOT_CONTAINS) goto L152;
        List<Rect> r23 = r19.getTouchRects();
        Intrinsics.checkNotNull(r23);
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Collection.class) == true) goto L144;
    L146:
        Iterator r25 = r24.iterator();
    L148:
        if (r25.hasNext() == false) goto L138;
        if (((Rect) ZeusTransformUtils.preCheckCast(r25.next(), Rect.class, "com.obric.memorydata.plugin")).contains((int) r22.getX(), (int) r22.getY()) == false) goto L148;
    L144:
        if (((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L146;
    L152:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "invalid touchRectMatchRule: " + r19.getTouchRectMatchRule(), null, 4, null);
        goto L153
    L122:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L124;
        r15 = true;
        goto L125
    L172:
        return r7;
    L171:
        return r7;
    L57:
        if (r19.getKeywordsMatchRule() != KeywordsMatchRuleEnum.OR) goto L69;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r19.getKeywordMatchRules(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r26, Collection.class) == true) goto L61;
    L63:
        Iterator r110 = r26.iterator();
    L65:
        if (r110.hasNext() == false) goto L100;
        if (d.f12777a.a((KeywordMatchRule) ZeusTransformUtils.preCheckCast(r110.next(), KeywordMatchRule.class, "com.obric.memorydata.plugin"), r21, r22, this, r9) == false) goto L65;
    L100:
        r7 = false;
        goto L102
    L61:
        if (((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L63;
    L69:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r19.getKeywordMatchRules(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r27.iterator();
    L71:
        if (r112.hasNext() == false) goto L73;
        r111.add(Boolean.valueOf(d.f12777a.a((KeywordMatchRule) ZeusTransformUtils.preCheckCast(r112.next(), KeywordMatchRule.class, "com.obric.memorydata.plugin"), r21, r22, this, r9)));
        goto L71
    L73:
        List<Boolean> r28 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
        if (r19.getKeywordsMatchRule() != KeywordsMatchRuleEnum.AND) goto L87;
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r29, Collection.class) == true) goto L78;
    L80:
        Iterator r30 = r29.iterator();
    L82:
        if (r30.hasNext() == false) goto L101;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r30.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L82;
    L78:
        if (((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L80;
    L87:
        if (r19.getKeywordsMatchRule() != KeywordsMatchRuleEnum.EXPRESSION) goto L99;
        CharSequence r31 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getKeywordMatchExpression(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r31 != null) goto L91;
    L94:
        boolean r32 = true;
    L95:
        if (r32 == true) goto L98;
        d r33 = d.f12777a;
        String r34 = r19.getKeywordMatchExpression();
        Intrinsics.checkNotNull(r34);
        r7 = r33.a(r28, r34);
        goto L102
    L98:
        throw new IllegalArgumentException("keywordMatchExpression is empty");
    L91:
        if (r31.length() == 0) goto L94;
        r32 = false;
        goto L95
    L99:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "invalid keywordsMatchRule: " + r19.getKeywordsMatchRule(), null, 4, null);
        goto L100
    L33:
        List<String> r35 = r19.getActivityList();
        if (r35 != null) goto L36;
    L38:
        boolean r36 = false;
    L39:
        if (r36 == false) goto L51;
        List<String> r37 = r19.getActivityList();
        Intrinsics.checkNotNull(r37);
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r38, Collection.class) == true) goto L43;
    L45:
        Iterator r39 = r38.iterator();
    L47:
        if (r39.hasNext() == false) goto L51;
        if (at.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r39.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), r5) == false) goto L47;
    L43:
        if (((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L45;
    L51:
        r6 = false;
        goto L52
    L36:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L38;
        r36 = true;
        goto L39
    L21:
        if (StringsKt.contains$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("Activity", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) != true) goto L23;
        r4 = true;
    L26:
        ComponentName r40 = ba.a();
        if (r40 == null) goto L29;
        r3 = r40.getClassName();
    L29:
        r5 = String.valueOf(r3);
        goto L31
    }

    private final boolean d() {
        if (Math.abs(System.currentTimeMillis() - this.j) < 60000) goto L5;
        com.obric.memorydata.utils.c.a r0 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, this.f12769a.getPackageName(), null, 2, null);
        boolean r1 = false;
        if (r0 != null) goto L9;
        return false;
    L9:
        String r2 = r0.c();
        String r3 = this.f12769a.getMinVersion();
        String r4 = this.f12769a.getMaxVersion();
        if (r3 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r4 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r5 == false) goto L25;
        if (r6 == false) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "version compatibility check failed, currentVersion: " + r2 + ", minVersion: " + r3 + ", maxVersion: " + r4, null, 4, null);
    L27:
        this.j = System.currentTimeMillis();
        this.k = r1;
        return r1;
    L18:
        if (a(r2, r4) <= 0) goto L21;
        r6 = false;
        goto L22
    L12:
        if (a(r2, r3) >= 0) goto L15;
        r5 = false;
        goto L16
    L5:
        return this.k;
    }

    private final boolean e() {
        ComponentName r0 = ba.a();
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0.toShortString(), this.i) == true) goto L8;
        this.i = r0.toShortString();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "topActivity => " + r0, false, 4, null);
    L8:
        boolean r2 = !Intrinsics.areEqual(r0.getPackageName(), this.f12769a.getPackageName());
        if (r2 == true) goto L27;
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12769a.getConditions(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        AccessibilityCondition r6 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r5.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin");
        r3.add(r6.getActivityName());
        List<String> r7 = r6.getActivityList();
        if (r7 == null) goto L12;
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        goto L12
    L16:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(this.f12769a.getActivityNameWhiteList(), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L19;
    L21:
        Iterator r8 = r4.iterator();
    L23:
        if (r8.hasNext() == false) goto L20;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r10 = r0.getClassName();
        Intrinsics.checkNotNullExpressionValue(r10, "getClassName(...)");
        if (at.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r9) == false) goto L23;
        r2 = false;
    L20:
        r2 = true;
        goto L27
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L21;
    L27:
        if (r2 == true) goto L29;
    L31:
        if (r2 == true) goto L33;
    L37:
        if (r2 == true) goto L39;
    L38:
        r1 = true;
    L39:
        if (r1 == true) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "out of range, activity = " + r0, false, 4, null);
    L41:
        return r1;
    L33:
        if (this.c != MatchStatus.MATCHING) goto L37;
        if ((System.currentTimeMillis() - this.e) > this.f12769a.getMatchTimeout()) goto L39;
    L29:
        if (this.e != 0) goto L31;
        this.e = System.currentTimeMillis();
        goto L31
    }

    private final void f() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "reset rule", false, 4, null);
        this.c = MatchStatus.INIT;
        this.d = -1;
        this.e = 0;
        SoftReference<Object> r0 = this.h;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.h = null;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12769a.getConditions(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        ((AccessibilityCondition) ZeusTransformUtils.preCheckCast(r9.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin")).setMatched(false);
        goto L7
    }

    public final AppAccessibilityEventRule a() {
        return this.f12769a;
    }

    public final void a(AccessibilityService r20, AccessibilityEvent r21, b r22, TouchInfo r23) {
        AccessibilityService r3 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r20, AccessibilityService.class, "com.obric.memorydata.plugin");
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r22, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "event");
        if (r3 != null) goto L6;
        return;
    L6:
        if (d() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "Rule " + this.f12769a.getId() + " version not compatible, skip processing", false, 4, null);
        return;
    L10:
        if (r21.getEventType() == 2048) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "onAccessibilityEvent type=" + r21.getEventType(), false, 4, null);
        if (com.obric.memorydata.sdk.accessibility.a.f12814a.a(r21.getEventType()) == true) goto L46;
        AccessibilityNodeInfo r6 = r21.getSource();
        if (r6 == null) goto L46;
        CharSequence r7 = r6.getText();
        if (r7 != null) goto L18;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == true) goto L45;
        CharSequence r9 = r6.getContentDescription();
        if (r9 != null) goto L28;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == true) goto L45;
        String r11 = r6.getViewIdResourceName();
        if (r11 != null) goto L38;
    L43:
        boolean r12 = false;
    L44:
        if (r12 == false) goto L46;
    L38:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L40;
        boolean r13 = true;
    L41:
        if (r13 != true) goto L43;
        r12 = true;
        goto L44
    L40:
        r13 = false;
        goto L41
    L28:
        if (r9.length() <= 0) goto L30;
        boolean r14 = true;
    L31:
        if (r14 != true) goto L33;
        r10 = true;
        goto L34
    L30:
        r14 = false;
    L45:
        RunLog.INSTANCE.debug(this.f12770b, "event.source text = " + r6.getText() + " contentDesc: " + r6.getContentDescription() + " viewId = " + r6.getViewIdResourceName());
        goto L46
    L18:
        if (r7.length() <= 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 != true) goto L23;
        r8 = true;
        goto L24
    L20:
        r15 = false;
    L46:
        if (r5 != null) goto L49;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "listener is null", null, 4, null);
        return;
    L49:
        MatchStatus r16 = this.c;
        if (r16 == MatchStatus.MATCHED) goto L54;
        if (this.c == MatchStatus.MATCHING) goto L54;
    L74:
        if (this.f12769a.getConditionMatchRule() != ConditionMatchRuleEnum.OR) goto L82;
        Iterator<AccessibilityCondition> r17 = this.f12769a.getConditions().iterator();
    L77:
        if (r17.hasNext() == false) goto L104;
        AccessibilityCondition r18 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r17.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin");
        if (a(r18, r3, r21, r23) == false) goto L77;
        r18.setMatched(true);
        this.c = MatchStatus.MATCHED;
    L104:
        if (r16 == this.c) goto L150;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "rule onStatusChange ==> " + this.c, false, 4, null);
        if (this.c != MatchStatus.MATCHED) goto L151;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12769a.getConditions(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L109:
        if (r1.hasNext() == false) goto L116;
        Object r2 = r1.next();
        if (((AccessibilityCondition) ZeusTransformUtils.preCheckCast(r2, AccessibilityCondition.class, "com.obric.memorydata.plugin")).getScreenshotOpt() == null) goto L113;
        boolean r19 = true;
    L114:
        if (r19 == false) goto L109;
    L117:
        AccessibilityCondition r4 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r2, AccessibilityCondition.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L120;
        ScreenshotOption r24 = r4.getScreenshotOpt();
    L121:
        if (r24 == null) goto L125;
        Object r25 = e.f12780a.b(this, r3.getRootInActiveWindow(), r24);
        if (r25 == null) goto L129;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "use cache screenshot", false, 4, null);
        this.h = new SoftReference(r25);
    L129:
        r5.a(this);
        if (this.f12769a.getResetWhenMatched() == false) goto L132;
    L135:
        f();
        return;
    L132:
        if (this.f12769a.getConditionMatchRule() == ConditionMatchRuleEnum.SEQUENCE) goto L134;
        return;
    L134:
        if (Intrinsics.areEqual(((AccessibilityCondition) ZeusTransformUtils.preCheckCast(CollectionsKt.first(this.f12769a.getConditions()), AccessibilityCondition.class, "com.obric.memorydata.plugin")).getActivityName(), ((AccessibilityCondition) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.f12769a.getConditions()), AccessibilityCondition.class, "com.obric.memorydata.plugin")).getActivityName()) == false) goto L135;
        return;
    L125:
        SoftReference<Object> r26 = this.h;
        if (r26 == null) goto L128;
        r26.clear();
    L128:
        this.h = null;
        goto L129
    L120:
        r24 = null;
        goto L121
    L113:
        r19 = false;
        goto L114
    L116:
        r2 = null;
        goto L117
    L151:
        return;
    L150:
        return;
    L82:
        if (this.f12769a.getConditionMatchRule() != ConditionMatchRuleEnum.SEQUENCE) goto L104;
        int r27 = this.d + 1;
        if (r27 >= this.f12769a.getConditions().size()) goto L104;
        AccessibilityCondition r110 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(this.f12769a.getConditions().get(r27), AccessibilityCondition.class, "com.obric.memorydata.plugin");
        boolean r111 = a(r110, r3, r21, r23);
        if (r111 == false) goto L88;
    L92:
        if (r111 == false) goto L104;
        r110.setMatched(true);
        this.d = r27;
        if (r27 != (this.f12769a.getConditions().size() - 1)) goto L96;
        MatchStatus r28 = MatchStatus.MATCHED;
    L97:
        this.c = r28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, this.f12769a.getId() + " matching progress = " + (this.d + 1) + '/' + this.f12769a.getConditions().size() + " , condition is " + r110, false, 4, null);
        ScreenshotOption r29 = r110.getScreenshotOpt();
        if (r29 == null) goto L104;
        if (r29.getCacheStrategy().getStrategy() != CacheStrategy.NO_CACHE) goto L102;
        e.f12780a.a(this, r3.getRootInActiveWindow(), r29);
    L102:
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AccessibilityRuleStatus$onAccessibilityEvent$3$1(this, r3, r29, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L104
    L96:
        r28 = MatchStatus.MATCHING;
        goto L97
    L88:
        if (r110.getOptional() == false) goto L92;
        if (r27 >= (this.f12769a.getConditions().size() - 1)) goto L92;
        r27 = r27 + 1;
        r110 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(this.f12769a.getConditions().get(r27), AccessibilityCondition.class, "com.obric.memorydata.plugin");
        r111 = a(r110, r3, r21, r23);
    L54:
        if (e() == true) goto L57;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "enter valid page, reset rule", false, 4, null);
        f();
    L57:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f12769a.getResetConditions(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L71;
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12769a.getResetConditions(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r112 = false;
    L60:
        if (r30.hasNext() == false) goto L68;
        AccessibilityCondition r113 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r30.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin");
        if (a(r113, r3, r21, r23) == false) goto L60;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "matched reset condition " + r113, false, 4, null);
        if (r113.getResetToStep() < 0) goto L66;
        this.d = r113.getResetToStep();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12770b, "reset to step = " + r113.getResetToStep() + ", current progress = " + (this.d + 1) + '/' + this.f12769a.getConditions().size(), false, 4, null);
        this.c = MatchStatus.MATCHING;
    L67:
        f.f12787a.a(r3.getRootInActiveWindow());
        r112 = true;
        goto L60
    L66:
        f();
        goto L67
    L68:
        if (r112 == false) goto L71;
        r16 = this.c;
    L71:
        if (this.c != MatchStatus.MATCHED) goto L74;
    }

    public final Map<String, String> b() {
        return this.g;
    }

    public final SoftReference<Object> c() {
        return this.h;
    }
}
