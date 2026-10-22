package com.larus.avlink.simulInterpret.page.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.j0;
import ha8.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BO\b\u0002\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "", "topIconRes", "", "bottomIconRes", "topTranslatingIconRes", "bottomTranslatingIconRes", "isShowMuteIcon", "", "onboardingDescription", "", "endSubtitle", "<init>", "(Ljava/lang/String;IIIIIZLjava/lang/String;Ljava/lang/String;)V", "getTopIconRes", "()I", "getBottomIconRes", "getTopTranslatingIconRes", "getBottomTranslatingIconRes", "()Z", "getOnboardingDescription", "()Ljava/lang/String;", "getEndSubtitle", "DEVICE_LITE", "DEVICE_G", "DEVICE_E", "DEVICE_LORY", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DoraDeviceType extends Enum<DoraDeviceType> {
    public static final DoraDeviceType DEVICE_E = null;
    public static final DoraDeviceType DEVICE_G = null;
    public static final DoraDeviceType DEVICE_LITE = null;
    public static final DoraDeviceType DEVICE_LORY = null;
    public static final DoraDeviceType UNKNOWN = null;
    public static final /* synthetic */ DoraDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int bottomIconRes;
    private final int bottomTranslatingIconRes;
    private final String endSubtitle;
    private final boolean isShowMuteIcon;
    private final String onboardingDescription;
    private final int topIconRes;
    private final int topTranslatingIconRes;

    public static EnumEntries<DoraDeviceType> getEntries() {
        return b;
    }

    static {
        int r0 = j0.a;
        DoraDeviceType r10 = new DoraDeviceType("DEVICE_LITE", 0, 2131237998, 2131238052, 2131237999, 2131238053, false, j0.d(2131903361), j0.d(2131903355));
        DEVICE_LITE = r10;
        boolean r1 = d.a;
        DoraDeviceType r2 = new DoraDeviceType("DEVICE_G", 1, 2131238034, 2131237945, 2131238035, 2131237946, false, j0.d(2131902972), j0.d(2131902971));
        DEVICE_G = r2;
        DoraDeviceType r3 = new DoraDeviceType("DEVICE_E", 2, 0, 0, 0, 0, false, null, null, 127, null);
        DEVICE_E = r3;
        DoraDeviceType r6 = new DoraDeviceType("DEVICE_LORY", 3, 0, 0, 0, 0, false, null, null, 127, null);
        DEVICE_LORY = r6;
        DoraDeviceType r7 = new DoraDeviceType("UNKNOWN", 4, 0, 0, 0, 0, false, null, null, 127, null);
        UNKNOWN = r7;
        DoraDeviceType[] r4 = {r10, r2, r3, r6, r7};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DoraDeviceType[] values() {
        return (DoraDeviceType[]) a.clone();
    }

    public final int getBottomIconRes() {
        return this.bottomIconRes;
    }

    public final int getBottomTranslatingIconRes() {
        return this.bottomTranslatingIconRes;
    }

    public final String getEndSubtitle() {
        return this.endSubtitle;
    }

    public final String getOnboardingDescription() {
        return this.onboardingDescription;
    }

    public final int getTopIconRes() {
        return this.topIconRes;
    }

    public final int getTopTranslatingIconRes() {
        return this.topTranslatingIconRes;
    }

    public final boolean isShowMuteIcon() {
        return this.isShowMuteIcon;
    }

    public static DoraDeviceType valueOf(String r1) {
        return (DoraDeviceType) r27.a.a(DoraDeviceType.class, r1);
    }

    public DoraDeviceType(String r1, int r2, int r3, int r4, int r5, int r6, boolean r7, String r8, String r9) {
        super(r1, r2);
        this.topIconRes = r3;
        this.bottomIconRes = r4;
        this.topTranslatingIconRes = r5;
        this.bottomTranslatingIconRes = r6;
        this.isShowMuteIcon = r7;
        this.onboardingDescription = r8;
        this.endSubtitle = r9;
    }

    public /* synthetic */ DoraDeviceType(String r13, int r14, int r15, int r16, int r17, int r18, boolean r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r11 = "";
    L30:
        this(r13, r14, r5, r6, r7, r8, r9, r10, r11);
        return;
    L29:
        r11 = r21;
        goto L30
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }
}
