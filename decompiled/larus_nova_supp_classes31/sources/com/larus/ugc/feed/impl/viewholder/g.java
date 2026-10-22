package com.larus.ugc.feed.impl.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g extends BaseControllerListener<Object> {
    public final /* synthetic */ CreationAvatarEntranceViewHolder a;

    public g(CreationAvatarEntranceViewHolder r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image failed");
        super.onFailure(r3, r4);
    }

    public final void onSubmit(String r3, Object r4) {
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image submit");
        super.onSubmit(r3, r4);
        e1.o(this.a.b);
        View r5 = this.a.c;
        if (r5 == null) goto L6;
        e1.o(r5);
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image set");
        e1.x(this.a.b);
        View r4 = this.a.c;
        if (r4 == null) goto L5;
        e1.x(r4);
    L5:
        this.a.b.setText(ContextCompat.getString(AppHost.a.getApplication().getApplicationContext(), 2131908822));
    }
}
