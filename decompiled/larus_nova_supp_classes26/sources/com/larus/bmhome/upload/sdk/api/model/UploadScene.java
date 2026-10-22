package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadScene;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_DIRECT_IMAGE", "CHAT_ATTACHMENT_IMAGE", "CHAT_ATTACHMENT_VIDEO", "CHAT_IMAGE_VLM", "CHAT_IMAGE_OCR", "CHAT_IMAGE_EDU", "CHAT_FILE_UPLOAD", "CREATION_USER_VIDEO", "SPRING_MAIN_VENUE", "UNKNOWN", "O_SERVER", "O_MOBILE_TMP", "O_ASSISTANT_FEEDBACK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadScene extends Enum<UploadScene> {
    public static final UploadScene CHAT_ATTACHMENT_IMAGE = null;
    public static final UploadScene CHAT_ATTACHMENT_VIDEO = null;
    public static final UploadScene CHAT_DIRECT_IMAGE = null;
    public static final UploadScene CHAT_FILE_UPLOAD = null;
    public static final UploadScene CHAT_IMAGE_EDU = null;
    public static final UploadScene CHAT_IMAGE_OCR = null;
    public static final UploadScene CHAT_IMAGE_VLM = null;
    public static final UploadScene CREATION_USER_VIDEO = null;
    public static final UploadScene O_ASSISTANT_FEEDBACK = null;
    public static final UploadScene O_MOBILE_TMP = null;
    public static final UploadScene O_SERVER = null;
    public static final UploadScene SPRING_MAIN_VENUE = null;
    public static final UploadScene UNKNOWN = null;
    public static final /* synthetic */ UploadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UploadScene> getEntries() {
        return b;
    }

    static {
        UploadScene r0 = new UploadScene("CHAT_DIRECT_IMAGE", 0);
        CHAT_DIRECT_IMAGE = r0;
        UploadScene r1 = new UploadScene("CHAT_ATTACHMENT_IMAGE", 1);
        CHAT_ATTACHMENT_IMAGE = r1;
        UploadScene r3 = new UploadScene("CHAT_ATTACHMENT_VIDEO", 2);
        CHAT_ATTACHMENT_VIDEO = r3;
        UploadScene r5 = new UploadScene("CHAT_IMAGE_VLM", 3);
        CHAT_IMAGE_VLM = r5;
        UploadScene r7 = new UploadScene("CHAT_IMAGE_OCR", 4);
        CHAT_IMAGE_OCR = r7;
        UploadScene r9 = new UploadScene("CHAT_IMAGE_EDU", 5);
        CHAT_IMAGE_EDU = r9;
        UploadScene r11 = new UploadScene("CHAT_FILE_UPLOAD", 6);
        CHAT_FILE_UPLOAD = r11;
        UploadScene r13 = new UploadScene("CREATION_USER_VIDEO", 7);
        CREATION_USER_VIDEO = r13;
        UploadScene r15 = new UploadScene("SPRING_MAIN_VENUE", 8);
        SPRING_MAIN_VENUE = r15;
        UploadScene r14 = new UploadScene("UNKNOWN", 9);
        UNKNOWN = r14;
        UploadScene r12 = new UploadScene("O_SERVER", 10);
        O_SERVER = r12;
        UploadScene r10 = new UploadScene("O_MOBILE_TMP", 11);
        O_MOBILE_TMP = r10;
        UploadScene r8 = new UploadScene("O_ASSISTANT_FEEDBACK", 12);
        O_ASSISTANT_FEEDBACK = r8;
        UploadScene[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static UploadScene[] values() {
        return (UploadScene[]) a.clone();
    }

    public static UploadScene valueOf(String r1) {
        return (UploadScene) a.a(UploadScene.class, r1);
    }

    public UploadScene(String r1, int r2) {
        super(r1, r2);
    }
}
