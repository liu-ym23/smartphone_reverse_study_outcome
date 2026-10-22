package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.provider.w0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements d0 {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final String a() {
        return "";
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o b() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean c(ChildResultMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        return true;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void detach() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean e() {
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean f(CameraResultRoute r1) {
        if (r1 != null) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void g() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.q getSession() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean h(CameraOutputContext r1, xy8.d r2) {
        Intrinsics.checkNotNullParameter(r1, "outputContext");
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final int i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return -1;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void j(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "onSelectionChanged");
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final List<com.larus.chat.gallery.api.o> l() {
        return CollectionsKt.emptyList();
    }
}
