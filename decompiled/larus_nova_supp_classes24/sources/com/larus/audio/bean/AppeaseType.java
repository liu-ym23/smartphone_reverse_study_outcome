package com.larus.audio.bean;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/bean/AppeaseType;", "", "type", "", "scene", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getScene", "()Ljava/lang/String;", "UNKNOW", "VOICE", "PEOPLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AppeaseType extends Enum<AppeaseType> {
    public static final AppeaseType PEOPLE = null;
    public static final AppeaseType UNKNOW = null;
    public static final AppeaseType VOICE = null;
    public static final /* synthetic */ AppeaseType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;
    private final int type;

    public static EnumEntries<AppeaseType> getEntries() {
        return b;
    }

    static {
        AppeaseType r0 = new AppeaseType("UNKNOW", 0, 0, "");
        UNKNOW = r0;
        AppeaseType r1 = new AppeaseType("VOICE", 1, 1, "audio_comfort");
        VOICE = r1;
        AppeaseType r2 = new AppeaseType("PEOPLE", 2, 2, "voice_comfort");
        PEOPLE = r2;
        AppeaseType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static AppeaseType[] values() {
        return (AppeaseType[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getType() {
        return this.type;
    }

    public static AppeaseType valueOf(String r1) {
        return (AppeaseType) a.a(AppeaseType.class, r1);
    }

    public AppeaseType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.scene = r4;
    }
}
