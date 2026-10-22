package com.larus.dora.impl.dynamic.viewholder;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.dora.impl.databinding.LarusDoraDeviceUnbindLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.s1;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DoraDeviceUnbindViewHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceUnbindLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceUnbindLayoutBinding;)V", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceUnbindViewHolder extends BaseViewHolder<d59.c> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraDeviceUnbindLayoutBinding b;

    public static final class a {
    }

    static {
    }

    public DoraDeviceUnbindViewHolder(LarusDoraDeviceUnbindLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r2, e59.b r3, d59.b r4) {
        d59.c r5 = r2;
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r3, "connectionState");
        LarusDoraDeviceUnbindLayoutBinding r6 = this.b;
        if (r6 == null) goto L12;
        d59.j r7 = r5.e;
        if ((r7 instanceof d59.n) == false) goto L13;
        AppCompatTextView r8 = r6.c;
        s1 r9 = ((d59.n) r7).b();
        if (r9 == null) goto L9;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r10 = "";
    L10:
        r8.setText(r10);
        e1.d(r6.b, new m());
        return;
    L9:
        r10 = null;
        goto L10
    L13:
        return;
    }
}
