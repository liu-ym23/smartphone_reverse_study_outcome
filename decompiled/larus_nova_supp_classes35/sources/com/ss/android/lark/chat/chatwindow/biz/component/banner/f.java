package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b {
    public final /* synthetic */ BaseBannerComponent a;

    public static final class a implements Runnable {
        public final /* synthetic */ BaseBannerComponent a;

        public a(BaseBannerComponent r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = this.a.E0().getHeight();
            BaseBannerComponent r1 = this.a;
            if (r0 == r1.m) goto L11;
            List<IBannerComponent.a> r2 = r1.F0();
            BaseBannerComponent r3 = this.a;
            Iterator<T> r4 = r2.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            IBannerComponent.a r5 = (IBannerComponent.a) r4.next();
            int r6 = r3.m;
            r5.a(r0);
            goto L6
        L8:
            this.a.m = r0;
            return;
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
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseBannerComponent a;

        public b(BaseBannerComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseBannerComponent r0 = this.a;     // Catch: Throwable -> L7
            int r1 = BaseBannerComponent.p;     // Catch: Throwable -> L7
            List<IBannerComponent.a> r2 = r0.F0();     // Catch: Throwable -> L7
            BaseBannerComponent r3 = this.a;     // Catch: Throwable -> L7
            Iterator<T> r4 = r2.iterator();     // Catch: Throwable -> L7
        L4:
            if (r4.hasNext() == false) goto L16;
            ((IBannerComponent.a) r4.next()).b(r3.E0().getHeight());     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void a() {
        this.a.E0().post(new a(this.a));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void b() {
        BaseBannerComponent r0 = this.a;
        int r1 = BaseBannerComponent.p;
        Iterator<T> r2 = r0.F0().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((IBannerComponent.a) r2.next()).c();
        goto L4
    L6:
        this.a.m = 0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void onShow() {
        this.a.E0().post(new b(this.a));
    }

    public f(BaseBannerComponent r1) {
        this.a = r1;
    }
}
