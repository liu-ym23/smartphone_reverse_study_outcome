package com.larus.bmhome.view.textview.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.t;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.utils.s2;
import com.larus.bmhome.view.textview.impl.phone.PhoneAppLogHelper;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.d;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.business.markdown.impl.markwon.c;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import fh8.f;
import fh8.h;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import lsc.i;
import lsc.v;
import lsc.w;
import lw8.l;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.node.Link;
import org.commonmark.node.StrongEmphasis;
import tsc.o;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u000208H\u0014J\u0018\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0014J0\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0014J(\u0010B\u001a\u0002082\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J(\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0014J0\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u00152\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0012\u0010O\u001a\u0002082\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010R\u001a\u0002082\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0000H\u0016J\b\u0010X\u001a\u00020\bH\u0016J\b\u0010Y\u001a\u000208H\u0016J\u001e\u0010Z\u001a\u0002082\b\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010[\u001a\u000208H\u0002J.\u0010\\\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u00152\u0006\u0010]\u001a\u00020\u000e2\b\u0010^\u001a\u0004\u0018\u00010\u00192\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\n\u0010a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010b\u001a\u000208H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u000eH\u0016J\u0012\u0010b\u001a\u0002082\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\b\u0010e\u001a\u000208H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "Lcom/larus/bmhome/view/textview/impl/CustomUnderlineTextView;", "Lcom/larus/bmhome/view/textview/api/ICustomMarkdownTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "jumpAnalyzer", "Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer;", "settingMd", "", "markdownWidth", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "onBoardingType", "", "getOnBoardingType", "()Ljava/lang/String;", "value", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "markwonContent", "getMarkwonContent", "()Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "onboardingType", "getOnboardingType", "payloadParam", "", "", "payload", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "markdownTextMonitorCache", "getMarkdownTextMonitorCache", "setMarkdownTextMonitorCache", "(Ljava/lang/String;)V", "hasLink", "hasFormula", "hasTable", "hasBold", "requestRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "onAttachedToWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "setPadding", "setPaddingRelative", "start", "end", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMarkdown", "content", "highlight", "Lkotlin/ranges/IntRange;", "setMarkdownCallback", "Lio/noties/markwon/SetMarkdownCallback;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "setText", ShareType.TEXT, "", "type", "Landroid/widget/TextView$BufferType;", "asTextView", "getSelectedColor", "onRecycled", "setTextDirectly", "onSpanRecycled", "analysisJump", "stream", "messageId", "listener", "Lcom/larus/business/markdown/api/view/text/JumpListener;", "getOriginText", "checkNode", "node", "Lorg/commonmark/node/Node;", "startAppLogJob", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomMarkdownTextView extends CustomUnderlineTextView implements rt8.a {
    public final c j;
    public boolean k;
    public int l;
    public MarkwonContent m;
    public String n;
    public Map<String, Object> o;
    public String p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    public static final class a {
    }

    static {
    }

    public CustomMarkdownTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomMarkdownTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rt8.a
    public final void a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        CharSequence r2 = getText();     // Catch: Throwable -> L17
        if ((r2 instanceof Spanned) == false) goto L6;
        Spanned r3 = (Spanned) r2;     // Catch: Throwable -> L17
    L7:
        int r4 = 0;
        if (r3 == null) goto L11;
        o[] r5 = (o[]) r3.getSpans(0, getText().length(), o.class);     // Catch: Throwable -> L17
        if (r5 == null) goto L11;
    L12:
        int r6 = r5.length;     // Catch: Throwable -> L17
    L13:
        if (r4 >= r6) goto L15;
        r5[r4].f(this);     // Catch: Throwable -> L17
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L13
    L15:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L22;
        FLogger.a.i("MarkdownTextView", r8.toString());
    L22:
        this.j.getClass();
        Map<String, Object> r9 = this.o;
        if (r9 == null) goto L33;
        f r10 = h.b(r9);
        if (r10 == null) goto L33;
        Message r11 = r10.b;
        if (r11 == null) goto L33;
        String r12 = r11.getMessageId();
        if (r12 == null) goto L33;
        t r13 = ILegacyChatUiServiceDelegate.b.V8();
        if (r13 == null) goto L33;
        r13.b(r12, this);
    L33:
        super/*android.widget.TextView*/.setText("", TextView.BufferType.NORMAL);
        MarkwonContent r14 = this.m;
        if (r14 == null) goto L38;
        SpannableStringBuilder r15 = r14.a;
        if (r15 == null) goto L38;
        r15.clear();
    L38:
        MarkwonContent r16 = this.m;
        if (r16 == null) goto L41;
        r16.j(this);
    L41:
        MarkwonContent r17 = this.m;
        if (r17 == null) goto L44;
        r17.k(this);
    L44:
        MarkwonContent r18 = this.m;
        if (r18 == null) goto L47;
        r18.l(this);
    L47:
        this.m = null;
        this.n = null;
        setMarkdownTextMonitorCache(null);
        return;
    L11:
        r5 = new o[0];     // Catch: Throwable -> L17
        goto L12
    L6:
        r3 = null;
    L17:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ow8.a
    public final TextView o() {
        return this;
    }

    public final boolean requestRectangleOnScreen(Rect r1, boolean r2) {
        return false;
    }

    @Override // rt8.a
    public String getOriginText() {
        MarkwonContent r0 = this.m;
        if (r0 == null) goto L7;
        b r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.f;
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ow8.a
    public int getSelectedColor() {
        return ContextCompat.getColor(getContext(), 2131103318);
    }

    @Override // rt8.a
    public final void h() {
        long r0 = SystemClock.elapsedRealtime();
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        MarkwonContent r2 = this.m;
        if (r2 == null) goto L5;
        b r3 = r2.e;
    L6:
        B(r3);
        FLogger.a.d("MarkdownTextView", "checkNode, hasLink[" + this.q + "], cost: " + (SystemClock.elapsedRealtime() - r0));
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.textview.impl.SelectorTextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MarkwonContent r0 = this.m;
        if (r0 == null) goto L9;
        List r1 = (List) r0.m.getValue();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if ((!r1.isEmpty()) != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        C(this.m, null, null, null);
    L12:
        Map<String, Object> r3 = this.o;
        if (r3 == null) goto L24;
        f r4 = h.b(r3);
        if (r4 == null) goto L25;
        Message r5 = r4.b;
        if (r5 == null) goto L26;
        String r6 = r5.getMessageId();
        if (r6 == null) goto L27;
        t r7 = ILegacyChatUiServiceDelegate.b.V8();
        if (r7 == null) goto L28;
        r7.f(r6, this);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // rt8.a
    public final boolean d() {
        return this.s;
    }

    @Override // rt8.a
    public final boolean e() {
        return this.r;
    }

    @Override // rt8.a
    public final boolean g() {
        return this.q;
    }

    @Override // ow8.a
    public l getMarkdownContent() {
        return this.m;
    }

    @Override // rt8.a
    public String getMarkdownTextMonitorCache() {
        return this.p;
    }

    @Override // ow8.a
    public int getMarkdownWidth() {
        return this.l;
    }

    public final MarkwonContent getMarkwonContent() {
        return this.m;
    }

    public String getOnBoardingType() {
        return this.n;
    }

    public final String getOnboardingType() {
        return this.n;
    }

    @Override // rt8.a
    public Map<String, Object> getPayload() {
        return this.o;
    }

    @Override // rt8.a
    public final boolean m() {
        return this.t;
    }

    public final void B(b r3) {
        if ((r3 instanceof Link) == false) goto L6;
        this.q = true;
    L17:
        if (r3 == null) goto L19;
        b r4 = r3.b;
    L20:
        if (r4 == null) goto L22;
        B(r4);
        r4 = r4.e;
        goto L20
    L22:
        return;
    L19:
        r4 = null;
        goto L20
    L6:
        if ((r3 instanceof LatexMathNode) == false) goto L8;
    L16:
        this.r = true;
        goto L17
    L8:
        if ((r3 instanceof LatexMathBlock) == true) goto L16;
        if ((r3 instanceof TableBlock) == false) goto L14;
        this.s = true;
        goto L17
    L14:
        if ((r3 instanceof StrongEmphasis) == false) goto L17;
        this.t = true;
        goto L17
    }

    @Override // com.larus.bmhome.view.textview.impl.CustomUnderlineTextView
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super/*android.widget.TextView*/.onInitializeAccessibilityNodeInfo(r4);
        if (r4 == null) goto L6;
        int r0 = s2.a;
        r4.setContentDescription(s2.b(this.m, null, 6));
        return;
    }

    public void setMarkdown(l r2) {
        C(r2, null, null, null);
    }

    @Override // rt8.a
    public void setMarkdownTextMonitorCache(String r1) {
        this.p = r1;
    }

    public void setMarkdownWidth(int r1) {
        this.l = r1;
    }

    public void setPayload(Map<String, Object> r1) {
        this.o = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        int r0 = w.a;     // Catch: Throwable -> L16
        getPaint();     // Catch: Throwable -> L16
        if (getMarkdownWidth() <= 0) goto L6;
        getMarkdownWidth();     // Catch: Throwable -> L16
        getPaddingStart();     // Catch: Throwable -> L16
        getPaddingEnd();     // Catch: Throwable -> L16
    L6:
        if (getMarkdownWidth() <= 0) goto L14;
        MarkwonContent r1 = this.m;     // Catch: Throwable -> L16
        boolean r2 = false;
        if (r1 != null) goto L10;
    L12:
        if (r2 == false) goto L14;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMarkdownWidth(), 1073741824), r5);     // Catch: Throwable -> L16
        return;
    L10:
        if (r1.c != true) goto L12;
        r2 = true;
    L14:
        super.onMeasure(r4, r5);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        int r6 = w.a;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r4, TextView.BufferType r5) {
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (this.k == true) goto L25;
        MarkwonContent r0 = this.m;
        if (r0 == null) goto L25;
        lw8.h r1 = r0.f;
        if (r1 == null) goto L25;
        i r2 = r1.a();
        if (r2 == null) goto L25;
        this.k = true;     // Catch: Throwable -> L22
        if ((r4 instanceof Spanned) == false) goto L16;
        Spanned r6 = (Spanned) r4;     // Catch: Throwable -> L22
    L17:
        if (r6 != null) goto L19;
        r6 = new SpannableString(r4);     // Catch: Throwable -> L22
    L19:
        r2.d(this, r6, null);     // Catch: Throwable -> L22
        this.k = false;
        return;
    L16:
        r6 = null;
    L22:
        th = move-exception;
        this.k = false;
        throw th;
    L25:
        if (r5 != null) goto L27;
        r5 = TextView.BufferType.NORMAL;
    L27:
        super/*android.widget.TextView*/.setText(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomMarkdownTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = new c();
        setHighlightColor(0);
    }

    public /* synthetic */ CustomMarkdownTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(l r11, IntRange r12, String r13, v r14) {
        SpannableStringBuilder r0 = null;
        if (r11 == null) goto L11;
        if ((r11 instanceof MarkwonContent) == true) goto L11;
        d r1 = IMarkdownLoggerKt.a();
        if (r1 == null) goto L13;
        r1.e("mark_down", "unsupport markdown: " + r11);
    L13:
        MarkwonContent r15 = null;
    L14:
        this.m = r15;
        this.n = r13;
        if (r15 == null) goto L17;
        SpannableStringBuilder r16 = r15.a;
    L18:
        if (r16 != null) goto L21;
        super/*android.widget.TextView*/.setText("", TextView.BufferType.NORMAL);
        return;
    L21:
        boolean r2 = false;
        if (r12 == null) goto L24;
        int r3 = RangesKt.coerceAtLeast(r12.getFirst(), 0);
    L26:
        if (r12 == null) goto L28;
        int r17 = RangesKt.coerceAtMost(r12.getLast() + 1, r16.length());
    L30:
        if (r17 <= r3) goto L93;
        SpannableStringBuilder r5 = new SpannableStringBuilder(r16);
        r5.setSpan(new BackgroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(2130973611, getContext(), 2131105590))), r3, r17, 17);
        if (AppHost.a.isDebug() == false) goto L36;
        d r18 = IMarkdownLoggerKt.a();
        if (r18 == null) goto L36;
        r18.v("MarkdownTextView", "MdRead: [" + r3 + ", " + r17 + ")==>" + r5.subSequence(r3, r17).toString());
    L36:
        r16 = r5;
    L93:
        int r19 = w.a;     // Catch: Throwable -> L88
        getPaint();     // Catch: Throwable -> L88
        if (getMarkdownWidth() <= 0) goto L40;
        getMarkdownWidth();     // Catch: Throwable -> L88
        getPaddingStart();     // Catch: Throwable -> L88
        getPaddingEnd();     // Catch: Throwable -> L88
    L40:
        this.k = true;     // Catch: Throwable -> L88
        Intrinsics.checkNotNullParameter(r16, "builder");     // Catch: Throwable -> L88
        tt8.b r110 = m31getTextSelector();     // Catch: Throwable -> L88
        if (r110 == null) goto L91;
        int r4 = Math.max(r110.l, 0);     // Catch: Throwable -> L88
        int r6 = Math.min(r110.m, r16.length());     // Catch: Throwable -> L88
        if (r6 <= r4) goto L91;
        r16.setSpan(r110.o, r4, r6, 17);     // Catch: Throwable -> L88
    L91:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L53
        lw8.h r112 = r15.f;     // Catch: Throwable -> L53
        if (r112 == null) goto L50;
        i r113 = r112.a();     // Catch: Throwable -> L53
        if (r113 == null) goto L50;
        r113.d(this, r16, r14);     // Catch: Throwable -> L53
    L51:
        Object r114 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r115 = Result.exceptionOrNull-impl(r114);     // Catch: Throwable -> L88
        if (r115 == null) goto L58;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L88
        super/*android.widget.TextView*/.setText(r16, TextView.BufferType.NORMAL);     // Catch: Throwable -> L88
    L58:
        this.k = false;
        int r116 = w.a;
        MarkwonContent r117 = this.m;
        if (r117 != null) goto L61;
    L63:
        if (r2 == false) goto L97;
        Map<String, Object> r118 = this.o;
        if (r118 == null) goto L68;
        f r119 = h.b(r118);
    L69:
        if (r119 == null) goto L95;
        Message r120 = r119.b;
        if (r120 == null) goto L96;
        String r7 = r120.getMessageId();
        if (r7 == null) goto L98;
        String r121 = r119.d;
        if (r121 != null) goto L83;
        Message r122 = r119.b;
        if (r122 == null) goto L80;
        r121 = r122.getSenderId();
    L81:
        if (r121 != null) goto L83;
        return;
    L80:
        r121 = null;
    L83:
        String r8 = r121;
        int r123 = PhoneAppLogHelper.a;
        Context r9 = getContext();
        MarkwonContent r124 = this.m;
        if (r124 == null) goto L86;
        r0 = r124.a;
    L86:
        PhoneAppLogHelper.a(r9, r7, r8, r0, r119.q, false);
        return;
    L98:
        return;
    L96:
        return;
    L95:
        return;
    L68:
        r119 = null;
        goto L69
    L97:
        return;
    L61:
        if (r117.h != true) goto L63;
        r2 = true;
        goto L63
    L50:
        super/*android.widget.TextView*/.setText(r16, TextView.BufferType.NORMAL);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L88
        r114 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        this.k = false;
        int r126 = w.a;
        throw th;
    L28:
        r17 = 0;
        goto L30
    L24:
        r3 = 0;
        goto L26
    L17:
        r16 = null;
    L11:
        if ((r11 instanceof MarkwonContent) == false) goto L13;
        r15 = (MarkwonContent) r11;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.setPadding(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.setPaddingRelative(r1, r2, r3, r4);
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
