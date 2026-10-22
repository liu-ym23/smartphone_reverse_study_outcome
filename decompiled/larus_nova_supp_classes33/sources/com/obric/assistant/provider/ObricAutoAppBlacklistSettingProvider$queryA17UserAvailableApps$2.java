package com.obric.assistant.provider;

import android.database.MatrixCursor;
import android.os.Bundle;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.h1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/MatrixCursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MatrixCursor>, Object> {
    int label;

    public ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2(Continuation<? super ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2(r2);
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
        h1 r8 = (h1) r7;
        if (r8 == null) goto L24;
        MatrixCursor r2 = new MatrixCursor(new String[]{"package_name"});
        Iterator<T> r3 = r8.a.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        r2.addRow(new String[]{((com.obric.assistant.settings.e) r3.next()).a});
        goto L17
    L19:
        Bundle r4 = new Bundle();
        r4.putBoolean("is_complete", r8.b);
        r2.setExtras(r4);
        return r2;
    L24:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IObricAutoGuiSettingsApi r9 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        if (r9 == null) goto L21;
        this.label = 1;
        r7 = r9.c(this);
        if (r7 != r0) goto L13;
        return r0;
    L21:
        return null;
    }
}
