package com.ss.android.lark.integrator.todo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.todo.v1.ContainerSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chat.entity.message.content.TodoContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoSceneType;
import com.ss.android.lark.todo.impl.features.center.v3.sidebar.TodoSidebarFragment;
import com.ss.android.lark.todo.impl.features.detail.assignee.display.AssigneeBaseMeta;
import com.ss.android.lark.todo.impl.features.detail.create.CreateTodoDocxParams;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import com.ss.android.lark.todo_api.ITodoApi;
import e7c.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;
import ova.d;
import ova.f;
import pva.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(ITodoApi.class)
@Singleton
public class TodoApiImpl implements ITodoApi {
    private static final String TAG = "TodoApiImpl";

    public class a implements b {
        public final Map<String, d> a(Context r1) {
            return TodoModuleProvider.a().g();
        }
    }

    @Inject
    public TodoApiImpl() {
    }

    public void bindViewWithShareTodoMsg(TextView r1, TextView r2, ImageView r3, TodoContent r4) {
    }

    public String getFormatTodoTaskViewInChatText(String r1) {
        return "";
    }

    public String getOpenTodoFromNoticeKey() {
        return "enter_todo_tab_from_offline_push";
    }

    public boolean isTodoTabEnable() {
        return true;
    }

    public String getTodoPageName() {
        return TodoModuleProvider.a().getPageName();
    }

    public boolean isTodoFlutterEnable() {
        return TodoDependencyHolder.b().a();
    }

    public Map<String, String> getAutoInitModuleConfigMap() {
        return xrb.a.a;
    }

    public Map<String, String> getThirdPartyModuleConfigMap() {
        return xrb.a.b;
    }

    public Map<String, String> getThirdPartyPrefixModuleConfigMap() {
        return xrb.a.c;
    }

    public Fragment getTodoDrawerFragment(wqb.a r1) {
        return new TodoSidebarFragment();
    }

    public Intent getTodoIntentForWsChannelOfflinePush(String r2) {
        return TodoModuleProvider.a().d(r2);
    }

