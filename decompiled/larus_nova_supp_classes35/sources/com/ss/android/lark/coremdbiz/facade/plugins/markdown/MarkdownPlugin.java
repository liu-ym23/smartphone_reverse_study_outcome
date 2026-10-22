package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.coremd.impl.parse.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableMarkdownDocumentParser;
import com.ss.android.lark.movable.attatchment.m;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MarkdownPlugin implements com.ss.android.lark.coremd.base.parse.g {
    public static final Companion b = null;
    public static final LinkedHashMap<h, com.ss.android.lark.movable.h> c = null;
    public static final HashMap<h, Deferred<com.ss.android.lark.movable.h>> d = null;
    public static final CoroutineScope e = null;
    public static final HashMap<a, Job> f = null;
    public final CoroutineScope a;

    public static final class Companion {

        public static final class a implements Function2<String, Float, m> {
            public a() {
            }

            public final Object invoke(Object r2, Object r3) {
                String r4 = (String) r2;
                float r5 = ((Number) r3).floatValue();
                Intrinsics.checkNotNullParameter(r4, "p1");
                return d.a.a(r4, r5);
            }
        }

        public static void a() {
            LinkedHashMap<h, com.ss.android.lark.movable.h> r1 = MarkdownPlugin.c;
            monitor-enter(r1);
            Log.d("MarkdownPlugin", "clear renderCache, size: " + r1.size());     // Catch: Throwable -> L11
            Iterator<T> r0 = r1.values().iterator();     // Catch: Throwable -> L11
        L6:
            if (r0.hasNext() == false) goto L8;
            ((com.ss.android.lark.movable.h) r0.next()).b.a();     // Catch: Throwable -> L11
            goto L6
        L8:
            MarkdownPlugin.c.clear();     // Catch: Throwable -> L11
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r1);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public Companion() {
        }

        public static com.ss.android.lark.movable.h b(h r1) {
            LinkedHashMap<h, com.ss.android.lark.movable.h> r0 = MarkdownPlugin.c;
            monitor-enter(r0);
            com.ss.android.lark.movable.h r2 = r0.get(r1);     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public static void e(h r4, com.ss.android.lark.movable.h r5) {
            Intrinsics.checkNotNullParameter(r4, "renderKey");
            Intrinsics.checkNotNullParameter(r5, "parsedDocument");
            LinkedHashMap<h, com.ss.android.lark.movable.h> r1 = MarkdownPlugin.c;
            monitor-enter(r1);
        L29:
            th = move-exception;
            throw th;
        L5:
            if (r1.containsKey(r4) == false) goto L18;
            StringBuilder r3 = new StringBuilder("putCachedDocument, docId: ");     // Catch: Throwable -> L29
            r3.append(UInt.toString-impl(r5.a.getDocumentId-pVg5ArA()));     // Catch: Throwable -> L29
            r3.append(", release id: ");     // Catch: Throwable -> L29
            com.ss.android.lark.movable.h r0 = r1.get(r4);     // Catch: Throwable -> L29
            if (r0 == null) goto L11;
            MovableDocumentInfo r2 = r0.a;     // Catch: Throwable -> L29
            if (r2 == null) goto L11;
            UInt r6 = UInt.box-impl(r2.getDocumentId-pVg5ArA());     // Catch: Throwable -> L29
        L12:
            r3.append(r6);     // Catch: Throwable -> L29
            Log.d("MarkdownPlugin", r3.toString());     // Catch: Throwable -> L29
            com.ss.android.lark.movable.h r7 = r1.get(r4);     // Catch: Throwable -> L29
            if (r7 == null) goto L18;
            com.ss.android.lark.movable.d r8 = r7.b;     // Catch: Throwable -> L29
            if (r8 == null) goto L18;
            r8.a();     // Catch: Throwable -> L29
        L11:
            r6 = null;
        L18:
            if (r1.size() < 20) goto L26;
            h r9 = (h) CollectionsKt.firstOrNull(r1.keySet());     // Catch: Throwable -> L29
            if (r9 == null) goto L26;
            com.ss.android.lark.movable.h r10 = r1.remove(r9);     // Catch: Throwable -> L29
            if (r10 == null) goto L26;
            com.ss.android.lark.movable.d r11 = r10.b;     // Catch: Throwable -> L29
            if (r11 == null) goto L26;
            r11.a();     // Catch: Throwable -> L29
        L26:
            r1.put(r4, r5);     // Catch: Throwable -> L29
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L29
            monitor-exit(r1);
        }

        public static Object d(h r8, MovableRenderConfig r9, MovableRenderUrlPreviewInlines r10, Continuation r11) {
            com.ss.android.lark.movable.h r0 = b(r8);
            if (r0 == null) goto L5;
            return r0;
        L5:
            HashMap<h, Deferred<com.ss.android.lark.movable.h>> r1 = MarkdownPlugin.d;
            monitor-enter(r1);
            Deferred<com.ss.android.lark.movable.h> r2 = r1.get(r8);     // Catch: Throwable -> L13
            if (r2 != null) goto L10;
            r2 = BuildersKt.async$default(MarkdownPlugin.e, null, null, new MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1(r8, r9, r10, null), 3, null);     // Catch: Throwable -> L13
            r1.put(r8, r2);     // Catch: Throwable -> L13
        L10:
            monitor-exit(r1);
            return r2.await(r11);
        L13:
            th = move-exception;
            throw th;
        }

        public final Object c(h r12, MovableRenderConfig r13, MovableRenderUrlPreviewInlines r14, Continuation<? super com.ss.android.lark.movable.h> r15) {
            if ((r15 instanceof MarkdownPlugin$Companion$parseAndCacheDocument$1) == false) goto L7;
            MarkdownPlugin$Companion$parseAndCacheDocument$1 r1 = (MarkdownPlugin$Companion$parseAndCacheDocument$1) r15;
            int r2 = r1.label;
            if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
            r1.label = r2 - PluginList.LEVEL_NOT_SET;
        L8:
            MarkdownPlugin$Companion$parseAndCacheDocument$1 r7 = r1;
            Object r16 = r7.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r7.label;
            if (r4 == 0) goto L18;
            if (r4 != 1) goto L17;
            eab.e r17 = (eab.e) r7.L$1;
            h r18 = (h) r7.L$0;
            ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
        L28:
            com.ss.android.lark.movable.h r19 = (com.ss.android.lark.movable.h) r16;     // Catch: Throwable -> L14
            if (r19 == null) goto L35;
            Companion r110 = MarkdownPlugin.b;     // Catch: Throwable -> L14
            e(r18, r19);     // Catch: Throwable -> L14
            Log.d("MarkdownPlugin", "parseMarkdownForClient, docId: " + UInt.toString-impl(r19.a.getDocumentId-pVg5ArA()) + "，isMainThread：" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));     // Catch: Throwable -> L14
            Map<String, ImageSetV2> r111 = r17.k;
            if (r111 == null) goto L34;
            d r112 = d.a;
            Intrinsics.checkNotNullParameter(r111, "sizeAttr");
            ((ArrayList) d.b).remove(r111);
        L34:
            return r19;
        L35:
            Map<String, ImageSetV2> r113 = r17.k;
            if (r113 == null) goto L52;
            d r114 = d.a;
            Intrinsics.checkNotNullParameter(r113, "sizeAttr");
            ((ArrayList) d.b).remove(r113);
            return null;
        L52:
            return null;
        L14:
            Throwable th = th;
            eab.e r115 = r17;
        L43:
            Map<String, ImageSetV2> r116 = r115.k;
            if (r116 == null) goto L51;
            d r117 = d.a;
            Intrinsics.checkNotNullParameter(r116, "sizeAttr");
            ((ArrayList) d.b).remove(r116);
            throw th;
        L51:
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r16);
            if (r12.a >= 20.0f) goto L21;
            Log.e("MarkdownPlugin", new Throwable());
        L21:
            r115 = r12.b;
            String r5 = r115.j;
            float r6 = r12.a;
            Map<String, ImageSetV2> r8 = r115.k;
            if (r8 == null) goto L47;
            d r9 = d.a;
            Intrinsics.checkNotNullParameter(r8, "sizeAttr");
            ((ArrayList) d.b).add(r8);
        L47:
            int r10 = MovableMarkdownDocumentParser.a;     // Catch: Throwable -> L41
            a r11 = new a();     // Catch: Throwable -> L41
            r7.L$0 = r12;     // Catch: Throwable -> L41
            r7.L$1 = r115;     // Catch: Throwable -> L41
            r7.label = 1;     // Catch: Throwable -> L41
            Object r118 = MovableMarkdownDocumentParser.b(r5, r6, r13, r14, r11, r7);     // Catch: Throwable -> L41
            if (r118 != r3) goto L27;
            return r3;
        L27:
            r18 = r12;
            r17 = r115;
            r16 = r118;
        L41:
            th = move-exception;
            th = th;
        L7:
            r1 = new MarkdownPlugin$Companion$parseAndCacheDocument$1(this, r15);
            goto L8
        }
    }

    static {
        b = new Companion();
        c = new LinkedHashMap();
        d = new HashMap();
        e = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f = new HashMap();
    }

    public MarkdownPlugin() {
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static String e(MovableRenderUrlPreviewInlines r9) {
        if (r9 == null) goto L6;
        List r10 = r9.getItems();
        if (r10 == null) goto L6;
        String r11 = CollectionsKt.joinToString$default(r10, "\u001f", null, null, 0, null, MarkdownPlugin$toDigest$1.INSTANCE, 30, null);
    L7:
        if (r11 != null) goto L10;
        return BuildConfig.FLAVOR;
    L10:
        return r11;
    L6:
        r11 = null;
        goto L7
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.e.class, new f());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.e.class, new e(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }
}
