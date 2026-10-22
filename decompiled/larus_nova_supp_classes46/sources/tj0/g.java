package tj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public boolean a;
    public CompositeDisposable b;
    public com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a c;
    public com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.c d;
    public List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> e;
    public final uj0.d f;
    public final o.a g;

    public static String a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r3) {
        return "micseat_" + r3.f + '_' + r3.d.f;
    }

    public g(uj0.d r2, o.a r3) {
        Intrinsics.checkNotNullParameter(r2, "micseatRender");
        this.f = r2;
        this.g = r3;
    }

    public final void b(List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "structs");
        if (this.a == true) goto L5;
        return;
    L5:
        List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r1 = this.e;
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        Intrinsics.checkNotNullParameter(r12, "micseatStructs");
        List r2 = CollectionsKt.sortedWith(r12, new com.bytedance.android.live.liveinteract.videotalk.avatarmix.b());
        List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r3 = r1;
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Object r7 = r4.next();
        r6.put(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r7), r7);
        goto L10
    L12:
        List r5 = r2;
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator r9 = r5.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        r8.put(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r10), r10);
        goto L14
    L16:
        ArrayList r11 = new ArrayList();
        Iterator r14 = r5.iterator();
    L18:
        if (r14.hasNext() == false) goto L22;
        Object r15 = r14.next();
        if ((true ^ r6.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r15))) == false) goto L18;
        r11.add(r15);
        goto L18
    L22:
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r3.iterator();
    L24:
        if (r17.hasNext() == false) goto L28;
        Object r18 = r17.next();
        if ((!r8.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r18))) == false) goto L24;
        r16.add(r18);
        goto L24
    L28:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r5.iterator();
    L30:
        if (r20.hasNext() == false) goto L34;
        Object r21 = r20.next();
        if (r6.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r21)) == false) goto L30;
        r19.add(r21);
        goto L30
    L34:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r19.iterator();
    L36:
        if (r23.hasNext() == false) goto L40;
        Object r24 = r23.next();
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r25 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r24;
        Object r110 = r6.get(a(r25));
        Intrinsics.checkNotNull(r110);
        if ((!com.bytedance.android.live.liveinteract.videotalk.avatarmix.c.a(r25, (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r110)) == false) goto L36;
        r22.add(r24);
        goto L36
    L40:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r5.iterator();
    L42:
        if (r27.hasNext() == false) goto L46;
        Object r28 = r27.next();
        if (r6.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r28)) == false) goto L42;
        r26.add(r28);
        goto L42
    L46:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r26.iterator();
    L48:
        if (r30.hasNext() == false) goto L52;
        Object r31 = r30.next();
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r32 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r31;
        Object r111 = r6.get(a(r32));
        Intrinsics.checkNotNull(r111);
        if (com.bytedance.android.live.liveinteract.videotalk.avatarmix.c.a(r32, (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r111) == false) goto L48;
        r29.add(r31);
        goto L48
    L52:
        Intrinsics.checkNotNullParameter(r11, "added");
        Intrinsics.checkNotNullParameter(r16, "removed");
        Intrinsics.checkNotNullParameter(r22, "changed");
        Intrinsics.checkNotNullParameter(r29, "unchanged");
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r33 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r11);
        if (r33 == null) goto L55;
        r33.g = true;
    L55:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r34 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r16);
        if (r34 == null) goto L58;
        r34.g = true;
    L58:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r35 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r22);
        if (r35 == null) goto L61;
        r35.g = true;
    L61:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r36 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r29);
        if (r36 == null) goto L65;
        r36.g = true;
    L65:
        if ((!r11.isEmpty()) == false) goto L67;
    L72:
        boolean r37 = true;
    L73:
        if (r37 == true) goto L76;
        if (r13 == true) goto L76;
        return;
    L76:
        Iterator r112 = r16.iterator();
    L78:
        if (r112.hasNext() == false) goto L80;
        this.f.a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r112.next());
        goto L78
    L80:
        List r113 = CollectionsKt.minus(r12, r16);
        CompositeDisposable r38 = this.b;
        if (r38 == null) goto L83;
        r38.clear();
        this.b = null;
    L83:
        this.b = new CompositeDisposable();
        RxUtilKt.c(Observable.fromIterable(r113).concatMapSingle(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.a), this.b);
        this.e = r12;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r114 = this.c;
        if (r114 == null) goto L106;
        Intrinsics.checkNotNullParameter(r12, "structs");
        Iterator<T> r0 = r114.a.keySet().iterator();
    L87:
        if (r0.hasNext() == false) goto L106;
        String r39 = (String) r0.next();
        if (r12.isEmpty() == true) goto L97;
        Iterator<T> r40 = r12.iterator();
    L93:
        if (r40.hasNext() == false) goto L97;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r41 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r40.next();
        int r42 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(r41), r39) == false) goto L93;
        boolean r43 = false;
    L98:
        if (r43 == false) goto L87;
        Pair<String, Bitmap> r44 = r114.a.remove(r39);
        if (r44 == null) goto L87;
        ((Bitmap) r44.getSecond()).recycle();
        int r45 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d((String) r44.getFirst()) == false) goto L87;
        String r46 = (String) r44.getFirst();
        MemoryCache r47 = ImagePipelineFactory.getInstance().getImagePipeline().getBitmapMemoryCache();
        if (r47 == null) goto L87;
        r47.removeAll(new com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.b(r46));
    L97:
        r43 = true;
    L106:
        o.a r115 = this.g;
        if (r115 == null) goto L157;
        r115.f();
        return;
    L157:
        return;
    L67:
        if ((!r16.isEmpty()) == true) goto L72;
        if ((!r22.isEmpty()) == true) goto L72;
        r37 = false;
        goto L73
    }
}
