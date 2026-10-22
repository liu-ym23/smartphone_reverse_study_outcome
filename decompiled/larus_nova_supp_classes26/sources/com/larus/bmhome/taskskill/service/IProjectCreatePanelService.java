package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService;", "", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "enterMethod", "", "callback", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$Callback;", "", "config", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$PanelConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observePanelResult", "resultKey", "PanelConfig", "Callback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IProjectCreatePanelService {

    public interface a {
        void a(boolean r1);

        void b(com.larus.bmhome.taskskill.service.a r1);

        void c();

        void d(boolean r1);
    }

    public static final class b {
        public final String a;
        public final boolean b;

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
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "PanelConfig(resultKey=" + this.a + ", autoLaunchDevicePicker=" + this.b + ')';
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "resultKey");
            this.a = r2;
            this.b = r3;
        }
    }

    boolean a(Fragment r1, b r2, LifecycleOwner r3, String r4, a r5);

    void b(Fragment r1, LifecycleOwner r2, String r3, String r4, a r5);

    void c(Fragment r1, String r2, a r3);
}
