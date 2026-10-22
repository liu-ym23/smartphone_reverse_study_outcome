package com.ss.android.lark.message.universalcard.datachannel;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageCardRenderUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/message/universalcard/datachannel/MessageCardRenderUtils$StreamingBindViewMethod;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_AND_RENDER", "UPDATE_ONLY", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum StreamingBindViewMethod extends Enum<StreamingBindViewMethod> {
        public static final StreamingBindViewMethod UPDATE_AND_RENDER = null;
        public static final StreamingBindViewMethod UPDATE_ONLY = null;
        public static final /* synthetic */ StreamingBindViewMethod[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StreamingBindViewMethod> getEntries() {
            return b;
        }

        static {
            StreamingBindViewMethod r0 = new StreamingBindViewMethod("UPDATE_AND_RENDER", 0);
            UPDATE_AND_RENDER = r0;
            StreamingBindViewMethod r1 = new StreamingBindViewMethod("UPDATE_ONLY", 1);
            UPDATE_ONLY = r1;
            StreamingBindViewMethod[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static StreamingBindViewMethod[] values() {
            return (StreamingBindViewMethod[]) a.clone();
        }

        public static StreamingBindViewMethod valueOf(String r1) {
            return (StreamingBindViewMethod) r27.a.a(StreamingBindViewMethod.class, r1);
        }

        public StreamingBindViewMethod(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public static boolean a(LynxCardContentVO r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((v5b.a) r1).a.isStreamingMode();
    }
}
