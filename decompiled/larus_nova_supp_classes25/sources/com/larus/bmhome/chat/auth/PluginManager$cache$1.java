package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class PluginManager$cache$1 extends FunctionReferenceImpl implements Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object>, SuspendFunction {
    public PluginManager$cache$1(Object r8) {
        super(5, r8, PluginAuthRepository.class, "requestPluginList", "requestPluginList(Ljava/lang/String;IILcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        return invoke((String) r7, ((Number) r8).intValue(), ((Number) r9).intValue(), (DowngradeSource) r10, (Continuation) r11);
    }

    public final Object invoke(String r8, int r9, int r10, DowngradeSource r11, Continuation<? super PluginItemData> r12) {
        return ((PluginAuthRepository) ((CallableReference) this).receiver).c(r8, r9, r10, r11, r12);
    }
}
