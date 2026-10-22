package com.bytedance.crash.resource;

import com.bytedance.crash.resource.utils.LogPath;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ResourceMonitorConfig {
    protected static final int TYPE_FD = 2;
    protected static final int TYPE_GWP_ASAN = 0;
    protected static final int TYPE_HEAP_TRACK = 1;
    protected static final int TYPE_PRIO = 6;
    protected static final int TYPE_REF = 5;
    protected static final int TYPE_TLS = 4;
    protected static final int TYPE_VMM = 3;
    protected int mApiLevelMax;
    protected int mApiLevelMin;
    protected String mConfigName;
    protected String mGuardFileName;
    protected String mLibName;
    protected File mReportDir;
    protected int mResourceType;

    public ResourceMonitorConfig(int r10, int r11, int r12) {
        this.mGuardFileName = null;
        this.mLibName = null;
        this.mConfigName = null;
        this.mReportDir = null;
        this.mApiLevelMax = r11;
        this.mApiLevelMin = r10;
        this.mResourceType = r12;
    }

    private static String getConfigName(int r10) {
        if (r10 != 0) goto L4;
        return "xasan.config";
    L4:
        if (r10 != 1) goto L6;
        return "heap_track.config";
    L6:
        if (r10 != 2) goto L8;
        return "fd_track.config";
    L8:
        if (r10 != 3) goto L10;
        return "vmm.config";
    L10:
        if (r10 != 4) goto L12;
        return "tls_monitor.config";
    L12:
        if (r10 == 5) goto L15;
        return "unknown";
    L15:
        return "ref_monitor.config";
    }

    private static String getGuardFileName(int r10) {
        if (r10 != 0) goto L4;
        return "gwp_asan.guard";
    L4:
        if (r10 != 1) goto L6;
        return "heap_track.guard";
    L6:
        if (r10 != 2) goto L8;
        return "fd_track.guard";
    L8:
        if (r10 != 3) goto L10;
        return "vm_monitor.guard";
    L10:
        if (r10 != 4) goto L12;
        return "tls_monitor.guard";
    L12:
        if (r10 == 5) goto L15;
        return "unknown";
    L15:
        return "ref_monitor.guard";
    }

    private static String getLibName(int r10) {
        switch(r10) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "npth_setpriority";
    L7:
        return "npth_ref_monitor";
    L9:
        return "npth_tls_monitor";
    L11:
        return "npth_vm_monitor";
    L13:
        return "npth_fd_tracker";
    L15:
        return "npth_heap_tracker";
    L17:
        return "npth_xasan";
    }

    public static File getReportDir(int r10) {
        switch(r10) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return LogPath.getPriorityMonitorPath();
    L8:
        return LogPath.getRefMonitorPath();
    L10:
        return LogPath.getTLSMonitorPath();
    L12:
        return LogPath.getVmMonitorPath();
    L14:
        return LogPath.getFdTrackPath();
    L16:
        return LogPath.getNativeHeapTrackerPath();
    L18:
        return LogPath.getGwpAsanLogPath();
    }

    public String getConfigName() {
        if (this.mConfigName != null) goto L6;
        this.mConfigName = getConfigName(this.mResourceType);
    L6:
        return this.mConfigName;
    }

    public String getFullSoName() {
        return "lib" + getLibName() + ".so";
    }

    public String getGuardFileName() {
        if (this.mGuardFileName != null) goto L6;
        this.mGuardFileName = getGuardFileName(this.mResourceType);
    L6:
        return this.mGuardFileName;
    }

    public String getLibName() {
        if (this.mLibName != null) goto L6;
        this.mLibName = getLibName(this.mResourceType);
    L6:
        return this.mLibName;
    }

    public File getReportDir() {
        if (this.mReportDir != null) goto L6;
        this.mReportDir = getReportDir(this.mResourceType);
    L6:
        return this.mReportDir;
    }

    public int getResourceType() {
        return this.mResourceType;
    }

    public int getmApiLevelMax() {
        return this.mApiLevelMax;
    }

    public int getmApiLevelMin() {
        return this.mApiLevelMin;
    }

    public String toString() {
        return "";
    }
}
