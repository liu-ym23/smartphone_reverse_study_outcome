package com.ss.android.lark.coremd.facade.bizext.image;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremd/facade/bizext/image/IMShowImageScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "IMAGE_MODE_POST", "IMAGE_MODE_POST_DETAIL", "IMAGE_MODE_THREAD_TOPIC", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMShowImageScene extends Enum<IMShowImageScene> {
    public static final IMShowImageScene IMAGE_MODE_POST = null;
    public static final IMShowImageScene IMAGE_MODE_POST_DETAIL = null;
    public static final IMShowImageScene IMAGE_MODE_THREAD_TOPIC = null;
    public static final /* synthetic */ IMShowImageScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IMShowImageScene> getEntries() {
        return b;
    }

    static {
        IMShowImageScene r0 = new IMShowImageScene("IMAGE_MODE_POST", 0);
        IMAGE_MODE_POST = r0;
        IMShowImageScene r1 = new IMShowImageScene("IMAGE_MODE_POST_DETAIL", 1);
        IMAGE_MODE_POST_DETAIL = r1;
        IMShowImageScene r3 = new IMShowImageScene("IMAGE_MODE_THREAD_TOPIC", 2);
        IMAGE_MODE_THREAD_TOPIC = r3;
        IMShowImageScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static IMShowImageScene[] values() {
        return (IMShowImageScene[]) a.clone();
    }

    public static IMShowImageScene valueOf(String r1) {
        return (IMShowImageScene) r27.a.a(IMShowImageScene.class, r1);
    }

    public IMShowImageScene(String r1, int r2) {
        super(r1, r2);
    }
}
