package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.content.Context;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.CompositeImagePreviewDialog;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "path", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class LikeEggManager$launchImagePicker$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a $msg;
    final /* synthetic */ int $templateIndex;
    final /* synthetic */ c this$0;

    public LikeEggManager$launchImagePicker$1(c r1, Function0 r2, int r3, com.bytedance.android.livesdk.chatroom.likeegg.a r4, Context r5) {
        this.this$0 = r1;
        this.$dismissAction = r2;
        this.$templateIndex = r3;
        this.$msg = r4;
        this.$context = r5;
        super(1);
    }

    public final void invoke(String r8) {
        Intrinsics.checkNotNullParameter(r8, "path");
        CompositeImagePreviewDialog r0 = this.this$0.b;
        if (r0 == null) goto L5;
        r0.Z0();
    L5:
        this.$dismissAction.invoke();
        ALogger.d("LikeEggManager", "photo picked with template " + this.$templateIndex);
        int r1 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_album_select", new LinkedHashMap());
        com.bytedance.android.livesdk.chatroom.likeegg.a.b r2 = this.$msg.jumpDetail;
        Boolean r3 = null;
        if (r2 == null) goto L12;
        n r4 = r2.templatePhotoJumpDetail;
        if (r4 == null) goto L12;
        List r5 = r4.a();
        if (r5 == null) goto L12;
        n.a r6 = (n.a) CollectionsKt.getOrNull(r5, this.$templateIndex);
    L13:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        u r9 = r.u(this.this$0.e, null, 2);
        if (r9 == null) goto L18;
        User r10 = r9.o();
        if (r10 == null) goto L18;
        String r11 = r10.getNickName();
    L19:
        if (r6 == null) goto L21;
        String r13 = r6.replaceContent;
    L22:
        if (r6 == null) goto L25;
        r3 = r6.supportReplace;
    L25:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L38;
        if (r13 == null) goto L38;
        boolean r14 = false;
        if (r13.length() <= 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 != true) goto L38;
        if (r11 == null) goto L38;
        if (r11.length() <= 0) goto L36;
        r14 = true;
    L36:
        if (r14 != true) goto L38;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(r13, r11);
        Unit r17 = Unit.INSTANCE;
        r7.element = r16;
        goto L38
    L30:
        r15 = false;
    L38:
        if (r6 == null) goto L41;
        String r18 = r6.templateId;
        if (r18 == null) goto L41;
    L42:
        LikeEggManager$launchImagePicker$1$retryAction$1 r19 = new LikeEggManager$launchImagePicker$1$retryAction$1(this, r18, r8, r7);
        CompositeImagePreviewDialog r20 = this.this$0.b;
        if (r20 == null) goto L45;
        Function1<String, Unit> r21 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r21, "confirmAction");
        r20.B = r21;
    L45:
        CompositeImagePreviewDialog r23 = this.this$0.b;
        if (r23 == null) goto L48;
        Function0<Unit> r24 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r24, "cancelAction");
        r23.C = r24;
    L48:
        CompositeImagePreviewDialog r25 = this.this$0.b;
        if (r25 == null) goto L51;
        Intrinsics.checkNotNullParameter(r19, "retryAction");
        r25.D = r19;
    L51:
        r19.invoke();
        return;
    L41:
        r18 = BuildConfig.FLAVOR;
        goto L42
    L21:
        r13 = null;
    L18:
        r11 = null;
    L12:
        r6 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
