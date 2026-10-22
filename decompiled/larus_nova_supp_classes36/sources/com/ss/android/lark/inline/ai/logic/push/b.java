package com.ss.android.lark.inline.ai.logic.push;

import androidx.collection.LruCache;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.inline.ai.logic.InlineAIViewModel;
import e0c.k;
import e0c.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.inline.ai.logic.push.a.AbstractC0106a {
    public final InlineAIViewModel b;
    public final LruCache<String, Map<String, Object>> c;
    public final LruCache<String, obb.b> d;
    public final LruCache<String, Object> e;
    public final LruCache<String, Integer> f;
    public final C0107b g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.b$b, reason: collision with other inner class name */
    public static final class C0107b {
        public final Map<String, List<IGetDataCallback<obb.b>>> a;
        public final LruCache<String, obb.b> b;

        public C0107b() {
            this.a = new LinkedHashMap();
            this.b = new LruCache(20);
        }

        public final synchronized void a(String r3, obb.b r4) {
            monitor-enter(this);
            List r0 = (List) ((LinkedHashMap) this.a).get(r3);     // Catch: Throwable -> L14
            if (r0 == null) goto L9;
            Iterator r1 = r0.iterator();     // Catch: Throwable -> L14
        L7:
            if (r1.hasNext() == false) goto L9;
            ((IGetDataCallback) r1.next()).onSuccess(r4);     // Catch: Throwable -> L14
        L9:
            List r5 = (List) ((LinkedHashMap) this.a).get(r3);     // Catch: Throwable -> L14
            if (r5 == null) goto L12;
            r5.clear();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public b(InlineAIViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "inlineAIViewModel");
        this.b = r2;
        this.c = new LruCache(20);
        this.d = new LruCache(20);
        this.e = new LruCache(20);
        this.f = new LruCache(20);
        this.g = new C0107b();
    }

    public static final obb.b c(b r3, String r4) {
        monitor-enter(r3);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r3.e.get(r4) == null) goto L7;
        monitor-exit(r3);
        return null;
    L7:
        obb.b r0 = (obb.b) r3.d.get(r4);     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        monitor-exit(r3);
    L22:
        return r0;
    L11:
        sbb.c.a.getClass();     // Catch: Throwable -> L18
        r0 = sbb.c.e(r4);     // Catch: Throwable -> L18
        if (r0 == null) goto L14;
        r3.d.put(r4, r0);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r3);
        goto L22
    L14:
        r3.e.put(r4, new Object());     // Catch: Throwable -> L18
        goto L15
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (CollectionsKt.listOf(new String[]{"processing", "success"}).contains(r11.task_status) == false) goto L5;
        String r2 = r11.unique_task_id;
        int r3 = (int) r11.seq_id.longValue();
        String r1 = r11.content;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.b), Dispatchers.getIO(), null, new UrlRecognizeFilter$extractDocsUrl$1(r1, r2, r3, this, null), 2, null);
    L5:
        b(r11, false);
    }

    public static final Object d(b r6, obb.b r7, Continuation r8) {
        r6.getClass();
        final j r0 = new j(IntrinsicsKt.intercepted(r8), 1);
        r0.C();
        C0107b r9 = r6.g;
        IGetDataCallback<obb.b> r1 = new UrlRecognizeFilter$requestDocsMeta$2$1(r0);
        monitor-enter(r9);
        Intrinsics.checkNotNullParameter(r7, "docsMetaInfo");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r1, "callback");     // Catch: Throwable -> L22
        String r3 = r7.getType() + '_' + r7.b;     // Catch: Throwable -> L22
        obb.b r4 = (obb.b) r9.b.get(r3);     // Catch: Throwable -> L22
        if (r4 == null) goto L10;
        r9.a(r3, r4);     // Catch: Throwable -> L22
        monitor-exit(r9);
    L18:
        Object r10 = r0.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L21:
        return r10;
    L10:
        if (r9.a.containsKey(r3) == false) goto L16;
        List r11 = (List) ((LinkedHashMap) r9.a).get(r3);     // Catch: Throwable -> L22
        if (r11 == null) goto L14;
        r11.add(r1);     // Catch: Throwable -> L22
    L14:
        monitor-exit(r9);
        goto L18
    L16:
        r9.a.put(r3, CollectionsKt.mutableListOf(new IGetDataCallback[]{r1}));     // Catch: Throwable -> L22
        qbb.c r2 = new qbb.c(null);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r2, "userScopeView");     // Catch: Throwable -> L22
        l r5 = r2.provideComponent();     // Catch: Throwable -> L22
        r2.e9();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(qbb.a.class, "userScopeApi");     // Catch: Throwable -> L22
        ((qbb.a) k.b(r5, qbb.a.class)).a(r7).subscribe(new c(r9, r3), new d(r9, r3));     // Catch: Throwable -> L22
        monitor-exit(r9);
    L22:
        th = move-exception;
        throw th;
    }
}
