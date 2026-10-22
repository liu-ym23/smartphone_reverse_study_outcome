package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00190 j\b\u0012\u0004\u0012\u00020\u0019`!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001f¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkCustomizePlayDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/c;", "", "isCustomizePkPlay", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkCustomizePlayDataContext$a;", "getCustomizePkSelfData", Constants.Keys.DATA, "", "updateCustomizePkSelfData", "reset", "Lcom/bytedance/android/livesdk/link/model/u2;", "battleSelfData", "Lcom/bytedance/android/livesdk/link/model/u2;", "getBattleSelfData", "()Lcom/bytedance/android/livesdk/link/model/u2;", "setBattleSelfData", "(Lcom/bytedance/android/livesdk/link/model/u2;)V", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "battleConfigSetting", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "setBattleConfigSetting", "(Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;)V", "", "selfOptId", "I", "getSelfOptId", "()I", "setSelfOptId", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "backOperationType", "Landroidx/lifecycle/MutableLiveData;", "getBackOperationType", "()Landroidx/lifecycle/MutableLiveData;", "setBackOperationType", "(Landroidx/lifecycle/MutableLiveData;)V", "backOperationType4Log", "getBackOperationType4Log", "setBackOperationType4Log", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkCustomizePlayDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.pk.service.c {
    private MutableLiveData<Integer> backOperationType;
    private int backOperationType4Log;
    private IBattleConfigSetting battleConfigSetting;
    private u2 battleSelfData;
    private int selfOptId;

    public static final class a {
        public final u2 a;
        public final int b;
        public final IBattleConfigSetting c;

        public a() {
            this(null, 0, 7);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            u2 r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            IBattleConfigSetting r4 = this.c;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CustomizePkData(selfData=" + this.a + ", selfOptId=" + this.b + ", configSetting=" + this.c + ")";
        }

        public a(u2 r3, int r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = 0;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = null;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.c
    public void reset() {
        this.battleSelfData = null;
        this.battleConfigSetting = null;
        this.backOperationType.setValue(0);
        this.backOperationType4Log = 0;
        this.selfOptId = -1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.c
    public a getCustomizePkSelfData() {
        return new a(this.battleSelfData, this.selfOptId, 4);
    }

    public final boolean isCustomizePkPlay() {
        IBattleConfigSetting r0 = this.battleConfigSetting;
        if (r0 == null) goto L12;
        v2 r1 = r0.getSelfSettingRate();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getPkValueType() > 0) goto L9;
        return false;
    L9:
        if (r1.getPkValueType() >= 100) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public PkCustomizePlayDataContext() {
        this.backOperationType = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getBackOperationType() {
        return this.backOperationType;
    }

    public final int getBackOperationType4Log() {
        return this.backOperationType4Log;
    }

    public final IBattleConfigSetting getBattleConfigSetting() {
        return this.battleConfigSetting;
    }

    public final u2 getBattleSelfData() {
        return this.battleSelfData;
    }

    public final int getSelfOptId() {
        return this.selfOptId;
    }

    public final void setBackOperationType(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.backOperationType = r2;
    }

    public final void setBackOperationType4Log(int r1) {
        this.backOperationType4Log = r1;
    }

    public final void setBattleConfigSetting(IBattleConfigSetting r1) {
        this.battleConfigSetting = r1;
    }

    public final void setBattleSelfData(u2 r1) {
        this.battleSelfData = r1;
    }

    public final void setSelfOptId(int r1) {
        this.selfOptId = r1;
    }

    public void updateCustomizePkSelfData(a r2) {
        if (r2 == null) goto L4;
        u2 r0 = r2.a;
    L5:
        this.battleSelfData = r0;
        if (r2 == null) goto L9;
        this.selfOptId = r2.b;
        return;
    L9:
        return;
    L4:
        r0 = null;
        goto L5
    }
}
