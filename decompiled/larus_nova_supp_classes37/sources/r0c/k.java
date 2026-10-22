package r0c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.lark.android.encryption.CipherManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements d {
    public final Context a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final boolean h;
    public final boolean i;
    public com.ss.android.lark.compose.foundation.toast.g j;
    public final q0c.a k;

    public class a implements Runnable {
        public final /* synthetic */ k a;

        public final void a() {
            final q0c.b r0 = p0c.a.a();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.isCipherStatusOn() == false) goto L9;
            LKUIToast.show(this.a.a, 2131890600);
            CipherManager.h();
            return;
        L9:
            k r1 = this.a;
            if (r1.i == false) goto L13;
            e.a(r1.a, "key_result_saved_image", r1.c);
            return;
        L13:
            AuthorizationServiceV2.b r6 = new i(this, r0);
            r0.checkImageDownloadAuthorizationAndShowWarningOnFailed(r1.d, r1.e, r1.f, r1.a, 2131890280, r6);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(k r1) {
            this.a = r1;
        }
    }

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.a, this.g);
    }

    public final void c() {
        com.ss.android.lark.compose.foundation.toast.g r0 = this.j;
        if (r0 == null) goto L6;
        r0.cancel();
        this.j = null;
        return;
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        return this.b;
    }

    public static void b(k r2, boolean r3) {
        r2.getClass();
        Activity r4 = Contexts.requireActivity(r2.a);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r4 == null) goto L12;
        Intent r0 = new Intent();
        r0.putExtra("key_result_saved_image", r3);
        r4.setResult(-1, r0);
        r4.finish();
        return;
    L12:
        return;
    L5:
        e = move-exception;
        Log.e("SavePhotoUrlAction", "mContext not Activity", e);
        r4 = null;
        goto L7
    }

    public k(Context r2, boolean r3, String r4, String r5, String r6, String r7, int r8, boolean r9, boolean r10, q0c.a r11) {
        Lifecycle r0 = null;
        this.j = null;
        this.k = null;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.k = r11;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        LifecycleOwner r12 = Contexts.requireActivity(r2);     // Catch: Exception -> L9
        if ((r12 instanceof LifecycleOwner) == false) goto L6;
        r0 = r12.getLifecycle();     // Catch: Exception -> L9
    L6:
        if (r0 == null) goto L14;
        r0.addObserver(new h(this, r0));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Log.e("SavePhotoUrlAction", "onDestroy failed:" + e);
    }
}
