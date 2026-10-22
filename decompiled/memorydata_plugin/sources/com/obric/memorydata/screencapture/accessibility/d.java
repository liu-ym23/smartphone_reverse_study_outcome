package com.obric.memorydata.screencapture.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.sdk.accessibility.KeywordMatchRule;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.obric.memorydata.sdk.screencapture.rule.SearchNodeEnum;
import com.obric.memorydata.sdk.screencapture.rule.TextMatchRuleEnum;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u001a\u0010\u001f\u001a\u00020\u0007*\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/RuleMatcher;", "", "<init>", "()V", "TAG", "", "isEventMatch", "", "keywordMatchRule", "Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "ruleStatus", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;", "service", "Landroid/accessibilityservice/AccessibilityService;", "isNodeMatchText", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "keyword", "matchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "isMatchText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "evaluateExpression", "conditions", "", "expression", "match", "viewTrees", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12777a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12778a = null;

        static {
            int[] r0 = new int[TextMatchRuleEnum.values().length];
            r0[TextMatchRuleEnum.NOT_CONTAINS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[TextMatchRuleEnum.CHANGED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[TextMatchRuleEnum.CONTAINS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[TextMatchRuleEnum.EQUALS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[TextMatchRuleEnum.REGEX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[TextMatchRuleEnum.WILDCARD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f12778a = r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class b implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12779a = null;

        static {
            f12779a = new b();
        }

        b() {
        }

        public final Void a() {
            throw new IllegalArgumentException("motionEvent is null");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ Object invoke() {
            return a();
        }
    }

    static {
        f12777a = new d();
    }

    private d() {
    }

    private final boolean a(AccessibilityNodeInfo r3, String r4, TextMatchRuleEnum r5) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (a(r4, r3.getText(), r5) == false) goto L8;
    L9:
        return true;
    L8:
        if (a(r4, r3.getContentDescription(), r5) == true) goto L9;
        return false;
    }

    private final boolean a(KeywordMatchRule r8, List<ViewTreeNode> r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r8.getMatchRule() != TextMatchRuleEnum.NOT_CONTAINS) goto L22;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L7;
    L9:
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L50;
        ViewTreeNode r12 = (ViewTreeNode) ZeusTransformUtils.preCheckCast(r11.next(), ViewTreeNode.class, "com.obric.memorydata.plugin");
        d r1 = f12777a;
        if (r1.a(r8.getKeyword(), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getText(), CharSequence.class, "com.obric.memorydata.plugin"), TextMatchRuleEnum.CONTAINS) == false) goto L15;
    L18:
        boolean r13 = true;
    L19:
        if (r13 == false) goto L11;
        return false;
    L15:
        if (r1.a(r8.getKeyword(), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getContentDescription(), CharSequence.class, "com.obric.memorydata.plugin"), TextMatchRuleEnum.CONTAINS) == true) goto L18;
        r13 = false;
        goto L19
    L50:
        return true;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        return true;
    L22:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L25;
    L27:
        Iterator r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L38;
        ViewTreeNode r16 = (ViewTreeNode) ZeusTransformUtils.preCheckCast(r15.next(), ViewTreeNode.class, "com.obric.memorydata.plugin");
        d r2 = f12777a;
        if (r2.a(r8.getKeyword(), (CharSequence) ZeusTransformUtils.preCheckCast(r16.getText(), CharSequence.class, "com.obric.memorydata.plugin"), r8.getMatchRule()) == false) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 == false) goto L29;
        return true;
    L33:
        if (r2.a(r8.getKeyword(), (CharSequence) ZeusTransformUtils.preCheckCast(r16.getContentDescription(), CharSequence.class, "com.obric.memorydata.plugin"), r8.getMatchRule()) == true) goto L36;
        r17 = false;
    L38:
        return false;
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
        goto L27
    }

    private final boolean a(String r6, CharSequence r7, TextMatchRuleEnum r8) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        int r3 = a.f12778a[r8.ordinal()];
        if (r3 == 1) goto L32;
        if (r3 == 3) goto L40;
        if (r3 == 4) goto L39;
        if (r3 == 5) goto L38;
        if (r3 != 6) goto L27;
        return at.a(r5, r6);
    L27:
        throw new IllegalArgumentException("RuleMatcher: invalid matchRule: " + r8);
    L38:
        return new Regex(r6).matches(r5);
    L39:
        return StringsKt.contentEquals(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
    L40:
        return StringsKt.contains$default(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null);
    L32:
        if (StringsKt.contains$default(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L35;
        return true;
    L35:
        return false;
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean a(KeywordMatchRule r19, AccessibilityEvent r20, TouchInfo r21, AccessibilityRuleStatus r22, AccessibilityService r23) {
        AccessibilityService r2 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r23, AccessibilityService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "keywordMatchRule");
        Intrinsics.checkNotNullParameter(r20, "event");
        Intrinsics.checkNotNullParameter(r22, "ruleStatus");
        Intrinsics.checkNotNullParameter(r2, "service");
        boolean r8 = true;
        if (r19.getSearchNode() != SearchNodeEnum.EVENT) goto L21;
        List<CharSequence> r3 = r20.getText();
        Intrinsics.checkNotNullExpressionValue(r3, "getText(...)");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L7;
    L9:
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L8;
        if (f12777a.a(r19.getKeyword(), (CharSequence) ZeusTransformUtils.preCheckCast(r5.next(), CharSequence.class, "com.obric.memorydata.plugin"), r19.getMatchRule()) == false) goto L11;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        return true;
    L17:
        if (a(r19.getKeyword(), r20.getContentDescription(), r19.getMatchRule()) == false) goto L20;
        return true;
    L20:
        return false;
    L8:
        r6 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L21:
        String r10 = null;
        if (r19.getSearchNode() != SearchNodeEnum.TOUCH_POSITION) goto L38;
        if (com.obric.memorydata.sdk.accessibility.a.f12814a.a(r20.getEventType()) == false) goto L38;
        List r7 = f.a(f.f12787a, r2.getRootInActiveWindow(), r19.getViewTreeCacheValidDuration(), false, 4, null);
        if (r21 != null) goto L29;
        y.a(null, (Function0) ZeusTransformUtils.preCheckCast(b.f12779a, Function0.class, "com.obric.memorydata.plugin"), 1, null);
        return false;
    L29:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r9.iterator();
    L31:
        if (r12.hasNext() == false) goto L36;
        Object r13 = r12.next();
        if (((ViewTreeNode) ZeusTransformUtils.preCheckCast(r13, ViewTreeNode.class, "com.obric.memorydata.plugin")).getRect().contains((int) r21.getX(), (int) r21.getY()) == false) goto L31;
        r11.add(r13);
        goto L31
    L36:
        return a(r19, (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"));
    L38:
        if (r19.getSearchNode() != SearchNodeEnum.SOURCE) goto L56;
        if (r19.getTraverseAllChildren() == true) goto L56;
        if (at.a(r19.getViewIdResourceName()) == false) goto L54;
        AccessibilityNodeInfo r14 = r20.getSource();
        if (r14 == null) goto L51;
        String r15 = r14.getViewIdResourceName();
        if (r15 == null) goto L51;
        List r16 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"id/"}, false, 0, 6, null);
        if (r16 == null) goto L51;
        r10 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r16), String.class, "com.obric.memorydata.plugin");
    L51:
        if (Intrinsics.areEqual(r10, r19.getViewIdResourceName()) == true) goto L54;
        return false;
    L54:
        return a(r20.getSource(), r19.getKeyword(), r19.getMatchRule());
    L56:
        if (r19.getSearchNode() != SearchNodeEnum.ROOT_VIEW_TREE) goto L58;
        AccessibilityNodeInfo r17 = r2.getRootInActiveWindow();
    L59:
        if (r17 != null) goto L62;
        return false;
    L62:
        if (r19.getTraverseAllChildren() == false) goto L66;
        long r18 = System.currentTimeMillis();
        boolean r0 = a(r19, f.f12787a.a(r17, r19.getViewTreeCacheValidDuration(), r19.getViewVisibleOnly()));
        RunLog.INSTANCE.debug("RuleMatcher", "found " + r19.getKeyword() + " return " + r0 + ", traverse node: " + r17.hashCode() + " all children cost " + (System.currentTimeMillis() - r18) + "ms");
        return r0;
    L66:
        if (r19.getMatchRule() != TextMatchRuleEnum.EQUALS) goto L68;
    L82:
        long r110 = System.currentTimeMillis();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getViewIdResourceName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L85;
    L88:
        boolean r24 = true;
    L89:
        if (r24 == false) goto L91;
        List<AccessibilityNodeInfo> r25 = r17.findAccessibilityNodeInfosByText(r19.getKeyword());
    L92:
        Intrinsics.checkNotNull(r25);
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L94:
        if (r28.hasNext() == false) goto L101;
        Object r29 = r28.next();
        AccessibilityNodeInfo r111 = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r29, AccessibilityNodeInfo.class, "com.obric.memorydata.plugin");
        if (r19.getViewVisibleOnly() == false) goto L98;
        boolean r112 = r111.isVisibleToUser();
    L99:
        if (r112 == false) goto L94;
        r27.add(r29);
        goto L94
    L98:
        r112 = true;
        goto L99
    L101:
        List r30 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("RuleMatcher", "search " + r19 + " found " + r30.size() + " size, cost " + (System.currentTimeMillis() - r110) + "ms");
        int r31 = a.f12778a[r19.getMatchRule().ordinal()];
        if (r31 != 1) goto L104;
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r32, Collection.class) == true) goto L165;
    L167:
        Iterator r33 = r32.iterator();
    L169:
        if (r33.hasNext() == false) goto L166;
        if (f12777a.a((AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r33.next(), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin"), r19.getKeyword(), TextMatchRuleEnum.CONTAINS) == false) goto L169;
        boolean r34 = true;
    L173:
        if (r34 == false) goto L176;
        r8 = false;
    L176:
        RunLog.INSTANCE.debug("RuleMatcher", "search " + r19.getKeyword() + ", found: " + r8 + ", cost " + (System.currentTimeMillis() - r110) + "ms");
        return r8;
    L166:
        r34 = false;
        goto L173
    L165:
        if (((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L167;
    L104:
        if (r31 == 2) goto L116;
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r35, Collection.class) == true) goto L108;
    L110:
        Iterator r36 = r35.iterator();
    L112:
        if (r36.hasNext() == false) goto L109;
        if (f12777a.a((AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r36.next(), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin"), r19.getKeyword(), r19.getMatchRule()) == false) goto L112;
    L109:
        r8 = false;
        goto L176
    L108:
        if (((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L110;
    L116:
        CharSequence r37 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getViewIdResourceName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r37 != null) goto L119;
    L122:
        boolean r38 = true;
    L123:
        if (r38 == true) goto L161;
        AccessibilityNodeInfo r39 = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r30), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L158;
        StringBuilder r40 = new StringBuilder(Integer.toHexString(r39.hashCode()));
        CharSequence r41 = r39.getText();
        if (r41 != null) goto L129;
    L134:
        boolean r42 = false;
    L136:
        if (r42 == false) goto L138;
        r40.append("_");
        r40.append(r39.getText());
    L138:
        CharSequence r43 = r39.getContentDescription();
        if (r43 != null) goto L141;
    L146:
        boolean r44 = false;
    L147:
        if (r44 == false) goto L149;
        r40.append("_");
        r40.append(r39.getContentDescription());
    L149:
        String r45 = (String) ZeusTransformUtils.preCheckCast(r22.b().get(r19.getViewIdResourceName()), String.class, "com.obric.memorydata.plugin");
        if (r45 != null) goto L153;
        r45 = "";
    L153:
        if (Intrinsics.areEqual(r45, r40.toString()) == false) goto L156;
        return false;
    L156:
        Map<String, String> r46 = r22.b();
        String r47 = r19.getViewIdResourceName();
        Intrinsics.checkNotNull(r47);
        r46.put(r47, r40.toString());
        return true;
    L141:
        if (r43.length() <= 0) goto L143;
        boolean r48 = true;
    L144:
        if (r48 != true) goto L146;
        r44 = true;
        goto L147
    L143:
        r48 = false;
        goto L144
    L129:
        if (r41.length() <= 0) goto L131;
        boolean r49 = true;
    L132:
        if (r49 != true) goto L134;
        r42 = true;
        goto L136
    L131:
        r49 = false;
        goto L132
    L158:
        return false;
    L161:
        throw new IllegalArgumentException("viewIdResourceName is empty");
    L119:
        if (r37.length() == 0) goto L122;
        r38 = false;
        goto L123
    L91:
        r25 = r17.findAccessibilityNodeInfosByViewId(r17.getPackageName() + ":id/" + r19.getViewIdResourceName());
        goto L92
    L85:
        if (r1.length() == 0) goto L88;
        r24 = false;
        goto L89
    L68:
        if (r19.getMatchRule() == TextMatchRuleEnum.CONTAINS) goto L82;
        if (r19.getMatchRule() == TextMatchRuleEnum.NOT_CONTAINS) goto L82;
        CharSequence r50 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getViewIdResourceName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r50 != null) goto L74;
    L77:
        boolean r51 = true;
    L78:
        if (r51 == false) goto L82;
        long r52 = System.currentTimeMillis();
        boolean r53 = a(r19, f.f12787a.a(r17, r19.getViewTreeCacheValidDuration(), r19.getViewVisibleOnly()));
        RunLog.INSTANCE.debug("RuleMatcher", "search " + r19.getKeyword() + " viewTree, found: " + r53 + ", cost " + (System.currentTimeMillis() - r52) + "ms");
        return r53;
    L74:
        if (r50.length() == 0) goto L77;
        r51 = false;
        goto L78
    L58:
        r17 = r20.getSource();
        goto L59
    }

    public final boolean a(List<Boolean> r8, String r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "conditions");
        Intrinsics.checkNotNullParameter(r9, "expression");
        List r10 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{" "}, false, 0, 6, null);
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r10.size()) goto L21;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3, "&&") == false) goto L14;
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r11.remove(CollectionsKt.getLastIndex(r11)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r2 = r2 + 1;
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r7.get(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.memorydata.plugin"))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r4 == false) goto L11;
        if (r5 == false) goto L11;
    L10:
        boolean r6 = true;
    L12:
        Object r12 = Boolean.valueOf(r6);
    L20:
        r11.add(r12);
        r2 = r2 + 1;
    L11:
        r6 = false;
        goto L12
    L14:
        if (Intrinsics.areEqual(r3, "||") == false) goto L19;
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r11.remove(CollectionsKt.getLastIndex(r11)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r2 = r2 + 1;
        boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r7.get(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.memorydata.plugin"))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r13 == true) goto L10;
        if (r14 == false) goto L11;
    L19:
        r12 = r7.get(Integer.parseInt(r3));
        goto L20
    L21:
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r11), Boolean.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L24;
        return false;
    L24:
        return r15.booleanValue();
    }
}
