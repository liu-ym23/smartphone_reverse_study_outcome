package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceHomeFragment$setupAlbumCard$albumView$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricDeviceHomeFragment$setupAlbumCard$albumView$2(Object r8) {
        super(0, r8, DoraObricDeviceHomeViewModel.class, "onAlbumSyncRequiresConnection", "onAlbumSyncRequiresConnection()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m229invoke() {
        ((DoraObricDeviceHomeViewModel) ((CallableReference) this).receiver).onAlbumSyncRequiresConnection();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m229invoke();
        return Unit.INSTANCE;
    }
}
