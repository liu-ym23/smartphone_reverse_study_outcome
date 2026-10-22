package com.ss.android.lark.chat.base.model.dispatch;

import com.bytedance.lark.pb.media.v1.PreprocessResourceRequest;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/base/model/dispatch/ResourceType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FILE", "IMAGE", "MEDIA", "toSdkFileType", "Lcom/bytedance/lark/pb/media/v1/PreprocessResourceRequest$FileType;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType FILE = null;
    public static final ResourceType IMAGE = null;
    public static final ResourceType MEDIA = null;
    public static final /* synthetic */ ResourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceType.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static EnumEntries<ResourceType> getEntries() {
        return b;
    }

    static {
        ResourceType r0 = new ResourceType("FILE", 0, 1);
        FILE = r0;
        ResourceType r1 = new ResourceType("IMAGE", 1, 2);
        IMAGE = r1;
        ResourceType r4 = new ResourceType("MEDIA", 2, 5);
        MEDIA = r4;
        ResourceType[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) a.clone();
    }

    public final PreprocessResourceRequest.FileType toSdkFileType() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L10;
        return PreprocessResourceRequest.FileType.MEDIA;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return PreprocessResourceRequest.FileType.IMAGE;
    L13:
        return PreprocessResourceRequest.FileType.FILE;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceType valueOf(String r1) {
        return (ResourceType) r27.a.a(ResourceType.class, r1);
    }

    public ResourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
