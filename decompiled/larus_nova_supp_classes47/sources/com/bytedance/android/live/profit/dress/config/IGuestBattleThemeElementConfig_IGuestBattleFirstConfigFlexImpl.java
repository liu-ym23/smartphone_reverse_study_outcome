package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.GuestBattleFirstConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/j$b;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl;", "gradeConfigs$delegate", "getGradeConfigs", "()Ljava/util/List;", "gradeConfigs", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl extends FlexModelBase<j.b> implements j.b, vh7.h {

    @SerializedName("grade_configs")
    protected List<IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl> _$$gradeConfigs;

    @SerializedName("name")
    protected String _$$name;

    public IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl() {
        super(j.b.class);
        this._$$gradeConfigs = $defaultValue_gradeConfigs$();
    }

    public IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl(am3.g r6) {
        super(j.b.class);
        this._$$gradeConfigs = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$name = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$gradeConfigs.add(new IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl(r6));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$gradeConfigs.isEmpty() == false) goto L25;
        this._$$gradeConfigs = $defaultValue_gradeConfigs$();
        return;
    }

    public final List<IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl> $defaultValue_gradeConfigs$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.b
    public final List<IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl> getGradeConfigs() {
        return this._$$gradeConfigs;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.b
    public final String getName() {
        return this._$$name;
    }
}
