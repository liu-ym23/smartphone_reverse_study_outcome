package com.obric.cae.cldReport.logcat;

import android.aimedia.a;
import android.content.Context;
import android.provider.Settings;
import com.google.protobuf.d;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class LogcatLogLevelConfig extends AbstractLogLevelConfig {
    public static final Set<Integer> ALL_LOG_MASKS = null;
    public static final int LOGCAT_DEBUG_LOG_MASK = 1;
    private static final String LOGCAT_ORI_LOG_LEVEL = "logcat_ori_log_level";
    public static final int LOGCAT_VERBOSE_LOG_MASK = 2;
    private static final String TAG = "LogcatLogLevelConfig";
    private final Context mContext;
    private final ConcurrentHashMap<Integer, AtomicInteger> mLogMaskCounterMap;
    private String mLogcatLevelOri;

    static {
        HashSet r8 = new HashSet();
        r8.add(1);
        r8.add(2);
        ALL_LOG_MASKS = Collections.unmodifiableSet(r8);
    }

    public LogcatLogLevelConfig(Context r8) {
        super(r8);
        this.mLogcatLevelOri = "I";
        ConcurrentHashMap<Integer, AtomicInteger> r10 = new ConcurrentHashMap();
        this.mLogMaskCounterMap = r10;
        this.mContext = r8;
        r10.clear();
        setup();
    }

    public static /* synthetic */ AtomicInteger a(Integer r8) {
        return lambda$logLevelIncrement$0(r8);
    }

    private static /* synthetic */ AtomicInteger lambda$logLevelIncrement$0(Integer r8) {
        return new AtomicInteger(0);
    }

    private void setCldLogcatLogLevel(int r8, boolean r10) {
        if (r8 != 1) goto L5;
        setLogcatDebugLog(r10);
        return;
    L5:
        if (r8 == 2) goto L8;
        CaeLog.e(TAG, "unknown log level");
        return;
    L8:
        setLogcatVerboseLog(r10);
    }

    private void setLogcatDebugLog(boolean r8) {
        String r10 = TAG;
        a.r(a.l("setLogcatDebugLog: enable=", r8, ", mLogcatLevelOri="), this.mLogcatLevelOri, r10);
        if (r8 == true) goto L5;
        CldUtil.setProperty("persist.log.tag", this.mLogcatLevelOri);
        return;
    L5:
        if (this.mLogcatLevelOri.equals("D") == false) goto L7;
        return;
    L7:
        if (this.mLogcatLevelOri.equals("V") == false) goto L9;
        return;
    L9:
        if (this.mLogcatLevelOri.isEmpty() == true) goto L16;
        CldUtil.setProperty("persist.log.tag", "D");
        return;
    }

    private void setLogcatVerboseLog(boolean r8) {
        String r10 = TAG;
        a.r(a.l("setLogcatVerboseLog: enable=", r8, ", mLogcatLevelOri="), this.mLogcatLevelOri, r10);
        if (r8 == true) goto L5;
        CldUtil.setProperty("persist.log.tag", this.mLogcatLevelOri);
        return;
    L5:
        if (this.mLogcatLevelOri.equals("V") == false) goto L7;
        return;
    L7:
        if (this.mLogcatLevelOri.isEmpty() == true) goto L13;
        CldUtil.setProperty("persist.log.tag", "V");
        return;
    }

    private void setup() {
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), LOGCAT_ORI_LOG_LEVEL);
        if (r8 != null) goto L5;
        r8 = CldUtil.getProperty("persist.log.tag", "");
        this.mLogcatLevelOri = r8;
        Settings.Global.putString(this.mContext.getContentResolver(), LOGCAT_ORI_LOG_LEVEL, r8);
    L6:
        String r10 = TAG;
        a.r(b.h("setup logLevel=", r8, ", mLogcatLevelOri="), this.mLogcatLevelOri, r10);
        return;
    L5:
        this.mLogcatLevelOri = r8;
        goto L6
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelDecrement(int r8, boolean r10) {
        Iterator<Integer> r11 = ALL_LOG_MASKS.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        int r12 = r11.next().intValue();
        if ((r8 & r12) == 0) goto L4;
        AtomicInteger r13 = this.mLogMaskCounterMap.get(Integer.valueOf(r12));
        if (r13 == null) goto L9;
        if (r10 == false) goto L13;
        int r14 = r13.decrementAndGet();
    L14:
        if (r14 != 0) goto L16;
        setCldLogcatLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(5), r12);
    L16:
        if (r14 >= 0) goto L4;
        CaeLog.e(TAG, "logLevelDecrement: counterValue < 0");
        goto L4
    L13:
        r14 = r13.get();
        goto L14
    L9:
        setCldLogcatLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(5), r12);
        return;
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelIncrement(int r8, int r10, boolean r11) {
        Iterator<Integer> r12 = ALL_LOG_MASKS.iterator();
    L4:
        if (r12.hasNext() == false) goto L19;
        int r13 = r12.next().intValue();
        if ((r8 & r13) == 0) goto L4;
        AtomicInteger r14 = this.mLogMaskCounterMap.computeIfAbsent(Integer.valueOf(r13), new d(3));
        if (r11 == false) goto L10;
        int r15 = r14.incrementAndGet();
    L12:
        if (r15 == 0) goto L13;
        if (r15 != 1) goto L18;
        setCldLogcatLogLevel(r13, true);
        insertLogLevDb(CldCommon.CldModuleToString(5), r13, r10);
    L18:
        updateLogLevDb(CldCommon.CldModuleToString(5), r13, r10);
        goto L4
    L13:
        setCldLogcatLogLevel(r13, true);
        return;
    L10:
        r15 = r14.get();
        goto L12
    }
}
