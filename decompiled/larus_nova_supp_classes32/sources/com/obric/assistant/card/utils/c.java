package com.obric.assistant.card.utils;

import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.common.CardProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final Object b(AppIntentCardData r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.getType();
        if (r0 != 0) goto L5;
        return r5;
    L5:
        if (r0 == 1) goto L8;
        FLogger.a.w("AppIntentMessageEx", "AppIntentCardData.innerData unknown type " + r5.getType());
    L12:
        return null;
    L8:
        CardProvider r6 = r5.getCardProvider();
        if (r6 != null) goto L13;
        FLogger.a.w("AppIntentMessageEx", "AppIntentCardData.innerData no cardProvider");
        goto L12
    L13:
        return r6;
    }

    public static final Object c(AppIntentCardData r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.getType();
        if (r0 != 0) goto L5;
        CardProvider r6 = r5.getAppEntity();
        if (r6 != null) goto L17;
        FLogger.a.w("AppIntentMessageEx", "AppIntentCardData.innerData no appEntity");
        return null;
    L17:
        return r6;
    L5:
        if (r0 == 1) goto L7;
        FLogger.a.w("AppIntentMessageEx", "AppIntentCardData.innerData unknown type " + r5.getType());
        return null;
    L7:
        r6 = r5.getCardProvider();
        if (r6 != null) goto L17;
        FLogger.a.w("AppIntentMessageEx", "AppIntentCardData.innerData no cardProvider");
        return null;
    }

    public static final List<Parcelable> d(AppIntentMessage r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getDataV2() == null) goto L7;
        return r1.getDataV2();
    L7:
        return r1.getData();
    }

    public static final MessageExtraForViewHolder a(AppIntentMessage r9, Message r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "message");
        boolean r2 = r9.isPaused();
        boolean r3 = r9.getShowRecentContact();
        String r4 = r9.getDataSource().getSourceIntent();
        String r5 = r9.getDataSource().getIntentName();
        String r1 = r10.getLocalMessageId();
        if (r1 != null) goto L6;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return new MessageExtraForViewHolder(r2, r3, r4, r5, r1, r9.getExt(), r10.getExt());
    }
}
