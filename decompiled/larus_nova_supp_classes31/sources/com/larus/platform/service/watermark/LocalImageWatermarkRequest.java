package com.larus.platform.service.watermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LocalImageWatermarkRequest extends f {
    public final b a;
    public final OutputPreference b;
    public final DownloadWatermarkScene c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/service/watermark/LocalImageWatermarkRequest$OutputPreference;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_AS_INPUT", "AS_BITMAP", "AS_PATH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum OutputPreference extends Enum<OutputPreference> {
        public static final OutputPreference AS_BITMAP = null;
        public static final OutputPreference AS_PATH = null;
        public static final OutputPreference SAME_AS_INPUT = null;
        public static final /* synthetic */ OutputPreference[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<OutputPreference> getEntries() {
            return b;
        }

        static {
            OutputPreference r0 = new OutputPreference("SAME_AS_INPUT", 0);
            SAME_AS_INPUT = r0;
            OutputPreference r1 = new OutputPreference("AS_BITMAP", 1);
            AS_BITMAP = r1;
            OutputPreference r3 = new OutputPreference("AS_PATH", 2);
            AS_PATH = r3;
            OutputPreference[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static OutputPreference[] values() {
            return (OutputPreference[]) a.clone();
        }

        public static OutputPreference valueOf(String r1) {
            return (OutputPreference) r27.a.a(OutputPreference.class, r1);
        }

        public OutputPreference(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalImageWatermarkRequest) == true) goto L8;
        return false;
    L8:
        LocalImageWatermarkRequest r6 = (LocalImageWatermarkRequest) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "LocalImageWatermarkRequest(input=" + this.a + ", preferOutput=" + this.b + ", scene=" + this.c + ')';
    }

    public LocalImageWatermarkRequest(b r2, OutputPreference r3, DownloadWatermarkScene r4) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "preferOutput");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
