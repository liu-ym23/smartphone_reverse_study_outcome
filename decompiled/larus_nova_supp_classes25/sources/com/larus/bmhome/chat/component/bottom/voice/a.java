package com.larus.bmhome.chat.component.bottom.voice;

import android.widget.EditText;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.chat.component.bottom.core.f6;
import com.larus.bmhome.chat.component.bottom.core.g6;
import com.larus.bmhome.chat.component.bottom.core.h6;
import com.larus.bmhome.chat.component.bottom.core.y5;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.voice.a$a, reason: collision with other inner class name */
    public static final class C0054a {
        public static /* synthetic */ void a(a r3, int r4) {
            boolean r1 = true;
            if ((r4 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 2) != 0) goto L10;
            r1 = false;
        L10:
            r3.ql(r0, r1);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    void Cd(LottieAnimationView r1);

    boolean DG();

    int Ef();

    com.larus.bmhome.chat.component.bottom.voice.service.h Hw();

    Job IL(f6 r1);

    boolean OL();

    v19.e QZ();

    Job S50(h6 r1);

    void T70(EditText r1);

    Job a20(g6 r1);

    Job jI(y5 r1);

    void jj(EditText r1, int r2, String r3);

    void lP();

    boolean q40();

    void ql(boolean r1, boolean r2);

    void x30(d r1);
}
