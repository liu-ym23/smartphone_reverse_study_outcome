package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShortcutXmlParser {
    private static final String ATTR_SHORTCUT_ID = "shortcutId";
    private static final Object GET_INSTANCE_LOCK = null;
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    private static final String TAG = "ShortcutXmlParser";
    private static final String TAG_SHORTCUT = "shortcut";
    private static volatile ArrayList<String> sShortcutIds;

    static {
        GET_INSTANCE_LOCK = new Object();
    }

    private ShortcutXmlParser() {
    }

    private static String getAttributeValue(XmlPullParser r10, String r11) {
        String r12 = r10.getAttributeValue("http://schemas.android.com/apk/res/android", r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r10.getAttributeValue(null, r11);
    }

    @NonNull
    @WorkerThread
    public static List<String> getShortcutIds(@NonNull Context r10) {
        if (sShortcutIds != null) goto L15;
        Object r11 = GET_INSTANCE_LOCK;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sShortcutIds != null) goto L9;
        sShortcutIds = new ArrayList();     // Catch: Throwable -> L11
        sShortcutIds.addAll(parseShortcutIds(r10));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L15:
        return sShortcutIds;
    }

    @NonNull
    private static XmlResourceParser getXmlResourceParser(Context r10, ActivityInfo r11) {
        XmlResourceParser r12 = r11.loadXmlMetaData(r10.getPackageManager(), META_DATA_APP_SHORTCUTS);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + r11.name);
    }

    @NonNull
    @VisibleForTesting
    public static List<String> parseShortcutIds(@NonNull XmlPullParser r10) {
        ArrayList r11 = new ArrayList(1);
    L3:
        int r12 = r10.next();
        if (r12 == 1) goto L18;
        if (r12 == 3) goto L8;
    L9:
        int r13 = r10.getDepth();
        String r14 = r10.getName();
        if (r12 != 2) goto L3;
        if (r13 != 2) goto L3;
        if (TAG_SHORTCUT.equals(r14) == false) goto L3;
        String r15 = getAttributeValue(r10, ATTR_SHORTCUT_ID);
        if (r15 == null) goto L3;
        r11.add(r15);
        goto L3
    L8:
        if (r10.getDepth() > 0) goto L9;
    L18:
        return r11;
    }

    @NonNull
    private static Set<String> parseShortcutIds(@NonNull Context r10) {
        HashSet r11 = new HashSet();
        Intent r12 = new Intent("android.intent.action.MAIN");
        r12.addCategory("android.intent.category.LAUNCHER");
        r12.setPackage(r10.getPackageName());
        List<ResolveInfo> r13 = r10.getPackageManager().queryIntentActivities(r12, 128);
        if (r13 != null) goto L5;
    L28:
        return r11;
    L5:
        if (r13.size() == 0) goto L28;
        Iterator<ResolveInfo> r14 = r13.iterator();     // Catch: Exception -> L26
    L9:
        if (r14.hasNext() == false) goto L28;
        ActivityInfo r15 = r14.next().activityInfo;     // Catch: Exception -> L26
        Bundle r16 = r15.metaData;     // Catch: Exception -> L26
        if (r16 == null) goto L9;
        if (r16.containsKey(META_DATA_APP_SHORTCUTS) == false) goto L9;
        XmlResourceParser r17 = getXmlResourceParser(r10, r15);     // Catch: Exception -> L26
        r11.addAll(parseShortcutIds(r17));     // Catch: Throwable -> L19
        if (r17 == null) goto L9;
        r17.close();     // Catch: Exception -> L26
        goto L9
    L19:
        th = move-exception;
        if (r17 != null) goto L29;
    L25:
        throw th;     // Catch: Exception -> L26
    L29:
        r17.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Failed to parse the Xml resource: ", e);
        goto L28
    }
}
