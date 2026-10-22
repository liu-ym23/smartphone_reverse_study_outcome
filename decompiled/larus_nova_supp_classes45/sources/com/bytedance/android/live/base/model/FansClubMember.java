package com.bytedance.android.live.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.FansClub")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/FansClubMember;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/t;", "Lpy/h;", "data", "Lpy/h;", "getData", "()Lpy/h;", "setData", "(Lpy/h;)V", "", "", "preferData", "Ljava/util/Map;", "getPreferData", "()Ljava/util/Map;", "setPreferData", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubMember extends FlexModelBase<com.bytedance.android.live.base.model.user.t> implements com.bytedance.android.live.base.model.user.t, vh7.h {
    public static final a Companion = null;
    public static final int OTHER_ROOM = 1;
    public static final int PERSONAL_PROFILE = 0;

    @SerializedName("data")
    protected py.h data;

    @SerializedName("prefer_data")
    protected Map<Integer, ? extends py.h> preferData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FansClubMember() {
        super(com.bytedance.android.live.base.model.user.t.class);
    }

    @Override // com.bytedance.android.live.base.model.user.t
    public py.h getData() {
        return this.data;
    }

    @Override // com.bytedance.android.live.base.model.user.t
    public Map<Integer, py.h> getPreferData() {
        return this.preferData;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.h] */
    public FansClubMember(am3.g r11) {
        super(com.bytedance.android.live.base.model.user.t.class);
        this.preferData = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        this.data = vh7.f.a(r11, py.h.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r7 = r11.c();
        Integer r3 = null;
        Object r6 = null;
    L11:
        int r9 = r11.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Integer.valueOf(r11.i());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r6 = vh7.f.a(r11, py.h.class);
        goto L11
    L15:
        am3.h.e(r11);
        goto L11
    L18:
        r11.d(r7);
        Map<Integer, ? extends py.h> r4 = this.preferData;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r4.put(r3, r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r5, r11);
        goto L3
    L27:
        r11.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.t
    public void setData(py.h r1) {
        this.data = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.t
    public void setPreferData(Map<Integer, ? extends py.h> r1) {
        this.preferData = r1;
    }
}
