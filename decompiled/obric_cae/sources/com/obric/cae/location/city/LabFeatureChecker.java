package com.obric.cae.location.city;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes.dex */
public final class LabFeatureChecker {
    private static final int STATUS_ENABLED = 1;
    private static final String TAG = "StarLocation-Lab";
    private static final Uri URI_AI_PROACTIVE_AGENT = null;

    static {
        URI_AI_PROACTIVE_AGENT = Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent");
    }

    private LabFeatureChecker() {
    }

    public static boolean isProactiveAgentEnabled(Context r10) {
        if (r10 != null) goto L38;
        return false;
    L38:
        Cursor r11 = r10.getContentResolver().query(URI_AI_PROACTIVE_AGENT, null, null, null, null);     // Catch: Exception -> L31
        if (r11 != null) goto L34;
        if (r11 == null) goto L9;
        r11.close();     // Catch: Exception -> L31
    L9:
        return false;
    L34:
    L25:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Exception -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31
        goto L30
    L11:
        if (r11.moveToFirst() == true) goto L14;
        r11.close();     // Catch: Exception -> L31
        return false;
    L14:
        int r8 = r11.getColumnIndex("status");     // Catch: Throwable -> L25
        if (r8 >= 0) goto L18;
        r11.close();     // Catch: Exception -> L31
        return false;
    L18:
        boolean r12 = true;
        if (r11.getInt(r8) == 1) goto L22;
        r12 = false;
    L22:
        CommSenseLog.i(TAG, "isProactiveAgentEnabled: " + r12);     // Catch: Throwable -> L25
        r11.close();     // Catch: Exception -> L31
        return r12;
    L31:
        e = move-exception;
        CommSenseLog.w(TAG, "isProactiveAgentEnabled failed: " + e.getMessage());
        return false;
    }

    public static void registerProactiveAgentObserver(Context r8, ContentObserver r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L13;
        r8.getContentResolver().registerContentObserver(URI_AI_PROACTIVE_AGENT, false, r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CommSenseLog.w(TAG, "registerProactiveAgentObserver failed: " + e.getMessage());
        return;
    L13:
        return;
    }

    public static void unregisterProactiveAgentObserver(Context r8, ContentObserver r10) {
        if (r8 == null) goto L10;
        if (r10 == null) goto L11;
        r8.getContentResolver().unregisterContentObserver(r10);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L11:
        return;
    }
}
