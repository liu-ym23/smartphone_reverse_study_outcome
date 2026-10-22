package com.obric.aikernel.service.res;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5517a = null;

        static {
            f5517a = new a();
        }

        private a() {
        }

        public String toString() {
            return "ClearOverride";
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.b$b, reason: collision with other inner class name */
    public static final class C0121b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f5518a;

        public C0121b(e r10) {
            Intrinsics.checkNotNullParameter(r10, "state");
            this.f5518a = r10;
        }

        public final e a() {
            return this.f5518a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0121b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f5518a, ((C0121b) r10).f5518a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f5518a.hashCode();
        }

        public String toString() {
            return "Override(state=" + this.f5518a + ')';
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5519a;

        public c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "reason");
            this.f5519a = r10;
        }

        public final String a() {
            return this.f5519a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f5519a, ((c) r10).f5519a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f5519a.hashCode();
        }

        public String toString() {
            return "TriggerAutoUpdate(reason=" + this.f5519a + ')';
        }
    }
}
