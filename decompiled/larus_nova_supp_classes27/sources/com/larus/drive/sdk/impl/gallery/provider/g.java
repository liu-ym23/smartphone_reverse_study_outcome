package com.larus.drive.sdk.impl.gallery.provider;

import android.widget.TextView;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.api.w;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements v79.e {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // v79.e
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        w r3 = ((t) this.a).e;
        if (r3 == null) goto L6;
        r3.Rf(p.g.a);
        return;
    }

    @Override // v79.e
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r3, "newFileName");
        LarusGalleryChatTitleBinding r4 = this.a.g;
        if (r4 == null) goto L8;
        TextView r5 = r4.g;
        if (r5 == null) goto L9;
        r5.setText(r3);
        return;
    L9:
        return;
    }
}
