package com.obric.assistant.obric_action;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0016J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H§@¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/obric_action/IObricActionHandler;", "P", "R", "", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "parseData", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "params", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionHandler<P, R> {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<List<IObricActionHandler<?, ?>>> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.obric.assistant.obric_action.a());
        }
    }

    public static final class b {
        public static <P, R> P a(IObricActionHandler<P, R> r3, Context r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "data");
            f r2 = f.a;
            Class<P> r6 = r3.b();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "data");
            Intrinsics.checkNotNullParameter(r6, "paramsType");
            Object r1 = null;
            if (Intrinsics.areEqual(r6, Intent.class) == false) goto L14;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
            Intent r7 = Intent.parseUri(r5, 1);     // Catch: Throwable -> L6
            r7.setPackage(r4.getPackageName());     // Catch: Throwable -> L6
            Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L6
        L9:
            if (Result.isFailure-impl(r8) == true) goto L30;
            r1 = r8;
        L30:
            return r6.cast((Intent) r1);
        L6:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        L14:
            if (Intrinsics.areEqual(r6, String.class) == true) goto L31;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
            Object r11 = Result.constructor-impl(((Gson) f.b.getValue()).fromJson(r5, r6));     // Catch: Throwable -> L18
        L21:
            if (Result.isFailure-impl(r11) == true) goto L25;
            r1 = r11;
        L25:
            return (P) r1;
        L18:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        L31:
            return r6.cast(r5);
        }
    }

    static {
        a = a.a;
    }

    P a(Context r1, String r2);

    Class<P> b();

    d c();

    Object d(Context r1, P r2, Continuation<? super h<? extends R>> r3);
}
