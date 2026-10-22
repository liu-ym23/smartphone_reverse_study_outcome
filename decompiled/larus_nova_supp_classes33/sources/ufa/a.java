package ufa;

import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.assistant.card.utils.c;
import com.obric.capabilitykit.common.CardProvider;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p9a.b;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static com.obric.assistant.remote_card_container.widget.a a(Message r6, AppIntentMessage r7) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Object r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        List r8 = c.d(r7);
        if (r8 == null) goto L8;
        Parcelable r9 = (Parcelable) CollectionsKt.firstOrNull(r8);
    L10:
        if ((r9 instanceof AppIntentCardData) == false) goto L12;
        AppIntentCardData r10 = (AppIntentCardData) r9;
    L14:
        if (r10 == null) goto L43;
        CardProvider r11 = r10.getCardProvider();
        if (r11 == null) goto L43;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L32
        String r3 = r11.getCardUri();     // Catch: Throwable -> L32
        String r4 = "";
        if (r3 != null) goto L22;
        r3 = "";
    L22:
        String r12 = r6.getLocalMessageId();     // Catch: Throwable -> L32
        if (r12 == null) goto L26;
        r4 = r12;
    L26:
        String r13 = r11.getExtraParams();     // Catch: Throwable -> L32
        Integer r14 = r11.getViewHeight();     // Catch: Throwable -> L32
        if (r14 == null) goto L29;
        int r15 = r14.intValue();     // Catch: Throwable -> L32
    L30:
        Object r16 = Result.constructor-impl(new com.obric.assistant.remote_card_container.widget.a(r3, r4, r13, RangesKt.coerceAtLeast(r15, 0)));     // Catch: Throwable -> L32
    L34:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L38;
        e r5 = b.a;
        b.c("RemoteCardUtil", "extractCardData failed: " + r17.getMessage(), r17);
    L38:
        if (Result.isFailure-impl(r16) == true) goto L42;
        r0 = r16;
    L42:
        return (com.obric.assistant.remote_card_container.widget.a) r0;
    L29:
        r15 = 0;
    L32:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L43:
        FLogger.a.i("RemoteCardUtil", "extractCardData: no card data");
        return null;
    L12:
        r10 = null;
        goto L14
    L8:
        r9 = null;
        goto L10
    }
}
