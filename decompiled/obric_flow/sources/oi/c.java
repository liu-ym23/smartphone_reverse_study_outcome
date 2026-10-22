package oi;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public c() {
    }

    @Override // oi.a
    public final String a() {
        return "LocalPermissionLoader";
    }

    @Override // oi.a
    public final JSONObject c() {
        if (this.f20582a == null) goto L5;
        Intrinsics.checkNotNullParameter(new f9.a(17), "localStorage");
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", STGroup.DICT_KEY);
        String r5 = wl.b.f22870a.getString("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", null);
    L6:
        if (r5 != null) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return null;
    L11:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "config");
        if (r5 == null) goto L14;
        JSONObject r11 = new JSONObject(r5);
    L15:
        JSONObject r12 = new JSONObject();
        r12.put("data", r11);
        return r12;
    L14:
        r11 = new JSONObject();
        goto L15
    L8:
        r10 = StringsKt.isBlank(r5);
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
