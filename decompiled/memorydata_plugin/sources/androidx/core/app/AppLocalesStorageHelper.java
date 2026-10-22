package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
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

    public static void persistLocales(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Object r0 = sAppLocaleStorageSync;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (r6.equals("") == false) goto L41;
        r7.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        return;
    L41:
        FileOutputStream r8 = r7.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L28 Throwable -> L31
        XmlSerializer r2 = Xml.newSerializer();     // Catch: Throwable -> L31
        r2.setOutput(r8, null);     // Catch: Throwable -> L17 Exception -> L19
        r2.startDocument(RpcUtils.CHARSET_UTF8, true);     // Catch: Throwable -> L17 Exception -> L19
        r2.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L17 Exception -> L19
        r2.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r6);     // Catch: Throwable -> L17 Exception -> L19
        r2.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L17 Exception -> L19
        r2.endDocument();     // Catch: Throwable -> L17 Exception -> L19
        if (r8 != null) goto L36;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return;
    L36:
        r8.close();     // Catch: IOException -> L34 Throwable -> L31
        goto L23
    L19:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e);     // Catch: Throwable -> L17
        if (r8 == null) goto L23;
    L17:
        th = move-exception;
        if (r8 != null) goto L43;
    L27:
        throw th;     // Catch: Throwable -> L31
    L43:
        r8.close();     // Catch: IOException -> L35 Throwable -> L31
        goto L27
    L28:
        Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{APPLICATION_LOCALES_RECORD_FILE}));     // Catch: Throwable -> L31
    }

    public static String readLocales(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Object r0 = sAppLocaleStorageSync;
        monitor-enter(r0);
        String r1 = "";
        FileInputStream r2 = r9.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L37 Throwable -> L39
        XmlPullParser r3 = Xml.newPullParser();     // Catch: Throwable -> L23 Throwable -> L25
        r3.setInput(r2, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L23 Throwable -> L25
        int r4 = r3.getDepth();     // Catch: Throwable -> L23 Throwable -> L25
    L7:
        int r5 = r3.next();     // Catch: Throwable -> L23 Throwable -> L25
        if (r5 == 1) goto L20;
        if (r5 == 3) goto L12;
    L13:
        if (r5 == 3) goto L7;
        if (r5 == 4) goto L7;
        if (r3.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L7;
        r1 = r3.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L23 Throwable -> L25
    L12:
        if (r3.getDepth() > r4) goto L13;
    L20:
        if (r2 == null) goto L29;
    L51:
        r2.close();     // Catch: IOException -> L42 Throwable -> L39
    L29:
        if (r1.isEmpty() == false) goto L32;
        r9.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L39
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r1;
    L25:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L23
        if (r2 == null) goto L29;
    L23:
        th = move-exception;
        if (r2 != null) goto L49;
    L36:
        throw th;     // Catch: Throwable -> L39
    L49:
        r2.close();     // Catch: IOException -> L43 Throwable -> L39
        goto L36
    L39:
        th = move-exception;
        throw th;
    L38:
        return "";
    }
}
