package com.larksuite.component.universe_design.button.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Be\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonType;", "", "backgroundColorRes", "", "textColorRes", "strokeColorRes", "disabledTextColorRes", "loadingBackgroundColorRes", "loadingTextColorRes", "loadingStrokeColorRes", "loadingIndicatorColorRes", "<init>", "(Ljava/lang/String;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackgroundColorRes$universe_ui_button_release", "()I", "getTextColorRes$universe_ui_button_release", "getStrokeColorRes$universe_ui_button_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisabledTextColorRes$universe_ui_button_release", "getLoadingBackgroundColorRes$universe_ui_button_release", "getLoadingTextColorRes$universe_ui_button_release", "getLoadingStrokeColorRes$universe_ui_button_release", "getLoadingIndicatorColorRes$universe_ui_button_release", "Primary", "SecondaryGray", "SecondaryBlue", "SecondaryRed", "Danger", "TextPrimary", "TextSecondary", "TextDanger", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDButtonType extends Enum<UDButtonType> {
    public static final UDButtonType Danger = null;
    public static final UDButtonType Primary = null;
    public static final UDButtonType SecondaryBlue = null;
    public static final UDButtonType SecondaryGray = null;
    public static final UDButtonType SecondaryRed = null;
    public static final UDButtonType TextDanger = null;
    public static final UDButtonType TextPrimary = null;
    public static final UDButtonType TextSecondary = null;
    public static final /* synthetic */ UDButtonType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int backgroundColorRes;
    private final Integer disabledTextColorRes;
    private final Integer loadingBackgroundColorRes;
    private final Integer loadingIndicatorColorRes;
    private final Integer loadingStrokeColorRes;
    private final Integer loadingTextColorRes;
    private final Integer strokeColorRes;
    private final int textColorRes;

    public UDButtonType() {
        throw null;
    }

    public static EnumEntries<UDButtonType> getEntries() {
        return b;
    }

    static {
        UDButtonType r13 = new UDButtonType("Primary", 0, 2131108881, 2131106521, null, 2131109013, 2131105550, null, null, 2131106521, 100, null);
        Primary = r13;
        UDButtonType r0 = new UDButtonType("SecondaryGray", 1, 2131108893, 2131108884, 2131103352, null, null, 2131109045, 2131108721, 2131105542, 24, null);
        SecondaryGray = r0;
        UDButtonType r2 = new UDButtonType("SecondaryBlue", 2, 2131108892, 2131108883, 2131108882, null, null, null, 2131105544, 2131105542, 56, null);
        SecondaryBlue = r2;
        UDButtonType r3 = new UDButtonType("SecondaryRed", 3, 2131108894, 2131108887, 2131108886, null, null, null, 2131102091, 2131102089, 56, null);
        SecondaryRed = r3;
        UDButtonType r5 = new UDButtonType("Danger", 4, 2131108885, 2131106521, null, 2131109013, 2131102095, null, null, 2131106521, 100, null);
        Danger = r5;
        UDButtonType r6 = new UDButtonType("TextPrimary", 5, 2131108889, 2131108883, null, null, null, null, null, 2131105542, 124, null);
        TextPrimary = r6;
        UDButtonType r1 = new UDButtonType("TextSecondary", 6, 2131108890, 2131108884, null, null, null, null, null, 2131106622, 124, null);
        TextSecondary = r1;
        UDButtonType r7 = new UDButtonType("TextDanger", 7, 2131108888, 2131108887, null, null, null, null, null, 2131102089, 124, null);
        TextDanger = r7;
        UDButtonType[] r4 = {r13, r0, r2, r3, r5, r6, r1, r7};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static UDButtonType[] values() {
        return (UDButtonType[]) a.clone();
    }

    public final int getBackgroundColorRes$universe_ui_button_release() {
        return this.backgroundColorRes;
    }

    public final Integer getDisabledTextColorRes$universe_ui_button_release() {
        return this.disabledTextColorRes;
    }

    public final Integer getLoadingBackgroundColorRes$universe_ui_button_release() {
        return this.loadingBackgroundColorRes;
    }

    public final Integer getLoadingIndicatorColorRes$universe_ui_button_release() {
        return this.loadingIndicatorColorRes;
    }

    public final Integer getLoadingStrokeColorRes$universe_ui_button_release() {
        return this.loadingStrokeColorRes;
    }

    public final Integer getLoadingTextColorRes$universe_ui_button_release() {
        return this.loadingTextColorRes;
    }

    public final Integer getStrokeColorRes$universe_ui_button_release() {
        return this.strokeColorRes;
    }

    public final int getTextColorRes$universe_ui_button_release() {
        return this.textColorRes;
    }

    public static UDButtonType valueOf(String r1) {
        return (UDButtonType) r27.a.a(UDButtonType.class, r1);
    }

    public UDButtonType(String r2, int r3, int r4, int r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r7 = null;
    L9:
        if ((r12 & 16) == 0) goto L12;
        r8 = null;
    L12:
        if ((r12 & 32) == 0) goto L15;
        r9 = null;
    L15:
        if ((r12 & 64) == 0) goto L18;
        r10 = null;
    L18:
        if ((r12 & 128) == 0) goto L20;
        r11 = null;
    L20:
        super(r2, r3);
        this.backgroundColorRes = r4;
        this.textColorRes = r5;
        this.strokeColorRes = r6;
        this.disabledTextColorRes = r7;
        this.loadingBackgroundColorRes = r8;
        this.loadingTextColorRes = r9;
        this.loadingStrokeColorRes = r10;
        this.loadingIndicatorColorRes = r11;
    }
}
