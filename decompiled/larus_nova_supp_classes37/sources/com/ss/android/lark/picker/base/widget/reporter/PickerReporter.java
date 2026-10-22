package com.ss.android.lark.picker.base.widget.reporter;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.EmailContact;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.reporter.SafeReporter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\f\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\f\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0010J\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporter;", "", "<init>", "()V", "TAG", "", "removeReporter", "", "scene", "profileClickReporter", "viewReporter", "eventName", "selectReporter", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "isSelected", "", "position", "", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "departmentId", "selectUserGroupReporter", "userGroupId", "contact", "Lcom/ss/android/lark/contact/export/EmailContact;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "navigate", "isCollaboration", "navigateToNext", "putEntityId", "entityId", "json", "Lorg/json/JSONObject;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerReporter {
    public static final PickerReporter INSTANCE = null;
    private static final String TAG = "LarkSearch.SearchWidget.PickerReporter";

    static {
        INSTANCE = new PickerReporter();
    }

    private PickerReporter() {
    }

    public final void navigate(boolean r6) {
        SafeReporter r0 = SafeReporter.INSTANCE;
        if (r6 == false) goto L5;
        String r1 = "public_picker_select_associated_organizations_click";
    L6:
        JSONObject r2 = new JSONObject();
        r2.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.NAVIGATION_BAR);
        if (r6 == false) goto L9;
        String r7 = "public_picker_select_associated_organizations_view";
    L10:
        r2.put(PickerReporterConstants.KEY.TARGET, r7);
        Unit r8 = Unit.INSTANCE;
        r0.safeSendEvent(r1, r2);
        return;
    L9:
        r7 = "public_picker_select_architecture_member_view";
        goto L10
    L5:
        r1 = "public_picker_select_architecture_member_click";
        goto L6
    }

    public final void navigateToNext(boolean r6) {
        SafeReporter r0 = SafeReporter.INSTANCE;
        if (r6 == false) goto L5;
        String r1 = "public_picker_select_associated_organizations_click";
    L6:
        JSONObject r2 = new JSONObject();
        r2.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.NEXT_DEPARTMENT_LEVEL);
        if (r6 == false) goto L9;
        String r7 = "public_picker_select_associated_organizations_view";
    L10:
        r2.put(PickerReporterConstants.KEY.TARGET, r7);
        Unit r8 = Unit.INSTANCE;
        r0.safeSendEvent(r1, r2);
        return;
    L9:
        r7 = "public_picker_select_architecture_member_view";
        goto L10
    L5:
        r1 = "public_picker_select_architecture_member_click";
        goto L6
    }

    public final void profileClickReporter(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        SafeReporter r1 = SafeReporter.INSTANCE;
        JSONObject r2 = new JSONObject();
        r2.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.PROFILE);
        r2.put(PickerReporterConstants.KEY.TARGET, "profile_main_view");
        r2.put("scene", r6);
        Unit r7 = Unit.INSTANCE;
        r1.safeSendEvent("public_picker_select_click", r2);
    }

    public final void removeReporter(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        SafeReporter r1 = SafeReporter.INSTANCE;
        JSONObject r2 = new JSONObject();
        r2.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        r2.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_view");
        r2.put("scene", r6);
        Unit r7 = Unit.INSTANCE;
        r1.safeSendEvent("public_picker_select_click", r2);
    }

    public final void viewReporter(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        SafeReporter.INSTANCE.safeSendEvent(r3, new JSONObject());
    }

    private final void putEntityId(String r2, JSONObject r3) {
        r3.put(PickerReporterConstants.KEY.ENTITY_ID, y.b(r2));
    }

    public final void selectReporter(Chatter r9, boolean r10, int r11) {
        Log.d(TAG, "position: " + r11 + ", isSelected: " + r10 + " position: " + r11);
        int r12 = r11 + 1;
        if (r9 == null) goto L25;
        if (r12 > 0) goto L6;
        return;
    L6:
        if (r9.isCollaboration() == false) goto L13;
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r7 = new JSONObject();
        if (r10 == false) goto L10;
        r7.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r7.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.member());
        r7.put("list_number", r12);
    L11:
        r7.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_associated_organizations_view");
        INSTANCE.putEntityId(r9.getId(), r7);
        Unit r13 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_associated_organizations_click", r7);
        return;
    L10:
        r7.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L11
    L13:
        if (r9.isCrossTenant() == false) goto L19;
        SafeReporter r1 = SafeReporter.INSTANCE;
        JSONObject r8 = new JSONObject();
        if (r10 == false) goto L17;
        r8.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r8.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.member());
        r8.put("list_number", r12);
    L18:
        r8.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_external_view");
        INSTANCE.putEntityId(r9.getId(), r8);
        Unit r14 = Unit.INSTANCE;
        r1.safeSendEvent("public_picker_select_external_click", r8);
        return;
    L17:
        r8.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L18
    L19:
        SafeReporter r2 = SafeReporter.INSTANCE;
        JSONObject r15 = new JSONObject();
        if (r10 == false) goto L22;
        r15.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r15.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.member());
        r15.put("list_number", r12);
    L23:
        r15.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_architecture_member_view");
        INSTANCE.putEntityId(r9.getId(), r15);
        Unit r16 = Unit.INSTANCE;
        r2.safeSendEvent("public_picker_select_architecture_member_click", r15);
        return;
    L22:
        r15.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L23
    }

    public final void selectUserGroupReporter(String r4, boolean r5, int r6) {
        if (r4 != null) goto L5;
        Log.e(TAG, "Picker reporter: userGroupId is null");
        return;
    L5:
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r1 = new JSONObject();
        if (r5 == false) goto L8;
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r1.put("list_number", r6 + 1);
    L9:
        r1.put(PickerReporterConstants.KEY.TARGET, "none");
        INSTANCE.putEntityId(r4, r1);
        Unit r7 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_user_group_click", r1);
        return;
    L8:
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L9
    }

    public final void selectReporter(SearchBaseInfo r4, boolean r5, int r6) {
        if (r4 != null) goto L5;
        Log.e(TAG, "Picker reporter: searchBaseInfo is null");
        return;
    L5:
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r1 = new JSONObject();
        if (r5 == false) goto L8;
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r1.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.toType(r4));
        r1.put("list_number", r6 + 1);
    L9:
        r1.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_search_member_view");
        INSTANCE.putEntityId(r4.getId(), r1);
        Unit r7 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_search_member_click", r1);
        return;
    L8:
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L9
    }

    public final void selectReporter(EmailContact r4, boolean r5, int r6) {
        if (r4 != null) goto L5;
        Log.e(TAG, "Picker reporter: emailContact is null");
        return;
    L5:
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r1 = new JSONObject();
        if (r5 == false) goto L8;
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r1.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.mailMember());
        r1.put("list_number", r6 + 1);
    L9:
        r1.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_email_member_view");
        INSTANCE.putEntityId(r4.a, r1);
        Unit r7 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_email_member_click", r1);
        return;
    L8:
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L9
    }

    public final void selectReporter(String r4, boolean r5, int r6) {
        if (r4 != null) goto L5;
        Log.e(TAG, "Picker reporter: departmentId is null");
        return;
    L5:
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r1 = new JSONObject();
        if (r5 == false) goto L8;
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r1.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.department());
        r1.put("list_number", r6 + 1);
    L9:
        r1.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_architecture_member_view");
        INSTANCE.putEntityId(r4, r1);
        Unit r7 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_architecture_member_click", r1);
        return;
    L8:
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L9
    }

    public final void selectReporter(Chat r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "chat");
        SafeReporter r0 = SafeReporter.INSTANCE;
        JSONObject r1 = new JSONObject();
        if (r5 == false) goto L5;
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.SELECT);
        r1.put(PickerReporterConstants.KEY.TYPE, PickerReporterConstants.VALUE.TYPE.INSTANCE.group());
        r1.put("list_number", r6 + 1);
    L6:
        r1.put(PickerReporterConstants.KEY.TARGET, "public_picker_select_manage_group_view");
        INSTANCE.putEntityId(r4.getId(), r1);
        Unit r7 = Unit.INSTANCE;
        r0.safeSendEvent("public_picker_select_manage_group_click", r1);
        return;
    L5:
        r1.put(PickerReporterConstants.KEY.CLICK, PickerReporterConstants.VALUE.CLICK.REMOVE);
        goto L6
    }
}
