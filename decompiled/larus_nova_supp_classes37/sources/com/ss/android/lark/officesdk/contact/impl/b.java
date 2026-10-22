package com.ss.android.lark.officesdk.contact.impl;

import android.content.Context;
import android.content.Intent;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.DoubaoAddFriendSetting;
import com.bytedance.lark.pb.settings.v1.GetDoubaoAddFriendSettingRequest;
import com.bytedance.lark.pb.settings.v1.UpdateDoubaoAddFriendSettingRequest;
import com.bytedance.lark.pb.settings.v1.WayToAddFriendItem;
import com.larus.bmhome.n0;
import com.larus.bmhome.p0;
import com.larus.setting.api.o;
import com.larus.setting.api.s;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.contact.customized.externalcontact.repository.c;
import com.ss.android.lark.contact.customized.externalcontact.repository.d;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.contact.customized.search.OfficeInviteExternalSearchActivity;
import com.ss.android.lark.contact.customized.setting.DoubaoAddFriendSettingRepository;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.f;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.e;
import mtb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class b implements ktb.a {
    @Inject
    public b() {
    }

    @Override // ktb.a
    public final void V7(o r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Lazy r1 = DoubaoAddFriendSettingRepository.a;
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("Contact_AddFriendSetting", "getSetting start");
        GetDoubaoAddFriendSettingRequest.Builder r0 = new GetDoubaoAddFriendSettingRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.GET_DOUBAO_ADD_FRIEND_SETTING, r0, new DoubaoAddFriendSettingRepository.toSdkCallback.1(r4), com.ss.android.lark.contact.customized.setting.a.a);
    }

    @Override // ktb.a
    public final void W9(n0 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Lazy r1 = NewFriendBadgeRepository.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        Log.i("Contact_NewFriendBadge", "addListener");
        f.a((CopyOnWriteArrayList) NewFriendBadgeRepository.a.getValue(), r3, c.a);
    }

    @Override // ktb.a
    public final OfficeExternalContactFragment Z7(mtb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Lazy r1 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r3, "model");
        int r0 = OfficeExternalContactFragment.r;
        return OfficeExternalContactFragment.a.a(false, r3.a, r3.b);
    }

    @Override // ktb.a
    public final void t1(ltb.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Lazy r1 = NewFriendBadgeRepository.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        Log.i("Contact_NewFriendBadge", "removeListener");
        f.b((CopyOnWriteArrayList) NewFriendBadgeRepository.a.getValue(), r3, d.a);
    }

    @Override // ktb.a
    public final void t7(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Lazy r0 = NewFriendBadgeRepository.a;
        NewFriendBadgeRepository.a(NewFriendBadgeRepository.Source.EXTERNAL_API, r2);
    }

    @Override // ktb.a
    public final void F1(Context r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        Lazy r1 = OfficeContactPageUtils.a;
        String r5 = r4.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        int r0 = OfficeMyQrCodeActivity.a;
        OfficeMyQrCodeActivity.a.a(r3, r5);
    }

    @Override // ktb.a
    public final void Gc(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Lazy r1 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = OfficeInviteExternalActivity.a;
        OfficeInviteExternalActivity.a.a(r3, r4);
    }

    @Override // ktb.a
    public final void U8(Context r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "model");
        Lazy r2 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "model");
        int r0 = OfficeInviteExternalSearchActivity.a;
        Intent r1 = new Intent(r4, OfficeInviteExternalSearchActivity.class);
        r1.putExtra("contact_db_initial_keyword", r5.a);
        r1.putExtra("from", r5.b);
        r4.startActivity(r1);
    }

    @Override // ktb.a
    public final void Ub(mtb.f r5, s r6) {
        Intrinsics.checkNotNullParameter(r5, "settingsItem");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Lazy r1 = DoubaoAddFriendSettingRepository.a;
        DoubaoAddFriendSettingType r2 = r5.a;
        boolean r3 = r5.d;
        a r4 = new a(r6, r5);
        Intrinsics.checkNotNullParameter(r2, "settingType");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("Contact_AddFriendSetting", "updateSetting start type=" + r2 + " enabled=" + r3);
        DoubaoAddFriendSetting.Builder r7 = new DoubaoAddFriendSetting.Builder();
        int r8 = DoubaoAddFriendSettingRepository.a.b[r2.ordinal()];
        if (r8 != 1) goto L5;
        int r9 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CHAT.getValue();
    L16:
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOUBAO_ADD_FRIEND_SETTING, new UpdateDoubaoAddFriendSettingRequest.Builder().setting(r7.way_to_add_friend_items(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r9), Boolean.valueOf(r3)))).build()), new DoubaoAddFriendSettingRepository.updateSetting.1(r2, r3, r4), com.ss.android.lark.contact.customized.setting.b.a);
        return;
    L5:
        if (r8 != 2) goto L7;
        r9 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN.getValue();
        goto L16
    L7:
        if (r8 != 3) goto L9;
        r9 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_NAME_CARD.getValue();
        goto L16
    L9:
        if (r8 != 4) goto L12;
        r9 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_DOCS.getValue();
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
