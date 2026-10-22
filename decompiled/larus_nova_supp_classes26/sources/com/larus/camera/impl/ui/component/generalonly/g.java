package com.larus.camera.impl.ui.component.generalonly;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ AlbumThumbListComponent a;

    public /* synthetic */ g(AlbumThumbListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ((RecyclerView) this.a.p.getValue()).scrollToPosition(0);
        return Unit.INSTANCE;
    }
}
