package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "", "desc", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "CHATTER", "CHAT", "UNKNOWN", "Companion", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TargetType extends Enum<TargetType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TargetType[] $VALUES = null;
    public static final TargetType CHAT = null;
    public static final TargetType CHATTER = null;
    public static final Companion Companion = null;
    public static final TargetType UNKNOWN = null;
    private final String desc;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/TargetType$Companion;", "", "<init>", "()V", "parse", "Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "desc", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TargetType parse(String r3) {
            if (r3 == null) goto L4;
            TargetType r0 = TargetType.CHATTER;
            if (Intrinsics.areEqual(r3, r0.getDesc()) == true) goto L13;
            TargetType r1 = TargetType.CHAT;
            if (Intrinsics.areEqual(r3, r1.getDesc()) == false) goto L12;
            return r1;
        L12:
            return TargetType.UNKNOWN;
        L13:
            return r0;
        L4:
            return TargetType.UNKNOWN;
        }
    }

    private static final /* synthetic */ TargetType[] $values() {
        return new TargetType[]{CHATTER, CHAT, UNKNOWN};
    }

    public static EnumEntries<TargetType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final TargetType parse(String r1) {
        return Companion.parse(r1);
    }

    static {
        CHATTER = new TargetType("CHATTER", 0, "PEOPLE");
        CHAT = new TargetType("CHAT", 1, "GROUP");
        UNKNOWN = new TargetType("UNKNOWN", 2, "DEFAULT");
        TargetType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static TargetType[] values() {
        return (TargetType[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public static TargetType valueOf(String r1) {
        return (TargetType) a.a(TargetType.class, r1);
    }

    private TargetType(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
