package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        SerialExecutor(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            this.mLock = new Object();
            this.mTasks = new ArrayDeque();
            this.mExecutor = r4;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mTasks.add(new $$Lambda$AppLocalesStorageHelper$SerialExecutor$VQIUCyuFJVaYXOOy5lMhu8dTj68(this, r5));     // Catch: Throwable -> L9
            if (this.mActive != null) goto L7;
            scheduleNext();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ void lambda$execute$0$AppLocalesStorageHelper$SerialExecutor(Runnable r3) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")).run();     // Catch: Throwable -> L6
            scheduleNext();
            return;
        L6:
            th = move-exception;
            scheduleNext();
            throw th;
        }

        public void scheduleNext() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.mTasks.poll(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            this.mActive = r1;     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            this.mExecutor.execute(r1);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
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
        public void execute(Runnable r2) {
            new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    static void persistLocales(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r7.equals("") == false) goto L34;
        r8.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
        return;
    L34:
        FileOutputStream r9 = r8.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r3 = Xml.newSerializer();
        r3.setOutput(r9, null);     // Catch: Throwable -> L13 Exception -> L15
        r3.startDocument(RpcUtils.CHARSET_UTF8, true);     // Catch: Throwable -> L13 Exception -> L15
        r3.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r3.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r7);     // Catch: Throwable -> L13 Exception -> L15
        r3.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r3.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d(TAG, "Storing App Locales : app-locales: " + r7 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r9 != null) goto L32;
    L27:
        return;
    L32:
        r9.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r9 != null) goto L30;
    L22:
        throw th;
    L30:
        r9.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales: " + r7, e);     // Catch: Throwable -> L13
        if (r9 == null) goto L27;
    L23:
        Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{APPLICATION_LOCALES_RECORD_FILE}));
    }

    static String readLocales(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r2 = "";
        FileInputStream r3 = r10.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L34
        XmlPullParser r4 = Xml.newPullParser();     // Catch: Throwable -> L21 Throwable -> L23
        r4.setInput(r3, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L21 Throwable -> L23
        int r5 = r4.getDepth();     // Catch: Throwable -> L21 Throwable -> L23
    L5:
        int r6 = r4.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (r6 == 1) goto L18;
        if (r6 == 3) goto L10;
    L11:
        if (r6 == 3) goto L5;
        if (r6 == 4) goto L5;
        if (r4.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L5;
        r2 = r4.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L21 Throwable -> L23
    L10:
        if (r4.getDepth() > r5) goto L11;
    L18:
        if (r3 == null) goto L27;
    L39:
        r3.close();     // Catch: IOException -> L36
    L27:
        if (r2.isEmpty() == true) goto L29;
        Log.d(TAG, "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r2);
    L30:
        return r2;
    L29:
        r10.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
    L21:
        th = move-exception;
        if (r3 != null) goto L44;
    L33:
        throw th;
    L44:
        r3.close();     // Catch: IOException -> L37
    L23:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L21
        if (r3 == null) goto L27;
    L34:
        Log.w(TAG, "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }

    static void syncLocalesToFramework(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r0 = new ComponentName(r5, APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME);
        if (r5.getPackageManager().getComponentEnabledSetting(r0) != 1) goto L7;
        return;
    L7:
        if (AppCompatDelegate.getApplicationLocales().isEmpty() == false) goto L11;
        String r1 = readLocales(r5);
        Object r3 = r5.getSystemService("locale");
        if (r3 == null) goto L11;
        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(r3, AppCompatDelegate.Api24Impl.localeListForLanguageTags(r1));
    L11:
        ZeusTransformUtils.setComponentEnabledSetting(r5.getPackageManager(), r0, 1, 1);
        return;
    }
}
