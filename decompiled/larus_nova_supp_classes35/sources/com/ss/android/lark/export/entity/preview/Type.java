package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Type;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN", "EMPTY", "LINEAR_LAYOUT", "FLEX_LAYOUT", "HEADER", "RICHTEXT", "IMAGE", "CHATTERS_PREVIEW", "BUTTON", "ICON_BUTTON", "TEXT_BUTTON", "TIME", "TEXT", "TAG_LIST", "SPIN_BUTTON", "AVATAR", "VIDEO", "CARD_CONTAINER", "DOC_IMAGE", "LOADING", "TIME_ZONE", "OVERSIZED_TEXT", "ENGINE", "IMAGE_CONTAINER", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Type extends Enum<Type> implements Serializable {
    public static final Type AVATAR = null;
    public static final Type BUTTON = null;
    public static final Type CARD_CONTAINER = null;
    public static final Type CHATTERS_PREVIEW = null;
    public static final a Companion = null;
    public static final Type DOC_IMAGE = null;
    public static final Type EMPTY = null;
    public static final Type ENGINE = null;
    public static final Type FLEX_LAYOUT = null;
    public static final Type HEADER = null;
    public static final Type ICON_BUTTON = null;
    public static final Type IMAGE = null;
    public static final Type IMAGE_CONTAINER = null;
    public static final Type LINEAR_LAYOUT = null;
    public static final Type LOADING = null;
    public static final Type OVERSIZED_TEXT = null;
    public static final Type RICHTEXT = null;
    public static final Type SPIN_BUTTON = null;
    public static final Type TAG_LIST = null;
    public static final Type TEXT = null;
    public static final Type TEXT_BUTTON = null;
    public static final Type TIME = null;
    public static final Type TIME_ZONE = null;
    public static final Type UNKNOWN = null;
    public static final Type VIDEO = null;
    public static final /* synthetic */ Type[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Type a(int r1) {
            if (r1 == 0) goto L34;
            if (r1 == 1) goto L57;
            if (r1 == 2) goto L56;
            if (r1 == 521) goto L55;
            switch(r1) {
                case 501: goto L54;
                case 502: goto L53;
                case 503: goto L52;
                case 504: goto L51;
                case 505: goto L50;
                case 506: goto L49;
                case 507: goto L48;
                case 508: goto L47;
                case 509: goto L46;
                case 510: goto L45;
                case 511: goto L44;
                case 512: goto L43;
                case 513: goto L42;
                case 514: goto L41;
                case 515: goto L40;
                case 516: goto L39;
                case 517: goto L38;
                case 518: goto L37;
                case 519: goto L36;
                default: goto L35;
            };
        L35:
            return Type.UNKNOWN;
        L36:
            return Type.ENGINE;
        L37:
            return Type.OVERSIZED_TEXT;
        L38:
            return Type.TIME_ZONE;
        L39:
            return Type.LOADING;
        L40:
            return Type.DOC_IMAGE;
        L41:
            return Type.CARD_CONTAINER;
        L42:
            return Type.VIDEO;
        L43:
            return Type.AVATAR;
        L44:
            return Type.SPIN_BUTTON;
        L45:
            return Type.TAG_LIST;
        L46:
            return Type.TEXT;
        L47:
            return Type.TIME;
        L48:
            return Type.TEXT_BUTTON;
        L49:
            return Type.ICON_BUTTON;
        L50:
            return Type.BUTTON;
        L51:
            return Type.CHATTERS_PREVIEW;
        L52:
            return Type.IMAGE;
        L53:
            return Type.RICHTEXT;
        L54:
            return Type.HEADER;
        L55:
            return Type.IMAGE_CONTAINER;
        L56:
            return Type.FLEX_LAYOUT;
        L57:
            return Type.LINEAR_LAYOUT;
        L34:
            return Type.EMPTY;
        }
    }

    public static EnumEntries<Type> getEntries() {
        return b;
    }

    static {
        Type r0 = new Type("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        Type r1 = new Type("EMPTY", 1, 0);
        EMPTY = r1;
        Type r3 = new Type("LINEAR_LAYOUT", 2, 1);
        LINEAR_LAYOUT = r3;
        Type r5 = new Type("FLEX_LAYOUT", 3, 2);
        FLEX_LAYOUT = r5;
        Type r7 = new Type("HEADER", 4, DocErrorCode.ERRCODE_RENDERING_NOT_READY);
        HEADER = r7;
        Type r9 = new Type("RICHTEXT", 5, DocErrorCode.ERRCODE_RENDER_CACHE_START_NOT_READY);
        RICHTEXT = r9;
        Type r11 = new Type("IMAGE", 6, DocErrorCode.ERRCODE_RENDER_CACHE_END_NOT_READY);
        IMAGE = r11;
        Type r13 = new Type("CHATTERS_PREVIEW", 7, DocErrorCode.ERRCODE_PULL_DATA_START_NOT_READY);
        CHATTERS_PREVIEW = r13;
        Type r12 = new Type("BUTTON", 8, DocErrorCode.ERRCODE_PULL_DATA_END_NOT_READY);
        BUTTON = r12;
        Type r10 = new Type("ICON_BUTTON", 9, DocErrorCode.ERRCODE_RENDER_DOC_START_NOT_READY);
        ICON_BUTTON = r10;
        Type r8 = new Type("TEXT_BUTTON", 10, DocErrorCode.ERRCODE_RENDER_DOC_END_NOT_READY);
        TEXT_BUTTON = r8;
        Type r6 = new Type("TIME", 11, 508);
        TIME = r6;
        Type r4 = new Type("TEXT", 12, 509);
        TEXT = r4;
        Type r2 = new Type("TAG_LIST", 13, 510);
        TAG_LIST = r2;
        Type r14 = new Type("SPIN_BUTTON", 14, 511);
        SPIN_BUTTON = r14;
        Type r15 = new Type("AVATAR", 15, 512);
        AVATAR = r15;
        Type r16 = new Type("VIDEO", 16, 513);
        VIDEO = r16;
        Type r17 = new Type("CARD_CONTAINER", 17, 514);
        CARD_CONTAINER = r17;
        Type r18 = new Type("DOC_IMAGE", 18, 515);
        DOC_IMAGE = r18;
        Type r19 = new Type("LOADING", 19, 516);
        LOADING = r19;
        Type r20 = new Type("TIME_ZONE", 20, 517);
        TIME_ZONE = r20;
        Type r21 = new Type("OVERSIZED_TEXT", 21, 518);
        OVERSIZED_TEXT = r21;
        Type r22 = new Type("ENGINE", 22, 519);
        ENGINE = r22;
        Type r23 = new Type("IMAGE_CONTAINER", 23, 521);
        IMAGE_CONTAINER = r23;
        Type[] r24 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23};
        a = r24;
        b = EnumEntriesKt.enumEntries(r24);
        Companion = new a();
    }

    public static Type[] values() {
        return (Type[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Type valueOf(String r1) {
        return (Type) r27.a.a(Type.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public Type(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
