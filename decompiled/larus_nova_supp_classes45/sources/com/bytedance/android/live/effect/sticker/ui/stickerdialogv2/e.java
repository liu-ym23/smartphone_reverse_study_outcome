package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ LiveStickerDialogListAdapter a;
    public final /* synthetic */ LiveStickerDialogListAdapter.StickerViewHolder b;

    public e(LiveStickerDialogListAdapter r1, LiveStickerDialogListAdapter.StickerViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RecyclerView r0 = this.a.k.get();
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof GridLayoutManager) == false) goto L10;
        r1 = r2;
    L10:
        GridLayoutManager r3 = (GridLayoutManager) r1;
        int r4 = this.b.getAdapterPosition();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r4 == (-1)) goto L28;
        int r5 = r3.findFirstVisibleItemPosition();
        int r6 = r3.findLastVisibleItemPosition();
        if (r5 > r4) goto L19;
        if (r6 < r4) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L29;
        Sticker r8 = (Sticker) CollectionsKt.getOrNull(this.a.d, this.b.getAdapterPosition());
        if (r8 == null) goto L30;
        StickerDialogUIViewModel r9 = this.a.z2();
        if (r9 == null) goto L31;
        r9.onStickerViewAttached(this.a.i, r8, this.b.getAdapterPosition());
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r7 = false;
        goto L20
    L28:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
