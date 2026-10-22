package com.larus.bmhome.utils;

import com.larus.bmhome.video.bean.VideoType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.icon.CommonFileIconType;
import h19.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class FileMimeTypeUtils {
    public static final HashMap<String, String> a = null;
    public static final HashMap<String, List<String>> b = null;
    public static final Object[][] c = null;
    public static final Set<String> d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/utils/FileMimeTypeUtils$AudioMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "MP3", "WAV", "M4A", "WMA", "ACC", "OGG", "AMR", "FLAC", "AIFF", "UNCLEAR", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioMineTypeAbbr extends Enum<AudioMineTypeAbbr> {
        public static final AudioMineTypeAbbr ACC = null;
        public static final AudioMineTypeAbbr AIFF = null;
        public static final AudioMineTypeAbbr AMR = null;
        public static final a Companion = null;
        public static final AudioMineTypeAbbr FLAC = null;
        public static final AudioMineTypeAbbr M4A = null;
        public static final AudioMineTypeAbbr MP3 = null;
        public static final AudioMineTypeAbbr OGG = null;
        public static final AudioMineTypeAbbr UNCLEAR = null;
        public static final AudioMineTypeAbbr WAV = null;
        public static final AudioMineTypeAbbr WMA = null;
        public static final /* synthetic */ AudioMineTypeAbbr[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String type;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AudioMineTypeAbbr> getEntries() {
            return b;
        }

        static {
            AudioMineTypeAbbr r0 = new AudioMineTypeAbbr("MP3", 0, "MP3");
            MP3 = r0;
            AudioMineTypeAbbr r1 = new AudioMineTypeAbbr("WAV", 1, "WAV");
            WAV = r1;
            AudioMineTypeAbbr r3 = new AudioMineTypeAbbr("M4A", 2, "M4A");
            M4A = r3;
            AudioMineTypeAbbr r5 = new AudioMineTypeAbbr("WMA", 3, "WMA");
            WMA = r5;
            AudioMineTypeAbbr r7 = new AudioMineTypeAbbr("ACC", 4, "AAC");
            ACC = r7;
            AudioMineTypeAbbr r9 = new AudioMineTypeAbbr("OGG", 5, "OGG");
            OGG = r9;
            AudioMineTypeAbbr r11 = new AudioMineTypeAbbr("AMR", 6, "AMR");
            AMR = r11;
            AudioMineTypeAbbr r13 = new AudioMineTypeAbbr("FLAC", 7, "FLAC");
            FLAC = r13;
            AudioMineTypeAbbr r15 = new AudioMineTypeAbbr("AIFF", 8, "AIFF");
            AIFF = r15;
            AudioMineTypeAbbr r14 = new AudioMineTypeAbbr("UNCLEAR", 9, "UNKNOWN");
            UNCLEAR = r14;
            AudioMineTypeAbbr[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new a();
        }

        public static AudioMineTypeAbbr[] values() {
            return (AudioMineTypeAbbr[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static AudioMineTypeAbbr valueOf(String r1) {
            return (AudioMineTypeAbbr) r27.a.a(AudioMineTypeAbbr.class, r1);
        }

        public AudioMineTypeAbbr(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/utils/FileMimeTypeUtils$TextMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TXT", "HTML", "PDF", "DOC", "CODE", "DOCX", "XLS", "XLSX", "PPT", "PPTX", "CSV", "AI_DOC", "AI_SHEET", "AI_SLIDES", "BITABLE", "UNCLEAR", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextMineTypeAbbr extends Enum<TextMineTypeAbbr> {
        public static final TextMineTypeAbbr AI_DOC = null;
        public static final TextMineTypeAbbr AI_SHEET = null;
        public static final TextMineTypeAbbr AI_SLIDES = null;
        public static final TextMineTypeAbbr BITABLE = null;
        public static final TextMineTypeAbbr CODE = null;
        public static final TextMineTypeAbbr CSV = null;
        public static final TextMineTypeAbbr DOC = null;
        public static final TextMineTypeAbbr DOCX = null;
        public static final TextMineTypeAbbr HTML = null;
        public static final TextMineTypeAbbr PDF = null;
        public static final TextMineTypeAbbr PPT = null;
        public static final TextMineTypeAbbr PPTX = null;
        public static final TextMineTypeAbbr TXT = null;
        public static final TextMineTypeAbbr UNCLEAR = null;
        public static final TextMineTypeAbbr XLS = null;
        public static final TextMineTypeAbbr XLSX = null;
        public static final /* synthetic */ TextMineTypeAbbr[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String type;

        public static EnumEntries<TextMineTypeAbbr> getEntries() {
            return b;
        }

        static {
            TextMineTypeAbbr r0 = new TextMineTypeAbbr("TXT", 0, "TXT");
            TXT = r0;
            TextMineTypeAbbr r1 = new TextMineTypeAbbr("HTML", 1, "HTML");
            HTML = r1;
            TextMineTypeAbbr r3 = new TextMineTypeAbbr("PDF", 2, "PDF");
            PDF = r3;
            TextMineTypeAbbr r5 = new TextMineTypeAbbr("DOC", 3, "DOC");
            DOC = r5;
            TextMineTypeAbbr r7 = new TextMineTypeAbbr("CODE", 4, "CODE");
            CODE = r7;
            TextMineTypeAbbr r9 = new TextMineTypeAbbr("DOCX", 5, "DOCX");
            DOCX = r9;
            TextMineTypeAbbr r11 = new TextMineTypeAbbr("XLS", 6, "XLS");
            XLS = r11;
            TextMineTypeAbbr r13 = new TextMineTypeAbbr("XLSX", 7, "XLSX");
            XLSX = r13;
            TextMineTypeAbbr r15 = new TextMineTypeAbbr("PPT", 8, "PPT");
            PPT = r15;
            TextMineTypeAbbr r14 = new TextMineTypeAbbr("PPTX", 9, "PPTX");
            PPTX = r14;
            TextMineTypeAbbr r12 = new TextMineTypeAbbr("CSV", 10, "CSV");
            CSV = r12;
            TextMineTypeAbbr r10 = new TextMineTypeAbbr("AI_DOC", 11, "文档");
            AI_DOC = r10;
            TextMineTypeAbbr r4 = new TextMineTypeAbbr("AI_SHEET", 12, "表格");
            AI_SHEET = r4;
            TextMineTypeAbbr r2 = new TextMineTypeAbbr("AI_SLIDES", 13, "幻灯片");
            AI_SLIDES = r2;
            TextMineTypeAbbr r6 = new TextMineTypeAbbr("BITABLE", 14, AppHost.a.getApplication().getString(2131897483));
            BITABLE = r6;
            TextMineTypeAbbr r8 = new TextMineTypeAbbr("UNCLEAR", 15, "OTHERS");
            UNCLEAR = r8;
            TextMineTypeAbbr[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r4, r2, r6, r8};
            a = r16;
            b = EnumEntriesKt.enumEntries(r16);
        }

        public static TextMineTypeAbbr[] values() {
            return (TextMineTypeAbbr[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static TextMineTypeAbbr valueOf(String r1) {
            return (TextMineTypeAbbr) r27.a.a(TextMineTypeAbbr.class, r1);
        }

        public TextMineTypeAbbr(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TextMineTypeAbbr.values().length];
            r0[TextMineTypeAbbr.TXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r0[TextMineTypeAbbr.PDF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r0[TextMineTypeAbbr.DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[TextMineTypeAbbr.DOCX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[TextMineTypeAbbr.XLS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r0[TextMineTypeAbbr.XLSX.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r0[TextMineTypeAbbr.PPT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[TextMineTypeAbbr.PPTX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[TextMineTypeAbbr.CSV.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[TextMineTypeAbbr.HTML.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r0[TextMineTypeAbbr.CODE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[TextMineTypeAbbr.AI_DOC.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[TextMineTypeAbbr.AI_SHEET.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r0[TextMineTypeAbbr.AI_SLIDES.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[TextMineTypeAbbr.BITABLE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r0[TextMineTypeAbbr.UNCLEAR.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            a = r0;
        }
    }

    static {
        a = new HashMap();
        String[][] r1 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", "video/x-msvideo"}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"csv", "text/comma-separated-values"}, new String[]{"doc", "application/msword"}, new String[]{"dot", "application/msword"}, new String[]{"docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{"xls", "application/vnd.ms-excel"}, new String[]{"xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", "image/gif"}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{"json", "text/plain"}, new String[]{"jpeg", "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{"js", "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"md", "text/plain"}, new String[]{"md", "text/markdown"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", "video/quicktime"}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{"mp3", "audio/x-mpeg"}, new String[]{"mpg4", "video/mp4"}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{VideoType.MP4, "video/mp4"}, new String[]{"mpga", "audio/mpeg"}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{"pdf", "application/pdf"}, new String[]{"png", "image/png"}, new String[]{"pps", "application/vnd.ms-powerpoint"}, new String[]{"ppt", "application/vnd.ms-powerpoint"}, new String[]{"pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", "audio/x-wav"}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"amr", "audio/amr"}, new String[]{"aac", "audio/x-aac"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/xml"}, new String[]{"z", "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", "application/x-rar-compressed"}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        b = new HashMap();
        c = new Object[][]{new Object[]{"mp3", CollectionsKt.listOf("audio/mpeg")}};
        int r2 = 0;
    L3:
        if (r2 >= 76) goto L5;
        String[] r5 = r1[r2];
        a.put(r5[0], r5[1]);
        r2 = r2 + 1;
        goto L3
    L5:
        Object[][] r0 = c;
        int r3 = r0.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        Object[] r6 = r0[r4];
        HashMap<String, List<String>> r7 = b;
        String r8 = r6[0].toString();
        Object r9 = r6[1];
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        r7.put(r8, (List) r9);
        r4 = r4 + 1;
        goto L6
    L8:
        d = SetsKt.setOf(new String[]{"text/plain", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "text/html", "application/pdf", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/rtf", "application/vnd.ms-works"});
    }

    public static AudioMineTypeAbbr a(String r6) {
        AudioMineTypeAbbr.a r0 = AudioMineTypeAbbr.Companion;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "type");
        AudioMineTypeAbbr[] r1 = AudioMineTypeAbbr.values();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        AudioMineTypeAbbr r4 = r1[r3];
        if (StringsKt.equals(r4.getType(), r6, true) == true) goto L12;
        r3 = r3 + 1;
    L12:
        if (r4 == null) goto L14;
        return r4;
    L14:
        return AudioMineTypeAbbr.UNCLEAR;
    L11:
        r4 = null;
        goto L12
    }

    public static String c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "extension");
        return a.get(r1);
    }

    public static List d(List r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L12;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r5.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r3 = c((String) r1.next());
        if (r3 == null) goto L6;
        r2.add(r3);
        goto L6
    L10:
        List r4 = CollectionsKt.distinct(r2);
        if (r4 == null) goto L12;
    L13:
        if (r5 == null) goto L27;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L27;
        String r8 = (String) r7.next();
        Intrinsics.checkNotNullParameter(r8, "extension");
        List<String> r9 = b.get(r8);
        if (r9 == null) goto L24;
        Iterator<T> r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        r0.add((String) r10.next());
        goto L21
    L23:
        Unit r11 = Unit.INSTANCE;
    L25:
        if (r11 == null) goto L16;
        r6.add(r11);
        goto L16
    L24:
        r11 = null;
    L27:
        r0.addAll(r4);
        return r0;
    L12:
        r4 = CollectionsKt.emptyList();
        goto L13
    }

    public static TextMineTypeAbbr e(String r1, String r2) {
        if (r1 != null) goto L4;
    L68:
        TextMineTypeAbbr r3 = TextMineTypeAbbr.UNCLEAR;
    L69:
        TextMineTypeAbbr r0 = TextMineTypeAbbr.UNCLEAR;
        if (r3 != r0) goto L80;
        if (r2 == null) goto L80;
        if (Intrinsics.areEqual(r2, "dot") == false) goto L77;
        return TextMineTypeAbbr.DOC;
    L77:
        if (Intrinsics.areEqual(r2, "log") == true) goto L79;
        return r0;
    L79:
        return TextMineTypeAbbr.TXT;
    L80:
        return r3;
    L4:
        switch(r1.hashCode()) {
            case -2135895576: goto L65;
            case -1418040159: goto L61;
            case -1248334925: goto L57;
            case -1218310520: goto L53;
            case -1082243251: goto L49;
            case -1073633483: goto L45;
            case -1071817359: goto L41;
            case -1050893613: goto L37;
            case -1004747228: goto L34;
            case -533161071: goto L30;
            case -366307023: goto L26;
            case -102775833: goto L22;
            case 817335912: goto L19;
            case 890891481: goto L15;
            case 904647503: goto L11;
            case 1993842850: goto L7;
            default: goto L68;
        };
    L7:
        if (r1.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") == false) goto L68;
        r3 = TextMineTypeAbbr.XLSX;
        goto L69
    L11:
        if (r1.equals("application/msword") == false) goto L68;
        r3 = TextMineTypeAbbr.DOC;
        goto L69
    L15:
        if (r1.equals("ai_slides") == false) goto L68;
        r3 = TextMineTypeAbbr.AI_SLIDES;
        goto L69
    L19:
        if (r1.equals("text/plain") == false) goto L68;
        r3 = TextMineTypeAbbr.TXT;
        goto L69
    L22:
        if (r1.equals("bitable") == false) goto L68;
        r3 = TextMineTypeAbbr.BITABLE;
        goto L69
    L26:
        if (r1.equals("application/vnd.ms-excel") == false) goto L68;
        r3 = TextMineTypeAbbr.XLS;
        goto L69
    L30:
        if (r1.equals("text/markdown") == false) goto L68;
        r3 = TextMineTypeAbbr.CODE;
        goto L69
    L34:
        if (r1.equals("text/csv") == false) goto L68;
    L67:
        r3 = TextMineTypeAbbr.CSV;
        goto L69
    L37:
        if (r1.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") == false) goto L68;
        r3 = TextMineTypeAbbr.DOCX;
        goto L69
    L41:
        if (r1.equals("application/vnd.ms-powerpoint") == false) goto L68;
        r3 = TextMineTypeAbbr.PPT;
        goto L69
    L45:
        if (r1.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation") == false) goto L68;
        r3 = TextMineTypeAbbr.PPTX;
        goto L69
    L49:
        if (r1.equals("text/html") == false) goto L68;
        r3 = TextMineTypeAbbr.HTML;
        goto L69
    L53:
        if (r1.equals("ai_sheet") == false) goto L68;
        r3 = TextMineTypeAbbr.AI_SHEET;
        goto L69
    L57:
        if (r1.equals("application/pdf") == false) goto L68;
        r3 = TextMineTypeAbbr.PDF;
        goto L69
    L61:
        if (r1.equals("ai_doc") == false) goto L68;
        r3 = TextMineTypeAbbr.AI_DOC;
        goto L69
    L65:
        if (r1.equals("text/comma-separated-values") == true) goto L67;
        goto L67
    }

    public static int b(String r0, String r1, boolean r2) {
        TextMineTypeAbbr r3 = e(r0, r1);
        switch(a.a[r3.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L7;
            case 16: goto L6;
            default: goto L5;
        };
    L6:
        CommonFileIconType r4 = CommonFileIconType.UNKNOWN;
    L21:
        b.a.getClass();
        return b.a(r4);
    L7:
        if (r2 == false) goto L9;
        r4 = CommonFileIconType.BITABLE_APP;
        goto L21
    L9:
        r4 = CommonFileIconType.BITABLE;
        goto L21
    L10:
        r4 = CommonFileIconType.AI_SLIDES;
        goto L21
    L11:
        r4 = CommonFileIconType.AI_SHEET;
        goto L21
    L12:
        r4 = CommonFileIconType.AI_DOC;
        goto L21
    L13:
        r4 = CommonFileIconType.CODE;
        goto L21
    L14:
        r4 = CommonFileIconType.CODE;
        goto L21
    L15:
        r4 = CommonFileIconType.CSV;
        goto L21
    L16:
        r4 = CommonFileIconType.PPT;
        goto L21
    L17:
        r4 = CommonFileIconType.XLS;
        goto L21
    L18:
        r4 = CommonFileIconType.DOC;
        goto L21
    L19:
        r4 = CommonFileIconType.PDF;
        goto L21
    L20:
        r4 = CommonFileIconType.TXT;
        goto L21
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
