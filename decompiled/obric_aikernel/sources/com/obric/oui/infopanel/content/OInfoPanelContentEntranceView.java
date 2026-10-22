package com.obric.oui.infopanel.content;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onAttachedToWindow", "Landroid/view/View$OnClickListener;", "listener", "onClick", "", "text", "setEntranceText", "Landroid/view/ViewGroup;", "entranceContainer", "Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "tvEntrance", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivJump", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OInfoPanelContentEntranceView extends ConstraintLayout {
    private final ViewGroup entranceContainer;
    private final ImageView ivJump;
    private final TextView tvEntrance;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInfoPanelContentEntranceView f6838c;

        a(OInfoPanelContentEntranceView r10) {
            this.f6838c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OInfoPanelContentEntranceView r10 = this.f6838c;
            int r11 = OInfoPanelContentEntranceView.access$getEntranceContainer$p(r10).getWidth();
            float r12 = 44;
            Resources r13 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
            k.b(r10, r11, MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics())), true);
            ViewGroup r14 = OInfoPanelContentEntranceView.access$getEntranceContainer$p(this.f6838c);
            int r15 = OInfoPanelContentEntranceView.access$getEntranceContainer$p(this.f6838c).getWidth();
            Resources r16 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
            k.b(r14, r15, MathKt.roundToInt(TypedValue.applyDimension(1, r12, r16.getDisplayMetrics())), true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelContentEntranceView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OInfoPanelContentEntranceView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-1, -2);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r13.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        r12.setMargins(0, r14, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, r15.getDisplayMetrics())));
        Unit r16 = Unit.INSTANCE;
        setLayoutParams(r12);
        View r17 = findViewById(f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tv_title)");
        this.tvEntrance = (TextView) r17;
        View r18 = findViewById(f.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.iv_arrow)");
        this.ivJump = (ImageView) r18;
        View r19 = findViewById(f.entrance_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.entrance_container)");
        this.entranceContainer = (ViewGroup) r19;
    }

    public /* synthetic */ OInfoPanelContentEntranceView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ ViewGroup access$getEntranceContainer$p(OInfoPanelContentEntranceView r10) {
        return r10.entranceContainer;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public final void onClick(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.entranceContainer.setOnClickListener(r10);
    }

    public final void setEntranceText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.tvEntrance.setText(r10);
    }
}
