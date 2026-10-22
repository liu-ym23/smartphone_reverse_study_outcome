package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ String b;

    public c(ArrayList r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        ay1.b.b().put(this.b, this.a);
    }
}
