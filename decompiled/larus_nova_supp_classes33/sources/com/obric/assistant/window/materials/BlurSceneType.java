package com.obric.assistant.window.materials;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/window/materials/BlurSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW", "VIEW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlurSceneType extends Enum<BlurSceneType> {
    public static final BlurSceneType VIEW = null;
    public static final BlurSceneType WINDOW = null;
    public static final /* synthetic */ BlurSceneType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BlurSceneType> getEntries() {
        return b;
    }

    static {
        BlurSceneType r0 = new BlurSceneType("WINDOW", 0);
        WINDOW = r0;
        BlurSceneType r1 = new BlurSceneType("VIEW", 1);
        VIEW = r1;
        BlurSceneType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BlurSceneType[] values() {
        return (BlurSceneType[]) a.clone();
    }

    public static BlurSceneType valueOf(String r1) {
        return (BlurSceneType) a.a(BlurSceneType.class, r1);
    }

    public BlurSceneType(String r1, int r2) {
        super(r1, r2);
    }
}
