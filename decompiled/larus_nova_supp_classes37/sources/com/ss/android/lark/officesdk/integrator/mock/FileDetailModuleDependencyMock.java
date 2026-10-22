package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.j0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.NetworkTypeListener;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;
import com.ss.android.lark.log.Log;
import java.util.List;
import ytb.f;
import ytb.g;
import ytb.h;
import ytb.i;
import ytb.j;
import ytb.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(hfb.b.class)
public class FileDetailModuleDependencyMock implements hfb.b {
    private static final String TAG = "FileDetailModuleDependencyMock";

    public class a implements hfb.b.l {
        public a() {
        }
    }

    public class b implements hfb.b.e {
        public b() {
        }
    }

    public class c implements hfb.b.f {
        public c() {
        }
    }

    public class d implements hfb.b.d {
        public final void a() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getMessagesByIds mocked");
        }

        public final void b() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getChatById mocked");
        }

        public final void c() {
            Log.w(FileDetailModuleDependencyMock.TAG, "sendMessage mocked");
        }

        public final void d() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getLocalMessage mocked");
        }

        public final void e() {
            Log.w(FileDetailModuleDependencyMock.TAG, "forwardFavoriteMessage mocked");
        }

        public final void f() {
            Log.w(FileDetailModuleDependencyMock.TAG, "openChat mocked");
        }

        public final void g() {
            Log.w(FileDetailModuleDependencyMock.TAG, "sendMessageWithRichText mocked");
        }

        public final void h() {
            Log.w(FileDetailModuleDependencyMock.TAG, "openThread mocked");
        }

        public final void i() {
            Log.w(FileDetailModuleDependencyMock.TAG, "forwardMessage mocked");
        }

        public d() {
        }
    }

    public class e implements hfb.b.b {
        public e() {
        }
    }

    public FileDetailModuleDependencyMock() {
    }

    public static /* synthetic */ void a(String r0, String r1, String r2, String r3, Message.SourceType r4, OpenFileInfo r5, UIGetDataCallback r6) {
        lambda$getDriveDependency$0(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void b(FileDetailLaunchParams r0) {
        lambda$getMailDependency$7(r0);
    }

    public static /* synthetic */ String c() {
        return lambda$getDynamicDomainDependency$1();
    }

    public static /* synthetic */ void d(List r0, UIGetDataCallback r1) {
        lambda$getFavoriteDependency$4(r0, r1);
    }

    public static /* synthetic */ boolean e() {
        return lambda$getFeatureConfigDependency$5();
    }

    public static /* synthetic */ void f(Context r0, String r1) {
        lambda$getSearchDependency$6(r0, r1);
    }

    public static /* synthetic */ void g(Context r0, String r1) {
        lambda$getBrowserDependency$3(r0, r1);
    }

    private static /* synthetic */ Activity lambda$getAppStateDependency$2() {
        Log.w(TAG, "getTopActivity mocked");
        return null;
    }

    private static /* synthetic */ String lambda$getDynamicDomainDependency$1() {
        Log.w(TAG, "getSecurityWebHost mocked");
        return null;
    }

    private static /* synthetic */ boolean lambda$getFeatureConfigDependency$5() {
        Log.w(TAG, "isFileDownloadEnable mocked");
        return true;
    }

    public hfb.b.a getAppStateDependency() {
        Log.w(TAG, "getAppStateDependency mocked");
        return new ytb.e();
    }

    public hfb.b.b getAuditDependency() {
        Log.w(TAG, "getAuditDependency mocked");
        return new e();
    }

    public hfb.b.c getBrowserDependency() {
        Log.w(TAG, "getBrowserDependency mocked");
        return new g();
    }

    public hfb.b.d getChatDependency() {
        Log.w(TAG, "getChatDependency mocked");
        return new d();
    }

    public Context getContext() {
        Log.w(TAG, "getContext mocked");
        return null;
    }

    public hfb.b.e getDownloadDependency() {
        Log.w(TAG, "getDownloadDependency mocked");
        return new b();
    }

    public hfb.b.f getDownloadFileMonitorDependency() {
        Log.w(TAG, "getDownloadFileMonitorDependency mocked");
        return new c();
    }

    public hfb.b.g getDriveDependency() {
        Log.w(TAG, "getDriveDependency mocked");
        return new j();
    }

    public hfb.b.h getDynamicDomainDependency() {
        Log.w(TAG, "getDynamicDomainDependency mocked");
        return new f();
    }

    public hfb.b.i getFavoriteDependency() {
        Log.w(TAG, "getFavoriteDependency mocked");
        return new ytb.d();
    }

    public hfb.b.j getFeatureConfigDependency() {
        Log.w(TAG, "getFeatureConfigDependency mocked");
        return new k();
    }

    public ForwardEnhancedView getForwardEnhancedView() {
        Log.w(TAG, "getForwardEnhancedView mocked");
        return null;
    }

    public hfb.b.k getMailDependency() {
        Log.w(TAG, "getMailDependency mocked");
        return new i();
    }

    public hfb.b.l getPushDependency() {
        Log.w(TAG, "getPushDependency mocked");
        return new a();
    }

    public hfb.b.m getSearchDependency() {
        Log.w(TAG, "getSearchDependency mocked");
        return new h();
    }

    public String getUserId() {
        Log.w(TAG, "getUserId mocked");
        return "";
    }

    public boolean isFeishuBrand() {
        Log.w(TAG, "isFeishuBrand mocked");
        return false;
    }

    private static /* synthetic */ void lambda$getMailDependency$7(FileDetailLaunchParams r1) {
        Log.w(TAG, "openEmlFile mocked");
    }

    public void addListenerToDriveSaveStateEventPush(j0 r2) {
        Log.w(TAG, "addListenerToDriveSaveStateEventPush mocked");
    }

    public void addListenerToNetworkTypeDispatcher(NetworkTypeListener r2) {
        Log.w(TAG, "addListenerToNetworkTypeDispatcher mocked");
    }

    public boolean isFeatureGatingCurrentEnable(String r2) {
        Log.w(TAG, "isFeatureGatingCurrentEnable mocked");
        return false;
    }

    public boolean isFeatureGatingEnable(String r2) {
        Log.w(TAG, "isFeatureGatingEnable mocked");
        return false;
    }

    public void removeListenerToDriveSaveStateEventPush(j0 r2) {
        Log.w(TAG, "removeListenerToDriveSaveStateEventPush mocked");
    }

    public void removeListenerToNetworkTypeDispatcher(NetworkTypeListener r2) {
        Log.w(TAG, "removeListenerToNetworkTypeDispatcher mocked");
    }

    public void showFullQuotoDialog(FragmentActivity r2) {
        Log.w(TAG, "showFullQuotoDialog mocked");
    }

    private static /* synthetic */ void lambda$getBrowserDependency$3(Context r0, String r1) {
        Log.w(TAG, "openUrl mocked");
    }

    private static /* synthetic */ void lambda$getFavoriteDependency$4(List r0, IGetDataCallback r1) {
        Log.w(TAG, "putFavoriteItems mocked");
    }

    private static /* synthetic */ void lambda$getSearchDependency$6(Context r0, String r1) {
        Log.w(TAG, "goToSearch mocked");
    }

    public void execPreviewAction(String r1, String r2) {
        Log.w(TAG, "execPreviewAction mocked");
    }

    private static /* synthetic */ void lambda$getDriveDependency$0(String r0, String r1, String r2, String r3, Message.SourceType r4, OpenFileInfo r5, IGetDataCallback r6) {
        Log.w(TAG, "saveToNutStore mocked");
    }
}
