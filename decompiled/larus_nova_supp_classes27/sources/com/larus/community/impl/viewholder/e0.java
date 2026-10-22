package com.larus.community.impl.viewholder;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.service.z2;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 extends BaseControllerListener<Object> {
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
        if (this.a != 4) goto L11;
        z2 r4 = z2.a;
        if (r4.m() == true) goto L7;
    L10:
        e1.o(this.b.c);
        goto L11
    L7:
        if (r4.getCreationMakeSameConfigV2().b() == true) goto L10;
        e1.x(this.b.c);
    L11:
        Integer r5 = this.c;
        if (r5 != null) goto L15;
    L16:
        CreationMusicViewHolder r6 = this.b;
        UserCreationContent r7 = this.d.e;
        if (r7 == null) goto L21;
        UserCreationMusic r8 = r7.b;
        if (r8 == null) goto L21;
        String r9 = r8.f;
    L22:
        r6.U3(r9, r6.g);
        e1.x(this.b.d);
        e1.x(this.b.e);
        return;
    L21:
        r9 = null;
        goto L22
    L15:
        if (r5.intValue() != 5) goto L16;
    }

    public e0(int r1, CreationMusicViewHolder r2, Integer r3, UserCreation r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
