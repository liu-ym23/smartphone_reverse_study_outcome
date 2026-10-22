package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements c0.a {
    public final WeakReference<a> a;
    public final w4b.c0 b;
    public final C0081f c;
    public final d d;
    public final b e;
    public final e f;

    public interface a {
        void onFileDownloadFail();

        void onSwitchToCellularDataNetwork(boolean r1);

        com.ss.android.lark.chatbase.l<f5b.b> stream();
    }

    public static final class b implements aqb.b {
        public final /* synthetic */ f a;

        public final void a() {
            a r0 = this.a.a.get();
            if (r0 == null) goto L6;
            r0.onSwitchToCellularDataNetwork(true);
            return;
        }

        public final void b() {
            a r0 = this.a.a.get();
            if (r0 == null) goto L6;
            r0.onFileDownloadFail();
            return;
        }

        public final void c() {
            a r0 = this.a.a.get();
            if (r0 == null) goto L6;
            r0.onSwitchToCellularDataNetwork(false);
            return;
        }

        public b(f r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements aqb.g {
        public final /* synthetic */ f a;

        public d(f r1) {
            this.a = r1;
        }

        public final void onPushUploadProgress(String r2, int r3) {
            a r0 = this.a.a.get();
            if (r0 == null) goto L10;
            com.ss.android.lark.chatbase.l<f5b.b> r1 = r0.stream();
            if (r1 == null) goto L11;
            Intrinsics.checkNotNull(r2);
            com.ss.android.lark.chatbase.l<f5b.b> r4 = r1.query(r2);
            if (r4 == null) goto L12;
            r4.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.f(r3));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class e implements j5b.a {
        public final /* synthetic */ f a;

        public e(f r1) {
            this.a = r1;
        }

        @Override // j5b.a
        public final void a(String r2, int r3) {
            a r0 = this.a.a.get();
            if (r0 == null) goto L10;
            com.ss.android.lark.chatbase.l<f5b.b> r1 = r0.stream();
            if (r1 == null) goto L11;
            Intrinsics.checkNotNull(r2);
            com.ss.android.lark.chatbase.l<f5b.b> r4 = r1.query(r2);
            if (r4 == null) goto L12;
            r4.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.d(r3));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.push.f$f, reason: collision with other inner class name */
    public static final class C0081f implements aqb.i {
        public C0081f() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().registerSourceMessageRecalledEventListener(this.c);
        ChatCoreModule.a().getDownloadDependency().b(this.e);
        this.b.b(this.d);
        this.b.e();
        this.b.g(this.f);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().unRegisterSourceMessageRecalledEventListener(this.c);
        ChatCoreModule.a().getDownloadDependency().a(this.e);
        this.b.d(this.d);
        this.b.c();
        this.b.a(this.f);
    }

    public f(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = new WeakReference(r3);
        this.b = ChatCoreModule.a().getPushDependency();
        this.c = new C0081f();
        this.d = new d(this);
        this.e = new b(this);
        new c();
        this.f = new e(this);
    }
}
