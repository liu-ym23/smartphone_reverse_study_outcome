package com.ss.android.lark.inline.ai.creationai;

import android.view.ViewTreeObserver;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.log.Log;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ CreationAIPanelController a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Log.i("CreationAIPanelController", "onPreDraw");
        int r0 = d0.b;
        ScenarioType r1 = this.a.a.g;
        Intrinsics.checkNotNullParameter(r1, "scenario");
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        r2.put("product_type", r1.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L8
        if (d0.a == 0) goto L6;
        r2.put("cost", System.currentTimeMillis() - d0.a);     // Catch: Exception -> L8
    L6:
        d0.a = 0;     // Catch: Exception -> L8
    L10:
        this.a.e.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L8:
        e = move-exception;
        Log.e("CreationAIReport", "Exception: " + e);
        goto L10
    }

    public p(CreationAIPanelController r1) {
        this.a = r1;
    }
}
