package com.ss.android.lark.movable.attatchment;

import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MovableAttachmentApplier {
    public List<? extends IAttachmentBinder> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/MovableAttachmentApplier$Op;", "", "v", "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "Insert", "Delete", "Update", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ss/android/lark/movable/attatchment/MovableAttachmentApplier$parsePropertyToStringMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class d extends TypeToken<Map<String, ? extends Object>> {
        public d() {
        }
    }

    static {
    }

    public MovableAttachmentApplier() {
    }

    public static Map c(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Map r4 = (Map) new Gson().fromJson(r3, new d().getType());     // Catch: Throwable -> L14
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));     // Catch: Throwable -> L14
        Iterator r5 = r4.entrySet().iterator();     // Catch: Throwable -> L14
    L11:
        if (r5.hasNext() == false) goto L21;
        Object r2 = r5.next();     // Catch: Throwable -> L14
        r1.put(((Map.Entry) r2).getKey(), ((Map.Entry) r2).getValue().toString());     // Catch: Throwable -> L14
        goto L11
    L21:
        return r1;
    L14:
        th = move-exception;
        Log.w("MovableAttachApplier", "property json parse error: " + th.getMessage());
        return MapsKt.emptyMap();
    L8:
        return MapsKt.emptyMap();
    L5:
        r0 = false;
        goto L6
    }

    public final void a(MovableView r6, com.ss.android.lark.movable.attatchment.b r7) {
        ViewGroup r0 = (ViewGroup) r6.findViewWithTag(Integer.valueOf(r7.b));
        if ((r0 instanceof com.ss.android.lark.movable.attatchment.d) == false) goto L10;
        ((com.ss.android.lark.movable.attatchment.d) r0).a(r7, this.a);
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r8 == null) goto L9;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r9.width = (int) r7.e;
        r9.height = (int) r7.f;
        r9.leftMargin = (int) r7.c;
        r9.topMargin = (int) r7.d;
        r0.setLayoutParams(r9);
        Log.i("MovableAttachApplier", "find exist attachment viewId=" + r7.b);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        com.ss.android.lark.movable.attatchment.d r1 = new com.ss.android.lark.movable.attatchment.d(r6.getContext(), r6);
        r1.setTag(Integer.valueOf(r7.b));
        r1.a(r7, this.a);
        ViewGroup.MarginLayoutParams r2 = new ViewGroup.MarginLayoutParams((int) r7.e, (int) r7.f);
        r2.leftMargin = (int) r7.c;
        r2.topMargin = (int) r7.d;
        r6.addView(r1, r2);
        Log.i("MovableAttachApplier", "add attachment viewId=" + r7.b + " typeId=" + r7.a);
    }

    public final void b(MovableView r20, byte[] r21) {
        Intrinsics.checkNotNullParameter(r20, "container");
        int r4 = 0;
        int r5 = 1;
        if (r21.length != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L71;
        b r6 = new b(ByteBuffer.wrap(r21));
        long r7 = r6.c();
        if (r7 == 1295139888) goto L12;
        Log.w("MovableAttachApplier", "attachment diff magic mismatch: " + r7);
        return;
    L12:
        int r8 = 4;
        if (r6.b() >= 4) goto L15;
        return;
    L15:
        int r9 = (int) r6.c();
        Log.i("MovableAttachApplier", "attachments diff opCount=" + r9);
    L16:
        if (r4 >= r9) goto L83;
        if (r6.b() <= 0) goto L69;
        int r10 = r6.a.get() & 255;
        if (r10 == 0) goto L26;
        if (r10 == r5) goto L25;
        if (r10 == 2) goto L24;
        Op r11 = null;
    L27:
        if (r11 != null) goto L30;
        Log.w("MovableAttachApplier", "unknown attachment op: " + r10 + " at index=" + r4);
        goto L69
    L30:
        if (r6.b() < r8) goto L69;
        r6.c();
        int r12 = c.a[r11.ordinal()];
        String r13 = "";
        if (r12 == r5) goto L60;
        if (r12 != 2) goto L35;
        int r22 = r9;
        if (r6.b() < r8) goto L70;
        int r14 = (int) r6.c();
        Log.i("MovableAttachApplier", "op delete, viewId: " + r14);
        ViewGroup r15 = (ViewGroup) r20.findViewWithTag(Integer.valueOf(r14));
        if (r15 == null) goto L70;
        r20.removeView(r15);
        Log.i("MovableAttachApplier", "remove attachment viewId=" + r14);
    L70:
        r4 = r4 + 1;
        r9 = r22;
        r5 = 1;
        r8 = 4;
        goto L16
    L35:
        if (r12 != 3) goto L53;
        if (r6.b() < 32) goto L69;
        r6.c();
        int r16 = (int) r6.c();
        int r17 = (int) r6.c();
        float r18 = r6.a();
        float r19 = r6.a();
        float r110 = r6.a();
        float r111 = r6.a();
        r22 = r9;
        int r23 = (int) r6.c();
        if (r23 > 0) goto L42;
    L44:
        com.ss.android.lark.movable.attatchment.b r24 = com.ss.android.lark.movable.utils.b.a(new com.ss.android.lark.movable.attatchment.b(r17, r16, r18, r19, r110, r111, c(r13)), r20.getContext());
        Log.i("MovableAttachApplier", "op update, viewId: " + r16);
        ViewGroup r25 = (ViewGroup) r20.findViewWithTag(Integer.valueOf(r24.b));
        if ((r25 instanceof com.ss.android.lark.movable.attatchment.d) == false) goto L51;
        ((com.ss.android.lark.movable.attatchment.d) r25).a(r24, this.a);
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L50;
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;
        r27.width = (int) r24.e;
        r27.height = (int) r24.f;
        r27.leftMargin = (int) r24.c;
        r27.topMargin = (int) r24.d;
        r25.setLayoutParams(r27);
        Log.i("MovableAttachApplier", "update attachment viewId=" + r24.b);
        goto L70
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L51:
        a(r20, r24);
        goto L70
    L42:
        if (r6.b() < r23) goto L44;
        byte[] r28 = new byte[r23];
        r6.a.get(r28);
        r13 = new String(r28, Charsets.UTF_8);
        goto L44
    L53:
        throw new NoWhenBranchMatchedException();
    L60:
        r22 = r9;
        if (r6.b() < 32) goto L70;
        r6.c();
        int r29 = (int) r6.c();
        int r112 = (int) r6.c();
        float r113 = r6.a();
        float r114 = r6.a();
        float r115 = r6.a();
        float r116 = r6.a();
        int r30 = (int) r6.c();
        if (r30 > 0) goto L66;
    L68:
        com.ss.android.lark.movable.attatchment.b r31 = com.ss.android.lark.movable.utils.b.a(new com.ss.android.lark.movable.attatchment.b(r112, r29, r113, r114, r115, r116, c(r13)), r20.getContext());
        Log.i("MovableAttachApplier", "op insert, viewId: " + r29);
        a(r20, r31);
        goto L70
    L66:
        if (r6.b() < r30) goto L68;
        byte[] r32 = new byte[r30];
        r6.a.get(r32);
        r13 = new String(r32, Charsets.UTF_8);
        goto L68
    L24:
        r11 = Op.Update;
        goto L27
    L25:
        r11 = Op.Delete;
        goto L27
    L26:
        r11 = Op.Insert;
    L69:
        r22 = r9;
        goto L70
    L83:
        return;
    L71:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
