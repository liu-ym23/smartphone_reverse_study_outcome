package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import android.os.Handler;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DrawerFeedPreviewHelper {
    public int[] a;
    public RecyclerView b;
    public Disposable c;
    public final c d;
    public final a e;

    public static final class a implements Runnable {
        public final /* synthetic */ DrawerFeedPreviewHelper a;

        public a(DrawerFeedPreviewHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DrawerFeedPreviewHelper a;
        public final /* synthetic */ RecyclerView b;

        public b(DrawerFeedPreviewHelper r1, RecyclerView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            uv1.a r7 = (uv1.a) r6;
            String r0 = (String) xv1.b.a().get("play_type");
            if (r0 == null) goto L5;
            int r1 = CastIntegerProtector.parseInt(r0);
        L7:
            if (r1 != 1) goto L9;
            DrawerFeedPreviewHelper r2 = this.a;
            int[] r3 = r2.a;
            if (r3 != null) goto L24;
            r2.d();
            return;
        L24:
            if (r7.b > ArraysKt.last(r3)) goto L48;
            RecyclerView r4 = this.a.b;
            RecyclerView.LayoutManager r5 = null;
            if (r4 == null) goto L29;
            RecyclerView.LayoutManager r8 = r4.getLayoutManager();
        L31:
            if ((r8 instanceof GridLayoutManager) == false) goto L34;
            r5 = r8;
        L34:
            GridLayoutManager r9 = (GridLayoutManager) r5;
            if (r9 == null) goto L49;
            int r10 = r9.getSpanSizeLookup().getSpanIndex(r7.b, r9.getSpanCount());
            RecyclerView r11 = this.a.b;
            if (r11 == null) goto L45;
            r11.postDelayed(new com.bytedance.android.livesdk.feed.drawerfeed.autoplay.a(this, r10, r7), 300);
            return;
        L45:
            return;
        L49:
            return;
        L29:
            r8 = null;
            goto L31
        L48:
            return;
        L9:
            if (r1 != 2) goto L46;
            DrawerFeedPreviewHelper r12 = this.a;
            int[] r13 = r12.a;
            if (r13 != null) goto L15;
            r12.d();
            return;
        L15:
            if (r7.b > ArraysKt.last(r13)) goto L47;
            RecyclerView r14 = this.a.b;
            if (r14 == null) goto L42;
            r14.postDelayed(new com.bytedance.android.livesdk.feed.drawerfeed.autoplay.b(this), 300);
            return;
        L42:
            return;
        L47:
            return;
        L46:
            return;
        L5:
            r1 = 0;
            goto L7
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DrawerFeedPreviewHelper a;

        public c(DrawerFeedPreviewHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int a() {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L5;
        return -1;
    L5:
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        if ((r2 instanceof GridLayoutManager) == true) goto L8;
        r2 = null;
    L8:
        GridLayoutManager r3 = (GridLayoutManager) r2;
        if (r3 != null) goto L11;
        return -1;
    L11:
        int r4 = r3.findFirstCompletelyVisibleItemPosition();
        int r5 = r3.findLastCompletelyVisibleItemPosition();
        if (r4 == (-1)) goto L20;
        if (r5 == (-1)) goto L20;
    L16:
        if ((r0.findViewHolderForAdapterPosition(r4) instanceof an2.a) == true) goto L19;
        if (r4 > r5) goto L19;
        r4 = r4 + 1;
    L19:
        return r4;
    L20:
        return -1;
    }

    public final void c() {
        int[] r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0 == null) goto L20;
        int r2 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        int r4 = r0[r3];
        RecyclerView r5 = this.b;
        if (r5 == null) goto L12;
        RecyclerView.ViewHolder r6 = r5.findViewHolderForAdapterPosition(r4);
    L14:
        if ((r6 instanceof an2.a) == true) goto L16;
        r6 = null;
    L16:
        an2.a r7 = (an2.a) r6;
        if (r7 == null) goto L19;
        r7.reset();
    L19:
        r3 = r3 + 1;
        goto L8
    L12:
        r6 = null;
    L20:
        this.a = null;
    }

    public DrawerFeedPreviewHelper() {
        this.d = new c(this);
        this.e = new a(this);
    }

    public final void d() {
        if ((!xv1.b.a().isEmpty()) == true) goto L5;
        return;
    L5:
        RecyclerView r0 = this.b;
        if (r0 != null) goto L8;
        return;
    L8:
        int r2 = a();
        int r3 = 0;
        if (r2 >= 0) goto L11;
        int[] r4 = new int[0];
    L53:
        if (r4.length != 0) goto L55;
        boolean r5 = true;
    L56:
        if (r5 == false) goto L58;
        return;
    L58:
        int[] r6 = this.a;
        if (r6 != null) goto L61;
    L62:
        int[] r7 = this.a;
        if (r7 == null) goto L73;
        int r8 = r7.length;
        int r9 = 0;
    L65:
        if (r9 >= r8) goto L73;
        RecyclerView.ViewHolder r10 = r0.findViewHolderForAdapterPosition(r7[r9]);
        if ((r10 instanceof an2.a) == true) goto L69;
        r10 = null;
    L69:
        an2.a r11 = (an2.a) r10;
        if (r11 == null) goto L72;
        r11.reset();
    L72:
        r9 = r9 + 1;
    L73:
        int r12 = r4.length;
        int r13 = 0;
    L74:
        if (r3 >= r12) goto L84;
        RecyclerView.ViewHolder r14 = r0.findViewHolderForAdapterPosition(r4[r3]);
        if ((r14 instanceof an2.a) == true) goto L78;
        r14 = null;
    L78:
        an2.a r15 = (an2.a) r14;
        if (r15 == null) goto L83;
        if (r15.t7() == false) goto L83;
        r15.play();
        r13 = r13 + 1;
    L83:
        r3 = r3 + 1;
        goto L74
    L84:
        r4.toString();
        if (r13 <= 0) goto L94;
        Handler r1 = i0.c();
        a r16 = this.e;
        if ((true ^ xv1.b.a().isEmpty()) == false) goto L92;
        String r17 = (String) xv1.b.a().get("play_duration");
        if (r17 == null) goto L91;
        long r18 = CastLongProtector.parseLong(r17);
    L93:
        r1.postDelayed(r16, r18);
        goto L94
    L91:
        r18 = 5000;
        goto L93
    L92:
        r18 = -1;
    L94:
        this.a = r4;
        return;
    L61:
        if (Arrays.equals(r6, r4) != true) goto L62;
        return;
    L55:
        r5 = false;
        goto L56
    L11:
        String r19 = (String) xv1.b.a().get("play_type");
        if (r19 == null) goto L14;
        int r20 = CastIntegerProtector.parseInt(r19);
    L16:
        if (r20 == 1) goto L21;
        if (r20 == 2) goto L19;
        r4 = new int[0];
        goto L53
    L19:
        int[] r21 = {r2, r2 + 1};
    L20:
        r4 = r21;
        goto L53
    L21:
        r21 = new int[1];
        RecyclerView r22 = this.b;
        if (r22 == null) goto L24;
        RecyclerView.LayoutManager r23 = r22.getLayoutManager();
    L26:
        if ((r23 instanceof GridLayoutManager) == true) goto L28;
        r23 = null;
    L28:
        GridLayoutManager r24 = (GridLayoutManager) r23;
        if (r24 == null) goto L50;
        GridLayoutManager.SpanSizeLookup r25 = r24.getSpanSizeLookup();
        if (r25 == null) goto L34;
        Integer r26 = Integer.valueOf(r25.getSpanGroupIndex(r2, r24.getSpanCount()));
    L35:
        if (r26 == null) goto L50;
        r26.intValue();
        RecyclerView r27 = this.b;
        if (r27 == null) goto L43;
        RecyclerView.Adapter r28 = r27.getAdapter();
        if (r28 == null) goto L43;
        if (r28.getItemViewType(0) != 2131566007) goto L43;
        boolean r29 = true;
    L44:
        if (r29 == false) goto L47;
        r26 = Integer.valueOf(r26.intValue() - 1);
    L47:
        if ((r26.intValue() % 2) == 0) goto L51;
        r2 = r2 + 1;
    L51:
        r21[0] = r2;
    L43:
        r29 = false;
        goto L44
    L34:
        r26 = null;
    L50:
        r2 = 0;
        goto L51
    L24:
        r23 = null;
        goto L26
    L14:
        r20 = 0;
        goto L16
    }

    public final void b(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        if ((!xv1.b.a().isEmpty()) == true) goto L5;
        return;
    L5:
        this.b = r3;
        r3.addOnScrollListener(new DrawerFeedPreviewHelper$initPreview$1(this));
        this.c = xs2.b.a().b(uv1.a.class).subscribe(new b(this, r3));
    }
}
