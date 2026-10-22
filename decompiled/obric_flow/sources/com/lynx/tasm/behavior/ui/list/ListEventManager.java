package com.lynx.tasm.behavior.ui.list;

import ai.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.r;
import en.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import pm.a;

/* JADX INFO: loaded from: classes2.dex */
public class ListEventManager extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f10503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f10504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10505c;
    public final UIList d;
    public int e;
    public boolean f;

    public ListEventManager(r r5, l r10, UIList r11) {
        this.f10505c = 0;
        this.e = 0;
        this.f = false;
        this.f10503a = r5;
        this.f10504b = r10;
        r10.addOnScrollListener(this);
        this.d = r11;
    }

    public static int a(a r5, int r10) {
        ReadableType r11 = r5.getType();
        if (r11 != ReadableType.String) goto L9;
        return Integer.parseInt(r5.asString());
    L6:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r10;
    L9:
        if (r11 == ReadableType.Int) goto L17;
        if (r11 == ReadableType.Number) goto L17;
        if (r11 != ReadableType.Long) goto L15;
    L17:
        return r5.asInt();
    }

    public static boolean c(a r5, boolean r10) {
        if (r5 == null) goto L19;
        ReadableType r11 = r5.getType();
        if (r11 != ReadableType.String) goto L9;
        return Boolean.parseBoolean(r5.asString());
    L9:
        if (r11 == ReadableType.Int) goto L21;
        if (r11 == ReadableType.Number) goto L21;
        if (r11 == ReadableType.Long) goto L21;
        if (r11 != ReadableType.Boolean) goto L19;
        return r5.asBoolean();
    L21:
        if (r5.asInt() == 0) goto L24;
        return true;
    L24:
        return false;
    L19:
        return r10;
    }

    public final JavaOnlyArray b() {
        JavaOnlyArray r5 = new JavaOnlyArray();
        ArrayList r10 = new ArrayList();
        l r11 = this.f10504b;
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r13 = (LinearLayoutManager) r12;
        int r14 = r13.findFirstVisibleItemPosition();
        int r15 = r13.findLastVisibleItemPosition();
    L5:
        if (r14 > r15) goto L19;
        r14 = j0.d(r14, r10, r14, 1);
    L19:
        Iterator r16 = r10.iterator();
    L21:
        if (r16.hasNext() == false) goto L27;
        if (r11.findViewHolderForLayoutPosition(((Integer) r16.next()).intValue()) == null) goto L21;
        throw new ClassCastException();
    L27:
        return r5;
    L8:
        if ((r12 instanceof StaggeredGridLayoutManager) == false) goto L19;
        StaggeredGridLayoutManager r17 = (StaggeredGridLayoutManager) r12;
        int[] r18 = r17.findFirstVisibleItemPositions(null);
        int[] r19 = r17.findLastVisibleItemPositions(null);
        int r20 = r18.length;
        int r21 = 0;
        int r22 = Integer.MIN_VALUE;
        int r23 = 0;
    L10:
        if (r23 >= r20) goto L12;
        int r24 = r18[r23];
        r10.add(Integer.valueOf(r24));
        r22 = Math.max(r22, r24);
        r23 = r23 + 1;
        goto L10
    L12:
        int r25 = r19.length;
        int r26 = Integer.MAX_VALUE;
    L13:
        if (r21 >= r25) goto L15;
        int r27 = r19[r21];
        r10.add(Integer.valueOf(r27));
        r26 = Math.min(r26, r27);
        r21 = r21 + 1;
        goto L13
    L15:
        int r28 = r22 + 1;
    L16:
        if (r28 >= r26) goto L18;
        r28 = j0.d(r28, r10, r28, 1);
        goto L16
    L18:
        Collections.sort(r10);
        goto L19
    }
}
