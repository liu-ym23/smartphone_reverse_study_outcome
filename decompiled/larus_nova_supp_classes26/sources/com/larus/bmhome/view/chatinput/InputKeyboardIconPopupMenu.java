package com.larus.bmhome.view.chatinput;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.input.impl.databinding.LarusInputKeyboardIconPopupViewBinding;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import et8.g;
import et8.h;
import et8.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J#\u0010\u0014\u001a\u00020\u00002\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0017R\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0002\b\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/chatinput/InputKeyboardIconPopupMenu;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusInputKeyboardIconPopupViewBinding;", "balloon", "Lcom/skydoves/balloon/Balloon;", "handleDismissBalloon", "createBalloon", "", "show", "anchor", "Landroid/view/View;", "config", "block", "Lkotlin/Function1;", "Lcom/larus/bmhome/view/chatinput/InputKeyboardIconPopupMenu$ConfigBuilder;", "Lkotlin/ExtensionFunctionType;", "Companion", "ConfigBuilder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputKeyboardIconPopupMenu extends FrameLayout {
    public final LarusInputKeyboardIconPopupViewBinding a;
    public Balloon b;
    public Balloon c;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), c7.b(Float.valueOf(12.0f)));
        }
    }

    public static final class b {
    }

    public final class c {
        public final /* synthetic */ InputKeyboardIconPopupMenu a;

        public c(InputKeyboardIconPopupMenu r1) {
            this.a = r1;
        }
    }

    static {
    }

    public InputKeyboardIconPopupMenu(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InputKeyboardIconPopupMenu(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public InputKeyboardIconPopupMenu(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562459, this);
        int r10 = 2131367794;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(this, 2131367794);
        if (r11 == null) goto L21;
        r10 = 2131369197;
        View r3 = ViewBindings.findChildViewById(this, 2131369197);
        if (r3 == null) goto L21;
        r10 = 2131379905;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131379905);
        if (r4 == null) goto L21;
        r10 = 2131379906;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(this, 2131379906);
        if (r12 == null) goto L21;
        r10 = 2131386031;
        if (ViewBindings.findChildViewById(this, 2131386031) == null) goto L21;
        this.a = new LarusInputKeyboardIconPopupViewBinding(this, r11, r3, r4, r12);
        ViewGroup.LayoutParams r13 = getLayoutParams();
        if (r13 != null) goto L15;
        r13 = new FrameLayout.LayoutParams(-1, -1);
    L15:
        setLayoutParams(r13);
        if (z2.a.messageInputMenuConfig().b() == true) goto L18;
        e1.o(r12);
    L18:
        r11.post(new g(this));
        measure(0, 0);
        Balloon.a r14 = new Balloon.a(getContext());
        Intrinsics.checkNotNullParameter(this, "layout");
        r14.I = this;
        r14.v = 0;
        r14.n(Integer.MIN_VALUE);
        r14.j(Integer.MIN_VALUE);
        r14.e(ArrowPositionRules.ALIGN_BALLOON);
        r14.p = 0.5f;
        r14.f(0);
        r14.m = false;
        r14.T = true;
        r14.h(false);
        r14.l(new h(this));
        this.b = r14.b();
        Balloon.a r15 = new Balloon.a(getContext());
        r15.v = 0;
        r15.n(1);
        r15.j(1);
        r15.h(false);
        r15.T = false;
        k r16 = new k(this);
        Intrinsics.checkNotNullParameter(r16, "value");
        r15.Q = r16;
        this.c = r15.b();
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public /* synthetic */ InputKeyboardIconPopupMenu(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
