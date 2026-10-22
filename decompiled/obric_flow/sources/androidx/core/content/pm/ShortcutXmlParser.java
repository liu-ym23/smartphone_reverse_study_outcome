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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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

    private static String getAttributeValue(XmlPullParser r5, String r10) {
        String r11 = r5.getAttributeValue("http://schemas.android.com/apk/res/android", r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return r5.getAttributeValue(null, r10);
    }

    @NonNull
    @WorkerThread
    public static List<String> getShortcutIds(@NonNull Context r5) {
        if (sShortcutIds != null) goto L16;
        Object r10 = GET_INSTANCE_LOCK;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sShortcutIds != null) goto L11;
        sShortcutIds = new ArrayList();     // Catch: Throwable -> L9
        sShortcutIds.addAll(parseShortcutIds(r5));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return sShortcutIds;
    }

    @NonNull
    private static XmlResourceParser getXmlResourceParser(Context r5, ActivityInfo r10) {
        XmlResourceParser r11 = r10.loadXmlMetaData(r5.getPackageManager(), META_DATA_APP_SHORTCUTS);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + r10.name);
    }

    @NonNull
    private static Set<String> parseShortcutIds(@NonNull Context r5) {
        HashSet r10 = new HashSet();
        Intent r11 = new Intent("android.intent.action.MAIN");
        r11.addCategory("android.intent.category.LAUNCHER");
        r11.setPackage(r5.getPackageName());
        List<ResolveInfo> r12 = r5.getPackageManager().queryIntentActivities(r11, 128);
        if (r12 != null) goto L5;
    L29:
        return r10;
    L5:
        if (r12.size() == 0) goto L29;
        Iterator<ResolveInfo> r13 = r12.iterator();     // Catch: Exception -> L19
    L9:
        if (r13.hasNext() == false) goto L29;
        ActivityInfo r14 = r13.next().activityInfo;     // Catch: Exception -> L19
        Bundle r15 = r14.metaData;     // Catch: Exception -> L19
        if (r15 == null) goto L9;
        if (r15.containsKey(META_DATA_APP_SHORTCUTS) == false) goto L9;
        XmlResourceParser r16 = getXmlResourceParser(r5, r14);     // Catch: Exception -> L19
        r10.addAll(parseShortcutIds(r16));     // Catch: Throwable -> L21
        if (r16 == null) goto L9;
        r16.close();     // Catch: Exception -> L19
        goto L9
    L21:
        th = move-exception;
        if (r16 != null) goto L30;
    L27:
        throw th;     // Catch: Exception -> L19
    L30:
        r16.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Log.e(TAG, "Failed to parse the Xml resource: ", e);
        goto L29
    }

    @NonNull
    @VisibleForTesting
    public static List<String> parseShortcutIds(@NonNull XmlPullParser r10) throws IOException, XmlPullParserException {
        ArrayList r5 = new ArrayList(1);
    L3:
        int r11 = r10.next();
        if (r11 == 1) goto L18;
        if (r11 == 3) goto L8;
    L9:
        int r12 = r10.getDepth();
        String r13 = r10.getName();
        if (r11 != 2) goto L3;
        if (r12 != 2) goto L3;
        if (TAG_SHORTCUT.equals(r13) == false) goto L3;
        String r14 = getAttributeValue(r10, ATTR_SHORTCUT_ID);
        if (r14 == null) goto L3;
        r5.add(r14);
        goto L3
    L8:
        if (r10.getDepth() > 0) goto L9;
    L18:
        return r5;
    }
}
