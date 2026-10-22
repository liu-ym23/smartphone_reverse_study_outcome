package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class y implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends y {
        public static final a a = null;

        static {
            a = new a();
        }

        public final String toString() {
            return "LoadForwardSubtitle";
        }

        public a() {
        }
    }

    public static final class b extends y {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.k a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "MarkSubtitle(request=" + this.a + ')';
        }

        public b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.k r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            this.a = r2;
        }
    }

    public static final class c extends y {
        public final MmSubtitleScrollMode a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SwitchScrollMode(" + this.a + ')';
        }

        public c(MmSubtitleScrollMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            this.a = r2;
        }
    }

    public static final class d extends y {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UnmarkSubtitle(markId=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "markId");
            this.a = r2;
        }
    }

    public y() {
    }
}
