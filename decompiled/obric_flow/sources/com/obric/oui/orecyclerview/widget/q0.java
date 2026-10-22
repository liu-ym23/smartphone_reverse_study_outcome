package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f13886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13887c;
    public final List d;
    public int e;
    public int f;
    public p0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13888h;

    public q0(RecyclerView r5) {
        this.f13888h = r5;
        ArrayList r10 = new ArrayList();
        this.f13885a = r10;
        this.f13886b = null;
        this.f13887c = new ArrayList();
        this.d = Collections.unmodifiableList(r10);
        this.e = 2;
        this.f = 2;
    }

    public final void a(x0 r5, boolean r10) {
        RecyclerView.k(r5);
        View r11 = r5.itemView;
        RecyclerView r12 = this.f13888h;
        RecyclerViewAccessibilityDelegate r13 = r12.i0;
        if (r13 == null) goto L9;
        RecyclerViewAccessibilityDelegate.ItemDelegate r14 = r13.f13773b;
        if (r14 == null) goto L7;
        AccessibilityDelegateCompat r15 = (AccessibilityDelegateCompat) r14.f13775b.remove(r11);
    L8:
        ViewCompat.setAccessibilityDelegate(r11, r15);
        goto L9
    L7:
        r15 = null;
    L9:
        if (r10 == false) goto L23;
        ArrayList r16 = r12.f13745n;
        if (r16.size() > 0) goto L21;
        a0 r17 = r12.f13742l;
        if (r17 == null) goto L16;
        r17.onViewRecycled(r5);
    L16:
        if (r12.f13729b0 == null) goto L19;
        r12.f.u(r5);
    L19:
        if (RecyclerView.f13724y0 == false) goto L23;
        Log.d("RecyclerView", "dispatchViewRecycled: " + r5);
        goto L23
    L21:
        r16.get(0).getClass();
        throw new ClassCastException();
    L23:
        r5.mBindingAdapter = null;
        r5.mOwnerRecyclerView = null;
        p0 r18 = b();
        r18.getClass();
        int r19 = r5.getItemViewType();
        ArrayList r20 = r18.a(r19).f13873a;
        if (((o0) r18.f13879a.get(r19)).f13874b > r20.size()) goto L27;
        PoolingContainer.callPoolingContainerOnRelease(r5.itemView);
        return;
    L27:
        if (RecyclerView.f13723x0 == true) goto L29;
    L33:
        r5.resetInternal();
        r20.add(r5);
        return;
    L29:
        if (r20.contains(r5) == false) goto L33;
        throw new IllegalArgumentException("this scrap item already exists");
    }

    public final p0 b() {
        if (this.g != null) goto L6;
        p0 r5 = new p0();
        r5.f13879a = new SparseArray();
        r5.f13880b = 0;
        r5.f13881c = Collections.newSetFromMap(new IdentityHashMap());
        this.g = r5;
        c();
    L6:
        return this.g;
    }

    public final void c() {
        p0 r5 = this.g;
        if (r5 == null) goto L10;
        RecyclerView r10 = this.f13888h;
        a0 r11 = r10.f13742l;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r10.f13753r == false) goto L12;
        r5.f13881c.add(r11);
        return;
    L12:
        return;
    }

    public final void d(a0 r5, boolean r10) {
        p0 r11 = this.g;
        if (r11 == null) goto L15;
        Set r12 = r11.f13881c;
        r12.remove(r5);
        if (r12.size() != 0) goto L18;
        if (r10 == true) goto L19;
        int r13 = 0;
    L8:
        SparseArray r14 = r11.f13879a;
        if (r13 >= r14.size()) goto L20;
        ArrayList r15 = ((o0) r14.get(r14.keyAt(r13))).f13873a;
        int r16 = 0;
    L12:
        if (r16 >= r15.size()) goto L14;
        PoolingContainer.callPoolingContainerOnRelease(((x0) r15.get(r16)).itemView);
        r16 = r16 + 1;
        goto L12
    L14:
        r13 = r13 + 1;
        goto L8
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void e() {
        ArrayList r5 = this.f13887c;
        int r10 = r5.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        f(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        r5.clear();
        if (RecyclerView.C0 == false) goto L13;
        com.airbnb.lottie.parser.moshi.c r11 = this.f13888h.f13727a0;
        int[] r12 = (int[]) r11.d;
        if (r12 == null) goto L10;
        Arrays.fill(r12, -1);
    L10:
        r11.f1315c = 0;
        return;
    }

    public final void f(int r10) {
        if (RecyclerView.f13724y0 == false) goto L5;
        Log.d("RecyclerView", "Recycling cached view at index " + r10);
    L5:
        ArrayList r5 = this.f13887c;
        x0 r11 = (x0) r5.get(r10);
        if (RecyclerView.f13724y0 == false) goto L8;
        Log.d("RecyclerView", "CachedViewHolder to be recycled: " + r11);
    L8:
        a(r11, true);
        r5.remove(r10);
    }

    public final void g(View r5) {
        x0 r10 = RecyclerView.F(r5);
        boolean r11 = r10.isTmpDetached();
        RecyclerView r12 = this.f13888h;
        if (r11 == false) goto L6;
        r12.removeDetachedView(r5, false);
    L6:
        if (r10.isScrap() == false) goto L9;
        r10.unScrap();
    L11:
        h(r10);
        if (r12.H != null) goto L14;
        return;
    L14:
        if (r10.isRecyclable() == true) goto L18;
        r12.H.d(r10);
        return;
    L18:
        return;
    L9:
        if (r10.wasReturnedFromScrap() == false) goto L11;
        r10.clearReturnedFromScrapFlag();
        goto L11
    }

    public final void h(x0 r12) {
        boolean r5 = r12.isScrap();
        boolean r10 = false;
        boolean r11 = true;
        RecyclerView r13 = this.f13888h;
        if (r5 == false) goto L5;
    L79:
        StringBuilder r14 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
        r14.append(r12.isScrap());
        r14.append(" isAttached:");
        if (r12.itemView.getParent() == null) goto L82;
        r10 = true;
    L82:
        r14.append(r10);
        r14.append(r13.t());
        throw new IllegalArgumentException(r14.toString());
    L5:
        if (r12.itemView.getParent() != null) goto L79;
        if (r12.isTmpDetached() == false) goto L10;
        StringBuilder r15 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        r15.append(r12);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r13, r15));
    L10:
        if (r12.shouldIgnore() == true) goto L76;
        boolean r16 = r12.doesTransientStatePreventRecycling();
        a0 r17 = r13.f13742l;
        if (r17 == null) goto L17;
        if (r16 == false) goto L17;
        if (r17.onFailedToRecycleView(r12) == false) goto L17;
        boolean r18 = true;
    L18:
        boolean r19 = RecyclerView.f13723x0;
        ArrayList r20 = this.f13887c;
        if (r19 == true) goto L21;
    L25:
        if (r18 == true) goto L34;
        if (r12.isRecyclable() == true) goto L34;
        if (RecyclerView.f13724y0 == false) goto L32;
        Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + r13.t());
    L32:
        r11 = false;
    L69:
        r13.f.u(r12);
        if (r10 == true) goto L90;
        if (r11 == true) goto L91;
        if (r16 == false) goto L92;
        PoolingContainer.callPoolingContainerOnRelease(r12.itemView);
        r12.mBindingAdapter = null;
        r12.mOwnerRecyclerView = null;
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L34:
        if (this.f > 0) goto L36;
    L64:
        boolean r21 = false;
    L65:
        if (r21 == true) goto L68;
        a(r12, true);
    L67:
        r10 = r21;
        goto L69
    L68:
        r11 = false;
        goto L67
    L36:
        if (r12.hasAnyOfTheFlags(526) == true) goto L64;
        int r22 = r20.size();
        if (r22 < this.f) goto L42;
        if (r22 <= 0) goto L42;
        f(0);
        r22 = r22 - 1;
    L42:
        if (RecyclerView.C0 == false) goto L63;
        if (r22 <= 0) goto L63;
        com.airbnb.lottie.parser.moshi.c r23 = r13.f13727a0;
        int r24 = r12.mPosition;
        if (((int[]) r23.d) == null) goto L52;
        int r25 = r23.f1315c * 2;
        int r26 = 0;
    L47:
        if (r26 >= r25) goto L52;
        if (((int[]) r23.d)[r26] == r24) goto L63;
        r26 = r26 + 2;
    L52:
        int r27 = r22 - 1;
    L53:
        if (r27 < 0) goto L62;
        int r28 = ((x0) r20.get(r27)).mPosition;
        com.airbnb.lottie.parser.moshi.c r29 = r13.f13727a0;
        if (((int[]) r29.d) == null) goto L62;
        int r30 = r29.f1315c * 2;
        int r31 = 0;
    L57:
        if (r31 >= r30) goto L62;
        if (((int[]) r29.d)[r31] == r28) goto L60;
        r31 = r31 + 2;
        goto L57
    L60:
        r27 = r27 - 1;
    L62:
        r22 = r27 + 1;
    L63:
        r20.add(r22, r12);
        r21 = true;
        goto L65
    L21:
        if (r20.contains(r12) == false) goto L25;
        StringBuilder r32 = new StringBuilder("cached view received recycle internal? ");
        r32.append(r12);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r13, r32));
    L17:
        r18 = false;
        goto L18
    L76:
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r13, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
    }

    public final void i(View r5) {
        x0 r10 = RecyclerView.F(r5);
        boolean r11 = r10.hasAnyOfTheFlags(12);
        RecyclerView r12 = this.f13888h;
        if (r11 == true) goto L20;
        if (r10.isUpdated() == false) goto L20;
        g0 r13 = r12.H;
        if (r13 == null) goto L20;
        i r14 = (i) r13;
        if (r10.getUnmodifiedPayloads().isEmpty() == false) goto L20;
        if (r14.g == false) goto L20;
        if (r10.isInvalid() == true) goto L20;
        if (this.f13886b != null) goto L18;
        this.f13886b = new ArrayList();
    L18:
        r10.setScrapContainer(this, true);
        this.f13886b.add(r10);
        return;
    L20:
        if (r10.isInvalid() == true) goto L22;
    L28:
        r10.setScrapContainer(this, false);
        this.f13885a.add(r10);
        return;
    L22:
        if (r10.isRemoved() == true) goto L28;
        if (r12.f13742l.hasStableIds() == true) goto L28;
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r12, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
    }

    public final x0 j(int r28, long r29) {
        int r5 = -1;
        RecyclerView r10 = this.f13888h;
        if (r28 >= 0) goto L5;
    L297:
        StringBuilder r11 = ai.j0.v("Invalid item position ", r28, r28, "(", "). Item count:");
        r11.append(r10.f13729b0.b());
        r11.append(r10.t());
        throw new IndexOutOfBoundsException(r11.toString());
    L5:
        if (r28 >= r10.f13729b0.b()) goto L297;
        u0 r12 = r10.f13729b0;
        if (r12.f == false) goto L39;
        ArrayList r13 = this.f13886b;
        if (r13 == null) goto L35;
        int r14 = r13.size();
        if (r14 == 0) goto L35;
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L22;
        x0 r16 = (x0) this.f13886b.get(r15);
        if (r16.wasReturnedFromScrap() == true) goto L20;
        if (r16.getLayoutPosition() != r28) goto L20;
        r16.addFlags(32);
    L36:
        if (r16 == null) goto L38;
        boolean r17 = true;
    L40:
        ArrayList r18 = this.f13887c;
        ArrayList r19 = this.f13885a;
        if (r16 != null) goto L131;
        int r110 = r19.size();
        int r111 = 0;
    L43:
        if (r111 >= r110) goto L56;
        x0 r112 = (x0) r19.get(r111);
        if (r112.wasReturnedFromScrap() == true) goto L55;
        if (r112.getLayoutPosition() != r28) goto L55;
        if (r112.isInvalid() == true) goto L55;
        if (r12.f == true) goto L54;
        if (r112.isRemoved() == true) goto L55;
    L54:
        r112.addFlags(32);
        r16 = r112;
    L94:
        if (r16 == null) goto L131;
        if (r16.isRemoved() == true) goto L98;
        int r20 = r16.mPosition;
        if (r20 >= 0) goto L108;
    L128:
        StringBuilder r21 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
        r21.append(r16);
        throw new IndexOutOfBoundsException(androidx.room.jarjarred.org.antlr.runtime.a.n(r10, r21));
    L108:
        if (r20 >= r10.f13742l.getItemCount()) goto L128;
        if (r12.f == true) goto L115;
        if (r10.f13742l.getItemViewType(r16.mPosition) == r16.getItemViewType()) goto L115;
    L113:
        boolean r22 = false;
    L119:
        if (r22 == true) goto L127;
        r16.addFlags(4);
        if (r16.isScrap() == false) goto L124;
        r10.removeDetachedView(r16.itemView, false);
        r16.unScrap();
    L126:
        h(r16);
        r16 = null;
        goto L131
    L124:
        if (r16.wasReturnedFromScrap() == false) goto L126;
        r16.clearReturnedFromScrapFlag();
        goto L126
    L127:
        r17 = true;
    L115:
        if (r10.f13742l.hasStableIds() == true) goto L117;
    L118:
        r22 = true;
        goto L119
    L117:
        if (r16.getItemId() != r10.f13742l.getItemId(r16.mPosition)) goto L113;
    L98:
        if (RecyclerView.f13723x0 == true) goto L100;
    L104:
        r22 = r12.f;
        goto L119
    L100:
        if (r12.f == true) goto L104;
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(r10, new StringBuilder("should not receive a removed view unless it is pre layout")));
    L55:
        r111 = r111 + 1;
        goto L43
    L56:
        ArrayList r23 = (ArrayList) r10.e.d;
        int r113 = r23.size();
        int r114 = 0;
    L57:
        if (r114 >= r113) goto L66;
        View r115 = (View) r23.get(r114);
        x0 r116 = RecyclerView.F(r115);
        if (r116.getLayoutPosition() != r28) goto L65;
        if (r116.isInvalid() == true) goto L65;
        if (r116.isRemoved() == true) goto L65;
    L67:
        if (r115 == null) goto L81;
        x0 r24 = RecyclerView.F(r115);
        com.google.common.reflect.w r25 = r10.e;
        int r117 = ((RecyclerView) ((y) r25.f9377c).f13929a).indexOfChild(r115);
        if (r117 < 0) goto L80;
        com.bytedance.crash.upload.l r118 = (com.bytedance.crash.upload.l) r25.f9376b;
        if (r118.e(r117) == false) goto L78;
        r118.b(r117);
        r25.z(r115);
        int r26 = r10.e.u(r115);
        if (r26 == (-1)) goto L75;
        r10.e.m(r26);
        i(r115);
        r24.addFlags(8224);
        r16 = r24;
        goto L94
    L75:
        StringBuilder r27 = new StringBuilder("layout index should not be -1 after unhiding a view:");
        r27.append(r24);
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(r10, r27));
    L78:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r115);
    L80:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r115);
    L81:
        int r30 = r18.size();
        int r31 = 0;
    L82:
        if (r31 >= r30) goto L93;
        r16 = (x0) r18.get(r31);
        if (r16.isInvalid() == true) goto L92;
        if (r16.getLayoutPosition() != r28) goto L92;
        if (r16.isAttachedToTransitionOverlay() == true) goto L92;
        r18.remove(r31);
        if (RecyclerView.f13724y0 == false) goto L94;
        Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + r28 + ") found match in cache: " + r16);
    L92:
        r31 = r31 + 1;
        goto L82
    L93:
        r16 = null;
    L65:
        r114 = r114 + 1;
        goto L57
    L66:
        r115 = null;
    L131:
        if (r16 != null) goto L213;
        int r32 = r10.d.f(r28, 0);
        if (r32 >= 0) goto L135;
    L211:
        StringBuilder r33 = ai.j0.v("Inconsistency detected. Invalid item position ", r28, r32, "(offset:", ").state:");
        r33.append(r12.b());
        r33.append(r10.t());
        throw new IndexOutOfBoundsException(r33.toString());
    L135:
        if (r32 >= r10.f13742l.getItemCount()) goto L211;
        int r34 = r10.f13742l.getItemViewType(r32);
        if (r10.f13742l.hasStableIds() == false) goto L168;
        long r119 = r10.f13742l.getItemId(r32);
        int r120 = r19.size() - 1;
    L139:
        if (r120 < 0) goto L153;
        x0 r35 = (x0) r19.get(r120);
        if (r35.getItemId() != r119) goto L152;
        if (r35.wasReturnedFromScrap() == true) goto L152;
        if (r34 == r35.getItemViewType()) goto L146;
        r19.remove(r120);
        r10.removeDetachedView(r35.itemView, false);
        x0 r36 = RecyclerView.F(r35.itemView);
        r36.mScrapContainer = null;
        r36.mInChangeScrap = false;
        r36.clearReturnedFromScrapFlag();
        h(r36);
        r5 = -1;
        goto L152
    L146:
        r35.addFlags(32);
        if (r35.isRemoved() == true) goto L149;
    L165:
        if (r35 == null) goto L167;
        r35.mPosition = r32;
        r16 = r35;
        r17 = true;
        goto L168
    L167:
        r16 = r35;
        goto L168
    L149:
        if (r12.f == true) goto L165;
        r35.setFlags(2, 14);
    L152:
        r120 = r120 + r5;
        goto L139
    L153:
        int r37 = r18.size() - 1;
    L154:
        if (r37 < 0) goto L163;
        r35 = (x0) r18.get(r37);
        if (r35.getItemId() != r119) goto L164;
        if (r35.isAttachedToTransitionOverlay() == true) goto L164;
        if (r34 != r35.getItemViewType()) goto L162;
        r18.remove(r37);
        goto L165
    L162:
        f(r37);
    L164:
        r37 = r37 - 1;
    L163:
        r35 = null;
    L168:
        if (r16 == null) goto L170;
    L186:
        if (r16 != null) goto L213;
        long r38 = r10.getNanoTime();
        if (r29 == Long.MAX_VALUE) goto L199;
        long r121 = this.g.a(r34).f13875c;
        if (r121 != 0) goto L192;
    L195:
        boolean r39 = true;
    L196:
        if (r39 == true) goto L199;
        return null;
    L192:
        if ((r121 + r38) < r29) goto L195;
        r39 = false;
    L199:
        r16 = r10.f13742l.createViewHolder(r10, r34);
        if (RecyclerView.C0 == false) goto L204;
        RecyclerView r40 = RecyclerView.y(r16.itemView);
        if (r40 == null) goto L204;
        r16.mNestedRecyclerView = new WeakReference(r40);
    L204:
        long r122 = r10.getNanoTime() - r38;
        o0 r41 = this.g.a(r34);
        long r42 = r41.f13875c;
        if (r42 == 0) goto L208;
        r122 = (r122 / 4) + ((r42 / 4) * 3);
    L208:
        r41.f13875c = r122;
        if (RecyclerView.f13724y0 == false) goto L213;
        Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
        goto L213
    L170:
        if (RecyclerView.f13724y0 == false) goto L172;
        Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + r28 + ") fetching from shared pool");
    L172:
        o0 r43 = (o0) b().f13879a.get(r34);
        if (r43 == null) goto L182;
        ArrayList r44 = r43.f13873a;
        if (r44.isEmpty() == true) goto L182;
        int r45 = r44.size() - 1;
    L177:
        if (r45 < 0) goto L182;
        if (((x0) r44.get(r45)).isAttachedToTransitionOverlay() == false) goto L180;
        r45 = r45 - 1;
        goto L177
    L180:
        x0 r46 = (x0) r44.remove(r45);
    L183:
        if (r46 == null) goto L185;
        r46.resetInternal();
        boolean r47 = RecyclerView.f13723x0;
    L185:
        r16 = r46;
    L182:
        r46 = null;
    L213:
        if (r17 == false) goto L222;
        if (r12.f == true) goto L222;
        if (r16.hasAnyOfTheFlags(8192) == false) goto L222;
        r16.setFlags(0, 8192);
        if (r12.f13915i == false) goto L222;
        g0.b(r16);
        g0 r48 = r10.H;
        r16.getUnmodifiedPayloads();
        r48.getClass();
        f0 r49 = new f0();
        r49.a(r16);
        r10.Q(r16, r49);
    L222:
        if (r12.f == false) goto L227;
        if (r16.isBound() == false) goto L227;
        r16.mPreLayoutPosition = r28;
    L233:
        boolean r50 = false;
        boolean r51 = true;
    L283:
        ViewGroup.LayoutParams r52 = r16.itemView.getLayoutParams();
        if (r52 != null) goto L287;
        RecyclerView.LayoutParams r53 = (RecyclerView.LayoutParams) r10.generateDefaultLayoutParams();
        r16.itemView.setLayoutParams(r53);
    L290:
        r53.f13768a = r16;
        if (r17 == false) goto L294;
        if (r50 == false) goto L294;
    L295:
        r53.d = r51;
        return r16;
    L294:
        r51 = false;
        goto L295
    L287:
        if (r10.checkLayoutParams(r52) == true) goto L289;
        r53 = (RecyclerView.LayoutParams) r10.generateLayoutParams(r52);
        r16.itemView.setLayoutParams(r53);
        goto L290
    L289:
        r53 = (RecyclerView.LayoutParams) r52;
    L227:
        if (r16.isBound() == false) goto L235;
        if (r16.needsUpdate() == true) goto L235;
        if (r16.isInvalid() == false) goto L233;
    L235:
        if (RecyclerView.f13723x0 == true) goto L237;
    L241:
        int r54 = r10.d.f(r28, 0);
        r16.mBindingAdapter = null;
        r16.mOwnerRecyclerView = r10;
        int r55 = r16.getItemViewType();
        long r56 = r10.getNanoTime();
        if (r29 == Long.MAX_VALUE) goto L248;
        long r123 = this.g.a(r55).d;
        if (r123 == 0) goto L248;
        if ((r123 + r56) >= r29) goto L233;
    L248:
        if (r16.isTmpDetached() == false) goto L250;
        RecyclerView.d(r10, r16.itemView, r10.getChildCount(), r16.itemView.getLayoutParams());
        boolean r57 = true;
    L251:
        r10.f13742l.bindViewHolder(r16, r54);
        if (r57 == false) goto L254;
        RecyclerView.e(r10, r16.itemView);
    L254:
        long r58 = r10.getNanoTime() - r56;
        o0 r59 = this.g.a(r16.getItemViewType());
        long r60 = r59.d;
        if (r60 == 0) goto L258;
        r58 = (r58 / 4) + ((r60 / 4) * 3);
    L258:
        r59.d = r58;
        AccessibilityManager r61 = r10.A;
        if (r61 != null) goto L261;
    L263:
        boolean r62 = false;
    L264:
        if (r62 == false) goto L278;
        View r63 = r16.itemView;
        r51 = true;
        if (ViewCompat.getImportantForAccessibility(r63) != 0) goto L268;
        ViewCompat.setImportantForAccessibility(r63, 1);
    L268:
        RecyclerViewAccessibilityDelegate r64 = r10.i0;
        if (r64 == null) goto L280;
        RecyclerViewAccessibilityDelegate.ItemDelegate r65 = r64.f13773b;
        if (r65 == null) goto L277;
        AccessibilityDelegateCompat r66 = ViewCompat.getAccessibilityDelegate(r63);
        if (r66 == null) goto L277;
        if (r66 == r65) goto L277;
        r65.f13775b.put(r63, r66);
    L277:
        ViewCompat.setAccessibilityDelegate(r63, r65);
    L280:
        if (r12.f == false) goto L282;
        r16.mPreLayoutPosition = r28;
    L282:
        r50 = r51;
        goto L283
    L278:
        r51 = true;
        goto L280
    L261:
        if (r61.isEnabled() == false) goto L263;
        r62 = true;
        goto L264
    L250:
        r57 = false;
        goto L251
    L237:
        if (r16.isRemoved() == false) goto L241;
        StringBuilder r67 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
        r67.append(r16);
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(r10, r67));
    L38:
        r17 = false;
    L20:
        r15 = r15 + 1;
        goto L14
    L22:
        if (r10.f13742l.hasStableIds() == false) goto L35;
        int r124 = r10.d.f(r28, 0);
        if (r124 <= 0) goto L35;
        if (r124 >= r10.f13742l.getItemCount()) goto L35;
        long r125 = r10.f13742l.getItemId(r124);
        int r126 = 0;
    L28:
        if (r126 >= r14) goto L35;
        x0 r127 = (x0) this.f13886b.get(r126);
        if (r127.wasReturnedFromScrap() == true) goto L34;
        if (r127.getItemId() != r125) goto L34;
        r127.addFlags(32);
        r16 = r127;
    L34:
        r126 = r126 + 1;
    L35:
        r16 = null;
        goto L36
    L39:
        r17 = false;
        r16 = null;
        goto L40
    }

    public final void k(x0 r5) {
        if (r5.mInChangeScrap == false) goto L5;
        this.f13886b.remove(r5);
    L6:
        r5.mScrapContainer = null;
        r5.mInChangeScrap = false;
        r5.clearReturnedFromScrapFlag();
        return;
    L5:
        this.f13885a.remove(r5);
        goto L6
    }

    public final void l() {
        k0 r5 = this.f13888h.f13743m;
        if (r5 == null) goto L5;
        int r10 = r5.g;
    L6:
        this.f = this.e + r10;
        ArrayList r11 = this.f13887c;
        int r12 = r11.size() - 1;
    L7:
        if (r12 < 0) goto L11;
        if (r11.size() <= this.f) goto L14;
        f(r12);
        r12 = r12 - 1;
        goto L7
    L14:
        return;
    L11:
        return;
    L5:
        r10 = 0;
        goto L6
    }
}
