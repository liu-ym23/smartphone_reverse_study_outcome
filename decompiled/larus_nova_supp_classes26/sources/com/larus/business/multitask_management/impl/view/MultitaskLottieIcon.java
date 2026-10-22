package com.larus.business.multitask_management.impl.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/MultitaskLottieIcon;", "", "identifier", "", "lightAssetPath", "darkAssetPath", "staticResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getIdentifier", "()Ljava/lang/String;", "getLightAssetPath", "getDarkAssetPath", "getStaticResId", "()I", "RECORD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultitaskLottieIcon extends Enum<MultitaskLottieIcon> {
    public static final MultitaskLottieIcon RECORD = null;
    public static final /* synthetic */ MultitaskLottieIcon[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String darkAssetPath;
    private final String identifier;
    private final String lightAssetPath;
    private final int staticResId;

    public static EnumEntries<MultitaskLottieIcon> getEntries() {
        return b;
    }

    static {
        MultitaskLottieIcon r0 = new MultitaskLottieIcon();
        RECORD = r0;
        MultitaskLottieIcon[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public MultitaskLottieIcon() {
        super("RECORD", 0);
        this.identifier = "record";
        this.lightAssetPath = "multitask_lottie_record_light.json";
        this.darkAssetPath = "multitask_lottie_record_dark.json";
        this.staticResId = 2131243071;
    }

    public static MultitaskLottieIcon[] values() {
        return (MultitaskLottieIcon[]) a.clone();
    }

    public final String getDarkAssetPath() {
        return this.darkAssetPath;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getLightAssetPath() {
        return this.lightAssetPath;
    }

    public final int getStaticResId() {
        return this.staticResId;
    }

    public static MultitaskLottieIcon valueOf(String r1) {
        return (MultitaskLottieIcon) r27.a.a(MultitaskLottieIcon.class, r1);
    }
}
