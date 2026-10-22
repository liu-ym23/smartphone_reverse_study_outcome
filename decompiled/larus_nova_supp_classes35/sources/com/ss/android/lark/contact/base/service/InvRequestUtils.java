package com.ss.android.lark.contact.base.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class InvRequestUtils {
    public static final /* synthetic */ int a = 0;

    public static final class LocalAndServerRequestImpl<T> {
        public final a<T> a;
        public boolean b;
        public boolean c;
        public final InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 d;
        public final InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 e;

        public LocalAndServerRequestImpl(a<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataCallback");
            this.a = r2;
            this.d = new InvRequestUtils$LocalAndServerRequestImpl$localCallback$1(this);
            this.e = new InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1(this);
        }
    }

    public interface a<T> {
        void a(InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 r1);

        void b(boolean r1, T r2);

        void c();

        boolean d(T r1);

        void e(InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 r1);

        void f(ErrorResult r1);

        void onShowLoading();
    }

    static {
    }
}
