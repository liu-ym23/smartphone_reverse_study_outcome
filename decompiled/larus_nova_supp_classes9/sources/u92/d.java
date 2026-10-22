package u92;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.textmessage.model.d0;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements j {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "textMessage");
        if ((r9 instanceof d0) == true) goto L5;
        return false;
    L5:
        d0 r10 = (d0) r9;
        c4 r0 = r10.b;
        String r2 = BuildConfig.FLAVOR;
        if (r0 == null) goto L11;
        m0 r1 = r0.getBaseMessage();
        if (r1 == null) goto L11;
        String r3 = r1.getMsgProcessFilterK();
        if (r3 == null) goto L11;
    L12:
        c4 r4 = r10.b;
        if (r4 == null) goto L18;
        m0 r5 = r4.getBaseMessage();
        if (r5 == null) goto L18;
        String r6 = r5.getMsgProcessFilterV();
        if (r6 == null) goto L18;
    L20:
        if (TextUtils.isEmpty(r3) == false) goto L22;
        return false;
    L22:
        if (TextUtils.isEmpty(r6) == true) goto L44;
        String r7 = (String) SettingUtil.getValue("key_ttlive_sdk_setting", r3, String.class, BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r7) == false) goto L26;
    L28:
        HashMap r8 = new HashMap();
        r8.put("msg_filter_key", r3);
        r8.put("msg_filter_value", r6);
        c4 r11 = r10.b;
        Long r13 = null;
        if (r11 == null) goto L31;
        Long r14 = Long.valueOf(r11.getMessageId());
    L32:
        r8.put("message_id", String.valueOf(r14));
        c4 r15 = r10.b;
        if (r15 == null) goto L38;
        String r16 = r15.toString();
        if (r16 == null) goto L38;
        r2 = r16;
    L38:
        r8.put("message", r2);
        r8.put("event", "intercept message due to ab setting.");
        b0.o().b("ttlive_msg", r8);
        StringBuilder r17 = new StringBuilder("intercept message due to ab setting, message_id=");
        c4 r18 = r10.b;
        if (r18 == null) goto L41;
        r13 = Long.valueOf(r18.getMessageId());
    L41:
        r17.append(String.valueOf(r13));
        r17.append(", key=");
        r17.append(r3);
        r17.append(", value=");
        r17.append(r6);
        Logger.d("MessageShowSettingInterceptor", r17.toString());
        return true;
    L31:
        r14 = null;
        goto L32
    L26:
        if (TextUtils.equals(r7, r6) == false) goto L28;
        return false;
    L44:
        return false;
    L18:
        r6 = BuildConfig.FLAVOR;
    L11:
        r3 = BuildConfig.FLAVOR;
        goto L12
    }
}
