package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationReviewShortcut {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewShortcut$Result;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "REQUESTED", "ALREADY_PINNED", "UNSUPPORTED", "FAILED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result ALREADY_PINNED = null;
        public static final Result FAILED = null;
        public static final Result REQUESTED = null;
        public static final Result UNSUPPORTED = null;
        public static final /* synthetic */ Result[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Result> getEntries() {
            return b;
        }

        static {
            Result r0 = new Result("REQUESTED", 0);
            REQUESTED = r0;
            Result r1 = new Result("ALREADY_PINNED", 1);
            ALREADY_PINNED = r1;
            Result r3 = new Result("UNSUPPORTED", 2);
            UNSUPPORTED = r3;
            Result r5 = new Result("FAILED", 3);
            FAILED = r5;
            Result[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Result[] values() {
            return (Result[]) a.clone();
        }

        public static Result valueOf(String r1) {
            return (Result) r27.a.a(Result.class, r1);
        }

        public Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }
}
