package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g9 {

    public static final class a {
        public final Function1<c, Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a = r2;
        }
    }

    public static final class b {
        public final View a;

        public b(View r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public final b a;

        public final h9 a() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362090);
        }

        public final h9 b() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362091);
        }

        public final h9 c() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362092);
        }

        public final h9 d() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362097);
        }

        public final h9 e() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362113);
        }

        public final h9 f() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362118);
        }

        public final h9 g() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362119);
        }

        public final h9 h() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362132);
        }

        public final h9 i() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131362144);
        }

        public final h9 j() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131375415);
        }

        public final h9 k() {
            b r0 = this.a;
            r0.getClass();
            return new h9(r0, 2131387050);
        }

        public c(b r2) {
            Intrinsics.checkNotNullParameter(r2, "finder");
            this.a = r2;
        }
    }

    View root();
}
