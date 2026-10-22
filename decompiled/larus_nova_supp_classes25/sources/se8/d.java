package se8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static PolarisFileWrapper a(Context r27, String r28, String r29) {
        String r0 = r28;
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r0, "content");
        String r3 = ((SimpleDateFormat) a.getValue()).format(new Date());
        if (Intrinsics.areEqual(r29, "csv") == false) goto L5;
        String r4 = "sheet_" + r3;
    L6:
        PolarisFileWrapper r5 = null;
        if (r29 == null) goto L9;
        String r6 = r29.toLowerCase(Locale.getDefault());
    L11:
        if (r6 == null) goto L134;
        String r9 = "cpp";
        switch(r6.hashCode()) {
            case -1351281305: goto L131;
            case -1267903281: goto L127;
            case -1125574399: goto L123;
            case -989164661: goto L119;
            case -973197092: goto L115;
            case -874439239: goto L111;
            case -522285947: goto L108;
            case 99: goto L104;
            case 114: goto L101;
            case 3304: goto L98;
            case 96515: goto L96;
            case 96891: goto L92;
            case 98723: goto L90;
            case 98819: goto L86;
            case 98822: goto L83;
            case 107512: goto L79;
            case 110968: goto L76;
            case 114126: goto L73;
            case 114276: goto L70;
            case 118807: goto L67;
            case 3016404: goto L64;
            case 3075967: goto L60;
            case 3213227: goto L57;
            case 3254818: goto L54;
            case 3271912: goto L51;
            case 3511770: goto L47;
            case 3512292: goto L43;
            case 3701415: goto L39;
            case 109250886: goto L36;
            case 109854227: goto L33;
            case 110115790: goto L31;
            case 188995949: goto L27;
            case 953822857: goto L23;
            case 1064388554: goto L19;
            case 1144429618: goto L16;
            default: goto L134;
        };
    L33:
        r9 = "swift";
        if (r6.equals("swift") == false) goto L134;
    L136:
        if (Intrinsics.areEqual(r29, "csv") == true) goto L140;
        if (Intrinsics.areEqual(r29, "table") == true) goto L140;
    L161:
        PolarisFileWrapper r2 = r4 + '.' + r9;
        if (TextUtils.isEmpty(r0) == false) goto L164;
    L203:
        return r5;
    L164:
        if (TextUtils.isEmpty(r2) == true) goto L203;
        if (r27 == null) goto L203;
        String r1 = FileUtils.getCacheDirPath(r27);     // Catch: Throwable -> L185 Exception -> L187
        if (TextUtils.isEmpty(r1) == true) goto L203;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r1 + File.separator + "nova_export_file");     // Catch: Throwable -> L185 Exception -> L187
        if (r7.exists() == true) goto L173;
        r7.mkdirs();     // Catch: Throwable -> L185 Exception -> L187
    L173:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r7, r2);     // Catch: Throwable -> L185 Exception -> L187
        if (r8.exists() == true) goto L176;
        r8.createNewFile();     // Catch: Throwable -> L185 Exception -> L187
    L176:
        byte[] r10 = r0.getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L185 Exception -> L187
        r2 = new PolarisFileOutputStreamWrapper(r8);     // Catch: Throwable -> L185 Exception -> L187
        r2.write(r10);     // Catch: Exception -> L183 Throwable -> L195
        r2.flush();     // Catch: Exception -> L183 Throwable -> L195
        r2.close();     // Catch: Exception -> L180
    L182:
        r5 = r8;
    L204:
    L180:
        e = move-exception;
        r2 = e;
        FLogger.a.e("ImageFileUtils", "saveFileToCacheDir2: error ", r2);
    L183:
        e = e;
    L189:
        FLogger.a.e("ImageFileUtils", "saveFileToCacheDir1: error ", e);     // Catch: Throwable -> L195
        if (r2 == null) goto L204;
        r2.close();     // Catch: Exception -> L193
    L193:
        e = move-exception;
        FLogger.a.e("ImageFileUtils", "saveFileToCacheDir2: error ", e);
        goto L204
    L187:
        e = e;
        r2 = null;
    L185:
        th = th;
    L186:
        Throwable r11 = th;
        if (r5 == null) goto L227;
        r5.close();     // Catch: Exception -> L200
        throw r11;
    L200:
        e = move-exception;
        FLogger.a.e("ImageFileUtils", "saveFileToCacheDir2: error ", e);
        throw r11;
    L227:
        throw r11;
    L195:
        th = th;
        r5 = r2;
    L140:
        if (StringsKt.contains$default(r0, "|", false, 2, null) == false) goto L211;
        Intrinsics.checkNotNullParameter(r0, "sourceContent");
        List r12 = StringsKt.split$default(StringsKt.trim(r28).toString(), new String[]{"\n"}, false, 0, 6, null);
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r12.iterator();
    L143:
        if (r14.hasNext() == false) goto L149;
        String r15 = (String) r14.next();
        if (StringsKt.startsWith$default(r15, "|--", false, 2, null) == true) goto L143;
        if (StringsKt.startsWith$default(r15, "| --", false, 2, null) == true) goto L143;
        r13.append(CollectionsKt.joinToString$default(StringsKt.split$default(StringsKt.trim(r15, new char[]{'|'}), new String[]{"|"}, false, 0, 6, null), ",", null, null, 0, null, new b(), 30, null));
        r13.append("\n");
        goto L143
    L149:
        r0 = r13.toString();
        goto L161
    L211:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L156
        List r17 = StringsKt.lines(StringsKt.trim(r28).toString());     // Catch: Throwable -> L156
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));     // Catch: Throwable -> L156
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L156
    L152:
        if (r19.hasNext() == false) goto L154;
        r18.add(CollectionsKt.joinToString$default(StringsKt.split$default((String) r19.next(), new String[]{"\t"}, false, 0, 6, null), ",", null, null, 0, null, new c(), 30, null));     // Catch: Throwable -> L156
        goto L152
    L154:
        r0 = CollectionsKt.joinToString$default(r18, "\n", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Throwable r21 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r21 == null) goto L160;
        FLogger.a.e("FileExportUtils", "convertToCsv error", r21);
    L160:
        r0 = "";
        goto L161
    L36:
        r9 = "scala";
        if (r6.equals("scala") == true) goto L136;
    L39:
        r9 = "yaml";
        if (r6.equals("yaml") == true) goto L136;
    L54:
        r9 = "java";
        if (r6.equals("java") == true) goto L136;
    L57:
        r9 = "html";
        if (r6.equals("html") == true) goto L136;
    L60:
        r9 = "dart";
        if (r6.equals("dart") == true) goto L136;
    L67:
        r9 = "xml";
        if (r6.equals("xml") == true) goto L136;
    L70:
        r9 = "svg";
        if (r6.equals("svg") == true) goto L136;
    L73:
        r9 = "sql";
        if (r6.equals("sql") == true) goto L136;
    L76:
        r9 = "php";
        if (r6.equals("php") == true) goto L136;
    L79:
        r9 = "lua";
        if (r6.equals("lua") == true) goto L136;
    L86:
        r9 = "css";
        if (r6.equals("css") == true) goto L136;
    L92:
        r9 = "asm";
        if (r6.equals("asm") == true) goto L136;
    L98:
        r9 = "go";
        if (r6.equals("go") == true) goto L136;
    L101:
        r9 = "r";
        if (r6.equals("r") == true) goto L136;
    L104:
        r9 = "c";
        if (r6.equals("c") == true) goto L136;
    L111:
        r9 = "thrift";
        if (r6.equals("thrift") == true) goto L136;
    L16:
        if (r6.equals("vega-lite") == false) goto L134;
    L53:
        r9 = "json";
        goto L136
    L19:
        if (r6.equals("mindmap") == false) goto L134;
        r9 = "md";
        goto L136
    L23:
        if (r6.equals("mermaid") == false) goto L134;
        r9 = "mmd";
        goto L136
    L27:
        if (r6.equals("javascript") == false) goto L134;
        r9 = "js";
        goto L136
    L31:
        if (r6.equals("table") == false) goto L134;
    L85:
        r9 = "csv";
        goto L136
    L43:
        if (r6.equals("rust") == false) goto L134;
        r9 = "rs";
        goto L136
    L47:
        if (r6.equals("ruby") == false) goto L134;
        r9 = "rb";
        goto L136
    L51:
        if (r6.equals("json") == true) goto L53;
    L64:
        if (r6.equals("bash") == false) goto L134;
        r9 = "sh";
        goto L136
    L83:
        if (r6.equals("csv") == true) goto L85;
    L90:
        if (r6.equals("cpp") == true) goto L136;
    L96:
        if (r6.equals("c++") == true) goto L136;
    L108:
        if (r6.equals("typescript") == false) goto L134;
        r9 = "ts";
        goto L136
    L115:
        if (r6.equals("python") == false) goto L134;
        r9 = "py";
        goto L136
    L119:
        if (r6.equals("protobuf") == false) goto L134;
        r9 = "pb";
        goto L136
    L123:
        if (r6.equals("kotlin") == false) goto L134;
        r9 = "kt";
        goto L136
    L127:
        if (r6.equals("objective-c") == false) goto L134;
        r9 = "m";
        goto L136
    L131:
        if (r6.equals("csharp") == false) goto L134;
        r9 = "cs";
    L134:
        r9 = "txt";
        goto L136
    L9:
        r6 = null;
        goto L11
    L5:
        r4 = "code_" + r3;
        goto L6
    }
}
