package com.larus.bmhome.bigimg;

import android.content.Context;
import android.view.View;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final View a(List<? extends Pair<Integer, ? extends View>> r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "imageViews");
        List<? extends Pair<Integer, ? extends View>> r8 = r6;
        Iterator<T> r0 = r8.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((Number) ((Pair) r1).getFirst()).intValue() != r7) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        Pair r2 = (Pair) r1;
        if (r2 == null) goto L15;
        View r4 = (View) r2.getSecond();
    L16:
        if (r4 == null) goto L18;
        return r4;
    L18:
        Iterator<T> r5 = r8.iterator();
        if (r5.hasNext() == true) goto L21;
        Object r9 = null;
    L30:
        Pair r10 = (Pair) r9;
        Iterator<T> r11 = r8.iterator();
        if (r11.hasNext() == true) goto L33;
        Object r12 = null;
    L42:
        Pair r13 = (Pair) r12;
        if (r10 == null) goto L51;
        if (r13 == null) goto L51;
        if (Math.abs(r7 - ((Number) r10.getFirst()).intValue()) > Math.abs(r7 - ((Number) r13.getFirst()).intValue())) goto L50;
        return (View) r10.getSecond();
    L50:
        return (View) r13.getSecond();
    L51:
        return null;
    L33:
        r12 = r11.next();
        if (r11.hasNext() == false) goto L42;
        int r14 = ((Number) ((Pair) r12).getFirst()).intValue();
    L37:
        Object r15 = r11.next();
        int r16 = ((Number) ((Pair) r15).getFirst()).intValue();
        if (r14 <= r16) goto L41;
        r12 = r15;
        r14 = r16;
    L41:
        if (r11.hasNext() == true) goto L37;
    L21:
        r9 = r5.next();
        if (r5.hasNext() == false) goto L30;
        int r17 = ((Number) ((Pair) r9).getFirst()).intValue();
    L25:
        Object r18 = r5.next();
        int r19 = ((Number) ((Pair) r18).getFirst()).intValue();
        if (r17 >= r19) goto L29;
        r9 = r18;
        r17 = r19;
    L29:
        if (r5.hasNext() == true) goto L25;
    L15:
        r4 = null;
        goto L16
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public static void e(BigImagePhotoViewerDialog r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
        r3.e(r4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.d("BigImagePhotoViewerDialog", "rect showAnimated error: " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(BigImagePhotoViewerDialog r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
    L7:
        e = move-exception;
        FLogger.a.d("BigImagePhotoViewerDialog", "view show error: " + e);
        return;
    L4:
        if (r3.isShowing() == true) goto L12;
        ((PhotoViewerDialog) r3).b.scrollToPosition(r4);     // Catch: Exception -> L7
        r3.d(r4, false);     // Catch: Exception -> L7
        PhotoViewerDialog.c(r3);     // Catch: Exception -> L7
        return;
    }

    public static BigImageLocalPhotoViewerDialog d(Context r15, List r16, List r17, int r18, uo8.k r19, l1 r20, com.larus.avlink.gallery.view.p1 r21, int r22) {
        if ((r22 & 32) == 0) goto L5;
        boolean r11 = !r17.isEmpty();
    L7:
        if ((r22 & 64) == 0) goto L9;
        l1 r12 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        com.larus.avlink.gallery.view.p1 r3 = null;
    L14:
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "imageViews");
        Intrinsics.checkNotNullParameter(r17, "imageList");
        Intrinsics.checkNotNullParameter(r19, "reportParams");
        if (r18 >= 0) goto L17;
        return null;
    L17:
        if (r18 >= r17.size()) goto L62;
        List r1 = r17;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L23;
        t1 r4 = (t1) r2.next();
        r9.add(new n1(r4.getPath(), r4));
        goto L21
    L23:
        BigImageLocalPhotoViewerDialog r5 = new BigImageLocalPhotoViewerDialog(r15, r9, r19, r11, r12);
        j r6 = new j(r3, r16);
        ((PhotoViewerDialog) r5).m = r6;
        TransitionPagerAdapter r7 = ((PhotoViewerDialog) r5).a;
        r7.d = r6;
        r7.e = 1;
        Iterator r0 = r16.iterator();
    L25:
        if (r0.hasNext() == false) goto L32;
        Object r8 = r0.next();
        if (((Number) ((Pair) r8).getFirst()).intValue() != r18) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L25;
    L33:
        Pair r13 = (Pair) r8;
        if (r13 == null) goto L36;
        View r14 = (View) r13.getSecond();
    L38:
        if (r14 == null) goto L44;
        Intrinsics.checkNotNullParameter(r14, "view");
        Intrinsics.checkNotNullParameter("BigImageLocalPhotoViewerDialog", "tag");
        r5.f(r18, r14);     // Catch: Exception -> L42
    L50:
        return r5;
    L42:
        e = move-exception;
        FLogger.a.d("BigImageLocalPhotoViewerDialog", "view showAnimated error: " + e);
        goto L50
    L44:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
        r5.e(r18, null);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        FLogger.a.d("BigImagePhotoViewerDialog", "rect showAnimated error: " + e);
        goto L50
    L36:
        r14 = null;
        goto L38
    L29:
        r10 = false;
        goto L30
    L32:
        r8 = null;
        goto L33
    L62:
        return null;
    L13:
        r3 = r21;
        goto L14
    L9:
        r12 = r20;
        goto L11
    L5:
        r11 = false;
        goto L7
    }

    public static void b(Context r20, List r21, int r22, uo8.k r23, boolean r24, List r25, List r26, List r27, int r28) {
        int r4 = 0;
        if ((r28 & 128) != 0) goto L5;
        boolean r7 = r24;
    L11:
        if ((r28 & 256) == 0) goto L13;
        List r10 = null;
    L15:
        if ((r28 & 512) == 0) goto L17;
        List r11 = null;
    L19:
        if ((r28 & 1024) == 0) goto L21;
        List r12 = null;
    L22:
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "imageUrls");
        Intrinsics.checkNotNullParameter(r23, "reportParams");
        if (r22 >= 0) goto L25;
        return;
    L25:
        if (r22 >= r21.size()) goto L40;
        List r0 = r21;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L29:
        if (r1.hasNext() == false) goto L34;
        Object r2 = r1.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r3 = (String) r2;
        r5.add(new n1(r3, r3));
        r4 = r8;
        goto L29
    L34:
        BigImagePhotoViewerDialog r6 = new BigImagePhotoViewerDialog(r20, r5, null, r23, r7, null, null, r10, r11, r12, null, false, false, false, 30752);
        ((PhotoViewerDialog) r6).a.e = 1;
        e(r6, r22);
        return;
    L40:
        return;
    L21:
        r12 = r27;
        goto L22
    L17:
        r11 = r26;
        goto L19
    L13:
        r10 = r25;
        goto L15
    L5:
        if (r21.size() <= 1) goto L7;
        boolean r9 = true;
    L8:
        r7 = r9;
        goto L11
    L7:
        r9 = false;
        goto L8
    }

    public static void c(Context r24, List r25, List r26, int r27, uo8.k r28, boolean r29, HybridEventParams r30, String r31, boolean r32, Function1 r33, Function1 r34, Function1 r35, qh8.j r36, int r37) {
        if ((r37 & 32) != 0) goto L5;
        boolean r12 = r29;
    L10:
        View r23 = null;
        if ((r37 & 64) == 0) goto L13;
        HybridEventParams r13 = null;
    L15:
        if ((r37 & 128) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r37 & 512) == 0) goto L21;
        boolean r20 = true;
    L23:
        if ((r37 & 1024) == 0) goto L25;
        Function1 r4 = null;
    L27:
        if ((r37 & 2048) == 0) goto L29;
        Function1 r15 = null;
    L31:
        if ((r37 & 4096) == 0) goto L33;
        Function1 r11 = null;
    L35:
        if ((r37 & 8192) == 0) goto L37;
        qh8.j r3 = null;
    L38:
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "imageViews");
        Intrinsics.checkNotNullParameter(r26, "imageList");
        Intrinsics.checkNotNullParameter(r28, "reportParams");
        if (r27 >= 0) goto L41;
        return;
    L41:
        if (r27 >= r26.size()) goto L90;
        List r7 = r26;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r6 = r7.iterator();
    L45:
        if (r6.hasNext() == false) goto L52;
        l r5 = (l) r6.next();
        Iterator r38 = r6;
        if (r3 == null) goto L50;
        String r8 = (String) r3.invoke(r5.b);
        if (r8 == null) goto L50;
    L51:
        r9.add(new n1(r8));
        r6 = r38;
    L50:
        r8 = r5.b;
        goto L51
    L52:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r16 = r7.iterator();
    L54:
        if (r16.hasNext() == false) goto L56;
        r10.add(((l) r16.next()).d);
        goto L54
    L56:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r18 = r7.iterator();
    L58:
        if (r18.hasNext() == false) goto L60;
        r17.add(((l) r18.next()).j);
        goto L58
    L60:
        BigImagePhotoViewerDialog r19 = new BigImagePhotoViewerDialog(r24, r9, r10, r28, r12, r13, r14, null, null, null, r17, false, r20, false, 22272);
        r19.L0 = r11;
        h r21 = new h(r4, r25, r15);
        ((PhotoViewerDialog) r19).m = r21;
        ((PhotoViewerDialog) r19).a.d = r21;
        r19.k0 = new i(r26);
        Iterator r0 = r25.iterator();
    L62:
        if (r0.hasNext() == false) goto L69;
        Object r1 = r0.next();
        int r22 = r27;
        if (((Number) ((Pair) r1).getFirst()).intValue() != r22) goto L66;
        boolean r2 = true;
    L67:
        if (r2 == false) goto L62;
    L70:
        Pair r39 = (Pair) r1;
        if (r39 == null) goto L73;
        r23 = (View) r39.getSecond();
    L73:
        View r40 = r23;
        if (r40 == null) goto L76;
        r19.v(r22, r40, "BigImagePhotoViewerDialog");
        return;
    L76:
        f(r19, r22);
        return;
    L66:
        r2 = false;
        goto L67
    L69:
        r22 = r27;
        r1 = null;
        goto L70
    L90:
        return;
    L37:
        r3 = r36;
        goto L38
    L33:
        r11 = r35;
        goto L35
    L29:
        r15 = r34;
        goto L31
    L25:
        r4 = r33;
        goto L27
    L21:
        r20 = r32;
        goto L23
    L17:
        r14 = r31;
        goto L19
    L13:
        r13 = r30;
        goto L15
    L5:
        if (r26.size() <= 1) goto L7;
        boolean r41 = true;
    L8:
        r12 = r41;
        goto L10
    L7:
        r41 = false;
        goto L8
    }
}
