package com.larus.avlink.gallery.view;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.avlink.gallery.share.AlbumDeleteDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements AlbumDeleteDialog.a {
    public final /* synthetic */ MediaAlbumViewHelper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
    public final void onCancelClick() {
    }

    @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
    public final void a() {
        MediaAlbumViewHelper r4 = this.a;
        String r1 = this.b;
        Function0<Unit> r3 = this.c;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.b), Dispatchers.getIO(), null, new MediaAlbumViewHelper$executeDeletion$1(r1, false, r3, r4, null), 2, null);
    }

    @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
    public final void b() {
        MediaAlbumViewHelper r4 = this.a;
        String r1 = this.b;
        Function0<Unit> r3 = this.c;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.b), Dispatchers.getIO(), null, new MediaAlbumViewHelper$executeDeletion$1(r1, true, r3, r4, null), 2, null);
    }

    public i0(MediaAlbumViewHelper r1, String r2, com.larus.bmhome.bigimg.o r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
