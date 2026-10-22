package g82;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements kf1.a {
    public final Context a;
    public final Bundle b;

    public final String tag() {
        return "CoinTaskInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.COIN_TASK;
    }

    public a(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.b = r3;
    }

    public final boolean qa(Runnable r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "afterInterceptRunnable");
        if (r8 == true) goto L23;
        Context r9 = this.a;
        Bundle r10 = this.b;
        if (r10 == null) goto L8;
        String r11 = r10.getString("live.intent.extra.FROM_COIN_TASK");
    L10:
        if ((!Intrinsics.areEqual("1", r11)) == true) goto L23;
        SettingKey r13 = LiveConfigSettingKeys.COIN_TASK_REMAIN_URL;
        if (TextUtils.isEmpty((CharSequence) r13.getValue()) == true) goto L23;
        if (((Boolean) LiveConfigSettingKeys.SHOW_COIN_TASK_POPUP.getValue()).booleanValue() == false) goto L23;
        if (SharedPrefHelper.b(r9).h("live.pref.SHOW_COIN_TASK_POPUP_COUNTS", 1) >= 3) goto L23;
        String r1 = SharedPrefHelper.b(r9).j("live.pref.SHOW_COIN_TASK_POPUP_DATE", BuildConfig.FLAVOR);
        String r2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date());
        if (TextUtils.equals(r1, r2) == true) goto L23;
        ILiveService r3 = TTLiveService.getLiveService();
        Intrinsics.checkNotNull(r3);
        r3.handleSchema(r9, UriProtector.parse((String) r13.getValue()));
        SharedPrefHelper r14 = SharedPrefHelper.b(r9);
        r14.l("live.pref.SHOW_COIN_TASK_POPUP_DATE", r2);
        r14.a();
        return true;
    L8:
        r11 = null;
    L23:
        return false;
    }
}
