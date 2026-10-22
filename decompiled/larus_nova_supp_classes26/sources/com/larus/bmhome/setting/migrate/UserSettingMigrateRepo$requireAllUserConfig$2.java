package com.larus.bmhome.setting.migrate;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.network.http.a;
import com.larus.platform.model.UserConfigItem;
import hq9.y4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/UserConfigResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.migrate.UserSettingMigrateRepo$requireAllUserConfig$2", f = "UserSettingMigrateRepo.kt", i = {0, 0}, l = {35}, m = "invokeSuspend", n = {"adminSwitchKey", "includesAdminSwitch"}, s = {"I$0", "Z$0"})
public final class UserSettingMigrateRepo$requireAllUserConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super y4>, Object> {
    final /* synthetic */ List<Integer> $configTypes;
    final /* synthetic */ int $reason;
    final /* synthetic */ String $source;
    int I$0;
    boolean Z$0;
    int label;

    public UserSettingMigrateRepo$requireAllUserConfig$2(List<Integer> r1, String r2, int r3, Continuation<? super UserSettingMigrateRepo$requireAllUserConfig$2> r4) {
        this.$configTypes = r1;
        this.$source = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UserSettingMigrateRepo$requireAllUserConfig$2(this.$configTypes, this.$source, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super y4> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        boolean r3 = this.Z$0;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r15);
    L12:
        y4 r16 = (y4) ((a) r15).b;
        if (r16 != null) goto L16;
        return null;
    L16:
        if (r3 == false) goto L48;
        Iterable r5 = r16.a();
        if (r5 != null) goto L20;
        r5 = CollectionsKt.emptyList();
    L20:
        Iterable r6 = r5;
        if ((r6 instanceof Collection) == true) goto L23;
    L25:
        Iterator r7 = r6.iterator();
    L27:
        if (r7.hasNext() == false) goto L37;
        Integer r8 = ((UserConfigItem) r7.next()).b();
        if (r8 != null) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L27;
        r2 = false;
        goto L37
    L32:
        if (r8.intValue() != r4) goto L34;
        r9 = true;
    L37:
        if (r2 == false) goto L49;
        Collection r17 = r16.a();
        if (r17 != null) goto L41;
        r17 = CollectionsKt.emptyList();
    L41:
        ArrayList r10 = new ArrayList(r17);
        r10.add(new UserConfigItem(Boxing.boxInt(r4), TriggerSendLoading.NO_LOADING, Boxing.boxLong(0)));
        return new y4(r10);
    L49:
        return r16;
    L23:
        if (((Collection) r6).isEmpty() == false) goto L25;
    L48:
        return r16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r4 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue();
        boolean r18 = this.$configTypes.contains(Boxing.boxInt(r4));
        FlowDowngradeServiceDelegate r11 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r12 = new JSONObject();
        List<Integer> r13 = this.$configTypes;
        int r14 = this.$reason;
        r12.put("objects", new JSONArray(r13));
        r12.put("reason", r14);
        Unit r19 = Unit.INSTANCE;
        Map r110 = MapsKt.mapOf(TuplesKt.to(MusicAppletPage.KEY_SOURCE, this.$source));
        this.I$0 = r4;
        this.Z$0 = r18;
        this.label = 1;
        Object r20 = IFlowDowngradeService.a.b(r11, "Social", y4.class, "/alice/user/config/pull", r12, null, false, null, r110, this, 1008);
        if (r20 != r0) goto L11;
        return r0;
    L11:
        r3 = r18;
        r15 = r20;
        goto L12
    }
}
