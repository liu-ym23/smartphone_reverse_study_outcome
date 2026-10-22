package com.bytedance.android.livesdk.interactivity.publicscreen.panel;

import com.bytedance.android.live.base.model.data.b;
import com.bytedance.android.live.base.model.message.a6;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B-\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0014J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u001e\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/ChatLikeLinkedHashMap;", "Ljava/util/LinkedHashMap;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/data/b;", "Lkotlin/collections/LinkedHashMap;", BuildConfig.FLAVOR, "eldest", BuildConfig.FLAVOR, "removeEldestEntry", "key", "value", "put", BuildConfig.FLAVOR, "from", BuildConfig.FLAVOR, "putAll", "msgid", "Lcom/bytedance/android/live/base/model/message/a6;", "newLikeCount", "putLikeCount", BuildConfig.FLAVOR, "maxCapacity", "I", "initialCapacity", BuildConfig.FLAVOR, "loadFactor", "accessOrder", "<init>", "(IIFZ)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatLikeLinkedHashMap extends LinkedHashMap<Long, b> {
    private final int maxCapacity;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Long, b>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Long> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<b> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsKey((Long) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof b) == true) goto L7;
        return false;
    L7:
        return containsValue((b) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof Long) == true) goto L7;
        return null;
    L7:
        return get((Long) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends b> r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Iterator<Map.Entry<? extends Long, ? extends b>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<? extends Long, ? extends b> r0 = r5.next();
        put(r0.getKey().longValue(), r0.getValue());
        goto L4
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r2) {
        if ((r2 instanceof Long) == true) goto L7;
        return null;
    L7:
        return remove((Long) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Long, b> r2) {
        Intrinsics.checkNotNullParameter(r2, "eldest");
        if (size() <= this.maxCapacity) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(Long r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(b r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ b get(Long r1) {
        return (b) super.get(r1);
    }

    public /* bridge */ b remove(Long r1) {
        return (b) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof Long) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((Long) r2, (b) r3);
    }

    public b put(long r6, b r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        if (containsKey(Long.valueOf(r6)) == false) goto L10;
        b r0 = (b) get(Long.valueOf(r6));
        if (r0 == null) goto L7;
        long r1 = r0.c();
    L9:
        if (r1 < r8.c()) goto L10;
        return null;
    L7:
        r1 = 0;
    L10:
        super.put(Long.valueOf(r6), r8);
        return null;
    }

    public final void putLikeCount(long r8, a6 r10) {
        Intrinsics.checkNotNullParameter(r10, "newLikeCount");
        long r1 = 0;
        if (containsKey(Long.valueOf(r8)) == true) goto L12;
        b r0 = new b();
        Long r3 = r10.a();
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L8:
        r0.g(r4);
        Long r11 = r10.b();
        if (r11 == null) goto L11;
        r1 = r11.longValue();
    L11:
        r0.h(r1);
        super.put(Long.valueOf(r8), r0);
        return;
    L7:
        r4 = 0;
        goto L8
    L12:
        Long r2 = r10.b();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        b r6 = (b) get(Long.valueOf(r8));
        if (r6 == null) goto L19;
        long r7 = r6.c();
    L21:
        if (r5 <= r7) goto L37;
        b r9 = (b) get(Long.valueOf(r8));
        if (r9 == null) goto L29;
        Long r13 = r10.a();
        if (r13 == null) goto L27;
        long r14 = r13.longValue();
    L28:
        r9.g(r14);
        goto L29
    L27:
        r14 = 0;
    L29:
        b r15 = (b) get(Long.valueOf(r8));
        if (r15 == null) goto L38;
        Long r16 = r10.b();
        if (r16 == null) goto L34;
        r1 = r16.longValue();
    L34:
        r15.h(r1);
        return;
    L38:
        return;
    L37:
        return;
    L19:
        r7 = 0;
        goto L21
    L15:
        r5 = 0;
        goto L16
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r2, Object r3) {
        if ((r2 instanceof Long) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof b) == true) goto L8;
        return false;
    L8:
        return remove((Long) r2, (b) r3);
    }

    public /* bridge */ b getOrDefault(Long r1, b r2) {
        return (b) super.getOrDefault(r1, r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r3, Object r4) {
        return put(((Number) r3).longValue(), (b) r4);
    }

    public /* bridge */ boolean remove(Long r1, b r2) {
        return super.remove(r1, r2);
    }

    public ChatLikeLinkedHashMap(int r1, int r2, float r3, boolean r4) {
        super(r2, r3, r4);
        this.maxCapacity = r1;
    }

    public /* synthetic */ ChatLikeLinkedHashMap(int r1, int r2, float r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 10;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0.75f;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = true;
    L11:
        this(r1, r2, r3, r4);
    }
}
