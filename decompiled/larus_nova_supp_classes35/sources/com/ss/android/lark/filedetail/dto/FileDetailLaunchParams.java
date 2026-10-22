package com.ss.android.lark.filedetail.dto;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.filedetail.impl.folder.manage.service.FileConfigValue;
import com.ss.android.lark.filedetail.impl.open.OpenFileParams;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001aB¯\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020\u0015\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010+\u001a\u00020\u0015¢\u0006\u0004\b,\u0010-J\u0006\u0010_\u001a\u00020`R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010\u0010\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010?R\u0014\u0010\u0013\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010?R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0016\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010?R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010\u001a\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u0011\u0010\u001b\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0014\u0010\u001c\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010=R\u0014\u0010\u001d\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010?R\u0014\u0010\u001e\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010?R\u0011\u0010\u001f\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010?R\u0014\u0010 \u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010AR\u0016\u0010!\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0014\u0010\"\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010?R\u0011\u0010#\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bM\u0010?R\u0011\u0010$\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010=R\u0011\u0010%\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bO\u0010AR\u001c\u0010&\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010RR\u001c\u0010'\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010=\"\u0004\bT\u0010RR\u001c\u0010(\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010=\"\u0004\bV\u0010RR\u001c\u0010)\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010=\"\u0004\bX\u0010RR\u001a\u0010*\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010?\"\u0004\bZ\u0010[R\u001a\u0010+\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010A\"\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/ss/android/lark/filedetail/dto/FileDetailLaunchParams;", "Lcom/ss/android/lark/filedetail/impl/open/OpenFileParams;", "Ljava/io/Serializable;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "favoriteMessage", "Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "favoriteSourceMessageStatus", "Lcom/ss/android/lark/chat/entity/message/Message$Status;", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "messageId", BuildConfig.FLAVOR, "chatId", "isSecret", BuildConfig.FLAVOR, "isCrossWithKA", "jumpPosition", BuildConfig.FLAVOR, "isSearch", "needHitPoint", "from", BuildConfig.FLAVOR, "menuFlag", "mergeMsgId", "mergeMsgChatId", "showDownload", "showForward", "showMenuAndFuncButton", "downloadFileScene", "threadId", "isFromFolderManager", "forwardAsFile", "originMergeForwardId", "threadPosition", "senderTenantId", "previewId", "authFileKey", "msgLinkToken", "onlyShowCancel", "chatType", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/ss/android/lark/chat/entity/message/Message;Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;Lcom/ss/android/lark/chat/entity/message/Message$Status;Lcom/ss/android/lark/chat/entity/message/content/FileContent;Ljava/lang/String;Ljava/lang/String;ZZIZZJJLjava/lang/String;Ljava/lang/String;ZZZILjava/lang/String;ZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getContext", "()Ljava/lang/ref/WeakReference;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "getFavoriteMessage", "()Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "getFavoriteSourceMessageStatus", "()Lcom/ss/android/lark/chat/entity/message/Message$Status;", "setFavoriteSourceMessageStatus", "(Lcom/ss/android/lark/chat/entity/message/Message$Status;)V", "getFileContent", "()Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "getMessageId", "()Ljava/lang/String;", "getChatId", "()Z", "getJumpPosition", "()I", "getNeedHitPoint", "getFrom", "()J", "getMenuFlag", "getMergeMsgId", "getMergeMsgChatId", "getShowDownload", "getShowForward", "getShowMenuAndFuncButton", "getDownloadFileScene", "getThreadId", "getForwardAsFile", "getOriginMergeForwardId", "getThreadPosition", "getSenderTenantId", "setSenderTenantId", "(Ljava/lang/String;)V", "getPreviewId", "setPreviewId", "getAuthFileKey", "setAuthFileKey", "getMsgLinkToken", "setMsgLinkToken", "getOnlyShowCancel", "setOnlyShowCancel", "(Z)V", "getChatType", "setChatType", "(I)V", "convertFolderLaunchParams", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "Builder", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileDetailLaunchParams extends OpenFileParams {
    public final transient WeakReference<Context> a;
    private String authFileKey;
    private final String chatId;
    private int chatType;
    private final int downloadFileScene;
    private final FavoriteMessageInfo favoriteMessage;
    private Message.Status favoriteSourceMessageStatus;
    private final FileContent fileContent;
    private final boolean forwardAsFile;
    private final long from;
    private final boolean isCrossWithKA;
    private final boolean isFromFolderManager;
    private final boolean isSearch;
    private final boolean isSecret;
    private final int jumpPosition;
    private final long menuFlag;
    private final String mergeMsgChatId;
    private final String mergeMsgId;
    private Message message;
    private final String messageId;
    private String msgLinkToken;
    private final boolean needHitPoint;
    private boolean onlyShowCancel;
    private final String originMergeForwardId;
    private String previewId;
    private String senderTenantId;
    private final boolean showDownload;
    private final boolean showForward;
    private final boolean showMenuAndFuncButton;
    private final String threadId;
    private final int threadPosition;

    public static final class a {
        public String A;
        public int B;
        public final Context a;
        public Message b;
        public FavoriteMessageInfo c;
        public String d;
        public FileContent e;
        public boolean f;
        public boolean g;
        public int h;
        public final String i;
        public long j;
        public boolean k;
        public boolean l;
        public long m;
        public String n;
        public String o;
        public final boolean p;
        public boolean q;
        public boolean r;
        public int s;
        public String t;
        public boolean u;
        public boolean v;
        public String w;
        public int x;
        public String y;
        public String z;

        public final FileDetailLaunchParams a() {
            WeakReference r2 = new WeakReference(this.a);
            Message r3 = this.b;
            FavoriteMessageInfo r4 = this.c;
            FileContent r1 = this.e;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("fileContent");
            r1 = null;
        L6:
            Message.Status r5 = null;
            return new FileDetailLaunchParams(r2, r3, r4, r5, r1, this.i, this.d, this.f, this.g, this.h, this.k, this.l, this.j, this.m, this.n, this.o, this.q, this.r, this.p, this.s, this.t, this.u, this.v, this.w, this.x, null, this.y, this.z, this.A, false, this.B, 33554440, null);
        }

        public final Context getContext() {
            return this.a;
        }

        public a(Context r4) {
            this.a = r4;
            this.d = BuildConfig.FLAVOR;
            this.h = -1;
            this.i = BuildConfig.FLAVOR;
            this.m = 15;
            this.n = BuildConfig.FLAVOR;
            this.o = BuildConfig.FLAVOR;
            this.p = true;
            this.q = true;
            this.r = true;
            this.s = -99;
            this.w = BuildConfig.FLAVOR;
            this.x = -1;
            this.y = BuildConfig.FLAVOR;
            this.z = BuildConfig.FLAVOR;
            this.A = BuildConfig.FLAVOR;
            this.B = Chat.Type.UNKNOWN.getNumber();
        }

        public final void b(boolean r5) {
            this.r = r5;
            long r0 = this.m | 2;
            this.m = r0;
            if (r5 == true) goto L6;
            this.m = r0 ^ 2;
            return;
        }

        public final void c(boolean r5) {
            this.q = r5;
            long r0 = this.m | 1;
            this.m = r0;
            if (r5 == true) goto L6;
            this.m = r0 ^ 1;
            return;
        }

        public a(Context r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "message");
            this(r2);
            this.b = r3;
            this.i = r3.getId();
            FileContent r4 = (FileContent) r3.getContent();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.e = r4;
        }

        public a(Context r2, FileContent r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "fileContent");
            Intrinsics.checkNotNullParameter(r4, "messageId");
            this(r2);
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            this.e = r3;
            this.i = r4;
        }
    }

    public final FolderManageLaunchParams convertFolderLaunchParams() {
        String r1 = getMessageId();
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Chat.Type.UNKNOWN.getNumber();
        String r2 = getChatId();
        Intrinsics.checkNotNullParameter(r2, "chatId");
        int r3 = getJumpPosition();
        boolean r4 = this.needHitPoint;
        String r5 = this.mergeMsgId;
        String r6 = getMergeMsgChatId();
        int r7 = getDownloadFileScene();
        String r8 = getFileContent().getKey();
        Intrinsics.checkNotNullParameter(r8, "folderKey");
        String r9 = getFileContent().getName();
        Intrinsics.checkNotNullParameter(r9, "folderName");
        String r10 = getThreadId();
        if (r10 != null) goto L5;
        r10 = BuildConfig.FLAVOR;
    L5:
        int r11 = this.threadPosition;
        long r12 = getFileContent().getSize();
        boolean r14 = getShowForward();
        boolean r15 = getShowDownload();
        String r16 = getPreviewId();
        String r17 = getAuthFileKey();
        String r18 = getMsgLinkToken();
        String r19 = this.originMergeForwardId;
        Intrinsics.checkNotNullParameter(r19, "originMergeForwardId");
        int r110 = this.chatType;
        Message r111 = this.message;
        if (r111 != null) goto L9;
        r111 = null;
    L9:
        FavoriteMessageInfo r112 = this.favoriteMessage;
        if (r112 != null) goto L13;
        r112 = null;
    L13:
        FileConfigValue r22 = ExtractConfig.a;
        FavoriteMessageInfo r26 = r112;
        if (ExtractConfig.a(getFileContent().getSize(), getFileContent().getName()) == false) goto L16;
        int r13 = 0;
    L18:
        if (getMergeMsgChatId().length() <= 0) goto L20;
        boolean r23 = true;
    L21:
        if (r23 == false) goto L23;
        int r113 = 5;
    L42:
        FolderManageLaunchParams r114 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r114.a = r1;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r114.b = r2;
        r114.c = r3;
        r114.d = r4;
        r114.e = r113;
        r114.f = r7;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r114.g = r8;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r114.h = r9;
        r114.i = r5;
        r114.j = r6;
        r114.k = r10;
        r114.l = r11;
        r114.m = r111;
        r114.n = r12;
        r114.o = r26;
        r114.p = r15;
        r114.q = r14;
        r114.r = r13;
        r114.s = r16;
        r114.t = r18;
        r114.u = r17;
        r114.v = r19;
        r114.w = r110;
        return r114;
    L23:
        long r115 = this.from;
        if (r115 != 1) goto L27;
        r113 = 0;
        goto L42
    L27:
        if (r115 != 2) goto L30;
        r113 = 2;
        goto L42
    L30:
        if (r115 != 6) goto L33;
        r113 = 4;
        goto L42
    L33:
        if (r115 != 5) goto L36;
        r113 = 6;
        goto L42
    L36:
        if (r115 != 3) goto L39;
        r113 = 7;
        goto L42
    L39:
        if (r115 != 4) goto L41;
        r113 = 8;
        goto L42
    L41:
        r113 = -1;
        goto L42
    L20:
        r23 = false;
        goto L21
    L16:
        r13 = 2;
        goto L18
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getAuthFileKey() {
        return this.authFileKey;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getChatId() {
        return this.chatId;
    }

    public final int getChatType() {
        return this.chatType;
    }

    public final WeakReference<Context> getContext() {
        return this.a;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public int getDownloadFileScene() {
        return this.downloadFileScene;
    }

    public final FavoriteMessageInfo getFavoriteMessage() {
        return this.favoriteMessage;
    }

    public final Message.Status getFavoriteSourceMessageStatus() {
        return this.favoriteSourceMessageStatus;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public FileContent getFileContent() {
        return this.fileContent;
    }

    public final boolean getForwardAsFile() {
        return this.forwardAsFile;
    }

    public final long getFrom() {
        return this.from;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public int getJumpPosition() {
        return this.jumpPosition;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public long getMenuFlag() {
        return this.menuFlag;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getMergeMsgChatId() {
        return this.mergeMsgChatId;
    }

    public final String getMergeMsgId() {
        return this.mergeMsgId;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getMessageId() {
        return this.messageId;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getMsgLinkToken() {
        return this.msgLinkToken;
    }

    public final boolean getNeedHitPoint() {
        return this.needHitPoint;
    }

    public final boolean getOnlyShowCancel() {
        return this.onlyShowCancel;
    }

    public final String getOriginMergeForwardId() {
        return this.originMergeForwardId;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getPreviewId() {
        return this.previewId;
    }

    public final String getSenderTenantId() {
        return this.senderTenantId;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public boolean getShowDownload() {
        return this.showDownload;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public boolean getShowForward() {
        return this.showForward;
    }

    public final boolean getShowMenuAndFuncButton() {
        return this.showMenuAndFuncButton;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public String getThreadId() {
        return this.threadId;
    }

    public final int getThreadPosition() {
        return this.threadPosition;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public boolean isCrossWithKA() {
        return this.isCrossWithKA;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public boolean isFromFolderManager() {
        return this.isFromFolderManager;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    @Override // com.ss.android.lark.filedetail.impl.open.OpenFileParams
    public boolean isSecret() {
        return this.isSecret;
    }

    public void setAuthFileKey(String r1) {
        this.authFileKey = r1;
    }

    public final void setChatType(int r1) {
        this.chatType = r1;
    }

    public final void setFavoriteSourceMessageStatus(Message.Status r1) {
        this.favoriteSourceMessageStatus = r1;
    }

    public final void setMessage(Message r1) {
        this.message = r1;
    }

    public void setMsgLinkToken(String r1) {
        this.msgLinkToken = r1;
    }

    public final void setOnlyShowCancel(boolean r1) {
        this.onlyShowCancel = r1;
    }

    public void setPreviewId(String r1) {
        this.previewId = r1;
    }

    public final void setSenderTenantId(String r1) {
        this.senderTenantId = r1;
    }

    public FileDetailLaunchParams(WeakReference<Context> r27, Message r28, FavoriteMessageInfo r29, Message.Status r30, FileContent r31, String r32, String r33, boolean r34, boolean r35, int r36, boolean r37, boolean r38, long r39, long r41, String r43, String r44, boolean r45, boolean r46, boolean r47, int r48, String r49, boolean r50, boolean r51, String r52, int r53, String r54, String r55, String r56, String r57, boolean r58, int r59) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r31, "fileContent");
        Intrinsics.checkNotNullParameter(r32, "messageId");
        Intrinsics.checkNotNullParameter(r33, "chatId");
        Intrinsics.checkNotNullParameter(r43, "mergeMsgId");
        Intrinsics.checkNotNullParameter(r44, "mergeMsgChatId");
        Intrinsics.checkNotNullParameter(r52, "originMergeForwardId");
        super(r31, r32, r33, r36, r34, r35, r45, r46, r41, r44, r48, r49, r50, r55, r56, r57);
        this.a = r27;
        this.message = r28;
        this.favoriteMessage = r29;
        this.favoriteSourceMessageStatus = r30;
        this.fileContent = r31;
        this.messageId = r32;
        this.chatId = r33;
        this.isSecret = r34;
        this.isCrossWithKA = r35;
        this.jumpPosition = r36;
        this.isSearch = r37;
        this.needHitPoint = r38;
        this.from = r39;
        this.menuFlag = r41;
        this.mergeMsgId = r43;
        this.mergeMsgChatId = r44;
        this.showDownload = r45;
        this.showForward = r46;
        this.showMenuAndFuncButton = r47;
        this.downloadFileScene = r48;
        this.threadId = r49;
        this.isFromFolderManager = r50;
        this.forwardAsFile = r51;
        this.originMergeForwardId = r52;
        this.threadPosition = r53;
        this.senderTenantId = r54;
        this.previewId = r55;
        this.authFileKey = r56;
        this.msgLinkToken = r57;
        this.onlyShowCancel = r58;
        this.chatType = r59;
    }

    public /* synthetic */ FileDetailLaunchParams(WeakReference r38, Message r39, FavoriteMessageInfo r40, Message.Status r41, FileContent r42, String r43, String r44, boolean r45, boolean r46, int r47, boolean r48, boolean r49, long r50, long r52, String r54, String r55, boolean r56, boolean r57, boolean r58, int r59, String r60, boolean r61, boolean r62, String r63, int r64, String r65, String r66, String r67, String r68, boolean r69, int r70, int r71, DefaultConstructorMarker r72) {
        if ((r71 & 8) == 0) goto L5;
        Message.Status r7 = null;
    L7:
        if ((r71 & 256) == 0) goto L9;
        boolean r12 = false;
    L11:
        if ((r71 & 16384) == 0) goto L13;
        String r20 = BuildConfig.FLAVOR;
    L15:
        if ((32768 & r71) == 0) goto L17;
        String r21 = BuildConfig.FLAVOR;
    L19:
        if ((65536 & r71) == 0) goto L21;
        boolean r22 = true;
    L23:
        if ((131072 & r71) == 0) goto L25;
        boolean r23 = true;
    L27:
        if ((262144 & r71) == 0) goto L29;
        boolean r24 = true;
    L31:
        if ((524288 & r71) == 0) goto L33;
        int r25 = -99;
    L35:
        if ((4194304 & r71) == 0) goto L37;
        boolean r28 = false;
    L39:
        if ((33554432 & r71) == 0) goto L41;
        String r31 = null;
    L43:
        if ((67108864 & r71) == 0) goto L45;
        String r32 = null;
    L47:
        if ((536870912 & r71) == 0) goto L49;
        boolean r35 = false;
    L51:
        if ((r71 & 1073741824) == 0) goto L53;
        int r36 = 0;
    L54:
        this(r38, r39, r40, r7, r42, r43, r44, r45, r12, r47, r48, r49, r50, r52, r20, r21, r22, r23, r24, r25, r60, r61, r28, r63, r64, r31, r32, r67, r68, r35, r36);
        return;
    L53:
        r36 = r70;
        goto L54
    L49:
        r35 = r69;
        goto L51
    L45:
        r32 = r66;
        goto L47
    L41:
        r31 = r65;
        goto L43
    L37:
        r28 = r62;
        goto L39
    L33:
        r25 = r59;
        goto L35
    L29:
        r24 = r58;
        goto L31
    L25:
        r23 = r57;
        goto L27
    L21:
        r22 = r56;
        goto L23
    L17:
        r21 = r55;
        goto L19
    L13:
        r20 = r54;
        goto L15
    L9:
        r12 = r46;
        goto L11
    L5:
        r7 = r41;
        goto L7
    }
}
