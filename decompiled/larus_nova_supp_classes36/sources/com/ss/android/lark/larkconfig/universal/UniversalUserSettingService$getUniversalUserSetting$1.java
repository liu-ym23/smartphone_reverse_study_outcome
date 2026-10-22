package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/ss/android/lark/larkconfig/universal/UniversalUserSettingService$getUniversalUserSetting$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "", "Lcom/bytedance/lark/pb/basic/v1/UniversalUserSetting;", "onSuccess", "", "universalUserSettingMap", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "universal_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UniversalUserSettingService$getUniversalUserSetting$1 implements IGetDataCallback<Map<String, ? extends UniversalUserSetting>> {
    final /* synthetic */ IGetDataCallback<UniversalUserSetting> $callback;
    final /* synthetic */ String $key;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("UniversalUserSettingService", "get all universal user setting failed, " + r3.getDebugMsg());
    }

    public void onSuccess(Map<String, UniversalUserSetting> r4) {
        if (r4 != null) goto L5;
        Log.e("UniversalUserSettingService", "universal user setting map is null");
        return;
    L5:
        Iterator<Map.Entry<String, UniversalUserSetting>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, UniversalUserSetting> r0 = r5.next();
        String r1 = r0.getKey();
        UniversalUserSetting r2 = r0.getValue();
        a.a.getClass();
        a.a(r1, r2);
        goto L7
    L9:
        this.$callback.onSuccess(e.a.a(this.$key));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Map) r1);
    }

    public UniversalUserSettingService$getUniversalUserSetting$1(IGetDataCallback<UniversalUserSetting> r1, String r2) {
        this.$callback = r1;
        this.$key = r2;
    }
}
