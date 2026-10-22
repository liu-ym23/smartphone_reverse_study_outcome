package androidx.appcompat.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayDeque f679b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Executor f680m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Runnable f681n;

        public a(b r8) {
            this.f678a = new Object();
            this.f679b = new ArrayDeque();
            this.f680m = r8;
        }

        public final void a() {
            Object r8 = this.f678a;
            monitor-enter(r8);
            Runnable r10 = (Runnable) this.f679b.poll();     // Catch: Throwable -> L9
            this.f681n = r10;     // Catch: Throwable -> L9
            if (r10 == null) goto L7;
            this.f680m.execute(r10);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r8);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r8) {
            Object r10 = this.f678a;
            monitor-enter(r10);
            this.f679b.add(new r(0, this, r8));     // Catch: Throwable -> L9
            if (this.f681n != null) goto L7;
            a();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r8) {
            new Thread(r8).start();
        }
    }

    public static void a(Context r8, String r10) {
        if (r10.equals("") == false) goto L34;
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return;
    L34:
        FileOutputStream r11 = r8.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r12 = Xml.newSerializer();
        r12.setOutput(r11, null);     // Catch: Throwable -> L13 Exception -> L15
        r12.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 Exception -> L15
        r12.startTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r12.attribute(null, "application_locales", r10);     // Catch: Throwable -> L13 Exception -> L15
        r12.endTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r12.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + r10 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r11 != null) goto L32;
    L29:
        return;
    L32:
        r11.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r11 != null) goto L27;
    L22:
        throw th;
    L27:
        r11.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(r10), e);     // Catch: Throwable -> L13
        if (r11 == null) goto L29;
    L23:
        Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{"androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"}));
    }

    public static String b(Context r10) {
        String r8 = "";
        FileInputStream r11 = r10.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: FileNotFoundException -> L34
        XmlPullParser r12 = Xml.newPullParser();     // Catch: Throwable -> L21 Throwable -> L23
        r12.setInput(r11, "UTF-8");     // Catch: Throwable -> L21 Throwable -> L23
        int r13 = r12.getDepth();     // Catch: Throwable -> L21 Throwable -> L23
    L5:
        int r14 = r12.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (r14 == 1) goto L18;
        if (r14 == 3) goto L10;
    L11:
        if (r14 == 3) goto L5;
        if (r14 == 4) goto L5;
        if (r12.getName().equals("locales") == false) goto L5;
        r8 = r12.getAttributeValue(null, "application_locales");     // Catch: Throwable -> L21 Throwable -> L23
    L10:
        if (r12.getDepth() > r13) goto L11;
    L18:
        if (r11 == null) goto L27;
    L40:
        r11.close();     // Catch: IOException -> L36
    L27:
        if (r8.isEmpty() == true) goto L29;
        Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(r8));
    L30:
        return r8;
    L29:
        r10.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
    L21:
        th = move-exception;
        if (r11 != null) goto L44;
    L33:
        throw th;
    L44:
        r11.close();     // Catch: IOException -> L37
    L23:
        Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L21
        if (r11 == null) goto L27;
    L34:
        Log.w("AppLocalesStorageHelper", "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }
}
