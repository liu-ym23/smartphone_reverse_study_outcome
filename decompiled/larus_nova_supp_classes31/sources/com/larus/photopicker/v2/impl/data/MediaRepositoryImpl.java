package com.larus.photopicker.v2.impl.data;

import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import pp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class MediaRepositoryImpl implements d {
    public final e a;
    public final LazyLoadConfig b;
    public final String c;
    public final MutexImpl d;
    public int e;
    public final op9.b f;
    public final MutableLiveData<List<mp9.b>> g;
    public final MutableLiveData h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaTab.values().length];
            r0[MediaTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaTab.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaTab.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final MutableLiveData g() {
        return this.h;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final List<mp9.b> h(mp9.c r23) {
        Intrinsics.checkNotNullParameter(r23, "mediaItem");
        List r2 = (List) this.g.getValue();
        if (r2 == null) goto L74;
        List r3 = CollectionsKt.toMutableList(r2);
        if (r3 == null) goto L86;
        int r4 = 2;
        int r8 = 1;
        Set r5 = SetsKt.setOf(new Long[]{-1L, Long.valueOf(r23.e)});
        List r6 = r3;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r9 = r6.iterator();
        boolean r10 = false;
    L9:
        if (r9.hasNext() == false) goto L69;
        mp9.b r11 = (mp9.b) r9.next();
        if (r5.contains(Long.valueOf(r11.a)) == true) goto L13;
        Iterator r19 = r9;
        boolean r18 = r10;
    L65:
        r10 = r18;
    L67:
        r7.add(r11);
        r9 = r19;
        r4 = 2;
        r8 = 1;
        goto L9
    L13:
        Map r12 = MapsKt.toMutableMap(r11.f);
        Map r13 = MapsKt.toMutableMap(r11.e);
        Iterator<Map.Entry<MediaTab, List<mp9.c>>> r14 = r11.f.entrySet().iterator();
        boolean r15 = false;
    L15:
        if (r14.hasNext() == false) goto L63;
        Map.Entry<MediaTab, List<mp9.c>> r16 = r14.next();
        MediaTab r17 = r16.getKey();
        List<mp9.c> r110 = r16.getValue();
        int r20 = a.a[r17.ordinal()];
        if (r20 == r8) goto L30;
        if (r20 == r4) goto L27;
        if (r20 != 3) goto L25;
        if (r23.getType() == MediaType.VIDEO) goto L30;
    L29:
        boolean r21 = false;
    L31:
        if (r21 == true) goto L33;
        Iterator r111 = r9;
        boolean r112 = r10;
    L62:
        r10 = r112;
        r9 = r111;
        r4 = 2;
        r8 = 1;
        goto L15
    L33:
        List<mp9.c> r22 = r110;
        if ((r22 instanceof Collection) == true) goto L36;
    L38:
        Iterator r24 = r22.iterator();
    L40:
        if (r24.hasNext() == false) goto L37;
        mp9.c r25 = (mp9.c) r24.next();
        r112 = r10;
        r111 = r9;
        Iterator r26 = r24;
        if (r25.a != r23.a) goto L44;
    L47:
        boolean r27 = true;
    L48:
        if (r27 == true) goto L49;
        r10 = r112;
        r9 = r111;
        r24 = r26;
        goto L40
    L49:
        boolean r28 = true;
    L52:
        if (r28 == true) goto L62;
        ArrayList r29 = new ArrayList();
        r29.add(r23);
        r29.addAll(r110);
        r12.put(r17, r29);
        Integer r30 = (Integer) r13.get(r17);
        if (r30 != null) goto L59;
        r30 = r11.e.get(r17);
        if (r30 != null) goto L59;
        int r31 = 0;
    L61:
        r13.put(r17, Integer.valueOf(r31 + 1));
        this.f.b(r11.a, r17, r29);
        r15 = true;
    L59:
        r31 = r30.intValue();
        goto L61
    L44:
        if (Intrinsics.areEqual(r25.b, r23.b) == true) goto L47;
        r27 = false;
    L37:
        r111 = r9;
        r112 = r10;
        r28 = false;
        goto L52
    L36:
        if (r22.isEmpty() == false) goto L38;
    L25:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r23.getType() != MediaType.IMAGE) goto L29;
    L30:
        r21 = true;
        goto L31
    L63:
        r19 = r9;
        r18 = r10;
        if (r15 == false) goto L65;
        r11 = mp9.b.a(r11, r11.d + 1, r13, r12, 7);
        r10 = true;
        goto L67
    L69:
        if (r10 == false) goto L72;
        this.g.postValue(r7);
        return r7;
    L72:
        return null;
    L86:
        return null;
    L74:
        return null;
    }

    public MediaRepositoryImpl(ContentResolverMediaSource r2, LazyLoadConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaSource");
        Intrinsics.checkNotNullParameter(r3, "lazyLoadConfig");
        this.a = r2;
        this.b = r3;
        this.c = "MediaRepositoryImpl";
        this.d = kotlinx.coroutines.sync.b.a();
        this.f = new op9.b();
        MutableLiveData<List<mp9.b>> r4 = new MutableLiveData(CollectionsKt.emptyList());
        this.g = r4;
        this.h = r4;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object a(String r2, Continuation<? super mp9.c> r3) {
        return this.a.a(r2, r3);
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object b(mp9.a r12, Continuation<? super Integer> r13) {
        if ((r13 instanceof MediaRepositoryImpl$getCurPage$1) == false) goto L7;
        MediaRepositoryImpl$getCurPage$1 r0 = (MediaRepositoryImpl$getCurPage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r4 = 1;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r0.L$1;
        mp9.a r5 = (mp9.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.sync.a r16 = r15;
        r12 = r5;
    L59:
        Long r6 = r12.a;     // Catch: Throwable -> L56
        int r7 = 0;
        if (r6 == null) goto L53;
        long r8 = r6.longValue();     // Catch: Throwable -> L56
        MediaTab r17 = r12.b;     // Catch: Throwable -> L56
        if (r17 != null) goto L24;
        Integer r18 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r16.unlock(null);
        return r18;
    L24:
        int r9 = this.b.b;     // Catch: Throwable -> L56
        List r10 = (List) this.g.getValue();     // Catch: Throwable -> L56
        if (r10 != null) goto L29;
        Integer r19 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r16.unlock(null);
        return r19;
    L29:
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L56
    L31:
        if (r11.hasNext() == false) goto L38;
        Object r20 = r11.next();     // Catch: Throwable -> L56
        if (((mp9.b) r20).a != r8) goto L35;
        boolean r21 = true;
    L36:
        if (r21 == false) goto L31;
    L39:
        mp9.b r22 = (mp9.b) r20;     // Catch: Throwable -> L56
        if (r22 != null) goto L44;
        Integer r110 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r16.unlock(null);
        return r110;
    L44:
        List<mp9.c> r111 = r22.f.get(r17);     // Catch: Throwable -> L56
        if (r111 == null) goto L47;
        r7 = r111.size();     // Catch: Throwable -> L56
    L47:
        if (r7 == 0) goto L50;
        r4 = 1 + ((r7 - 1) / r9);     // Catch: Throwable -> L56
    L50:
        Integer r112 = Boxing.boxInt(r4);     // Catch: Throwable -> L56
        r16.unlock(null);
        return r112;
    L35:
        r21 = false;
        goto L36
    L38:
        r20 = null;
        goto L39
    L53:
        Integer r113 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r16.unlock(null);
        return r113;
    L56:
        th = move-exception;
        r16.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r16 = this.d;
        r0.L$0 = r12;
        r0.L$1 = r16;
        r0.label = 1;
        if (r16.a(null, r0) != r2) goto L59;
        return r2;
    L7:
        r0 = new MediaRepositoryImpl$getCurPage$1(this, r13);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object d(mp9.a r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof MediaRepositoryImpl$hasMore$1) == false) goto L7;
        MediaRepositoryImpl$hasMore$1 r0 = (MediaRepositoryImpl$hasMore$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) r0.L$1;
        mp9.a r5 = (mp9.a) r0.L$0;
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.sync.a r15 = r14;
        r11 = r5;
    L59:
        Long r6 = r11.a;     // Catch: Throwable -> L56
        boolean r7 = false;
        if (r6 == null) goto L53;
        long r8 = r6.longValue();     // Catch: Throwable -> L56
        MediaTab r16 = r11.b;     // Catch: Throwable -> L56
        if (r16 != null) goto L24;
        Boolean r17 = Boxing.boxBoolean(false);     // Catch: Throwable -> L56
        r15.unlock(null);
        return r17;
    L24:
        List r9 = (List) this.g.getValue();     // Catch: Throwable -> L56
        if (r9 == null) goto L50;
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L56
    L28:
        if (r10.hasNext() == false) goto L35;
        Object r18 = r10.next();     // Catch: Throwable -> L56
        if (((mp9.b) r18).a != r8) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == false) goto L28;
    L36:
        mp9.b r20 = (mp9.b) r18;     // Catch: Throwable -> L56
        if (r20 == null) goto L50;
        Integer r21 = r20.e.get(r16);     // Catch: Throwable -> L56
        if (r21 == null) goto L41;
        int r22 = r21.intValue();     // Catch: Throwable -> L56
    L42:
        List<mp9.c> r110 = r20.f.get(r16);     // Catch: Throwable -> L56
        if (r110 == null) goto L45;
        int r111 = r110.size();     // Catch: Throwable -> L56
    L46:
        if (r111 < r22) goto L49;
        r4 = false;
    L49:
        r7 = r4;
        goto L50
    L45:
        r111 = 0;
        goto L46
    L41:
        r22 = 0;
        goto L42
    L32:
        r19 = false;
        goto L33
    L35:
        r18 = null;
    L50:
        Boolean r112 = Boxing.boxBoolean(r7);     // Catch: Throwable -> L56
        r15.unlock(null);
        return r112;
    L53:
        Boolean r113 = Boxing.boxBoolean(false);     // Catch: Throwable -> L56
        r15.unlock(null);
        return r113;
    L56:
        th = move-exception;
        r15.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r15 = this.d;
        r0.L$0 = r11;
        r0.L$1 = r15;
        r0.label = 1;
        if (r15.a(null, r0) != r2) goto L59;
        return r2;
    L7:
        r0 = new MediaRepositoryImpl$hasMore$1(this, r12);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object e(List<? extends MediaTab> r4, Continuation<? super List<mp9.b>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaRepositoryImpl$initMediaFolders$2(this, r4, null), r5);
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final int c(long r3, MediaTab r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "mediaTab");
        op9.b r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "mediaTab");
        SparseArray<LongSparseArray<Integer>> r4 = r1.b.get(r3, null);
        if (r4 == null) goto L14;
        LongSparseArray<Integer> r7 = r4.get(r5.getId(), null);
        if (r7 == null) goto L15;
        Integer r8 = r7.get(r6, -1);
        if (r8 == null) goto L12;
        r8.intValue();
    L12:
        Intrinsics.checkNotNull(r8);
        return r8.intValue();
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object f(int r11, int r12, List<? extends MediaTab> r13, Continuation<? super List<mp9.c>> r14) {
        if ((r14 instanceof MediaRepositoryImpl$fastLoadMediaItems$1) == false) goto L7;
        MediaRepositoryImpl$fastLoadMediaItems$1 r1 = (MediaRepositoryImpl$fastLoadMediaItems$1) r14;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L21
    L19:
        List r16 = (List) r15;     // Catch: Exception -> L21
        Lazy r17 = i.a;     // Catch: Exception -> L21
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L21
        int r19 = this.e + 1;     // Catch: Exception -> L21
        this.e = r19;     // Catch: Exception -> L21
        r18.put("notify_times", r19);     // Catch: Exception -> L21
        r18.put("album_size", r16.size());     // Catch: Exception -> L21
        r18.put("data_type", "media");     // Catch: Exception -> L21
        r18.put("is_success", 1);     // Catch: Exception -> L21
        i.b(r18);     // Catch: Exception -> L21
        int r110 = e0.a;     // Catch: Exception -> L21
        e0.d(this.c, "result fastLoadMediaItems: " + r16.size());     // Catch: Exception -> L21
        return r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        int r111 = e0.a;
        e0.d(this.c, "fastLoadMediaItems: " + r11 + ", " + r12 + ", " + r13.size());
        e r112 = this.a;     // Catch: Exception -> L21
        mp9.a r5 = new mp9.a(null, (MediaTab) CollectionsKt.first(r13));     // Catch: Exception -> L21
        r1.label = 1;     // Catch: Exception -> L21
        r15 = r112.c(r11, r12, r5, r1);     // Catch: Exception -> L21
        if (r15 != r3) goto L19;
        return r3;
    L21:
        e = move-exception;
        Lazy r113 = i.a;
        JSONObject r114 = new JSONObject();
        int r115 = this.e + 1;
        this.e = r115;
        r114.put("notify_times", r115);
        r114.put("error_msg", e.getMessage());
        r114.put("data_type", "media");
        r114.put("is_success", 0);
        i.b(r114);
        int r116 = e0.a;
        e0.c(this.c, "fastLoadMediaItems: An error occurred，" + ExceptionsKt.stackTraceToString(e));
        return CollectionsKt.emptyList();
    L7:
        r1 = new MediaRepositoryImpl$fastLoadMediaItems$1(this, r14);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object i(int r9, int r10, mp9.a r11, Continuation<? super Unit> r12) {
        if (r11 == null) goto L4;
        Object r13 = BuildersKt.withContext(Dispatchers.getIO(), new MediaRepositoryImpl$loadMore$2(this, r9, r10, r11, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r13;
    L9:
        return Unit.INSTANCE;
    L4:
        return Unit.INSTANCE;
    }
}
