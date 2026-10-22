package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class q5 {
    public final String a;

    public static final class a extends q5 {
        public final ReviewMode b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.b == ((a) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "EmptyState(reviewMode=" + this.b + ')';
        }

        public a(ReviewMode r2) {
            Intrinsics.checkNotNullParameter(r2, "reviewMode");
            super("empty-state");
            this.b = r2;
        }
    }

    public static final class b extends q5 {
        public final MainView b;
        public final String c;
        public final boolean d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            String r3 = this.e;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Header(mainView=" + this.b + ", dateLabel=" + this.c + ", settlementCompletedToday=" + this.d + ", settlementTimeLabel=" + this.e + ')';
        }

        public b(MainView r2, String r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "mainView");
            Intrinsics.checkNotNullParameter(r3, "dateLabel");
            super("header");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c extends q5 {
        public final List<p5> b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((c) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "ModuleTabs(tabs=" + this.b + ')';
        }

        public c(List<p5> r2) {
            Intrinsics.checkNotNullParameter(r2, "tabs");
            super("module-tabs");
            this.b = r2;
        }
    }

    public static final class d extends q5 {
        public final int b;
        public final List<o5> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "OverviewRow(rowIndex=" + this.b + ", modules=" + this.c + ')';
        }

        public d(int r3, List<o5> r4) {
            Intrinsics.checkNotNullParameter(r4, "modules");
            super("overview-row-" + r3);
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class e extends q5 {
        public final ReviewMode b;
        public final u5 c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SummaryHero(reviewMode=" + this.b + ", stats=" + this.c + ')';
        }

        public e(ReviewMode r2, u5 r3) {
            Intrinsics.checkNotNullParameter(r2, "reviewMode");
            Intrinsics.checkNotNullParameter(r3, "stats");
            super("summary-hero");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f extends q5 {
        public final e4 b;
        public final boolean c;
        public final boolean d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            String r5 = this.e;
            if (r5 != null) goto L13;
            int r6 = 0;
        L15:
            return r4 + r6;
        L13:
            r6 = r5.hashCode();
            goto L15
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "TaskCard(task=" + this.b + ", expanded=" + this.c + ", hasRun=" + this.d + ", launchingTaskId=" + this.e + ')';
        }

        public f(e4 r3, boolean r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "task");
            super("task-card-" + r3.a);
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class g extends q5 {
        public final CocreationTaskFilter b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "TaskEmpty(filter=" + this.b + ", loading=" + this.c + ", loadFailed=" + this.d + ')';
        }

        public g(CocreationTaskFilter r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "filter");
            super("task-empty");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class h extends q5 {
        public final int b;
        public final int c;
        public final CocreationTaskFilter d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.b * 31) + this.c) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "TaskSummary(total=" + this.b + ", run=" + this.c + ", filter=" + this.d + ')';
        }

        public h(int r2, int r3, CocreationTaskFilter r4) {
            Intrinsics.checkNotNullParameter(r4, "filter");
            super("task-summary");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class i extends q5 {
        public final com.obric.assistant.cocreationreview.a b;
        public final a5 c;
        public final boolean d;
        public final List<b5> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.e.hashCode();
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "UsageCard(record=" + this.b + ", feedback=" + this.c + ", readOnly=" + this.d + ", feedbackMedia=" + this.e + ')';
        }

        public i(com.obric.assistant.cocreationreview.a r3, a5 r4, boolean r5, List<b5> r6) {
            Intrinsics.checkNotNullParameter(r3, "record");
            Intrinsics.checkNotNullParameter(r4, "feedback");
            Intrinsics.checkNotNullParameter(r6, "feedbackMedia");
            super("usage-card-" + r3.a());
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public q5(String r1) {
        this.a = r1;
    }
}
