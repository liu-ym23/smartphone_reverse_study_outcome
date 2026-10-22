package com.ss.android.lark.contact.base.contact_myqrcode;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b<T> {

    public static final class a extends b {
        public final ErrorResult a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Error(error=" + this.a + ')';
        }

        public a(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_ERROR);
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.b$b, reason: collision with other inner class name */
    public static final class C0164b<T> extends b<T> {
        public final T a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0164b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0164b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0164b(z8b.a r1) {
            this.a = r1;
        }
    }

    public b() {
    }
}
