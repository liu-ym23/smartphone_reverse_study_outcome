package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt8.c0;
import bt8.d0;
import bt8.e0;
import bt8.f0;
import bt8.g0;
import bt8.h0;
import bt8.i0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import cq8.a0;
import cq8.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J,\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMultiMediaSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "subTitleView", "Landroid/widget/TextView;", "contentRow", "Landroid/widget/LinearLayout;", "init", "", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "Lcom/larus/bmhome/instruction/core/model/widget/MultiMediaSelectorDescriptor;", "createAddTile", "Landroid/view/View;", ShareType.TEXT, "", "onClick", "Lkotlin/Function0;", "createThumbnail", "attachment", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "onRemove", "loadThumbnail", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "thumbLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "withLeftMargin", "", "dp", "value", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMultiMediaSelectorWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int h = 0;
    public TextView f;
    public LinearLayout g;

    public static final class a {
    }

    static {
    }

    public KmpMultiMediaSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpMultiMediaSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [bt8.d0] */
    /* JADX WARN: Type inference failed for: r13v0, types: [bt8.e0] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r17) {
        a0 r1 = r17;
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        if ((r1 instanceof k0) == true) goto L5;
        r1 = null;
    L5:
        final k0 r2 = (k0) r1;
        if (r2 == null) goto L74;
        List<MediaAttachment> r3 = r2.f;
        FLogger.a.i("KmpMultiMediaSelectorWidget", "[bind] attachments:" + r3.size());
        String r4 = r2.h;
        boolean r6 = false;
        if (o0.d(r4) == false) goto L17;
        TextView r5 = this.f;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r5 = null;
    L13:
        r5.setText(r4);
        TextView r7 = this.f;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r7 = null;
    L16:
        r7.setVisibility(0);
    L21:
        LinearLayout r8 = this.g;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        r8 = null;
    L24:
        r8.removeAllViews();
        String r9 = r2.g;
        if (r9 != null) goto L27;
    L31:
        r9 = "参考图";
    L33:
        if (r3.isEmpty() == false) goto L39;
        LinearLayout r10 = this.g;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        LinearLayout r11 = null;
    L38:
        r11.addView(V5(r9, new c0(r2)), Z5(false));
        return;
    L37:
        r11 = r10;
        goto L38
    L39:
        Iterator<T> r12 = r3.iterator();
        int r13 = 0;
    L41:
        if (r12.hasNext() == false) goto L64;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        final MediaAttachment r16 = (MediaAttachment) r14;
        LinearLayout r18 = this.g;
        LinearLayout r19 = r18;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        r19 = null;
    L48:
        final ?? r110 = new d0(r2, r16);
        final ?? r111 = new e0(r2, r16);
        FrameLayout r112 = new FrameLayout(getContext());
        CardView r113 = new CardView(getContext());
        r113.setRadius(Y5(6));
        r113.setCardElevation(0.0f);
        r113.setUseCompatPadding(r6);
        r113.setLayoutParams(new FrameLayout.LayoutParams(Y5(84), Y5(84)));
        SimpleDraweeView r20 = new SimpleDraweeView(getContext());
        r20.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        e1.d(r20, new h0(r110));
        String r21 = r16.getLocalFilePath();
        if (o0.d(r21) == false) goto L53;
        Intrinsics.checkNotNull(r21);
        if (new PolarisFileWrapper(r21).exists() == false) goto L53;
        ImageLoaderKt.s(r20, Uri.fromFile(new PolarisFileWrapper(r21)), null);
    L59:
        r113.addView(r20);
        r112.addView(r113);
        AppCompatImageView r22 = new AppCompatImageView(getContext());
        r22.setImageResource(2131242965);
        FrameLayout.LayoutParams r23 = new FrameLayout.LayoutParams(Y5(16), Y5(16));
        r23.gravity = 8388661;
        r23.topMargin = Y5(4);
        r23.rightMargin = Y5(4);
        r22.setLayoutParams(r23);
        e1.d(r22, new i0(r111));
        r112.addView(r22);
        if (r13 <= 0) goto L62;
        boolean r24 = true;
    L63:
        r19.addView(r112, Z5(r24));
        r13 = r15;
        r6 = false;
        goto L41
    L62:
        r24 = false;
    L53:
        String r25 = r16.getPreviewUrl();
        if (r25 != null) goto L58;
        r25 = r16.getUrl();
        if (r25 != null) goto L58;
        r25 = r16.getOriginUrl();
    L58:
        ImageLoaderKt.u(r20, r25, "instruction_reference_image");
        goto L59
    L64:
        LinearLayout r26 = this.g;
        if (r26 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
        LinearLayout r27 = null;
    L68:
        r27.addView(V5(r9, new f0(r2)), Z5(true));
        return;
    L67:
        r27 = r26;
        goto L68
    L27:
        if ((!StringsKt.isBlank(r9)) == true) goto L30;
        r9 = null;
    L30:
        if (r9 != null) goto L33;
    L17:
        TextView r28 = this.f;
        if (r28 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r28 = null;
    L20:
        r28.setVisibility(8);
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int Y5(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final LinearLayout.LayoutParams Z5(boolean r4) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(Y5(84), Y5(84));
        if (r4 == false) goto L5;
        r0.leftMargin = Y5(8);
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        LinearLayout r9 = new LinearLayout(r7);
        r9.setOrientation(1);
        r9.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        TextView r0 = new TextView(r7);
        r0.setTextColor(-1728053248);
        r0.setTextSize(2, 12.0f);
        r0.setVisibility(8);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.leftMargin = Y5(14);
        r3.bottomMargin = Y5(6);
        r0.setLayoutParams(r3);
        this.f = r0;
        LinearLayout r1 = new LinearLayout(r7);
        r1.setOrientation(0);
        r1.setPadding(Y5(14), 0, Y5(14), Y5(12));
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.g = r1;
        TextView r10 = this.f;
        LinearLayout r2 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r10 = null;
    L5:
        r9.addView(r10);
        LinearLayout r11 = this.g;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentRow");
    L9:
        r9.addView(r2);
        addView(r9);
        return;
    L8:
        r2 = r11;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View V5(String r7, final Function0<Unit> r8) {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(1);
        r0.setGravity(17);
        GradientDrawable r2 = new GradientDrawable();
        r2.setCornerRadius(Y5(6));
        r2.setColor(251684607);
        r0.setBackground(r2);
        e1.d(r0, new g0(r8));
        View r9 = new AppCompatImageView(getContext());
        r9.setImageResource(2131242964);
        r0.addView(r9, new LinearLayout.LayoutParams(Y5(20), Y5(20)));
        TextView r10 = new TextView(getContext());
        r10.setText(r7);
        r10.setTextColor(-16750849);
        r10.setTextSize(2, 11.0f);
        r10.setGravity(17);
        r10.setIncludeFontPadding(false);
        r10.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        r11.topMargin = Y5(6);
        Unit r1 = Unit.INSTANCE;
        r0.addView(r10, r11);
        return r0;
    }

    public KmpMultiMediaSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KmpMultiMediaSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
