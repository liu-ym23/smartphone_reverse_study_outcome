package com.larus.bmhome.setting;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.setting.migrate.UserSettingMigrateRepo;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.platform.model.UserConfigItem;
import com.larus.utils.logger.FLogger;
import hq9.y4;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.UserSettingCacheManager$syncServerAndSaveUserSetting$2", f = "UserSettingCacheManager.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
final class UserSettingCacheManager$syncServerAndSaveUserSetting$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ UserConfigKey $key;
    final /* synthetic */ String $value;
    int label;

    public UserSettingCacheManager$syncServerAndSaveUserSetting$2(UserConfigKey r1, String r2, Continuation<? super UserSettingCacheManager$syncServerAndSaveUserSetting$2> r3) {
        this.$key = r1;
        this.$value = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UserSettingCacheManager$syncServerAndSaveUserSetting$2(this.$key, this.$value, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L17:
        a r8 = (a) r7;
        y4 r2 = (y4) r8.b;
        if (r2 == null) goto L23;
        ArrayList r3 = r2.a();
        if (r3 == null) goto L23;
        UserSettingCacheManager.o(UserSettingCacheManager.a, r3, false, null, 6);
    L23:
        return Boxing.boxBoolean(r8 instanceof y);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("UserSettingCacheManager", "syncServerAndSaveUserSetting by user settings");
        Integer r4 = Boxing.boxInt(this.$key.getValue());
        String r5 = this.$value;
        UserSettingCacheManager r6 = UserSettingCacheManager.a;
        UserConfigKey r9 = this.$key;
        r6.getClass();
        UserConfigItem r10 = UserSettingCacheManager.j(r9);
        if (r10 == null) goto L13;
        Long r11 = r10.d();
        if (r11 == null) goto L13;
        long r12 = r11.longValue();
    L14:
        UserConfigItem r13 = new UserConfigItem(r4, r5, Boxing.boxLong(r12));
        int r14 = UserSettingMigrateRepo.a;
        List r15 = CollectionsKt.listOf(r13);
        this.label = 1;
        r7 = UserSettingMigrateRepo.b(r15, this);
        if (r7 != r0) goto L17;
        return r0;
    L13:
        r12 = 1;
        goto L14
    }
}
