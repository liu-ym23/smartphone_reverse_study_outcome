package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.MultiLinkAudioCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.utils.h;
import com.bytedance.android.live.liveinteract.videotalk.e0;
import com.bytedance.android.live.liveinteract.videotalk.k0;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b extends jg0.a<MultiLinkNormalEmptyViewBinder.a> {
    public MultiLinkNormalEmptyViewBinder.a e;
    public ch0.b f;
    public View g;
    public TextView h;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b i;
    public PositionNameTv j;
    public View k;
    public ImageView l;
    public com.bytedance.android.live.liveinteract.a m;
    public Integer n;
    public CompositeDisposable o;
    public final DataCenter p;

    public void r() {
    }

    public int s() {
        return 2131251693;
    }

    public void v() {
    }

    @Override // jg0.c, jg0.f
    public void onDetach() {
        CompositeDisposable r0 = this.o;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public com.bytedance.android.live.liveinteract.a t() {
        MicSeatScene r0 = this.b;
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return new e0(q());
    L11:
        return new k0(q());
    }

    public final void y() {
        MultiLinkNormalEmptyViewBinder.a r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.d;
    L7:
        if (h.f(r1) == true) goto L11;
        AppCompatTextView r2 = this.j;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r2);
    L11:
        PositionNameTv r3 = this.j;
        if (r3 == null) goto L34;
        MultiLinkNormalEmptyViewBinder.a r4 = this.e;
        if (r4 == null) goto L16;
        LinkmicPositionItem r5 = r4.c();
    L17:
        LinkmicPositionItem r6 = r5;
        boolean r7 = gh0.a.d();
        MultiLinkNormalEmptyViewBinder.a r8 = this.e;
        if (r8 == null) goto L20;
        int r9 = r8.f;
    L21:
        if (r8 == null) goto L24;
        List<Integer> r10 = r8.g;
        if (r10 == null) goto L24;
    L25:
        MultiLinkNormalEmptyViewBinder.a r11 = this.e;
        if (r11 == null) goto L28;
        int r12 = r11.d;
    L29:
        if (r12 <= 0) goto L31;
        boolean r13 = true;
    L32:
        PositionNameTv.y(r3, r6, r7, r9, r10, r13);
        return;
    L31:
        r13 = false;
        goto L32
    L28:
        r12 = 0;
    L24:
        r10 = CollectionsKt.emptyList();
        goto L25
    L20:
        r9 = 0;
        goto L21
    L16:
        r5 = null;
        goto L17
    L34:
        return;
    L5:
        r1 = -1;
        goto L7
    }

    @Override // jg0.c, jg0.f
    public void a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super.a(r7);
        this.g = q().findViewById(2131389539);
        this.h = (TextView) q().findViewById(2131389540);
        PositionNameTv r8 = (PositionNameTv) q().findViewById(2131389701);
        this.j = r8;
        if (r8 == null) goto L5;
        r8.setDataCenter(this.p);
    L5:
        this.k = q().findViewById(2131389606);
        this.l = (ImageView) q().findViewById(2131363623);
        ImageView r1 = (ImageView) q().findViewById(2131389534);
        TextView r2 = (TextView) q().findViewById(2131389541);
        ImageView r3 = (ImageView) q().findViewById(2131389536);
        int r4 = s();
        this.i = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b(r1, r2, r3, r4, this instanceof MultiLinkAudioCommonEmptyMicSeatBasicLayer);
        com.bytedance.android.live.liveinteract.a r9 = t();
        this.m = r9;
        if (r9 == null) goto L8;
        r9.b();
    L8:
        this.o = new CompositeDisposable();
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        r();
        if (LinkFeedTypeConstant.Companion.isFeedType(n()) == true) goto L18;
        MicSeatScene r4 = this.b;
        if (r4 != MicSeatScene.AUDIO_LINK_HAMLET_AVATAR) goto L8;
    L9:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r5 = this.i;
        if (r5 == null) goto L12;
        r5.k.setTextSize(2, 10.0f);
    L12:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L17;
        int r1 = s1.f(36.0f);
        int r0 = s1.f(36.0f);
        ViewGroup.LayoutParams r7 = r6.j.getLayoutParams();
        r7.width = r1;
        r7.height = r0;
        return;
    L17:
        return;
    L8:
        if (r4 == MicSeatScene.AUDIO_LINK_STAGE_ENLARGE) goto L9;
        return;
    }

    public final void u(boolean r4) {
        MultiLinkNormalEmptyViewBinder.a r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() != true) goto L28;
        MultiLinkNormalEmptyViewBinder.a r1 = this.e;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.e() != true) goto L30;
        if (r4 == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r5 = this.i;
        if (r5 == null) goto L14;
        int r2 = r5.d / 2;
        ViewGroup.LayoutParams r3 = r5.j.getLayoutParams();
        r3.width = r2;
        r3.height = r2;
        r5.j.setLayoutParams(r3);
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L17;
        r6.d(2131251692);
    L17:
        MultiLinkNormalEmptyViewBinder.a r7 = this.e;
        if (r7 != null) goto L20;
    L22:
        int r8 = 2131917241;
    L23:
        String r9 = s1.B(r8);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r10 = this.i;
        if (r10 == null) goto L31;
        r10.g(r9);
        return;
    L31:
        return;
    L20:
        if (r7.h() != true) goto L22;
        r8 = 2131919823;
        goto L23
    L30:
        return;
    }

    public b(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        super(r2, r3);
        this.p = null;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        w((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    public void w(MultiLinkNormalEmptyViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.e = r2;
        this.n = Integer.valueOf(r3);
        v();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r4 = this.i;
        if (r4 == null) goto L6;
        r4.a = this.e;
        r4.h();
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        x((MultiLinkNormalEmptyViewBinder.a) r1, r2, r3);
    }

    public void x(MultiLinkNormalEmptyViewBinder.a r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        this.e = r2;
        this.n = Integer.valueOf(r3);
    }
}
