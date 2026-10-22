package com.ss.android.lark.chat.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOC", "SHEET", "BITABLE", "MINDNOTE", "FILE", "SLIDE", "WIKI", "DOCX", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocType extends Enum<DocType> implements Serializable {
    public static final DocType BITABLE = null;
    public static final a Companion = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType FILE = null;
    public static final DocType MINDNOTE = null;
    public static final DocType SHEET = null;
    public static final DocType SLIDE = null;
    public static final DocType UNKNOWN = null;
    public static final DocType WIKI = null;
    public static final /* synthetic */ DocType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static DocType a(int r0) {
            switch(r0) {
                case 0: goto L13;
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L14;
            };
        L14:
            return DocType.UNKNOWN;
        L15:
            return DocType.DOCX;
        L16:
            return DocType.WIKI;
        L17:
            return DocType.SLIDE;
        L18:
            return DocType.FILE;
        L19:
            return DocType.MINDNOTE;
        L20:
            return DocType.BITABLE;
        L21:
            return DocType.SHEET;
        L22:
            return DocType.DOC;
        L13:
            return DocType.UNKNOWN;
        }
    }

    public static EnumEntries<DocType> getEntries() {
        return b;
    }

    static {
        DocType r0 = new DocType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        DocType r1 = new DocType("DOC", 1, 1);
        DOC = r1;
        DocType r3 = new DocType("SHEET", 2, 2);
        SHEET = r3;
        DocType r5 = new DocType("BITABLE", 3, 3);
        BITABLE = r5;
        DocType r7 = new DocType("MINDNOTE", 4, 4);
        MINDNOTE = r7;
        DocType r9 = new DocType("FILE", 5, 5);
        FILE = r9;
        DocType r11 = new DocType("SLIDE", 6, 6);
        SLIDE = r11;
        DocType r13 = new DocType("WIKI", 7, 7);
        WIKI = r13;
        DocType r15 = new DocType("DOCX", 8, 8);
        DOCX = r15;
        DocType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new a();
    }

    public static DocType[] values() {
        return (DocType[]) a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public final int getValue() {
        return this.value;
    }

    public static DocType valueOf(String r1) {
        return (DocType) r27.a.a(DocType.class, r1);
    }

    public DocType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
