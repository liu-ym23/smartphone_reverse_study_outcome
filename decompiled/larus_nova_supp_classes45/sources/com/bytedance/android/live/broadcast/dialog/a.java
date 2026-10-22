package com.bytedance.android.live.broadcast.dialog;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;
import m60.i;
import o60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ PosterGenerateDialog a;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.dialog.a$a, reason: collision with other inner class name */
    public static final class C0018a implements e {
        public final /* synthetic */ a a;

        public C0018a(a r1) {
            this.a = r1;
        }

        @Override // o60.e
        public final void onPermissionDenied(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            ALogger.e("PosterGenerateDialog", "fail to save: permission denied");
            this.a.a.g = false;
            f2.c(s1.B(2131915035), 0);
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            PosterGenerateDialog.T90(this.a.a);
        }
    }

    public a(PosterGenerateDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        PosterGenerateDialog r6 = this.a;
        if (r6.g == true) goto L9;
        r6.g = true;
        if (Build.VERSION.SDK_INT < 33) goto L7;
        PosterGenerateDialog.T90(r6);
        return;
    L7:
        Activity r7 = ContextUtil.contextToActivity(r6.getContext());
        SettingKey<Boolean> r0 = i.a;
        new i.b(r7).b(new C0018a(this), null, TokenCert.Companion.with("bpea-live_anchor_column_save_poster"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        return;
    }
}
