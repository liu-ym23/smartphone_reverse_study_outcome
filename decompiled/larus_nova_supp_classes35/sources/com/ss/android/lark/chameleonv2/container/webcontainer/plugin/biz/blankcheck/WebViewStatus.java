package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/WebViewStatus;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NORMAL", "DESTROY", "UN_ATTACHED", "UN_SHOWN", "UN_KNOWN", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebViewStatus extends Enum<WebViewStatus> {
    public static final WebViewStatus DESTROY = null;
    public static final WebViewStatus NORMAL = null;
    public static final WebViewStatus UN_ATTACHED = null;
    public static final WebViewStatus UN_KNOWN = null;
    public static final WebViewStatus UN_SHOWN = null;
    public static final /* synthetic */ WebViewStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<WebViewStatus> getEntries() {
        return b;
    }

    static {
        WebViewStatus r0 = new WebViewStatus("NORMAL", 0, "normal");
        NORMAL = r0;
        WebViewStatus r1 = new WebViewStatus("DESTROY", 1, "destroy");
        DESTROY = r1;
        WebViewStatus r2 = new WebViewStatus("UN_ATTACHED", 2, "un_attached");
        UN_ATTACHED = r2;
        WebViewStatus r4 = new WebViewStatus("UN_SHOWN", 3, "un_shown");
        UN_SHOWN = r4;
        WebViewStatus r6 = new WebViewStatus("UN_KNOWN", 4, "un_known");
        UN_KNOWN = r6;
        WebViewStatus[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static WebViewStatus[] values() {
        return (WebViewStatus[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static WebViewStatus valueOf(String r1) {
        return (WebViewStatus) r27.a.a(WebViewStatus.class, r1);
    }

    public WebViewStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
