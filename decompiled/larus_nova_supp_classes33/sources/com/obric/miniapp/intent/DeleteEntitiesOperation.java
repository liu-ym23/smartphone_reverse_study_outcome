package com.obric.miniapp.intent;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DeleteEntitiesOperation {
    public static final DeleteEntitiesOperation a = null;

    public static final class a {
        public final k a;
        public final List<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CallbackResult(result=" + this.a + ", deletedIds=" + this.b + ')';
        }

        public a(k r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
            Intrinsics.checkNotNullParameter(r3, "deletedIds");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final AppEntity[] a;
        public final List<String> b;
        public final String c;

        public b() {
            this(null, null, null, 7);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((Arrays.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ParsedRequest(entities=" + Arrays.toString(this.a) + ", entityIds=" + this.b + ", errorCode=" + this.c + ')';
        }

        public b(AppEntity[] r2, List r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = new AppEntity[0];
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = CollectionsKt.emptyList();
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            Intrinsics.checkNotNullParameter(r2, "entities");
            Intrinsics.checkNotNullParameter(r3, "entityIds");
            Intrinsics.checkNotNullParameter(r4, "errorCode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = new DeleteEntitiesOperation();
    }

    public DeleteEntitiesOperation() {
    }

    public final void a(JSONObject r18, Set<Integer> r19, final Function2<? super k, ? super List<String>, Unit> r20) {
        Intrinsics.checkNotNullParameter(r18, "payload");
        Intrinsics.checkNotNullParameter(r19, "allowedTypes");
        Intrinsics.checkNotNullParameter(r20, "callback");
        Intrinsics.checkNotNullParameter(r18, "payload");
        Intrinsics.checkNotNullParameter(r19, "allowedTypes");
        int r9 = 0;
        if (r18.optJSONObject("entity") == null) goto L6;
        List r0 = CollectionsKt.listOf(r18.optJSONObject("entity"));
    L12:
        if (r0.isEmpty() == true) goto L64;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L16;
    L18:
        Iterator r10 = r1.iterator();
    L20:
        if (r10.hasNext() == false) goto L27;
        if (((JSONObject) r10.next()) != null) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L20;
        boolean r11 = true;
    L28:
        if (r11 == true) goto L64;
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator r15 = CollectionsKt.filterNotNull(r1).iterator();
    L32:
        if (r15.hasNext() == false) goto L63;
        JSONObject r2 = (JSONObject) r15.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L36
        zda.a.a.getClass();     // Catch: Throwable -> L36
        Object r3 = Result.constructor-impl(zda.a.d(r2));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r3) == false) goto L41;
        r3 = null;
    L41:
        AppEntity r4 = (AppEntity) r3;
        if (r4 == null) goto L43;
        if (r19.contains(Integer.valueOf(r4.getType())) == false) goto L46;
        String r17 = r4.getEcaId();
        if (r17 != null) goto L50;
    L54:
        r17 = r4.getId();
        if (r17 != null) goto L57;
    L59:
        r17 = null;
    L60:
        if (r17 != null) goto L62;
        b r5 = new b(null, null, "INVALID_ENTITIES", 3);
    L66:
        final b r6 = r5;
        if (r6.c.length() <= 0) goto L69;
        boolean r7 = true;
    L71:
        if (r7 == false) goto L74;
        FLogger.a.e("DeleteEntitiesOperation", "parse failed error=" + r6.c + " allowedTypes=" + r19 + " hasEntity=" + r18.has("entity") + " hasEntities=" + r18.has("entities"));
        int r8 = k.d;
        r20.invoke(k.a.a(r6.c, "entity payload is invalid"), CollectionsKt.emptyList());
        return;
    L74:
        IAgentAppIntentIDL r21 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r21 != null) goto L81;
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("dispatch failed: aiagent unavailable ids=");
        r23.append(r6.b);
        r23.append(" types=");
        AppEntity[] r24 = r6.a;
        ArrayList r25 = new ArrayList(r24.length);
        int r26 = r24.length;
    L77:
        if (r9 >= r26) goto L79;
        r25.add(Integer.valueOf(r24[r9].getType()));
        r9 = r9 + 1;
        goto L77
    L79:
        r23.append(r25);
        r22.e("DeleteEntitiesOperation", r23.toString());
        int r27 = k.d;
        r20.invoke(k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable"), CollectionsKt.emptyList());
        return;
    L81:
        final AtomicBoolean r28 = new AtomicBoolean(false);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DeleteEntitiesOperation$execute$2(r6, r28, r20, null), 3, null);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L94
        FLogger r30 = FLogger.a;     // Catch: Throwable -> L94
        StringBuilder r31 = new StringBuilder();     // Catch: Throwable -> L94
        r31.append("dispatch ids=");     // Catch: Throwable -> L94
        r31.append(r6.b);     // Catch: Throwable -> L94
        r31.append(" types=");     // Catch: Throwable -> L94
        AppEntity[] r32 = r6.a;     // Catch: Throwable -> L94
        ArrayList r33 = new ArrayList(r32.length);     // Catch: Throwable -> L94
        int r110 = r32.length;     // Catch: Throwable -> L94
        int r111 = 0;
    L83:
        if (r111 >= r110) goto L85;
        r33.add(Integer.valueOf(r32[r111].getType()));     // Catch: Throwable -> L94
        r111 = r111 + 1;     // Catch: Throwable -> L94
        goto L83
    L85:
        r31.append(r33);     // Catch: Throwable -> L94
        r31.append(" packages=");     // Catch: Throwable -> L94
        AppEntity[] r34 = r6.a;     // Catch: Throwable -> L94
        ArrayList r35 = new ArrayList(r34.length);     // Catch: Throwable -> L94
        int r112 = r34.length;     // Catch: Throwable -> L94
        int r113 = 0;
    L86:
        if (r113 >= r112) goto L88;
        r35.add(r34[r113].getPackageName());     // Catch: Throwable -> L94
        r113 = r113 + 1;     // Catch: Throwable -> L94
        goto L86
    L88:
        r31.append(r35);     // Catch: Throwable -> L94
        r30.i("DeleteEntitiesOperation", r31.toString());     // Catch: Throwable -> L94
        r21.deleteEntities(r6.a, new DeleteEntitiesOperation$execute$3$3(this, r6, r28, r20));     // Catch: Throwable -> L92
        Object r36 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L97:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L127;
        FLogger.a.e("DeleteEntitiesOperation", "dispatch exception ids=" + r6.b + " message=" + r37.getMessage(), r37);
        int r38 = k.d;
        String r39 = r37.getMessage();
        if (r39 != null) goto L102;
        r39 = "delete entities request failed";
    L102:
        k r40 = k.a.a("DELETE_ENTITIES_FAILED", r39);
        List r41 = CollectionsKt.emptyList();
        if (r28.compareAndSet(false, true) == false) goto L128;
        r20.invoke(r40, r41);
        return;
    L128:
        return;
    L127:
        return;
    L92:
        th = th;
    L96:
        Result.Companion r42 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L94:
        th = th;
        goto L96
    L69:
        r7 = false;
    L62:
        r13.add(r4);
        r14.add(r17);
        goto L32
    L57:
        if ((!StringsKt.isBlank(r17)) == false) goto L59;
    L50:
        if ((!StringsKt.isBlank(r17)) == true) goto L53;
        r17 = null;
    L53:
        if (r17 != null) goto L62;
    L46:
        r5 = new b(null, null, "INVALID_ENTITY_TYPE", 3);
        goto L66
    L43:
        r5 = new b(null, null, "INVALID_ENTITIES", 3);
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L63:
        r5 = new b((AppEntity[]) r13.toArray(new AppEntity[0]), r14, null, 4);
        goto L66
    L24:
        r12 = false;
    L27:
        r11 = false;
        goto L28
    L16:
        if (r1.isEmpty() == false) goto L18;
    L64:
        r5 = new b(null, null, "INVALID_ENTITIES", 3);
        goto L66
    L6:
        if (r18.optJSONArray("entities") == null) goto L65;
        JSONArray r43 = r18.optJSONArray("entities");
        List r115 = CollectionsKt.createListBuilder();
        int r116 = r43.length();
        int r117 = 0;
    L8:
        if (r117 >= r116) goto L10;
        r115.add(r43.optJSONObject(r117));
        r117 = r117 + 1;
        goto L8
    L10:
        r0 = CollectionsKt.build(r115);
        goto L12
    L65:
        r5 = new b(null, null, "MISSING_ENTITIES", 3);
        goto L66
    }
}
