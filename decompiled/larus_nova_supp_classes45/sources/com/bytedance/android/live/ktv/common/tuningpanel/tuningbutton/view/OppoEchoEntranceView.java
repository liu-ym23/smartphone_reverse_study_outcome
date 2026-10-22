package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/OppoEchoEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OppoEchoEntranceView extends ConstraintLayout implements LifecycleOwnerCompat {
    public static final /* synthetic */ int e = 0;
    public final TextView a;
    public final TextView b;
    public final LifecycleRegistry c;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OppoEchoEntranceView a;

        public b(OppoEchoEntranceView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            OppoEchoEntranceView r4 = this.a;
            int r0 = OppoEchoEntranceView.e;
            r4.S5();
        }
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.d;
        if (r0 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r0.h() != true) goto L11;
        if (Intrinsics.areEqual(this.d.I(), Boolean.TRUE) == false) goto L9;
    L10:
        setVisibility(0);
        return;
    L9:
        if (this.d.Z() != true) goto L11;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        this.c.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public Lifecycle getLifecycleCompat() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "goIntroPageCallback");
        String r0 = getContext().getString(2131917188);
        SpannableString r1 = new SpannableString(r0);
        r1.setSpan(new UnderlineSpan(), 0, r0.length(), 0);
        this.b.setText(r1);
        this.b.setOnClickListener(new a(r5));
        this.a.setText(getContext().getString(2131918380));
        S5();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6 = this.d;
        if (r6 == null) goto L6;
        r6.t(this, new b(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OppoEchoEntranceView(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3, Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 0);
        this.d = r3;
        LifecycleRegistry r5 = new LifecycleRegistry(this);
        this.c = r5;
        r5.setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(r4).inflate(2131566516, this).setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.a = (TextView) findViewById(2131371714);
        this.b = (TextView) findViewById(2131371704);
    }
}
