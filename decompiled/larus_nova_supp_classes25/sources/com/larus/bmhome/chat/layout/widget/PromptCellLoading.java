package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.common.databinding.LarusPromptLoadingBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/PromptCellLoading;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusPromptLoadingBinding;", "setLoadingStyle", "", "style", "CellLoadingStyle", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PromptCellLoading extends ConstraintLayout {
    public final LarusPromptLoadingBinding a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/PromptCellLoading$CellLoadingStyle;", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CellLoadingStyle {
        public static final a Companion = null;
        public static final int Horizontal = 2;
        public static final int Undefined = 0;
        public static final int Vertical = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public PromptCellLoading(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromptCellLoading(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setLoadingStyle(int r4) {
        if (r4 != 1) goto L5;
        this.a.c.setVisibility(0);
        this.a.b.setVisibility(8);
        return;
    L5:
        if (r4 != 2) goto L11;
        this.a.b.setVisibility(0);
        this.a.c.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PromptCellLoading(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131563094, this);
        int r5 = 2131378989;
        if (ViewBindings.findChildViewById(this, 2131378989) == null) goto L29;
        r5 = 2131378990;
        if (ViewBindings.findChildViewById(this, 2131378990) == null) goto L29;
        r5 = 2131378991;
        if (ViewBindings.findChildViewById(this, 2131378991) == null) goto L29;
        r5 = 2131378992;
        if (ViewBindings.findChildViewById(this, 2131378992) == null) goto L29;
        r5 = 2131379012;
        ConstraintLayout r6 = ViewBindings.findChildViewById(this, 2131379012);
        if (r6 == null) goto L29;
        r5 = 2131379013;
        ConstraintLayout r7 = ViewBindings.findChildViewById(this, 2131379013);
        if (r7 == null) goto L29;
        r5 = 2131379027;
        if (ViewBindings.findChildViewById(this, 2131379027) == null) goto L29;
        r5 = 2131379028;
        if (ViewBindings.findChildViewById(this, 2131379028) == null) goto L29;
        r5 = 2131379029;
        if (ViewBindings.findChildViewById(this, 2131379029) == null) goto L29;
        r5 = 2131379030;
        if (ViewBindings.findChildViewById(this, 2131379030) == null) goto L29;
        r5 = 2131379031;
        if (ViewBindings.findChildViewById(this, 2131379031) == null) goto L29;
        r5 = 2131379032;
        if (ViewBindings.findChildViewById(this, 2131379032) == null) goto L29;
        this.a = new LarusPromptLoadingBinding(this, r6, r7);
        return;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ PromptCellLoading(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
