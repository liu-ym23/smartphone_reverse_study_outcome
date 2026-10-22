package com.larus.dora.o.impl.simul;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!Bm\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulDeviceForm;", "", "topIconRes", "", "bottomIconRes", "topTranslatingIconRes", "bottomTranslatingIconRes", "introRes", "exitHintRes", "supportConference", "", "adjustAreaSize", "topSideLabelRes", "bottomSideLabelRes", "<init>", "(Ljava/lang/String;IIIIIIIZZLjava/lang/Integer;Ljava/lang/Integer;)V", "getTopIconRes", "()I", "getBottomIconRes", "getTopTranslatingIconRes", "getBottomTranslatingIconRes", "getIntroRes", "getExitHintRes", "getSupportConference", "()Z", "getAdjustAreaSize", "getTopSideLabelRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomSideLabelRes", "EARPHONE", "GLASSES", "UNKNOWN", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OSimulDeviceForm extends Enum<OSimulDeviceForm> {
    public static final String ARG_PRODUCT_ID = "product_id";
    public static final a Companion = null;
    public static final OSimulDeviceForm EARPHONE = null;
    public static final OSimulDeviceForm GLASSES = null;
    public static final OSimulDeviceForm UNKNOWN = null;
    public static final /* synthetic */ OSimulDeviceForm[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean adjustAreaSize;
    private final int bottomIconRes;
    private final Integer bottomSideLabelRes;
    private final int bottomTranslatingIconRes;
    private final int exitHintRes;
    private final int introRes;
    private final boolean supportConference;
    private final int topIconRes;
    private final Integer topSideLabelRes;
    private final int topTranslatingIconRes;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OSimulDeviceForm> getEntries() {
        return b;
    }

    static {
        OSimulDeviceForm r13 = new OSimulDeviceForm("EARPHONE", 0, 2131233971, 2131233975, 2131233972, 2131233976, 2131903361, 2131903355, false, false, 2131903470, 2131903471);
        EARPHONE = r13;
        OSimulDeviceForm r0 = new OSimulDeviceForm("GLASSES", 1, 2131233960, 2131233952, 2131233973, 2131233948, 2131902972, 2131902971, true, true, null, null);
        GLASSES = r0;
        OSimulDeviceForm r1 = new OSimulDeviceForm("UNKNOWN", 2, 0, 0, 0, 0, 0, 0, false, false, null, null);
        UNKNOWN = r1;
        OSimulDeviceForm[] r2 = {r13, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static OSimulDeviceForm[] values() {
        return (OSimulDeviceForm[]) a.clone();
    }

    public final boolean getAdjustAreaSize() {
        return this.adjustAreaSize;
    }

    public final int getBottomIconRes() {
        return this.bottomIconRes;
    }

    public final Integer getBottomSideLabelRes() {
        return this.bottomSideLabelRes;
    }

    public final int getBottomTranslatingIconRes() {
        return this.bottomTranslatingIconRes;
    }

    public final int getExitHintRes() {
        return this.exitHintRes;
    }

    public final int getIntroRes() {
        return this.introRes;
    }

    public final boolean getSupportConference() {
        return this.supportConference;
    }

    public final int getTopIconRes() {
        return this.topIconRes;
    }

    public final Integer getTopSideLabelRes() {
        return this.topSideLabelRes;
    }

    public final int getTopTranslatingIconRes() {
        return this.topTranslatingIconRes;
    }

    public static OSimulDeviceForm valueOf(String r1) {
        return (OSimulDeviceForm) r27.a.a(OSimulDeviceForm.class, r1);
    }

    public OSimulDeviceForm(String r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, boolean r9, boolean r10, Integer r11, Integer r12) {
        super(r1, r2);
        this.topIconRes = r3;
        this.bottomIconRes = r4;
        this.topTranslatingIconRes = r5;
        this.bottomTranslatingIconRes = r6;
        this.introRes = r7;
        this.exitHintRes = r8;
        this.supportConference = r9;
        this.adjustAreaSize = r10;
        this.topSideLabelRes = r11;
        this.bottomSideLabelRes = r12;
    }
}
