package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.broadcastgame.opengame.debug.dialog.DebugMenuDialog;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenGameDebugFloatBall;", "Landroidx/appcompat/widget/AppCompatImageView;", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameDebugFloatBall extends AppCompatImageView {
    public static final /* synthetic */ int b = 0;
    public c a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OpenGameDebugFloatBall a;

        public a(OpenGameDebugFloatBall r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.ImageView, com.bytedance.android.live.broadcastgame.opengame.debug.OpenGameDebugFloatBall, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ?? r4 = this.a;
            int r0 = OpenGameDebugFloatBall.b;
            r4.getClass();
            Context r1 = r4.getContext();
            c r5 = r4.a;
            if (r5 == null) goto L15;
            DebugMenuDialog r2 = new DebugMenuDialog(r1, r5);
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r2);
            return;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r2);
            r2.show();
            DialogLancet.afterDialogShow(r2);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenGameDebugFloatBall(ViewGroup r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        UtilityKotlinExtentionsKt.t(this);
        setImageDrawable(s1.m(2131252512));
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(j(r5, 36), j(r5, 36));
        r0.topMargin = j(r5, 134);
        r0.rightMargin = j(r5, 10);
        r0.gravity = 8388613;
        r4.addView(this, r0);
        setOnClickListener(new a(this));
    }

    public final int j(Context r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }
}
