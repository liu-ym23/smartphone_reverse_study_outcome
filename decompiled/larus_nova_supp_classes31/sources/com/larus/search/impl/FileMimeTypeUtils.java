package com.larus.search.impl;

import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class FileMimeTypeUtils {
    public static final HashMap<String, String> a = null;
    public static final HashMap<String, List<String>> b = null;
    public static final Object[][] c = null;
    public static final Set<String> d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/search/impl/FileMimeTypeUtils$AudioMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "MP3", "WAV", "M4A", "WMA", "ACC", "OGG", "AMR", "FLAC", "AIFF", "UNCLEAR", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/search/impl/FileMimeTypeUtils$TextMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TXT", "PDF", "DOC", "DOCX", "XLS", "XLSX", "PPT", "PPTX", "CSV", "UNCLEAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum TextMineTypeAbbr extends Enum<TextMineTypeAbbr> {
        public static final TextMineTypeAbbr CSV = null;
        public static final TextMineTypeAbbr DOC = null;
        public static final TextMineTypeAbbr DOCX = null;
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
            TextMineTypeAbbr r1 = new TextMineTypeAbbr("PDF", 1, "PDF");
            PDF = r1;
            TextMineTypeAbbr r3 = new TextMineTypeAbbr("DOC", 2, "DOC");
            DOC = r3;
            TextMineTypeAbbr r5 = new TextMineTypeAbbr("DOCX", 3, "DOCX");
            DOCX = r5;
            TextMineTypeAbbr r7 = new TextMineTypeAbbr("XLS", 4, "XLS");
            XLS = r7;
            TextMineTypeAbbr r9 = new TextMineTypeAbbr("XLSX", 5, "XLSX");
            XLSX = r9;
            TextMineTypeAbbr r11 = new TextMineTypeAbbr("PPT", 6, "PPT");
            PPT = r11;
            TextMineTypeAbbr r13 = new TextMineTypeAbbr("PPTX", 7, "PPTX");
            PPTX = r13;
            TextMineTypeAbbr r15 = new TextMineTypeAbbr("CSV", 8, "CSV");
            CSV = r15;
            TextMineTypeAbbr r14 = new TextMineTypeAbbr("UNCLEAR", 9, "UNKNOWN");
            UNCLEAR = r14;
            TextMineTypeAbbr[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
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

    static {
        a = new HashMap();
        String[][] r1 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", "video/x-msvideo"}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"csv", "text/comma-separated-values"}, new String[]{"doc", "application/msword"}, new String[]{"docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{"xls", "application/vnd.ms-excel"}, new String[]{"xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", "image/gif"}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{"jpeg", "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{"js", "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", "video/quicktime"}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{"mp3", "audio/x-mpeg"}, new String[]{"mpg4", "video/mp4"}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mp4", "video/mp4"}, new String[]{"mpga", "audio/mpeg"}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{"pdf", "application/pdf"}, new String[]{"png", "image/png"}, new String[]{"pps", "application/vnd.ms-powerpoint"}, new String[]{"ppt", "application/vnd.ms-powerpoint"}, new String[]{"pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", "audio/x-wav"}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"amr", "audio/amr"}, new String[]{"aac", "audio/x-aac"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/xml"}, new String[]{"z", "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", "application/x-rar-compressed"}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        b = new HashMap();
        c = new Object[][]{new Object[]{"mp3", CollectionsKt.listOf("audio/mpeg")}};
        int r2 = 0;
    L3:
        if (r2 >= 72) goto L5;
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

    public static List a(List r6) {
        ArrayList r0 = new ArrayList();
        if (r6 == null) goto L12;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r6.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r4 = (String) r2.next();
        Intrinsics.checkNotNullParameter(r4, "extension");
        String r5 = a.get(r4);
        if (r5 == null) goto L6;
        r3.add(r5);
        goto L6
    L10:
        List r7 = CollectionsKt.distinct(r3);
        if (r7 == null) goto L12;
    L13:
        if (r6 == null) goto L27;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L27;
        String r10 = (String) r9.next();
        Intrinsics.checkNotNullParameter(r10, "extension");
        List<String> r11 = b.get(r10);
        if (r11 == null) goto L24;
        Iterator<T> r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        r0.add((String) r12.next());
        goto L21
    L23:
        Unit r13 = Unit.INSTANCE;
    L25:
        if (r13 == null) goto L16;
        r8.add(r13);
        goto L16
    L24:
        r13 = null;
    L27:
        r0.addAll(r7);
        return r0;
    L12:
        r7 = CollectionsKt.emptyList();
        goto L13
    }
}
