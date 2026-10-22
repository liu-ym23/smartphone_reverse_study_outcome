package com.bytedance.android.livesdk.chatroom.widget;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ Sticker b;
    public final /* synthetic */ Sticker c;

    public e(g r1, Sticker r2, Sticker r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        this.a.g.invoke(this.b, this.c);
        zg1.q r5 = this.a.e.d;
        if (r5 == null) goto L5;
        zg1.q.a.a(r5, true);
    L5:
        r3.dismiss();
    }
}
