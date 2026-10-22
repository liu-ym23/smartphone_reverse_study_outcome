package com.larus.profile.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.api.creation.UpdateUserCreationMusic;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.ICreationService;
import com.larus.profile.api.bean.UpdateUserCreationContent;
import com.larus.profile.impl.creation.CreationDoSameAbility;
import com.larus.profile.impl.creation.CreationImageEditAbility;
import com.larus.profile.impl.creation.CreationPagerFragment;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J.\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J8\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096@¢\u0006\u0002\u0010)JN\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010(2\b\u0010-\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u00101J*\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 032\u0006\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020(H\u0096@¢\u0006\u0002\u00106J*\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 032\u0006\u00104\u001a\u00020 2\u0006\u00108\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u00109J<\u0010:\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010;\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u0001032\u0006\u00104\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010 2\b\u0010=\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010>J6\u0010?\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010 2\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010A\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010BJ.\u0010C\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010 2\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010DJ6\u0010E\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010 2\b\u0010F\u001a\u0004\u0018\u00010 2\b\u0010G\u001a\u0004\u0018\u00010 2\b\u00104\u001a\u0004\u0018\u00010 H\u0082@¢\u0006\u0002\u0010HR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/profile/impl/CreationServiceImpl;", "Lcom/larus/profile/api/ICreationService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "generateCreationDetailFragment", "Lcom/larus/profile/api/model/ICreationPagerFragment;", "initConfig", "Lcom/larus/profile/api/model/CreationPagerInitConfig;", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "newDoSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "fragment", "Landroidx/fragment/app/Fragment;", "disablePhotoHelper", "", "doImageEditor", "", "context", "Landroid/content/Context;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "doImageEditInitParams", "Lcom/larus/profile/api/bean/DoImageEditInitParams;", "doVideoEditor", "doSameInitParams", "Lcom/larus/profile/api/bean/DoVideoEditInitParams;", "trackerExt", "", "", "addCreationByCanvas", "Lcom/larus/platform/api/creation/AddCreationResult;", "canvasId", "", "canvasSubId", "taskId", "privateStatus", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCreation", "messageId", "type", "index", "creationTaskId", "source", "materialId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCreation", "Lkotlin/Pair;", "creationId", "creationPrivateStatus", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreation", "isDeletePublic", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCreationContent", "Lcom/larus/platform/api/ModifiedUserCreationResponse;", "title", "coverUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAutoAddCMD", "ext", "needRestore", "(Ljava/lang/String;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseExt", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportAutoAddCreation", "botId", "creationType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationServiceImpl implements ICreationService {
    public final Keva b;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/profile/impl/CreationServiceImpl$parseExt$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public CreationServiceImpl() {
        this.b = Keva.getRepo("creation_landing", 0);
    }

    @Override // com.larus.profile.api.ICreationService
    public final gs9.g a(gs9.c r4, gs9.d r5) {
        Intrinsics.checkNotNullParameter(r4, "initConfig");
        Intrinsics.checkNotNullParameter(r5, "creationPagerInitParams");
        CreationPagerFragment r0 = new CreationPagerFragment(r4.a);
        r0.l = r4.b;
        r0.m = r4.c;
        String r1 = r4.d;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.n = r1;
        r0.o = r4.e;
        String r2 = r4.f;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.q = r2;
        r0.r = r4.g;
        r0.s = r4.h;
        r0.t = r5;
        return r0;
    }

    @Override // com.larus.profile.api.ICreationService
    public final sq9.t d(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new CreationDoSameAbility(r2, r3);
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object b(String r13, boolean r14, Continuation<? super Pair<Boolean, String>> r15) {
        if ((r15 instanceof CreationServiceImpl$deleteCreation$1) == false) goto L7;
        CreationServiceImpl$deleteCreation$1 r0 = (CreationServiceImpl$deleteCreation$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        com.larus.network.http.f r8 = null;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L24:
        com.larus.network.http.a r17 = (com.larus.network.http.a) r16;
    L25:
        String r18 = "";
        if ((r17 instanceof com.larus.network.http.y) == true) goto L28;
        Boolean r19 = Boxing.boxBoolean(false);
        if ((r17 instanceof com.larus.network.http.f) == false) goto L32;
        r8 = (com.larus.network.http.f) r17;
    L32:
        if (r8 == null) goto L40;
        AsyncThrowable r110 = r8.d;
        if (r110 == null) goto L40;
        String r111 = Boxing.boxLong(r110.getCode()).toString();
        if (r111 == null) goto L40;
        r18 = r111;
    L40:
        return TuplesKt.to(r19, r18);
    L28:
        return TuplesKt.to(Boxing.boxBoolean(true), "");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = r0.Z$0;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        String r3 = r13;
        boolean r5 = r14;
        r17 = (com.larus.network.http.a) r16;
        if ((r17 instanceof com.larus.network.http.y) == true) goto L25;
        Lazy<ProfileRepo> r112 = ProfileRepo.b;
        ProfileRepo r113 = ProfileRepo.a.a();
        Integer r4 = Boxing.boxInt(3);
        r0.L$0 = null;
        r0.label = 2;
        r113.getClass();
        r16 = ProfileRepo.h(r3, null, r4, null, r5, r0);
        if (r16 != r7) goto L24;
        return r7;
    L16:
        ResultKt.throwOnFailure(r16);
        Lazy<ProfileRepo> r114 = ProfileRepo.b;
        ProfileRepo r115 = ProfileRepo.a.a();
        Integer r6 = Boxing.boxInt(3);
        r0.L$0 = r13;
        r0.Z$0 = r14;
        r0.label = 1;
        r115.getClass();
        r16 = ProfileRepo.h(r13, null, r6, null, r14, r0);
        if (r16 != r7) goto L19;
        return r7;
    L7:
        r0 = new CreationServiceImpl$deleteCreation$1(this, r15);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object f(String r17, int r18, Continuation<? super Pair<Boolean, String>> r19) {
        if ((r19 instanceof CreationServiceImpl$updateCreation$1) == false) goto L7;
        CreationServiceImpl$updateCreation$1 r1 = (CreationServiceImpl$updateCreation$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        com.larus.network.http.f r12 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L25:
        com.larus.network.http.a r4 = (com.larus.network.http.a) r0;
    L26:
        String r5 = "";
        if ((r4 instanceof com.larus.network.http.y) == true) goto L29;
        Boolean r6 = Boxing.boxBoolean(false);
        if ((r4 instanceof com.larus.network.http.f) == false) goto L33;
        r12 = (com.larus.network.http.f) r4;
    L33:
        if (r12 == null) goto L41;
        AsyncThrowable r7 = r12.d;
        if (r7 == null) goto L41;
        String r8 = Boxing.boxLong(r7.getCode()).toString();
        if (r8 == null) goto L41;
        r5 = r8;
    L41:
        return TuplesKt.to(r6, r5);
    L29:
        return TuplesKt.to(Boxing.boxBoolean(true), "");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r9 = r1.I$0;
        String r10 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        int r15 = r9;
    L20:
        r4 = (com.larus.network.http.a) r0;
        if ((r4 instanceof com.larus.network.http.y) == true) goto L26;
        Lazy<ProfileRepo> r13 = ProfileRepo.b;
        ProfileRepo r14 = ProfileRepo.a.a();
        Integer r16 = Boxing.boxInt(r15);
        r1.L$0 = null;
        r1.label = 2;
        r0 = ProfileRepo.i(r14, r10, null, null, r16, false, r1, 16);
        if (r0 != r11) goto L25;
        return r11;
    L16:
        ResultKt.throwOnFailure(r0);
        Lazy<ProfileRepo> r20 = ProfileRepo.b;
        ProfileRepo r21 = ProfileRepo.a.a();
        Integer r22 = Boxing.boxInt(r18);
        r1.L$0 = r17;
        r15 = r18;
        r1.I$0 = r15;
        r1.label = 1;
        Object r23 = ProfileRepo.i(r21, r17, null, null, r22, false, r1, 16);
        if (r23 != r11) goto L19;
        return r11;
    L19:
        r10 = r17;
        r0 = r23;
    L7:
        r1 = new CreationServiceImpl$updateCreation$1(this, r19);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final void h(Context r7, fs9.i r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "doSameInitParams");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "doVideoEditInitParams");
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L8;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L8;
        String r2 = r1.W();
        if (r2 == null) goto L8;
    L9:
        Bundle r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r2), TuplesKt.to("argBotType", 1)});
        com.bytedance.router.i r10 = SmartRouter.buildRoute(r7, "//flow/chat_page");
        r10.c.putExtras(r3);
        Pair[] r4 = new Pair[6];
        r4[0] = TuplesKt.to("actionbar_instruction_prompt", AppHost.a.getApplication().getString(2131905606));
        nr9.g r5 = r8.a;
        if (r5 == null) goto L12;
        String r6 = HttpExtKt.p(r5);
    L13:
        r4[1] = TuplesKt.to("creation_remote_video_play_data", r6);
        r4[2] = TuplesKt.to("creation_remote_video_prompt", r8.c);
        r4[3] = TuplesKt.to("creation_remote_video_ref_image_url", r8.d);
        r4[4] = TuplesKt.to("creation_remote_video_task_id", r8.e);
        r4[5] = TuplesKt.to("creation_msg_id", r8.b);
        Bundle r11 = com.larus.utils.f.c(r4);
        if (r9 != null) goto L16;
        r9 = MapsKt.emptyMap();
    L16:
        Iterator<Map.Entry<String, String>> r12 = r9.entrySet().iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<String, String> r13 = r12.next();
        r11.putString(r13.getKey(), r13.getValue());
        goto L18
    L20:
        r10.c.putExtras(r11);
        r10.d = 2130772401;
        r10.e = 2130772399;
        r10.d();
        return;
    L12:
        r6 = null;
    L8:
        r2 = "7234781073513644036";
        goto L9
    }

    public final Object k(String r13, Map<String, String> r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof CreationServiceImpl$parseExt$1) == false) goto L7;
        CreationServiceImpl$parseExt$1 r0 = (CreationServiceImpl$parseExt$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r17 = (Iterator) r0.L$3;
        String r18 = (String) r0.L$2;
        String r4 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        String r19 = r18;
        String r110 = r5;
    L39:
        if (r17.hasNext() == false) goto L44;
        String r8 = (String) r17.next();
        r0.L$0 = r110;
        r0.L$1 = r4;
        r0.L$2 = r19;
        r0.L$3 = r17;
        r0.label = 1;
        if (l(r110, r4, r19, r8, r0) != r2) goto L39;
        return r2;
    L44:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        boolean r111 = false;
        if (r14 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L46;
        if (r13 != null) goto L24;
    L25:
        r111 = true;
    L26:
        if (r111 == true) goto L46;
        String r112 = null;
        if (r14 == null) goto L31;
        r4 = r14.get("bot_id");
    L32:
        if (r14 == null) goto L34;
        String r7 = r14.get("type");
    L35:
        if (r14 == null) goto L37;
        r112 = r14.get("creation_ids");
    L37:
        List r113 = (List) GsonProtectorUtils.fromJson(new Gson(), r112, new a().getType());
        Intrinsics.checkNotNull(r113);
        Iterator r114 = r113.iterator();
        r19 = r7;
        r110 = r13;
        r17 = r114;
        goto L39
    L34:
        r7 = null;
        goto L35
    L31:
        r4 = null;
        goto L32
    L24:
        if (r13.length() != 0) goto L26;
    L46:
        return Unit.INSTANCE;
    L17:
        if (r14.isEmpty() == true) goto L20;
        r6 = false;
    L7:
        r0 = new CreationServiceImpl$parseExt$1(this, r15);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final void e(Context r1, Fragment r2, LifecycleCoroutineScope r3, fs9.g r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "doImageEditInitParams");
        new CreationImageEditAbility(r1, r3, r4).c();
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object g(String r5, Map<String, String> r6, boolean r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof CreationServiceImpl$handleAutoAddCMD$1) == false) goto L7;
        CreationServiceImpl$handleAutoAddCMD$1 r0 = (CreationServiceImpl$handleAutoAddCMD$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = r0.Z$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L20
    L26:
    L22:
        if (r7 == false) goto L25;
        this.b.storeBoolean("has_unread_creation", true);
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        r0.Z$0 = r7;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        if (k(r5, r6, r0) != r2) goto L26;
        return r2;
    L20:
        e = move-exception;
        FLogger.a.e("CreationServiceImpl", "parseExt error: " + e.getMessage());
    L7:
        r0 = new CreationServiceImpl$handleAutoAddCMD$1(this, r8);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object j(String r10, String r11, String r12, Continuation<? super Pair<ModifiedUserCreationResponse, String>> r13) {
        if ((r13 instanceof CreationServiceImpl$updateCreationContent$1) == false) goto L7;
        CreationServiceImpl$updateCreationContent$1 r0 = (CreationServiceImpl$updateCreationContent$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CreationServiceImpl$updateCreationContent$1 r7 = r0;
        Object r14 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        com.larus.network.http.f r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof com.larus.network.http.y) == true) goto L25;
        if ((r15 instanceof com.larus.network.http.f) == false) goto L23;
        int r16 = lm9.e.a;
        return TuplesKt.to(null, lm9.e.a(r15.d, ""));
    L23:
        return null;
    L25:
        return TuplesKt.to(((com.larus.network.http.a) ((com.larus.network.http.y) r15)).b, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Lazy<ProfileRepo> r17 = ProfileRepo.b;
        ProfileRepo r4 = ProfileRepo.a.a();
        UpdateUserCreationContent r5 = new UpdateUserCreationContent(new UpdateUserCreationMusic(r11, r12));
        r7.label = 1;
        r14 = ProfileRepo.i(r4, r10, r5, null, null, false, r7, 28);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationServiceImpl$updateCreationContent$1(this, r13);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object i(Long r11, Long r12, String r13, Integer r14, Continuation<? super zp9.a> r15) {
        if ((r15 instanceof CreationServiceImpl$addCreationByCanvas$1) == false) goto L7;
        CreationServiceImpl$addCreationByCanvas$1 r0 = (CreationServiceImpl$addCreationByCanvas$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L25:
        return (zp9.a) r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (Integer) r0.L$3;
        r13 = (String) r0.L$2;
        r12 = (Long) r0.L$1;
        r11 = (Long) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        Long r5 = r11;
        Long r6 = r12;
        String r7 = r13;
        Integer r8 = r14;
        zp9.a r17 = (zp9.a) r16;
        if (r17.a == true) goto L26;
        Lazy<ProfileRepo> r18 = ProfileRepo.b;
        ProfileRepo r19 = ProfileRepo.a.a();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        r19.getClass();
        r16 = BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$createUserCreationByCanvas$2(r5, r6, r7, r8, null), r0);
        if (r16 != r2) goto L25;
        return r2;
    L26:
        return r17;
    L16:
        ResultKt.throwOnFailure(r16);
        Lazy<ProfileRepo> r110 = ProfileRepo.b;
        ProfileRepo r111 = ProfileRepo.a.a();
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r13;
        r0.L$3 = r14;
        r0.label = 1;
        r111.getClass();
        r16 = BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$createUserCreationByCanvas$2(r11, r12, r13, r14, null), r0);
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r0 = new CreationServiceImpl$addCreationByCanvas$1(this, r15);
        goto L8
    }

    public final Object l(String r31, String r32, String r33, String r34, Continuation<? super Unit> r35) {
        String r0 = r31;
        String r1 = r32;
        String r2 = r33;
        String r3 = r34;
        if ((r35 instanceof CreationServiceImpl$reportAutoAddCreation$1) == false) goto L7;
        CreationServiceImpl$reportAutoAddCreation$1 r5 = (CreationServiceImpl$reportAutoAddCreation$1) r35;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        String r17 = null;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        wc9.e r8 = (wc9.e) r5.L$4;
        String r9 = (String) r5.L$3;
        String r10 = (String) r5.L$2;
        String r11 = (String) r5.L$1;
        String r12 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
        String r24 = r9;
        String r25 = r10;
        String r19 = r11;
        String r18 = r12;
    L79:
        BotModel r14 = (BotModel) r4;
        if (r8 == null) goto L82;
        Integer r15 = r8.v;
    L83:
        if (r15 != null) goto L86;
    L89:
        if (r15 != null) goto L92;
    L94:
        if (r15 != null) goto L97;
    L115:
        String r16 = "others_created";
    L116:
        tx9.m0.a(r18, r19, r16, "chat_list", "chat", true, r24, r25, "auto_add", 1536);
        return Unit.INSTANCE;
    L97:
        if (r15.intValue() != 2) goto L115;
        if (r14 == null) goto L105;
        Integer r20 = r14.getBotType();
        if (r20 == null) goto L105;
        if (r20.intValue() != 2) goto L105;
        boolean r110 = true;
    L106:
        if (r110 == false) goto L108;
        r16 = "other_default";
        goto L116
    L108:
        if (r14 == null) goto L113;
        BotCreatorInfo r21 = r14.getBotCreatorInfo();
        if (r21 == null) goto L113;
        r17 = r21.getId();
    L113:
        if (Intrinsics.areEqual(r17, AccountService.a.getUserId()) == false) goto L115;
        r16 = "self_created";
    L105:
        r110 = false;
        goto L106
    L92:
        if (r15.intValue() != 3) goto L94;
        r16 = "default_new";
        goto L116
    L86:
        if (r15.intValue() != 1) goto L89;
        r16 = "default";
        goto L116
    L82:
        r15 = null;
        goto L83
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r22 = (String) r5.L$4;
        String r23 = (String) r5.L$3;
        r2 = (String) r5.L$2;
        String r26 = (String) r5.L$1;
        String r27 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
        boolean r111 = false;
    L70:
        wc9.e r28 = (wc9.e) r4;
        String r29 = r22;
        r8 = r28;
    L72:
        IBotRepoService r30 = RepoDispatcherDelegate.b.b();
        if (r29 != null) goto L75;
        r29 = "0";
    L75:
        r5.L$0 = r27;
        r5.L$1 = r26;
        r5.L$2 = r2;
        r5.L$3 = r23;
        r5.L$4 = r8;
        r5.label = 3;
        r4 = r30.j1(r29, r111, r5);
        if (r4 != r13) goto L78;
        return r13;
    L78:
        r24 = r23;
        r25 = r2;
        r19 = r26;
        r18 = r27;
        goto L79
    L17:
        String r36 = (String) r5.L$3;
        String r37 = (String) r5.L$2;
        String r38 = (String) r5.L$1;
        String r39 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r3 = r36;
        r0 = r39;
        r2 = r37;
        r1 = r38;
    L56:
        Message r40 = (Message) r4;
    L58:
        if (r40 == null) goto L60;
        r29 = r40.getConversationId();
    L61:
        IConversationRepoService r41 = RepoDispatcherDelegate.b.f();
        if (r41 == null) goto L71;
        if (r29 != null) goto L65;
        String r42 = "0";
    L66:
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r2;
        r5.L$3 = r3;
        r5.L$4 = r29;
        r5.label = 2;
        r111 = false;
        Object r43 = IConversationRepoService.a.c(r41, r42, false, null, r5, 6);
        if (r43 != r13) goto L69;
        return r13;
    L69:
        r27 = r0;
        r22 = r29;
        r4 = r43;
        String r210 = r3;
        r26 = r1;
        r23 = r210;
        goto L70
    L65:
        r42 = r29;
        goto L66
    L71:
        r111 = false;
        r27 = r0;
        r8 = null;
        String r211 = r3;
        r26 = r1;
        r23 = r211;
        goto L72
    L60:
        r29 = null;
        goto L61
    L18:
        ResultKt.throwOnFailure(r4);
        if (r0 != null) goto L21;
    L24:
        boolean r44 = true;
    L25:
        if (r44 == true) goto L119;
        if (r1 != null) goto L28;
    L31:
        boolean r45 = true;
    L32:
        if (r45 == true) goto L119;
        if (r2 != null) goto L35;
    L38:
        boolean r46 = true;
    L39:
        if (r46 == true) goto L119;
        if (r3 != null) goto L42;
    L45:
        boolean r47 = true;
    L46:
        if (r47 == true) goto L119;
        IChatRepoService r48 = RepoDispatcherDelegate.b.e();
        if (r48 == null) goto L57;
        if (r0 != null) goto L52;
        String r49 = "0";
    L53:
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r2;
        r5.L$3 = r3;
        r5.label = 1;
        r4 = r48.E1(r49, r5);
        if (r4 != r13) goto L56;
        return r13;
    L52:
        r49 = r0;
        goto L53
    L57:
        r40 = null;
        goto L58
    L42:
        if (r34.length() == 0) goto L45;
        r47 = false;
        goto L46
    L35:
        if (r33.length() == 0) goto L38;
        r46 = false;
        goto L39
    L28:
        if (r32.length() == 0) goto L31;
        r45 = false;
    L119:
        return Unit.INSTANCE;
    L21:
        if (r31.length() == 0) goto L24;
        r44 = false;
    L7:
        r5 = new CreationServiceImpl$reportAutoAddCreation$1(this, r35);
        goto L8
    }

    @Override // com.larus.profile.api.ICreationService
    public final Object c(String r38, Integer r39, String r40, int r41, String r42, int r43, String r44, Continuation<? super zp9.a> r45) {
        String r8 = r38;
        Integer r9 = r39;
        String r10 = r40;
        String r11 = r42;
        int r12 = r43;
        String r13 = r44;
        if ((r45 instanceof CreationServiceImpl$addCreation$1) == false) goto L7;
        CreationServiceImpl$addCreation$1 r1 = (CreationServiceImpl$addCreation$1) r45;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreationServiceImpl$addCreation$1 r15 = r1;
        Object r0 = r15.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        boolean r16 = false;
        long r23 = 0;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L121:
        return (zp9.a) r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r4 = r15.I$1;
        int r14 = r15.I$0;
        String r17 = (String) r15.L$4;
        String r18 = (String) r15.L$3;
        String r19 = (String) r15.L$2;
        Integer r110 = (Integer) r15.L$1;
        String r111 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
        Object r5 = r7;
        int r6 = 1;
        int r112 = 4;
        r12 = r4;
        int r20 = r14;
        r8 = r111;
        r13 = r17;
        r9 = r110;
        r11 = r18;
        r10 = r19;
    L74:
        zp9.a r21 = (zp9.a) r0;
        if (r21.a == true) goto L122;
        Lazy<ProfileRepo> r22 = ProfileRepo.b;
        ProfileRepo r24 = ProfileRepo.a.a();
        if (r9 != null) goto L79;
        char r25 = 2;
    L81:
        if (r9 != null) goto L83;
        char r26 = 5;
    L86:
        if (r9 != null) goto L89;
    L91:
        Integer[] r27 = new Integer[7];
        r27[0] = Boxing.boxInt(7);
        r27[r6] = Boxing.boxInt(6);
        r27[r25] = Boxing.boxInt(9);
        r27[3] = Boxing.boxInt(8);
        r27[r112] = Boxing.boxInt(10);
        r27[r26] = Boxing.boxInt(11);
        r27[6] = Boxing.boxInt(12);
        if (CollectionsKt.contains(CollectionsKt.listOf(r27), r9) == false) goto L99;
        if (r11 == null) goto L96;
        Long r28 = StringsKt.toLongOrNull(r11);
    L97:
        fs9.e r29 = new fs9.e(r8, null, null, null, null, new fs9.c0(r28), 30);
    L109:
        if (r11 != null) goto L111;
    L116:
        String r30 = null;
    L117:
        fs9.f r31 = new fs9.f(r29, new fs9.k(r8, r30, r13), null, r112);
        Integer r32 = Boxing.boxInt(r20);
        r15.L$0 = null;
        r15.L$1 = null;
        r15.L$2 = null;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.label = 2;
        r24.getClass();
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$createUserCreation$2(r32, r12, r31, null), r15);
        if (r0 != r5) goto L121;
        return r5;
    L111:
        if (r11.length() != 0) goto L113;
        r16 = true;
    L113:
        if (r16 == true) goto L116;
        r30 = r11;
        goto L117
    L96:
        r28 = null;
        goto L97
    L99:
        if (r10 == null) goto L101;
        Long r33 = StringsKt.toLongOrNull(r10);
    L102:
        r29 = new fs9.e(r8, null, null, new fs9.z(r33), null, null, 54);
        goto L109
    L101:
        r33 = null;
        goto L102
    L89:
        if (r9.intValue() != r6) goto L91;
        r29 = new fs9.e(r8, null, new fs9.l(r10), null, null, null, 58);
        goto L109
    L83:
        r26 = 5;
        if (r9.intValue() != 5) goto L86;
    L104:
        if (r10 == null) goto L108;
        Long r34 = StringsKt.toLongOrNull(r10);
        if (r34 == null) goto L108;
        r23 = r34.longValue();
    L108:
        r29 = new fs9.e(r8, new fs9.j(Boxing.boxLong(r23)), null, null, null, null, 60);
        goto L109
    L79:
        r25 = 2;
        if (r9.intValue() == 2) goto L104;
    L122:
        return r21;
    L16:
        ResultKt.throwOnFailure(r0);
        Lazy<ProfileRepo> r35 = ProfileRepo.b;
        ProfileRepo r210 = ProfileRepo.a.a();
        if (r9 != null) goto L20;
    L21:
        if (r9 != null) goto L24;
    L26:
        if (r9 != null) goto L29;
    L31:
        Object r36 = r7;
        if (r9 != null) goto L35;
        int r37 = 7;
        r112 = 4;
    L42:
        Integer[] r46 = new Integer[r37];
        r46[0] = Boxing.boxInt(r37);
        r46[1] = Boxing.boxInt(6);
        r46[2] = Boxing.boxInt(8);
        r46[3] = Boxing.boxInt(9);
        r46[r112] = Boxing.boxInt(10);
        r46[5] = Boxing.boxInt(11);
        r46[6] = Boxing.boxInt(12);
        if (CollectionsKt.contains(CollectionsKt.listOf(r46), r9) == false) goto L50;
        if (r11 == null) goto L47;
        Long r47 = StringsKt.toLongOrNull(r42);
    L48:
        fs9.e r211 = new fs9.e(r38, null, null, null, null, new fs9.c0(r47), 30);
    L61:
        fs9.e r48 = r211;
    L62:
        if (r11 != null) goto L64;
    L70:
        String r49 = null;
    L71:
        fs9.f r50 = new fs9.f(r48, new fs9.k(r8, r49, r13), null, r112);
        Integer r51 = Boxing.boxInt(r41);
        r15.L$0 = r8;
        r15.L$1 = r9;
        r15.L$2 = r10;
        r15.L$3 = r11;
        r15.L$4 = r13;
        r20 = r41;
        r15.I$0 = r20;
        r15.I$1 = r12;
        r6 = 1;
        r15.label = 1;
        r210.getClass();
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$createUserCreation$2(r51, r12, r50, null), r15);
        r5 = r36;
        if (r0 != r5) goto L74;
        return r5;
    L64:
        if (r42.length() != 0) goto L66;
        boolean r52 = true;
    L67:
        if (r52 == true) goto L70;
        r49 = r11;
        goto L71
    L66:
        r52 = false;
        goto L67
    L47:
        r47 = null;
        goto L48
    L50:
        if (r10 == null) goto L52;
        Long r53 = StringsKt.toLongOrNull(r40);
    L53:
        r211 = new fs9.e(r38, null, null, new fs9.z(r53), null, null, 54);
        goto L61
    L52:
        r53 = null;
        goto L53
    L35:
        if (r39.intValue() == 4) goto L37;
        r112 = 4;
        r37 = 7;
        goto L42
    L37:
        if (r10 == null) goto L39;
        Long r54 = StringsKt.toLongOrNull(r40);
    L40:
        r112 = 4;
        r211 = new fs9.e(r38, null, null, null, new fs9.a(r54), null, 46);
        goto L61
    L39:
        r54 = null;
        goto L40
    L29:
        if (r39.intValue() != 1) goto L31;
        r36 = r7;
        r48 = new fs9.e(r38, null, new fs9.l(r10), null, null, null, 58);
        r112 = 4;
        goto L62
    L24:
        if (r39.intValue() != 5) goto L26;
    L54:
        r36 = r7;
        r112 = 4;
        if (r10 == null) goto L59;
        Long r55 = StringsKt.toLongOrNull(r40);
        if (r55 == null) goto L59;
        long r56 = r55.longValue();
    L60:
        r211 = new fs9.e(r38, new fs9.j(Boxing.boxLong(r56)), null, null, null, null, 60);
    L59:
        r56 = 0;
        goto L60
    L20:
        if (r39.intValue() == 2) goto L54;
    L7:
        r1 = new CreationServiceImpl$addCreation$1(this, r45);
        goto L8
    }
}
