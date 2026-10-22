package com.bytedance.forest.chain.fetchers;

import android.app.Application;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/BuiltinFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/Request;", "request", "Lcom/bytedance/forest/model/w;", "response", "", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "Lkotlin/Function1;", "callback", "fetchAsync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "cancel", "()V", "Companion", "com/bytedance/forest/chain/fetchers/a", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class BuiltinFetcher extends ResourceFetcher {
    private static final String BUILTIN_DIR = "offline";
    public static final a Companion = null;
    public static final String TAG = "BuiltinFetcher";

    static {
        Companion = new a();
    }

    public BuiltinFetcher(Forest r5) {
        super(r5);
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(Request r10, w r11, Function1<? super w, Unit> r12) {
        getContext$forest_release().b(new String[]{"builtin_start"});
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, "BuiltinFetcher", "start to fetch from buildin", true, null, "builtin_start", 16);
        if (r10.getGeckoModel().a() == false) goto L6;
        com.bytedance.forest.model.c r13 = r11.s;
        ErrorInfo$Type r5 = ErrorInfo$Type.d;
        r13.getClass();
        r13.f4360a += r13.a(r5, 1, "Could not get Channel Or Bundle");
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r12.invoke(r11);
        return;
    L6:
        a r14 = Companion;
        com.bytedance.forest.model.m r15 = r10.getGeckoModel();
        r14.getClass();
        String r16 = r15.f4390b + '/' + StringsKt.A(r15.f4391c, "/");
        if (StringsKt.P(r16, "/") == false) goto L9;
        String r17 = td.d.b(BUILTIN_DIR, r16);
    L10:
        Application r18 = getForest().getApplication();
        boolean r19 = false;
        int r20 = StringsKt.t(r17, '/', 0, 6);
        Integer r21 = Integer.valueOf(r20);
        Object r22 = null;
        if (r20 != (-1)) goto L14;
        r21 = null;
    L14:
        if (r21 == null) goto L31;
        int r23 = r21.intValue();
        if (r17 == null) goto L30;
        String r24 = r17.substring(0, r23);
        String r25 = r17.substring(r23 + 1);
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L20
        Object r27 = Result.m124constructorimpl(r18.getAssets().list(r24));     // Catch: Throwable -> L20
    L23:
        if (Result.m130isFailureimpl(r27) == true) goto L26;
        r22 = r27;
    L26:
        String[] r28 = (String[]) r22;
        if (r28 == null) goto L31;
        r19 = ArraysKt.contains(r28, r25);
    L20:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r27 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L23
    L30:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L31:
        if (r19 == false) goto L33;
        r11.f4442r = true;
        r11.f4443t = r17;
        r11.f4444u = ResourceFrom.f4339b;
        r11.f4446w = true;
        r11.d(getContext$forest_release().a(new b(this, r17), r10));
    L34:
        getContext$forest_release().b(new String[]{"builtin_finish"});
        r12.invoke(r11);
        return;
    L33:
        com.bytedance.forest.model.c r110 = r11.s;
        ErrorInfo$Type r30 = ErrorInfo$Type.d;
        r110.getClass();
        r110.f4360a += r110.a(r30, 3, "builtin resource not exists");
        goto L34
    L9:
        r17 = td.d.b("offline/", r16);
        goto L10
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request r5, w r10) {
        fetchAsync(r5, r10, AnonymousClass1.f4245a);
    }
}
