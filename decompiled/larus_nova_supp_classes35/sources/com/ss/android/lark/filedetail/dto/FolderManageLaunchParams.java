package com.ss.android.lark.filedetail.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0002ijB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010^\u001a\u00020_2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0011H\u0016J\b\u0010a\u001a\u00020\u0011H\u0016J \u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001c\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001a\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u001a\u0010L\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0013\"\u0004\bN\u0010\u0015R\u001c\u0010O\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\n\"\u0004\bQ\u0010\fR\u001c\u0010R\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010\fR\u001c\u0010U\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\n\"\u0004\bW\u0010\fR\u001c\u0010X\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010\fR\u001a\u0010[\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0013\"\u0004\b]\u0010\u0015¨\u0006k"}, d2 = {"Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "messageId", BuildConfig.FLAVOR, "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "chatId", "getChatId", "setChatId", "jumpPosition", BuildConfig.FLAVOR, "getJumpPosition", "()I", "setJumpPosition", "(I)V", "needHitPoint", BuildConfig.FLAVOR, "getNeedHitPoint", "()Z", "setNeedHitPoint", "(Z)V", "from", "getFrom", "setFrom", "downloadFileScene", "getDownloadFileScene", "setDownloadFileScene", "folderKey", "getFolderKey", "setFolderKey", "folderName", "getFolderName", "setFolderName", "mergeMsgId", "getMergeMsgId", "setMergeMsgId", "mergeChatId", "getMergeChatId", "setMergeChatId", "threadId", "getThreadId", "setThreadId", "threadPosition", "getThreadPosition", "setThreadPosition", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "folderSize", BuildConfig.FLAVOR, "getFolderSize", "()J", "setFolderSize", "(J)V", "favoriteMessageInfo", "Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "getFavoriteMessageInfo", "()Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;", "setFavoriteMessageInfo", "(Lcom/ss/android/lark/chat/entity/favorite/FavoriteMessageInfo;)V", "showSaveToDrive", "getShowSaveToDrive", "setShowSaveToDrive", "showForward", "getShowForward", "setShowForward", "previewFileType", "getPreviewFileType", "setPreviewFileType", "previewId", "getPreviewId", "setPreviewId", "msgLinkToken", "getMsgLinkToken", "setMsgLinkToken", "authFileKey", "getAuthFileKey", "setAuthFileKey", "originMergeForwardId", "getOriginMergeForwardId", "setOriginMergeForwardId", "chatType", "getChatType", "setChatType", "writeToParcel", BuildConfig.FLAVOR, "flags", "describeContents", "convertFileDetailParams", "Lcom/ss/android/lark/filedetail/dto/FileDetailLaunchParams;", "context", "Landroid/content/Context;", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "mergeForwardMsgId", "Builder", "CREATOR", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderManageLaunchParams implements Parcelable {
    public static final a CREATOR = null;
    public String a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public Message m;
    public long n;
    public FavoriteMessageInfo o;
    public boolean p;
    public boolean q;
    public int r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;

    public static final class a implements Parcelable.Creator<FolderManageLaunchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderManageLaunchParams createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Intrinsics.checkNotNullParameter(r8, "parcel");
            FolderManageLaunchParams r1 = new FolderManageLaunchParams();
            String r0 = r8.readString();
            String r2 = BuildConfig.FLAVOR;
            if (r0 != null) goto L5;
            r0 = BuildConfig.FLAVOR;
        L5:
            r1.a = r0;
            String r3 = r8.readString();
            if (r3 != null) goto L8;
            r3 = BuildConfig.FLAVOR;
        L8:
            r1.b = r3;
            r1.c = r8.readInt();
            boolean r4 = true;
            if (r8.readByte() == 0) goto L11;
            boolean r5 = true;
        L12:
            r1.d = r5;
            r1.e = r8.readInt();
            r1.f = r8.readInt();
            String r6 = r8.readString();
            if (r6 != null) goto L15;
            r6 = BuildConfig.FLAVOR;
        L15:
            r1.g = r6;
            String r7 = r8.readString();
            if (r7 == null) goto L19;
            r2 = r7;
        L19:
            r1.h = r2;
            r1.i = r8.readString();
            r1.j = r8.readString();
            r1.k = r8.readString();
            r1.l = r8.readInt();
            r1.m = (Message) r8.readSerializable();
            r1.n = r8.readLong();
            r1.o = (FavoriteMessageInfo) r8.readSerializable();
            if (r8.readByte() == 0) goto L22;
            boolean r9 = true;
        L23:
            r1.p = r9;
            if (r8.readByte() != 0) goto L27;
            r4 = false;
        L27:
            r1.q = r4;
            r1.r = r8.readInt();
            r1.s = r8.readString();
            r1.u = r8.readString();
            r1.t = r8.readString();
            r1.v = r8.readString();
            r1.w = r8.readInt();
            return r1;
        L22:
            r9 = false;
            goto L23
        L11:
            r5 = false;
            goto L12
        }

        @Override // android.os.Parcelable.Creator
        public final FolderManageLaunchParams[] newArray(int r1) {
            return new FolderManageLaunchParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public FolderManageLaunchParams() {
        this.a = BuildConfig.FLAVOR;
        this.b = BuildConfig.FLAVOR;
        this.c = -1;
        this.f = -99;
        this.g = BuildConfig.FLAVOR;
        this.h = BuildConfig.FLAVOR;
        this.l = -1;
        this.r = 1;
        this.w = Chat.Type.UNKNOWN.getNumber();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeInt(this.c);
        r3.writeByte(this.d ? 1 : 0);
        r3.writeInt(this.e);
        r3.writeInt(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
        r3.writeInt(this.l);
        r3.writeSerializable(this.m);
        r3.writeLong(this.n);
        r3.writeSerializable(this.o);
        r3.writeByte(this.p ? 1 : 0);
        r3.writeByte(this.q ? 1 : 0);
        r3.writeInt(this.r);
        r3.writeString(this.s);
        r3.writeString(this.u);
        r3.writeString(this.t);
        r3.writeString(this.v);
        r3.writeInt(this.w);
    }
}
