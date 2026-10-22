package com.bytedance.android.live.service.grouppurchasetip;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.o;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public boolean b;
    public Disposable c;
    public final CompositeDisposable d;
    public final o e;

    /* JADX INFO: renamed from: com.bytedance.android.live.service.grouppurchasetip.a$a, reason: collision with other inner class name */
    public static final class C0222a implements Action {
        public final /* synthetic */ a a;

        public C0222a(a r1) {
            this.a = r1;
        }

        public final void run() {
            Disposable r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            a r1 = this.a;
            r1.c = null;
            r1.d.clear();
        }
    }

    public static final class b {
    }

    static {
    }

    public a(o r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.e = r3;
        CompositeDisposable r0 = new CompositeDisposable();
        this.d = r0;
        Completable r4 = r3.J2();
        if (r4 == null) goto L8;
        Disposable r5 = r4.subscribe(new C0222a(this));
        if (r5 == null) goto L9;
        RxUtilKt.c(r5, r0);
        return;
    L9:
        return;
    }
}
