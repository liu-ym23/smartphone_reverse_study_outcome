package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.text.OTextView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogMultiTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/text/OTextView;", "getContentTextView", "tvContent", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogMultiTextView extends ConstraintLayout {
    private final OTextView tvContent;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DialogMultiTextView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public DialogMultiTextView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_layout_dialog_multi_text, this);
        View r12 = findViewById(f.tv_content);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_content)");
        OTextView r13 = (OTextView) r12;
        this.tvContent = r13;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r13.setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 20, r14.getDisplayMetrics())));
    }

    public /* synthetic */ DialogMultiTextView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final OTextView getContentTextView() {
        return this.tvContent;
    }
}
