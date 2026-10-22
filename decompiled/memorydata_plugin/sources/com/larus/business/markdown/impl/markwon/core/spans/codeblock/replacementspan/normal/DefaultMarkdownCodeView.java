package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.larus.business.markdown.impl.common.utils.c;
import com.larus.business.markdown.impl.databinding.MarkdownCodeViewLayoutBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.syntax.b;
import io.noties.markwon.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bm;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0001IB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020!H\u0002J\u0006\u00107\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020!J\u0006\u00109\u001a\u00020\u000eJ\b\u0010:\u001a\u000201H\u0002J\u009a\u0001\u0010;\u001a\u00020*2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2%\b\u0002\u0010+\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020*\u0018\u00010,2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)2\u0006\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00072\n\b\u0003\u0010@\u001a\u0004\u0018\u00010AH\u0007¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020!H\u0002J\u0006\u0010D\u001a\u00020*J\b\u0010E\u001a\u00020*H\u0002J\b\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020*H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020*\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_MAX_HEIGHT", "MAX_LINE", "binding", "Lcom/larus/business/markdown/impl/databinding/MarkdownCodeViewLayoutBinding;", "currentCode", "", "getCurrentCode", "()Ljava/lang/String;", "setCurrentCode", "(Ljava/lang/String;)V", "currentLanguage", "getCurrentLanguage", "setCurrentLanguage", "highlight", "Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "getHighlight", "()Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "highlight$delegate", "Lkotlin/Lazy;", "highlightDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "highlightScope", "Lkotlinx/coroutines/CoroutineScope;", "isFinish", "", "()Z", "setFinish", "(Z)V", "isFold", "Ljava/lang/Boolean;", "maxHeight", "onClickCopyListener", "Lkotlin/Function0;", "", "onClickFullScreenListener", "Lkotlin/Function1;", "onClickPreviewListener", "onLongClickListener", "supportsCodePreview", "textView", "Landroid/widget/TextView;", "bindData", "code", Api.KEY_LANGUAGE, "bindText", "enableAsync", "getCode", "getFinishState", "getLanguage", "getMarkdownTextView", CommonConsts.APM_INNER_EVENT_COST_INIT, "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "isClickButton", "foldText", "textSize", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ILjava/lang/Float;)V", "isMarkdownTextViewClickable", "onRecycle", "performSingleClick", "updateGravity", "updateHafFoldStatus", "updatePreviewButton", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultMarkdownCodeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f5222b;
    private MarkdownCodeViewLayoutBinding c;
    private final Lazy d;
    private final int e;
    private final int f;
    private String g;
    private String h;
    private boolean i;
    private int j;
    private Function0<Boolean> k;
    private Boolean l;
    private final bm m;
    private final al n;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView$Companion;", "", "()V", "MARKDOWN_CODE_STD_OUT", "", "TAG", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5221a = new a(null);
    }

    public DefaultMarkdownCodeView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DefaultMarkdownCodeView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public DefaultMarkdownCodeView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f5222b = new TextView(r6);
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(DefaultMarkdownCodeView$highlight$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        int r8 = c.l();
        this.e = r8;
        this.f = 20;
        this.g = "";
        this.h = "";
        this.j = r8;
        ExecutorService r9 = Executors.newSingleThreadExecutor($$Lambda$DefaultMarkdownCodeView$rWxVnO2SxIO897zCnxAOwAQs3hw.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r9, "newSingleThreadExecutor …\"highlight-thread\")\n    }");
        bm r10 = bo.a(r9);
        this.m = r10;
        this.n = am.a(r10.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public /* synthetic */ DefaultMarkdownCodeView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ b a(DefaultMarkdownCodeView r0) {
        return r0.getHighlight();
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "highlight-thread");
    }

    private final boolean a() {
        return false;
    }

    private final void b() {
        Function0<Boolean> r0 = this.k;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        ImageView r2 = null;
        if (r1 == true) goto L11;
    L18:
        MarkdownCodeViewLayoutBinding r5 = this.c;
        if (r5 == null) goto L21;
        r2 = r5.markdownCodePreviewButton;
    L21:
        if (r2 == null) goto L27;
        r2.setVisibility(8);
        return;
    L27:
        return;
    L11:
        if (this.i == false) goto L18;
        MarkdownCodeViewLayoutBinding r6 = this.c;
        if (r6 == null) goto L15;
        r2 = r6.markdownCodePreviewButton;
    L15:
        if (r2 == null) goto L26;
        r2.setVisibility(0);
        return;
    L26:
        return;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L7;
        goto L7
    }

    private final void c() {
        TextView r0 = getMarkdownTextView();
        if (this.i == false) goto L5;
        int r2 = 48;
    L7:
        if ((r0.getGravity() & 112) == r2) goto L10;
        r0.setGravity(r2 | (r0.getGravity() & 7));
        r0.requestLayout();
        return;
    L10:
        return;
    L5:
        r2 = 80;
        goto L7
    }

    private final void d() {
        if (this.i == false) goto L5;
        String r0 = com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui.a.f5226a.b(this.g, this.f);
    L6:
        TextView r1 = getMarkdownTextView();
        if (a() == false) goto L29;
        boolean r4 = true;
        if (Intrinsics.areEqual(this.l, true) == true) goto L20;
        CharSequence r2 = r1.getText();
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        CharSequence r10 = getHighlight().a(this.h, r0);
    L30:
        r1.setText(r10);
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
    L20:
        CharSequence r5 = r1.getText();
        if (r5 != null) goto L23;
    L26:
        if (r4 == false) goto L28;
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
    L28:
        i.a(this.n, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DefaultMarkdownCodeView$bindText$1(this, r0, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L23:
        if (r5.length() == 0) goto L26;
        r4 = false;
        goto L26
    L29:
        r10 = (CharSequence) ZeusTransformUtils.preCheckCast(new x(getHighlight().a(this.h, r0)).b(), CharSequence.class, "com.obric.memorydata.plugin");
        goto L30
    L5:
        r0 = com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui.a.f5226a.a(this.g, this.f);
        goto L6
    }

    private final void e() {
        Boolean r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r3 = null;
        if (this.i == false) goto L18;
        boolean r1 = Intrinsics.areEqual(r0, true);
        MarkdownCodeViewLayoutBinding r4 = this.c;
        if (r1 == false) goto L14;
        if (r4 == null) goto L11;
        r3 = r4.markdownCodeFoldDesc;
    L11:
        if (r3 == null) goto L26;
        r3.setVisibility(0);
        return;
    L26:
        return;
    L14:
        if (r4 == null) goto L16;
        r3 = r4.markdownCodeFoldDesc;
    L16:
        if (r3 == null) goto L27;
    L23:
        r3.setVisibility(8);
        return;
    L27:
        return;
    L18:
        MarkdownCodeViewLayoutBinding r5 = this.c;
        if (r5 == null) goto L21;
        r3 = r5.markdownCodeFoldDesc;
    L21:
        if (r3 != null) goto L23;
    }

    private final b getHighlight() {
        return (b) ZeusTransformUtils.preCheckCast(this.d.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    private final TextView getMarkdownTextView() {
        return this.f5222b;
    }

    public static /* synthetic */ Thread lambda$rWxVnO2SxIO897zCnxAOwAQs3hw(Runnable r0) {
        return a(r0);
    }

    public void a(String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "code");
        Intrinsics.checkNotNullParameter(r8, Api.KEY_LANGUAGE);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        setVisibility(8);
        return;
    L10:
        TextView r5 = null;
        String r10 = StringsKt.substringBefore$default(r8, " ", null, 2, null);
        if (Intrinsics.areEqual(r10, "STDOUT") == false) goto L14;
        setVisibility(8);
        return;
    L14:
        setVisibility(0);
        MarkdownCodeViewLayoutBinding r1 = this.c;
        if (r1 == null) goto L17;
        r5 = r1.markdownCodeLanguage;
    L17:
        if (r5 == null) goto L20;
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
    L20:
        this.g = r7;
        this.h = r10;
        this.i = r9;
        d();
        c();
        b();
        e();
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final String getCode() {
        return this.g;
    }

    public final String getCurrentCode() {
        return this.g;
    }

    public final String getCurrentLanguage() {
        return this.h;
    }

    public final boolean getFinishState() {
        return this.i;
    }

    public final String getLanguage() {
        return this.h;
    }

    public final void setCurrentCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setCurrentLanguage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setFinish(boolean r1) {
        this.i = r1;
    }
}
