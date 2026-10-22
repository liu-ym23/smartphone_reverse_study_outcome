package com.ss.android.lark.chat.entity.image;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/entity/image/ImageAuthType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PREVIEW_AUTH", "SHARE_AUTH", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageAuthType extends Enum<ImageAuthType> {
    public static final ImageAuthType PREVIEW_AUTH = null;
    public static final ImageAuthType SHARE_AUTH = null;
    public static final /* synthetic */ ImageAuthType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImageAuthType> getEntries() {
        return b;
    }

    static {
        ImageAuthType r0 = new ImageAuthType("PREVIEW_AUTH", 0);
        PREVIEW_AUTH = r0;
        ImageAuthType r1 = new ImageAuthType("SHARE_AUTH", 1);
        SHARE_AUTH = r1;
        ImageAuthType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ImageAuthType[] values() {
        return (ImageAuthType[]) a.clone();
    }

    public static ImageAuthType valueOf(String r1) {
        return (ImageAuthType) r27.a.a(ImageAuthType.class, r1);
    }

    public ImageAuthType(String r1, int r2) {
        super(r1, r2);
    }
}
