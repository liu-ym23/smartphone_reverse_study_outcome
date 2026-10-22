package yub;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {

    /* JADX INFO: renamed from: yub.a$a, reason: collision with other inner class name */
    public static final class C0206a {
        public final String a;
        public final String b;
        public final boolean c;
        public final boolean d;

        public C0206a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0206a) == true) goto L8;
            return false;
        L8:
            C0206a r6 = (C0206a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "AppStateInfo(topProcessName=" + this.a + ", topActivityName=" + this.b + ", isAppFront=" + this.c + ", isProcessFront=" + this.d + ')';
        }

        public /* synthetic */ C0206a(int r2) {
            this("", "", false, false);
        }

        public C0206a(String r2, String r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "topProcessName");
            Intrinsics.checkNotNullParameter(r3, "topActivityName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface b {
        void onActivityCreated(Activity r1);

        void onActivityDestroyed(Activity r1);

        void onActivityPaused(Activity r1);

        void onActivityResumed(Activity r1);

        void onActivitySaveInstanceState(Activity r1, Bundle r2);

        void onActivityStarted(Activity r1);

        void onActivityStopped(Activity r1);
    }

    public interface c {
        void a(C0206a r1, C0206a r2);
    }

    void a(k r1);

    void b(k r1);

    Context getContext();
}
