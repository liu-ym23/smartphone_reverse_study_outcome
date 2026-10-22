package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = null;

    static {
        sAppLocaleStorageSync = new Object();
    }

    private AppLocalesStorageHelper() {
    }

    public static void persistLocales(@NonNull Context r5, @NonNull String r10) {
        Object r11 = sAppLocaleStorageSync;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r10.equals("") == false) goto L44;
        r5.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L44:
        FileOutputStream r12 = r5.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: Throwable -> L9 FileNotFoundException -> L29
        XmlSerializer r13 = Xml.newSerializer();     // Catch: Throwable -> L9
        r13.setOutput(r12, null);     // Catch: Throwable -> L18 Exception -> L20
        r13.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L18 Exception -> L20
        r13.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L18 Exception -> L20
        r13.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r10);     // Catch: Throwable -> L18 Exception -> L20
        r13.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L18 Exception -> L20
        r13.endDocument();     // Catch: Throwable -> L18 Exception -> L20
        if (r12 != null) goto L42;
    L36:
    L24:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L42:
        r12.close();     // Catch: Throwable -> L9 IOException -> L34
    L18:
        th = move-exception;
        if (r12 != null) goto L40;
    L28:
        throw th;     // Catch: Throwable -> L9
    L40:
        r12.close();     // Catch: Throwable -> L9 IOException -> L35
    L20:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e);     // Catch: Throwable -> L18
        if (r12 == null) goto L36;
    L29:
        Log.w(TAG, "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");     // Catch: Throwable -> L9
    }

    @NonNull
    public static String readLocales(@NonNull Context r10) {
        Object r5 = sAppLocaleStorageSync;
        monitor-enter(r5);
        String r11 = "";
        FileInputStream r12 = r10.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L26 FileNotFoundException -> L40
        XmlPullParser r13 = Xml.newPullParser();     // Catch: Throwable -> L14 Throwable -> L28
        r13.setInput(r12, "UTF-8");     // Catch: Throwable -> L14 Throwable -> L28
        int r14 = r13.getDepth();     // Catch: Throwable -> L14 Throwable -> L28
    L7:
        int r15 = r13.next();     // Catch: Throwable -> L14 Throwable -> L28
        if (r15 == 1) goto L23;
        if (r15 == 3) goto L12;
    L16:
        if (r15 == 3) goto L7;
        if (r15 == 4) goto L7;
        if (r13.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L7;
        r11 = r13.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L14 Throwable -> L28
    L12:
        if (r13.getDepth() > r14) goto L16;
    L23:
        if (r12 == null) goto L32;
    L48:
        r12.close();     // Catch: Throwable -> L26 IOException -> L44
    L32:
        if (r11.isEmpty() == false) goto L35;
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L26
    L35:
        monitor-exit(r5);     // Catch: Throwable -> L26
        return r11;
    L14:
        th = move-exception;
        if (r12 != null) goto L46;
    L39:
        throw th;     // Catch: Throwable -> L26
    L46:
        r12.close();     // Catch: Throwable -> L26 IOException -> L45
    L28:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L14
        if (r12 == null) goto L32;
    L26:
        th = move-exception;
        throw th;
    L41:
        return "";
    }
}
