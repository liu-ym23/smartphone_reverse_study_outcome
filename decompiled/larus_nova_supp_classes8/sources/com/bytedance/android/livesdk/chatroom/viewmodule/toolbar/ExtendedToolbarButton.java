package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class ExtendedToolbarButton implements a2 {
    public static final Map<ToolbarButton, WeakReference<b>> g = null;
    public static final a h = null;
    public long a;
    public int b;
    public RedDotDelegate c;
    public int d;
    public final boolean e;
    public HighLightMode f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ExtendedToolbarButton$HighLightMode;", "", "DISABLE", "TRUE", "FALSE", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HighLightMode extends Enum<HighLightMode> {
        public static final HighLightMode DISABLE = null;
        public static final HighLightMode FALSE = null;
        public static final HighLightMode TRUE = null;
        public static final /* synthetic */ HighLightMode[] a = null;

        static {
            HighLightMode r1 = new HighLightMode("DISABLE", 0);
            DISABLE = r1;
            HighLightMode r2 = new HighLightMode("TRUE", 1);
            TRUE = r2;
            HighLightMode r3 = new HighLightMode("FALSE", 2);
            FALSE = r3;
            a = new HighLightMode[]{r1, r2, r3};
        }

        public static HighLightMode valueOf(String r1) {
            return (HighLightMode) r27.a.a(HighLightMode.class, r1);
        }

        public static HighLightMode[] values() {
            return (HighLightMode[]) a.clone();
        }

        public HighLightMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static b a(ToolbarButton r3) {
            Intrinsics.checkNotNullParameter(r3, "button");
            Map<ToolbarButton, WeakReference<b>> r0 = ExtendedToolbarButton.g;
            WeakReference r1 = (WeakReference) ((LinkedHashMap) r0).get(r3);
            if (r1 == null) goto L8;
            b r2 = (b) r1.get();
            if (r2 == null) goto L8;
            return r2;
        L8:
            b r4 = new b(r3);
            r0.put(r3, new WeakReference(r4));
            return r4;
        }
    }

    public static final class b extends ExtendedToolbarButton {
        public final ToolbarButton i;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.i, ((b) r2).i) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ToolbarButton r0 = this.i;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "LocalIcon(icon=" + this.i + ")";
        }

        public b(ToolbarButton r2) {
            Intrinsics.checkNotNullParameter(r2, "icon");
            super(true);
            this.i = r2;
        }
    }

    public static class c extends ExtendedToolbarButton {
        public int i;
        public long j;
        public int k;
        public String l;
        public long m;
        public long n;
        public String o;
        public List<String> p;
        public String q;
        public boolean r;
        public final String s;

        public c(List<String> r2, String r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_TITLE);
            Intrinsics.checkNotNullParameter(r5, "id");
            super(false);
            this.p = r2;
            this.q = r3;
            this.r = r4;
            this.s = r5;
            this.l = "";
        }
    }

    public static final class d extends c {
        public final boolean t;
        public final List<String> u;
        public final String v;
        public final boolean w;
        public final String x;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L16;
            d r4 = (d) r3;
            if (this.t == r4.t) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.u, r4.u) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.v, r4.v) == true) goto L12;
            return false;
        L12:
            if (this.w == r4.w) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.x, r4.x) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            boolean r0 = this.t;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            List<String> r4 = this.u;
            int r5 = 0;
            if (r4 == null) goto L8;
            int r6 = r4.hashCode();
        L9:
            int r7 = (r3 + r6) * 31;
            String r8 = this.v;
            if (r8 == null) goto L12;
            int r9 = r8.hashCode();
        L13:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.w;
            if (r11 == true) goto L17;
            r1 = r11;
        L17:
            int r12 = (r10 + r1) * 31;
            String r13 = this.x;
            if (r13 == null) goto L21;
            r5 = r13.hashCode();
        L21:
            return r12 + r5;
        L12:
            r9 = 0;
            goto L13
        L8:
            r6 = 0;
            goto L9
        }

        public final String toString() {
            return "NetworkIconWithSwitch(isOn=" + this.t + ", switchUrl=" + this.u + ", switchTitle=" + this.v + ", switchIsNew=" + this.w + ", switchId=" + this.x + ")";
        }

        public d(boolean r2, List r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "switchUrl");
            Intrinsics.checkNotNullParameter(r4, "switchTitle");
            Intrinsics.checkNotNullParameter(r5, "switchId");
            super(r3, r4, false, r5);
            this.t = r2;
            this.u = r3;
            this.v = r4;
            this.w = false;
            this.x = r5;
        }
    }

    @JvmStatic
    public static final b e(ToolbarButton r1) {
        h.getClass();
        return a.a(r1);
    }

    static {
        h = new a();
        g = new LinkedHashMap();
    }

    public final String f() {
        if ((this instanceof b) == false) goto L6;
        return ((b) this).i.name();
    L6:
        if ((this instanceof c) == false) goto L10;
        return ((c) this).q;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final String g() {
        if ((this instanceof b) == false) goto L24;
        b r0 = (b) this;
        if (r0.i.getTitleId() != 0) goto L7;
        String r1 = "";
    L12:
        String r2 = r0.i.getTitleStr();
        if (r2 != null) goto L15;
        return r1;
    L15:
        if (r2.length() <= 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 != true) goto L30;
        String r4 = r0.i.getTitleStr();
        if (r4 != null) goto L31;
        return r1;
    L31:
        return r4;
    L30:
        return r1;
    L17:
        r3 = false;
        goto L18
    L7:
        IMiddlewareHostApp r5 = jc1.k.f(IMiddlewareHostApp.class);
        if (r5 == null) goto L11;
        r1 = r5.replaceBrand(r0.i.getTitleId());
        if (r1 != null) goto L12;
    L11:
        r1 = com.bytedance.android.live.core.utils.s1.B(r0.i.getTitleId());
        goto L12
    L24:
        if ((this instanceof c) == false) goto L28;
        return ((c) this).q;
    L28:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return f();
    }

    public ExtendedToolbarButton(boolean r2) {
        HighLightMode r0 = HighLightMode.DISABLE;
        this.e = r2;
        this.f = r0;
        this.d = -1;
    }
}
