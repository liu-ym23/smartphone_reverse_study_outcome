package com.ss.android.lark.filedetail.impl.open;

import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001e\b\u0016\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010 R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010 R\u0014\u0010\f\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0014\u0010\u0011\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0014\u0010\u0013\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010 R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001c¨\u0006-"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/open/OpenFileParams;", "Ljava/io/Serializable;", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "messageId", BuildConfig.FLAVOR, "chatId", "jumpPosition", BuildConfig.FLAVOR, "isSecret", BuildConfig.FLAVOR, "isCrossWithKA", "showDownload", "showForward", "menuFlag", BuildConfig.FLAVOR, "mergeMsgChatId", "downloadFileScene", "threadId", "isFromFolderManager", "previewId", "authFileKey", "msgLinkToken", "<init>", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent;Ljava/lang/String;Ljava/lang/String;IZZZZJLjava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileContent", "()Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "getMessageId", "()Ljava/lang/String;", "getChatId", "getJumpPosition", "()I", "()Z", "getShowDownload", "getShowForward", "getMenuFlag", "()J", "getMergeMsgChatId", "getDownloadFileScene", "getThreadId", "getPreviewId", "getAuthFileKey", "getMsgLinkToken", "Companion", "Builder", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OpenFileParams implements Serializable {
    public static final b Companion = null;
    private final String authFileKey;
    private final String chatId;
    private final int downloadFileScene;
    private final FileContent fileContent;
    private final boolean isCrossWithKA;
    private final boolean isFromFolderManager;
    private final boolean isSecret;
    private final int jumpPosition;
    private final long menuFlag;
    private final String mergeMsgChatId;
    private final String messageId;
    private final String msgLinkToken;
    private final String previewId;
    private final boolean showDownload;
    private final boolean showForward;
    private final String threadId;

    public static final class a {
        public FileContent a;
        public String b;
        public int c;
        public String d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public long i;
        public String j;
        public int k;
        public String l;
        public String m;
        public String n;

        public final OpenFileParams a() {
            FileContent r1 = this.a;
            if (r1 == null) goto L5;
            FileContent r3 = r1;
        L6:
            String r2 = this.b;
            if (r2 == null) goto L9;
            String r20 = r2;
        L11:
            return new OpenFileParams(r3, r20, this.d, this.c, this.e, this.f, this.g, this.h, this.i, this.j, this.k, null, false, this.l, this.m, this.n);
        L9:
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            r20 = null;
            goto L11
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("fileContent");
            r3 = null;
            goto L6
        }

        public a() {
            this.c = -1;
            this.d = BuildConfig.FLAVOR;
            this.g = true;
            this.h = true;
            this.i = 15;
            this.j = BuildConfig.FLAVOR;
            this.k = -99;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public String getAuthFileKey() {
        return this.authFileKey;
    }

    public String getChatId() {
        return this.chatId;
    }

    public int getDownloadFileScene() {
        return this.downloadFileScene;
    }

    public FileContent getFileContent() {
        return this.fileContent;
    }

    public int getJumpPosition() {
        return this.jumpPosition;
    }

    public long getMenuFlag() {
        return this.menuFlag;
    }

    public String getMergeMsgChatId() {
        return this.mergeMsgChatId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsgLinkToken() {
        return this.msgLinkToken;
    }

    public String getPreviewId() {
        return this.previewId;
    }

    public boolean getShowDownload() {
        return this.showDownload;
    }

    public boolean getShowForward() {
        return this.showForward;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public boolean isCrossWithKA() {
        return this.isCrossWithKA;
    }

    public boolean isFromFolderManager() {
        return this.isFromFolderManager;
    }

    public boolean isSecret() {
        return this.isSecret;
    }

    public OpenFileParams(FileContent r7, String r8, String r9, int r10, boolean r11, boolean r12, boolean r13, boolean r14, long r15, String r17, int r18, String r19, boolean r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r7, "fileContent");
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r17, "mergeMsgChatId");
        this.fileContent = r7;
        this.messageId = r8;
        this.chatId = r9;
        this.jumpPosition = r10;
        this.isSecret = r11;
        this.isCrossWithKA = r12;
        this.showDownload = r13;
        this.showForward = r14;
        this.menuFlag = r15;
        this.mergeMsgChatId = r17;
        this.downloadFileScene = r18;
        this.threadId = r19;
        this.isFromFolderManager = r20;
        this.previewId = r21;
        this.authFileKey = r22;
        this.msgLinkToken = r23;
    }

    public /* synthetic */ OpenFileParams(FileContent r20, String r21, String r22, int r23, boolean r24, boolean r25, boolean r26, boolean r27, long r28, String r30, int r31, String r32, boolean r33, String r34, String r35, String r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L5;
        int r13 = -99;
    L6:
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r13, r32, r33, r34, r35, r36);
        return;
    L5:
        r13 = r31;
        goto L6
    }
}
