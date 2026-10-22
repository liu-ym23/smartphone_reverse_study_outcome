package com.obric.assistant.oauto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J&\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J&\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J>\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&Ja\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u001bH&¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/oauto/IOAutoApi;", "", "isAssistantDisplayInOAuto", "", "isDisplayInOAuto", "task", "Landroid/app/TaskInfo;", "notifyAssistantTakeOver", "", "isOAutoVirtualDisplayIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "jumpToOAutoVirtualDisplay", "context", "Landroid/content/Context;", "catchError", "jumpToOAutoTaskList", "jumpToOAutoConditionEventDetailStarter", "jumpToOAutoCreateShortcut", "query", "", "messageId", "taskModelJson", "jumpToOAutoCreateShortcutForResult", "activity", "Landroid/app/Activity;", "onCreateResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", WindowEvent.WindowOpenPerfResult.SUCCESS, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOAutoApi {
    void a(Context r1, String r2, String r3, String r4);

    boolean b();

    boolean c(Intent r1);

    void d(Activity r1, String r2, String r3, String r4, com.obric.assistant.obric_action.handler.a r5);

    void e(Context r1, Intent r2);

    void f();

    boolean g(Context r1, Intent r2, boolean r3);

    void h(Context r1, boolean r2);
}
