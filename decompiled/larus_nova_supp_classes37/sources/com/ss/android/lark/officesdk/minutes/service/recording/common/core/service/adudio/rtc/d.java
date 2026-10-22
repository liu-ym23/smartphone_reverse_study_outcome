package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.profile.v2.entity.UserInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public JSONObject a;
    public JSONObject b;
    public String c;

    public static final class a {
        public static String a(int r4, boolean r5) {
            Intrinsics.checkNotNullParameter("", "tenantId");
            JSONObject r0 = new JSONObject();
            if (r4 != 2) goto L5;
            r0.put("call_type", "meeting");
        L7:
            if (r5 == false) goto L9;
            r0.put("user_type", "host");
        L10:
            r0.put("tenant_id", "");
            return r0.toString();
        L9:
            r0.put("user_type", "attendee");
            goto L10
        L5:
            r0.put("call_type", "call");
            goto L7
        }
    }

    static {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("", "tenantId");
        Intrinsics.checkNotNullParameter("", "interactiveId");
        Intrinsics.checkNotNullParameter("", "appVersion");
        JSONObject r0 = this.b;
        if (r0 == null) goto L5;
        r0.put("tenant_id", "");
    L5:
        JSONObject r1 = this.b;
        if (r1 == null) goto L8;
        r1.put("interactive_id", "");
    L8:
        JSONObject r2 = this.b;
        if (r2 == null) goto L12;
        r2.put("app_version", "");
        return;
    }

    public d() {
        this.c = UserInfo.NONE_NAME_CARD_ID;
    }
}
