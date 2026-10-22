package com.larus.drive.biz.api.model;

import com.larus.common_ui.icon.CommonFileIconType;
import h19.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006&"}, d2 = {"Lcom/larus/drive/biz/api/model/DriveFileType;", "", "value", "", "iconType", "Lcom/larus/common_ui/icon/CommonFileIconType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/common_ui/icon/CommonFileIconType;)V", "getValue", "()Ljava/lang/String;", "FOLDER", "DOC", "TXT", "PPT", "PDF", "IMAGE", "VIDEO", "AUDIO", "XLS", "CODE", "MARKDOWN", "ZIP", "CSV", "KEYNOTE", "PAGES", "NUMBERS", "AI_DOC", "AI_SLIDES", "AI_SHEET", "BITABLE", "MIAODA", "MINDNOTE", "UNKNOWN", "iconResId", "", "getIconResId", "()I", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveFileType extends Enum<DriveFileType> {
    public static final DriveFileType AI_DOC = null;
    public static final DriveFileType AI_SHEET = null;
    public static final DriveFileType AI_SLIDES = null;
    public static final DriveFileType AUDIO = null;
    public static final DriveFileType BITABLE = null;
    public static final DriveFileType CODE = null;
    public static final DriveFileType CSV = null;
    public static final a Companion = null;
    public static final DriveFileType DOC = null;
    public static final DriveFileType FOLDER = null;
    public static final DriveFileType IMAGE = null;
    public static final DriveFileType KEYNOTE = null;
    public static final DriveFileType MARKDOWN = null;
    public static final DriveFileType MIAODA = null;
    public static final DriveFileType MINDNOTE = null;
    public static final DriveFileType NUMBERS = null;
    public static final DriveFileType PAGES = null;
    public static final DriveFileType PDF = null;
    public static final DriveFileType PPT = null;
    public static final DriveFileType TXT = null;
    public static final DriveFileType UNKNOWN = null;
    public static final DriveFileType VIDEO = null;
    public static final DriveFileType XLS = null;
    public static final DriveFileType ZIP = null;
    public static final /* synthetic */ DriveFileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final CommonFileIconType iconType;
    private final String value;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.drive.biz.api.model.DriveFileType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0109a {
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

        public a() {
        }

        public static DriveFileType a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            Iterator r0 = DriveFileType.getEntries().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((DriveFileType) r1).getValue(), r3) == false) goto L4;
        L10:
            return (DriveFileType) r1;
        L8:
            r1 = null;
            goto L10
        }

        public static DriveFileType b(String r1) {
            b.a.getClass();
            CommonFileIconType r2 = b.c(r1);
            switch(C0109a.a[r2.ordinal()]) {
                case 1: goto L30;
                case 2: goto L53;
                case 3: goto L52;
                case 4: goto L51;
                case 5: goto L50;
                case 6: goto L49;
                case 7: goto L48;
                case 8: goto L47;
                case 9: goto L46;
                case 10: goto L45;
                case 11: goto L44;
                case 12: goto L43;
                case 13: goto L42;
                case 14: goto L41;
                case 15: goto L40;
                case 16: goto L39;
                case 17: goto L38;
                case 18: goto L37;
                case 19: goto L36;
                case 20: goto L35;
                case 21: goto L34;
                case 22: goto L33;
                case 23: goto L32;
                case 24: goto L31;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L31:
            return DriveFileType.UNKNOWN;
        L32:
            return DriveFileType.MINDNOTE;
        L33:
            return DriveFileType.MIAODA;
        L34:
            return DriveFileType.BITABLE;
        L35:
            return DriveFileType.BITABLE;
        L36:
            return DriveFileType.AI_SHEET;
        L37:
            return DriveFileType.AI_SLIDES;
        L38:
            return DriveFileType.AI_DOC;
        L39:
            return DriveFileType.NUMBERS;
        L40:
            return DriveFileType.PAGES;
        L41:
            return DriveFileType.KEYNOTE;
        L42:
            return DriveFileType.CSV;
        L43:
            return DriveFileType.ZIP;
        L44:
            return DriveFileType.MARKDOWN;
        L45:
            return DriveFileType.CODE;
        L46:
            return DriveFileType.XLS;
        L47:
            return DriveFileType.AUDIO;
        L48:
            return DriveFileType.VIDEO;
        L49:
            return DriveFileType.IMAGE;
        L50:
            return DriveFileType.PDF;
        L51:
            return DriveFileType.PPT;
        L52:
            return DriveFileType.TXT;
        L53:
            return DriveFileType.DOC;
        L30:
            return DriveFileType.FOLDER;
        }
    }

    public static EnumEntries<DriveFileType> getEntries() {
        return b;
    }

    static {
        DriveFileType r0 = new DriveFileType("FOLDER", 0, "folder", CommonFileIconType.FOLDER);
        FOLDER = r0;
        DriveFileType r1 = new DriveFileType("DOC", 1, "doc", CommonFileIconType.DOC);
        DOC = r1;
        DriveFileType r2 = new DriveFileType("TXT", 2, "txt", CommonFileIconType.TXT);
        TXT = r2;
        DriveFileType r4 = new DriveFileType("PPT", 3, "ppt", CommonFileIconType.PPT);
        PPT = r4;
        DriveFileType r6 = new DriveFileType("PDF", 4, "pdf", CommonFileIconType.PDF);
        PDF = r6;
        DriveFileType r8 = new DriveFileType("IMAGE", 5, "image", CommonFileIconType.IMAGE);
        IMAGE = r8;
        DriveFileType r10 = new DriveFileType("VIDEO", 6, "media", CommonFileIconType.VIDEO);
        VIDEO = r10;
        DriveFileType r12 = new DriveFileType("AUDIO", 7, "audio", CommonFileIconType.AUDIO);
        AUDIO = r12;
        DriveFileType r11 = new DriveFileType("XLS", 8, "xls", CommonFileIconType.XLS);
        XLS = r11;
        DriveFileType r9 = new DriveFileType("CODE", 9, "code", CommonFileIconType.CODE);
        CODE = r9;
        DriveFileType r7 = new DriveFileType("MARKDOWN", 10, "markdown", CommonFileIconType.MARKDOWN);
        MARKDOWN = r7;
        DriveFileType r5 = new DriveFileType("ZIP", 11, "zip", CommonFileIconType.ZIP);
        ZIP = r5;
        DriveFileType r3 = new DriveFileType("CSV", 12, "csv", CommonFileIconType.CSV);
        CSV = r3;
        DriveFileType r13 = new DriveFileType("KEYNOTE", 13, "keynote", CommonFileIconType.KEYNOTE);
        KEYNOTE = r13;
        DriveFileType r14 = new DriveFileType("PAGES", 14, "pages", CommonFileIconType.PAGES);
        PAGES = r14;
        DriveFileType r15 = new DriveFileType("NUMBERS", 15, "numbers", CommonFileIconType.NUMBERS);
        NUMBERS = r15;
        DriveFileType r16 = new DriveFileType("AI_DOC", 16, "ai_doc", CommonFileIconType.AI_DOC);
        AI_DOC = r16;
        DriveFileType r17 = new DriveFileType("AI_SLIDES", 17, "ai_slides", CommonFileIconType.AI_SLIDES);
        AI_SLIDES = r17;
        DriveFileType r18 = new DriveFileType("AI_SHEET", 18, "ai_sheet", CommonFileIconType.AI_SHEET);
        AI_SHEET = r18;
        DriveFileType r20 = new DriveFileType("BITABLE", 19, "bitable", CommonFileIconType.BITABLE);
        BITABLE = r20;
        DriveFileType r21 = new DriveFileType("MIAODA", 20, "miaoda", CommonFileIconType.MIAODA);
        MIAODA = r21;
        DriveFileType r22 = new DriveFileType("MINDNOTE", 21, "mindnote", CommonFileIconType.MINDNOTE);
        MINDNOTE = r22;
        DriveFileType r23 = new DriveFileType("UNKNOWN", 22, "unknown", CommonFileIconType.UNKNOWN);
        UNKNOWN = r23;
        DriveFileType[] r24 = {r0, r1, r2, r4, r6, r8, r10, r12, r11, r9, r7, r5, r3, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23};
        a = r24;
        b = EnumEntriesKt.enumEntries(r24);
        Companion = new a();
    }

    public static DriveFileType[] values() {
        return (DriveFileType[]) a.clone();
    }

    public final int getIconResId() {
        b r0 = b.a;
        CommonFileIconType r1 = this.iconType;
        r0.getClass();
        return b.a(r1);
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveFileType valueOf(String r1) {
        return (DriveFileType) r27.a.a(DriveFileType.class, r1);
    }

    public DriveFileType(String r1, int r2, String r3, CommonFileIconType r4) {
        super(r1, r2);
        this.value = r3;
        this.iconType = r4;
    }
}
