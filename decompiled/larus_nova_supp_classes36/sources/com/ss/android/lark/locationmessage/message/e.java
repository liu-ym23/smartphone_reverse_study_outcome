package com.ss.android.lark.locationmessage.message;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnLongClickListener {
    public final /* synthetic */ LocationMessageCell.LocationMessageViewHolder a;
    public final /* synthetic */ v5b.c b;
    public final /* synthetic */ LocationMessageCell c;

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        r5b.b<LocationContentVO> r4 = this.c.b;
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.d(this.a.a, this.b);
    }

    public e(LocationMessageCell r1, LocationMessageCell.LocationMessageViewHolder r2, v5b.c r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
