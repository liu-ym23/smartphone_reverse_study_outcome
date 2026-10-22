package r0c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements RxScheduledExecutor.Producer<String> {
    public final /* synthetic */ String a;
    public final /* synthetic */ k b;

    public final Object produce() {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
    L13:
        Log.e("SavePhotoUrlAction", "Path not exists, path = " + this.a);
    L14:
        return "";
    L5:
        if (FileUtils.r(this.a) == false) goto L13;
        VFSFiles r0 = VFSFiles.b;
        q0c.b r2 = p0c.a.a();
        Objects.requireNonNull(r2);
        VFSFile r1 = r0.i(r2.getWatermarkResource("IM_CLASS_SAVE_PHOTO_URL_ACTION_EDIT_FINISH_MENU", this.a));
        String r5 = System.currentTimeMillis() + "." + FileUtils.k(this.a);
        Context r4 = this.b.a;
        Token r8 = new Token("LARK-PSDA-android_photo_editor_save_to_gallery");
        Set r3 = MediaStoreUtil.a;
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        Uri r6 = MediaStoreUtil.f(r4, r5, null, null, r8, 28);
        if (r6 == null) goto L12;
        MediaStoreUtil.c(r1, r6, this.b.a);
        PolarisFileWrapper r7 = m0.b(this.b.a, r6, false);
        if (r7 == null) goto L12;
        return r7.getAbsolutePath();
    L12:
        Log.e("SavePhotoUrlAction", "Failed to get target file path");
        goto L14
    }

    public l(k r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
