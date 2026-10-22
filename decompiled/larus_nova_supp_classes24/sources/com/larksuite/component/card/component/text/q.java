package com.larksuite.component.card.component.text;

import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q implements mcc.d {
    public final /* synthetic */ UniversalCardTextLynxUI a;

    public q(UniversalCardTextLynxUI r1) {
        this.a = r1;
    }

    public final void e(View r4, mcc.d.a r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "clickInfo");
        String r6 = r5.a;
        if (Intrinsics.areEqual(r6, "number_tag") == false) goto L8;
        UrlInfo r7 = r5.c;
        if (r7 == null) goto L15;
        UniversalCardTextLynxUI r8 = this.a;
        int r0 = UniversalCardTextLynxUI.g;
        r8.P(r7);
        return;
    L15:
        return;
    L8:
        if (Intrinsics.areEqual(r6, "markdown_audio") == false) goto L17;
        String r9 = r5.b;
        if (r9 != null) goto L13;
        Log.e("UniversalCardTextLynxUI", "MARKDOWN_AUDIO click with no id");
        return;
    L13:
        UniversalCardTextLynxUI r10 = this.a;
        int r1 = UniversalCardTextLynxUI.g;
        r10.getClass();
        r10.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r10.getSign(), "elementclick", MapsKt.mapOf(new Pair[]{TuplesKt.to("tag", "markdown_audio"), TuplesKt.to("id", r9)})));
        return;
    }
}
