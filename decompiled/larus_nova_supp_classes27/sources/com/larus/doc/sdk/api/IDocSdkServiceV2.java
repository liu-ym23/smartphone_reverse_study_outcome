package com.larus.doc.sdk.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.container.f;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.larus.office.h;
import fo9.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import n39.e;
import n39.m;
import n39.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0005H&Ja\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H&¢\u0006\u0002\u0010(Jd\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H¦@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&J\u001c\u0010/\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&Jt\u00100\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u00052*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000307H&J\b\u0010:\u001a\u00020\u0003H&JF\u0010;\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00030<H&J\b\u0010=\u001a\u00020\u0005H&J3\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u0001092\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\b\u0002\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0005H&J\u0010\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0019H&J\u0012\u0010H\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010IH&¨\u0006J"}, d2 = {"Lcom/larus/doc/sdk/api/IDocSdkServiceV2;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "deleteDoc", "", "objToken", "", "callback", "Lcom/larus/doc/sdk/api/IDeleteDocCallback;", "getShareLinkUrl", "resId", "getPermissionService", "Lcom/larus/doc/sdk/api/IDocPermissionService;", "getPhotoPickerService", "Lcom/larus/doc/sdk/api/IPhotoPickerService;", "onToolbarChanged", "toolbar", "Lcom/bytedance/ee/bear/document/model/toolbar/ToolbarV2;", "onToolbarItemClicked", "name", "onContextMenuShow", "notifyChatInputFoldStatusChanged", "isFold", "", "docLogicKey", "getDocFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "url", "content", "clickTimestamp", "", "param", "Lcom/larus/office/OfficeInputParam;", "permissionListener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;)Landroidx/fragment/app/Fragment;", "openAndGetDocFragment", "messageId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initDocSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "startDocExport", "fileName", "fileType", "type", "token", "eventSource", "passback", "Lkotlin/Function4;", "Landroid/net/Uri;", "", "cancelDocExport", "startDownloadAudioFile", "Lkotlin/Function3;", "getChameleonResVersion", "startDocSnapshot", "inputViewHeight", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Ljava/lang/String;)V", "isDoubaoDoc", "onBackPressed", "fragment", "setToolbarTraceListener", "Lcom/larus/doc/sdk/api/IToolbarTraceListener;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocSdkServiceV2 extends ISdkLifecycleV2 {
    void cancelDocExport();

    void deleteDoc(String r1, e r2);

    Fragment getDocFragment(Context r1, String r2, String r3, Long r4, OfficeInputParam r5, b r6, h r7, f r8);

    IDocPermissionService getPermissionService();

    m getPhotoPickerService();

    String getShareLinkUrl(String r1);

    Object initDocSdkIfNeeded(Continuation<? super Unit> r1);

    void notifyChatInputFoldStatusChanged(boolean r1, String r2);

    boolean onBackPressed(Fragment r1);

    void onContextMenuShow(String r1);

    void onToolbarChanged(ToolbarV2 r1);

    void onToolbarItemClicked(String r1);

    Object openAndGetDocFragment(Context r1, String r2, String r3, String r4, Long r5, OfficeInputParam r6, b r7, f r8, Continuation<? super Fragment> r9);

    void preloadDocumentData(String r1, OfficeInputParam r2);

    void setToolbarTraceListener(p r1);

    void startDocExport(Context r1, String r2, String r3, String r4, String r5, String r6, String r7, Function4<? super Boolean, ? super Uri, ? super Integer, ? super String, Unit> r8);

    void startDocSnapshot(Integer r1, Drawable r2, n39.h r3, String r4);

    void startDownloadAudioFile(Context r1, String r2, String r3, Function3<? super Boolean, ? super Uri, ? super String, Unit> r4);

    boolean tryPrefetchData(String r1, OfficeInputParam r2);
}
