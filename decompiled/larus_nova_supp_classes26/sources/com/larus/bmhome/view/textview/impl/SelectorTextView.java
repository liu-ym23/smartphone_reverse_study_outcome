package com.larus.bmhome.view.textview.impl;

import android.content.ClipData;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.utils.FormatSource;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lw8.l;
import tt8.c;
import tt8.d;
import ut8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0014J\u001a\u0010!\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J8\u0010$\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020#H\u0016J\u0016\u0010+\u001a\u00020#2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bJ\u0016\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bJ\b\u0010/\u001a\u00020\u0000H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/SelectorTextView;", "Lcom/larus/bmhome/view/textview/impl/GestureTextView;", "Lcom/larus/bmhome/view/textview/api/selector/ISelectorTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textSelector", "Lcom/larus/bmhome/view/textview/impl/Selector;", "getTextSelector", "()Lcom/larus/bmhome/view/textview/impl/Selector;", "setTextSelector", "(Lcom/larus/bmhome/view/textview/impl/Selector;)V", "appendCurrentSelectSpan", "", "builder", "Landroid/text/SpannableStringBuilder;", "onAttachedToWindow", "addCursorMoveListener", "listener", "Lcom/larus/bmhome/view/textview/api/selector/SelectorCursorMoveListener;", "removeCursorMoveListener", "getSelectedMarkdownContent", "", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", MusicAppletPage.KEY_SOURCE, "Lcom/larus/bmhome/utils/FormatSource;", "onDetachedFromWindow", "copy", "isCopyAll", "", "formateMarkdownText", "start", "end", "copyText", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isShowingSelector", "isSelected", "showSelectView", "touchXInTextView", "touchYInTextView", "asTextView", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectorTextView extends GestureTextView implements st8.b {
    public static final /* synthetic */ int e = 0;
    public tt8.b d;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ MarkwonContent a;

        public b(MarkwonContent r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues(Integer.valueOf(this.a.a.getSpanStart(r3)), Integer.valueOf(this.a.a.getSpanStart(r2)));
        }
    }

    static {
    }

    public SelectorTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelectorTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public /* bridge */ /* synthetic */ st8.b.InterfaceC0134b getTextSelector() {
        return m31getTextSelector();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        setTextSelector(new tt8.b(this));
        Object r0 = getTag(2131365552);
        final SelectorRestore r2 = null;
        if ((r0 instanceof String) == false) goto L5;
        final String r1 = (String) r0;
    L6:
        if (r1 == null) goto L15;
        Object r3 = getTag(2131373650);
        if ((r3 instanceof SelectorRestore) == false) goto L10;
        r2 = (SelectorRestore) r3;
    L10:
        if (r2 == null) goto L16;
        final c r4 = (c) ((LinkedHashMap) r2.b).get(r1);
        if (r4 == null) goto L17;
        post(new d(this, r4, r2, r1));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        if (z() == false) goto L17;
        Object r0 = getTag(2131365552);
        if ((r0 instanceof String) == false) goto L7;
        String r1 = (String) r0;
    L8:
        if (r1 == null) goto L17;
        Object r2 = getTag(2131373650);
        if ((r2 instanceof SelectorRestore) == false) goto L12;
        SelectorRestore r3 = (SelectorRestore) r2;
    L13:
        if (r3 == null) goto L17;
        tt8.b r4 = m31getTextSelector();
        if (r4 == null) goto L17;
        r3.b.put(r1, new c(r4.l, r4.m, r4.u));
        r3.a = r1;
        goto L17
    L12:
        r3 = null;
        goto L13
    L7:
        r1 = null;
    L17:
        tt8.b r5 = m31getTextSelector();
        if (r5 != null) goto L34;
    L32:
        setTextSelector(null);
        return;
    L34:
    L30:
        e = move-exception;
        FLogger.a.e("BaseWordSelector", e.getMessage());
        goto L32
    L20:
        if (r5.d == null) goto L22;
        r5.i();     // Catch: Exception -> L30
        r5.d.removeCallbacks(r5.v);     // Catch: Exception -> L30
        r5.d.getViewTreeObserver().removeOnScrollChangedListener(r5.b);     // Catch: Exception -> L30
        r5.d.getViewTreeObserver().removeOnGlobalLayoutListener(r5.c);     // Catch: Exception -> L30
        r5.d = null;     // Catch: Exception -> L30
    L22:
        i r6 = r5.h;     // Catch: Exception -> L30
        if (r6 == null) goto L25;
        r6.setTouchMoveListener(null);     // Catch: Exception -> L30
        r5.h = null;     // Catch: Exception -> L30
    L25:
        i r7 = r5.j;     // Catch: Exception -> L30
        if (r7 == null) goto L28;
        r7.setTouchMoveListener(null);     // Catch: Exception -> L30
        r5.j = null;     // Catch: Exception -> L30
    L28:
        r5.a = null;     // Catch: Exception -> L30
        goto L32
    }

    public final boolean z() {
        tt8.b r0 = m31getTextSelector();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.p != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX INFO: renamed from: getTextSelector, reason: collision with other method in class */
    public tt8.b m31getTextSelector() {
        return this.d;
    }

    public final void A(st8.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        tt8.b r0 = m31getTextSelector();
        if (r0 == null) goto L6;
        r0.q.remove(r2);
        return;
    }

    public void setTextSelector(tt8.b r1) {
        this.d = r1;
    }

    public final void x(st8.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt8.b r0 = m31getTextSelector();
        if (r0 == null) goto L6;
        r0.q.clear();
        r0.q.add(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // st8.b
    public final void G3(l r8, boolean r9) {
        if (r9 == true) goto L8;
        tt8.b r1 = m31getTextSelector();
        if (r1 == null) goto L8;
        int r2 = RangesKt.coerceAtLeast(r1.l, 0);
    L9:
        if (r9 == false) goto L11;
        int r10 = getText().length();
    L15:
        if (r2 < r10) goto L17;
        int r4 = getText().length();
        int r3 = 0;
    L18:
        StringBuilder r11 = new StringBuilder(getText().subSequence(r3, r4));
        y(r8, r3, r4, r11, FormatSource.UNKNOWN);
        ClipData r12 = ClipData.newPlainText(ShareType.TEXT, StringsKt.removeSuffix(StringsKt.trim(r11.toString()).toString(), "⚫"));     // Catch: Exception -> L25
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Exception -> L25
        if (r13 == null) goto L29;
        r13.d0();     // Catch: Exception -> L25
        i1 r14 = i1.a;
        Context r0 = getContext();     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L25
        r14.i(r0, r12, "bpea-menu-popup-copy");     // Catch: Exception -> L25
    L29:
        tt8.b r15 = m31getTextSelector();
        if (r15 == null) goto L35;
        r15.i();
        return;
    L35:
        return;
    L25:
        e = move-exception;
        com.larus.business.markdown.api.depend.d r16 = IMarkdownLoggerKt.a();
        if (r16 == null) goto L29;
        r16.e("SelectorTextView", "do copy failed", e);
        goto L29
    L17:
        r4 = r10;
        r3 = r2;
        goto L18
    L11:
        tt8.b r17 = m31getTextSelector();
        if (r17 == null) goto L14;
        r10 = RangesKt.coerceAtMost(r17.m, getText().length());
        goto L15
    L14:
        r10 = 0;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // st8.b
    public final String M4(l r10, FormatSource r11) {
        Intrinsics.checkNotNullParameter(r11, MusicAppletPage.KEY_SOURCE);
        tt8.b r0 = m31getTextSelector();
        if (r0 == null) goto L5;
        int r1 = RangesKt.coerceAtLeast(r0.l, 0);
    L6:
        tt8.b r2 = m31getTextSelector();
        if (r2 == null) goto L9;
        int r3 = RangesKt.coerceAtMost(r2.m, getText().length());
    L10:
        if (r1 < r3) goto L12;
        int r6 = getText().length();
        int r5 = 0;
    L13:
        StringBuilder r4 = new StringBuilder(getText().subSequence(r5, r6));
        y(r10, r5, r6, r4, r11);
        return StringsKt.removeSuffix(StringsKt.trim(r4.toString()).toString(), "⚫");
    L12:
        r5 = r1;
        r6 = r3;
        goto L13
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean q(int r4, int r5) {
        if (r4 < 0) goto L18;
        if (r5 < r4) goto L21;
        tt8.b r1 = m31getTextSelector();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.p == true) goto L13;
        return false;
    L13:
        if (r4 >= r1.l) goto L15;
        return false;
    L15:
        if (r5 > r1.m) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    L18:
        return false;
    }

    public SelectorTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SelectorTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void y(l r10, int r11, int r12, StringBuilder r13, FormatSource r14) {
        if ((r10 instanceof MarkwonContent) == false) goto L5;
        MarkwonContent r15 = (MarkwonContent) r10;
    L6:
        if (r15 == null) goto L75;
        ArrayList r0 = new ArrayList();
        List r1 = ArraysKt.toList(r15.a.getSpans(0, getText().length(), io.noties.markwon.ext.onetex.c.class));
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        boolean r5 = true;
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        SpannableStringBuilder r7 = r15.a;
        int r6 = r7.getSpanStart((io.noties.markwon.ext.onetex.c) r4);
        if (r11 > r6) goto L14;
        if (r6 >= r12) goto L14;
    L15:
        if (r5 == false) goto L8;
        r2.add(r4);
    L14:
        r5 = false;
        goto L15
    L17:
        List r8 = ArraysKt.toList(r15.a.getSpans(0, getText().length(), LeadingMarginSpan.class));
        List r9 = ArraysKt.toList(r15.a.getSpans(0, getText().length(), CustomCitationSpan.class));
        r0.addAll(r2);
        r0.addAll(r8);
        r0.addAll(r9);
        List r16 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(r0, new b(r15)));
        io.noties.markwon.ext.onetex.c r17 = (io.noties.markwon.ext.onetex.c) CollectionsKt.lastOrNull(r2);
        Iterator r18 = r16.iterator();
    L18:
        int r19 = 0;
    L20:
        if (r18.hasNext() == false) goto L106;
        Object r20 = r18.next();
        if ((r20 instanceof q) == true) goto L24;
        if ((r20 instanceof io.noties.markwon.core.spans.c) == true) goto L36;
        if ((r20 instanceof io.noties.markwon.ext.onetex.c) == true) goto L45;
        if ((r20 instanceof CustomCitationSpan) == false) goto L20;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L70
        int r22 = r15.a.getSpanStart(r20);     // Catch: Throwable -> L70
        int r23 = r15.a.getSpanEnd(r20);     // Catch: Throwable -> L70
        if (r11 > r22) goto L64;
        if (r22 >= r12) goto L64;
        boolean r24 = true;
    L65:
        if (r24 == false) goto L68;
        if (r23 > r12) goto L68;
        r13.replace(r22 - r11, r23 - r11, " ");     // Catch: Throwable -> L70
    L68:
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L20;
        g.a.ensureNotReachHere(r26);
    L64:
        r24 = false;
    L70:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L45:
        int r28 = r15.a.getSpanStart(r20);
        r19 = r19 + (r15.a.getSpanEnd(r20) - r28);
        io.noties.markwon.ext.onetex.c r29 = (io.noties.markwon.ext.onetex.c) r20;
        Integer r30 = r29.e.o;
        if (r30 == null) goto L51;
        if (r30.intValue() != 0) goto L51;
    L52:
        if (r11 > r28) goto L55;
        if (r28 >= r12) goto L55;
        boolean r31 = true;
    L56:
        if (r31 == false) goto L20;
        int r32 = r28 - r11;
        r13.delete(r32, r19 + r32);
        r13.insert(r32, ((wsc.a) r29.e).a);
    L55:
        r31 = false;
    L51:
        if (Intrinsics.areEqual(r17, r20) == false) goto L20;
    L36:
        int r33 = r15.a.getSpanStart(r20);
        if (r11 > r33) goto L40;
        if (r33 >= r12) goto L40;
        boolean r34 = true;
    L41:
        if (r34 == false) goto L20;
        r13.insert(r33 - r11, "- ");
    L40:
        r34 = false;
        goto L41
    L24:
        if (r14 != FormatSource.TTS) goto L26;
        int r35 = r11 + 1;
    L27:
        int r36 = r15.a.getSpanStart(r20);
        if (r35 > r36) goto L31;
        if (r36 >= r12) goto L31;
        boolean r37 = true;
    L32:
        if (r37 == false) goto L20;
        int r38 = r36 - r11;
        r13.insert(r38, ((q) r20).i);
    L31:
        r37 = false;
        goto L32
    L26:
        r35 = r11;
        goto L27
    L106:
        return;
    L75:
        return;
    L5:
        r15 = null;
        goto L6
    }
}
