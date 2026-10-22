package com.larus.e_commerce.impl.settings;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.platform.service.z2;
import com.larus.setting.api.IOrderMessageNotifySettingsProvider;
import com.larus.setting.api.data.NotifySettingsItemId;
import com.larus.setting.api.data.NotifySettingsSectionId;
import com.larus.setting.api.data.SettingsItemAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import zs9.b;
import zs9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/e_commerce/impl/settings/OrderMessageNotifySettingsProviderImpl;", "Lcom/larus/setting/api/IOrderMessageNotifySettingsProvider;", "<init>", "()V", "getNotifySettingItems", "", "Lcom/larus/setting/api/data/SettingsSection;", "activity", "Landroidx/fragment/app/FragmentActivity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderMessageNotifySettingsProviderImpl implements IOrderMessageNotifySettingsProvider {
    public OrderMessageNotifySettingsProviderImpl() {
    }

    public final List<c> a(final FragmentActivity r5) {
        if (r5 == null) goto L9;
        if (z2.a.getECommerceSettingsConfig().getEnableOrderMessageNotificationSettings() == false) goto L9;
        final ISettingRepoService r0 = RepoDispatcherDelegate.b.c();
        c r1 = new c();
        r1.a = NotifySettingsSectionId.NOTIFY_TYPE.getValue();
        r1.b = r5.getString(2131909304);
        b r2 = new b();
        r2.a = NotifySettingsItemId.ORDER_MESSAGE.getValue();
        r2.b = r5.getString(2131908277);
        r2.g = SettingsItemAction.TOGGLE;
        r2.d = 2131241677;
        r2.e = Boolean.valueOf(r0.G0());
        r2.h = new a(r5, r0);
        r1.a(CollectionsKt.listOf(r2));
        return CollectionsKt.listOf(r1);
    L9:
        return CollectionsKt.emptyList();
    }
}
