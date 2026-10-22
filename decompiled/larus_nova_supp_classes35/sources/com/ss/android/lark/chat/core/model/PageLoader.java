package com.ss.android.lark.chat.core.model;

import com.ss.android.lark.chat.core.model.PageLoader.b;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import x4b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class PageLoader<T extends b, PageData> {
    public final Executor a;

    public interface IReceiver<PageData> {

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultType {
            public static final int AFTER = 1;
            public static final int BEFORE = 2;
            public static final int INIT = 0;
        }

        void a(int r1, x4b.a r2);

        void b(Throwable r1);
    }

    public interface a<PageData> {
        void a(x4b.a r1);

        void onError(Throwable r1);
    }

    public static class b {
        public final c a;
        public final int b;

        public b(final int r2, int r3) {
            this.a = new m(r2);
            this.b = r3;
        }

        public b(c r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
        int getPosition();
    }

    public static class d<PageData> implements a<PageData> {
        public final IReceiver<PageData> a;
        public final int b;

        @Override // com.ss.android.lark.chat.core.model.PageLoader.a
        public final void a(x4b.a r3) {
            IReceiver<PageData> r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(this.b, r3);
            return;
        }

        @Override // com.ss.android.lark.chat.core.model.PageLoader.a
        public final void onError(Throwable r2) {
            IReceiver<PageData> r0 = this.a;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }

        public d(IReceiver<PageData> r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public PageLoader(Executor r1) {
        this.a = r1;
    }

    public final void a(Runnable r4) {
        Executor r0 = this.a;
        if (r0 == null) goto L5;
        r0.execute(r4);
        return;
    L5:
        Log.e("PageLoader", new Exception("ExecuteAction, loadExecutor is null"), true);
        r4.run();
    }
}
