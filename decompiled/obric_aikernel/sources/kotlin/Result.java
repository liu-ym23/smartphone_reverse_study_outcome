package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@JvmInline
public final class Result<T> implements Serializable {
    public static final Companion Companion = null;
    private final Object value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @InlineOnly
        @JvmName(name = "failure")
        private final <T> Object failure(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
            return Result.m32constructorimpl(ResultKt.createFailure(r10));
        }

        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object success(T r10) {
            return Result.m32constructorimpl(r10);
        }
    }

    public static final class Failure implements Serializable {

        @JvmField
        public final Throwable exception;

        public Failure(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
            this.exception = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Failure) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.exception, ((Failure) r10).exception) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    static {
        Companion = new Companion(null);
    }

    @PublishedApi
    private /* synthetic */ Result(Object r10) {
        this.value = r10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m31boximpl(Object r10) {
        return new Result(r10);
    }

    @PublishedApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m32constructorimpl(Object r10) {
        return r10;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m33equalsimpl(Object r10, Object r11) {
        if ((r11 instanceof Result) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((Result) r11).m41unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m34equalsimpl0(Object r10, Object r11) {
        return Intrinsics.areEqual(r10, r11);
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m35exceptionOrNullimpl(Object r10) {
        if ((r10 instanceof Failure) == true) goto L7;
        return null;
    L7:
        return ((Failure) r10).exception;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m36getOrNullimpl(Object r10) {
        if (m38isFailureimpl(r10) == false) goto L6;
        return null;
    L6:
        return r10;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m37hashCodeimpl(Object r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.hashCode();
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m38isFailureimpl(Object r10) {
        return r10 instanceof Failure;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m39isSuccessimpl(Object r10) {
        return !(r10 instanceof Failure);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m40toStringimpl(Object r10) {
        if ((r10 instanceof Failure) == false) goto L6;
        return ((Failure) r10).toString();
    L6:
        return "Success(" + r10 + ')';
    }

    public boolean equals(Object r10) {
        return m33equalsimpl(this.value, r10);
    }

    public int hashCode() {
        return m37hashCodeimpl(this.value);
    }

    public String toString() {
        return m40toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m41unboximpl() {
        return this.value;
    }
}
