package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "switch", "", "<anonymous parameter 1>", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECReplaySettingItem$publishActionEC$1 extends Lambda implements Function3<Boolean, Boolean, Context, Unit> {
    final /* synthetic */ j this$0;

    public ECReplaySettingItem$publishActionEC$1(j r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(final boolean r8, boolean r9, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(r10);
        if (r0 == null) goto L10;
        int r11 = a0.a;
        Room r12 = this.this$0.m;
        if (r12 == null) goto L7;
        long r13 = r12.id;
    L8:
        a0.c(r0, 1, r8, r13, new ECReplaySettingItem$publishActionEC$1$$special$$inlined$let$lambda$1(this, r8), ECReplaySettingItem$publishActionEC$1$1$2.INSTANCE);
        return;
    L7:
        r13 = 0;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), ((Boolean) r2).booleanValue(), (Context) r3);
        return Unit.INSTANCE;
    }
}
