package com.obric.aikernel.api.security;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4470a;

        public a(long r10) {
            super(null);
            this.f4470a = r10;
        }

        public final long a() {
            return this.f4470a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f4470a == ((a) r10).f4470a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f4470a);
        }

        public String toString() {
            return "DelayRetry(delayMs=" + this.f4470a + ')';
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4471a;

        public b(long r10) {
            super(null);
            this.f4471a = r10;
        }

        public final long a() {
            return this.f4471a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f4471a == ((b) r10).f4471a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f4471a);
        }

        public String toString() {
            return "OpenCircuit(cooldownMs=" + this.f4471a + ')';
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4472a = null;

        static {
            f4472a = new c();
        }

        private c() {
            super(null);
        }
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker r10) {
        this();
    }
}
