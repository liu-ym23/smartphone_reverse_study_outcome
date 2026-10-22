package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.navi.userinfo.viewmodel.UserInfoBasicVM;
import com.bytedance.android.live.room.navi.userinfo.viewmodel.UserInfoVM;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/UVHolder;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/CommonTabHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UVHolder extends CommonTabHolder implements Observer<KVData> {
    public static final /* synthetic */ int j = 0;
    public String h;
    public u91.a i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        this.e.observe("data_anchor_online_count_str", this);
        q("avg_concurrent_users");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.i = null;
        this.h = "";
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r1) {
        this.i = r1;
        r(this.h);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L16;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1325275850) goto L9;
        return;
    L9:
        if (r0.equals("data_anchor_online_count_str") == false) goto L15;
        String r6 = (String) r5.getData();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r(r6);
        return;
    L15:
        return;
    }

    public final void r(String r4) {
        u91.a r0 = this.i;
        if (r0 == null) goto L8;
        if (r0.b == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        this.h = r4;
        u91.a r5 = this.i;
        if (r5 != null) goto L12;
    L19:
        String r6 = s1.B(2131911609);
        UserInfoVM.Companion.getClass();
        k91.d r2 = UserInfoVM.b.a();
        if (r2 == null) goto L24;
        UserInfoBasicVM r3 = r2.getBasicVM();
        if (r3 == null) goto L24;
        UserInfoBasicVM.updateAccessibilityDesc$default(r3, null, r6, 1, null);
    L24:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r6);
        return;
    L12:
        if (r5.c != 1) goto L19;
        UserInfoVM.Companion.getClass();
        k91.d r7 = UserInfoVM.b.a();
        if (r7 == null) goto L18;
        UserInfoBasicVM r8 = r7.getBasicVM();
        if (r8 == null) goto L18;
        UserInfoBasicVM.updateAccessibilityDesc$default(r8, this.h, null, 2, null);
    L18:
        r6 = this.h;
        goto L24
    }

    public UVHolder(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
        this.h = "";
    }
}
