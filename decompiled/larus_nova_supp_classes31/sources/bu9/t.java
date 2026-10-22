package bu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/camera/EduIntentionCameraConfig;", "", "mainBotAutoDismissInstruction", "", "ugcBotAutoDismissInstruction", "mainBotCanContinueShot", "ugcBotCanContinueShot", "<init>", "(ZZZZ)V", "getMainBotAutoDismissInstruction", "()Z", "getUgcBotAutoDismissInstruction", "getMainBotCanContinueShot", "getUgcBotCanContinueShot", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class t {
    public static final t a = null;
    public static final t b = null;

    @SerializedName("main_bot_auto_dismiss_instruction")
    private final boolean mainBotAutoDismissInstruction;

    @SerializedName("main_bot_edu_suggest_continue_shot_question")
    private final boolean mainBotCanContinueShot;

    @SerializedName("ugc_bot_auto_dismiss_instruction")
    private final boolean ugcBotAutoDismissInstruction;

    @SerializedName("ugc_bot_edu_suggest_continue_shot_question")
    private final boolean ugcBotCanContinueShot;

    public static final class a {
    }

    public t() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.mainBotAutoDismissInstruction == r6.mainBotAutoDismissInstruction) goto L12;
        return false;
    L12:
        if (this.ugcBotAutoDismissInstruction == r6.ugcBotAutoDismissInstruction) goto L15;
        return false;
    L15:
        if (this.mainBotCanContinueShot == r6.mainBotCanContinueShot) goto L18;
        return false;
    L18:
        if (this.ugcBotCanContinueShot == r6.ugcBotCanContinueShot) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.mainBotAutoDismissInstruction == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.ugcBotAutoDismissInstruction == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.mainBotCanContinueShot == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.ugcBotCanContinueShot == true) goto L19;
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
        return "EduIntentionCameraConfig(mainBotAutoDismissInstruction=" + this.mainBotAutoDismissInstruction + ", ugcBotAutoDismissInstruction=" + this.ugcBotAutoDismissInstruction + ", mainBotCanContinueShot=" + this.mainBotCanContinueShot + ", ugcBotCanContinueShot=" + this.ugcBotCanContinueShot + ')';
    }

    static {
        a = new t(true, true, true, true);
        b = new t(false, false, false, false);
    }

    public final boolean a() {
        return this.mainBotAutoDismissInstruction;
    }

    public final boolean b() {
        return this.mainBotCanContinueShot;
    }

    public final boolean c() {
        return this.ugcBotAutoDismissInstruction;
    }

    public final boolean d() {
        return this.ugcBotCanContinueShot;
    }

    public t(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.mainBotAutoDismissInstruction = r1;
        this.ugcBotAutoDismissInstruction = r2;
        this.mainBotCanContinueShot = r3;
        this.ugcBotCanContinueShot = r4;
    }
}
