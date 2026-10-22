package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "", "Ignore", "RenderOnly", "ScrollToTop", "Restore", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$Ignore;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$RenderOnly;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$Restore;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$ScrollToTop;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ab {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$Ignore;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6598a = null;

        static {
            f6598a = new a();
        }

        private a() {
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
            return false;
        L9:
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -1867466899;
        }

        public String toString() {
            return "Ignore";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$RenderOnly;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6599a = null;

        static {
            f6599a = new b();
        }

        private b() {
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -464351619;
        }

        public String toString() {
            return "RenderOnly";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$Restore;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "anchor", "Lcom/obric/aiproactive/ui/entry/SensingEventsScrollAnchor;", "<init>", "(Lcom/obric/aiproactive/ui/entry/SensingEventsScrollAnchor;)V", "getAnchor", "()Lcom/obric/aiproactive/ui/entry/SensingEventsScrollAnchor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final aa f6600a;

        public c(aa r2) {
            Intrinsics.checkNotNullParameter(r2, "anchor");
            this.f6600a = r2;
        }

        public final aa a() {
            return this.f6600a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6600a, r6.f6600a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6600a.hashCode();
        }

        public String toString() {
            return "Restore(anchor=" + this.f6600a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision$ScrollToTop;", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6601a = null;

        static {
            f6601a = new d();
        }

        private d() {
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
            return false;
        L9:
            d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -2107321006;
        }

        public String toString() {
            return "ScrollToTop";
        }
    }
}
