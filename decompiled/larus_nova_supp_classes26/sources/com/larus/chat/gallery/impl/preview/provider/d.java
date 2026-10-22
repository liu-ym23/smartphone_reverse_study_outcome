package com.larus.chat.gallery.impl.preview.provider;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements r {
    public final boolean a;
    public final boolean b;
    public final com.larus.chat.gallery.api.z c;
    public PreviewBottomContainerFragment d;
    public List<com.larus.chat.gallery.api.o> e;
    public String f;

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        this.f = r2;
        PreviewBottomContainerFragment r0 = this.d;
        if (r0 == null) goto L6;
        r0.U90(r2);
        return;
    }

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final void b(List<com.larus.chat.gallery.api.o> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        this.e = r3;
        PreviewBottomContainerFragment r1 = this.d;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "items");
        r1.g = r3;
        r1.T90();
        return;
    }

    public d(boolean r1, boolean r2, com.larus.chat.gallery.api.z r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.e = CollectionsKt.emptyList();
    }

    @Override // com.larus.chat.gallery.impl.preview.provider.r
    public final Fragment c(GalleryInputFragment r8, Function1 r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r8, "inputFragment");
        Intrinsics.checkNotNullParameter(r9, "onSelectedItemClick");
        Intrinsics.checkNotNullParameter(r10, "onSelectedItemRemove");
        int r2 = PreviewBottomContainerFragment.l;
        boolean r3 = this.a;
        boolean r4 = this.b;
        PreviewBottomContainerFragment r5 = new PreviewBottomContainerFragment();
        Bundle r6 = new Bundle();
        r6.putBoolean("show_input", r3);
        r6.putBoolean("show_selection", r4);
        r5.setArguments(r6);
        com.larus.chat.gallery.api.z r7 = this.c;
        if (r7 == null) goto L6;
        GalleryInputFragment r11 = r7.a();
        if (r11 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r8, "callbackInputFragment");
        Intrinsics.checkNotNullParameter(r11, "visibleInputFragment");
        Intrinsics.checkNotNullParameter(r9, "onSelectedItemClick");
        Intrinsics.checkNotNullParameter(r10, "onSelectedItemRemove");
        if (r5.f != null) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L17;
        r5.d = r8;
        r5.e = r11;
        r5.f = new PreviewBottomContainerFragment.b(r9, r10, r5.requireArguments().getBoolean("show_selection"));
        this.d = r5;
        List<com.larus.chat.gallery.api.o> r12 = this.e;
        Intrinsics.checkNotNullParameter(r12, "items");
        r5.g = r12;
        r5.T90();
        String r13 = this.f;
        if (r13 == null) goto L15;
        r5.U90(r13);
    L15:
        return r5;
    L17:
        throw new IllegalStateException("Preview bottom has already been configured".toString());
    L10:
        r0 = false;
    L6:
        r11 = r8;
        goto L7
    }
}
