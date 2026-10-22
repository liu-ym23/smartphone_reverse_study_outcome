package com.ss.android.lark.passport_user.ipc;

import com.ss.android.lark.manis.annotation.RemoteService;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.base.view.ItemViewType;
import ee.android.framework.manis.interfaces.IHookInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@RemoteService
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/passport_user/ipc/IUserListStorageServiceByIPC;", "Lee/android/framework/manis/interfaces/IHookInterface;", "users", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "getUsers", "()Ljava/util/List;", "foregroundUser", "getForegroundUser", "()Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "lark-user_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IUserListStorageServiceByIPC extends IHookInterface {
    User getForegroundUser();

    List<User> getUsers();
}
