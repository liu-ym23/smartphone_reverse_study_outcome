package com.larus.bmhome.chat.standarduikit.commonbuttonv2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.mainbot.impl.databinding.LarusBlockItemButtonV2Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zj8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u0014B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2ViewInput;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2ViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentBinding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemButtonV2Binding;", "bindData", "", "input", "output", "getCurrentIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mobCardShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonButtonV2 extends LinearLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusBlockItemButtonV2Binding a;

    public static final class a {
    }

    static {
    }

    public CommonButtonV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final SimpleDraweeView a(e r2) {
        if (r2.i != 1) goto L5;
        SimpleDraweeView r3 = this.a.c;
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        SimpleDraweeView r4 = this.a.d;
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    public CommonButtonV2(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        View r9 = LayoutInflater.from(r7).inflate(2131561826, this, false);
        addView(r9);
        LinearLayout r2 = (LinearLayout) r9;
        int r10 = 2131365058;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r9, 2131365058);
        if (r3 == null) goto L11;
        r10 = 2131365059;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r9, 2131365059);
        if (r4 == null) goto L11;
        r10 = 2131365060;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r9, 2131365060);
        if (r5 == null) goto L11;
        this.a = new LarusBlockItemButtonV2Binding(r2, r2, r3, r4, r5);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }
}
