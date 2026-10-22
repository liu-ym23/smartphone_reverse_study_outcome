package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "", "<init>", "(Ljava/lang/String;I)V", "VERSION_1", "VERSION_2", "Companion", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum IntentInputVersion extends Enum<IntentInputVersion> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IntentInputVersion[] $VALUES = null;
    public static final Companion Companion = null;
    public static final IntentInputVersion VERSION_1 = null;
    public static final IntentInputVersion VERSION_2 = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion$Companion;", "", "<init>", "()V", "parse", "Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "", "(Ljava/lang/Integer;)Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final IntentInputVersion parse(Integer r1) {
            if (r1 != null) goto L6;
            return IntentInputVersion.VERSION_1;
        L6:
            return IntentInputVersion.VERSION_2;
        }
    }

    private static final /* synthetic */ IntentInputVersion[] $values() {
        return new IntentInputVersion[]{VERSION_1, VERSION_2};
    }

    public static EnumEntries<IntentInputVersion> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final IntentInputVersion parse(Integer r1) {
        return Companion.parse(r1);
    }

    static {
        VERSION_1 = new IntentInputVersion("VERSION_1", 0);
        VERSION_2 = new IntentInputVersion("VERSION_2", 1);
        IntentInputVersion[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static IntentInputVersion[] values() {
        return (IntentInputVersion[]) $VALUES.clone();
    }

    public static IntentInputVersion valueOf(String r1) {
        return (IntentInputVersion) a.a(IntentInputVersion.class, r1);
    }

    private IntentInputVersion(String r1, int r2) {
        super(r1, r2);
    }
}
