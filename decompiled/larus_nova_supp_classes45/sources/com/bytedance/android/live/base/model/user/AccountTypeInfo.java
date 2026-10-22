package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.AuthenticationInfo.AccountTypeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AccountTypeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/a;", "", "", "", "typeMap", "Ljava/util/Map;", "getTypeMap", "()Ljava/util/Map;", "setTypeMap", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AccountTypeInfo extends FlexModelBase<py.a> implements py.a, vh7.h {
    public static final a Companion = null;
    public static final long mediaType = 1;

    @SerializedName("account_type_map")
    protected Map<Long, Boolean> typeMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AccountTypeInfo() {
        super(py.a.class);
    }

    @Override // py.a
    public Map<Long, Boolean> getTypeMap() {
        return this.typeMap;
    }

    public AccountTypeInfo(am3.g r11) {
        super(py.a.class);
        this.typeMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L7;
        long r6 = r11.c();
        Long r3 = null;
        Boolean r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = Boolean.valueOf(am3.h.a(r11));
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, Boolean> r4 = this.typeMap;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L25:
        r11.d(r0);
        setThreadSafe(true);
    }

    public void setTypeMap(Map<Long, Boolean> r1) {
        this.typeMap = r1;
    }
}
