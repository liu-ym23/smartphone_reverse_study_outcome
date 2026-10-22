package com.larksuite.component.card.component;

import androidx.collection.LruCache;
import com.larksuite.component.card.component.res.ComponentISettings;
import com.larksuite.component.card.utils.NetUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import znc.h;
import znc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardDynamicComponentFetcher implements k7a.a {
    public static final a a = null;
    public static final Object b = null;
    public static final LruCache<String, byte[]> c = null;
    public static final VFSPath d = null;
    public static final Lazy<h> e = null;

    public static final class a implements CoroutineScope {
        public final /* synthetic */ CoroutineScope a;

        public final CoroutineContext getCoroutineContext() {
            return this.a.getCoroutineContext();
        }

        public a() {
            this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        }

        public static final Object a(a r4, String r5) {
            r4.getClass();
            ComponentISettings r0 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);     // Catch: Throwable -> L28
            byte[] r1 = null;
            if (r0 == null) goto L10;
            HashMap<String, ComponentISettings.a> r2 = r0.getDynamicComponents();     // Catch: Throwable -> L28
            if (r2 == null) goto L10;
            ComponentISettings.a r3 = r2.get(r5);     // Catch: Throwable -> L28
            if (r3 == null) goto L10;
            String r6 = r3.b();     // Catch: Throwable -> L28
        L11:
            if (r6 != null) goto L13;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L28
            return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("load file from cdn, cannot find url")));
        L13:
            int r8 = NetUtils.a;     // Catch: Throwable -> L28
            Intrinsics.checkNotNullParameter(r6, "url");     // Catch: Throwable -> L28
            Response r9 = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(r6).build()).execute();     // Catch: Throwable -> L28
            if (r9.isSuccessful() == false) goto L26;
            ResponseBody r10 = r9.body();     // Catch: Throwable -> L28
            if (r10 == null) goto L18;
            r1 = r10.bytes();     // Catch: Throwable -> L28
        L18:
            if (r1 != null) goto L20;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
            return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("load file from cdn response body is null")));
        L20:
            CardDynamicComponentFetcher.c.put(r5, r1);     // Catch: Throwable -> L28
            String r12 = s.b(r5);     // Catch: Throwable -> L23
            Lazy<h> r13 = CardDynamicComponentFetcher.e;     // Catch: Throwable -> L23
            h r14 = (h) r13.getValue();     // Catch: Throwable -> L23
            ByteArrayInputStream r15 = new ByteArrayInputStream(r1);     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r14, "<this>");     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r12, "key");     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r15, "inputStream");     // Catch: Throwable -> L23
            r14.d(r12, new i(r15));     // Catch: Throwable -> L23
            ((h) r13.getValue()).flush();     // Catch: Throwable -> L23
        L36:
            return Result.constructor-impl(r1);
        L23:
            th = move-exception;
            Log.e("CardDynamicComponentFetcher", "save file to diskCache failed", th);     // Catch: Throwable -> L28
            goto L36
        L26:
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
            return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("load file from cdn response is not successful, code: " + r9.code())));
        L10:
            r6 = null;
        L28:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(th));
        }

        public static final Object b(a r3, String r4) {
            r3.getClass();
            File r5 = ((h) CardDynamicComponentFetcher.e.getValue()).a(s.b(r4));     // Catch: Throwable -> L29
            if (r5 != null) goto L6;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L29
            return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("file not in diskCache")));
        L6:
            BufferedSource r7 = Okio.buffer(Okio.source(r5));     // Catch: Throwable -> L29
            byte[] r0 = r7.readByteArray();     // Catch: Throwable -> L24
            CardDynamicComponentFetcher.a.getClass();     // Catch: Throwable -> L24
            CardDynamicComponentFetcher.c.put(r4, r0);     // Catch: Throwable -> L24
            String r1 = null;
            CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L29
            ComponentISettings r8 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);     // Catch: Throwable -> L29
            if (r8 == null) goto L16;
            HashMap<String, ComponentISettings.a> r9 = r8.getDynamicComponents();     // Catch: Throwable -> L29
            if (r9 == null) goto L16;
            ComponentISettings.a r10 = r9.get(r4);     // Catch: Throwable -> L29
            if (r10 == null) goto L16;
            r1 = r10.a();     // Catch: Throwable -> L29
        L16:
            String r11 = s.a(r0);     // Catch: Throwable -> L29
            if (Intrinsics.areEqual(r1, r11) == true) goto L19;
            Log.e("CardDynamicComponentFetcher", "file md5 " + r11 + ", setting md5 " + r1);     // Catch: Throwable -> L29
            boolean r12 = false;
        L20:
            if (r12 == true) goto L39;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
            return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("file in diskCache but invalid")));
        L39:
            return Result.constructor-impl(r0);
        L19:
            r12 = true;
            goto L20
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L29
            throw th;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(th));
        }

        public static final Object c(a r4, String r5, Continuation r6) {
            r4.getClass();
            if ((r6 instanceof CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1) == false) goto L7;
            CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1 r0 = (CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1) r6;
            int r1 = r0.label;
            if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
            r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
        L8:
            Object r7 = r0.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L18:
            return ((Result) r7).unbox-impl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            Log.i("CardDynamicComponentFetcher", "load from net");
            CoroutineDispatcher r9 = Dispatchers.getIO();
            CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 r3 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(r5, null);
            r0.label = 1;
            r7 = BuildersKt.withContext(r9, r3, r0);
            if (r7 != r8) goto L18;
            return r8;
        L7:
            r0 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1(r4, r6);
            goto L8
        }

        public static final Object d(a r4, String r5, Continuation r6) {
            r4.getClass();
            if ((r6 instanceof CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1) == false) goto L7;
            CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1 r0 = (CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1) r6;
            int r1 = r0.label;
            if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
            r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
        L8:
            Object r7 = r0.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L18:
            return ((Result) r7).unbox-impl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            Log.i("CardDynamicComponentFetcher", "load from path");
            CoroutineDispatcher r9 = Dispatchers.getIO();
            CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2 r3 = new CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2(r5, null);
            r0.label = 1;
            r7 = BuildersKt.withContext(r9, r3, r0);
            if (r7 != r8) goto L18;
            return r8;
        L7:
            r0 = new CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1(r4, r6);
            goto L8
        }
    }

    static {
        a = new a();
        b = new Object();
        c = new LruCache(1);
        d = LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, new com.ss.android.lark.storage.d(new String[]{"open_platform", "card_dynamic_components"}));
        e = LazyKt.lazy(CardDynamicComponentFetcher$Fetcher$diskCache$2.INSTANCE);
    }
}
