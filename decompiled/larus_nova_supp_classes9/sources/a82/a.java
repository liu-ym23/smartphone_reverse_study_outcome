package a82;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends g<b, Object> {
    public final c82.a a;

    /* JADX INFO: renamed from: a82.a$a, reason: collision with other inner class name */
    public static final class C0000a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"La82/a$b;", BuildConfig.FLAVOR, "La82/a$b$a;", "args", "La82/a$b$a;", "a", "()La82/a$b$a;", "setArgs", "(La82/a$b$a;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("args")
        private C0001a args;

        /* JADX INFO: renamed from: a82.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"La82/a$b$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, sz1.a.KEY_WIDTH, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", sz1.a.KEY_HEIGHT, "a", "setHeight", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0001a {

            @SerializedName(sz1.a.KEY_HEIGHT)
            private Integer height;

            @SerializedName(sz1.a.KEY_WIDTH)
            private Integer width;

            public final String toString() {
                return "Args(width=" + this.width + ", height=" + this.height + ')';
            }

            public C0001a() {
                this.width = 0;
                this.height = 0;
            }

            public final Integer a() {
                return this.height;
            }

            public final Integer b() {
                return this.width;
            }
        }

        public b() {
        }

        public final String toString() {
            return "Params(args=" + this.args + ')';
        }

        public final C0001a a() {
            return this.args;
        }
    }

    static {
    }

    public a(c82.a r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        this.a = r2;
    }

    public final Object invoke(Object r3, CallContext r4) {
        b r5 = (b) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        b.C0001a r6 = r5.a();
        if (r6 != null) goto L5;
        int r7 = b82.a.a;
        b82.a.a("JSB_ERROR,  null args: " + r5, null);
    L12:
        return null;
    L5:
        Integer r8 = r6.b();
        Integer r1 = r6.a();
        if (r8 == null) goto L11;
        if (r1 == null) goto L11;
        c82.a r9 = this.a;
        int r10 = r8.intValue();
        int r2 = r1.intValue();
        Function2<Integer, Integer, Unit> r11 = r9.c;
        if (r11 == null) goto L12;
        Unit r13 = (Unit) r11.invoke(Integer.valueOf(r10), Integer.valueOf(r2));
    L11:
        int r14 = b82.a.a;
        b82.a.a("JSB_ERROR, null args : " + r6, null);
        goto L12
    }
}
