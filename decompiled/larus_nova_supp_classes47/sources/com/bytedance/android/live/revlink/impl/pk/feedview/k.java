package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b b;
    public final /* synthetic */ Function0 c;

    public k(MediatorLiveData r1, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r6) {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r7 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) r6;
        JSONObject r8 = new JSONObject();
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r0 = this.b.e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.b;
    L6:
        r8.put("state", r2);
        IBaseBattleSetting r3 = this.b.b();
        if (r3 == null) goto L11;
        IBattleConfigSetting r4 = r3.getBattleConfigSetting();
        if (r4 == null) goto L11;
        int r5 = r4.getModType();
    L12:
        r8.put("play_mode", r5);
        r8.put("skin_type", this.b.d());
        IBaseBattleSetting r9 = this.b.b();
        String r10 = null;
        if (r9 == null) goto L15;
        String r12 = String.valueOf(r9.getBattleId());
    L16:
        r8.put("battle_id", r12);
        IBaseBattleSetting r13 = this.b.b();
        if (r13 == null) goto L19;
        r10 = String.valueOf(r13.getBattleId());
    L19:
        r8.put("battle_id_str", r10);
        r8.put("channel_id_str", this.c.invoke());
        IBaseBattleSetting r14 = this.b.b();
        if (r14 == null) goto L23;
        String r15 = r14.getLynxData();
        if (r15 == null) goto L23;
    L24:
        r8.put("lynx_data", r15);
        q11.a r16 = this.b.l;
        if (r16 == null) goto L29;
        RevPkResult r17 = r16.a();
        if (r17 == null) goto L29;
        r1 = r17.ordinal();
    L29:
        r8.put("pk_result", r1);
        this.a.setValue(r8.toString());
        return;
    L23:
        r15 = "";
        goto L24
    L15:
        r12 = null;
    L11:
        r5 = 0;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }
}
