package com.obric.assistant.omnidetailpage.localmedia;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OmniDetailLocalFileOpenHelper {
    public static final OmniDetailLocalFileOpenHelper a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/omnidetailpage/localmedia/OmniDetailLocalFileOpenHelper$PreferredApp;", "", "<init>", "(Ljava/lang/String;I)V", "BROWSER", "FILE_MANAGER", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreferredApp extends Enum<PreferredApp> {
        public static final PreferredApp BROWSER = null;
        public static final PreferredApp FILE_MANAGER = null;
        public static final /* synthetic */ PreferredApp[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreferredApp> getEntries() {
            return b;
        }

        static {
            PreferredApp r0 = new PreferredApp("BROWSER", 0);
            BROWSER = r0;
            PreferredApp r1 = new PreferredApp("FILE_MANAGER", 1);
            FILE_MANAGER = r1;
            PreferredApp[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PreferredApp[] values() {
            return (PreferredApp[]) a.clone();
        }

        public static PreferredApp valueOf(String r1) {
            return (PreferredApp) r27.a.a(PreferredApp.class, r1);
        }

        public PreferredApp(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final Uri a;
        public final String b;
        public final List<String> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ResolvedLocalFile(uri=" + this.a + ", fileName=" + this.b + ", mimeTypes=" + this.c + ')';
        }

        public a(Uri r2, String r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "mimeTypes");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreferredApp.values().length];
            r0[PreferredApp.BROWSER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreferredApp.FILE_MANAGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public OmniDetailLocalFileOpenHelper() {
    }

    static {
        a = new OmniDetailLocalFileOpenHelper();
        b = SetsKt.setOf(new String[]{"json", "md", "xml"});
        c = SetsKt.setOf(new String[]{"html", "htm"});
    }

    public static boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        ch8.a.a.getClass();
        ch8.b.b r2 = ch8.a.a(r1);
        if ((r2 instanceof ch8.b.b) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.a.exists() == true) goto L7;
        return true;
    }

    public static a d(Context r8, String r9, String r10) {
        ch8.a r0 = ch8.a.a;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        r0.getClass();
        ch8.b.a r11 = ch8.a.a(r9);
        if ((r11 instanceof ch8.b.a) == false) goto L9;
        return e(r8, r11.a, r10);
    L9:
        if ((r11 instanceof ch8.b.b) == false) goto L46;
        ch8.b.b r12 = (ch8.b.b) r11;
        Uri r1 = f(r8, r12.a, ".omni_exports.fileprovider");
        if (r1 != null) goto L44;
        r1 = f(r8, r12.a, ".fileprovider");
        if (r1 != null) goto L44;
        File r13 = r12.a;
        if (r13.isFile() == true) goto L17;
        r1 = null;
        goto L44
    L17:
        Uri r2 = MediaStore.Files.getContentUri("external");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L38
        Cursor r14 = a(r8.getContentResolver(), r2, new String[]{"_id"}, "_data=?", new String[]{r13.getAbsolutePath()});     // Catch: Throwable -> L38
        if (r14 == null) goto L35;
        Cursor r15 = r14;     // Catch: Throwable -> L38
        Cursor r4 = r15;     // Catch: Throwable -> L30
        if (r4.moveToFirst() == false) goto L26;
        int r5 = r4.getColumnIndex("_id");     // Catch: Throwable -> L30
        if (r5 < 0) goto L26;
        Uri r6 = ContentUris.withAppendedId(r2, r4.getLong(r5));     // Catch: Throwable -> L30
    L28:
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L38
    L36:
        Object r16 = Result.constructor-impl(r6);     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r16) == false) goto L43;
        r16 = null;
    L43:
        r1 = (Uri) r16;
        goto L44
    L26:
        r6 = null;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L35:
        r6 = null;
    L38:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        if (r1 == null) goto L48;
        a.getClass();
        return e(r8, r1, r10);
    L48:
        return null;
    L46:
        if (r11 == null) goto L48;
        throw new NoWhenBranchMatchedException();
    }

    public static a e(Context r6, Uri r7, String r8) {
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r2 = null;
        if (StringsKt.isBlank(r8) == false) goto L38;
        a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L29
        Cursor r3 = a(r6.getContentResolver(), r7, new String[]{"_display_name"}, null, null);     // Catch: Throwable -> L29
        if (r3 == null) goto L26;
        Cursor r4 = r3;     // Catch: Throwable -> L29
        Cursor r5 = r4;     // Catch: Throwable -> L21
        if (r5.moveToFirst() == false) goto L18;
        int r9 = r5.getColumnIndex("_display_name");     // Catch: Throwable -> L21
        if (r9 < 0) goto L18;
        String r10 = r5.getString(r9);     // Catch: Throwable -> L21
    L19:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L29
    L27:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r11) == false) goto L34;
        r11 = null;
    L34:
        r8 = (String) r11;
        if (r8 != null) goto L38;
        r8 = "";
        goto L38
    L18:
        r10 = null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        r10 = null;
    L29:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        if (StringsKt.isBlank(r8) == false) goto L42;
        r8 = r7.getLastPathSegment();
        if (r8 != null) goto L42;
        r8 = "";
    L42:
        String r0 = StringsKt.substringAfterLast(r8, '.', "").toLowerCase(Locale.ROOT);
        ArrayList r13 = new ArrayList();
        if (Intrinsics.areEqual(r0, "json") == false) goto L45;
        String r14 = "application/json";
    L46:
        if (r14 == null) goto L49;
        r13.add(r14);
    L49:
        if (Intrinsics.areEqual(r7.getScheme(), "content") == false) goto L70;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L52
        Object r16 = Result.constructor-impl(r6.getContentResolver().getType(r7));     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r16) == false) goto L57;
        r16 = null;
    L57:
        String r17 = (String) r16;
        if (r17 == null) goto L70;
        boolean r18 = true;
        if ((!StringsKt.isBlank(r17)) == true) goto L62;
    L64:
        r18 = false;
    L65:
        if (r18 == false) goto L67;
        r2 = r17;
    L67:
        if (r2 == null) goto L70;
        r13.add(r2);
        goto L70
    L62:
        if (Intrinsics.areEqual(r17, "*/*") == true) goto L64;
    L52:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L70:
        if (b.contains(r0) == false) goto L73;
        r13.add("text/plain");
    L73:
        return new a(r7, r8, CollectionsKt.distinct(r13));
    L45:
        r14 = FileMimeTypeUtils.c(r0);
        goto L46
    }

    public static Uri f(Context r3, File r4, String r5) {
        Object r1 = null;
        if (r4.isFile() == true) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(FileProvider.getUriForFile(r3, r3.getPackageName() + r5, r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r6) == true) goto L14;
        r1 = r6;
    L14:
        return (Uri) r1;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static ResolveInfo g(Context r5, List r6, PreferredApp r7) {
        Object r1 = null;
        if (r7 != PreferredApp.FILE_MANAGER) goto L14;
        Iterator r0 = r6.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((ResolveInfo) r2).activityInfo.packageName, "com.obric.filemanager") == false) goto L6;
    L11:
        ResolveInfo r3 = (ResolveInfo) r2;
        if (r3 == null) goto L14;
        return r3;
    L10:
        r2 = null;
    L14:
        int r8 = b.a[r7.ordinal()];
        if (r8 != 1) goto L17;
        String r9 = "android.intent.category.APP_BROWSER";
    L22:
        Intent r10 = Intent.makeMainSelectorActivity("android.intent.action.MAIN", r9);
        ResolveInfo r4 = r5.getPackageManager().resolveActivity(r10, 0);
        if (r4 == null) goto L27;
        ActivityInfo r11 = r4.activityInfo;
        if (r11 == null) goto L27;
        String r12 = r11.packageName;
    L28:
        List<ResolveInfo> r13 = r5.getPackageManager().queryIntentActivities(r10, 0);
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator<T> r15 = r13.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        r14.add(((ResolveInfo) r15.next()).activityInfo.packageName);
        goto L30
    L32:
        List r16 = r6;
        Iterator r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L38;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((ResolveInfo) r18).activityInfo.packageName, r12) == false) goto L34;
    L39:
        ResolveInfo r19 = (ResolveInfo) r18;
        if (r19 != null) goto L59;
        Iterator r20 = r16.iterator();
    L43:
        if (r20.hasNext() == false) goto L48;
        Object r21 = r20.next();
        if (r14.contains(((ResolveInfo) r21).activityInfo.packageName) == false) goto L43;
        r1 = r21;
    L48:
        return (ResolveInfo) r1;
    L59:
        return r19;
    L38:
        r18 = null;
    L27:
        r12 = null;
        goto L28
    L17:
        if (r8 != 2) goto L20;
        r9 = "android.intent.category.APP_FILES";
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public static void c(final Context r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, "fileName");
        Intrinsics.checkNotNullParameter(r14, "fileType");
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L20;
        com.larus.platform.service.o r15 = com.larus.platform.service.o.a;
        JSONObject r16 = new JSONObject();
        r16.put("action", "open_external");
        r16.put("entry", "omni_detail_local_file");
        r16.put("content_type", "file");
        Unit r17 = Unit.INSTANCE;
        r15.reportEvent("flow_enterprise_file_egress_block", r16);
        String r18 = r0.A0();
        if (r18 != null) goto L12;
        return;
    L12:
        if ((!StringsKt.isBlank(r18)) == true) goto L15;
        r18 = null;
    L15:
        String r2 = r18;
        if (r2 == null) goto L85;
        t19.s.j(t19.s.a, r11, r2, null, false, 28);
        return;
    L85:
        return;
    L20:
        if (b(r12) == false) goto L23;
        FLogger.a.i("OmniDetailLocalFileOpenHelper", "open failed, file does not exist, path=" + r12 + ", fileName=" + r13);
        com.larus.utils.y.c(new p());
        return;
    L23:
        a r1 = d(r11, r12, r13);
        if (r1 != null) goto L27;
        FLogger.a.i("OmniDetailLocalFileOpenHelper", "open failed, unresolved fileName=" + r13);
        com.larus.utils.y.c(new o(r11));
        return;
    L27:
        Iterator r19 = SequencesKt.map(SequencesKt.sequenceOf(new String[]{r14, r13, r12}), new n()).iterator();
    L29:
        if (r19.hasNext() == false) goto L33;
        if (c.contains((String) r19.next()) == false) goto L29;
        boolean r110 = true;
    L34:
        if (r110 == false) goto L36;
        PreferredApp r111 = PreferredApp.BROWSER;
    L37:
        Iterator<T> r112 = r1.c.iterator();
    L39:
        if (r112.hasNext() == false) goto L70;
        String r113 = (String) r112.next();
        a.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L59
        Intent r6 = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L59
        r6.addFlags(1);     // Catch: Throwable -> L59
        if ((r11 instanceof Activity) == true) goto L44;
        r6.addFlags(268435456);     // Catch: Throwable -> L59
    L44:
        r6.setClipData(ClipData.newUri(r11.getContentResolver(), r1.b, r1.a));     // Catch: Throwable -> L59
        r6.setDataAndType(r1.a, r113);     // Catch: Throwable -> L59
        List<ResolveInfo> r7 = r11.getPackageManager().queryIntentActivities(r6, 0);     // Catch: Throwable -> L59
        if (r7.isEmpty() == false) goto L47;
        boolean r114 = false;
    L68:
        if (r114 == false) goto L39;
        return;
    L47:
        Iterator<T> r8 = r7.iterator();     // Catch: Throwable -> L59
    L49:
        if (r8.hasNext() == false) goto L51;
        r11.grantUriPermission(((ResolveInfo) r8.next()).activityInfo.packageName, r1.a, 1);     // Catch: Throwable -> L59
        goto L49
    L51:
        ResolveInfo r9 = g(r11, r7, r111);     // Catch: Throwable -> L59
        if (r9 == null) goto L54;
        ActivityInfo r10 = r9.activityInfo;     // Catch: Throwable -> L59
        r6.setClassName(r10.packageName, r10.name);     // Catch: Throwable -> L59
        r11.startActivity(r6);     // Catch: Throwable -> L59
        r114 = true;
        goto L68
    L54:
        Intent r20 = Intent.createChooser(r6, r1.b);     // Catch: Throwable -> L59
        r20.addFlags(1);     // Catch: Throwable -> L59
        r20.setClipData(r6.getClipData());     // Catch: Throwable -> L59
        if ((r11 instanceof Activity) == true) goto L57;
        r20.addFlags(268435456);     // Catch: Throwable -> L59
    L57:
        r11.startActivity(r20);     // Catch: Throwable -> L59
        Object r21 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L59
    L61:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L64;
        FLogger.a.e("OmniDetailLocalFileOpenHelper", "open failed, uri=" + r1.a + ", fileName=" + r1.b + ", mimeType=" + r113, r22);
    L64:
        Boolean r115 = Boolean.FALSE;
        if (Result.isFailure-impl(r21) == false) goto L67;
        r21 = r115;
    L67:
        r114 = ((Boolean) r21).booleanValue();
    L59:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L70:
        com.larus.utils.y.c(new o(r11));
        return;
    L36:
        r111 = PreferredApp.FILE_MANAGER;
        goto L37
    L33:
        r110 = false;
        goto L34
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
