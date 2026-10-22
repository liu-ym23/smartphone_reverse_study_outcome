package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends b<MultiLinkPreOnlineViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r6, tf0.e r7) {
        MultiLinkPreOnlineViewBinder.a r8 = (MultiLinkPreOnlineViewBinder.a) r6;
        MultiLinkPreOnlineViewBinder.a r9 = (MultiLinkPreOnlineViewBinder.a) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        LinkmicPositionItem r0 = r8.n;
        LinkmicPositionItem r1 = r9.n;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        boolean r2 = true;
    L10:
        if (super.a(r8, r9) == false) goto L18;
        if (r2 == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r8.k.getIdString(), r9.k.getIdString()) == true) goto L15;
        return false;
    L15:
        if (r8.l != r9.l) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    L5:
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        r2 = r0.equals(r1);
    L8:
        r2 = false;
        goto L10
    }

    @Override // gg0.b
    public final boolean b(tf0.e r2, tf0.e r3) {
        MultiLinkPreOnlineViewBinder.a r4 = (MultiLinkPreOnlineViewBinder.a) r2;
        MultiLinkPreOnlineViewBinder.a r5 = (MultiLinkPreOnlineViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.m != r5.m) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r4, tf0.e r5, int r6, int r7) {
        MultiLinkPreOnlineViewBinder.a r8 = (MultiLinkPreOnlineViewBinder.a) r4;
        MultiLinkPreOnlineViewBinder.a r9 = (MultiLinkPreOnlineViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        Bundle r10 = super.d(r8, r9, r6, r7);
        LinkmicPositionItem r11 = r8.n;
        LinkmicPositionItem r0 = r9.n;
        if (Intrinsics.areEqual(r11, r0) == false) goto L5;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L12;
        r10.putBoolean("payload_key_pre_online_position_item_update", true);
    L12:
        if ((!Intrinsics.areEqual(r8.k.getIdString(), r9.k.getIdString())) == false) goto L15;
        r10.putBoolean("payload_key_pre_online_user_update", true);
    L15:
        if (r8.l == r9.l) goto L17;
        r10.putBoolean("payload_key_pre_online_link_player_status_update", true);
    L17:
        return r10;
    L5:
        if (r11 == null) goto L8;
        if (r0 == null) goto L8;
        r12 = r11.equals(r0);
    L8:
        r12 = false;
        goto L9
    }
}
