package com.bytedance.android.ec.core.imagex.opt;

import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageMultiSizeReuseOpt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final ReadOnlyProperty d = null;
    public static final ECImageMultiSizeReuseOpt e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$CacheType;", "", "REUSE_THUMB_CACHE", "REUSE_CACHE", "PRELOAD_REUSE_CACHE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType PRELOAD_REUSE_CACHE = null;
        public static final CacheType REUSE_CACHE = null;
        public static final CacheType REUSE_THUMB_CACHE = null;
        public static final /* synthetic */ CacheType[] a = null;

        static {
            CacheType r1 = new CacheType("REUSE_THUMB_CACHE", 0);
            REUSE_THUMB_CACHE = r1;
            CacheType r10 = new CacheType("REUSE_CACHE", 1);
            REUSE_CACHE = r10;
            CacheType r11 = new CacheType("PRELOAD_REUSE_CACHE", 2);
            PRELOAD_REUSE_CACHE = r11;
            a = new CacheType[]{r1, r10, r11};
        }

        public static CacheType valueOf(String r1) {
            return (CacheType) r27.a.a(CacheType.class, r1);
        }

        public static CacheType[] values() {
            return (CacheType[]) a.clone();
        }

        public CacheType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u001b\b\u0002\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache;", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$c;", "Lkotlin/collections/HashMap;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageRequest", "Lcom/bytedance/android/ec/core/imagex/r;", "context", "", "onlyFrescoCacheEmpty", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$b;", "getBitmapCache", "Lcom/facebook/cache/common/CacheKey;", "cacheKey", "key", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/ref/Reference;", "Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;", "bitmapRef", "", "putCache", "removeCache", "Ljava/util/concurrent/locks/ReadWriteLock;", "lock", "Ljava/util/concurrent/locks/ReadWriteLock;", "com/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache$a", "lru", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache$a;", "", "maxSize", "I", "<init>", "(I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerLruCache extends HashMap<String, List<? extends c>> {
        private final ReadWriteLock lock;
        private final a lru;
        private final int maxSize;

        public static final class a extends LruCache<CacheKey, Pair<? extends String, ? extends c>> {
            public final /* synthetic */ InnerLruCache a;

            public a(InnerLruCache r1, int r10) {
                this.a = r1;
                super(r10);
            }

            @Override // android.util.LruCache
            public final void entryRemoved(boolean r1, CacheKey r10, Pair<? extends String, ? extends c> r11, Pair<? extends String, ? extends c> r12) {
                CacheKey r13 = r10;
                Pair<? extends String, ? extends c> r14 = r11;
                if (r14 == null) goto L5;
                String r15 = (String) r14.getFirst();
            L6:
                if (r1 == false) goto L11;
                if (r13 == null) goto L12;
                if (r15 == null) goto L13;
                InnerLruCache.access$removeCache(this.a, r15, r13);
                return;
            L13:
                return;
            L12:
                return;
            L11:
                return;
            L5:
                r15 = null;
                goto L6
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, List<c>>> entrySet() {
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

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<List<c>> values() {
            return getValues();
        }

        public InnerLruCache(int r10) {
            this.maxSize = r10;
            this.lock = new ReentrantReadWriteLock();
            this.lru = new a(this, r10);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return false;
        L7:
            return containsKey((String) r10);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r10) {
            if ((r10 instanceof List) == true) goto L7;
            return false;
        L7:
            return containsValue((List) r10);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ List<c> get(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return get((String) r10);
        }

        public final b getBitmapCache(CacheKey r10) {
            Pair<? extends String, ? extends c> r11 = this.lru.get(r10);
            if (r11 == null) goto L14;
            c r12 = (c) r11.getSecond();
            if (r12 == null) goto L14;
            Reference<CloseableStaticBitmap> r1 = r12.a;
            if (r1 == null) goto L9;
            CloseableStaticBitmap r13 = r1.get();
        L10:
            if (r13 != null) goto L12;
        L13:
            r12.a = null;
            goto L14
        L12:
            if (r13.isClosed() == true) goto L13;
        L15:
            if (r13 != null) goto L17;
        L20:
            return null;
        L17:
            if (i.a(r13) != true) goto L20;
            return new b(r13);
        L9:
            r13 = null;
        L14:
            r13 = null;
            goto L15
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ List<c> remove(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return remove((String) r10);
        }

        public /* bridge */ boolean containsKey(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean containsValue(List r1) {
            return super.containsValue(r1);
        }

        public /* bridge */ List get(String r1) {
            return (List) super.get(r1);
        }

        public /* bridge */ List remove(String r1) {
            return (List) super.remove(r1);
        }

        public final void a(String r10, CacheKey r11) {
            this.lock.writeLock().lock();
            List<c> r0 = get(r10);     // Catch: Throwable -> L22
            if (r0 == null) goto L14;
            ArrayList r12 = new ArrayList();     // Catch: Throwable -> L22
            Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L22
        L7:
            if (r1.hasNext() == false) goto L15;
            Object r13 = r1.next();     // Catch: Throwable -> L22
            if (((c) r13).e == r11) goto L11;
            boolean r14 = true;
        L12:
            if (r14 == false) goto L7;
            r12.add(r13);     // Catch: Throwable -> L22
            goto L7
        L11:
            r14 = false;
        L15:
            if (r12 != null) goto L17;
        L20:
            this.lock.writeLock().unlock();
            return;
        L17:
            if ((!r12.isEmpty()) == false) goto L19;
            put(r10, r12);     // Catch: Throwable -> L22
            goto L20
        L19:
            remove(r10);     // Catch: Throwable -> L22
            goto L20
        L14:
            r12 = null;
        L22:
            th = move-exception;
            this.lock.writeLock().unlock();
            throw th;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object r10, Object r11) {
            if (r10 == null) goto L4;
            boolean r0 = r10 instanceof String;
        L5:
            if (r0 == true) goto L8;
            return r11;
        L8:
            return getOrDefault((String) r10, (List) r11);
        L4:
            r0 = true;
            goto L5
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r10, Object r11) {
            boolean r0 = true;
            if (r10 == null) goto L5;
            boolean r1 = r10 instanceof String;
        L6:
            if (r1 == false) goto L13;
            if (r11 == null) goto L9;
            r0 = r11 instanceof List;
        L9:
            if (r0 == true) goto L12;
            return false;
        L12:
            return remove((String) r10, (List) r11);
        L13:
            return false;
        L5:
            r1 = true;
            goto L6
        }

        public final void removeCache(String r10, c r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            a(r10, r11.e);
        }

        public /* bridge */ List getOrDefault(String r1, List r10) {
            return (List) super.getOrDefault(r1, r10);
        }

        public /* bridge */ boolean remove(String r1, List r10) {
            return super.remove(r1, r10);
        }

        public static final /* synthetic */ void access$removeCache(InnerLruCache r0, String r1, CacheKey r10) {
            r0.a(r1, r10);
        }

        public final b getBitmapCache(ImageRequest r10, com.bytedance.android.ec.core.imagex.r r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "imageRequest");
            CacheKey r13 = ECImageMultiSizeReuseOpt.a(ECImageMultiSizeReuseOpt.e, r10, r11);
            if (r12 == false) goto L18;
            CloseableReference r14 = null;
            CloseableReference r15 = Fresco.getImagePipelineFactory().getImagePipeline().getCachedImage(r13);     // Catch: Throwable -> L14
        L12:
            th = th;
            r14 = r15;
        L15:
            CloseableReference.closeSafely(r14);
            throw th;
        L7:
            if (CloseableReference.isValid(r15) == false) goto L11;
            b r16 = new b(null);     // Catch: Throwable -> L12
            CloseableReference.closeSafely(r15);
            return r16;
        L11:
            CloseableReference.closeSafely(r15);
        L14:
            th = th;
        L18:
            return getBitmapCache(r13);
        }

        public final void putCache(String r10, c r11, Reference<CloseableStaticBitmap> r12) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            this.lock.writeLock().lock();
            List<c> r0 = get(r10);     // Catch: Throwable -> L46
            if (r0 != null) goto L6;
            r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L46
        L6:
            ArrayList r13 = new ArrayList();     // Catch: Throwable -> L46
            Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L46
        L8:
            if (r1.hasNext() == false) goto L12;
            Object r14 = r1.next();     // Catch: Throwable -> L46
            if ((true ^ Intrinsics.areEqual(((c) r14).e, r11.e)) == false) goto L8;
            r13.add(r14);     // Catch: Throwable -> L46
            goto L8
        L12:
            List r15 = CollectionsKt.toMutableList(r13);     // Catch: Throwable -> L46
            if (r11.c == 0) goto L17;
            if (r11.d == 0) goto L17;
        L35:
            if (r12 == null) goto L43;
            CloseableStaticBitmap r16 = r12.get();     // Catch: Throwable -> L46
            if (r16 == null) goto L43;
            if (r16.isClosed() == true) goto L43;
            if (r16.isThumbCache() == true) goto L43;
            Intrinsics.checkNotNullParameter(r12, "imageRef");     // Catch: Throwable -> L46
            r11.a = r12;     // Catch: Throwable -> L46
        L43:
            r15.add(r11);     // Catch: Throwable -> L46
            put(r10, r15);     // Catch: Throwable -> L46
            this.lru.put(r11.e, new Pair(r10, r11));     // Catch: Throwable -> L46
            this.lock.writeLock().unlock();
            return;
        L17:
            if (r15.size() >= r0.size()) goto L35;
            Iterator<T> r17 = r0.iterator();     // Catch: Throwable -> L46
        L20:
            if (r17.hasNext() == false) goto L31;
            Object r18 = r17.next();     // Catch: Throwable -> L46
            c r19 = (c) r18;     // Catch: Throwable -> L46
            if (Intrinsics.areEqual(r19.e, r11.e) == true) goto L24;
        L28:
            boolean r20 = false;
        L29:
            if (r20 == false) goto L20;
        L32:
            c r21 = (c) r18;     // Catch: Throwable -> L46
            if (r21 == null) goto L35;
            r11 = r21;
            goto L35
        L24:
            if (r19.c <= 0) goto L28;
            if (r19.d <= 0) goto L28;
            r20 = true;
            goto L29
        L31:
            r18 = null;
        L46:
            th = move-exception;
            this.lock.writeLock().unlock();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void putCache$default(InnerLruCache r0, String r1, c r10, Reference r11, int r12, Object r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = null;
        L5:
            r0.putCache(r1, r10, r11);
        }
    }

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.b> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public com.bytedance.android.shopping.api.image.b b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.b, java.lang.Object] */
        public final com.bytedance.android.shopping.api.image.b getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            Intrinsics.checkNotNullParameter(r11, "property");
            if (this.b != null) goto L5;
            LazyFastSDKSettings r12 = this.a;
            KProperty<?>[] r0 = g;
            if (r12.getValue(this, r0[0]) == this.d) goto L15;
            this.b = this.a.getValue(this, r0[0]);
            if (ColdLaunchExpFilter.e.b(this.c) == true) goto L15;
            return this.b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.e.b(this.c) == false) goto L8;
            return null;
        L8:
            return this.b;
        }

        public a(final com.bytedance.android.shopping.api.image.b r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_multi_size_reuse_config";
            this.c = "ec_image_multi_size_reuse_config";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_multi_size_reuse_config", r10, null, r11, r12, new ECImageMultiSizeReuseOpt$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    public static final class b {
        public final CloseableStaticBitmap a;

        public b(CloseableStaticBitmap r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.shopping.api.image.q {
        public static final /* synthetic */ int g = 0;
        public Reference<CloseableStaticBitmap> a;
        public final String b;
        public final int c;
        public final int d;
        public final CacheKey e;
        public final com.bytedance.android.shopping.api.image.q f;

        public static final class a {
            public static c a(String r10, int r11, int r12, CacheKey r13, com.bytedance.android.shopping.api.image.q r14) {
                Intrinsics.checkNotNullParameter(r10, "realUrl");
                Intrinsics.checkNotNullParameter(r13, "requestCacheKey");
                Intrinsics.checkNotNullParameter(r14, "imageXUrlParams");
                if ((r14 instanceof c) == true) goto L5;
                com.bytedance.android.shopping.api.image.q r1 = null;
            L6:
                c r15 = (c) r1;
                if (r15 == null) goto L12;
                com.bytedance.android.shopping.api.image.q r16 = r15.f;
                if (r16 == null) goto L12;
                com.bytedance.android.shopping.api.image.q r17 = r16;
            L14:
                return new c(r10, r11, r12, r13, r17);
            L12:
                r17 = r14;
                goto L14
            L5:
                r1 = r14;
                goto L6
            }
        }

        static {
        }

        public final int a() {
            return this.f.a();
        }

        public final com.bytedance.android.shopping.api.image.n b() {
            return this.f.b();
        }

        public final String c() {
            return this.f.c();
        }

        public final com.bytedance.android.shopping.api.image.n d() {
            return this.f.d();
        }

        public final int e() {
            return this.f.e();
        }

        public final boolean f(String r10, String r11) {
            return this.f.f(r10, r11);
        }

        public final String g() {
            return this.f.g();
        }

        public final String getDomain() {
            return this.f.getDomain();
        }

        public final String getFlag() {
            return this.f.getFlag();
        }

        public final String getFormat() {
            return this.f.getFormat();
        }

        public final String getImageUri() {
            return this.f.getImageUri();
        }

        public final String getOriginUrl() {
            return this.f.getOriginUrl();
        }

        public final com.bytedance.android.shopping.api.image.n getQuality() {
            return this.f.getQuality();
        }

        public final com.bytedance.android.shopping.api.image.u getQuery() {
            return this.f.getQuery();
        }

        public final String getServiceId() {
            return this.f.getServiceId();
        }

        public final Pair<Integer, Integer> h() {
            return this.f.h();
        }

        public final String i() {
            return this.f.i();
        }

        public final boolean isHierarchical() {
            return this.f.isHierarchical();
        }

        public final boolean j() {
            return this.f.j();
        }

        public final Integer k() {
            return this.f.k();
        }

        public final String l() {
            return this.f.l();
        }

        public final boolean m() {
            return this.f.m();
        }

        public final com.bytedance.android.shopping.api.image.t n() {
            return this.f.n();
        }

        public final void o() {
            ECImageMultiSizeReuseOpt r0 = ECImageMultiSizeReuseOpt.e;
            r0.getClass();
            String r1 = getImageUri();
            if (r1 == null) goto L8;
            InnerLruCache r10 = r0.h();
            if (r10 == null) goto L9;
            r10.removeCache(r1, this);
            Unit r11 = Unit.INSTANCE;
            return;
        L9:
            return;
        }

        public c(String r1, int r10, int r11, CacheKey r12, com.bytedance.android.shopping.api.image.q r13) {
            this.b = r1;
            this.c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECImageMultiSizeReuseOpt.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/ECImageMultiReuseModel;", 0))};
        e = new ECImageMultiSizeReuseOpt();
        b = LazyKt.lazy(ECImageMultiSizeReuseOpt$innerRequestCache$2.INSTANCE);
        c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ECImageMultiSizeReuseOpt$enable$2.INSTANCE);
        com.bytedance.android.shopping.api.image.b r0 = new com.bytedance.android.shopping.api.image.b(null);
        ECImageMultiSizeReuseOpt$config$2 r10 = ECImageMultiSizeReuseOpt$config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r11 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r1 = new a(r0, r10, r11);
    L6:
        d = r1;
        return;
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_multi_size_reuse_config", r0, null, r10, r11);
        goto L6
    }

    public ECImageMultiSizeReuseOpt() {
    }

    public static boolean g() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final com.bytedance.android.shopping.api.image.b f() {
        return (com.bytedance.android.shopping.api.image.b) d.getValue(this, a[0]);
    }

    public final InnerLruCache h() {
        if (f() != null) goto L7;
        return null;
    L7:
        return (InnerLruCache) b.getValue();
    }

    public final boolean j() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r0 = f();
        if (r0 == null) goto L7;
        Boolean r1 = r0.h();
    L9:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    public final boolean k() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r0 = f();
        if (r0 == null) goto L7;
        Boolean r1 = r0.i();
    L9:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    public final boolean l() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r0 = f();
        if (r0 == null) goto L7;
        Boolean r1 = r0.j();
    L9:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    public static b c(CacheKey r1) {
        if (r1 == null) goto L4;
        e.getClass();
        return ((InnerLruCache) b.getValue()).getBitmapCache(r1);
    L4:
        return null;
    }

    public static void n(final com.bytedance.android.ec.core.imagex.u r1, final ImageRequest r10) {
        if (r1 == null) goto L7;
        if (r10 == null) goto L8;
        Executor r0 = AsyncWorker.a;
        com.bytedance.android.ec.core.imagex.common.g.a(false, false, new ECImageMultiSizeReuseOpt$recordPreloadCache$1(r1, r10), 3);
        return;
    L8:
        return;
    }

    public final Pair<CacheType, c> e(com.bytedance.android.ec.core.imagex.r r18, com.bytedance.android.shopping.api.image.q r19) {
        Intrinsics.checkNotNullParameter(r18, "callerContext");
        Intrinsics.checkNotNullParameter(r19, "imageXUrlParams");
        com.bytedance.android.shopping.api.image.b r10 = f();
        Pair<CacheType, c> r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (k() == false) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L169;
        if (com.bytedance.android.ec.core.imagex.common.l.b(r10, r18, r19) == false) goto L169;
        String r13 = r19.i();
        if (r13 == null) goto L167;
        Map r14 = r10.k();
        if (r14 == null) goto L21;
        com.bytedance.android.shopping.api.image.o0 r15 = (com.bytedance.android.shopping.api.image.o0) r14.get(r13);
    L22:
        if (r15 == null) goto L167;
        String r16 = r19.getImageUri();
        if (r16 == null) goto L29;
        InnerLruCache r17 = e.h();
        if (r17 == null) goto L29;
        List<c> r20 = r17.get(r16);
    L30:
        boolean r21 = r19.m();
        if (k() == false) goto L43;
        int r22 = t.a;
        Intrinsics.checkNotNullParameter(r10, "$this$ignoreCheckReuseOpt");
        if (r18 == null) goto L39;
        String r23 = r18.f;
        if (r23 == null) goto L39;
        HashSet r110 = r10.b();
        if (r110 == null) goto L39;
        Boolean r24 = Boolean.valueOf(r110.contains(r23));
    L41:
        if (Intrinsics.areEqual(r24, Boolean.TRUE) == true) goto L43;
        boolean r25 = true;
    L45:
        if (l() == false) goto L57;
        int r111 = t.a;
        Intrinsics.checkNotNullParameter(r10, "$this$ignoreCheckThumbOpt");
        if (r18 == null) goto L53;
        String r0 = r18.f;
        if (r0 == null) goto L53;
        HashSet r26 = r10.d();
        if (r26 == null) goto L53;
        Boolean r1 = Boolean.valueOf(r26.contains(r0));
    L55:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L57;
        boolean r27 = true;
    L58:
        List<c> r28 = r20;
        if (r28 != null) goto L61;
    L64:
        boolean r29 = true;
    L65:
        if (r29 == true) goto L164;
        if (r25 == true) goto L68;
        if (r27 == true) goto L68;
        return null;
    L68:
        int r30 = r20.size() - 1;
        c r112 = null;
        c r113 = null;
    L69:
        if (r30 < 0) goto L158;
        c r114 = (c) CollectionsKt.getOrNull(r20, r30);
        if (r114 == null) goto L157;
        if (Intrinsics.areEqual(r114.g(), r19.g()) == true) goto L75;
        if (r114.c == 0) goto L157;
        if (r114.d == 0) goto L157;
        if (r25 == true) goto L83;
        if (r27 == false) goto L157;
    L83:
        String r115 = r114.getFormat();
        String r116 = r19.getFormat();
        if (Intrinsics.areEqual(r115, "image") == false) goto L89;
        if (Intrinsics.areEqual(r116, "image") == false) goto L89;
    L128:
        boolean r31 = true;
    L130:
        if (r31 == false) goto L157;
        boolean r32 = r114.m();
        if (r25 == false) goto L142;
        if (r112 != null) goto L142;
        if (r32 == true) goto L141;
        if (r21 == true) goto L142;
        if (Intrinsics.areEqual(r114.i(), r19.i()) == false) goto L142;
        if (b(r114, r19, true) == false) goto L142;
    L141:
        r112 = r114;
    L142:
        if (r27 == false) goto L157;
        if (r112 != null) goto L157;
        if (Intrinsics.areEqual(r114.i(), r19.i()) == true) goto L153;
        HashSet r33 = r15.a();
        if (r33 == null) goto L157;
        if (CollectionsKt.contains(r33, r114.i()) != true) goto L157;
    L153:
        if (r113 != null) goto L155;
    L156:
        r113 = r114;
        goto L157
    L155:
        if (b(r114, r113, false) == false) goto L157;
    L89:
        if (Intrinsics.areEqual(r115, "image") == false) goto L91;
    L129:
        r31 = false;
        goto L130
    L91:
        if (Intrinsics.areEqual(r116, "image") == true) goto L129;
        TmplConvConfig r117 = TmplConvConfig.k;
        com.bytedance.android.shopping.api.image.p0 r118 = r117.b();
        if (r118 == null) goto L100;
        HashSet r34 = r118.d();
        if (r34 == null) goto L100;
        if (CollectionsKt.contains(r34, r115) != true) goto L100;
        boolean r35 = true;
    L101:
        com.bytedance.android.shopping.api.image.p0 r119 = r117.b();
        if (r119 == null) goto L108;
        HashSet r36 = r119.d();
        if (r36 == null) goto L108;
        if (CollectionsKt.contains(r36, r116) != true) goto L108;
        boolean r37 = true;
    L109:
        if (r35 != r37) goto L129;
        com.bytedance.android.shopping.api.image.p0 r38 = r117.b();
        if (r38 == null) goto L118;
        HashSet r39 = r38.a();
        if (r39 == null) goto L118;
        if (CollectionsKt.contains(r39, r115) != true) goto L118;
        boolean r40 = true;
    L119:
        com.bytedance.android.shopping.api.image.p0 r41 = r117.b();
        if (r41 == null) goto L126;
        HashSet r42 = r41.a();
        if (r42 == null) goto L126;
        if (CollectionsKt.contains(r42, r116) != true) goto L126;
        boolean r43 = true;
    L127:
        if (r40 != r43) goto L129;
    L126:
        r43 = false;
    L118:
        r40 = false;
    L108:
        r37 = false;
    L100:
        r35 = false;
        goto L101
    L75:
        return r11;
    L157:
        r30 = r30 - 1;
        r11 = null;
        goto L69
    L158:
        if (r112 != null) goto L160;
        if (r113 != null) goto L163;
        return null;
    L163:
        return new Pair(CacheType.REUSE_THUMB_CACHE, r113);
    L160:
        return new Pair(CacheType.REUSE_CACHE, r112);
    L164:
        return null;
    L61:
        if (r28.isEmpty() == true) goto L64;
        r29 = false;
    L53:
        r1 = null;
    L57:
        r27 = false;
    L39:
        r24 = null;
    L43:
        r25 = false;
    L29:
        r20 = null;
        goto L30
    L21:
        r15 = null;
    L167:
        return null;
    L169:
        return null;
    L8:
        if (l() == true) goto L11;
        r12 = false;
        goto L12
    }

    public static final CacheKey a(ECImageMultiSizeReuseOpt r1, ImageRequest r10, Object r11) {
        r1.getClass();
        CacheKeyFactory r12 = Fresco.getImagePipelineFactory().getImagePipeline().getCacheKeyFactory();
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r10.getPostprocessor() == null) goto L11;
        return r12.getPostprocessedBitmapCacheKey(r10, r11);
    L11:
        return r12.getBitmapCacheKey(r10, r11);
    }

    public static boolean b(c r10, com.bytedance.android.shopping.api.image.q r11, boolean r12) {
        int r0 = r10.c;
        int r1 = r10.d;
        Pair r13 = i(r10, r0, r1);
        int r14 = ((Number) r13.component1()).intValue();
        int r15 = ((Number) r13.component2()).intValue();
        Pair r16 = i(r11, r0, r1);
        int r17 = ((Number) r16.component1()).intValue();
        int r18 = ((Number) r16.component2()).intValue();
        byte r19 = -1;
        if (r17 != 0) goto L8;
        if (r18 != 0) goto L8;
        if (r14 != 0) goto L17;
        if (r15 != 0) goto L17;
    L15:
        byte r20 = 0;
    L18:
        Integer r21 = r10.getQuality().getValue();
        int r22 = 100;
        Integer r23 = null;
        if (r21 == null) goto L25;
        int r24 = r21.intValue();
        if (r24 > 0) goto L24;
        r24 = 100;
    L24:
        Integer r25 = Integer.valueOf(r24);
    L26:
        Integer r26 = r11.getQuality().getValue();
        if (r26 == null) goto L32;
        int r27 = r26.intValue();
        if (r27 <= 0) goto L31;
        r22 = r27;
    L31:
        r23 = Integer.valueOf(r22);
    L32:
        if (r25 == null) goto L40;
        if (r23 == null) goto L40;
        if (r25.intValue() <= r23.intValue()) goto L38;
        r19 = 1;
        goto L40
    L38:
        if (Intrinsics.areEqual(r25, r23) == false) goto L40;
        r19 = 0;
    L40:
        if (r12 == false) goto L44;
        if (r20 < 0) goto L44;
        if (r19 < 0) goto L44;
        return true;
    L44:
        if (r12 == true) goto L49;
        if (r20 > 0) goto L48;
        if (r20 != 0) goto L49;
        if (r19 < 0) goto L49;
    L48:
        return true;
    L49:
        return false;
    L25:
        r25 = null;
    L17:
        r20 = -1;
    L8:
        if (r14 != 0) goto L11;
        if (r15 != 0) goto L11;
    L16:
        r20 = 1;
    L11:
        if (r14 <= 0) goto L17;
        if (r17 <= 0) goto L17;
        if (r14 < r17) goto L17;
        if (r14 != r17) goto L16;
        goto L15
    }

    public static b d(ImageRequest r1, com.bytedance.android.ec.core.imagex.r r10, boolean r11) {
        if (r1 == null) goto L4;
        e.getClass();
        return ((InnerLruCache) b.getValue()).getBitmapCache(r1, r10, r11);
    L4:
        return null;
    }

    public static Pair i(com.bytedance.android.shopping.api.image.q r10, int r11, int r12) {
        Integer r0 = r10.d().getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r13 = r0.intValue();
    L6:
        Integer r14 = r10.b().getValue();
        if (r14 == null) goto L9;
        r1 = r14.intValue();
    L9:
        if (r13 <= 0) goto L15;
        if (r1 <= 0) goto L15;
        int r15 = (r1 * r11) / r12;
        int r16 = (r12 * r13) / r11;
        if (r15 > r13) goto L22;
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r1));
    L22:
        return new Pair(Integer.valueOf(r13), Integer.valueOf(r16));
    L15:
        if (r13 > 0) goto L23;
        if (r1 <= 0) goto L20;
        return new Pair(Integer.valueOf((r11 * r1) / r12), Integer.valueOf(r1));
    L20:
        return new Pair(Integer.valueOf(r13), Integer.valueOf(r1));
    L23:
        return new Pair(Integer.valueOf(r13), Integer.valueOf((r12 * r13) / r11));
    L5:
        r13 = 0;
        goto L6
    }

    public final void m(final com.bytedance.android.ec.core.imagex.u r10, final ImageRequest r11, ImageInfo r12) {
        Intrinsics.checkNotNullParameter(r10, "imageCallerContext");
        Intrinsics.checkNotNullParameter(r11, "imageRequest");
        Intrinsics.checkNotNullParameter(r12, "image");
        final String r13 = r11.getSourceUri().toString();
        Map r0 = r11.getCustomParam();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("ec_use_multi_image_size_cache");
    L7:
        if (Intrinsics.areEqual(r1, "1") == false) goto L9;
        com.bytedance.android.shopping.api.image.q r14 = r10.A;
    L10:
        final com.bytedance.android.shopping.api.image.q r15 = r14;
        if (r15 == null) goto L23;
        final int r16 = r12.getWidth();
        final int r17 = r12.getHeight();
        if (j() == true) goto L15;
    L20:
        final WeakReference r18 = null;
    L21:
        Executor r19 = AsyncWorker.a;
        com.bytedance.android.ec.core.imagex.common.g.a(false, false, new ECImageMultiSizeReuseOpt$recordCache$1(r16, r17, r15, r11, r10, r13, r18), 3);
        return;
    L15:
        if ((r12 instanceof CloseableStaticBitmap) == true) goto L17;
        r12 = null;
    L17:
        CloseableStaticBitmap r110 = (CloseableStaticBitmap) r12;
        if (r110 == null) goto L20;
        r18 = new WeakReference(r110);
        goto L21
    L23:
        return;
    L9:
        r14 = r10.n();
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
