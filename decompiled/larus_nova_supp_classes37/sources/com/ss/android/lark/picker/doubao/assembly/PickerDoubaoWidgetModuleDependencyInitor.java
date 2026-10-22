package com.ss.android.lark.picker.doubao.assembly;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import z3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(PickerWidgetModuleDependency.IPickerWidgetModuleDependency.class)
public class PickerDoubaoWidgetModuleDependencyInitor implements PickerWidgetModuleDependency.IPickerWidgetModuleDependency {
    public PickerDoubaoWidgetModuleDependencyInitor() {
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public String getSelfId() {
        return "";
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public String getTenantID() {
        return "";
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public void goContactsGroupActivity(Activity r1) {
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public boolean isCustomer() {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public boolean isInZenMode(long r1) {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.ICalendarController getCalendarController() {
        return new AnonymousClass7(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactHomeController getContactHomeController() {
        return new AnonymousClass2(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController getContactsOwnerGroupController() {
        return new AnonymousClass6(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController getContactsSelectorController() {
        return new AnonymousClass4(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController getDepartmentDetailController() {
        return new AnonymousClass5(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IEmailContactController getEmailContactController() {
        return new AnonymousClass3(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public a getSearchLifecycleObserver() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IUserGroupController getUserGroupController() {
        return new AnonymousClass8(this);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public Map getChatsByIds(List<String> r1) {
        return new HashMap();
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency
    public void loadImage(Context r2, String r3, String r4, ImageView r5, int r6, int r7) {
        LoadParams r0 = new LoadParams();
        r0.a = UIHelper.dp2px(r6);
        r0.b = UIHelper.dp2px(r7);
        ImageModule.a(r2, r5, r3, r4, r0);
    }
}
