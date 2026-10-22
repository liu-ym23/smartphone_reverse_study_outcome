package com.obric.aikernel.runtime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5366b;

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, "loraType");
            this.f5365a = r10;
            this.f5366b = r11;
        }

        public final String a() {
            return this.f5366b;
        }

        public final String b() {
            return this.f5365a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f5365a, r11.f5365a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5366b, r11.f5366b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f5365a.hashCode() * 31) + this.f5366b.hashCode();
        }

        public String toString() {
            return "DownloadStatus(packageName=" + this.f5365a + ", loraType=" + this.f5366b + ')';
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5367a;

        public b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "caller");
            this.f5367a = r10;
        }

        public final String a() {
            return this.f5367a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f5367a, ((b) r10).f5367a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f5367a.hashCode();
        }

        public String toString() {
            return "RequestAllBackground(caller=" + this.f5367a + ')';
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5370c;

        public c(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, "loraType");
            Intrinsics.checkNotNullParameter(r12, "caller");
            this.f5368a = r10;
            this.f5369b = r11;
            this.f5370c = r12;
        }

        public final String a() {
            return this.f5370c;
        }

        public final String b() {
            return this.f5369b;
        }

        public final String c() {
            return this.f5368a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f5368a, r11.f5368a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5369b, r11.f5369b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f5370c, r11.f5370c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f5368a.hashCode() * 31) + this.f5369b.hashCode()) * 31) + this.f5370c.hashCode();
        }

        public String toString() {
            return "UpdateTargetBackground(packageName=" + this.f5368a + ", loraType=" + this.f5369b + ", caller=" + this.f5370c + ')';
        }
    }
}
