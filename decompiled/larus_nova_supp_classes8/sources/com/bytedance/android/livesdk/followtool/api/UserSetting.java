package com.bytedance.android.livesdk.followtool.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.open_user_setting.UpdateSettingRequest")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/UserSetting;", "", "", "allowFollowSyncToHost", "J", "<init>", "()V", "Companion", "a", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class UserSetting implements h {
    public static final a Companion = null;
    public static final long NO = 2;
    public static final long YES = 1;

    @SerializedName("relation_sync_to_host")
    public long allowFollowSyncToHost;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UserSetting() {
    }

    public UserSetting(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.allowFollowSyncToHost = r5.j();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
