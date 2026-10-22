package com.larus.uaigc.chat.markdown.placeholder;

import android.content.Context;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationTextPlaceholderBinding;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import fz9.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import usc.e;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016JR\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0014J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J/\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010$\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/uaigc/chat/markdown/placeholder/MDTextPlaceHolderWidget;", "Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationTextPlaceholderBinding;", "message", "Lcom/larus/im/bean/message/Message;", "markDownData", "Lcom/larus/uaigc/chat/markdown/bean/CreationPlaceholderData;", "preLoadingText", "", "onRecycle", "", "bindData", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", "payload", "", "", "initView", "refreshViewState", "(Landroid/widget/TextView;Landroid/text/Spanned;Lio/noties/markwon/html/customdata/ICustomDataSpan;I)Lkotlin/Unit;", "hideOriginalLoadingDot", "updateSizeInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MDTextPlaceHolderWidget extends AbsCustomCreationDataWidget {
    public static final /* synthetic */ int h = 0;
    public Size c;
    public LarusWidgetMarkdownCreationTextPlaceholderBinding d;
    public Message e;
    public b f;
    public String g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final void c() {
        super.c();
        removeAllViews();
        this.d = null;
    }

    public MDTextPlaceHolderWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new Size(0, 0);
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final Size b(final TextView r8, Spanned r9, e r10, Message r11, b r12, int r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r8, "textView");
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r10, "span");
        this.e = r11;
        this.f = r12;
        String r15 = null;
        if (this.d != null) goto L10;
        LarusWidgetMarkdownCreationTextPlaceholderBinding r16 = LarusWidgetMarkdownCreationTextPlaceholderBinding.a(LayoutInflater.from(getContext()), this, true);
        this.d = r16;
        setClipToPadding(false);
        r16.a.setOnLongClickListener(new gz9.a(r8));
        TextView r1 = r16.b.getLoadingText();
        b r2 = this.f;
        if (r2 == null) goto L7;
        String r3 = r2.b();
    L8:
        r1.setText(r3);
        r16.b.a();
        removeAllViews();
        addView(r16.a);
        Unit r17 = Unit.INSTANCE;
        goto L10
    L7:
        r3 = null;
    L10:
        if (this.d == null) goto L96;
        String r18 = this.g;
        b r4 = this.f;
        if (r4 == null) goto L14;
        String r5 = r4.b();
    L16:
        if (Intrinsics.areEqual(r18, r5) == true) goto L89;
        b r19 = this.f;
        if (r19 == null) goto L21;
        String r110 = r19.b();
    L22:
        this.g = r110;
        if (r110 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
        this.c = new Size(0, 0);
        goto L89
    L31:
        int r112 = gw8.e.a(r9, r9.getSpanStart(r10)) + r8.getPaddingStart();
        int r20 = i5.E();
        LarusWidgetMarkdownCreationTextPlaceholderBinding r113 = this.d;
        if (r113 == null) goto L43;
        ShimmerTextPlaceHolderView r114 = r113.b;
        if (r114 == null) goto L43;
        TextView r115 = r114.getLoadingText();
        if (r115 == null) goto L43;
        TextPaint r116 = r115.getPaint();
        if (r116 == null) goto L43;
        String r6 = this.g;
        if (r6 != null) goto L42;
        r6 = "";
    L42:
        Number r117 = Float.valueOf(r116.measureText(r6));
    L44:
        int r21 = r20 + r117.intValue();
        Message r118 = this.e;
        if (r118 == null) goto L49;
        CreationMsgContentData r119 = dp8.e.c(r118);
        if (r119 == null) goto L49;
        r15 = r119.text;
    L49:
        if (r15 != null) goto L51;
    L54:
        boolean r120 = true;
    L55:
        boolean r121 = !r120;
        LarusWidgetMarkdownCreationTextPlaceholderBinding r122 = this.d;
        if (r122 == null) goto L63;
        ShimmerTextPlaceHolderView r123 = r122.b;
        if (r123 == null) goto L63;
        if (r121 == false) goto L61;
        int r7 = i5.q();
    L62:
        int r22 = r123.getPaddingEnd();
        int r23 = r123.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:ShimmerTextPlaceHolderView,source:,start:" + r112 + ",top:" + r7 + ",end:" + r22 + ",bottom:" + r23);
        r123.setPaddingRelative(r112, r7, r22, r23);
        goto L63
    L61:
        r7 = 0;
    L63:
        LarusWidgetMarkdownCreationTextPlaceholderBinding r124 = this.d;
        if (r124 == null) goto L74;
        ShimmerTextPlaceHolderView r125 = r124.b;
        if (r125 == null) goto L74;
        TextView r126 = r125.getLoadingText();
        if (r126 == null) goto L74;
        TextPaint r127 = r126.getPaint();
        if (r127 == null) goto L74;
        Paint.FontMetrics r128 = r127.getFontMetrics();
        if (r128 == null) goto L74;
        int r129 = (int) (r128.bottom - r128.top);
    L75:
        if (r129 > 0) goto L77;
        r129 = i5.E();
    L77:
        if (r121 == false) goto L79;
        r129 = r129 + i5.q();
    L79:
        LarusWidgetMarkdownCreationTextPlaceholderBinding r130 = this.d;
        if (r130 == null) goto L88;
        ShimmerTextPlaceHolderView r131 = r130.b;
        if (r131 == null) goto L88;
        ViewGroup.LayoutParams r24 = r131.getLayoutParams();
        if (r24 == null) goto L87;
        r24.height = r129;
        r131.setLayoutParams(r24);
        goto L88
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L88:
        this.c = new Size(RangesKt.coerceAtMost(r21 + r112, r13) + i5.q(), r129);
    L74:
        r129 = 0;
        goto L75
    L51:
        if (StringsKt.isBlank(r15) == true) goto L54;
        r120 = false;
    L43:
        r117 = 0;
        goto L44
    L25:
        if (StringsKt.isBlank(r110) == true) goto L28;
        r111 = false;
        goto L29
    L21:
        r110 = null;
    L89:
        v0[] r25 = (v0[]) r9.getSpans(RangesKt.coerceAtLeast(0, r9.length() - 1), r9.length(), v0.class);
        if (r25 == null) goto L94;
        v0 r26 = (v0) ArraysKt.firstOrNull(r25);
        if (r26 == null) goto L94;
        r26.g = true;
    L94:
        Unit r27 = Unit.INSTANCE;
        goto L96
    L14:
        r5 = null;
    L96:
        return this.c;
    }
}
