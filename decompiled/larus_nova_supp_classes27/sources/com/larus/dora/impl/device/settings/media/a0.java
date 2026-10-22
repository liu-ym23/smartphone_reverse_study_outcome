package com.larus.dora.impl.device.settings.media;

import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a0 {

    public static final class a implements a0 {
        public final FlowDoraVideoRecordConfig a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Config(cfg=" + this.a + ')';
        }

        public a(FlowDoraVideoRecordConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "cfg");
            this.a = r2;
        }
    }
}
