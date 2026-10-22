package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final String APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME = "androidx.appcompat.app.AppLocalesMetadataHolderService";
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";

    public static class SerialExecutor implements Executor {
        Runnable mActive;
        final Executor mExecutor;
        private final Object mLock;
        final Queue<Runnable> mTasks;

        public SerialExecutor(Executor r5) {
            this.mLock = new Object();
            this.mTasks = new ArrayDeque();
            this.mExecutor = r5;
        }

        public static /* synthetic */ void a(SerialExecutor r5, Runnable r10) {
            r5.lambda$execute$0(r10);
        }

        private /* synthetic */ void lambda$execute$0(Runnable r5) {
            r5.run();     // Catch: Throwable -> L5
            scheduleNext();
            return;
        L5:
            th = move-exception;
            scheduleNext();
            throw th;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
            this.mTasks.add(new d(this, r5));     // Catch: Throwable -> L7
            if (this.mActive != null) goto L9;
            scheduleNext();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void scheduleNext() {
            Object r5 = this.mLock;
            monitor-enter(r5);
            Runnable r10 = this.mTasks.poll();     // Catch: Throwable -> L7
            this.mActive = r10;     // Catch: Throwable -> L7
            if (r10 == null) goto L9;
            this.mExecutor.execute(r10);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r5);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class ThreadPerTaskExecutor implements Executor {
        public ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r5) {
            new Thread(r5).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    public static void persistLocales(@NonNull Context r10, @NonNull String r11) {
        if (r11.equals("") == false) goto L34;
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
        return;
    L34:
        FileOutputStream r12 = r10.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r5 = Xml.newSerializer();
        r5.setOutput(r12, null);     // Catch: Throwable -> L13 Exception -> L15
        r5.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 Exception -> L15
        r5.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r5.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r11);     // Catch: Throwable -> L13 Exception -> L15
        r5.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r5.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d(TAG, "Storing App Locales : app-locales: " + r11 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r12 != null) goto L32;
    L27:
        return;
    L32:
        r12.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r12 != null) goto L30;
    L22:
        throw th;
    L30:
        r12.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales: ".concat(r11), e);     // Catch: Throwable -> L13
        if (r12 == null) goto L27;
    L23:
        Log.w(TAG, "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
    }

    @NonNull
    public static String readLocales(@NonNull Context r10) {
        String r5 = "";
        FileInputStream r11 = r10.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L35
        XmlPullParser r12 = Xml.newPullParser();     // Catch: Throwable -> L12 Throwable -> L24
        r12.setInput(r11, "UTF-8");     // Catch: Throwable -> L12 Throwable -> L24
        int r13 = r12.getDepth();     // Catch: Throwable -> L12 Throwable -> L24
    L5:
        int r14 = r12.next();     // Catch: Throwable -> L12 Throwable -> L24
        if (r14 == 1) goto L21;
        if (r14 == 3) goto L10;
    L14:
        if (r14 == 3) goto L5;
        if (r14 == 4) goto L5;
        if (r12.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L5;
        r5 = r12.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L12 Throwable -> L24
    L10:
        if (r12.getDepth() > r13) goto L14;
    L21:
        if (r11 == null) goto L28;
    L43:
        r11.close();     // Catch: IOException -> L37
    L28:
        if (r5.isEmpty() == true) goto L30;
        Log.d(TAG, "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(r5));
    L31:
        return r5;
    L30:
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
    L24:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L12
        if (r11 == null) goto L28;
    L12:
        th = move-exception;
        if (r11 != null) goto L39;
    L34:
        throw th;
    L39:
        r11.close();     // Catch: IOException -> L38
    L35:
        Log.w(TAG, "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }

    public static void syncLocalesToFramework(Context r5) {
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r10 = new ComponentName(r5, APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME);
        if (r5.getPackageManager().getComponentEnabledSetting(r10) != 1) goto L7;
        return;
    L7:
        if (AppCompatDelegate.getApplicationLocales().isEmpty() == false) goto L11;
        String r11 = readLocales(r5);
        Object r12 = r5.getSystemService("locale");
        if (r12 == null) goto L11;
        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(r12, AppCompatDelegate.Api24Impl.localeListForLanguageTags(r11));
    L11:
        r5.getPackageManager().setComponentEnabledSetting(r10, 1, 1);
        return;
    }
}
