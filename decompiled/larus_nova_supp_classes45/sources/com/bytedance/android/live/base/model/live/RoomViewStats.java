package com.bytedance.android.live.base.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/base/model/live/RoomViewStats;", "", "", "isPCU", "", "toString", "isHidden", "Z", "()Z", "setHidden", "(Z)V", "displayShort", "Ljava/lang/String;", "getDisplayShort", "()Ljava/lang/String;", "setDisplayShort", "(Ljava/lang/String;)V", "displayMiddle", "getDisplayMiddle", "setDisplayMiddle", "displayLong", "getDisplayLong", "setDisplayLong", "", "displayValue", "J", "getDisplayValue", "()J", "setDisplayValue", "(J)V", "displayVersion", "getDisplayVersion", "setDisplayVersion", "incremental", "getIncremental", "setIncremental", "", "displayType", "I", "getDisplayType", "()I", "setDisplayType", "(I)V", "<init>", "()V", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomViewStats implements h {
    public static final a Companion = null;
    private static int DisplayTypeHidden;
    private static int DisplayTypePCU;
    private static int DisplayTypePV;
    private static int DisplayTypePVOfVS;
    private static int DisplayTypePVWithPreview;
    private static int DisplayTypeUVWithPreview;
    private static int DisplayTypeUnknown;

    @SerializedName("display_long")
    protected String displayLong;

    @SerializedName("display_middle")
    protected String displayMiddle;

    @SerializedName("display_short")
    protected String displayShort;

    @SerializedName("display_type")
    protected int displayType;

    @SerializedName("display_value")
    protected long displayValue;

    @SerializedName("display_version")
    protected long displayVersion;

    @SerializedName("incremental")
    protected boolean incremental;

    @SerializedName("is_hidden")
    protected boolean isHidden;

    public static final class a {
        public a() {
        }
    }

    public RoomViewStats() {
    }

    static {
        Companion = new a();
        DisplayTypePCU = 1;
        DisplayTypePVWithPreview = 2;
        DisplayTypeUVWithPreview = 3;
        DisplayTypePV = 4;
        DisplayTypePVOfVS = 5;
        DisplayTypeHidden = 6;
    }

    public final boolean isPCU() {
        if (this.displayType != DisplayTypePCU) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "RoomViewStats{isHidden=" + this.isHidden + ", displayShort='" + this.displayShort + "', displayMiddle='" + this.displayMiddle + "', displayLong='" + this.displayLong + "', displayValue=" + this.displayValue + ", displayVersion=" + this.displayVersion + ", incremental=" + this.incremental + '}';
    }

    public static final /* synthetic */ int access$getDisplayTypeHidden$cp() {
        return DisplayTypeHidden;
    }

    public static final /* synthetic */ int access$getDisplayTypePCU$cp() {
        return DisplayTypePCU;
    }

    public static final /* synthetic */ int access$getDisplayTypePV$cp() {
        return DisplayTypePV;
    }

    public static final /* synthetic */ int access$getDisplayTypePVOfVS$cp() {
        return DisplayTypePVOfVS;
    }

    public static final /* synthetic */ int access$getDisplayTypePVWithPreview$cp() {
        return DisplayTypePVWithPreview;
    }

    public static final /* synthetic */ int access$getDisplayTypeUVWithPreview$cp() {
        return DisplayTypeUVWithPreview;
    }

    public static final /* synthetic */ int access$getDisplayTypeUnknown$cp() {
        return DisplayTypeUnknown;
    }

    public final String getDisplayLong() {
        return this.displayLong;
    }

    public final String getDisplayMiddle() {
        return this.displayMiddle;
    }

    public final String getDisplayShort() {
        return this.displayShort;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final long getDisplayValue() {
        return this.displayValue;
    }

    public final long getDisplayVersion() {
        return this.displayVersion;
    }

    public final boolean getIncremental() {
        return this.incremental;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public RoomViewStats(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.displayType = r5.i();
        goto L3
    L8:
        this.incremental = am3.h.a(r5);
        goto L3
    L9:
        this.displayVersion = r5.j();
        goto L3
    L10:
        this.displayValue = r5.j();
        goto L3
    L11:
        this.displayLong = am3.h.c(r5);
        goto L3
    L12:
        this.displayMiddle = am3.h.c(r5);
        goto L3
    L13:
        this.displayShort = am3.h.c(r5);
        goto L3
    L14:
        this.isHidden = am3.h.a(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public static final /* synthetic */ void access$setDisplayTypeHidden$cp(int r0) {
        DisplayTypeHidden = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypePCU$cp(int r0) {
        DisplayTypePCU = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypePV$cp(int r0) {
        DisplayTypePV = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypePVOfVS$cp(int r0) {
        DisplayTypePVOfVS = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypePVWithPreview$cp(int r0) {
        DisplayTypePVWithPreview = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypeUVWithPreview$cp(int r0) {
        DisplayTypeUVWithPreview = r0;
    }

    public static final /* synthetic */ void access$setDisplayTypeUnknown$cp(int r0) {
        DisplayTypeUnknown = r0;
    }

    public final void setDisplayLong(String r1) {
        this.displayLong = r1;
    }

    public final void setDisplayMiddle(String r1) {
        this.displayMiddle = r1;
    }

    public final void setDisplayShort(String r1) {
        this.displayShort = r1;
    }

    public final void setDisplayType(int r1) {
        this.displayType = r1;
    }

    public final void setDisplayValue(long r1) {
        this.displayValue = r1;
    }

    public final void setDisplayVersion(long r1) {
        this.displayVersion = r1;
    }

    public final void setHidden(boolean r1) {
        this.isHidden = r1;
    }

    public final void setIncremental(boolean r1) {
        this.incremental = r1;
    }
}
