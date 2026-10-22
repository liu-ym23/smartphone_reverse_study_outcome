package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class MentionBotLocalMessageCreateResult {

    public static final class Failure extends MentionBotLocalMessageCreateResult {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult$Failure$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE_NOT_READY", "DB_ERROR", "PUSH_ERROR", "UNSUPPORTED", "OTHER", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final enum Reason extends Enum<Reason> {
            public static final Reason DB_ERROR = null;
            public static final Reason OTHER = null;
            public static final Reason PUSH_ERROR = null;
            public static final Reason SOURCE_NOT_READY = null;
            public static final Reason UNSUPPORTED = null;
            public static final /* synthetic */ Reason[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<Reason> getEntries() {
                return b;
            }

            static {
                Reason r0 = new Reason("SOURCE_NOT_READY", 0);
                SOURCE_NOT_READY = r0;
                Reason r1 = new Reason("DB_ERROR", 1);
                DB_ERROR = r1;
                Reason r3 = new Reason("PUSH_ERROR", 2);
                PUSH_ERROR = r3;
                Reason r5 = new Reason("UNSUPPORTED", 3);
                UNSUPPORTED = r5;
                Reason r7 = new Reason("OTHER", 4);
                OTHER = r7;
                Reason[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
            }

            public static Reason[] values() {
                return (Reason[]) a.clone();
            }

            public static Reason valueOf(String r1) {
                return (Reason) r27.a.a(Reason.class, r1);
            }

            public Reason(String r1, int r2) {
                super(r1, r2);
            }
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof Failure) == true) goto L9;
            return false;
        L9:
            ((Failure) r3).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Failure(reason=null)";
        }
    }

    public static final class a extends MentionBotLocalMessageCreateResult {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public MentionBotLocalMessageCreateResult() {
    }
}
