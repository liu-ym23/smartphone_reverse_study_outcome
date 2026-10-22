package am8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchAppletCardItem;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements usc.f {
    public final zl8.e a;

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final View asView() {
        return this.a.b();
    }

    public final void f() {
        this.a.c();
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new zl8.e(r2);
    }

    public final Size d(TextView r21, Spanned r22, final usc.e r23, int r24, Map<String, ? extends Object> r25) {
        Intrinsics.checkNotNullParameter(r21, "textView");
        Intrinsics.checkNotNullParameter(r22, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r23, "span");
        boolean r13 = Intrinsics.areEqual(r23.i(), "data-block-full");
        ContainerAttribute r3 = null;
        if (r25 == null) goto L5;
        Object r2 = r25.get("markdown_common_input_data");
    L7:
        if ((r2 instanceof fh8.f) == false) goto L9;
        final fh8.f r4 = (fh8.f) r2;
    L10:
        if (r4 == null) goto L12;
        final Message r10 = r4.b;
    L13:
        wc8.b r6 = wc8.b.a;
        if (r10 == null) goto L16;
        String r7 = r10.getMessageId();
    L17:
        RichMediaMeta r8 = r6.h(r7, r23.k(), "MarkdownAppletWidget");
        if (r8 == null) goto L26;
        List r9 = r8.getMedia();
        if (r9 == null) goto L26;
        RichMediaItem r11 = (RichMediaItem) CollectionsKt.firstOrNull(r9);
        if (r11 == null) goto L26;
        SearchAppletCardItem r12 = r11.applet;
        if (r12 == null) goto L26;
        String r14 = r12.renderData;
    L28:
        if (r14 == null) goto L30;
    L41:
        String r15 = r14;
        if (r22.getSpanStart(r23) != 0) goto L44;
        boolean r16 = true;
    L46:
        if (r22.getSpanEnd(r23) != r22.length()) goto L48;
        boolean r17 = true;
    L49:
        if (r10 == null) goto L51;
        String r5 = r10.getMessageId();
    L52:
        RichMediaMeta r18 = r6.h(r5, r23.k(), "MarkdownAppletWidget");
        if (r18 == null) goto L55;
        r3 = r18.getContainerAttribute();
    L55:
        if (r3 == null) goto L57;
        boolean r19 = Intrinsics.areEqual(r3.isFullWidth(), Boolean.TRUE);
    L58:
        if (r19 == false) goto L65;
        if (r4 == null) goto L63;
        Integer r20 = r4.w;
        if (r20 == null) goto L63;
        int r26 = r20.intValue();
    L64:
        int r27 = (r26 + r21.getPaddingStart()) + r21.getPaddingEnd();
    L66:
        cm8.f r28 = new cm8.f(r27, r15, r10, null, false, r13, r16, r17, r19, r21.getPaddingStart(), r21.getPaddingEnd(), new a(r23, r10, r4));
        this.a.a(r28, new cm8.e(r4));
        return this.a.e(r28);
    L63:
        r26 = r24;
        goto L64
    L65:
        r27 = r24;
        goto L66
    L57:
        r19 = false;
        goto L58
    L51:
        r5 = null;
        goto L52
    L48:
        r17 = false;
        goto L49
    L44:
        r16 = false;
        goto L46
    L30:
        if (r23.k().length() != 0) goto L32;
        boolean r29 = true;
    L33:
        if (r29 == false) goto L35;
        r14 = r23.h();
    L39:
        if (r14 != null) goto L41;
        r14 = "{}";
        goto L41
    L35:
        if (r10 == null) goto L37;
        String r30 = r10.getMessageId();
    L38:
        r14 = r6.c(r30, r23.k(), "MarkdownAppletWidget");
        goto L39
    L37:
        r30 = null;
        goto L38
    L32:
        r29 = false;
    L26:
        r14 = null;
        goto L28
    L16:
        r7 = null;
        goto L17
    L12:
        r10 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
