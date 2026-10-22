package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.navi.userinfo.viewmodel.UserInfoBasicVM;
import com.bytedance.android.live.room.navi.userinfo.viewmodel.UserInfoVM;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/PVHolder;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/CommonTabHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PVHolder extends CommonTabHolder implements Observer<KVData> {
    public static final /* synthetic */ int k = 0;
    public long h;
    public u91.a i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        q("cumulative_audience_cnt");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.i = null;
        this.j = false;
        this.h = 0;
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r12) {
        this.i = r12;
        if (this.j == true) goto L71;
        boolean r0 = true;
        this.j = true;
        if (r12 != null) goto L7;
    L10:
        if (r12 != null) goto L12;
    L14:
        String r4 = "";
        IRoom r5 = this.d;
        String r1 = (String) this.e.get("data_anchor_total_user_count_str", "");     // Catch: Exception -> L17
    L32:
        String r8 = null;
        if (r1 != null) goto L35;
    L43:
        if (r5 == null) goto L56;
        IRoomStats r2 = r5.getStats();
        if (r2 == null) goto L56;
        String r3 = r2.getTotalUserStr();
        if (r3 == null) goto L56;
        if (r3.length() > 0) goto L52;
        r0 = false;
    L52:
        if (r0 == false) goto L54;
        r8 = r3;
    L54:
        if (r8 == null) goto L56;
        r(r8);
        return;
    L56:
        r(DataType.FALSE);
        Spm.Companion.getClass();
        Spm r6 = Spm.a.a("a100.c100.d100");
        IRoom r7 = this.d;
        if (r7 == null) goto L60;
        String r9 = r7.getOwnerUserIdString();
        if (r9 == null) goto L60;
    L61:
        Spm r10 = r6.anchorId(r9);
        IRoom r13 = this.d;
        if (r13 == null) goto L67;
        String r14 = r13.getIdStr();
        if (r14 == null) goto L67;
        r4 = r14;
    L67:
        sw2.a.b(r10.roomId(r4).aliasAppend("render_pv_failed").result(-1).reason("room or datacenter is null").e(), "PVHolder");
        return;
    L60:
        r9 = "";
        goto L61
    L35:
        if (r1.length() <= 0) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == true) goto L41;
        r1 = null;
    L41:
        if (r1 == null) goto L43;
        r(r1);
        return;
    L37:
        r15 = false;
    L17:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r16 = Spm.a.a("a100.c100.d100");
        if (r5 == null) goto L22;
        String r17 = r5.getOwnerUserIdString();
        if (r17 == null) goto L22;
    L23:
        Spm r18 = r16.anchorId(r17);
        if (r5 == null) goto L27;
        String r19 = r5.getIdStr();
        if (r19 == null) goto L27;
    L28:
        Spm r20 = r18.roomId(r19).aliasAppend("render_pv_failed");
        String r22 = e.getMessage();
        if (r22 != null) goto L31;
        r22 = "";
    L31:
        sw2.a.b(r20.reason(r22).result(-1).e(), "PVHolder");
        r1 = "";
    L27:
        r19 = "";
    L22:
        r17 = "";
        goto L23
    L12:
        if (r12.b == true) goto L14;
    L13:
        this.e.observe("data_anchor_total_user_count_str", this);
        goto L14
    L7:
        if (r12.b != true) goto L10;
        if (r12.c == 1) goto L13;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L16;
        String r0 = r5.getKey();
        if (r0.hashCode() == 687774237) goto L9;
        return;
    L9:
        if (r0.equals("data_anchor_total_user_count_str") == false) goto L15;
        String r6 = (String) r5.getData();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r(r6);
        return;
    L15:
        return;
    }

    public final void r(String r10) {
        String r4 = "";
        if (TextUtils.isEmpty(r10) == false) goto L61;
        Spm.Companion.getClass();
        Spm r12 = Spm.a.a("a100.c100.d100");
        IRoom r0 = this.d;
        if (r0 == null) goto L8;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L8;
    L9:
        Spm r13 = r12.anchorId(r1);
        IRoom r2 = this.d;
        if (r2 == null) goto L15;
        String r3 = r2.getIdStr();
        if (r3 == null) goto L15;
        r4 = r3;
    L15:
        sw2.a.b(r13.roomId(r4).aliasAppend("render_total_user_count_canceled").result(-1).reason("current total count string is empty").e(), "PVHolder");
        return;
    L8:
        r1 = "";
        goto L9
    L61:
        long r5 = CastLongProtector.parseLong(r10, CharsKt.checkRadix(10));     // Catch: NumberFormatException -> L23
        if (this.h <= r5) goto L21;
        return;
    L21:
        this.h = r5;     // Catch: NumberFormatException -> L23
    L38:
        u91.a r6 = this.i;
        if (r6 != null) goto L41;
    L54:
        r10 = s1.C(2131911611, new Object[]{r10});
        UserInfoVM.Companion.getClass();
        k91.d r7 = UserInfoVM.b.a();
        if (r7 == null) goto L59;
        UserInfoBasicVM r8 = r7.getBasicVM();
        if (r8 == null) goto L59;
        UserInfoBasicVM.updateAccessibilityDesc$default(r8, null, r10, 1, null);
    L59:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r10);
        return;
    L41:
        if (r6.b != true) goto L54;
        if (r6.c != 1) goto L49;
        UserInfoVM.Companion.getClass();
        k91.d r9 = UserInfoVM.b.a();
        if (r9 == null) goto L59;
        UserInfoBasicVM r14 = r9.getBasicVM();
        if (r14 == null) goto L59;
        UserInfoBasicVM.updateAccessibilityDesc$default(r14, r10, null, 2, null);
        goto L59
    L49:
        r10 = s1.C(2131911611, new Object[]{""});
        UserInfoVM.Companion.getClass();
        k91.d r15 = UserInfoVM.b.a();
        if (r15 == null) goto L59;
        UserInfoBasicVM r16 = r15.getBasicVM();
        if (r16 == null) goto L59;
        UserInfoBasicVM.updateAccessibilityDesc$default(r16, null, r10, 1, null);
    L23:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r17 = Spm.a.a("a100.c100.d100");
        IRoom r18 = this.d;
        if (r18 == null) goto L28;
        String r19 = r18.getOwnerUserIdString();
        if (r19 == null) goto L28;
    L29:
        Spm r20 = r17.anchorId(r19);
        IRoom r22 = this.d;
        if (r22 == null) goto L33;
        String r23 = r22.getIdStr();
        if (r23 == null) goto L33;
    L34:
        Spm r24 = r20.roomId(r23).aliasAppend("render_total_user_count_failed").result(-1);
        String r25 = e.getMessage();
        if (r25 != null) goto L37;
        r25 = "";
    L37:
        sw2.a.b(r24.reason(r25).w(), "PVHolder");
    L33:
        r23 = "";
    L28:
        r19 = "";
        goto L29
    }

    public PVHolder(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
