package com.larus.photopicker.v2.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumViolation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kq9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public int a;
    public boolean b;
    public boolean c;
    public int d;
    public long e;
    public final MutableLiveData<Set<op9.d>> f;
    public final MutableLiveData g;
    public final MutableLiveData<Boolean> h;
    public final MutableLiveData i;
    public final MutableLiveData<e> j;
    public final MutableLiveData<String> k;
    public boolean l;
    public CreationReferenceAlbumConfig m;

    public final int i() {
        int r0 = this.a;
        if (r0 >= 0) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r0;
    }

    public final void n() {
        e0.d("SelectionManager", "updateSelectableState");
        if (this.m == null) goto L6;
        this.h.setValue(Boolean.TRUE);
        return;
    L6:
        Set r0 = (Set) this.f.getValue();
        boolean r1 = false;
        if (r0 == null) goto L9;
        int r2 = r0.size();
    L11:
        if (this.c == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L19;
        this.h.setValue(Boolean.TRUE);
        return;
    L19:
        int r4 = i();
        MutableLiveData<Boolean> r5 = this.h;
        if (this.l == true) goto L22;
    L23:
        if (r2 >= r4) goto L25;
    L24:
        r1 = true;
    L25:
        r5.setValue(Boolean.valueOf(r1));
        return;
    L22:
        if (this.a == 1) goto L24;
    L13:
        if (this.b == false) goto L15;
        r3 = true;
        goto L16
    L9:
        r2 = 0;
        goto L11
    }

    public d() {
        this.a = 10;
        this.b = false;
        this.c = false;
        this.d = -1;
        this.e = 0;
        MutableLiveData<Set<op9.d>> r0 = new MutableLiveData(new LinkedHashSet());
        this.f = r0;
        this.g = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData(Boolean.TRUE);
        this.h = r1;
        this.i = r1;
        this.j = new MutableLiveData();
        this.k = new MutableLiveData();
    }

    public static int c(Set r4) {
        Set r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L9:
        if (r6.hasNext() == false) goto L19;
        if (((op9.d) r6.next()).a.getType() == MediaType.VIDEO) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r2 = false;
        goto L14
    L19:
        return r0;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return 0;
    }

    public static int d(Set r4) {
        Set r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L9:
        if (r6.hasNext() == false) goto L19;
        if (((op9.d) r6.next()).a.getType() != MediaType.VIDEO) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r2 = false;
        goto L14
    L19:
        return r0;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return 0;
    }

    public static CreationReferenceAlbumAttachment k(op9.d r13) {
        if (r13.a.getType() != MediaType.VIDEO) goto L5;
        CreationReferenceAlbumMediaType r0 = CreationReferenceAlbumMediaType.VIDEO;
    L6:
        CreationReferenceAlbumMediaType r2 = r0;
        Integer r1 = Integer.valueOf(r13.a.j);
        boolean r3 = false;
        if (r1.intValue() <= 0) goto L9;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r1 = null;
    L14:
        Integer r5 = Integer.valueOf(r13.a.k);
        if (r5.intValue() <= 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        Integer r7 = r5;
    L21:
        Long r8 = Long.valueOf(r13.a.i);
        if (r8.longValue() <= 0) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L28;
        r8 = null;
    L28:
        if (r8 == null) goto L30;
        Double r10 = Double.valueOf(r8.longValue() / 1000.0d);
    L31:
        Long r14 = Long.valueOf(r13.a.l);
        if (r14.longValue() <= 0) goto L34;
        r3 = true;
    L34:
        if (r3 == true) goto L38;
        r14 = null;
    L38:
        return new CreationReferenceAlbumAttachment(r2, r1, r7, r10, r14);
    L30:
        r10 = null;
        goto L31
    L24:
        r9 = false;
        goto L25
    L20:
        r7 = null;
        goto L21
    L17:
        r6 = false;
        goto L18
    L9:
        r4 = false;
        goto L11
    L5:
        r0 = CreationReferenceAlbumMediaType.IMAGE;
        goto L6
    }

    public final boolean a(op9.d r10) {
        Intrinsics.checkNotNullParameter(r10, "incoming");
        int r0 = e0.a;
        e0.d("SelectionManager", "canSelect: " + r10.a.a);
        Set<op9.d> r1 = (Set) this.f.getValue();
        if (r1 != null) goto L5;
        return false;
    L5:
        Set<op9.d> r2 = r1;
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        if (((op9.d) r3.next()).a.a != r10.a.a) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L12;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        return true;
    L23:
        if (this.m == null) goto L30;
        if (o(r10, r1, true) == true) goto L28;
        return false;
    L28:
        return b(r10);
    L30:
        if (b(r10) == true) goto L32;
        return false;
    L32:
        e r11 = j(r10);
        if (r11 == null) goto L36;
        this.j.setValue(r11);
        return false;
    L36:
        return true;
    L16:
        r4 = false;
    L19:
        r5 = false;
        goto L20
    L8:
        if (r2.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean b(op9.d r9) {
        if (this.e > 0) goto L5;
    L10:
        boolean r10 = false;
    L11:
        if (r10 == true) goto L13;
        return true;
    L13:
        this.j.setValue(new e(UnSelectableToastType.VIDEO_DURATION, (int) RangesKt.coerceAtMost(this.e, 2147483647L)));
        return false;
    L5:
        if (r9.a.getType() != MediaType.VIDEO) goto L10;
        if (MathKt.roundToInt(r9.a.i / 1000.0f) <= this.e) goto L10;
        r10 = true;
        goto L11
    }

    public final int e(long r8) {
        Set r0 = (Set) this.f.getValue();
        if (r0 != null) goto L5;
        return -1;
    L5:
        Iterator r1 = r0.iterator();
        int r3 = 0;
    L7:
        if (r1.hasNext() == false) goto L18;
        Object r4 = r1.next();
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        if (((op9.d) r4).a.a != r8) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L19;
        r3 = r3 + 1;
    L19:
        if (r3 != (-1)) goto L21;
        return -1;
    L21:
        return r3;
    L14:
        r5 = false;
        goto L15
    L18:
        r3 = -1;
        goto L19
    }

    public final boolean f(op9.d r10) {
        Intrinsics.checkNotNullParameter(r10, "incoming");
        Set<op9.d> r0 = (Set) this.f.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        Set<op9.d> r2 = r0;
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        if (((op9.d) r3.next()).a.a != r10.a.a) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L12;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        return true;
    L23:
        if (this.m != null) goto L25;
        MediaType r11 = r10.a.getType();
        Intrinsics.checkNotNullParameter(r11, "type");
        if (this.m == null) goto L30;
        return true;
    L30:
        if (this.c == true) goto L32;
    L34:
        boolean r6 = false;
    L35:
        if (r6 == false) goto L67;
        Set r7 = (Set) this.f.getValue();
        if (r7 == null) goto L68;
        int r8 = i();
        int r9 = this.d;
        int r12 = Integer.MAX_VALUE;
        if (r9 >= 0) goto L43;
        r9 = Integer.MAX_VALUE;
    L43:
        int r13 = this.a;
        if (r13 < 0) goto L47;
        r12 = RangesKt.coerceAtLeast(r13 - r9, 0);
    L47:
        int r14 = d(r7);
        int r15 = c(r7);
        if ((r15 + r14) < r8) goto L50;
        boolean r16 = true;
    L52:
        if (r11 != MediaType.VIDEO) goto L56;
        if (r16 == true) goto L60;
        if (r14 >= r9) goto L60;
    L58:
        r1 = true;
    L60:
        return r1;
    L56:
        if (r16 == true) goto L60;
        if (r15 >= r12) goto L60;
    L50:
        r16 = false;
        goto L52
    L68:
        return true;
    L67:
        return true;
    L32:
        if (this.b == false) goto L34;
        r6 = true;
        goto L35
    L25:
        return o(r10, r0, false);
    L16:
        r4 = false;
    L19:
        r5 = false;
        goto L20
    L8:
        if (r2.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean g(long r7) {
        Set r0 = (Set) this.f.getValue();
        if (r0 == null) goto L24;
        Set r1 = r0;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L26;
        if (((op9.d) r2.next()).a.a != r7) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
        return true;
    L15:
        r3 = false;
        goto L16
    L26:
        return false;
    L7:
        if (r1.isEmpty() == false) goto L9;
        return false;
    L24:
        return false;
    }

    public final e j(op9.d r11) {
        Intrinsics.checkNotNullParameter(r11, "incoming");
        Set<op9.d> r0 = (Set) this.f.getValue();
        if (r0 != null) goto L5;
        return null;
    L5:
        Set<op9.d> r2 = r0;
        boolean r4 = false;
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        if (((op9.d) r3.next()).a.a != r11.a.a) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        return null;
    L22:
        if (this.m == null) goto L24;
        return null;
    L24:
        if (this.l == false) goto L29;
        if (this.a != 1) goto L29;
        return null;
    L29:
        if (this.c == true) goto L31;
    L33:
        e r12 = new e(UnSelectableToastType.DEFAULT, this.a);
        if (r0.size() < i()) goto L36;
        r4 = true;
    L36:
        if (r4 == true) goto L38;
        return null;
    L38:
        return r12;
    L31:
        if (this.b == false) goto L33;
        return h(r11.a.getType(), r0);
    L16:
        r5 = false;
    L19:
        r6 = false;
        goto L20
    L8:
        if (r2.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean l(op9.d r14) {
        Intrinsics.checkNotNullParameter(r14, "selectedItem");
        int r0 = e0.a;
        e0.d("SelectionManager", "toggleSelection: " + r14.a.a);
        long r1 = r14.a.a;
        Set r2 = (Set) this.f.getValue();
        if (r2 == null) goto L59;
        Set<op9.d> r3 = CollectionsKt.toMutableSet(r2);
        if (r3 == null) goto L59;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (((op9.d) r5).a.a != r1) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
    L17:
        op9.d r6 = (op9.d) r5;
        if (r6 == null) goto L22;
        r3.remove(r6);
        this.f.setValue(r3);
        n();
        return false;
    L22:
        if (this.m == null) goto L33;
        if (o(r14, r3, true) == true) goto L27;
        return false;
    L27:
        if (this.l == true) goto L29;
    L31:
        r3.add(op9.d.a(r14, null, true, 0, false, 29));
    L57:
        this.f.setValue(r3);
        n();
        return true;
    L29:
        if (this.a != 1) goto L31;
        r3.clear();
        goto L31
    L33:
        if (b(r14) == true) goto L36;
        return false;
    L36:
        if (this.c == true) goto L38;
    L40:
        boolean r8 = false;
    L41:
        if (r8 == false) goto L47;
        e r9 = h(r14.a.getType(), r3);
        if (r9 == null) goto L56;
        this.j.setValue(r9);
        return false;
    L56:
        r3.add(op9.d.a(r14, null, true, 0, false, 29));
        goto L57
    L47:
        if (r3.size() < i()) goto L56;
        if (this.l == true) goto L51;
    L54:
        this.j.setValue(new e(UnSelectableToastType.DEFAULT, this.a));
        return false;
    L51:
        if (this.a != 1) goto L54;
        r3.clear();
        r3.add(op9.d.a(r14, null, true, 0, false, 29));
        this.f.setValue(r3);
        n();
        return true;
    L38:
        if (this.b == false) goto L40;
        r8 = true;
        goto L41
    L13:
        r7 = false;
        goto L14
    L16:
        r5 = null;
    L59:
        return false;
    }

    public final void m(int r3) {
        int r0 = e0.a;
        e0.d("SelectionManager", "updateMaxSelectCount: maxSelectCount: " + r3);
        this.a = r3;
        n();
    }

    public static boolean p(d r6, Collection r7) {
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "selected");
        if (r7.isEmpty() == true) goto L24;
        CreationReferenceAlbumConfig r1 = r6.m;
        if (r1 == null) goto L23;
        int r2 = j.a;
        Collection r8 = r7;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r4 = r8.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(k((op9.d) r4.next()));
        goto L10
    L12:
        Intrinsics.checkNotNullParameter(r1, "config");
        Intrinsics.checkNotNullParameter(r3, "selected");
        CreationReferenceAlbumViolation r0 = j.b(r1, r3, r3);
        if (r0 == null) goto L22;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r5.add(k((op9.d) r9.next()).getType());
        goto L16
    L18:
        CreationReferenceAlbumMediaType r10 = (CreationReferenceAlbumMediaType) CollectionsKt.singleOrNull(CollectionsKt.distinct(r5));
        MutableLiveData<String> r11 = r6.k;
        String r12 = r1.violationMessage(r0, r10);
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r11.setValue(r12);
    L22:
        if (r0 != null) goto L24;
    L23:
        return true;
    L24:
        return false;
    }

    public final e h(MediaType r8, Set<op9.d> r9) {
        int r0 = i();
        int r1 = this.d;
        int r2 = Integer.MAX_VALUE;
        if (r1 >= 0) goto L5;
        r1 = Integer.MAX_VALUE;
    L5:
        boolean r4 = false;
        if (this.a < 0) goto L9;
        r2 = RangesKt.coerceAtLeast(r0 - r1, 0);
    L9:
        int r3 = d(r9);
        int r10 = c(r9);
        if (r8 != MediaType.VIDEO) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L21;
        if (r3 < r1) goto L16;
    L18:
        if (r4 == false) goto L29;
    L26:
        return null;
    L29:
        return new e(UnSelectableToastType.VIDEO_LIMIT, r1);
    L16:
        if ((r10 + r3) >= r0) goto L18;
        r4 = true;
        goto L18
    L21:
        if (r10 < r2) goto L23;
    L25:
        if (r4 == true) goto L26;
        return new e(UnSelectableToastType.IMAGE_LIMIT, r2);
    L23:
        if ((r10 + r3) >= r0) goto L25;
        r4 = true;
        goto L25
    L12:
        r11 = false;
        goto L13
    }

    public final boolean o(op9.d r5, Set<op9.d> r6, boolean r7) {
        CreationReferenceAlbumConfig r0 = this.m;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (this.l == true) goto L8;
    L10:
        Set<op9.d> r8 = r6;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        r2.add(k((op9.d) r9.next()));
        goto L12
    L14:
        List r10 = r2;
    L15:
        CreationReferenceAlbumAttachment r11 = k(r5);
        CreationReferenceAlbumViolation r12 = j.a(r0, r10, r11);
        if (r12 == null) goto L22;
        if (r7 == false) goto L22;
        CreationReferenceAlbumMediaType r13 = r11.getType();
        MutableLiveData<String> r14 = this.k;
        String r15 = r0.violationMessage(r12, r13);
        if (r15 != null) goto L21;
        r15 = "";
    L21:
        r14.setValue(r15);
    L22:
        if (r12 == null) goto L27;
        return false;
    L27:
        return true;
    L8:
        if (this.a != 1) goto L10;
        r10 = CollectionsKt.emptyList();
        goto L15
    }
}
