package com.obric.aiproactive.ui.artifact;

import com.loc.o;
import com.obric.aiproactive.api.AiProactiveArtifactType;
import com.obric.aiproactive.api.j;
import com.obric.memorydata.plugin.R;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/ArtifactFileIconResolver;", "", "<init>", "()V", "resolveIconRes", "", "artifact", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "type", "Lcom/obric/aiproactive/ui/artifact/ArtifactFileIconResolver$IconType;", "resolveIconType", "resolveIconType$ai_proactive_ui_obricRelease", "resolveTypeBySuffix", "suffix", "", "resolveTypeBySuffix$ai_proactive_ui_obricRelease", "resolveTypeByMimeType", "mimeType", "normalizeSuffix", "DOC_SUFFIXES", "", "SHEET_SUFFIXES", "SLIDE_SUFFIXES", "PDF_SUFFIXES", "CSV_SUFFIXES", "TXT_SUFFIXES", "IMAGE_SUFFIXES", "VIDEO_SUFFIXES", "AUDIO_SUFFIXES", "CODE_SUFFIXES", "ZIP_SUFFIXES", "DOC_MIME_TYPES", "SHEET_MIME_TYPES", "SLIDE_MIME_TYPES", "ZIP_MIME_TYPES", "IconType", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArtifactFileIconResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArtifactFileIconResolver f6533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6534b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;
    private static final Set<String> h = null;
    private static final Set<String> i = null;
    private static final Set<String> j = null;
    private static final Set<String> k = null;
    private static final Set<String> l = null;
    private static final Set<String> m = null;
    private static final Set<String> n = null;
    private static final Set<String> o = null;
    private static final Set<String> p = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/ArtifactFileIconResolver$IconType;", "", "<init>", "(Ljava/lang/String;I)V", "DOC", "SHEET", "SLIDE", "PDF", "TXT", "CSV", "CODE", "ZIP", "IMAGE", "VIDEO", "AUDIO", "LINK", "OTHERS", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType AUDIO = null;
        public static final IconType CODE = null;
        public static final IconType CSV = null;
        public static final IconType DOC = null;
        public static final IconType IMAGE = null;
        public static final IconType LINK = null;
        public static final IconType OTHERS = null;
        public static final IconType PDF = null;
        public static final IconType SHEET = null;
        public static final IconType SLIDE = null;
        public static final IconType TXT = null;
        public static final IconType VIDEO = null;
        public static final IconType ZIP = null;

        private static final /* synthetic */ IconType[] $values() {
            return new IconType[]{DOC, SHEET, SLIDE, PDF, TXT, CSV, CODE, ZIP, IMAGE, VIDEO, AUDIO, LINK, OTHERS};
        }

        static {
            DOC = new IconType("DOC", 0);
            SHEET = new IconType("SHEET", 1);
            SLIDE = new IconType("SLIDE", 2);
            PDF = new IconType("PDF", 3);
            TXT = new IconType("TXT", 4);
            CSV = new IconType("CSV", 5);
            CODE = new IconType("CODE", 6);
            ZIP = new IconType("ZIP", 7);
            IMAGE = new IconType("IMAGE", 8);
            VIDEO = new IconType("VIDEO", 9);
            AUDIO = new IconType("AUDIO", 10);
            LINK = new IconType("LINK", 11);
            OTHERS = new IconType("OTHERS", 12);
            IconType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private IconType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<IconType> getEntries() {
            return $ENTRIES;
        }

        public static IconType valueOf(String r2) {
            return (IconType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IconType.class, r2), IconType.class, "com.obric.memorydata.plugin");
        }

        public static IconType[] values() {
            return (IconType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IconType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6535a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6536b = null;

        static {
            int[] r0 = new int[IconType.values().length];
            r0[IconType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L66:
            r0[IconType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L78:
            r0[IconType.SLIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L50:
            r0[IconType.PDF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L52:
            r0[IconType.TXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L62:
            r0[IconType.CSV.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L74:
            r0[IconType.CODE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L54:
            r0[IconType.ZIP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L68:
            r0[IconType.IMAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L72:
            r0[IconType.VIDEO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L46:
            r0[IconType.AUDIO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L64:
            r0[IconType.LINK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L76:
            r0[IconType.OTHERS.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L20:
            f6535a = r0;
            int[] r1 = new int[AiProactiveArtifactType.values().length];
            r1[AiProactiveArtifactType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L70:
            r1[AiProactiveArtifactType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L80:
            r1[AiProactiveArtifactType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L48:
            r1[AiProactiveArtifactType.LINK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L58:
            r1[AiProactiveArtifactType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L26:
            f6536b = r1;
        }
    }

    static {
        f6533a = new ArtifactFileIconResolver();
        f6534b = SetsKt.setOf(new String[]{"doc", "docx", "dot", "dotx", "docm", "dotm", "wps", "wpt", "pages", "rtf"});
        c = SetsKt.setOf(new String[]{"xls", "xlsx", "xlt", "xltx", "xlsm", "xltm", "xlsb", "xlm", "et", "ett", "numbers"});
        d = SetsKt.setOf(new String[]{"ppt", "pptx", "pptm", "pps", "ppsx", "ppsm", "potx", "potm", "dps", "dpt", "key", "keynote"});
        e = SetsKt.setOf("pdf");
        f = SetsKt.setOf("csv");
        g = SetsKt.setOf(new String[]{"txt", "log"});
        h = SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "gif", "webp", "bmp", "heic", "heif", "avif", "svg", "svgz", "tif", "tiff", "ico", "dng", "raw"});
        i = SetsKt.setOf(new String[]{"mp4", "mov", "m4v", "avi", "wmv", "mkv", "webm", "flv", "f4v", "mpg", "mpeg", "3gp", "3gpp", "rm", "rmvb", "ts", "mts", "vob", "asf", "ogv"});
        j = SetsKt.setOf(new String[]{"mp3", "wav", "m4a", "aac", "flac", "ogg", "oga", "wma", "amr", "aiff", "au", "m4r", "opus"});
        k = SetsKt.setOf(new String[]{"md", "markdown", "mdown", "html", "htm", "xhtml", "xml", "json", "yaml", "yml", "css", "scss", "less", "js", "jsx", "ts", "tsx", "vue", "java", "kt", "kts", "py", "go", "rs", f.f16171b, "php", "swift", "dart", "c", "cc", "cpp", "cxx", o.g, "hpp", "cs", "scala", "sh", "bash", "zsh", "bat", "cmd", "ps1", "sql", "gradle", "groovy", "properties", "plist", "conf", "ini", "toml", "proto", "thrift", "patch", "diff", "lua", "r", "pl"});
        l = SetsKt.setOf(new String[]{"zip", "zipx", "rar", "7z", "tar", "gz", "tgz", "bz2", "tbz", "tbz2", "xz", "txz", "lz", "lzma", "cab", "jar", "iso", "z"});
        m = SetsKt.setOf(new String[]{"application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/rtf"});
        n = SetsKt.setOf(new String[]{"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
        o = SetsKt.setOf(new String[]{"application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation"});
        p = SetsKt.setOf(new String[]{"application/zip", "application/x-zip-compressed", "application/x-rar-compressed", "application/x-7z-compressed", "application/x-tar", "application/gzip"});
    }

    private ArtifactFileIconResolver() {
    }

    private final IconType b(String r5) {
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(r5, ';', null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Locale r6 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r6, "ROOT");
        String r7 = r4.toLowerCase(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r7, "application/pdf") == false) goto L12;
        return IconType.PDF;
    L12:
        if (Intrinsics.areEqual(r7, "text/csv") == false) goto L15;
        return IconType.CSV;
    L15:
        if (Intrinsics.areEqual(r7, "text/markdown") == true) goto L47;
        if (Intrinsics.areEqual(r7, "text/x-markdown") == true) goto L47;
        if (Intrinsics.areEqual(r7, "text/html") == true) goto L47;
        if (m.contains(r7) == false) goto L26;
        return IconType.DOC;
    L26:
        if (n.contains(r7) == false) goto L29;
        return IconType.SHEET;
    L29:
        if (o.contains(r7) == false) goto L32;
        return IconType.SLIDE;
    L32:
        if (p.contains(r7) == false) goto L35;
        return IconType.ZIP;
    L35:
        if (StringsKt.startsWith$default(r7, "image/", false, 2, null) == false) goto L38;
        return IconType.IMAGE;
    L38:
        if (StringsKt.startsWith$default(r7, "video/", false, 2, null) == false) goto L41;
        return IconType.VIDEO;
    L41:
        if (StringsKt.startsWith$default(r7, "audio/", false, 2, null) == false) goto L44;
        return IconType.AUDIO;
    L44:
        if (StringsKt.startsWith$default(r7, "text/", false, 2, null) == true) goto L58;
        return null;
    L58:
        return IconType.TXT;
    L47:
        return IconType.CODE;
    L5:
        r8 = false;
        goto L6
    }

    private final String c(String r3) {
        if (r3 == null) goto L8;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r2 == null) goto L8;
        String r4 = StringsKt.removePrefix(r2, (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L8;
        Locale r5 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r5, "ROOT");
        String r6 = r4.toLowerCase(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
    L9:
        if (r6 != null) goto L12;
        return "";
    L12:
        return r6;
    L8:
        r6 = null;
        goto L9
    }

    public final int a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "artifact");
        return a(b(r2));
    }

    public final int a(IconType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        switch(a.f6535a[r2.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        int r1 = R.drawable.ic_proactive_artifact_other;
        String r0 = "ic_proactive_artifact_other";
    L20:
        return ZeusTransformUtils.mapRes(r1, "drawable", r0);
    L7:
        r1 = R.drawable.oui_icon_oic_hyperlink;
        r0 = "oui_icon_oic_hyperlink";
        goto L20
    L8:
        r1 = R.drawable.ic_proactive_artifact_audio;
        r0 = "ic_proactive_artifact_audio";
        goto L20
    L9:
        r1 = R.drawable.ic_proactive_artifact_video;
        r0 = "ic_proactive_artifact_video";
        goto L20
    L10:
        r1 = R.drawable.ic_proactive_artifact_image;
        r0 = "ic_proactive_artifact_image";
        goto L20
    L11:
        r1 = R.drawable.ic_proactive_artifact_zip;
        r0 = "ic_proactive_artifact_zip";
        goto L20
    L12:
        r1 = R.drawable.ic_proactive_artifact_code;
        r0 = "ic_proactive_artifact_code";
        goto L20
    L13:
        r1 = R.drawable.ic_proactive_artifact_csv;
        r0 = "ic_proactive_artifact_csv";
        goto L20
    L14:
        r1 = R.drawable.ic_proactive_artifact_txt;
        r0 = "ic_proactive_artifact_txt";
        goto L20
    L15:
        r1 = R.drawable.ic_proactive_artifact_pdf;
        r0 = "ic_proactive_artifact_pdf";
        goto L20
    L16:
        r1 = R.drawable.ic_proactive_artifact_slide;
        r0 = "ic_proactive_artifact_slide";
        goto L20
    L17:
        r1 = R.drawable.ic_proactive_artifact_sheet;
        r0 = "ic_proactive_artifact_sheet";
        goto L20
    L18:
        r1 = R.drawable.ic_proactive_artifact_doc;
        r0 = "ic_proactive_artifact_doc";
        goto L20
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final IconType a(String r2) {
        String r1 = c(r2);
        if (Intrinsics.areEqual(r1, "") == false) goto L6;
        return null;
    L6:
        if (f6534b.contains(r1) == false) goto L9;
        return IconType.DOC;
    L9:
        if (c.contains(r1) == false) goto L12;
        return IconType.SHEET;
    L12:
        if (d.contains(r1) == false) goto L15;
        return IconType.SLIDE;
    L15:
        if (e.contains(r1) == false) goto L18;
        return IconType.PDF;
    L18:
        if (f.contains(r1) == false) goto L21;
        return IconType.CSV;
    L21:
        if (g.contains(r1) == false) goto L24;
        return IconType.TXT;
    L24:
        if (h.contains(r1) == false) goto L27;
        return IconType.IMAGE;
    L27:
        if (i.contains(r1) == false) goto L30;
        return IconType.VIDEO;
    L30:
        if (j.contains(r1) == false) goto L33;
        return IconType.AUDIO;
    L33:
        if (k.contains(r1) == false) goto L36;
        return IconType.CODE;
    L36:
        if (l.contains(r1) == true) goto L38;
        return null;
    L38:
        return IconType.ZIP;
    }

    public final IconType b(j r4) {
        Intrinsics.checkNotNullParameter(r4, "artifact");
        if (r4.b() == AiProactiveArtifactType.LINK) goto L5;
        IconType r0 = a(StringsKt.substringAfterLast(r4.d(), '.', ""));
        if (r0 == null) goto L9;
        return r0;
    L9:
        IconType r3 = b(r4.e());
        if (r3 == null) goto L12;
        return r3;
    L12:
        AiProactiveArtifactType r5 = r4.b();
        int r6 = a.f6536b[r5.ordinal()];
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L33;
        if (r6 == 3) goto L32;
        if (r6 == 4) goto L31;
        if (r6 != 5) goto L24;
        return IconType.OTHERS;
    L24:
        throw new NoWhenBranchMatchedException();
    L31:
        return IconType.LINK;
    L32:
        return IconType.AUDIO;
    L33:
        return IconType.VIDEO;
    L29:
        return IconType.IMAGE;
    L5:
        return IconType.LINK;
    }
}
