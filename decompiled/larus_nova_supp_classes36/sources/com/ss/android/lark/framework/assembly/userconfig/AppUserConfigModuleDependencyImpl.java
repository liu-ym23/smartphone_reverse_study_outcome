package com.ss.android.lark.framework.assembly.userconfig;

import c0c.b;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.larkconfig.userconfig.c;
import com.ss.android.lark.larkconfig.userconfig.e;
import com.ss.android.lark.larkconfig.userconfig.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(upb.a.class)
public class AppUserConfigModuleDependencyImpl implements upb.a {
    private static final String TAG = "AppUserConfigModuleDependencyImpl";
    private final ConcurrentHashMap<h, b> mListenerMap;
    j mPassportService;
    yzb.b mUserListApi;

    public class a extends b {
        public final /* synthetic */ h b;

        public final void nf(f0c.b r3) {
            Log.i(AppUserConfigModuleDependencyImpl.TAG, "onPrepared");
            Scene r4 = r3.b.b;
            if (Scene.FIRST_ONLINE.equals(r4) == false) goto L5;
        L8:
            e r5 = ((c) this.b).a;
            r5.d();
            r5.b();
            return;
        L5:
            if (Scene.FAST_ONLINE.equals(r4) == true) goto L8;
            if (Scene.SWITCH_ONLINE.equals(r4) == true) goto L8;
        }

        public a(j r1, h r2) {
            this.b = r2;
            super(r1);
        }
    }

    private j getPassPortService() {
        if (this.mPassportService != null) goto L6;
        this.mPassportService = (j) LarkContext.spiByDwarf(j.class);
    L6:
        return this.mPassportService;
    }

    private yzb.b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (yzb.b) LarkContext.spiByDwarf(yzb.b.class);
    L6:
        return this.mUserListApi;
    }

    public AppUserConfigModuleDependencyImpl() {
        this.mListenerMap = new ConcurrentHashMap();
    }

    @Override // upb.a
    public String getUserId() {
        return getUserListApi().c();
    }

    @Override // upb.a
    public void registerAccountChangeListener(h r3) {
        Log.i(TAG, "registerAccountChangeListener");
        if (r3 != null) goto L5;
    L9:
        Log.i(TAG, "return");
        return;
    L5:
        if (this.mListenerMap.containsKey(r3) == true) goto L9;
        a r0 = new a(getPassPortService(), r3);
        this.mListenerMap.put(r3, r0);
        com.ss.android.lark.passportc.api.h.a(r0);
    }

    public void unregisterAccountChangeListener(h r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        b r3 = this.mListenerMap.remove(r2);
        if (r3 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.getPassport().h(r3);
        return;
    }
}
