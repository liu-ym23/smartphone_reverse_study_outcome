package com.larus.browsertakeover.cdp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.browsertakeover.session.BrowserTakeoverSession;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import iv8.a0;
import iv8.b1;
import iv8.d0;
import iv8.e0;
import iv8.f0;
import iv8.h0;
import iv8.o0;
import iv8.r0;
import iv8.s;
import iv8.s0;
import iv8.t;
import iv8.u;
import iv8.u0;
import iv8.v;
import iv8.w;
import iv8.x0;
import iv8.y0;
import iv8.z0;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BrowserCdpClient {
    public static final Regex N = null;
    public static final Set<String> O = null;
    public static final String P = null;
    public static final String Q = null;
    public static final Set<String> R = null;
    public volatile boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public volatile float D;
    public volatile float E;
    public volatile c F;
    public String G;
    public boolean H;
    public b I;
    public i J;
    public h K;
    public h L;
    public boolean M;
    public final BrowserTransport a;
    public final d b;
    public final jv8.a c;
    public final Handler d;
    public final ExecutorService e;
    public final AtomicInteger f;
    public final AtomicInteger g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final AtomicInteger j;
    public final AtomicInteger k;
    public final ConcurrentHashMap<Integer, k> l;
    public final Object m;
    public final LinkedHashMap<Integer, String> n;
    public final String o;
    public final HashMap<String, f> p;
    public final Object q;
    public final com.larus.browsertakeover.cdp.b<m> r;
    public volatile boolean s;
    public long t;
    public final iv8.f u;
    public volatile boolean v;
    public volatile boolean w;
    public volatile String x;
    public volatile String y;
    public volatile String z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/cdp/BrowserCdpClient$State;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "ATTACHING", "READY", "DISCONNECTED", "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ATTACHING = null;
        public static final State CONNECTING = null;
        public static final State DISCONNECTED = null;
        public static final State ERROR = null;
        public static final State READY = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("CONNECTING", 0);
            CONNECTING = r0;
            State r1 = new State("ATTACHING", 1);
            ATTACHING = r1;
            State r3 = new State("READY", 2);
            READY = r3;
            State r5 = new State("DISCONNECTED", 3);
            DISCONNECTED = r5;
            State r7 = new State("ERROR", 4);
            ERROR = r7;
            State[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final String d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;
        public final boolean i;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f, r6.f) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.g, r6.g) == 0) goto L30;
            return false;
        L30:
            if (Float.compare(this.h, r6.h) == 0) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31;
            if (this.i == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "EncodedFrame(data=" + this.a + ", connectionGeneration=" + this.b + ", pageGeneration=" + this.c + ", targetSessionId=" + this.d + ", deviceWidth=" + this.e + ", deviceHeight=" + this.f + ", offsetTop=" + this.g + ", pageScaleFactor=" + this.h + ", fromVideo=" + this.i + ')';
        }

        public b(String r2, int r3, int r4, String r5, float r6, float r7, float r8, float r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r5, "targetSessionId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class c {
        public final int a;
        public final String b;
        public final float c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "ExpectedScreencastGeometry(pageGeneration=" + this.a + ", targetSessionId=" + this.b + ", width=" + this.c + ", height=" + this.d + ')';
        }

        public c(int r2, String r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r3, "targetSessionId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface d {
        void OH(String r1);

        void R50(Bitmap r1, float r2, float r3, float r4);

        void iu(String r1);

        void ko(l r1);

        void m70(i r1);

        void pW(String r1, String r2);

        void v30(State r1);
    }

    public static final class e {
        public final long a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof e) == true) goto L8;
            return false;
        L8:
            e r9 = (e) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "count=" + this.a + " suppressed=" + this.b;
        }

        public e(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class f {
        public long a;
        public long b;
        public long c;

        public f() {
        }
    }

    public static final class g {
        public final Integer a;
        public final Integer b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "NavigationHistory(previousId=" + this.a + ", nextId=" + this.b + ", currentUrl=" + this.c + ')';
        }

        public g(Integer r1, Integer r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h {
        public final j a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "NavigationRequest(page=" + this.a + ", revision=" + this.b + ", action=" + this.c + ')';
        }

        public h(j r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "page");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class i {
        public final boolean a;
        public final boolean b;

        public i() {
            this(false, false);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "NavigationState(canGoBack=" + this.a + ", canGoForward=" + this.b + ')';
        }

        public i(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j {
        public final int a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof j) == true) goto L8;
            return false;
        L8:
            j r6 = (j) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PageToken(connectionGeneration=" + this.a + ", pageGeneration=" + this.b + ", targetSessionId=" + this.c + ')';
        }

        public j(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "targetSessionId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class k {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final Function1<JSONObject, Unit> e;
        public final Set<Integer> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c) * 31;
            if (this.d == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (((r4 + r5) * 31) + this.e.hashCode()) * 31;
            Set<Integer> r7 = this.f;
            if (r7 == null) goto L15;
            r2 = r7.hashCode();
        L15:
            return r6 + r2;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingCommand(method=" + this.a + ", targetSessionId=" + this.b + ", pageGeneration=" + this.c + ", allowStalePageGeneration=" + this.d + ", callback=" + this.e + ", retryIds=" + this.f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public k(String r2, String r3, int r4, boolean r5, Function1<? super JSONObject, Unit> r6, Set<Integer> r7) {
            Intrinsics.checkNotNullParameter(r2, "method");
            Intrinsics.checkNotNullParameter(r6, "callback");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class l {
        public final boolean a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final String e;
        public final String f;
        public final int g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof l) == true) goto L8;
            return false;
        L8:
            l r6 = (l) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.d == true) goto L15;
            r1 = 1237;
        L15:
            return ((((((r4 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g;
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemoteEditableFocus(editable=" + this.a + ", inputMode=" + this.b + ", isPassword=" + this.c + ", multiline=" + this.d + ", enterKeyHint=" + this.e + ", focusSerial=" + this.f + ", inspectionId=" + this.g + ')';
        }

        public l(boolean r2, String r3, boolean r4, boolean r5, String r6, String r7, int r8) {
            Intrinsics.checkNotNullParameter(r3, "inputMode");
            Intrinsics.checkNotNullParameter(r6, "enterKeyHint");
            Intrinsics.checkNotNullParameter(r7, "focusSerial");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public /* synthetic */ l(boolean r10, String r11, boolean r12, boolean r13, String r14, String r15, int r16, int r17) {
            if ((r17 & 2) == 0) goto L5;
            String r3 = ShareType.TEXT;
        L7:
            if ((r17 & 4) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r17 & 8) == 0) goto L13;
            boolean r5 = false;
        L15:
            if ((r17 & 16) == 0) goto L17;
            String r6 = "";
        L19:
            if ((r17 & 32) == 0) goto L21;
            String r7 = "";
        L23:
            if ((r17 & 64) == 0) goto L25;
            int r8 = 0;
        L26:
            this(r10, r3, r4, r5, r6, r7, r8);
            return;
        L25:
            r8 = r16;
            goto L26
        L21:
            r7 = r15;
            goto L23
        L17:
            r6 = r14;
            goto L19
        L13:
            r5 = r13;
            goto L15
        L9:
            r4 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }
    }

    public static final class m {
        public final j a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof m) == true) goto L8;
            return false;
        L8:
            m r6 = (m) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "RemoteInputToken(page=" + this.a + ", generation=" + this.b + ')';
        }

        public m(j r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "page");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        N = new Regex("[A-Za-z][A-Za-z0-9_]*\\.[A-Za-z][A-Za-z0-9_]*");
        O = SetsKt.setOf(new String[]{"Runtime.evaluate", "Input.insertText", "Input.dispatchKeyEvent", "Input.dispatchMouseEvent", "Page.screencastFrame", "Page.screencastFrameAck"});
        P = "(() => {\n  const fallback = {\n    editable: false,\n    inputMode: 'text',\n    password: false,\n    multiline: false,\n    enterKeyHint: ''\n  };\n  const lower = (value, limit) =>\n    typeof value === 'string' && value.length <= limit ? value.toLowerCase() : '';\n  try {\n    let element = document.activeElement;\n    let depth = 0;\n    while (element && depth++ < 32) {\n      if (element.shadowRoot && element.shadowRoot.activeElement) {\n        element = element.shadowRoot.activeElement;\n        continue;\n      }\n      const localName = lower(element.localName, 32);\n      if (localName === 'iframe' || localName === 'frame') {\n        let childDocument = null;\n        try {\n          childDocument = element.contentDocument;\n        } catch (_) {}\n        if (!childDocument || !childDocument.activeElement) return fallback;\n        element = childDocument.activeElement;\n        continue;\n      }\n      break;\n    }\n    if (!element) return fallback;\n\n    const tag = lower(element.localName, 32);\n    const type = lower(element.type, 32) || 'text';\n    const declaredInputMode = lower(element.inputMode, 16);\n    const enterKeyHint = lower(element.enterKeyHint, 16);\n    const textInputTypes = new Set([\n      'text', 'search', 'email', 'password', 'tel', 'url', 'number'\n    ]);\n    const contentEditable = element.isContentEditable ||\n      lower(element.ownerDocument && element.ownerDocument.designMode, 8) === 'on';\n    const editable = !element.disabled && !element.readOnly && (\n      (tag === 'input' && textInputTypes.has(type)) ||\n      tag === 'textarea' ||\n      contentEditable\n    );\n    if (!editable || declaredInputMode === 'none') return fallback;\n\n    let inputMode = declaredInputMode || type || 'text';\n    if ((tag === 'textarea' || contentEditable) && !declaredInputMode) inputMode = 'text';\n    if (type === 'number' && !declaredInputMode) inputMode = 'decimal';\n    let focusSerial = '';\n    try {\n      const stateKey = Symbol.for('larus.cloudBrowserFocusIdentity');\n      let focusState = window[stateKey];\n      if (!focusState || !focusState.ids || typeof focusState.nextId !== 'number' ||\n          typeof focusState.documentId !== 'string') {\n        const documentId = Array.from(crypto.getRandomValues(new Uint32Array(2)),\n          value => value.toString(16).padStart(8, '0')).join('');\n        focusState = { ids: new WeakMap(), nextId: 1, documentId };\n        Object.defineProperty(window, stateKey, {\n          value: focusState,\n          configurable: true\n        });\n      }\n      let focusId = focusState.ids.get(element);\n      if (!focusId) {\n        focusId = focusState.nextId++;\n        focusState.ids.set(element, focusId);\n      }\n      // A new document must not reuse the previous document's numeric focus id.\n      focusSerial = focusState.documentId + ':' + String(focusId);\n    } catch (_) {}\n    return {\n      editable: true,\n      inputMode,\n      password: type === 'password',\n      multiline: tag === 'textarea' || contentEditable,\n      enterKeyHint,\n      focusSerial\n    };\n  } catch (_) {\n    return fallback;\n  }\n})()";
        Q = "(expectedFocusSerial, visibleTop, visibleBottom) => {\n  try {\n    if (!Number.isFinite(visibleTop) || !Number.isFinite(visibleBottom) ||\n        visibleTop < 0 || visibleBottom > 32768 || visibleBottom - visibleTop < 24) return false;\n    const frames = [];\n    let element = document.activeElement;\n    for (let depth = 0; element && depth < 32; depth++) {\n      if (element.shadowRoot && element.shadowRoot.activeElement) {\n        element = element.shadowRoot.activeElement;\n      } else if (element.localName === 'iframe' || element.localName === 'frame') {\n        const child = element.contentDocument;\n        if (!child || !child.activeElement) return false;\n        frames.push(element);\n        element = child.activeElement;\n      } else {\n        break;\n      }\n    }\n    const state = window[Symbol.for('larus.cloudBrowserFocusIdentity')];\n    if (!element || !element.isConnected || !state || !state.ids ||\n        state.documentId + ':' + String(state.ids.get(element)) !== expectedFocusSerial ||\n        element.disabled || element.readOnly || element.inputMode === 'none') return null;\n\n    const contentEditable = element.isContentEditable ||\n      element.ownerDocument.designMode.toLowerCase() === 'on';\n    if (!contentEditable && element.localName !== 'textarea' &&\n        !(element.localName === 'input' &&\n          ['text', 'search', 'email', 'password', 'tel', 'url', 'number'].includes(element.type))) return false;\n    const parent = node => node.parentElement || (node.getRootNode && node.getRootNode().host);\n    const safeRect = rect => rect && Number.isFinite(rect.top) &&\n      Number.isFinite(rect.bottom) && rect.bottom > rect.top;\n\n    // Convert same-origin frame coordinates only when the path is unscaled.\n    // Unknown transforms/zoom fail closed instead of scrolling the wrong area.\n    for (const frame of frames) {\n      const rect = frame.getBoundingClientRect();\n      if (Math.abs(rect.width - frame.offsetWidth) > 1 ||\n          Math.abs(rect.height - frame.offsetHeight) > 1) return false;\n    }\n    const topOffset = doc => {\n      let offset = 0;\n      for (let i = frames.length - 1; doc !== document && i >= 0; i--) {\n        const frame = frames[i];\n        if (frame.contentDocument !== doc) continue;\n        offset += frame.getBoundingClientRect().top + frame.clientTop;\n        doc = frame.ownerDocument;\n      }\n      return doc === document ? offset : NaN;\n    };\n    const targetRect = () => {\n      let rect = element.getBoundingClientRect();\n      if (contentEditable) {\n        const selection = element.ownerDocument.defaultView.getSelection();\n        if (selection && selection.focusNode && element.contains(selection.focusNode)) {\n          const caret = element.ownerDocument.createRange();\n          caret.setStart(selection.focusNode, selection.focusOffset);\n          caret.collapse(true);\n          const caretRect = caret.getBoundingClientRect();\n          if (safeRect(caretRect)) rect = caretRect;\n        }\n      }\n      if (!safeRect(rect)) return null;\n      const offset = topOffset(element.ownerDocument);\n      return { top: rect.top + offset, bottom: rect.bottom + offset };\n    };\n    const delta = (rect, top, bottom) => {\n      if (!safeRect(rect) || !Number.isFinite(top) || !Number.isFinite(bottom) || bottom <= top) return 0;\n      if (rect.bottom - rect.top > bottom - top) {\n        // A tall textarea has no reliable DOM caret rect. Keep an already\n        // visible portion stable instead of alternately aligning its edges.\n        if (rect.bottom > top && rect.top < bottom) return 0;\n        return rect.top >= bottom ? rect.top - bottom + Math.min(24, bottom - top) :\n          rect.bottom - top - Math.min(24, bottom - top);\n      }\n      return rect.top < top ? rect.top - top : rect.bottom > bottom ? rect.bottom - bottom : 0;\n    };\n    const visibleBand = (top, bottom) => {\n      const clippedTop = Math.max(top, visibleTop);\n      const clippedBottom = Math.min(bottom, visibleBottom);\n      // An offscreen frame/container is first scrolled locally, then its\n      // ancestors reveal it. Do not manufacture an inverted visible band.\n      return clippedBottom > clippedTop ? [clippedTop, clippedBottom] : [top, bottom];\n    };\n\n    let node = element;\n    let budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      const view = doc.defaultView;\n      for (let ancestor = node; ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        const style = view.getComputedStyle(ancestor);\n        if (style.transform !== 'none' || (style.zoom && style.zoom !== '1' && style.zoom !== 'normal')) return false;\n      }\n      if (doc === document) break;\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    if (budget <= 0) return false;\n\n    node = element;\n    budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      const view = doc.defaultView;\n      let fixedInDocument = view.getComputedStyle(node).position === 'fixed';\n      for (let ancestor = parent(node); ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        const style = view.getComputedStyle(ancestor);\n        if (!fixedInDocument && ancestor !== doc.scrollingElement && ancestor.clientHeight > 0 &&\n            ancestor.scrollHeight > ancestor.clientHeight &&\n            ['auto', 'scroll', 'overlay'].includes(style.overflowY)) {\n          const top = ancestor.getBoundingClientRect().top + ancestor.clientTop + topOffset(doc);\n          const band = visibleBand(top, top + ancestor.clientHeight);\n          const amount = delta(targetRect(), band[0], band[1]);\n          if (Math.abs(amount) > 1 && Math.abs(amount) <= 32768) {\n            ancestor.scrollBy({ top: amount, behavior: 'instant' });\n          }\n        }\n        if (style.position === 'fixed') fixedInDocument = true;\n      }\n      const offset = topOffset(doc);\n      const band = doc === document ? [visibleTop, visibleBottom] :\n        visibleBand(offset, offset + view.innerHeight);\n      const amount = delta(targetRect(), band[0], band[1]);\n      if (!fixedInDocument && Math.abs(amount) > 1 && Math.abs(amount) <= 32768) {\n        view.scrollBy({ top: amount, behavior: 'instant' });\n      }\n      if (doc === document) break;\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    const finalRect = targetRect();\n    let clipTop = visibleTop;\n    let clipBottom = visibleBottom;\n    node = element;\n    budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      for (let ancestor = parent(node); ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        if (ancestor === doc.scrollingElement ||\n            !['auto', 'scroll', 'overlay', 'hidden', 'clip'].includes(\n              doc.defaultView.getComputedStyle(ancestor).overflowY)) continue;\n        const top = ancestor.getBoundingClientRect().top + ancestor.clientTop + topOffset(doc);\n        clipTop = Math.max(clipTop, top);\n        clipBottom = Math.min(clipBottom, top + ancestor.clientHeight);\n      }\n      if (doc === document) break;\n      const offset = topOffset(doc);\n      clipTop = Math.max(clipTop, offset);\n      clipBottom = Math.min(clipBottom, offset + doc.defaultView.innerHeight);\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    return budget > 0 && clipBottom > clipTop && safeRect(finalRect) &&\n      Math.abs(delta(finalRect, clipTop, clipBottom)) <= 1;\n  } catch (_) {\n    // Cross-origin/closed roots or disappearing DOM cannot safely be adjusted.\n    return false;\n  }\n}";
        R = SetsKt.setOf(new String[]{"Target.getTargets", "Target.attachToTarget", "Page.enable", "Page.startScreencast"});
    }

    public final void P() {
        final int r0 = this.k.incrementAndGet();
        K(new s0(r0, this));
    }

    public final void Q() {
        this.i.incrementAndGet();
        c(false, false);
        this.h.incrementAndGet();
        t();
        this.F = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.D = 1.0f;
        this.E = 1.0f;
        c0(false);
    }

    public final void W() {
        if (this.s == false) goto L5;
        return;
    L5:
        if (this.r.b() == 0) goto L14;
        this.s = true;
        long r0 = SystemClock.elapsedRealtime();
        long r2 = RangesKt.coerceAtLeast((this.t + 50) - r0, 0);
        if (r2 != 0) goto L10;
        this.d.post(this.u);
        return;
    L10:
        this.d.postDelayed(this.u, r2);
        return;
    }

    public final JSONObject X() {
        return new JSONObject().put("format", "jpeg").put("quality", this.c.c).put("maxWidth", this.c.a).put("maxHeight", this.c.b).put("everyNthFrame", 1);
    }

    public final j d() {
        String r0 = this.x;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.A == true) goto L9;
        return null;
    L9:
        return new j(this.g.get(), this.h.get(), r0);
    }

    public final void f() {
        Object r0 = this.q;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.C == true) goto L7;
    L18:
        monitor-exit(r0);
        return;
    L7:
        if (this.H == true) goto L18;
        b r1 = this.I;     // Catch: Throwable -> L20
        if (r1 != null) goto L14;
        monitor-exit(r0);
        return;
    L14:
        this.I = null;     // Catch: Throwable -> L20
        this.H = true;     // Catch: Throwable -> L20
        monitor-exit(r0);
        e(r1);
    }

    public final void g() {
        String r3 = this.x;
        if (this.v == false) goto L10;
        if (r3 == null) goto L10;
        if (n() == true) goto L8;
    L9:
        Y(this, "Page.stopScreencast", new JSONObject(), r3, false, null, 24);
        goto L10
    L8:
        if (this.B == true) goto L9;
    L10:
        this.g.incrementAndGet();
        this.v = false;
        this.l.clear();
        LinkedHashMap<Integer, String> r0 = this.n;
        monitor-enter(r0);
        this.n.clear();     // Catch: Throwable -> L24
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r0);
        Object r2 = this.q;
        monitor-enter(r2);
        this.I = null;     // Catch: Throwable -> L21
        monitor-exit(r2);
        Q();
        this.G = null;
        this.a.disconnect();
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        if (this.a.a() != BrowserTransport.FrameSource.RTP_CDP) goto L5;
        return true;
    L5:
        return false;
    }

    public final void t() {
        int r0 = this.j.incrementAndGet();
        l r10 = new l(false, null, false, false, null, null, r0, 62);
        this.d.post(new h0(r0, this, null, r10));
    }

    public final boolean y() {
        if (this.a.c() != BrowserTransport.EndpointMode.PAGE) goto L5;
        return true;
    L5:
        return false;
    }

    public static String S(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return "<unknown>";
    L11:
        if (r2.length() <= 128) goto L13;
    L15:
        return "<invalid>";
    L13:
        if (N.matches(r2) == false) goto L15;
        return r2;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static boolean z(JSONObject r4) {
        if (Intrinsics.areEqual(r4.optString("type"), "page") == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4.optString("subtype"), "prerender") == false) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default(r4.optString(ShareType.URL), "devtools://", false, 2, null) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void H(final String r4) {
        final int r0 = this.g.get();
        this.d.post(new t(this, r0, r4));
    }

    public final void J(final State r4) {
        final int r0 = this.g.get();
        this.d.post(new w(this, r0, r4));
    }

    public final void K(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.d.post(new iv8.k(r3));
    }

    public final void L(i r2) {
        if (this.w == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.J, r2) == true) goto L10;
        this.J = r2;
        this.b.m70(r2);
        return;
    }

    public final k N(int r5) {
        Object r0 = this.m;
        monitor-enter(r0);
        k r6 = this.l.remove(Integer.valueOf(r5));     // Catch: Throwable -> L16
        if (r6 == null) goto L13;
        Set<Integer> r1 = r6.f;     // Catch: Throwable -> L16
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L16
    L10:
        if (r2.hasNext() == false) goto L14;
        int r3 = ((Number) r2.next()).intValue();     // Catch: Throwable -> L16
        this.l.remove(Integer.valueOf(r3));     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return r6;
    L13:
        r6 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final void O(final h r4) {
        Z(r4, "Runtime.evaluate", new JSONObject().put("expression", "window.location.href").put("returnByValue", true).put("silent", true), new u0(this, r4));
    }

    public final e T(String r13) {
        HashMap<String, f> r0 = this.p;
        monitor-enter(r0);
        f r1 = this.p.get(r13);     // Catch: Throwable -> L22
        if (r1 == null) goto L7;
    L14:
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        long r4 = r1.a + 1;     // Catch: Throwable -> L22
        r1.a = r4;     // Catch: Throwable -> L22
        if (r4 > 1) goto L17;
    L19:
        e r14 = new e(r4, r1.b);     // Catch: Throwable -> L22
        r1.b = 0;     // Catch: Throwable -> L22
        r1.c = r2;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r0);
        return r14;
    L17:
        if ((r2 - r1.c) >= 5000) goto L19;
        r1.b++;     // Catch: Throwable -> L22
        r14 = null;
        goto L20
    L7:
        if (this.p.size() < 63) goto L10;
        r13 = "other";
    L10:
        HashMap<String, f> r3 = this.p;     // Catch: Throwable -> L22
        f r5 = r3.get(r13);     // Catch: Throwable -> L22
        if (r5 != null) goto L13;
        r5 = new f();     // Catch: Throwable -> L22
        r3.put(r13, r5);     // Catch: Throwable -> L22
    L13:
        r1 = r5;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void U(final boolean r3) {
        final j r0 = d();
        if (r0 != null) goto L5;
        return;
    L5:
        K(new a0(this, r0, r3));
    }

    public final void b0(RemoteInputCommand.Key r3) {
        if (this.A == true) goto L5;
        return;
    L5:
        a0(this, "Input.dispatchKeyEvent", A(r3, RemoteInputCommand.Phase.DOWN));
        a0(this, "Input.dispatchKeyEvent", A(r3, RemoteInputCommand.Phase.UP));
    }

    public final void c0(boolean r2) {
        this.A = r2;
        if (r2 == true) goto L13;
        P();
        this.B = false;
        this.C = false;
        Object r3 = this.q;
        monitor-enter(r3);
        this.I = null;     // Catch: Throwable -> L10
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r3);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(final b r6) {
        this.e.execute(new x0(r6, this));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e r0 = T("frame_decode_rejected:decoder_executor_rejected");
        if (r0 == null) goto L8;
        FLogger.a.i("BrowserCdpClient", "client=" + this.o + " generation=" + this.g.get() + " event=frame_decode_rejected reasons=decoder_executor_rejected frameConnectionGeneration=" + r6.b + " framePageGeneration=" + r6.c + ' ' + r0);
    L8:
        monitor-enter(this.q);
        this.I = null;     // Catch: Throwable -> L13
        this.H = false;     // Catch: Throwable -> L13
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void k(final int r8) {
        Y(this, "Target.getTargets", new JSONObject(), null, false, new u(r8, this), 12);
    }

    public final void p(JSONObject r3) {
        String r0 = null;
        if (r3 == null) goto L9;
        String r4 = r3.optString("targetId");
        if (r4 == null) goto L9;
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
        r0 = r4;
    L9:
        if (r0 != null) goto L11;
    L15:
        FLogger.a.e("BrowserCdpClient", "cloud browser target crashed");
        G("cdp", "target_crashed");
        Q();
        J(State.ERROR);
        return;
    L11:
        if (Intrinsics.areEqual(r0, this.y) == true) goto L15;
        if (Intrinsics.areEqual(r0, this.z) == true) goto L15;
    }

    public final boolean v(j r3) {
        if (r3.a == this.g.get()) goto L5;
    L11:
        return false;
    L5:
        if (r3.b != this.h.get()) goto L11;
        if (Intrinsics.areEqual(r3.c, this.x) == false) goto L11;
        if (this.A == false) goto L11;
        return true;
    }

    public final boolean x(h r3) {
        if (this.K == r3) goto L5;
    L9:
        return false;
    L5:
        if (r3.b != this.k.get()) goto L9;
        if (v(r3.a) == false) goto L9;
        return true;
    }

    public static JSONObject A(RemoteInputCommand.Key r2, RemoteInputCommand.Phase r3) {
        return new JSONObject().put("type", r3.getCdpType()).put("key", r2.getKey()).put("code", r2.getCode()).put("windowsVirtualKeyCode", r2.getVirtualKeyCode()).put("nativeVirtualKeyCode", r2.getVirtualKeyCode());
    }

    public static Integer F(JSONObject r9, String r10) {
        Object r11 = r9.opt(r10);
        if ((r11 instanceof Number) == false) goto L5;
        Number r12 = (Number) r11;
    L6:
        if (r12 == null) goto L30;
        Double r13 = Double.valueOf(r12.doubleValue());
        double r1 = r13.doubleValue();
        boolean r3 = false;
        if (Double.isInfinite(r1) == false) goto L10;
    L12:
        boolean r14 = false;
    L13:
        if (r14 == true) goto L15;
    L24:
        if (r3 == true) goto L27;
        r13 = null;
    L27:
        if (r13 != null) goto L29;
        return null;
    L29:
        return Integer.valueOf((int) r13.doubleValue());
    L15:
        if (r1 < 0.0d) goto L24;
        if (r1 > 2.147483647E9d) goto L24;
        if ((r1 % 1.0d) != 0.0d) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L24;
        r3 = true;
        goto L24
    L21:
        r15 = false;
        goto L22
    L10:
        if (Double.isNaN(r1) == true) goto L12;
        r14 = true;
        goto L13
    L30:
        return null;
    L5:
        r12 = null;
        goto L6
    }

    public static Double m(JSONObject r3, String r4) {
        Object r5 = r3.opt(r4);
        if ((r5 instanceof Number) == false) goto L5;
        Number r6 = (Number) r5;
    L6:
        if (r6 == null) goto L16;
        Double r7 = Double.valueOf(r6.doubleValue());
        double r1 = r7.doubleValue();
        if (Double.isInfinite(r1) == false) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L15;
        return null;
    L15:
        return r7;
    L10:
        if (Double.isNaN(r1) == true) goto L12;
        r8 = true;
        goto L13
    L16:
        return null;
    L5:
        r6 = null;
        goto L6
    }

    public final void D(String r5, String r6) {
        e r0 = T(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.d("BrowserCdpClient", "client=" + this.o + " generation=" + this.g.get() + " event=" + r5 + ' ' + r0 + " method=" + S(r6));
    }

    public final void G(final String r4, final String r5) {
        final int r0 = this.g.get();
        this.d.post(new iv8.d(this, r0, r4, r5));
    }

    public final void R(final Function0<Unit> r8, final Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        if (n() == true) goto L7;
        r9.invoke();
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        this.d.post(new iv8.b(this, r8, r9));
        return;
    L10:
        j r1 = d();
        if (r1 != null) goto L13;
        m r0 = null;
    L14:
        if (r0 != null) goto L16;
    L47:
        r9.invoke();
        return;
    L16:
        if (this.r.b() == 0) goto L47;
        com.larus.browsertakeover.cdp.b<m> r2 = this.r;
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r9, "action");     // Catch: Throwable -> L44
        if (r8 == null) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
    L27:
        if (r4 == true) goto L29;
    L33:
        r2.d.addLast(new com.larus.browsertakeover.cdp.b.AbstractC0066b.a(r0, r9, r8));     // Catch: Throwable -> L44
        r2.e++;     // Catch: Throwable -> L44
        r2.f++;     // Catch: Throwable -> L44
        if (r4 == false) goto L36;
        r2.g++;     // Catch: Throwable -> L44
    L36:
        b1 r10 = new b1(true, 1);     // Catch: Throwable -> L44
        monitor-exit(r2);
    L39:
        if (r10.a == true) goto L42;
        FLogger.a.i("BrowserCdpClient", "client=" + this.o + " generation=" + this.g.get() + " event=input_barrier_rejected pendingUnits=" + this.r.b());
        return;
    L42:
        W();
        return;
    L29:
        if (r2.g < 1) goto L33;
    L30:
        r10 = new b1(false, 0);     // Catch: Throwable -> L44
        monitor-exit(r2);
        goto L39
    L26:
        if ((r2.f - r2.g) >= r2.b) goto L30;
    L23:
        r4 = false;
    L44:
        th = move-exception;
        throw th;
    L13:
        r0 = new m(r1, this.i.get());
        goto L14
    }

    public final h b(j r4, boolean r5) {
        final h r0 = new h(r4, this.k.get(), r5);
        this.K = r0;
        L(new i(false, false));
        this.d.postDelayed(new o0(this, r0), 10000);
        return r0;
    }

    public final void c(boolean r7, boolean r8) {
        com.larus.browsertakeover.cdp.b<m> r0 = this.r;
        monitor-enter(r0);
        ArrayDeque<com.larus.browsertakeover.cdp.b.AbstractC0066b<m>> r1 = r0.d;     // Catch: Throwable -> L26
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<com.larus.browsertakeover.cdp.b.AbstractC0066b<m>> r3 = r1.iterator();     // Catch: Throwable -> L26
    L6:
        if (r3.hasNext() == false) goto L15;
        com.larus.browsertakeover.cdp.b.AbstractC0066b<m> r4 = r3.next();     // Catch: Throwable -> L26
        Function0<Unit> r5 = null;
        if ((r4 instanceof com.larus.browsertakeover.cdp.b.AbstractC0066b.a) == false) goto L10;
        com.larus.browsertakeover.cdp.b.AbstractC0066b.a r6 = (com.larus.browsertakeover.cdp.b.AbstractC0066b.a) r4;     // Catch: Throwable -> L26
    L11:
        if (r6 == null) goto L13;
        r5 = r6.c;     // Catch: Throwable -> L26
    L13:
        if (r5 == null) goto L6;
        r2.add(r5);     // Catch: Throwable -> L26
        goto L6
    L10:
        r6 = null;
        goto L11
    L15:
        r0.d.clear();     // Catch: Throwable -> L26
        r0.e = 0;     // Catch: Throwable -> L26
        r0.f = 0;     // Catch: Throwable -> L26
        r0.g = 0;     // Catch: Throwable -> L26
        monitor-exit(r0);
        this.d.removeCallbacks(this.u);
        this.s = false;
        if (r7 == false) goto L20;
        this.t = 0;
    L20:
        if (r8 == false) goto L25;
        Iterator r9 = r2.iterator();
    L23:
        if (r9.hasNext() == false) goto L37;
        ((Function0) r9.next()).invoke();
        goto L23
    L37:
        return;
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean e0(float r5, float r6) {
        if (this.A == true) goto L5;
        return false;
    L5:
        if (Float.isInfinite(r5) == false) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
        return false;
    L12:
        if (Float.isInfinite(r6) == false) goto L14;
    L16:
        boolean r1 = false;
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (r5 >= 0.0f) goto L21;
        return false;
    L21:
        if (r6 >= 0.0f) goto L23;
        return false;
    L23:
        if (r5 <= this.D) goto L25;
        return false;
    L25:
        if (r6 > this.E) goto L34;
        return true;
    L34:
        return false;
    L14:
        if (Float.isNaN(r6) == true) goto L16;
        r1 = true;
        goto L17
    L7:
        if (Float.isNaN(r5) == true) goto L9;
        r0 = true;
        goto L10
    }

    public final void h(final String r4, final Function1<? super m, b1> r5) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.d.post(new iv8.j(this, r4, r5));
        return;
    L6:
        j r1 = d();
        if (r1 != null) goto L9;
        m r0 = null;
    L10:
        if (r0 != null) goto L12;
        return;
    L12:
        b1 r6 = (b1) r5.invoke(r0);
        if (r6.a == true) goto L27;
        FLogger r7 = FLogger.a;
        StringBuilder r2 = new StringBuilder("client=");
        r2.append(this.o);
        r2.append(" generation=");
        r2.append(this.g.get());
        r2.append(" event=input_queue_rejected kind=");
        r2.append(r4);
        r2.append(" pendingUnits=");
        r2.append(this.r.b());
        r2.append(" barrierPending=");
        com.larus.browsertakeover.cdp.b<m> r8 = this.r;
        monitor-enter(r8);
        if (r8.f <= 0) goto L19;
        boolean r3 = true;
    L20:
        monitor-exit(r8);
        r2.append(r3);
        r7.i("BrowserCdpClient", r2.toString());
        return;
    L19:
        r3 = false;
    L23:
        th = move-exception;
        throw th;
    L27:
        if (r6.b <= 0) goto L32;
        W();
        return;
    L32:
        return;
    L9:
        r0 = new m(r1, this.i.get());
        goto L10
    }

    public final void j(String r5, String r6) {
        FLogger.a.e("BrowserCdpClient", "browser initialization failed, method=" + r5);
        if (Intrinsics.areEqual(r5, "Page.screencastFrame") == false) goto L5;
    L8:
        G("first_frame", "first_frame_timeout");
    L10:
        if (this.B == false) goto L12;
        a0(this, "Page.stopScreencast", new JSONObject());
    L12:
        this.l.clear();
        LinkedHashMap<Integer, String> r7 = this.n;
        monitor-enter(r7);
        this.n.clear();     // Catch: Throwable -> L18
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r7);
        Q();
        J(State.ERROR);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r5, "RTP.firstFrame") == true) goto L8;
        G("cdp", r6);
        goto L10
    }

    public final void l(h r1, boolean r2) {
        if (x(r1) == true) goto L5;
        return;
    L5:
        this.K = null;
        if (r2 == false) goto L8;
    L9:
        this.M = false;
        U(false);
        return;
    L8:
        if (this.M == true) goto L9;
    }

    public final void q(JSONObject r3, int r4) {
        if (r3 == null) goto L22;
        JSONObject r5 = r3.optJSONObject("targetInfo");
        if (r5 != null) goto L7;
        return;
    L7:
        if (this.A == true) goto L9;
        return;
    L9:
        if (z(r5) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r5.optString("openerId"), this.y) == true) goto L14;
        return;
    L14:
        String r0 = r5.optString("targetId");
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L20;
        return;
    L20:
        a(r0, r4, r5.optString(ShareType.URL));
        return;
    }

    public final void r(final String r11, final int r12) {
        FLogger.a.i("BrowserCdpClient", "CDP page initialization started, endpointMode=" + this.a.c());
        Y(this, "Page.enable", new JSONObject(), r11, false, new v(this, r11, r12), 8);
    }

    public final void u(int r2, j r3) {
        if (r2 == this.j.get()) goto L5;
        return;
    L5:
        if (v(r3) == false) goto L9;
        t();
        return;
    }

    public final boolean w(String r2, int r3) {
        if (this.w == false) goto L5;
    L11:
        return false;
    L5:
        if (this.v == false) goto L11;
        if (r3 != this.g.get()) goto L11;
        if (Intrinsics.areEqual(r2, this.x) == false) goto L11;
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [iv8.f] */
    public BrowserCdpClient(BrowserTransport r2, BrowserTakeoverSession.d r3, jv8.a r4) {
        Intrinsics.checkNotNullParameter(r2, "transport");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r4, "captureParameters");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Handler(Looper.getMainLooper());
        this.e = PThreadExecutorsUtils.newSingleThreadExecutor(new iv8.e());
        this.f = new AtomicInteger(1);
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.k = new AtomicInteger(0);
        this.l = new ConcurrentHashMap();
        this.m = new Object();
        this.n = new LinkedHashMap();
        this.o = Integer.toString(System.identityHashCode(this), CharsKt.checkRadix(16));
        this.p = new HashMap();
        this.q = new Object();
        this.r = new com.larus.browsertakeover.cdp.b();
        this.u = new iv8.f(this);
        this.D = 1.0f;
        this.E = 1.0f;
        this.J = new i(false, false);
    }

    public static JSONObject E(String r3, float r4, float r5) {
        return new JSONObject().put("type", r3).put("x", r4).put("y", r5);
    }

    public static void a0(BrowserCdpClient r7, String r8, JSONObject r9) {
        String r3 = r7.x;
        if (r3 == null) goto L7;
        Y(r7, r8, r9, r3, false, null, 8);
        return;
    }

    public final void a(final String r11, final int r12, final String r13) {
        if (Intrinsics.areEqual(r11, this.y) == true) goto L5;
    L7:
        this.z = r11;
        J(State.ATTACHING);
        String r7 = this.x;
        this.h.incrementAndGet();
        this.F = null;
        this.x = null;
        this.y = null;
        c0(false);
        if (r7 == null) goto L10;
        Y(this, "Page.stopScreencast", new JSONObject(), r7, false, null, 24);
        Y(this, "Target.detachFromTarget", new JSONObject().put("sessionId", r7), null, false, null, 28);
    L10:
        Y(this, "Target.attachToTarget", new JSONObject().put("targetId", r11).put("flatten", true), null, true, new f0(r12, this, r11, r13), 4);
        return;
    L5:
        if (this.x == null) goto L7;
    }

    public static void V(final BrowserCdpClient r3, final j r4, Integer r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        final boolean r0 = true;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r4 = null;
    L10:
        if ((r6 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if (r4 != null) goto L16;
        r4 = r3.d();
        if (r4 != null) goto L16;
        return;
    L16:
        if (r5 == null) goto L18;
        final int r7 = r5.intValue();
    L19:
        r3.d.postDelayed(new iv8.c(r3, r7, r4, r0), 140);
        return;
    L18:
        r7 = r3.j.incrementAndGet();
        goto L19
    L5:
        r0 = false;
        goto L7
    }

    public final void I(String r10, final int r11, final String r12, final Integer r13) {
        Object r0 = "";
        final int r6 = this.h.get();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        URI r2 = new URI(r10);     // Catch: Throwable -> L24
        Set r14 = SetsKt.setOf(new String[]{"https", "http"});     // Catch: Throwable -> L24
        String r3 = r2.getScheme();     // Catch: Throwable -> L24
        String r4 = null;
        if (r3 == null) goto L6;
        String r5 = r3.toLowerCase(Locale.US);     // Catch: Throwable -> L24
    L8:
        if (CollectionsKt.contains(r14, r5) == true) goto L10;
    L9:
        r4 = "";
    L22:
        Object r15 = Result.constructor-impl(r4);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r15) == true) goto L30;
        r0 = r15;
    L30:
        final String r8 = (String) r0;
        this.d.post(new e0(this, r11, r12, r6, r13, r8));
        return;
    L10:
        String r16 = r2.getHost();     // Catch: Throwable -> L24
        if (r16 == null) goto L20;
        String r17 = r16.toLowerCase(Locale.US);     // Catch: Throwable -> L24
        if (r17 == null) goto L20;
        if (r17.length() > 253) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        r4 = r17;
        goto L20
    L17:
        r7 = false;
    L20:
        if (r4 != null) goto L22;
    L6:
        r5 = null;
    L24:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public final void M(float r11, float r12, final j r13, final int r14) {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        if (Y(this, "Input.dispatchMouseEvent", E("mouseReleased", r11, r12).put("button", "left").put("buttons", 0).put("clickCount", 1), r13.c, false, new y0(r0, this, r13, r14), 8) == false) goto L5;
    L8:
        this.d.postDelayed(new z0(r0, this, r14, r13), 2000);
        return;
    L5:
        if (r0.compareAndSet(false, true) == false) goto L8;
        u(r14, r13);
    }

    public final void Z(final h r11, String r12, JSONObject r13, final Function1<? super JSONObject, Unit> r14) {
        if (x(r11) == true) goto L6;
        return;
    L6:
        if (this.l.size() < 64) goto L10;
        l(r11, false);
        return;
    L10:
        if (Y(this, r12, r13, r11.a.c, false, new r0(this, r11, r14), 8) == true) goto L13;
        l(r11, false);
        return;
    }

    public final boolean d0(int r10, String r11, JSONObject r12, k r13) {
        if (r13 != null) goto L5;
    L7:
        LinkedHashMap<Integer, String> r1 = this.n;
        monitor-enter(r1);
        Integer r2 = Integer.valueOf(r10);     // Catch: Throwable -> L31
        this.n.put(r2, r11);     // Catch: Throwable -> L31
        if (this.n.size() <= 256) goto L12;
        Iterator<Integer> r3 = this.n.keySet().iterator();     // Catch: Throwable -> L31
        r3.next();     // Catch: Throwable -> L31
        r3.remove();     // Catch: Throwable -> L31
    L12:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r1);
        C(this, "cdp_send", "command", r11, Integer.valueOf(r10), 16);
        if (this.a.send(r12.toString()) == true) goto L29;
        k r14 = N(r10);
        LinkedHashMap<Integer, String> r5 = this.n;
        monitor-enter(r5);
        String r6 = this.n.remove(Integer.valueOf(r10));     // Catch: Throwable -> L26
        monitor-exit(r5);
        B("cdp_send_failed", "command", r11, Integer.valueOf(r10), true);
        if (R.contains(r11) == false) goto L25;
        if (r13 == null) goto L24;
        if (r14 != r13) goto L25;
    L24:
        j(r11, "send_failed");
    L25:
        return false;
    L26:
        th = move-exception;
        throw th;
    L29:
        return true;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.l.get(Integer.valueOf(r10)) == r13) goto L7;
        return false;
    }

    public final void o(JSONObject r12, String r13, int r14, boolean r15) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (this.B == false) goto L77;
        int r0 = r12.optInt("sessionId", -1);
        if (r0 >= 0) goto L9;
        return;
    L9:
        if (r15 == true) goto L11;
        Y(this, "Page.screencastFrameAck", new JSONObject().put("sessionId", r0), r13, false, null, 24);
    L11:
        String r2 = r12.optString("data");
        Intrinsics.checkNotNull(r2);
        boolean r1 = false;
        if (r2.length() != 0) goto L14;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L62;
        if (r2.length() > 6291456) goto L62;
        JSONObject r16 = r12.optJSONObject("metadata");
        if (r16 != null) goto L23;
        return;
    L23:
        Double r4 = m(r16, "deviceWidth");
        if (r4 == null) goto L60;
        float r6 = (float) r4.doubleValue();
        Double r5 = m(r16, "deviceHeight");
        if (r5 == null) goto L67;
        float r7 = (float) r5.doubleValue();
        Double r8 = m(r16, "offsetTop");
        if (r8 == null) goto L68;
        float r9 = (float) r8.doubleValue();
        Double r17 = m(r16, "pageScaleFactor");
        if (r17 == null) goto L69;
        float r10 = (float) r17.doubleValue();
        if (1.0f <= r6) goto L34;
    L36:
        boolean r11 = false;
    L37:
        if (r11 == true) goto L39;
        return;
    L39:
        if (1.0f <= r7) goto L41;
    L43:
        if (r1 == true) goto L45;
        return;
    L45:
        if (r9 >= 0.0f) goto L47;
        return;
    L47:
        if (r9 < r7) goto L49;
        return;
    L49:
        if (Math.abs(r10 - 1.0f) > 0.01f) goto L74;
        this.F = new c(this.h.get(), r13, r6, r7);
        b r18 = new b(r2, r14, this.h.get(), r13, r6, r7, r9, r10, r15);
        Object r19 = this.q;
        monitor-enter(r19);
        this.I = r18;     // Catch: Throwable -> L57
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L57
        monitor-exit(r19);
        f();
        return;
    L57:
        th = move-exception;
        throw th;
    L74:
        return;
    L41:
        if (r7 > 32768.0f) goto L43;
        r1 = true;
        goto L43
    L34:
        if (r6 > 32768.0f) goto L36;
        r11 = true;
        goto L37
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L60:
        return;
    L62:
        if (r2.length() <= 6291456) goto L76;
        FLogger.a.e("BrowserCdpClient", "dropped oversized frame");
        return;
    L76:
        return;
    L14:
        r3 = false;
        goto L16
    }

    public final void s(final int r17, final j r18, final boolean r19, final boolean r20) {
        if (r17 == this.j.get()) goto L5;
        return;
    L5:
        if (v(r18) == true) goto L7;
        return;
    L7:
        if (this.A == false) goto L13;
        final AtomicBoolean r10 = new AtomicBoolean(false);
        Y(this, "Runtime.evaluate", new JSONObject().put("expression", P).put("returnByValue", true).put("awaitPromise", false).put("userGesture", false).put("silent", true), r18.c, false, new iv8.h(r17, this, r18, r10, r19), 8);
        this.d.postDelayed(new iv8.i(r10, r17, this, r18, r20), 1500);
        return;
    }

    public final void B(String r5, String r6, String r7, Integer r8, boolean r9) {
        String r10 = S(r7);
        e r1 = null;
        if (O.contains(r10) == false) goto L6;
        String r0 = r10;
    L9:
        if (r0 == null) goto L13;
        r1 = T(r5 + ':' + r6 + ':' + r0);
        if (r1 != null) goto L13;
        return;
    L13:
        StringBuilder r2 = new StringBuilder("client=");
        r2.append(this.o);
        r2.append(" generation=");
        r2.append(this.g.get());
        r2.append(" event=");
        r2.append(r5);
        r2.append(" kind=");
        r2.append(r6);
        r2.append(" id=");
        Object r11 = r8;
        if (r8 != null) goto L16;
        r11 = "-";
    L16:
        r2.append(r11);
        r2.append(" method=");
        r2.append(r10);
        if (r1 == null) goto L19;
        String r12 = " " + r1;
    L20:
        r2.append(r12);
        String r13 = r2.toString();
        if (r9 == false) goto L23;
        FLogger.a.e("BrowserCdpClient", r13);
        return;
    L23:
        if (r1 == null) goto L25;
        FLogger.a.d("BrowserCdpClient", r13);
        return;
    L25:
        FLogger.a.i("BrowserCdpClient", r13);
        return;
    L19:
        r12 = "";
        goto L20
    L6:
        if (StringsKt.startsWith$default(r10, "Input.", false, 2, null) == false) goto L8;
        r0 = "Input.other";
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public static /* synthetic */ void C(BrowserCdpClient r6, String r7, String r8, String r9, Integer r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r6.B(r7, r8, r9, r10, false);
    }

    public static final void i(AtomicBoolean r7, final BrowserCdpClient r8, final j r9, final int r10, final Function1<? super Boolean, Unit> r11, final boolean r12) {
        if (r7.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        r8.d.post(new d0(r8, r9, r10, r11, r12));
    }

    public static boolean Y(final BrowserCdpClient r16, String r17, JSONObject r18, String r19, boolean r20, Function1 r21, int r22) {
        if ((r22 & 4) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r22 & 8) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r22 & 16) == 0) goto L13;
        Function1 r5 = null;
    L15:
        if (r16.v == true) goto L17;
        return false;
    L17:
        if (r16.w == true) goto L42;
        if (r5 != null) goto L21;
    L23:
        final int r11 = r16.f.getAndIncrement();
        JSONObject r12 = new JSONObject().put("id", r11).put("method", r17).put("params", r18);
        if (r2 != null) goto L26;
    L28:
        if (r5 == null) goto L38;
        int r3 = r16.h.get();
        if (r16.y() == true) goto L32;
    L34:
        Set r6 = null;
    L35:
        k r7 = new k(r17, r2, r3, r4, r5, r6);
        r16.l.put(Integer.valueOf(r11), r7);
        long r13 = SystemClock.elapsedRealtime() + 10000;
        r16.d.postDelayed(new iv8.a(r16, r11), 10000);
        if (r7.f == null) goto L38;
        r16.d.postDelayed(new s(r16, r16.g.get(), r11, 1, r7, r13), 1000);
        goto L38
    L32:
        if (Intrinsics.areEqual(r17, "Page.enable") == false) goto L34;
        r6 = SetsKt.mutableSetOf(new Integer[]{Integer.valueOf(r11)});
    L38:
        Intrinsics.checkNotNull(r12);
        return r16.d0(r11, r17, r12, null);
    L26:
        if (r16.y() == true) goto L28;
        r12.put("sessionId", r2);
        goto L28
    L21:
        if (r16.l.size() < 64) goto L23;
        FLogger.a.e("BrowserCdpClient", "too many pending CDP commands");
        r16.G("cdp", "pending_command_limit");
        r16.J(State.ERROR);
        return false;
    L42:
        return false;
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
