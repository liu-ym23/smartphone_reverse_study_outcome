package com.larus.bmhome.chat.manager;

import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.QuotaConfig;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.TitleQuotaModel;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.c2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class Gpt4SwitchManager {
    public static final CoroutineScope a = null;
    public static final ISettingRepoService b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.Gpt4SwitchManager$1", f = "Gpt4SwitchManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CoroutineScope r3 = Gpt4SwitchManager.a;
            ((Keva) Gpt4SwitchManager.c.getValue()).registerChangeListener(new k0());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.Gpt4SwitchManager$2", f = "Gpt4SwitchManager.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.Gpt4SwitchManager$2$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r4, Continuation r5) {
                UserConfigKey r6 = (UserConfigKey) r4;
                FLogger.a.d("OgfSwitchManager", "OgfSwitchManager.init userConfigUpdatedFlow:" + r6);
                if (r6 != UserConfigKey.USE_OFG_SWITCH) goto L9;
                Object r7 = BuildersKt.withContext(Dispatchers.getMain(), new Gpt4SwitchManager$2$1$1(null), r5);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
                return r7;
            L10:
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IUserSettingCacheService r5 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
            if (r5 == null) goto L18;
            d1 r6 = r5.i();
            if (r6 == null) goto L18;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public Gpt4SwitchManager() {
    }

    static {
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        a = r0;
        b = RepoDispatcherDelegate.b.c();
        c = LazyKt.lazy(new h0());
        d = LazyKt.lazy(new i0());
        e = LazyKt.lazy(new j0());
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
        BuildersKt.launch$default(r0, null, null, new AnonymousClass2(null), 3, null);
    }

    public static final void a() {
        int r0 = ((Keva) c.getValue()).getInt(TitleQuotaModel.KEY_LEFT_QUOTA_COUNT, 0);
        boolean r1 = b.y0();
        Iterator r2 = ((List) d.getValue()).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Function2 r3 = (Function2) ((WeakReference) r2.next()).get();
        if (r3 == null) goto L4;
        r3.invoke(Boolean.valueOf(r1), Integer.valueOf(r0));
        goto L4
    }

    public static boolean c() {
        return ((Keva) c.getValue()).getBoolean("key_has_sub_benefits_".concat(AccountService.a.getSecUserId()), false);
    }

    public static void b(String r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default(a, Dispatchers.getMain(), null, new Gpt4SwitchManager$addShowGpt4LoadingTextMessageId$1(r7, null), 2, null);
        return;
    L4:
        if (r7.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static boolean d(String r6) {
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 == null) goto L53;
        QuotaConfig r1 = r0.b1();
        if (r1 == null) goto L53;
        boolean r3 = true;
        if (b.y0() == true) goto L10;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L17;
        return false;
    L17:
        if (r6 != null) goto L19;
    L22:
        BotModel r4 = null;
        if (r3 == true) goto L30;
        BotModel r7 = BotInfoCache.INSTANCE.get(r6);
        if (r7 == null) goto L29;
        r4 = r7;
    L29:
        r4 = r4;
    L30:
        List r8 = r1.g();
        if (r8 != null) goto L33;
        r8 = CollectionsKt.emptyList();
    L33:
        List r5 = r1.a();
        if (r5 != null) goto L36;
        r5 = CollectionsKt.emptyList();
    L36:
        if (r4 == null) goto L40;
        Integer r9 = r4.getBotType();
        if (r9 == null) goto L40;
        long r10 = r9.intValue();
    L41:
        if (r4 == null) goto L44;
        String r11 = r4.getBotId();
        if (r11 == null) goto L44;
    L46:
        if (r8.contains(Long.valueOf(r10)) == true) goto L49;
        return false;
    L49:
        if (r5.contains(r11) == false) goto L52;
        return false;
    L52:
        return r1.e();
    L44:
        r11 = "";
    L40:
        r10 = -1;
        goto L41
    L19:
        if (r6.length() == 0) goto L22;
        r3 = false;
        goto L22
    L10:
        if (((Keva) c.getValue()).getInt(TitleQuotaModel.KEY_LEFT_QUOTA_COUNT, 0) <= 0) goto L12;
    L13:
        r2 = true;
        goto L15
    L12:
        if (c2.a.a() == false) goto L14;
    L53:
        return false;
    }
}
