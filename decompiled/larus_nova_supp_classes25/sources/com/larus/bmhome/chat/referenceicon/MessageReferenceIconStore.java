package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.bytedance.keva.Keva;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import hq9.v2;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageReferenceIconStore {
    public static final MessageReferenceIconStore a = null;
    public static final Object b = null;
    public static final MessageReferenceIconStore$bitmapCache$1 c = null;
    public static final LruCache<String, Integer> d = null;
    public static final Lazy e = null;
    public static final ThreadLocal<MessageDigest> f = null;
    public static final Map<String, CompletableDeferred<a>> g = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$a$a, reason: collision with other inner class name */
        public static final class C0069a extends a {
            public static final C0069a a = null;

            static {
                a = new C0069a();
            }

            public C0069a() {
            }
        }

        public static final class b extends a {
            public final Bitmap a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(bitmap=" + this.a + ')';
            }

            public b(Bitmap r2) {
                Intrinsics.checkNotNullParameter(r2, "bitmap");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public MessageReferenceIconStore() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$bitmapCache$1] */
    static {
        a = new MessageReferenceIconStore();
        b = new Object();
        c = new MessageReferenceIconStore$bitmapCache$1();
        d = new LruCache(256);
        e = LazyKt.lazy(new d());
        f = ThreadLocal.withInitial(new e());
        g = new LinkedHashMap();
    }

    public static Keva f() {
        return (Keva) e.getValue();
    }

    public static String b(String r2) {
        return "document:" + r2;
    }

    public static String c(String r11) {
        StringBuilder r0 = new StringBuilder("obj_type:");
        MessageDigest r1 = f.get();
        r1.reset();
        r0.append(ArraysKt.joinToString$default(r1.digest(r11.getBytes(Charsets.UTF_8)), "", null, null, 0, null, new f(), 30, null));
        return r0.toString();
    }

    public static Bitmap e(String r4) {
        Object r0 = b;
        monitor-enter(r0);
        MessageReferenceIconStore$bitmapCache$1 r1 = c;     // Catch: Throwable -> L14
        Bitmap r2 = (Bitmap) r1.get(r4);     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        boolean r3 = r2.isRecycled();     // Catch: Throwable -> L14
        if (r3 == false) goto L9;
        r1.remove(r4);     // Catch: Throwable -> L14
    L9:
        if (r3 == true) goto L11;
    L12:
        monitor-exit(r0);
        return r2;
    L11:
        r2 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static Integer g(String r6) {
        Intrinsics.checkNotNullParameter(r6, "documentUrl");
        Integer r1 = null;
        if (StringsKt.isBlank(r6) == false) goto L5;
        return null;
    L5:
        String r0 = b(r6);
        String r7 = c(r6);
        Object r2 = b;
        monitor-enter(r2);
        LruCache<String, Integer> r3 = d;     // Catch: Throwable -> L21
        Integer r4 = (Integer) r3.get(r0);     // Catch: Throwable -> L21
        if (r4 != null) goto L18;
        boolean r5 = false;
        Integer r8 = Integer.valueOf(f().getInt(r7, 0));     // Catch: Throwable -> L21
        if (r8.intValue() == 0) goto L12;
        r5 = true;
    L12:
        if (r5 == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L19;
        r3.put(r0, Integer.valueOf(r8.intValue()));     // Catch: Throwable -> L21
        r1 = r8;
    L19:
        monitor-exit(r2);
        return r1;
    L18:
        r1 = r4;
    L21:
        th = move-exception;
        throw th;
    }

    public static void k(String r10) {
        LinkedHashSet r0 = new LinkedHashSet(SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(f().getString("__document_obj_type_index__", "")), MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1.INSTANCE), MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2.INSTANCE)));
        r0.remove(r10);
        r0.add(r10);
    L4:
        if (r0.size() <= 256) goto L9;
        String r11 = (String) CollectionsKt.firstOrNull(r0);
        if (r11 == null) goto L9;
        r0.remove(r11);
        f().erase(r11);
    L9:
        f().storeString("__document_obj_type_index__", CollectionsKt.joinToString$default(r0, "\n", null, null, 0, null, null, 62, null));
    }

    public static void j(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "documentUrl");
        if (StringsKt.isBlank(r4) == true) goto L24;
        if (r5 == 0) goto L27;
        String r0 = b(r4);
        String r6 = c(r4);
        Object r1 = b;
        monitor-enter(r1);
        LruCache<String, Integer> r2 = d;     // Catch: Throwable -> L21
        Integer r3 = (Integer) r2.get(r0);     // Catch: Throwable -> L21
        if (r3 != null) goto L12;
    L15:
        r2.put(r0, Integer.valueOf(r5));     // Catch: Throwable -> L21
        if (f().getInt(r6, 0) == r5) goto L18;
        f().storeInt(r6, r5);     // Catch: Throwable -> L21
        k(r6);     // Catch: Throwable -> L21
    L18:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r1);
        return;
    L12:
        if (r3.intValue() != r5) goto L15;
        monitor-exit(r1);
        return;
    L21:
        th = move-exception;
        throw th;
    L27:
        return;
    }

    public static String a(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "type");
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L5;
    L32:
        return null;
    L5:
        if (r8 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L32;
        if (r9 == null) goto L17;
        Long r4 = StringsKt.toLongOrNull(r9);
        if (r4 == null) goto L17;
        long r5 = r4.longValue();
    L19:
        if (r5 <= 0) goto L32;
        String r3 = AccountService.a.getUserId();
        if ((true ^ StringsKt.isBlank(r3)) == true) goto L25;
        r3 = null;
    L25:
        if (r3 != null) goto L27;
        return null;
    L27:
        v2 r0 = LarkSocialExp.a();
        if (r0 != null) goto L31;
        return null;
    L31:
        return "avatar:" + r3 + ':' + r0.a + ':' + r0.b + ':' + r7 + ':' + r9 + ':' + r8;
    L17:
        r5 = 0;
        goto L19
    L7:
        if (StringsKt.isBlank(r8) == true) goto L10;
        r2 = false;
        goto L11
    }

    public static void d(String r3, CompletableDeferred r4, a r5) {
        Object r0 = b;
        monitor-enter(r0);
        Map<String, CompletableDeferred<a>> r1 = g;     // Catch: Throwable -> L11
        if (((LinkedHashMap) r1).get(r3) != r4) goto L7;
        r1.remove(r3);     // Catch: Throwable -> L11
    L7:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        r4.complete(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00b7 -> B:51:0x00ba). Please report as a decompilation issue!!! */
    public final Object h(String r12, Function1<? super Continuation<? super Bitmap>, ? extends Object> r13, Continuation<? super Bitmap> r14) {
        if ((r14 instanceof MessageReferenceIconStore$getOrLoad$1) == false) goto L7;
        MessageReferenceIconStore$getOrLoad$1 r0 = (MessageReferenceIconStore$getOrLoad$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Bitmap r4 = null;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 != 2) goto L20;
        CompletableDeferred r16 = (CompletableDeferred) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15 CancellationException -> L17
    L64:
        Bitmap r18 = (Bitmap) r15;     // Catch: Throwable -> L15 CancellationException -> L17
        if (r18 != null) goto L67;
    L69:
        r18 = null;
    L70:
        if (r18 == null) goto L90;
        Object r5 = b;     // Catch: Throwable -> L15 CancellationException -> L17
        monitor-enter(r5);     // Catch: Throwable -> L15 CancellationException -> L17
        MessageReferenceIconStore$bitmapCache$1 r6 = c;     // Catch: Throwable -> L87
        Bitmap r7 = (Bitmap) r6.get(r17);     // Catch: Throwable -> L87
        if (r7 == null) goto L80;
        boolean r8 = r7.isRecycled();     // Catch: Throwable -> L87
        if (r8 == false) goto L78;
        r6.remove(r17);     // Catch: Throwable -> L87
    L78:
        if (r8 == true) goto L80;
        r4 = r7;
    L80:
        if (r4 != null) goto L83;
        r6.put(r17, r18);     // Catch: Throwable -> L87
    L84:
        monitor-exit(r5);     // Catch: Throwable -> L15 CancellationException -> L17
        d(r17, r16, new a.b(r18));     // Catch: Throwable -> L15 CancellationException -> L17
        return r18;
    L83:
        r18 = r4;
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15 CancellationException -> L17
    L90:
        d(r17, r16, a.C0069a.a);     // Catch: Throwable -> L15 CancellationException -> L17
        return r18;
    L67:
        if (r18.isRecycled() == true) goto L69;
    L17:
        CancellationException e2 = e;
    L98:
        d(r17, r16, a.C0069a.a);
        throw e2;
    L15:
        Throwable th = th;
    L94:
        d(r17, r16, a.C0069a.a);
        throw th;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        Function1<? super Continuation<? super Bitmap>, ? extends Object> r19 = (Function1) r0.L$1;
        String r110 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        r13 = r19;
        r12 = r110;
    L51:
        a r111 = (a) r15;
        if ((r111 instanceof a.b) == false) goto L56;
        return ((a.b) r111).a;
    L56:
        if (Intrinsics.areEqual(r111, a.C0069a.a) == true) goto L23;
        throw new NoWhenBranchMatchedException();
    L23:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        Object r10 = b;
        monitor-enter(r10);
        MessageReferenceIconStore$bitmapCache$1 r11 = c;     // Catch: Throwable -> L100
        Bitmap r20 = (Bitmap) r11.get(r12);     // Catch: Throwable -> L100
        if (r20 == null) goto L33;
        boolean r21 = r20.isRecycled();     // Catch: Throwable -> L100
        if (r21 == false) goto L31;
        r11.remove(r12);     // Catch: Throwable -> L100
    L31:
        if (Boxing.boxBoolean(r21).booleanValue() == true) goto L33;
    L34:
        r112.element = r20;     // Catch: Throwable -> L100
        if (r20 == null) goto L37;
        CompletableDeferred r22 = null;
    L40:
        monitor-exit(r10);
        Bitmap r113 = (Bitmap) r112.element;
        if (r113 != null) goto L43;
        if (r22 == null) goto L23;
        if (r9.element == true) goto L107;
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.label = 1;
        r15 = r22.await(r0);
        if (r15 != r2) goto L51;
        return r2;
    L107:
        r0.L$0 = r12;     // Catch: Throwable -> L92 CancellationException -> L96
        r0.L$1 = r22;     // Catch: Throwable -> L92 CancellationException -> L96
        r0.label = 2;     // Catch: Throwable -> L92 CancellationException -> L96
        r15 = r13.invoke(r0);     // Catch: Throwable -> L92 CancellationException -> L96
        if (r15 != r2) goto L63;
        return r2;
    L63:
        r17 = r12;
        r16 = r22;
        goto L64
    L96:
        e = move-exception;
        e2 = e;
        r17 = r12;
        r16 = r22;
    L92:
        th = move-exception;
        th = th;
        r17 = r12;
        r16 = r22;
        goto L94
    L43:
        return r113;
    L37:
        Map<String, CompletableDeferred<a>> r23 = g;     // Catch: Throwable -> L100
        r22 = (CompletableDeferred) ((LinkedHashMap) r23).get(r12);     // Catch: Throwable -> L100
        if (r22 != null) goto L40;
        r22 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L100
        r23.put(r12, r22);     // Catch: Throwable -> L100
        r9.element = true;     // Catch: Throwable -> L100
    L33:
        r20 = null;
    L100:
        th = move-exception;
        throw th;
    L22:
        ResultKt.throwOnFailure(r15);
    L7:
        r0 = new MessageReferenceIconStore$getOrLoad$1(this, r14);
        goto L8
    }

    public final Object i(Context r15, String r16, String r17, String r18, Continuation<? super Bitmap> r19) {
        if ((r19 instanceof MessageReferenceIconStore$loadAvatar$1) == false) goto L7;
        MessageReferenceIconStore$loadAvatar$1 r2 = (MessageReferenceIconStore$loadAvatar$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r6 = (String) r2.L$3;
        String r7 = (String) r2.L$2;
        String r8 = (String) r2.L$1;
        String r9 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L21:
        Bitmap r10 = (Bitmap) r1;
        if (r10 != null) goto L24;
        return null;
    L24:
        if (Intrinsics.areEqual(r6, a(r9, r8, r7)) == true) goto L26;
        return null;
    L26:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r11 = a(r16, r17, r18);
        if (r11 != null) goto L17;
        return null;
    L17:
        MessageReferenceIconStore$loadAvatar$bitmap$1 r12 = new MessageReferenceIconStore$loadAvatar$bitmap$1(r11, r16, r17, r18, r15, null);
        r2.L$0 = r16;
        r2.L$1 = r17;
        r2.L$2 = r18;
        r2.L$3 = r11;
        r2.label = 1;
        Object r13 = h(r11, r12, r2);
        if (r13 != r4) goto L20;
        return r4;
    L20:
        r6 = r11;
        r1 = r13;
        r9 = r16;
        r8 = r17;
        r7 = r18;
    L7:
        r2 = new MessageReferenceIconStore$loadAvatar$1(this, r19);
        goto L8
    }
}
