package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import w20.nc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w2 extends w20.o4<nc, OpenMultiSelectPhotoLibraryResultModel> implements ILiveActivityResultListener.OnLiveActivityResultListener {
    public static final TokenCert c = null;
    public int a;
    public final WeakReference<Context> b;

    public interface a {
        void a();

        void b();
    }

    public static final class b {
    }

    static {
        c = TokenCert.Companion.with("bpea-livescreenshotsharedialog_request_permission");
    }

    public w2(WeakReference<Context> r2) {
        Intrinsics.checkNotNullParameter(r2, "contextRef");
        this.b = r2;
        this.a = 6144;
    }

    private final Activity getContext(Context r2) {
        if ((r2 instanceof Activity) == true) goto L5;
    L7:
        return null;
    L5:
        if ((r2 instanceof ILiveActivityResultListener) == false) goto L7;
        return (Activity) r2;
    }

    public final void invoke(Object r5, CallContext r6) {
        nc r7 = (nc) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        ILiveActivityResultListener r8 = getContext(r6.getContext());
        if ((r8 instanceof ILiveActivityResultListener) == false) goto L15;
        r8.setOnLiveActivityResultListener(this);
        TokenCert r0 = c;
        a3 r1 = new a3(this, r7, r8);
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 34) goto L8;
        String[] r10 = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    L11:
        Context r11 = this.b.get();
        if (m60.c.d(r11, (String[]) Arrays.copyOf(r10, r10.length)) == false) goto L14;
        r1.b();
        return;
    L14:
        Activity r2 = ContextUtil.contextToActivity(r11);
        SettingKey r3 = m60.i.a;
        new m60.i.b(r2).b(new x2(r1, r11), null, r0, (String[]) Arrays.copyOf(r10, r10.length));
        return;
    L8:
        if (r9 < 33) goto L10;
        r10 = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        goto L11
    L10:
        r10 = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        goto L11
    L15:
        finishWithFailure(new Throwable("Context is not support ILiveActivityResultListener, ctx = ".concat(String.valueOf(r8))));
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        if (r2 == 100200) goto L5;
        return;
    L5:
        if (r3 != (-1)) goto L12;
        if (r4 == null) goto L12;
        Task.callInBackground(new y2(this, r4.getParcelableArrayListExtra("key_choose_media_live_link_data"))).continueWith(new z2(this), Task.UI_THREAD_EXECUTOR);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        finishWithFailure(e);
        return;
    L12:
        finishWithFailure();
    }
}
