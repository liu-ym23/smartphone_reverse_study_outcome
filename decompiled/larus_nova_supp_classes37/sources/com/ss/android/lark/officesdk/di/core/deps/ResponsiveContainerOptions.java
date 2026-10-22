package com.ss.android.lark.officesdk.di.core.deps;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ResponsiveContainerOptions {
    public final boolean a;
    public final boolean b;
    public final BackgroundStrategy c;
    public final boolean d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/ResponsiveContainerOptions$BackgroundStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FORCE_HIDE", "FORCE_SHOW", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum BackgroundStrategy extends Enum<BackgroundStrategy> {
        public static final BackgroundStrategy DEFAULT = null;
        public static final BackgroundStrategy FORCE_HIDE = null;
        public static final BackgroundStrategy FORCE_SHOW = null;
        public static final /* synthetic */ BackgroundStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BackgroundStrategy> getEntries() {
            return b;
        }

        static {
            BackgroundStrategy r0 = new BackgroundStrategy("DEFAULT", 0);
            DEFAULT = r0;
            BackgroundStrategy r1 = new BackgroundStrategy("FORCE_HIDE", 1);
            FORCE_HIDE = r1;
            BackgroundStrategy r3 = new BackgroundStrategy("FORCE_SHOW", 2);
            FORCE_SHOW = r3;
            BackgroundStrategy[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static BackgroundStrategy[] values() {
            return (BackgroundStrategy[]) a.clone();
        }

        public static BackgroundStrategy valueOf(String r1) {
            return (BackgroundStrategy) r27.a.a(BackgroundStrategy.class, r1);
        }

        public BackgroundStrategy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final BackgroundStrategy a;

        public a() {
            this.a = BackgroundStrategy.DEFAULT;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResponsiveContainerOptions) == true) goto L8;
        return false;
    L8:
        ResponsiveContainerOptions r6 = (ResponsiveContainerOptions) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((r2 + r3) * 31) + this.c.hashCode()) * 31;
        if (this.d == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResponsiveContainerOptions(insetsCompat=" + this.a + ", swipeToDismissEnabled=" + this.b + ", backgroundStrategy=" + this.c + ", enableDynamicBackground=" + this.d + ')';
    }

    public ResponsiveContainerOptions() {
        this(false, true, BackgroundStrategy.DEFAULT, false);
    }

    public ResponsiveContainerOptions(boolean r2, boolean r3, BackgroundStrategy r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "backgroundStrategy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
