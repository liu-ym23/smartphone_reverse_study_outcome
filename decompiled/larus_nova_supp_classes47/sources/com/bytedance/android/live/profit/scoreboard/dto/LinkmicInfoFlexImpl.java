package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.open.api.LinkmicInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/LinkmicInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/p;", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/LinkmicUserFlexImpl;", "users$delegate", "Ljava/lang/Object;", "getUsers", "()Ljava/util/List;", "users", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicInfoFlexImpl extends FlexModelBase<p> implements p, vh7.h {

    @SerializedName("users")
    protected List<LinkmicUserFlexImpl> _$$users;

    public LinkmicInfoFlexImpl() {
        super(p.class);
        this._$$users = $defaultValue_users$();
    }

    public LinkmicInfoFlexImpl(am3.g r6) {
        super(p.class);
        this._$$users = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$users.add(new LinkmicUserFlexImpl(r6));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$users.isEmpty() == false) goto L19;
        this._$$users = $defaultValue_users$();
        return;
    }

    public final List<LinkmicUserFlexImpl> $defaultValue_users$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.p
    public final List<LinkmicUserFlexImpl> getUsers() {
        return this._$$users;
    }
}
