package z1a;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.update.IBitsUpdateImpl;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class e implements yhc.c {
    public final /* synthetic */ IBitsUpdateImpl a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(IBitsUpdateImpl r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(PolarisFileWrapper r6) {
        IBitsUpdateImpl r0 = this.a;
        String r1 = this.b;
        int r2 = IBitsUpdateImpl.h;
        Intrinsics.checkNotNull(r6);
        r0.getClass();
        AppHost.Companion r3 = AppHost.a;
        ContextWrapper r4 = r3.a().getCurrentActivity();
        if (r4 != null) goto L5;
        r4 = r3.getApplication();
    L5:
        FLogger.a.d("update_sdk", "auto install apk context:" + r4 + ",file:" + r6);
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 24) goto L8;
        Uri r7 = FileProvider.getUriForFile(r4, r1, r6);
    L9:
        Intent r8 = new Intent("android.intent.action.VIEW");
        r8.setDataAndType(r7, "application/vnd.android.package-archive");
        if (r5 < 24) goto L12;
        int r9 = 268435457;
    L13:
        r8.addFlags(r9);
        r4.startActivity(r8);
        return;
    L12:
        r9 = 268435456;
        goto L13
    L8:
        r7 = Uri.fromFile(r6);
        goto L9
    }
}
