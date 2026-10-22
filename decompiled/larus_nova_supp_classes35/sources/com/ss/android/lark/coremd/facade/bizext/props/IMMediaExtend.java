package com.ss.android.lark.coremd.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMMediaExtend implements f {
    public static final a q = null;
    public static final /* synthetic */ KProperty<Object>[] r = null;
    public final c c;
    public final c d;
    public final m e;
    public final c f;
    public final c g;
    public final m h;
    public final c i;
    public final c j;
    public final c k;
    public final c l;
    public final c m;
    public final c n;
    public final c o;
    public final c p;

    public static final class a implements h<IMMediaExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super IMMediaExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMMediaExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMMediaExtend.class);
        }
    }

    static {
        r = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageKey", "getCoverImageKey(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageFsUnit", "getCoverImageFsUnit(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageCrypto", "getCoverImageCrypto(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Lokio/ByteString;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageUrl", "getCoverImageUrl(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImagePath", "getCoverImagePath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "resourceCleanScene", "getResourceCleanScene(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Lcom/ss/android/lark/image/entity/ResourceCleanScene;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "url", "getUrl(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "originPath", "getOriginPath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "compressPath", "getCompressPath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "cryptoToken", "getCryptoToken(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "mimeType", "getMimeType(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "mediaUploadId", "getMediaUploadId(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "imageUploadId", "getImageUploadId(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "needCopy", "getNeedCopy(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Z", 0))};
        q = new a();
    }

    public IMMediaExtend() {
        final String r1 = BuildConfig.FLAVOR;
        Function1<j, String> r0 = new IMMediaExtend$special$$inlined$extend$1(r1);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r3 = r;
        KProperty<Object> r4 = r3[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r4), r0);
        this.c = new c();
        Function1<j, String> r2 = new IMMediaExtend$special$$inlined$extend$2(r1);
        Intrinsics.checkNotNullParameter(r2, "defaultProvider");
        KProperty<Object> r5 = r3[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r2, "value");
        r9.put(e.a(r5), r2);
        this.d = new c();
        KProperty<Object> r6 = r3[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        this.e = new m();
        Function1<j, String> r8 = new IMMediaExtend$special$$inlined$extend$3(r1);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r10 = r3[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r10, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r9.put(e.a(r10), r8);
        this.f = new c();
        Function1<j, String> r11 = new IMMediaExtend$special$$inlined$extend$4(r1);
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r3[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r9.put(e.a(r12), r11);
        this.g = new c();
        KProperty<Object> r13 = r3[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r13, "property");
        this.h = new m();
        Function1<j, String> r14 = new IMMediaExtend$special$$inlined$extend$5(r1);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r3[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r9.put(e.a(r15), r14);
        this.i = new c();
        Function1<j, String> r16 = new IMMediaExtend$special$$inlined$extend$6(r1);
        Intrinsics.checkNotNullParameter(r16, "defaultProvider");
        KProperty<Object> r17 = r3[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r17, "property");
        Intrinsics.checkNotNullParameter(r17, "kProperty");
        Intrinsics.checkNotNullParameter(r16, "value");
        r9.put(e.a(r17), r16);
        this.j = new c();
        Function1<j, String> r18 = new IMMediaExtend$special$$inlined$extend$7(r1);
        Intrinsics.checkNotNullParameter(r18, "defaultProvider");
        KProperty<Object> r19 = r3[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r19, "property");
        Intrinsics.checkNotNullParameter(r19, "kProperty");
        Intrinsics.checkNotNullParameter(r18, "value");
        r9.put(e.a(r19), r18);
        this.k = new c();
        Function1<j, String> r20 = new IMMediaExtend$special$$inlined$extend$8(r1);
        Intrinsics.checkNotNullParameter(r20, "defaultProvider");
        KProperty<Object> r21 = r3[9];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r21, "property");
        Intrinsics.checkNotNullParameter(r21, "kProperty");
        Intrinsics.checkNotNullParameter(r20, "value");
        r9.put(e.a(r21), r20);
        this.l = new c();
        Function1<j, String> r22 = new IMMediaExtend$special$$inlined$extend$9(r1);
        Intrinsics.checkNotNullParameter(r22, "defaultProvider");
        KProperty<Object> r23 = r3[10];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r23, "property");
        Intrinsics.checkNotNullParameter(r23, "kProperty");
        Intrinsics.checkNotNullParameter(r22, "value");
        r9.put(e.a(r23), r22);
        this.m = new c();
        Function1<j, String> r24 = new IMMediaExtend$special$$inlined$extend$10(r1);
        Intrinsics.checkNotNullParameter(r24, "defaultProvider");
        KProperty<Object> r25 = r3[11];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r25, "property");
        Intrinsics.checkNotNullParameter(r25, "kProperty");
        Intrinsics.checkNotNullParameter(r24, "value");
        r9.put(e.a(r25), r24);
        this.n = new c();
        Function1<j, String> r26 = new IMMediaExtend$special$$inlined$extend$11(r1);
        Intrinsics.checkNotNullParameter(r26, "defaultProvider");
        KProperty<Object> r27 = r3[12];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r27, "property");
        Intrinsics.checkNotNullParameter(r27, "kProperty");
        Intrinsics.checkNotNullParameter(r26, "value");
        r9.put(e.a(r27), r26);
        this.o = new c();
        final Boolean r28 = Boolean.FALSE;
        Function1<j, Boolean> r29 = new IMMediaExtend$special$$inlined$extend$12(r28);
        Intrinsics.checkNotNullParameter(r29, "defaultProvider");
        KProperty<Object> r30 = r3[13];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r30, "property");
        Intrinsics.checkNotNullParameter(r30, "kProperty");
        Intrinsics.checkNotNullParameter(r29, "value");
        r9.put(e.a(r30), r29);
        this.p = new c();
    }

    public static String g(eab.f r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.k;
    }

    public final ByteString a(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (ByteString) this.e.getValue(r4, r[2]);
    }

    public final String b(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.d.getValue(r4, r[1]);
    }

    public final String d(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.c.getValue(r4, r[0]);
    }

    public final String f(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.f.getValue(r4, r[3]);
    }

    public final String h(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.j.getValue(r4, r[7]);
    }

    public final ResourceCleanScene i(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (ResourceCleanScene) this.h.getValue(r4, r[5]);
    }

    public final String j(eab.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.i.getValue(r4, r[6]);
    }
}
