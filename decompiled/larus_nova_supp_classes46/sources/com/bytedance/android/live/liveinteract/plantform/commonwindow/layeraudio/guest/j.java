package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public FrameLayout A;
    public View B;
    public final CompositeDisposable C;
    public int z;

    public static final class a implements Runnable {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.i;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            j r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ j a;

        public c(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            j r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131566572;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c, jg0.f
    public final void onDetach() {
        super.onDetach();
        this.C.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void r() {
        super.r();
        q().post(new a(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void K(IBaseUser r4) {
        Intrinsics.checkNotNullParameter(r4, "curUser");
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r4, AvatarType.AVATAR_MEDIUM.getValue()), 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        ConstraintLayout r4 = q().findViewById(2131389565);
        this.A = (FrameLayout) q().findViewById(2131389568);
        this.B = q().findViewById(2131374158);
        InteractiveSongContext.a r5 = InteractiveSongContext.Companion;
        InteractiveSongContext r0 = r5.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<String> r1 = r0.getSingingGuestId();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L11;
        Disposable r6 = r2.subscribe(new b(this));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.C);
    L11:
        InteractiveSongContext r7 = r5.getContext();
        if (r7 == null) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isShowPlayer();
        if (r8 == null) goto L22;
        Observable r9 = r8.a();
        if (r9 == null) goto L23;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L24;
        RxUtilKt.c(r10, this.C);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.z = r3;
        super.A(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public j(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
        this.C = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        super.B(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
