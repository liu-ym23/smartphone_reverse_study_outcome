package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c implements j {

    public static final class a extends c {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "InitData(entity=" + this.a + ')';
        }

        public a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r2) {
            Intrinsics.checkNotNullParameter(r2, "entity");
            this.a = r2;
        }
    }

    public static final class b extends c {
        public final String a;
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "UpdateMarkedSpeaker(clusterId=" + this.a + ", speaker=" + this.b + ')';
        }

        public b(String r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r3) {
            Intrinsics.checkNotNullParameter(r2, "clusterId");
            Intrinsics.checkNotNullParameter(r3, MmEndWindowAvatar.TYPE_SPEAKER);
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.c$c, reason: collision with other inner class name */
    public static final class C0054c extends c {
        public static final C0054c a = null;

        static {
            a = new C0054c();
        }

        public final String toString() {
            return "WebViewLoadComplete";
        }

        public C0054c() {
        }
    }

    public c() {
    }
}
