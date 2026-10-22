package com.ss.android.lark.picker.scenario;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.settings.PullUserEmployeeTypeEnumRequest;
import com.ss.android.lark.pb.settings.PullUserPermissionGroupRequest;
import com.ss.android.lark.pb.settings.UserEmployeeType;
import com.ss.android.lark.pb.settings.UserPermissionGroup;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import com.ss.android.lark.search.dto.info.SearchPersonnelTypeInfo;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u001a\u0010\r\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\nJ\u000e\u0010\u000f\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/scenario/ScenarioDataPuller;", "", "<init>", "()V", "TAG", "", "NAME_KEY_EN_US", "loadPersonnelTypes", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchPersonnelTypeInfo;", "loadPermissionGroups", "Lcom/ss/android/lark/search/dto/info/SearchPermissionGroupInfo;", "toSearchInfo", "Lcom/ss/android/lark/pb/settings/UserEmployeeType;", "Lcom/ss/android/lark/pb/settings/UserPermissionGroup;", "resolveI18nName", "i18nNames", "", "defaultName", "getCurrentLanguageKey", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ScenarioDataPuller {
    public static final ScenarioDataPuller INSTANCE = null;
    private static final String NAME_KEY_EN_US = "en_us";
    private static final String TAG = "ScenarioDataPuller";

    static {
        INSTANCE = new ScenarioDataPuller();
    }

    private ScenarioDataPuller() {
    }

    private final String getCurrentLanguageKey() {
        Locale r0 = PickerBaseModuleDependency.getDependency().getCachedLanguageSetting();
        if (r0 != null) goto L6;
        r0 = Locale.getDefault();
    L6:
        return (r0.getLanguage() + '_' + r0.getCountry()).toLowerCase(Locale.ENGLISH);
    }

    private final SearchPermissionGroupInfo toSearchInfo(UserPermissionGroup r4) {
        Long r0 = r4.mgroup_id;
        if (r0 == null) goto L22;
        String r1 = r0.toString();
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L25;
        String r5 = r4.mgroup_name;
        if (r5 != null) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r5)) == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L26;
        SearchPermissionGroupInfo r2 = new SearchPermissionGroupInfo();
        r2.setId(r1);
        r2.setTitle(r5);
        return r2;
    L26:
        return null;
    L25:
        return null;
    L22:
        return null;
    }

    public final void loadPermissionGroups(final IGetDataCallback<List<SearchPermissionGroupInfo>> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        SdkSender.sendPassThroughRequest(Command.PULL_USER_PERMISSION_GROUPS, new PullUserPermissionGroupRequest.Builder(), new AnonymousClass1(r4), AnonymousClass2.INSTANCE);
    }

    public final void loadPersonnelTypes(final IGetDataCallback<List<SearchPersonnelTypeInfo>> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        SdkSender.sendPassThroughRequest(Command.PULL_USER_EMPLOYEE_TYPE_ENUM, new PullUserEmployeeTypeEnumRequest.Builder(), new C03761(r4), C03772.INSTANCE);
    }

    private final SearchPersonnelTypeInfo toSearchInfo(UserEmployeeType r4) {
        String r0 = r4.memployee_type_id;
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L19;
        String r5 = resolveI18nName(r4.memployee_type_i18n_name, r4.memployee_type_name);
        if ((!StringsKt.isBlank(r5)) == true) goto L14;
        r5 = null;
    L14:
        if (r5 != null) goto L16;
        return null;
    L16:
        SearchPersonnelTypeInfo r1 = new SearchPersonnelTypeInfo();
        r1.setId(r0);
        r1.setTitle(r5);
        return r1;
    L19:
        return null;
    }

    public static final /* synthetic */ SearchPermissionGroupInfo access$toSearchInfo(ScenarioDataPuller r0, UserPermissionGroup r1) {
        return r0.toSearchInfo(r1);
    }

    private final String resolveI18nName(Map<String, String> r4, String r5) {
        String r0 = getCurrentLanguageKey();
        String r1 = null;
        if (r4 == null) goto L13;
        String r2 = r4.get(r0);
        if (r2 == null) goto L13;
        if ((!StringsKt.isBlank(r2)) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L13;
        return r2;
    L13:
        if (r4 == null) goto L19;
        String r6 = r4.get(NAME_KEY_EN_US);
        if (r6 == null) goto L19;
        if ((!StringsKt.isBlank(r6)) == false) goto L19;
        r1 = r6;
    L19:
        if (r1 != null) goto L23;
        if (r5 != null) goto L25;
        return "";
    L25:
        return r5;
    L23:
        return r1;
    }

    public static final /* synthetic */ SearchPersonnelTypeInfo access$toSearchInfo(ScenarioDataPuller r0, UserEmployeeType r1) {
        return r0.toSearchInfo(r1);
    }
}
