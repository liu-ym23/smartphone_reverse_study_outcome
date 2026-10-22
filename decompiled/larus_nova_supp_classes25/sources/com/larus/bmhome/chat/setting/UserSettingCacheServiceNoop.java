package com.larus.bmhome.chat.setting;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.platform.model.UserConfigItem;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0006H\u0016J$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0096@¢\u0006\u0002\u0010%R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/setting/UserSettingCacheServiceNoop;", "Lcom/larus/bmhome/chat/setting/IUserSettingCacheService;", "<init>", "()V", "userConfigs", "", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "Lcom/larus/platform/model/UserConfigItem;", "updatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "answerWithVideo", "", "keywordHighlightEngine", "", "settingEngineType", "userConfigUpdatedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserConfigUpdatedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "init", "", "saveAnswerWithVideo", "", "value", "notifyServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerWithVideo", "saveKeywordHighlightEngine", "getKeywordHighlightEngine", "getSettingEngineType", "saveUserSettings", "", "getLocalUserSettingList", "getUserSetting", "key", "syncUserConfig", "configs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UserSettingCacheServiceNoop implements IUserSettingCacheService {
    public final Map<UserConfigKey, UserConfigItem> a;
    public final MutableSharedFlow<UserConfigKey> b;
    public int c;
    public String d;
    public final MutableSharedFlow e;

    public final int f() {
        return 0;
    }

    public final void init() {
    }

    public final List<UserConfigItem> g() {
        return CollectionsKt.toList(((LinkedHashMap) this.a).values());
    }

    public UserSettingCacheServiceNoop() {
        this.a = new LinkedHashMap();
        MutableSharedFlow<UserConfigKey> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.b = r0;
        this.d = "";
        this.e = r0;
    }

    public final int S() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final d1<UserConfigKey> i() {
        return this.e;
    }

    public final UserConfigItem b(UserConfigKey r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (UserConfigItem) ((LinkedHashMap) this.a).get(r2);
    }

    public final void c(List<UserConfigItem> r4) {
        Intrinsics.checkNotNullParameter(r4, "userConfigs");
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        UserConfigItem r0 = (UserConfigItem) r5.next();
        Integer r1 = r0.b();
        if (r1 == null) goto L4;
        UserConfigKey.a r2 = UserConfigKey.Companion;
        int r3 = r1.intValue();
        r2.getClass();
        UserConfigKey r6 = UserConfigKey.a.a(r3);
        if (r6 == null) goto L4;
        this.a.put(r6, r0);
        this.b.tryEmit(r6);
        goto L4
    }

    public final Object a(List<UserConfigItem> r1, Continuation<? super List<UserConfigItem>> r2) {
        c(r1);
        return r1;
    }

    public final Object d(String r1, boolean r2, Continuation<? super Boolean> r3) {
        Integer r4 = StringsKt.toIntOrNull(r1);
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        this.c = r5;
        return Boxing.boxBoolean(true);
    L5:
        r5 = 0;
        goto L6
    }

    public final Object h(String r1, boolean r2, Continuation<? super Boolean> r3) {
        this.d = r1;
        return Boxing.boxBoolean(true);
    }
}
