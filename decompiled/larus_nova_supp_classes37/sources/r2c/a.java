package r2c;

import android.os.SystemClock;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.reaction.widget.panel.c;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a implements View.OnClickListener {
    public final long a;
    public long b;

    public a() {
        this.a = 500;
        this.a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.b;
        this.b = r0;
        if (r2 >= this.a) goto L6;
        Log.i("OnSingleClickListener", "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        c r10 = (c) this;
        r10.c.n.setVisibility(8);
        ReactionPanelFacade r1 = r10.c;
        ImageView r3 = r1.p;
        TransitionManager.beginDelayedTransition((ViewGroup) r1.k, new AutoTransition().setOrdering(0).setDuration(100).setInterpolator(PathInterpolatorCompat.create(0.4f, 0.8f, 0.74f, 1.0f)));
        int r4 = com.ss.android.lark.reaction.widget.panel.a.a;
        ReactionPanelFacade r5 = r10.c;
        d r6 = r5.x.value;
        DefaultEmojiPanelData r7 = r5.z;
        if (r7 != null) goto L9;
    L11:
        s5c.a r8 = z0.d;
    L12:
        d r11 = r6.plus(r8);
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        Statistics.sendEvent("public_reaction_panel_select_view", r11.toJson());
        r10.c.m.setVisibility(0);
        r10.c.l.setVisibility(8);
        ReactionPanelFacade.b r12 = r10.c.b;
        if (r12 == null) goto L16;
        r12.b();
        return;
    L16:
        return;
    L9:
        if (r7.c() == false) goto L11;
        r8 = z0.c;
        goto L12
    }
}
