package com.larus.bmhome.chat.model;

import android.os.Looper;
import androidx.lifecycle.Transformations;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public static final f0 a = null;
    public static final Keva b = null;
    public static String c;
    public static final d0 d = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.d("ChatUsuallyRepo", "accountStateCallback.onLogIn");
            f0 r0 = f0.a;
            f0.c = r4.b;
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            f0.c = "";
        }
    }

    public f0() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.model.d0] */
    static {
        a = new f0();
        b = Keva.getRepo("im_chat_usually", 0);
        c = "";
        a r0 = new a();
        ?? r1 = new d0();
        d = r1;
        AccountService r2 = AccountService.a;
        c = r2.getUserId();
        r2.E(r0);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        RepoDispatcher.a.getClass();
        Transformations.distinctUntilChanged(RepoDispatcher.d.a).observeForever(r1);
        return;
    L5:
        FLogger.a.w("ChatUsuallyRepo", "ChatDraftRepo first init not in main thread, current thread is " + ThreadMethodProxy.currentThread().getName());
        com.larus.utils.y.c(new e0());
    }

    public static String a(String r2) {
        return c + '_' + r2;
    }
}
