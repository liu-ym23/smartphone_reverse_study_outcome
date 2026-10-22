package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g0;
import kotlin.jvm.internal.Reflection;
import ry8.b;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ g(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ChatContinuousTalkComponent r6 = this.a;
        int r0 = ChatContinuousTalkComponent.M;
        b r1 = r6.Y2();
        if (r1 == null) goto L9;
        g0 r2 = r1.C5();
        if (r2 == null) goto L9;
        if (r2.getTtsContinuousTalkEnabled() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L33;
        b r4 = r6.Y2();
        if (r4 == null) goto L16;
        g0 r7 = r4.C5();
        if (r7 == null) goto L16;
        boolean r8 = r7.getTtsContinuousTalkChecked();
    L17:
        b r9 = r6.Y2();
        if (r9 == null) goto L22;
        g0 r10 = r9.C5();
        if (r10 == null) goto L22;
        r10.setTtsContinuousTalkChecked(!r8);
    L22:
        FragmentActivity r11 = r6.C3();
        if (r11 == null) goto L35;
        FragmentManager r12 = r11.getSupportFragmentManager();
        if (r12 == null) goto L36;
        Fragment r13 = r12.findFragmentByTag("continuous_talk_fragment_v2");
        if (r13 == null) goto L37;
        t1a.b r14 = a.g(r13);
        if (r14 == null) goto L38;
        n1 r15 = (n1) r14.o(Reflection.getOrCreateKotlinClass(n1.class));
        if (r15 == null) goto L39;
        r15.onMuteStateChanged(!r8);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L16:
        r8 = true;
        goto L17
    L33:
        t19.s r16 = t19.s.a;
        Context r17 = r6.getContext();
        String r18 = AppHost.a.getApplication().getString(2131901019);
        r16.getClass();
        t19.s.t(r17, r18);
        return;
    L9:
        r3 = false;
        goto L10
    }
}
