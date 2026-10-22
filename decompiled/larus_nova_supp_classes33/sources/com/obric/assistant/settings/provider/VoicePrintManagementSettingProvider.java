package com.obric.assistant.settings.provider;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/provider/VoicePrintManagementSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVoicePrintManagementClick", "", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoicePrintManagementSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public VoicePrintManagementSettingProvider() {
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
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.settings.provider.w1] */
    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r30, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r31) {
        if ((r31 instanceof VoicePrintManagementSettingProvider$getSettingItems$1) == false) goto L7;
        VoicePrintManagementSettingProvider$getSettingItems$1 r2 = (VoicePrintManagementSettingProvider$getSettingItems$1) r31;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L17;
        if (r5 != 1) goto L12;
        Context r6 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L33:
        final Context r13 = r6;
        final boolean r12 = ((Boolean) r1).booleanValue();
        final BluetoothDevice r10 = null;
        final Boolean r11 = null;
        int r7 = 0;
    L34:
        if (r7 == 0) goto L42;
        if (r12 == false) goto L42;
        if (com.obric.assistant.t1.a.u() == false) goto L42;
        if (r10 == null) goto L42;
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L42;
        final boolean r8 = true;
    L43:
        String r17 = r13.getString(2131912571);
        Function1 r9 = new u1(this);
        if (r7 == 0) goto L46;
        final boolean r14 = true;
    L48:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_voice", "voice_print_management", r17, 95, r9, null, new v1(r14, r10, r11, r12, r13), new VoicePrintManagementSettingProvider$getSettingItems$4(null), new w1(r8), false, null, null, 7456));
    L46:
        r14 = false;
    L42:
        r8 = false;
        goto L43
    L12:
        if (r5 != 2) goto L15;
        r7 = r2.I$0;
        boolean r15 = r2.Z$0;
        BluetoothDevice r16 = (BluetoothDevice) r2.L$1;
        Context r18 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r11 = (Boolean) r1;
        r13 = r18;
        r12 = r15;
        r10 = r16;
        goto L34
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r1);
        Context r19 = r30.getHostContext();
        if (r19 != null) goto L22;
        return CollectionsKt.emptyList();
    L22:
        if (Build.VERSION.SDK_INT >= 23) goto L26;
        return CollectionsKt.emptyList();
    L26:
        if (ega.a.a() == false) goto L28;
        CoroutineDispatcher r20 = Dispatchers.getIO();
        VoicePrintManagementSettingProvider$getSettingItems$isVoicePrintExisted$1 r21 = new VoicePrintManagementSettingProvider$getSettingItems$isVoicePrintExisted$1(null);
        r2.L$0 = r19;
        r2.label = 1;
        Object r22 = BuildersKt.withContext(r20, r21, r2);
        if (r22 != r4) goto L32;
        return r4;
    L32:
        r6 = r19;
        r1 = r22;
        goto L33
    L28:
        return CollectionsKt.emptyList();
    L7:
        r2 = new VoicePrintManagementSettingProvider$getSettingItems$1(this, r31);
        goto L8
    }
}
