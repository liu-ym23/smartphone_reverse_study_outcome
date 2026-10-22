package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType;", "MentionChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenConfig$InterceptorType extends Enum<PublicScreenConfig$InterceptorType> {
    public static final PublicScreenConfig$InterceptorType MentionChat = null;
    public static final /* synthetic */ PublicScreenConfig$InterceptorType[] a = null;

    static {
        PublicScreenConfig$InterceptorType r1 = new PublicScreenConfig$InterceptorType();
        MentionChat = r1;
        a = new PublicScreenConfig$InterceptorType[]{r1};
    }

    public static PublicScreenConfig$InterceptorType valueOf(String r1) {
        return (PublicScreenConfig$InterceptorType) r27.a.a(PublicScreenConfig$InterceptorType.class, r1);
    }

    public static PublicScreenConfig$InterceptorType[] values() {
        return (PublicScreenConfig$InterceptorType[]) a.clone();
    }

    public PublicScreenConfig$InterceptorType() {
        super("MentionChat", 0);
    }
}
