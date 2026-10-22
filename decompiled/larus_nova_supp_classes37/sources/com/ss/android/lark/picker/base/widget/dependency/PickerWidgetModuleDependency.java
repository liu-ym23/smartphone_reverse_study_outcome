package com.ss.android.lark.picker.base.widget.dependency;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.Department;
import com.ss.android.lark.contact.export.EmailContact;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.business.ContactsSelectorBusiness;
import com.ss.android.lark.picker.base.widget.params.PickType;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import z3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R)\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency;", "", "<init>", "()V", "dependency", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency;", "kotlin.jvm.PlatformType", "getDependency$annotations", "getDependency", "()Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency;", "dependency$delegate", "Lkotlin/Lazy;", "onServerResultEmpty", "", "searchKey", "", "onServerErr", "onLocalBackupErr", "IPickerWidgetModuleDependency", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerWidgetModuleDependency {
    public static final PickerWidgetModuleDependency INSTANCE = null;
    private static final Lazy dependency$delegate = null;

    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\b01234567J\b\u0010\u0002\u001a\u00020\u0003H&J:\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H&J\n\u0010)\u001a\u0004\u0018\u00010\bH&J\n\u0010*\u001a\u0004\u0018\u00010+H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020/H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u00068"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency;", "", "getSearchLifecycleObserver", "Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "isCustomer", "", "()Z", "tenantID", "", "getTenantID", "()Ljava/lang/String;", "loadImage", "", "context", "Landroid/content/Context;", "avatarKey", "id", "imageView", "Landroid/widget/ImageView;", "imageWidth", "", "imageHeight", "getChatsByIds", "", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "chatIds", "", "getContactHomeController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactHomeController;", "getEmailContactController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IEmailContactController;", "getContactsSelectorController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "getDepartmentDetailController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController;", "goContactsGroupActivity", "activity", "Landroid/app/Activity;", "isInZenMode", "time", "", "getSelfId", "getContactsOwnerGroupController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsOwnerGroupController;", "getCalendarController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$ICalendarController;", "getUserGroupController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController;", "IContactHomeController", "IEmailContactController", "IContactsSelectorController", "IDepartmentDetailController", "IContactsOwnerGroupController", "ICalendarController", "IUserGroupController", "IItemCustomizer", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IPickerWidgetModuleDependency {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$ICalendarController;", "", "isSupportMultiTimeZone", "", "()Z", "isValidEmail", "emailStr", "", "splitEmail", "", "hitPointEmailAttendeeEnter", "", "hitPointEmailAttendeeInvite", "isValidPhone", "phoneStr", "splitPhone", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface ICalendarController {
            void hitPointEmailAttendeeEnter();

            void hitPointEmailAttendeeInvite();

            boolean isSupportMultiTimeZone();

            boolean isValidEmail(String r1);

            boolean isValidPhone(String r1);

            List<String> splitEmail(String r1);

            List<String> splitPhone(String r1);
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0017J(\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u000bH&J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0004H&¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactHomeController;", "", "init", "hideAllHeader", "", "showSelect", "hideContacts", "selectedListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactHomeController$IOnItemSelectedListener;", "isMultiSelect", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "updateSelectedView", "", "values", "", "", "updateContainsView", "", "setOnItemSelectedListener", "onItemSelectedListener", "switchMultiple", "isMultiple", "IOnItemSelectedListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IContactHomeController {

            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactHomeController$IOnItemSelectedListener;", "", "onItemSelected", "", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "isSelected", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnItemSelectedListener {
                void onItemSelected(Chatter r1, boolean r2);
            }

            BaseFragment asFragment();

            IContactHomeController init(boolean r1, boolean r2, boolean r3, IOnItemSelectedListener r4);

            IContactHomeController init(boolean r1, boolean r2, boolean r3, boolean r4);

            void setOnItemSelectedListener(IOnItemSelectedListener r1);

            void switchMultiple(boolean r1);

            void updateContainsView(Collection<String> r1);

            void updateSelectedView(List<String> r1);
        }

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ\"\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0016\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004H&¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsOwnerGroupController;", "", "init", "multiSelectMode", "", "pickType", "Lcom/ss/android/lark/picker/base/widget/params/PickType;", "extras", "Landroid/os/Bundle;", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "setGroupOperationListener", "listener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsOwnerGroupController$IOnOperationListener;", "setSelectChatIds", "", "chaIds", "", "", "setContainedChatId", "setPickType", "setItemCustomizer", "itemCustomizer", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IItemCustomizer;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "setEnableChatPreview", "isEnableChatPreview", "IOnOperationListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IContactsOwnerGroupController {

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsOwnerGroupController$IOnOperationListener;", "", "onContactsGroupSelect", "", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "isSelected", "position", "", "onFinish", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnOperationListener {
                boolean onContactsGroupSelect(Chat r1, boolean r2, int r3);

                void onFinish();
            }

            BaseFragment asFragment();

            IContactsOwnerGroupController init(boolean r1, PickType r2, Bundle r3);

            void setContainedChatId(List<String> r1);

            IContactsOwnerGroupController setEnableChatPreview(boolean r1);

            IContactsOwnerGroupController setGroupOperationListener(IOnOperationListener r1);

            void setItemCustomizer(IItemCustomizer<Chat> r1);

            void setPickType(PickType r1);

            void setSelectChatIds(List<String> r1);
        }

        @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u000267J\u00ad\u0001\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH&¢\u0006\u0002\u0010\u001fJZ\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH&J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\bH&J\u0018\u0010&\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\bH&J\b\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0017H&J\u0010\u0010,\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0019H&J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\bH&J\u0010\u00102\u001a\u00020!2\u0006\u00101\u001a\u00020\bH&J\u0018\u00103\u001a\u00020!2\u0006\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\bH&¨\u00068"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "", "init", "pickerInitTime", "", "pickerTracker", "Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "newContactsVisible", "", "mineGroupVisible", "ownerGroupVisible", "botVisible", "onCallVisible", "externalContactsVisible", "depVisible", "trustPartyVisible", "emailContactVisible", "emailSharedAccountVisible", "userGroupScene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "mineGroupLabel", "", "onClickListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnClickListener;", "onViewDataListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnViewDataListener;", "relatedContactsInfoList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "(Ljava/lang/Long;Lcom/ss/android/lark/picker/base/statistics/PickerTracker;ZZZZZZZZZZLcom/ss/android/lark/search/dto/UserGroupScene;Ljava/lang/String;Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnClickListener;Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnViewDataListener;Ljava/util/List;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "switchMultiple", "", "isMultiple", "onSelected", "id", "selected", "onDeSelected", "deSelected", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "setOnEntranceClickListener", "listener", "setOnViewDataReadyListener", "setContactsSelectorBusiness", "contactsSelectorBusiness", "Lcom/ss/android/lark/picker/base/widget/business/ContactsSelectorBusiness;", "changeExternalContactVisibility", "isVisible", "changeEmailContactVisibility", "changeSectionVisibility", "mask", "", "IOnClickListener", "IOnViewDataListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IContactsSelectorController {

            @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public static final class DefaultImpls {
                public static /* synthetic */ IContactsSelectorController init$default(IContactsSelectorController r21, Long r22, PickerTracker r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, UserGroupScene r34, String r35, IOnClickListener r36, IOnViewDataListener r37, List r38, g r39, int r40, Object r41) {
                    if (r41 != null) goto L14;
                    if ((r40 & 1) == 0) goto L6;
                    Long r3 = null;
                L8:
                    if ((r40 & 2) == 0) goto L10;
                    PickerTracker r4 = null;
                L12:
                    return r21.init(r3, r4, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
                L10:
                    r4 = r23;
                    goto L12
                L6:
                    r3 = r22;
                    goto L8
                L14:
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
                }
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnClickListener;", "", "onNewContactClick", "", "onMineGroupClick", "onRobotClick", "onOnCallClick", "onExternalContactClick", "onEmailContactClick", "onMailSharedAccountClick", "onSubordinateItemClick", "id", "", "onOwnerGroupClick", "onTrustPartyItemClick", "onUserGroupItemClick", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnClickListener {
                void onEmailContactClick();

                void onExternalContactClick();

                void onMailSharedAccountClick();

                void onMineGroupClick();

                void onNewContactClick();

                void onOnCallClick();

                void onOwnerGroupClick();

                void onRobotClick();

                void onSubordinateItemClick(String r1);

                void onTrustPartyItemClick();

                void onUserGroupItemClick();
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController$IOnViewDataListener;", "", "onReady", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnViewDataListener {
                void onReady();
            }

            BaseFragment asFragment();

            void changeEmailContactVisibility(boolean r1);

            void changeExternalContactVisibility(boolean r1);

            void changeSectionVisibility(int r1, boolean r2);

            IContactsSelectorController init(Long r1, PickerTracker r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, UserGroupScene r13, String r14, IOnClickListener r15, IOnViewDataListener r16, List<? extends SearchBaseInfo> r17, g r18);

            IContactsSelectorController init(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, UserGroupScene r9, String r10);

            void onDeSelected(String r1, boolean r2);

            void onSelected(String r1, boolean r2);

            void setContactsSelectorBusiness(ContactsSelectorBusiness r1);

            void setOnEntranceClickListener(IOnClickListener r1);

            void setOnViewDataReadyListener(IOnViewDataListener r1);

            void switchMultiple(boolean r1);
        }

        @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001;J\u0083\u0001\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H&J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001cH&J\u001c\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\"\u001a\u00020\u001cH&J\u0016\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\rH&J\u0016\u0010%\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\rH&J\u0016\u0010&\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\rH&J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0004H&J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004H&J\n\u0010+\u001a\u0004\u0018\u00010,H&J\b\u0010-\u001a\u00020\u001aH&J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH&J.\u0010/\u001a\u00020\u001a2$\u00100\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\r\u0012\u0004\u0012\u00020\u001c0201H&J\u0016\u00105\u001a\u00020\u001a2\f\u00106\u001a\b\u0012\u0004\u0012\u00020,01H&J\u0010\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0004H&J\b\u00109\u001a\u00020\u001aH&J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006<"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController;", "", "init", "isSelectMode", "", "isShowUserStatus", "pickType", "Lcom/ss/android/lark/picker/base/widget/params/PickType;", "listener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController$IOnOperationListener;", "isCheckPermission", "isCheckSelectPermission", "permissions", "", "Lcom/bytedance/lark/pb/basic/v1/ActionType;", "isShowContact", "isIgnoreLoginUser", "needEnterpriseEmail", "needPullEnterpriseEmailData", "isEnableChatPreview", "extras", "Landroid/os/Bundle;", "(ZZLcom/ss/android/lark/picker/base/widget/params/PickType;Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController$IOnOperationListener;ZZLjava/util/List;ZZLjava/lang/Boolean;Ljava/lang/Boolean;ZLandroid/os/Bundle;)Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController;", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "setTargetDepartmentId", "", "id", "", "hasEnterpriseEmail", "setTargetMailGroupRole", "mailGroupRole", "", "mailGroupId", "chatId", "setSelectedChatters", "chatterIds", "setContainedChatters", "setSelectedDepartment", "departmentIds", "setDisableOutChatter", "disabled", "setEnableChatPreview", "getCurDepartment", "Lcom/ss/android/lark/contact/export/Department;", "backToPreviousDepartment", "setOrganizationListener", "setPersonItemCustomizer", "personItemCustomizer", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IItemCustomizer;", "Lkotlin/Triple;", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "Lcom/bytedance/lark/pb/basic/v1/DeniedReason;", "setDepartmentItemCustomizer", "departmentIItemCustomizer", "switchMultiple", "isMultiple", "refreshCurrentDepartment", "setPickType", "IOnOperationListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IDepartmentDetailController {

            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J2\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&J4\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\bH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\bH&¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController$IOnOperationListener;", "", "onTitleChange", "", "newTitle", "", "onTitleSecLeftVisibleChange", "visible", "", "onFinish", "onContactsChatterClick", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "deniedReason", "", "position", "enterpriseEmail", "onContactsChatterSelect", "isSelected", "onContactsDepartmentSelect", "departmentId", "departmentName", "memberCount", "onBreadcrumbsItemClick", "isCollaboration", "onClickNextDepartmentLevel", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnOperationListener {
                void onBreadcrumbsItemClick(boolean r1);

                void onClickNextDepartmentLevel(boolean r1);

                void onContactsChatterClick(Chatter r1, int r2, int r3, String r4);

                boolean onContactsChatterSelect(Chatter r1, boolean r2, int r3, String r4, int r5);

                boolean onContactsDepartmentSelect(String r1, String r2, int r3, boolean r4, int r5);

                void onFinish();

                void onTitleChange(String r1);

                void onTitleSecLeftVisibleChange(boolean r1);
            }

            BaseFragment asFragment();

            void backToPreviousDepartment();

            Department getCurDepartment();

            IDepartmentDetailController init(boolean r1, boolean r2, PickType r3, IOnOperationListener r4, boolean r5, boolean r6, List<? extends ActionType> r7, boolean r8, boolean r9, Boolean r10, Boolean r11, boolean r12, Bundle r13);

            void needEnterpriseEmail(boolean r1);

            void refreshCurrentDepartment();

            void setContainedChatters(List<String> r1);

            void setDepartmentItemCustomizer(IItemCustomizer<Department> r1);

            void setDisableOutChatter(boolean r1);

            IDepartmentDetailController setEnableChatPreview(boolean r1);

            void setOrganizationListener(IOnOperationListener r1);

            void setPersonItemCustomizer(IItemCustomizer<Triple<Chatter, List<DeniedReason>, String>> r1);

            void setPickType(PickType r1);

            void setSelectedChatters(List<String> r1);

            void setSelectedDepartment(List<String> r1);

            void setTargetDepartmentId(String r1);

            void setTargetDepartmentId(String r1, String r2);

            void setTargetMailGroupRole(int r1, String r2);

            void switchMultiple(boolean r1);
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ0\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u0016\u0010\u0012\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H&J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\nH&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H&¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IEmailContactController;", "", "init", "hideAllHeader", "", "showSelect", "mIsMultiSelect", "pickType", "Lcom/ss/android/lark/picker/base/widget/params/PickType;", "selectedListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IEmailContactController$IOnItemSelectedListener;", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "updateSelectedView", "", "values", "", "", "updateContainsView", "", "setTargetMailGroupRole", "mailGroupRole", "", "mailGroupId", "setOnItemSelectedListener", "onItemSelectedListener", "switchMultiple", "isMultiple", "IOnItemSelectedListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IEmailContactController {

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IEmailContactController$IOnItemSelectedListener;", "", "onItemSelected", "", "contact", "Lcom/ss/android/lark/contact/export/EmailContact;", "isSelected", "position", "", "onFinish", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnItemSelectedListener {
                void onFinish();

                boolean onItemSelected(EmailContact r1, boolean r2, int r3);
            }

            BaseFragment asFragment();

            IEmailContactController init(boolean r1, boolean r2, boolean r3, PickType r4, IOnItemSelectedListener r5);

            void setOnItemSelectedListener(IOnItemSelectedListener r1);

            void setTargetMailGroupRole(int r1, String r2);

            void switchMultiple(boolean r1);

            void updateContainsView(Collection<String> r1);

            void updateSelectedView(List<String> r1);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IItemCustomizer;", "T", "", AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION, "", "getVersion", "()I", "selectable", "", "item", "(Ljava/lang/Object;)Z", "onItemClick", "data", "onBindItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "(Ljava/lang/Object;)Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IItemCustomizer<T> {
            int getVersion();

            SearchResultView.CheckBoxBindStatus onBindItem(T r1);

            boolean onItemClick(T r1);

            boolean selectable(T r1);
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u001a\u001bJ(\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0006H&¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController;", "", "init", "groupScene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "showSelect", "", "mIsMultiSelect", "selectedListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController$IOnItemSelectedListener;", "asFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "setUserGroupScene", "", "scene", "setSelectedUserGroup", "groupIds", "", "", "setOnItemSelectedListener", "onItemSelectedListener", "setOnOperationListener", "onOperationListener", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController$UserGroupOnOperationListener;", "switchMultiple", "isMultiple", "UserGroupOnOperationListener", "IOnItemSelectedListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface IUserGroupController {

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController$IOnItemSelectedListener;", "", "onItemSelected", "", "groupId", "", "groupName", "groupType", "", "isSelected", "position", "onItemClick", "", "onFinish", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface IOnItemSelectedListener {
                void onFinish();

                void onItemClick(String r1, String r2, int r3, int r4);

                boolean onItemSelected(String r1, String r2, int r3, boolean r4, int r5);
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController$UserGroupOnOperationListener;", "", "onBreadcrumbsItemClick", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
            public interface UserGroupOnOperationListener {
                void onBreadcrumbsItemClick();
            }

            BaseFragment asFragment();

            IUserGroupController init(UserGroupScene r1, boolean r2, boolean r3, IOnItemSelectedListener r4);

            void setOnItemSelectedListener(IOnItemSelectedListener r1);

            void setOnOperationListener(UserGroupOnOperationListener r1);

            void setSelectedUserGroup(List<String> r1);

            void setUserGroupScene(UserGroupScene r1);

            void switchMultiple(boolean r1);
        }

        ICalendarController getCalendarController();

        Map<String, Chat> getChatsByIds(List<String> r1);

        IContactHomeController getContactHomeController();

        IContactsOwnerGroupController getContactsOwnerGroupController();

        IContactsSelectorController getContactsSelectorController();

        IDepartmentDetailController getDepartmentDetailController();

        IEmailContactController getEmailContactController();

        a getSearchLifecycleObserver();

        String getSelfId();

        String getTenantID();

        IUserGroupController getUserGroupController();

        void goContactsGroupActivity(Activity r1);

        boolean isCustomer();

        boolean isInZenMode(long r1);

        void loadImage(Context r1, String r2, String r3, ImageView r4, int r5, int r6);
    }

    private PickerWidgetModuleDependency() {
    }

    @JvmStatic
    public static /* synthetic */ void getDependency$annotations() {
    }

    @JvmStatic
    public static final void onLocalBackupErr(String r1) {
        Intrinsics.checkNotNullParameter(r1, "searchKey");
    }

    @JvmStatic
    public static final void onServerErr(String r1) {
        Intrinsics.checkNotNullParameter(r1, "searchKey");
    }

    @JvmStatic
    public static final void onServerResultEmpty(String r1) {
        Intrinsics.checkNotNullParameter(r1, "searchKey");
    }

    static {
        INSTANCE = new PickerWidgetModuleDependency();
        dependency$delegate = LazyKt.lazy(PickerWidgetModuleDependency$dependency$2.INSTANCE);
    }

    public static final IPickerWidgetModuleDependency getDependency() {
        return (IPickerWidgetModuleDependency) dependency$delegate.getValue();
    }
}
