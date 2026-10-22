package com.bytedance.android.live.componentsmarket.impl;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.componentsmarket.api.IComponentsMarketService;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.CommonMergeAnchorInfoWidget;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.MediaAnchorInfoWidget;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.c0;
import com.bytedance.android.live.componentsmarket.impl.components.close.RoomCloseWidget;
import com.bytedance.android.live.componentsmarket.impl.components.close.i;
import com.bytedance.android.live.componentsmarket.impl.components.title.TitleTetris;
import com.bytedance.android.live.componentsmarket.impl.components.title.l;
import com.bytedance.android.live.componentsmarket.impl.components.userlist.RoomCountWidget;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.config.hs;
import h70.b;
import j70.h;
import j70.n;
import jc1.k;
import k40.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n40.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\u0014\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007H\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010H\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/ComponentsMarketService;", "Lcom/bytedance/android/live/componentsmarket/api/IComponentsMarketService;", "Lj70/h;", "Lh70/b;", "getTitleTetrisDesc", "getMediaTopAreaTetrisDesc", "getUserListTetrisDesc", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "getTitleTetris", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAnchorInfoWidget", "getUserListWidget", "getCloseRoomTetris", "getCloseRoomDescriptor", "getAnchorInfoTetrisDesc", "Lj70/n;", "getLiveDetailWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/View;", "cardView", "", "resetPositionOnSizeChange", "Lk40/d;", "createDraggableCard", "", "text", "Landroid/app/Dialog;", "getLoadingDialog", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ComponentsMarketService implements IComponentsMarketService {
    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public h<? extends b> getAnchorInfoTetrisDesc() {
        return new c0();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public Class<? extends LiveRecyclableWidget> getAnchorInfoWidget() {
        if (((Boolean) hs.a.getValue()).booleanValue() == false) goto L6;
        return CommonMergeAnchorInfoWidget.class;
    L6:
        return MediaAnchorInfoWidget.class;
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public h<? extends b> getCloseRoomDescriptor() {
        return new i();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public Tetris<? extends b> getCloseRoomTetris() {
        return new RoomCloseWidget();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public n<? extends b> getLiveDetailWidgetDescriptor() {
        return new com.bytedance.android.live.componentsmarket.impl.components.titledetail.b();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public h<? extends b> getMediaTopAreaTetrisDesc() {
        int r0 = a.a;
        return null;
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public Tetris<? extends b> getTitleTetris() {
        return new TitleTetris();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public h<? extends b> getTitleTetrisDesc() {
        return new l();
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public h<? extends b> getUserListTetrisDesc() {
        return new com.bytedance.android.live.componentsmarket.impl.components.userlist.a();
    }

    public ComponentsMarketService() {
        k.l(IComponentsMarketService.class, this);
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public Class<? extends LiveRecyclableWidget> getUserListWidget() {
        return RoomCountWidget.class;
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public Dialog getLoadingDialog(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new r40.a(r2, r3);
    }

    @Override // com.bytedance.android.live.componentsmarket.api.IComponentsMarketService
    public d createDraggableCard(Context r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cardView");
        return new p40.a(r2, r3, r4);
    }
}
