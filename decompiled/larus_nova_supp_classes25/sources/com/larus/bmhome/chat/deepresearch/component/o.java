package com.larus.bmhome.chat.deepresearch.component;

import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchBinding;
import com.larus.utils.e1;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ DeepReSearchContentComponent a;

    public /* synthetic */ o(DeepReSearchContentComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepReSearchContentComponent r0 = this.a;
        Map<String, Long> r1 = DeepReSearchContentComponent.M;
        LarusPageDeepResearchBinding r2 = r0.p3();
        if (r2 == null) goto L7;
        AppCompatImageView r3 = r2.i;
        if (r3 == null) goto L7;
        e1.o(r3);
    L7:
        LarusPageDeepResearchBinding r4 = r0.p3();
        if (r4 == null) goto L13;
        ProgressBar r5 = r4.j;
        if (r5 == null) goto L14;
        e1.x(r5);
        return;
    L14:
        return;
    }
}
