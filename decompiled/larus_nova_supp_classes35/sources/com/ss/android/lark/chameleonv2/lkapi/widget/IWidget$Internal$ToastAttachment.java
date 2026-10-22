package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastAttachment;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CURRENT_WEBVIEW", "CURRENT_WINDOW", "CUSTOM_WEBVIEW", "CUSTOM_WINDOW", "PRIMARY_WINDOW", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$Internal$ToastAttachment extends Enum<IWidget$Internal$ToastAttachment> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$Internal$ToastAttachment[] $VALUES = null;
    public static final IWidget$Internal$ToastAttachment CURRENT_WEBVIEW = null;
    public static final IWidget$Internal$ToastAttachment CURRENT_WINDOW = null;
    public static final IWidget$Internal$ToastAttachment CUSTOM_WEBVIEW = null;
    public static final IWidget$Internal$ToastAttachment CUSTOM_WINDOW = null;
    public static final a Companion = null;
    public static final IWidget$Internal$ToastAttachment PRIMARY_WINDOW = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ IWidget$Internal$ToastAttachment[] $values() {
        return new IWidget$Internal$ToastAttachment[]{CURRENT_WEBVIEW, CURRENT_WINDOW, CUSTOM_WEBVIEW, CUSTOM_WINDOW, PRIMARY_WINDOW};
    }

    public static EnumEntries<IWidget$Internal$ToastAttachment> getEntries() {
        return $ENTRIES;
    }

    static {
        CURRENT_WEBVIEW = new IWidget$Internal$ToastAttachment("CURRENT_WEBVIEW", 0, "current-webview");
        CURRENT_WINDOW = new IWidget$Internal$ToastAttachment("CURRENT_WINDOW", 1, "current-window");
        CUSTOM_WEBVIEW = new IWidget$Internal$ToastAttachment("CUSTOM_WEBVIEW", 2, "custom-webview");
        CUSTOM_WINDOW = new IWidget$Internal$ToastAttachment("CUSTOM_WINDOW", 3, "custom-window");
        PRIMARY_WINDOW = new IWidget$Internal$ToastAttachment("PRIMARY_WINDOW", 4, "primary-window");
        IWidget$Internal$ToastAttachment[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static IWidget$Internal$ToastAttachment[] values() {
        return (IWidget$Internal$ToastAttachment[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IWidget$Internal$ToastAttachment valueOf(String r1) {
        return (IWidget$Internal$ToastAttachment) r27.a.a(IWidget$Internal$ToastAttachment.class, r1);
    }

    private IWidget$Internal$ToastAttachment(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
