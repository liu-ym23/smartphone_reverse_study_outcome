package com.obric.assistant.provider;

import android.database.MatrixCursor;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi$a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/MatrixCursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MatrixCursor>, Object> {
    int label;

    public ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2(Continuation<? super ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MatrixCursor> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L13:
        List r8 = (List) r7;
    L15:
        MatrixCursor r2 = new MatrixCursor(new String[]{"package_name", "app_permission_status"});
        if (r8 == null) goto L21;
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        com.obric.assistant.settings.e r3 = (com.obric.assistant.settings.e) r9.next();
        r2.addRow(new Object[]{r3.a, Boxing.boxInt(r3.b ? 1 : 0)});
    L21:
        return r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IObricAutoGuiSettingsApi r10 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        if (r10 == null) goto L14;
        this.label = 1;
        r7 = IObricAutoGuiSettingsApi$a.a(r10, false, this, 3);
        if (r7 != r0) goto L13;
        return r0;
    L14:
        r8 = null;
        goto L15
    }
}
