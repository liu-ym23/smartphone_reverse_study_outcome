package com.obric.assistant.card;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.entity.IObricIntentEntityListSheetService;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0007H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/card/ObricIntentEntityListSheetServiceImpl;", "Lcom/obric/assistant/entity/IObricIntentEntityListSheetService;", "<init>", "()V", "openIntentEntityListSheet", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "entitiesJson", NameKeys.UnloadStrategy_No_Strategy, "localMessageId", "messageId", "widgetId", "mixtureCardId", "parseEntities", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "findFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIntentEntityListSheetServiceImpl implements IObricIntentEntityListSheetService {

    public static final class a {
    }

    static {
    }

    public ObricIntentEntityListSheetServiceImpl() {
    }

    public final boolean a(Context r16, String r17, String r18, String r19, String r20, String r21) {
        Context r4 = r16;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r17, "entitiesJson");
        Intrinsics.checkNotNullParameter(r18, "localMessageId");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Intrinsics.checkNotNullParameter(r20, "widgetId");
        Intrinsics.checkNotNullParameter(r21, "mixtureCardId");
    L3:
        List r6 = null;
        if (r4 == null) goto L15;
        if ((r4 instanceof FragmentActivity) == true) goto L7;
        if ((r4 instanceof ContextWrapper) == false) goto L11;
        ContextWrapper r5 = (ContextWrapper) r4;
    L12:
        if (r5 != null) goto L13;
        r4 = null;
        goto L3
    L13:
        r4 = r5.getBaseContext();
        goto L3
    L11:
        r5 = null;
        goto L12
    L7:
        FragmentActivity r13 = (FragmentActivity) r4;
    L17:
        if (r13 != null) goto L21;
        FLogger.a.w("ObricIntentEntityListSheet", "openIntentEntityListSheet: FragmentActivity not found");
        return false;
    L21:
        if (StringsKt.isBlank(r17) == false) goto L77;
        List r0 = CollectionsKt.emptyList();
    L70:
        if (r0.isEmpty() == false) goto L73;
        FLogger.a.w("ObricIntentEntityListSheet", "openIntentEntityListSheet: entities are empty");
        return false;
    L73:
        Bundle r14 = new Bundle();
        r14.putParcelableArrayList(LynxResourceModule.DATA_KEY, new ArrayList(r0));
        r14.putParcelable("message_extra", new MessageExtraForViewHolder(false, false, null, null, r18, null, null, SpeechEvent.SERVER_UPLINK_EVENT_UPDATE_UI_CONTEXT));
        r14.putString("message_id", r19);
        r14.putString("widget_id", r20);
        r14.putString("mixture_card_id", r21);
        int r1 = ShowAllDialogFragment.n;
        ShowAllDialogFragment.a.a(r13.getSupportFragmentManager(), r14);
        return true;
    L77:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L59
        JsonElement r3 = JsonParser.parseString(r17);     // Catch: Throwable -> L59
        if (r3.isJsonArray() == true) goto L27;
        r3 = null;
    L27:
        if (r3 == null) goto L55;
        JsonArray r7 = r3.getAsJsonArray();     // Catch: Throwable -> L59
        if (r7 == null) goto L55;
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L59
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L59
    L32:
        if (r9.hasNext() == false) goto L54;
        JsonElement r10 = (JsonElement) r9.next();     // Catch: Throwable -> L59
        if (r10.isJsonObject() == true) goto L37;
        r10 = null;
    L37:
        if (r10 == null) goto L51;
        JsonObject r11 = r10.getAsJsonObject();     // Catch: Throwable -> L59
        if (r11 == null) goto L51;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L42
        zda.a r15 = zda.a.a;     // Catch: Throwable -> L42
        String r22 = r11.toString();     // Catch: Throwable -> L42
        r15.getClass();     // Catch: Throwable -> L42
        Object r23 = Result.constructor-impl(zda.a.c(r22));     // Catch: Throwable -> L42
    L44:
        Throwable r110 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L59
        if (r110 == null) goto L48;
        FLogger.a.w("ObricIntentEntityListSheet", "parse entity failed: " + r110.getMessage());     // Catch: Throwable -> L59
    L48:
        if (Result.isFailure-impl(r23) == false) goto L50;
        r23 = null;
    L50:
        AppEntity r24 = (AppEntity) r23;     // Catch: Throwable -> L59
    L52:
        if (r24 == null) goto L32;
        r8.add(r24);     // Catch: Throwable -> L59
        goto L32
    L42:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L59
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
    L51:
        r24 = null;
        goto L52
    L54:
        r6 = r8;
    L55:
        if (r6 != null) goto L57;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L59
    L57:
        Object r25 = Result.constructor-impl(r6);     // Catch: Throwable -> L59
    L61:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L65;
        FLogger.a.w("ObricIntentEntityListSheet", "parseEntities failed: " + r26.getMessage(), r26);
    L65:
        if (Result.exceptionOrNull-impl(r25) == null) goto L68;
        r25 = CollectionsKt.emptyList();
    L68:
        r0 = (List) r25;
    L59:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L15:
        r13 = null;
        goto L17
    }
}
