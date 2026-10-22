package com.obric.assistant.tipoff;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFeedbackReasonConfig {
    public static final List<FeedbackReason> a = null;
    public static final List<FeedbackReason> b = null;
    public static final List<FeedbackReason> c = null;
    public static final List<FeedbackReason> d = null;
    public static final List<FeedbackReason> e = null;
    public static final Map<Integer, String> f = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/tipoff/ObricFeedbackReasonConfig$FeedbackReason;", "", "id", "", "textRes", "trackLabel", "", "<init>", "(Ljava/lang/String;IIILjava/lang/String;)V", "getId", "()I", "getTextRes", "getTrackLabel", "()Ljava/lang/String;", "TASK_TIME_LONG", "TASK_UN_COMPLETED", "TASK_ERROR_OPERATION", "TASK_ASK_TOO_MUCH", "TASK_UI_RELATED", "TASK_OTHER", "SEARCH_NO_RESULT", "SEARCH_INCOMPLETE_RESULT", "SEARCH_WRONG_ANSWER", "SEARCH_OTHER", "MEMORY_CONTENT_WRONG", "MEMORY_CONTENT_MISSING", "MEMORY_CONTENT_REDUNDANT", "MEMORY_CATEGORY_ERROR", "MEMORY_NOT_UPDATED", "MEMORY_NOT_DELETED", "MEMORY_OTHER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedbackReason extends Enum<FeedbackReason> {
        public static final FeedbackReason MEMORY_CATEGORY_ERROR = null;
        public static final FeedbackReason MEMORY_CONTENT_MISSING = null;
        public static final FeedbackReason MEMORY_CONTENT_REDUNDANT = null;
        public static final FeedbackReason MEMORY_CONTENT_WRONG = null;
        public static final FeedbackReason MEMORY_NOT_DELETED = null;
        public static final FeedbackReason MEMORY_NOT_UPDATED = null;
        public static final FeedbackReason MEMORY_OTHER = null;
        public static final FeedbackReason SEARCH_INCOMPLETE_RESULT = null;
        public static final FeedbackReason SEARCH_NO_RESULT = null;
        public static final FeedbackReason SEARCH_OTHER = null;
        public static final FeedbackReason SEARCH_WRONG_ANSWER = null;
        public static final FeedbackReason TASK_ASK_TOO_MUCH = null;
        public static final FeedbackReason TASK_ERROR_OPERATION = null;
        public static final FeedbackReason TASK_OTHER = null;
        public static final FeedbackReason TASK_TIME_LONG = null;
        public static final FeedbackReason TASK_UI_RELATED = null;
        public static final FeedbackReason TASK_UN_COMPLETED = null;
        public static final /* synthetic */ FeedbackReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int id;
        private final int textRes;
        private final String trackLabel;

        public static EnumEntries<FeedbackReason> getEntries() {
            return b;
        }

        static {
            FeedbackReason r8 = new FeedbackReason("TASK_TIME_LONG", 0, 101, 2131912628, null, 4, null);
            TASK_TIME_LONG = r8;
            String r14 = null;
            int r15 = 4;
            DefaultConstructorMarker r16 = null;
            FeedbackReason r0 = new FeedbackReason("TASK_UN_COMPLETED", 1, ErrorCode.EXECUTE_ACTION_ERROR, 2131912630, r14, r15, r16);
            TASK_UN_COMPLETED = r0;
            String r22 = null;
            int r23 = 4;
            DefaultConstructorMarker r24 = null;
            FeedbackReason r1 = new FeedbackReason("TASK_ERROR_OPERATION", 2, ErrorCode.PARAMETER_ERROR, 2131912626, r22, r23, r24);
            TASK_ERROR_OPERATION = r1;
            FeedbackReason r2 = new FeedbackReason("TASK_ASK_TOO_MUCH", 3, ErrorCode.REGISTER_ERROR, 2131912625, r14, r15, r16);
            TASK_ASK_TOO_MUCH = r2;
            FeedbackReason r3 = new FeedbackReason("TASK_UI_RELATED", 4, ErrorCode.UNREGISTER_ERROR, 2131912629, r22, r23, r24);
            TASK_UI_RELATED = r3;
            FeedbackReason r4 = new FeedbackReason("TASK_OTHER", 5, ErrorCode.APP_VERSION_TOO_LOW, 2131912627, r14, r15, r16);
            TASK_OTHER = r4;
            FeedbackReason r5 = new FeedbackReason("SEARCH_NO_RESULT", 6, 107, 2131912398, "no_result");
            SEARCH_NO_RESULT = r5;
            FeedbackReason r6 = new FeedbackReason("SEARCH_INCOMPLETE_RESULT", 7, 108, 2131912397, "incomplete_result");
            SEARCH_INCOMPLETE_RESULT = r6;
            FeedbackReason r7 = new FeedbackReason("SEARCH_WRONG_ANSWER", 8, 109, 2131912399, "wrong_answer");
            SEARCH_WRONG_ANSWER = r7;
            FeedbackReason r17 = new FeedbackReason("SEARCH_OTHER", 9, ApWakeEvent.RUNNING_START, 2131912627, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
            SEARCH_OTHER = r17;
            FeedbackReason r9 = new FeedbackReason("MEMORY_CONTENT_WRONG", 10, 111, 2131912259, "content_wrong");
            MEMORY_CONTENT_WRONG = r9;
            FeedbackReason r10 = new FeedbackReason("MEMORY_CONTENT_MISSING", 11, ErrorCode.DEVICE_LOCK_ERROR, 2131912254, "content_missing");
            MEMORY_CONTENT_MISSING = r10;
            FeedbackReason r11 = new FeedbackReason("MEMORY_CONTENT_REDUNDANT", 12, ErrorCode.PERMISSION_ERROR, 2131912257, "content_redundant");
            MEMORY_CONTENT_REDUNDANT = r11;
            FeedbackReason r12 = new FeedbackReason("MEMORY_CATEGORY_ERROR", 13, 114, 2131912258, "category_error");
            MEMORY_CATEGORY_ERROR = r12;
            FeedbackReason r13 = new FeedbackReason("MEMORY_NOT_UPDATED", 14, 115, 2131912256, "not_updated");
            MEMORY_NOT_UPDATED = r13;
            FeedbackReason r18 = new FeedbackReason("MEMORY_NOT_DELETED", 15, 115, 2131912255, "not_updated");
            MEMORY_NOT_DELETED = r18;
            FeedbackReason r25 = new FeedbackReason("MEMORY_OTHER", 16, 116, 2131912627, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
            MEMORY_OTHER = r25;
            FeedbackReason[] r19 = {r8, r0, r1, r2, r3, r4, r5, r6, r7, r17, r9, r10, r11, r12, r13, r18, r25};
            a = r19;
            b = EnumEntriesKt.enumEntries(r19);
        }

        public static FeedbackReason[] values() {
            return (FeedbackReason[]) a.clone();
        }

        public final int getId() {
            return this.id;
        }

        public final int getTextRes() {
            return this.textRes;
        }

        public final String getTrackLabel() {
            return this.trackLabel;
        }

        public static FeedbackReason valueOf(String r1) {
            return (FeedbackReason) r27.a.a(FeedbackReason.class, r1);
        }

        public FeedbackReason(String r1, int r2, int r3, int r4, String r5) {
            super(r1, r2);
            this.id = r3;
            this.textRes = r4;
            this.trackLabel = r5;
        }

        public /* synthetic */ FeedbackReason(String r7, int r8, int r9, int r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = null;
        L5:
            this(r7, r8, r9, r10, r11);
        }
    }

    static {
        a = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.TASK_TIME_LONG, FeedbackReason.TASK_UN_COMPLETED, FeedbackReason.TASK_ERROR_OPERATION, FeedbackReason.TASK_ASK_TOO_MUCH, FeedbackReason.TASK_UI_RELATED, FeedbackReason.TASK_OTHER});
        List<FeedbackReason> r0 = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.SEARCH_NO_RESULT, FeedbackReason.SEARCH_INCOMPLETE_RESULT, FeedbackReason.SEARCH_WRONG_ANSWER, FeedbackReason.SEARCH_OTHER});
        b = r0;
        List<FeedbackReason> r1 = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_CONTENT_WRONG, FeedbackReason.MEMORY_CONTENT_MISSING, FeedbackReason.MEMORY_CONTENT_REDUNDANT, FeedbackReason.MEMORY_CATEGORY_ERROR});
        c = r1;
        List<FeedbackReason> r2 = r1;
        FeedbackReason r7 = FeedbackReason.MEMORY_OTHER;
        List<FeedbackReason> r6 = CollectionsKt.plus(r2, CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_NOT_UPDATED, r7}));
        d = r6;
        List<FeedbackReason> r3 = CollectionsKt.plus(r2, CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_NOT_DELETED, r7}));
        e = r3;
        List r4 = CollectionsKt.flatten(CollectionsKt.listOf(new List[]{r0, r6, r3}));
        ArrayList r5 = new ArrayList();
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        FeedbackReason r9 = (FeedbackReason) r8.next();
        String r10 = r9.getTrackLabel();
        if (r10 == null) goto L8;
        Pair r11 = TuplesKt.to(Integer.valueOf(r9.getId()), r10);
    L9:
        if (r11 == null) goto L4;
        r5.add(r11);
        goto L4
    L8:
        r11 = null;
        goto L9
    L11:
        f = MapsKt.toMap(r5);
    }
}
