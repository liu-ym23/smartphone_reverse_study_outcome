package com.larus.drive.sdk.impl.gallery.provider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h extends t<z79.c> {
    public final z79.b f;
    public LarusGalleryChatTitleBinding g;

    public final boolean n() {
        return false;
    }

    public final void t() {
    }

    public final ViewGroup.LayoutParams q() {
        int r1 = i5.c0();
        i0.a.getClass();
        return new ViewGroup.LayoutParams(-1, r1 + i0.g());
    }

    public h(z79.b r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.f = r2;
    }

    public final View p(ViewGroup r5) {
        final DriveFileItem r0 = this.f.b;
        final LarusGalleryChatTitleBinding r6 = LarusGalleryChatTitleBinding.a(LayoutInflater.from(getContext()), r5);
        this.g = r6;
        TextView r1 = r6.g;
        r1.setMaxLines(1);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        r1.setTextSize(2, 15.0f);
        e1.o(r6.f);
        r6.b.setOnClickListener(new d(this));
        e1.x(r6.c);
        r6.c.setOnClickListener(new e(this, r6, r0));
        LarusGalleryChatTitleBinding r7 = this.g;
        if (r7 != null) goto L7;
        return null;
    L7:
        return r7.a;
    }

    public final void x(p r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        boolean r3 = r2 instanceof p.e;
    }

    public final void w(Object r8, int r9) {
        z79.c r10 = (z79.c) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        ((t) this).d = r10;
        LarusGalleryChatTitleBinding r11 = this.g;
        if (r11 == null) goto L11;
        TextView r12 = r11.g;
        if (r12 == null) goto L11;
        DriveFileItem r1 = r10.a;
        if (r1 == null) goto L9;
        String r2 = r1.a;
    L10:
        r12.setText(r2);
        goto L11
    L9:
        r2 = null;
    L11:
        DriveFileItem r13 = r10.a;
        if (r13 == null) goto L15;
        BuildersKt.launch$default(this.f.c, Dispatchers.getIO(), null, new DriveGalleryTopBarProvider$onPreviewChanged$1$1(r13, null), 2, null);
        return;
    }
}
