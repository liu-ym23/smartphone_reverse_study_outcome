package com.obric.assistant.cocreationreview;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/CocreationTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskRepository$loadTasks$2", f = "CocreationTaskRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CocreationTaskRepository$loadTasks$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends e4>>, Object> {
    int label;
    final /* synthetic */ CocreationTaskRepository this$0;

    public CocreationTaskRepository$loadTasks$2(CocreationTaskRepository r1, Continuation<? super CocreationTaskRepository$loadTasks$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CocreationTaskRepository$loadTasks$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<e4>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r9);
        CocreationTaskRepository r10 = this.this$0;
        MemoryResponse r11 = (MemoryResponse) r10.a.invoke(r10.b, Boxing.boxInt(100));
        if (r11.a() == false) goto L51;
        List r12 = (List) r11.c;
        if (r12 != null) goto L9;
        r12 = CollectionsKt.emptyList();
    L9:
        CocreationTaskRepository r2 = this.this$0;
        ArrayList r3 = new ArrayList();
        Iterator r0 = r12.iterator();
    L11:
        if (r0.hasNext() == false) goto L43;
        RecommendComplexQuery r4 = (RecommendComplexQuery) r0.next();
        String r5 = r4.getMeta();
        r2.getClass();
        e4 r7 = null;
        if (StringsKt.isBlank(r5) == false) goto L55;
    L34:
        String r6 = null;
    L35:
        if (r6 != null) goto L38;
    L41:
        if (r7 == null) goto L11;
        r3.add(r7);
        goto L11
    L38:
        if (StringsKt.isBlank(r4.getQuery()) == true) goto L41;
        r7 = new e4(r6, r4.getQuery());
        goto L41
    L55:
        JsonElement r8 = JsonParser.parseString(r5);     // Catch: JsonParseException -> L33
        if (r8.isJsonObject() == false) goto L34;
        JsonElement r13 = r8.getAsJsonObject().get("id");     // Catch: JsonParseException -> L33
        if (r13 == null) goto L34;
        if (r13.isJsonPrimitive() == false) goto L34;
        JsonPrimitive r14 = r13.getAsJsonPrimitive();     // Catch: JsonParseException -> L33
        if (r14.isString() == false) goto L27;
    L29:
        r6 = r14.getAsString();     // Catch: JsonParseException -> L33
        Intrinsics.checkNotNull(r6);     // Catch: JsonParseException -> L33
        if ((!StringsKt.isBlank(r6)) == false) goto L34;
    L27:
        if (r14.isNumber() == true) goto L29;
    L43:
        HashSet r1 = new HashSet();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r3.iterator();
    L45:
        if (r16.hasNext() == false) goto L49;
        Object r17 = r16.next();
        if (r1.add(((e4) r17).a) == false) goto L45;
        r15.add(r17);
        goto L45
    L49:
        int r18 = s3.a;
        s3.b("task.load", "memory synthesis count=" + r12.size() + ", validIds=" + r15.size());
        return r15;
    L51:
        int r19 = s3.a;
        s3.c("task.load", "memory synthesis failed code=" + r11.a);
        throw new IOException("Memory recommendation failed code=" + r11.a);
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
