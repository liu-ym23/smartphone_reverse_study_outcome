package r0c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements RxScheduledExecutor.Consumer<String> {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void consume(Object r6) {
        String r7 = (String) r6;
        this.a.c();
        if (TextUtils.isEmpty(r7) == false) goto L5;
        LKUIToast.show(this.a.a, 2131892141);
        boolean r8 = false;
    L14:
        k.b(this.a, r8);
        return;
    L5:
        Context r0 = this.a.a;
        Log.i("SavePhotoUrlAction", "notifySystemScanFile, filePath = " + r7 + ", shouldEncryptFile = true");
        VFSFiles.b.getClass();     // Catch: EncryptException -> L8
        CipherManager.c(VFSFiles.b(true).i(r7));     // Catch: EncryptException -> L8
        Log.i("SavePhotoUrlAction", "[cipher] file encrypt success, path = " + r7);     // Catch: EncryptException -> L8
    L9:
        FileUtils.v(r0, r7, new Token("LARK-PSDA-messenger_save_photo_url"));
        k r9 = this.a;
        q0c.a r1 = r9.k;
        if (r1 == null) goto L12;
        r1.y0();
    L13:
        r8 = true;
        goto L14
    L12:
        LKUIToast.show(r9.a, 2131247510, 2131892146);
    L8:
        Log.e("SavePhotoUrlAction", "[cipher] file encrypt failed, path = " + r7);
        goto L9
    }
}
