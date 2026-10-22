package com.obric.assistant.upload.internal;

import androidx.collection.LruCache;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.UploadDataType;
import com.obric.assistant.upload.Scene;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFileUploader {

    public static final class a {
    }

    static {
    }

    public ObricFileUploader() {
    }

    public static void b(List r7) {
        Intrinsics.checkNotNullParameter(r7, "identifiers");
        if (((ArrayList) r7).isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = j.a;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricFileUploader$deleteRemoteResources$1(r7, null), 3, null);
    }

    public final void c(String r13, File r14, Scene r15) {
        Intrinsics.checkNotNullParameter(r13, "identifier");
        Intrinsics.checkNotNullParameter(r14, "file");
        Intrinsics.checkNotNullParameter(r15, "scene");
        long r7 = System.currentTimeMillis();
        LruCache<String, l> r1 = k.a;
        Intrinsics.checkNotNullParameter(r13, "identifier");
        k.a.put(r13, new l(0));
        int r0 = j.a;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricFileUploader$uploadImage$1(r13, r14, r15, this, r7, null), 3, null);
    }

    public static final Object a(ObricFileUploader r30, final String r31, final UplinkFileEntity r32, String r33, Scene r34, UploadDataType r35, final long r36, Continuation r38) {
        r30.getClass();
        final long r14 = System.currentTimeMillis();
        CoroutineScope r1 = com.obric.assistant.chat.api.f.a;
        Intrinsics.checkNotNullParameter(r31, "identifier");
        Object r2 = com.obric.assistant.chat.api.f.b;
        monitor-enter(r2);
        com.obric.assistant.chat.api.f.c(r14);     // Catch: Throwable -> L26
        LinkedHashMap r3 = com.obric.assistant.chat.api.f.d;     // Catch: Throwable -> L26
        Object r4 = r3.get(r31);     // Catch: Throwable -> L26
        if (r4 != null) goto L7;
        r4 = new com.obric.assistant.chat.api.f.b(0);     // Catch: Throwable -> L26
        r3.put(r31, r4);     // Catch: Throwable -> L26
    L7:
        com.obric.assistant.chat.api.f.b r5 = (com.obric.assistant.chat.api.f.b) r4;     // Catch: Throwable -> L26
        if (r5.a > 0) goto L10;
        r5.a = r14;     // Catch: Throwable -> L26
    L10:
        com.obric.assistant.chat.api.f.a r6 = (com.obric.assistant.chat.api.f.a) ((LinkedHashMap) com.obric.assistant.chat.api.f.g).get(r31);     // Catch: Throwable -> L26
        if (r6 == null) goto L14;
        r6.f = r5.a;     // Catch: Throwable -> L26
    L14:
        if (r3.size() <= 100) goto L19;
        String r7 = (String) CollectionsKt.firstOrNull(r3.keySet());     // Catch: Throwable -> L26
        if (r7 == null) goto L19;
        r3.remove(r7);     // Catch: Throwable -> L26
    L19:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r2);
        ResourceUploader r11 = ResourceUploader.a;
        String r10 = r34.getValue();
        CountDownLatch r9 = new CountDownLatch(1);
        mr9.h r12 = new mr9.h(true, null, r32, 26);
        Object r0 = r11.j(new mr9.j(r33, r10, r35, new com.obric.assistant.upload.internal.a(r31, r32, r36, r14), new b(r31, r32), new c(r31, r32, r36, r14), false, null, null, null, r31, true, r9, r12, null, null, null, null, null, null, 2065344), r38);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r0;
    L25:
        return Unit.INSTANCE;
    L26:
        th = move-exception;
        throw th;
    }
}
