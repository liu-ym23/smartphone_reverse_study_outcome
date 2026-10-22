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

    static class SerialExecutor implements Executor {
        Runnable mActive;
        final Executor mExecutor;
        private final Object mLock;
        final Queue<Runnable> mTasks;

        SerialExecutor(Executor r10) {
            this.mLock = new Object();
            this.mTasks = new ArrayDeque();
            this.mExecutor = r10;
        }

        public static /* synthetic */ void a(SerialExecutor r10, Runnable r11) {
            r10.lambda$execute$0(r11);
        }

        private /* synthetic */ void lambda$execute$0(Runnable r10) {
            r10.run();     // Catch: Throwable -> L5
            scheduleNext();
            return;
        L5:
            th = move-exception;
            scheduleNext();
            throw th;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mTasks.add(new e(this, r10));     // Catch: Throwable -> L9
            if (this.mActive != null) goto L7;
            scheduleNext();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r11);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        protected void scheduleNext() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            Runnable r11 = this.mTasks.poll();     // Catch: Throwable -> L9
            this.mActive = r11;     // Catch: Throwable -> L9
            if (r11 == null) goto L7;
            this.mExecutor.execute(r11);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            new Thread(r10).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    static void persistLocales(@NonNull Context r10, @NonNull String r11) {
        if (r11.equals("") == false) goto L30;
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
        return;
    L30:
        FileOutputStream r12 = r10.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r13 = Xml.newSerializer();
        r13.setOutput(r12, null);     // Catch: Throwable -> L13 Exception -> L15
        r13.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 Exception -> L15
        r13.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r13.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r11);     // Catch: Throwable -> L13 Exception -> L15
        r13.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r13.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d(TAG, "Storing App Locales : app-locales: " + r11 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r12 != null) goto L35;
    L27:
        return;
    L35:
        r12.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r12 != null) goto L32;
    L22:
        throw th;
    L32:
        r12.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales: " + r11, e);     // Catch: Throwable -> L13
        if (r12 == null) goto L27;
    L23:
        Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{APPLICATION_LOCALES_RECORD_FILE}));
    }

    @NonNull
    static String readLocales(@NonNull Context r10) {
        String r11 = "";
        FileInputStream r12 = r10.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L34
        XmlPullParser r13 = Xml.newPullParser();     // Catch: Throwable -> L21 Throwable -> L23
        r13.setInput(r12, "UTF-8");     // Catch: Throwable -> L21 Throwable -> L23
        int r14 = r13.getDepth();     // Catch: Throwable -> L21 Throwable -> L23
    L5:
        int r15 = r13.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (r15 == 1) goto L18;
        if (r15 == 3) goto L10;
    L11:
        if (r15 == 3) goto L5;
        if (r15 == 4) goto L5;
        if (r13.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L5;
        r11 = r13.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L21 Throwable -> L23
    L10:
        if (r13.getDepth() > r14) goto L11;
    L18:
        if (r12 == null) goto L27;
    L44:
        r12.close();     // Catch: IOException -> L36
    L27:
        if (r11.isEmpty() == true) goto L29;
        Log.d(TAG, "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r11);
    L30:
        return r11;
    L29:
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
    L23:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L21
        if (r12 == null) goto L27;
    L34:
        Log.w(TAG, "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    L21:
        th = move-exception;
        if (r12 != null) goto L40;
    L33:
        throw th;
    L40:
        r12.close();     // Catch: IOException -> L37
        goto L33
    }

    static void syncLocalesToFramework(Context r10) {
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r11 = new ComponentName(r10, APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME);
        if (r10.getPackageManager().getComponentEnabledSetting(r11) != 1) goto L7;
        return;
    L7:
        if (AppCompatDelegate.getApplicationLocales().isEmpty() == false) goto L11;
        String r12 = readLocales(r10);
        Object r13 = r10.getSystemService("locale");
        if (r13 == null) goto L11;
        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(r13, AppCompatDelegate.Api24Impl.localeListForLanguageTags(r12));
    L11:
        r10.getPackageManager().setComponentEnabledSetting(r11, 1, 1);
        return;
    }
}
