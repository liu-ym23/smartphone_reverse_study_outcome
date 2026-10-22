package com.bytedance.ai.debugscene;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.db.AIPackageDatabase;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AppletDebugCommandDispatcher$clearAIPackage$1", f = "AppletDebugCommandDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugCommandDispatcher$clearAIPackage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AppletDebugCommandDispatcher$clearAIPackage$1(Continuation<? super AppletDebugCommandDispatcher$clearAIPackage$1> r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        return new AppletDebugCommandDispatcher$clearAIPackage$1(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r10);
        AIManager r11 = AIManager.a;
        if (AIManager.e == false) goto L12;
        AIPackageManager.a.getClass();
        com.bytedance.ai.utils.f.c(com.bytedance.ai.resource.core.a.a);
        AIPackageStorage r12 = AIPackageStorage.a;
        SupportSQLiteDatabase r13 = AIPackageDatabase.a.b().getOpenHelper().getWritableDatabase();     // Catch: Exception -> L9
        r13.execSQL("DELETE FROM ai_widget_info");     // Catch: Exception -> L9
        r13.execSQL("DELETE FROM ai_applet_info");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageStorage", "clearDatabase : " + ExceptionsKt.stackTraceToString(e));
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
