package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.CompositeImagePreviewDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker.LikeEggImagePickerDialog;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "templateIndex", BuildConfig.FLAVOR, "dismissAction", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LikeEggManager$launchTemplatePreviewDialog$2 extends Lambda implements Function2<Integer, Function0<? extends Unit>, Unit> {
    final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a $msg;
    final /* synthetic */ c this$0;

    public LikeEggManager$launchTemplatePreviewDialog$2(c r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2);
    }

    public final void invoke(int r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "dismissAction");
        ALogger.d("LikeEggManager", "launch photo picker with template " + r10);
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.chatroom.likeegg.a r1 = this.$msg;
        Intrinsics.checkNotNullParameter(r1, "msg");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_defined_click", r.k().a(r1, r10, BuildConfig.FLAVOR));
        final c r2 = this.this$0;
        com.bytedance.android.livesdk.chatroom.likeegg.a r6 = this.$msg;
        int r3 = c.f;
        r2.getClass();
        Context r4 = com.bytedance.android.live.core.utils.a.d();
        if (r4 != null) goto L6;
        r4 = r2.d.getContext();
    L6:
        CompositeImagePreviewDialog r5 = r2.b;
        if (r5 == null) goto L9;
        r5.dismissDialog();
    L9:
        int r7 = CompositeImagePreviewDialog.L0;
        r2.b = CompositeImagePreviewDialog.a.a(r4, r6, r2.e);
        int r8 = LikeEggImagePickerDialog.o;
        LikeEggImagePickerDialog.Companion.a(r4, new LikeEggManager$launchImagePicker$1(r2, r11, r10, r6, r4), new LikeEggManager$launchImagePicker$2(r2), r2.e);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), (Function0) r2);
        return Unit.INSTANCE;
    }
}
