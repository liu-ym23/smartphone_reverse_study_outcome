package com.larus.reach.runtime;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachBannerHost;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachClickTarget;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachCustomClickResult;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.ui.ReachSwipeDismissLayout;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ReachBannerRuntime {
    public static final /* synthetic */ int j = 0;
    public final Handler a;
    public final os9.g b;
    public final com.larus.reach.impl.a c;
    public final com.larus.reach.impl.n d;
    public final AtomicLong e;
    public final AtomicLong f;
    public final LinkedHashMap<String, c> g;
    public boolean h;
    public boolean i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/larus/reach/runtime/ReachBannerRuntime$EntryState;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "WAITING_HOST", "WAITING_POSITION", "CHECKING", "ALLOWED", "FOREGROUND", "BACKGROUND", "DISMISSING", "isPresented", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum EntryState extends Enum<EntryState> {
        public static final EntryState ALLOWED = null;
        public static final EntryState BACKGROUND = null;
        public static final EntryState CHECKING = null;
        public static final EntryState DISMISSING = null;
        public static final EntryState FOREGROUND = null;
        public static final EntryState PENDING = null;
        public static final EntryState WAITING_HOST = null;
        public static final EntryState WAITING_POSITION = null;
        public static final /* synthetic */ EntryState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EntryState> getEntries() {
            return b;
        }

        static {
            EntryState r0 = new EntryState("PENDING", 0);
            PENDING = r0;
            EntryState r1 = new EntryState("WAITING_HOST", 1);
            WAITING_HOST = r1;
            EntryState r3 = new EntryState("WAITING_POSITION", 2);
            WAITING_POSITION = r3;
            EntryState r5 = new EntryState("CHECKING", 3);
            CHECKING = r5;
            EntryState r7 = new EntryState("ALLOWED", 4);
            ALLOWED = r7;
            EntryState r9 = new EntryState("FOREGROUND", 5);
            FOREGROUND = r9;
            EntryState r11 = new EntryState("BACKGROUND", 6);
            BACKGROUND = r11;
            EntryState r13 = new EntryState("DISMISSING", 7);
            DISMISSING = r13;
            EntryState[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
        }

        public static EntryState[] values() {
            return (EntryState[]) a.clone();
        }

        public final boolean isPresented() {
            if (this != ALLOWED) goto L5;
        L12:
            return true;
        L5:
            if (this == FOREGROUND) goto L12;
            if (this == BACKGROUND) goto L12;
            if (this == DISMISSING) goto L12;
            return false;
        }

        public static EntryState valueOf(String r1) {
            return (EntryState) r27.a.a(EntryState.class, r1);
        }

        public EntryState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/runtime/ReachBannerRuntime$ReachGatePhase;", "", "<init>", "(Ljava/lang/String;I)V", "SUBMIT", "BEFORE_PRESENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum ReachGatePhase extends Enum<ReachGatePhase> {
        public static final ReachGatePhase BEFORE_PRESENT = null;
        public static final ReachGatePhase SUBMIT = null;
        public static final /* synthetic */ ReachGatePhase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ReachGatePhase> getEntries() {
            return b;
        }

        static {
            ReachGatePhase r0 = new ReachGatePhase("SUBMIT", 0);
            SUBMIT = r0;
            ReachGatePhase r1 = new ReachGatePhase("BEFORE_PRESENT", 1);
            BEFORE_PRESENT = r1;
            ReachGatePhase[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ReachGatePhase[] values() {
            return (ReachGatePhase[]) a.clone();
        }

        public static ReachGatePhase valueOf(String r1) {
            return (ReachGatePhase) r27.a.a(ReachGatePhase.class, r1);
        }

        public ReachGatePhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.reach.runtime.ReachBannerRuntime$a$a, reason: collision with other inner class name */
        public static final class C0018a extends a {
            public final c a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0018a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0018a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Check(entry=" + this.a + ')';
            }

            public C0018a(c r2) {
                Intrinsics.checkNotNullParameter(r2, "entry");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public final c a;
            public final ReachCloseReason b;

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
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Dismiss(entry=" + this.a + ", reason=" + this.b + ')';
            }

            public b(c r2, ReachCloseReason r3) {
                Intrinsics.checkNotNullParameter(r2, "entry");
                Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends a {
            public final c a;
            public final ReachRejectReason b;

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
                return "Reject(entry=" + this.a + ", reason=" + this.b + ')';
            }

            public c(c r2, ReachRejectReason r3) {
                Intrinsics.checkNotNullParameter(r2, "entry");
                Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
                this.a = r2;
                this.b = r3;
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c {
        public final ns9.t a;
        public final Function0<Unit> b;
        public final long c;
        public final long d;
        public final boolean e;
        public EntryState f;
        public ReachBannerHost g;
        public long h;
        public long i;
        public long j;
        public boolean k;
        public boolean l;
        public long m;
        public ns9.c n;
        public boolean o;

        public c() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L36;
            return false;
        L36:
            if (this.j == r9.j) goto L39;
            return false;
        L39:
            if (this.k == r9.k) goto L42;
            return false;
        L42:
            if (this.l == r9.l) goto L45;
            return false;
        L45:
            if (this.m == r9.m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r9.o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Function0<Unit> r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            long r4 = this.c;
            int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.d;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            int r8 = 1231;
            if (this.e == false) goto L9;
            int r9 = 1231;
        L10:
            int r10 = (((r7 + r9) * 31) + this.f.hashCode()) * 31;
            ReachBannerHost r11 = this.g;
            if (r11 != null) goto L13;
            int r12 = 0;
        L14:
            long r13 = this.h;
            int r14 = (((r10 + r12) * 31) + ((int) (r13 ^ (r13 >>> 32)))) * 31;
            long r15 = this.i;
            int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
            long r17 = this.j;
            int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
            if (this.k == false) goto L17;
            int r19 = 1231;
        L18:
            int r20 = (r18 + r19) * 31;
            if (this.l == false) goto L21;
            int r21 = 1231;
        L22:
            long r22 = this.m;
            int r23 = (((r20 + r21) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31;
            ns9.c r24 = this.n;
            if (r24 == null) goto L26;
            r2 = r24.hashCode();
        L26:
            int r25 = (r23 + r2) * 31;
            if (this.o == true) goto L31;
            r8 = 1237;
        L31:
            return r25 + r8;
        L21:
            r21 = 1237;
            goto L22
        L17:
            r19 = 1237;
            goto L18
        L13:
            r12 = r11.hashCode();
            goto L14
        L9:
            r9 = 1237;
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(request=" + this.a + ", localClickAction=" + this.b + ", arrivalOrder=" + this.c + ", entryToken=" + this.d + ", isP0=" + this.e + ", state=" + this.f + ", host=" + this.g + ", firstShownAtUptimeMs=" + this.h + ", foregroundStartedAtMs=" + this.i + ", remainingAutoDismissMs=" + this.j + ", autoDismissEnabled=" + this.k + ", hasAutoDismissTimeout=" + this.l + ", autoDismissGeneration=" + this.m + ", content=" + this.n + ", localClickActionConsumed=" + this.o + ')';
        }

        public final void a(EntryState r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.f = r2;
        }

        public c(ns9.t r3, Function0 r4, long r5, long r7, boolean r9) {
            EntryState r0 = EntryState.PENDING;
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r0, "state");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r9;
            this.f = r0;
            this.g = null;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = true;
            this.l = false;
            this.m = 0;
            this.n = null;
            this.o = false;
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public final ReachBannerHost a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Ready(host=" + this.a + ')';
            }

            public a(ReachBannerHost r2) {
                Intrinsics.checkNotNullParameter(r2, "host");
                this.a = r2;
            }
        }

        public static final class b extends d {
            public final ReachRejectReason a;
            public final ReachBannerHost b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                ReachBannerHost r1 = this.b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Reject(reason=" + this.a + ", host=" + this.b + ')';
            }

            public b(ReachRejectReason r2, ReachBannerHost r3) {
                Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends d {
            public final ReachBannerHost a;
            public final long b;
            public final String c;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof c) == true) goto L8;
                return false;
            L8:
                c r9 = (c) r8;
                if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r9.b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                long r1 = this.b;
                int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
                String r3 = this.c;
                if (r3 != null) goto L5;
                int r4 = 0;
            L7:
                return r2 + r4;
            L5:
                r4 = r3.hashCode();
                goto L7
            }

            public final String toString() {
                return "Wait(host=" + this.a + ", environmentGeneration=" + this.b + ", reason=" + this.c + ')';
            }

            public c(ReachBannerHost r2, long r3, String r5) {
                Intrinsics.checkNotNullParameter(r2, "host");
                this.a = r2;
                this.b = r3;
                this.c = r5;
            }
        }

        public d() {
        }
    }

    public static abstract class e {

        public static final class a extends e {
            public final ReachBannerHost a;
            public final ns9.g b;
            public final ns9.c c;
            public final c d;
            public final ReachCloseReason e;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (this.e == r6.e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
            }

            public final String toString() {
                return "Replace(host=" + this.a + ", session=" + this.b + ", content=" + this.c + ", replacedEntry=" + this.d + ", reason=" + this.e + ')';
            }

            public a(ReachBannerHost r2, f r3, ns9.c r4, c r5, ReachCloseReason r6) {
                Intrinsics.checkNotNullParameter(r2, "host");
                Intrinsics.checkNotNullParameter(r3, "session");
                Intrinsics.checkNotNullParameter(r4, "content");
                Intrinsics.checkNotNullParameter(r5, "replacedEntry");
                Intrinsics.checkNotNullParameter(r6, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }
        }

        public static final class b extends e {
            public final ReachBannerHost a;
            public final ns9.g b;
            public final ns9.c c;

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
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "Show(host=" + this.a + ", session=" + this.b + ", content=" + this.c + ')';
            }

            public b(ReachBannerHost r2, f r3, ns9.c r4) {
                Intrinsics.checkNotNullParameter(r2, "host");
                Intrinsics.checkNotNullParameter(r3, "session");
                Intrinsics.checkNotNullParameter(r4, "content");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class c extends e {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends e {
            public final Long a;

            public d() {
                this(null);
            }

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                Long r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Wait(retryDelayMs=" + this.a + ')';
            }

            public d(Long r1) {
                this.a = r1;
            }
        }

        public e() {
        }
    }

    public static final class f implements ns9.g {
        public final ns9.t a;
        public final long b;
        public final ReachBannerRuntime c;

        @Override // ns9.g
        public final void a() {
            ReachBannerRuntime r0 = this.c;
            String r1 = this.a.a.h;
            long r2 = this.b;
            monitor-enter(r0);
            c r3 = r0.g.get(r1);     // Catch: Throwable -> L26
            if (r3 != null) goto L7;
        L24:
            monitor-exit(r0);
            return;
        L7:
            if (r3.d == r2) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == true) goto L15;
            r3 = null;
        L15:
            if (r3 == null) goto L24;
            r3.a(EntryState.BACKGROUND);     // Catch: Throwable -> L26
            r3.m++;     // Catch: Throwable -> L26
            long r5 = r3.i;     // Catch: Throwable -> L26
            if (r5 <= 0) goto L21;
            long r6 = r3.j;     // Catch: Throwable -> L26
            if (r6 <= 0) goto L21;
            r3.j = RangesKt.coerceAtLeast(r6 - (SystemClock.uptimeMillis() - r5), 0);     // Catch: Throwable -> L26
        L21:
            r3.i = 0;     // Catch: Throwable -> L26
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L26
            monitor-exit(r0);
            r0.r();
            return;
        L9:
            if (r3.f != EntryState.FOREGROUND) goto L11;
            r4 = true;
        L26:
            th = move-exception;
            throw th;
        }

        @Override // ns9.g
        public final void c() {
            final ReachBannerRuntime r2 = this.c;
            final String r0 = this.a.a.h;
            long r3 = this.b;
            monitor-enter(r2);
            c r5 = r2.g.get(r0);     // Catch: Throwable -> L79
            if (r5 != null) goto L7;
        L77:
            monitor-exit(r2);
            return;
        L7:
            if (r5.d != r3) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L13;
            r5 = null;
        L13:
            if (r5 == null) goto L77;
            EntryState r6 = r5.f;     // Catch: Throwable -> L79
            EntryState r7 = EntryState.FOREGROUND;     // Catch: Throwable -> L79
            if (r6 != r7) goto L20;
            monitor-exit(r2);
            return;
        L20:
            if (r6 != EntryState.ALLOWED) goto L22;
        L25:
            r5.a(r7);     // Catch: Throwable -> L79
            if (r5.h > 0) goto L28;
            boolean r13 = true;
        L29:
            if (r13 == false) goto L31;
            r5.h = SystemClock.uptimeMillis();     // Catch: Throwable -> L79
        L31:
            if (r13 == false) goto L39;
            ns9.t r8 = r5.a;     // Catch: Throwable -> L79
            Long r9 = r8.c.b;     // Catch: Throwable -> L79
            if (r9 == null) goto L36;
            long r10 = RangesKt.coerceAtLeast(r9.longValue(), 0);     // Catch: Throwable -> L79
        L40:
            long r14 = r10;
            if (r13 == true) goto L43;
        L47:
            r5.j = r14;     // Catch: Throwable -> L79
            r5.i = SystemClock.uptimeMillis();     // Catch: Throwable -> L79
            r5.m++;     // Catch: Throwable -> L79
            Collection<c> r11 = r2.g.values();     // Catch: Throwable -> L79
            ArrayList r12 = new ArrayList();     // Catch: Throwable -> L79
            Iterator<T> r15 = r11.iterator();     // Catch: Throwable -> L79
        L49:
            if (r15.hasNext() == false) goto L58;
            Object r16 = r15.next();     // Catch: Throwable -> L79
            c r17 = (c) r16;     // Catch: Throwable -> L79
            if (r17.a.b.b() == r5.a.b.b()) goto L53;
        L55:
            boolean r18 = false;
        L56:
            if (r18 == false) goto L49;
            r12.add(r16);     // Catch: Throwable -> L79
            goto L49
        L53:
            if (r17.f != EntryState.WAITING_POSITION) goto L55;
            r18 = true;
            goto L56
        L58:
            Iterator r19 = r12.iterator();     // Catch: Throwable -> L79
        L60:
            if (r19.hasNext() == false) goto L62;
            ((c) r19.next()).a(EntryState.PENDING);     // Catch: Throwable -> L79
            goto L60
        L62:
            ns9.t r110 = r5.a;     // Catch: Throwable -> L79
            if (r5.k == true) goto L65;
        L67:
            boolean r111 = false;
        L68:
            final g r20 = new g(r110, r13, r14, r111, r5.d, r5.m);     // Catch: Throwable -> L79
            monitor-exit(r2);
            if (r20.b == false) goto L74;
            ConcurrentHashMap<String, Long> r21 = com.larus.reach.impl.b.a;
            com.larus.reach.impl.b.e(r20.a);
            r2.d.a(r20.a);
            Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r22 = y.a;
            y.d(r20.a);
        L74:
            if (r20.d == false) goto L76;
            r2.a.postDelayed(new n(r2, r0, r20), RangesKt.coerceAtLeast(r20.c, 0));
        L76:
            r2.r();
            return;
        L65:
            if (r5.l == false) goto L67;
            r111 = true;
            goto L68
        L43:
            if (r14 <= 0) goto L45;
            boolean r23 = true;
        L46:
            r5.l = r23;     // Catch: Throwable -> L79
            goto L47
        L45:
            r23 = false;
            goto L46
        L36:
            if (r8.b.b() != ReachPosition.TOP) goto L38;
            r10 = 5000;
            goto L40
        L38:
            r10 = 10000;
            goto L40
        L39:
            r10 = r5.j;     // Catch: Throwable -> L79
            goto L40
        L28:
            r13 = false;
            goto L29
        L22:
            if (r6 == EntryState.BACKGROUND) goto L25;
            monitor-exit(r2);
            return;
        L9:
            r4 = false;
        L79:
            th = move-exception;
            throw th;
        }

        @Override // ns9.g
        public final void b(ReachCloseReason r5) {
            Intrinsics.checkNotNullParameter(r5, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.c.s(this.a.a.h, this.b, r5);
        }

        public final ReachCustomClickResult d(ns9.e r11) {
            Intrinsics.checkNotNullParameter(r11, "click");
            ReachBannerRuntime r0 = this.c;
            String r1 = this.a.a.h;
            long r2 = this.b;
            r0.getClass();
            if (r11.a == ReachClickTarget.CLOSE) goto L86;
            monitor-enter(r0);
            c r4 = r0.g.get(r1);     // Catch: Throwable -> L75
            if (r4 == null) goto L72;
            boolean r7 = false;
            if (r4.d != r2) goto L11;
            boolean r3 = true;
        L12:
            Function0<Unit> r5 = null;
            if (r3 == true) goto L16;
            r4 = null;
        L16:
            if (r4 == null) goto L72;
            EntryState r6 = r4.f;     // Catch: Throwable -> L75
            if (r6 != EntryState.ALLOWED) goto L20;
        L24:
            ns9.t r8 = r4.a;     // Catch: Throwable -> L75
            Function0<Unit> r9 = r4.b;     // Catch: Throwable -> L75
            if (r9 == null) goto L27;
            boolean r10 = true;
        L28:
            if (r10 == true) goto L30;
        L32:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L75
            monitor-exit(r0);
            if (r10 == false) goto L45;
            if (r5 == null) goto L87;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
            Object r14 = Result.constructor-impl(r5.invoke());     // Catch: Throwable -> L38
        L40:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L43;
            FLogger.a.w("ReachBannerRuntime", "reach local click action failed, reachUniqueId=" + r1, r15);
        L43:
            Result.box-impl(r14);
        L38:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
        L87:
            return ReachCustomClickResult.LOCAL_HANDLED;
        L45:
            if (r8 == null) goto L90;
            Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r17 = y.a;
            Intrinsics.checkNotNullParameter(r8, "request");
            Intrinsics.checkNotNullParameter(r11, "click");
            List r18 = y.f(r8.a.c);
            if ((r18 instanceof Collection) == true) goto L49;
        L51:
            Iterator r19 = r18.iterator();
        L53:
            if (r19.hasNext() == false) goto L68;
            ReachSceneInterceptor r20 = (ReachSceneInterceptor) r19.next();
            Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L57
            Object r22 = Result.constructor-impl(Boolean.valueOf(r20.j(r8, r11)));     // Catch: Throwable -> L57
        L59:
            Throwable r23 = Result.exceptionOrNull-impl(r22);
            if (r23 == null) goto L62;
            FLogger.a.w("ReachSceneDispatcher", "reach scene click action failed, reachUniqueId=" + r8.a.h + ", scene=" + r8.a.c, r23);
        L62:
            Boolean r24 = Boolean.FALSE;
            if (Result.isFailure-impl(r22) == false) goto L66;
            r22 = r24;
        L66:
            if (((Boolean) r22).booleanValue() == false) goto L53;
            r7 = true;
        L57:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r22 = Result.constructor-impl(ResultKt.createFailure(th));
        L68:
            if (r7 == false) goto L89;
            return ReachCustomClickResult.SCENE_HANDLED;
        L89:
            return ReachCustomClickResult.NOT_HANDLED;
        L49:
            if (r18.isEmpty() == false) goto L51;
        L90:
            return ReachCustomClickResult.LOCAL_HANDLED;
        L30:
            if (r4.o == true) goto L32;
            r4.o = true;     // Catch: Throwable -> L75
            r5 = r9;
            goto L32
        L27:
            r10 = false;
            goto L28
        L20:
            if (r6 == EntryState.FOREGROUND) goto L24;
            ReachCustomClickResult r110 = ReachCustomClickResult.LOCAL_HANDLED;     // Catch: Throwable -> L75
            monitor-exit(r0);
            return r110;
        L11:
            r3 = false;
        L72:
            ReachCustomClickResult r111 = ReachCustomClickResult.LOCAL_HANDLED;     // Catch: Throwable -> L75
            monitor-exit(r0);
            return r111;
        L75:
            th = move-exception;
            throw th;
        L86:
            return ReachCustomClickResult.NOT_HANDLED;
        }

        public f(ns9.t r2, long r3, ReachBannerRuntime r5) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r5, "runtime");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public static final class g {
        public final ns9.t a;
        public final boolean b;
        public final long c;
        public final boolean d;
        public final long e;
        public final long f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof g) == true) goto L8;
            return false;
        L8:
            g r9 = (g) r8;
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
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            long r4 = this.c;
            int r3 = (((r0 + r1) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r5 = (r3 + r2) * 31;
            long r6 = this.e;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            long r8 = this.f;
            return r7 + ((int) (r8 ^ (r8 >>> 32)));
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ShownResult(request=" + this.a + ", firstShown=" + this.b + ", autoDismissMs=" + this.c + ", scheduleAutoDismiss=" + this.d + ", entryToken=" + this.e + ", autoDismissGeneration=" + this.f + ')';
        }

        public g(ns9.t r2, boolean r3, long r4, boolean r6, long r7, long r9) {
            Intrinsics.checkNotNullParameter(r2, "request");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r9;
        }
    }

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachCloseReason.values().length];
            r0[ReachCloseReason.BUSINESS_NOT_ALLOWED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReachCloseReason.REVOKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class i<T> implements Comparator {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((c) r3).c), Long.valueOf(((c) r4).c));
        }
    }

    static {
    }

    public final void e() {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.i = true;     // Catch: Throwable -> L44
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(this);
    L57:
        monitor-enter(this);     // Catch: Throwable -> L36
        a r1 = h();     // Catch: Throwable -> L33
        if (r1 != null) goto L15;
        r1 = k();     // Catch: Throwable -> L33
    L15:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r1 == null) goto L17;
        g(r1);     // Catch: Throwable -> L36
        if ((r1 instanceof a.c) == true) goto L57;
        monitor-enter(this);
        this.i = false;     // Catch: Throwable -> L30
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    L17:
        monitor-enter(this);
        this.i = false;     // Catch: Throwable -> L21
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        monitor-enter(this);
        this.i = false;     // Catch: Throwable -> L41
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L41
        throw th;
    L41:
        th = move-exception;
        throw th;
    }

    public final void l() {
        monitor-enter(this);
        Collection<c> r0 = this.g.values();     // Catch: Throwable -> L20
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L20
    L5:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();     // Catch: Throwable -> L20
        if (((c) r3).f != EntryState.WAITING_HOST) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L5;
        r1.add(r3);     // Catch: Throwable -> L20
        goto L5
    L9:
        r4 = false;
        goto L10
    L12:
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L20
    L14:
        if (r5.hasNext() == false) goto L16;
        ((c) r5.next()).a(EntryState.PENDING);     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        r();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void r() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.h == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.h = true;     // Catch: Throwable -> L12
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        this.a.post(new com.larus.reach.runtime.i(this));
    }

    public final a.c h() {
        Iterator<T> r0 = this.g.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Object r1 = r0.next();
        c r3 = (c) r1;
        EntryState r4 = r3.f;
        if (r4 != EntryState.DISMISSING) goto L8;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L4;
    L16:
        c r2 = (c) r1;
        if (r2 != null) goto L19;
        return null;
    L19:
        o(r2);
        return new a.c(r2, ReachRejectReason.EXPIRED);
    L8:
        if (r4.isPresented() == true) goto L12;
        if (j(r3.a) == false) goto L12;
        r5 = true;
        goto L13
    L15:
        r1 = null;
        goto L16
    }

    public final a.C0018a k() {
        Collection<c> r0 = this.g.values();
        if (r0.isEmpty() == true) goto L18;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        c r2 = (c) r1.next();
        if (r2.a.b.b() == ReachPosition.TOP) goto L11;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L7;
        boolean r4 = true;
    L19:
        Collection<c> r5 = this.g.values();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L30;
        Object r8 = r7.next();
        c r9 = (c) r8;
        if (r9.a.b.b() == ReachPosition.TOP) goto L25;
    L27:
        boolean r10 = false;
    L28:
        if (r10 == false) goto L21;
        r6.add(r8);
        goto L21
    L25:
        if (r9.f.isPresented() == true) goto L27;
        r10 = true;
        goto L28
    L30:
        Iterator r11 = r6.iterator();
        if (r11.hasNext() == true) goto L33;
        Object r12 = null;
    L42:
        c r13 = (c) r12;
        Collection<c> r14 = this.g.values();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L44:
        if (r16.hasNext() == false) goto L55;
        Object r17 = r16.next();
        c r18 = (c) r17;
        if (r18.f == EntryState.PENDING) goto L48;
    L52:
        boolean r19 = false;
    L53:
        if (r19 == false) goto L44;
        r15.add(r17);
        goto L44
    L48:
        if (r18.a.b.b() != ReachPosition.TOP) goto L51;
        if (r4 == true) goto L52;
        if (r18 != r13) goto L52;
    L51:
        r19 = true;
        goto L53
    L55:
        Iterator r20 = CollectionsKt.sortedWith(r15, new o()).iterator();
        if (r20.hasNext() == false) goto L59;
        c r21 = (c) r20.next();
        r21.a(EntryState.CHECKING);
        return new a.C0018a(r21);
    L59:
        return null;
    L33:
        r12 = r11.next();
        if (r11.hasNext() == false) goto L42;
        long r22 = ((c) r12).c;
    L37:
        Object r23 = r11.next();
        long r24 = ((c) r23).c;
        if (r22 <= r24) goto L41;
        r12 = r23;
        r22 = r24;
    L41:
        if (r11.hasNext() == true) goto L37;
    L11:
        if (r2.f != EntryState.ALLOWED) goto L15;
        if (r2.h > 0) goto L15;
        r3 = true;
    L18:
        r4 = false;
        goto L19
    }

    public ReachBannerRuntime() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new os9.g();
        this.c = new com.larus.reach.impl.a();
        this.d = new com.larus.reach.impl.n();
        this.e = new AtomicLong();
        this.f = new AtomicLong();
        this.g = new LinkedHashMap();
    }

    public static boolean j(ns9.t r6) {
        ns9.v r7 = r6.b;
        if ((r7 instanceof ns9.w) == false) goto L5;
        ns9.w r8 = (ns9.w) r7;
    L7:
        if (r8 != null) goto L10;
        return false;
    L10:
        if (r8.d > 0) goto L12;
        return false;
    L12:
        if (System.currentTimeMillis() < r8.d) goto L16;
        return true;
    L16:
        return false;
    L5:
        r8 = null;
        goto L7
    }

    public final List<ns9.j> d(c r14) {
        monitor-enter(this);
        Collection<c> r0 = this.g.values();     // Catch: Throwable -> L26
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L26
    L4:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();     // Catch: Throwable -> L26
        c r5 = (c) r4;     // Catch: Throwable -> L26
        if (r5 != r14) goto L9;
    L13:
        if (r3 == false) goto L4;
        r1.add(r4);     // Catch: Throwable -> L26
        goto L4
    L9:
        if (r5.a.b.b() != r14.a.b.b()) goto L13;
        if (r5.f.isPresented() == false) goto L13;
        r3 = true;
        goto L13
    L15:
        List r15 = CollectionsKt.sortedWith(r1, new i());     // Catch: Throwable -> L26
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));     // Catch: Throwable -> L26
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L26
    L16:
        if (r16.hasNext() == false) goto L24;
        c r7 = (c) r16.next();     // Catch: Throwable -> L26
        ns9.t r8 = r7.a;     // Catch: Throwable -> L26
        long r9 = r7.c;     // Catch: Throwable -> L26
        long r10 = r7.h;     // Catch: Throwable -> L26
        boolean r11 = r7.e;     // Catch: Throwable -> L26
        if (r7.f != EntryState.DISMISSING) goto L21;
        boolean r12 = true;
    L22:
        r6.add(new ns9.j(r8, r9, r10, r11, r12));     // Catch: Throwable -> L26
        goto L16
    L21:
        r12 = false;
        goto L22
    L24:
        monitor-exit(this);
        return r6;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r10v11, types: [os9.d] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.reach.runtime.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.reach.runtime.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v8, types: [os9.c] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.reach.runtime.a, java.lang.Object] */
    public final void g(a r23) {
        if ((r23 instanceof a.C0018a) == false) goto L351;
        final c r8 = ((a.C0018a) r23).a;
        long r4 = v.b();
        ReachRejectReason r0 = f(r8.a, ReachGatePhase.BEFORE_PRESENT);
        c r9 = null;
        boolean r10 = true;
        if (r0 != null) goto L7;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
        Object r2 = Result.constructor-impl(v.d(r8.a));     // Catch: Throwable -> L34
    L36:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L40;
        FLogger.a.w("ReachBannerRuntime", "reach host resolve failed, reachUniqueId=" + r8.a.a.h, r3);
    L40:
        if (Result.isFailure-impl(r2) == false) goto L42;
        r2 = null;
    L42:
        ReachBannerHost r5 = (ReachBannerHost) r2;
        if (r5 != null) goto L369;
        c(r8, new d.b(ReachRejectReason.INVALID_PROTOCOL, null));
        return;
    L369:
        ns9.h r6 = r5.d(r8.a);     // Catch: Throwable -> L57
        if (Intrinsics.areEqual(r6, ns9.h.a.a) == false) goto L49;
        Object r7 = null;
    L54:
        Object r11 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L62;
        FLogger.a.w("ReachBannerRuntime", "reach host evaluate failed, reachUniqueId=" + r8.a.a.h, r12);
    L62:
        d.b r13 = new d.b(ReachRejectReason.CLIENT_EXCEPTION, r5);
        if (Result.isFailure-impl(r11) == false) goto L65;
        r11 = r13;
    L65:
        d r14 = (d) r11;
        if (r14 == null) goto L68;
        c(r8, r14);
        return;
    L68:
        Context r15 = r5.e(r8.a);
        if (r15 != null) goto L71;
        c(r8, new d.c(r5, r4, "render_context_unavailable"));
        return;
    L71:
        ns9.c r16 = r8.n;
        if (r16 != null) goto L322;
        final ns9.t r17 = r8.a;
        os9.g r18 = this.b;
        List<os9.g.a> r19 = os9.g.a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        final View r20 = LayoutInflater.from(r15).inflate(2131563227, null, false);
        os9.g r21 = this.b;
        final ?? r22 = new com.larus.reach.runtime.a(this, r20, r17, r8);
        final ?? r110 = new com.larus.reach.runtime.f(r17, this, r20, r8);
        final ?? r111 = new com.larus.reach.runtime.g(r17, this);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r17, "request");
        Intrinsics.checkNotNullParameter(r22, "onContainerClick");
        Intrinsics.checkNotNullParameter(r110, "onButtonClick");
        Intrinsics.checkNotNullParameter(r111, "onCloseClick");
        Integer r24 = r17.d.a;
        if (r24 != null) goto L77;
    L79:
        boolean r25 = false;
    L80:
        String r112 = r17.d.c;
        if (r112 != null) goto L83;
    L86:
        boolean r113 = true;
    L87:
        boolean r114 = !r113;
        if (r25 == true) goto L110;
        List<ns9.d> r26 = r17.d.f;
        if ((r26 instanceof Collection) == true) goto L92;
    L94:
        Iterator<T> r27 = r26.iterator();
    L96:
        if (r27.hasNext() == false) goto L107;
        ns9.d r115 = (ns9.d) r27.next();
        if (r115.getType() != ReachButtonType.NORMAL) goto L100;
    L103:
        boolean r116 = true;
    L104:
        if (r116 == false) goto L96;
        boolean r28 = true;
    L108:
        if (r28 == false) goto L110;
        boolean r29 = true;
    L111:
        SimpleDraweeView r117 = r20.findViewById(2131383733);
        if (r117 == null) goto L129;
        if (r114 == false) goto L115;
        int r118 = 0;
    L116:
        r117.setVisibility(r118);
        GenericDraweeHierarchy r119 = r117.getHierarchy();
        RoundingParams r120 = r117.getHierarchy().getRoundingParams();
        if (r120 == null) goto L119;
        boolean r30 = true;
        RoundingParams r31 = r120.setRoundAsCircle(StringsKt.equals(r17.e.b.get("icon_shape"), "circle", true));
    L120:
        r119.setRoundingParams(r31);
        String r32 = r17.d.c;
        if (r32 != null) goto L123;
    L128:
        ViewGroup.LayoutParams r33 = r117.getLayoutParams();
        r33.width = os9.g.b(36, r117);
        r33.height = os9.g.b(36, r117);
        r117.setLayoutParams(r33);
    L130:
        String r34 = r17.d.d;
        if (r34 != null) goto L133;
    L136:
        boolean r121 = true;
    L137:
        boolean r35 = !r121;
        TextView r36 = (TextView) r20.findViewById(2131383741);
        if (r36 == null) goto L147;
        String r122 = r17.d.b;
        if (r122 != null) goto L142;
        r122 = "";
    L142:
        r36.setText(r122);
        if (r35 == false) goto L145;
        int r123 = 1;
    L146:
        r36.setMaxLines(r123);
        goto L147
    L145:
        r123 = 2;
    L147:
        TextView r37 = (TextView) r20.findViewById(2131383739);
        if (r37 == null) goto L157;
        String r124 = r17.d.d;
        if (r124 != null) goto L152;
        r124 = "";
    L152:
        r37.setText(r124);
        if (r35 == false) goto L155;
        int r38 = 0;
    L156:
        r37.setVisibility(r38);
        goto L157
    L155:
        r38 = 8;
    L157:
        View r39 = r20.findViewById(2131383732);
        if (r39 == null) goto L166;
        ViewGroup.LayoutParams r125 = r39.getLayoutParams();
        r125.height = -2;
        r39.setLayoutParams(r125);
        int r126 = 14;
        int r127 = os9.g.b(14, r39);
        if (r25 == false) goto L162;
        r126 = 10;
    L162:
        if (r25 == false) goto L164;
        int r128 = os9.g.b(10, r39);
    L165:
        r39.setMinimumHeight(os9.g.b(r126 + 50, r39));
        int r129 = os9.g.b(16, r39);
        r39.setPaddingRelative(r129, r127, r129, r128);
        goto L166
    L164:
        r128 = r127;
    L166:
        View r40 = r20.findViewById(2131383740);
        if (r40 == null) goto L186;
        ViewGroup.LayoutParams r130 = r40.getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == false) goto L171;
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
    L172:
        if (r131 == null) goto L186;
        int r132 = 12;
        if (r114 == false) goto L176;
        int r133 = 12;
    L177:
        r131.setMarginStart(os9.g.b(r133, r40));
        if (r17.a.f == ReachRequestSource.CLIENT_BRIDGE) goto L180;
    L182:
        if (r29 == true) goto L185;
        r132 = 0;
    L185:
        r131.setMarginEnd(os9.g.b(r132, r40));
        r40.setLayoutParams(r131);
        goto L186
    L180:
        if (r17.b.b() != ReachPosition.BOTTOM) goto L182;
        r132 = 8;
        goto L182
    L176:
        r133 = 0;
        goto L177
    L171:
        r131 = null;
    L186:
        Iterator r41 = CollectionsKt.listOf(new Integer[]{2131383730, 2131383737, 2131383734}).iterator();
    L188:
        if (r41.hasNext() == false) goto L192;
        View r134 = r20.findViewById(((Number) r41.next()).intValue());
        if (r134 == null) goto L188;
        r134.setVisibility(8);
        r134.setOnClickListener(null);
        goto L188
    L192:
        int r135 = 8;
        View r136 = r20.findViewById(2131383736);
        if (r136 == null) goto L197;
        if (r29 == false) goto L196;
        r135 = 0;
    L196:
        r136.setVisibility(r135);
    L197:
        if (r25 == false) goto L262;
        Iterable r42 = CollectionsKt.withIndex(r17.d.f);
        ArrayList r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L200:
        if (r44.hasNext() == false) goto L207;
        Object r45 = r44.next();
        if (((ns9.d) ((IndexedValue) r45).getValue()).getType() != ReachButtonType.NORMAL) goto L204;
        boolean r46 = true;
    L205:
        if (r46 == false) goto L200;
        r43.add(r45);
        goto L200
    L204:
        r46 = false;
        goto L205
    L207:
        List r47 = CollectionsKt.take(r43, 2);
        if (r47.isEmpty() == true) goto L305;
        View r48 = r20.findViewById(2131383730);
        if (r48 == null) goto L213;
        r48.setVisibility(0);
    L213:
        int r49 = r47.size();
        ViewGroup r50 = (ViewGroup) r20.findViewById(2131383730);
        if (r50 == null) goto L247;
        List r51 = CollectionsKt.take(os9.g.a, r49);
        ArrayList r52 = new ArrayList();
        Iterator r53 = r51.iterator();
    L218:
        if (r53.hasNext() == false) goto L222;
        View r137 = r50.findViewById(((os9.g.a) r53.next()).a);
        if (r137 == null) goto L218;
        r52.add(r137);
        goto L218
    L222:
        Iterator r54 = r52.iterator();
    L224:
        if (r54.hasNext() == false) goto L226;
        r50.removeView((View) r54.next());
        goto L224
    L226:
        Iterator r55 = r52.iterator();
        int r138 = 0;
    L228:
        if (r55.hasNext() == false) goto L247;
        Object r139 = r55.next();
        int r140 = r138 + 1;
        if (r138 >= 0) goto L232;
        CollectionsKt.throwIndexOverflow();
    L232:
        View r141 = (View) r139;
        r50.addView(r141, r138);
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L235;
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r142;
    L236:
        if (r143 == null) goto L246;
        int r144 = os9.g.b(6, r141);
        if (r138 != 0) goto L240;
        int r56 = 0;
    L241:
        r143.setMarginStart(r56);
        if (r138 != CollectionsKt.getLastIndex(r52)) goto L244;
        r144 = 0;
    L244:
        r143.setMarginEnd(r144);
        r141.setLayoutParams(r143);
        goto L246
    L240:
        r56 = r144;
    L246:
        r138 = r140;
        r55 = r55;
        goto L228
    L235:
        r143 = null;
    L247:
        Iterator r57 = r47.iterator();
        int r58 = 0;
    L249:
        if (r57.hasNext() == false) goto L305;
        Object r59 = r57.next();
        int r60 = r58 + 1;
        if (r58 >= 0) goto L253;
        CollectionsKt.throwIndexOverflow();
    L253:
        final IndexedValue r61 = (IndexedValue) r59;
        os9.g.a r62 = (os9.g.a) ListProtector.get(os9.g.a, r58);
        TextView r145 = (TextView) r20.findViewById(r62.b);
        ShapeLinearLayout r63 = r20.findViewById(r62.a);
        if (r63 == null) goto L256;
        r63.setVisibility(0);
        e1.d(r63, new os9.b(r110, r61));
        os9.g.a(r63, r145, ((ns9.d) r61.getValue()).b);
    L256:
        if (r145 == null) goto L261;
        String r64 = ((ns9.d) r61.getValue()).c;
        if (r64 != null) goto L260;
        r64 = "";
    L260:
        r145.setText(r64);
    L261:
        r58 = r60;
    L305:
        Intrinsics.checkNotNullParameter(r20, "view");
        View r65 = r20.findViewById(2131383731);
        if (r65 != null) goto L308;
        r65 = r20;
    L308:
        r65.setClickable(true);
        e1.d(r65, new os9.a(r22));
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r20, "view");
        View r66 = r20.findViewById(2131383731);
        if (r66 != null) goto L312;
        r66 = r20;
    L312:
        if ((r66 instanceof ReachSwipeDismissLayout) == false) goto L314;
        ReachSwipeDismissLayout r67 = (ReachSwipeDismissLayout) r66;
    L315:
        if (r67 != null) goto L317;
    L321:
        r16 = new ns9.c(r20, r66);
        r8.n = r16;
    L367:
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L340
        ReachBannerHost r69 = r5;
        ns9.h r70 = r69.b(r8.a, r16);     // Catch: Throwable -> L338
        if (Intrinsics.areEqual(r70, ns9.h.a.a) == false) goto L329;
        Object r71 = new d.a(r69);     // Catch: Throwable -> L338
    L335:
        Object r72 = Result.constructor-impl(r71);     // Catch: Throwable -> L338
    L343:
        Throwable r73 = Result.exceptionOrNull-impl(r72);
        if (r73 == null) goto L346;
        FLogger.a.w("ReachBannerRuntime", "reach host evaluate failed, reachUniqueId=" + r8.a.a.h, r73);
    L346:
        d.b r74 = new d.b(ReachRejectReason.CLIENT_EXCEPTION, r69);
        if (Result.isFailure-impl(r72) == false) goto L349;
        r72 = r74;
    L349:
        c(r8, (d) r72);
        return;
    L329:
        if ((r70 instanceof ns9.h.c) == false) goto L333;
        Object r75 = new d.c(r69, r4, ((ns9.h.c) r70).a);     // Catch: Throwable -> L338
    L331:
        r71 = r75;
        goto L335
    L333:
        if ((r70 instanceof ns9.h.b) == false) goto L337;
        r75 = new d.b(((ns9.h.b) r70).a, r69);     // Catch: Throwable -> L338
        goto L331
    L337:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L338
    L338:
        th = th;
    L342:
        Result.Companion r76 = Result.Companion;
        r72 = Result.constructor-impl(ResultKt.createFailure(th));
    L340:
        th = th;
        r69 = r5;
        goto L342
    L317:
        if (r17.b.b() != ReachPosition.BOTTOM) goto L319;
        int r146 = 1;
    L320:
        r67.setSwipeDirection(r146);
        r67.setOnSwipeDismiss(new com.larus.reach.runtime.h(this, r17));
        goto L321
    L319:
        r146 = -1;
        goto L320
    L314:
        r67 = null;
        goto L315
    L262:
        ViewGroup r77 = (ViewGroup) r20.findViewById(2131383736);
        if (r77 == null) goto L305;
        r77.removeAllViews();
        Iterator r78 = r17.d.f.iterator();
        final int r79 = 0;
    L267:
        if (r78.hasNext() == false) goto L283;
        Object r147 = r78.next();
        int r148 = r79 + 1;
        if (r79 >= 0) goto L271;
        CollectionsKt.throwIndexOverflow();
    L271:
        ns9.d r149 = (ns9.d) r147;
        int r150 = os9.g.c.a[r149.getType().ordinal()];
        if (r150 != 1) goto L274;
        String r151 = r149.c;
        if (r151 != null) goto L281;
        r151 = "";
    L281:
        ReachButtonStyle r152 = r149.b;
        final ?? r153 = new os9.c(r110, r79);
        View r80 = LayoutInflater.from(r77.getContext()).inflate(2131563229, r77, false);
        Intrinsics.checkNotNull(r80, "null cannot be cast to non-null type com.larus.common_ui.venus.ShapeLinearLayout");
        ShapeLinearLayout r81 = (ShapeLinearLayout) r80;
        TextView r82 = (TextView) r81.findViewById(R.id.text1);
        r82.setText(r151);
        e1.d(r81, new os9.e(r153));
        os9.g.a(r81, r82, r152);
        r77.addView(r81);
    L282:
        r79 = r148;
        r78 = r78;
        goto L267
    L274:
        if (r150 != 2) goto L277;
        final ?? r154 = new os9.d(r111, r79);
        View r83 = LayoutInflater.from(r77.getContext()).inflate(2131563228, r77, false);
        e1.d(r83, new os9.f(r154));
        r77.addView(r83);
        goto L282
    L277:
        throw new NoWhenBranchMatchedException();
    L283:
        IntRange r84 = RangesKt.until(0, r77.getChildCount());
        ArrayList r85 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r84, 10));
        IntIterator r86 = r84.iterator();
    L285:
        if (r86.hasNext() == false) goto L287;
        r85.add(r77.getChildAt(r86.nextInt()));
        goto L285
    L287:
        Iterator r87 = r85.iterator();
        int r155 = 0;
    L289:
        if (r87.hasNext() == false) goto L305;
        Object r88 = r87.next();
        int r89 = r155 + 1;
        if (r155 >= 0) goto L293;
        CollectionsKt.throwIndexOverflow();
    L293:
        View r90 = (View) r88;
        ViewGroup.LayoutParams r91 = r90.getLayoutParams();
        if ((r91 instanceof ViewGroup.MarginLayoutParams) == false) goto L296;
        ViewGroup.MarginLayoutParams r92 = (ViewGroup.MarginLayoutParams) r91;
    L298:
        if (r92 == null) goto L304;
        r92.setMarginStart(0);
        if (r155 != CollectionsKt.getLastIndex(r85)) goto L302;
        int r156 = 0;
    L303:
        r92.setMarginEnd(r156);
        r90.setLayoutParams(r92);
        goto L304
    L302:
        Intrinsics.checkNotNull(r90);
        r156 = os9.g.b(15, r90);
    L304:
        r155 = r89;
        goto L289
    L296:
        r92 = null;
        goto L298
    L133:
        if (StringsKt.isBlank(r34) == true) goto L136;
        r121 = false;
        goto L137
    L123:
        if ((StringsKt.isBlank(r32) ^ r30) == true) goto L126;
        r32 = null;
    L126:
        if (r32 == null) goto L128;
        ImageLoaderKt.u(r117, r32, "notification.banner");
        goto L128
    L119:
        r30 = true;
        r31 = null;
        goto L120
    L115:
        r118 = 8;
        goto L116
    L129:
        r5 = r5;
        r4 = r4;
        goto L130
    L100:
        if (r115.getType() == ReachButtonType.CLOSE) goto L103;
        r116 = false;
    L107:
        r28 = false;
        goto L108
    L92:
        if (r26.isEmpty() == false) goto L94;
    L110:
        r29 = false;
        goto L111
    L83:
        if (StringsKt.isBlank(r112) == true) goto L86;
        r113 = false;
        goto L87
    L77:
        if (r24.intValue() != 2) goto L79;
        r25 = true;
        goto L80
    L322:
        r5 = r5;
        r4 = r4;
        goto L367
    L49:
        if ((r6 instanceof ns9.h.c) == false) goto L52;
        r7 = new d.c(r5, r4, ((ns9.h.c) r6).a);     // Catch: Throwable -> L57
        goto L54
    L52:
        if ((r6 instanceof ns9.h.b) == false) goto L56;
        r7 = new d.b(((ns9.h.b) r6).a, r5);     // Catch: Throwable -> L57
        goto L54
    L56:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        Result.Companion r94 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L7:
        if (r0 == ReachRejectReason.NOT_TARGET_PAGE) goto L9;
    L11:
        monitor-enter(this);
        c r95 = this.g.get(r8.a.a.h);     // Catch: Throwable -> L29
        if (r95 == null) goto L24;
        if (r95 == r8) goto L16;
    L18:
        boolean r96 = false;
    L19:
        if (r96 == false) goto L21;
        r9 = r95;
    L21:
        if (r9 == null) goto L24;
        o(r8);     // Catch: Throwable -> L29
    L25:
        monitor-exit(this);
        if (r10 == false) goto L28;
        n(r8, r0);
    L28:
        r();
        return;
    L16:
        if (r95.f != EntryState.CHECKING) goto L18;
        r96 = true;
    L24:
        r10 = false;
    L29:
        th = move-exception;
        throw th;
    L9:
        if (t(r8, null, r4, null) == false) goto L11;
        r();
        return;
    L351:
        if ((r23 instanceof a.b) == false) goto L357;
        a.b r97 = (a.b) r23;
        final c r98 = r97.a;
        final ReachCloseReason r99 = r97.b;
        final ReachBannerHost r100 = r98.g;
        if (r100 != null) goto L355;
        s(r98.a.a.h, r98.d, r99);
        return;
    L355:
        q(new l(this, r100, r98, r99));
        return;
    L357:
        if ((r23 instanceof a.c) == false) goto L361;
        a.c r101 = (a.c) r23;
        n(r101.a, r101.b);
        return;
    L361:
        throw new NoWhenBranchMatchedException();
    }

    public final c o(c r7) {
        c r0 = this.g.remove(r7.a.a.h);
        if (r0 == null) goto L6;
        r7 = r0;
    L6:
        Collection<c> r1 = this.g.values();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        c r5 = (c) r4;
        if (r5.a.b.b() == r7.a.b.b()) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        if (r5.f != EntryState.WAITING_POSITION) goto L14;
        r6 = true;
        goto L15
    L17:
        Iterator r8 = r2.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        ((c) r8.next()).a(EntryState.PENDING);
        goto L19
    L21:
        return r7;
    }

    public final void q(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new m(r3));
    }

    public static ReachRejectReason f(ns9.t r5, ReachGatePhase r6) {
        if (j(r5) == true) goto L54;
        List<Integer> r0 = r5.a.g;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L32
        if (r0 != null) goto L9;
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
    L9:
        boolean r3 = true;
        if (r0.isEmpty() == true) goto L30;
        List<Integer> r1 = r0;     // Catch: Throwable -> L32
        if ((r1 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r4 = r1.iterator();     // Catch: Throwable -> L32
    L19:
        if (r4.hasNext() == false) goto L30;
        int r7 = ((Number) r4.next()).intValue();     // Catch: Throwable -> L32
        UserConfigKey.Companion.getClass();     // Catch: Throwable -> L32
        UserConfigKey r8 = UserConfigKey.a.a(r7);     // Catch: Throwable -> L32
        if (r8 != null) goto L23;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L19;
        r3 = false;
        goto L30
    L23:
        UserConfigItem r10 = UserSettingDelegate.b.b(r8);     // Catch: Throwable -> L32
        if (r10 == null) goto L26;
        String r11 = r10.c();     // Catch: Throwable -> L32
    L27:
        r9 = !Intrinsics.areEqual(r11, "0");     // Catch: Throwable -> L32
        goto L28
    L26:
        r11 = null;
        goto L27
    L15:
        if (r1.isEmpty() == false) goto L17;
    L30:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L32
    L34:
        Boolean r13 = Boolean.TRUE;
        if (Result.isFailure-impl(r12) == false) goto L38;
        r12 = r13;
    L38:
        if (((Boolean) r12).booleanValue() == true) goto L41;
        return ReachRejectReason.NOTIFICATION_DISABLED;
    L41:
        if (r6 != ReachGatePhase.BEFORE_PRESENT) goto L46;
        if (y.a(r5) == true) goto L46;
        return ReachRejectReason.BUSINESS_NOT_ALLOWED;
    L46:
        return null;
    L32:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L54:
        return ReachRejectReason.EXPIRED;
    }

    public static void n(c r1, ReachRejectReason r2) {
        ConcurrentHashMap<String, Long> r0 = com.larus.reach.impl.b.a;
        com.larus.reach.impl.b.d(r1.a, r2);
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r3 = y.a;
        y.c(r1.a, r2);
    }

    public final void a(ns9.t r8, boolean r9) {
        if (r9 == true) goto L4;
        return;
    L4:
        boolean r0 = false;
        if (StringsKt.equals(r8.c.c, "keep", true) == false) goto L16;
        monitor-enter(this);
        c r10 = this.g.get(r8.a.h);     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        r10.k = false;     // Catch: Throwable -> L13
    L10:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        String r12 = r8.c.c;
        if (r12 != null) goto L19;
    L20:
        r0 = true;
    L21:
        if (r0 == false) goto L23;
    L24:
        p(this, r8.a.h, ReachCloseReason.CLICK_DISMISSAL, null, null, true, 12);
        return;
    L23:
        if (StringsKt.equals(r8.c.c, "dismiss", true) == true) goto L24;
        return;
    L19:
        if (StringsKt.isBlank(r12) == false) goto L21;
        goto L20
    }

    public final void c(final c r11, d r12) {
        if ((r12 instanceof d.a) == true) goto L84;
        boolean r1 = true;
        c r3 = null;
        if ((r12 instanceof d.c) == false) goto L55;
        d.c r0 = (d.c) r12;
        if (t(r11, r0.a, r0.b, r0.c) == true) goto L73;
        monitor-enter(this);
        c r2 = this.g.get(r11.a.a.h);     // Catch: Throwable -> L51
        if (r2 == null) goto L47;
        if (r2 == r11) goto L39;
    L41:
        boolean r4 = false;
    L42:
        if (r4 == false) goto L44;
        r3 = r2;
    L44:
        if (r3 == null) goto L47;
        r3.g = ((d.c) r12).a;     // Catch: Throwable -> L51
        o(r11);     // Catch: Throwable -> L51
    L48:
        monitor-exit(this);
        if (r1 == false) goto L73;
        n(r11, ReachRejectReason.NOT_TARGET_PAGE);
        goto L73
    L39:
        if (r2.f != EntryState.CHECKING) goto L41;
        r4 = true;
    L47:
        r1 = false;
    L51:
        th = move-exception;
        throw th;
    L73:
        r();
        return;
    L55:
        if ((r12 instanceof d.b) == false) goto L79;
        monitor-enter(this);
        c r5 = this.g.get(r11.a.a.h);     // Catch: Throwable -> L75
        if (r5 == null) goto L69;
        if (r5 == r11) goto L61;
    L63:
        boolean r6 = false;
    L64:
        if (r6 == false) goto L66;
        r3 = r5;
    L66:
        if (r3 == null) goto L69;
        r3.g = ((d.b) r12).b;     // Catch: Throwable -> L75
        o(r11);     // Catch: Throwable -> L75
    L70:
        monitor-exit(this);
        if (r1 == false) goto L73;
        n(r11, ((d.b) r12).a);
        goto L73
    L61:
        if (r5.f != EntryState.CHECKING) goto L63;
        r6 = true;
    L69:
        r1 = false;
    L75:
        th = move-exception;
        throw th;
    L79:
        throw new NoWhenBranchMatchedException();
    L84:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L6
        Object r8 = Result.constructor-impl(((d.a) r12).a.c(r11.a, d(r11)));     // Catch: Throwable -> L6
    L8:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L11;
        FLogger.a.w("ReachBannerRuntime", "reach host resolve display decision failed, reachUniqueId=" + r11.a.a.h, r9);
    L11:
        ns9.i.b r10 = ns9.i.b.a;
        if (Result.isFailure-impl(r8) == false) goto L14;
        r8 = r10;
    L14:
        final e r13 = b(r11, ((d.a) r12).a, (ns9.i) r8);
        if ((r13 instanceof e.b) == false) goto L18;
        q(new j(this, r13, r11));
        this.a.postDelayed(new com.larus.reach.runtime.b(this, r11), 3000);
        goto L73
    L18:
        if ((r13 instanceof e.a) == false) goto L21;
        q(new k(this, r13, r11));
        this.a.postDelayed(new com.larus.reach.runtime.b(this, r11), 3000);
        goto L73
    L21:
        if ((r13 instanceof e.d) == false) goto L26;
        Long r14 = ((e.d) r13).a;
        if (r14 == null) goto L73;
        this.a.postDelayed(new com.larus.reach.runtime.c(this, r11), RangesKt.coerceAtLeast(r14.longValue(), 1));
        goto L73
    L26:
        if (Intrinsics.areEqual(r13, e.c.a) == true) goto L73;
        throw new NoWhenBranchMatchedException();
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void i(c r7, ReachRejectReason r8) {
        monitor-enter(this);
        c r0 = this.g.get(r7.a.a.h);     // Catch: Throwable -> L21
        c r1 = null;
        if (r0 == null) goto L17;
        if (r0 == r7) goto L7;
    L11:
        boolean r9 = false;
    L12:
        if (r9 == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L17;
        r1 = o(r0);     // Catch: Throwable -> L21
        goto L17
    L7:
        if (r0.d != r7.d) goto L11;
        if (r0.h > 0) goto L11;
        r9 = true;
    L17:
        monitor-exit(this);
        if (r1 == null) goto L26;
        n(r1, r8);
        r();
        return;
    L26:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final void m(final c r8, final ReachRejectReason r9) {
        monitor-enter(this);
        c r0 = this.g.get(r8.a.a.h);     // Catch: Throwable -> L23
        final ReachBannerHost r1 = null;
        if (r0 == null) goto L17;
        if (r0 == r8) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L17;
        r0.a(EntryState.DISMISSING);     // Catch: Throwable -> L23
        r1 = r0.g;     // Catch: Throwable -> L23
        goto L17
    L7:
        if (r0.d != r8.d) goto L11;
        if (r0.f != EntryState.ALLOWED) goto L11;
        r2 = true;
    L17:
        monitor-exit(this);
        if (r1 != null) goto L21;
        i(r8, r9);
        return;
    L21:
        q(new com.larus.reach.runtime.d(this, r1, r8, r9));
        this.a.postDelayed(new com.larus.reach.runtime.e(this, r8, r9), 500);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final e b(c r12, ReachBannerHost r13, ns9.i r14) {
        monitor-enter(this);
        c r0 = this.g.get(r12.a.a.h);     // Catch: Throwable -> L49
        if (r0 == null) goto L46;
        boolean r1 = true;
        if (r0 == r12) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L46;
        r0.g = r13;     // Catch: Throwable -> L49
        f r7 = new f(r12.a, r12.d, this);     // Catch: Throwable -> L49
        ns9.c r8 = r12.n;     // Catch: Throwable -> L49
        if (r8 != null) goto L20;
        e r15 = e.c.a;     // Catch: Throwable -> L49
    L47:
        monitor-exit(this);
        return r15;
    L20:
        if (Intrinsics.areEqual(r14, ns9.i.b.a) == false) goto L23;
        r0.a(EntryState.ALLOWED);     // Catch: Throwable -> L49
        r15 = new e.b(r13, r7, r8);     // Catch: Throwable -> L49
        goto L47
    L23:
        if ((r14 instanceof ns9.i.a) == false) goto L42;
        c r4 = this.g.get(((ns9.i.a) r14).a);     // Catch: Throwable -> L49
        if (r4 != null) goto L27;
    L34:
        c r9 = null;
    L35:
        if (r9 == null) goto L40;
        EntryState r16 = r9.f;     // Catch: Throwable -> L49
        EntryState r2 = EntryState.DISMISSING;     // Catch: Throwable -> L49
        if (r16 == r2) goto L40;
        r9.a(r2);     // Catch: Throwable -> L49
        r0.a(EntryState.ALLOWED);     // Catch: Throwable -> L49
        r15 = new e.a(r13, r7, r8, r9, ((ns9.i.a) r14).b);     // Catch: Throwable -> L49
    L40:
        r0.a(EntryState.WAITING_POSITION);     // Catch: Throwable -> L49
        r15 = new e.d(null);     // Catch: Throwable -> L49
        goto L47
    L27:
        if (r4.a.b.b() == r12.a.b.b()) goto L29;
    L31:
        r1 = false;
    L32:
        if (r1 == false) goto L34;
        r9 = r4;
        goto L35
    L29:
        if (r4.f.isPresented() == false) goto L31;
    L42:
        if ((r14 instanceof ns9.i.c) == false) goto L45;
        r0.a(EntryState.WAITING_POSITION);     // Catch: Throwable -> L49
        r15 = new e.d(((ns9.i.c) r14).a);     // Catch: Throwable -> L49
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L49
    L8:
        if (r0.f != EntryState.CHECKING) goto L10;
        r3 = true;
    L46:
        r15 = e.c.a;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }

    public final void s(String r7, long r8, ReachCloseReason r10) {
        monitor-enter(this);
        c r9 = this.g.get(r7);     // Catch: Throwable -> L46
        c r1 = null;
        if (r9 != null) goto L6;
    L14:
        monitor-exit(this);
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.h <= 0) goto L36;
        ConcurrentHashMap<String, Long> r11 = com.larus.reach.impl.b.a;
        ns9.t r12 = r1.a;
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r10, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Long r13 = com.larus.reach.impl.b.a.remove(r12.a.h);
        if (r13 == null) goto L25;
        long r14 = r13.longValue();
        if (com.larus.reach.impl.c.a(r12) == false) goto L25;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r15 = com.larus.reach.impl.b.a(r12);
        r15.put("close_type", r10.getCloseType());
        r15.put("stay_duration", RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - r14, 0));
        Unit r16 = Unit.INSTANCE;
        r0.reportEvent("inapp_push_close", r15);
    L25:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r17 = y.a;
        ns9.t r18 = r1.a;
        Intrinsics.checkNotNullParameter(r18, "request");
        Intrinsics.checkNotNullParameter(r10, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Iterator r19 = y.h(r18.a.c).iterator();
    L27:
        if (r19.hasNext() == false) goto L44;
        ReachSceneLifecycleListener r20 = (ReachSceneLifecycleListener) r19.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        r20.d(r18, r10);     // Catch: Throwable -> L31
        Object r21 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L27;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onDismiss failed, reachUniqueId=" + r18.a.h + ", scene=" + r18.a.c, r22);
    L31:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r();
        return;
    L36:
        int r23 = h.a[r10.ordinal()];
        if (r23 != 1) goto L39;
        ReachRejectReason r24 = ReachRejectReason.BUSINESS_NOT_ALLOWED;
    L43:
        ConcurrentHashMap<String, Long> r25 = com.larus.reach.impl.b.a;
        com.larus.reach.impl.b.d(r1.a, r24);
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r26 = y.a;
        y.c(r1.a, r24);
        goto L44
    L39:
        if (r23 == 2) goto L41;
        r24 = ReachRejectReason.CLIENT_EXCEPTION;
        goto L43
    L41:
        r24 = ReachRejectReason.REVOKED;
        goto L43
    L6:
        if (r9.d != r8) goto L8;
        boolean r27 = true;
    L9:
        if (r27 == true) goto L12;
        r9 = null;
    L12:
        if (r9 == null) goto L14;
        r1 = o(r9);     // Catch: Throwable -> L46
        goto L14
    L8:
        r27 = false;
    L46:
        th = move-exception;
        throw th;
    }

    public final boolean t(c r6, ReachBannerHost r7, long r8, String r10) {
        ns9.t r0 = r6.a;
        c r2 = null;
        boolean r3 = false;
        if (Intrinsics.areEqual(r10, "legacy_activity_dialog_dismissing") == true) goto L39;
        ns9.v r1 = r0.b;
        if ((r1 instanceof ns9.w) == false) goto L8;
        ns9.w r4 = (ns9.w) r1;
    L9:
        if (r4 != null) goto L11;
        boolean r11 = false;
    L41:
        if (r11 == true) goto L43;
        return false;
    L43:
        monitor-enter(this);
        c r12 = this.g.get(r6.a.a.h);     // Catch: Throwable -> L65
        if (r12 == null) goto L57;
        if (r12 == r6) goto L48;
    L50:
        boolean r9 = false;
    L51:
        if (r9 == true) goto L54;
        r12 = null;
    L54:
        if (r12 == null) goto L57;
        r12.g = r7;     // Catch: Throwable -> L65
        r12.a(EntryState.WAITING_HOST);     // Catch: Throwable -> L65
        r2 = r12;
        goto L57
    L48:
        if (r12.f != EntryState.CHECKING) goto L50;
        r9 = true;
    L57:
        if (r2 == null) goto L59;
        r3 = true;
    L59:
        monitor-exit(this);
        if (r3 == false) goto L64;
        int r13 = v.a;
        if (v.a(r8, new ReachBannerRuntime$waitDisplayUnavailableIfNeeded$registered$1(this)) == true) goto L64;
        l();
    L64:
        return r3;
    L65:
        th = move-exception;
        throw th;
    L11:
        if (r10 != null) goto L13;
    L37:
        boolean r14 = false;
    L38:
        if (r14 == true) goto L39;
        r11 = !StringsKt.equals(r4.c, "discard", true);
        goto L41
    L13:
        switch(r10.hashCode()) {
            case -2102071058: goto L34;
            case -1807286182: goto L31;
            case -1069127566: goto L28;
            case -992605017: goto L25;
            case -672605360: goto L22;
            case 1272387642: goto L19;
            case 2127802908: goto L16;
            default: goto L37;
        };
    L16:
        if (r10.equals("message_spacer_not_ready") == false) goto L37;
    L36:
        r14 = true;
        goto L38
    L19:
        if (r10.equals("banner_measurement_unavailable") == true) goto L36;
    L22:
        if (r10.equals("target_page_container_unavailable") == true) goto L36;
    L25:
        if (r10.equals("target_page_anchor_root_detached") == true) goto L36;
    L28:
        if (r10.equals("target_page_container_detached") == true) goto L36;
    L31:
        if (r10.equals("bottom_anchor_unavailable") == true) goto L36;
    L34:
        if (r10.equals("target_conversation_host_not_ready") == true) goto L36;
    L8:
        r4 = null;
    L39:
        r11 = true;
        goto L41
    }

    public static void p(ReachBannerRuntime r4, String r5, ReachCloseReason r6, Long r7, Long r8, boolean r9, int r10) {
        if ((r10 & 4) == 0) goto L6;
        r7 = null;
    L6:
        if ((r10 & 8) == 0) goto L9;
        r8 = null;
    L9:
        if ((r10 & 16) == 0) goto L11;
        r9 = false;
    L11:
        monitor-enter(r4);
        c r11 = r4.g.get(r5);     // Catch: Throwable -> L46
        if (r11 != null) goto L16;
        monitor-exit(r4);
        return;
    L16:
        if (r7 != null) goto L19;
    L22:
        if (r8 == null) goto L29;
        if (r11.m == r8.longValue()) goto L29;
        monitor-exit(r4);
        return;
    L29:
        if (r6 != ReachCloseReason.AUTO_DISMISS) goto L35;
        if (r9 == true) goto L35;
        if (r11.k == true) goto L35;
        monitor-exit(r4);
        return;
    L35:
        EntryState r12 = r11.f;     // Catch: Throwable -> L46
        EntryState r13 = EntryState.DISMISSING;     // Catch: Throwable -> L46
        if (r12 != r13) goto L40;
        monitor-exit(r4);
        return;
    L40:
        if (r12.isPresented() == false) goto L42;
        r11.a(r13);     // Catch: Throwable -> L46
        a r14 = new a.b(r11, r6);     // Catch: Throwable -> L46
    L43:
        monitor-exit(r4);
        r4.g(r14);
        return;
    L42:
        r4.o(r11);     // Catch: Throwable -> L46
        r14 = new a.c(r11, ReachRejectReason.CLIENT_EXCEPTION);     // Catch: Throwable -> L46
        goto L43
    L19:
        if (r11.d == r7.longValue()) goto L22;
        monitor-exit(r4);
        return;
    L46:
        th = move-exception;
        throw th;
    }
}
