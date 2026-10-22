package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livesdk.chatroom.replay.input.ReplayEmojiInputDialogFragment;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vr1.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements yr1.f, com.bytedance.android.scope.o {
    public j() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.f
    public final boolean d(CharSequence r1) {
        return ((ArrayList) ab2.a.d(r1)).isEmpty();
    }

    @Override // yr1.f
    public final Drawable getRealDrawable(String r2) {
        return jc1.k.n(IHostEmoji.class).getRealDrawable(r2);
    }

    @Override // yr1.f
    public final GradientEditText a(Context r2, int r3) {
        return jc1.k.n(IExpressionService.class).createEmojiEditText(r2, r3);
    }

    @Override // yr1.f
    public final CharSequence c(CharSequence r1, float r2) {
        return ab2.a.f(r1, r2);
    }

    @Override // yr1.f
    public final int h(String r2, boolean r3, int r4) {
        List r5 = ab2.b.a().b.b(r2);
        if (r3 == false) goto L5;
        r4 = 15;
    L5:
        Iterator r6 = ((ArrayList) r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L20;
        db2.a r7 = (db2.a) r6.next();
        if (r7.c <= r4) goto L7;
        int r8 = r7.b;
        if (r4 < r8) goto L7;
        return r8;
    L20:
        return r4;
    }

    @Override // yr1.f
    public final View g(FragmentActivity r3, boolean r4, int r5, ReplayEmojiInputDialogFragment.b r6) {
        return jc1.k.n(IExpressionService.class).createEmojiSelectPanel(r3, r4, r5, new i(r6));
    }

    @Override // yr1.f
    public final View f(Context r8, boolean r9, int r10, lm1.e r11, c0 r12) {
        Intrinsics.checkNotNullParameter(r11, "param");
        if (r8 != null) goto L6;
        return null;
    L6:
        IExpressionService r1 = jc1.k.n(IExpressionService.class);
        com.bytedance.android.livesdk.interactivity.api.expression.i r5 = new com.bytedance.android.livesdk.interactivity.api.expression.i();
        r5.c = true;
        r5.b = true;
        r5.d = true;
        r5.e = r11.a;
        r5.f = r11.b;
        r5.a = false;
        return r1.createNewEmojiSelectPanel(r8, r9, r10, r5, new h(r12));
    }
}
