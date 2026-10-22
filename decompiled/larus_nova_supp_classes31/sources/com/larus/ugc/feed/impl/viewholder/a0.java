package com.larus.ugc.feed.impl.viewholder;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.service.z2;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 extends BaseControllerListener<Object> {
    public final /* synthetic */ int a;
    public final /* synthetic */ CreationMusicViewHolder b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ UserCreation d;

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
        e1.o(this.b.c);
        e1.o(this.b.d);
        e1.o(this.b.e);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        if (this.a == 4) goto L5;
    L8:
        Integer r4 = this.c;
        if (r4 != null) goto L12;
    L13:
        CreationMusicViewHolder r5 = this.b;
        UserCreationContent r6 = this.d.e;
        if (r6 == null) goto L18;
        UserCreationMusic r7 = r6.b;
        if (r7 == null) goto L18;
        String r8 = r7.f;
    L19:
        r5.U3(r8, r5.g);
        e1.x(this.b.d);
        e1.x(this.b.e);
        return;
    L18:
        r8 = null;
        goto L19
    L12:
        if (r4.intValue() != 5) goto L13;
        return;
    L5:
        if (z2.a.getCreationMakeSameConfigV2().b() == false) goto L7;
        e1.o(this.b.c);
        goto L8
    L7:
        e1.x(this.b.c);
        goto L8
    }

    public a0(int r1, CreationMusicViewHolder r2, Integer r3, UserCreation r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
