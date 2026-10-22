package com.larus.dora.impl.device.manage.holder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/MediaAlbumUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "helper", "Lcom/larus/avlink/api/IMediaAlbumViewHelper;", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "", "onStop", "onDestroy", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaAlbumUIComponent extends LifecycleUIComponent {
    public w88.u d;

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        w88.u r0 = this.d;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        this.d = null;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStart() {
        super.onStart();
        w88.u r0 = this.d;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStop() {
        super.onStop();
        w88.u r0 = this.d;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public MediaAlbumUIComponent() {
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "container");
        IDoraAVLinkService r7 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r7 == null) goto L5;
        w88.u r8 = r7.l1(r6.getContext(), this);
    L6:
        this.d = r8;
        if (r8 == null) goto L10;
        View r9 = r8.getView();
        if (r9 == null) goto L10;
    L11:
        Resources r10 = r6.getContext().getResources();
        float r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density;
        int r0 = (int) (16 * r11);
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        r1.setMargins(r0, (int) (12 * r11), r0, 0);
        r9.setLayoutParams(r1);
        return r9;
    L10:
        r9 = new View(r6.getContext());
        goto L11
    L5:
        r8 = null;
        goto L6
    }
}
