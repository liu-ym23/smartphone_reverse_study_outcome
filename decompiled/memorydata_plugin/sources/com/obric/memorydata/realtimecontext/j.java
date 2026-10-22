package com.obric.memorydata.realtimecontext;

import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Pair;
import android.view.ViewStructure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0012\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010!\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010#\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010$\u001a\u00020\f*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0082@¢\u0006\u0002\u0010)J\f\u0010*\u001a\u00020\u0005*\u00020\u0018H\u0002J\f\u0010+\u001a\u00020\u0005*\u00020\u0018H\u0002J\f\u0010,\u001a\u00020\u0005*\u00020\u0018H\u0002J\f\u0010-\u001a\u00020\u0005*\u00020.H\u0002J\f\u0010/\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u00100\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/memorydata/realtimecontext/AssistStructureViewTreeDumper;", "", "<init>", "()V", "TAG", "", "LOG_PREFIX", "CACHE_DIR_NAME", "EXTRA_VISIBLE_TO_USER", "fileUnsafeCharRegex", "Lkotlin/text/Regex;", "dump", "", "assistStructure", "Landroid/app/assist/AssistStructure;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "buildViewTree", "appendViewNode", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "node", "Landroid/app/assist/AssistStructure$ViewNode;", "depth", "", "appendIdInfo", "appendTextInfo", ActivityLifecycle.NAME, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "appendVisibleToUser", "appendStateFlags", "appendTextMetrics", "appendWebInfo", "appendAutofillInfo", "appendHtmlInfo", "appendExtrasKeys", "writeViewTreeToCache", "viewTree", "componentName", "Landroid/content/ComponentName;", "(Ljava/lang/String;Landroid/content/ComponentName;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toVisibilityText", "toTextStyleText", "toColorText", "formatFloat", "", "formatText", "formatFileName", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f12472b = null;

    static {
        f12471a = new j();
        f12472b = new Regex("[^A-Za-z0-9._-]");
    }

    private j() {
    }

    private static final CharSequence a(Pair r4) {
        StringBuilder r0 = new StringBuilder().append((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin")).append('=');
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        String r6 = f12471a.a(r5);
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(r6).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r6 = null;
        goto L6
    }

    private static final CharSequence a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return (CharSequence) ZeusTransformUtils.preCheckCast(f12471a.a(r3.toString()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object a(j r2, String r3, ComponentName r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r4, ComponentName r5, Continuation<? super Unit> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Object r7 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AssistStructureViewTreeDumper$writeViewTreeToCache$2(r5, r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    private final String a(float r2) {
        if ((r2 % 1.0f) != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return String.valueOf((int) r2);
    L9:
        return String.valueOf(r2);
    L5:
        r1 = false;
        goto L6
    }

    private final String a(int r3) {
        if (r3 != 0) goto L5;
        StringBuilder r0 = new StringBuilder();
        String r1 = "VISIBLE(";
    L13:
        return r0.append(r1).append(r3).append(')').toString();
    L5:
        if (r3 != 4) goto L7;
        r0 = new StringBuilder();
        r1 = "INVISIBLE(";
        goto L13
    L7:
        if (r3 == 8) goto L9;
        r0 = new StringBuilder();
        r1 = "UNKNOWN(";
        goto L13
    L9:
        r0 = new StringBuilder();
        r1 = "GONE(";
        goto L13
    }

    private final String a(AssistStructure r9) {
        StringBuilder r8 = new StringBuilder();
        StringBuilder r0 = r8.append("activity=" + r9.getActivityComponent());
        Intrinsics.checkNotNullExpressionValue(r0, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r0.append('\n'), "append(...)");
        int r1 = r9.getWindowNodeCount();
        StringBuilder r3 = r8.append("windowCount=" + r1);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append(...)");
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        AssistStructure.WindowNode r5 = r9.getWindowNodeAt(r4);
        StringBuilder r6 = r8.append("window[" + r4 + "] title=" + r5.getTitle() + ", rect=(" + r5.getLeft() + ',' + r5.getTop() + ',' + r5.getWidth() + 'x' + r5.getHeight() + ')');
        Intrinsics.checkNotNullExpressionValue(r6, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r6.append('\n'), "append(...)");
        j r7 = f12471a;
        AssistStructure.ViewNode r10 = r5.getRootViewNode();
        Intrinsics.checkNotNullExpressionValue(r10, "getRootViewNode(...)");
        r7.a(r8, r10, 1);
        r4 = r4 + 1;
        goto L3
    L5:
        String r11 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    }

    public static final /* synthetic */ String a(j r0, AssistStructure r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String a(j r0, String r1) {
        return r0.b(r1);
    }

    private final String a(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(r13, "\r", "\\r", false, 4, null), "\n", "\\n", false, 4, null);
    }

    private final void a(StringBuilder r8, AssistStructure.ViewNode r9) {
        String r7 = r9.getIdEntry();
        String r0 = null;
        if (r7 == null) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L11;
        r8.append(", id=").append(r7);
    L11:
        if (r9.getId() == (-1)) goto L13;
        r8.append(", idInt=").append(r9.getId());
    L13:
        String r10 = r9.getIdPackage();
        String r3 = r9.getIdType();
        String r4 = r9.getIdEntry();
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r5 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L35;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == false) goto L35;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L32;
    L33:
        r6 = true;
    L34:
        if (r6 == false) goto L35;
    L45:
        String r15 = r9.getTextIdEntry();
        if (r15 != null) goto L48;
        return;
    L48:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L50;
        r0 = r15;
    L50:
        if (r0 == null) goto L54;
        r8.append(", textId=").append(r0);
        return;
    L54:
        return;
    L32:
        if (StringsKt.isBlank(r14) == false) goto L34;
    L24:
        if (StringsKt.isBlank(r12) == true) goto L27;
        r13 = false;
    L35:
        StringBuilder r16 = r8.append(", idFull=");
        if (r10 != null) goto L38;
        r10 = "";
    L38:
        StringBuilder r17 = r16.append(r10).append(':');
        if (r3 != null) goto L41;
        r3 = "";
    L41:
        StringBuilder r18 = r17.append(r3).append('/');
        if (r4 != null) goto L44;
        r4 = "";
    L44:
        r18.append(r4);
        goto L45
    L16:
        if (StringsKt.isBlank(r5) == true) goto L19;
        r11 = false;
        goto L20
    }

    private final void a(StringBuilder r6, AssistStructure.ViewNode r7, int r8) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        r6.append("  ");
        r1 = r1 + 1;
        goto L3
    L5:
        r6.append("- class=").append(r7.getClassName());
        a(r6, r7);
        a(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r7.getText());
        a(r6, "desc", r7.getContentDescription());
        a(r6, "hint", (CharSequence) ZeusTransformUtils.preCheckCast(r7.getHint(), CharSequence.class, "com.obric.memorydata.plugin"));
        r6.append(", rect=(").append(r7.getLeft()).append(',').append(r7.getTop()).append(',').append(r7.getWidth()).append('x').append(r7.getHeight()).append(')');
        r6.append(", scroll=(").append(r7.getScrollX()).append(',').append(r7.getScrollY()).append(')');
        r6.append(", visibility=").append(a(r7.getVisibility()));
        b(r6, r7);
        c(r6, r7);
        r6.append(", alpha=").append(a(r7.getAlpha()));
        r6.append(", elevation=").append(a(r7.getElevation()));
        d(r6, r7);
        e(r6, r7);
        f(r6, r7);
        g(r6, r7);
        h(r6, r7);
        r6.append(", children=").append(r7.getChildCount());
        Intrinsics.checkNotNullExpressionValue(r6.append('\n'), "append(...)");
        int r2 = r7.getChildCount();
    L6:
        if (r0 >= r2) goto L8;
        AssistStructure.ViewNode r3 = r7.getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        a(r6, r3, r8 + 1);
        r0 = r0 + 1;
        goto L6
    }

    private final void a(StringBuilder r3, String r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        String r7 = r6.toString();
        if (r7 == null) goto L16;
        String r2 = a(r7);
        if (r2 != null) goto L9;
        return;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L18;
        r3.append(", ").append(r4).append("=\"").append(r2).append(Typography.quote);
        return;
    L18:
        return;
    L16:
        return;
    }

    private final String b(int r13) {
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L6;
        r12.add("BOLD");
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12.add("ITALIC");
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12.add("UNDERLINE");
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12.add("STRIKE_THRU");
    L15:
        if (r12.isEmpty() == false) goto L17;
        StringBuilder r14 = new StringBuilder().append("UNKNOWN(");
    L19:
        return r14.append(r13).append(')').toString();
    L17:
        r14 = new StringBuilder().append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append('(');
        goto L19
    }

    private final String b(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.take(f12472b.replace(r1, "_"), 120);
    }

    private final void b(StringBuilder r2, AssistStructure.ViewNode r3) {
        Bundle r1 = r3.getExtras();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.containsKey("android.view.ViewStructure.extra.VISIBLE_TO_USER") == false) goto L9;
        r2.append(", visibleToUser=").append(r1.getBoolean("android.view.ViewStructure.extra.VISIBLE_TO_USER"));
        return;
    }

    private final String c(int r3) {
        return '#' + StringsKt.padStart(UStringsKt.m2735toStringV7xB4Y4(UInt.m1516constructorimpl(r3), 16), 8, '0');
    }

    private final void c(StringBuilder r2, AssistStructure.ViewNode r3) {
        r2.append(", enabled=").append(r3.isEnabled());
        r2.append(", clickable=").append(r3.isClickable());
        r2.append(", longClickable=").append(r3.isLongClickable());
        r2.append(", contextClickable=").append(r3.isContextClickable());
        r2.append(", focusable=").append(r3.isFocusable());
        r2.append(", focused=").append(r3.isFocused());
        r2.append(", accessibilityFocused=").append(r3.isAccessibilityFocused());
        r2.append(", selected=").append(r3.isSelected());
        r2.append(", activated=").append(r3.isActivated());
        r2.append(", checkable=").append(r3.isCheckable());
        r2.append(", checked=").append(r3.isChecked());
        r2.append(", assistBlocked=").append(r3.isAssistBlocked());
        r2.append(", opaque=").append(r3.isOpaque());
    }

    private final void d(StringBuilder r4, AssistStructure.ViewNode r5) {
        if (r5.getTextSelectionStart() < 0) goto L5;
    L6:
        r4.append(", textSelection=").append(r5.getTextSelectionStart()).append("..").append(r5.getTextSelectionEnd());
    L8:
        if (r5.getTextSize() <= 0.0f) goto L11;
        r4.append(", textSize=").append(a(r5.getTextSize()));
    L11:
        if (r5.getTextStyle() == 0) goto L14;
        r4.append(", textStyle=").append(b(r5.getTextStyle()));
    L14:
        if (r5.getTextColor() == 1) goto L17;
        r4.append(", textColor=").append(c(r5.getTextColor()));
    L17:
        if (r5.getTextBackgroundColor() == 1) goto L20;
        r4.append(", textBgColor=").append(c(r5.getTextBackgroundColor()));
    L20:
        if (r5.getMinTextEms() < 0) goto L23;
        r4.append(", minTextEms=").append(r5.getMinTextEms());
    L23:
        if (r5.getMaxTextEms() < 0) goto L26;
        r4.append(", maxTextEms=").append(r5.getMaxTextEms());
    L26:
        if (r5.getMaxTextLength() < 0) goto L29;
        r4.append(", maxTextLength=").append(r5.getMaxTextLength());
    L29:
        if (r5.getInputType() == 0) goto L32;
        r4.append(", inputType=").append(r5.getInputType());
        return;
    L32:
        return;
    L5:
        if (r5.getTextSelectionEnd() < 0) goto L8;
        goto L6
    }

    private final void e(StringBuilder r6, AssistStructure.ViewNode r7) {
        String r5 = r7.getWebScheme();
        String r0 = r7.getWebDomain();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L16;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
    L14:
        r3 = true;
    L15:
        if (r3 == false) goto L16;
    L23:
        LocaleList r8 = r7.getLocaleList();
        if (r8 != null) goto L26;
        return;
    L26:
        if ((!r8.isEmpty()) == true) goto L29;
        r8 = null;
    L29:
        if (r8 == null) goto L33;
        r6.append(", localeList=").append(r8);
        return;
    L33:
        return;
    L13:
        if (StringsKt.isBlank(r4) == false) goto L15;
    L16:
        StringBuilder r9 = r6.append(", web=");
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        StringBuilder r10 = r9.append(r5).append("://");
        if (r0 != null) goto L22;
        r0 = "";
    L22:
        r10.append(r0);
        goto L23
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void f(StringBuilder r19, AssistStructure.ViewNode r20) {
        if (r20.getAutofillType() == 0) goto L6;
        r19.append(", autofillType=").append(r20.getAutofillType());
    L6:
        if (r20.getImportantForAutofill() == 0) goto L8;
        r19.append(", importantForAutofill=").append(r20.getImportantForAutofill());
    L8:
        String[] r1 = r20.getAutofillHints();
        boolean r5 = false;
        if (r1 != null) goto L11;
    L20:
        CharSequence[] r2 = r20.getAutofillOptions();
        if (r2 != null) goto L23;
        return;
    L23:
        if (r2.length != 0) goto L26;
        r5 = true;
    L26:
        if ((!r5) == false) goto L28;
        CharSequence[] r7 = r2;
    L29:
        if (r7 == null) goto L33;
        r19.append(", autofillOptions=").append(ArraysKt.joinToString$default(r7, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$j$hUzchDCLV4R0p8Y2SzlVXUgoiQc.INSTANCE, 25, null));
        return;
    L33:
        return;
    L28:
        r7 = null;
        goto L29
    L11:
        if (r1.length != 0) goto L13;
        boolean r8 = true;
    L15:
        if ((!r8) == false) goto L17;
        String[] r9 = r1;
    L18:
        if (r9 == null) goto L20;
        r19.append(", autofillHints=").append(ArraysKt.joinToString$default(r9, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 57, null));
        goto L20
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = false;
        goto L15
    }

    private final void g(StringBuilder r11, AssistStructure.ViewNode r12) {
        ViewStructure.HtmlInfo r10 = r12.getHtmlInfo();
        if (r10 != null) goto L5;
        return;
    L5:
        String r13 = r10.getTag();
        if (r13 != null) goto L8;
    L13:
        List<Pair<String, String>> r14 = r10.getAttributes();
        if (r14 != null) goto L17;
        r14 = CollectionsKt.emptyList();
    L17:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        r11.append(", htmlAttrs=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$j$30wtLJi5qlL03cO4dmwRzOi0Izw.INSTANCE, 25, null));
        return;
    L20:
        return;
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L13;
        r11.append(", htmlTag=").append(r13);
        goto L13
    }

    private final void h(StringBuilder r11, AssistStructure.ViewNode r12) {
        Bundle r10 = r12.getExtras();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((!r10.isEmpty()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L12;
        StringBuilder r13 = r11.append(", extrasKeys=");
        Set<String> r14 = r10.keySet();
        Intrinsics.checkNotNullExpressionValue(r14, "keySet(...)");
        r13.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 57, null));
        return;
    }

    public static /* synthetic */ CharSequence lambda$30wtLJi5qlL03cO4dmwRzOi0Izw(Pair r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$hUzchDCLV4R0p8Y2SzlVXUgoiQc(CharSequence r0) {
        return a(r0);
    }

    public final void a(AssistStructure r8, al r9) {
        al r1 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "scope");
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L8;
        RunLog.INSTANCE.debug(RealTimeContextService.TAG, "[assistStructureViewTree] assistStructure is null");
        return;
    L8:
        ComponentName r7 = r8.getActivityComponent();
        kotlinx.coroutines.i.a(r1, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AssistStructureViewTreeDumper$dump$1(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }
}
