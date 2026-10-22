package com.larus.uaigc.chat;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationVideoManagerViewModel implements kh8.a {
    public static final /* synthetic */ int j = 0;
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, View> b;
    public final ConcurrentHashMap<String, Integer> c;
    public String d;
    public final Lazy e;
    public final Lazy f;
    public final MutableSharedFlow<Unit> g;
    public final HashMap<String, Boolean> h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final View b;
        public final Rect c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
        }

        public final String toString() {
            return "VisibleVideo(vid=" + this.a + ", view=" + this.b + ", visibleRect=" + this.c + ", verticalGap=" + this.d + ')';
        }

        public b(String r2, View r3, Rect r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "vid");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "visibleRect");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public final void g() {
        BuildersKt.launch$default(this.a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onCreationPagerExit$1(this, null), 2, null);
    }

    public final MutableSharedFlow h() {
        return (MutableSharedFlow) this.e.getValue();
    }

    public final MutableSharedFlow i() {
        return (MutableSharedFlow) this.f.getValue();
    }

    public final String b() {
        return this.d;
    }

    public CreationVideoManagerViewModel(CoroutineScope r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModelScope");
        this.a = r10;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.e = LazyKt.lazy(new l());
        this.f = LazyKt.lazy(new m());
        this.g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.h = new HashMap();
        BuildersKt.launch$default(r10, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$bindObservers$1(this, null), 2, null);
        this.i = LazyKt.lazy(new n());
    }

    public static Rect l(View r4) {
        boolean r1 = true;
        if (r4.isAttachedToWindow() == true) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        if (r4.getWidth() > 0) goto L15;
    L18:
        if (r1 == false) goto L20;
        return null;
    L20:
        Rect r2 = new Rect();
        if (r4.getGlobalVisibleRect(r2) == true) goto L23;
        return null;
    L23:
        return r2;
    L15:
        if (r4.getHeight() <= 0) goto L18;
        r1 = false;
        goto L18
    L5:
        if (r4.isShown() == false) goto L8;
        r0 = false;
        goto L10
    }

    public static RecyclerView m(View r3) {
        RecyclerView r4 = r3.getParent();
    L4:
        if ((r4 instanceof View) == false) goto L16;
        if ((r4 instanceof RecyclerView) == false) goto L15;
        RecyclerView r0 = r4;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L12;
        boolean r2 = true;
        if (r1.canScrollHorizontally() != true) goto L12;
    L13:
        if (r2 == false) goto L15;
        return r0;
    L12:
        r2 = false;
    L15:
        r4 = ((View) r4).getParent();
        goto L4
    L16:
        return null;
    }

    public final Integer a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        return this.c.get(r2);
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "vid");
        this.b.remove(r4);
        FLogger.a.i("CreationVideoManagerVM", "onMdVideoViewRecycle: vid=" + r4 + ", viewCount=" + this.b.size());
    }

    public final Object f(Continuation<? super Unit> r4) {
        FLogger.a.i("CreationVideoManagerVM", "checkAutoPlay: curBindMdVideoView.size=" + this.b.size());
        MutableSharedFlow<Unit> r0 = this.g;
        Unit r1 = Unit.INSTANCE;
        Object r5 = r0.emit(r1, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        return r5;
    L5:
        return r1;
    }

    public static final String k(final CreationVideoManagerViewModel r17, Map r18) {
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((HashMap) r18).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r5 = (String) r3.getKey();
        View r4 = (View) r3.getValue();
        Rect r6 = l(r4);
        if (r6 != null) goto L8;
        FLogger.a.d("CreationVideoManagerVM", "bindObservers: vid=" + r5 + ", calVisibleRect=null");
    L10:
        b r7 = null;
    L12:
        if (r7 == null) goto L4;
        r1.add(r7);
        goto L4
    L8:
        long r9 = ((long) r6.width()) * ((long) r6.height());
        long r11 = ((long) r4.getMeasuredWidth()) * ((long) r4.getMeasuredHeight());
        long r13 = ((90 * r11) + ((long) 99)) / ((long) 100);
        FLogger.a.d("CreationVideoManagerVM", "bindObservers: vid=" + r5 + ", visibleArea=" + r9 + ", totalArea=" + r11 + ", threshold=" + r13);
        if (r9 < r13) goto L10;
        r7 = new b(r5, r4, r6, Math.abs(r6.centerY() - (((Number) r17.i.getValue()).intValue() / 2)));
        goto L12
    L15:
        if (r1.isEmpty() == true) goto L19;
        String r8 = r17.d;
        b r10 = (b) CollectionsKt.minWithOrNull(r1, new q(new p(new o(new i()), r8)));
        if (r10 == null) goto L19;
        final RecyclerView r12 = m(r10.b);
        if (r12 == null) goto L41;
        Rect r14 = l(r12);
        if (r14 == null) goto L26;
        final Integer r15 = Integer.valueOf(r14.centerX());
    L27:
        b r0 = (b) SequencesKt.minWithOrNull(SequencesKt.filter(CollectionsKt.asSequence(r1), new j(r17, r12)), new q(new p(new o(new k(r15)), r8)));
        if (r0 == null) goto L32;
        String r16 = r0.a;
        if (r16 == null) goto L32;
    L34:
        return r16;
    L32:
        r16 = r10.a;
        goto L34
    L26:
        r15 = null;
        goto L27
    L41:
        return r10.a;
    L19:
        return null;
    }

    public final void d(String r3, VideoPlayView r4) {
        Intrinsics.checkNotNullParameter(r3, "vid");
        if (r4 != null) goto L5;
        return;
    L5:
        this.b.put(r3, r4);
        FLogger.a.i("CreationVideoManagerVM", "onMdVideoViewBind: vid=" + r3 + ", viewCount=" + this.b.size());
    }

    public final void e(String r7, Integer r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(this.a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onVideoDetailExit$1(this, r7, null), 2, null);
        if (r8 == null) goto L8;
        r8.intValue();
        this.c.put(r7, r8);
        return;
    }

    public final void j(String r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(this.a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onPlayOrPauseByUser$1(this, r7, r8, null), 2, null);
    }
}
