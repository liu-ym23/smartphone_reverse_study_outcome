package com.obric.aiproactive.ui.util;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u001e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001cH\u0000\u001a\u0012\u0010!\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0000\u001a'\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\u0010(\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004\"\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\"\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0004\"\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0004\"\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0004¨\u0006)"}, d2 = {"VALUE_RATING_AMOUNT_SOURCES", "", "", "getVALUE_RATING_AMOUNT_SOURCES", "()Ljava/util/Set;", "VALUE_RATING_TARGET_TYPES", "getVALUE_RATING_TARGET_TYPES", "VALUE_RATING_SUBMIT_TYPES", "getVALUE_RATING_SUBMIT_TYPES", "CARD_LIST_PAGES", "getCARD_LIST_PAGES", "CARD_CLICK_PAGES", "getCARD_CLICK_PAGES", "CARD_CLICK_BUTTON_TYPES", "getCARD_CLICK_BUTTON_TYPES", "ENTER_PAGE_PAGES", "getENTER_PAGE_PAGES", "PAGE_CLICK_PAGES", "getPAGE_CLICK_PAGES", "PAGE_CLICK_BUTTON_TYPES", "getPAGE_CLICK_BUTTON_TYPES", "PAGE_SCROLL_PAGES", "getPAGE_SCROLL_PAGES", "resolveSessionEnterFrom", "rawEnterFrom", "resolveStartupEnterFrom", "startupInspirationId", "shouldReportHomeEnterPage", "", "enterFrom", "resolveStartupLaunchPosition", "resolveFeedEnterMethod", "userScrollTriggered", "resolvePreferencePreviousPage", "rawPreviousPage", "resolveDetailTrackingContext", "Lcom/obric/aiproactive/ui/util/DetailTrackingContext;", "sourcePage", "sourceRank", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiproactive/ui/util/DetailTrackingContext;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f6893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6894b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;
    private static final Set<String> h = null;
    private static final Set<String> i = null;
    private static final Set<String> j = null;

    static {
        f6893a = SetsKt.setOf(new String[]{"preset", "custom"});
        f6894b = SetsKt.setOf(new String[]{"suggestion", "action_result"});
        c = SetsKt.setOf(new String[]{"create", BuildConfig.CHANNEL});
        Set<String> r2 = SetsKt.setOf(new String[]{"home", "proactive_all"});
        d = r2;
        e = SetsKt.plus(r2, "proactive_card_detail");
        f = SetsKt.setOf(new String[]{"click_button", MemoryListActivity.JUMP_FROM_DETAIL, "ignore"});
        Set<String> r3 = SetsKt.setOf(new String[]{"home", "proactive_all", "preference", "interview", "proactive_card_detail", "events"});
        g = r3;
        h = SetsKt.plus(r3, "proactive_settings");
        i = SetsKt.setOf(new String[]{"show_menu", "collapse_menu", "show_detail", "collapse_detail", "wake_up_doubao", "disable_proactive", "feedback", "preference", "enter_interview"});
        j = SetsKt.setOf(new String[]{"home", "proactive_all", "preference", "proactive_card_detail", "events"});
    }

    public static final f a(String r1, String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "enterFrom");
        Intrinsics.checkNotNullParameter(r2, "sourcePage");
        if (Intrinsics.areEqual(r1, "lockscreen_card") == false) goto L6;
        return new f("", 1);
    L6:
        return new f(r2, r3);
    }

    public static final String a(String r1) {
        if (Intrinsics.areEqual(r1, "lockscreen_card") == true) goto L7;
        return "desktop_icon";
    L7:
        return "lockscreen_card";
    }

    public static final String a(String r2, String r3) {
        if (Intrinsics.areEqual(r2, "lockscreen_card") == true) goto L15;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L16;
        return "desktop_icon";
    L16:
        return "lockscreen_card";
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r5 = false;
        goto L11
    L15:
        return "lockscreen_card";
    }

    public static final String a(boolean r0) {
        if (r0 == false) goto L4;
        return "scroll";
    L4:
        return "click";
    }

    public static final Set<String> a() {
        return f6893a;
    }

    public static final String b(String r1) {
        if (Intrinsics.areEqual(r1, "interview") == true) goto L7;
        return "home";
    L7:
        return "interview";
    }

    public static final Set<String> b() {
        return f6894b;
    }

    public static final boolean b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        if (Intrinsics.areEqual(r3, "lockscreen_card") == false) goto L13;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == true) goto L13;
        return false;
    L7:
        if (StringsKt.isBlank(r5) == true) goto L10;
        r6 = false;
    L13:
        return true;
    }

    public static final String c(String r0, String r1) {
        if (Intrinsics.areEqual(a(r0, r1), "lockscreen_card") == false) goto L5;
        return "lock_screen";
    L5:
        return "unlock_screen";
    }

    public static final Set<String> c() {
        return c;
    }

    public static final Set<String> d() {
        return d;
    }

    public static final Set<String> e() {
        return e;
    }

    public static final Set<String> f() {
        return f;
    }

    public static final Set<String> g() {
        return g;
    }

    public static final Set<String> h() {
        return h;
    }

    public static final Set<String> i() {
        return i;
    }

    public static final Set<String> j() {
        return j;
    }
}
