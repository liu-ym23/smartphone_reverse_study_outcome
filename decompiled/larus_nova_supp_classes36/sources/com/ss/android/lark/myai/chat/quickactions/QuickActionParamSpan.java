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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/QuickActionParamSpan;", "Landroid/text/style/StyleSpan;", "Lcom/ss/android/lark/myai/chat/quickactions/QuickActionInlineBlockSpan;", "paramId", "", "paramName", "paramDescription", "paramPlaceHolder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParamId", "()Ljava/lang/String;", "getParamName", "getParamDescription", "getParamPlaceHolder", "isRemoving", "", "isRemoving$myai_export_release", "()Z", "setRemoving$myai_export_release", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QuickActionParamSpan extends StyleSpan implements a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QuickActionParamSpan) == true) goto L8;
        return false;
    L8:
        QuickActionParamSpan r6 = (QuickActionParamSpan) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @Override // android.text.style.StyleSpan
    public final String toString() {
        return "QuickActionParamSpan(paramId=" + this.a + ", paramName=" + this.b + ", paramDescription=" + this.c + ", paramPlaceHolder=" + this.d + ')';
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

    public QuickActionParamSpan(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "paramId");
        Intrinsics.checkNotNullParameter(r3, "paramName");
        Intrinsics.checkNotNullParameter(r4, "paramDescription");
        Intrinsics.checkNotNullParameter(r5, "paramPlaceHolder");
        super(1);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
