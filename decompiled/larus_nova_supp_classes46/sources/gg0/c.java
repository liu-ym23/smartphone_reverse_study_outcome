package gg0;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends b<MultiLinkNormalEmptyViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r3, tf0.e r4) {
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r3;
        MultiLinkNormalEmptyViewBinder.a r6 = (MultiLinkNormalEmptyViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        boolean r0 = f(r5.c(), r6.c());
        if (super.a(r5, r6) == false) goto L18;
        if (r0 == false) goto L18;
        if (r5.g() != r6.g()) goto L18;
        if (r5.e() != r6.e()) goto L18;
        if (r5.h() != r6.h()) goto L18;
        if (r5.f() != r6.f()) goto L18;
        if (e(r5.a(), r6.a()) == false) goto L18;
        if (r5.i() != r6.i()) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // gg0.b
    public final boolean b(tf0.e r2, tf0.e r3) {
        MultiLinkNormalEmptyViewBinder.a r4 = (MultiLinkNormalEmptyViewBinder.a) r2;
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.b() != r5.b()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(ch0.b r5, ch0.b r6) {
        if (Intrinsics.areEqual(r5, r6) == false) goto L5;
        return true;
    L5:
        IBaseUser r0 = null;
        if (r5 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r5.b);
    L9:
        if (r6 == null) goto L11;
        Boolean r3 = Boolean.valueOf(r6.b);
    L13:
        if (Intrinsics.areEqual(r2, r3) == false) goto L22;
        if (r5 == null) goto L22;
        IBaseUser r7 = r5.a;
        if (r7 == null) goto L22;
        if (r6 == null) goto L20;
        r0 = r6.a;
    L20:
        if (r7.equals(r0) != true) goto L22;
        return true;
    L22:
        return false;
    L11:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final boolean f(LinkmicPositionItem r2, LinkmicPositionItem r3) {
        if (Intrinsics.areEqual(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == null) goto L14;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (vm2.d.N0() == false) goto L13;
        return com.bytedance.android.live.liveinteract.multianchor.model.h.b(r2, r3);
    L13:
        return r2.equals(r3);
    L14:
        return false;
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r3, tf0.e r4, int r5, int r6) {
        MultiLinkNormalEmptyViewBinder.a r7 = (MultiLinkNormalEmptyViewBinder.a) r3;
        MultiLinkNormalEmptyViewBinder.a r8 = (MultiLinkNormalEmptyViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r7, "oldItem");
        Intrinsics.checkNotNullParameter(r8, "newItem");
        Bundle r9 = super.d(r7, r8, r5, r6);
        if (f(r7.c(), r8.c()) == true) goto L6;
        r9.putBoolean("payload_key_position_item_update", true);
    L6:
        if (r7.f() == r8.f()) goto L9;
        r9.putBoolean("payload_key_position_invite_guide_update", r8.f());
    L9:
        if (r7.h() == r8.h()) goto L11;
    L12:
        r9.putBoolean("payload_key_interact_state_update", r8.h());
    L14:
        if (e(r7.a(), r8.a()) == true) goto L16;
        r9.putBoolean("payload_key_friend_online_update", true);
    L16:
        return r9;
    L11:
        if (r7.g() == r8.g()) goto L14;
        goto L12
    }
}
