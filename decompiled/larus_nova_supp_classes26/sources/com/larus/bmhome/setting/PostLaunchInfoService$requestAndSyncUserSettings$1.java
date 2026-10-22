package com.larus.bmhome.setting;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.setting.migrate.UserSettingMigrateRepo;
import com.larus.network.http.a;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.y0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.y4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.PostLaunchInfoService$requestAndSyncUserSettings$1", f = "PostLaunchInfoService.kt", i = {}, l = {29, 51}, m = "invokeSuspend", n = {}, s = {})
public final class PostLaunchInfoService$requestAndSyncUserSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LaunchInfo $launchData;
    int label;
    final /* synthetic */ PostLaunchInfoService this$0;

    public PostLaunchInfoService$requestAndSyncUserSettings$1(PostLaunchInfoService r1, LaunchInfo r2, Continuation<? super PostLaunchInfoService$requestAndSyncUserSettings$1> r3) {
        this.this$0 = r1;
        this.$launchData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PostLaunchInfoService$requestAndSyncUserSettings$1(this.this$0, this.$launchData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L71:
        y4 r14 = (y4) ((a) r13).b;
        if (r14 == null) goto L76;
        ArrayList r15 = r14.a();
        if (r15 == null) goto L76;
        UserSettingCacheManager.o(UserSettingCacheManager.a, r15, false, null, 6);
    L76:
        LaunchInfo r16 = this.$launchData;
        if (r16 == null) goto L85;
        FeatureConfig r17 = r16.y0();
        if (r17 == null) goto L85;
        FeatureDetail r18 = r17.G0();
        if (r18 == null) goto L85;
        if (r18.b() != true) goto L85;
    L86:
        if (r5 == true) goto L91;
        ISettingRepoService r19 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        if (r19 == null) goto L91;
        r19.I0(false);
    L91:
        return Unit.INSTANCE;
    L85:
        r5 = false;
        goto L86
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L18:
        y4 r110 = (y4) r13;
        if (r110 == null) goto L21;
        ArrayList r111 = r110.a();
    L22:
        if (r111 == null) goto L24;
        UserSettingCacheManager.o(UserSettingCacheManager.a, r111, true, null, 4);
    L24:
        UserSettingCacheManager.a.getClass();
        ArrayList r2 = UserSettingCacheManager.g();
        ArrayList r6 = new ArrayList();
        Iterator r3 = r2.iterator();
    L26:
        if (r3.hasNext() == false) goto L39;
        Object r7 = r3.next();
        UserConfigItem r9 = (UserConfigItem) r7;
        if (r111 == null) goto L36;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r8 = r111.iterator();
    L31:
        if (r8.hasNext() == false) goto L34;
        r10.add(((UserConfigItem) r8.next()).b());
        goto L31
    L34:
        if (r10.contains(r9.b()) == true) goto L36;
        boolean r11 = true;
    L37:
        if (r11 == false) goto L26;
        r6.add(r7);
    L36:
        r11 = false;
        goto L37
    L39:
        LaunchInfo r112 = this.$launchData;
        PostLaunchInfoService r4 = this.this$0;
        if (r112 == null) goto L48;
        FeatureConfig r113 = r112.y0();
        if (r113 == null) goto L48;
        FeatureDetail r114 = r113.E();
        if (r114 == null) goto L48;
        if (r114.b() != true) goto L48;
        boolean r115 = true;
    L49:
        if (r115 == true) goto L62;
        List r116 = CollectionsKt.toMutableList(r6);
        r6 = new ArrayList();
        Iterator r117 = r116.iterator();
    L52:
        if (r117.hasNext() == false) goto L62;
        Object r12 = r117.next();
        Integer r20 = ((UserConfigItem) r12).b();
        int r118 = UserConfigKey.SAVE_CHAT_HISTORY.getValue();
        if (r20 != null) goto L57;
    L58:
        boolean r21 = true;
    L60:
        if (r21 == false) goto L52;
        r6.add(r12);
        goto L52
    L57:
        if (r20.intValue() != r118) goto L58;
        r21 = false;
    L62:
        FLogger r119 = FLogger.a;
        String r22 = r4.a;
        StringBuilder r23 = new StringBuilder("sync user config(");
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r25 = r6.iterator();
    L64:
        if (r25.hasNext() == false) goto L66;
        r24.add(((UserConfigItem) r25.next()).c());
        goto L64
    L66:
        r23.append(CollectionsKt.toList(r24));
        r23.append(')');
        r119.i(r22, r23.toString());
        if ((!r6.isEmpty()) == false) goto L76;
        int r120 = UserSettingMigrateRepo.a;
        this.label = 2;
        r13 = UserSettingMigrateRepo.b(r6, this);
        if (r13 != r0) goto L71;
        return r0;
    L48:
        r115 = false;
        goto L49
    L21:
        r111 = null;
        goto L22
    L10:
        ResultKt.throwOnFailure(r13);
        y0 r121 = y0.a;
        if (r121.h() == true) goto L13;
    L92:
        FLogger.a.d(this.this$0.a, "requestAndSyncUserSetting is intercepted");
        return Unit.INSTANCE;
    L13:
        if (r121.f() == true) goto L92;
        FLogger.a.d(this.this$0.a, "requestAndSyncUserSettings");
        UserSettingRepo r122 = UserSettingRepo.a;
        UserConfigKey.Companion.getClass();
        List r26 = UserConfigKey.a.b();
        int r27 = UserConfigPullReason.STARTUP.getValue();
        String r28 = DowngradeSource.AFTER_LAUNCH.getValue();
        this.label = 1;
        r13 = r122.d(r26, r27, r28, this);
        if (r13 != r0) goto L18;
        return r0;
    }
}
