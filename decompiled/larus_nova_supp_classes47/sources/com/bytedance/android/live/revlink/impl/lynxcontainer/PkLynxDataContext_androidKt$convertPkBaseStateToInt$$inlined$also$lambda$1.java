package com.bytedance.android.live.revlink.impl.lynxcontainer;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/lynxcontainer/PkLynxDataContext_androidKt$convertPkBaseStateToInt$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkLynxDataContext_androidKt$convertPkBaseStateToInt$$inlined$also$lambda$1 implements Observer<PkBaseStateMachine.c> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ e b;

    public final void onChanged(Object r7) {
        PkBaseStateMachine.c r8 = (PkBaseStateMachine.c) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        JSONObject r0 = new JSONObject();
        Map<String, ? extends PkBaseResult> r1 = (Map) this.b.getPkBaseResult().getValue();
        int r2 = 0;
        Long r3 = null;
        if (r1 == null) goto L10;
        d21.d r4 = com.bytedance.android.live.revlink.impl.global.b.r();
        if (r4 == null) goto L7;
        RevPkResult r5 = r4.e(r1);
    L8:
        if (r5 == null) goto L10;
        int r6 = r5.ordinal();
    L11:
        RevPkState r9 = r8.c();
        if (r9 == null) goto L14;
        Integer r10 = Integer.valueOf(r9.ordinal());
    L15:
        r0.put("state", r10.intValue());
        IBattleConfigSetting r12 = this.b.getConfigSetting();
        if (r12 == null) goto L18;
        r2 = r12.getModType();
    L18:
        r0.put("play_mode", r2);
        r0.put("skin_type", (int) this.b.getPkSkinConfig().a);
        r0.put("battle_id", String.valueOf(this.b.getPkId()));
        r0.put("battle_id_str", String.valueOf(this.b.getPkId()));
        LinkCrossRoomDataHolder r13 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r13 == null) goto L21;
        r3 = Long.valueOf(r13.c());
    L21:
        r0.put("channel_id_str", String.valueOf(r3));
        IBaseBattleSetting r14 = this.b.getBattleSettings();
        if (r14 == null) goto L25;
        String r15 = r14.getLynxData();
        if (r15 == null) goto L25;
    L26:
        r0.put("lynx_data", r15);
        r0.put("pk_result", r6);
        this.a.setValue(r0.toString());
        return;
    L25:
        r15 = "";
        goto L26
    L14:
        r10 = null;
        goto L15
    L7:
        r5 = null;
    L10:
        r6 = 0;
        goto L11
    }

    public PkLynxDataContext_androidKt$convertPkBaseStateToInt$$inlined$also$lambda$1(MediatorLiveData r1, e r2) {
        this.a = r1;
        this.b = r2;
    }
}
