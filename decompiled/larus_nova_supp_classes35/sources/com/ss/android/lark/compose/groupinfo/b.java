package com.ss.android.lark.compose.groupinfo;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {

    public static final class a implements b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 2116751936;
        }

        public final String toString() {
            return "Finish";
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.b$b, reason: collision with other inner class name */
    public static final class C0149b implements b {
        public static final C0149b a = null;

        static {
            a = new C0149b();
        }

        public C0149b() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0149b) == true) goto L9;
            return false;
        L9:
            C0149b r4 = (C0149b) r3;
            return true;
        }

        public final int hashCode() {
            return -1686718457;
        }

        public final String toString() {
            return "PickAvatar";
        }
    }

    public static final class c implements b {
        public final Throwable a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowError(error=" + this.a + ')';
        }

        public c(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_ERROR);
            this.a = r2;
        }
    }

    public static final class d implements b {
        public final GroupInfoToast a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowToast(toast=" + this.a + ')';
        }

        public d(GroupInfoToast r2) {
            Intrinsics.checkNotNullParameter(r2, "toast");
            this.a = r2;
        }
    }
}
