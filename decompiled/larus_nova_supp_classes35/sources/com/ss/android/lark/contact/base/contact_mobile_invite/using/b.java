package com.ss.android.lark.contact.base.contact_mobile_invite.using;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.ChatApplication;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UserInfo;
import com.bytedance.lark.pb.contact.v2.UserContactStatus;
import com.bytedance.lark.pb.im.v1.ProcessChatApplicationRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.contact.base.service.d;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TextView c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UserContactStatus.values().length];
            r0[UserContactStatus.CONTACT_POINT_FRIEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UserContactStatus.CONTACT_STATUS_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UserContactStatus.CONTACT_STATUS_RECEIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public b(com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b r1, int r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Enum r8 = this.a.f.b;
        if (r8 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("contactStatus");
        r8 = null;
    L6:
        int r9 = a.a[r8.ordinal()];
        if (r9 != 1) goto L9;
        com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b.c(this.a);
    L19:
        com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b r10 = this.a;
        int r0 = this.b;
        d9b.a.a = r10.e;
        d9b.a.b = r0;
        return;
    L9:
        if (r9 != 2) goto L11;
        com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b.c(this.a);
        goto L19
    L11:
        if (r9 == 3) goto L16;
        com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b r11 = this.a;
        Context r1 = this.c.getContext();
        UserInfo r12 = r11.f.a();
        ContactSource r2 = new ContactSource();
        r2.setSourceType(10);
        String r3 = r12.user_id;
        String r13 = r12.user_name;
        int r4 = com.ss.android.lark.profile.utils.a.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "contactSource");
        Log.i("ProfileJumpUtilsExport", "open add contact by router, uid: " + r3 + ", token: , chatId :null, userName: " + r13);
        snc.b r5 = new snc.b(r1, "messenger/core/profile/addfriendactivity");
        r5.b("param_key_user_id", r3);
        r5.b("param_key_user_name", r13);
        Intrinsics.checkNotNullParameter("param_key_source", "key");
        r5.a().putSerializable("param_key_source", r2);
        r5.b("param_key_chat_id", null);
        r5.b("param_key_token", BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter("param_key_is_has_tenant_certification", "key");
        r5.a().putBoolean("param_key_is_has_tenant_certification", false);
        Intrinsics.checkNotNullParameter("param_key_is_tenant_certification", "key");
        r5.a().putBoolean("param_key_is_tenant_certification", false);
        Intrinsics.checkNotNullParameter("param_key_status_certification", "key");
        r5.a().putInt("param_key_status_certification", 0);
        Intrinsics.checkNotNullParameter("request_code", "key");
        if ((-1) == null) goto L15;
        r5.c.put("request_code", -1);
    L15:
        r5.c();
        Statistics.sendEvent("addressbook_usinglark_add_click", InvHitPoint.a());
        goto L19
    L16:
        final com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b r14 = this.a;
        r14.getClass();
        int r6 = d.a;
        String r15 = r14.f.a().user_id;
        UIGetDataCallback r16 = new UIGetDataCallback(new InviteExternalContactUsingItem$InviteExternalContactUsingItemUserItem$agreeFriendRequest$1(r14));
        SdkSender.asynSendRequestNonWrap(Command.PROCESS_CHAT_APPLICATION, new ProcessChatApplicationRequest.Builder().id(r15).status(ChatApplication.Status.AGREED), r16, com.ss.android.lark.contact.base.service.b.a);
        goto L19
    }
}
