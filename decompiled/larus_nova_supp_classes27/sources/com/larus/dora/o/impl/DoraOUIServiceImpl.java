package com.larus.dora.o.impl;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.larus.dora.o.api.IDoraOUIService;
import com.larus.dora.o.impl.album.ODoraAlbumCardView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/o/impl/DoraOUIServiceImpl;", "Lcom/larus/dora/o/api/IDoraOUIService;", "<init>", "()V", "createAlbumCardView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAlbumEntryClick", "Lkotlin/Function0;", "", "onSyncRequiresConnection", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOUIServiceImpl implements IDoraOUIService {
    public DoraOUIServiceImpl() {
    }

    @Override // com.larus.dora.o.api.IDoraOUIService
    public final View a(Context r2, LifecycleOwner r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "onAlbumEntryClick");
        Intrinsics.checkNotNullParameter(r5, "onSyncRequiresConnection");
        return new ODoraAlbumCardView(r2, r3, r4, r5);
    }
}
