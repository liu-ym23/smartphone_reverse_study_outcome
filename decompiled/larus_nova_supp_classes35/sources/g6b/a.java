package g6b;

import android.content.Context;
import android.util.Size;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.chat.preview.components.ChattersPreviewComponent$update$1$2;
import com.ss.android.lark.chat.preview.components.view.j;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.officesdk.integrator.im.b;
import com.ss.android.lark.officesdk.integrator.im.c;
import com.ss.android.lark.officesdk.integrator.im.d;
import com.ss.android.lark.officesdk.integrator.im.h;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static InterfaceC0223a a;

    /* JADX INFO: renamed from: g6b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0223a extends i6b.a {
        com.ss.android.lark.officesdk.integrator.im.a a();

        void b(Context r1, j r2, String r3, String r4, String r5, String r6, int r7, Image r8, boolean r9);

        c c();

        void clearAllUrlCache();

        void e();

        void f(List r1, ChattersPreviewComponent$update$1$2 r2);

        b getCoreDependency();

        h getFeatureGatingDependency();

        d getLoginDependency();

        long getNtpTime();

        void h(LKUIRoundedImageView2 r1, String r2, int r3, int r4, String r5, String r6, String r7, Size r8);

        void i();
    }

    static {
    }
}
