package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.PSHighlightCommonCompLauncher;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Action {
    public final /* synthetic */ b a;
    public final /* synthetic */ i b;

    public a(b r1, PSHighlightCommonCompLauncher r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        b r0 = this.a;
        i r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "launcher");
        if (((ArrayList) r0.a).remove(r1) == false) goto L6;
        r1.onUnload();
        return;
    }
}
