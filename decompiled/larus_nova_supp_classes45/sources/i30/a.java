package i30;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends g<C0238a, Object> {
    public final SettingKey<Boolean> a;
    public final Activity b;
    public final DataCenter c;

    /* JADX INFO: renamed from: i30.a$a, reason: collision with other inner class name */
    public static class C0238a {

        @SerializedName("enter_live_source")
        public String enterLiveSource;

        @SerializedName("room_id")
        public long roomId;

        @SerializedName("user_id")
        public String userId;

        public C0238a() {
        }
    }

    public a(Activity r5, DataCenter r6) {
        Boolean r2 = Boolean.TRUE;
        SettingKey<Boolean> r0 = new SettingKey("live_fix_gotolive_jsb_ctx_mml", "修复GotoLiveMethod context内测泄露", r2, r2);
        this.a = r0;
        if (r0.getValue().booleanValue() == true) goto L5;
        this.b = r5;
    L5:
        this.c = r6;
    }

    public final Object invoke(Object r8, CallContext r9) throws Exception {
        C0238a r11 = (C0238a) r8;
        if (this.a.getValue().booleanValue() == true) goto L5;
        k.f(IRoomService.class).gotoLiveByProfile(this.b, this.c, r11.enterLiveSource, r11.userId, r11.roomId);
        return null;
    L5:
        Activity r1 = ContextUtil.contextToActivity(r9.getContext());
        if (r1 == null) goto L11;
        k.f(IRoomService.class).gotoLiveByProfile(r1, this.c, r11.enterLiveSource, r11.userId, r11.roomId);
        return null;
    L11:
        return null;
    }
}
