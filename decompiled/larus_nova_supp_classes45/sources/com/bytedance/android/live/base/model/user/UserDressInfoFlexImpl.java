package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.UserDressInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/user/UserDressInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/l0;", "", "", "<set-?>", "owning$delegate", "Ljava/lang/Object;", "getOwning", "()Ljava/util/List;", "setOwning", "(Ljava/util/List;)V", "owning", "wearing$delegate", "getWearing", "setWearing", "wearing", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserDressInfoFlexImpl extends FlexModelBase<l0> implements l0, vh7.h {

    @SerializedName("dress_own_ids")
    protected List<String> _$$owning;

    @SerializedName("dress_wear_ids")
    protected List<String> _$$wearing;

    public UserDressInfoFlexImpl() {
        super(l0.class);
        this._$$owning = $defaultValue_owning$();
        this._$$wearing = $defaultValue_wearing$();
    }

    public UserDressInfoFlexImpl(am3.g r6) {
        super(l0.class);
        this._$$owning = new ArrayList();
        this._$$wearing = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L13;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        List<String> r4 = this._$$owning;
    L12:
        r4.add(am3.h.c(r6));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L11:
        r4 = this._$$wearing;
        goto L12
    L13:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$owning.isEmpty() == false) goto L17;
        this._$$owning = $defaultValue_owning$();
    L17:
        if (this._$$wearing.isEmpty() == false) goto L27;
        this._$$wearing = $defaultValue_wearing$();
        return;
    }

    public final List<String> $defaultValue_owning$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<String> $defaultValue_wearing$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.base.model.user.l0
    public final List<String> getOwning() {
        return this._$$owning;
    }

    @Override // com.bytedance.android.live.base.model.user.l0
    public final List<String> getWearing() {
        return this._$$wearing;
    }

    @Override // com.bytedance.android.live.base.model.user.l0
    public final void setOwning(List<String> r1) {
        this._$$owning = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.l0
    public final void setWearing(List<String> r1) {
        this._$$wearing = r1;
    }
}
