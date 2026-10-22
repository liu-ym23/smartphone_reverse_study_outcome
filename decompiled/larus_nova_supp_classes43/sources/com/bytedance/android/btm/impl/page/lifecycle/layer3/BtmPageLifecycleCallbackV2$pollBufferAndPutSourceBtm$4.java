package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.model.Flag;
import com.bytedance.android.btm.impl.page.model.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$4 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef $bufferBtm;
    final /* synthetic */ boolean $shouldPollBuffer;

    public BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$4(boolean r1, Ref.ObjectRef r10) {
        this.$shouldPollBuffer = r1;
        this.$bufferBtm = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m853invoke() {
        StringBuilder r0 = new StringBuilder("shouldPollBuffer=");
        r0.append(this.$shouldPollBuffer);
        r0.append(", pausedInfo.flag=");
        boolean r1 = BtmPageLifecycleCallbackV2.a;
        i r10 = BtmPageLifecycleCallbackV2.h;
        if (r10 == null) goto L5;
        Flag r11 = r10.c;
    L6:
        r0.append(r11);
        r0.append(", bufferBtm=");
        r0.append((BufferBtm) this.$bufferBtm.element);
        return r0.toString();
    L5:
        r11 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m853invoke();
    }
}
