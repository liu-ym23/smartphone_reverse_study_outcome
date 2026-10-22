package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonChannel;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT_CHANNEL", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ChameleonChannel extends Enum<ChameleonChannel> {
    private static final /* synthetic */ ChameleonChannel[] $VALUES = null;
    public static final ChameleonChannel DEFAULT_CHANNEL = null;
    private final String value;

    private static final /* synthetic */ ChameleonChannel[] $values() {
        return new ChameleonChannel[]{DEFAULT_CHANNEL};
    }

    public static ChameleonChannel valueOf(String r1) {
        return (ChameleonChannel) a.a(ChameleonChannel.class, r1);
    }

    public static ChameleonChannel[] values() {
        return (ChameleonChannel[]) $VALUES.clone();
    }

    static {
        DEFAULT_CHANNEL = new ChameleonChannel("DEFAULT_CHANNEL", 0, "Chameleon_default_channel");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private ChameleonChannel(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
