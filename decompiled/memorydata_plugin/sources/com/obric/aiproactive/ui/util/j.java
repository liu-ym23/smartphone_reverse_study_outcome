package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\u0011H\u0002J\"\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020)H\u0000¢\u0006\u0002\b,R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/ui/util/ProactiveMarkdownRenderer;", "", "<init>", "()V", "openAgentRunHttpUrl", "", "widget", "Landroid/view/View;", "rawUrl", "", "openAgentRunHttpUrl$ai_proactive_ui_obricRelease", "proactiveLinkResolver", "com/obric/aiproactive/ui/util/ProactiveMarkdownRenderer$proactiveLinkResolver$1", "Lcom/obric/aiproactive/ui/util/ProactiveMarkdownRenderer$proactiveLinkResolver$1;", "MARKDOWN_FONT_DIFF_DP", "", "cardInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "textView", "Landroid/widget/TextView;", "detailPrimaryInfo", "detailSecondaryInfo", "bindCardText", "markdown", "bindDetailPrimaryText", "bindDetailSecondaryText", "bindAgentRunDetailText", "bindSafeDocumentText", "resetAgentRunTextInteraction", "resetAgentRunTextInteraction$ai_proactive_ui_obricRelease", "enableSystemTextSelection", "applySystemTextSelection", "bind", "info", "bindAgentRun", "applyAgentRunTextInteractionPolicy", "policy", "Lcom/obric/aiproactive/ui/util/AgentRunTextInteractionPolicy;", "prepareCardTextForParentClick", "ensureLinkResolverRegistered", "enableMarkdownLinkStyleForTest", "", "enableMarkdownLinkStyleForTest$ai_proactive_ui_obricRelease", "needMarkdownLinkUnderlineForTest", "needMarkdownLinkUnderlineForTest$ai_proactive_ui_obricRelease", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f6886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f6887b = null;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/obric/aiproactive/ui/util/ProactiveMarkdownRenderer$proactiveLinkResolver$1", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "needUnderline", "", "link", "", "enableLinkStyle", "resolve", "", "view", "Landroid/view/View;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.larus.business.markdown.api.depend.i {
        a() {
        }

        @Override // com.larus.business.markdown.api.depend.i
        public void a(View r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "link");
            resolve(r1, r2);
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return j.f6886a.b();
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return j.f6886a.a();
        }

        @Override // com.larus.business.markdown.api.depend.i, io.noties.markwon.d
        public void resolve(View r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "link");
            i r2 = i.f6885a;
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
            r2.a(r5, r4);
        }
    }

    static {
        f6886a = new j();
        f6887b = new a();
    }

    private j() {
    }

    private final void a(TextView r1, e r2) {
        r1.setMovementMethod(null);
        r1.setLinksClickable(false);
        r1.setTextIsSelectable(r2.a());
        r1.setLongClickable(r2.b());
        r1.setClickable(r2.c());
        r1.setFocusable(r2.d());
        if (r2.e() == false) goto L6;
        r1.setLinksClickable(true);
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    private final void a(TextView r17, String r18, com.larus.business.markdown.api.model.c r19) {
        c();
        com.larus.business.markdown.api.model.h r2 = null;
        if (r18 == null) goto L5;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        r17.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        r17.setVisibility(8);
        return;
    L13:
        r17.setVisibility(0);
        com.larus.business.markdown.api.a r5 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r5 == null) goto L17;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        r2 = com.larus.business.markdown.api.a.b.a(r5, r6, 0, r1, true, r19, null, null, null, 224, null);
    L17:
        if (ZeusTransformUtils.instanceOf(r17, MarkdownTextView.class) == false) goto L20;
        ((MarkdownTextView) ZeusTransformUtils.preCheckCast(r17, MarkdownTextView.class, "com.obric.memorydata.plugin")).setMarkdown(r2);
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r2, com.larus.business.markdown.impl.markwon.e.class) == false) goto L22;
        r17.setText((CharSequence) ZeusTransformUtils.preCheckCast(((com.larus.business.markdown.impl.markwon.e) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.impl.markwon.e.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
        f(r17);
        return;
    L22:
        r17.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void b(TextView r18, String r19, com.larus.business.markdown.api.model.c r20) {
        a(r18);
        com.larus.business.markdown.api.model.h r2 = null;
        if (r19 == null) goto L5;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        r18.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        r18.setVisibility(8);
        return;
    L13:
        r18.setVisibility(0);
        com.larus.business.markdown.api.a r4 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r4 == null) goto L18;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        Node r5 = com.larus.business.markdown.api.a.b.a(r4, r6, r1, true, r20, null, null, 48, null);
        if (r5 == null) goto L18;
        Node r8 = k.a(r5);
    L19:
        if (r8 == null) goto L22;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        r2 = com.larus.business.markdown.api.a.b.a(r4, r7, 0, r8, true, r20, null, null, null, null, 480, null);
    L22:
        if (ZeusTransformUtils.instanceOf(r2, com.larus.business.markdown.impl.markwon.e.class) == false) goto L24;
        int r3 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        k.a((Spannable) ZeusTransformUtils.preCheckCast(((com.larus.business.markdown.impl.markwon.e) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.impl.markwon.e.class, "com.obric.memorydata.plugin")).a(), Spannable.class, "com.obric.memorydata.plugin"));
        Spannable r9 = (Spannable) ZeusTransformUtils.preCheckCast(((com.larus.business.markdown.impl.markwon.e) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.impl.markwon.e.class, "com.obric.memorydata.plugin")).a(), Spannable.class, "com.obric.memorydata.plugin");
        TextPaint r10 = r18.getPaint();
        Intrinsics.checkNotNullExpressionValue(r10, "getPaint(...)");
        k.a(r9, r10, ZeusTransformUtils.getResources(r18, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_marker_gap, "dimen", "ai_proactive_agent_secondary_list_marker_gap")), ZeusTransformUtils.getResources(r18, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_bullet_diameter, "dimen", "ai_proactive_agent_secondary_list_bullet_diameter")), r3, r18.getCurrentTextColor());
        r18.setLinkTextColor(r3);
        r18.setText((CharSequence) ZeusTransformUtils.preCheckCast(((com.larus.business.markdown.impl.markwon.e) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.impl.markwon.e.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
    L25:
        a(r18, k.a(true));
        return;
    L24:
        r18.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
    L18:
        r8 = null;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    private final com.larus.business.markdown.api.model.c c(TextView r39) {
        int r2 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_2, "dimen", "oui_p_container_tiny_2"));
        int r0 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_1, "dimen", "oui_p_container_tiny_1"));
        return new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(r2), Integer.valueOf(r0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -102401, null);
    }

    private final void c() {
        com.larus.business.markdown.api.a r3 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r3 == null) goto L6;
        r3.registerLinkResolver((com.larus.business.markdown.api.depend.i) ZeusTransformUtils.preCheckCast(f6887b, com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final com.larus.business.markdown.api.model.c d(TextView r39) {
        int r2 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2"));
        int r0 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_1, "dimen", "oui_p_container_tiny_1"));
        return new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(r2), Integer.valueOf(r0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -102401, null);
    }

    private final com.larus.business.markdown.api.model.c e(TextView r39) {
        int r2 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_1, "dimen", "oui_p_container_1"));
        int r0 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_1, "dimen", "oui_p_container_tiny_1"));
        return new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(r2), Integer.valueOf(r0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -102401, null);
    }

    private final void f(TextView r1) {
        r1.setTextIsSelectable(true);
        r1.setLongClickable(true);
    }

    private final void g(TextView r1) {
        if (r1.isTextSelectable() == true) goto L6;
        r1.setFocusable(false);
        return;
    }

    private static final void h(TextView r1) {
        f6886a.f(r1);
    }

    /* JADX INFO: renamed from: lambda$x-YYVDHkVT2j6YqCUBLSiNUe9Ik, reason: not valid java name */
    public static /* synthetic */ void m351lambda$xYYVDHkVT2j6YqCUBLSiNUe9Ik(TextView r0) {
        h(r0);
    }

    public final void a(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "rawUrl");
        k.a(r1, r2);
    }

    public final void a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        a(r2, k.a(false));
    }

    public final void a(TextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        a(r2, r3, c(r2));
        g(r2);
    }

    public final boolean a() {
        return true;
    }

    public final void b(final TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        f(r2);
        r2.post(new $$Lambda$j$xYYVDHkVT2j6YqCUBLSiNUe9Ik(r2));
    }

    public final void b(TextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        a(r2, r3, d(r2));
    }

    public final boolean b() {
        return false;
    }

    public final void c(TextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        a(r2, r3, e(r2));
    }

    public final void d(TextView r39, String r40) {
        Intrinsics.checkNotNullParameter(r39, "textView");
        int r2 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_2, "dimen", "oui_p_container_tiny_2"));
        int r1 = ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_item_gap, "dimen", "ai_proactive_agent_secondary_list_item_gap"));
        b(r39, r40, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(r2), Integer.valueOf(r1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -102401, null));
    }

    public final void e(TextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        d(r2, r3);
    }
}
