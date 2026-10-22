package com.bytedance.common.utility.c;

import android.content.SharedPreferences;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f1978a = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.c.a$a, reason: collision with other inner class name */
    static class C0112a implements b {
        C0112a() {
        }

        @Override // com.bytedance.common.utility.c.a.b
        public void a(SharedPreferences.Editor r2) {
            ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).commit();
        }
    }

    interface b {
        void a(SharedPreferences.Editor r1);
    }

    static class c implements b {
        c() {
        }

        @Override // com.bytedance.common.utility.c.a.b
        public void a(SharedPreferences.Editor r2) {
            ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).apply();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 9) goto L5;
        b r0 = new c();
    L6:
        f1978a = r0;
        return;
    L5:
        r0 = new C0112a();
        goto L6
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        f1978a.a(r3);
    }
}
