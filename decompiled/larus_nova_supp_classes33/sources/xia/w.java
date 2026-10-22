package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w implements c {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    @Override // xia.c
    public final int a(AppEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        if ((r5 instanceof CallHistoryEntity) == false) goto L32;
        CallHistoryEntity r6 = (CallHistoryEntity) r5;
        int r0 = ((((r6.getTelephones().hashCode() + 0) * 31) + r6.getCallType().name().hashCode()) * 31) + r6.getDuration();
        String r1 = r6.getTag();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        int r2 = r0 * 31;
        int r3 = 1231;
        if (r6.isAIPickup() == false) goto L10;
        int r4 = 1231;
    L11:
        int r7 = (r2 + r4) * 31;
        if (r6.getHasTranscript() == true) goto L15;
        r3 = 1237;
    L15:
        int r8 = r7 + r3;
        String r9 = r6.getTranscript();
        if (r9 == null) goto L18;
        r8 = (r8 * 31) + r9.hashCode();
    L18:
        List r10 = r6.getCarriers();
        if (r10 == null) goto L21;
        r8 = (r8 * 31) + r10.hashCode();
    L21:
        List r11 = r6.getTodoList();
        if (r11 == null) goto L24;
        r8 = (r8 * 31) + r11.hashCode();
    L24:
        String r12 = r6.getTranscriptTitle();
        if (r12 == null) goto L27;
        r8 = (r8 * 31) + r12.hashCode();
    L27:
        String r13 = r6.getSourceNumber();
        if (r13 != null) goto L30;
        return r8;
    L30:
        return (r8 * 31) + r13.hashCode();
    L10:
        r4 = 1237;
        goto L11
    L32:
        throw new IllegalStateException("Check failed.".toString());
    }
}
