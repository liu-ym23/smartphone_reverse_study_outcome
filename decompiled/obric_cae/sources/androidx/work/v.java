package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import j1.b0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AddedAbstractMethod"})
public abstract class v {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a[] f2959a = null;

        static {
            f2959a = new a[]{new a("NOT_APPLIED", 0), new a("APPLIED_IMMEDIATELY", 1), new a("APPLIED_FOR_NEXT_RUN", 2)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f2959a.clone();
        }
    }

    public v() {
    }

    public static b0 c(Context r8) {
        return b0.f(r8);
    }

    public abstract j1.m a();

    public abstract p b(String r8, List r10);
}
