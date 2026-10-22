package com.ss.android.lark.integrator.im.impl.preview;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeUrlPreviewSessionImpl implements h {
    public final UrlPreviewService a;
    public final com.ss.android.lark.chat.preview.service.d b;
    public final sza.b c;
    public final sza.d d;
    public final com.ss.android.lark.integrator.im.impl.preview.c e;
    public final com.ss.android.lark.integrator.im.impl.preview.a f;
    public final CoroutineScope g;
    public final AtomicBoolean h;
    public final ConcurrentHashMap<String, Long> i;
    public final ConcurrentHashMap<c, b> j;
    public final Object k;
    public Integer l;
    public final e m;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final UrlPreviewCardType b;
        public final long c;
        public final int d;
        public final int e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "RenderBuildKey(previewId=" + this.a + ", cardType=" + this.b + ", generation=" + this.c + ", entityVersion=" + this.d + ", maxWidth=" + this.e + ')';
        }

        public b(String r2, UrlPreviewCardType r3, long r4, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "previewId");
            Intrinsics.checkNotNullParameter(r3, "cardType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    public static final class c {
        public final String a;
        public final UrlPreviewCardType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "RenderSlotKey(previewId=" + this.a + ", cardType=" + this.b + ')';
        }

        public c(String r2, UrlPreviewCardType r3) {
            Intrinsics.checkNotNullParameter(r2, "previewId");
            Intrinsics.checkNotNullParameter(r3, "cardType");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r0 = FlowChatModule.d;
            FlowChatModule.a.a().a().getBrowserDependency().openUrl(r3.getContext(), this.a);
        }
    }

    static {
    }

    public final sza.e c() {
        int r0 = this.c.a.a.b;
        sza.e r1 = new sza.e(r0);
        Object r2 = this.k;
        monitor-enter(r2);
        Integer r3 = this.l;     // Catch: Throwable -> L13
        if (r3 != null) goto L8;
    L9:
        this.e.d();     // Catch: Throwable -> L13
        this.l = Integer.valueOf(r0);     // Catch: Throwable -> L13
    L10:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return r1;
    L8:
        if (r3.intValue() == r0) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chat.preview.service.d r0 = this.b;
        e r1 = this.m;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        com.ss.android.lark.sdk.f.b(r0.a, r1, com.ss.android.lark.chat.preview.service.c.a);
        CoroutineScopeKt.cancel$default(this.g, null, 1, null);
        this.i.clear();
        this.j.clear();
        com.ss.android.lark.integrator.im.impl.preview.c r2 = this.e;
        Object r3 = r2.a;
        monitor-enter(r3);
        r2.b.clear();     // Catch: Throwable -> L10
        r2.c.clear();     // Catch: Throwable -> L10
        r2.d.clear();     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r3);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final void J(List<String> r21) {
        Intrinsics.checkNotNullParameter(r21, "previewIds");
        if (this.h.get() == false) goto L5;
        return;
    L5:
        c();
        List r0 = SequencesKt.toList(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence(r21), OfficeUrlPreviewSessionImpl$pullPreview$validIds$1.INSTANCE)));
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        List r1 = r0;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        String r3 = (String) r2.next();
        com.ss.android.lark.integrator.im.impl.preview.c r4 = this.e;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "previewId");
        Object r12 = r4.a;
        monitor-enter(r12);
        LinkedHashMap<String, f> r13 = r4.b;     // Catch: Throwable -> L19
        f r5 = r13.get(r3);     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        f.b r14 = new f.b(r3, r4.a(r3), new PreviewHangPoint(null, null, null, r3, false, false, null));     // Catch: Throwable -> L19
        r13.put(r3, r14);     // Catch: Throwable -> L19
        r5 = r14;
    L16:
        f r6 = r5;     // Catch: Throwable -> L19
        monitor-exit(r12);
    L19:
        th = move-exception;
        throw th;
    L22:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
    L24:
        if (r8.hasNext() == false) goto L36;
        String r9 = (String) r8.next();
        f r10 = this.e.c(r9);
        if (r10 != null) goto L29;
    L33:
        Pair r11 = null;
    L34:
        if (r11 == null) goto L24;
        r7.add(r11);
        goto L24
    L29:
        if (r10.a() != null) goto L33;
        if (this.i.putIfAbsent(r9, Long.valueOf(r10.b())) != null) goto L33;
        r11 = TuplesKt.to(r9, Long.valueOf(r10.b()));
        goto L34
    L36:
        final Map r15 = MapsKt.toMap(r7);
        SyncDataStrategy r16 = SyncDataStrategy.TRY_LOCAL;
        if (r15.isEmpty() == true) goto L55;
        List r17 = CollectionsKt.toList(r15.keySet());
        final Function0<Unit> r18 = new OfficeUrlPreviewSessionImpl$requestEntities$onFinished$1(r15, this);
        UrlPreviewService r19 = this.a;     // Catch: Throwable -> L42
        IGetDataCallback<Map<String, ? extends UrlCardPreviewEntity>> r20 = new OfficeUrlPreviewSessionImpl$requestEntities$1(this, r15, r18);     // Catch: Throwable -> L42
        r19.getClass();     // Catch: Throwable -> L42
        UrlPreviewService.c(r17, r16, r20);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        r18.invoke();
        throw th;
    }

    public final long b(String r5) {
        com.ss.android.lark.integrator.im.impl.preview.c r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "previewId");
        Object r1 = r0.a;
        monitor-enter(r1);
        long r2 = r0.a(r5);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final void s(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "previewId");
        if (this.h.get() == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L19;
        com.ss.android.lark.integrator.im.impl.preview.c r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "previewId");
        Object r1 = r0.a;
        monitor-enter(r1);
        r0.b.remove(r8);     // Catch: Throwable -> L13
        r0.d.remove(r8);     // Catch: Throwable -> L13
        r0.c.put(r8, Long.valueOf(r0.a(r8) + 1));     // Catch: Throwable -> L13
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        this.i.remove(r8);
        CollectionsKt.removeAll(this.j.keySet(), new OfficeUrlPreviewSessionImpl$removePreview$1(r8));
        UrlPreviewService r3 = this.a;
        List r9 = CollectionsKt.listOf(r8);
        r3.getClass();
        UrlPreviewService.a(r9);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void f(Map<String, UrlCardPreviewEntity> r10, Map<String, Long> r11) {
        if (this.h.get() == false) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L43;
        com.ss.android.lark.integrator.im.impl.preview.c r0 = this.e;
        Object r1 = r0.a;
        monitor-enter(r1);
        Set r2 = CollectionsKt.toSet(r0.b.keySet());     // Catch: Throwable -> L28
        monitor-exit(r1);
        int r3 = c().a;
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r12 = r10.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L27;
        Map.Entry<String, UrlCardPreviewEntity> r4 = r12.next();
        String r5 = r4.getKey();
        UrlCardPreviewEntity r6 = r4.getValue();
        if (r11 == null) goto L19;
        Long r7 = r11.get(r5);
        if (r7 == null) goto L19;
        long r8 = r7.longValue();
    L21:
        if (r2.contains(r5) == false) goto L13;
        if (b(r5) != r8) goto L13;
        if (this.e.f(r5, r8, r6) == false) goto L13;
        e(r5, r8, r6, r3);
    L19:
        r8 = b(r5);
        goto L21
    L27:
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public final UrlPreviewRenderResult d(String r8, UrlPreviewCardType r9, ViewGroup r10) {
        if (this.h.get() == true) goto L5;
        int r6 = c().a;
        f r0 = this.e.c(r8);
        if (r0 == null) goto L9;
        UrlCardPreviewEntity r5 = r0.a();
        if (r5 == null) goto L13;
        t6c.d r11 = this.e.b(r8, r9, r6);
        if (r11 != null) goto L18;
        e(r8, r0.b(), r5, r6);
        return UrlPreviewRenderResult.NO_RENDER;
    L18:
        boolean r1 = true;
        if (r10.getChildCount() == 0) goto L21;
        boolean r12 = true;
    L22:
        String r2 = null;
        if (r12 == false) goto L25;
        LKUIRoundableLayout r13 = r10.getChildAt(0);
    L61:
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L58
        r11.a(r13);     // Catch: Exception -> L58
        r11.f();     // Catch: Exception -> L58
        UrlPreviewBody r14 = r5.getPreviewBody();     // Catch: Exception -> L58
        if (r14 == null) goto L42;
        Url r15 = r14.getCardUrl();     // Catch: Exception -> L58
        if (r15 == null) goto L42;
        String r16 = r15.getAndroidUrl();     // Catch: Exception -> L58
        if (r16 == null) goto L42;
        if (r16.length() <= 0) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == true) goto L39;
        r16 = null;
    L39:
        if (r16 == null) goto L42;
    L41:
        r2 = r16;
    L54:
        if (r2 == null) goto L57;
        r13.setOnClickListener(new d(r2));     // Catch: Exception -> L58
    L57:
        return UrlPreviewRenderResult.SUCCESS;
    L35:
        r17 = false;
    L42:
        UrlPreviewBody r18 = r5.getPreviewBody();     // Catch: Exception -> L58
        if (r18 == null) goto L54;
        Url r19 = r18.getCardUrl();     // Catch: Exception -> L58
        if (r19 == null) goto L54;
        r16 = r19.getUrl();     // Catch: Exception -> L58
        if (r16 == null) goto L54;
        if (r16.length() > 0) goto L52;
        r1 = false;
    L52:
        if (r1 == false) goto L54;
    L58:
        e = move-exception;
        Log.e("UrlPreviewSession", "render error.", e);
        return UrlPreviewRenderResult.RENDER_FAILED;
    L25:
        r13 = new LKUIRoundableLayout(r10.getContext(), null, 6, 0);
        r13.setId(2131382951);
        r10.addView(r13);
        goto L61
    L21:
        r12 = false;
        goto L22
    L13:
        return UrlPreviewRenderResult.NO_DATA;
    L9:
        return UrlPreviewRenderResult.NO_DATA;
    L5:
        return UrlPreviewRenderResult.NO_DATA;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final UrlPreviewRenderResult j0(String r3, UrlPreviewCardType r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r3, "previewId");
        Intrinsics.checkNotNullParameter(r4, "cardType");
        Intrinsics.checkNotNullParameter(r5, "container");
        if (this.h.get() == true) goto L17;
        if (StringsKt.isBlank(r3) == true) goto L17;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        Log.e("UrlPreviewSession", "renderPreview must be called on the main thread");
        return UrlPreviewRenderResult.RENDER_FAILED;
    L18:
        return d(r3, r4, r5);
    L13:
        th = move-exception;
        Log.e("UrlPreviewSession", "render preview failed: " + th);
        return UrlPreviewRenderResult.RENDER_FAILED;
    L17:
        return UrlPreviewRenderResult.NO_DATA;
    }

    public final void e(String r24, long r25, UrlCardPreviewEntity r27, int r28) {
        UrlPreviewCardType[] r13 = UrlPreviewCardType.values();
        int r14 = r13.length;
        int r10 = 0;
    L3:
        if (r10 >= r14) goto L29;
        UrlPreviewCardType r7 = r13[r10];
        if (this.e.b(r24, r7, r28) != null) goto L28;
        if (this.h.get() == true) goto L28;
        b r8 = new b(r24, r7, r25, r27.getInlineEntity().getVersion(), r28);
        c r0 = new c(r8.a, r8.b);
    L11:
        if (this.h.get() == true) goto L23;
        b r1 = this.j.get(r0);
        if (Intrinsics.areEqual(r1, r8) == true) goto L23;
        if (r1 == null) goto L17;
    L19:
        if (r1 == null) goto L11;
        if (this.j.replace(r0, r1, r8) == false) goto L11;
    L22:
        boolean r2 = true;
    L24:
        if (r2 == false) goto L28;
        c r6 = new c(r24, r7);
        BuildersKt.launch$default(this.g, null, null, new OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1(this, r27, r7, r28, r24, r25, r6, r8, null), 3, null);
        goto L28
    L17:
        if (this.j.putIfAbsent(r0, r8) != null) goto L19;
    L23:
        r2 = false;
    L28:
        r10 = r10 + 1;
        goto L3
    }

    public OfficeUrlPreviewSessionImpl(UrlPreviewService r2, com.ss.android.lark.chat.preview.service.d r3, kc9.a r4, FlowOfficeUrlPreviewHostService.b r5, LifecycleOwner r6, Context r7) {
        Intrinsics.checkNotNullParameter(r2, "urlPreviewService");
        Intrinsics.checkNotNullParameter(r3, "urlPreviewPush");
        Intrinsics.checkNotNullParameter(r4, "renderConfigProvider");
        Intrinsics.checkNotNullParameter(r7, "renderContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new com.ss.android.lark.integrator.im.impl.preview.c();
        this.f = new com.ss.android.lark.integrator.im.impl.preview.a(r7, r6);
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.h = new AtomicBoolean(false);
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new Object();
        e r8 = new e(this);
        this.m = r8;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "listener");
        ArrayList r9 = r3.a;
        if (r9.isEmpty() == false) goto L13;
        monitor-enter(r9);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r9.isEmpty() == false) goto L8;
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_PREVIEWS, new com.ss.android.lark.chat.preview.service.b(r3));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r9);     // Catch: Throwable -> L10
    L13:
        r9.add(r8);
    }

    public static final boolean a(OfficeUrlPreviewSessionImpl r12, String r13, long r14, UrlCardPreviewEntity r16, UrlPreviewCardType r17, t6c.d r18, int r19) {
        Object r1 = r12.k;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r12.h.get() == false) goto L7;
    L16:
        boolean r0 = false;
    L17:
        monitor-exit(r1);
        return r0;
    L7:
        if (r12.b(r13) != r14) goto L16;
        Integer r2 = r12.l;     // Catch: Throwable -> L19
        if (r2 == null) goto L16;
        if (r2.intValue() != r19) goto L16;
        if (r12.e.g(r13, r14, r16, r17, r18, r19) == false) goto L16;
        r0 = true;
        goto L17
    }
}
