package n0c;

import com.ss.android.lark.permission.IGetPermissionCallback;
import com.ss.android.lark.permission.StoragePermissionUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class b implements StoragePermissionUtils.a {
    public final /* synthetic */ IGetPermissionCallback a;

    public /* synthetic */ b(IGetPermissionCallback r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
    public final void b(StoragePermissionUtils.c r2) {
        IGetPermissionCallback r0 = this.a;
        if (r2.d == false) goto L5;
        r0.onSuccess();
        return;
    L5:
        r0.onError();
    }
}
