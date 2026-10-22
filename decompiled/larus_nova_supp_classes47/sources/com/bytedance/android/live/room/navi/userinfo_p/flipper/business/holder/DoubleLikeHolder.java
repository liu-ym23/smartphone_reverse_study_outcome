package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.executor.DoubleLikeNextTabExecutor;
import com.bytedance.android.livesdk.model.b1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/DoubleLikeHolder;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/CommonTabHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleLikeHolder extends CommonTabHolder implements Observer<KVData> {
    public static final /* synthetic */ int i = 0;
    public b1 h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return new DoubleLikeNextTabExecutor(this.e, this.h);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void n() {
        this.e.observe("cmd_user_info_sub_title_anim", this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.h = null;
        this.e.removeObserver(this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final boolean d(w91.e r2) {
        return a0.d(this.e, false);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        b1 r7 = r6.d;
        View r0 = null;
        if (r7 == null) goto L15;
        String r1 = r7.a;
        int r2 = r7.b;
        View r3 = this.f.findViewById(2131390378);
        if ((r3 instanceof TextView) == false) goto L10;
        r0 = r3;
    L10:
        TextView r4 = (TextView) r0;
        if (r4 == null) goto L14;
        r4.setText(r1);
        r4.setTextColor(r2);
    L14:
        Unit r5 = Unit.INSTANCE;
    L16:
        this.h = r7;
        return;
    L15:
        r7 = null;
        goto L16
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L27;
        String r0 = r7.getKey();
        if (r0.hashCode() == (-777370727)) goto L9;
        return;
    L9:
        if (r0.equals("cmd_user_info_sub_title_anim") == false) goto L25;
        Object r8 = r7.getData();
        View r1 = null;
        if ((r8 instanceof b1) == true) goto L13;
        r8 = null;
    L13:
        b1 r9 = (b1) r8;
        if (r9 == null) goto L26;
        String r2 = r9.a;
        int r3 = r9.b;
        View r4 = this.f.findViewById(2131390378);
        if ((r4 instanceof TextView) == false) goto L19;
        r1 = r4;
    L19:
        TextView r5 = (TextView) r1;
        if (r5 == null) goto L23;
        r5.setText(r2);
        r5.setTextColor(r3);
    L23:
        Unit r10 = Unit.INSTANCE;
        this.h = r9;
        return;
    L26:
        return;
    L25:
        return;
    }

    public DoubleLikeHolder(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
