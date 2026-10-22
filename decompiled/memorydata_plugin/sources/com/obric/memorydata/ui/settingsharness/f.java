package com.obric.memorydata.ui.settingsharness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "", "Committed", "Rejected", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult$Committed;", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult$Rejected;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface f {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult$Committed;", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13037a = null;

        static {
            f13037a = new a();
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
            return -652016079;
        }

        public String toString() {
            return "Committed";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult$Rejected;", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "userMessage", "Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "<init>", "(Lcom/obric/memorydata/ui/settingsharness/SettingsText;)V", "getUserMessage", "()Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f13038a;

        public b(q r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "userMessage");
            this.f13038a = r4;
        }

        public final q a() {
            return this.f13038a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13038a, r6.f13038a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f13038a.hashCode();
        }

        public String toString() {
            return "Rejected(userMessage=" + this.f13038a + ')';
        }
    }
}
