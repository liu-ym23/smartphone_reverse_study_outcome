package com.bytedance.android.anya;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "Lcom/bytedance/android/anya/MVIState;", "STATE", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke", "(ILcom/bytedance/android/anya/MVIState;)Z"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class ReadWriteStateContext$getAndModifyEachIndexed$1 extends Lambda implements Function2 {
    public static final ReadWriteStateContext$getAndModifyEachIndexed$1 INSTANCE = null;

    static {
        INSTANCE = new ReadWriteStateContext$getAndModifyEachIndexed$1();
    }

    public ReadWriteStateContext$getAndModifyEachIndexed$1() {
        super(2);
    }

    public final boolean invoke(int r1, MVIState r10) {
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return Boolean.valueOf(invoke(((Number) r1).intValue(), (MVIState) r10));
    }
}
