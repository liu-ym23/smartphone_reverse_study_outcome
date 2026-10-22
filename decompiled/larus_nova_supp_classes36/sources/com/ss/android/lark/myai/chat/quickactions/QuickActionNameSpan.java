package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.k;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/QuickActionNameSpan;", "Landroid/text/style/StyleSpan;", "Lcom/ss/android/lark/myai/chat/quickactions/QuickActionInlineBlockSpan;", "quickActionDisplayName", "", "<init>", "(Ljava/lang/CharSequence;)V", "getQuickActionDisplayName", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QuickActionNameSpan extends StyleSpan implements a {
    public final CharSequence a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof QuickActionNameSpan) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((QuickActionNameSpan) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.text.style.StyleSpan
    public final String toString() {
        return "QuickActionNameSpan(quickActionDisplayName=" + this.a + ')';
    }

    public QuickActionNameSpan(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "quickActionDisplayName");
        super(1);
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.f
    public final k.a a(int r2, int r3, Spannable r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        return f.a.b(r2, r3, r4);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r1, int r2, Editable r3) {
        return a.C0194a.a(this, r1, r2, r3);
    }
}
