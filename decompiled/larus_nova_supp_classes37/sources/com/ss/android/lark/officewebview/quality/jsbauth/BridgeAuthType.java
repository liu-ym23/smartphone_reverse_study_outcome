package com.ss.android.lark.officewebview.quality.jsbauth;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/jsbauth/BridgeAuthType;", "", "authType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAuthType", "()Ljava/lang/String;", "Secure", "Private", "Public", "Companion", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum BridgeAuthType extends Enum<BridgeAuthType> {
    public static final a Companion = null;
    public static final BridgeAuthType Private = null;
    public static final BridgeAuthType Public = null;
    public static final BridgeAuthType Secure = null;
    public static final /* synthetic */ BridgeAuthType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String authType;

    public static EnumEntries<BridgeAuthType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType$a] */
    static {
        BridgeAuthType r0 = new BridgeAuthType("Secure", 0, "secure");
        Secure = r0;
        BridgeAuthType r1 = new BridgeAuthType("Private", 1, "private");
        Private = r1;
        BridgeAuthType r3 = new BridgeAuthType("Public", 2, "public");
        Public = r3;
        BridgeAuthType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static BridgeAuthType[] values() {
        return (BridgeAuthType[]) a.clone();
    }

    public final String getAuthType() {
        return this.authType;
    }

    public static BridgeAuthType valueOf(String r1) {
        return (BridgeAuthType) r27.a.a(BridgeAuthType.class, r1);
    }

    public BridgeAuthType(String r1, int r2, String r3) {
        super(r1, r2);
        this.authType = r3;
    }
}
