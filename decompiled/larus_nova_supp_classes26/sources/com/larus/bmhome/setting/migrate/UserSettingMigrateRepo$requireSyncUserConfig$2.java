package com.larus.bmhome.setting.migrate;

import com.google.gson.Gson;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.f;
import com.larus.platform.model.UserConfigItem;
import hq9.y4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/UserConfigResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.migrate.UserSettingMigrateRepo$requireSyncUserConfig$2", f = "UserSettingMigrateRepo.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class UserSettingMigrateRepo$requireSyncUserConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends y4>>, Object> {
    final /* synthetic */ List<UserConfigItem> $configs;
    int label;

    public UserSettingMigrateRepo$requireSyncUserConfig$2(List<UserConfigItem> r1, Continuation<? super UserSettingMigrateRepo$requireSyncUserConfig$2> r2) {
        this.$configs = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UserSettingMigrateRepo$requireSyncUserConfig$2(this.$configs, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<y4>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L43:
        return (a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        List<UserConfigItem> r2 = this.$configs;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        Integer r6 = ((UserConfigItem) r5).b();
        int r7 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue();
        if (r6 != null) goto L15;
    L16:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L10;
        r3.add(r5);
        goto L10
    L15:
        if (r6.intValue() != r7) goto L16;
        r8 = false;
        goto L18
    L21:
        if (r3.isEmpty() == false) goto L24;
        AsyncThrowable.Companion.getClass();
        return new f(AsyncThrowable.access$getDEFAULT$cp(), null);
    L24:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r10 = r3.iterator();
    L26:
        if (r10.hasNext() == false) goto L39;
        UserConfigItem r11 = (UserConfigItem) r10.next();
        Gson r12 = new Gson();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L30
        Object r15 = Result.constructor-impl(r12.toJson(r11));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r15) == false) goto L35;
        r15 = null;
    L35:
        String r17 = (String) r15;
        if (r17 != null) goto L38;
        r17 = "";
    L38:
        r9.add(new JSONObject(r17));
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L39:
        JSONObject r19 = new JSONObject();
        r19.put("configs", new JSONArray(r9));
        Unit r20 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", y4.class, "/alice/user/config/sync", r19, null, null, false, null, null, null, this, 1008);
        if (r1 != r14) goto L43;
        return r14;
    }
}
