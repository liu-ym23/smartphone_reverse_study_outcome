package com.larus.share.host;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static final j a = null;
    public static final List<String> b = null;
    public static final CoroutineScope c = null;
    public static final Map<String, String> d = null;

    public static final class a {
        public final Uri a;
        public final String b;
        public final String c;
        public final String d;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "PreparedShare(contentUri=" + this.a + ", fileName=" + this.b + ", mimeType=" + this.c + ", chooserTitle=" + this.d + ')';
        }

        public a(Uri r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "contentUri");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "mimeType");
            Intrinsics.checkNotNullParameter(r5, "chooserTitle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
        public final File a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedSourceFile(file=" + this.a + ", displayName=" + this.b + ')';
        }

        public b(File r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "file");
            this.a = r2;
            this.b = r3;
        }
    }

    public j() {
    }

    static {
        a = new j();
        b = CollectionsKt.listOf(new String[]{"com.android.intentresolver", "com.android.systemui"});
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to("csv", "text/csv"), TuplesKt.to("md", "text/plain"), TuplesKt.to("markdown", "text/plain"), TuplesKt.to("pdf", "application/pdf"), TuplesKt.to("doc", "application/msword"), TuplesKt.to("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"), TuplesKt.to("ppt", "application/vnd.ms-powerpoint"), TuplesKt.to("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"), TuplesKt.to("xls", "application/vnd.ms-excel"), TuplesKt.to("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")});
    }

    public static void c(Context r6, Uri r7) {
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r6.grantUriPermission(r1, r7, 1);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.i("SystemFileShareHelper", "grant chooser uri permission failed for " + r1 + ": " + r4.getClass().getSimpleName());
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final a a(j r21, Context r22, com.larus.bmhome.share.panel.b r23) {
        r21.getClass();
        PolarisFileWrapper r4 = new PolarisFileWrapper(r22.getCacheDir(), "nova_export_file/system_file_share");
        long r5 = System.currentTimeMillis() - 86400000;
        File[] r7 = r4.listFiles();
        if (r7 == null) goto L15;
        int r9 = r7.length;
        int r10 = 0;
    L5:
        if (r10 >= r9) goto L15;
        File r0 = r7[r10];
        if (r0.isFile() == false) goto L14;
        if (r0.lastModified() >= r5) goto L14;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L12
        Result.constructor-impl(Boolean.valueOf(r0.delete()));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        r10 = r10 + 1;
    L15:
        String r1 = r23.l;
        if (r1 != null) goto L18;
    L224:
        return null;
    L18:
        if ((!StringsKt.isBlank(r1)) == false) goto L20;
        String r6 = r1;
    L21:
        if (r6 == null) goto L224;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        Object r3 = Result.constructor-impl(UriProtector.parse(r6));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r3) == false) goto L30;
        r3 = null;
    L30:
        Uri r13 = (Uri) r3;
        if (r13 == null) goto L35;
        String r8 = r13.getScheme();
        if (r8 == null) goto L35;
        String r14 = r8.toLowerCase(Locale.ROOT);
    L37:
        if (Intrinsics.areEqual(r14, "content") == false) goto L116;
        Cursor r15 = b(r22.getContentResolver(), r13, new String[]{"_display_name"});     // Catch: Throwable -> L58
        if (r15 == null) goto L55;
        Cursor r16 = r15;     // Catch: Throwable -> L58
        Cursor r17 = r16;     // Catch: Throwable -> L48
        if (r17.moveToFirst() == false) goto L45;
        String r18 = r17.getString(0);     // Catch: Throwable -> L48
    L46:
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L58
    L56:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r19) == false) goto L63;
        r19 = null;
    L63:
        String r20 = (String) r19;
        if (r20 != null) goto L71;
        String r24 = r13.getLastPathSegment();
        if (r24 == null) goto L68;
        r20 = new PolarisFileWrapper(r24).getName();
    L69:
        if (r20 != null) goto L71;
        r20 = new PolarisFileWrapper(r6).getName();
        goto L71
    L68:
        r20 = null;
    L71:
        Intrinsics.checkNotNull(r20);
        if (r4.exists() == false) goto L74;
    L78:
        String r25 = new PolarisFileWrapper(r20).getName();
        Intrinsics.checkNotNull(r25);
        if ((!StringsKt.isBlank(r25)) == true) goto L81;
    L83:
        boolean r110 = false;
    L84:
        if (r110 == true) goto L87;
        r25 = null;
    L87:
        if (r25 != null) goto L94;
        String r26 = r13.getLastPathSegment();
        if (r26 == null) goto L91;
        r25 = new PolarisFileWrapper(r26).getName();
    L92:
        if (r25 != null) goto L94;
        r25 = "share_file";
        goto L94
    L91:
        r25 = null;
    L94:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r4, UUID.randomUUID() + '_' + r25);
        InputStream r27 = ContentResolverWrapper.openInputStream(r22.getContentResolver(), r13);
        if (r27 == null) goto L114;
        PolarisFileOutputStreamWrapper r28 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L107
        ByteStreamsKt.copyTo$default(r27, r28, 0, 2, null);     // Catch: Throwable -> L100
        CloseableKt.closeFinally(r28, null);     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r27, null);
        b r29 = new b(r111, r20);
    L152:
        if (r29 == null) goto L261;
        File r30 = r29.a;
        Iterator r31 = SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.sequenceOf(new String[]{r23.m, r23.i, r29.b, r30.getName()})), new i()).iterator();
    L156:
        if (r31.hasNext() == false) goto L165;
        Object r32 = r31.next();
        String r112 = (String) r32;
        Intrinsics.checkNotNull(r112);
        if ((!StringsKt.isBlank(r112)) == true) goto L160;
    L162:
        boolean r113 = false;
    L163:
        if (r113 == false) goto L156;
    L166:
        String r33 = (String) r32;
        if (r33 != null) goto L240;
        r33 = r30.getName();
    L240:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L171
        Object r35 = Result.constructor-impl(FileProvider.getUriForFile(r22, r22.getPackageName() + ".fileprovider", r30));     // Catch: Throwable -> L171
    L174:
        if (Result.exceptionOrNull-impl(r35) == null) goto L177;
        FLogger.a.i("SystemFileShareHelper", "direct FileProvider uri unavailable, use cache fallback");
    L177:
        if (Result.isFailure-impl(r35) == false) goto L179;
        r35 = null;
    L179:
        Uri r36 = (Uri) r35;
        if (r36 == null) goto L183;
        File r37 = r30;
    L201:
        if (r13 == null) goto L203;
        String r38 = r22.getContentResolver().getType(r13);
    L204:
        String[] r39 = {r33, r37.getName(), r30.getName()};
        Iterator r40 = SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.sequenceOf(new String[]{r38})), new e()).iterator();
    L205:
        String r41 = "application/octet-stream";
        if (r40.hasNext() == false) goto L215;
        Object r42 = r40.next();
        String r43 = (String) r42;
        if ((!StringsKt.isBlank(r43)) == true) goto L210;
    L212:
        boolean r44 = false;
    L213:
        if (r44 == false) goto L205;
        Object r45 = r42;
    L216:
        String r46 = (String) r45;
        if (r46 != null) goto L222;
        String r47 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(SequencesKt.map(ArraysKt.asSequence(r39), new f()), new g()), new h()));
        if (r47 == null) goto L260;
        r41 = r47;
    L260:
        return new a(r36, r33, r41, r33);
    L222:
        r41 = r46;
        goto L260
    L210:
        if (Intrinsics.areEqual(r43, "application/octet-stream") == true) goto L212;
        r44 = true;
        goto L213
    L215:
        r45 = null;
        goto L216
    L203:
        r38 = null;
        goto L204
    L183:
        if (r4.exists() == false) goto L185;
    L189:
        String r48 = new PolarisFileWrapper(r33).getName();
        Intrinsics.checkNotNull(r48);
        if ((!StringsKt.isBlank(r48)) == true) goto L192;
    L194:
        boolean r49 = false;
    L195:
        if (r49 == true) goto L198;
        r48 = null;
    L198:
        if (r48 != null) goto L200;
        r48 = r30.getName();
    L200:
        r37 = new PolarisFileWrapper(r4, UUID.randomUUID() + '_' + r48);
        FilesKt.copyTo$default(r30, r37, false, 0, 4, null);
        r36 = FileProvider.getUriForFile(r22, r22.getPackageName() + ".fileprovider", r37);
        goto L201
    L192:
        if (Intrinsics.areEqual(r48, ".") == true) goto L194;
        r49 = true;
        goto L195
    L185:
        if (r4.mkdirs() == true) goto L189;
        throw new IOException("create system file share cache failed");
    L171:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L174
    L160:
        if (Intrinsics.areEqual(r112, ".") == true) goto L162;
        r113 = true;
        goto L163
    L165:
        r32 = null;
        goto L166
    L261:
        return null;
    L100:
        th = move-exception;
        throw th;     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        CloseableKt.closeFinally(r28, th);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        CloseableKt.closeFinally(r27, th);
        throw th;
    L114:
        throw new IOException("open content uri stream failed");
    L81:
        if (Intrinsics.areEqual(r25, ".") == true) goto L83;
        r110 = true;
        goto L84
    L74:
        if (r4.mkdirs() == true) goto L78;
        throw new IOException("create system file share cache failed");
    L45:
        r18 = null;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L55:
        r18 = null;
    L58:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L116:
        if (Intrinsics.areEqual(r14, "file") == true) goto L230;
        File r50 = new PolarisFileWrapper(r6);
        if (r50.exists() == true) goto L143;
    L145:
        boolean r51 = false;
    L146:
        if (r51 == true) goto L149;
        r50 = null;
    L149:
        if (r50 != null) goto L151;
    L150:
        r29 = null;
        goto L152
    L151:
        r29 = new b(r50, r50.getName());
        goto L152
    L143:
        if (r50.isFile() == false) goto L145;
        r51 = true;
        goto L146
    L230:
        String r52 = r13.getPath();     // Catch: Throwable -> L122
        if (r52 == null) goto L121;
        Object r53 = Result.constructor-impl(new PolarisFileWrapper(r52));     // Catch: Throwable -> L122
    L125:
        if (Result.isFailure-impl(r53) == false) goto L127;
        r53 = null;
    L127:
        File r54 = (File) r53;
        if (r54 == null) goto L150;
        if (r54.exists() == true) goto L132;
    L134:
        boolean r55 = false;
    L135:
        if (r55 == true) goto L138;
        r54 = null;
    L138:
        if (r54 == null) goto L150;
        r29 = new b(r54, r54.getName());
        goto L152
    L132:
        if (r54.isFile() == false) goto L134;
        r55 = true;
        goto L135
    L121:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        r14 = null;
    L25:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L20:
        r6 = null;
        goto L21
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }
}
