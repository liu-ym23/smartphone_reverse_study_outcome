package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/liveinteract/plantform/commonwindow/utils/a$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0052a extends TypeToken<ClientUIInfo> {
        public C0052a() {
        }
    }

    public static final ClientUIInfo a(String r5) {
        ClientUIInfo r2 = null;
        if (r5 != null) goto L19;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L23;
        ClientUIInfo r4 = (ClientUIInfo) GsonHelper.get().fromJson(r5, new C0052a().getType());     // Catch: Exception -> L8
        ALogger.i("ClientUIUtil", "clientUiInfo = " + r5);     // Catch: Exception -> L15
        return r4;
    L15:
        Exception e = e;
        r2 = r4;
    L17:
        ALogger.e("ClientUIUtil", "parse ui_feature_list error!", e);
        return r2;
    L8:
        e = e;
        goto L17
    L23:
        return null;
    L19:
        if (r5.length() == 0) goto L10;
        r3 = false;
        goto L11
    }
}
