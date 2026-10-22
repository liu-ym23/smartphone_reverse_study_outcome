package com.obric.aiproactive.ui.list;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u001a*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0005*\u00020\u000fH\u0002\u001a,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0000\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0016H\u0002\u001a2\u0010\u001e\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\"H\u0002\u001a\u001c\u0010#\u001a\u00020\u0016*\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"COLLAPSED_CONTENT_LINES", "", "INLINE_ACTION_PADDING_DP", "", "INLINE_ACTION_WORD_JOINER", "", "INLINE_ACTION_SEPARATOR", "INLINE_ELLIPSIS", "toggleSensingEventExpansion", "", "expandedEventIds", "eventId", "retainExistingExpandedSensingEvents", "existingEventIds", "stableId", "Lcom/obric/aiproactive/ui/list/SensingEvent;", "buildCollapsedSensingEventText", Params.CONTENT, "actionText", "fitsWithinCollapsedLines", "Lkotlin/Function1;", "", "", "buildExpandedSensingEventText", "safePrefixEnd", "index", "showPlainSensingEventContent", "", "Landroid/widget/TextView;", "expanded", "showInlineSensingEventAction", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "maxLines", "onClick", "Lkotlin/Function0;", "fitsWithinLines", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class j {
    private static final int a(String r2, int r3) {
        if (r3 <= 0) goto L13;
        if (r3 >= r2.length()) goto L13;
        int r0 = r3 - 1;
        if (Character.isHighSurrogate(r2.charAt(r0)) == true) goto L9;
        return r3;
    L9:
        if (Character.isLowSurrogate(r2.charAt(r3)) == true) goto L11;
        return r3;
    L11:
        return r0;
    L13:
        return RangesKt.coerceIn(r3, 0, r2.length());
    }

    public static final /* synthetic */ String a(h r0) {
        return b(r0);
    }

    public static final String a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, "actionText");
        return StringsKt.trimEnd((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString() + "\u2060 " + r4;
    }

    public static final String a(String r9, String r10, Function1<? super CharSequence, Boolean> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r10, "actionText");
        Intrinsics.checkNotNullParameter(r12, "fitsWithinCollapsedLines");
        String r13 = "… " + r10;
        int r0 = r9.length();
        String r4 = r13;
        int r3 = 0;
    L3:
        if (r3 > r0) goto L8;
        int r5 = (r3 + r0) >>> 1;
        int r6 = a(r9, r5);
        StringBuilder r7 = new StringBuilder();
        String r8 = r9.substring(0, r6);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        String r14 = r7.append(StringsKt.trimEnd((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString()).append(r13).toString();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(r14), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r0 = r5 - 1;
        goto L3
    L6:
        r3 = r5 + 1;
        r4 = r14;
        goto L3
    L8:
        return r4;
    }

    public static final Set<String> a(Set<String> r2, String r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "expandedEventIds");
        Intrinsics.checkNotNullParameter(r3, "eventId");
        if (r4.contains(r3) == false) goto L6;
        return SetsKt.minus(r4, r3);
    L6:
        return SetsKt.plus(r4, r3);
    }

    public static final Set<String> a(Set<String> r2, Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "expandedEventIds");
        Intrinsics.checkNotNullParameter(r5, "existingEventIds");
        return CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(Function0 r2, View r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.invoke();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(TextView r2, String r3, String r4, int r5, Function0 r6) {
        b(r2, r3, r4, r5, (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(TextView r0, String r1, boolean r2) {
        b(r0, r1, r2);
    }

    public static final /* synthetic */ boolean a(TextView r2, CharSequence r3, int r4) {
        return b(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final String b(h r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = r3.a() + 0 + r3.b();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    private static final void b(TextView r6, String r7, String r8, int r9, Function0<Unit> r10) {
        final Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        r6.setMaxLines(r9);
        r6.setEllipsize(null);
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        l.a(r6, r8, 0.0f, ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, TypedValues.Custom.S_COLOR, "oui_accent_7_fg")), new $$Lambda$j$lw_AVDSAijdrj7YygRFyZsvzlko(r11), null);
    }

    private static final void b(TextView r2, String r3, boolean r4) {
        TextUtils.TruncateAt r0 = null;
        r2.setMovementMethod(null);
        r2.setLinksClickable(false);
        r2.setClickable(false);
        r2.setHighlightColor(0);
        if (r4 == false) goto L5;
        int r1 = Integer.MAX_VALUE;
    L6:
        r2.setMaxLines(r1);
        if (r4 == true) goto L10;
        r0 = TextUtils.TruncateAt.END;
    L10:
        r2.setEllipsize(r0);
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = 2;
        goto L6
    }

    private static final boolean b(TextView r4, CharSequence r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = (r4.getWidth() - r4.getTotalPaddingLeft()) - r4.getTotalPaddingRight();
        if (r0 > 0) goto L6;
        return false;
    L6:
        if (StaticLayout.Builder.obtain(r7, 0, r7.length(), r4.getPaint(), r0).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(r4.getBreakStrategy()).setHyphenationFrequency(r4.getHyphenationFrequency()).setIncludePad(r4.getIncludeFontPadding()).setLineSpacing(r4.getLineSpacingExtra(), r4.getLineSpacingMultiplier()).build().getLineCount() > r6) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ Unit lambda$lw_AVDSAijdrj7YygRFyZsvzlko(Function0 r0, View r1) {
        return a(r0, r1);
    }
}
