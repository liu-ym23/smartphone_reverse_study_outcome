package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;
    public final /* synthetic */ IRoom c;

    public c(b r1, View r2, IRoom r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        i1 r7 = (i1) r6;
        Float r0 = null;
        float r1 = 0.0f;
        if (r7 != null) goto L5;
    L27:
        View r2 = this.b;
        if (r2 == null) goto L33;
        float r8 = -r7.a;
        Float r3 = this.a.f;
        if (r3 == null) goto L32;
        r1 = r3.floatValue();
    L32:
        r2.setTranslationY(r8 + r1);
    L33:
        this.a.f = null;
        return;
    L5:
        if (r7.b != true) goto L27;
        b r4 = this.a;
        if (r4.f != null) goto L13;
        View r5 = this.b;
        if (r5 == null) goto L11;
        r0 = Float.valueOf(r5.getTranslationY());
    L11:
        r4.f = r0;
    L13:
        if (PadConfigUtils.a() == true) goto L21;
        IRoom r9 = this.c;
        if (r9 != null) goto L17;
    L18:
        View r10 = this.b;
        if (r10 == null) goto L35;
        r10.setTranslationY((-r7.a) + a1.e(r10));
        return;
    L35:
        return;
    L17:
        if (r9.isMergeVSRoom() != true) goto L18;
    L21:
        View r11 = this.b;
        if (r11 == null) goto L37;
        float r12 = -r7.a;
        float r13 = s1.j(2131168800);
        View r14 = this.b;
        if (r14 == null) goto L26;
        r1 = a1.e(r14);
    L26:
        r11.setTranslationY(r12 - (r13 - r1));
        return;
    }
}
