package com.larus.uaigc.chat.markdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import com.larus.uaigc.chat.markdown.placeholder.MDTextPlaceHolderWidget;
import com.larus.uaigc.chat.markdown.video.MDMultiVideoWidget;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import fh8.h;
import fz9.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0016J0\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/larus/uaigc/chat/markdown/CreationCustomWidgetBinder;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customCreationDataWidget", "Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", "text", "Landroid/text/Spanned;", "maxWidth", "", "Ljava/lang/Integer;", "asView", "Landroid/view/View;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "payload", "", "", "", "onReuse", "onRecycle", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationCustomWidgetBinder implements f {
    public final Context a;
    public final AttributeSet b;
    public AbsCustomCreationDataWidget c;
    public Spanned d;
    public Integer e;

    public static final class a {
    }

    static {
    }

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final void e() {
    }

    public final View asView() {
        AbsCustomCreationDataWidget r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new FrameLayout(this.a);
    }

    public final void f() {
        AbsCustomCreationDataWidget r0 = this.c;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.c = null;
    }

    public CreationCustomWidgetBinder(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.e = 0;
    }

    public final Size c(TextView r11, e r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r11, "textView");
        Intrinsics.checkNotNullParameter(r12, "span");
        Spanned r3 = this.d;
        if (r3 != null) goto L5;
        return null;
    L5:
        Integer r1 = this.e;
        if (r1 == null) goto L105;
        int r7 = r1.intValue();
        if (r13 == null) goto L10;
        fh8.f r2 = h.b(r13);
    L11:
        if (r2 == null) goto L13;
        Message r5 = r2.b;
    L14:
        b r6 = j0.a(r12, r5);
        boolean r4 = true;
        if (r5 == null) goto L44;
        wc8.b r8 = wc8.b.a;
        String r9 = r5.getMessageId();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        wc8.a r10 = r8.d(r9, r12.k());
        if (r6 == null) goto L22;
        String r14 = r6.b();
    L23:
        if (r14 != null) goto L25;
    L28:
        boolean r15 = true;
    L29:
        if (r15 == false) goto L44;
        if (r10 == null) goto L34;
        IMMetaInfo.InsertTextReference r16 = r10.b;
        if (r16 == null) goto L34;
        boolean r17 = Intrinsics.areEqual(r16.getCanReplace(), Boolean.FALSE);
    L35:
        if (r17 == true) goto L44;
        CreationMsgContentData r18 = dp8.e.c(r5);
        if (r18 == null) goto L41;
        CreationInfo r19 = r18.creationInfo;
        if (r19 == null) goto L41;
        boolean r20 = Intrinsics.areEqual(r19.needRefreshCreationContent, Boolean.TRUE);
    L42:
        if (r20 == true) goto L44;
        return null;
    L41:
        r20 = false;
    L34:
        r17 = false;
        goto L35
    L25:
        if (r14.length() == 0) goto L28;
        r15 = false;
        goto L29
    L22:
        r14 = null;
    L44:
        if (r6 == null) goto L46;
        List<String> r21 = r6.a();
    L47:
        List<String> r22 = r21;
        if (r22 != null) goto L50;
    L53:
        if (r4 == true) goto L89;
        if (r5 == null) goto L58;
        CreationMsgContentData r23 = dp8.e.c(r5);
        if (r23 == null) goto L58;
        CreationInfo r24 = r23.creationInfo;
    L59:
        if (r24 == null) goto L70;
        Map r25 = r24.taskInfo;
        if (r25 == null) goto L70;
        if (r6 == null) goto L66;
        List<String> r26 = r6.a();
        if (r26 == null) goto L66;
        String r27 = (String) CollectionsKt.firstOrNull(r26);
    L67:
        CreationTask r28 = (CreationTask) r25.get(r27);
        if (r28 == null) goto L70;
        Integer r29 = r28.loadingAssetType;
    L71:
        if (r29 != null) goto L73;
    L83:
        AbsCustomCreationDataWidget r30 = this.c;
        if ((r30 instanceof MDImageScrollWidget) == false) goto L86;
        AbsCustomCreationDataWidget r31 = (MDImageScrollWidget) r30;
    L87:
        if (r31 != null) goto L101;
        r31 = new MDImageScrollWidget(this.a, this.b);
    L101:
        this.c = r31;
        if (r31 != null) goto L104;
        return null;
    L104:
        return r31.a(r11, r3, r12, r5, r6, r7, r13);
    L86:
        r31 = null;
        goto L87
    L73:
        if (r29.intValue() == 5) goto L83;
        if (r29.intValue() != 7) goto L100;
        AbsCustomCreationDataWidget r32 = this.c;
        if ((r32 instanceof MDMultiVideoWidget) == false) goto L80;
        r31 = (MDMultiVideoWidget) r32;
    L81:
        if (r31 != null) goto L101;
        r31 = new MDMultiVideoWidget(this.a, this.b);
        goto L101
    L80:
        r31 = null;
    L100:
        r31 = null;
    L66:
        r27 = null;
    L70:
        r29 = null;
    L58:
        r24 = null;
        goto L59
    L89:
        if (r6 == null) goto L91;
        String r33 = r6.b();
    L93:
        if (o0.d(r33) == false) goto L100;
        AbsCustomCreationDataWidget r34 = this.c;
        if ((r34 instanceof MDTextPlaceHolderWidget) == false) goto L97;
        r31 = (MDTextPlaceHolderWidget) r34;
    L98:
        if (r31 != null) goto L101;
        r31 = new MDTextPlaceHolderWidget(this.a, this.b);
        goto L101
    L97:
        r31 = null;
        goto L98
    L91:
        r33 = null;
        goto L93
    L50:
        if (r22.isEmpty() == true) goto L53;
        r4 = false;
        goto L53
    L46:
        r21 = null;
        goto L47
    L13:
        r5 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    L105:
        return null;
    }

    public final Size d(TextView r12, Spanned r13, e r14, int r15, Map<String, ? extends Object> r16) {
        Intrinsics.checkNotNullParameter(r12, "textView");
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "span");
        this.d = r13;
        this.e = Integer.valueOf(r15);
        AbsCustomCreationDataWidget r1 = null;
        if (r16 == null) goto L5;
        fh8.f r5 = h.b(r16);
    L6:
        if (r5 == null) goto L8;
        Message r6 = r5.b;
    L9:
        b r7 = j0.a(r14, r6);
        if (r7 == null) goto L12;
        List<String> r8 = r7.a();
    L13:
        List<String> r9 = r8;
        if (r9 != null) goto L16;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == true) goto L54;
        if (r6 == null) goto L25;
        CreationMsgContentData r11 = dp8.e.c(r6);
        if (r11 == null) goto L25;
        CreationInfo r17 = r11.creationInfo;
    L26:
        if (r17 == null) goto L37;
        Map r18 = r17.taskInfo;
        if (r18 == null) goto L37;
        if (r7 == null) goto L33;
        List<String> r19 = r7.a();
        if (r19 == null) goto L33;
        String r20 = (String) CollectionsKt.firstOrNull(r19);
    L34:
        CreationTask r21 = (CreationTask) r18.get(r20);
        if (r21 == null) goto L37;
        Integer r22 = r21.loadingAssetType;
    L38:
        if (r22 != null) goto L40;
    L49:
        AbsCustomCreationDataWidget r23 = this.c;
        if ((r23 instanceof MDImageScrollWidget) == false) goto L52;
        r1 = (MDImageScrollWidget) r23;
    L52:
        if (r1 != null) goto L64;
        r1 = new MDImageScrollWidget(this.a, this.b);
    L64:
        this.c = r1;
        if (r1 == null) goto L69;
        Size r2 = r1.a(r12, r13, r14, r6, r7, r15, r16);
        if (r2 == null) goto L69;
        return r2;
    L69:
        return new Size(0, 0);
    L40:
        if (r22.intValue() == 5) goto L49;
        if (r22.intValue() != 7) goto L64;
        AbsCustomCreationDataWidget r24 = this.c;
        if ((r24 instanceof MDMultiVideoWidget) == false) goto L47;
        r1 = (MDMultiVideoWidget) r24;
    L47:
        if (r1 != null) goto L64;
        r1 = new MDMultiVideoWidget(this.a, this.b);
    L33:
        r20 = null;
    L37:
        r22 = null;
    L25:
        r17 = null;
        goto L26
    L54:
        if (r7 == null) goto L56;
        String r25 = r7.b();
    L58:
        if (o0.d(r25) == false) goto L64;
        AbsCustomCreationDataWidget r26 = this.c;
        if ((r26 instanceof MDTextPlaceHolderWidget) == false) goto L62;
        r1 = (MDTextPlaceHolderWidget) r26;
    L62:
        if (r1 != null) goto L64;
        r1 = new MDTextPlaceHolderWidget(this.a, this.b);
        goto L64
    L56:
        r25 = null;
        goto L58
    L16:
        if (r9.isEmpty() == true) goto L19;
        r10 = false;
        goto L20
    L12:
        r8 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
