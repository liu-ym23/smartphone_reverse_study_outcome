package com.ss.android.lark.myai.export.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import osb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DownVoteFeedbackParam {
    public final nsb.a a;
    public final f b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/DownVoteFeedbackParam$WorkMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "INLINE", "IM_REPLY", "UNREAD_RECOMMEND", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum WorkMode extends Enum<WorkMode> {
        public static final WorkMode CHAT = null;
        public static final WorkMode IM_REPLY = null;
        public static final WorkMode INLINE = null;
        public static final WorkMode UNREAD_RECOMMEND = null;
        public static final /* synthetic */ WorkMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<WorkMode> getEntries() {
            return b;
        }

        static {
            WorkMode r0 = new WorkMode("CHAT", 0, 1);
            CHAT = r0;
            WorkMode r1 = new WorkMode("INLINE", 1, 2);
            INLINE = r1;
            WorkMode r4 = new WorkMode("IM_REPLY", 2, 4);
            IM_REPLY = r4;
            WorkMode r6 = new WorkMode("UNREAD_RECOMMEND", 3, 6);
            UNREAD_RECOMMEND = r6;
            WorkMode[] r7 = {r0, r1, r4, r6};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static WorkMode[] values() {
            return (WorkMode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static WorkMode valueOf(String r1) {
            return (WorkMode) r27.a.a(WorkMode.class, r1);
        }

        public WorkMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public String a;
        public nsb.a b;
        public f c;

        public a() {
            WorkMode r0 = WorkMode.CHAT;
        }
    }

    public DownVoteFeedbackParam(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        if (r2.a != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("aiMessageId");
    L6:
        this.a = r2.b;
        this.b = r2.c;
    }
}
