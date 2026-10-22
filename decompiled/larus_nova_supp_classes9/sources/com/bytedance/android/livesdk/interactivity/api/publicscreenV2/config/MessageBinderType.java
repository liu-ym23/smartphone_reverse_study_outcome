package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessageBinderType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", "Companion", "a", "CommonMessageModelBinder", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MessageBinderType extends Enum<MessageBinderType> {
    public static final MessageBinderType CommonMessageModelBinder = null;
    public static final a Companion = null;
    public static final /* synthetic */ MessageBinderType[] a = null;
    public static final MessageBinderType[] b = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        MessageBinderType r1 = new MessageBinderType();
        CommonMessageModelBinder = r1;
        a = new MessageBinderType[]{r1};
        Companion = new a();
        b = values();
    }

    public static MessageBinderType valueOf(String r1) {
        return (MessageBinderType) r27.a.a(MessageBinderType.class, r1);
    }

    public static MessageBinderType[] values() {
        return (MessageBinderType[]) a.clone();
    }

    public MessageBinderType() {
        super("CommonMessageModelBinder", 0);
        this.type = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
    }

    public static final /* synthetic */ MessageBinderType[] access$getVALUES$cp() {
        return b;
    }

    public final int getType() {
        return this.type;
    }
}