    public void initProcessorDoInit(String r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.equals("com.ss.android.lark.integrator.todo.wrapper.TodoModuleWrapper") == false) goto L10;
        c r3 = (c) TodoModuleProvider.a.getValue();
        return;
    }

    public boolean isTaskListUrl(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        Uri r5 = UriProtector.parse(r4);
        if (r5 != null) goto L8;
        return false;
    L8:
        f.m().getClass();
        if (f.q(r5) == true) goto L12;
        return false;
    L12:
        if (r5.getPath().equalsIgnoreCase("/client/todo/task_list") == true) goto L15;
        return false;
    L15:
        return !TextUtils.isEmpty(UriProtector.getQueryParameter(r5, "guid"));
    }

    public void onTodoDrawerClose(Fragment r2) {
        if ((r2 instanceof TodoSidebarFragment) == false) goto L8;
        TodoSidebarFragment r3 = (TodoSidebarFragment) r2;
        if (r3.isActive() == false) goto L9;
        r3.ba0().onDrawerClose();
        return;
    L9:
        return;
    }

    public void onTodoDrawerWillShow(Fragment r3) {
        if ((r3 instanceof TodoSidebarFragment) == false) goto L8;
        TodoSidebarFragment r4 = (TodoSidebarFragment) r3;
        r4.getClass();
        int r0 = a9c.a.a;
        a9c.a.c("todo_mobile_container_menu_view", new JSONObject());
        if (r4.isActive() == false) goto L9;
        r4.ba0().onDrawerWillShow();
        return;
    L9:
        return;
    }

    public void startTodoSettingActivity(Activity r2) {
        TodoModuleProvider.a().startTodoSettingActivity(r2);
    }

    public void goCreateTaskActivityWithData(Context r12, Todo r13) {
        com.ss.android.lark.todo.impl.features.detail.a.a(r12, null, new SimpleSubTodoData(r13), "", "", false, "", TodoSceneType.INTERFACE, false, "", -1);
    }

    public void packageLaunchTodoTransPageIntent(Bundle r3, String r4) {
        r3.putBoolean("enter_todo_tab_from_offline_push", true);
        r3.putString("key_offline_push_todo_data", r4);
    }

    public void packageTodoOfflinePushNotice(Bundle r3, String r4) {
        r3.putBoolean("enter_todo_tab_from_offline_push", true);
        r3.putString("key_offline_push_todo_data", r4);
    }

    public void showTodoGuideDialog(Context r1, String r2) {
        TodoModuleProvider.a().c(r1);
    }

    public void startTodoAddAssigneeActivity(Fragment r2, int r3) {
        TodoModuleProvider.a().h(r2, r3);
    }

    public void startTodoCreateActivity(Fragment r8, String r9, int r10) {
        Log.i(TAG, "startTodoCreateActivity");
        JSONObject r2 = new JSONObject(r9);     // Catch: Exception -> L14
        String r11 = r2.optJSONObject(IOfflineExtraParser.ParserType.TODO).optJSONArray("relatedTaskListGuids").optString(0);     // Catch: Exception -> L14
        JSONArray r3 = r2.optJSONArray("taskListSections");     // Catch: Exception -> L14
        int r4 = 0;
    L5:
        if (r4 >= r3.length()) goto L11;
        JSONObject r5 = r3.optJSONObject(0);     // Catch: Exception -> L14
        if (TextUtils.equals(r5.optString("containerGuid"), r11) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        String r6 = r5.optString("sectionGuid");     // Catch: Exception -> L14
        String r7 = r5.optString("rank");     // Catch: Exception -> L14
    L12:
        CreateTodoDocxParams r12 = new CreateTodoDocxParams();     // Catch: Exception -> L14
        r12.setTaskListSection(new ContainerSection.Builder().container_guid(r11).section_guid(r6).rank(r7).build());     // Catch: Exception -> L14
        TodoModuleProvider.a().a(r8, r12, r10);     // Catch: Exception -> L14
        return;
    L11:
        r6 = "";
        r7 = "";
    L14:
        e = move-exception;
        TodoModuleProvider.a().a(r8, null, r10);
        Log.w(TAG, "startTodoCreateActivity", e);
    }

    public void startTodoDisplayAssigneeActivity(Fragment r10, String r11, int r12) {
        com.alibaba.fastjson.JSONObject r13 = JSON.parseObject(r11);     // Catch: Exception -> L11
        boolean r0 = r13.getBooleanValue("editable");     // Catch: Exception -> L11
        int r2 = 0;
        if (r13.getBooleanValue("enableMultiAssignee") == false) goto L9;
        com.alibaba.fastjson.JSONArray r14 = r13.getJSONArray("users");     // Catch: Exception -> L11
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L11
    L6:
        if (r2 >= r14.size()) goto L8;
        com.alibaba.fastjson.JSONObject r3 = r14.getJSONObject(r2);     // Catch: Exception -> L11
        r1.add(new AssigneeBaseMeta(r3.getString("id"), r3.getString("name"), r3.getLongValue("completedMilliTime")));     // Catch: Exception -> L11
        r2 = r2 + 1;     // Catch: Exception -> L11
        goto L6
    L8:
        TodoModuleProvider.a().b(r10, r1, r0, r12);     // Catch: Exception -> L11
        return;
    L9:
        List r15 = Arrays.asList((String[]) r13.getJSONArray("userIds").toArray(new String[0]));     // Catch: Exception -> L11
        TodoModuleProvider.a().f(r10, r15, r0, r12);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "startTodoDisplayAssigneeActivity", e);
    }

    public View getSendToChatView(Context r2, Drawable r3, String r4, View.OnClickListener r5) {
        return TodoModuleProvider.a().getSendToChatView(r2, r3, r4, r5);
    }
}
