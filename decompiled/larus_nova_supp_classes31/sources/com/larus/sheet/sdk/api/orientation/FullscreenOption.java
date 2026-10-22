package com.larus.sheet.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/FullscreenOption;", "", "hideStatusBar", "", "hideNavigationBar", "immersive", "clickFrom", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHideStatusBar", "()Ljava/lang/Boolean;", "setHideStatusBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHideNavigationBar", "setHideNavigationBar", "getImmersive", "setImmersive", "getClickFrom", "()Ljava/lang/String;", "setClickFrom", "(Ljava/lang/String;)V", "Preset", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FullscreenOption {

    @SerializedName("clickFrom")
    private String clickFrom;

    @SerializedName("hideNavigationBar")
    private Boolean hideNavigationBar;

    @SerializedName("hideStatusBar")
    private Boolean hideStatusBar;

    @SerializedName("immersive")
    private Boolean immersive;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/FullscreenOption$Preset;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_TRUE", "ALL_FALSE", "toOption", "Lcom/larus/sheet/sdk/api/orientation/FullscreenOption;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum Preset extends Enum<Preset> {
        public static final Preset ALL_FALSE = null;
        public static final Preset ALL_TRUE = null;
        public static final /* synthetic */ Preset[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Preset.values().length];
                r0[Preset.ALL_TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Preset.ALL_FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public static EnumEntries<Preset> getEntries() {
            return b;
        }

        static {
            Preset r0 = new Preset("ALL_TRUE", 0);
            ALL_TRUE = r0;
            Preset r1 = new Preset("ALL_FALSE", 1);
            ALL_FALSE = r1;
            Preset[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Preset[] values() {
            return (Preset[]) a.clone();
        }

        public final FullscreenOption toOption() {
            int r0 = a.a[ordinal()];
            if (r0 != 1) goto L5;
            Boolean r4 = Boolean.TRUE;
            return new FullscreenOption(r4, r4, r4, null, 8, null);
        L5:
            if (r0 != 2) goto L8;
            Boolean r5 = Boolean.FALSE;
            return new FullscreenOption(r5, r5, r5, null, 8, null);
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static Preset valueOf(String r1) {
            return (Preset) r27.a.a(Preset.class, r1);
        }

        public Preset(String r1, int r2) {
            super(r1, r2);
        }
    }

    public FullscreenOption() {
        this(null, null, null, null, 15, null);
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final Boolean getHideNavigationBar() {
        return this.hideNavigationBar;
    }

    public final Boolean getHideStatusBar() {
        return this.hideStatusBar;
    }

    public final Boolean getImmersive() {
        return this.immersive;
    }

    public final void setClickFrom(String r1) {
        this.clickFrom = r1;
    }

    public final void setHideNavigationBar(Boolean r1) {
        this.hideNavigationBar = r1;
    }

    public final void setHideStatusBar(Boolean r1) {
        this.hideStatusBar = r1;
    }

    public final void setImmersive(Boolean r1) {
        this.immersive = r1;
    }

    public FullscreenOption(Boolean r1, Boolean r2, Boolean r3, String r4) {
        this.hideStatusBar = r1;
        this.hideNavigationBar = r2;
        this.immersive = r3;
        this.clickFrom = r4;
    }

    public /* synthetic */ FullscreenOption(Boolean r1, Boolean r2, Boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Boolean.TRUE;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Boolean.TRUE;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = null;
    L14:
        this(r1, r2, r3, r4);
    }
}
