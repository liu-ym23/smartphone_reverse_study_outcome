package com.bytedance.android.live.room.api.screenrotation.entrance.judge.land;

import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.judge.a;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/entrance/judge/land/LandVisibleCommonJudge;", "Lcom/bytedance/android/live/room/api/screenrotation/entrance/judge/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandVisibleCommonJudge extends a implements Observer<KVData> {
    public final String d;
    public boolean e;

    public LandVisibleCommonJudge() {
        this.d = "LandVisibleCommonJudge";
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.judge.a, com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final void onUnload() {
        super.onUnload();
        d r0 = this.a;
        if (r0 == null) goto L8;
        DataCenter r1 = r0.b();
        if (r1 == null) goto L9;
        r1.removeObserver(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final String getTag() {
        return this.d;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final boolean c(IRotateEntrance r2) {
        Intrinsics.checkNotNullParameter(r2, "entrance");
        return !this.e;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.judge.a
    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r2, "session");
        DataCenter r3 = r2.b();
        if (r3 == null) goto L6;
        r3.observe("data_keyboard_status", this);
        return;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Boolean r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == 1060055221) goto L12;
        return;
    L12:
        if (r1.equals("data_keyboard_status") == false) goto L17;
        if (r6 == null) goto L15;
        r0 = (Boolean) r6.getData();
    L15:
        this.e = Intrinsics.areEqual(r0, Boolean.TRUE);
        this.b.b();
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
