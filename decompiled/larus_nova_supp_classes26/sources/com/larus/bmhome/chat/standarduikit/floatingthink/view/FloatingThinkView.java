package com.larus.bmhome.chat.standarduikit.floatingthink.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusCompressDeepThinkHeaderBinding;
import fl8.b;
import fl8.c;
import fl8.d;
import fl8.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001aB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/view/FloatingThinkView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/view/FloatingThinkViewInput;", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/view/FloatingThinkViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCompressDeepThinkHeaderBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCompressDeepThinkHeaderBinding;", "binding$delegate", "Lkotlin/Lazy;", "compressDeepThinkHeaderTitle", "", "bindData", "", "input", "output", "setupLoadingIndicator", "setupIcon", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingThinkView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    private final LarusCompressDeepThinkHeaderBinding getBinding() {
        return (LarusCompressDeepThinkHeaderBinding) this.a.getValue();
    }

    public final String b() {
        CharSequence r0 = getBinding().g.getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void c() {
        getBinding().e.b();
        getBinding().b.R5();
    }

    public FloatingThinkView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupIcon(d r4) {
        SimpleDraweeView r0 = getBinding().d;
        String r1 = r4.f;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r0.setVisibility(8);
        return;
    L11:
        r0.setVisibility(0);
        ImageLoaderKt.u(r0, r4.f, "FloatingThinkView");
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final void setupLoadingIndicator(d r2) {
        ActivityIndicatorView r0 = getBinding().e;
        boolean r3 = r2.c;
        r0.d = r3;
        if (r3 == false) goto L5;
        getBinding().e.setVisibility(0);
        getBinding().e.b();
        ActivityIndicatorView r4 = getBinding().e;
        Handler r1 = r4.h;
        Intrinsics.checkNotNull(r1);
        r1.post(r4.i);
        return;
    L5:
        getBinding().e.b();
        getBinding().e.setVisibility(8);
    }

    public FloatingThinkView(final Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        this.a = LazyKt.lazy(new b(r7, this));
        we8.a.b(getBinding().g, i5.t(), false, null, null, 12);
    }

    public final void a(d r3, final e r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "output");
        setupIcon(r3);
        getBinding().g.setText(r3.a);
        setupLoadingIndicator(r3);
        AppCompatImageView r0 = getBinding().c;
        if (r3.b == true) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        getBinding().f.setClickable(r3.e);
        getBinding().f.setFocusable(r3.e);
        if (r3.d == false) goto L11;
        getBinding().b.T5();
    L12:
        ConstraintLayout r2 = getBinding().f;
        if (r3.e == true) goto L15;
    L17:
        View.OnClickListener r5 = null;
    L18:
        r2.setOnClickListener(r5);
        return;
    L15:
        if (r4.a == null) goto L17;
        r5 = new c(r4);
        goto L18
    L11:
        getBinding().b.R5();
        goto L12
    L5:
        if (r3.c == true) goto L7;
        r1 = 0;
        goto L8
    }
}
