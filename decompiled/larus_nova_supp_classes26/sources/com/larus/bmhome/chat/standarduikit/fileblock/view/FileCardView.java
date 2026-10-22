package com.larus.bmhome.chat.standarduikit.fileblock.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.larus.mainbot.impl.databinding.LarusBlockItemFileBinding;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;
import yk8.b;
import yk8.c;
import yk8.d;
import yk8.e;
import yk8.g;
import zk8.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardViewOutput;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "boundUrl", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusBlockItemFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "bindFileIcon", "bindCardStyle", "updateIconLayout", "sizeDp", "", "updateTextLayout", "startMarginDp", "verticalMarginDp", "updateSubtitleTopMargin", "topMarginDp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileCardView extends ConstraintLayout {
    public static final /* synthetic */ int c = 0;
    public String a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    private final LarusBlockItemFileBinding getBinding() {
        return (LarusBlockItemFileBinding) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileCardView(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "";
        this.b = LazyKt.lazy(new yk8.a(r2, this));
        setBackgroundResource(2131239091);
    }

    public final void T5(int r3) {
        ConstraintLayout.LayoutParams r0 = getBinding().g.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = r0;
        ((ViewGroup.MarginLayoutParams) r1).width = c7.b(Integer.valueOf(r3));
        ((ViewGroup.MarginLayoutParams) r1).height = c7.b(Integer.valueOf(r3));
        ((ViewGroup.MarginLayoutParams) r1).topMargin = c7.b(16);
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = c7.b(16);
        getBinding().g.setLayoutParams(r1);
    }

    public final void U5(int r3) {
        ViewGroup.LayoutParams r0 = getBinding().i.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
        r1.topMargin = c7.b(Integer.valueOf(r3));
        getBinding().i.setLayoutParams(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(final g r10, final v r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "output");
        this.a = r10.i;
        int r1 = 2;
        boolean r3 = true;
        int r4 = 0;
        if (r10.g == false) goto L5;
        setBackgroundResource(2131239070);
        setMinimumHeight(c7.b(72));
        T5(32);
        V5(12, 0);
        TextView r0 = getBinding().h;
        r0.setIncludeFontPadding(false);
        r0.setTypeface(Typeface.create("sans-serif-medium", 0));
        r0.setTextSize(2, 14.0f);
        r0.setLineSpacing(0.0f, 1.0f);
        TextViewCompat.setLineHeight(r0, c7.b(20));
        TextView r2 = getBinding().i;
        r2.setIncludeFontPadding(false);
        r2.setTypeface(Typeface.create("sans-serif", 0));
        r2.setTextSize(2, 12.0f);
        r2.setLineSpacing(0.0f, 1.0f);
        TextViewCompat.setLineHeight(r2, c7.b(18));
        U5(2);
    L10:
        AppCompatImageView r5 = getBinding().g;
        Integer r6 = r10.a;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        r5.setImageResource(r7);
        getBinding().h.setText(r10.c);
        boolean r8 = r10.g;
        if (r8 == false) goto L17;
        String r9 = r10.f;
    L18:
        if (r8 == false) goto L23;
        if (r10.f.length() > 0) goto L29;
    L30:
        boolean r12 = false;
    L31:
        TextView r13 = getBinding().h;
        if (r10.g == false) goto L35;
        r1 = 1;
    L38:
        r13.setMaxLines(r1);
        TextView r14 = getBinding().h;
        if (r10.g == false) goto L41;
    L44:
        TextUtils.TruncateAt r15 = TextUtils.TruncateAt.END;
    L45:
        r14.setEllipsize(r15);
        getBinding().i.setText(r9);
        TextView r16 = getBinding().i;
        int r17 = 8;
        if (r12 == false) goto L48;
        int r18 = 0;
    L49:
        r16.setVisibility(r18);
        LinearLayout r19 = getBinding().b;
        if (r10.h == false) goto L52;
    L55:
        if (r3 == false) goto L57;
        int r20 = 0;
    L58:
        r19.setVisibility(r20);
        FileAudioButtonView r21 = getBinding().f;
        if (r10.h == false) goto L61;
        int r22 = 0;
    L62:
        r21.setVisibility(r22);
        getBinding().f.c(r10.j);
        ImageView r23 = getBinding().d;
        if (r10.g == false) goto L65;
        int r24 = 0;
    L66:
        r23.setVisibility(r24);
        ImageView r25 = getBinding().e;
        if (r10.g == false) goto L69;
        r17 = 0;
    L69:
        r25.setVisibility(r17);
        ViewGroup.LayoutParams r26 = getBinding().d.getLayoutParams();
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) r26;
        if (r10.h == true) goto L72;
    L74:
        r27.setMarginStart(r4);
        getBinding().d.setLayoutParams(r27);
        e1.d(getBinding().f, new b(r10, r11, this));
        e1.d(getBinding().d, new c(r11));
        e1.d(getBinding().e, new d(r11));
        e1.d(getBinding().a, new e(r11));
        return;
    L72:
        if (r10.g == false) goto L74;
        r4 = c7.b(12);
        goto L74
    L65:
        r24 = 8;
        goto L66
    L61:
        r22 = 8;
        goto L62
    L57:
        r20 = 8;
        goto L58
    L52:
        if (r10.g == true) goto L55;
        r3 = false;
        goto L55
    L48:
        r18 = 8;
        goto L49
    L41:
        if (r10.e == true) goto L44;
        r15 = null;
        goto L45
    L35:
        if (r10.e == true) goto L38;
        r1 = Integer.MAX_VALUE;
    L29:
        r12 = true;
        goto L31
    L23:
        if (r10.e == false) goto L30;
        if (r10.d.length() <= 0) goto L27;
        boolean r28 = true;
    L28:
        if (r28 == false) goto L30;
    L27:
        r28 = false;
        goto L28
    L17:
        r9 = r10.d;
        goto L18
    L13:
        r7 = r10.b;
        goto L14
    L5:
        Integer r29 = r10.k;
        if (r29 == null) goto L8;
        int r30 = r29.intValue();
    L9:
        setBackgroundResource(r30);
        setMinimumHeight(0);
        T5(24);
        V5(16, 16);
        TextView r31 = getBinding().h;
        r31.setIncludeFontPadding(true);
        r31.setTypeface(Typeface.create("PingFang SC", 0));
        r31.setTextSize(0, i5.q());
        r31.setLineSpacing(0.0f, 1.0f);
        TextView r32 = getBinding().i;
        r32.setIncludeFontPadding(true);
        r32.setTypeface(Typeface.create("sans-serif", 0));
        r32.setTextSize(0, i5.m());
        r32.setLineSpacing(0.0f, 1.0f);
        U5(4);
        goto L10
    L8:
        r30 = 2131239091;
        goto L9
    }

    public final void V5(int r3, int r4) {
        ConstraintLayout.LayoutParams r0 = getBinding().c.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = r0;
        r1.setMarginStart(c7.b(Integer.valueOf(r3)));
        ((ViewGroup.MarginLayoutParams) r1).topMargin = c7.b(Integer.valueOf(r4));
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = c7.b(Integer.valueOf(r4));
        getBinding().c.setLayoutParams(r1);
    }

    public static Unit R5(FileCardView r1, String r2, vl8.g r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (Intrinsics.areEqual(r1.a, r2) == false) goto L6;
        r1.getBinding().f.c(r3);
    L6:
        return Unit.INSTANCE;
    }
}
