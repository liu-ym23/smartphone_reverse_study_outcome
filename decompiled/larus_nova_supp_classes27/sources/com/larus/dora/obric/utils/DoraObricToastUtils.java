package com.larus.dora.obric.utils;

import android.content.Context;
import com.larus.utils.t0;
import com.obric.oui.toast.f;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraObricToastUtils {
    public static WeakReference<f> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/obric/utils/DoraObricToastUtils$ToastIcon;", "", "drawableRes", "", "tintColorRes", "<init>", "(Ljava/lang/String;IILjava/lang/Integer;)V", "getDrawableRes", "()I", "getTintColorRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Success", "Failure", "Warning", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastIcon extends Enum<ToastIcon> {
        public static final ToastIcon Failure = null;
        public static final ToastIcon Success = null;
        public static final ToastIcon Warning = null;
        public static final /* synthetic */ ToastIcon[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int drawableRes;
        private final Integer tintColorRes;

        public static EnumEntries<ToastIcon> getEntries() {
            return b;
        }

        static {
            ToastIcon r7 = new ToastIcon("Success", 0, 2131244215, null, 2, null);
            Success = r7;
            ToastIcon r0 = new ToastIcon("Failure", 1, 2131244214, null, 2, null);
            Failure = r0;
            ToastIcon r1 = new ToastIcon("Warning", 2, 2131246386, 2131104915);
            Warning = r1;
            ToastIcon[] r2 = {r7, r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static ToastIcon[] values() {
            return (ToastIcon[]) a.clone();
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public final Integer getTintColorRes() {
            return this.tintColorRes;
        }

        public static ToastIcon valueOf(String r1) {
            return (ToastIcon) r27.a.a(ToastIcon.class, r1);
        }

        public ToastIcon(String r1, int r2, int r3, Integer r4) {
            super(r1, r2);
            this.drawableRes = r3;
            this.tintColorRes = r4;
        }

        public /* synthetic */ ToastIcon(String r1, int r2, int r3, Integer r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = null;
        L5:
            this(r1, r2, r3, r4);
        }
    }

    static {
        a = new WeakReference(null);
    }

    public static void d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ToastIcon r0 = ToastIcon.Success;
        c(r2, r2.getString(2131910467), r0);
    }

    public static void a(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ToastIcon r0 = ToastIcon.Failure;
        c(r1, r1.getString(r2), r0);
    }

    public static void b(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        c(r1, r2, ToastIcon.Failure);
    }

    public static void e(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ToastIcon r0 = ToastIcon.Warning;
        c(r1, r1.getString(r2), r0);
    }

    public static void c(final Context r1, final String r2, final ToastIcon r3) {
        t0.e(new d(r1, r2, r3));
    }
}
