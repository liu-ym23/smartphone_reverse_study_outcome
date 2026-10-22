package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/provider/AILabSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AILabSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AILabSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (r2.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_ai_lab"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r22, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r23) {
        if ((r23 instanceof AILabSettingProvider$getSettingItems$1) == false) goto L7;
        AILabSettingProvider$getSettingItems$1 r1 = (AILabSettingProvider$getSettingItems$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        List r5 = (List) r1.L$1;
        final Context r6 = (Context) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L31:
        boolean r7 = ((Boolean) r0).booleanValue();
        r5.add(new com.obric.assistant.settings.spi.a("group_ai_lab", "ai_lab", r6.getString(2131912415), 55, new com.obric.assistant.settings.provider.a(r6), null, null, new AILabSettingProvider$getSettingItems$3(r7, null), null, false, null, null, ErrorCode.EventTask.WIFI_SELECTED_ID_CONDITION_EMPTY));
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Context r8 = r22.getHostContext();
        if (r8 != null) goto L19;
        return CollectionsKt.emptyList();
    L19:
        if (Build.VERSION.SDK_INT >= 23) goto L23;
        return CollectionsKt.emptyList();
    L23:
        if (t9a.b.a().b() == true) goto L34;
        if (t9a.b.a().e() == true) goto L34;
        ArrayList r9 = new ArrayList();
        IAILabService r10 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        AILabSettingProvider$getSettingItems$visibleCheck$1 r12 = new AILabSettingProvider$getSettingItems$visibleCheck$1(r10, null);
        r1.L$0 = r8;
        r1.L$1 = r9;
        r1.label = 1;
        Object r13 = BuildersKt.withContext(r11, r12, r1);
        if (r13 != r3) goto L30;
        return r3;
    L30:
        r5 = r9;
        r6 = r8;
        r0 = r13;
    L34:
        return CollectionsKt.emptyList();
    L7:
        r1 = new AILabSettingProvider$getSettingItems$1(this, r23);
        goto L8
    }
}
