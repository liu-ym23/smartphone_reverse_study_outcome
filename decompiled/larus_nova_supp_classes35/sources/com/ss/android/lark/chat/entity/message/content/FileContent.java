package com.ss.android.lark.chat.entity.message.content;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002OPB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0012\u0010G\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0015\u0010K\u001a\u0004\u0018\u00010\u001f2\u0006\u0010L\u001a\u00020M¢\u0006\u0002\u0010NR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R6\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000202`3X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010!\"\u0004\b@\u0010#R\u001c\u0010A\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001c\u0010D\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000b¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "Lcom/ss/android/lark/chat/entity/message/content/BaseFileContent;", "<init>", "()V", "content", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent;)V", "mime", BuildConfig.FLAVOR, "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "filePath", "getFilePath", "setFilePath", "uriString", "getUriString", "setUriString", "fileState", "Lcom/ss/android/lark/chat/entity/message/content/FileState;", "getFileState", "()Lcom/ss/android/lark/chat/entity/message/content/FileState;", "setFileState", "(Lcom/ss/android/lark/chat/entity/message/content/FileState;)V", "progress", BuildConfig.FLAVOR, "getProgress", "()I", "setProgress", "(I)V", "speed", BuildConfig.FLAVOR, "getSpeed", "()J", "setSpeed", "(J)V", "isEncrypted", BuildConfig.FLAVOR, "()Z", "setEncrypted", "(Z)V", "riskObjectKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRiskObjectKeys", "()Ljava/util/ArrayList;", "setRiskObjectKeys", "(Ljava/util/ArrayList;)V", "previewHangPoints", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Lkotlin/collections/LinkedHashMap;", "getPreviewHangPoints", "()Ljava/util/LinkedHashMap;", "setPreviewHangPoints", "(Ljava/util/LinkedHashMap;)V", "fileAbility", "Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", "getFileAbility", "()Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", "setFileAbility", "(Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;)V", "lastUpdateTime", "getLastUpdateTime", "setLastUpdateTime", "lastUpdateChatterName", "getLastUpdateChatterName", "setLastUpdateChatterName", "fileUploadId", "getFileUploadId", "setFileUploadId", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "isItemSame", "getFd", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Long;", "Companion", "FileAbility", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "FileContent")
public final class FileContent extends BaseFileContent<FileContent> {
    public static final a Companion = null;
    private FileAbility fileAbility;
    private String filePath;
    private FileState fileState;
    private String fileUploadId;
    private boolean isEncrypted;
    private String lastUpdateChatterName;
    private long lastUpdateTime;
    private String mime;
    private LinkedHashMap<String, PreviewHangPoint> previewHangPoints;
    private int progress;
    private ArrayList<String> riskObjectKeys;
    private long speed;
    private String uriString;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FileContent$FileAbility;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SUPPORT_EDIT", "SUPPORT_PREVIEW", "NOT_SUPPORT_PREVIEW", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileAbility extends Enum<FileAbility> {
        public static final a Companion = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN = null;
        public static final /* synthetic */ FileAbility[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FileAbility> getEntries() {
            return b;
        }

        static {
            FileAbility r0 = new FileAbility("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FileAbility r1 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r1;
            FileAbility r3 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r3;
            FileAbility r5 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r5;
            FileAbility[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static FileAbility[] values() {
            return (FileAbility[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FileAbility fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return UNKNOWN;
        L14:
            return NOT_SUPPORT_PREVIEW;
        L15:
            return SUPPORT_PREVIEW;
        L12:
            return SUPPORT_EDIT;
        }

        public static FileAbility valueOf(String r1) {
            return (FileAbility) r27.a.a(FileAbility.class, r1);
        }

        public FileAbility(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FileContent() {
        this.mime = BuildConfig.FLAVOR;
        this.fileState = FileState.DOWNLOAD;
        this.previewHangPoints = new LinkedHashMap();
    }

    public final FileAbility getFileAbility() {
        return this.fileAbility;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final FileState getFileState() {
        return this.fileState;
    }

    public final String getFileUploadId() {
        return this.fileUploadId;
    }

    public final String getLastUpdateChatterName() {
        return this.lastUpdateChatterName;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final String getMime() {
        return this.mime;
    }

    public final LinkedHashMap<String, PreviewHangPoint> getPreviewHangPoints() {
        return this.previewHangPoints;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final ArrayList<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public final long getSpeed() {
        return this.speed;
    }

    public final String getUriString() {
        return this.uriString;
    }

    public final boolean isEncrypted() {
        return this.isEncrypted;
    }

    public FileContent(FileContent r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        this.mime = BuildConfig.FLAVOR;
        this.fileState = FileState.DOWNLOAD;
        this.previewHangPoints = new LinkedHashMap();
        setKey(r3.getKey());
        setName(r3.getName());
        setSize(r3.getSize());
        this.mime = r3.mime;
        this.filePath = r3.filePath;
        setNameSpace(r3.getNameSpace());
        setSource(r3.getSource());
        setSaveToDrive(r3.getSaveToDrive());
        this.progress = r3.progress;
        this.fileState = r3.fileState;
        setInMyNutStore(r3.isInMyNutStore());
        setLanTransStatus(r3.getLanTransStatus());
        this.uriString = r3.uriString;
        this.speed = r3.speed;
        this.isEncrypted = r3.isEncrypted;
        this.riskObjectKeys = r3.riskObjectKeys;
        this.previewHangPoints = r3.previewHangPoints;
        this.fileAbility = r3.fileAbility;
        this.lastUpdateTime = r3.lastUpdateTime;
        this.lastUpdateChatterName = r3.lastUpdateChatterName;
        this.fileUploadId = r3.fileUploadId;
    }

    public final Long getFd(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = this.uriString;
        if (r0 == null) goto L20;
        Uri r1 = UriProtector.parse(r0);
        ContentResolver r7 = r6.getContentResolver();
        if (r7 == null) goto L20;
        ParcelFileDescriptor r8 = a(r7, r1);     // Catch: Exception -> L8
    L17:
        if (r8 == null) goto L20;
        return Long.valueOf(r8.detachFd());
    L8:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L12;
    L15:
        Log.e("FileContent", "cannot open fd in r, message: " + e.getMessage() + ", uri: " + this.uriString);
    L16:
        r8 = null;
        goto L17
    L12:
        if ((e instanceof SecurityException) == true) goto L15;
        Log.e("FileContent", "cannot open fd in r, message: " + e.getMessage() + ", uri: " + this.uriString);
    L20:
        return null;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r7) {
        if (super.isContentSame(r7) == true) goto L5;
        return false;
    L5:
        if ((r7 instanceof FileContent) == false) goto L47;
        FileContent r8 = (FileContent) r7;
        if (this.progress == r8.progress) goto L9;
        return false;
    L9:
        if (this.speed == r8.speed) goto L11;
        return false;
    L11:
        if (this.isEncrypted != r8.isEncrypted) goto L50;
        ArrayList<String> r0 = this.riskObjectKeys;
        Integer r2 = null;
        if (r0 == null) goto L15;
        Integer r1 = Integer.valueOf(r0.size());
    L16:
        ArrayList<String> r3 = r8.riskObjectKeys;
        if (r3 == null) goto L20;
        r2 = Integer.valueOf(r3.size());
    L20:
        if (Intrinsics.areEqual(r1, r2) == true) goto L22;
        return false;
    L22:
        if (this.fileAbility == r8.fileAbility) goto L24;
        return false;
    L24:
        if (this.lastUpdateTime == r8.lastUpdateTime) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.lastUpdateChatterName, r8.lastUpdateChatterName) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.fileUploadId, r8.fileUploadId) == true) goto L30;
        return false;
    L30:
        if (this.previewHangPoints.size() != r8.previewHangPoints.size()) goto L56;
        LinkedHashMap<String, PreviewHangPoint> r4 = this.previewHangPoints;
        if (r4.isEmpty() == false) goto L34;
    L33:
        boolean r9 = true;
    L40:
        if (r9 == false) goto L57;
        return true;
    L57:
        return false;
    L34:
        Iterator<Map.Entry<String, PreviewHangPoint>> r5 = r4.entrySet().iterator();
    L36:
        if (r5.hasNext() == false) goto L33;
        Map.Entry<String, PreviewHangPoint> r6 = r5.next();
        if (y28.a.c(r6.getValue(), r8.previewHangPoints.get(r6.getKey())) == true) goto L36;
        r9 = false;
        goto L40
    L56:
        return false;
    L15:
        r1 = null;
        goto L16
    L50:
        return false;
    L47:
        return false;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r2 instanceof FileContent) == false) goto L8;
        if (Intrinsics.areEqual(getKey(), ((FileContent) r2).getKey()) == false) goto L8;
        return true;
    }

    public final void setEncrypted(boolean r1) {
        this.isEncrypted = r1;
    }

    public final void setFileAbility(FileAbility r1) {
        this.fileAbility = r1;
    }

    public final void setFilePath(String r1) {
        this.filePath = r1;
    }

    public final void setFileState(FileState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileState = r2;
    }

    public final void setFileUploadId(String r1) {
        this.fileUploadId = r1;
    }

    public final void setLastUpdateChatterName(String r1) {
        this.lastUpdateChatterName = r1;
    }

    public final void setLastUpdateTime(long r1) {
        this.lastUpdateTime = r1;
    }

    public final void setMime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mime = r2;
    }

    public final void setPreviewHangPoints(LinkedHashMap<String, PreviewHangPoint> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previewHangPoints = r2;
    }

    public final void setProgress(int r1) {
        this.progress = r1;
    }

    public final void setRiskObjectKeys(ArrayList<String> r1) {
        this.riskObjectKeys = r1;
    }

    public final void setSpeed(long r1) {
        this.speed = r1;
    }

    public final void setUriString(String r1) {
        this.uriString = r1;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseFileContent, com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Content) r1);
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }
}
