package gp8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.larus.camera.impl.ui.viewmodel.d;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.h1;
import com.larus.platform.api.h2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements h2 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void b(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final JSONObject c() {
        return null;
    }

    public final h1 d() {
        return null;
    }

    public final boolean e() {
        return false;
    }

    public final boolean f() {
        return false;
    }

    public final LiveData<Message> g() {
        return null;
    }

    public final JSONObject h() {
        return null;
    }

    public final void i() {
    }

    public final Integer j() {
        return null;
    }

    public final boolean k() {
        return false;
    }

    public final int l() {
        return 0;
    }

    public final boolean m() {
        return false;
    }

    public final boolean o() {
        return false;
    }

    public final void q(String r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "schema");
    }

    public final boolean n(Context r2, UserCreation r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userCreation");
        return false;
    }

    public final void p(final Context r1, String r2, final String r3, String r4, Message r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        AlertDialog.Builder r6 = new AlertDialog.Builder(r1);
        r6.setTitle(r2);
        r6.setMessage(r3);
        r6.setPositiveButton("复制", new a(r1, r3));
        r6.show();
    }
}
