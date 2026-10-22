package com.larus.dora.impl.ota.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage;", "", "PeripheralDownloading", "PeripheralInstalling", "PeripheralRestarting", "PeripheralOTASuccess", "PeripheralOTAFailed", "PeripheralOther", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralDownloading;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralInstalling;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOTAFailed;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOTASuccess;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOther;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralRestarting;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraOTAPeripheralStage {

    public static final class a implements DoraOTAPeripheralStage {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "PeripheralDownloading(progress=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b implements DoraOTAPeripheralStage {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "PeripheralInstalling(progress=" + this.a + ')';
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    public static final class c implements DoraOTAPeripheralStage {
        public final int a;
        public final com.larus.dora.impl.ota.c b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PeripheralOTAFailed(errorCode=" + this.a + ", otaIntent=" + this.b + ')';
        }

        public c(int r2, com.larus.dora.impl.ota.c r3) {
            Intrinsics.checkNotNullParameter(r3, "otaIntent");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements DoraOTAPeripheralStage {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements DoraOTAPeripheralStage {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "PeripheralOther(stage=" + this.a + ')';
        }

        public e(int r1) {
            this.a = r1;
        }
    }

    public static final class f implements DoraOTAPeripheralStage {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.a == ((f) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "PeripheralRestarting(progress=" + this.a + ')';
        }

        public f(int r1) {
            this.a = r1;
        }
    }
}
