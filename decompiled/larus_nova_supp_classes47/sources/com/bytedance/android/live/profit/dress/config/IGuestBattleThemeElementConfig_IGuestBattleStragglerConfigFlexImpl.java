package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.GuestBattleStragglerConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/j$e;", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl;", "gradeConfig$delegate", "Ljava/lang/Object;", "getGradeConfig", "()Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl;", "gradeConfig", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl extends FlexModelBase<j.e> implements j.e, vh7.h {

    @SerializedName("grade_config")
    protected IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl _$$gradeConfig;

    public IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl() {
        super(j.e.class);
    }

    public IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl(am3.g r6) {
        super(j.e.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$gradeConfig = new IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.e
    public /* bridge */ /* synthetic */ j.c getGradeConfig() {
        return getGradeConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.e
    public final IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl getGradeConfig() {
        return this._$$gradeConfig;
    }
}
