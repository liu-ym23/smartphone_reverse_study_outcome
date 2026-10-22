package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.Fragment;
import com.larus.project.create.CreateProjectPanelFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0012\u0013\u0014\u0015J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0011H&¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService;", "", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "selectedPcDeviceId", "", "config", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$PanelConfig;", "callback", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$Callback;", "showAddComputerGuide", "showFolderPanel", "pcDeviceId", "currentPage", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderPanelConfig;", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderCallback;", "PanelConfig", "FolderPanelConfig", "Callback", "FolderCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPcDevicePanelService {

    public interface a {
        void a();

        void b(be8.d r1);

        void c();
    }

    public interface b {
        void a();

        void b();

        void c(String r1, String r2);
    }

    public static final class c {
        public final boolean a;

        public c() {
            this(true);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "FolderPanelConfig(showDoNotUseFolder=" + this.a + ')';
        }

        public c(boolean r1) {
            this.a = r1;
        }
    }

    public static final class d {
        public final Integer a;
        public final Integer b;
        public final Integer c;
        public final boolean d;

        public d() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
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
            Integer r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (r6 + r1) * 31;
            if (this.d == false) goto L17;
            int r9 = 1231;
        L19:
            return r8 + r9;
        L17:
            r9 = 1237;
            goto L19
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PanelConfig(titleResId=" + this.a + ", navigationIconResId=" + this.b + ", bottomSheetCloseSizeDp=" + this.c + ", showCloudComputer=" + this.d + ')';
        }

        public /* synthetic */ d(int r2) {
            this(null, null, null, true);
        }

        public d(Integer r1, Integer r2, Integer r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    void a(Fragment r1, String r2, d r3, a r4);

    void b(CreateProjectPanelFragment r1, String r2, c r3, ls9.i r4);

    void c(Fragment r1);
}
