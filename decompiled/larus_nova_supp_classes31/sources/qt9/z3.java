package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003JÛ\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0011HÖ\u0001J\t\u00108\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u00069"}, d2 = {"Lcom/larus/settings/provider/RouterConfig;", "", "enableOuterLinkWhiteListFromNet", "", "enablePushWhiteListFromNet", "enableXOpenWhiteListFromNet", "enablePostSwitchRouting", "outerLinkWhiteList", "", "", "pushWhiteList", "xOpenWhiteList", "outerLinkBlockList", "pushBlockList", "xOpenBlockList", "outerLinkQueryBlockList", "judgeIsFromOuterStrategy", "", "isDeeplinkAutoSendDowngrade", "enableChatSchemaOptions", "<init>", "(ZZZZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IZZ)V", "getEnableOuterLinkWhiteListFromNet", "()Z", "getEnablePushWhiteListFromNet", "getEnableXOpenWhiteListFromNet", "getEnablePostSwitchRouting", "getOuterLinkWhiteList", "()Ljava/util/List;", "getPushWhiteList", "getXOpenWhiteList", "getOuterLinkBlockList", "getPushBlockList", "getXOpenBlockList", "getOuterLinkQueryBlockList", "getJudgeIsFromOuterStrategy", "()I", "getEnableChatSchemaOptions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class z3 {

    @SerializedName("chat_schema_options_enable")
    private final boolean enableChatSchemaOptions;

    @SerializedName("router_outer_link_check_enable")
    private final boolean enableOuterLinkWhiteListFromNet;

    @SerializedName("post_switch_route_enable")
    private final boolean enablePostSwitchRouting;

    @SerializedName("router_push_check_enable")
    private final boolean enablePushWhiteListFromNet;

    @SerializedName("router_xopen_check_enable")
    private final boolean enableXOpenWhiteListFromNet;

    @SerializedName("router_auto_send_downgrade")
    private final boolean isDeeplinkAutoSendDowngrade;

    @SerializedName("judge_is_from_outer_strategy")
    private final int judgeIsFromOuterStrategy;

    @SerializedName("block_list_for_outer_link")
    private final List<String> outerLinkBlockList;

    @SerializedName("block_query_list_for_outer_link")
    private final List<String> outerLinkQueryBlockList;

    @SerializedName("white_list_for_outer_link")
    private final List<String> outerLinkWhiteList;

    @SerializedName("block_list_for_push")
    private final List<String> pushBlockList;

    @SerializedName("white_list_for_push")
    private final List<String> pushWhiteList;

    @SerializedName("block_list_for_xopen")
    private final List<String> xOpenBlockList;

    @SerializedName("white_list_for_xopen")
    private final List<String> xOpenWhiteList;

    public z3() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z3) == true) goto L8;
        return false;
    L8:
        z3 r6 = (z3) r5;
        if (this.enableOuterLinkWhiteListFromNet == r6.enableOuterLinkWhiteListFromNet) goto L12;
        return false;
    L12:
        if (this.enablePushWhiteListFromNet == r6.enablePushWhiteListFromNet) goto L15;
        return false;
    L15:
        if (this.enableXOpenWhiteListFromNet == r6.enableXOpenWhiteListFromNet) goto L18;
        return false;
    L18:
        if (this.enablePostSwitchRouting == r6.enablePostSwitchRouting) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.outerLinkWhiteList, r6.outerLinkWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pushWhiteList, r6.pushWhiteList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.xOpenWhiteList, r6.xOpenWhiteList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.outerLinkBlockList, r6.outerLinkBlockList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pushBlockList, r6.pushBlockList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.xOpenBlockList, r6.xOpenBlockList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.outerLinkQueryBlockList, r6.outerLinkQueryBlockList) == true) goto L42;
        return false;
    L42:
        if (this.judgeIsFromOuterStrategy == r6.judgeIsFromOuterStrategy) goto L45;
        return false;
    L45:
        if (this.isDeeplinkAutoSendDowngrade == r6.isDeeplinkAutoSendDowngrade) goto L48;
        return false;
    L48:
        if (this.enableChatSchemaOptions == r6.enableChatSchemaOptions) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableOuterLinkWhiteListFromNet == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enablePushWhiteListFromNet == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableXOpenWhiteListFromNet == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enablePostSwitchRouting == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        List<String> r9 = this.outerLinkWhiteList;
        int r10 = 0;
        if (r9 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r8 + r11) * 31;
        List<String> r13 = this.pushWhiteList;
        if (r13 != null) goto L25;
        int r14 = 0;
    L26:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.xOpenWhiteList;
        if (r16 != null) goto L29;
        int r17 = 0;
    L30:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.outerLinkBlockList;
        if (r19 != null) goto L33;
        int r20 = 0;
    L34:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.pushBlockList;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.xOpenBlockList;
        if (r25 != null) goto L41;
        int r26 = 0;
    L42:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.outerLinkQueryBlockList;
        if (r28 == null) goto L46;
        r10 = r28.hashCode();
    L46:
        int r29 = (((r27 + r10) * 31) + this.judgeIsFromOuterStrategy) * 31;
        if (this.isDeeplinkAutoSendDowngrade == false) goto L49;
        int r30 = 1231;
    L50:
        int r31 = (r29 + r30) * 31;
        if (this.enableChatSchemaOptions == true) goto L55;
        r1 = 1237;
    L55:
        return r31 + r1;
    L49:
        r30 = 1237;
        goto L50
    L41:
        r26 = r25.hashCode();
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L33:
        r20 = r19.hashCode();
        goto L34
    L29:
        r17 = r16.hashCode();
        goto L30
    L25:
        r14 = r13.hashCode();
        goto L26
    L21:
        r11 = r9.hashCode();
        goto L22
    L17:
        r7 = 1237;
        goto L18
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
        return "RouterConfig(enableOuterLinkWhiteListFromNet=" + this.enableOuterLinkWhiteListFromNet + ", enablePushWhiteListFromNet=" + this.enablePushWhiteListFromNet + ", enableXOpenWhiteListFromNet=" + this.enableXOpenWhiteListFromNet + ", enablePostSwitchRouting=" + this.enablePostSwitchRouting + ", outerLinkWhiteList=" + this.outerLinkWhiteList + ", pushWhiteList=" + this.pushWhiteList + ", xOpenWhiteList=" + this.xOpenWhiteList + ", outerLinkBlockList=" + this.outerLinkBlockList + ", pushBlockList=" + this.pushBlockList + ", xOpenBlockList=" + this.xOpenBlockList + ", outerLinkQueryBlockList=" + this.outerLinkQueryBlockList + ", judgeIsFromOuterStrategy=" + this.judgeIsFromOuterStrategy + ", isDeeplinkAutoSendDowngrade=" + this.isDeeplinkAutoSendDowngrade + ", enableChatSchemaOptions=" + this.enableChatSchemaOptions + ')';
    }

    public final boolean a() {
        return this.enableChatSchemaOptions;
    }

    public final boolean b() {
        return this.enableOuterLinkWhiteListFromNet;
    }

    public final boolean c() {
        return this.enablePostSwitchRouting;
    }

    public final boolean d() {
        return this.enablePushWhiteListFromNet;
    }

    public final boolean e() {
        return this.enableXOpenWhiteListFromNet;
    }

    public final int f() {
        return this.judgeIsFromOuterStrategy;
    }

    public final List<String> g() {
        return this.outerLinkBlockList;
    }

    public final List<String> h() {
        return this.outerLinkQueryBlockList;
    }

    public final List<String> i() {
        return this.outerLinkWhiteList;
    }

    public final List<String> j() {
        return this.pushBlockList;
    }

    public final List<String> k() {
        return this.pushWhiteList;
    }

    public final List<String> l() {
        return this.xOpenBlockList;
    }

    public final List<String> m() {
        return this.xOpenWhiteList;
    }

    public final boolean n() {
        return this.isDeeplinkAutoSendDowngrade;
    }

    public z3(Object r2) {
        this.enableOuterLinkWhiteListFromNet = false;
        this.enablePushWhiteListFromNet = false;
        this.enableXOpenWhiteListFromNet = false;
        this.enablePostSwitchRouting = true;
        this.outerLinkWhiteList = null;
        this.pushWhiteList = null;
        this.xOpenWhiteList = null;
        this.outerLinkBlockList = null;
        this.pushBlockList = null;
        this.xOpenBlockList = null;
        this.outerLinkQueryBlockList = null;
        this.judgeIsFromOuterStrategy = 1;
        this.isDeeplinkAutoSendDowngrade = true;
        this.enableChatSchemaOptions = true;
    }
}
