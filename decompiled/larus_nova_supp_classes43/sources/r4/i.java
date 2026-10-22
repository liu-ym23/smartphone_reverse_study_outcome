package r4;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.bridge.service.OnPermissionCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface i {
    void a(Activity r1, e3.d r10, String r11, String[] r12, OnPermissionCallback r13);

    boolean isPermissionAllGranted(Context r1, String... r10);
}
