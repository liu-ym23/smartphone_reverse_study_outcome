package com.obric.memorydata.markdown.stream;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001cH\u0002J\u0006\u0010!\u001a\u00020\u001cJ\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlinkingCursorManager;", "", "textView", "Landroid/widget/TextView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "blinkIntervalMs", "", "cursorRadiusDp", "", "cursorColorRes", "", "<init>", "(Landroid/widget/TextView;Lkotlinx/coroutines/CoroutineScope;JFLjava/lang/Integer;)V", "Ljava/lang/Integer;", "blinkJob", "Lkotlinx/coroutines/Job;", "isActive", "", "showCursor", "renderedContent", "", "renderedWithCursor", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "initTextViewStableConfig", "", "createCursorSpan", "Lcom/obric/memorydata/markdown/stream/BlinkingCursorSpan;", CommonConsts.APM_INNER_EVENT_COST_START, "showCursorOnly", "captureAndShowCursor", "buildWithCursor", Params.CONTENT, "refreshDisplay", "stop", "isRunning", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0487a f10008a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f10009b;
    private final long c;
    private final float d;
    private final Integer e;
    private volatile bx f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile CharSequence i;
    private volatile CharSequence j;

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlinkingCursorManager$Companion;", "", "<init>", "()V", "CURSOR_PLACEHOLDER", "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0487a {
        private C0487a() {
        }

        public /* synthetic */ C0487a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10008a = new C0487a(null);
    }

    public static final /* synthetic */ void a(a r0) {
        r0.c();
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.h = r1;
    }

    private final b b() {
        if (this.e == null) goto L6;
        return b.f10010a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.e.intValue(), this.d);
    L6:
        return b.f10010a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.d);
    }

    public static final /* synthetic */ boolean b(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ long c(a r2) {
        return r2.c;
    }

    private final void c() {
        b r0 = b();
        SpannableStringBuilder r1 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast("\u200c", CharSequence.class, "com.obric.memorydata.plugin"));
        r1.setSpan(r0, 0, 1, 16711698);
        this.i = (CharSequence) ZeusTransformUtils.preCheckCast(new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin");
        this.j = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        this.f10009b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private final void d() {
        if (this.h == false) goto L5;
        CharSequence r0 = this.j;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f10009b.getText(), r0) == true) goto L12;
        ViewGroup.LayoutParams r1 = this.f10009b.getLayoutParams();
        r1.height = this.f10009b.getHeight();
        this.f10009b.requestLayout();
        this.f10009b.setText(r0);
        this.f10009b.getLayoutParams().height = -2;
        return;
    L12:
        return;
    L5:
        r0 = this.i;
        goto L6
    }

    public static final /* synthetic */ boolean d(a r0) {
        return r0.h;
    }

    public static final /* synthetic */ void e(a r0) {
        r0.d();
    }

    private final Context getContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f10009b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        return r2;
    }

    public final void a() {
        this.g = false;
        bx r0 = this.f;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.f = null;
        TextView r1 = this.f10009b;
        CharSequence r2 = this.i;
        if (r2 != null) goto L8;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        r1.setText(r2);
        this.i = null;
        this.j = null;
    }
}
