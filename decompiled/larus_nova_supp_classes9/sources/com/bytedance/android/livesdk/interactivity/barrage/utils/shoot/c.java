package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.chatroom.utils.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements a1.b {
    public final /* synthetic */ q72.b a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d b;
    public final /* synthetic */ r22.a.b c;

    public final void a(Bitmap r3) {
        q72.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.c = true;
    L5:
        if (r0 == null) goto L8;
        r0.b = r3;
    L8:
        if (this.b.isSelfSendFake() == false) goto L15;
        q72.b r4 = this.a;
        if (r4 == null) goto L12;
        Bitmap r5 = r4.a;
    L13:
        if (r5 == null) goto L17;
        this.c.a(this.b);
        return;
    L17:
        return;
    L12:
        r5 = null;
        goto L13
    L15:
        this.c.a(this.b);
    }

    public final void onFail(Exception r2) {
        q72.b r3 = this.a;
        if (r3 == null) goto L6;
        r3.c = true;
    L6:
        if (this.b.isSelfSendFake() == false) goto L13;
        q72.b r4 = this.a;
        if (r4 == null) goto L10;
        Bitmap r5 = r4.a;
    L11:
        if (r5 == null) goto L15;
        this.c.a(this.b);
        return;
    L15:
        return;
    L10:
        r5 = null;
        goto L11
    L13:
        this.c.a(this.b);
    }

    public c(q72.b r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2, r22.a.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
