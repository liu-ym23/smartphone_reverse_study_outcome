package com.larus.common.account.douyin;

import android.app.Application;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements n38.l {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ IAiChatOpenDouyinAuthService.b b;

    public static final class a implements n38.m {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ IAiChatOpenDouyinAuthService.b c;
        public final /* synthetic */ String d;

        public final void onSuccess(String r14) {
            Bundle r15 = this.a;
            String r0 = "";
            if (r15 == null) goto L6;
            String r16 = r15.getString("granted_permission");
            if (r16 == null) goto L6;
        L7:
            Bundle r1 = this.a;
            if (r1 == null) goto L13;
            String r2 = r1.getString("state");
            if (r2 == null) goto L13;
            r0 = r2;
        L13:
            JSONObject r11 = this.b;
            if (r11 == null) goto L16;
            w0.d(null, "host", null, 1, r16, null, null, null, null, null, r11, 3045);
        L16:
            IAiChatOpenDouyinAuthService.b r3 = this.c;
            if (r3 == null) goto L20;
            IAiChatOpenDouyinAuthService.b.a.a(r3, true, null, null, this.d, r0, r16, 6);
            return;
        L20:
            return;
        L6:
            r16 = "";
            goto L7
        }

        public a(Bundle r1, JSONObject r2, IAiChatOpenDouyinAuthService.b r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a(int r18, String r110, String r20, String r21) {
            if (d.a.contains(String.valueOf(r18)) == false) goto L10;
            s r1 = s.a;
            AppHost.Companion r2 = AppHost.a;
            Application r3 = r2.getApplication();
            if (r110 != null) goto L7;
            String r4 = r2.getApplication().getString(2131908252);
        L8:
            r1.getClass();
            s.t(r3, r4);
            goto L10
        L7:
            r4 = r110;
        L10:
            if (r18 != 4048) goto L12;
            s r5 = s.a;
            AppHost.Companion r6 = AppHost.a;
            Application r7 = r6.getApplication();
            String r8 = r6.getApplication().getString(2131899061);
            r5.getClass();
            s.t(r7, r8);
            w0.a();
        L23:
            JSONObject r15 = this.b;
            if (r15 == null) goto L26;
            w0.d(null, "host", null, 0, null, null, null, null, null, null, r15, 3045);
        L26:
            IAiChatOpenDouyinAuthService.b r9 = this.c;
            if (r9 == null) goto L30;
            IAiChatOpenDouyinAuthService.b.a.a(r9, false, Integer.valueOf(r18), r110, null, null, "", 24);
            return;
        L30:
            return;
        L12:
            s r10 = s.a;
            AppHost.Companion r11 = AppHost.a;
            Application r12 = r11.getApplication();
            if (r110 != null) goto L15;
        L18:
            boolean r13 = true;
        L19:
            if (r13 == false) goto L21;
            String r14 = r11.getApplication().getString(2131907052);
        L22:
            Intrinsics.checkNotNull(r14);
            r10.getClass();
            s.t(r12, r14);
            goto L23
        L21:
            r14 = r110;
            goto L22
        L15:
            if (r110.length() == 0) goto L18;
            r13 = false;
            goto L19
        }
    }

    public b(JSONObject r1, com.larus.common.account.douyin.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "token");
        ILoginService.a.q("8943", "aweme_v2", r5, new a(r6, this.a, this.b, r5));
    }

    public final void b(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "errorMsg");
        if (Intrinsics.areEqual(r21, "-2") == false) goto L5;
        s r7 = s.a;
        AppHost.Companion r2 = AppHost.a;
        s.j(r7, r2.getApplication(), r2.getApplication().getString(2131905280), null, false, 28);
    L5:
        if (r21 != null) goto L17;
    L8:
        Integer r1 = null;
    L9:
        Integer r5 = r1;
        JSONObject r3 = this.a;
        if (r3 == null) goto L12;
        w0.d(null, "host", null, 0, null, null, null, null, null, null, r3, 3045);
    L12:
        IAiChatOpenDouyinAuthService.b r4 = this.b;
        if (r4 == null) goto L19;
        IAiChatOpenDouyinAuthService.b.a.a(r4, false, r5, r20, null, null, "", 24);
        return;
    L19:
        return;
    L17:
        r1 = Integer.valueOf(CastIntegerProtector.parseInt(r21));     // Catch: NumberFormatException -> L16
        goto L9
    }
}
