package com.larus.bmhome.setting;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.setting.migrate.UserSettingMigrateRepo;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.platform.model.UserConfigItem;
import com.larus.utils.logger.FLogger;
import hq9.y4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.UserSettingCacheManager$syncServerAndSaveUserSettings$2", f = "UserSettingCacheManager.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
final class UserSettingCacheManager$syncServerAndSaveUserSettings$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Map<UserConfigKey, String> $settings;
    int label;

    public UserSettingCacheManager$syncServerAndSaveUserSettings$2(Map<UserConfigKey, String> r1, Continuation<? super UserSettingCacheManager$syncServerAndSaveUserSettings$2> r2) {
        this.$settings = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UserSettingCacheManager$syncServerAndSaveUserSettings$2(this.$settings, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L21:
        y r11 = (a) r10;
        if ((r11 instanceof y) == false) goto L30;
        y4 r12 = (y4) ((a) r11).b;
        Unit r3 = null;
        if (r12 == null) goto L28;
        ArrayList r13 = r12.a();
        if (r13 == null) goto L28;
        UserSettingCacheManager.o(UserSettingCacheManager.a, r13, false, null, 6);
        r3 = Unit.INSTANCE;
    L28:
        if (r3 == null) goto L30;
    L32:
        return Boxing.boxBoolean(r2);
    L30:
        r2 = false;
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FLogger.a.i("UserSettingCacheManager", "syncServerAndSaveUserSettings by privacy settings");
        Map<UserConfigKey, String> r14 = this.$settings;
        ArrayList r4 = new ArrayList(r14.size());
        Iterator<Map.Entry<UserConfigKey, String>> r15 = r14.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<UserConfigKey, String> r5 = r15.next();
        UserConfigKey r6 = r5.getKey();
        String r7 = r5.getValue();
        Integer r8 = Boxing.boxInt(r6.getValue());
        UserSettingCacheManager.a.getClass();
        UserConfigItem r9 = UserSettingCacheManager.j(r6);
        if (r9 == null) goto L16;
        Long r16 = r9.d();
        if (r16 == null) goto L16;
        long r17 = r16.longValue();
    L17:
        r4.add(new UserConfigItem(r8, r7, Boxing.boxLong(r17)));
    L16:
        r17 = 1;
        goto L17
    L18:
        int r18 = UserSettingMigrateRepo.a;
        this.label = 1;
        r10 = UserSettingMigrateRepo.b(r4, this);
        if (r10 != r0) goto L21;
        return r0;
    }
}
