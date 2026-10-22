package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$convertPkBaseStateToInt$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ e0 b;

    public s(MediatorLiveData r1, e0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r7) {
        Long r8 = (Long) r7;
        if (LinkMultiDynamicSettingsKt.a() > 0) goto L5;
    L10:
        MediatorLiveData r0 = this.a;
        JSONObject r1 = new JSONObject();
        r1.put("remain_time", r8.longValue());
        LiveData<PkBaseStateMachine.c> r9 = this.b.G.getPkBaseState();
        e0 r2 = this.b;
        final com.bytedance.android.live.revlink.impl.global.c r3 = r2.F;
        final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = r2.G;
        Intrinsics.checkNotNullParameter(r9, "$this$convertPkBaseStateToInt");
        Intrinsics.checkNotNullParameter(r4, "pkService");
        final MediatorLiveData r5 = new MediatorLiveData();
        r5.addSource(r9, new PkLynxDataContextKt$convertPkBaseStateToInt$$inlined$also$lambda$1(r5, r4, r3));
        r1.put("state", r5.getValue());
        Unit r10 = Unit.INSTANCE;
        r0.setValue(r1);
        return;
    L5:
        if (r8 == null) goto L7;
        long r6 = r8.longValue();
    L9:
        if ((r6 % ((long) LinkMultiDynamicSettingsKt.a())) == 0) goto L10;
        return;
    L7:
        r6 = 0;
        goto L9
    }
}
