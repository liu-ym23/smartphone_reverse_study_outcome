package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.BrowseFolderRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.LarkKVStorage;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileListModel extends BaseModel implements i {
    public final FolderManageLaunchParams a;
    public final long b;
    public final Lazy c;
    public final ConcurrentHashMap<String, nfb.c> d;
    public long e;
    public boolean f;
    public String g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final int M() {
        ofb.b r0 = ofb.b.a;
        Intrinsics.checkNotNullParameter((String) this.c.getValue(), "userId");
        return LarkKVStorage.q(FileDetailModule.a, true).getInt("params_folder_manage_layout_type", 0);
    }

    public final void destroy() {
        this.d.clear();
        super.destroy();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final long t3() {
        nfb.c r0 = this.d.get(this.g);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b;
    }

    public final void create() {
        super.create();
        this.a.getClass();
        this.g = this.a.g;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final boolean w2() {
        return this.f;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final void U(int r4) {
        if (((String) this.c.getValue()).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ofb.b r1 = ofb.b.a;
        Intrinsics.checkNotNullParameter((String) this.c.getValue(), "userId");
        LarkKVStorage.q(FileDetailModule.a, true).putInt("params_folder_manage_layout_type", r4);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final boolean l7(nfb.a r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        if (this.d.get(r3.a) == null) goto L13;
        nfb.c r4 = this.d.get(r3.a);
        if (r4 == null) goto L9;
        List<nfb.a> r5 = r4.a;
        if (r5 == null) goto L9;
        boolean r6 = !r5.isEmpty();
    L10:
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r6 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final void m6(UIGetDataCallback r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r2 = this.g;
        FolderManageLaunchParams r0 = this.a;
        k(r2, r0.s, r0.t, this.e, 20, r11);
    }

    public FileListModel(FolderManageLaunchParams r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "launchParams");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(FileListModel$userId$2.INSTANCE);
        this.d = new ConcurrentHashMap();
        this.g = BuildConfig.FLAVOR;
    }

    public final void h(String r4, UIGetDataCallback r5) {
        nfb.c r0 = this.d.get(r4);
        if (r0 == null) goto L14;
        List<nfb.a> r1 = r0.a;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        this.e = r0.a.size();
        this.f = r0.c;
        Log.i("FileListModel", "folderKey = " + r4 + ", size = " + r0.a.size());
        r5.onSuccess(r0.a);
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L14:
        r5.onError(new ErrorResult("get data from memory wrong: response = null"));
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final void v7(String r3, nfb.c r4, UIGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "folderKey");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.g = r3;
        if (r4 != null) goto L6;
        r5.onError(new ErrorResult("push response is null"));
        return;
    L6:
        Log.i("FileListModel", "folder key is " + r3 + ", size = " + r4.a.size());
        this.d.put(r3, r4);
        h(r3, r5);
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i
    public final void I2(String r12, String r13, String r14, UIGetDataCallback r15) {
        Intrinsics.checkNotNullParameter(r12, "folderKey");
        Intrinsics.checkNotNullParameter(r15, "callback");
        boolean r0 = TextUtils.equals(this.g, r12);
        boolean r1 = false;
        if (r0 == true) goto L5;
        this.g = r12;
        this.e = 0;
        this.f = false;
    L5:
        if (r0 == false) goto L7;
    L20:
        k(r12, r13, r14, this.e, this.b, r15);
        return;
    L7:
        if (this.d.get(r12) == null) goto L20;
        nfb.c r2 = this.d.get(r12);
        if (r2 == null) goto L11;
        List<nfb.a> r3 = r2.a;
    L12:
        List<nfb.a> r4 = r3;
        if (r4 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == true) goto L20;
        h(r12, r15);
        return;
    L15:
        if (r4.isEmpty() == false) goto L17;
    L11:
        r3 = null;
        goto L12
    }

    public final void k(final String r17, String r18, String r19, final long r20, long r22, final UIGetDataCallback r24) {
        if (r17.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r24.onError(new ErrorResult("folder key is null"));
        return;
    L9:
        nfb.b.a r1 = new nfb.b.a();
        Intrinsics.checkNotNullParameter(r17, "key");
        r1.a = r20;
        FolderManageLaunchParams r3 = this.a;
        int r11 = r3.f;
        String r12 = r3.u;
        nfb.b r10 = new nfb.b(r17, r20, r22, r1.b, r1.c, r11, r18, r12, r19);
        IGetDataCallback<nfb.c> r2 = new FileListModel$loadMoreFileListFromNet$secondCallback$1(r17, this, r20, r24);
        ofb.b r4 = ofb.b.a;
        IGetDataCallback r5 = getCallbackManager().wrapAndAddCallback(r2);
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        BrowseFolderRequest.Builder r6 = ofb.b.a(r10);
        SdkSender.asynSendRequestNonWrap(Command.BROWSE_FOLDER, r6, r5, new ofb.a(r10));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
