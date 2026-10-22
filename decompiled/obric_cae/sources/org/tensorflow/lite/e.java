package org.tensorflow.lite;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f9837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f9838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f9839e;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9840a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a[] f9841b = null;

        static {
            a r8 = new a("FROM_APPLICATION_ONLY", 0);
            f9840a = r8;
            f9841b = new a[]{r8, new a("FROM_SYSTEM_ONLY", 1), new a("PREFER_SYSTEM_OVER_APPLICATION", 2)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f9841b.clone();
        }
    }

    public e() {
        this.f9835a = a.f9840a;
        this.f9836b = -1;
        this.f9838d = new ArrayList();
        this.f9839e = new ArrayList();
    }
}
