package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "", "None", "ShowAllFallback", "OpenDetail", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$None;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$OpenDetail;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$ShowAllFallback;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ae {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$None;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6604a = null;

        static {
            f6604a = new a();
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
            return -1268665268;
        }

        public String toString() {
            return "None";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$OpenDetail;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "inspirationId", "", "<init>", "(Ljava/lang/String;)V", "getInspirationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6605a;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "inspirationId");
            this.f6605a = r2;
        }

        public final String a() {
            return this.f6605a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6605a, r6.f6605a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6605a.hashCode();
        }

        public String toString() {
            return "OpenDetail(inspirationId=" + this.f6605a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision$ShowAllFallback;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6606a = null;

        static {
            f6606a = new c();
        }

        private c() {
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
            return false;
        L9:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return 1315051218;
        }

        public String toString() {
            return "ShowAllFallback";
        }
    }
}
