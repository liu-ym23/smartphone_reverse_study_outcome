package com.ss.android.lark.profile_api;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.dto.ChatterDescriptionResponse$ChatterDescriptionsResponse;
import com.ss.android.lark.profile.entity.ChatterDescription;
import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.profile.v2.entity.Profile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r5b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u000245J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0014\u0010\u0014\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015H&J&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0005H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\"H&J*\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J.\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020+0\tH&J \u0010,\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010-2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH&J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/2\u0006\u00102\u001a\u000203H&¨\u00066"}, d2 = {"Lcom/ss/android/lark/profile_api/IProfileApi;", "", "fetchUserProfile", "", "userId", "", "strategy", "Lcom/ss/android/lark/profile_api/IProfileApi$STRATEGY;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/profile/v2/entity/Profile;", "contactToken", "getProfileV1Sync", "Lcom/ss/android/lark/profile/entity/Profile;", "isMedalEnabled", "", "getProfileKBPlusItem", "Lcom/ss/android/lark/chat/entity/keyboard/IPlusItem;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getProfileMessageCellFactory", "Lcom/ss/android/lark/chat/export/ui/message/IOpenMessageCellFactory;", "parseFields", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Lkotlin/collections/ArrayList;", "pbFields", "", "Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$Field;", "startContactsProfileActivityByChatterId", "chatterId", "canOpenProfileByUrl", "url", "fetchUserProfileManis", "Lcom/ss/android/lark/profile_api/IProfileApi$FetchUserProfileManisCallback;", "updateUserStatus", "description", "descriptionType", "", "fetchUserHistoryStatus", "count", "offset", "queryAll", "Lcom/ss/android/lark/profile/dto/ChatterDescriptionResponse$ChatterDescriptionsResponse;", "deleteUserStatus", "Lcom/ss/android/lark/profile/entity/ChatterDescription;", "buildProfileFragment", "Lkotlin/Pair;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/profile_api/IProfilePageController;", "bundle", "Landroid/os/Bundle;", "STRATEGY", "FetchUserProfileManisCallback", "profile-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IProfileApi {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/profile_api/IProfileApi$STRATEGY;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "FORCE_SERVER", "TRY_LOCAL", "profile-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum STRATEGY extends Enum<STRATEGY> {
        public static final STRATEGY FORCE_SERVER = null;
        public static final STRATEGY LOCAL = null;
        public static final STRATEGY TRY_LOCAL = null;
        public static final /* synthetic */ STRATEGY[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<STRATEGY> getEntries() {
            return b;
        }

        static {
            STRATEGY r0 = new STRATEGY("LOCAL", 0);
            LOCAL = r0;
            STRATEGY r1 = new STRATEGY("FORCE_SERVER", 1);
            FORCE_SERVER = r1;
            STRATEGY r3 = new STRATEGY("TRY_LOCAL", 2);
            TRY_LOCAL = r3;
            STRATEGY[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static STRATEGY[] values() {
            return (STRATEGY[]) a.clone();
        }

        public static STRATEGY valueOf(String r1) {
            return (STRATEGY) r27.a.a(STRATEGY.class, r1);
        }

        public STRATEGY(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    Pair<Fragment, r1c.a> buildProfileFragment(Bundle r1);

    boolean canOpenProfileByUrl(String r1);

    void deleteUserStatus(ChatterDescription r1, IGetDataCallback<Boolean> r2);

    void fetchUserHistoryStatus(int r1, int r2, boolean r3, IGetDataCallback<ChatterDescriptionResponse$ChatterDescriptionsResponse> r4);

    void fetchUserProfile(String r1, IGetDataCallback<Profile> r2);

    void fetchUserProfile(String r1, STRATEGY r2, IGetDataCallback<Profile> r3);

    void fetchUserProfileManis(String r1, a r2);

    d5b.a getProfileKBPlusItem(Chat r1);

    e<?, ?, ?> getProfileMessageCellFactory();

    com.ss.android.lark.profile.entity.Profile getProfileV1Sync();

    boolean isMedalEnabled();

    ArrayList<BaseField> parseFields(List<GetUserProfileResponse.Field> r1);

    void startContactsProfileActivityByChatterId(String r1);

    void updateUserStatus(String r1, int r2, IGetDataCallback<String> r3);
}
