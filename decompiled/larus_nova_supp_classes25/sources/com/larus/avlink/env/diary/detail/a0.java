package com.larus.avlink.env.diary.detail;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 {
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.avlink.env.diary.detail.z] */
    public static final boolean a(Fragment r94, final CustomMarkdownTextView r95) {
        Intrinsics.checkNotNullParameter(r94, "fragment");
        boolean r10 = false;
        if (r95 != null) goto L5;
        return false;
    L5:
        List r1 = CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(2131907401, 2131907401, null, null, null, null, null, null, null, false, false, null, 2131241927, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127), new com.larus.bmhome.view.screenmenu.l0(2131907407, 2131907407, null, null, null, null, null, null, null, false, false, null, 2131241970, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127)});
        w r2 = new w(r94, r95, new z(r95));
        CommonMenu r3 = new CommonMenu(r95.getContext());
        r3.g(r1, r2);
        Balloon r0 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r95, r3, false, null, null, null, null, 124);
        Integer r4 = Integer.valueOf((int) r95.getClickX());
        if (r4.intValue() <= 0) goto L8;
        boolean r5 = true;
    L9:
        Integer r6 = null;
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        int r7 = r4.intValue();
    L16:
        Integer r8 = Integer.valueOf((int) r95.getClickY());
        if (r8.intValue() <= 0) goto L19;
        r10 = true;
    L19:
        if (r10 == false) goto L21;
        r6 = r8;
    L21:
        if (r6 == null) goto L23;
        int r9 = r6.intValue();
    L24:
        r0.v(r95, r7, r9);
        return true;
    L23:
        r9 = r95.getHeight() / 2;
        goto L24
    L15:
        r7 = r95.getWidth() / 2;
        goto L16
    L8:
        r5 = false;
        goto L9
    }
}
