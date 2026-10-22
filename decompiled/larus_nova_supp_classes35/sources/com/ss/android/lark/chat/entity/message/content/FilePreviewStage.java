package com.ss.android.lark.chat.entity.message.content;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FilePreviewStage;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "UnknownStage", "Normal", "Encrypted", "NotSupportedType", "NotSupportedSize", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilePreviewStage extends Enum<FilePreviewStage> {
    public static final a Companion = null;
    public static final FilePreviewStage Encrypted = null;
    public static final FilePreviewStage Normal = null;
    public static final FilePreviewStage NotSupportedSize = null;
    public static final FilePreviewStage NotSupportedType = null;
    public static final FilePreviewStage UnknownStage = null;
    public static final /* synthetic */ FilePreviewStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FilePreviewStage> getEntries() {
        return b;
    }

    static {
        FilePreviewStage r0 = new FilePreviewStage("UnknownStage", 0);
        UnknownStage = r0;
        FilePreviewStage r1 = new FilePreviewStage("Normal", 1);
        Normal = r1;
        FilePreviewStage r3 = new FilePreviewStage("Encrypted", 2);
        Encrypted = r3;
        FilePreviewStage r5 = new FilePreviewStage("NotSupportedType", 3);
        NotSupportedType = r5;
        FilePreviewStage r7 = new FilePreviewStage("NotSupportedSize", 4);
        NotSupportedSize = r7;
        FilePreviewStage[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static FilePreviewStage[] values() {
        return (FilePreviewStage[]) a.clone();
    }

    @JvmStatic
    public static final FilePreviewStage fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return UnknownStage;
    L17:
        return NotSupportedSize;
    L18:
        return NotSupportedType;
    L19:
        return Encrypted;
    L15:
        return Normal;
    }

    public static FilePreviewStage valueOf(String r1) {
        return (FilePreviewStage) r27.a.a(FilePreviewStage.class, r1);
    }

    public FilePreviewStage(String r1, int r2) {
        super(r1, r2);
    }
}
