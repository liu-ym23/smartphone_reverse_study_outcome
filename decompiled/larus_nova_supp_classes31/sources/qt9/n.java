package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/settings/provider/BasicExperienceBugFixConfig;", "", "fullScreenEditFragmentContainerViewFix", "", "messageInputFocusFix", "lowVersionImeInsetsCompatFix", "selectTextReferenceProtocolFix", "<init>", "(ZZZZ)V", "getFullScreenEditFragmentContainerViewFix", "()Z", "getMessageInputFocusFix", "getLowVersionImeInsetsCompatFix", "getSelectTextReferenceProtocolFix", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n {

    @SerializedName("full_screen_edit_fragment_container_view_fix")
    private final boolean fullScreenEditFragmentContainerViewFix;

    @SerializedName("low_version_ime_insets_compat_fix")
    private final boolean lowVersionImeInsetsCompatFix;

    @SerializedName("message_input_focus_fix")
    private final boolean messageInputFocusFix;

    @SerializedName("select_text_reference_protocol_fix")
    private final boolean selectTextReferenceProtocolFix;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.fullScreenEditFragmentContainerViewFix == r6.fullScreenEditFragmentContainerViewFix) goto L12;
        return false;
    L12:
        if (this.messageInputFocusFix == r6.messageInputFocusFix) goto L15;
        return false;
    L15:
        if (this.lowVersionImeInsetsCompatFix == r6.lowVersionImeInsetsCompatFix) goto L18;
        return false;
    L18:
        if (this.selectTextReferenceProtocolFix == r6.selectTextReferenceProtocolFix) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.fullScreenEditFragmentContainerViewFix == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.messageInputFocusFix == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.lowVersionImeInsetsCompatFix == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.selectTextReferenceProtocolFix == true) goto L19;
        r1 = 1237;
    L19:
        return r6 + r1;
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicExperienceBugFixConfig(fullScreenEditFragmentContainerViewFix=" + this.fullScreenEditFragmentContainerViewFix + ", messageInputFocusFix=" + this.messageInputFocusFix + ", lowVersionImeInsetsCompatFix=" + this.lowVersionImeInsetsCompatFix + ", selectTextReferenceProtocolFix=" + this.selectTextReferenceProtocolFix + ')';
    }

    public final boolean a() {
        return this.fullScreenEditFragmentContainerViewFix;
    }

    public final boolean b() {
        return this.lowVersionImeInsetsCompatFix;
    }

    public final boolean c() {
        return this.messageInputFocusFix;
    }

    public final boolean d() {
        return this.selectTextReferenceProtocolFix;
    }

    public n(int r1) {
        this.fullScreenEditFragmentContainerViewFix = true;
        this.messageInputFocusFix = true;
        this.lowVersionImeInsetsCompatFix = true;
        this.selectTextReferenceProtocolFix = true;
    }
}
