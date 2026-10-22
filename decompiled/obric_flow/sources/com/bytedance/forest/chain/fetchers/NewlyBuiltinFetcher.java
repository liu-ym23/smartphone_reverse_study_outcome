package com.bytedance.forest.chain.fetchers;

import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/NewlyBuiltinFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/Request;", "request", "Lcom/bytedance/forest/model/w;", "response", "", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "Lkotlin/Function1;", "callback", "fetchAsync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "cancel", "()V", "Companion", "com/bytedance/forest/chain/fetchers/k", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class NewlyBuiltinFetcher extends ResourceFetcher {
    public static final k Companion = null;
    public static final String TAG = "BuiltinFetcher";

    static {
        Companion = new k();
    }

    public NewlyBuiltinFetcher(Forest r5) {
        super(r5);
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(Request r17, w r18, Function1<? super w, Unit> r19) {
        getContext$forest_release().b(new String[]{"builtin_start"});
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, "BuiltinFetcher", "start to fetch from builtin", true, null, "builtin_start", 16);
        com.bytedance.forest.model.m r5 = r17.getGeckoModel();
        if (r5.f4389a.length() != 0) goto L6;
    L7:
        com.bytedance.forest.model.c r10 = r18.s;
        ErrorInfo$Type r11 = ErrorInfo$Type.d;
        r10.getClass();
        r10.f4360a += r10.a(r11, 1, "ak/channel/bundle is empty");
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L6:
        if (r5.a() == true) goto L7;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        LinkedHashMap r13 = com.bytedance.geckox.f.f4747a;     // Catch: Throwable -> L11
        Object r14 = Result.m124constructorimpl(com.bytedance.geckox.f.a(getContext$forest_release().f4621c, r5.f4389a, r5.f4390b, r5.f4391c));     // Catch: Throwable -> L11
    L13:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        String r16 = "";
        if (r15 == null) goto L20;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 5, "BuiltinFetcher", "get builtin path from gecko failed, " + r15, true, r15, null, 32);
        com.bytedance.forest.model.c r20 = r18.s;
        ErrorInfo$Type r21 = ErrorInfo$Type.d;
        String r22 = r15.getMessage();
        if (r22 == null) goto L18;
        r16 = r22;
    L18:
        r20.getClass();
        r20.f4360a += r20.a(r21, 2, r16);
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L20:
        Uri r23 = null;
        if (Result.m130isFailureimpl(r14) == false) goto L23;
        r14 = null;
    L23:
        com.bytedance.geckox.d r24 = (com.bytedance.geckox.d) r14;
        if (r24 != null) goto L28;
        com.bytedance.forest.model.c r25 = r18.s;
        ErrorInfo$Type r26 = ErrorInfo$Type.d;
        r25.getClass();
        r25.f4360a += r25.a(r26, 2, "builtin info from gecko is NULL");
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L28:
        if (com.lynx.tasm.behavior.utils.d.g(r24.f4745c) == false) goto L34;
        com.bytedance.forest.model.c r27 = r18.s;
        ErrorInfo$Type r28 = ErrorInfo$Type.d;
        String r29 = r24.f4745c;
        if (r29 == null) goto L32;
        r16 = r29;
    L32:
        r27.getClass();
        r27.f4360a += r27.a(r28, 2, r16);
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L34:
        String r30 = r24.f4743a;
        if (r30 == null) goto L56;
        if (r30.length() == 0) goto L56;
        String r31 = r24.f4743a;
        if (r31 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        Uri r32 = Uri.parse(r31);
        if (Intrinsics.areEqual(r32.getScheme(), "file") == false) goto L45;
        r23 = r32;
    L45:
        if (r23 == null) goto L50;
        String r33 = r23.getPath();
        if (new File(r33).exists() == true) goto L50;
        com.bytedance.forest.model.c r34 = r18.s;
        r34.getClass();
        r34.f4360a += r34.a(ErrorInfo$Type.d, 3, "builtin file " + r33 + " not exists");
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L50:
        r18.f4442r = true;
        r18.f4443t = r24.f4743a;
        Long r35 = r24.f4744b;
        if (r35 == null) goto L53;
        long r36 = r35.longValue();
    L54:
        r18.f4449z = r36;
        r18.f4444u = ResourceFrom.f4339b;
        r18.f4446w = true;
        r18.d(getContext$forest_release().a(new l(this, r24, r32), r17));
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L53:
        r36 = 0;
    L56:
        com.bytedance.forest.model.c r37 = r18.s;
        ErrorInfo$Type r38 = ErrorInfo$Type.d;
        r37.getClass();
        r37.f4360a += r37.a(r38, 2, "builtin path info from gecko is null or empty");
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r19.invoke(r18);
        return;
    L11:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request r5, w r10) {
        fetchAsync(r5, r10, AnonymousClass1.f4285a);
    }
}
