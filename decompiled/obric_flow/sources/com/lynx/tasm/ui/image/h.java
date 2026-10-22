package com.lynx.tasm.ui.image;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Logger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.vmsdk.jsbridge.utils.SystemThread;
import com.facebook.common.references.CloseableReference;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.image.InlineImageShadowNode;
import com.lynx.tasm.behavior.ui.list.ListEventManager;
import com.lynx.tasm.behavior.ui.list.ListLayoutManager$ListGridLayoutManager;
import com.lynx.tasm.behavior.ui.list.ListLayoutManager$ListLinearLayoutManager;
import com.lynx.tasm.behavior.ui.list.ListStickyManager;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.oui.constraintlayout.helper.widget.Carousel;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11046b;

    public h(OSelectionItemView r5, OSelectionItemView r10) {
        this.f11045a = 7;
        this.f11046b = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 0;
        JavaOnlyArray r10 = null;
        switch(this.f11045a) {
            case 0: goto L274;
            case 1: goto L268;
            case 2: goto L264;
            case 3: goto L260;
            case 4: goto L241;
            case 5: goto L228;
            case 6: goto L224;
            case 7: goto L222;
            case 8: goto L220;
            case 9: goto L216;
            case 10: goto L214;
            case 11: goto L212;
            case 12: goto L283;
            case 13: goto L203;
            case 14: goto L201;
            case 15: goto L199;
            case 16: goto L102;
            case 17: goto L100;
            case 18: goto L92;
            case 19: goto L79;
            case 20: goto L59;
            case 21: goto L52;
            case 22: goto L45;
            case 23: goto L38;
            case 24: goto L28;
            case 25: goto L23;
            case 26: goto L21;
            case 27: goto L14;
            case 28: goto L12;
            default: goto L4;
        };
    L4:
        Uri r14 = (Uri) this.f11046b;
        if (r14 == null) goto L340;
        String r15 = com.bytedance.pia.core.utils.j.k(r14, null);
        if (r15 == null) goto L341;
        jh.c.n(r15);
        return;
    L341:
        return;
    L340:
        return;
    L12:
        LockMonitorManager.access$800((jg.e) this.f11046b);
        return;
    L14:
        jg.f r16 = (jg.f) this.f11046b;
        if (r16 == null) goto L17;
        ((b3.g) r16).a(LockMonitorManager.dumpLockInfo());     // Catch: Throwable -> L19
    L285:
        return;
    L17:
        r16.getClass();     // Catch: Throwable -> L19
    L19:
        r16.getClass();
        return;
    L21:
        Carousel r17 = (Carousel) this.f11046b;
        r17.f12600p.setProgress(0.0f);
        r17.getClass();
        r17.getClass();
        int r18 = r17.f12599o;
        throw null;
    L23:
        StringBuilder r11 = new StringBuilder("Try to updateSurfaceTexture, mHasDestroyed: ");
        im.e r19 = (im.e) this.f11046b;
        r11.append(r19.f17587b);
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", r11.toString());
        if (r19.f17587b == true) goto L343;
        r19.e = false;
        r19.setVisibility(r19.f);
        r19.e();
        return;
    L343:
        return;
    L38:
        i4.a r12 = (i4.a) this.f11046b;
        Iterator r13 = ((CopyOnWriteArraySet) r12.d).iterator();     // Catch: OutOfMemoryError -> L276
    L41:
        if (r13.hasNext() == false) goto L43;
        ((ia.b) r13.next()).a(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L276
        goto L41
    L43:
        ia.f r20 = (ia.f) r12.f17502b;     // Catch: OutOfMemoryError -> L276
        r20.b(Message.obtain(r20.d, this), 5000);     // Catch: OutOfMemoryError -> L276
        return;
    L344:
        return;
    L45:
        i4.a r21 = (i4.a) this.f11046b;
        Iterator r22 = ((CopyOnWriteArraySet) r21.d).iterator();     // Catch: OutOfMemoryError -> L277
    L48:
        if (r22.hasNext() == false) goto L50;
        ((ia.b) r22.next()).a(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L277
        goto L48
    L50:
        ia.f r23 = (ia.f) r21.f17502b;     // Catch: OutOfMemoryError -> L277
        r23.b(Message.obtain(r23.d, this), 30000);     // Catch: OutOfMemoryError -> L277
        return;
    L345:
        return;
    L52:
        i9.f.g();
        System.currentTimeMillis();
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_kill_history_err"}) != 1) goto L58;
        Iterator r110 = ((LinkedList) this.f11046b).iterator();
    L56:
        if (r110.hasNext() == false) goto L346;
        i9.e r24 = (i9.e) r110.next();
        i9.f.e(r24, r24.f17536i, r24.f17532a, null);
        goto L56
    L346:
        return;
    L58:
        return;
    L59:
        hf.g r111 = (hf.g) this.f11046b;
    L66:
        th = move-exception;
        GeckoLogger.b("onUpdateStart exception: " + th.getMessage());
        return;
    L62:
        if (r111.d == null) goto L69;
        PrepareMeta r25 = r111.f17319a;     // Catch: Throwable -> L66
        if (r25 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L66
    L68:
        r25.getPack();     // Catch: Throwable -> L66
    L69:
        Iterator r26 = pa.b.f21323a.iterator();     // Catch: Throwable -> L66
    L70:
        if (r26.hasNext() == false) goto L347;
        pa.a r27 = (pa.a) r26.next();     // Catch: Throwable -> L66
        PrepareMeta r28 = r111.f17319a;     // Catch: Throwable -> L66
        if (r28 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L66
    L75:
        r28.getPack();     // Catch: Throwable -> L66
        r27.getClass();     // Catch: Throwable -> L66
        goto L70
    L347:
        return;
    L79:
        LinkedList r29 = ((h6.a) this.f11046b).f17283a;
        monitor-enter(r29);
        LinkedList r30 = new LinkedList(((h6.a) this.f11046b).f17283a);     // Catch: Throwable -> L88
        ((h6.a) this.f11046b).f17283a.clear();     // Catch: Throwable -> L88
        monitor-exit(r29);     // Catch: Throwable -> L88
        Iterator r31 = r30.iterator();
    L85:
        if (r31.hasNext() == false) goto L87;
        ((h6.a) this.f11046b).c((h6.b) r31.next());
        goto L85
    L87:
        return;
    L88:
        th = move-exception;
        throw th;
    L100:
        Looper.prepare();
        SystemThread.access$100(SystemThread.access$000((SystemThread) this.f11046b));
        Looper.loop();
        return;
    L102:
        UIList r112 = (UIList) this.f11046b;
        ListStickyManager r32 = r112.f10517n;
        if (r32 == null) goto L109;
        if (r32.e == true) goto L109;
        UIListAdapter r33 = r32.f10506a.f10509b;
        r32.d.getClass();
        r32.f10508c.getClass();
    L109:
        if (r112.f10521r == false) goto L350;
        ListEventManager r34 = r112.f;
        UIListAdapter r35 = r112.f10509b;
        UIList r36 = r35.f10531c;
        RecyclerView.LayoutManager r37 = ((RecyclerView) r36.getView()).getLayoutManager();
        ArrayList r38 = r35.f10544u;
        if (r38.isEmpty() == false) goto L114;
    L112:
        int r39 = 0;
    L178:
        r34.e = r39;
        ListEventManager r113 = r112.f;
        int r40 = r113.e;
        if ((r113.f10505c & 1) == 0) goto L351;
        on.f r41 = new on.f(r113.d.getSign(), "scroll");
        if (r113.f == false) goto L183;
        r10 = r113.b();
    L183:
        float r42 = r40;
        r41.a("scrollLeft", Float.valueOf(r42 / DisplayMetricsHolder.a().density));
        r41.a("scrollTop", Float.valueOf(r42 / DisplayMetricsHolder.a().density));
        float r43 = 0;
        r41.a("deltaX", Float.valueOf(r43 / DisplayMetricsHolder.a().density));
        r41.a("deltaY", Float.valueOf(r43 / DisplayMetricsHolder.a().density));
        if (r10 == null) goto L197;
        ArrayList r44 = new ArrayList();
    L188:
        if (r5 >= r10.size()) goto L196;
        JavaOnlyMap r45 = r10.getMap(r5);
        if (r45 == null) goto L195;
        if (r45.isEmpty() == true) goto L195;
        r44.add(r45);
    L195:
        r5 = r5 + 1;
        goto L188
    L196:
        r41.a("attachedCells", r44);
    L197:
        r113.f10503a.b(r41);
        return;
    L351:
        return;
    L114:
        if ((r37 instanceof ListLayoutManager$ListLinearLayoutManager) == false) goto L127;
        ListLayoutManager$ListLinearLayoutManager r46 = (ListLayoutManager$ListLinearLayoutManager) r37;
        int r47 = r46.findFirstVisibleItemPosition();
        View r48 = r46.findViewByPosition(r47);
        if (r48 == null) goto L118;
        r39 = -((int) r48.getY());
    L119:
        HashMap r49 = (HashMap) r38.get(0);
        int r50 = 0;
    L120:
        if (r50 >= r47) goto L178;
        if (r49.get(Integer.valueOf(r50)) != null) goto L124;
        int r51 = 0;
    L125:
        r39 = r39 + r51;
        r50 = r50 + 1;
        goto L120
    L124:
        r51 = ((Integer) r49.get(Integer.valueOf(r50))).intValue();
        goto L125
    L118:
        r39 = 0;
        goto L119
    L127:
        if ((r37 instanceof ListLayoutManager$ListGridLayoutManager) == true) goto L281;
        int r52 = r36.f10510c;
        int[] r53 = new int[r52];
        View[] r54 = new View[r52];
        ((en.e) r37).findFirstVisibleItemPositions(r53);
        int r55 = 0;
    L148:
        if (r55 >= r52) goto L161;
        int r114 = 0;
    L151:
        if (r114 >= ((RecyclerView) r36.getView()).getChildCount()) goto L160;
        View r115 = ((RecyclerView) r36.getView()).getChildAt(r114);
        if (r115 == null) goto L157;
        if (((RecyclerView) r36.getView()).getChildViewHolder(r115) == null) goto L157;
        throw new ClassCastException();
    L157:
        r114 = r114 + 1;
        goto L151
    L160:
        r55 = r55 + 1;
        goto L148
    L161:
        int r56 = 0;
        r39 = 0;
    L162:
        if (r56 >= r52) goto L178;
        if (r56 >= r38.size()) goto L178;
        View r116 = r54[r56];
        if (r116 == null) goto L177;
        int r117 = -((int) r116.getY());
        HashMap r118 = (HashMap) r38.get(r56);
        int r119 = 0;
    L170:
        if (r119 >= r53[r56]) goto L176;
        if (r118.get(Integer.valueOf(r119)) != null) goto L174;
        int r120 = 0;
    L175:
        r117 = r117 + r120;
        r119 = r119 + 1;
        goto L170
    L174:
        r120 = ((Integer) r118.get(Integer.valueOf(r119))).intValue();
        goto L175
    L176:
        r39 = Math.max(r39, r117);
    L177:
        r56 = r56 + 1;
        goto L162
    L281:
        ListLayoutManager$ListGridLayoutManager r57 = (ListLayoutManager$ListGridLayoutManager) r37;     // Catch: Exception -> L141
        int r58 = 0;
        int r59 = 0;
    L129:
        if (r59 >= r38.size()) goto L145;
        View r60 = r57.getChildAt(r59);     // Catch: Exception -> L141
        if (r60 == null) goto L144;
        int r61 = r57.getPosition(r60);     // Catch: Exception -> L141
        int r62 = -((int) r60.getY());
        HashMap r121 = (HashMap) r38.get(r59);     // Catch: Exception -> L141
        int r122 = 0;
    L135:
        if (r122 >= r61) goto L143;
        if (r121.get(Integer.valueOf(r122)) != null) goto L139;
        int r123 = 0;
    L140:
        r62 = r62 + r123;     // Catch: Exception -> L141
        r122 = r122 + 1;     // Catch: Exception -> L141
        goto L135
    L139:
        r123 = ((Integer) r121.get(Integer.valueOf(r122))).intValue();     // Catch: Exception -> L141
        goto L140
    L143:
        r58 = Math.max(r58, r62);     // Catch: Exception -> L141
    L144:
        r59 = r59 + 1;
        goto L129
    L145:
        r39 = r58;
    L141:
        e = move-exception;
        e.printStackTrace();
        goto L112
    L350:
        return;
    L199:
        ((View) this.f11046b).requestLayout();
        return;
    L201:
        ((b0.c) this.f11046b).b(true);
        return;
    L203:
        Logger.d("ThreadPlus", "thread count: " + e8.f.f16791c.incrementAndGet());
        ((e8.f) this.f11046b).run();     // Catch: Exception -> L206
    L208:
        Logger.d("ThreadPlus", "thread count: " + e8.f.f16791c.decrementAndGet());
        return;
    L206:
        e = move-exception;
        Logger.w("ThreadPlus", "Thread crashed!", e);
        goto L208
    L212:
        ((com.lynx.animax.player.b) this.f11046b).d();
        return;
    L214:
        ((dn.f) this.f11046b).n();
        return;
    L216:
        dn.b r124 = ((InlineImageShadowNode) this.f11046b).O;
        if (r124 == null) goto L353;
        r124.m();
        return;
    L353:
        return;
    L220:
        ((com.obric.oui.panel.j) this.f11046b).k(0);
        return;
    L222:
        ODialogListItemView.n((OSelectionItemView) this.f11046b);
        return;
    L224:
        CloseableReference r125 = ((b1) this.f11046b).g;
        if (r125 == null) goto L354;
        r125.close();
        return;
    L354:
        return;
    L228:
        s0 r63 = (s0) this.f11046b;
        no.d r64 = r63.f11103b;
        v0 r65 = r63.f11104c;
        if (r64 == r65.f11131q) goto L232;
        Log.e("LynxImageManager", "imageRequest != mCurImageRequest invalid request");
        return;
    L232:
        if (r65.f11138y == true) goto L236;
        v0 r66 = ((s0) this.f11046b).f11104c;
        t0 r67 = r66.f11130p;
        if (r67 == null) goto L236;
        r67.onDrawableReady(r66.f11125k.d());
    L236:
        TraceEvent.c("LynxImageManager.onAttach");
        ((s0) this.f11046b).f11104c.a();
        v0 r126 = ((s0) this.f11046b).f11104c;
        if (r126.f11124j == false) goto L239;
        r126.f11125k.f();
    L239:
        TraceEvent.a(0, "LynxImageManager.onAttach");
        return;
    L241:
        d0 r68 = d0.e;
        d0 r127 = (d0) this.f11046b;
        r127.d = new Handler(r127.getLooper());
        r127.f11038c = new Handler(Looper.myLooper());
        LinkedList r69 = r127.f11036a;
        if (r69 != null) goto L244;
    L250:
        LinkedList r70 = r127.f11037b;
        if (r70 != null) goto L253;
        return;
    L253:
        if (r70.isEmpty() == true) goto L357;
        Iterator r71 = r127.f11037b.iterator();
    L256:
        if (r71.hasNext() == false) goto L258;
        r127.d.post((Runnable) r71.next());
        goto L256
    L258:
        r127.f11037b.clear();
        return;
    L357:
        return;
    L244:
        if (r69.isEmpty() == true) goto L250;
        Iterator r72 = r127.f11036a.iterator();
    L247:
        if (r72.hasNext() == false) goto L249;
        r127.f11038c.post((Runnable) r72.next());
        goto L247
    L249:
        r127.f11036a.clear();
        goto L250
    L260:
        a0 r128 = (a0) this.f11046b;
        if (r128.f11016t == false) goto L358;
        r128.f11016t = false;
        r128.f11022z.mo100a();
        return;
    L358:
        return;
    L264:
        FrescoInlineImageShadowNode r129 = (FrescoInlineImageShadowNode) this.f11046b;
        if (r129.V == null) goto L359;
        LynxLog.b(2, "FrescoInlineImageShadowNode", "close reference mRef = " + r129.V.hashCode());
        r129.V.close();
        r129.V = null;
        return;
    L359:
        return;
    L268:
        k r130 = (k) this.f11046b;
        WeakReference r73 = r130.f11073o;
        if (r73 != null) goto L271;
        return;
    L271:
        if (r73.get() == null) goto L361;
        ((LynxContext) r130.f11073o.get()).b(new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3, null, false));
        return;
    L361:
        return;
    L274:
        ((i) this.f11046b).invalidateSelf();
        return;
    L283:
        ((e6.e) ((e6.d) this.f11046b).f16763b).g();     // Catch: Throwable -> L278
        return;
    L352:
        return;
    L28:
        if (((ia.f) this.f11046b).f17562c.isEmpty() == true) goto L33;
        if (((ia.f) this.f11046b).d == null) goto L28;
        ((ia.f) this.f11046b).d.sendMessageAtFrontOfQueue((Message) ((ia.f) this.f11046b).f17562c.poll());
    L33:
        if (((ia.f) this.f11046b).f17561b.isEmpty() == true) goto L37;
        ia.e r74 = (ia.e) ((ia.f) this.f11046b).f17561b.poll();
        if (((ia.f) this.f11046b).d == null) goto L33;
        ((ia.f) this.f11046b).d.sendMessageAtTime(r74.f17558a, r74.f17559b);
        goto L33
    L37:
        return;
    L92:
        if (Logger.debug() == false) goto L95;
        Logger.d("WsChannelSdk", "sRunnable AppAlive = " + g8.c.f17061c);
    L95:
        if (g8.c.f17061c == false) goto L348;
        g8.c.f17061c = false;
        g8.b r131 = ((g8.c) this.f11046b).f17062a;
        if (r131 == null) goto L349;
        r131.b();
        return;
    L349:
        return;
    }

    public /* synthetic */ h(Object r5, int r10) {
        this.f11045a = r10;
        this.f11046b = r5;
    }
}
