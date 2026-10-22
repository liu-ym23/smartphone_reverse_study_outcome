package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.View;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ImageItemAdapter a;
    public final /* synthetic */ int b;

    public a(ImageItemAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Function2<? super Integer, ? super String, Unit> r5 = this.a.b;
        if (r5 == null) goto L9;
        Integer r0 = Integer.valueOf(this.b);
        String r1 = (String) CollectionsKt.getOrNull(this.a.a, this.b);
        if (r1 != null) goto L7;
        r1 = BuildConfig.FLAVOR;
    L7:
        Unit r6 = (Unit) r5.invoke(r0, r1);
        return;
    }
}
