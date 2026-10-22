package com.larksuite.component.blockit.hashtag.list;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ oy7.e b;

    public d(b r1, oy7.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        HashTagSwipeAdapter r7 = this.a.e;
        if (r7 == null) goto L5;
        r7.y2();
    L5:
        oy7.e r8 = this.b;
        String r9 = r8.b;
        if (r9 == null) goto L15;
        b r0 = this.a;
        JSONObject r1 = new JSONObject(r0.c);
        HashTagSwipeAdapter r2 = r0.e;
        if (r2 == null) goto L10;
        Integer r3 = Integer.valueOf(r2.getItemCount());
    L11:
        r1.put("tag_count", r3);
        r1.put("tag_id", r8.a);
        qy7.a.a("pano_action_panel_delete_tag", r1);
        k.a r4 = r0.d;
        if (r4 == null) goto L16;
        r4.M3(r8.a, r9);
        return;
    L16:
        return;
    L10:
        r3 = null;
        goto L11
    }
}
