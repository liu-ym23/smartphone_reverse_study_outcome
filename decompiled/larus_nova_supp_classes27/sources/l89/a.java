package l89;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.impl.view.preview.DrivePreviewActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Fragment a() {
        AppCompatActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = r0;
    L7:
        if ((r1 instanceof DrivePreviewActivity) == false) goto L14;
        Fragment r2 = ((DrivePreviewActivity) r1).getSupportFragmentManager().findFragmentByTag("drive_preview_fragment");
        if (r2 == null) goto L15;
        FragmentManager r3 = r2.getChildFragmentManager();
        if (r3 != null) goto L13;
        return null;
    L13:
        return r3.findFragmentByTag("drive_preview_float_chat_fragment");
    L15:
        return null;
    L14:
        return null;
    L5:
        r1 = null;
        goto L7
    }
}
