package com.larus.drive.sdk.impl.gallery.provider;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.DriveGalleryHelper;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.image.loader.b0;
import ic8.r;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends t<z79.c> {
    public final z79.b f;
    public final z79.a g;
    public LarusLayoutGalleryCreationSideBarBinding h;
    public int i;
    public final Map<String, Boolean> j;
    public boolean k;

    public final ViewGroup.LayoutParams q() {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.topMargin = i5.c0();
        return r0;
    }

    public final View p(ViewGroup r11) {
        LarusLayoutGalleryCreationSideBarBinding r12 = LarusLayoutGalleryCreationSideBarBinding.a(LayoutInflater.from(getContext()), r11);
        this.h = r12;
        CreationSidebarView r0 = r12.b;
        if (r0 == null) goto L5;
        z79.a r13 = this.g;
        ic8.d r2 = r13.a;
        ic8.d r1 = r13.b;
        ic8.d r5 = r13.c;
        ic8.d r4 = r13.d;
        int r14 = LeftCreationEditView.l;
        CreationSidebarView.S5(r0, r1, r2, null, r4, r5, null, null, LeftCreationEditView.a.a(), 100);
    L5:
        DriveGalleryHelper r15 = DriveGalleryHelper.a;
        boolean r16 = DriveGalleryHelper.c(this.f.b);
        this.k = r16;
        LarusLayoutGalleryCreationSideBarBinding r3 = this.h;
        if (r3 == null) goto L13;
        FrameLayout r6 = r3.a;
        if (r6 == null) goto L13;
        if (r16 == false) goto L11;
        int r17 = 0;
    L12:
        r6.setVisibility(r17);
        goto L13
    L11:
        r17 = 8;
    L13:
        LarusLayoutGalleryCreationSideBarBinding r18 = this.h;
        if (r18 != null) goto L18;
        return null;
    L18:
        return r18.a;
    }

    public final void x(p r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof p.k) == false) goto L42;
        p.k r6 = (p.k) r5;
        if (r6.a == this.i) goto L7;
        return;
    L7:
        ImageInfo r7 = r6.b;
        if (r7 != null) goto L10;
        return;
    L10:
        z79.c r0 = (z79.c) ((t) this).d;
        if (r0 != null) goto L13;
        return;
    L13:
        DriveFileItem r1 = r0.a;
        if (r1 == null) goto L16;
        DriveFileType r2 = r1.j;
    L18:
        if (r2 == DriveFileType.IMAGE) goto L20;
        return;
    L20:
        if (r1 == null) goto L23;
        String r3 = r1.b;
        if (r3 == null) goto L23;
    L26:
        int r4 = r7.getWidth();
        int r8 = r7.getHeight();
        if (r4 <= 0) goto L35;
        if (r8 <= 0) goto L35;
        int r9 = Math.max(r4, r8);
        int r10 = Math.min(r4, r8);
        if (r9 <= 3840) goto L33;
    L34:
        boolean r11 = true;
    L36:
        this.j.put(r3, Boolean.valueOf(r11));
        LarusLayoutGalleryCreationSideBarBinding r12 = this.h;
        if (r12 == null) goto L43;
        CreationSidebarView r13 = r12.b;
        if (r13 == null) goto L44;
        r13.T5(!r11);
        return;
    L44:
        return;
    L43:
        return;
    L33:
        if (r10 > 2160) goto L34;
    L35:
        r11 = false;
    L23:
        r3 = r0.e;
        if (r3 != null) goto L26;
        r3 = UUID.randomUUID().toString();
        goto L26
    L16:
        r2 = null;
        goto L18
    }

    public c(z79.b r2, z79.a r3) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        Intrinsics.checkNotNullParameter(r3, "aiEditParam");
        this.f = r2;
        this.g = r3;
        this.i = -1;
        this.j = new LinkedHashMap();
        this.k = true;
    }

    public final void w(Object r11, int r12) {
        z79.c r13 = (z79.c) r11;
        Intrinsics.checkNotNullParameter(r13, "data");
        ((t) this).d = r13;
        this.i = r12;
        DriveGalleryHelper r14 = DriveGalleryHelper.a;
        boolean r15 = DriveGalleryHelper.c(r13.a);
        this.k = r15;
        LarusLayoutGalleryCreationSideBarBinding r0 = this.h;
        if (r0 == null) goto L11;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L11;
        if (r15 == false) goto L8;
        int r16 = 0;
    L9:
        r1.setVisibility(r16);
        goto L11
    L8:
        r16 = 8;
    L11:
        if (this.k == false) goto L48;
        LarusLayoutGalleryCreationSideBarBinding r17 = this.h;
        DriveFileType r2 = null;
        if (r17 == null) goto L28;
        CreationSidebarView r3 = r17.b;
        if (r3 == null) goto L28;
        m1 r18 = r13.b;
        if (r18 == null) goto L22;
        String r110 = r18.a;
        if (r110 == null) goto L22;
        Uri r4 = b0.a(r110, "common.photo_dialog_preview", false, false, 6);
    L23:
        m1 r5 = r13.b;
        nr9.g r6 = r13.c;
        DriveFileItem r111 = r13.a;
        if (r111 == null) goto L26;
        String r112 = r111.b;
    L27:
        CreationSidebarView.R5(r3, r4, r5, r6, null, false, new r(r112), 24);
        goto L28
    L26:
        r112 = null;
    L22:
        r4 = null;
    L28:
        DriveFileItem r113 = r13.a;
        if (r113 == null) goto L32;
        r2 = r113.j;
    L32:
        if (r2 != DriveFileType.IMAGE) goto L45;
        if (r113 == null) goto L36;
        String r114 = r113.b;
        if (r114 == null) goto L36;
    L39:
        LarusLayoutGalleryCreationSideBarBinding r115 = this.h;
        if (r115 == null) goto L46;
        CreationSidebarView r116 = r115.b;
        if (r116 == null) goto L47;
        r116.T5(!Intrinsics.areEqual(((LinkedHashMap) this.j).get(r114), Boolean.TRUE));
        return;
    L47:
        return;
    L46:
        return;
    L36:
        r114 = r13.e;
        if (r114 != null) goto L39;
        r114 = UUID.randomUUID().toString();
        goto L39
    L45:
        return;
    }
}
