package com.larus.suggest.impl.wcb.request;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface e {

    public static final class a implements e {
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

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return null;
        }

        public final int hashCode() {
            return 968727568;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements e {
        public final com.larus.suggest.impl.repo.a.C0035a a;
        public final NexPulseResponseData b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            NexPulseResponseData r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(error=" + this.a + ", response=" + this.b + ')';
        }

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return this.b;
        }

        public b(com.larus.suggest.impl.repo.a.C0035a r2, NexPulseResponseData r3) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements e {
        public final NexPulseResponseData a;

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
            return "Success(response=" + this.a + ')';
        }

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return this.a;
        }

        public c(NexPulseResponseData r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    NexPulseResponseData getResponse();
}
