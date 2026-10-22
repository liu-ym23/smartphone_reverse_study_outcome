package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V", "com/bytedance/android/livesdk/chatroom/ui/setting/PrivilegeSettingItem$1$1$1"}, k = 3, mv = {1, 4, 3})
final class PrivilegeSettingItem$1$$special$$inlined$let$lambda$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Context $context$inlined;

    public PrivilegeSettingItem$1$$special$$inlined$let$lambda$1(Context r1) {
        this.$context$inlined = r1;
        super(1);
    }

    public final void invoke(Boolean r3) {
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L8;
        IBroadcastService r4 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        Activity r0 = s2.a(this.$context$inlined);
        if ((r0 instanceof FragmentActivity) == true) goto L7;
        r0 = null;
    L7:
        r4.openPrivilegeDetailSettingDialog((FragmentActivity) r0);
        return;
    L8:
        f2.c("请在开播时打开特权弹幕开关", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Boolean) r1);
        return Unit.INSTANCE;
    }
}
