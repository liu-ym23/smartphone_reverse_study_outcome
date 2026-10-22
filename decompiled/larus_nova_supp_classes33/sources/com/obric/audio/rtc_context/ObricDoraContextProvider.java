package com.obric.audio.rtc_context;

import android.os.SystemClock;
import bda.b;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.aiagent.assistant.idl.u;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wc9.e;
import zca.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/rtc_context/ObricDoraContextProvider;", "Lcom/obric/audio/rtc_context/IObricDoraContextProvider;", "<init>", "()V", "TAG", "", "isAgentExtCompleted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getObricContext", "", "roundId", "", "forceUpdateFull", "", "getPersonalContext", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraContextProvider implements IObricDoraContextProvider {
    public final String b;
    public final AtomicBoolean c;

    @Override // com.obric.audio.rtc_context.IObricDoraContextProvider
    public final JSONObject c() {
        if (ObricAsrDelegate.b.q() == true) goto L6;
        FLogger.a.i(this.b, "getPersonalContext: canUpdatePersonalContextToAsr=false");
        return null;
    L6:
        IAgentVoiceInteractionIDL r0 = u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r0 == null) goto L9;
        PersonalContextInfo r1 = r0.getUserRecentData();
    L10:
        if (r1 == null) goto L12;
        String r2 = r1.getPersonalInfo();
    L13:
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L28;
        FLogger.a.i(this.b, "getPersonalContext: personalInfo is empty");
        return null;
    L28:
        JSONArray r4 = new JSONArray(r2);     // Catch: JSONException -> L25
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        r6.put("personal_ctx", r4);
        r6.put("update_nonstream_context_finish", r1.isComplete());
        Unit r7 = Unit.INSTANCE;
        r5.put("context_data", r6);
        FLogger.a.i(this.b, "getPersonalContext: " + r5);
        return r5;
    L25:
        e = move-exception;
        FLogger.a.w(this.b, "getPersonalContext: parse personalInfo failed", e);
        return null;
    L15:
        if (r2.length() == 0) goto L18;
        r3 = false;
        goto L19
    L12:
        r2 = null;
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    public ObricDoraContextProvider() {
        this.b = "ObricDoraContextProvider";
        this.c = new AtomicBoolean(false);
    }

    @Override // com.obric.audio.rtc_context.IObricDoraContextProvider
    public final Map<String, String> a(long r12, boolean r14) {
        long r0 = SystemClock.elapsedRealtime();
        boolean r2 = this.c.get();
        if (r14 == false) goto L5;
    L9:
        HashMap r5 = new HashMap();
        IObricChatService.a.getClass();
        IObricChatService r6 = IObricChatService.a.a();
        Boolean r7 = null;
        if (r6 == null) goto L12;
        e r8 = r6.h();
    L13:
        if (r6 == null) goto L15;
        r6.g();
        a r9 = MessageApiImpl.a.f(r5, r8, new b.a("", ""));
    L16:
        if (r9 == null) goto L18;
        this.c.set(r9.b);
        r5.putAll(r9.a);
    L18:
        FLogger r10 = FLogger.a;
        String r11 = this.b;
        StringBuilder r13 = new StringBuilder("getObricContext: roundId=");
        r13.append(r12);
        r13.append(", previousAgentExtCompleted=");
        r13.append(r2);
        r13.append(", forceUpdateFullExt: ");
        r13.append(r14);
        r13.append(", currentAgentExtCompleted=");
        if (r9 == null) goto L21;
        r7 = Boolean.valueOf(r9.b);
    L21:
        r13.append(r7);
        r13.append(", originMap=");
        r13.append(r5);
        r13.append(", cost=");
        r13.append(SystemClock.elapsedRealtime() - r0);
        r13.append("ms");
        r10.i(r11, r13.toString());
        return MapsKt.toMap(r5);
    L15:
        r9 = null;
        goto L16
    L12:
        r8 = null;
        goto L13
    L5:
        if (r12 <= 0) goto L9;
        if (r2 == false) goto L9;
        FLogger.a.i(this.b, "getObricContext: roundId=" + r12 + ", previousAgentExtCompleted=" + r2 + ", forceUpdateFullExt: false, return empty");
        return MapsKt.emptyMap();
    }
}
