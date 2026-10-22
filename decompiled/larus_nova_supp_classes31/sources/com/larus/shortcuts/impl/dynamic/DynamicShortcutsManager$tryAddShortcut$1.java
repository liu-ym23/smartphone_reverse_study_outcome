package com.larus.shortcuts.impl.dynamic;

import android.content.pm.ShortcutInfo;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.dynamic.DynamicShortcutsManager$tryAddShortcut$1", f = "DynamicShortcutsManager.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
final class DynamicShortcutsManager$tryAddShortcut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<tw9.a> $shortcutInfoList;
    int label;

    public DynamicShortcutsManager$tryAddShortcut$1(List<tw9.a> r1, Continuation<? super DynamicShortcutsManager$tryAddShortcut$1> r2) {
        this.$shortcutInfoList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DynamicShortcutsManager$tryAddShortcut$1(this.$shortcutInfoList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        ArrayList r6 = new ArrayList();
        Iterator<T> r2 = this.$shortcutInfoList.iterator();
    L13:
        if (r2.hasNext() == false) goto L17;
        ShortcutInfo r3 = DynamicShortcutsManager.b((tw9.a) r2.next());
        if (r3 == null) goto L13;
        r6.add(r3);
        goto L13
    L17:
        DynamicShortcutsManager.c(r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FLogger.a.i("DynamicShortcutsManager", "download image");
        int r7 = ShortcutCommonUtil.a;
        List<tw9.a> r8 = this.$shortcutInfoList;
        this.label = 1;
        if (ShortcutCommonUtil.d(r8, this) != r0) goto L11;
        return r0;
    }
}
