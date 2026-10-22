package h19;

import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.common_ui.icon.ICommonFileIconProvider;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final b a = null;
    public static final Lazy b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Set<String> e = null;
    public static final Set<String> f = null;
    public static final Set<String> g = null;
    public static final Set<String> h = null;
    public static final Set<String> i = null;
    public static final Set<String> j = null;
    public static final Set<String> k = null;
    public static final Set<String> l = null;
    public static final Set<String> m = null;
    public static final Set<String> n = null;
    public static final Set<String> o = null;
    public static final Set<String> p = null;
    public static final Set<String> q = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommonFileIconType.values().length];
            r0[CommonFileIconType.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r0[CommonFileIconType.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r0[CommonFileIconType.TXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[CommonFileIconType.PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[CommonFileIconType.PDF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r0[CommonFileIconType.IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r0[CommonFileIconType.VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r0[CommonFileIconType.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r0[CommonFileIconType.XLS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r0[CommonFileIconType.CODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r0[CommonFileIconType.MARKDOWN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r0[CommonFileIconType.ZIP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r0[CommonFileIconType.CSV.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r0[CommonFileIconType.KEYNOTE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r0[CommonFileIconType.PAGES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r0[CommonFileIconType.NUMBERS.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r0[CommonFileIconType.AI_DOC.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r0[CommonFileIconType.AI_SLIDES.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r0[CommonFileIconType.AI_SHEET.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r0[CommonFileIconType.BITABLE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r0[CommonFileIconType.BITABLE_APP.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r0[CommonFileIconType.MIAODA.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r0[CommonFileIconType.MINDNOTE.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r0[CommonFileIconType.UNKNOWN.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            a = r0;
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new h19.a());
        c = SetsKt.setOf(new String[]{"doc", "dot", "wps", "wpt", "docx", "dotx", "docm", "dotm"});
        d = SetsKt.setOf(new String[]{"txt", "rtf", "log"});
        e = SetsKt.setOf(new String[]{"ppt", "pptx", "pptm", "ppsx", "ppsm", "pps", "potx", "potm", "dpt", "dps"});
        f = SetsKt.setOf("pdf");
        g = SetsKt.setOf(new String[]{"jpg", "jpeg", "gif", "png", "heic", "heif", "dng", "bmp", "tif", "tiff", "svg", "webp", "arw", "nef", "raw", "avif", "ico", "cr2", "crw", "dcr", "dcs", "dwg", "erf", "kdc", "mef", "mos", "mrw", "nrw", "orf", "pef", "ppm", "r3d", "raf", "rw2", "rwl", "sr2", "svgz", "wbmp", "x3f", "3rf"});
        h = SetsKt.setOf(new String[]{"mp4", "mov", "wmv", "m4v", "avi", "mpg", "mpeg", "rm", "rmvb", "flv", "mkv", "ogv", "asf", "dv", "f4v", "m2t", "mpe", "mts", "mxf", "vob", "webm", "3gp", "3gpp", "3gpp2", "mp4v", "mpg4", "mpegts", "m4s"});
        i = SetsKt.setOf(new String[]{"mp3", "wav", "m4a", "wma", "amr", "aac", "au", "flac", "cda", "oga", "ogg", "m4r", "air", "aiff"});
        j = SetsKt.setOf(new String[]{"xls", "xlt", "et", "xlsx", "xltx", "xlsm", "xltm", "ett", "xlsb", "xlm"});
        k = SetsKt.setOf(new String[]{"md", "markdown", "mdown", "mkdn"});
        l = SetsKt.setOf(new String[]{"py", "java", "js", "ts", "c", "cpp", "h", "hpp", "cc", "cxx", "html", "css", "php", "rb", "pl", "sh", "bash", "swift", "kt", "kts", "ktm", "go", "dart", "scala", "cs", "aspx", "xaml", "vue", "proto", "tsx", "jsx", "rs", "json", "yaml", "yml", "xml", "properties", "plist", "bat", "cmd", "ps1", "vbs", "lua", "wxml", "wxss", "m", "for", "f90", "f95", "f", "xhtml", "scss", "thrift", "patch", "sql", "htm", "matlab", "gradle", "groovy", "less", "ejs", "jsp", "r", "hs", "conf", "coffee", "url", "webloc", "website", "as", "as3", "asm", "asp", "cmake", "diff", "erb", "erl", "gvy", "haml", "hh", "hxx", "lst", "make", "ml", "out", "sass", "script", "scm", "sml", "vb", "vi", "vim", "xsd", "xsl"});
        m = SetsKt.setOf(new String[]{"zip", "rar", "tar", "gz", "tgz", "lzma", "7z", "bz2", "cab", "zipx", "jar", "ace", "arj", "lzh", "z", "bz", "cpio", "iso", "lha", "lz", "tbz", "taz", "tbz2", "tlz", "txz", "tz", "xar", "xz"});
        n = SetsKt.setOf("csv");
        o = SetsKt.setOf(new String[]{"key", "keynote"});
        p = SetsKt.setOf("pages");
        q = SetsKt.setOf("numbers");
    }

    public static int a(CommonFileIconType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ICommonFileIconProvider r2 = (ICommonFileIconProvider) b.getValue();     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        Integer r4 = r2.b(r3);     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L15;
        r0 = r5;
    L15:
        Integer r6 = (Integer) r0;
        if (r6 == null) goto L19;
        return r6.intValue();
    L19:
        switch(a.a[r3.ordinal()]) {
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L41;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            default: goto L21;
        };
    L22:
        return 2131243566;
    L23:
        return 2131243560;
    L24:
        return 2131243559;
    L25:
        return 2131243549;
    L26:
        return 2131243550;
    L27:
        return 2131243570;
    L28:
        return 2131243553;
    L29:
        return 2131243561;
    L30:
        return 2131243562;
    L31:
        return 2131243557;
    L32:
        return 2131243552;
    L33:
        return 2131243569;
    L34:
        return 2131243558;
    L35:
        return 2131243551;
    L36:
        return 2131243554;
    L37:
        return 2131243548;
    L38:
        return 2131243567;
    L39:
        return 2131243556;
    L40:
        return 2131243563;
    L41:
        return 2131243564;
    L42:
        return 2131243565;
    L43:
        return 2131243568;
    L44:
        return 2131243555;
    L21:
        throw new NoWhenBranchMatchedException();
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static Integer b(CommonFileIconType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ICommonFileIconProvider r3 = (ICommonFileIconProvider) b.getValue();     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        Integer r4 = r3.a(r2);     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L16;
        r0 = r5;
    L16:
        return (Integer) r0;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static CommonFileIconType c(String r2) {
        String r0 = "";
        if (r2 == null) goto L5;
        String r3 = StringsKt.substringAfterLast(r2, '.', "");
    L6:
        if (r3 == null) goto L10;
        r0 = r3;
    L10:
        return d(r0);
    L5:
        r3 = null;
        goto L6
    }

    public static CommonFileIconType d(String r1) {
        if (r1 == null) goto L8;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L8;
        String r3 = StringsKt.removePrefix(r2, ".");
        if (r3 == null) goto L8;
        String r4 = r3.toLowerCase(Locale.ROOT);
    L9:
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (c.contains(r4) == false) goto L15;
        return CommonFileIconType.DOC;
    L15:
        if (d.contains(r4) == false) goto L18;
        return CommonFileIconType.TXT;
    L18:
        if (e.contains(r4) == false) goto L21;
        return CommonFileIconType.PPT;
    L21:
        if (f.contains(r4) == false) goto L24;
        return CommonFileIconType.PDF;
    L24:
        if (n.contains(r4) == false) goto L27;
        return CommonFileIconType.CSV;
    L27:
        if (g.contains(r4) == false) goto L30;
        return CommonFileIconType.IMAGE;
    L30:
        if (h.contains(r4) == false) goto L33;
        return CommonFileIconType.VIDEO;
    L33:
        if (i.contains(r4) == false) goto L36;
        return CommonFileIconType.AUDIO;
    L36:
        if (j.contains(r4) == false) goto L39;
        return CommonFileIconType.XLS;
    L39:
        if (k.contains(r4) == false) goto L42;
        return CommonFileIconType.MARKDOWN;
    L42:
        if (l.contains(r4) == false) goto L45;
        return CommonFileIconType.CODE;
    L45:
        if (m.contains(r4) == false) goto L48;
        return CommonFileIconType.ZIP;
    L48:
        if (o.contains(r4) == false) goto L51;
        return CommonFileIconType.KEYNOTE;
    L51:
        if (p.contains(r4) == false) goto L54;
        return CommonFileIconType.PAGES;
    L54:
        if (q.contains(r4) == false) goto L57;
        return CommonFileIconType.NUMBERS;
    L57:
        return CommonFileIconType.UNKNOWN;
    L8:
        r4 = null;
        goto L9
    }
}
