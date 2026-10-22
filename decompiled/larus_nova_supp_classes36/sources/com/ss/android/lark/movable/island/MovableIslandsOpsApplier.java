package com.ss.android.lark.movable.island;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MovableIslandsOpsApplier {
    public static final /* synthetic */ int c = 0;
    public final MovableView a;
    public final jsb.b b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/movable/island/MovableIslandsOpsApplier$Op;", "", "v", "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "Insert", "Delete", "Update", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Op extends Enum<Op> {
        public static final Op Delete = null;
        public static final Op Insert = null;
        public static final Op Update = null;
        public static final /* synthetic */ Op[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int v;

        public static EnumEntries<Op> getEntries() {
            return b;
        }

        static {
            Op r0 = new Op("Insert", 0, 0);
            Insert = r0;
            Op r1 = new Op("Delete", 1, 1);
            Delete = r1;
            Op r3 = new Op("Update", 2, 2);
            Update = r3;
            Op[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Op[] values() {
            return (Op[]) a.clone();
        }

        public final int getV() {
            return this.v;
        }

        public static Op valueOf(String r1) {
            return (Op) r27.a.a(Op.class, r1);
        }

        public Op(String r1, int r2, int r3) {
            super(r1, r2);
            this.v = r3;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.movable.island.MovableIslandsOpsApplier$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0188a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Op.values().length];
                r0[Op.Insert.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[Op.Delete.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[Op.Update.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static List a(byte[] r20, Context r21) {
            Intrinsics.checkNotNullParameter(r21, "context");
            if (r20.length >= 8) goto L5;
            return null;
        L5:
            b r2 = new b(ByteBuffer.wrap(r20));
            long r5 = r2.c();
            if (r5 == 1295139888) goto L10;
            Log.d("MovableIslandsOpsApplier", "islands diff magic mismatch: " + r5);
            return null;
        L10:
            if (r2.b() >= 4) goto L12;
            return null;
        L12:
            int r3 = (int) r2.c();
            Log.d("MovableIslandsOpsApplier", "islands diff opCount=" + r3);
            ArrayList r6 = new ArrayList();
            int r7 = 0;
        L13:
            if (r7 >= r3) goto L50;
            if (r2.b() <= 0) goto L49;
            int r8 = r2.a.get() & 255;
            if (r8 == 0) goto L23;
            if (r8 == 1) goto L22;
            if (r8 == 2) goto L21;
            Op r11 = null;
        L24:
            if (r11 != null) goto L27;
            Log.d("MovableIslandsOpsApplier", "unknown island op: " + r8 + " at index=" + r7);
            goto L49
        L27:
            if (r2.b() < 4) goto L49;
            r2.c();
            int r9 = C0188a.a[r11.ordinal()];
            if (r9 == 1) goto L43;
            if (r9 != 2) goto L32;
            int r10 = MovableIslandsOpsApplier.c;
            if (r2.b() < 4) goto L45;
            jsb.a r12 = new jsb.a((int) r2.c(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        L47:
            if (r12 == null) goto L49;
            r6.add(TuplesKt.to(r11, r12));
        L45:
            r12 = null;
            goto L47
        L32:
            if (r9 != 3) goto L38;
            int r13 = MovableIslandsOpsApplier.c;
            if (r2.b() < 28) goto L45;
            r12 = com.ss.android.lark.movable.utils.b.c(new jsb.a((int) r2.c(), r2.a(), r2.a(), r2.a(), r2.a(), r2.a(), r2.a()), r21);
            goto L47
        L38:
            throw new NoWhenBranchMatchedException();
        L43:
            int r14 = MovableIslandsOpsApplier.c;
            if (r2.b() < 28) goto L45;
            r12 = com.ss.android.lark.movable.utils.b.c(new jsb.a((int) r2.c(), r2.a(), r2.a(), r2.a(), r2.a(), r2.a(), r2.a()), r21);
            goto L47
        L21:
            r11 = Op.Update;
            goto L24
        L22:
            r11 = Op.Delete;
            goto L24
        L23:
            r11 = Op.Insert;
        L49:
            r7 = r7 + 1;
            goto L13
        L50:
            return r6;
        }
    }

    public static final class b {
        public final ByteBuffer a;

        public final float a() {
            return this.a.getFloat();
        }

        public final int b() {
            return this.a.remaining();
        }

        public final long c() {
            return ((long) this.a.getInt()) & 4294967295L;
        }

        public b(ByteBuffer r2) {
            Intrinsics.checkNotNullParameter(r2, "buf");
            this.a = r2;
            r2.order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Op.values().length];
            r0[Op.Insert.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Op.Delete.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Op.Update.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public MovableIslandsOpsApplier(MovableView r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public final void a(MovableView r5, jsb.a r6) {
        ScrollIsland r0 = (ScrollIsland) r5.findViewWithTag(Integer.valueOf(r6.a));
        if (r0 == null) goto L6;
        Log.d("MovableIslandsOpsApplier", "addIsland existed, islandID=" + r6.a);
        r0.a(r6);
        return;
    L6:
        Log.d("MovableIslandsOpsApplier", "addIsland new, islandID=" + r6.a);
        View r1 = LayoutInflater.from(r5.getContext()).inflate(2131563695, r5, false);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.movable.island.ScrollIsland");
        ScrollIsland r2 = (ScrollIsland) r1;
        r2.setTag(Integer.valueOf(r6.a));
        r2.setIslandID(r6.a);
        r2.setParentInfo(r5);
        ViewGroup.MarginLayoutParams r3 = new ViewGroup.MarginLayoutParams((int) r6.d, (int) r6.e);
        r3.leftMargin = (int) r6.b;
        r3.topMargin = (int) r6.c;
        r5.addView(r2, r3);
        r2.a(r6);
        this.b.a(r6, r2);
    }
}
