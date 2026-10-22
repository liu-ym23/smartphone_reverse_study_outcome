package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.e5;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w20.o7;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a$a, reason: collision with other inner class name */
    public static final class C0127a {
        public final ILinkMicBattleInviteMessage a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof C0127a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((C0127a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBattleInviteMessage r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BattleInviteEvent(inviteMessage=" + this.a + ")";
        }

        public C0127a(ILinkMicBattleInviteMessage r2) {
            Intrinsics.checkNotNullParameter(r2, "inviteMessage");
            this.a = r2;
        }
    }

    public interface b {
        void a(q7 r1);

        void onFailed(Throwable r1);
    }

    public static final class c {
        public final e5 a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            e5 r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BattleReplyEvent(rejectMessage=" + this.a + ")";
        }

        public c(e5 r1) {
            this.a = r1;
        }
    }

    public static final class d {
        public final ILinkMicBizInviteMessage a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((d) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBizInviteMessage r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BizInviteEvent(bizInviteMessage=" + this.a + ")";
        }

        public d(ILinkMicBizInviteMessage r2) {
            Intrinsics.checkNotNullParameter(r2, "bizInviteMessage");
            this.a = r2;
        }
    }

    public static final class e {
        public final ILinkMicBizReplyMessage a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBizReplyMessage r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BizReplyEvent(bizReplyMessage=" + this.a + ")";
        }

        public e(ILinkMicBizReplyMessage r2) {
            Intrinsics.checkNotNullParameter(r2, "bizReplyMessage");
            this.a = r2;
        }
    }

    public static final class f {
        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof f) == false) goto L8;
            ((f) r2).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L13;
            return false;
        L13:
            return true;
        L8:
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "BizReplyResponseEvent(bizReplyParams=null)";
        }
    }

    public static final class g {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r2, c21.e r3, MultiPKLauncher.c r4, Map r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            r2.a(r3, r4, r5);
        }
    }

    void a(c21.e r1, c21.d r2, Map<String, String> r3);

    void b(c21.b r1, c21.a r2);

    void c(c21.g r1);

    void d(long r1, aa r3);

    MutableLiveData e();

    MutableLiveData f();

    MutableLiveData g();

    MutableLiveData h();

    void i(c21.i r1, b r2);

    MutableLiveData j();

    void k(c21.k r1);

    MutableLiveData l();

    void m(o7 r1, com.bytedance.android.live.revlink.impl.jsb.a r2);

    void n();

    void o(c21.j r1, b r2);

    boolean p();
}
