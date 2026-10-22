package com.obric.assistant.util;

import android.view.View;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n1 implements View.OnLayoutChangeListener {
    public final Function1<Integer, Unit> a;
    public final Function0<Long> b;
    public final Function0<Boolean> c;
    public final long d;
    public final Function1<Integer, Integer> e;
    public int f;
    public long g;
    public final LruCache<String, Integer> h;

    public static boolean c(RecyclerView r2) {
        if (r2.getWidth() > 0) goto L5;
    L13:
        return true;
    L5:
        if (r2.getHeight() <= 0) goto L13;
        RecyclerView.Adapter r0 = r2.getAdapter();
        if (r0 == null) goto L9;
        int r1 = r0.getItemCount();
    L10:
        if (r1 > 0) goto L12;
        return false;
    L12:
        if (r2.getChildCount() == 0) goto L13;
        return false;
    L9:
        r1 = 0;
        goto L10
    }

    public final void b(RecyclerView r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L6;
        return;
    L6:
        if (((Number) this.b.invoke()).longValue() != Long.MAX_VALUE) goto L8;
        return;
    L8:
        long r8 = ((Number) this.b.invoke()).longValue();
        if (r8 != Long.MAX_VALUE) goto L11;
        return;
    L11:
        long r6 = System.currentTimeMillis();
        if (c(r12) == false) goto L14;
        return;
    L14:
        a(r12, r6, r8, true);
    }

    public final void a(RecyclerView r14, long r15, long r17, boolean r19) {
        wq8.b r1 = r14.getAdapter();
        if ((r1 instanceof wq8.b) == false) goto L5;
        wq8.b r2 = r1;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        RecyclerView.LayoutManager r3 = r14.getLayoutManager();
        if (r3 != null) goto L11;
        return;
    L11:
        Iterator r4 = r2.getCurrentList().iterator();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L13:
        if (r4.hasNext() == false) goto L44;
        Object r8 = r4.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        Message r10 = (Message) r8;
        if (r10.getCreateTime() < r17) goto L43;
        if (r10.getContentType() == 1002) goto L43;
        View r11 = r3.findViewByPosition(r6);
        String r12 = "";
        if (r11 != null) goto L31;
        LruCache<String, Integer> r13 = this.h;
        String r16 = r10.getLocalMessageId();
        if (r16 == null) goto L27;
        r12 = r16;
    L27:
        Integer r18 = (Integer) r13.get(r12);
        if (r18 == null) goto L30;
        int r20 = r18.intValue();
    L42:
        r7 = r7 + r20;
        goto L43
    L30:
        r20 = i5.f0();
        goto L42
    L31:
        r5 = r3.getTopDecorationHeight(r11);
        int r110 = r3.getBottomDecorationHeight(r11);
        Function1<Integer, Integer> r111 = this.e;
        if (r6 != 0) goto L36;
        if (r110 <= 0) goto L36;
        int r21 = RangesKt.coerceIn(((Number) r111.invoke(Integer.valueOf(r110))).intValue(), 0, r110);
    L37:
        r20 = ((r11.getHeight() + r5) + r110) - r21;
        LruCache<String, Integer> r22 = this.h;
        String r23 = r10.getLocalMessageId();
        if (r23 == null) goto L41;
        r12 = r23;
    L41:
        r22.put(r12, Integer.valueOf(r20));
    L36:
        r21 = 0;
    L43:
        r6 = r9;
        goto L13
    L44:
        if (r5 <= 0) goto L46;
        r7 = (r7 - r5) + i5.b();
    L46:
        if (r19 == false) goto L48;
    L49:
        this.f = r7;
        this.g = r15;
        this.a.invoke(Integer.valueOf(r7));
        return;
    L48:
        if (r7 != this.f) goto L49;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public n1(Function1 r3, Function0 r4, Function0 r5, yha.r r6, int r7) {
        if ((r7 & 8) == 0) goto L5;
        long r0 = 100;
    L6:
        Function1<Integer, Integer> r8 = r6;
        if ((r7 & 16) == 0) goto L9;
        r8 = new m1();
    L9:
        Intrinsics.checkNotNullParameter(r3, "onHeightChanged");
        Intrinsics.checkNotNullParameter(r4, "getFirstMsgCreateTime");
        Intrinsics.checkNotNullParameter(r5, "getMessageListTouched");
        Intrinsics.checkNotNullParameter(r8, "latestMessageExtraBottomInsetProvider");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = r8;
        this.f = -1;
        this.h = new LruCache(30);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if ((r2 instanceof RecyclerView) == false) goto L5;
        RecyclerView r11 = (RecyclerView) r2;
    L6:
        RecyclerView r12 = r11;
        if (r12 != null) goto L10;
        return;
    L10:
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L12;
        return;
    L12:
        long r13 = ((Number) this.b.invoke()).longValue();
        if (r13 != Long.MAX_VALUE) goto L15;
        return;
    L15:
        long r14 = System.currentTimeMillis();
        if ((r14 - this.g) >= this.d) goto L19;
        return;
    L19:
        if (c(r12) == false) goto L21;
        return;
    L21:
        a(r12, r14, r13, false);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
