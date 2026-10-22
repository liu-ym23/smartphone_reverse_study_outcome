package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/UserSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserSerializer implements JsonSerializer<IBaseUser> {
    public UserSerializer() {
    }

    public final JsonElement serialize(Object r3, Type r4, JsonSerializationContext r5) {
        IBaseUser r6 = (IBaseUser) r3;
        JsonObject r7 = new JsonObject();
        if (r6 == null) goto L6;
        String r8 = r6.getIdString();
        if (r8 == null) goto L6;
    L7:
        r7.addProperty("id", r8);
        String r9 = BuildConfig.FLAVOR;
        if (r6 == null) goto L11;
        String r0 = r6.getNickName();
        if (r0 == null) goto L11;
    L12:
        r7.addProperty("nickname", r0);
        if (r6 == null) goto L16;
        String r1 = r6.getIdString();
        if (r1 == null) goto L16;
    L17:
        r7.addProperty("id_str", r1);
        if (r6 == null) goto L23;
        String r10 = r6.getWebcastUid();
        if (r10 == null) goto L23;
        r9 = r10;
    L23:
        r7.addProperty("webcast_uid", r9);
        return r7;
    L16:
        r1 = BuildConfig.FLAVOR;
    L11:
        r0 = BuildConfig.FLAVOR;
    L6:
        r8 = "0";
        goto L7
    }
}
