package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a$a, reason: collision with other inner class name */
    public static final class C0090a {
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;
        public final boolean g;

        public C0090a() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0090a) == false) goto L20;
            C0090a r4 = (C0090a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = 1;
            ?? r6 = r4;
            if (r4 == false) goto L9;
            r6 = 1;
        L9:
            int r7 = (r3 + r6) * 31;
            String r8 = this.c;
            if (r8 == null) goto L12;
            int r9 = r8.hashCode();
        L13:
            int r10 = (r7 + r9) * 31;
            String r11 = this.d;
            if (r11 == null) goto L16;
            int r13 = r11.hashCode();
        L17:
            int r14 = (r10 + r13) * 31;
            String r15 = this.e;
            if (r15 == null) goto L20;
            r1 = r15.hashCode();
        L20:
            int r16 = (r14 + r1) * 31;
            boolean r17 = this.f;
            ?? r18 = r17;
            if (r17 == false) goto L23;
            r18 = 1;
        L23:
            int r19 = (r16 + r18) * 31;
            boolean r20 = this.g;
            if (r20 == true) goto L28;
            r5 = r20;
        L28:
            return r19 + r5;
        L16:
            r13 = 0;
            goto L17
        L12:
            r9 = 0;
            goto L13
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ChatChannelTrackInfo(createType=" + this.a + ", isOwner=" + this.b + ", subCreateType=" + this.c + ", channelId=" + this.d + ", createAppId=" + this.e + ", isChannelValid=" + this.f + ", isChannelGuideShow=" + this.g + ")";
        }

        public /* synthetic */ C0090a(int r9) {
            this(BuildConfig.FLAVOR, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, true, false);
        }

        public C0090a(String r2, boolean r3, String r4, String r5, String r6, boolean r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r2, "createType");
            Intrinsics.checkNotNullParameter(r4, "subCreateType");
            Intrinsics.checkNotNullParameter(r5, "channelId");
            Intrinsics.checkNotNullParameter(r6, "createAppId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    static {
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a a(DataContext r0, DataCenter r1) {
        com.bytedance.android.livesdk.interactivity.api.h r2 = com.bytedance.android.livesdk.interactivity.api.i.a(r0, r1);
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r3 = r2.getPublicScreenAreaStateManager();
        if (r3 == null) goto L7;
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a) r3.getValue();
    L7:
        return null;
    }

    @JvmStatic
    public static final boolean b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "currentUserId");
        Intrinsics.checkNotNullParameter(r6, "toUser");
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L10;
        long r7 = r0.hasSecretChatChannel(r5, r6);
        if (r7 > 0) goto L7;
        return false;
    L7:
        if (r0.trySwitchToChannel(r7) == false) goto L12;
        u22.m r1 = new u22.m();
        r1.d = false;
        r1.m = 1;
        r1.n = r7;
        r1.l = OpenInputSource.ChatChannel;
        xs2.b.a().post(r1);
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean c(RoomContext r8, DataCenter r9) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r5 = null;
        if (PadConfigUtils.c() == false) goto L21;
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L7;
        boolean r1 = r0.isInMultiTabMode(r8);
    L8:
        if (r1 == false) goto L21;
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r3 = IRoomContextService.a.a(r2, r9, 0, 2);
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n r4 = r3.getPadOrientation();
        if (r4 == null) goto L16;
        PadOrientation r6 = (PadOrientation) r4.getValue();
    L18:
        if (r6 != PadOrientation.PORTRAIT) goto L20;
        ContainerType r7 = ContainerType.MultiTab;
    L29:
        if (r7 != ContainerType.MultiTab) goto L31;
        boolean r10 = true;
    L32:
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        if (r11 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r11, r9, 0, 2);
        if (r13 == null) goto L39;
        Boolean r14 = r13.isPortraitInteraction();
        if (r14 == null) goto L39;
        boolean r15 = r14.booleanValue();
    L40:
        if (r10 == false) goto L66;
        if (r15 == false) goto L66;
        if (r9 == null) goto L44;
        Long r16 = (Long) r9.get("multi_selected_tab_id", 0L);
    L45:
        if (r16 != null) goto L48;
    L50:
        boolean r17 = false;
    L51:
        if (r17 == false) goto L83;
        com.bytedance.android.livesdk.interactivity.api.h r18 = com.bytedance.android.livesdk.interactivity.api.i.a(r8, r9);
        if (r18 == null) goto L57;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r19 = r18.getMultiChatTabAreaStateManager();
        if (r19 == null) goto L57;
        r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a) r19.getValue();
    L57:
        if (r5 == null) goto L63;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r20 = r5.getState();
        if (r20 == null) goto L63;
        com.bytedance.android.livesdk.interactivity.api.base.d r21 = (com.bytedance.android.livesdk.interactivity.api.base.d) r20.getValue();
        if (r21 == null) goto L63;
        boolean r23 = b.a(r21);
    L64:
        if (r23 == false) goto L84;
        return true;
    L84:
        return false;
    L63:
        r23 = false;
        goto L64
    L83:
        return false;
    L48:
        if (r16.longValue() != 10) goto L50;
        r17 = true;
        goto L51
    L44:
        r16 = null;
    L66:
        if (r10 == true) goto L75;
        if (r15 == false) goto L75;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r24 = a(r8, r9);
        if (r24 == null) goto L86;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r25 = r24.getState();
        if (r25 == null) goto L87;
        com.bytedance.android.livesdk.interactivity.api.base.d r26 = (com.bytedance.android.livesdk.interactivity.api.base.d) r25.getValue();
        if (r26 != null) goto L89;
        return false;
    L89:
        return b.a(r26);
    L87:
        return false;
    L86:
        return false;
    L75:
        com.bytedance.android.livesdk.interactivity.api.h r27 = com.bytedance.android.livesdk.interactivity.api.i.a(r8, r9);
        if (r27 == null) goto L78;
        r5 = r27.getChatChannelLandscapeDialogState();
    L78:
        if (r5 == null) goto L90;
        Boolean r28 = (Boolean) r5.getValue();
        if (r28 != null) goto L82;
        return false;
    L82:
        return r28.booleanValue();
    L90:
        return false;
    L39:
        r15 = true;
        goto L40
    L31:
        r10 = false;
        goto L32
    L20:
        r7 = ContainerType.PublicScreen;
    L16:
        r6 = null;
        goto L18
    L7:
        r1 = false;
    L21:
        IInteractivityInjectService r29 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r29 == null) goto L24;
        boolean r30 = r29.isInMultiTabMode(r8);
    L25:
        if (r30 == false) goto L27;
        r7 = ContainerType.MultiTab;
        goto L29
    L27:
        r7 = ContainerType.PublicScreen;
        goto L29
    L24:
        r30 = false;
        goto L25
    }

    public static void d(IBaseUser r3, OpenInputSource r4, Long r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "source");
        xs2.b r0 = xs2.b.a();
        u22.m r1 = new u22.m(0, false, r4);
        r1.j = r3;
        if (r5 == null) goto L5;
        r1.k = r5.longValue();
    L5:
        r1.h = r6;
        Unit r7 = Unit.INSTANCE;
        r0.post(r1);
    }
}
