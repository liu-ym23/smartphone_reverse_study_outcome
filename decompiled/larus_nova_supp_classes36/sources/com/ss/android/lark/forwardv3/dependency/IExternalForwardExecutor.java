package com.ss.android.lark.forwardv3.dependency;

import android.content.Context;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IExternalForwardExecutor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/forwardv3/dependency/IExternalForwardExecutor$ExternalForwardFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MESSAGE_CONTENT_TOO_LARGE", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ExternalForwardFailureReason extends Enum<ExternalForwardFailureReason> {
        public static final ExternalForwardFailureReason MESSAGE_CONTENT_TOO_LARGE = null;
        public static final ExternalForwardFailureReason UNKNOWN = null;
        public static final /* synthetic */ ExternalForwardFailureReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ExternalForwardFailureReason> getEntries() {
            return b;
        }

        static {
            ExternalForwardFailureReason r0 = new ExternalForwardFailureReason("UNKNOWN", 0);
            UNKNOWN = r0;
            ExternalForwardFailureReason r1 = new ExternalForwardFailureReason("MESSAGE_CONTENT_TOO_LARGE", 1);
            MESSAGE_CONTENT_TOO_LARGE = r1;
            ExternalForwardFailureReason[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ExternalForwardFailureReason[] values() {
            return (ExternalForwardFailureReason[]) a.clone();
        }

        public static ExternalForwardFailureReason valueOf(String r1) {
            return (ExternalForwardFailureReason) r27.a.a(ExternalForwardFailureReason.class, r1);
        }

        public ExternalForwardFailureReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void onFailure(String r1);

        void onSuccess(Map<String, ? extends ForwardTargetBaseInfoNew> r1);
    }

    void a(CoroutineScope r1, Context r2, List<? extends SearchBaseInfo> r3, String r4, RichText r5, a r6);
}
