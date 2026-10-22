package ifb;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.page.FolderManageActivity;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Context r2, FolderManageLaunchParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Log.i("FolderManageLauncher", "enter FolderManageActivity page");
        Intent r0 = new Intent(r2, FolderManageActivity.class);
        r0.putExtra("extra.launch.params", r3);
        r2.startActivity(r0);
    }
}
