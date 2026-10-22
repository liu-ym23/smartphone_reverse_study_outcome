package com.ss.android.lark.chat.entity.message.content;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 f2\u00020\u0001:\u0002fgB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0006\u0010[\u001a\u00020BJ\b\u0010\\\u001a\u0004\u0018\u00010OJ\u0012\u0010`\u001a\u00020B2\b\u0010a\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010b\u001a\u00020B2\b\u0010a\u001a\u0004\u0018\u00010\u0001H\u0016J\u000e\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020(R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001c\u00103\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR\u0013\u0010?\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b@\u0010\tR\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010C\"\u0004\bD\u0010ER.\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010Gj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR6\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O0Nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O`PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR\u001c\u0010X\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\t\"\u0004\bZ\u0010\u000bR\u001a\u0010]\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000b¨\u0006h"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MediaContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "content", "(Lcom/ss/android/lark/chat/entity/message/content/MediaContent;)V", "key", BuildConfig.FLAVOR, "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", IPortraitService.NAME, "getName", "setName", "size", BuildConfig.FLAVOR, "getSize", "()J", "setSize", "(J)V", "mime", "getMime", "setMime", "source", "Lcom/ss/android/lark/chat/entity/message/content/MediaContent$Source;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/MediaContent$Source;", "setSource", "(Lcom/ss/android/lark/chat/entity/message/content/MediaContent$Source;)V", "imageSet", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "getImageSet", "()Lcom/ss/android/lark/chat/entity/image/ImageSet;", "setImageSet", "(Lcom/ss/android/lark/chat/entity/image/ImageSet;)V", "duration", "getDuration", "setDuration", "progress", BuildConfig.FLAVOR, "getProgress", "()I", "setProgress", "(I)V", "originPath", "getOriginPath", "setOriginPath", "filePath", "getFilePath", "setFilePath", "compressPath", "getCompressPath", "setCompressPath", "fileState", "Lcom/ss/android/lark/chat/entity/message/content/FileState;", "getFileState", "()Lcom/ss/android/lark/chat/entity/message/content/FileState;", "setFileState", "(Lcom/ss/android/lark/chat/entity/message/content/FileState;)V", "url", "getUrl", "setUrl", "playPath", "getPlayPath", "isOriginal", BuildConfig.FLAVOR, "()Z", "setOriginal", "(Z)V", "riskObjectKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRiskObjectKeys", "()Ljava/util/ArrayList;", "setRiskObjectKeys", "(Ljava/util/ArrayList;)V", "cleanResourceKeyScene", "Ljava/util/HashMap;", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "Lkotlin/collections/HashMap;", "getCleanResourceKeyScene", "()Ljava/util/HashMap;", "setCleanResourceKeyScene", "(Ljava/util/HashMap;)V", "firstScreenImageUploadId", "getFirstScreenImageUploadId", "setFirstScreenImageUploadId", "mediaUploadId", "getMediaUploadId", "setMediaUploadId", "resourceIsCleaned", "currentResourceScene", "cryptoToken", "getCryptoToken", "setCryptoToken", "isContentSame", "diffable", "isItemSame", "setUploadProgress", BuildConfig.FLAVOR, "uploadProgress", "Companion", "Source", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "MediaContent")
public final class MediaContent extends Content {
    public static final int COMPRESS_PROGRESS_PROPORTION = 60;
    public static final a Companion = null;
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private String compressPath;
    private String cryptoToken;
    private long duration;
    private String filePath;
    private FileState fileState;
    private String firstScreenImageUploadId;
    private ImageSet imageSet;
    private boolean isOriginal;
    private String key;
    private String mediaUploadId;
    private String mime;
    private String name;
    private String originPath;
    private int progress;
    private ArrayList<String> riskObjectKeys;
    private long size;
    private Source source;
    private String url;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MediaContent$Source;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "LARK", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final a Companion = null;
        public static final Source LARK = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Source r1 = new Source("LARK", 1, 1);
            LARK = r1;
            Source[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ResourceCleanScene currentResourceScene() {
        ResourceCleanScene r0 = this.cleanResourceKeyScene.get(this.key);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final String getPlayPath() {
        if (TextUtils.isEmpty(this.originPath) == true) goto L6;
        return this.originPath;
    L6:
        return this.filePath;
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    public MediaContent() {
        this.key = BuildConfig.FLAVOR;
        this.name = BuildConfig.FLAVOR;
        this.mime = BuildConfig.FLAVOR;
        this.source = Source.LARK;
        this.originPath = BuildConfig.FLAVOR;
        this.filePath = BuildConfig.FLAVOR;
        this.compressPath = BuildConfig.FLAVOR;
        this.url = BuildConfig.FLAVOR;
        this.cleanResourceKeyScene = new HashMap();
        this.cryptoToken = BuildConfig.FLAVOR;
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final String getCompressPath() {
        return this.compressPath;
    }

    public final String getCryptoToken() {
        return this.cryptoToken;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final FileState getFileState() {
        return this.fileState;
    }

    public final String getFirstScreenImageUploadId() {
        return this.firstScreenImageUploadId;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMediaUploadId() {
        return this.mediaUploadId;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginPath() {
        return this.originPath;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final ArrayList<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public final long getSize() {
        return this.size;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isOriginal() {
        return this.isOriginal;
    }

    public MediaContent(MediaContent r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        this.key = BuildConfig.FLAVOR;
        this.name = BuildConfig.FLAVOR;
        this.mime = BuildConfig.FLAVOR;
        this.source = Source.LARK;
        this.originPath = BuildConfig.FLAVOR;
        this.filePath = BuildConfig.FLAVOR;
        this.compressPath = BuildConfig.FLAVOR;
        this.url = BuildConfig.FLAVOR;
        this.cleanResourceKeyScene = new HashMap();
        this.cryptoToken = BuildConfig.FLAVOR;
        this.key = r3.key;
        this.name = r3.name;
        this.size = r3.size;
        this.mime = r3.mime;
        this.source = r3.source;
        this.imageSet = r3.imageSet;
        this.duration = r3.duration;
        this.progress = r3.progress;
        this.originPath = r3.originPath;
        this.filePath = r3.filePath;
        this.compressPath = r3.compressPath;
        this.fileState = r3.fileState;
        this.url = r3.url;
        this.isOriginal = r3.isOriginal;
        this.cryptoToken = r3.cryptoToken;
        this.cleanResourceKeyScene = r3.cleanResourceKeyScene;
        this.firstScreenImageUploadId = r3.firstScreenImageUploadId;
        this.mediaUploadId = r3.mediaUploadId;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r4) {
        if (r4 != null) goto L4;
    L21:
        return false;
    L4:
        if ((r4 instanceof MediaContent) == false) goto L21;
        MediaContent r5 = (MediaContent) r4;
        if (this.progress != r5.progress) goto L21;
        ArrayList<String> r0 = this.riskObjectKeys;
        Integer r1 = null;
        if (r0 == null) goto L10;
        Integer r2 = Integer.valueOf(r0.size());
    L11:
        ArrayList<String> r3 = r5.riskObjectKeys;
        if (r3 == null) goto L15;
        r1 = Integer.valueOf(r3.size());
    L15:
        if (Intrinsics.areEqual(r2, r1) == false) goto L21;
        if (Intrinsics.areEqual(this.cleanResourceKeyScene, r5.cleanResourceKeyScene) == false) goto L21;
        if (Intrinsics.areEqual(this.mediaUploadId, r5.mediaUploadId) == false) goto L21;
        return true;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r3) {
        if ((r3 instanceof MediaContent) == true) goto L5;
        return false;
    L5:
        if (this != r3) goto L8;
        return true;
    L8:
        ImageSet r4 = ((MediaContent) r3).imageSet;
        ImageSet r0 = this.imageSet;
        if (r0 == null) goto L14;
        if (r4 == null) goto L15;
        Intrinsics.checkNotNull(r0);
        return Intrinsics.areEqual(r0.getKey(), r4.getKey());
    L15:
        return false;
    L14:
        return false;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cleanResourceKeyScene = r2;
    }

    public final void setCompressPath(String r1) {
        this.compressPath = r1;
    }

    public final void setCryptoToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cryptoToken = r2;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setFilePath(String r1) {
        this.filePath = r1;
    }

    public final void setFileState(FileState r1) {
        this.fileState = r1;
    }

    public final void setFirstScreenImageUploadId(String r1) {
        this.firstScreenImageUploadId = r1;
    }

    public final void setImageSet(ImageSet r1) {
        this.imageSet = r1;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setMediaUploadId(String r1) {
        this.mediaUploadId = r1;
    }

    public final void setMime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mime = r2;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setOriginPath(String r1) {
        this.originPath = r1;
    }

    public final void setOriginal(boolean r1) {
        this.isOriginal = r1;
    }

    public final void setProgress(int r1) {
        this.progress = r1;
    }

    public final void setRiskObjectKeys(ArrayList<String> r1) {
        this.riskObjectKeys = r1;
    }

    public final void setSize(long r1) {
        this.size = r1;
    }

    public final void setSource(Source r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public final void setUploadProgress(int r3) {
        this.progress = (int) (60 + (r3 * 0.4f));
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Content) r1);
    }
}
