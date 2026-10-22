package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.wgamex.gameinvite.AnchorInviteViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h4 implements c0.b {
    public View a;
    public DataCenter b;
    public final CompositeDisposable c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ h4 a;

        public a(h4 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.wgamex.gameinvite.i r5 = (com.bytedance.android.livesdk.wgamex.gameinvite.i) r4;
            h4 r0 = this.a;
            r0.getClass();
            if ((r5 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.a) == false) goto L5;
        L13:
            View r6 = r0.a;
            if (r6 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("toolbarView");
        L16:
            UtilityKotlinExtentionsKt.w(r6);
            return;
        L5:
            if ((r5 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == true) goto L13;
            if ((r5 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.b) == true) goto L13;
            View r7 = r0.a;
            if (r7 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("toolbarView");
        L12:
            UtilityKotlinExtentionsKt.t(r7);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public h4() {
        this.c = new CompositeDisposable();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_WGAME) == true) goto L5;
        return;
    L5:
        DataCenter r4 = this.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        r4.put("cmd_wgame_anchor_show_invite_dialog", Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
        UtilityKotlinExtentionsKt.t(r2);
        DataContext r4 = com.bytedance.live.datacontext.d.d(Integer.valueOf(r3.hashCode()));
        AnchorInviteViewModel r0 = null;
        if ((r4 instanceof RoomContext) == true) goto L5;
        r4 = null;
    L5:
        RoomContext r5 = (RoomContext) r4;
        if (r5 != null) goto L8;
        return;
    L8:
        zr1.c r6 = (zr1.c) r5.getWgameXInviteManager().getValue();
        if (r6 == null) goto L11;
        AnchorInviteViewModel r7 = r6.a();
    L13:
        if ((r7 instanceof AnchorInviteViewModel) == false) goto L16;
        r0 = r7;
    L16:
        if (r0 != null) goto L22;
        View r8 = this.a;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarView");
    L20:
        UtilityKotlinExtentionsKt.t(r8);
        return;
    L22:
        this.c.add(r0.stateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
        return;
    L11:
        r7 = null;
        goto L13
    }
}
