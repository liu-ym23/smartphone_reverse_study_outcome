package com.bytedance.android.livesdk.event;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface ISendCommentEvent extends j {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/event/ISendCommentEvent$Sender;", "", DSLType.Unknown, "CommentWidget", "Lottery", "VsPlusOne", "SubscribeJSB", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Sender extends Enum<Sender> {
        public static final Sender CommentWidget = null;
        public static final Sender Lottery = null;
        public static final Sender SubscribeJSB = null;
        public static final Sender Unknown = null;
        public static final Sender VsPlusOne = null;
        public static final /* synthetic */ Sender[] a = null;

        static {
            Sender r1 = new Sender(DSLType.Unknown, 0);
            Unknown = r1;
            Sender r2 = new Sender("CommentWidget", 1);
            CommentWidget = r2;
            Sender r3 = new Sender("Lottery", 2);
            Lottery = r3;
            Sender r4 = new Sender("VsPlusOne", 3);
            VsPlusOne = r4;
            Sender r5 = new Sender("SubscribeJSB", 4);
            SubscribeJSB = r5;
            a = new Sender[]{r1, r2, r3, r4, r5};
        }

        public static Sender valueOf(String r1) {
            return (Sender) r27.a.a(Sender.class, r1);
        }

        public static Sender[] values() {
            return (Sender[]) a.clone();
        }

        public Sender(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static <T> T a(ISendCommentEvent r1, String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Object r4 = r1.a().get(r2);
            if ((r4 instanceof Object) == true) goto L5;
            r4 = null;
        L5:
            if (r4 != null) goto L8;
            return r3;
        L8:
            return (T) r4;
        }
    }

    Map<String, Object> a();
}
