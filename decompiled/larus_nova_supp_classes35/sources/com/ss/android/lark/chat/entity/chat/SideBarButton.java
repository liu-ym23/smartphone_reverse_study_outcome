package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/SideBarButton;", "Ljava/io/Serializable;", "labelName", BuildConfig.FLAVOR, "iconKey", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabelName", "()Ljava/lang/String;", "getIconKey", "getUrl", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarButton implements Serializable {
    private final String iconKey;
    private final String labelName;
    private final String url;

    public SideBarButton() {
        this(null, null, null, 7, null);
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final String getUrl() {
        return this.url;
    }

    public SideBarButton(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "labelName");
        Intrinsics.checkNotNullParameter(r3, "iconKey");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.labelName = r2;
        this.iconKey = r3;
        this.url = r4;
    }

    public /* synthetic */ SideBarButton(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = BuildConfig.FLAVOR;
    L11:
        this(r2, r3, r4);
    }
}
