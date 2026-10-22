package com.ss.android.lark.filedetail.impl.folder.manage.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FileType;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "FILE", "IMAGE", "STICKER", "AUDIO", "MEDIA", "LARK_LOG", "AVATAR", "THIRD_PARTY", "FOLDER", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileType extends Enum<FileType> {
    public static final FileType AUDIO = null;
    public static final FileType AVATAR = null;
    public static final a Companion = null;
    public static final FileType FILE = null;
    public static final FileType FOLDER = null;
    public static final FileType IMAGE = null;
    public static final FileType LARK_LOG = null;
    public static final FileType MEDIA = null;
    public static final FileType STICKER = null;
    public static final FileType THIRD_PARTY = null;
    public static final FileType UNKNOWN = null;
    public static final /* synthetic */ FileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FileType> getEntries() {
        return b;
    }

    static {
        FileType r0 = new FileType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        FileType r1 = new FileType("FILE", 1, 1);
        FILE = r1;
        FileType r3 = new FileType("IMAGE", 2, 2);
        IMAGE = r3;
        FileType r5 = new FileType("STICKER", 3, 3);
        STICKER = r5;
        FileType r7 = new FileType("AUDIO", 4, 4);
        AUDIO = r7;
        FileType r9 = new FileType("MEDIA", 5, 5);
        MEDIA = r9;
        FileType r11 = new FileType("LARK_LOG", 6, 6);
        LARK_LOG = r11;
        FileType r13 = new FileType("AVATAR", 7, 7);
        AVATAR = r13;
        FileType r15 = new FileType("THIRD_PARTY", 8, 8);
        THIRD_PARTY = r15;
        FileType r14 = new FileType("FOLDER", 9, 9);
        FOLDER = r14;
        FileType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static FileType[] values() {
        return (FileType[]) a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static FileType valueOf(String r1) {
        return (FileType) r27.a.a(FileType.class, r1);
    }

    public FileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
