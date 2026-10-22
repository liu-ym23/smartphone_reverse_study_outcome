package com.bytedance.android.livesdk.ktvapi;

import com.bytedance.android.livesdk.ability.IAbility;
import fd2.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/AbsKtvSeiWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lfd2/j;", "<init>", "()V", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKtvSeiWidget extends HolderRoomWidget implements j {
    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // fd2.j
    public abstract void onSei(String r1);

    public AbsKtvSeiWidget() {
    }
}
