package com.bytedance.android.alog;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class FileManager {
    private static final String FETCH_TIME_INVALID = "time interval is invalid";
    private static final String LOG_DIR_INVALID = "log dir not exists";
    private static final String LOG_FILE_NOT_FOUND = "log file not found";
    private static final String LOG_FILE_SUFFIX = ".alog.hot";
    private static final int SUFFIX_LEN = 9;
    private static long sFetchEndTs;
    private static String sFetchFailReason;
    private static long sFetchStartTs;
    private static ArrayList<String> sLastFetchFileLists;

    static {
    }

    FileManager() {
    }

    static HashMap<String, String> getLastErrorInfo() {
        HashMap<String, String> r10 = new HashMap();
        r10.put(CommonConsts.APM_INNER_EVENT_COST_START, Long.toString(sFetchStartTs));
        r10.put("end", Long.toString(sFetchEndTs));
        r10.put("reason", sFetchFailReason);
        if (sLastFetchFileLists == null) goto L12;
        StringBuilder r11 = new StringBuilder();
        Iterator<String> r12 = sLastFetchFileLists.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next();
        if (r13.endsWith(LOG_FILE_SUFFIX) == false) goto L10;
        r13 = r13.substring(0, r13.length() - SUFFIX_LEN);
    L10:
        r11.append(r13);
        r11.append(";");
        goto L6
    L11:
        r10.put("file", r11.toString());
    L12:
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        return r10;
    }

    static File[] getLogs(String r10, String r11, String r12, final long r13, final long r14) {
        sFetchStartTs = r13;
        sFetchEndTs = r14;
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        if (r13 <= r14) goto L7;
        String r15 = FETCH_TIME_INVALID;
    L5:
        sFetchFailReason = r15;
        return new File[0];
    L7:
        File r16 = new File(r10);
        if (r16.exists() == true) goto L10;
    L31:
        r15 = LOG_DIR_INVALID;
        goto L5
    L10:
        if (r16.isDirectory() == false) goto L31;
        if (TextUtils.isEmpty(r11) == true) goto L15;
        r11 = r11.replace(':', '-');
    L15:
        StringBuilder r17 = new StringBuilder();
        r17.append("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r18 = "\\S+";
        if (TextUtils.isEmpty(r11) == false) goto L18;
        String r19 = "\\S+";
    L19:
        r17.append(r19);
        r17.append("__");
        if (TextUtils.isEmpty(r12) == true) goto L23;
        r18 = Pattern.quote(r12);
    L23:
        r17.append(r18);
        r17.append("\\.alog\\.hot$");
        final Pattern r20 = Pattern.compile(r17.toString());
        final ArrayList<String> r21 = new ArrayList();
        File[] r110 = r16.listFiles(new AnonymousClass1(r21, r20, r14, r13));
        if (r110 != null) goto L26;
    L27:
        sFetchFailReason = LOG_FILE_NOT_FOUND;
        sLastFetchFileLists = r21;
    L28:
        if (r110 == null) goto L30;
        return r110;
    L30:
        return new File[0];
    L26:
        if (r110.length != 0) goto L28;
    L18:
        r19 = Pattern.quote(r11);
        goto L19
    }
}
