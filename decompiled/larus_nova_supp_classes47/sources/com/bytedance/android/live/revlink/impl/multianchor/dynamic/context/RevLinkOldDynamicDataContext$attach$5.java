package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkOldDynamicDataContext$attach$5 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public RevLinkOldDynamicDataContext$attach$5(k0 r8) {
        super(1, r8, k0.class, "onMultiLastShowResultChange", "onMultiLastShowResultChange(Ljava/lang/Boolean;)V", 0);
    }

    public final void invoke(Boolean r4) {
        k0 r0 = (k0) ((CallableReference) this).receiver;
        r0.getClass();
        if (r4 == null) goto L13;
        r4.booleanValue();
        if (((Number) r0.y.invoke()).intValue() == 1) goto L14;
        MutableLiveData<String> r1 = r0.k;
        if (r4.booleanValue() == false) goto L10;
        String r5 = DataType.TRUE;
    L11:
        r1.setValue(r5);
        return;
    L10:
        r5 = DataType.FALSE;
        goto L11
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Boolean) r1);
        return Unit.INSTANCE;
    }
}
