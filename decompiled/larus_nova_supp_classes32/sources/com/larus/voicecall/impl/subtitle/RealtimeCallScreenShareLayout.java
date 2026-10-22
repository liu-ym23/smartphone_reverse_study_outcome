package com.larus.voicecall.impl.subtitle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.platform.service.z2;
import com.larus.voicecall.impl.databinding.LarusLayoutRealtimeCallScreenShareBinding;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/RealtimeCallScreenShareLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutRealtimeCallScreenShareBinding;", "setScreenShareExitClickListener", NameKeys.UnloadStrategy_No_Strategy, "listener", "Lkotlin/Function1;", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallScreenShareLayout extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutRealtimeCallScreenShareBinding a;

    public RealtimeCallScreenShareLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeCallScreenShareLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setScreenShareExitClickListener(final Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.larus.utils.e1.d(this.a.b, new m(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeCallScreenShareLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562871, this);
        int r5 = 2131364823;
        AppCompatButton r6 = ViewBindings.findChildViewById(this, 2131364823);
        if (r6 == null) goto L13;
        r5 = 2131391351;
        if (ViewBindings.findChildViewById(this, 2131391351) == null) goto L13;
        r5 = 2131391352;
        if (ViewBindings.findChildViewById(this, 2131391352) == null) goto L13;
        this.a = new LarusLayoutRealtimeCallScreenShareBinding(this, r6);
        if (z2.a.enableScreenShareNewTheme() == false) goto L14;
        r6.setBackground(r2.getDrawable(2131239055));
        r6.setTextColor(ContextCompat.getColor(r2, 2131100488));
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ RealtimeCallScreenShareLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
