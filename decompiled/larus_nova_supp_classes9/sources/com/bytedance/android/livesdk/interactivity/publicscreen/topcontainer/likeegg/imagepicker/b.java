package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ LikeEggImagePickerDialog a;

    public b(LikeEggImagePickerDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        ArrayList r5 = (ArrayList) r4;
        LikeEggImagePickerDialog r0 = this.a;
        int r1 = 0;
        r0.m = false;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L42;
        ImagePickViewModel r2 = r0.j;
        if (r2 != null) goto L10;
    L24:
        ImageItemAdapter r3 = r0.k;
        if (r3 == null) goto L29;
        ArrayList<String> r6 = r3.a;
        if (r6 == null) goto L29;
        r1 = r6.size();
    L29:
        ImageItemAdapter r7 = r0.k;
        if (r7 == null) goto L34;
        ArrayList<String> r8 = r7.a;
        if (r8 == null) goto L34;
        r8.addAll(r5);
    L34:
        ImageItemAdapter r9 = r0.k;
        if (r9 == null) goto L41;
        r9.notifyItemRangeInserted(r1, r5.size());
        return;
    L41:
        return;
    L10:
        if (r2.getMCurrentPageIndex() != 0) goto L24;
        ImageItemAdapter r10 = r0.k;
        if (r10 == null) goto L16;
        ArrayList<String> r11 = r10.a;
        if (r11 == null) goto L16;
        r11.clear();
    L16:
        ImageItemAdapter r13 = r0.k;
        if (r13 == null) goto L21;
        ArrayList<String> r14 = r13.a;
        if (r14 == null) goto L21;
        r14.addAll(r5);
    L21:
        ImageItemAdapter r15 = r0.k;
        if (r15 == null) goto L39;
        r15.notifyDataSetChanged();
        return;
    L39:
        return;
    }
}
