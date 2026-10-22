package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface z {
    void a(String r1, OfficeProfileModel.acceptFriend.2.1 r2);

    void b(String r1, String r2, String r3, ContactSource r4, OfficeProfileModel.applyFriend.2.1 r5);

    void c(String r1, OfficeProfileModel.deleteFriend.2.1 r2);

    void d(List r1, OfficeProfileModel.updateChatApplicationMeRead.2.1 r2);

    void e(String r1, boolean r2, OfficeProfileModel.blockUser.2.1 r3);

    void f(long r1, GetMyGroupChatsRequest.Type r3, OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1 r4);

    void g(long r1, IGetDataCallback r3);

    void h(long r1, IGetDataCallback r3);

    void i(IGetDataCallback r1);
}
