package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.depend.g;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GBU\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0018\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016JR\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u000203H\u0016J4\u00104\u001a\u00020\n2\u0006\u00102\u001a\u0002032\b\u0010%\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0002J!\u00108\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0018\u0010>\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010?\u001a\u00020\u0001H\u0016J\"\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010*2\u0006\u0010B\u001a\u00020\nH\u0002J'\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020E2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010FR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/CustomCodeSpan;", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "Landroid/text/style/ReplacementSpan;", "payload", "", "", "", "code", Api.KEY_LANGUAGE, "startIndex", "", "endIndex", "maxContentWidth", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;)V", "attachedTextView", "Landroid/widget/TextView;", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLanguage", "getPayload", "()Ljava/util/Map;", "size", "Landroid/util/Size;", "getStartIndex", "widget", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "afterAttach", "", "textView", "beforeAttach", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spanned;", "draw", "canvas", "Landroid/graphics/Canvas;", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSpanWidth", "obtainWidget", "(Landroid/widget/TextView;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "onDetach", "needRemoveView", "", "onRecycle", "onReuse", "span", "printLog", "log", "index", "recycleWidget", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Integer;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;)V", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends ReplacementSpan implements com.larus.business.markdown.api.extplugin.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f5217b;
    private String c;
    private final String d;
    private final Integer e;
    private final Integer f;
    private final int g;
    private final com.larus.business.markdown.api.extplugin.a.a h;
    private TextView i;
    private Size j;
    private com.larus.business.markdown.api.extplugin.a.c k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/CustomCodeSpan$Companion;", "", "()V", "LOG_TAG", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5216a = new a(null);
    }

    public b(Map<String, ? extends Object> r3, String r4, String r5, Integer r6, Integer r7, int r8, com.larus.business.markdown.api.extplugin.a.a r9) {
        Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.extplugin.a.a r11 = (com.larus.business.markdown.api.extplugin.a.a) ZeusTransformUtils.wrapperContextForParams(r9, com.larus.business.markdown.api.extplugin.a.a.class, "com.obric.memorydata.plugin");
        this.f5217b = r10;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r11;
        this.j = new Size(0, 0);
    }

    private final int a(Spanned r3) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        if (c() != null) goto L7;
        return this.g;
    L7:
        return this.g - com.larus.business.markdown.api.c.a(r4, c().intValue());
    }

    private final com.larus.business.markdown.api.extplugin.a.c a(TextView r4, Integer r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r6 = r4.getTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_code_widget_list, OaidModel.KEY_ID, "markwon_cached_code_widget_list"));
        if (TypeIntrinsics.isMutableMap(r6) == false) goto L8;
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
    L9:
        if (r7 != null) goto L12;
        return null;
    L12:
        return (com.larus.business.markdown.api.extplugin.a.c) ZeusTransformUtils.preCheckCast(r7.get(r5), com.larus.business.markdown.api.extplugin.a.c.class, "com.obric.memorydata.plugin");
    L8:
        r7 = null;
        goto L9
    }

    private final void a(View r5, Integer r6, com.larus.business.markdown.api.extplugin.a.c r7) {
        com.larus.business.markdown.api.extplugin.a.c r4 = (com.larus.business.markdown.api.extplugin.a.c) ZeusTransformUtils.wrapperContextForParams(r7, com.larus.business.markdown.api.extplugin.a.c.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        Object r8 = r5.getTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_code_widget_list, OaidModel.KEY_ID, "markwon_cached_code_widget_list"));
        if (TypeIntrinsics.isMutableMap(r8) == false) goto L8;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
    L9:
        if (r9 != null) goto L11;
        r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L11:
        r9.put(r6, r4);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_code_widget_list, OaidModel.KEY_ID, "markwon_cached_code_widget_list"), r9);
        return;
    L8:
        r9 = null;
        goto L9
    }

    private static final void a(b r2, int r3, CharSequence r4, int r5, View r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$widgetView");
        r2.a("post show image marginTop " + r3, r7, r5);
        r6.setVisibility(0);
    }

    private final void a(String r2, CharSequence r3, int r4) {
        Log.d("CustomCodeSpan", "log:" + r2 + ", text:" + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")) + ", index:" + r4);
    }

    public static /* synthetic */ void lambda$iKPtfrbySzXVGPp4RtdSDtfVWXY(b r0, int r1, CharSequence r2, int r3, View r4) {
        a(r0, r1, r2, r3, r4);
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public String a() {
        return this.c;
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public void a(Spanned r2, com.larus.business.markdown.api.extplugin.a.b r3) {
        Spanned r1 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.extplugin.a.b r4 = (com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r4, "span");
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public void a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        a("span afterAttach", r3.getText(), -1);
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public void a(TextView r10, Spanned r11) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r11, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "textView");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.i = r10;     // Catch: Exception -> L39
        ViewParent r12 = r10.getParent();     // Catch: Exception -> L39
        if (ZeusTransformUtils.instanceOf(r12, FrameLayout.class) == false) goto L6;
        FrameLayout r13 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
    L8:
        if (ZeusTransformUtils.instanceOf(r10, com.larus.business.markdown.api.c.a.a.class) == false) goto L37;
        if (r13 == null) goto L37;
        com.larus.business.markdown.api.extplugin.a.c r0 = a(r10, c());     // Catch: Exception -> L39
        if (r0 != null) goto L19;
        com.larus.business.markdown.api.extplugin.a.a r1 = this.h;     // Catch: Exception -> L39
        if (r1 == null) goto L17;
        r0 = r1.a(r13, r10, r4, (com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.preCheckCast(this, com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        if (r0 == null) goto L17;
    L18:
        a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), c(), r0);     // Catch: Exception -> L39
    L17:
        r0 = (com.larus.business.markdown.api.extplugin.a.c) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.a(), com.larus.business.markdown.api.extplugin.a.c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
    L19:
        Size r2 = r0.a(r10, r4, (com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.preCheckCast(this, com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin"), null, d(), a(r4));     // Catch: Exception -> L39
        if (r2 != null) goto L22;
        r2 = new Size(0, 0);     // Catch: Exception -> L39
    L22:
        this.j = r2;     // Catch: Exception -> L39
        a("span calc new__: " + this.j.getWidth() + ", " + this.j.getHeight(), r10.getText(), 0);     // Catch: Exception -> L39
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        Intrinsics.checkNotNullExpressionValue(r14, "textView.context");     // Catch: Exception -> L39
        View r15 = r0.a(r14);     // Catch: Exception -> L39
        ViewGroup.LayoutParams r3 = r15.getLayoutParams();     // Catch: Exception -> L39
        if (r3 != null) goto L26;
        r15.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(this.j.getWidth(), this.j.getHeight()), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        r15.setVisibility(4);     // Catch: Exception -> L39
    L32:
        this.k = r0;     // Catch: Exception -> L39
        if (r15.getParent() != null) goto L45;
        r13.addView(r15);     // Catch: Exception -> L39
        return;
    L45:
        return;
    L26:
        if (r3.width == this.j.getWidth()) goto L28;
    L29:
        ViewGroup.LayoutParams r5 = r15.getLayoutParams();     // Catch: Exception -> L39
        if (r5 == null) goto L36;
        r5.width = this.j.getWidth();     // Catch: Exception -> L39
        r5.height = this.j.getHeight();     // Catch: Exception -> L39
        r15.setLayoutParams(r5);     // Catch: Exception -> L39
        goto L32
    L36:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Exception -> L39
    L28:
        if (r3.height == this.j.getHeight()) goto L32;
    L37:
        this.k = null;     // Catch: Exception -> L39
        return;
    L6:
        r13 = null;
    L39:
        e = move-exception;
        f r16 = g.a();
        if (r16 == null) goto L47;
        r16.e("CustomCodeSpan", "beforeAttach error:" + e);
        return;
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public void a(TextView r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        if (r5 == false) goto L14;
        com.larus.business.markdown.api.extplugin.a.c r6 = this.k;
        if (r6 == null) goto L14;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "textView.context");
        View r8 = r6.a(r7);
        if (r8 == null) goto L14;
        ViewParent r9 = r8.getParent();
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.class) == false) goto L11;
        ViewGroup r10 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin");
    L12:
        if (r10 == null) goto L14;
        r10.removeView(r8);
        goto L14
    L11:
        r10 = null;
    L14:
        this.i = null;
        a("span detach", null, 0);
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public String b() {
        return this.d;
    }

    @Override // com.larus.business.markdown.api.extplugin.a.b
    public Integer c() {
        return this.e;
    }

    public Map<String, Object> d() {
        return this.f5217b;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r4, CharSequence r5, final int r6, int r7, float r8, int r9, int r10, int r11, Paint r12) {
        final CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r12, "paint");
        TextView r14 = this.i;
        if (r14 != null) goto L5;
        return;
    L5:
        com.larus.business.markdown.api.extplugin.a.c r15 = this.k;
        if (r15 != null) goto L8;
        return;
    L8:
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r16, "textView.context");
        final View r17 = r15.a(r16);
        m r1 = null;
        if (ZeusTransformUtils.instanceOf(r13, SpannableString.class) == false) goto L11;
        SpannableString r18 = (SpannableString) ZeusTransformUtils.preCheckCast(r13, SpannableString.class, "com.obric.memorydata.plugin");
    L12:
        if (r18 == null) goto L16;
        Object[] r19 = ((Spanned) ZeusTransformUtils.preCheckCast(r18, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r6, r7, m.class);
        Intrinsics.checkExpressionValueIsNotNull(r19, "getSpans(start, end, T::class.java)");
        m[] r20 = (m[]) ZeusTransformUtils.preCheckCast(r19, m[].class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L16;
        r1 = (m) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r20), m.class, "com.obric.memorydata.plugin");
    L16:
        if (r1 == null) goto L18;
        float r21 = r1.a();
    L19:
        r17.setAlpha(r21 / 255);
        final int r22 = ((r9 + r14.getTop()) + r14.getPaddingTop()) + (((r11 - r9) - this.j.getHeight()) / 2);
        int r23 = (((int) r8) + r14.getLeft()) + r14.getPaddingLeft();
        ViewGroup.LayoutParams r24 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r25.topMargin == r22) goto L22;
    L28:
        ViewGroup.LayoutParams r26 = r17.getLayoutParams();
        Objects.requireNonNull(r26, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r27 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r26, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r28.topMargin = r22;
        r28.leftMargin = r23;
        r17.setLayoutParams(r27);
        r17.setVisibility(4);
        r17.post(new $$Lambda$b$iKPtfrbySzXVGPp4RtdSDtfVWXY(this, r22, r13, r6, r17));
        return;
    L22:
        if (r25.leftMargin != r23) goto L28;
        if (r17.getVisibility() == 0) goto L27;
        a("span just show image marginTop " + r22, r13, r6);
        r17.setVisibility(0);
        return;
    L27:
        a("span already show image marginTop " + r22, r13, r6);
        return;
    L18:
        r21 = 255.0f;
        goto L19
    L11:
        r18 = null;
        goto L12
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "paint");
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L10;
    L9:
        int r10 = this.j.getHeight();
    L13:
        if (r7 == null) goto L15;
        r7.ascent = -r10;
        r7.descent = 0;
        r7.top = r7.ascent;
        r7.bottom = 0;
    L15:
        a("span_size, get: " + this.j.getWidth() + ", " + r10, r8, r5);
        return this.j.getWidth();
    L10:
        TextView r11 = this.i;
        if (r11 == null) goto L9;
        r10 = (int) ((this.j.getHeight() - r11.getLineSpacingExtra()) / r11.getLineSpacingMultiplier());
        goto L13
    L5:
        if (r8.length() != r6) goto L7;
        r9 = true;
        goto L8
    }
}
