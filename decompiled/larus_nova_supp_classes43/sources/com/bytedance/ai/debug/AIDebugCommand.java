package com.bytedance.ai.debug;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIDebugCommand {
    public final Source a;
    public final String b;
    public final Map<String, String> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/debug/AIDebugCommand$Source;", "", "<init>", "(Ljava/lang/String;I)V", "DEVTOOL_ADB_BROADCAST", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DEVTOOL_ADB_BROADCAST = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source();
            DEVTOOL_ADB_BROADCAST = r0;
            Source[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public Source() {
            super("DEVTOOL_ADB_BROADCAST", 0);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIDebugCommand) == true) goto L8;
        return false;
    L8:
        AIDebugCommand r11 = (AIDebugCommand) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "AIDebugCommand(source=" + this.a + ", action=" + this.b + ", params=" + this.c + ')';
    }

    public AIDebugCommand(Source r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter("com.bytedance.applet.SET_APPLET_DEBUG_HOST", "action");
        Intrinsics.checkNotNullParameter(r11, "params");
        this.a = r10;
        this.b = "com.bytedance.applet.SET_APPLET_DEBUG_HOST";
        this.c = r11;
    }
}
