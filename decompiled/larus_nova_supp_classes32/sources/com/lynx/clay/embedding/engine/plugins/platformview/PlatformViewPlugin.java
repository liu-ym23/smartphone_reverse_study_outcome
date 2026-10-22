package com.lynx.clay.embedding.engine.plugins.platformview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import c5a.c;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.util.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n5a.h;
import n5a.i;
import n5a.j;
import n5a.k;
import n5a.l;
import n5a.m;
import n5a.n;
import n5a.o;
import n5a.p;
import o5a.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlatformViewPlugin implements j {
    private static final String PLATFORM_VIEW_TOUCH_RESULT_EVENT = "__clay_platform_view_touch_dispatch_result__";
    private static final Set<String> SYSTEM_TOUCH_DISPATCH_WHITELIST = null;
    private static final String TAG = "PlatformViewPlugin";
    private static Class[] VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY;
    private final ClayPluginContext context;
    private boolean enableSystemTouchDispatch;
    private boolean isInternalView;
    private i platformViewContext;
    private k platformViewHolder;
    private String tag;
    private int viewId;
    private final long viewPtr;

    public class a implements v5a.b.d {
        public final /* synthetic */ PlatformViewPlugin a;

        public a(PlatformViewPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements PlatformMethodCallback {
        public final /* synthetic */ long a;
        public final /* synthetic */ PlatformViewPlugin b;

        public b(PlatformViewPlugin r1, long r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallback
        public final void invoke(int r7, Object r8, PlatformViewDataProtocol r9) {
            this.b.nativeOnPlatformMethodCallback(this.a, r7, r8, r9.ordinal());
        }
    }

    public static /* synthetic */ boolean a(PlatformViewPlugin r0, MotionEvent r1, int r2, int r3) {
        return r0.lambda$onCreateView$1(r1, r2, r3);
    }

    public static /* synthetic */ void b(PlatformViewPlugin r0, MotionEvent r1, boolean r2) {
        r0.lambda$onCreateView$0(r1, r2);
    }

    public native void nativeMarkAsEditing(long r1);

    public native void nativeMarkLayoutDirty(long r1);

    public native void nativeOnPlatformMethodCallback(long r1, int r3, Object r4, int r5);

    public native void nativeOnPlatformViewSendEvent(long r1, String r3, String r4);

    public native void nativeRequestSubtreeRasterSnapshot(long r1, float r3, SubtreeRasterSnapshotCallback r4);

    private FlutterView getFlutterView() {
        ClayPluginContext r0 = this.context;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a;
    }

    private void onDestroyView() {
        k r0 = this.platformViewHolder;
        if (r0 == null) goto L5;
        r0.release();
        this.platformViewHolder = null;
    L5:
        i r1 = this.platformViewContext;
        if (r1 == null) goto L11;
        int r2 = this.viewId;
        n5a.b r3 = (n5a.b) r1;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r4 = r3.c;
        HashMap r5 = (HashMap) r4;
        com.lynx.clay.embedding.engine.plugins.platformview.a r6 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r5.get(Integer.valueOf(r2));
        if (r6 == null) goto L10;
        r6.h();
    L10:
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r7 = r3.c;
        HashMap r8 = (HashMap) r7;
        r8.remove(Integer.valueOf(r2));
    L11:
        this.platformViewContext = null;
    }

    private void onViewDetached() {
        k r0 = this.platformViewHolder;
        if (r0 != null) goto L5;
        c.d(5, TAG, "onViewDetached invoked with null platformViewHolder, viewId=" + this.viewId);
    L6:
        i r1 = this.platformViewContext;
        if (r1 == null) goto L12;
        int r2 = this.viewId;
        com.lynx.clay.embedding.engine.plugins.platformview.a r3 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r1).c).get(Integer.valueOf(r2));
        if (r3 == null) goto L13;
        r3.l();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0.onViewDetached();
        goto L6
    }

    @Override // n5a.j
    public void markAsEditing() {
        nativeMarkAsEditing(this.viewPtr);
    }

    @Override // n5a.j
    public void markLayoutDirty() {
        nativeMarkLayoutDirty(this.viewPtr);
    }

    static {
        SYSTEM_TOUCH_DISPATCH_WHITELIST = Collections.singleton("x-comment-inputview-card");
        VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY = new Class[]{SurfaceView.class};
    }

    private boolean ensureFlutterViewAttached() {
        if (getFlutterView() != null) goto L5;
        return false;
    L5:
        if (this.platformViewContext == null) goto L11;
        return true;
    L11:
        return false;
    }

    private void onInvalidate() {
        if (ensureFlutterViewAttached() == false) goto L8;
        k r0 = this.platformViewHolder;
        if (r0 == null) goto L9;
        r0.b();
        return;
    L9:
        return;
    }

    private void onNodeReady() {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r0 = this.platformViewContext;
        int r1 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r2 = ((n5a.b) r0).c;
        HashMap r3 = (HashMap) r2;
        com.lynx.clay.embedding.engine.plugins.platformview.a r4 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r3.get(Integer.valueOf(r1));
        if (r4 == null) goto L9;
        r4.j();
        return;
    L9:
        return;
    }

    private void onViewAttached() {
        if (ensureFlutterViewAttached() == false) goto L12;
        k r0 = this.platformViewHolder;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.platformViewContext == null) goto L14;
        r0.a(this.context.a);
        i r1 = this.platformViewContext;
        int r2 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r3 = ((n5a.b) r1).c;
        HashMap r4 = (HashMap) r3;
        com.lynx.clay.embedding.engine.plugins.platformview.a r5 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r4.get(Integer.valueOf(r2));
        if (r5 == null) goto L15;
        r5.k();
        return;
    L15:
        return;
    L14:
        return;
    }

    private void resignFirstResponder() {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r0 = this.platformViewContext;
        int r1 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r2 = ((n5a.b) r0).c;
        HashMap r3 = (HashMap) r2;
        com.lynx.clay.embedding.engine.plugins.platformview.a r4 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r3.get(Integer.valueOf(r1));
        if (r4 == null) goto L9;
        r4.m();
        return;
    L9:
        return;
    }

    private boolean usesSystemTouchDispatch() {
        return this.enableSystemTouchDispatch;
    }

    private MotionEvent parseMotionEvent(byte[] r20) {
        ByteBuffer r0 = ByteBuffer.wrap(r20);
        r0.order(ByteOrder.nativeOrder());
        long r2 = r0.getLong();
        long r4 = r0.getLong();
        float r12 = r0.getFloat();
        float r13 = r0.getFloat();
        int r6 = r0.getInt();
        int r7 = r0.getInt();
        int r10 = r0.getInt();
        int r11 = r0.getInt();
        int r14 = r0.getInt();
        int r15 = r0.getInt();
        int r16 = r0.getInt();
        int r17 = r0.getInt();
        r0.getInt();
        MotionEvent.PointerProperties[] r8 = new MotionEvent.PointerProperties[r7];
        int r9 = 0;
    L3:
        if (r9 >= r7) goto L5;
        MotionEvent.PointerProperties r1 = new MotionEvent.PointerProperties();
        int r18 = r15;
        r1.id = r0.getInt();
        r1.toolType = r0.getInt();
        r8[r9] = r1;
        r9 = r9 + 1;
        r15 = r18;
        goto L3
    L5:
        int r19 = r15;
        MotionEvent.PointerCoords[] r21 = new MotionEvent.PointerCoords[r7];
        int r3 = 0;
    L6:
        if (r3 >= r7) goto L9;
        MotionEvent.PointerCoords r110 = new MotionEvent.PointerCoords();
        int r22 = r14;
        r110.x = r0.getFloat();
        r110.y = r0.getFloat();
        r110.pressure = r0.getFloat();
        r110.size = r0.getFloat();
        r110.orientation = r0.getFloat();
        r21[r3] = r110;
        r3 = r3 + 1;
        r14 = r22;
        goto L6
    L9:
        return MotionEvent.obtain(r2, r4, r6, r7, r8, r21, r10, r11, r12, r13, r14, r19, r16, r17);
    }

    public void onPlatformViewTouchEvent(byte[] r3) {
        if (r3 != null) goto L6;
        c.d(5, TAG, "onPlatformViewTouchEvent invoked with null event data");
        return;
    L6:
        if (ensureFlutterViewAttached() == true) goto L8;
        return;
    L8:
        if (usesSystemTouchDispatch() == false) goto L10;
        return;
    L10:
        i r0 = this.platformViewContext;
        int r1 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r2 = ((n5a.b) r0).c;
        HashMap r4 = (HashMap) r2;
        com.lynx.clay.embedding.engine.plugins.platformview.a r5 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r4.get(Integer.valueOf(r1));
        if (r5 == null) goto L13;
        View r6 = r5.b();
    L14:
        if (r6 == null) goto L18;
        r6.dispatchTouchEvent(parseMotionEvent(r3));
        return;
    L18:
        return;
    L13:
        r6 = null;
        goto L14
    }

    private PlatformViewPlugin(ClayPluginContext r1, long r2) {
        this.context = r1;
        this.viewPtr = r2;
    }

    public static PlatformViewPlugin Create(ClayPluginContext r1, long r2) {
        return new PlatformViewPlugin(r1, r2);
    }

    private /* synthetic */ void lambda$onCreateView$0(MotionEvent r1, boolean r2) {
        syncPlatformViewTouchDispatchResult(r1, r2);
    }

    private void onInsertNode(int r3, int r4) {
        if (ensureFlutterViewAttached() == false) goto L13;
        i r5 = this.platformViewContext;
        if (r5 == null) goto L14;
        int r0 = this.viewId;
        n5a.b r6 = (n5a.b) r5;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r1 = r6.c;
        HashMap r2 = (HashMap) r1;
        com.lynx.clay.embedding.engine.plugins.platformview.a r7 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r2.get(Integer.valueOf(r0));
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r8 = r6.c;
        HashMap r9 = (HashMap) r8;
        com.lynx.clay.embedding.engine.plugins.platformview.a r10 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r9.get(Integer.valueOf(r3));
        if ((r10 instanceof f) == true) goto L9;
        return;
    L9:
        if ((r7 instanceof f) == false) goto L16;
        f r11 = (f) r7;
        ((f) r10).getClass();
        return;
    L16:
        return;
    L14:
        return;
    }

    private void onPlatformViewAttributesUpdate(byte[] r5, byte[] r6) {
    L18:
        e = move-exception;
        c.b(TAG, "onPlatformViewAttributesUpdate exception:", e);
        return;
    L3:
        if (ensureFlutterViewAttached() == false) goto L25;
        JSONObject r0 = new JSONObject(new String(r5, StandardCharsets.UTF_8));     // Catch: Exception -> L18
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L18
        if (r6 == null) goto L10;
        JSONArray r1 = new JSONArray(new String(r6, StandardCharsets.UTF_8));     // Catch: Exception -> L18
        int r8 = 0;
    L8:
        if (r8 >= r1.length()) goto L10;
        r7.add(r1.optString(r8));     // Catch: Exception -> L18
        r8 = r8 + 1;     // Catch: Exception -> L18
    L10:
        i r9 = this.platformViewContext;     // Catch: Exception -> L18
        int r2 = this.viewId;     // Catch: Exception -> L18
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r10 = ((n5a.b) r9).c;     // Catch: Exception -> L18
        HashMap r11 = (HashMap) r10;     // Catch: Exception -> L18
        com.lynx.clay.embedding.engine.plugins.platformview.a r12 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r11.get(Integer.valueOf(r2));     // Catch: Exception -> L18
        if (r12 == null) goto L26;
        Iterator<String> r3 = r0.keys();     // Catch: Exception -> L18
    L14:
        if (r3.hasNext() == false) goto L16;
        String r4 = r3.next();     // Catch: Exception -> L18
        r12.n(r4, r0.opt(r4));     // Catch: Exception -> L18
        goto L14
    L16:
        r12.p(r7);     // Catch: Exception -> L18
        r12.g();     // Catch: Exception -> L18
        return;
    L26:
        return;
    }

    private boolean shouldDispatchSystemTouchEventToPlatformView(int r3, int r4) {
        FlutterView r0 = getFlutterView();
        if (r0 != null) goto L5;
        return true;
    L5:
        FlutterEngine r1 = r0.getAttachedFlutterEngine();
        if (r1 != null) goto L8;
        return true;
    L8:
        int r2 = this.viewId;
        FlutterJNI r5 = r1.a;
        if (r5 != null) goto L13;
        return false;
    L13:
        return r5.isHitTestingTargetNativeView(r2, r3, r4);
    }

    private void syncPlatformViewTouchDispatchResult(MotionEvent r3, boolean r4) {
        int r5 = r3.getActionMasked();
        if (r5 != 0) goto L5;
    L18:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L15
        r0.put("handled", r4);     // Catch: Exception -> L15
        r0.put("action", r5);     // Catch: Exception -> L15
        nativeOnPlatformViewSendEvent(this.viewPtr, PLATFORM_VIEW_TOUCH_RESULT_EVENT, r0.toString());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        c.b(TAG, "syncPlatformViewTouchDispatchResult exception:", e);
        return;
    L5:
        if (r5 == 5) goto L18;
        if (r5 == 1) goto L18;
        if (r5 == 6) goto L18;
        if (r5 == 3) goto L18;
    }

    public void requestSubtreeRasterSnapshot(float r3, SubtreeRasterSnapshotCallback r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 > 0.0f) goto L7;
    L11:
        r4.onError();
        return;
    L7:
        if (r3 > 1.0f) goto L11;
        nativeRequestSubtreeRasterSnapshot(this.viewPtr, r3, r4);
    }

    public void sendEvent(String r3, List<Object> r4) {
        if (r4 != null) goto L4;
        JSONArray r5 = new JSONArray();     // Catch: Exception -> L7
    L5:
        nativeOnPlatformViewSendEvent(this.viewPtr, r3, r5.toString());     // Catch: Exception -> L7
        return;
    L4:
        r5 = new JSONArray(r4);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        c.b(TAG, "PlatformView sendEvent exception:", e);
    }

    @Override // n5a.j
    public void sendEvent(String r3, Map<String, Object> r4) {
        if (r4 != null) goto L4;
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L7
    L5:
        nativeOnPlatformViewSendEvent(this.viewPtr, r3, r5.toString());     // Catch: Exception -> L7
        return;
    L4:
        r5 = new JSONObject(r4);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        c.b(TAG, "PlatformView sendEvent exception:", e);
    }

    public static /* synthetic */ void access$000(PlatformViewPlugin r0, MotionEvent r1, boolean r2) {
        r0.syncPlatformViewTouchDispatchResult(r1, r2);
    }

    private void invokePlatformMethod(String r4, long r5, byte[] r7) {
    L10:
        e = move-exception;
        c.b(TAG, "invokePlatformMethod exception:", e);
        return;
    L3:
        if (ensureFlutterViewAttached() == true) goto L5;
        return;
    L5:
        if (r7.length <= 0) goto L7;
        JSONObject r0 = new JSONObject(new String(r7, StandardCharsets.UTF_8));     // Catch: Exception -> L10
    L8:
        i r8 = this.platformViewContext;     // Catch: Exception -> L10
        n5a.b r9 = (n5a.b) r8;     // Catch: Exception -> L10
        r9.b(this.viewId, r4, r0, new b(this, r5));     // Catch: Exception -> L10
        return;
    L7:
        r0 = new JSONObject();     // Catch: Exception -> L10
        goto L8
    }

    private /* synthetic */ boolean lambda$onCreateView$1(MotionEvent r1, int r2, int r3) {
        return shouldDispatchSystemTouchEventToPlatformView(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [n5a.m] */
    private boolean onCreateView(int r16, String r17, SurfaceTexture r18) {
        FlutterView r6 = getFlutterView();
        if (r6 != null) goto L6;
        c.d(5, TAG, "onCreateView invoked without an attached FlutterView");
        return false;
    L6:
        if (r17 != null) goto L9;
        c.d(5, TAG, "onCreateView invoked with a null tag");
        return false;
    L9:
        this.viewId = r16;
        this.tag = r17;
        this.enableSystemTouchDispatch = false;
        InternalPlatformViewRegistry r8 = InternalPlatformViewRegistry.e;
        monitor-enter(r8);
        r8.a();     // Catch: Throwable -> L79
        if (r8.a.containsKey(r17) == true) goto L17;
        if (r8.b.containsKey(r17) == true) goto L17;
        boolean r9 = false;
    L18:
        monitor-exit(r8);
        if (r9 == false) goto L21;
        this.isInternalView = true;
        this.platformViewContext = r6.getInternalPlatformViewContext();
    L23:
        if (ensureFlutterViewAttached() == true) goto L82;
        c.d(5, TAG, "onCreateView invoked before PlatformViewContext is ready, tag=".concat(r17));
        return false;
    L82:
        ((n5a.b) this.platformViewContext).a(r16, r17, this);     // Catch: Exception -> L29
        com.lynx.clay.embedding.engine.plugins.platformview.a r7 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) this.platformViewContext).c).get(Integer.valueOf(r16));     // Catch: Exception -> L29
        if (r7 == null) goto L31;
        View r10 = r7.b();     // Catch: Exception -> L29
    L32:
        if (r10 == null) goto L76;
        if (r10.getParent() != null) goto L74;
        InternalPlatformViewRegistry.ViewDrawType r3 = InternalPlatformViewRegistry.ViewDrawType.DRAWABLE;     // Catch: Exception -> L29
        com.lynx.clay.embedding.engine.plugins.platformview.a r5 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) this.platformViewContext).c).get(Integer.valueOf(r16));     // Catch: Exception -> L29
        LynxUIClayUIBridge$CompositionPreference r11 = LynxUIClayUIBridge$CompositionPreference.AUTO;     // Catch: Exception -> L29
        if (r5 == null) goto L39;
        r3 = r5.f;     // Catch: Exception -> L29
        r11 = r5.g;     // Catch: Exception -> L29
    L39:
        if (r3 == InternalPlatformViewRegistry.ViewDrawType.LOGICAL_ONLY) goto L41;
        boolean r12 = true;
    L42:
        boolean r13 = SYSTEM_TOUCH_DISPATCH_WHITELIST.contains(r17);     // Catch: Exception -> L29
        if (r18 != null) goto L48;
        l r2 = new l(r6, r16, r10, r12);     // Catch: Exception -> L29
        this.platformViewHolder = r2;     // Catch: Exception -> L29
        if (r13 == false) goto L72;
        this.enableSystemTouchDispatch = true;     // Catch: Exception -> L29
        r2.d(new m(this));     // Catch: Exception -> L29
    L72:
        return true;
    L48:
        if (Build.VERSION.SDK_INT < 23) goto L52;
        final Class[] r4 = VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY;     // Catch: Exception -> L29
        if (d.b(r10, new com.lynx.clay.util.c(r4)) == true) goto L52;
        boolean r14 = true;
    L54:
        if (r11 != LynxUIClayUIBridge$CompositionPreference.OFFSCREEN_SURFACE) goto L56;
        boolean r15 = true;
    L57:
        if (r15 == true) goto L83;
        if (r14 == false) goto L83;
    L63:
        if (this.platformViewHolder != null) goto L72;
        Context r19 = r6.getContext();     // Catch: Exception -> L29
        if (r13 == false) goto L67;
        n r20 = new n(this);     // Catch: Exception -> L29
    L68:
        if (r13 == false) goto L70;
        a r110 = new a(this);     // Catch: Exception -> L29
    L71:
        this.platformViewHolder = new p(r19, r18, r10, r12, r13, r20, r110);     // Catch: Exception -> L29
        this.enableSystemTouchDispatch = r13;     // Catch: Exception -> L29
        goto L72
    L70:
        r110 = null;
        goto L71
    L67:
        r20 = null;
    L83:
        this.platformViewHolder = new o(r6.getContext(), r18, r16, r10);     // Catch: Exception -> L61
    L61:
        this.platformViewHolder = null;     // Catch: Exception -> L29
        goto L63
    L56:
        r15 = false;
    L52:
        r14 = false;
        goto L54
    L41:
        r12 = false;
        goto L42
    L74:
        throw new IllegalStateException("PlatformView with id: " + r16 + " already added to parent view");     // Catch: Exception -> L29
    L76:
        throw new IllegalStateException("PlatformView with id: " + r16 + " not created");     // Catch: Exception -> L29
    L31:
        r10 = null;
    L29:
        e = move-exception;
        c.b(TAG, "onCreateView exception:", e);
        return false;
    L21:
        this.isInternalView = false;
        this.platformViewContext = r6.getExternalPlatformViewContext();
    L17:
        r9 = true;
    L79:
        th = move-exception;
        throw th;
    }

    private long onLayout(int r4, int r5, int r6, int r7) {
        if (ensureFlutterViewAttached() == false) goto L16;
        k r0 = this.platformViewHolder;
        if (r0 == null) goto L16;
        Size r1 = r0.c(r4, r5, r6, r7);
        if (r1 != null) goto L10;
        r1 = new Size(0, 0);
    L10:
        i r2 = this.platformViewContext;
        int r3 = this.viewId;
        com.lynx.clay.embedding.engine.plugins.platformview.a r8 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r2).c).get(Integer.valueOf(r3));
        if (r8 == null) goto L15;
        r8.i(r4, r5, r6, r7);
    L15:
        return ((long) r1.getWidth()) | (((long) r1.getHeight()) << 32);
    L16:
        c.d(5, TAG, "onLayout invoked before platform view is ready, viewId=" + this.viewId);
        return 0;
    }

    private float[] onMeasure(int r4, int r5, int r6, int r7) {
        if (ensureFlutterViewAttached() == false) goto L11;
        i r0 = this.platformViewContext;
        int r2 = this.viewId;
        MeasureMode r8 = MeasureMode.fromInt(r4);
        MeasureMode r9 = MeasureMode.fromInt(r6);
        com.lynx.clay.embedding.engine.plugins.platformview.a r1 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r0).c).get(Integer.valueOf(r2));
        if (r1 == null) goto L7;
        h r10 = r1.f(r8, r5, r9, r7);
    L8:
        float[] r11 = r10.a;
        return new float[]{r11[0], r11[1], r11[2]};
    L7:
        r10 = new h(0.0f, 0.0f);
        goto L8
    L11:
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private void updatePaddings(float r3, float r4, float r5, float r6) {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r0 = this.platformViewContext;
        int r1 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r2 = ((n5a.b) r0).c;
        HashMap r7 = (HashMap) r2;
        com.lynx.clay.embedding.engine.plugins.platformview.a r8 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r7.get(Integer.valueOf(r1));
        if (r8 == null) goto L9;
        r8.r(r3, r4, r5, r6);
        return;
    L9:
        return;
    }
}
