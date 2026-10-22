package com.larus.bmhome.instruction.core.impl.repo;

import com.larus.bmhome.actionbar.model.x0;
import com.larus.im.internal.delegate.j0;
import com.larus.im.internal.delegate.o0;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final j0 a;

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.repo.a$a, reason: collision with other inner class name */
    @Serializable
    public static final class C0017a {
        public static final b Companion = null;
        public final int a;
        public final String b;
        public final x0 c;

        /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.repo.a$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C0018a implements m0<C0017a> {
            public static final C0018a a = null;
            public static final g2 b = null;

            public C0018a() {
            }

            public final d<?>[] childSerializers() {
                return new d[]{w0.a, kuc.a.d(v2.a), kuc.a.d(x0.a.a)};
            }

            public final f getDescriptor() {
                return b;
            }

            static {
                C0018a r0 = new C0018a();
                a = r0;
                g2 r1 = new g2("com.larus.bmhome.instruction.core.impl.repo.ActionBarConfRepo.ActionBarConfResponseWrapper", r0, 3);
                r1.j("code", true);
                r1.j("msg", true);
                r1.j("data", true);
                b = r1;
            }

            public final d<?>[] typeParametersSerializers() {
                return i2.a;
            }

            public final Object deserialize(e r12) {
                Intrinsics.checkNotNullParameter(r12, "decoder");
                g2 r0 = b;
                c r13 = r12.beginStructure(r0);
                if (r13.decodeSequentially() == false) goto L5;
                int r1 = r13.decodeIntElement(r0, 0);
                String r3 = (String) r13.decodeNullableSerializableElement(r0, 1, v2.a, null);
                x0 r2 = (x0) r13.decodeNullableSerializableElement(r0, 2, x0.a.a, null);
                int r4 = 7;
            L19:
                r13.endStructure(r0);
                return new C0017a(r4, r1, r3, r2);
            L5:
                String r6 = null;
                x0 r7 = null;
                r1 = 0;
                int r5 = 0;
                boolean r8 = true;
            L6:
                if (r8 == false) goto L18;
                int r9 = r13.decodeElementIndex(r0);
                if (r9 != (-1)) goto L9;
                r8 = false;
                goto L6
            L9:
                if (r9 != 0) goto L10;
                r1 = r13.decodeIntElement(r0, 0);
                r5 = r5 | 1;
                goto L6
            L10:
                if (r9 != 1) goto L11;
                r6 = (String) r13.decodeNullableSerializableElement(r0, 1, v2.a, r6);
                r5 = r5 | 2;
                goto L6
            L11:
                if (r9 != 2) goto L14;
                r7 = (x0) r13.decodeNullableSerializableElement(r0, 2, x0.a.a, r7);
                r5 = r5 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r9);
            L18:
                r4 = r5;
                r3 = r6;
                r2 = r7;
                goto L19
            }

            public final void serialize(muc.f r6, Object r7) {
                C0017a r8 = (C0017a) r7;
                Intrinsics.checkNotNullParameter(r6, "encoder");
                Intrinsics.checkNotNullParameter(r8, "value");
                g2 r0 = b;
                muc.d r9 = r6.beginStructure(r0);
                b r1 = C0017a.Companion;
                boolean r2 = false;
                if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
            L7:
                boolean r3 = true;
            L9:
                if (r3 == false) goto L12;
                r9.encodeIntElement(r0, 0, r8.a);
            L12:
                if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
            L16:
                boolean r4 = true;
            L18:
                if (r4 == false) goto L21;
                r9.encodeNullableSerializableElement(r0, 1, v2.a, r8.b);
            L21:
                if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
            L25:
                r2 = true;
            L26:
                if (r2 == false) goto L28;
                r9.encodeNullableSerializableElement(r0, 2, x0.a.a, r8.c);
            L28:
                r9.endStructure(r0);
                return;
            L24:
                if (r8.c == null) goto L26;
            L15:
                if (r8.b != null) goto L16;
                r4 = false;
                goto L18
            L6:
                if (r8.a != 0) goto L7;
                r3 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.repo.a$a$b */
        public static final class b {
            public b() {
            }

            public final d<C0017a> serializer() {
                return C0018a.a;
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0017a) == true) goto L8;
            return false;
        L8:
            C0017a r6 = (C0017a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            x0 r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionBarConfResponseWrapper(code=" + this.a + ", msg=" + this.b + ", data=" + this.c + ')';
        }

        static {
            Companion = new b();
        }

        public C0017a() {
            this.a = 0;
            this.b = null;
            this.c = null;
        }

        public C0017a(int r4, int r5, String r6, x0 r7) {
            if ((r4 & 0) == 0) goto L5;
            b2.b(r4, 0, C0018a.b);
            throw null;
        L5:
            if ((r4 & 1) != 0) goto L7;
            this.a = 0;
        L9:
            if ((r4 & 2) != 0) goto L11;
            this.b = null;
        L13:
            if ((r4 & 4) != 0) goto L15;
            this.c = null;
            return;
        L15:
            this.c = r7;
            return;
        L11:
            this.b = r6;
            goto L13
        L7:
            this.a = r5;
            goto L9
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
        o0 r0 = o0.a;
        this.a = o0.l();
    }

    public static Object a(a r3, Continuation r4) {
        return BuildersKt.withContext(com.flow.kmp.common.thread.c.a("actionbar_api_request"), new ActionBarConfRepo$requestActionBarConfV3$2(r3, null, null, null), r4);
    }
}
