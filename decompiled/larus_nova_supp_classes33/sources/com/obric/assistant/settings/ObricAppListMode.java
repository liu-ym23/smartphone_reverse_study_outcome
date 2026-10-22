package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/settings/ObricAppListMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BLACK_LIST", "WHITE_LIST", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAppListMode extends Enum<ObricAppListMode> {
    public static final ObricAppListMode BLACK_LIST = null;
    public static final a Companion = null;
    public static final ObricAppListMode WHITE_LIST = null;
    public static final /* synthetic */ ObricAppListMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ObricAppListMode> getEntries() {
        return b;
    }

    static {
        ObricAppListMode r0 = new ObricAppListMode("BLACK_LIST", 0, 0);
        BLACK_LIST = r0;
        ObricAppListMode r1 = new ObricAppListMode("WHITE_LIST", 1, 1);
        WHITE_LIST = r1;
        ObricAppListMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static ObricAppListMode[] values() {
        return (ObricAppListMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricAppListMode valueOf(String r1) {
        return (ObricAppListMode) r27.a.a(ObricAppListMode.class, r1);
    }

    public ObricAppListMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
