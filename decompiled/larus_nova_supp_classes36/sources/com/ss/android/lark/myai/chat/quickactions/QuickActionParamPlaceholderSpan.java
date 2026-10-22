package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.i;
import com.ss.android.lark.keyboard.edittext2.span.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/QuickActionParamPlaceholderSpan;", "Landroid/text/style/ForegroundColorSpan;", "Lcom/ss/android/lark/keyboard/edittext2/span/InlineBlockSpan;", "Lcom/ss/android/lark/keyboard/edittext2/span/LongClickableSpan;", "<init>", "()V", "reselect", "Lcom/ss/android/lark/keyboard/edittext2/span/SelectionControlSpan$SelectResult;", "selStart", "", "selEnd", "text", "Landroid/text/Editable;", "onLongClick", "", "view", "Landroid/widget/TextView;", "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QuickActionParamPlaceholderSpan extends ForegroundColorSpan implements f, i {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.f
    public final k.a a(int r1, int r2, Spannable r3) {
        throw null;
    }

    public QuickActionParamPlaceholderSpan() {
        super(UDColorUtils.getColor(LarkContext.getApplication(), 2131106620));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.i
    public final void b(TextView r3) {
        Boolean r0 = null;
        if (r3 == null) goto L5;
        r0 = Boolean.valueOf(r3.performAccessibilityAction(32, null));
    L5:
        Log.i("QuickActionParamPlaceholderSpan", "perform onLongClick, call result is " + Intrinsics.areEqual(r0, Boolean.TRUE));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r7, int r8, Editable r9) {
        Intrinsics.checkNotNullParameter(r9, "text");
        int r0 = r9.getSpanStart(this);
        int r1 = r9.getSpanEnd(this);
        boolean r2 = false;
        if (r0 < 0) goto L6;
        if (r0 > r1) goto L6;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
        return null;
    L10:
        if (r0 > r7) goto L13;
        if (r8 > r1) goto L13;
        r2 = true;
    L13:
        if (r2 == true) goto L15;
        IntRange r3 = new IntRange(r0 + 1, r1 - 1);
        if (r3.contains(r7) == false) goto L19;
        int r5 = r3.getFirst() - 1;
    L21:
        if (r3.contains(r8) == false) goto L23;
        int r6 = r3.getLast() + 1;
    L24:
        if (r5 != r7) goto L29;
        if (r6 != r8) goto L29;
        return null;
    L29:
        return f.a.b(r5, r6, r9);
    L23:
        r6 = r8;
        goto L24
    L19:
        r5 = r7;
        goto L21
    L15:
        return f.a.b(r0, r0, r9);
    L6:
        r4 = false;
        goto L8
    }
}
