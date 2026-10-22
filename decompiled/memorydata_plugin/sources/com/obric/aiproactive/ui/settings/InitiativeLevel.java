package com.obric.aiproactive.ui.settings;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/settings/InitiativeLevel;", "", "storageToken", "", "labelRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getStorageToken", "()Ljava/lang/String;", "getLabelRes", "()I", "RESTRAINED", "BALANCED", "AGGRESSIVE", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum InitiativeLevel extends Enum<InitiativeLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InitiativeLevel[] $VALUES = null;
    public static final InitiativeLevel AGGRESSIVE = null;
    public static final InitiativeLevel BALANCED = null;
    public static final a Companion = null;
    public static final InitiativeLevel RESTRAINED = null;
    private final int labelRes;
    private final String storageToken;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/settings/InitiativeLevel$Companion;", "", "<init>", "()V", "decode", "Lcom/obric/aiproactive/ui/settings/InitiativeLevel;", "rawValue", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final InitiativeLevel a(String r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(InitiativeLevel.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((InitiativeLevel) ZeusTransformUtils.preCheckCast(r0, InitiativeLevel.class, "com.obric.memorydata.plugin")).getStorageToken(), r4) == false) goto L4;
        L9:
            InitiativeLevel r5 = (InitiativeLevel) ZeusTransformUtils.preCheckCast(r0, InitiativeLevel.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L12;
            return r5;
        L12:
            return InitiativeLevel.BALANCED;
        L8:
            r0 = null;
            goto L9
        }
    }

    private static final /* synthetic */ InitiativeLevel[] $values() {
        return new InitiativeLevel[]{RESTRAINED, BALANCED, AGGRESSIVE};
    }

    static {
        RESTRAINED = new InitiativeLevel("RESTRAINED", 0, "restrained", ZeusTransformUtils.mapRes(R.string.proactive_initiative_restrained, TypedValues.Custom.S_STRING, "proactive_initiative_restrained"));
        BALANCED = new InitiativeLevel("BALANCED", 1, "balanced", ZeusTransformUtils.mapRes(R.string.proactive_initiative_balanced, TypedValues.Custom.S_STRING, "proactive_initiative_balanced"));
        AGGRESSIVE = new InitiativeLevel("AGGRESSIVE", 2, "aggressive", ZeusTransformUtils.mapRes(R.string.proactive_initiative_aggressive, TypedValues.Custom.S_STRING, "proactive_initiative_aggressive"));
        InitiativeLevel[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private InitiativeLevel(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.storageToken = r3;
        this.labelRes = r4;
    }

    public static EnumEntries<InitiativeLevel> getEntries() {
        return $ENTRIES;
    }

    public static InitiativeLevel valueOf(String r2) {
        return (InitiativeLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(InitiativeLevel.class, r2), InitiativeLevel.class, "com.obric.memorydata.plugin");
    }

    public static InitiativeLevel[] values() {
        return (InitiativeLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InitiativeLevel[].class, "com.obric.memorydata.plugin");
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final String getStorageToken() {
        return this.storageToken;
    }
}
