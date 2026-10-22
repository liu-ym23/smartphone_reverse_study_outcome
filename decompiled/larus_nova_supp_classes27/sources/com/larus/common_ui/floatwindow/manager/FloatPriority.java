package com.larus.common_ui.floatwindow.manager;

import e19.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FloatPriority implements g {
    public final int a;
    public final long b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/floatwindow/manager/FloatPriority$Level;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Level {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int HIGH = 1;
        public static final int LOW = -1;
        public static final int MAX = 2;
        public static final int MIN = -2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public final String toString() {
        return "priority:level[" + this.a + "],time[" + this.b + ']';
    }

    public final int hashCode() {
        return this.a;
    }

    public FloatPriority(int r3) {
        this.a = r3;
        this.b = System.currentTimeMillis();
    }

    @Override // java.lang.Comparable
    public final int compareTo(g r2) {
        g r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        if ((r3 instanceof FloatPriority) == false) goto L7;
        return this.a - ((FloatPriority) r3).a;
    L7:
        throw new IllegalArgumentException("only FloatPriority permitted");
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof FloatPriority) == true) goto L5;
        return false;
    L5:
        g r4 = (g) r3;
        Intrinsics.checkNotNullParameter(r4, "other");
        if ((r4 instanceof FloatPriority) == false) goto L12;
        if ((this.a - ((FloatPriority) r4).a) != 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new IllegalArgumentException("only FloatPriority permitted");
    }
}
