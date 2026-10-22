package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/MaskType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FULLSCREEN", "AROUNDPANEL", "NONE", "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MaskType extends Enum<MaskType> {
    public static final MaskType AROUNDPANEL = null;
    public static final MaskType DEFAULT = null;
    public static final MaskType FULLSCREEN = null;
    public static final MaskType NONE = null;
    public static final /* synthetic */ MaskType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MaskType> getEntries() {
        return b;
    }

    static {
        MaskType r0 = new MaskType("FULLSCREEN", 0, "fullScreen");
        FULLSCREEN = r0;
        MaskType r1 = new MaskType("AROUNDPANEL", 1, "aroundPanel");
        AROUNDPANEL = r1;
        MaskType r2 = new MaskType("NONE", 2, "none");
        NONE = r2;
        MaskType r4 = new MaskType("DEFAULT", 3, LocationHitPoint$ResultType.DEFAULT);
        DEFAULT = r4;
        MaskType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static MaskType[] values() {
        return (MaskType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MaskType valueOf(String r1) {
        return (MaskType) a.a(MaskType.class, r1);
    }

    public MaskType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
