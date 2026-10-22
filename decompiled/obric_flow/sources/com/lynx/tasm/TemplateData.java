package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.common.NullableConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class TemplateData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f10054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AbstractMap f10055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10056c;
    public volatile boolean d;
    public boolean e;
    public volatile long f;
    public final AtomicBoolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference f10057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f10058i;

    public static final enum ActionType extends Enum<ActionType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ActionType f10059a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ActionType f10060b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ActionType f10061c = null;
        public static final /* synthetic */ ActionType[] d = null;

        static {
            ActionType r5 = new ActionType("STRING_DATA", 0);
            f10059a = r5;
            ActionType r10 = new ActionType("BYTE_BUFFER", 1);
            f10060b = r10;
            ActionType r11 = new ActionType("NATIVE_DATA", 2);
            f10061c = r11;
            d = new ActionType[]{r5, r10, r11, new ActionType("REMOVE_DATA", 3)};
        }

        public ActionType(String r5, int r10) {
            super(r5, r10);
        }

        public static ActionType valueOf(String r5) {
            return (ActionType) Enum.valueOf(ActionType.class, r5);
        }

        public static ActionType[] values() {
            return (ActionType[]) d.clone();
        }
    }

    public static class UpdateAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ActionType f10062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBuffer f10063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10064c;
        public long d;

        public UpdateAction() {
            this.f10063b = null;
            this.f10064c = null;
            this.d = 0;
        }

        public final void finalize() {
            super.finalize();
            long r5 = this.d;
            if (r5 == 0) goto L6;
            TemplateData.f(r5);
            return;
        }

        @CalledByNative
        public long getNativeData() {
            return this.d;
        }
    }

    public TemplateData() {
        this.e = false;
        this.g = new AtomicBoolean(false);
        this.f10058i = new ArrayList();
        LynxEnv.inst();
        this.f10056c = null;
    }

    public static TemplateData b(String r5) {
        TraceEvent.c("TemplateData.FromString");
        TemplateData r10 = new TemplateData(r5);
        TraceEvent.a(0, "TemplateData.FromString");
        return r10;
    }

    public static TemplateData c(Map r5) {
        TraceEvent.c("TemplateData.FromMap");
        TemplateData r10 = new TemplateData(r5);
        TraceEvent.a(0, "TemplateData.FromMap");
        return r10;
    }

    @CalledByNative
    private void consumeUpdateActions() {
        mn.h.d().execute(new v0(this, 2));
    }

    public static ArrayList d(JSONArray r5) {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= r5.length()) goto L17;
        Object r12 = r5.get(r11);     // Catch: Throwable -> L8
        if ((r12 instanceof JSONObject) == false) goto L11;
        r12 = e((JSONObject) r12);     // Catch: Throwable -> L8
    L13:
        r10.add(r12);     // Catch: Throwable -> L8
    L16:
        r11 = r11 + 1;
        goto L4
    L11:
        if ((r12 instanceof JSONArray) == false) goto L13;
        r12 = d((JSONArray) r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        StringBuilder r13 = p.d(r11, "Failed to parse JSONArray at index ", ": ");
        r13.append(th.getMessage());
        LynxLog.b(4, "LynxTemplateData", r13.toString());
        goto L16
    L17:
        return r10;
    }

    @CalledByNative
    private static Object decodeByteBuffer(ByteBuffer r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return kn.b.a(r5);
    }

    public static HashMap e(JSONObject r5) {
        HashMap r10 = new HashMap();
        Iterator<String> r11 = r5.keys();     // Catch: Throwable -> L9
    L4:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();     // Catch: Throwable -> L9
        Object r13 = r5.get(r12);     // Catch: Throwable -> L9
        if ((r13 instanceof JSONObject) == false) goto L12;
        r13 = e((JSONObject) r13);     // Catch: Throwable -> L9
    L14:
        r10.put(r12, r13);     // Catch: Throwable -> L9
        goto L4
    L12:
        if ((r13 instanceof JSONArray) == false) goto L14;
        r13 = d((JSONArray) r13);     // Catch: Throwable -> L9
    L17:
        return r10;
    L9:
        th = move-exception;
        LynxLog.b(4, "LynxTemplateData", "Failed to parse JSONObject: " + th.getMessage());
        goto L17
    }

    public static /* synthetic */ void f(long r5) {
        nativeReleaseData(r5);
    }

    private static native long nativeClone(long r5);

    private static native long nativeCreateObject();

    private static native long nativeCreateTemplateData(long r5, boolean r10, String r11, Object r12);

    public static native Object nativeGetData(long r5);

    public static native void nativeMergeTemplateData(long r5, long r10);

    private static native long nativeParseData(ByteBuffer r5, int r10);

    private static native long nativeParseStringData(String r5);

    private static native void nativeReleaseData(long r5);

    private static native void nativeReleaseTemplateData(long r5);

    private static native void nativeRemoveData(long r5, String r10);

    private static native long nativeShallowCopy(long r5);

    private static native void nativeUpdateData(long r5, ByteBuffer r10, int r11);

    public final TemplateData a() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L6;
        LynxLog.b(4, "LynxTemplateData", "deepClone failed since env not ready!");
        return new TemplateData();
    L6:
        k();
        TemplateData r5 = new TemplateData();
        if (this.f10054a == 0) goto L9;
        r5.f10054a = nativeClone(this.f10054a);
    L9:
        r5.f10056c = this.f10056c;
        r5.e = this.e;
        r5.d = this.d;
        r5.j(n());
        return r5;
    }

    public final void finalize() {
        o();
        monitor-enter(this);
        WeakReference r5 = this.f10057h;     // Catch: Throwable -> L13
        if (r5 == null) goto L16;
        LynxContext r10 = (LynxContext) r5.get();     // Catch: Throwable -> L13
        if (r10 == null) goto L16;
        v0 r11 = new v0(this, 1);     // Catch: Throwable -> L13
        UIBody.UIBodyView r12 = r10.l();     // Catch: Throwable -> L13
        if (r12 == null) goto L22;
        r12.runOnTasmThread(r11);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    L23:
        super.finalize();
        return;
    L22:
        monitor-exit(this);
    L16:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L22;
        if (this.f == 0) goto L22;
        nativeReleaseData(this.f);     // Catch: Throwable -> L13
        this.f = 0;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(UpdateAction r5) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f10058i != null) goto L8;
        this.f10058i = new ArrayList();     // Catch: Throwable -> L6
    L8:
        this.f10058i.add(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    @CalledByNative
    public long getDataForJSThread() {
        return m();
    }

    @CalledByNative
    public long getNativeTemplateData() {
        return this.f10054a;
    }

    @CalledByNative
    public TemplateData getTemplateDataForJSThread() {
        TemplateData r5 = new TemplateData();
        if (this.f == 0) goto L5;
        r5.f = nativeClone(this.f);
    L5:
        r5.j(n());
        return r5;
    }

    public final void h(TemplateData r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this != r5) goto L9;
        LynxLog.b(3, "LynxTemplateData", "can not update TemplateData with self");
        return;
    L9:
        if (this.e == false) goto L13;
        LynxLog.b(3, "LynxTemplateData", "can not update readOnly TemplateData");
        return;
    L13:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L17;
        LynxLog.b(3, "LynxTemplateData", "updateWithTemplateData failed since env not ready.");
        return;
    L17:
        if (this.g.get() == false) goto L19;
        LynxLog.b(3, "LynxTemplateData", "updateWithTemplateData to consumed TemplateData, this:" + this + ",diff:" + r5);
    L19:
        k();
        r5.k();
        j(r5.n());
        if (r5.f10054a == 0) goto L23;
        nativeMergeTemplateData(this.f10054a, r5.f10054a);
        return;
    }

    public final void i(String r5, Object r10) {
        if (this.e == false) goto L7;
        LynxLog.b(3, "LynxTemplateData", "can not update readOnly TemplateData");
        return;
    L7:
        if (this.g.get() == false) goto L9;
        LynxLog.b(3, "LynxTemplateData", "put data to consumed TemplateData,key:" + r5);
    L9:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.f10055b == null) goto L13;
        monitor-exit(this);
    L22:
        this.f10055b.put(r5, r10);
        return;
    L13:
        if (this.d == false) goto L17;
        AbstractMap r11 = new NullableConcurrentHashMap();     // Catch: Throwable -> L15
    L18:
        this.f10055b = r11;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        goto L22
    L17:
        r11 = new HashMap();     // Catch: Throwable -> L15
        goto L18
    }

    public final synchronized void j(ArrayList r5) {
        monitor-enter(this);
        if (r5 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f10058i != null) goto L11;
        this.f10058i = new ArrayList();     // Catch: Throwable -> L9
    L11:
        this.f10058i.addAll(r5);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public final synchronized void k() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L11;
        LynxLog.b(3, "LynxTemplateData", "Env not ready!");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.f10055b == null) goto L28;
        if (this.f10055b.isEmpty() == true) goto L28;
        boolean r5 = kn.b.f18686a;     // Catch: Throwable -> L8
        ByteBuffer r10 = kn.b.b(this.f10055b);     // Catch: Throwable -> L8
        this.f10055b.clear();     // Catch: Throwable -> L8
        if (r10 != null) goto L18;
    L32:
        monitor-exit(this);
        return;
    L18:
        if (r10.position() <= 0) goto L32;
        LynxLog.b(2, "LynxTemplateData", "flush data." + this);     // Catch: Throwable -> L8
        UpdateAction r11 = new UpdateAction();     // Catch: Throwable -> L8
        r11.f10062a = ActionType.f10060b;     // Catch: Throwable -> L8
        r11.f10063b = r10;     // Catch: Throwable -> L8
        g(r11);     // Catch: Throwable -> L8
        if (this.f10054a != 0) goto L24;
        this.f10054a = nativeParseData(r10, r10.position());     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L24:
        nativeUpdateData(this.f10054a, r10, r10.position());     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L28:
        if (this.f10054a != 0) goto L32;
        this.f10054a = nativeCreateObject();     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    public final void l(Map r5) {
        if (this.e == false) goto L7;
        LynxLog.b(4, "LynxTemplateData", "can not update readOnly TemplateData");
        return;
    L7:
        if (this.g.get() == false) goto L9;
        LynxLog.b(3, "LynxTemplateData", "updateData to consumed TemplateData, diff:" + r5.keySet());
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isEmpty() == true) goto L33;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.f10055b == null) goto L17;
        monitor-exit(this);
    L26:
        this.f10055b.putAll(r5);
        return;
    L17:
        if (this.d == false) goto L21;
        AbstractMap r10 = new NullableConcurrentHashMap();     // Catch: Throwable -> L19
    L22:
        this.f10055b = r10;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        goto L26
    L21:
        r10 = new HashMap();     // Catch: Throwable -> L19
        goto L22
    }

    public final synchronized long m() {
        monitor-enter(this);
        monitor-enter(this);     // Catch: Throwable -> L11
        ArrayList r5 = new ArrayList(this.f10058i);     // Catch: Throwable -> L43
        this.f10058i.clear();     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r5.isEmpty() == false) goto L14;
        long r10 = this.f;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L14:
        if (this.f != 0) goto L16;
        this.f = nativeCreateObject();     // Catch: Throwable -> L11
    L16:
        Iterator r11 = r5.iterator();     // Catch: Throwable -> L11
    L18:
        if (r11.hasNext() == false) goto L40;
        UpdateAction r12 = (UpdateAction) r11.next();     // Catch: Throwable -> L11
        int r13 = r12.f10062a.ordinal();     // Catch: Throwable -> L11
        if (r13 != 0) goto L22;
        String r14 = r12.f10064c;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r14) == true) goto L18;
        long r15 = nativeParseStringData(r14);     // Catch: Throwable -> L11
        nativeMergeTemplateData(this.f, r15);     // Catch: Throwable -> L11
        nativeReleaseData(r15);     // Catch: Throwable -> L11
        goto L18
    L22:
        if (r13 != 1) goto L24;
        ByteBuffer r16 = r12.f10063b;     // Catch: Throwable -> L11
        if (r16 == null) goto L18;
        if (r16.position() == 0) goto L18;
        long r17 = this.f;     // Catch: Throwable -> L11
        ByteBuffer r18 = r12.f10063b;     // Catch: Throwable -> L11
        nativeUpdateData(r17, r18, r18.position());     // Catch: Throwable -> L11
        goto L18
    L24:
        if (r13 != 2) goto L26;
        nativeMergeTemplateData(this.f, r12.getNativeData());     // Catch: Throwable -> L11
        goto L18
    L26:
        if (r13 != 3) goto L27;
        nativeRemoveData(this.f, null);     // Catch: Throwable -> L11
        goto L18
    L27:
        LynxLog.b(4, "LynxTemplateData", "undefined action type: " + r12.f10062a);     // Catch: Throwable -> L11
        goto L18
    L40:
        long r19 = this.f;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r19;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized ArrayList n() {
        monitor-enter(this);
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L6
        if (this.f == 0) goto L8;
        long r10 = nativeShallowCopy(this.f);     // Catch: Throwable -> L6
        UpdateAction r11 = new UpdateAction();     // Catch: Throwable -> L6
        r11.f10062a = ActionType.f10061c;     // Catch: Throwable -> L6
        r11.d = r10;     // Catch: Throwable -> L6
        r5.add(r11);     // Catch: Throwable -> L6
    L8:
        r5.addAll(this.f10058i);     // Catch: Throwable -> L6
        consumeUpdateActions();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void o() {
        monitor-enter(this);
        WeakReference r5 = this.f10057h;     // Catch: Throwable -> L12
        if (r5 == null) goto L15;
        LynxContext r10 = (LynxContext) r5.get();     // Catch: Throwable -> L12
        if (r10 == null) goto L15;
        v0 r11 = new v0(this, 0);     // Catch: Throwable -> L12
        UIBody.UIBodyView r12 = r10.l();     // Catch: Throwable -> L12
        if (r12 == null) goto L21;
        r12.runOnTasmThread(r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L21:
        monitor-exit(this);
        return;
    L15:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L21;
        if (this.f10054a == 0) goto L21;
        nativeReleaseData(this.f10054a);     // Catch: Throwable -> L12
        this.f10054a = 0;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final TemplateData p() {
        TraceEvent.c("TemplateData.ShallowClone");
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L6;
        LynxLog.b(4, "LynxTemplateData", "shallowClone failed since env not ready!");
        TraceEvent.a(0, "TemplateData.ShallowClone");
        return new TemplateData();
    L6:
        k();
        TemplateData r5 = new TemplateData();
        if (this.f10054a == 0) goto L9;
        r5.f10054a = nativeShallowCopy(this.f10054a);
    L9:
        r5.f10056c = this.f10056c;
        r5.e = this.e;
        r5.d = this.d;
        r5.j(n());
        TraceEvent.a(0, "TemplateData.ShallowClone");
        return r5;
    }

    public TemplateData(Map r5) {
        this.e = false;
        this.g = new AtomicBoolean(false);
        this.f10058i = new ArrayList();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L40;
        LynxEnv.inst();
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L10;
        ByteBuffer r10 = kn.b.b(r5);
        if (r10 != null) goto L32;
        return;
    L32:
        if (r10.position() <= 0) goto L42;
        this.f10054a = nativeParseData(r10, r10.position());
        this.f10056c = null;
        UpdateAction r11 = new UpdateAction();
        r11.f10062a = ActionType.f10060b;
        r11.f10063b = r10;
        g(r11);
        return;
    L42:
        return;
    L10:
        if (r5.isEmpty() == true) goto L41;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (this.f10055b == null) goto L16;
        monitor-exit(this);
    L25:
        this.f10055b.putAll(r5);
        return;
    L16:
        if (this.d == false) goto L20;
        AbstractMap r12 = new NullableConcurrentHashMap();     // Catch: Throwable -> L18
    L21:
        this.f10055b = r12;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        goto L25
    L20:
        r12 = new HashMap();     // Catch: Throwable -> L18
        goto L21
    L41:
        return;
    }

    public TemplateData(String r5) {
        this.e = false;
        this.g = new AtomicBoolean(false);
        this.f10058i = new ArrayList();
        if (TextUtils.isEmpty(r5) == true) goto L37;
        LynxEnv.inst();
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L35;
        this.f10054a = nativeParseStringData(r5);
        this.f10056c = null;
        UpdateAction r10 = new UpdateAction();
        r10.f10062a = ActionType.f10059a;
        r10.f10064c = r5;
        g(r10);
        return;
    L35:
        HashMap r11 = e(new JSONObject(r5));     // Catch: Throwable -> L25
        if (r11.isEmpty() == true) goto L36;
        monitor-enter(this);     // Catch: Throwable -> L25
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L12:
        if (this.f10055b == null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L25
    L23:
        this.f10055b.putAll(r11);     // Catch: Throwable -> L25
        return;
    L14:
        if (this.d == false) goto L18;
        AbstractMap r12 = new NullableConcurrentHashMap();     // Catch: Throwable -> L16
    L19:
        this.f10055b = r12;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
    L18:
        r12 = new HashMap();     // Catch: Throwable -> L16
        goto L19
    L36:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
