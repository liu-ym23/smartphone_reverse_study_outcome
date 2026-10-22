package com.larus.bmhome.chat.markdown.imagegroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import fh8.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import oi8.j;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0016\u0010*\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002JV\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f000&0/2\u0006\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u000fH\u0016J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupWidget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "widgetSize", "lastBindJob", "Lkotlinx/coroutines/Job;", "currInflateView", "Landroid/view/View;", "mobChatType", "", "mobBotId", "mobCurrentPage", "mobPreviousPage", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "textView", "Landroid/widget/TextView;", ChatDraftItem.TYPE_TEXT, "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", "payload", "", "", "updateSimpleImageGroupUISingle", "", "images", "", "Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupImageInfo;", "getBigImageInfoList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "updateSimpleImageGroupUIMore", "bindImage", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageViewListGetter", "Lkotlin/Function0;", "Lkotlin/Pair;", "targetWidth", "targetHeight", "index", "asView", "updateSpanSize", "data", "Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SimpleImageGroupWidget extends FrameLayout implements usc.f {
    public static final /* synthetic */ int i = 0;
    public Size a;
    public Size b;
    public Job c;
    public String d;
    public String e;
    public String f;
    public String g;
    public fh8.f h;

    public final void a() {
    }

    public final View asView() {
        return this;
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    public SimpleImageGroupWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public SimpleImageGroupWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Size(0, 0);
        this.b = new Size(0, 0);
    }

    public final Size d(TextView r7, Spanned r8, usc.e r9, int r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r7, "textView");
        Intrinsics.checkNotNullParameter(r8, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r9, "span");
        fh8.f r12 = fh8.h.b(r11);
        this.h = r12;
        if (r12 == null) goto L5;
        String r13 = r12.e;
    L6:
        this.f = r13;
        if (r12 == null) goto L9;
        String r14 = r12.f;
    L10:
        this.g = r14;
        if (r12 == null) goto L13;
        String r15 = r12.d;
    L14:
        this.e = r15;
        if (r12 == null) goto L17;
        String r16 = r12.a;
    L18:
        this.d = r16;
    L57:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return this.a;
    L20:
        if (r9.k().length() != 0) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L25;
        final String r18 = r9.h();     // Catch: Exception -> L57
    L38:
        if (r18 != null) goto L40;
        r18 = "{}";
    L40:
        d r19 = (d) b.a(r9, new h(r18));     // Catch: Exception -> L57
        Intrinsics.checkNotNull(r19);
        if (r19.a() == null) goto L47;
        if (r19.a().size() != 1) goto L47;
        int r0 = (r10 * 9) / 16;
        this.a = new Size(r10, r0);
        this.b = new Size(r10, r0);
    L52:
        Job r20 = this.c;
        if (r20 == null) goto L55;
        Job.DefaultImpls.cancel$default(r20, null, 1, null);
    L55:
        this.c = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new SimpleImageGroupWidget$bindData$1(r19, this, null), 3, null);
        return this.a;
    L47:
        if (r19.a() != null) goto L49;
    L51:
        this.a = new Size(0, 0);
        this.b = new Size(0, 0);
        goto L52
    L49:
        if (r19.a().size() <= 1) goto L51;
        int r21 = (r10 - (c7.b(4) * 2)) / 3;
        this.a = new Size(r10, r21);
        this.b = new Size(r21, r21);
        goto L52
    L25:
        fh8.f r22 = this.h;     // Catch: Exception -> L57
        if (r22 == null) goto L29;
        Message r23 = r22.b;     // Catch: Exception -> L57
    L31:
        if (r23 == null) goto L37;
        wc8.b r2 = wc8.b.a;     // Catch: Exception -> L57
        String r24 = r23.getMessageId();     // Catch: Exception -> L57
        if (r24 != null) goto L35;
        r24 = "";
    L35:
        r18 = r2.c(r24, r9.k(), "SimpleImageGroupWidget");     // Catch: Exception -> L57
        if (r18 != null) goto L38;
    L37:
        r18 = wc8.b.a.b(r9.k(), "SimpleImageGroupWidget");     // Catch: Exception -> L57
        goto L38
    L29:
        r23 = null;
        goto L31
    L22:
        r17 = false;
        goto L23
    L17:
        r16 = null;
        goto L18
    L13:
        r15 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public final void g(SimpleDraweeView r12, final Function0<? extends List<? extends Pair<Integer, ? extends View>>> r13, int r14, int r15, final List<e> r16, final int r17) {
        e r0 = (e) ListProtector.get(r16, r17);
        int r1 = j.a;
        String r2 = r0.b();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        j.b(r12, r2, "markdown.simple_image_group_cover_thumb", Integer.valueOf(r14), Integer.valueOf(r15), null, null, null, false, 992);
        r12.setOnClickListener(new i(this, r13, r16, r17));
    }
}
