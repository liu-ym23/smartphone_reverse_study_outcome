package com.larus.platform.api.fileselect;

import aq9.f;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.u;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface IChatFileSelectionStore {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$Source;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "DRIVE", "LOCAL", "SELECTED_LIST", "UNKNOWN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum Source extends Enum<Source> {
        public static final Source DRIVE = null;
        public static final Source LOCAL = null;
        public static final Source RECENT = null;
        public static final Source SELECTED_LIST = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("RECENT", 0);
            RECENT = r0;
            Source r1 = new Source("DRIVE", 1);
            DRIVE = r1;
            Source r3 = new Source("LOCAL", 2);
            LOCAL = r3;
            Source r5 = new Source("SELECTED_LIST", 3);
            SELECTED_LIST = r5;
            Source r7 = new Source("UNKNOWN", 4);
            UNKNOWN = r7;
            Source[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.larus.platform.api.fileselect.IChatFileSelectionStore$a$a, reason: collision with other inner class name */
        public static final class C0006a implements a {
            public final long a;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof C0006a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((C0006a) r8).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (int) (r0 ^ (r0 >>> 32));
            }

            public final String toString() {
                return "FileSizeNotAllowed(maxFileSize=" + this.a + ')';
            }

            public C0006a(long r1) {
                this.a = r1;
            }
        }

        public static final class b implements a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof b) == true) goto L9;
                return false;
            L9:
                b r4 = (b) r3;
                return true;
            }

            public final int hashCode() {
                return 1813436526;
            }

            public final String toString() {
                return "InvalidExistingSelection";
            }
        }

        public static final class c implements a {
            public final int a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.a == ((c) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a;
            }

            public final String toString() {
                return "MaxCountReached(maxCount=" + this.a + ')';
            }

            public c(int r1) {
                this.a = r1;
            }
        }

        public static final class d implements a {
            public final FlowDriveFileType a;
            public final FlowDriveFileType b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof d) == true) goto L8;
                return false;
            L8:
                d r6 = (d) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "MixedTypeNotSupported(selectedType=" + this.a + ", incomingType=" + this.b + ')';
            }

            public d(FlowDriveFileType r2, FlowDriveFileType r3) {
                Intrinsics.checkNotNullParameter(r2, "selectedType");
                Intrinsics.checkNotNullParameter(r3, "incomingType");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class e implements a {
            public final FlowDriveFileType a;

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
                return this.a.hashCode();
            }

            public final String toString() {
                return "TypeNotAllowed(type=" + this.a + ')';
            }

            public final FlowDriveFileType getType() {
                return this.a;
            }

            public e(FlowDriveFileType r2) {
                Intrinsics.checkNotNullParameter(r2, "type");
                this.a = r2;
            }
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof a) == true) goto L9;
                return false;
            L9:
                a r4 = (a) r3;
                return true;
            }

            public final int hashCode() {
                return 1017710447;
            }

            public final String toString() {
                return "Applied";
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.platform.api.fileselect.IChatFileSelectionStore$b$b, reason: collision with other inner class name */
        public static final class C0007b extends b {
            public final a a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0007b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0007b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Rejected(reason=" + this.a + ')';
            }

            public C0007b(a r2) {
                Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
                this.a = r2;
            }
        }

        public b() {
        }
    }

    b.a a(String r1, Source r2);

    b b(u r1, Source r2);

    b c(u r1, Source r2);

    void d(f r1);

    Source e(String r1);

    StateFlowImpl getState();

    List<u> snapshot();
}
