package com.larus.profile.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.api.UserCreationPrivateStatus;
import com.larus.platform.api.creation.CreateCreationSource;
import com.larus.platform.api.creation.UserCreationType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import fs9.i;
import gs9.c;
import gs9.d;
import gs9.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import sq9.t;
import zp9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 <2\u00020\u0001:\u0001<J8\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000bJT\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u001bJ<\u0010\u001c\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010 J8\u0010!\u001a\u00020\"2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H&J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0016H&J0\u00102\u001a\u00020\"2\u0006\u00103\u001a\u0002042\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H&J0\u00109\u001a\u00020\"2\u0006\u00103\u001a\u0002042\u0006\u00107\u001a\u00020:2\u0016\b\u0002\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010$H&¨\u0006="}, d2 = {"Lcom/larus/profile/api/ICreationService;", "", "addCreationByCanvas", "Lcom/larus/platform/api/creation/AddCreationResult;", "canvasId", "", "canvasSubId", "taskId", "", "privateStatus", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCreation", "messageId", "type", "index", "creationTaskId", "source", "materialId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCreation", "Lkotlin/Pair;", "", "creationId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreation", "isDeletePublic", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCreationContent", "Lcom/larus/platform/api/ModifiedUserCreationResponse;", "title", "coverUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAutoAddCMD", "", "ext", "", "needRestore", "(Ljava/lang/String;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateCreationDetailFragment", "Lcom/larus/profile/api/model/ICreationPagerFragment;", "initConfig", "Lcom/larus/profile/api/model/CreationPagerInitConfig;", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "newDoSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "fragment", "Landroidx/fragment/app/Fragment;", "disablePhotoHelper", "doImageEditor", "context", "Landroid/content/Context;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "doSameInitParams", "Lcom/larus/profile/api/bean/DoImageEditInitParams;", "doVideoEditor", "Lcom/larus/profile/api/bean/DoVideoEditInitParams;", "trackerExt", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\u000fJ8\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096A¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0018H\u0096A¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0096\u0001J/\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020'2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010)H\u0096\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J6\u00100\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010)2\u0006\u00102\u001a\u00020\u0018H\u0096A¢\u0006\u0002\u00103J\u0019\u00104\u001a\u0002052\u0006\u0010 \u001a\u00020!2\u0006\u00106\u001a\u00020\u0018H\u0096\u0001J,\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\tH\u0096A¢\u0006\u0002\u00108J<\u00109\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010=¨\u0006>"}, d2 = {"Lcom/larus/profile/api/ICreationService$Companion;", "Lcom/larus/profile/api/ICreationService;", "<init>", "()V", "addCreation", "Lcom/larus/platform/api/creation/AddCreationResult;", "messageId", "", "type", "", "index", "privateStatus", "creationTaskId", "source", "materialId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCreationByCanvas", "canvasId", "", "canvasSubId", "taskId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreation", "Lkotlin/Pair;", "", "creationId", "isDeletePublic", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doImageEditor", "", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "doSameInitParams", "Lcom/larus/profile/api/bean/DoImageEditInitParams;", "doVideoEditor", "Lcom/larus/profile/api/bean/DoVideoEditInitParams;", "trackerExt", "", "generateCreationDetailFragment", "Lcom/larus/profile/api/model/ICreationPagerFragment;", "initConfig", "Lcom/larus/profile/api/model/CreationPagerInitConfig;", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "handleAutoAddCMD", "ext", "needRestore", "(Ljava/lang/String;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newDoSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "disablePhotoHelper", "updateCreation", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCreationContent", "Lcom/larus/platform/api/ModifiedUserCreationResponse;", "title", "coverUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.profile.api.ICreationService
        public final g a(c r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "initConfig");
            Intrinsics.checkNotNullParameter(r3, "creationPagerInitParams");
            return this.b.a(r2, r3);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object b(String r2, boolean r3, Continuation<? super Pair<Boolean, String>> r4) {
            return this.b.b(r2, r3, r4);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object c(String r11, @UserCreationType Integer r12, String r13, @UserCreationPrivateStatus int r14, String r15, @CreateCreationSource int r16, String r17, Continuation<? super a> r18) {
            return this.b.c(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.larus.profile.api.ICreationService
        public final t d(Fragment r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            return this.b.d(r2, r3);
        }

        @Override // com.larus.profile.api.ICreationService
        public final void e(Context r2, Fragment r3, LifecycleCoroutineScope r4, fs9.g r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r5, "doSameInitParams");
            this.b.e(r2, r3, r4, r5);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object f(String r2, @UserCreationPrivateStatus int r3, Continuation<? super Pair<Boolean, String>> r4) {
            return this.b.f(r2, r3, r4);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object g(String r2, Map<String, String> r3, boolean r4, Continuation<? super Unit> r5) {
            return this.b.g(r2, r3, r4, r5);
        }

        @Override // com.larus.profile.api.ICreationService
        public final void h(Context r2, i r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "doSameInitParams");
            this.b.h(r2, r3, r4);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object i(Long r7, Long r8, String r9, Integer r10, Continuation<? super a> r11) {
            return this.b.i(r7, r8, r9, r10, r11);
        }

        @Override // com.larus.profile.api.ICreationService
        public final Object j(String r2, String r3, String r4, Continuation<? super Pair<ModifiedUserCreationResponse, String>> r5) {
            return this.b.j(r2, r3, r4, r5);
        }

        private Companion() {
            this.b = (ICreationService) ServiceManager.get().getService(ICreationService.class);
        }
    }

    static {
        a = Companion.c;
    }

    g a(c r1, d r2);

    Object b(String r1, boolean r2, Continuation<? super Pair<Boolean, String>> r3);

    Object c(String r1, @UserCreationType Integer r2, String r3, @UserCreationPrivateStatus int r4, String r5, @CreateCreationSource int r6, String r7, Continuation<? super a> r8);

    t d(Fragment r1, boolean r2);

    void e(Context r1, Fragment r2, LifecycleCoroutineScope r3, fs9.g r4);

    Object f(String r1, @UserCreationPrivateStatus int r2, Continuation<? super Pair<Boolean, String>> r3);

    Object g(String r1, Map<String, String> r2, boolean r3, Continuation<? super Unit> r4);

    void h(Context r1, i r2, Map<String, String> r3);

    Object i(Long r1, Long r2, String r3, Integer r4, Continuation<? super a> r5);

    Object j(String r1, String r2, String r3, Continuation<? super Pair<ModifiedUserCreationResponse, String>> r4);
}
