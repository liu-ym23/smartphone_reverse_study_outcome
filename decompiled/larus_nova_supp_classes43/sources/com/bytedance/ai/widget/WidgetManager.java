package com.bytedance.ai.widget;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.PendingWidgetPerformanceTracker;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k2.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import m5.i1;
import m5.u0;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WidgetManager implements l2.a {
    public static final a h = null;
    public static final ArrayDeque<WeakReference<WidgetManager>> i = null;
    public static boolean j;
    public final HashMap<com.bytedance.ai.widget.contianer.h, b> a;
    public String b;
    public String c;
    public final HashSet<Pair<String, String>> d;
    public final n e;
    public final WidgetManager$widgetUpdateListener$1 f;
    public WeakReference<com.bytedance.ai.widget.contianer.h> g;

    public static final class a {
        public final synchronized WidgetManager b() {
            monitor-enter(this);
            ArrayDeque<WeakReference<WidgetManager>> r0 = WidgetManager.i;     // Catch: Throwable -> L15
            ListIterator r1 = r0.listIterator(r0.size());     // Catch: Throwable -> L15
        L5:
            if (r1.hasPrevious() == false) goto L12;
            WidgetManager r10 = (WidgetManager) ((WeakReference) r1.previous()).get();     // Catch: Throwable -> L15
            if (r10 != null) goto L10;
            r1.remove();     // Catch: Throwable -> L15
            goto L5
        L10:
            monitor-exit(this);
            return r10;
        L12:
            monitor-exit(this);
            return null;
        L15:
            th = move-exception;
            throw th;
        }

        public a() {
        }

        public final synchronized com.bytedance.ai.widget.contianer.h a(final View r10) {
            monitor-enter(this);
            Iterator r0 = CollectionsKt.asReversedMutable(WidgetManager.i).iterator();     // Catch: Throwable -> L17
        L4:
            com.bytedance.ai.widget.contianer.h r11 = null;
            if (r0.hasNext() == false) goto L15;
            WidgetManager r1 = (WidgetManager) ((WeakReference) r0.next()).get();     // Catch: Throwable -> L17
            if (r1 == null) goto L12;
            if (r10 == null) goto L12;
            r11 = r1.m(new i(r10));     // Catch: Throwable -> L17
        L12:
            if (r11 == null) goto L4;
            monitor-exit(this);
            return r11;
        L15:
            monitor-exit(this);
            return null;
        L17:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jh\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/ai/widget/WidgetManager$InnerWidgetContext;", "", "messageId", "", "sectionId", "widgetId", "context", "position", "", "widgetInfo", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "parentRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/ref/WeakReference;)V", "getMessageId", "()Ljava/lang/String;", "getSectionId", "getWidgetId", "getContext", "setContext", "(Ljava/lang/String;)V", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidgetInfo", "()Lcom/bytedance/ai/model/objects/WidgetInfo;", "getParentRef", "()Ljava/lang/ref/WeakReference;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/ref/WeakReference;)Lcom/bytedance/ai/widget/WidgetManager$InnerWidgetContext;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {
        public final transient String a;
        public final transient Integer b;
        public final transient WidgetInfo c;

        @SerializedName("context")
        private String context;
        public final transient WeakReference<ViewGroup> d;

        @SerializedName("message_id")
        private final String messageId;

        @SerializedName("widget_id")
        private final String widgetId;

        public b() {
            this(null, null, null, null, null, null, null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.context, r11.context) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.messageId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.a;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.widgetId;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.context;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            Integer r21 = this.b;
            if (r21 != null) goto L21;
            int r22 = 0;
        L22:
            int r23 = (r20 + r22) * 31;
            WidgetInfo r24 = this.c;
            if (r24 != null) goto L25;
            int r25 = 0;
        L26:
            int r26 = (r23 + r25) * 31;
            WeakReference<ViewGroup> r27 = this.d;
            if (r27 == null) goto L31;
            r1 = r27.hashCode();
        L31:
            return r26 + r1;
        L25:
            r25 = r24.hashCode();
            goto L26
        L21:
            r22 = r21.hashCode();
            goto L22
        L17:
            r19 = r18.hashCode();
            goto L18
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "InnerWidgetContext(messageId=" + this.messageId + ", sectionId=" + this.a + ", widgetId=" + this.widgetId + ", context=" + this.context + ", position=" + this.b + ", widgetInfo=" + this.c + ", parentRef=" + this.d + ')';
        }

        public final String a() {
            return this.messageId;
        }

        public final String getContext() {
            return this.context;
        }

        public b(String r1, String r10, String r11, String r12, Integer r13, WidgetInfo r14, WeakReference<ViewGroup> r15) {
            this.messageId = r1;
            this.a = r10;
            this.widgetId = r11;
            this.context = r12;
            this.b = r13;
            this.c = r14;
            this.d = r15;
        }
    }

    static {
        h = new a();
        i = new ArrayDeque();
    }

    public final void k() {
        Iterator r0 = CollectionsKt.toList(this.a.keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        l((com.bytedance.ai.widget.contianer.h) r0.next());
        goto L4
    }

    @Override // l2.a
    public final void onHostDestroy() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostDestroy");
        k();
        AIManager r0 = AIManager.a;
        WidgetManager$widgetUpdateListener$1 r1 = this.f;
        Intrinsics.checkNotNullParameter(r1, "listener");
        AIManager.d.remove(r1);
        a r10 = h;
        monitor-enter(r10);
        CollectionsKt.removeAll(i, new k(this));     // Catch: Throwable -> L8
        monitor-exit(r10);
        this.e.getClass();
        com.bytedance.ai.widget.cache.a.a();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // l2.a
    public final void onHostHide() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostHide");
        Iterator<T> r0 = this.a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WidgetContainer r1 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.h) r0.next());
        r1.onHide();
        r1.onHostHide();
        goto L4
    }

    @Override // l2.a
    public final void onHostShow() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostShow");
        if (j == true) goto L10;
        Trace.beginSection("initLynx");
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L9;
        Context r1 = r0.a;
        if (r1 == null) goto L9;
        int r10 = AppletLynxViewApi.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        IIvyAIPackageResourceService.a.e(r1);
    L9:
        Trace.endSection();
    L10:
        a r11 = h;
        monitor-enter(r11);
        ArrayDeque<WeakReference<WidgetManager>> r12 = i;     // Catch: Throwable -> L21
        CollectionsKt.removeAll(r12, new j(this));     // Catch: Throwable -> L21
        r12.addLast(new WeakReference(this));     // Catch: Throwable -> L21
        monitor-exit(r11);
        Iterator<T> r13 = this.a.keySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        WidgetContainer r14 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.h) r13.next());
        r14.onHostShow();
        if (r14.f() == false) goto L16;
        r14.onShow();
        goto L16
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.widget.WidgetManager$widgetUpdateListener$1, java.lang.Object] */
    public WidgetManager() {
        this.a = new HashMap();
        this.d = new HashSet();
        this.e = new n();
        ?? r0 = new WidgetManager$widgetUpdateListener$1(this);
        this.f = r0;
        AIManager r1 = AIManager.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        AIManager.d.add((AIManager.c) r0);
    }

    @Override // l2.a
    public final void a(String r10) {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onChatHistoryClear convId=" + r10 + " this.convId=" + this.b);
        if (r10 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10, this.b) == false) goto L10;
        k();
        this.g = null;
        return;
    }

    @Override // l2.a
    public final void c(com.bytedance.ai.widget.contianer.h r1) {
        l(r1);
        r1.m();
    }

    @Override // l2.a
    public final void e(h5.k r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.ai.widget.contianer.h r0 = n(r10);
        ViewGroup r1 = null;
        if (r0 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "onWidgetRecycled msgId=" + r10.a() + " widgetContainer not found, enableCache = " + r10.l, null);
        return;
    L6:
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetRecycled widget=" + r0 + " view=" + r0.realView() + " enableCache = " + r10.l);
        View r13 = r0.realView();
        if (r13 == null) goto L13;
        ViewParent r14 = r13.getParent();
        if ((r14 instanceof ViewGroup) == false) goto L11;
        r1 = (ViewGroup) r14;
    L11:
        if (r1 == null) goto L13;
        r1.removeView(r13);
    L13:
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetRecycled destroy widgetContainer");
        l(r0);
        r0.m();
    }

    @Override // l2.a
    public final void f(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "msgIds");
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetMessageRemoved " + r10);
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        String r1 = (String) r11.next();
        Set<com.bytedance.ai.widget.contianer.h> r12 = this.a.keySet();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L15;
        Object r15 = r14.next();
        com.bytedance.ai.widget.contianer.m r16 = ((com.bytedance.ai.widget.contianer.h) r15).k();
        if (r16 == null) goto L11;
        String r17 = r16.e;
    L13:
        if (Intrinsics.areEqual(r17, r1) == false) goto L7;
        r13.add(r15);
        goto L7
    L11:
        r17 = null;
        goto L13
    L15:
        Iterator r18 = r13.iterator();
    L17:
        if (r18.hasNext() == false) goto L4;
        com.bytedance.ai.widget.contianer.h r19 = (com.bytedance.ai.widget.contianer.h) r18.next();
        com.bytedance.ai.applet.base.log.b r20 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "onWidgetMessageRemoved msgId=" + r1 + ' ' + r19);
        Intrinsics.checkNotNull(r19);
        l(r19);
        goto L17
    }

    @Override // l2.a
    public final void g(final h5.k r24) {
        Intrinsics.checkNotNullParameter(r24, "context");
        WidgetInfo r1 = r24.f;
        if (r1 == null) goto L5;
        String r10 = r1.getAppletId();
    L6:
        if (r10 != null) goto L8;
    L23:
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "updateWidget invalid render context " + r24, null);
        return;
    L8:
        if (r1.getWidgetId() == null) goto L23;
        String r12 = r24.e;
        if (r12 != null) goto L16;
        AppletRuntimeManager r13 = AppletRuntimeManager.INSTANCE;
        String r14 = r24.b;
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        r13.getClass();
        r12 = AppletRuntimeManager.h(r14);
    L16:
        String r15 = r12;
        com.bytedance.ai.widget.contianer.h r16 = n(r24);
        if (r16 != null) goto L20;
        r16 = m(new e(r24));
    L20:
        if (r16 == null) goto L25;
        r16.o(new com.bytedance.ai.widget.contianer.m(r1.getAppletId(), r1.getWidgetId(), r1.getWidgetData(), r15, r24.a, r24.c, r24.d, r24.j, r24.k, r1.getMixtureCardId(), r24.b, r24.b(), null, r24.n, null, null, null, null, 512000));
        return;
    L25:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // l2.a
    public final void h(Iterable<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "visibleWidgets");
        Iterator<T> r11 = this.a.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        com.bytedance.ai.widget.contianer.h r0 = (com.bytedance.ai.widget.contianer.h) r11.next();
        if (r0.f() == true) goto L7;
        ((WidgetContainer) r0).onHide();
        goto L4
    L7:
        ((WidgetContainer) r0).onShow();
        goto L4
    }

    public final void l(com.bytedance.ai.widget.contianer.h r10) {
        WidgetContainer r11 = (WidgetContainer) r10;
        r11.onDestroy();
        r11.onHostDestroy();
        this.a.remove(r11);
        WeakReference<com.bytedance.ai.widget.contianer.h> r0 = this.g;
        if (r0 == null) goto L5;
        com.bytedance.ai.widget.contianer.h r1 = r0.get();
    L7:
        if (Intrinsics.areEqual(r1, r11) == false) goto L10;
        this.g = null;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final com.bytedance.ai.widget.contianer.h m(Function1<? super com.bytedance.ai.widget.contianer.h, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        Iterator<T> r0 = this.a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        com.bytedance.ai.widget.contianer.h r11 = (com.bytedance.ai.widget.contianer.h) r1;
        Intrinsics.checkNotNull(r11);
        if (((Boolean) r10.invoke(r11)).booleanValue() == false) goto L4;
    L10:
        return (com.bytedance.ai.widget.contianer.h) r1;
    L8:
        r1 = null;
        goto L10
    }

    public final com.bytedance.ai.widget.contianer.h n(h5.k r10) {
        ViewGroup r0 = r10.g;
        if (r0 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "findWidgetContainerForContext: parent is null, cardId=" + r10.a(), null);
        return null;
    L6:
        Iterator<T> r11 = this.a.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L20;
        Object r12 = r11.next();
        Map.Entry r13 = (Map.Entry) r12;
        Intrinsics.checkNotNull(r13);
        b r14 = (b) r13.getValue();
        if (Intrinsics.areEqual(r14.a(), r10.a()) == false) goto L17;
        WeakReference<ViewGroup> r15 = r14.d;
        if (r15 == null) goto L14;
        ViewGroup r16 = r15.get();
    L15:
        if (r16 != r0) goto L17;
        boolean r17 = true;
    L18:
        if (r17 == false) goto L8;
    L21:
        Map.Entry r18 = (Map.Entry) r12;
        if (r18 != null) goto L24;
        return null;
    L24:
        return (com.bytedance.ai.widget.contianer.h) r18.getKey();
    L14:
        r16 = null;
    L17:
        r17 = false;
        goto L18
    L20:
        r12 = null;
        goto L21
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [com.bytedance.ai.widget.g, kotlin.jvm.functions.Function1<? super com.bytedance.ai.widget.contianer.h, kotlin.Unit>] */
    @Override // l2.a
    public final Object b(h5.k r26, Continuation<? super AppletWidgetContainer> r27) {
        h5.k r1 = r26;
        if ((r27 instanceof WidgetManager$bindWidget$1) == false) goto L7;
        WidgetManager$bindWidget$1 r10 = (WidgetManager$bindWidget$1) r27;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = true;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r1 = (h5.k) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L37:
        AppletWidgetContainer r16 = (AppletWidgetContainer) r12;
        JobKt.ensureActive(r10.getContext());
        if (r16 == null) goto L40;
        WidgetBoxView r17 = r16.z;
    L42:
        if (r17 == null) goto L61;
        HashMap<com.bytedance.ai.widget.contianer.h, b> r18 = this.a;
        String r19 = r1.a();
        String r20 = r1.c;
        if (r20 != null) goto L46;
        String r110 = "";
    L47:
        WidgetInfo r21 = r1.f;
        if (r21 == null) goto L50;
        String r111 = r21.getWidgetId();
    L51:
        Integer r112 = Boxing.boxInt(r1.i);
        WidgetInfo r113 = r1.f;
        ViewGroup r22 = r1.g;
        if (r22 == null) goto L54;
        WeakReference r114 = new WeakReference(r22);
    L55:
        r18.put(r16, new b(r19, r110, r111, "", r112, r113, r114));
        ?? r23 = new g(this);
        if (r16.u == null) goto L58;
    L60:
        r16.u = r23;
        goto L61
    L58:
        if (((ConcurrentHashMap) r16.s).isEmpty() == false) goto L60;
        r23.invoke(r16);
        goto L60
    L54:
        r114 = null;
        goto L55
    L50:
        r111 = null;
        goto L51
    L46:
        r110 = r20;
    L61:
        WidgetInfo r24 = r1.f;
        if (r24 == null) goto L64;
        String r25 = r24.getMixtureCardId();
    L66:
        if (com.bytedance.ai.utils.f.g(r25) == false) goto L110;
        WidgetInfo r28 = r1.f;
        if (r28 == null) goto L73;
        String r29 = r28.getAppletId();
        if (r29 == null) goto L73;
        String r30 = r29;
    L74:
        WidgetInfo r31 = r1.f;
        if (r31 == null) goto L80;
        String r32 = r31.getWidgetId();
        if (r32 == null) goto L80;
        String r115 = r32;
    L82:
        if (r30.length() <= 0) goto L84;
        boolean r33 = true;
    L85:
        if (r33 == false) goto L110;
        if (r115.length() > 0) goto L90;
        r15 = false;
    L90:
        if (r15 == false) goto L110;
        String r34 = r1.a;
        Keva r35 = com.bytedance.ai.widget.cache.c.a;
        if (Intrinsics.areEqual(r34, com.bytedance.ai.widget.cache.c.c) == false) goto L110;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "bindWidget: last message is mixture, save it");
        String r116 = r1.a;
        String r36 = r1.b;
        if (r36 != null) goto L96;
        String r117 = "";
    L97:
        String r37 = r1.e;
        if (r37 != null) goto L100;
        String r118 = "";
    L101:
        String r119 = r1.b();
        WidgetInfo r38 = r1.f;
        if (r38 == null) goto L104;
        String r120 = r38.getAppType();
    L105:
        WidgetInfo r39 = r1.f;
        if (r39 == null) goto L108;
        String r121 = r39.getVersionTag();
    L109:
        com.bytedance.ai.widget.cache.c.b(new ConversationWidgetData(r30, r115, r116, r118, r117, r119, null, r120, r121, 64, null));
        goto L110
    L108:
        r121 = null;
        goto L109
    L104:
        r120 = null;
        goto L105
    L100:
        r118 = r37;
        goto L101
    L96:
        r117 = r36;
        goto L97
    L84:
        r33 = false;
    L80:
        r115 = "";
    L73:
        r30 = "";
    L110:
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r40 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r41 = new StringBuilder("bindWidget: render view's width: ");
        if (r17 == null) goto L113;
        Integer r42 = Boxing.boxInt(r17.getWidth());
    L114:
        r41.append(r42);
        r41.append(", height: ");
        if (r17 == null) goto L117;
        Integer r43 = Boxing.boxInt(r17.getHeight());
    L118:
        r41.append(r43);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", r41.toString());
        return r16;
    L117:
        r43 = null;
        goto L118
    L113:
        r42 = null;
        goto L114
    L64:
        r25 = null;
        goto L66
    L40:
        r17 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Trace.beginSection("bindWidget");
        com.bytedance.ai.applet.base.log.b r44 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "bindWidget msgId=" + r1.a + " parent=" + r1.g + " enableCache=" + r1.l);
        if (j == false) goto L21;
        h2.a r45 = f2.b.c;
        if (r45 == null) goto L21;
        Context r46 = r45.a;
        if (r46 == null) goto L21;
        int r47 = AppletLynxViewApi.a;
        Intrinsics.checkNotNullParameter(r46, "context");
        IIvyAIPackageResourceService.a.e(r46);
    L21:
        WidgetInfo r48 = r1.f;
        if (r48 == null) goto L27;
        List<com.bytedance.ai.widget.a.C0055a> r49 = com.bytedance.ai.widget.a.a;
        String r122 = com.bytedance.ai.widget.a.a(r48.getAppletId(), r48.getWidgetId());
        if (r122 == null) goto L26;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "degradeWidgetIfNeed " + r48.getWidgetId());
        r48 = WidgetInfo.copy$default(r48, null, r122, null, null, null, null, null, null, null, null, null, null, null, null, 16381, null);
    L26:
        r1.f = r48;
    L27:
        WidgetInfo r50 = r1.f;
        if (r50 != null) goto L30;
    L34:
        r10.L$0 = r1;
        r10.label = 1;
        r12 = j(r1, r10);
        if (r12 != r13) goto L37;
        return r13;
    L30:
        if (Intrinsics.areEqual(r50.getAppType(), "1") == false) goto L34;
        String r51 = r50.getAppletId();
        if (r51 == null) goto L34;
        AIManager r52 = AIManager.a;
        AIManager.f(r51);
    L7:
        r10 = new WidgetManager$bindWidget$1(this, r27);
        goto L8
    }

    @Override // l2.a
    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "convId");
        Intrinsics.checkNotNullParameter(r11, "sectionId");
        this.c = r11;
        this.b = r10;
    }

    public final Object j(final h5.k r32, Continuation<? super AppletWidgetContainer> r33) {
        if ((r33 instanceof WidgetManager$createWidgetContainer$1) == false) goto L7;
        WidgetManager$createWidgetContainer$1 r10 = (WidgetManager$createWidgetContainer$1) r33;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        AppletWidgetContainer r1 = (AppletWidgetContainer) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L93:
        Trace.endSection();
        return r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        WidgetInfo r15 = r32.f;
        String r16 = null;
        if (r15 == null) goto L17;
        String r17 = r15.getAppletId();
    L18:
        String r18 = "";
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        if (r15 == null) goto L23;
        String r19 = r15.getWidgetId();
    L24:
        if (r19 != null) goto L26;
        r19 = "";
    L26:
        if (r15 == null) goto L28;
        String r110 = r15.getMixtureCardId();
    L29:
        if (r110 == null) goto L32;
        r18 = r110;
    L32:
        final PendingWidgetPerformanceTracker r20 = new PendingWidgetPerformanceTracker(r17, r19, r18, 5);
        r20.d();
        Map<String, Object> r21 = r32.k;
        boolean r22 = false;
        if (r21 == null) goto L35;
        boolean r23 = Intrinsics.areEqual(r21.get("hasFirstFeedShow"), Boxing.boxBoolean(false));
    L36:
        if (r23 == false) goto L43;
        Object r24 = r32.k.get("coldStartTime");
        if ((r24 instanceof Long) == false) goto L40;
        Long r25 = (Long) r24;
    L41:
        if (r25 == null) goto L43;
        r25.longValue();
        r20.o = true;
        goto L43
    L40:
        r25 = null;
    L43:
        ViewGroup r26 = r32.g;
        if (r26 == null) goto L47;
        Context r27 = r26.getContext();
        if (r27 == null) goto L47;
    L52:
        i1 r111 = y0.a;
        final String r112 = r32.a();
        final Map<String, Object> r113 = r32.k;
        WidgetInfo r114 = r32.f;
        if (r114 == null) goto L55;
        String r115 = r114.getMixtureCardId();
    L56:
        final boolean r116 = com.bytedance.ai.utils.f.g(r115);
        Intrinsics.checkNotNullParameter(r112, "traceId");
        final long r117 = System.currentTimeMillis();
        y0.r(new u0(r112, r113, r116, r117));
        h2.a r118 = f2.b.c;
        if (r118 != null) goto L59;
    L97:
        r20.c(AppletPerformanceErrorCode.INTERRUPTED, "createWidgetContainer: application is null");
        return null;
    L59:
        if (r118.a == null) goto L97;
        String r119 = r32.b;
        if (r119 != null) goto L64;
    L65:
        r22 = true;
    L66:
        if (r22 == true) goto L95;
        if (r15 == null) goto L69;
        String r28 = r15.getAppletId();
    L70:
        if (r28 == null) goto L95;
        if (r15.getWidgetId() == null) goto L95;
        Trace.beginSection("createWidgetContainer");
        String r29 = r32.e;
        if (r29 != null) goto L77;
        AppletRuntimeManager r30 = AppletRuntimeManager.INSTANCE;
        String r120 = r32.b;
        r30.getClass();
        r29 = AppletRuntimeManager.h(r120);
    L77:
        String r121 = r29;
        l r31 = y0.d;
        if (r31 == null) goto L80;
        r31.a(new m(r32.a, r32.a(), r32.d, r15.getAppletId(), r15.getWidgetId()));
    L80:
        final AppletWidgetContainer r34 = new AppletWidgetContainer(r27);
        Job r35 = r10.getContext().get(Job.Key);
        if (r35 == null) goto L83;
        r35.invokeOnCompletion(new f(r32, r20, r34));
    L83:
        u r36 = r32.h;
        if (r36 == null) goto L86;
        Intrinsics.checkNotNullParameter(r36, "widgetLifeObserver");
        ((ArrayList) r34.e).add(r36);
    L86:
        com.bytedance.ai.applet.base.log.b r37 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r38 = new StringBuilder("createWidgetContainer widget=");
        r38.append(r34);
        r38.append(" widgetData=");
        WidgetInfo r122 = r32.f;
        if (r122 == null) goto L89;
        r16 = r122.getWidgetData();
    L89:
        r38.append(r16);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", r38.toString());
        r34.b = r32.b;
        AppletRuntimeManager.INSTANCE.getClass();
        r34.a = AppletRuntimeManager.e;
        r34.r(WidgetContainer.LifecycleEvent.ON_START);
        new WeakReference(this.e);
        com.bytedance.ai.widget.contianer.m r39 = new com.bytedance.ai.widget.contianer.m(r15.getAppletId(), r15.getWidgetId(), r15.getWidgetData(), r121, r32.a, r32.c, r32.d, r32.j, r32.k, r15.getMixtureCardId(), r32.b, r32.b(), r32.m, r32.n, r15.getMcpName(), r15.getFullScreenRefresh(), r15.getEntityId(), r15.getVersionTag(), 131072);
        r10.L$0 = r34;
        r10.label = 1;
        if (r34.y(r39, r20, r10) != r13) goto L92;
        return r13;
    L92:
        r1 = r34;
        goto L93
    L69:
        r28 = null;
    L95:
        String r40 = "createWidgetContainer: invalid render context " + r32;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", r40, null);
        r20.c(AppletPerformanceErrorCode.INTERRUPTED, r40);
        return null;
    L64:
        if (r119.length() != 0) goto L66;
    L55:
        r115 = null;
    L47:
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "createWidgetContainer: parent is null", null);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r41 = AppletRuntimeManager.d;
        if (r41 == null) goto L99;
        r27 = r41.currentActivity();
        if (r27 != null) goto L52;
    L99:
        com.bytedance.ai.applet.base.log.a.b("WidgetManager", "createWidgetContainer: currentActivity is null", null);
        r20.c(AppletPerformanceErrorCode.INTERRUPTED, "createWidgetContainer: currentActivity is null");
        return null;
    L35:
        r23 = false;
        goto L36
    L28:
        r110 = null;
        goto L29
    L23:
        r19 = null;
        goto L24
    L17:
        r17 = null;
    L7:
        r10 = new WidgetManager$createWidgetContainer$1(this, r33);
        goto L8
    }

    public final Object i(h5.k r17, String r18, String r19, Continuation<? super com.bytedance.ai.widget.contianer.h> r20) {
        h5.k r1 = r17;
        if ((r20 instanceof WidgetManager$buildLoginWidget$1) == false) goto L7;
        WidgetManager$buildLoginWidget$1 r10 = (WidgetManager$buildLoginWidget$1) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r1 = (h5.k) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L24:
        AppletWidgetContainer r15 = (AppletWidgetContainer) r12;
        JobKt.ensureActive(r10.getContext());
        ViewGroup r16 = null;
        if (r15 == null) goto L27;
        WidgetBoxView r21 = r15.z;
    L28:
        if (r21 == null) goto L41;
        HashMap<com.bytedance.ai.widget.contianer.h, b> r22 = this.a;
        String r23 = r1.a();
        String r24 = r1.c;
        if (r24 != null) goto L32;
        r24 = "";
    L32:
        String r110 = r24;
        WidgetInfo r25 = r1.f;
        if (r25 == null) goto L35;
        String r111 = r25.getWidgetId();
    L36:
        Integer r112 = Boxing.boxInt(r1.i);
        WidgetInfo r113 = r1.f;
        ViewGroup r26 = r1.g;
        if (r26 == null) goto L39;
        WeakReference r114 = new WeakReference(r26);
    L40:
        r22.put(r15, new b(r23, r110, r111, "", r112, r113, r114));
        goto L41
    L39:
        r114 = null;
        goto L40
    L35:
        r111 = null;
    L41:
        if (r21 == null) goto L47;
        ViewParent r27 = r21.getParent();
        if ((r27 instanceof ViewGroup) == false) goto L45;
        r16 = (ViewGroup) r27;
    L45:
        if (r16 == null) goto L47;
        r16.removeView(r21);
    L47:
        com.bytedance.ai.applet.base.log.b r28 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "buildLoginWidget: widgetContainer to return: " + r15);
        return r15;
    L27:
        r21 = null;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        com.bytedance.ai.applet.base.log.b r29 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "buildLoginWidget: applet: " + r18 + ", widget: " + r19);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "buildLoginWidget: create widget container.");
        WidgetInfo r30 = r1.f;
        if (r30 != null) goto L17;
    L21:
        r10.L$0 = r1;
        r10.label = 1;
        r12 = j(r1, r10);
        if (r12 != r13) goto L24;
        return r13;
    L17:
        if (Intrinsics.areEqual(r30.getAppType(), "1") == false) goto L21;
        String r31 = r30.getAppletId();
        if (r31 == null) goto L21;
        AIManager r32 = AIManager.a;
        AIManager.f(r31);
    L7:
        r10 = new WidgetManager$buildLoginWidget$1(this, r20);
        goto L8
    }
}
