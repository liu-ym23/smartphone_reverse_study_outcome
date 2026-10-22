package e89;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.impl.DriveSdkServiceImpl;
import com.larus.drive.sdk.impl.utils.t;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c {
    String a(DriveFileItem r1, Context r2, DriveDownloadPriority r3, t79.a r4);

    Object b(String r1, int r2, boolean r3, Continuation<? super DriveFileItem> r4);

    boolean c(String r1);

    MutableLiveData d(String r1);

    nc5.b e(List r1, DriveSdkServiceImpl.k r2);

    void f(DriveFileItem r1, Context r2);

    boolean g(List<String> r1);

    nc5.b h(String r1, int r2, boolean r3, v79.b<Boolean> r4);

    Object i(String r1, int r2, String r3, Continuation<? super Integer> r4);

    nc5.b j(DriveFileItem r1, String r2, t.a r3);

    void k(DriveFileItem r1, kw9.d r2);

    void l(u79.a r1);

    nc5.b m(List<DriveFileItem> r1, v79.a r2);

    Object n(String r1, int r2, Continuation<? super Boolean> r3);

    void o(String r1, int r2, Dialog r3);

    nc5.b p(String r1, int r2, v79.b<Boolean> r3);

    void q(String r1, int r2);
}
