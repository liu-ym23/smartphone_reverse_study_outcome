package com.larus.drive.sdk.impl.gallery.provider;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.drive.sdk.impl.gallery.DriveGalleryHelper;
import com.larus.drive.sdk.impl.view.chat.DriveInputFragment;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.api.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveGalleryInputProvider extends t<z79.c> {
    public final z79.b f;
    public final Lazy g;
    public final a h;

    public static final class a implements r79.d {
        public final /* synthetic */ DriveGalleryInputProvider a;

        @Override // r79.d
        public final void c() {
        }

        @Override // r79.d
        public final boolean d() {
            return false;
        }

        @Override // r79.d
        public final void e() {
        }

        @Override // r79.d
        public final boolean g() {
            return false;
        }

        @Override // r79.d
        public final z79.c f() {
            return (z79.c) ((t) this.a).d;
        }

        public a(DriveGalleryInputProvider r1) {
            this.a = r1;
        }

        @Override // r79.d
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
        }

        @Override // r79.d
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            w r3 = ((t) this.a).e;
            if (r3 == null) goto L6;
            r3.Rf(p.c.a);
            return;
        }

        @Override // r79.d
        public final boolean h(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "text");
            return false;
        }
    }

    public final boolean m() {
        return false;
    }

    public final boolean s() {
        return true;
    }

    public final void u() {
    }

    public DriveGalleryInputProvider(z79.b r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.f = r2;
        this.g = LazyKt.lazy(new com.larus.drive.sdk.impl.gallery.provider.a(this));
        this.h = new a(this);
    }

    public final Fragment o(ViewGroup r2) {
        if (r2 == null) goto L5;
        r2.post(new b(this));
    L5:
        return (DriveInputFragment) this.g.getValue();
    }

    public final void w(Object r2, int r3) {
        z79.c r4 = (z79.c) r2;
        Intrinsics.checkNotNullParameter(r4, "data");
        ((t) this).d = r4;
        DriveInputFragment r5 = (DriveInputFragment) this.g.getValue();
        DriveGalleryHelper r0 = DriveGalleryHelper.a;
        r5.X90(DriveGalleryHelper.c(r4.a));
    }
}
